package javassist.compiler;

import java.util.ArrayList;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.ArrayInit;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.Keyword;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.MethodDecl;
import javassist.compiler.ast.NewExpr;
import javassist.compiler.ast.Pair;
import javassist.compiler.ast.Stmnt;
import javassist.compiler.ast.Symbol;

public class MemberCodeGen
        extends CodeGen {
    protected MemberResolver resolver;
    protected boolean resultStatic;
    protected CtClass thisClass;
    protected MethodInfo thisMethod;

    public MemberCodeGen(Bytecode paramBytecode, CtClass paramCtClass, ClassPool paramClassPool) {
        super(paramBytecode);
        this.resolver = new MemberResolver(paramClassPool);
        this.thisClass = paramCtClass;
        this.thisMethod = null;
    }

    private int addFieldrefInfo(CtField paramCtField, FieldInfo paramFieldInfo) {
        ConstPool localConstPool = this.bytecode.getConstPool();
        return localConstPool.addFieldrefInfo(localConstPool.addClassInfo(paramCtField.getDeclaringClass().getName()), paramFieldInfo.getName(), paramFieldInfo.getDescriptor());
    }

    private void addFinally(ArrayList paramArrayList, Stmnt paramStmnt) {
        Bytecode localBytecode = this.bytecode;
        int j = paramArrayList.size();
        int i = 0;
        while (i < j) {
            Object localObject = (int[]) paramArrayList.get(i);
            int k = localObject[0];
            localBytecode.write16bit(k, localBytecode.currentPc() - k + 1);
            localObject = new MemberCodeGen.JsrHook2(this, (int[]) localObject);
            paramStmnt.accept(this);
            ((CodeGen.ReturnHook) localObject).remove(this);
            if (!this.hasReturned) {
                localBytecode.addOpcode(167);
                localBytecode.addIndex(k + 3 - localBytecode.currentPc());
            }
            i += 1;
        }
    }

    private void atArrayLength(ASTree paramASTree) {
        if (this.arrayDim == 0) {
            throw new CompileError(".length applied to a non array");
        }
        this.bytecode.addOpcode(190);
        this.exprType = 324;
        this.arrayDim = 0;
    }

    private void atFieldAssignCore(CtField paramCtField, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
        int i = -2;
        if (paramInt != 0) {
            if (paramBoolean1) {
                this.bytecode.add(179);
                paramCtField = this.bytecode;
                if (paramBoolean2) {
                    paramCtField.growStack(i);
                }
            }
            for (; ; ) {
                this.bytecode.addIndex(paramInt);
                return;
                i = -1;
                break;
                this.bytecode.add(181);
                paramCtField = this.bytecode;
                if (paramBoolean2) {
                    i = -3;
                }
                paramCtField.growStack(i);
            }
        }
        CtClass localCtClass = paramCtField.getDeclaringClass();
        paramCtField = localCtClass.getAccessorMaker().getFieldSetter(paramCtField.getFieldInfo2(), paramBoolean1);
        this.bytecode.addInvokestatic(localCtClass, paramCtField.getName(), paramCtField.getDescriptor());
    }

    private int atFieldRead(CtField paramCtField, boolean paramBoolean) {
        int j = 1;
        int i = 1;
        Object localObject = paramCtField.getFieldInfo2();
        boolean bool = setFieldType((FieldInfo) localObject);
        AccessorMaker localAccessorMaker = isAccessibleField(paramCtField, (FieldInfo) localObject);
        if (localAccessorMaker != null) {
            localObject = localAccessorMaker.getFieldGetter((FieldInfo) localObject, paramBoolean);
            this.bytecode.addInvokestatic(paramCtField.getDeclaringClass(), ((MethodInfo) localObject).getName(), ((MethodInfo) localObject).getDescriptor());
            return 0;
        }
        int k = addFieldrefInfo(paramCtField, (FieldInfo) localObject);
        if (paramBoolean) {
            this.bytecode.add(178);
            paramCtField = this.bytecode;
            if (bool) {
                i = 2;
            }
            paramCtField.growStack(i);
            this.bytecode.addIndex(k);
            return k;
        }
        this.bytecode.add(180);
        paramCtField = this.bytecode;
        if (bool) {
        }
        for (i = j; ; i = 0) {
            paramCtField.growStack(i);
            break;
        }
    }

    private void atMethodCallCore2(CtClass paramCtClass, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, MemberResolver.Method paramMethod) {
        CtClass localCtClass = paramMethod.declaring;
        MethodInfo localMethodInfo = paramMethod.info;
        paramMethod = localMethodInfo.getDescriptor();
        int i = localMethodInfo.getAccessFlags();
        boolean bool2;
        boolean bool1;
        if (paramString.equals("<init>")) {
            bool2 = true;
            bool1 = true;
            if (localCtClass != paramCtClass) {
                throw new CompileError("no such constructor");
            }
            paramBoolean2 = bool2;
            if (localCtClass == this.thisClass) {
                break label410;
            }
            paramBoolean2 = bool2;
            if (!AccessFlag.isPrivate(i)) {
                break label410;
            }
            paramMethod = getAccessibleConstructor(paramMethod, localCtClass, localMethodInfo);
            this.bytecode.addOpcode(1);
            paramBoolean2 = bool1;
        }
        label155:
        label170:
        label403:
        label410:
        for (; ; ) {
            bool1 = false;
            bool2 = false;
            if ((i & 0x8) != 0) {
                paramBoolean2 = bool2;
                bool1 = paramBoolean1;
                if (!paramBoolean1) {
                    bool1 = true;
                    if (paramInt1 >= 0) {
                        this.bytecode.write(paramInt1, 0);
                        paramBoolean2 = bool2;
                    }
                } else {
                    this.bytecode.addInvokestatic(localCtClass, paramString, paramMethod);
                    paramBoolean1 = bool1;
                    setReturnType(paramMethod, paramBoolean1, paramBoolean2);
                    return;
                    if (!AccessFlag.isPrivate(i)) {
                        break label410;
                    }
                    if (localCtClass == this.thisClass) {
                        paramBoolean2 = true;
                        continue;
                    }
                    paramBoolean2 = false;
                    if ((i & 0x8) != 0) {
                        break label403;
                    }
                }
            }
            for (Object localObject = Descriptor.insertParameter(localCtClass.getName(), paramMethod); ; localObject = paramMethod) {
                i = AccessFlag.setPackage(i);
                paramString = getAccessiblePrivate(paramString, paramMethod, (String) localObject, localMethodInfo, localCtClass);
                i |= 0x8;
                paramBoolean1 = true;
                paramMethod = (MemberResolver.Method) localObject;
                break;
                paramBoolean2 = true;
                break label155;
                if (paramBoolean2) {
                    this.bytecode.addInvokespecial(localCtClass, paramString, paramMethod);
                    paramBoolean2 = bool1;
                    break label170;
                }
                if (Modifier.isPublic(localCtClass.getModifiers())) {
                    localObject = localCtClass;
                    if (localCtClass.isInterface() == paramCtClass.isInterface()) {
                    }
                } else {
                    localObject = paramCtClass;
                }
                if (((CtClass) localObject).isInterface()) {
                    this.bytecode.addInvokeinterface((CtClass) localObject, paramString, paramMethod, paramInt2);
                    paramBoolean2 = bool1;
                    break label170;
                }
                if (paramBoolean1) {
                    throw new CompileError(paramString + " is not static");
                }
                this.bytecode.addInvokevirtual((CtClass) localObject, paramString, paramMethod);
                paramBoolean2 = bool1;
                break label170;
            }
        }
    }

    private void atNewArrayExpr2(int paramInt, ASTree paramASTree, String paramString, ArrayInit paramArrayInit) {
        if (paramArrayInit == null) {
            if (paramASTree == null) {
                throw new CompileError("no array size");
            }
            paramASTree.accept(this);
        }
        int i;
        while (paramInt == 307) {
            paramASTree = resolveClassName(paramString);
            this.bytecode.addAnewarray(MemberResolver.jvmToJavaName(paramASTree));
            if (paramArrayInit == null) {
                break label334;
            }
            int j = paramArrayInit.length();
            i = 0;
            while (i < j) {
                this.bytecode.addOpcode(89);
                this.bytecode.addIconst(i);
                paramArrayInit.head().accept(this);
                if (!isRefType(paramInt)) {
                    atNumCastExpr(this.exprType, paramInt);
                }
                this.bytecode.addOpcode(getArrayWriteOp(paramInt, 0));
                paramArrayInit = paramArrayInit.tail();
                i += 1;
            }
            if (paramASTree == null) {
                i = paramArrayInit.length();
                this.bytecode.addIconst(i);
            } else {
                throw new CompileError("unnecessary array size specified for new");
            }
        }
        paramASTree = null;
        switch (paramInt) {
            default:
                i = 0;
                badNewExpr();
        }
        for (; ; ) {
            this.bytecode.addOpcode(188);
            this.bytecode.add(i);
            break;
            i = 4;
            continue;
            i = 5;
            continue;
            i = 6;
            continue;
            i = 7;
            continue;
            i = 8;
            continue;
            i = 9;
            continue;
            i = 10;
            continue;
            i = 11;
        }
        label334:
        this.exprType = paramInt;
        this.arrayDim = 1;
        this.className = paramASTree;
    }

    private static void badLvalue() {
        throw new CompileError("bad l-value");
    }

    private static void badMethod() {
        throw new CompileError("bad method");
    }

    private static void badNewExpr() {
        throw new CompileError("bad new expression");
    }

    private AccessorMaker isAccessibleField(CtField paramCtField, FieldInfo paramFieldInfo) {
        if ((AccessFlag.isPrivate(paramFieldInfo.getAccessFlags())) && (paramCtField.getDeclaringClass() != this.thisClass)) {
            paramFieldInfo = paramCtField.getDeclaringClass();
            if (isEnclosing(paramFieldInfo, this.thisClass)) {
                paramCtField = paramFieldInfo.getAccessorMaker();
                if (paramCtField != null) {
                    return paramCtField;
                }
                throw new CompileError("fatal error.  bug?");
            }
            throw new CompileError("Field " + paramCtField.getName() + " in " + paramFieldInfo.getName() + " is private.");
        }
        return null;
    }

    private boolean isEnclosing(CtClass paramCtClass1, CtClass paramCtClass2) {
        while (paramCtClass2 != null) {
            try {
                CtClass localCtClass = paramCtClass2.getDeclaringClass();
                paramCtClass2 = localCtClass;
                if (localCtClass == paramCtClass1) {
                    return true;
                }
            } catch (NotFoundException paramCtClass1) {
            }
        }
        return false;
    }

    private boolean setFieldType(FieldInfo paramFieldInfo) {
        boolean bool = false;
        paramFieldInfo = paramFieldInfo.getDescriptor();
        char c = paramFieldInfo.charAt(0);
        int j = 0;
        int i = 0;
        while (c == '[') {
            j += 1;
            i += 1;
            c = paramFieldInfo.charAt(i);
        }
        this.arrayDim = j;
        this.exprType = MemberResolver.descToType(c);
        if (c == 'L') {
        }
        for (this.className = paramFieldInfo.substring(i + 1, paramFieldInfo.indexOf(';', i + 1)); ; this.className = null) {
            if ((c == 'J') || (c == 'D')) {
                bool = true;
            }
            return bool;
        }
    }

    public void atArrayInit(ArrayInit paramArrayInit) {
        throw new CompileError("array initializer is not supported");
    }

    protected void atArrayVariableAssign(ArrayInit paramArrayInit, int paramInt1, int paramInt2, String paramString) {
        atNewArrayExpr2(paramInt1, null, paramString, paramArrayInit);
    }

    public void atCallExpr(CallExpr paramCallExpr) {
        boolean bool3 = true;
        boolean bool1 = true;
        boolean bool2 = false;
        ASTree localASTree = paramCallExpr.oprand1();
        ASTList localASTList = (ASTList) paramCallExpr.oprand2();
        MemberResolver.Method localMethod = paramCallExpr.getMethod();
        Object localObject;
        int i;
        if ((localASTree instanceof Member)) {
            paramCallExpr = ((Member) localASTree).get();
            localObject = this.thisClass;
            if ((this.inStaticMethod) || ((localMethod != null) && (localMethod.isStatic()))) {
                i = -1;
                bool2 = false;
            }
        }
        for (; ; ) {
            atMethodCallCore((CtClass) localObject, paramCallExpr, localASTList, bool1, bool2, i, localMethod);
            return;
            i = this.bytecode.currentPc();
            this.bytecode.addAload(0);
            bool1 = false;
            bool2 = false;
            continue;
            if ((localASTree instanceof Keyword)) {
                localObject = this.thisClass;
                if (this.inStaticMethod) {
                    throw new CompileError("a constructor cannot be static");
                }
                this.bytecode.addAload(0);
                if (((Keyword) localASTree).get() == 336) {
                    localObject = MemberResolver.getSuperclass((CtClass) localObject);
                    i = -1;
                    bool1 = false;
                    paramCallExpr = "<init>";
                    bool2 = true;
                }
            } else {
                if ((localASTree instanceof Expr)) {
                    localObject = (Expr) localASTree;
                    paramCallExpr = ((Symbol) ((Expr) localObject).oprand2()).get();
                    i = ((Expr) localObject).getOperator();
                    if (i == 35) {
                        localObject = this.resolver.lookupClass(((Symbol) ((Expr) localObject).oprand1()).get(), false);
                        bool1 = bool3;
                        label254:
                        i = -1;
                        continue;
                    }
                    if (i == 46) {
                        localObject = ((Expr) localObject).oprand1();
                        if ((!(localObject instanceof Keyword)) || (((Keyword) localObject).get() != 336)) {
                            break label444;
                        }
                    }
                }
                label444:
                for (bool1 = true; ; bool1 = false) {
                    try {
                        ((ASTree) localObject).accept(this);
                        bool2 = false;
                    } catch (NoFieldException localNoFieldException) {
                        for (; ; ) {
                            if (localNoFieldException.getExpr() != localObject) {
                                throw localNoFieldException;
                            }
                            this.exprType = 307;
                            this.arrayDim = 0;
                            this.className = localNoFieldException.getField();
                            bool2 = true;
                            continue;
                            if (this.exprType == 307) {
                                localObject = this.resolver.lookupClassByJvmName(this.className);
                            } else {
                                localObject = null;
                                badMethod();
                            }
                        }
                    }
                    if (this.arrayDim > 0) {
                        localObject = this.resolver.lookupClass("java.lang.Object", true);
                        bool3 = bool2;
                        bool2 = bool1;
                        bool1 = bool3;
                        break label254;
                    }
                    bool1 = false;
                    localObject = null;
                    badMethod();
                    break label254;
                    i = -1;
                    bool1 = false;
                    localObject = null;
                    paramCallExpr = null;
                    bool2 = false;
                    fatal();
                    break;
                }
            }
            i = -1;
            bool1 = false;
            paramCallExpr = "<init>";
            bool2 = true;
        }
    }

    protected void atClassObject2(String paramString) {
        if (getMajorVersion() < 49) {
            super.atClassObject2(paramString);
            return;
        }
        this.bytecode.addLdc(this.bytecode.getConstPool().addClassInfo(paramString));
    }

    protected void atFieldAssign(Expr paramExpr, int paramInt, ASTree paramASTree1, ASTree paramASTree2, boolean paramBoolean) {
        paramASTree1 = fieldAccess(paramASTree1, false);
        boolean bool1 = this.resultStatic;
        if ((paramInt != 61) && (!bool1)) {
            this.bytecode.addOpcode(89);
        }
        Object localObject;
        int i;
        int j;
        int k;
        boolean bool2;
        if (paramInt == 61) {
            localObject = paramASTree1.getFieldInfo2();
            setFieldType((FieldInfo) localObject);
            if (isAccessibleField(paramASTree1, (FieldInfo) localObject) == null) {
                i = addFieldrefInfo(paramASTree1, (FieldInfo) localObject);
                j = this.exprType;
                k = this.arrayDim;
                localObject = this.className;
                atAssignCore(paramExpr, paramInt, paramASTree2, j, k, (String) localObject);
                bool2 = is2word(j, k);
                if (paramBoolean) {
                    if (!bool1) {
                        break label192;
                    }
                    if (!bool2) {
                        break label186;
                    }
                    paramInt = 92;
                }
            }
        }
        for (; ; ) {
            this.bytecode.addOpcode(paramInt);
            atFieldAssignCore(paramASTree1, bool1, i, bool2);
            this.exprType = j;
            this.arrayDim = k;
            this.className = ((String) localObject);
            return;
            i = 0;
            break;
            i = atFieldRead(paramASTree1, bool1);
            break;
            label186:
            paramInt = 89;
            continue;
            label192:
            if (bool2) {
                paramInt = 93;
            } else {
                paramInt = 90;
            }
        }
    }

    protected void atFieldPlusPlus(int paramInt, boolean paramBoolean1, ASTree paramASTree, Expr paramExpr, boolean paramBoolean2) {
        int i = 89;
        paramASTree = fieldAccess(paramASTree, false);
        boolean bool1 = this.resultStatic;
        if (!bool1) {
            this.bytecode.addOpcode(89);
        }
        int j = atFieldRead(paramASTree, bool1);
        boolean bool2 = is2word(this.exprType, this.arrayDim);
        if (bool1) {
            if (bool2) {
                i = 92;
            }
            atPlusPlusCore(i, paramBoolean2, paramInt, paramBoolean1, paramExpr);
            atFieldAssignCore(paramASTree, bool1, j, bool2);
            return;
        }
        if (bool2) {
        }
        for (i = 93; ; i = 90) {
            break;
        }
    }

    protected void atFieldRead(ASTree paramASTree) {
        CtField localCtField = fieldAccess(paramASTree, true);
        if (localCtField == null) {
            atArrayLength(paramASTree);
            return;
        }
        boolean bool = this.resultStatic;
        paramASTree = TypeChecker.getConstantFieldValue(localCtField);
        if (paramASTree == null) {
            atFieldRead(localCtField, bool);
            return;
        }
        paramASTree.accept(this);
        setFieldType(localCtField.getFieldInfo2());
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

    public void atMethodCallCore(CtClass paramCtClass, String paramString, ASTList paramASTList, boolean paramBoolean1, boolean paramBoolean2, int paramInt, MemberResolver.Method paramMethod) {
        int i = getMethodArgsLength(paramASTList);
        int[] arrayOfInt1 = new int[i];
        int[] arrayOfInt2 = new int[i];
        String[] arrayOfString = new String[i];
        boolean bool = paramBoolean1;
        if (!paramBoolean1) {
            bool = paramBoolean1;
            if (paramMethod != null) {
                bool = paramBoolean1;
                if (paramMethod.isStatic()) {
                    this.bytecode.addOpcode(87);
                    bool = true;
                }
            }
        }
        i = this.bytecode.getStackDepth();
        atMethodArgs(paramASTList, arrayOfInt1, arrayOfInt2, arrayOfString);
        int j = this.bytecode.getStackDepth();
        if (paramMethod == null) {
        }
        for (paramASTList = this.resolver.lookupMethod(paramCtClass, this.thisClass, this.thisMethod, paramString, arrayOfInt1, arrayOfInt2, arrayOfString); ; paramASTList = paramMethod) {
            if (paramASTList == null) {
                if (paramString.equals("<init>")) {
                }
                for (paramCtClass = "constructor not found"; ; paramCtClass = "Method " + paramString + " not found in " + paramCtClass.getName()) {
                    throw new CompileError(paramCtClass);
                }
            }
            atMethodCallCore2(paramCtClass, paramString, bool, paramBoolean2, paramInt, j - i + 1, paramASTList);
            return;
        }
    }

    protected void atMultiNewArray(int paramInt, ASTList paramASTList1, ASTList paramASTList2) {
        int j = paramASTList2.length();
        int i = 0;
        ASTree localASTree;
        if (paramASTList2 != null) {
            localASTree = paramASTList2.head();
            if (localASTree != null) {
            }
        } else {
            this.exprType = paramInt;
            this.arrayDim = j;
            if (paramInt != 307) {
                break label114;
            }
            this.className = resolveClassName(paramASTList1);
        }
        label114:
        for (paramASTList1 = toJvmArrayName(this.className, j); ; paramASTList1 = toJvmTypeName(paramInt, j)) {
            this.bytecode.addMultiNewarray(paramASTList1, i);
            return;
            localASTree.accept(this);
            if (this.exprType != 324) {
                throw new CompileError("bad type for array size");
            }
            paramASTList2 = paramASTList2.tail();
            i += 1;
            break;
        }
    }

    public void atNewArrayExpr(NewExpr paramNewExpr) {
        int i = paramNewExpr.getArrayType();
        ASTList localASTList1 = paramNewExpr.getArraySize();
        ASTList localASTList2 = paramNewExpr.getClassName();
        paramNewExpr = paramNewExpr.getInitializer();
        if (localASTList1.length() > 1) {
            if (paramNewExpr != null) {
                throw new CompileError("sorry, multi-dimensional array initializer for new is not supported");
            }
            atMultiNewArray(i, localASTList2, localASTList1);
            return;
        }
        atNewArrayExpr2(i, localASTList1.head(), Declarator.astToClassName(localASTList2, '/'), paramNewExpr);
    }

    public void atNewExpr(NewExpr paramNewExpr) {
        if (paramNewExpr.isArray()) {
            atNewArrayExpr(paramNewExpr);
            return;
        }
        CtClass localCtClass = this.resolver.lookupClassByName(paramNewExpr.getClassName());
        String str = localCtClass.getName();
        paramNewExpr = paramNewExpr.getArguments();
        this.bytecode.addNew(str);
        this.bytecode.addOpcode(89);
        atMethodCallCore(localCtClass, "<init>", paramNewExpr, false, true, -1, null);
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = MemberResolver.javaToJvmName(str);
    }

    protected void atTryStmnt(Stmnt paramStmnt) {
        Bytecode localBytecode = this.bytecode;
        Object localObject1 = (Stmnt) paramStmnt.getLeft();
        if (localObject1 == null) {
            return;
        }
        ASTList localASTList = (ASTList) paramStmnt.getRight().getLeft();
        Stmnt localStmnt = (Stmnt) paramStmnt.getRight().getRight().getLeft();
        ArrayList localArrayList = new ArrayList();
        paramStmnt = null;
        if (localStmnt != null) {
            paramStmnt = new MemberCodeGen.JsrHook(this);
        }
        int j = localBytecode.currentPc();
        ((Stmnt) localObject1).accept(this);
        int k = localBytecode.currentPc();
        if (j == k) {
            throw new CompileError("empty try block");
        }
        int i;
        label118:
        int m;
        if (!this.hasReturned) {
            i = 1;
            if (i != 0) {
                localBytecode.addOpcode(167);
                localArrayList.add(new Integer(localBytecode.currentPc()));
                localBytecode.addIndex(0);
            }
            m = getMaxLocals();
            incMaxLocals(1);
            label165:
            if (localASTList == null) {
                break label334;
            }
            Object localObject2 = (Pair) localASTList.head();
            localASTList = localASTList.tail();
            localObject1 = (Declarator) ((Pair) localObject2).getLeft();
            localObject2 = (Stmnt) ((Pair) localObject2).getRight();
            ((Declarator) localObject1).setLocalVar(m);
            CtClass localCtClass = this.resolver.lookupClassByJvmName(((Declarator) localObject1).getClassName());
            ((Declarator) localObject1).setClassName(MemberResolver.javaToJvmName(localCtClass.getName()));
            localBytecode.addExceptionHandler(j, k, localBytecode.currentPc(), localCtClass);
            localBytecode.growStack(1);
            localBytecode.addAstore(m);
            this.hasReturned = false;
            if (localObject2 != null) {
                ((Stmnt) localObject2).accept(this);
            }
            if (this.hasReturned) {
                break label464;
            }
            localBytecode.addOpcode(167);
            localArrayList.add(new Integer(localBytecode.currentPc()));
            localBytecode.addIndex(0);
            i = 1;
        }
        label334:
        label464:
        for (; ; ) {
            break label165;
            i = 0;
            break label118;
            if (localStmnt != null) {
                paramStmnt.remove(this);
                k = localBytecode.currentPc();
                localBytecode.addExceptionHandler(j, k, k, 0);
                localBytecode.growStack(1);
                localBytecode.addAstore(m);
                this.hasReturned = false;
                localStmnt.accept(this);
                if (!this.hasReturned) {
                    localBytecode.addAload(m);
                    localBytecode.addOpcode(191);
                }
                addFinally(paramStmnt.jsrList, localStmnt);
            }
            patchGoto(localArrayList, localBytecode.currentPc());
            if (i == 0) {
            }
            for (boolean bool = true; ; bool = false) {
                this.hasReturned = bool;
                if ((localStmnt == null) || (i == 0)) {
                    break;
                }
                localStmnt.accept(this);
                return;
            }
        }
    }

    protected CtField fieldAccess(ASTree paramASTree, boolean paramBoolean) {
        Object localObject1;
        if ((paramASTree instanceof Member)) {
            localObject1 = ((Member) paramASTree).get();
            try {
                CtField localCtField = this.thisClass.getField((String) localObject1);
                paramBoolean = Modifier.isStatic(localCtField.getModifiers());
                if (paramBoolean) {
                    break label97;
                }
                if (this.inStaticMethod) {
                    throw new CompileError("not available in a static method: " + (String) localObject1);
                }
            } catch (NotFoundException localNotFoundException) {
                throw new NoFieldException((String) localObject1, paramASTree);
            }
            this.bytecode.addAload(0);
            label97:
            this.resultStatic = paramBoolean;
            return localNotFoundException;
        }
        if ((paramASTree instanceof Expr)) {
            Object localObject2 = (Expr) paramASTree;
            int i = ((Expr) localObject2).getOperator();
            if (i == 35) {
                paramASTree = this.resolver.lookupField(((Symbol) ((Expr) localObject2).oprand1()).get(), (Symbol) ((Expr) localObject2).oprand2());
                this.resultStatic = true;
                return paramASTree;
            }
            if (i == 46) {
                try {
                    ((Expr) localObject2).oprand1().accept(this);
                    if ((this.exprType == 307) && (this.arrayDim == 0)) {
                        localObject1 = this.resolver.lookupFieldByJvmName(this.className, (Symbol) ((Expr) localObject2).oprand2());
                    }
                    for (; ; ) {
                        paramBoolean = Modifier.isStatic(((CtField) localObject1).getModifiers());
                        if (paramBoolean) {
                            this.bytecode.addOpcode(87);
                        }
                        this.resultStatic = paramBoolean;
                        return (CtField) localObject1;
                        if ((paramBoolean) && (this.arrayDim > 0) && (((Symbol) ((Expr) localObject2).oprand2()).get().equals("length"))) {
                            return null;
                        }
                        localObject1 = null;
                        badLvalue();
                    }
                    String str;
                    badLvalue();
                } catch (NoFieldException localNoFieldException) {
                    if (localNoFieldException.getExpr() != ((Expr) localObject2).oprand1()) {
                        throw localNoFieldException;
                    }
                    localObject2 = (Symbol) ((Expr) localObject2).oprand2();
                    str = localNoFieldException.getField();
                    paramASTree = this.resolver.lookupFieldByJvmName2(str, (Symbol) localObject2, paramASTree);
                    this.resultStatic = true;
                    return paramASTree;
                }
            }
        }
        for (; ; ) {
            this.resultStatic = false;
            return null;
            badLvalue();
        }
    }

    protected String getAccessibleConstructor(String paramString, CtClass paramCtClass, MethodInfo paramMethodInfo) {
        if (isEnclosing(paramCtClass, this.thisClass)) {
            AccessorMaker localAccessorMaker = paramCtClass.getAccessorMaker();
            if (localAccessorMaker != null) {
                return localAccessorMaker.getConstructor(paramCtClass, paramString, paramMethodInfo);
            }
        }
        throw new CompileError("the called constructor is private in " + paramCtClass.getName());
    }

    protected String getAccessiblePrivate(String paramString1, String paramString2, String paramString3, MethodInfo paramMethodInfo, CtClass paramCtClass) {
        if (isEnclosing(paramCtClass, this.thisClass)) {
            paramCtClass = paramCtClass.getAccessorMaker();
            if (paramCtClass != null) {
                return paramCtClass.getMethodAccessor(paramString1, paramString2, paramString3, paramMethodInfo);
            }
        }
        throw new CompileError("Method " + paramString1 + " is private");
    }

    public int getMajorVersion() {
        ClassFile localClassFile = this.thisClass.getClassFile2();
        if (localClassFile == null) {
            return ClassFile.MAJOR_VERSION;
        }
        return localClassFile.getMajorVersion();
    }

    public int getMethodArgsLength(ASTList paramASTList) {
        return ASTList.length(paramASTList);
    }

    protected String getSuperName() {
        return MemberResolver.javaToJvmName(MemberResolver.getSuperclass(this.thisClass).getName());
    }

    public CtClass getThisClass() {
        return this.thisClass;
    }

    protected String getThisName() {
        return MemberResolver.javaToJvmName(this.thisClass.getName());
    }

    protected void insertDefaultSuperCall() {
        this.bytecode.addAload(0);
        this.bytecode.addInvokespecial(MemberResolver.getSuperclass(this.thisClass), "<init>", "()V");
    }

    public CtClass[] makeParamList(MethodDecl paramMethodDecl) {
        paramMethodDecl = paramMethodDecl.getParams();
        if (paramMethodDecl == null) {
            return new CtClass[0];
        }
        CtClass[] arrayOfCtClass = new CtClass[paramMethodDecl.length()];
        int i = 0;
        while (paramMethodDecl != null) {
            arrayOfCtClass[i] = this.resolver.lookupClass((Declarator) paramMethodDecl.head());
            paramMethodDecl = paramMethodDecl.tail();
            i += 1;
        }
        return arrayOfCtClass;
    }

    public CtClass[] makeThrowsList(MethodDecl paramMethodDecl) {
        paramMethodDecl = paramMethodDecl.getThrows();
        if (paramMethodDecl == null) {
            return null;
        }
        CtClass[] arrayOfCtClass = new CtClass[paramMethodDecl.length()];
        int i = 0;
        while (paramMethodDecl != null) {
            arrayOfCtClass[i] = this.resolver.lookupClassByName((ASTList) paramMethodDecl.head());
            paramMethodDecl = paramMethodDecl.tail();
            i += 1;
        }
        return arrayOfCtClass;
    }

    protected String resolveClassName(String paramString) {
        return this.resolver.resolveJvmClassName(paramString);
    }

    protected String resolveClassName(ASTList paramASTList) {
        return this.resolver.resolveClassName(paramASTList);
    }

    void setReturnType(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        int i = paramString.indexOf(')');
        if (i < 0) {
            badMethod();
        }
        int j = i + 1;
        char c = paramString.charAt(j);
        i = 0;
        while (c == '[') {
            i += 1;
            j += 1;
            c = paramString.charAt(j);
        }
        this.arrayDim = i;
        int k;
        if (c == 'L') {
            k = paramString.indexOf(';', j + 1);
            if (k < 0) {
                badMethod();
            }
            this.exprType = 307;
        }
        for (this.className = paramString.substring(j + 1, k); ; this.className = null) {
            j = this.exprType;
            if ((paramBoolean1) && (paramBoolean2)) {
                if (!is2word(j, i)) {
                    break;
                }
                this.bytecode.addOpcode(93);
                this.bytecode.addOpcode(88);
                this.bytecode.addOpcode(87);
            }
            return;
            this.exprType = MemberResolver.descToType(c);
        }
        if (j == 344) {
            this.bytecode.addOpcode(87);
            return;
        }
        this.bytecode.addOpcode(95);
        this.bytecode.addOpcode(87);
    }

    public void setThisMethod(CtMethod paramCtMethod) {
        this.thisMethod = paramCtMethod.getMethodInfo2();
        if (this.typeChecker != null) {
            this.typeChecker.setThisMethod(this.thisMethod);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/MemberCodeGen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */