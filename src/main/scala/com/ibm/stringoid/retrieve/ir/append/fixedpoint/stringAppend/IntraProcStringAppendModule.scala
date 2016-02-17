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
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAArrayStoreInstruction}
import com.ibm.wala.types.FieldReference
import com.ibm.wala.util.graph.traverse.SCCIterator

import scala.collection.JavaConversions._
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

trait IntraProcStringAppendModule extends StringAppendModule with IntraProcASBOModule {

  /**
    * Get the string concatenation results.
    */
  def stringAppends(node: Node, fieldToAutomaton: Map[FieldReference, StringPartAutomaton]): StringPartAutomaton = {
    val idToAsbo: Map[ValueNumber, Set[ASBO]] = idToAsboForNode(node)
    val solver: IntraProcStringAppendSolver = getAppendSolver(node, idToAsbo, fieldToAutomaton)
    stringAppendsForSolver(solver)
  }

  def getAppendSolver(
    node: Node,
    vnToAsbo: Map[Identifier, Set[ASBO]],
    fieldToAutomaton: Map[FieldReference, StringPartAutomaton]
  ) = new IntraProcStringAppendSolver(node, vnToAsbo, fieldToAutomaton)

  class IntraProcStringAppendSolver(
    node: Node,
    idToAsbo: Map[Identifier, Set[ASBO]],
    fieldToAutomaton: Map[FieldReference, StringPartAutomaton]
  ) extends StringAppendFixedPointSolver(idToAsbo, fieldToAutomaton) {

    override type BB = IExplodedBasicBlock

    override lazy val initialMapping: ArrayBuffer[AsboToAutomaton] =
      initialAtaRefMapping(ArrayBuffer.empty[AsboToAutomaton], node)

    override lazy val cfg = ExceptionPrunedCFG.make(ExplodedControlFlowGraph.make(node.getIr))

    override protected def transferFunctions: StringAppendTransferFunctions = new IntraProcStringAppendTransferFunctions

    class IntraProcStringAppendTransferFunctions extends StringAppendTransferFunctions(idToAsbo) {

      override def valNum(id: Identifier): ValueNumber = id

      override def getNodeTransferFunction(bb: BB): UnaryOperator[AtaReference] =
        bb.getInstruction match {
          case instr: SSAAbstractInvokeInstruction if isSbAppend(instr)                =>
            idToAsbo get getFirstSbAppendDef(instr) match {
              case Some(asbos) =>
                new StringBuilderAppendOperator(asbos, getAppendArgument(instr), node)
              case None =>
                // todo note that this means that we are appending to a StringBuilder for which we haven't added an ASBO to the idToAsbo map.
                // todo I think this means that the StringBuilder has been passed as a parameter or is a field. We should handle this case too at some point.
                IdentityOperator()
            }
          case inv: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(inv) =>
            idToAsbo get getSbConstructorDef(inv) match {
              case Some(asbos) =>
                val appendArgument = getSbConstructorArgument(inv)
                new StringBuilderAppendOperator(asbos, appendArgument, node)
              case None =>
                throw new UnsupportedOperationException(MISSING_STRING_BUILDER_MESSAGE)
            }
          case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)                 =>
            new StringFormatAppendOperator(inv, node)
          case _                                                                =>
            IdentityOperator()
        }

      protected case class StringFormatAppendOperator(
        instr: SSAAbstractInvokeInstruction,
        node: Node
      )
        extends AbstractAppendOperator
        with StringFormatSpecifiers {

        override def createLhsMap(rhsMap: AsboMap): AsboMap = {
          val newMap = mutable.Map.empty[ASBO, StringPartAutomaton]
          newMap ++= rhsMap
          val sfArgSeqs: Seq[Seq[StringPart]] = reorderStringFormatArgs
          if (sfArgSeqs.isEmpty)
            rhsMap
          else {
            sfArgSeqs foreach {
              sfArgs =>
                val sfTail = sfArgs.tail
                val automaton = sfTail.foldLeft(singleAutomaton(sfArgs.head)) {
                  case (resultAutomaton, stringFormatArg) =>
                    stringFormatArg match {
                      case StringIdentifier(id) =>
                        val (auto, toAppend) = getAppendAutomaton(node, id, newMap)
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
            newMap
          }
        }

        private[this] def getArrayValNums(arrayDef: ValueNumber): Iterator[ValueNumber] =
          node.getDu getUses arrayDef collect {
            case store: SSAArrayStoreInstruction =>
              store getUse 2
          }

        /**
          * Produce sequence of [[StringPart]]s for String.format arguments in the right concatenation order,
          * in the form of an automaton.
          * This method does not substitute the value numbers with the corresponding automata or [[ASBO]]s.
          */
        def reorderStringFormatArgs: Vector[Vector[StringPart]] = {
          val firstArg = getFirstStringFormatArg(instr)
          val formatArrayValNum = getStringFormatArray(instr)
          val table = node.getIr.getSymbolTable
          if (table isStringConstant firstArg) {
            val argValNums = getArrayValNums(formatArrayValNum)
            val (formattedParts, specifierNum) = parse(table getStringValue firstArg)
            formattedParts.foldLeft(Vector.empty[Vector[StringPart]]) {
              case (parts, FormattedStringPart(string)) =>
                val stringPart = StaticFieldPart(string)
                if (parts.isEmpty) Vector(Vector(stringPart))
                else parts map {
                  _ :+ stringPart
                }
              case (parts, Specifier(count)) =>
                val newVariables =
                  if (argValNums.hasNext)
                    createAutomaton(node, createIdentifier(argValNums.next(), node)).iterator.toVector
                  else Vector(Seq(MissingStringFormatArgument))
                if (parts.isEmpty) newVariables map { _.toVector }
                else for {
                  v <- newVariables
                  p <- parts
                } yield p ++ v
            }
          } else Vector.empty[Vector[StringPart]]
        }
      }

      // todo test intra- and inter-procedural cycles
      private[this] lazy val stronglyConnectedComponents: Set[util.Set[BB]] =
        (new SCCIterator(cfg) filter {
          blocks =>
            (blocks.size() > 1) || cfg.hasEdge(blocks.head, blocks.head)
        }).toSet

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
