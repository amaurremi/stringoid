package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend

import java.util

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.AbstractStringBuilderModule
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{IVariable, UnaryOperator}
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAArrayStoreInstruction, SSAFieldAccessInstruction, SSAPhiInstruction}
import com.ibm.wala.types.FieldReference
import com.ibm.wala.util.graph.NumberedGraph
import com.ibm.wala.util.graph.impl.NodeWithNumber
import com.ibm.wala.util.graph.traverse.SCCIterator
import seqset.regular.Automaton

import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer
import scala.collection.{breakOut, mutable}

trait StringAppendModule extends AbstractStringBuilderModule {

  protected val MISSING_STRING_BUILDER_MESSAGE: String =
    "Value-number-to-ASBO map should contain the value number for this string builder."
  protected val EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE: String =
    "No edge transfer functions for StringAppend fixed-point solver."

  type StringPartAutomaton = Automaton[StringPart]

  protected def stringAppends(
   node: Node,
   fieldToAutomaton: Map[FieldReference, StringPartAutomaton]
  ): StringPartAutomaton

  def mergeAutomata(automata: Iterable[Automaton[StringPart]]) =
    automata.foldLeft(Automaton.empty[StringPart]) { _ | _ }

  protected def singleAutomaton(sp: StringPart) = Automaton.empty[StringPart] + Seq(sp)

  def stringAppendsForSolver(solver: StringAppendFixedPointSolver): StringPartAutomaton = {
    val result  = solver.result
    val mapping = solver.ataRefMapping
    val ataRefs: Set[Int] = (solver.cfg map {
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

  abstract class StringAppendFixedPointSolver(
    vnToAsbo: Map[Identifier, Set[ASBO]],
    fieldToAutomaton: Map[FieldReference, StringPartAutomaton]
  ) {

    type BB
    type AsboMap = scala.collection.mutable.Map[ASBO, StringPartAutomaton]

    def cfg: NumberedGraph[BB]

    def initialMapping: ArrayBuffer[AsboToAutomaton]

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
    def ataRefMapping: ArrayBuffer[AsboToAutomaton]

    def initialAtaRefMapping(refMapping: ArrayBuffer[AsboToAutomaton], node: Node): ArrayBuffer[AsboToAutomaton] = {
      val table = node.getIr.getSymbolTable
      1 to table.getMaxValueNumber foreach {
        vn =>
          if (table isConstant vn) {
            val automaton = Automaton.empty[StringPart] + Seq(StringIdentifier(createIdentifier(vn, node)))
            val asboMap = mutable.Map(createAsbo(vn, node) -> automaton)
            refMapping += AsboToAutomaton(asboMap, None)
          } else {
            node.getDu getDef vn match {
              case fdAccess: SSAFieldAccessInstruction =>
                fieldToAutomaton get fdAccess.getDeclaredField foreach {
                  automaton =>
                    val asboMap = mutable.Map(createAsbo(vn, node) -> automaton)
                    refMapping += AsboToAutomaton(asboMap, None)
                }
              case _                                   => ()
            }
          }
      }
      refMapping
    }

    // ITransferFunctionProvider's methods force the lattice elements to be mutable
    /**
     * The map from ASBOs to string concatenations
      *
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

    def getSolver(framework: IKilldallFramework[BB, AtaReference]) =
      new DataflowSolver[BB, AtaReference](framework) {

        override def makeNodeVariable(bb: BB, in: Boolean): AtaReference = {
          val nextIndex = ataRefMapping.size
          ataRefMapping += AsboToAutomaton(mutable.Map.empty[ASBO, StringPartAutomaton], Some(bb))
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

      // todo different for interproc case?
      lazy val stronglyConnectedComponents: Set[util.Set[BB]] =
        (new SCCIterator(cfg) filter {
          blocks =>
            (blocks.size() > 1) || cfg.hasEdge(blocks.head, blocks.head)
        }).toSet

      def createAutomaton(node: Node, id: Identifier): StringPartAutomaton =
        node.getDu getDef valNum(id) match {
          case instr: SSAFieldAccessInstruction if fieldToAutomaton contains instr.getDeclaredField =>
            fieldToAutomaton(instr.getDeclaredField)
          case _                                                                                    =>
            singleAutomaton(StringIdentifier(id))
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
        rhsMap: AsboMap,
        processedAcc: Set[Identifier]
      ): (StringPartAutomaton, AsboMap) =
        if (processedAcc contains id)
          (singleAutomaton(StringCycle), mutable.Map.empty[ASBO, StringPartAutomaton])
        else {
          idToAsbo get id match {
            case Some(asbos) =>
              val automata = for {
                asbo <- asbos
                automaton <- rhsMap get asbo
              } yield automaton
              val newValNumAutomaton = if (automata.isEmpty)
                createAutomaton(node, id)
              else
                mergeAutomata(automata)
              (newValNumAutomaton, mutable.Map.empty[ASBO, StringPartAutomaton])
            case None =>
              node.getDu getDef valNum(id) match {
                case phi: SSAPhiInstruction =>
                  val uses = 0 until phi.getNumberOfUses map phi.getUse filter {
                    _ > 0
                  }
                  val (automata, asboMaps) = (uses map {
                    u =>
                      getAppendAutomaton(node, createIdentifier(u, node), rhsMap, processedAcc + id)
                  }).unzip
                  val mergedAutomaton = mergeAutomata(automata)
                  val mergedMap = (asboMaps reduceLeft {
                    _ ++ _
                  }) + (createAsbo(phi.getDef, node) -> mergedAutomaton)
                  (mergedAutomaton, mergedMap)
                case _ =>
                  (createAutomaton(node, id), mutable.Map.empty[ASBO, StringPartAutomaton])
              }
          }
        }

      def getAppendAutomaton(node: Node, id: Identifier, rhsMap: AsboMap): (StringPartAutomaton, AsboMap) =
        getAppendAutomaton(node, id, rhsMap, Set.empty[Identifier])


      protected trait AbstractAppendOperator extends UnaryOperator[AtaReference] {

        def createLhsMap(rhsMap: AsboMap): AsboMap

        override def evaluate(lhs: AtaReference, rhs: AtaReference): Byte = {
          val rhsMap = ataRefMapping(rhs.index).asboToAutomaton
          val newMap = createLhsMap(rhsMap)
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
        * Append the automaton for [[appendId]] to all [[asbos]].
        */
      protected case class StringBuilderAppendOperator(
        asbos: Set[ASBO],
        appendId: Identifier,
        node: Node
      ) extends AbstractAppendOperator {

        override def createLhsMap(rhsMap: AsboMap): AsboMap = {
          val newMap = mutable.Map.empty[ASBO, StringPartAutomaton] ++= rhsMap
          val (appendAutomaton, toAppend) = getAppendAutomaton(node, appendId, rhsMap)
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

      protected case class StringFormatAppendOperator(
        instr: SSAAbstractInvokeInstruction,
        node: Node
      ) extends AbstractAppendOperator with StringFormatSpecifiers {

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

      protected case class IdentityOperator() extends UnaryOperator[AtaReference] {

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
