package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend

import java.util

import com.ibm.stringoid.retrieve.ir._
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.IntraProcASBOModule
import com.ibm.wala.dataflow.graph.AbstractMeetOperator
import com.ibm.wala.fixpoint.FixedPointConstants._
import com.ibm.wala.fixpoint.UnaryOperator
import com.ibm.wala.ipa.cfg.ExceptionPrunedCFG
import com.ibm.wala.ssa.analysis.{ExplodedControlFlowGraph, IExplodedBasicBlock}
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAArrayStoreInstruction, SSAPhiInstruction}
import com.ibm.wala.util.graph.traverse.SCCIterator
import seqset.regular.Automaton

import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer
import scala.collection.{breakOut, mutable}

trait IntraProcStringAppendModule extends StringAppendModule with IntraProcASBOModule {

  /**
    * Get the string concatenation results.
    */
  def stringAppends(node: Node): StringPartAutomaton = {
    val solver  = getAppendSolver(node, idToAsboForNode(node))
    val result  = solver.result
    val mapping = solver.ataRefMapping
    val ataRefs: Set[Int] = (solver.getCfg map {
      result.getOut(_).index
    })(breakOut)
    // merging concatenations
    val concats = ataRefs.foldLeft(Automaton.empty[StringPart]) {
      (automaton, ref) =>
        val automata = mapping(ref).asboToAutomaton.values
        automaton | mergeAutomata(automata)
    }
    // adding constants
    solver.initialMapping.foldLeft(concats) {
      (automaton, asboToAutomaton) =>
        val automata = asboToAutomaton.asboToAutomaton.values
        automaton | mergeAutomata(automata)
    }
  }

  def getAppendSolver(node: Node, vnToAsbo: Map[Identifier, Set[ASBO]]) =
    new IntraProcStringAppendSolver(node, vnToAsbo)

  class IntraProcStringAppendSolver(
    node: Node,
    idToAsbo: Map[Identifier, Set[ASBO]]
  ) extends StringAppendFixedPointSolver(idToAsbo) {

    override type BB = IExplodedBasicBlock

    lazy val initialMapping = initialAtaRefMapping(node)

    override lazy val cfg = getCfg

    def getCfg = ExceptionPrunedCFG.make(ExplodedControlFlowGraph.make(node.getIr))

    override protected def transferFunctions: StringAppendTransferFunctions = new IntraProcStringAppendTransferFunctions

    class IntraProcStringAppendTransferFunctions extends StringAppendTransferFunctions {

      override def getNodeTransferFunction(bb: BB): UnaryOperator[AtaReference] =
        bb.getInstruction match {
          case instr: SSAAbstractInvokeInstruction if isSbAppend(instr)                =>
            idToAsbo get getFirstSbAppendDef(instr) match {
              case Some(asbos) =>
                new StringBuilderAppendOperator(asbos, getAppendArgument(instr))
              case None =>
                // todo note that this means that we are appending to a StringBuilder for which we haven't added an ASBO to the idToAsbo map.
                // todo I think this means that the StringBuilder has been passed as a parameter or is a field. We should handle this case too at some point.
                IdentityOperator()
            }
          case inv: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(inv) =>
            idToAsbo get getSbConstructorDef(inv) match {
              case Some(asbos) =>
                val appendArgument = getSbConstructorArgument(inv)
                new StringBuilderAppendOperator(asbos, appendArgument)
              case None =>
                throw new UnsupportedOperationException(MISSING_STRING_BUILDER_MESSAGE)
            }
          case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)                 =>
            new StringFormatAppendOperator(inv, node)
          case _                                                                =>
            IdentityOperator()
        }

      private[this] def getAppendAutomaton(
        id: Identifier,
        rhsMap: AsboMap,
        processedAcc: Set[Identifier]
      ): (StringPartAutomaton, AsboMap) =
        if (processedAcc contains id)
          (singleAutomaton(StringCycle), mutable.Map.empty[ASBO, StringPartAutomaton])
        else
          idToAsbo get id match {
            case Some(asbos) =>
              val automata = for {
                asbo      <- asbos
                automaton <- rhsMap get asbo
              } yield automaton
              val newValNumAutomaton = if (automata.isEmpty)
                singleAutomaton(StringIdentifier(id))
              else
                mergeAutomata(automata)
              (newValNumAutomaton, mutable.Map.empty[ASBO, StringPartAutomaton])
            case None         =>
              node.getDu.getDef(id) match {
                case phi: SSAPhiInstruction =>
                  val uses = 0 until phi.getNumberOfUses map phi.getUse
                  val (automata, asboMaps) = (uses map {
                    u =>
                      getAppendAutomaton(u, rhsMap, processedAcc + id)
                  }).unzip
                  val mergedAutomaton = mergeAutomata(automata)
                  val mergedMap = (asboMaps reduceLeft {
                    _ ++ _
                  }) + (createAsbo(phi.getDef, node) -> mergedAutomaton)
                  (mergedAutomaton, mergedMap)
                case _                      =>
                  (singleAutomaton(StringIdentifier(id)), mutable.Map.empty[ASBO, StringPartAutomaton])
              }
          }

      def getAppendAutomaton(vn: Identifier, rhsMap: AsboMap): (StringPartAutomaton, AsboMap) =
        getAppendAutomaton(vn, rhsMap, Set.empty[Identifier])

      protected case class StringFormatAppendOperator(
        instr: SSAAbstractInvokeInstruction,
        node: Node
      )
        extends AbstractAppendOperator
        with StringFormatSpecifiers {

        override def createNewMap(rhsMap: AsboMap): AsboMap = {
          val newMap = mutable.Map.empty[ASBO, StringPartAutomaton]
          newMap ++= rhsMap
          val sfArgs = reorderStringFormatArgs
          if (sfArgs.isEmpty)
            rhsMap
          else {
            val sfTail = sfArgs.tail
            val automaton = sfTail.foldLeft(singleAutomaton(sfArgs.head)) {
              case (resultAutomaton, stringFormatArg) =>
                stringFormatArg match {
                  case StringIdentifier(id) =>
                    val (auto, toAppend) = getAppendAutomaton(id, newMap)
                    newMap ++= toAppend
                    resultAutomaton +++ auto
                  case other =>
                    val appendAutomaton = singleAutomaton(other)
                    resultAutomaton +++ appendAutomaton
                }
            }

            // the ASBO corresponding to String.format can't be already contained in rhsMap,
            // so we just add the result to the map
            newMap += (createAsbo(instr.getDef, node) -> automaton)
          }
        }

        private[this] def getArrayValNums(arrayDef: ValueNumber): Iterator[ValueNumber] =
          node.getDu getUses arrayDef collect {
            case store: SSAArrayStoreInstruction =>
              store getUse 2
          }

        /**
          * Produce sequence of [[StringPart]]s for String.format arguments in the right concatenation order.
          * This method does not substitute the value numbers with the corresponding automata or [[ASBO]]s.
          */
        def reorderStringFormatArgs: Seq[StringPart] = {
          val firstArg = getFirstStringFormatArg(instr)
          val formatArrayValNum = getStringFormatArray(instr)
          val table = node.getIr.getSymbolTable
          if (table isStringConstant firstArg) {
            val argValNums = getArrayValNums(formatArrayValNum)
            val (formattedParts, specifierNum) = parse(table getStringValue firstArg)
            formattedParts.foldLeft(Vector.empty[StringPart]) {
              case (parts, FormattedStringPart(string)) =>
                parts :+ StringFormatPart(string)
              case (parts, Specifier(count)) =>
                val newVariable =
                  if (argValNums.hasNext)
                    StringIdentifier(createIdentifier(argValNums.next(), node))
                  else MissingStringFormatArgument
                parts :+ newVariable
            }
          } else Seq.empty[StringPart]
        }
      }

      /**
        * Append the automaton for [[appendId]] to all [[asbos]].
        */
      protected case class StringBuilderAppendOperator(
        asbos: Set[ASBO],
        appendId: Identifier
      ) extends AbstractAppendOperator {

        override def createNewMap(rhsMap: AsboMap) = {
          val newMap = mutable.Map.empty[ASBO, StringPartAutomaton] ++= rhsMap
          val (appendAutomaton, toAppend) = getAppendAutomaton(appendId, rhsMap)
          newMap ++= toAppend
          asbos foreach {
            asbo =>
              val newString = rhsMap get asbo match {
                case Some(sb) =>
                  sb +++ appendAutomaton
                case None =>
                  appendAutomaton
              }
              newMap += asbo -> newString
          }
          newMap
        }
      }

      // todo test intra- and inter-procedural cycles
      private[this] lazy val stronglyConnectedComponents: Set[util.Set[BB]] =
        (new SCCIterator(cfg) filter { _.size() > 1 }).toSet

      case class StringMeetOperator() extends AbstractMeetOperator[AtaReference] {

        override def evaluate(lhs: AtaReference, rhs: Array[AtaReference]): Byte = {
          val lhsAta = ataRefMapping(lhs.index)

          val sccForLhs = lhsAta.bb flatMap {
            block =>
              stronglyConnectedComponents find {
                _ contains block
              }
          }
          def addRhsToLhs(l: AsboMap, r: AsboToAutomaton): Unit =
            sccForLhs match  {
              case Some(scc) if scc contains r.bb.get =>
                r.asboToAutomaton foreach {
                  case (asbo, _) =>
                    l += asbo -> singleAutomaton(StringCycle)
                }
              case _                              =>
                r.asboToAutomaton foreach {
                  case (asbo, auto1) =>
                    l get asbo match {
                      case Some(auto2) =>
                        l += asbo -> (auto1 | auto2)
                      case None =>
                        l += asbo -> auto1
                    }
                }
            }

          val newMap = mutable.Map.empty[ASBO, StringPartAutomaton]
          rhs foreach {
            rmapRef =>
              addRhsToLhs(newMap, ataRefMapping(rmapRef.index))
          }
          if (newMap == lhsAta.asboToAutomaton)
            NOT_CHANGED
          else {
            lhsAta.asboToAutomaton ++= newMap
            CHANGED
          }
        }
      }

      override def getMeetOperator: AbstractMeetOperator[AtaReference] = StringMeetOperator()
    }

    /**
      * For efficiency we store our AsboToAutomaton in this array. The analysis operates on its indices
      * that serve as references to the stored AsboToAutomaton objects.
      */
    override def ataRefMapping: ArrayBuffer[AsboToAutomaton] = initialMapping
  }
}
