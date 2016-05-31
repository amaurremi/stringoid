package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend

import java.util

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.AbstractStringBuilderModule
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{IVariable, UnaryOperator}
import com.ibm.wala.ssa._
import com.ibm.wala.types.FieldReference
import com.ibm.wala.util.graph.NumberedGraph
import com.ibm.wala.util.graph.impl.NodeWithNumber

import scala.collection.JavaConversions._
import scala.collection.breakOut
import scala.collection.mutable.ArrayBuffer

trait StringAppendModule extends StringAppendTypes with AbstractStringBuilderModule {

  protected val MISSING_STRING_BUILDER_MESSAGE: String =
    "Value-number-to-ASBO map should contain the value number for this string builder."
  protected val EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE: String =
    "No edge transfer functions for StringAppend fixed-point solver."

  val processedRetInstructions = new util.IdentityHashMap[SSAInstruction, Int] withDefaultValue 0
  val processedCallInstructions = new util.IdentityHashMap[SSAInstruction, Int] withDefaultValue 0
  val processedAppendInstructions = new util.IdentityHashMap[SSAInstruction, Int] withDefaultValue 0
  val processedIdInstructions = new util.IdentityHashMap[SSAInstruction, Int] withDefaultValue 0

  var processedMeetInstructions = 0
  var instrCount = 0

  def updateProcessedInstructions(map: scala.collection.mutable.Map[SSAInstruction, Int], instr: SSAInstruction) = {
    map(instr) = map(instr) + 1
    instrCount = instrCount + 1
  }

  def stringAppendsForSolver(solver: StringAppendFixedPointSolver): Iterator[StringPartAutomaton] = {
    val result  = TimeResult("string-append solver", solver.result)
    val mapping = solver.ataRefMapping
    val ataRefs: Set[Int] = (solver.cfg map {
      result.getOut(_).index
    })(breakOut)
    TimeResult("creating sequence of all automata",
      ataRefs.iterator flatMap {
        mapping(_).asboToAutomaton.valuesIterator
      }
    )
  }

  abstract class StringAppendFixedPointSolver(
    vnToAsbo: Map[Identifier, Set[ASBO]],
    fieldToAutomaton: Map[FieldReference, StringPartAutomaton]
  ) {

    type BB
    type AsboMap = Map[ASBO, StringPartAutomaton]

    def cfg: NumberedGraph[BB]

    def initialMapping: AsboMap

    def result: DataflowSolver[BB, AtaReference] = {
      val framework = new IKilldallFramework[BB, AtaReference] {

        override def getFlowGraph = cfg

        override def getTransferFunctionProvider = transferFunctions
      }

      val solver = getSolver(framework)
      solver.solve(null)
      solver
    }

    /**
     * For efficiency we store our AsboToAutomaton in this array. The analysis operates on its indices
     * that serve as references to the stored AsboToAutomaton objects.
     */
    val ataRefMapping: ArrayBuffer[AsboToAutomaton] = new ArrayBuffer[AsboToAutomaton]()

    def initialAtaForNode(node: Node): AsboMap = {
      val table = node.getIr.getSymbolTable
      (1 to table.getMaxValueNumber).foldLeft(Map.empty[ASBO, StringPartAutomaton]) {
        case (oldMap, vn) =>
          if (table isConstant vn) {
            val automaton = StringPartAutomaton(node.getDu getDef vn, StringIdentifier(createIdentifier(vn, node)))
            oldMap + (createAsbo(vn, node) -> automaton)
          } else {
            node.getDu getDef vn match {
              case fdAccess: SSAFieldAccessInstruction =>
                (fieldToAutomaton get fdAccess.getDeclaredField).foldLeft(oldMap) {
                  case (oldOldMap, automaton) =>
                    oldOldMap + (createAsbo(vn, node) -> automaton)
                }
              case _                                   =>
                oldMap
            }
          }
      }
    }

    // ITransferFunctionProvider's methods force the lattice elements to be mutable
    /**
     * The map from ASBOs to string concatenations
      *
      * @param bb we need to keep track of the basic block in order to see whether a statement
     *           appears in a strongly connected component
     */
    case class AsboToAutomaton(var asboToAutomaton: AsboMap, bb: Option[BB])

    /**
     * A reference to an AsboToAutomaton in the [[ataRefMapping]] array
     */
    sealed trait AtaReference extends NodeWithNumber with IVariable[AtaReference]  {

      val index: Int

      private[this] var orderNumber = -1

      override def getOrderNumber: Int = orderNumber

      override def setOrderNumber(i: Int): Unit = orderNumber = i

      override def copyState(ref: AtaReference): Unit = {
        ataRefMapping(index).asboToAutomaton = ataRefMapping(ref.index).asboToAutomaton
      }
    }

    case class AtaRefIn(override val index: Int) extends AtaReference
    case class AtaRefOut(override val index: Int) extends AtaReference

    import com.ibm.wala.fixpoint.FixedPointConstants._

    def getSolver(framework: IKilldallFramework[BB, AtaReference]) =
      new DataflowSolver[BB, AtaReference](framework) {

        override def makeNodeVariable(bb: BB, in: Boolean): AtaReference = {
          val nextIndex = ataRefMapping.size
          ataRefMapping += AsboToAutomaton(initialMapping, Some(bb)) // todo this might be inefficient
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

    protected def transferFunctions: StringAppendTransferFunctions

    abstract class StringAppendTransferFunctions(idToAsbo: Map[Identifier, Set[ASBO]]) extends ITransferFunctionProvider[BB, AtaReference] {

      protected[this] def updateLhs(lhs: AtaReference, addToLhsMap: AsboMap): Unit = {
        val mapping = ataRefMapping(lhs.index)
        mapping.asboToAutomaton = mapping.asboToAutomaton ++ addToLhsMap
      }

      def createAutomaton(instruction: SSAInstruction, node: Node, id: Identifier): StringPartAutomaton =
        node.getDu getDef valNum(id) match {
          case instr: SSAFieldAccessInstruction if fieldToAutomaton contains instr.getDeclaredField =>
            fieldToAutomaton(instr.getDeclaredField)
          case _                                                                                    =>
            StringPartAutomaton(instruction, StringIdentifier(id))
        }

      /**
        * Resolve the union of all automata to which this value number could map.
        * 1. For each ASBO, checks if value number is in `rhsMap`, and
        *    - if yes, returns automaton;
        *    - if no, checks if val num is a phi instruction,
        *      and if yes, resolves its arguments recursively and adds them to a new AsboMap
        *      with which we will need to update the lhsMap.
        */
      private[this] def getAppendAutomaton(
        node: Node,
        id: Identifier,
        instruction: SSAInstruction,
        idNode: Node,
        rhsMap: AsboMap,
        processedAcc: Set[Identifier]
      ): (StringPartAutomaton, AsboMap) = {
        val (resultAuto, resultMap) =
          if (processedAcc contains id)
            (StringPartAutomaton(instruction, StringCycle), Map.empty[ASBO, StringPartAutomaton])
          else {
            idToAsbo get id match {
              case Some(asbos) =>
                val automata = for {
                  asbo <- asbos.iterator
                  automaton <- rhsMap get asbo
                } yield automaton
                val newValNumAutomaton =
                  if (automata.isEmpty) createAutomaton(instruction, node, id)
                  else StringPartAutomaton.merge(automata)
                (newValNumAutomaton, Map.empty[ASBO, StringPartAutomaton])
              case None if rhsMap contains createAsbo(valNum(id), idNode) =>
                (rhsMap(createAsbo(valNum(id), idNode)), Map.empty[ASBO, StringPartAutomaton])
              case None =>
                node.getDu getDef valNum(id) match {
                  case phi: SSAPhiInstruction =>
                    val uses = 0 until phi.getNumberOfUses map phi.getUse filter {
                      _ > 0
                    }
                    val (automata, asboMaps) = (uses map {
                      u =>
                        getAppendAutomaton(node, createIdentifier(u, node), instruction, idNode, rhsMap, processedAcc + id)
                    }).unzip
                    val mergedAutomaton = StringPartAutomaton.merge(automata.iterator)
                    val mergedMap = (asboMaps reduceLeft {
                      _ ++ _
                    }) + (createAsbo(phi.getDef, node) -> mergedAutomaton)
                    (mergedAutomaton, mergedMap)
                  case _ =>
                    (createAutomaton(instruction, node, id), Map.empty[ASBO, StringPartAutomaton])
                }
            }
          }
        (resultAuto addInstr instruction, resultMap)
      }

      def getAppendAutomaton(node: Node, id: Identifier, instruction: SSAInstruction, idNode: Node, rhsMap: AsboMap): (StringPartAutomaton, AsboMap) =
        getAppendAutomaton(node, id, instruction, idNode, rhsMap, Set.empty[Identifier])


      protected trait AbstractAppendOperator extends UnaryOperator[AtaReference] {

        def createNewMap(rhsMap: AsboMap): AsboMap

        override def evaluate(lhs: AtaReference, rhs: AtaReference): Byte = {
          val rhsMap = ataRefMapping(rhs.index).asboToAutomaton
          val newMap = createNewMap(rhsMap)
          val lhsMap: AsboMap = ataRefMapping(lhs.index).asboToAutomaton

          if (lhsMap == newMap)
            NOT_CHANGED
          else {
            updateLhs(lhs, newMap)
            CHANGED
          }
        }
      }

      /**
        * Append the automaton for [[appendId]] to all [[asbos]].
        */
      protected case class StringBuilderAppendOperator(
        asbos: Set[ASBO],
        appendId: Identifier,
        idNode: Node,
        node: Node,
        instruction: SSAInstruction
      ) extends AbstractAppendOperator {

        override def createNewMap(rhsMap: AsboMap): AsboMap = {
          updateProcessedInstructions(processedAppendInstructions, instruction)

          val (appendAutomaton, toAppend) = getAppendAutomaton(node, appendId, instruction, idNode, rhsMap)
          asbos.foldLeft(rhsMap ++ toAppend) {
            case (m, asbo) =>
              val newString = rhsMap get asbo match {
                case Some(sb) =>
                  sb +++ appendAutomaton
                case None =>
                  appendAutomaton
              }
              m + (asbo -> newString)
          }
        }
      }

      protected case class StringFormatAppendOperator(
        instr: SSAAbstractInvokeInstruction,
        node: Node
      ) extends AbstractAppendOperator with StringFormatSpecifiers {

        override def createNewMap(rhsMap: AsboMap): AsboMap = {
          val sfArgSeqs: Seq[Seq[StringPart]] = reorderStringFormatArgs
          if (sfArgSeqs.isEmpty)
            rhsMap
          else {
            sfArgSeqs.foldLeft(rhsMap) {
              case (m, sfArgs) =>
                val sfTail = sfArgs.tail
                val (updNewMap, automaton) = sfTail.foldLeft(m, StringPartAutomaton(instr, sfArgs.head)) {
                  case ((updM, resultAutomaton), stringFormatArg) =>
                    stringFormatArg match {
                      case StringIdentifier(id) =>
                        val (auto, toAppend) = getAppendAutomaton(node, id, instr, node, m)
                        (updM ++ toAppend, resultAutomaton +++ auto)
                      case other =>
                        val appendAutomaton = StringPartAutomaton(instr, other)
                        (updM, resultAutomaton +++ appendAutomaton)
                    }
                }

                // the ASBO corresponding to String.format can't be already contained in rhsMap,
                // so we just add the result to the map
                updNewMap + (createAsbo(instr.getDef, node) -> automaton)
            }
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
                    createAutomaton(instr, node, createIdentifier(argValNums.next(), node)).automaton.iterator.toVector
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

      override def getMeetOperator: AbstractMeetOperator[AtaReference] = StringMeetOperator()

      case class StringMeetOperator() extends AbstractMeetOperator[AtaReference] {

        override def evaluate(lhs: AtaReference, rhs: Array[AtaReference]): Byte = {
          processedMeetInstructions = processedMeetInstructions + 1

          def add(asbo: ASBO, auto1: StringPartAutomaton, l: AsboMap): StringPartAutomaton =
            l get asbo match {
              case Some(auto2) =>
                auto1 | auto2
              case None        =>
                auto1
            }

          def getNewMap(
            oldLhsMap: AsboMap,
            newMap: AsboMap,
            asbo: ASBO,
            rAuto: StringPartAutomaton
          ): AsboMap = {
            oldLhsMap get asbo match {
              case Some(StringPartAutomaton(_, instructions)) if (rAuto.instructions -- instructions).nonEmpty => // avoiding loops
                val automaton = add(asbo, rAuto, newMap)
                newMap.updated(asbo, automaton)
              case None =>
                val automaton = add(asbo, rAuto, newMap)
                newMap.updated(asbo, add(asbo, rAuto, newMap))
              case _ =>
                newMap
            }
          }

          val lhsAta = ataRefMapping(lhs.index)
          val oldLhsMap = lhsAta.asboToAutomaton
          var newMap = oldLhsMap
          for {
            rmapRef      <- rhs
            rmap          = ataRefMapping(rmapRef.index).asboToAutomaton
            (asbo, rAuto) <- rmap
          } {
            newMap get asbo match {
              case None                              =>
                newMap = getNewMap(oldLhsMap, newMap, asbo, rAuto)
              case Some(newAuto) if newAuto ne rAuto =>
                newMap = getNewMap(oldLhsMap, newMap, asbo, rAuto)
              case _                                 =>
                ()
            }
          }

          if (newMap.isEmpty || newMap == oldLhsMap)
            NOT_CHANGED
          else {
            lhsAta.asboToAutomaton = newMap
            CHANGED
          }
        }
      }

      protected case class IdentityOperator(instr: SSAInstruction) extends UnaryOperator[AtaReference] {

        override def evaluate(lhs: AtaReference, rhs: AtaReference): Byte = {
          updateProcessedInstructions(processedIdInstructions, instr)

          val lhsMap = ataRefMapping(lhs.index).asboToAutomaton
          val rhsMap = ataRefMapping(rhs.index).asboToAutomaton

          if (lhsMap == rhsMap)
            NOT_CHANGED
          else {
            updateLhs(lhs, rhsMap)
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
