package javassist.compiler;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtPrimitiveType;
import javassist.NotFoundException;
import javassist.bytecode.Bytecode;
import javassist.bytecode.Descriptor;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.CastExpr;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.Stmnt;
import javassist.compiler.ast.Symbol;

public class JvstCodeGen
        extends MemberCodeGen {
    public static final String cflowName = "$cflow";
    public static final String clazzName = "$class";
    public static final String dollarTypeName = "$type";
    public static final String sigName = "$sig";
    public static final String wrapperCastName = "$w";
    private CtClass dollarType = null;
    private String param0Type = null;
    String paramArrayName = null;
    String paramListName = null;
    CtClass[] paramTypeList = null;
    private int paramVarBase = 0;
    ProceedHandler procHandler = null;
    String proceedName = null;
    String returnCastName = null;
    CtClass returnType = null;
    private String returnVarName = null;
    private boolean useParam0 = false;

    public JvstCodeGen(Bytecode paramBytecode, CtClass paramCtClass, ClassPool paramClassPool) {
        super(paramBytecode, paramCtClass, paramClassPool);
        setTypeChecker(new JvstTypeChecker(paramCtClass, paramClassPool, this));
    }

    private void callGetType(String paramString) {
        this.bytecode.addInvokestatic("javassist/runtime/Desc", paramString, "(Ljava/lang/String;)Ljava/lang/Class;");
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/Class";
    }

    public static int compileParameterList(Bytecode paramBytecode, CtClass[] paramArrayOfCtClass, int paramInt) {
        if (paramArrayOfCtClass == null) {
            paramBytecode.addIconst(0);
            paramBytecode.addAnewarray("java.lang.Object");
            return 1;
        }
        CtClass[] arrayOfCtClass = new CtClass[1];
        int j = paramArrayOfCtClass.length;
        paramBytecode.addIconst(j);
        paramBytecode.addAnewarray("java.lang.Object");
        int i = 0;
        if (i < j) {
            paramBytecode.addOpcode(89);
            paramBytecode.addIconst(i);
            if (paramArrayOfCtClass[i].isPrimitive()) {
                CtPrimitiveType localCtPrimitiveType = (CtPrimitiveType) paramArrayOfCtClass[i];
                String str = localCtPrimitiveType.getWrapperName();
                paramBytecode.addNew(str);
                paramBytecode.addOpcode(89);
                int k = paramBytecode.addLoad(paramInt, localCtPrimitiveType);
                arrayOfCtClass[0] = localCtPrimitiveType;
                paramBytecode.addInvokespecial(str, "<init>", Descriptor.ofMethod(CtClass.voidType, arrayOfCtClass));
                paramInt = k + paramInt;
            }
            for (; ; ) {
                paramBytecode.addOpcode(83);
                i += 1;
                break;
                paramBytecode.addAload(paramInt);
                paramInt += 1;
            }
        }
        return 8;
    }

    private int indexOfParam1() {
        int j = this.paramVarBase;
        if (this.useParam0) {
        }
        for (int i = 1; ; i = 0) {
            return i + j;
        }
    }

    private static void makeCflowName(StringBuffer paramStringBuffer, ASTree paramASTree) {
        if ((paramASTree instanceof Symbol)) {
            paramStringBuffer.append(((Symbol) paramASTree).get());
            return;
        }
        if ((paramASTree instanceof Expr)) {
            paramASTree = (Expr) paramASTree;
            if (paramASTree.getOperator() == 46) {
                makeCflowName(paramStringBuffer, paramASTree.oprand1());
                paramStringBuffer.append('.');
                makeCflowName(paramStringBuffer, paramASTree.oprand2());
                return;
            }
        }
        throw new CompileError("bad $cflow");
    }

    private int recordVar(CtClass paramCtClass, String paramString, int paramInt, SymbolTable paramSymbolTable) {
        if (paramCtClass == CtClass.voidType) {
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/Object";
        }
        for (; ; ) {
            paramSymbolTable.append(paramString, new Declarator(this.exprType, this.className, this.arrayDim, paramInt, new Symbol(paramString)));
            if (!is2word(this.exprType, this.arrayDim)) {
                break;
            }
            return 2;
            setType(paramCtClass);
        }
        return 1;
    }

    private void setType(CtClass paramCtClass, int paramInt) {
        if (paramCtClass.isPrimitive()) {
            this.exprType = MemberResolver.descToType(((CtPrimitiveType) paramCtClass).getDescriptor());
            this.arrayDim = paramInt;
            this.className = null;
            return;
        }
        if (paramCtClass.isArray()) {
            try {
                setType(paramCtClass.getComponentType(), paramInt + 1);
                return;
            } catch (NotFoundException localNotFoundException) {
                throw new CompileError("undefined type: " + paramCtClass.getName());
            }
        }
        this.exprType = 307;
        this.arrayDim = paramInt;
        this.className = MemberResolver.javaToJvmName(paramCtClass.getName());
    }

    public void addNullIfVoid() {
        if (this.exprType == 344) {
            this.bytecode.addOpcode(1);
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/Object";
        }
    }

    protected void atAssignParamList(CtClass[] paramArrayOfCtClass, Bytecode paramBytecode) {
        if (paramArrayOfCtClass == null) {
            return;
        }
        int j = indexOfParam1();
        int m = paramArrayOfCtClass.length;
        int i = 0;
        label17:
        if (i < m) {
            paramBytecode.addOpcode(89);
            paramBytecode.addIconst(i);
            paramBytecode.addOpcode(50);
            compileUnwrapValue(paramArrayOfCtClass[i], paramBytecode);
            paramBytecode.addStore(j, paramArrayOfCtClass[i]);
            if (!is2word(this.exprType, this.arrayDim)) {
                break label89;
            }
        }
        label89:
        for (int k = 2; ; k = 1) {
            j += k;
            i += 1;
            break label17;
            break;
        }
    }

    public void atCallExpr(CallExpr paramCallExpr) {
        Object localObject = paramCallExpr.oprand1();
        if ((localObject instanceof Member)) {
            localObject = ((Member) localObject).get();
            if ((this.procHandler != null) && (((String) localObject).equals(this.proceedName))) {
                this.procHandler.doit(this, this.bytecode, (ASTList) paramCallExpr.oprand2());
                return;
            }
            if (((String) localObject).equals("$cflow")) {
                atCflow((ASTList) paramCallExpr.oprand2());
                return;
            }
        }
        super.atCallExpr(paramCallExpr);
    }

    public void atCastExpr(CastExpr paramCastExpr) {
        Object localObject = paramCastExpr.getClassName();
        if ((localObject != null) && (paramCastExpr.getArrayDim() == 0)) {
            ASTree localASTree = ((ASTList) localObject).head();
            if (((localASTree instanceof Symbol)) && (((ASTList) localObject).tail() == null)) {
                localObject = ((Symbol) localASTree).get();
                if (((String) localObject).equals(this.returnCastName)) {
                    atCastToRtype(paramCastExpr);
                    return;
                }
                if (((String) localObject).equals("$w")) {
                    atCastToWrapper(paramCastExpr);
                    return;
                }
            }
        }
        super.atCastExpr(paramCastExpr);
    }

    protected void atCastToRtype(CastExpr paramCastExpr) {
        paramCastExpr.getOprand().accept(this);
        if ((this.exprType == 344) || (isRefType(this.exprType)) || (this.arrayDim > 0)) {
            compileUnwrapValue(this.returnType, this.bytecode);
            return;
        }
        if ((this.returnType instanceof CtPrimitiveType)) {
            int i = MemberResolver.descToType(((CtPrimitiveType) this.returnType).getDescriptor());
            atNumCastExpr(this.exprType, i);
            this.exprType = i;
            this.arrayDim = 0;
            this.className = null;
            return;
        }
        throw new CompileError("invalid cast");
    }

    protected void atCastToWrapper(CastExpr paramCastExpr) {
        paramCastExpr.getOprand().accept(this);
        if ((isRefType(this.exprType)) || (this.arrayDim > 0)) {
        }
        do {
            return;
            paramCastExpr = this.resolver.lookupClass(this.exprType, this.arrayDim, this.className);
        } while (!(paramCastExpr instanceof CtPrimitiveType));
        paramCastExpr = (CtPrimitiveType) paramCastExpr;
        String str = paramCastExpr.getWrapperName();
        this.bytecode.addNew(str);
        this.bytecode.addOpcode(89);
        if (paramCastExpr.getDataSize() > 1) {
            this.bytecode.addOpcode(94);
        }
        for (; ; ) {
            this.bytecode.addOpcode(88);
            this.bytecode.addInvokespecial(str, "<init>", "(" + paramCastExpr.getDescriptor() + ")V");
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/Object";
            return;
            this.bytecode.addOpcode(93);
        }
    }

    protected void atCflow(ASTList paramASTList) {
        Object localObject = new StringBuffer();
        if ((paramASTList == null) || (paramASTList.tail() != null)) {
            throw new CompileError("bad $cflow");
        }
        makeCflowName((StringBuffer) localObject, paramASTList.head());
        paramASTList = ((StringBuffer) localObject).toString();
        localObject = this.resolver.getClassPool().lookupCflow(paramASTList);
        if (localObject == null) {
            throw new CompileError("no such $cflow: " + paramASTList);
        }
        this.bytecode.addGetstatic((String) localObject[0], (String) localObject[1], "Ljavassist/runtime/Cflow;");
        this.bytecode.addInvokevirtual("javassist.runtime.Cflow", "value", "()I");
        this.exprType = 324;
        this.arrayDim = 0;
        this.className = null;
    }

    protected void atFieldAssign(Expr paramExpr, int paramInt, ASTree paramASTree1, ASTree paramASTree2, boolean paramBoolean) {
        if (((paramASTree1 instanceof Member)) && (((Member) paramASTree1).get().equals(this.paramArrayName))) {
            if (paramInt != 61) {
                throw new CompileError("bad operator for " + this.paramArrayName);
            }
            paramASTree2.accept(this);
            if ((this.arrayDim != 1) || (this.exprType != 307)) {
                throw new CompileError("invalid type for " + this.paramArrayName);
            }
            atAssignParamList(this.paramTypeList, this.bytecode);
            if (!paramBoolean) {
                this.bytecode.addOpcode(87);
            }
            return;
        }
        super.atFieldAssign(paramExpr, paramInt, paramASTree1, paramASTree2, paramBoolean);
    }

    public void atMember(Member paramMember) {
        String str = paramMember.get();
        if (str.equals(this.paramArrayName)) {
            compileParameterList(this.bytecode, this.paramTypeList, indexOfParam1());
            this.exprType = 307;
            this.arrayDim = 1;
            this.className = "java/lang/Object";
            return;
        }
        if (str.equals("$sig")) {
            this.bytecode.addLdc(Descriptor.ofMethod(this.returnType, this.paramTypeList));
            this.bytecode.addInvokestatic("javassist/runtime/Desc", "getParams", "(Ljava/lang/String;)[Ljava/lang/Class;");
            this.exprType = 307;
            this.arrayDim = 1;
            this.className = "java/lang/Class";
            return;
        }
        if (str.equals("$type")) {
            if (this.dollarType == null) {
                throw new CompileError("$type is not available");
            }
            this.bytecode.addLdc(Descriptor.of(this.dollarType));
            callGetType("getType");
            return;
        }
        if (str.equals("$class")) {
            if (this.param0Type == null) {
                throw new CompileError("$class is not available");
            }
            this.bytecode.addLdc(this.param0Type);
            callGetType("getClazz");
            return;
        }
        super.atMember(paramMember);
    }

    public void atMethodArgs(ASTList paramASTList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString) {
        CtClass[] arrayOfCtClass = this.paramTypeList;
        String str = this.paramListName;
        int i = 0;
        if (paramASTList != null) {
            Object localObject = paramASTList.head();
            if (((localObject instanceof Member)) && (((Member) localObject).get().equals(str))) {
                if (arrayOfCtClass == null) {
                    break label198;
                }
                int n = arrayOfCtClass.length;
                int m = indexOfParam1();
                int k = 0;
                int j = i;
                for (; ; ) {
                    i = j;
                    if (k >= n) {
                        break;
                    }
                    localObject = arrayOfCtClass[k];
                    m += this.bytecode.addLoad(m, (CtClass) localObject);
                    setType((CtClass) localObject);
                    paramArrayOfInt1[j] = this.exprType;
                    paramArrayOfInt2[j] = this.arrayDim;
                    paramArrayOfString[j] = this.className;
                    k += 1;
                    j += 1;
                }
            }
            ((ASTree) localObject).accept(this);
            paramArrayOfInt1[i] = this.exprType;
            paramArrayOfInt2[i] = this.arrayDim;
            paramArrayOfString[i] = this.className;
            i += 1;
        }
        label198:
        for (; ; ) {
            paramASTList = paramASTList.tail();
            break;
            return;
        }
    }

    protected void atReturnStmnt(Stmnt paramStmnt) {
        ASTree localASTree = paramStmnt.getLeft();
        paramStmnt = localASTree;
        if (localASTree != null) {
            paramStmnt = localASTree;
            if (this.returnType == CtClass.voidType) {
                compileExpr(localASTree);
                if (!is2word(this.exprType, this.arrayDim)) {
                    break label59;
                }
                this.bytecode.addOpcode(88);
            }
        }
        for (; ; ) {
            paramStmnt = null;
            atReturnStmnt2(paramStmnt);
            return;
            label59:
            if (this.exprType != 344) {
                this.bytecode.addOpcode(87);
            }
        }
    }

    void compileInvokeSpecial(ASTree paramASTree, String paramString1, String paramString2, String paramString3, ASTList paramASTList) {
        paramASTree.accept(this);
        int i = getMethodArgsLength(paramASTList);
        atMethodArgs(paramASTList, new int[i], new int[i], new String[i]);
        this.bytecode.addInvokespecial(paramString1, paramString2, paramString3);
        setReturnType(paramString3, false, false);
        addNullIfVoid();
    }

    protected void compileUnwrapValue(CtClass paramCtClass, Bytecode paramBytecode) {
        if (paramCtClass == CtClass.voidType) {
            addNullIfVoid();
            return;
        }
        if (this.exprType == 344) {
            throw new CompileError("invalid type for " + this.returnCastName);
        }
        if ((paramCtClass instanceof CtPrimitiveType)) {
            CtPrimitiveType localCtPrimitiveType = (CtPrimitiveType) paramCtClass;
            String str = localCtPrimitiveType.getWrapperName();
            paramBytecode.addCheckcast(str);
            paramBytecode.addInvokevirtual(str, localCtPrimitiveType.getGetMethodName(), localCtPrimitiveType.getGetMethodDescriptor());
            setType(paramCtClass);
            return;
        }
        paramBytecode.addCheckcast(paramCtClass);
        setType(paramCtClass);
    }

    public void doNumCast(CtClass paramCtClass) {
        if ((this.arrayDim == 0) && (!isRefType(this.exprType))) {
            if ((paramCtClass instanceof CtPrimitiveType)) {
                paramCtClass = (CtPrimitiveType) paramCtClass;
                atNumCastExpr(this.exprType, MemberResolver.descToType(paramCtClass.getDescriptor()));
            }
        } else {
            return;
        }
        throw new CompileError("type mismatch");
    }

    public int getMethodArgsLength(ASTList paramASTList) {
        String str = this.paramListName;
        int i = 0;
        if (paramASTList != null) {
            ASTree localASTree = paramASTList.head();
            if (((localASTree instanceof Member)) && (((Member) localASTree).get().equals(str))) {
                if (this.paramTypeList == null) {
                    break label72;
                }
                i = this.paramTypeList.length + i;
            }
        }
        label72:
        for (; ; ) {
            paramASTList = paramASTList.tail();
            break;
            i += 1;
            continue;
            return i;
        }
    }

    public boolean isParamListName(ASTList paramASTList) {
        if ((this.paramTypeList != null) && (paramASTList != null) && (paramASTList.tail() == null)) {
            paramASTList = paramASTList.head();
            return ((paramASTList instanceof Member)) && (((Member) paramASTList).get().equals(this.paramListName));
        }
        return false;
    }

    public int recordParams(CtClass[] paramArrayOfCtClass, boolean paramBoolean, String paramString1, String paramString2, String paramString3, SymbolTable paramSymbolTable) {
        if (!paramBoolean) {
        }
        for (boolean bool = true; ; bool = false) {
            return recordParams(paramArrayOfCtClass, paramBoolean, paramString1, paramString2, paramString3, bool, 0, getThisName(), paramSymbolTable);
        }
    }

    public int recordParams(CtClass[] paramArrayOfCtClass, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, int paramInt, String paramString4, SymbolTable paramSymbolTable) {
        this.paramTypeList = paramArrayOfCtClass;
        this.paramArrayName = paramString2;
        this.paramListName = paramString3;
        this.paramVarBase = paramInt;
        this.useParam0 = paramBoolean2;
        if (paramString4 != null) {
            this.param0Type = MemberResolver.jvmToJavaName(paramString4);
        }
        this.inStaticMethod = paramBoolean1;
        int i = paramInt;
        if (paramBoolean2) {
            paramString2 = paramString1 + "0";
            paramSymbolTable.append(paramString2, new Declarator(307, MemberResolver.javaToJvmName(paramString4), 0, paramInt, new Symbol(paramString2)));
            i = paramInt + 1;
        }
        paramInt = 0;
        while (paramInt < paramArrayOfCtClass.length) {
            i += recordVar(paramArrayOfCtClass[paramInt], paramString1 + (paramInt + 1), i, paramSymbolTable);
            paramInt += 1;
        }
        if (getMaxLocals() < i) {
            setMaxLocals(i);
        }
        return i;
    }

    public int recordReturnType(CtClass paramCtClass, String paramString1, String paramString2, SymbolTable paramSymbolTable) {
        this.returnType = paramCtClass;
        this.returnCastName = paramString1;
        this.returnVarName = paramString2;
        if (paramString2 == null) {
            return -1;
        }
        int i = getMaxLocals();
        setMaxLocals(recordVar(paramCtClass, paramString2, i, paramSymbolTable) + i);
        return i;
    }

    public void recordType(CtClass paramCtClass) {
        this.dollarType = paramCtClass;
    }

    public int recordVariable(CtClass paramCtClass, String paramString, SymbolTable paramSymbolTable) {
        if (paramString == null) {
            return -1;
        }
        int i = getMaxLocals();
        setMaxLocals(recordVar(paramCtClass, paramString, i, paramSymbolTable) + i);
        return i;
    }

    public void recordVariable(String paramString1, String paramString2, int paramInt, SymbolTable paramSymbolTable) {
        int i = 0;
        char c;
        for (; ; ) {
            c = paramString1.charAt(i);
            if (c != '[') {
                break;
            }
            i += 1;
        }
        int j = MemberResolver.descToType(c);
        String str = null;
        if (j == 307) {
            if (i != 0) {
                break label92;
            }
        }
        label92:
        for (str = paramString1.substring(1, paramString1.length() - 1); ; str = paramString1.substring(i + 1, paramString1.length() - 1)) {
            paramSymbolTable.append(paramString2, new Declarator(j, str, i, paramInt, new Symbol(paramString2)));
            return;
        }
    }

    public void setProceedHandler(ProceedHandler paramProceedHandler, String paramString) {
        this.proceedName = paramString;
        this.procHandler = paramProceedHandler;
    }

    public void setType(CtClass paramCtClass) {
        setType(paramCtClass, 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/JvstCodeGen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */