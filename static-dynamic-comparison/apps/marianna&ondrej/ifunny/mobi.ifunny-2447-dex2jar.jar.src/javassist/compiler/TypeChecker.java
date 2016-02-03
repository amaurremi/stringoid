package javassist.compiler;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
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
import javassist.compiler.ast.InstanceOfExpr;
import javassist.compiler.ast.IntConst;
import javassist.compiler.ast.Keyword;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.NewExpr;
import javassist.compiler.ast.StringL;
import javassist.compiler.ast.Symbol;
import javassist.compiler.ast.Variable;
import javassist.compiler.ast.Visitor;

public class TypeChecker
        extends Visitor
        implements Opcode, TokenId {
    static final String javaLangObject = "java.lang.Object";
    static final String jvmJavaLangClass = "java/lang/Class";
    static final String jvmJavaLangObject = "java/lang/Object";
    static final String jvmJavaLangString = "java/lang/String";
    protected int arrayDim;
    protected String className;
    protected int exprType;
    protected MemberResolver resolver;
    protected CtClass thisClass;
    protected MethodInfo thisMethod;

    public TypeChecker(CtClass paramCtClass, ClassPool paramClassPool) {
        this.resolver = new MemberResolver(paramClassPool);
        this.thisClass = paramCtClass;
        this.thisMethod = null;
    }

    protected static String argTypesToString(int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString) {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append('(');
        int j = paramArrayOfInt1.length;
        if (j > 0) {
            int i = 0;
            for (; ; ) {
                typeToString(localStringBuffer, paramArrayOfInt1[i], paramArrayOfInt2[i], paramArrayOfString[i]);
                i += 1;
                if (i >= j) {
                    break;
                }
                localStringBuffer.append(',');
            }
        }
        localStringBuffer.append(')');
        return localStringBuffer.toString();
    }

    private void atArrayAssign(Expr paramExpr1, int paramInt, Expr paramExpr2, ASTree paramASTree) {
        atArrayRead(paramExpr2.oprand1(), paramExpr2.oprand2());
        paramInt = this.exprType;
        int i = this.arrayDim;
        paramExpr1 = this.className;
        paramASTree.accept(this);
        this.exprType = paramInt;
        this.arrayDim = i;
        this.className = paramExpr1;
    }

    private void atFieldRead(CtField paramCtField) {
        int j = 0;
        paramCtField = paramCtField.getFieldInfo2().getDescriptor();
        char c = paramCtField.charAt(0);
        int i = 0;
        while (c == '[') {
            j += 1;
            i += 1;
            c = paramCtField.charAt(i);
        }
        this.arrayDim = j;
        this.exprType = MemberResolver.descToType(c);
        if (c == 'L') {
            this.className = paramCtField.substring(i + 1, paramCtField.indexOf(';', i + 1));
            return;
        }
        this.className = null;
    }

    private void atFieldRead(ASTree paramASTree) {
        atFieldRead(fieldAccess(paramASTree));
    }

    private Expr atPlusExpr(BinExpr paramBinExpr) {
        ASTree localASTree1 = paramBinExpr.oprand1();
        ASTree localASTree2 = paramBinExpr.oprand2();
        if (localASTree2 == null) {
            localASTree1.accept(this);
            return null;
        }
        if (isPlusExpr(localASTree1)) {
            localObject = atPlusExpr((BinExpr) localASTree1);
            if (localObject != null) {
                localASTree2.accept(this);
                this.exprType = 307;
                this.arrayDim = 0;
                this.className = "java/lang/StringBuffer";
                return makeAppendCall((ASTree) localObject, localASTree2);
            }
        } else {
            localASTree1.accept(this);
        }
        int i = this.exprType;
        int j = this.arrayDim;
        Object localObject = this.className;
        localASTree2.accept(this);
        if (isConstant(paramBinExpr, 43, localASTree1, localASTree2)) {
            return null;
        }
        if (((i == 307) && (j == 0) && ("java/lang/String".equals(localObject))) || ((this.exprType == 307) && (this.arrayDim == 0) && ("java/lang/String".equals(this.className)))) {
            paramBinExpr = new NewExpr(ASTList.make(new Symbol("java"), new Symbol("lang"), new Symbol("StringBuffer")), null);
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/StringBuffer";
            return makeAppendCall(makeAppendCall(paramBinExpr, localASTree1), localASTree2);
        }
        computeBinExprType(paramBinExpr, 43, i);
        return null;
    }

    private void atPlusPlus(int paramInt, ASTree paramASTree, Expr paramExpr) {
        if (paramASTree == null) {
            paramInt = 1;
            if (paramInt == 0) {
                break label132;
            }
            paramASTree = paramExpr.oprand2();
        }
        label126:
        label132:
        for (; ; ) {
            if ((paramASTree instanceof Variable)) {
                paramASTree = ((Variable) paramASTree).getDeclarator();
                this.exprType = paramASTree.getType();
                this.arrayDim = paramASTree.getArrayDim();
            }
            do {
                return;
                paramInt = 0;
                break;
                if (!(paramASTree instanceof Expr)) {
                    break label126;
                }
                paramExpr = (Expr) paramASTree;
                if (paramExpr.getOperator() != 65) {
                    break label126;
                }
                atArrayRead(paramExpr.oprand1(), paramExpr.oprand2());
                paramInt = this.exprType;
            } while ((paramInt != 324) && (paramInt != 303) && (paramInt != 306) && (paramInt != 334));
            this.exprType = 324;
            return;
            atFieldPlusPlus(paramASTree);
            return;
        }
    }

    private void atVariableAssign(Expr paramExpr, int paramInt, Variable paramVariable, Declarator paramDeclarator, ASTree paramASTree) {
        int i = paramDeclarator.getType();
        int j = paramDeclarator.getArrayDim();
        paramExpr = paramDeclarator.getClassName();
        if (paramInt != 61) {
            atVariable(paramVariable);
        }
        paramASTree.accept(this);
        this.exprType = i;
        this.arrayDim = j;
        this.className = paramExpr;
    }

    private static void badMethod() {
        throw new CompileError("bad method");
    }

    private void booleanExpr(ASTree paramASTree) {
        int i = CodeGen.getCompOperator(paramASTree);
        if (i == 358) {
            paramASTree = (BinExpr) paramASTree;
            paramASTree.oprand1().accept(this);
            i = this.exprType;
            int j = this.arrayDim;
            paramASTree.oprand2().accept(this);
            if ((j == 0) && (this.arrayDim == 0)) {
                insertCast(paramASTree, i, this.exprType);
            }
        }
        for (; ; ) {
            this.exprType = 301;
            this.arrayDim = 0;
            return;
            if (i == 33) {
                ((Expr) paramASTree).oprand1().accept(this);
            } else if ((i == 369) || (i == 368)) {
                paramASTree = (BinExpr) paramASTree;
                paramASTree.oprand1().accept(this);
                paramASTree.oprand2().accept(this);
            } else {
                paramASTree.accept(this);
            }
        }
    }

    private void computeBinExprType(BinExpr paramBinExpr, int paramInt1, int paramInt2) {
        int i = this.exprType;
        if ((paramInt1 == 364) || (paramInt1 == 366) || (paramInt1 == 370)) {
            this.exprType = paramInt2;
        }
        for (; ; ) {
            if (CodeGen.isP_INT(this.exprType)) {
                this.exprType = 324;
            }
            return;
            insertCast(paramBinExpr, paramInt2, i);
        }
    }

    protected static void fatal() {
        throw new CompileError("fatal");
    }

    private CtField fieldAccess2(Expr paramExpr, String paramString) {
        Member localMember = (Member) paramExpr.oprand2();
        CtField localCtField = this.resolver.lookupFieldByJvmName2(paramString, localMember, paramExpr);
        paramExpr.setOperator(35);
        paramExpr.setOprand1(new Symbol(MemberResolver.jvmToJavaName(paramString)));
        localMember.setField(localCtField);
        return localCtField;
    }

    public static ASTree getConstantFieldValue(CtField paramCtField) {
        if (paramCtField == null) {
            return null;
        }
        paramCtField = paramCtField.getConstantValue();
        if (paramCtField == null) {
            return null;
        }
        if ((paramCtField instanceof String)) {
            return new StringL((String) paramCtField);
        }
        int i;
        if (((paramCtField instanceof Double)) || ((paramCtField instanceof Float))) {
            if ((paramCtField instanceof Double)) {
            }
            for (i = 405; ; i = 404) {
                return new DoubleConst(((Number) paramCtField).doubleValue(), i);
            }
        }
        if ((paramCtField instanceof Number)) {
            if ((paramCtField instanceof Long)) {
            }
            for (i = 403; ; i = 402) {
                return new IntConst(((Number) paramCtField).longValue(), i);
            }
        }
        if ((paramCtField instanceof Boolean)) {
            if (((Boolean) paramCtField).booleanValue()) {
            }
            for (i = 410; ; i = 411) {
                return new Keyword(i);
            }
        }
        return null;
    }

    private static ASTree getConstantFieldValue(Member paramMember) {
        return getConstantFieldValue(paramMember.getField());
    }

    private void insertCast(BinExpr paramBinExpr, int paramInt1, int paramInt2) {
        if (CodeGen.rightIsStrong(paramInt1, paramInt2)) {
            paramBinExpr.setLeft(new CastExpr(paramInt2, 0, paramBinExpr.oprand1()));
            return;
        }
        this.exprType = paramInt1;
    }

    private boolean isConstant(BinExpr paramBinExpr, int paramInt, ASTree paramASTree1, ASTree paramASTree2) {
        paramASTree1 = stripPlusExpr(paramASTree1);
        paramASTree2 = stripPlusExpr(paramASTree2);
        if (((paramASTree1 instanceof StringL)) && ((paramASTree2 instanceof StringL)) && (paramInt == 43)) {
            paramASTree1 = new StringL(((StringL) paramASTree1).get() + ((StringL) paramASTree2).get());
        }
        for (; ; ) {
            if (paramASTree1 == null) {
                return false;
                if ((paramASTree1 instanceof IntConst)) {
                    paramASTree1 = ((IntConst) paramASTree1).compute(paramInt, paramASTree2);
                    continue;
                }
                if ((paramASTree1 instanceof DoubleConst)) {
                    paramASTree1 = ((DoubleConst) paramASTree1).compute(paramInt, paramASTree2);
                }
            } else {
                paramBinExpr.setOperator(43);
                paramBinExpr.setOprand1(paramASTree1);
                paramBinExpr.setOprand2(null);
                paramASTree1.accept(this);
                return true;
            }
            paramASTree1 = null;
        }
    }

    private boolean isConstant(Expr paramExpr, int paramInt, ASTree paramASTree) {
        paramASTree = stripPlusExpr(paramASTree);
        long l;
        if ((paramASTree instanceof IntConst)) {
            paramASTree = (IntConst) paramASTree;
            l = paramASTree.get();
            if (paramInt == 45) {
                l = -l;
                paramASTree.set(l);
            }
        }
        for (; ; ) {
            paramExpr.setOperator(43);
            return true;
            if (paramInt == 126) {
                l ^= 0xFFFFFFFFFFFFFFFF;
                break;
            }
            return false;
            if (!(paramASTree instanceof DoubleConst)) {
                break label99;
            }
            paramASTree = (DoubleConst) paramASTree;
            if (paramInt != 45) {
                break label97;
            }
            paramASTree.set(-paramASTree.get());
        }
        label97:
        return false;
        label99:
        return false;
    }

    private static boolean isPlusExpr(ASTree paramASTree) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramASTree instanceof BinExpr)) {
            bool1 = bool2;
            if (((BinExpr) paramASTree).getOperator() == 43) {
                bool1 = true;
            }
        }
        return bool1;
    }

    private static Expr makeAppendCall(ASTree paramASTree1, ASTree paramASTree2) {
        return CallExpr.makeCall(Expr.make(46, paramASTree1, new Member("append")), new ASTList(paramASTree2));
    }

    static ASTree stripPlusExpr(ASTree paramASTree) {
        Object localObject;
        ASTree localASTree;
        if ((paramASTree instanceof BinExpr)) {
            localObject = (BinExpr) paramASTree;
            localASTree = paramASTree;
            if (((BinExpr) localObject).getOperator() == 43) {
                localASTree = paramASTree;
                if (((BinExpr) localObject).oprand2() == null) {
                    localASTree = ((BinExpr) localObject).getLeft();
                }
            }
        }
        label103:
        do {
            do {
                do {
                    int i;
                    do {
                        do {
                            return localASTree;
                            if (!(paramASTree instanceof Expr)) {
                                break label103;
                            }
                            localObject = (Expr) paramASTree;
                            i = ((Expr) localObject).getOperator();
                            if (i != 35) {
                                break;
                            }
                            localObject = getConstantFieldValue((Member) ((Expr) localObject).oprand2());
                            localASTree = paramASTree;
                        } while (localObject == null);
                        return (ASTree) localObject;
                        localASTree = paramASTree;
                    } while (i != 43);
                    localASTree = paramASTree;
                } while (((Expr) localObject).getRight() != null);
                return ((Expr) localObject).getLeft();
                localASTree = paramASTree;
            } while (!(paramASTree instanceof Member));
            localObject = getConstantFieldValue((Member) paramASTree);
            localASTree = paramASTree;
        } while (localObject == null);
        return (ASTree) localObject;
    }

    protected static StringBuffer typeToString(StringBuffer paramStringBuffer, int paramInt1, int paramInt2, String paramString) {
        if (paramInt1 == 307) {
            paramString = MemberResolver.jvmToJavaName(paramString);
        }
        for (; ; ) {
            paramStringBuffer.append(paramString);
            while (paramInt2 > 0) {
                paramStringBuffer.append("[]");
                paramInt2 -= 1;
            }
            if (paramInt1 == 412) {
                paramString = "Object";
            } else {
                try {
                    paramString = MemberResolver.getTypeName(paramInt1);
                } catch (CompileError paramString) {
                    paramString = "?";
                }
            }
        }
        return paramStringBuffer;
    }

    public void atArrayInit(ArrayInit paramArrayInit) {
        while (paramArrayInit != null) {
            ASTree localASTree = paramArrayInit.head();
            ASTList localASTList = paramArrayInit.tail();
            paramArrayInit = localASTList;
            if (localASTree != null) {
                localASTree.accept(this);
                paramArrayInit = localASTList;
            }
        }
    }

    public void atArrayLength(Expr paramExpr) {
        paramExpr.oprand1().accept(this);
        this.exprType = 324;
        this.arrayDim = 0;
    }

    public void atArrayRead(ASTree paramASTree1, ASTree paramASTree2) {
        paramASTree1.accept(this);
        int i = this.exprType;
        int j = this.arrayDim;
        paramASTree1 = this.className;
        paramASTree2.accept(this);
        this.exprType = i;
        this.arrayDim = (j - 1);
        this.className = paramASTree1;
    }

    public void atAssignExpr(AssignExpr paramAssignExpr) {
        int i = paramAssignExpr.getOperator();
        ASTree localASTree1 = paramAssignExpr.oprand1();
        ASTree localASTree2 = paramAssignExpr.oprand2();
        if ((localASTree1 instanceof Variable)) {
            atVariableAssign(paramAssignExpr, i, (Variable) localASTree1, ((Variable) localASTree1).getDeclarator(), localASTree2);
            return;
        }
        if (((localASTree1 instanceof Expr)) && (((Expr) localASTree1).getOperator() == 65)) {
            atArrayAssign(paramAssignExpr, i, (Expr) localASTree1, localASTree2);
            return;
        }
        atFieldAssign(paramAssignExpr, i, localASTree1, localASTree2);
    }

    public void atBinExpr(BinExpr paramBinExpr) {
        int i = paramBinExpr.getOperator();
        if (CodeGen.lookupBinOp(i) >= 0) {
            Object localObject;
            if (i == 43) {
                localObject = atPlusExpr(paramBinExpr);
                if (localObject != null) {
                    paramBinExpr.setOprand1(CallExpr.makeCall(Expr.make(46, (ASTree) localObject, new Member("toString")), null));
                    paramBinExpr.setOprand2(null);
                    this.className = "java/lang/String";
                }
            }
            ASTree localASTree;
            int j;
            do {
                return;
                localObject = paramBinExpr.oprand1();
                localASTree = paramBinExpr.oprand2();
                ((ASTree) localObject).accept(this);
                j = this.exprType;
                localASTree.accept(this);
            } while (isConstant(paramBinExpr, i, (ASTree) localObject, localASTree));
            computeBinExprType(paramBinExpr, i, j);
            return;
        }
        booleanExpr(paramBinExpr);
    }

    public void atCallExpr(CallExpr paramCallExpr) {
        String str = null;
        Object localObject = paramCallExpr.oprand1();
        ASTList localASTList = (ASTList) paramCallExpr.oprand2();
        if ((localObject instanceof Member)) {
            str = ((Member) localObject).get();
            localObject = this.thisClass;
        }
        for (; ; ) {
            paramCallExpr.setMethod(atMethodCallCore((CtClass) localObject, str, localASTList));
            return;
            if ((localObject instanceof Keyword)) {
                str = "<init>";
                if (((Keyword) localObject).get() == 336) {
                    localObject = MemberResolver.getSuperclass(this.thisClass);
                } else {
                    localObject = this.thisClass;
                }
            } else {
                if ((localObject instanceof Expr)) {
                    localObject = (Expr) localObject;
                    str = ((Symbol) ((Expr) localObject).oprand2()).get();
                    int i = ((Expr) localObject).getOperator();
                    if (i == 35) {
                        localObject = this.resolver.lookupClass(((Symbol) ((Expr) localObject).oprand1()).get(), false);
                    }
                    for (; ; ) {
                        break;
                        if (i == 46) {
                            ASTree localASTree = ((Expr) localObject).oprand1();
                            try {
                                localASTree.accept(this);
                                if (this.arrayDim > 0) {
                                    localObject = this.resolver.lookupClass("java.lang.Object", true);
                                }
                            } catch (NoFieldException localNoFieldException) {
                                for (; ; ) {
                                    if (localNoFieldException.getExpr() != localASTree) {
                                        throw localNoFieldException;
                                    }
                                    this.exprType = 307;
                                    this.arrayDim = 0;
                                    this.className = localNoFieldException.getField();
                                    ((Expr) localObject).setOperator(35);
                                    ((Expr) localObject).setOprand1(new Symbol(MemberResolver.jvmToJavaName(this.className)));
                                }
                                if (this.exprType == 307) {
                                    localObject = this.resolver.lookupClassByJvmName(this.className);
                                    continue;
                                }
                                localObject = null;
                                badMethod();
                            }
                        } else {
                            localObject = null;
                            badMethod();
                        }
                    }
                }
                localObject = null;
                fatal();
            }
        }
    }

    public void atCastExpr(CastExpr paramCastExpr) {
        String str = resolveClassName(paramCastExpr.getClassName());
        paramCastExpr.getOprand().accept(this);
        this.exprType = paramCastExpr.getType();
        this.arrayDim = paramCastExpr.getArrayDim();
        this.className = str;
    }

    public void atClassObject(Expr paramExpr) {
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/Class";
    }

    public void atCondExpr(CondExpr paramCondExpr) {
        booleanExpr(paramCondExpr.condExpr());
        paramCondExpr.thenExpr().accept(this);
        int i = this.exprType;
        int j = this.arrayDim;
        String str = this.className;
        paramCondExpr.elseExpr().accept(this);
        if ((j == 0) && (j == this.arrayDim)) {
            if (!CodeGen.rightIsStrong(i, this.exprType)) {
                break label84;
            }
            paramCondExpr.setThen(new CastExpr(this.exprType, 0, paramCondExpr.thenExpr()));
        }
        label84:
        while (!CodeGen.rightIsStrong(this.exprType, i)) {
            return;
        }
        paramCondExpr.setElse(new CastExpr(i, 0, paramCondExpr.elseExpr()));
        this.exprType = i;
    }

    public void atDoubleConst(DoubleConst paramDoubleConst) {
        this.arrayDim = 0;
        if (paramDoubleConst.getType() == 405) {
            this.exprType = 312;
            return;
        }
        this.exprType = 317;
    }

    public void atExpr(Expr paramExpr) {
        int i = paramExpr.getOperator();
        Object localObject = paramExpr.oprand1();
        if (i == 46) {
            localObject = ((Symbol) paramExpr.oprand2()).get();
            if (!((String) localObject).equals("length")) {
            }
        }
        do {
            try {
                atArrayLength(paramExpr);
                return;
            } catch (NoFieldException localNoFieldException) {
                atFieldRead(paramExpr);
                return;
            }
            if (localNoFieldException.equals("class")) {
                atClassObject(paramExpr);
                return;
            }
            atFieldRead(paramExpr);
            return;
            if (i == 35) {
                if (((Symbol) paramExpr.oprand2()).get().equals("class")) {
                    atClassObject(paramExpr);
                    return;
                }
                atFieldRead(paramExpr);
                return;
            }
            if (i == 65) {
                atArrayRead(localNoFieldException, paramExpr.oprand2());
                return;
            }
            if ((i == 362) || (i == 363)) {
                atPlusPlus(i, localNoFieldException, paramExpr);
                return;
            }
            if (i == 33) {
                booleanExpr(paramExpr);
                return;
            }
            if (i == 67) {
                fatal();
                return;
            }
            localNoFieldException.accept(this);
        }
        while ((isConstant(paramExpr, i, localNoFieldException)) || ((i != 45) && (i != 126)) || (!CodeGen.isP_INT(this.exprType)));
        this.exprType = 324;
    }

    protected void atFieldAssign(Expr paramExpr, int paramInt, ASTree paramASTree1, ASTree paramASTree2) {
        atFieldRead(fieldAccess(paramASTree1));
        paramInt = this.exprType;
        int i = this.arrayDim;
        paramExpr = this.className;
        paramASTree2.accept(this);
        this.exprType = paramInt;
        this.arrayDim = i;
        this.className = paramExpr;
    }

    protected void atFieldPlusPlus(ASTree paramASTree) {
        atFieldRead(fieldAccess(paramASTree));
        int i = this.exprType;
        if ((i == 324) || (i == 303) || (i == 306) || (i == 334)) {
            this.exprType = 324;
        }
    }

    public void atInstanceOfExpr(InstanceOfExpr paramInstanceOfExpr) {
        paramInstanceOfExpr.getOprand().accept(this);
        this.exprType = 301;
        this.arrayDim = 0;
    }

    public void atIntConst(IntConst paramIntConst) {
        this.arrayDim = 0;
        int i = paramIntConst.getType();
        if ((i == 402) || (i == 401)) {
            if (i == 402) {
            }
            for (i = 324; ; i = 306) {
                this.exprType = i;
                return;
            }
        }
        this.exprType = 326;
    }

    public void atKeyword(Keyword paramKeyword) {
        this.arrayDim = 0;
        int i = paramKeyword.get();
        switch (i) {
            default:
                fatal();
                return;
            case 410:
            case 411:
                this.exprType = 301;
                return;
            case 412:
                this.exprType = 412;
                return;
        }
        this.exprType = 307;
        if (i == 339) {
            this.className = getThisName();
            return;
        }
        this.className = getSuperName();
    }

    public void atMember(Member paramMember) {
        atFieldRead(paramMember);
    }

    public void atMethodArgs(ASTList paramASTList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString) {
        int i = 0;
        while (paramASTList != null) {
            paramASTList.head().accept(this);
            paramArrayOfInt1[i] = this.exprType;
            paramArrayOfInt2[i] = this.arrayDim;
            paramArrayOfString[i] = this.className;
            i += 1;
            paramASTList = paramASTList.tail();
        }
    }

    public MemberResolver.Method atMethodCallCore(CtClass paramCtClass, String paramString, ASTList paramASTList) {
        int i = getMethodArgsLength(paramASTList);
        int[] arrayOfInt1 = new int[i];
        int[] arrayOfInt2 = new int[i];
        String[] arrayOfString = new String[i];
        atMethodArgs(paramASTList, arrayOfInt1, arrayOfInt2, arrayOfString);
        paramASTList = this.resolver.lookupMethod(paramCtClass, this.thisClass, this.thisMethod, paramString, arrayOfInt1, arrayOfInt2, arrayOfString);
        if (paramASTList == null) {
            paramCtClass = paramCtClass.getName();
            paramASTList = argTypesToString(arrayOfInt1, arrayOfInt2, arrayOfString);
            if (paramString.equals("<init>")) {
            }
            for (paramCtClass = "cannot find constructor " + paramCtClass + paramASTList; ; paramCtClass = paramString + paramASTList + " not found in " + paramCtClass) {
                throw new CompileError(paramCtClass);
            }
        }
        setReturnType(paramASTList.info.getDescriptor());
        return paramASTList;
    }

    protected void atMultiNewArray(int paramInt, ASTList paramASTList1, ASTList paramASTList2) {
        int j = paramASTList2.length();
        int i = 0;
        for (; ; ) {
            ASTree localASTree;
            if (paramASTList2 != null) {
                localASTree = paramASTList2.head();
                if (localASTree != null) {
                }
            } else {
                this.exprType = paramInt;
                this.arrayDim = j;
                if (paramInt != 307) {
                    break;
                }
                this.className = resolveClassName(paramASTList1);
                return;
            }
            i += 1;
            localASTree.accept(this);
            paramASTList2 = paramASTList2.tail();
        }
        this.className = null;
    }

    public void atNewArrayExpr(NewExpr paramNewExpr) {
        int i = paramNewExpr.getArrayType();
        ASTList localASTList2 = paramNewExpr.getArraySize();
        ASTList localASTList1 = paramNewExpr.getClassName();
        paramNewExpr = paramNewExpr.getInitializer();
        if (paramNewExpr != null) {
            paramNewExpr.accept(this);
        }
        if (localASTList2.length() > 1) {
            atMultiNewArray(i, localASTList1, localASTList2);
            return;
        }
        paramNewExpr = localASTList2.head();
        if (paramNewExpr != null) {
            paramNewExpr.accept(this);
        }
        this.exprType = i;
        this.arrayDim = 1;
        if (i == 307) {
            this.className = resolveClassName(localASTList1);
            return;
        }
        this.className = null;
    }

    public void atNewExpr(NewExpr paramNewExpr) {
        if (paramNewExpr.isArray()) {
            atNewArrayExpr(paramNewExpr);
            return;
        }
        CtClass localCtClass = this.resolver.lookupClassByName(paramNewExpr.getClassName());
        String str = localCtClass.getName();
        atMethodCallCore(localCtClass, "<init>", paramNewExpr.getArguments());
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = MemberResolver.javaToJvmName(str);
    }

    public void atStringL(StringL paramStringL) {
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/String";
    }

    public void atVariable(Variable paramVariable) {
        paramVariable = paramVariable.getDeclarator();
        this.exprType = paramVariable.getType();
        this.arrayDim = paramVariable.getArrayDim();
        this.className = paramVariable.getClassName();
    }

    /* Error */
    protected CtField fieldAccess(ASTree paramASTree) {
        // Byte code:
        //   0: aload_1
        //   1: instanceof 238
        //   4: ifeq +58 -> 62
        //   7: aload_1
        //   8: checkcast 238	javassist/compiler/ast/Member
        //   11: astore 4
        //   13: aload 4
        //   15: invokevirtual 436	javassist/compiler/ast/Member:get	()Ljava/lang/String;
        //   18: astore_3
        //   19: aload_0
        //   20: getfield 45	javassist/compiler/TypeChecker:thisClass	Ljavassist/CtClass;
        //   23: aload_3
        //   24: invokevirtual 614	javassist/CtClass:getField	(Ljava/lang/String;)Ljavassist/CtField;
        //   27: astore 5
        //   29: aload 5
        //   31: invokevirtual 617	javassist/CtField:getModifiers	()I
        //   34: invokestatic 622	javassist/Modifier:isStatic	(I)Z
        //   37: ifeq +10 -> 47
        //   40: aload 4
        //   42: aload 5
        //   44: invokevirtual 256	javassist/compiler/ast/Member:setField	(Ljavassist/CtField;)V
        //   47: aload 5
        //   49: areturn
        //   50: astore 4
        //   52: new 433	javassist/compiler/NoFieldException
        //   55: dup
        //   56: aload_3
        //   57: aload_1
        //   58: invokespecial 625	javassist/compiler/NoFieldException:<init>	(Ljava/lang/String;Ljavassist/compiler/ast/ASTree;)V
        //   61: athrow
        //   62: aload_1
        //   63: instanceof 69
        //   66: ifeq +169 -> 235
        //   69: aload_1
        //   70: checkcast 69	javassist/compiler/ast/Expr
        //   73: astore_3
        //   74: aload_3
        //   75: invokevirtual 200	javassist/compiler/ast/Expr:getOperator	()I
        //   78: istore_2
        //   79: iload_2
        //   80: bipush 35
        //   82: if_icmpne +37 -> 119
        //   85: aload_3
        //   86: invokevirtual 76	javassist/compiler/ast/Expr:oprand2	()Ljavassist/compiler/ast/ASTree;
        //   89: checkcast 238	javassist/compiler/ast/Member
        //   92: astore_1
        //   93: aload_0
        //   94: getfield 43	javassist/compiler/TypeChecker:resolver	Ljavassist/compiler/MemberResolver;
        //   97: aload_3
        //   98: invokevirtual 73	javassist/compiler/ast/Expr:oprand1	()Ljavassist/compiler/ast/ASTree;
        //   101: checkcast 158	javassist/compiler/ast/Symbol
        //   104: invokevirtual 452	javassist/compiler/ast/Symbol:get	()Ljava/lang/String;
        //   107: aload_1
        //   108: invokevirtual 629	javassist/compiler/MemberResolver:lookupField	(Ljava/lang/String;Ljavassist/compiler/ast/Symbol;)Ljavassist/CtField;
        //   111: astore_3
        //   112: aload_1
        //   113: aload_3
        //   114: invokevirtual 256	javassist/compiler/ast/Member:setField	(Ljavassist/CtField;)V
        //   117: aload_3
        //   118: areturn
        //   119: iload_2
        //   120: bipush 46
        //   122: if_icmpne +113 -> 235
        //   125: aload_3
        //   126: invokevirtual 73	javassist/compiler/ast/Expr:oprand1	()Ljavassist/compiler/ast/ASTree;
        //   129: aload_0
        //   130: invokevirtual 92	javassist/compiler/ast/ASTree:accept	(Ljavassist/compiler/ast/Visitor;)V
        //   133: aload_0
        //   134: getfield 82	javassist/compiler/TypeChecker:exprType	I
        //   137: sipush 307
        //   140: if_icmpne +55 -> 195
        //   143: aload_0
        //   144: getfield 84	javassist/compiler/TypeChecker:arrayDim	I
        //   147: ifne +48 -> 195
        //   150: aload_0
        //   151: getfield 43	javassist/compiler/TypeChecker:resolver	Ljavassist/compiler/MemberResolver;
        //   154: aload_0
        //   155: getfield 86	javassist/compiler/TypeChecker:className	Ljava/lang/String;
        //   158: aload_3
        //   159: invokevirtual 76	javassist/compiler/ast/Expr:oprand2	()Ljavassist/compiler/ast/ASTree;
        //   162: checkcast 158	javassist/compiler/ast/Symbol
        //   165: invokevirtual 632	javassist/compiler/MemberResolver:lookupFieldByJvmName	(Ljava/lang/String;Ljavassist/compiler/ast/Symbol;)Ljavassist/CtField;
        //   168: astore_1
        //   169: aload_1
        //   170: areturn
        //   171: astore_1
        //   172: aload_1
        //   173: invokevirtual 459	javassist/compiler/NoFieldException:getExpr	()Ljavassist/compiler/ast/ASTree;
        //   176: aload_3
        //   177: invokevirtual 73	javassist/compiler/ast/Expr:oprand1	()Ljavassist/compiler/ast/ASTree;
        //   180: if_acmpeq +5 -> 185
        //   183: aload_1
        //   184: athrow
        //   185: aload_0
        //   186: aload_3
        //   187: aload_1
        //   188: invokevirtual 461	javassist/compiler/NoFieldException:getField	()Ljava/lang/String;
        //   191: invokespecial 634	javassist/compiler/TypeChecker:fieldAccess2	(Ljavassist/compiler/ast/Expr;Ljava/lang/String;)Ljavassist/CtField;
        //   194: areturn
        //   195: aconst_null
        //   196: astore_1
        //   197: aload_3
        //   198: invokevirtual 73	javassist/compiler/ast/Expr:oprand1	()Ljavassist/compiler/ast/ASTree;
        //   201: astore 4
        //   203: aload 4
        //   205: instanceof 158
        //   208: ifeq +21 -> 229
        //   211: aload_0
        //   212: aload_3
        //   213: aload 4
        //   215: checkcast 158	javassist/compiler/ast/Symbol
        //   218: invokevirtual 452	javassist/compiler/ast/Symbol:get	()Ljava/lang/String;
        //   221: invokespecial 634	javassist/compiler/TypeChecker:fieldAccess2	(Ljavassist/compiler/ast/Expr;Ljava/lang/String;)Ljavassist/CtField;
        //   224: areturn
        //   225: astore_1
        //   226: goto -29 -> 197
        //   229: aload_1
        //   230: ifnull +5 -> 235
        //   233: aload_1
        //   234: athrow
        //   235: new 215	javassist/compiler/CompileError
        //   238: dup
        //   239: ldc_w 636
        //   242: invokespecial 218	javassist/compiler/CompileError:<init>	(Ljava/lang/String;)V
        //   245: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	246	0	this	TypeChecker
        //   0	246	1	paramASTree	ASTree
        //   78	45	2	i	int
        //   18	195	3	localObject	Object
        //   11	30	4	localMember	Member
        //   50	1	4	localNotFoundException	javassist.NotFoundException
        //   201	13	4	localASTree	ASTree
        //   27	21	5	localCtField	CtField
        // Exception table:
        //   from	to	target	type
        //   19	47	50	javassist/NotFoundException
        //   125	133	171	javassist/compiler/NoFieldException
        //   133	169	225	javassist/compiler/CompileError
    }

    public int getMethodArgsLength(ASTList paramASTList) {
        return ASTList.length(paramASTList);
    }

    protected String getSuperName() {
        return MemberResolver.javaToJvmName(MemberResolver.getSuperclass(this.thisClass).getName());
    }

    protected String getThisName() {
        return MemberResolver.javaToJvmName(this.thisClass.getName());
    }

    protected String resolveClassName(String paramString) {
        return this.resolver.resolveJvmClassName(paramString);
    }

    protected String resolveClassName(ASTList paramASTList) {
        return this.resolver.resolveClassName(paramASTList);
    }

    void setReturnType(String paramString) {
        int i = paramString.indexOf(')');
        if (i < 0) {
            badMethod();
        }
        i += 1;
        char c = paramString.charAt(i);
        int j = 0;
        while (c == '[') {
            j += 1;
            i += 1;
            c = paramString.charAt(i);
        }
        this.arrayDim = j;
        if (c == 'L') {
            j = paramString.indexOf(';', i + 1);
            if (j < 0) {
                badMethod();
            }
            this.exprType = 307;
            this.className = paramString.substring(i + 1, j);
            return;
        }
        this.exprType = MemberResolver.descToType(c);
        this.className = null;
    }

    public void setThisMethod(MethodInfo paramMethodInfo) {
        this.thisMethod = paramMethodInfo;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/TypeChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */