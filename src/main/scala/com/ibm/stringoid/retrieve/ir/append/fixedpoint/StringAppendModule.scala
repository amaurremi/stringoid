package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import java.util

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{IVariable, UnaryOperator}
import com.ibm.wala.ipa.cfg.ExceptionPrunedCFG
import com.ibm.wala.ssa._
import com.ibm.wala.ssa.analysis.{ExplodedControlFlowGraph, IExplodedBasicBlock}
import com.ibm.wala.util.graph.impl.NodeWithNumber
import com.ibm.wala.util.graph.traverse.SCCIterator
import seqset.regular.Automaton

import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer
import scala.collection.{breakOut, mutable}

trait StringAppendModule extends AbstractStringBuilderModule {

  private[this] val MISSING_STRING_BUILDER_MESSAGE: String =
    "Value-number-to-ASBO map should contain the value number for this string builder."
  private[this] val EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE: String =
    "No edge transfer functions for StringAppend fixed-point solver."

  type ValNumAutomaton = Automaton[StringPart]

  /**
   * Get the string concatenation results.
   */
  def stringAppends(node: Node): ValNumAutomaton = {
    valueNumberToAsbo(node) match {
      case Some(vnToAsbo) =>
        val solver  = new StringAppendFixedPointSolver(node, vnToAsbo)
        val result  = solver.result
        val mapping = solver.ataRefMapping
        val ataRefs: Set[Int] = (solver.graph map {
            result.getOut(_).index
        })(breakOut)
        ataRefs.foldLeft(Automaton.empty[StringPart]) {
          (automaton, ref) =>
            val automata = mapping(ref).asboToAutomaton.values
            automaton | mergeAutomata(automata)
        }
      case None           =>
        Automaton.empty[StringPart]
    }
  }

  def mergeAutomata(automata: Iterable[Automaton[StringPart]]) =
    automata.foldLeft(Automaton.empty[StringPart]) { _ | _ }

  def singleAutomaton(sp: StringPart) = Automaton.empty[StringPart] + Seq(sp)

  private class StringAppendFixedPointSolver(node: Node, vnToAsbo: Map[ValueNumber, Set[ASBO]]) {

    type BB      = IExplodedBasicBlock
    type AsboMap = mutable.Map[ASBO, ValNumAutomaton]

    def graph = getGraph

    /**
     * For efficiency we store our AsboToAutomaton in this array. The analysis operates on its indices
     * that serve as references to the stored AsboToAutomaton objects.
     */
    val ataRefMapping = initialAtaRefMapping

    def initialAtaRefMapping: ArrayBuffer[AsboToAutomaton] = {
      val refMapping = ArrayBuffer.empty[AsboToAutomaton]
      val table = node.getIr.getSymbolTable
      1 to table.getMaxValueNumber foreach {
        vn =>
          if (table isConstant vn) {
            val automaton = Automaton.empty[StringPart] + Seq(StringValNum(vn))
            val asboMap = mutable.Map(getAsbo(vn, node) -> automaton)
            refMapping += AsboToAutomaton(asboMap, None)
          }
      }
      refMapping
    }

    // ITransferFunctionProvider's methods force the lattice elements to be mutable
    /**
     * The map from ASBOs to string concatenations
     * @param bb we need to keep track of the basic block in order to see whether a statement
     *           appears in a strongly connected component
     */
    case class AsboToAutomaton(asboToAutomaton: AsboMap, bb: Option[BB])

    /**
     * A reference to an AsboToAutomaton in the [[ataRefMapping]] array
     */
    sealed trait AtaReference extends NodeWithNumber with IVariable[AtaReference]  {

      val index: Int

      private[this] var orderNumber = -1

      override def getOrderNumber: Int = orderNumber

      override def setOrderNumber(i: Int): Unit = orderNumber = i

      override def copyState(ref: AtaReference): Unit = {
        val asboToString = ataRefMapping(index).asboToAutomaton
        asboToString.clear()
        asboToString ++= ataRefMapping(ref.index).asboToAutomaton
      }
    }

    case class AtaRefIn(override val index: Int) extends AtaReference
    case class AtaRefOut(override val index: Int) extends AtaReference

    import com.ibm.wala.fixpoint.FixedPointConstants._

    def result: DataflowSolver[BB, AtaReference] = {
      val framework = new IKilldallFramework[BB, AtaReference] {

        override def getFlowGraph = getGraph

        override def getTransferFunctionProvider = transferFunctions
      }

      val solver = getSolver(framework)
      solver.solve(null)
      solver
    }

    private[this] lazy val getGraph = ExceptionPrunedCFG.make(ExplodedControlFlowGraph.make(node.getIr))

    private[this] lazy val stronglyConnectedComponents: Set[util.Set[BB]] =
      (new SCCIterator(getGraph) filter { _.size() > 1 }).toSet

    private[this] def getSolver(framework: IKilldallFramework[BB, AtaReference]) =
      new DataflowSolver[BB, AtaReference](framework) {

        override def makeNodeVariable(bb: BB, in: Boolean): AtaReference = {
          val nextIndex = ataRefMapping.size
          ataRefMapping += AsboToAutomaton(mutable.Map.empty[ASBO, ValNumAutomaton], Some(bb))
          if (in)
            AtaRefIn(nextIndex)
          else
            AtaRefOut(nextIndex)
        }

        override def makeEdgeVariable(src: BB, dst: BB): AtaReference =
          throw new UnsupportedOperationException(EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE)

        override def makeStmtRHS(size: ValueNumber): Array[AtaReference] =
          new Array[AtaReference](size)
      }

    private[this] def transferFunctions = new ITransferFunctionProvider[BB, AtaReference] {

      override def getMeetOperator: AbstractMeetOperator[AtaReference] = StringMeetOperator()

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

          val newMap = mutable.Map.empty[ASBO, ValNumAutomaton]
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

      override def getNodeTransferFunction(bb: BB): UnaryOperator[AtaReference] =
        bb.getInstruction match {
          case instr: SSAAbstractInvokeInstruction if isSbAppend(instr)                =>
            vnToAsbo get getFirstSbAppendDef(instr) match {
              case Some(asbos) =>
                new StringBuilderAppendOperator(asbos, getAppendArgument(instr))
              case None =>
                // todo note that this means that we are appending to a StringBuilder for which we haven't added an ASBO to the vnToAsbo map.
                // todo I think this means that the StringBuilder has been passed as a parameter or is a field. We should handle this case too at some point.
                IdentityOperator()
            }
          case inv: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(inv) =>
            vnToAsbo get getSbConstructorDef(inv) match {
              case Some(asbos) =>
                val appendArgument = getSbConstructorArgument(inv)
                new StringBuilderAppendOperator(asbos, appendArgument)
              case None =>
                throw new UnsupportedOperationException(MISSING_STRING_BUILDER_MESSAGE)
            }
          case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)                 =>
            new StringFormatAppendOperator(inv, node.getDu)
          case _                                                                =>
            IdentityOperator()
        }

        /**
         * Resolve the union of all automata to which this value number could map.
         * 1. For each ASBO, checks if value number is in `rhsMap`, and
         *    - if yes, returns automaton;
         *    - if no, checks if val num is a phi instruction,
         *      and if yes, resolves its arguments recursively and adds them to a new AsboMap
         *      with which we will need to update the lhsMap.
         */
        private[this] def getAppendAutomaton(vn: ValueNumber, rhsMap: AsboMap): (ValNumAutomaton, AsboMap) =
          vnToAsbo get vn match {
            case Some(asbos) =>
              val automata = for {
                asbo      <- asbos
                automaton <- rhsMap get asbo
              } yield automaton
              val newValNumAutomaton = if (automata.isEmpty)
                singleAutomaton(StringValNum(vn))
              else
                mergeAutomata(automata)
              (newValNumAutomaton, mutable.Map.empty[ASBO, ValNumAutomaton])
            case None         =>
              node.getDu.getDef(vn) match {
                case phi: SSAPhiInstruction =>
                  val uses = 0 until phi.getNumberOfUses map phi.getUse
                  val (automata, asboMaps) = (uses map { getAppendAutomaton(_, rhsMap) }).unzip
                  val mergedAutomaton = mergeAutomata(automata)
                  val mergedMap = (asboMaps reduceLeft {
                    _ ++ _
                  }) + (getAsbo(phi.getDef, node) -> mergedAutomaton)
                  (mergedAutomaton, mergedMap)
                case _                      =>
                  (singleAutomaton(StringValNum(vn)), mutable.Map.empty[ASBO, ValNumAutomaton])
              }
          }

        private[this] sealed trait AbstractAppendOperator extends UnaryOperator[AtaReference] {

          def createNewMap(rhsMap: AsboMap): AsboMap

          override def evaluate(lhs: AtaReference, rhs: AtaReference): Byte = {
            val rhsMap = ataRefMapping(rhs.index).asboToAutomaton
            val newMap = createNewMap(rhsMap)
            val lhsMap: AsboMap = ataRefMapping(lhs.index).asboToAutomaton

            if (lhsMap == newMap)
              NOT_CHANGED
            else {
              lhsMap ++= newMap
              CHANGED
            }
          }
        }

        /**
         * Append the automaton for [[appendVn]] to all [[asbos]].
         */
        private[this] case class StringBuilderAppendOperator(
          asbos: Set[ASBO],
          appendVn: ValueNumber
        ) extends AbstractAppendOperator {

          override def createNewMap(rhsMap: AsboMap) = {
            val newMap = mutable.Map.empty[ASBO, ValNumAutomaton] ++= rhsMap
            val (appendAutomaton, toAppend) = getAppendAutomaton(appendVn, rhsMap)
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

        private[this] case class StringFormatAppendOperator(
          instr: SSAAbstractInvokeInstruction,
          defUse: DefUse
        )
          extends AbstractAppendOperator
          with StringFormatSpecifiers {

          override def createNewMap(rhsMap: AsboMap): AsboMap = {
            val newMap = mutable.Map.empty[ASBO, ValNumAutomaton]
            newMap ++= rhsMap
            val sfArgs = reorderStringFormatArgs
            if (sfArgs.isEmpty)
              rhsMap
            else {
              val sfTail = sfArgs.tail
              val automaton = sfTail.foldLeft(singleAutomaton(sfArgs.head)) {
                case (resultAutomaton, stringFormatArg) =>
                  stringFormatArg match {
                    case StringValNum(vn) =>
                      val (auto, toAppend) = getAppendAutomaton(vn, newMap)
                      newMap ++= toAppend
                      resultAutomaton +++ auto
                    case other =>
                      val appendAutomaton = singleAutomaton(other)
                      resultAutomaton +++ appendAutomaton
                  }
              }

              // the ASBO corresponding to String.format can't be already contained in rhsMap,
              // so we just add the result to the map
              newMap += (getAsbo(instr.getDef, node) -> automaton)
            }
          }

          private[this] def getArrayValNums(arrayDef: ValueNumber): Iterator[ValueNumber] =
            defUse getUses arrayDef collect {
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
                      StringValNum(argValNums.next())
                    else MissingStringFormatArgument
                  parts :+ newVariable
              }
            } else Seq.empty[StringPart]
          }
        }

        private[this] case class IdentityOperator() extends UnaryOperator[AtaReference] {

          override def evaluate(lhs: AtaReference, rhs: AtaReference): Byte = {
            val lhsMap = ataRefMapping(lhs.index).asboToAutomaton
            val rhsMap = ataRefMapping(rhs.index).asboToAutomaton
            if (lhsMap == rhsMap)
              NOT_CHANGED
            else {
              lhsMap ++= rhsMap
              CHANGED
            }
          }

          override def isIdentity: Boolean = true
        }

      override def getEdgeTransferFunction(src: BB, dst: BB): UnaryOperator[AtaReference] =
        throw new UnsupportedOperationException(EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE)

      override def hasNodeTransferFunctions: Boolean = true

      override def hasEdgeTransferFunctions: Boolean = false
    }
  }
}
