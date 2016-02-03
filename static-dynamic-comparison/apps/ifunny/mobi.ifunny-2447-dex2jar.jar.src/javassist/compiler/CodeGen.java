package javassist.compiler;

import java.util.ArrayList;
import java.util.Arrays;

import javassist.bytecode.Bytecode;
import javassist.bytecode.Opcode;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.ArrayInit;
import javassist.compiler.ast.AssignExpr;
import javassist.compiler.ast.BinExpr;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.CastExpr;
import javassist.compiler.ast.CondExpr;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.DoubleConst;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.FieldDecl;
import javassist.compiler.ast.InstanceOfExpr;
import javassist.compiler.ast.IntConst;
import javassist.compiler.ast.Keyword;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.MethodDecl;
import javassist.compiler.ast.NewExpr;
import javassist.compiler.ast.Pair;
import javassist.compiler.ast.Stmnt;
import javassist.compiler.ast.StringL;
import javassist.compiler.ast.Symbol;
import javassist.compiler.ast.Variable;
import javassist.compiler.ast.Visitor;

public abstract class CodeGen
        extends Visitor
        implements Opcode, TokenId {
    private static final int P_DOUBLE = 0;
    private static final int P_FLOAT = 1;
    private static final int P_INT = 3;
    private static final int P_LONG = 2;
    private static final int P_OTHER = -1;
    static final int[] binOp = {43, 99, 98, 97, 96, 45, 103, 102, 101, 100, 42, 107, 106, 105, 104, 47, 111, 110, 109, 108, 37, 115, 114, 113, 112, 124, 0, 0, 129, 128, 94, 0, 0, 131, 130, 38, 0, 0, 127, 126, 364, 0, 0, 121, 120, 366, 0, 0, 123, 122, 370, 0, 0, 125, 124};
    private static final int[] castOp = {0, 144, 143, 142, 141, 0, 140, 139, 138, 137, 0, 136, 135, 134, 133, 0};
    private static final int[] ifOp = {358, 159, 160, 350, 160, 159, 357, 164, 163, 359, 162, 161, 60, 161, 162, 62, 163, 164};
    private static final int[] ifOp2 = {358, 153, 154, 350, 154, 153, 357, 158, 157, 359, 156, 155, 60, 155, 156, 62, 157, 158};
    static final String javaLangObject = "java.lang.Object";
    static final String javaLangString = "java.lang.String";
    static final String jvmJavaLangObject = "java/lang/Object";
    static final String jvmJavaLangString = "java/lang/String";
    protected int arrayDim;
    protected ArrayList breakList;
    protected Bytecode bytecode;
    protected String className;
    protected ArrayList continueList;
    protected int exprType;
    protected boolean hasReturned;
    public boolean inStaticMethod;
    protected CodeGen.ReturnHook returnHooks;
    private int tempVar;
    TypeChecker typeChecker;

    public CodeGen(Bytecode paramBytecode) {
        this.bytecode = paramBytecode;
        this.tempVar = -1;
        this.typeChecker = null;
        this.hasReturned = false;
        this.inStaticMethod = false;
        this.breakList = null;
        this.continueList = null;
        this.returnHooks = null;
    }

    private void atArithBinExpr(Expr paramExpr, int paramInt1, int paramInt2, int paramInt3) {
        if (this.arrayDim != 0) {
            badTypes(paramExpr);
        }
        int i = this.exprType;
        if ((paramInt1 == 364) || (paramInt1 == 366) || (paramInt1 == 370)) {
            if ((i == 324) || (i == 334) || (i == 306) || (i == 303)) {
                this.exprType = paramInt3;
            }
        }
        for (; ; ) {
            paramInt1 = typePrecedence(this.exprType);
            if (paramInt1 < 0) {
                break;
            }
            paramInt2 = binOp[(paramInt2 + paramInt1 + 1)];
            if (paramInt2 == 0) {
                break;
            }
            if ((paramInt1 == 3) && (this.exprType != 301)) {
                this.exprType = 324;
            }
            this.bytecode.addOpcode(paramInt2);
            return;
            badTypes(paramExpr);
            continue;
            convertOprandTypes(paramInt3, i, paramExpr);
        }
        badTypes(paramExpr);
    }

    private void atArrayAssign(Expr paramExpr1, int paramInt, Expr paramExpr2, ASTree paramASTree, boolean paramBoolean) {
        arrayAccess(paramExpr2.oprand1(), paramExpr2.oprand2());
        if (paramInt != 61) {
            this.bytecode.addOpcode(92);
            this.bytecode.addOpcode(getArrayReadOp(this.exprType, this.arrayDim));
        }
        int i = this.exprType;
        int j = this.arrayDim;
        paramExpr2 = this.className;
        atAssignCore(paramExpr1, paramInt, paramASTree, i, j, paramExpr2);
        if (paramBoolean) {
            if (!is2word(i, j)) {
                break label131;
            }
            this.bytecode.addOpcode(94);
        }
        for (; ; ) {
            this.bytecode.addOpcode(getArrayWriteOp(i, j));
            this.exprType = i;
            this.arrayDim = j;
            this.className = paramExpr2;
            return;
            label131:
            this.bytecode.addOpcode(91);
        }
    }

    private void atBreakStmnt(Stmnt paramStmnt, boolean paramBoolean) {
        if (paramStmnt.head() != null) {
            throw new CompileError("sorry, not support labeled break or continue");
        }
        this.bytecode.addOpcode(167);
        paramStmnt = new Integer(this.bytecode.currentPc());
        this.bytecode.addIndex(0);
        if (paramBoolean) {
            this.breakList.add(paramStmnt);
            return;
        }
        this.continueList.add(paramStmnt);
    }

    private void atForStmnt(Stmnt paramStmnt) {
        ArrayList localArrayList1 = this.breakList;
        ArrayList localArrayList2 = this.continueList;
        this.breakList = new ArrayList();
        this.continueList = new ArrayList();
        Stmnt localStmnt = (Stmnt) paramStmnt.head();
        Object localObject1 = paramStmnt.tail();
        paramStmnt = ((ASTList) localObject1).head();
        Object localObject2 = ((ASTList) localObject1).tail();
        localObject1 = (Stmnt) ((ASTList) localObject2).head();
        localObject2 = (Stmnt) ((ASTList) localObject2).tail();
        if (localStmnt != null) {
            localStmnt.accept(this);
        }
        int j = this.bytecode.currentPc();
        int i;
        if (paramStmnt != null) {
            compileBooleanExpr(false, paramStmnt);
            i = this.bytecode.currentPc();
            this.bytecode.addIndex(0);
        }
        for (; ; ) {
            if (localObject2 != null) {
                ((Stmnt) localObject2).accept(this);
            }
            int k = this.bytecode.currentPc();
            if (localObject1 != null) {
                ((Stmnt) localObject1).accept(this);
            }
            this.bytecode.addOpcode(167);
            this.bytecode.addIndex(j - this.bytecode.currentPc() + 1);
            j = this.bytecode.currentPc();
            if (paramStmnt != null) {
                this.bytecode.write16bit(i, j - i + 1);
            }
            patchGoto(this.breakList, j);
            patchGoto(this.continueList, k);
            this.continueList = localArrayList2;
            this.breakList = localArrayList1;
            this.hasReturned = false;
            return;
            i = 0;
        }
    }

    private void atIfStmnt(Stmnt paramStmnt) {
        boolean bool2 = false;
        ASTree localASTree = paramStmnt.head();
        Stmnt localStmnt = (Stmnt) paramStmnt.tail().head();
        paramStmnt = (Stmnt) paramStmnt.tail().tail().head();
        compileBooleanExpr(false, localASTree);
        int j = this.bytecode.currentPc();
        this.bytecode.addIndex(0);
        this.hasReturned = false;
        if (localStmnt != null) {
            localStmnt.accept(this);
        }
        boolean bool3 = this.hasReturned;
        this.hasReturned = false;
        int i;
        if ((paramStmnt != null) && (!bool3)) {
            this.bytecode.addOpcode(167);
            i = this.bytecode.currentPc();
            this.bytecode.addIndex(0);
        }
        for (; ; ) {
            this.bytecode.write16bit(j, this.bytecode.currentPc() - j + 1);
            if (paramStmnt != null) {
                paramStmnt.accept(this);
                if (!bool3) {
                    this.bytecode.write16bit(i, this.bytecode.currentPc() - i + 1);
                }
                boolean bool1 = bool2;
                if (bool3) {
                    bool1 = bool2;
                    if (this.hasReturned) {
                        bool1 = true;
                    }
                }
                this.hasReturned = bool1;
            }
            return;
            i = 0;
        }
    }

    private void atPlusPlus(int paramInt, ASTree paramASTree, Expr paramExpr, boolean paramBoolean) {
        int i = 1;
        boolean bool;
        if (paramASTree == null) {
            bool = true;
            if (!bool) {
                break label589;
            }
            paramASTree = paramExpr.oprand2();
        }
        label132:
        label507:
        label535:
        label537:
        label589:
        for (; ; ) {
            if ((paramASTree instanceof Variable)) {
                paramASTree = ((Variable) paramASTree).getDeclarator();
                int k = paramASTree.getType();
                this.exprType = k;
                this.arrayDim = paramASTree.getArrayDim();
                int j = getLocalVar(paramASTree);
                if (this.arrayDim > 0) {
                    badType(paramExpr);
                }
                if (k == 312) {
                    this.bytecode.addDload(j);
                    if ((paramBoolean) && (bool)) {
                        this.bytecode.addOpcode(92);
                    }
                    this.bytecode.addDconst(1.0D);
                    paramASTree = this.bytecode;
                    if (paramInt == 362) {
                        paramInt = 99;
                        paramASTree.addOpcode(paramInt);
                        if ((paramBoolean) && (!bool)) {
                            this.bytecode.addOpcode(92);
                        }
                        this.bytecode.addDstore(j);
                    }
                }
                for (; ; ) {
                    return;
                    bool = false;
                    break;
                    paramInt = 103;
                    break label132;
                    if (k == 326) {
                        this.bytecode.addLload(j);
                        if ((paramBoolean) && (bool)) {
                            this.bytecode.addOpcode(92);
                        }
                        this.bytecode.addLconst(1L);
                        paramASTree = this.bytecode;
                        if (paramInt == 362) {
                        }
                        for (paramInt = 97; ; paramInt = 101) {
                            paramASTree.addOpcode(paramInt);
                            if ((paramBoolean) && (!bool)) {
                                this.bytecode.addOpcode(92);
                            }
                            this.bytecode.addLstore(j);
                            return;
                        }
                    }
                    if (k == 317) {
                        this.bytecode.addFload(j);
                        if ((paramBoolean) && (bool)) {
                            this.bytecode.addOpcode(89);
                        }
                        this.bytecode.addFconst(1.0F);
                        paramASTree = this.bytecode;
                        if (paramInt == 362) {
                        }
                        for (paramInt = 98; ; paramInt = 102) {
                            paramASTree.addOpcode(paramInt);
                            if ((paramBoolean) && (!bool)) {
                                this.bytecode.addOpcode(89);
                            }
                            this.bytecode.addFstore(j);
                            return;
                        }
                    }
                    if ((k != 303) && (k != 306) && (k != 334) && (k != 324)) {
                        break label537;
                    }
                    if ((paramBoolean) && (bool)) {
                        this.bytecode.addIload(j);
                    }
                    if (paramInt == 362) {
                        paramInt = i;
                        if (j <= 255) {
                            break label507;
                        }
                        this.bytecode.addOpcode(196);
                        this.bytecode.addOpcode(132);
                        this.bytecode.addIndex(j);
                        this.bytecode.addIndex(paramInt);
                    }
                    for (; ; ) {
                        if ((!paramBoolean) || (bool)) {
                            break label535;
                        }
                        this.bytecode.addIload(j);
                        return;
                        paramInt = -1;
                        break;
                        this.bytecode.addOpcode(132);
                        this.bytecode.add(j);
                        this.bytecode.add(paramInt);
                    }
                }
                badType(paramExpr);
                return;
            }
            if ((paramASTree instanceof Expr)) {
                Expr localExpr = (Expr) paramASTree;
                if (localExpr.getOperator() == 65) {
                    atArrayPlusPlus(paramInt, bool, localExpr, paramBoolean);
                    return;
                }
            }
            atFieldPlusPlus(paramInt, bool, paramASTree, paramExpr, paramBoolean);
            return;
        }
    }

    private void atStringConcatExpr(Expr paramExpr, int paramInt1, int paramInt2, String paramString) {
        int j = this.exprType;
        int k = this.arrayDim;
        boolean bool = is2word(j, k);
        int i;
        if ((j == 307) && ("java/lang/String".equals(this.className))) {
            i = 1;
            if (bool) {
                convToString(j, k);
            }
            if (!is2word(paramInt1, paramInt2)) {
                break label156;
            }
            this.bytecode.addOpcode(91);
            this.bytecode.addOpcode(87);
        }
        for (; ; ) {
            convToString(paramInt1, paramInt2);
            this.bytecode.addOpcode(95);
            if ((!bool) && (i == 0)) {
                convToString(j, k);
            }
            this.bytecode.addInvokevirtual("java.lang.String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/String";
            return;
            i = 0;
            break;
            label156:
            this.bytecode.addOpcode(95);
        }
    }

    private void atStringPlusEq(Expr paramExpr, int paramInt1, int paramInt2, String paramString, ASTree paramASTree) {
        if (!"java/lang/String".equals(paramString)) {
            badAssign(paramExpr);
        }
        convToString(paramInt1, paramInt2);
        paramASTree.accept(this);
        convToString(this.exprType, this.arrayDim);
        this.bytecode.addInvokevirtual("java.lang.String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/String";
    }

    private void atSwitchStmnt(Stmnt paramStmnt) {
        compileExpr(paramStmnt.head());
        ArrayList localArrayList = this.breakList;
        this.breakList = new ArrayList();
        int n = this.bytecode.currentPc();
        this.bytecode.addOpcode(171);
        int i = 3 - (n & 0x3);
        while (i > 0) {
            this.bytecode.add(0);
            i -= 1;
        }
        paramStmnt = (Stmnt) paramStmnt.tail();
        i = 0;
        Object localObject = paramStmnt;
        if (localObject != null) {
            if (((Stmnt) ((ASTList) localObject).head()).getOperator() != 304) {
                break label422;
            }
            i += 1;
        }
        label422:
        for (; ; ) {
            localObject = ((ASTList) localObject).tail();
            break;
            int i1 = this.bytecode.currentPc();
            this.bytecode.addGap(4);
            this.bytecode.add32bit(i);
            this.bytecode.addGap(i * 8);
            localObject = new long[i];
            int k = 0;
            int j = -1;
            if (paramStmnt != null) {
                Stmnt localStmnt = (Stmnt) paramStmnt.head();
                m = localStmnt.getOperator();
                if (m == 310) {
                    j = this.bytecode.currentPc();
                }
                for (; ; ) {
                    this.hasReturned = false;
                    ((Stmnt) localStmnt.tail()).accept(this);
                    paramStmnt = paramStmnt.tail();
                    break;
                    if (m != 304) {
                        fatal();
                    } else {
                        localObject[k] = ((computeLabel(localStmnt.head()) << 32) + (this.bytecode.currentPc() - n & 0xFFFFFFFFFFFFFFFF));
                        k += 1;
                    }
                }
            }
            Arrays.sort((long[]) localObject);
            int m = i1 + 8;
            k = 0;
            while (k < i) {
                this.bytecode.write32bit(m, (int) (localObject[k] >>> 32));
                this.bytecode.write32bit(m + 4, (int) localObject[k]);
                m += 8;
                k += 1;
            }
            if ((j < 0) || (this.breakList.size() > 0)) {
                this.hasReturned = false;
            }
            k = this.bytecode.currentPc();
            i = j;
            if (j < 0) {
                i = k;
            }
            this.bytecode.write32bit(i1, i - n);
            patchGoto(this.breakList, k);
            this.breakList = localArrayList;
            return;
        }
    }

    private void atSyncStmnt(Stmnt paramStmnt) {
        int j = getListSize(this.breakList);
        int k = getListSize(this.continueList);
        compileExpr(paramStmnt.head());
        if ((this.exprType != 307) && (this.arrayDim == 0)) {
            throw new CompileError("bad type expr for synchronized block");
        }
        Bytecode localBytecode = this.bytecode;
        int i = localBytecode.getMaxLocals();
        localBytecode.incMaxLocals(1);
        localBytecode.addOpcode(89);
        localBytecode.addAstore(i);
        localBytecode.addOpcode(194);
        CodeGen .1 local1 = new CodeGen .1 (this, this, i);
        int m = localBytecode.currentPc();
        paramStmnt = (Stmnt) paramStmnt.tail();
        if (paramStmnt != null) {
            paramStmnt.accept(this);
        }
        int n = localBytecode.currentPc();
        if (!this.hasReturned) {
            local1.doit(localBytecode, 0);
            localBytecode.addOpcode(167);
            i = localBytecode.currentPc();
            localBytecode.addIndex(0);
        }
        for (; ; ) {
            if (m < n) {
                int i1 = localBytecode.currentPc();
                local1.doit(localBytecode, 0);
                localBytecode.addOpcode(191);
                localBytecode.addExceptionHandler(m, n, i1, 0);
            }
            if (!this.hasReturned) {
                localBytecode.write16bit(i, localBytecode.currentPc() - i + 1);
            }
            local1.remove(this);
            if ((getListSize(this.breakList) != j) || (getListSize(this.continueList) != k)) {
                throw new CompileError("sorry, cannot break/continue in synchronized block");
            }
            return;
            i = 0;
        }
    }

    private void atThrowStmnt(Stmnt paramStmnt) {
        compileExpr(paramStmnt.getLeft());
        if ((this.exprType != 307) || (this.arrayDim > 0)) {
            throw new CompileError("bad throw statement");
        }
        this.bytecode.addOpcode(191);
        this.hasReturned = true;
    }

    private void atVariableAssign(Expr paramExpr, int paramInt, Variable paramVariable, Declarator paramDeclarator, ASTree paramASTree, boolean paramBoolean) {
        int i = paramDeclarator.getType();
        int j = paramDeclarator.getArrayDim();
        String str = paramDeclarator.getClassName();
        int k = getLocalVar(paramDeclarator);
        if (paramInt != 61) {
            atVariable(paramVariable);
        }
        if ((paramExpr == null) && ((paramASTree instanceof ArrayInit))) {
            atArrayVariableAssign((ArrayInit) paramASTree, i, j, str);
            if (paramBoolean) {
                if (!is2word(i, j)) {
                    break label141;
                }
                this.bytecode.addOpcode(92);
            }
            label91:
            if (j <= 0) {
                break label153;
            }
            this.bytecode.addAstore(k);
        }
        for (; ; ) {
            this.exprType = i;
            this.arrayDim = j;
            this.className = str;
            return;
            atAssignCore(paramExpr, paramInt, paramASTree, i, j, str);
            break;
            label141:
            this.bytecode.addOpcode(89);
            break label91;
            label153:
            if (i == 312) {
                this.bytecode.addDstore(k);
            } else if (i == 317) {
                this.bytecode.addFstore(k);
            } else if (i == 326) {
                this.bytecode.addLstore(k);
            } else if (isRefType(i)) {
                this.bytecode.addAstore(k);
            } else {
                this.bytecode.addIstore(k);
            }
        }
    }

    private void atWhileStmnt(Stmnt paramStmnt, boolean paramBoolean) {
        ArrayList localArrayList1 = this.breakList;
        ArrayList localArrayList2 = this.continueList;
        this.breakList = new ArrayList();
        this.continueList = new ArrayList();
        ASTree localASTree = paramStmnt.head();
        paramStmnt = (Stmnt) paramStmnt.tail();
        int i;
        if (paramBoolean) {
            this.bytecode.addOpcode(167);
            i = this.bytecode.currentPc();
            this.bytecode.addIndex(0);
        }
        for (; ; ) {
            int j = this.bytecode.currentPc();
            if (paramStmnt != null) {
                paramStmnt.accept(this);
            }
            int k = this.bytecode.currentPc();
            if (paramBoolean) {
                this.bytecode.write16bit(i, k - i + 1);
            }
            paramBoolean = compileBooleanExpr(true, localASTree);
            this.bytecode.addIndex(j - this.bytecode.currentPc() + 1);
            patchGoto(this.breakList, this.bytecode.currentPc());
            patchGoto(this.continueList, k);
            this.continueList = localArrayList2;
            this.breakList = localArrayList1;
            this.hasReturned = paramBoolean;
            return;
            i = 0;
        }
    }

    protected static void badAssign(Expr paramExpr) {
        if (paramExpr == null) {
        }
        for (paramExpr = "incompatible type for assignment"; ; paramExpr = "incompatible type for " + paramExpr.getName()) {
            throw new CompileError(paramExpr);
        }
    }

    protected static void badType(Expr paramExpr) {
        throw new CompileError("invalid type for " + paramExpr.getName());
    }

    protected static void badTypes(Expr paramExpr) {
        throw new CompileError("invalid types for " + paramExpr.getName());
    }

    private boolean booleanExpr(boolean paramBoolean, ASTree paramASTree) {
        boolean bool2 = true;
        boolean bool1 = true;
        int i = getCompOperator(paramASTree);
        if (i == 358) {
            paramASTree = (BinExpr) paramASTree;
            i = compileOprands(paramASTree);
            compareExpr(paramBoolean, paramASTree.getOperator(), i, paramASTree);
            this.exprType = 301;
            this.arrayDim = 0;
            return false;
        }
        if (i == 33) {
            if (!paramBoolean) {
            }
            for (paramBoolean = bool1; ; paramBoolean = false) {
                booleanExpr(paramBoolean, ((Expr) paramASTree).oprand1());
                break;
            }
        }
        if (i == 369) {
            bool1 = true;
            label98:
            if ((!bool1) && (i != 368)) {
                break label217;
            }
            paramASTree = (BinExpr) paramASTree;
            if (bool1) {
                break label211;
            }
        }
        for (; ; ) {
            booleanExpr(bool2, paramASTree.oprand1());
            i = this.bytecode.currentPc();
            this.bytecode.addIndex(0);
            booleanExpr(bool1, paramASTree.oprand2());
            this.bytecode.write16bit(i, this.bytecode.currentPc() - i + 3);
            if (paramBoolean == bool1) {
                break;
            }
            this.bytecode.addIndex(6);
            this.bytecode.addOpcode(167);
            break;
            bool1 = false;
            break label98;
            label211:
            bool2 = false;
        }
        label217:
        if (isAlwaysBranch(paramASTree, paramBoolean)) {
            this.bytecode.addOpcode(167);
            return true;
        }
        paramASTree.accept(this);
        if ((this.exprType != 301) || (this.arrayDim != 0)) {
            throw new CompileError("boolean expr is required");
        }
        paramASTree = this.bytecode;
        if (paramBoolean) {
        }
        for (i = 154; ; i = 153) {
            paramASTree.addOpcode(i);
            break;
        }
    }

    private String checkCastExpr(CastExpr paramCastExpr, String paramString) {
        ASTree localASTree = paramCastExpr.getOprand();
        int i = paramCastExpr.getArrayDim();
        int j = paramCastExpr.getType();
        localASTree.accept(this);
        int k = this.exprType;
        if ((invalidDim(k, this.arrayDim, this.className, j, i, paramString, true)) || (k == 344) || (j == 344)) {
            throw new CompileError("invalid cast");
        }
        if (j == 307) {
            if (!isRefType(k)) {
                throw new CompileError("invalid cast");
            }
            return toJvmArrayName(paramString, i);
        }
        if (i > 0) {
            return toJvmTypeName(j, i);
        }
        return null;
    }

    private void compareExpr(boolean paramBoolean, int paramInt1, int paramInt2, BinExpr paramBinExpr) {
        int i = 165;
        int k = 0;
        int j = 1;
        if (this.arrayDim == 0) {
            convertOprandTypes(paramInt2, this.exprType, paramBinExpr);
        }
        paramInt2 = typePrecedence(this.exprType);
        if ((paramInt2 == -1) || (this.arrayDim > 0)) {
            if (paramInt1 == 358) {
                paramBinExpr = this.bytecode;
                if (paramBoolean) {
                }
                for (; ; ) {
                    paramBinExpr.addOpcode(i);
                    return;
                    i = 166;
                }
            }
            if (paramInt1 == 350) {
                paramBinExpr = this.bytecode;
                if (paramBoolean) {
                    i = 166;
                }
                paramBinExpr.addOpcode(i);
                return;
            }
            badTypes(paramBinExpr);
            return;
        }
        int[] arrayOfInt;
        if (paramInt2 == 3) {
            arrayOfInt = ifOp;
            paramInt2 = 0;
            while (paramInt2 < arrayOfInt.length) {
                if (arrayOfInt[paramInt2] == paramInt1) {
                    paramBinExpr = this.bytecode;
                    if (paramBoolean) {
                    }
                    for (paramInt1 = 1; ; paramInt1 = 2) {
                        paramBinExpr.addOpcode(arrayOfInt[(paramInt2 + paramInt1)]);
                        return;
                    }
                }
                paramInt2 += 3;
            }
            badTypes(paramBinExpr);
            return;
        }
        if (paramInt2 == 0) {
            if ((paramInt1 == 60) || (paramInt1 == 357)) {
                this.bytecode.addOpcode(152);
                arrayOfInt = ifOp2;
                paramInt2 = k;
            }
        }
        for (; ; ) {
            if (paramInt2 >= arrayOfInt.length) {
                break label355;
            }
            if (arrayOfInt[paramInt2] == paramInt1) {
                paramBinExpr = this.bytecode;
                if (paramBoolean) {
                }
                for (paramInt1 = j; ; paramInt1 = 2) {
                    paramBinExpr.addOpcode(arrayOfInt[(paramInt2 + paramInt1)]);
                    return;
                    this.bytecode.addOpcode(151);
                    break;
                    if (paramInt2 == 1) {
                        if ((paramInt1 == 60) || (paramInt1 == 357)) {
                            this.bytecode.addOpcode(150);
                            break;
                        }
                        this.bytecode.addOpcode(149);
                        break;
                    }
                    if (paramInt2 == 2) {
                        this.bytecode.addOpcode(148);
                        break;
                    }
                    fatal();
                    break;
                }
            }
            paramInt2 += 3;
        }
        label355:
        badTypes(paramBinExpr);
    }

    private int compileOprands(BinExpr paramBinExpr) {
        paramBinExpr.oprand1().accept(this);
        int j = this.exprType;
        int i = this.arrayDim;
        paramBinExpr.oprand2().accept(this);
        if (i != this.arrayDim) {
            if ((j != 412) && (this.exprType != 412)) {
                throw new CompileError("incompatible array types");
            }
            if (this.exprType == 412) {
                this.arrayDim = i;
            }
        }
        i = j;
        if (j == 412) {
            i = this.exprType;
        }
        return i;
    }

    private int computeLabel(ASTree paramASTree) {
        doTypeCheck(paramASTree);
        paramASTree = TypeChecker.stripPlusExpr(paramASTree);
        if ((paramASTree instanceof IntConst)) {
            return (int) ((IntConst) paramASTree).get();
        }
        throw new CompileError("bad case label");
    }

    private void convToString(int paramInt1, int paramInt2) {
        if ((isRefType(paramInt1)) || (paramInt2 > 0)) {
            this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(Ljava/lang/Object;)Ljava/lang/String;");
            return;
        }
        if (paramInt1 == 312) {
            this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(D)Ljava/lang/String;");
            return;
        }
        if (paramInt1 == 317) {
            this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(F)Ljava/lang/String;");
            return;
        }
        if (paramInt1 == 326) {
            this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(J)Ljava/lang/String;");
            return;
        }
        if (paramInt1 == 301) {
            this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(Z)Ljava/lang/String;");
            return;
        }
        if (paramInt1 == 306) {
            this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(C)Ljava/lang/String;");
            return;
        }
        if (paramInt1 == 344) {
            throw new CompileError("void type expression");
        }
        this.bytecode.addInvokestatic("java.lang.String", "valueOf", "(I)Ljava/lang/String;");
    }

    private void convertOprandTypes(int paramInt1, int paramInt2, Expr paramExpr) {
        int j = typePrecedence(paramInt1);
        paramInt2 = typePrecedence(paramInt2);
        if ((paramInt2 < 0) && (j < 0)) {
        }
        label155:
        label167:
        do {
            return;
            if ((paramInt2 < 0) || (j < 0)) {
                badTypes(paramExpr);
            }
            int i;
            if (j <= paramInt2) {
                this.exprType = paramInt1;
                paramInt2 = castOp[(paramInt2 * 4 + j)];
                i = 0;
                paramInt1 = j;
                if (i == 0) {
                    continue;
                }
                if ((paramInt1 != 0) && (paramInt1 != 2)) {
                    break label167;
                }
                if ((j != 0) && (j != 2)) {
                    break label155;
                }
                this.bytecode.addOpcode(94);
            }
            for (; ; ) {
                this.bytecode.addOpcode(88);
                this.bytecode.addOpcode(paramInt2);
                this.bytecode.addOpcode(94);
                this.bytecode.addOpcode(88);
                return;
                int k = castOp[(j * 4 + paramInt2)];
                i = 1;
                paramInt1 = paramInt2;
                paramInt2 = k;
                break;
                this.bytecode.addOpcode(93);
            }
            if (paramInt1 == 1) {
                if (j == 2) {
                    this.bytecode.addOpcode(91);
                    this.bytecode.addOpcode(87);
                }
                for (; ; ) {
                    this.bytecode.addOpcode(paramInt2);
                    this.bytecode.addOpcode(95);
                    return;
                    this.bytecode.addOpcode(95);
                }
            }
            fatal();
            return;
        } while (paramInt2 == 0);
        this.bytecode.addOpcode(paramInt2);
    }

    protected static void fatal() {
        throw new CompileError("fatal");
    }

    protected static int getArrayReadOp(int paramInt1, int paramInt2) {
        if (paramInt2 > 0) {
            return 50;
        }
        switch (paramInt1) {
            default:
                return 50;
            case 301:
            case 303:
                return 51;
            case 312:
                return 49;
            case 317:
                return 48;
            case 326:
                return 47;
            case 324:
                return 46;
            case 334:
                return 53;
        }
        return 52;
    }

    protected static int getArrayWriteOp(int paramInt1, int paramInt2) {
        if (paramInt2 > 0) {
            return 83;
        }
        switch (paramInt1) {
            default:
                return 83;
            case 301:
            case 303:
                return 84;
            case 312:
                return 82;
            case 317:
                return 81;
            case 326:
                return 80;
            case 324:
                return 79;
            case 334:
                return 86;
        }
        return 85;
    }

    static int getCompOperator(ASTree paramASTree) {
        if ((paramASTree instanceof Expr)) {
            paramASTree = (Expr) paramASTree;
            int i = paramASTree.getOperator();
            if (i == 33) {
                return 33;
            }
            if (((paramASTree instanceof BinExpr)) && (i != 368) && (i != 369) && (i != 38) && (i != 124)) {
                return 358;
            }
            return i;
        }
        return 32;
    }

    private static int getListSize(ArrayList paramArrayList) {
        if (paramArrayList == null) {
            return 0;
        }
        return paramArrayList.size();
    }

    private boolean invalidDim(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, boolean paramBoolean) {
        if ((paramInt2 == paramInt4) || (paramInt1 == 412)) {
        }
        while (((paramInt4 == 0) && (paramInt3 == 307) && ("java/lang/Object".equals(paramString2))) || ((paramBoolean) && (paramInt2 == 0) && (paramInt1 == 307) && ("java/lang/Object".equals(paramString1)))) {
            return false;
        }
        return true;
    }

    public static boolean is2word(int paramInt1, int paramInt2) {
        return (paramInt2 == 0) && ((paramInt1 == 312) || (paramInt1 == 326));
    }

    private static boolean isAlwaysBranch(ASTree paramASTree, boolean paramBoolean) {
        if ((paramASTree instanceof Keyword)) {
            int i = ((Keyword) paramASTree).get();
            if (paramBoolean) {
                if (i != 410) {
                }
            }
            while (i == 411) {
                return true;
                return false;
            }
            return false;
        }
        return false;
    }

    static boolean isP_INT(int paramInt) {
        return typePrecedence(paramInt) == 3;
    }

    private static boolean isPlusPlusExpr(ASTree paramASTree) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramASTree instanceof Expr)) {
            int i = ((Expr) paramASTree).getOperator();
            if (i != 362) {
                bool1 = bool2;
                if (i != 363) {
                }
            } else {
                bool1 = true;
            }
        }
        return bool1;
    }

    protected static boolean isRefType(int paramInt) {
        return (paramInt == 307) || (paramInt == 412);
    }

    static int lookupBinOp(int paramInt) {
        int[] arrayOfInt = binOp;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j) {
            if (arrayOfInt[i] == paramInt) {
                return i;
            }
            i += 5;
        }
        return -1;
    }

    private boolean needsSuperCall(Stmnt paramStmnt) {
        if (paramStmnt.getOperator() == 66) {
            paramStmnt = (Stmnt) paramStmnt.head();
        }
        for (; ; ) {
            if ((paramStmnt != null) && (paramStmnt.getOperator() == 69)) {
                paramStmnt = paramStmnt.head();
                if ((paramStmnt != null) && ((paramStmnt instanceof Expr)) && (((Expr) paramStmnt).getOperator() == 67)) {
                    paramStmnt = ((Expr) paramStmnt).head();
                    if ((paramStmnt instanceof Keyword)) {
                        int i = ((Keyword) paramStmnt).get();
                        return (i != 339) && (i != 336);
                    }
                }
            }
            return true;
        }
    }

    static boolean rightIsStrong(int paramInt1, int paramInt2) {
        paramInt1 = typePrecedence(paramInt1);
        paramInt2 = typePrecedence(paramInt2);
        return (paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 > paramInt2);
    }

    protected static String toJvmArrayName(String paramString, int paramInt) {
        if (paramString == null) {
            localObject = null;
        }
        do {
            return (String) localObject;
            localObject = paramString;
        } while (paramInt == 0);
        Object localObject = new StringBuffer();
        while (paramInt > 0) {
            ((StringBuffer) localObject).append('[');
            paramInt -= 1;
        }
        ((StringBuffer) localObject).append('L');
        ((StringBuffer) localObject).append(paramString);
        ((StringBuffer) localObject).append(';');
        return ((StringBuffer) localObject).toString();
    }

    protected static String toJvmTypeName(int paramInt1, int paramInt2) {
        char c2 = 'I';
        char c1 = c2;
        switch (paramInt1) {
            default:
                c1 = c2;
        }
        StringBuffer localStringBuffer;
        for (; ; ) {
            localStringBuffer = new StringBuffer();
            while (paramInt2 > 0) {
                localStringBuffer.append('[');
                paramInt2 -= 1;
            }
            c1 = 'Z';
            continue;
            c1 = 'B';
            continue;
            c1 = 'C';
            continue;
            c1 = 'S';
            continue;
            c1 = 'J';
            continue;
            c1 = 'F';
            continue;
            c1 = 'D';
            continue;
            c1 = 'V';
        }
        localStringBuffer.append(c1);
        return localStringBuffer.toString();
    }

    private static int typePrecedence(int paramInt) {
        int j = -1;
        int i;
        if (paramInt == 312) {
            i = 0;
        }
        do {
            do {
                return i;
                if (paramInt == 317) {
                    return 1;
                }
                if (paramInt == 326) {
                    return 2;
                }
                i = j;
            } while (isRefType(paramInt));
            i = j;
        } while (paramInt == 344);
        return 3;
    }

    protected void arrayAccess(ASTree paramASTree1, ASTree paramASTree2) {
        paramASTree1.accept(this);
        int i = this.exprType;
        int j = this.arrayDim;
        if (j == 0) {
            throw new CompileError("bad array access");
        }
        paramASTree1 = this.className;
        paramASTree2.accept(this);
        if ((typePrecedence(this.exprType) != 3) || (this.arrayDim > 0)) {
            throw new CompileError("bad array index");
        }
        this.exprType = i;
        this.arrayDim = (j - 1);
        this.className = paramASTree1;
    }

    public void atASTList(ASTList paramASTList) {
    }

    public abstract void atArrayInit(ArrayInit paramArrayInit);

    public void atArrayPlusPlus(int paramInt, boolean paramBoolean1, Expr paramExpr, boolean paramBoolean2) {
        arrayAccess(paramExpr.oprand1(), paramExpr.oprand2());
        int j = this.exprType;
        int k = this.arrayDim;
        if (k > 0) {
            badType(paramExpr);
        }
        this.bytecode.addOpcode(92);
        this.bytecode.addOpcode(getArrayReadOp(j, this.arrayDim));
        if (is2word(j, k)) {
        }
        for (int i = 94; ; i = 91) {
            atPlusPlusCore(i, paramBoolean2, paramInt, paramBoolean1, paramExpr);
            this.bytecode.addOpcode(getArrayWriteOp(j, k));
            return;
        }
    }

    public void atArrayRead(ASTree paramASTree1, ASTree paramASTree2) {
        arrayAccess(paramASTree1, paramASTree2);
        this.bytecode.addOpcode(getArrayReadOp(this.exprType, this.arrayDim));
    }

    protected abstract void atArrayVariableAssign(ArrayInit paramArrayInit, int paramInt1, int paramInt2, String paramString);

    protected void atAssignCore(Expr paramExpr, int paramInt1, ASTree paramASTree, int paramInt2, int paramInt3, String paramString) {
        if ((paramInt1 == 354) && (paramInt3 == 0) && (paramInt2 == 307)) {
            atStringPlusEq(paramExpr, paramInt2, paramInt3, paramString, paramASTree);
        }
        for (; ; ) {
            if ((paramInt1 != 61) || ((paramInt3 == 0) && (!isRefType(paramInt2)))) {
                atNumCastExpr(this.exprType, paramInt2);
            }
            return;
            paramASTree.accept(this);
            if ((invalidDim(this.exprType, this.arrayDim, this.className, paramInt2, paramInt3, paramString, false)) || ((paramInt1 != 61) && (paramInt3 > 0))) {
                badAssign(paramExpr);
            }
            if (paramInt1 != 61) {
                int i = assignOps[(paramInt1 - 351)];
                int j = lookupBinOp(i);
                if (j < 0) {
                    fatal();
                }
                atArithBinExpr(paramExpr, i, j, paramInt2);
            }
        }
    }

    public void atAssignExpr(AssignExpr paramAssignExpr) {
        atAssignExpr(paramAssignExpr, true);
    }

    protected void atAssignExpr(AssignExpr paramAssignExpr, boolean paramBoolean) {
        int i = paramAssignExpr.getOperator();
        ASTree localASTree1 = paramAssignExpr.oprand1();
        ASTree localASTree2 = paramAssignExpr.oprand2();
        if ((localASTree1 instanceof Variable)) {
            atVariableAssign(paramAssignExpr, i, (Variable) localASTree1, ((Variable) localASTree1).getDeclarator(), localASTree2, paramBoolean);
            return;
        }
        if (((localASTree1 instanceof Expr)) && (((Expr) localASTree1).getOperator() == 65)) {
            atArrayAssign(paramAssignExpr, i, (Expr) localASTree1, localASTree2, paramBoolean);
            return;
        }
        atFieldAssign(paramAssignExpr, i, localASTree1, localASTree2, paramBoolean);
    }

    public void atBinExpr(BinExpr paramBinExpr) {
        int i = paramBinExpr.getOperator();
        int j = lookupBinOp(i);
        if (j >= 0) {
            paramBinExpr.oprand1().accept(this);
            ASTree localASTree = paramBinExpr.oprand2();
            if (localASTree == null) {
                return;
            }
            int k = this.exprType;
            int m = this.arrayDim;
            String str = this.className;
            localASTree.accept(this);
            if (m != this.arrayDim) {
                throw new CompileError("incompatible array types");
            }
            if ((i == 43) && (m == 0) && ((k == 307) || (this.exprType == 307))) {
                atStringConcatExpr(paramBinExpr, k, m, str);
                return;
            }
            atArithBinExpr(paramBinExpr, i, j, k);
            return;
        }
        booleanExpr(true, paramBinExpr);
        this.bytecode.addIndex(7);
        this.bytecode.addIconst(0);
        this.bytecode.addOpcode(167);
        this.bytecode.addIndex(4);
        this.bytecode.addIconst(1);
    }

    public abstract void atCallExpr(CallExpr paramCallExpr);

    public void atCastExpr(CastExpr paramCastExpr) {
        String str1 = resolveClassName(paramCastExpr.getClassName());
        String str2 = checkCastExpr(paramCastExpr, str1);
        int i = this.exprType;
        this.exprType = paramCastExpr.getType();
        this.arrayDim = paramCastExpr.getArrayDim();
        this.className = str1;
        if (str2 == null) {
            atNumCastExpr(i, this.exprType);
            return;
        }
        this.bytecode.addCheckcast(str2);
    }

    public void atClassObject(Expr paramExpr) {
        paramExpr = paramExpr.oprand1();
        if (!(paramExpr instanceof Symbol)) {
            throw new CompileError("fatal error: badly parsed .class expr");
        }
        Object localObject = ((Symbol) paramExpr).get();
        if (((String) localObject).startsWith("[")) {
            int i = ((String) localObject).indexOf("[L");
            paramExpr = (Expr) localObject;
            if (i >= 0) {
                String str1 = ((String) localObject).substring(i + 2, ((String) localObject).length() - 1);
                String str2 = resolveClassName(str1);
                paramExpr = (Expr) localObject;
                if (!str1.equals(str2)) {
                    paramExpr = MemberResolver.jvmToJavaName(str2);
                    localObject = new StringBuffer();
                    while (i >= 0) {
                        ((StringBuffer) localObject).append('[');
                        i -= 1;
                    }
                    ((StringBuffer) localObject).append('L').append(paramExpr).append(';');
                }
            }
        }
        for (paramExpr = ((StringBuffer) localObject).toString(); ; paramExpr = MemberResolver.jvmToJavaName(resolveClassName(MemberResolver.javaToJvmName((String) localObject)))) {
            atClassObject2(paramExpr);
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/Class";
            return;
        }
    }

    protected void atClassObject2(String paramString) {
        int i = this.bytecode.currentPc();
        this.bytecode.addLdc(paramString);
        this.bytecode.addInvokestatic("java.lang.Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
        int j = this.bytecode.currentPc();
        this.bytecode.addOpcode(167);
        int k = this.bytecode.currentPc();
        this.bytecode.addIndex(0);
        this.bytecode.addExceptionHandler(i, j, this.bytecode.currentPc(), "java.lang.ClassNotFoundException");
        this.bytecode.growStack(1);
        this.bytecode.addInvokestatic("javassist.runtime.DotClass", "fail", "(Ljava/lang/ClassNotFoundException;)Ljava/lang/NoClassDefFoundError;");
        this.bytecode.addOpcode(191);
        this.bytecode.write16bit(k, this.bytecode.currentPc() - k + 1);
    }

    public void atCondExpr(CondExpr paramCondExpr) {
        booleanExpr(false, paramCondExpr.condExpr());
        int i = this.bytecode.currentPc();
        this.bytecode.addIndex(0);
        paramCondExpr.thenExpr().accept(this);
        int j = this.arrayDim;
        this.bytecode.addOpcode(167);
        int k = this.bytecode.currentPc();
        this.bytecode.addIndex(0);
        this.bytecode.write16bit(i, this.bytecode.currentPc() - i + 1);
        paramCondExpr.elseExpr().accept(this);
        if (j != this.arrayDim) {
            throw new CompileError("type mismatch in ?:");
        }
        this.bytecode.write16bit(k, this.bytecode.currentPc() - k + 1);
    }

    public void atDeclarator(Declarator paramDeclarator) {
        paramDeclarator.setLocalVar(getMaxLocals());
        paramDeclarator.setClassName(resolveClassName(paramDeclarator.getClassName()));
        if (is2word(paramDeclarator.getType(), paramDeclarator.getArrayDim())) {
        }
        for (int i = 2; ; i = 1) {
            incMaxLocals(i);
            ASTree localASTree = paramDeclarator.getInitializer();
            if (localASTree != null) {
                doTypeCheck(localASTree);
                atVariableAssign(null, 61, null, paramDeclarator, localASTree, false);
            }
            return;
        }
    }

    public void atDoubleConst(DoubleConst paramDoubleConst) {
        this.arrayDim = 0;
        if (paramDoubleConst.getType() == 405) {
            this.exprType = 312;
            this.bytecode.addDconst(paramDoubleConst.get());
            return;
        }
        this.exprType = 317;
        this.bytecode.addFconst((float) paramDoubleConst.get());
    }

    public void atExpr(Expr paramExpr) {
        int i = paramExpr.getOperator();
        ASTree localASTree = paramExpr.oprand1();
        if (i == 46) {
            if (((Symbol) paramExpr.oprand2()).get().equals("class")) {
                atClassObject(paramExpr);
            }
        }
        int j;
        do {
            return;
            atFieldRead(paramExpr);
            return;
            if (i == 35) {
                atFieldRead(paramExpr);
                return;
            }
            if (i == 65) {
                atArrayRead(localASTree, paramExpr.oprand2());
                return;
            }
            if ((i == 362) || (i == 363)) {
                atPlusPlus(i, localASTree, paramExpr, true);
                return;
            }
            if (i == 33) {
                booleanExpr(false, paramExpr);
                this.bytecode.addIndex(7);
                this.bytecode.addIconst(1);
                this.bytecode.addOpcode(167);
                this.bytecode.addIndex(4);
                this.bytecode.addIconst(0);
                return;
            }
            if (i == 67) {
                fatal();
                return;
            }
            paramExpr.oprand1().accept(this);
            j = typePrecedence(this.exprType);
            if (this.arrayDim > 0) {
                badType(paramExpr);
            }
            if (i == 45) {
                if (j == 0) {
                    this.bytecode.addOpcode(119);
                    return;
                }
                if (j == 1) {
                    this.bytecode.addOpcode(118);
                    return;
                }
                if (j == 2) {
                    this.bytecode.addOpcode(117);
                    return;
                }
                if (j == 3) {
                    this.bytecode.addOpcode(116);
                    this.exprType = 324;
                    return;
                }
                badType(paramExpr);
                return;
            }
            if (i == 126) {
                if (j == 3) {
                    this.bytecode.addIconst(-1);
                    this.bytecode.addOpcode(130);
                    this.exprType = 324;
                    return;
                }
                if (j == 2) {
                    this.bytecode.addLconst(-1L);
                    this.bytecode.addOpcode(131);
                    return;
                }
                badType(paramExpr);
                return;
            }
            if (i != 43) {
                break;
            }
        } while (j != -1);
        badType(paramExpr);
        return;
        fatal();
    }

    protected abstract void atFieldAssign(Expr paramExpr, int paramInt, ASTree paramASTree1, ASTree paramASTree2, boolean paramBoolean);

    public void atFieldDecl(FieldDecl paramFieldDecl) {
        paramFieldDecl.getInit().accept(this);
    }

    protected abstract void atFieldPlusPlus(int paramInt, boolean paramBoolean1, ASTree paramASTree, Expr paramExpr, boolean paramBoolean2);

    protected abstract void atFieldRead(ASTree paramASTree);

    public void atInstanceOfExpr(InstanceOfExpr paramInstanceOfExpr) {
        paramInstanceOfExpr = checkCastExpr(paramInstanceOfExpr, resolveClassName(paramInstanceOfExpr.getClassName()));
        this.bytecode.addInstanceof(paramInstanceOfExpr);
        this.exprType = 301;
        this.arrayDim = 0;
    }

    public void atIntConst(IntConst paramIntConst) {
        this.arrayDim = 0;
        long l = paramIntConst.get();
        int i = paramIntConst.getType();
        if ((i == 402) || (i == 401)) {
            if (i == 402) {
            }
            for (i = 324; ; i = 306) {
                this.exprType = i;
                this.bytecode.addIconst((int) l);
                return;
            }
        }
        this.exprType = 326;
        this.bytecode.addLconst(l);
    }

    public void atKeyword(Keyword paramKeyword) {
        this.arrayDim = 0;
        int i = paramKeyword.get();
        switch (i) {
            default:
                fatal();
                return;
            case 410:
                this.bytecode.addIconst(1);
                this.exprType = 301;
                return;
            case 411:
                this.bytecode.addIconst(0);
                this.exprType = 301;
                return;
            case 412:
                this.bytecode.addOpcode(1);
                this.exprType = 412;
                return;
        }
        if (this.inStaticMethod) {
            StringBuilder localStringBuilder = new StringBuilder().append("not-available: ");
            if (i == 339) {
            }
            for (paramKeyword = "this"; ; paramKeyword = "super") {
                throw new CompileError(paramKeyword);
            }
        }
        this.bytecode.addAload(0);
        this.exprType = 307;
        if (i == 339) {
            this.className = getThisName();
            return;
        }
        this.className = getSuperName();
    }

    public abstract void atMember(Member paramMember);

    public void atMethodBody(Stmnt paramStmnt, boolean paramBoolean1, boolean paramBoolean2) {
        if (paramStmnt == null) {
        }
        do {
            return;
            if ((paramBoolean1) && (needsSuperCall(paramStmnt))) {
                insertDefaultSuperCall();
            }
            this.hasReturned = false;
            paramStmnt.accept(this);
        } while (this.hasReturned);
        if (paramBoolean2) {
            this.bytecode.addOpcode(177);
            this.hasReturned = true;
            return;
        }
        throw new CompileError("no return statement");
    }

    public void atMethodDecl(MethodDecl paramMethodDecl) {
        Object localObject = paramMethodDecl.getModifiers();
        setMaxLocals(1);
        while (localObject != null) {
            Keyword localKeyword = (Keyword) ((ASTList) localObject).head();
            ASTList localASTList = ((ASTList) localObject).tail();
            localObject = localASTList;
            if (localKeyword.get() == 335) {
                setMaxLocals(0);
                this.inStaticMethod = true;
                localObject = localASTList;
            }
        }
        for (localObject = paramMethodDecl.getParams(); localObject != null; localObject = ((ASTList) localObject).tail()) {
            atDeclarator((Declarator) ((ASTList) localObject).head());
        }
        localObject = paramMethodDecl.getBody();
        boolean bool2 = paramMethodDecl.isConstructor();
        if (paramMethodDecl.getReturn().getType() == 344) {
        }
        for (boolean bool1 = true; ; bool1 = false) {
            atMethodBody((Stmnt) localObject, bool2, bool1);
            return;
        }
    }

    public abstract void atNewExpr(NewExpr paramNewExpr);

    void atNumCastExpr(int paramInt1, int paramInt2) {
        int j = 0;
        if (paramInt1 == paramInt2) {
            return;
        }
        paramInt1 = typePrecedence(paramInt1);
        int i = typePrecedence(paramInt2);
        if ((paramInt1 >= 0) && (paramInt1 < 3)) {
            i = castOp[(paramInt1 * 4 + i)];
            label38:
            if (paramInt2 != 312) {
                break label104;
            }
            paramInt1 = 135;
        }
        for (; ; ) {
            if (i != 0) {
                this.bytecode.addOpcode(i);
            }
            if (((i != 0) && (i != 136) && (i != 139) && (i != 142)) || (paramInt1 == 0)) {
                break;
            }
            this.bytecode.addOpcode(paramInt1);
            return;
            i = 0;
            break label38;
            label104:
            if (paramInt2 == 317) {
                paramInt1 = 134;
            } else if (paramInt2 == 326) {
                paramInt1 = 133;
            } else if (paramInt2 == 334) {
                paramInt1 = 147;
            } else if (paramInt2 == 306) {
                paramInt1 = 146;
            } else {
                paramInt1 = j;
                if (paramInt2 == 303) {
                    paramInt1 = 145;
                }
            }
        }
    }

    public void atPair(Pair paramPair) {
    }

    protected void atPlusPlusCore(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, Expr paramExpr) {
        int i = this.exprType;
        if ((paramBoolean1) && (paramBoolean2)) {
            this.bytecode.addOpcode(paramInt1);
        }
        if ((i == 324) || (i == 303) || (i == 306) || (i == 334)) {
            this.bytecode.addIconst(1);
            paramExpr = this.bytecode;
            if (paramInt2 == 362) {
                paramInt2 = 96;
                paramExpr.addOpcode(paramInt2);
                this.exprType = 324;
            }
        }
        for (; ; ) {
            if ((paramBoolean1) && (!paramBoolean2)) {
                this.bytecode.addOpcode(paramInt1);
            }
            return;
            paramInt2 = 100;
            break;
            if (i == 326) {
                this.bytecode.addLconst(1L);
                paramExpr = this.bytecode;
                if (paramInt2 == 362) {
                }
                for (paramInt2 = 97; ; paramInt2 = 101) {
                    paramExpr.addOpcode(paramInt2);
                    break;
                }
            }
            if (i == 317) {
                this.bytecode.addFconst(1.0F);
                paramExpr = this.bytecode;
                if (paramInt2 == 362) {
                }
                for (paramInt2 = 98; ; paramInt2 = 102) {
                    paramExpr.addOpcode(paramInt2);
                    break;
                }
            }
            if (i == 312) {
                this.bytecode.addDconst(1.0D);
                paramExpr = this.bytecode;
                if (paramInt2 == 362) {
                }
                for (paramInt2 = 99; ; paramInt2 = 103) {
                    paramExpr.addOpcode(paramInt2);
                    break;
                }
            }
            badType(paramExpr);
        }
    }

    protected void atReturnStmnt(Stmnt paramStmnt) {
        atReturnStmnt2(paramStmnt.getLeft());
    }

    protected final void atReturnStmnt2(ASTree paramASTree) {
        int j = 176;
        int i;
        if (paramASTree == null) {
            i = 177;
        }
        for (paramASTree = this.returnHooks; ; paramASTree = paramASTree.next) {
            if (paramASTree == null) {
                break label129;
            }
            if (paramASTree.doit(this.bytecode, i)) {
                this.hasReturned = true;
                return;
                compileExpr(paramASTree);
                i = j;
                if (this.arrayDim > 0) {
                    break;
                }
                int k = this.exprType;
                if (k == 312) {
                    i = 175;
                    break;
                }
                if (k == 317) {
                    i = 174;
                    break;
                }
                if (k == 326) {
                    i = 173;
                    break;
                }
                i = j;
                if (isRefType(k)) {
                    break;
                }
                i = 172;
                break;
            }
        }
        label129:
        this.bytecode.addOpcode(i);
        this.hasReturned = true;
    }

    public void atStmnt(Stmnt paramStmnt) {
        boolean bool2 = true;
        boolean bool1 = true;
        if (paramStmnt == null) {
        }
        int i;
        for (; ; ) {
            return;
            i = paramStmnt.getOperator();
            if (i == 69) {
                paramStmnt = paramStmnt.getLeft();
                doTypeCheck(paramStmnt);
                if ((paramStmnt instanceof AssignExpr)) {
                    atAssignExpr((AssignExpr) paramStmnt, false);
                    return;
                }
                if (isPlusPlusExpr(paramStmnt)) {
                    paramStmnt = (Expr) paramStmnt;
                    atPlusPlus(paramStmnt.getOperator(), paramStmnt.oprand1(), paramStmnt, false);
                    return;
                }
                paramStmnt.accept(this);
                if (is2word(this.exprType, this.arrayDim)) {
                    this.bytecode.addOpcode(88);
                    return;
                }
                if (this.exprType != 344) {
                    this.bytecode.addOpcode(87);
                }
            } else {
                Stmnt localStmnt = paramStmnt;
                if (i != 68) {
                    if (i == 66) {
                        localStmnt = paramStmnt;
                    }
                } else {
                    while (localStmnt != null) {
                        ASTree localASTree = localStmnt.head();
                        paramStmnt = localStmnt.tail();
                        localStmnt = paramStmnt;
                        if (localASTree != null) {
                            localASTree.accept(this);
                            localStmnt = paramStmnt;
                        }
                    }
                }
            }
        }
        if (i == 320) {
            atIfStmnt(paramStmnt);
            return;
        }
        if ((i == 346) || (i == 311)) {
            if (i == 346) {
            }
            for (; ; ) {
                atWhileStmnt(paramStmnt, bool1);
                return;
                bool1 = false;
            }
        }
        if (i == 318) {
            atForStmnt(paramStmnt);
            return;
        }
        if ((i == 302) || (i == 309)) {
            if (i == 302) {
            }
            for (bool1 = bool2; ; bool1 = false) {
                atBreakStmnt(paramStmnt, bool1);
                return;
            }
        }
        if (i == 333) {
            atReturnStmnt(paramStmnt);
            return;
        }
        if (i == 340) {
            atThrowStmnt(paramStmnt);
            return;
        }
        if (i == 343) {
            atTryStmnt(paramStmnt);
            return;
        }
        if (i == 337) {
            atSwitchStmnt(paramStmnt);
            return;
        }
        if (i == 338) {
            atSyncStmnt(paramStmnt);
            return;
        }
        this.hasReturned = false;
        throw new CompileError("sorry, not supported statement: TokenId " + i);
    }

    public void atStringL(StringL paramStringL) {
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/String";
        this.bytecode.addLdc(paramStringL.get());
    }

    public void atSymbol(Symbol paramSymbol) {
    }

    protected void atTryStmnt(Stmnt paramStmnt) {
        this.hasReturned = false;
    }

    public void atVariable(Variable paramVariable) {
        paramVariable = paramVariable.getDeclarator();
        this.exprType = paramVariable.getType();
        this.arrayDim = paramVariable.getArrayDim();
        this.className = paramVariable.getClassName();
        int i = getLocalVar(paramVariable);
        if (this.arrayDim > 0) {
            this.bytecode.addAload(i);
            return;
        }
        switch (this.exprType) {
            default:
                this.bytecode.addIload(i);
                return;
            case 307:
                this.bytecode.addAload(i);
                return;
            case 326:
                this.bytecode.addLload(i);
                return;
            case 317:
                this.bytecode.addFload(i);
                return;
        }
        this.bytecode.addDload(i);
    }

    public boolean compileBooleanExpr(boolean paramBoolean, ASTree paramASTree) {
        doTypeCheck(paramASTree);
        return booleanExpr(paramBoolean, paramASTree);
    }

    public void compileExpr(ASTree paramASTree) {
        doTypeCheck(paramASTree);
        paramASTree.accept(this);
    }

    public void doTypeCheck(ASTree paramASTree) {
        if (this.typeChecker != null) {
            paramASTree.accept(this.typeChecker);
        }
    }

    protected int getLocalVar(Declarator paramDeclarator) {
        int j = paramDeclarator.getLocalVar();
        int i = j;
        if (j < 0) {
            i = getMaxLocals();
            paramDeclarator.setLocalVar(i);
            incMaxLocals(1);
        }
        return i;
    }

    public int getMaxLocals() {
        return this.bytecode.getMaxLocals();
    }

    protected abstract String getSuperName();

    protected int getTempVar() {
        if (this.tempVar < 0) {
            this.tempVar = getMaxLocals();
            incMaxLocals(2);
        }
        return this.tempVar;
    }

    protected abstract String getThisName();

    protected void incMaxLocals(int paramInt) {
        this.bytecode.incMaxLocals(paramInt);
    }

    protected abstract void insertDefaultSuperCall();

    protected void patchGoto(ArrayList paramArrayList, int paramInt) {
        int j = paramArrayList.size();
        int i = 0;
        while (i < j) {
            int k = ((Integer) paramArrayList.get(i)).intValue();
            this.bytecode.write16bit(k, paramInt - k + 1);
            i += 1;
        }
    }

    protected abstract String resolveClassName(String paramString);

    protected abstract String resolveClassName(ASTList paramASTList);

    public void setMaxLocals(int paramInt) {
        this.bytecode.setMaxLocals(paramInt);
    }

    public void setTypeChecker(TypeChecker paramTypeChecker) {
        this.typeChecker = paramTypeChecker;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/CodeGen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */