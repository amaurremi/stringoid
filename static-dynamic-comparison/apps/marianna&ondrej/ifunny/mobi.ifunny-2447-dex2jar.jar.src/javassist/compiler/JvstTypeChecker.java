package javassist.compiler;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtPrimitiveType;
import javassist.NotFoundException;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.CastExpr;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.Symbol;

public class JvstTypeChecker
        extends TypeChecker {
    private JvstCodeGen codeGen;

    public JvstTypeChecker(CtClass paramCtClass, ClassPool paramClassPool, JvstCodeGen paramJvstCodeGen) {
        super(paramCtClass, paramClassPool);
        this.codeGen = paramJvstCodeGen;
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
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/Object";
        }
    }

    public void atCallExpr(CallExpr paramCallExpr) {
        Object localObject = paramCallExpr.oprand1();
        if ((localObject instanceof Member)) {
            localObject = ((Member) localObject).get();
            if ((this.codeGen.procHandler != null) && (((String) localObject).equals(this.codeGen.proceedName))) {
                this.codeGen.procHandler.setReturnType(this, (ASTList) paramCallExpr.oprand2());
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
                if (((String) localObject).equals(this.codeGen.returnCastName)) {
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
        CtClass localCtClass = this.codeGen.returnType;
        paramCastExpr.getOprand().accept(this);
        if ((this.exprType == 344) || (CodeGen.isRefType(this.exprType)) || (this.arrayDim > 0)) {
            compileUnwrapValue(localCtClass);
        }
        while (!(localCtClass instanceof CtPrimitiveType)) {
            return;
        }
        this.exprType = MemberResolver.descToType(((CtPrimitiveType) localCtClass).getDescriptor());
        this.arrayDim = 0;
        this.className = null;
    }

    protected void atCastToWrapper(CastExpr paramCastExpr) {
        paramCastExpr.getOprand().accept(this);
        if ((CodeGen.isRefType(this.exprType)) || (this.arrayDim > 0)) {
        }
        while (!(this.resolver.lookupClass(this.exprType, this.arrayDim, this.className) instanceof CtPrimitiveType)) {
            return;
        }
        this.exprType = 307;
        this.arrayDim = 0;
        this.className = "java/lang/Object";
    }

    protected void atCflow(ASTList paramASTList) {
        this.exprType = 324;
        this.arrayDim = 0;
        this.className = null;
    }

    protected void atFieldAssign(Expr paramExpr, int paramInt, ASTree paramASTree1, ASTree paramASTree2) {
        if (((paramASTree1 instanceof Member)) && (((Member) paramASTree1).get().equals(this.codeGen.paramArrayName))) {
            paramASTree2.accept(this);
            paramExpr = this.codeGen.paramTypeList;
            if (paramExpr == null) {
            }
            for (; ; ) {
                return;
                int i = paramExpr.length;
                paramInt = 0;
                while (paramInt < i) {
                    compileUnwrapValue(paramExpr[paramInt]);
                    paramInt += 1;
                }
            }
        }
        super.atFieldAssign(paramExpr, paramInt, paramASTree1, paramASTree2);
    }

    public void atMember(Member paramMember) {
        String str = paramMember.get();
        if (str.equals(this.codeGen.paramArrayName)) {
            this.exprType = 307;
            this.arrayDim = 1;
            this.className = "java/lang/Object";
            return;
        }
        if (str.equals("$sig")) {
            this.exprType = 307;
            this.arrayDim = 1;
            this.className = "java/lang/Class";
            return;
        }
        if ((str.equals("$type")) || (str.equals("$class"))) {
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/Class";
            return;
        }
        super.atMember(paramMember);
    }

    public void atMethodArgs(ASTList paramASTList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString) {
        CtClass[] arrayOfCtClass = this.codeGen.paramTypeList;
        String str = this.codeGen.paramListName;
        int i = 0;
        if (paramASTList != null) {
            ASTree localASTree = paramASTList.head();
            if (((localASTree instanceof Member)) && (((Member) localASTree).get().equals(str))) {
                if (arrayOfCtClass == null) {
                    break label178;
                }
                int m = arrayOfCtClass.length;
                int k = 0;
                int j = i;
                for (; ; ) {
                    i = j;
                    if (k >= m) {
                        break;
                    }
                    setType(arrayOfCtClass[k]);
                    paramArrayOfInt1[j] = this.exprType;
                    paramArrayOfInt2[j] = this.arrayDim;
                    paramArrayOfString[j] = this.className;
                    k += 1;
                    j += 1;
                }
            }
            localASTree.accept(this);
            paramArrayOfInt1[i] = this.exprType;
            paramArrayOfInt2[i] = this.arrayDim;
            paramArrayOfString[i] = this.className;
            i += 1;
        }
        label178:
        for (; ; ) {
            paramASTList = paramASTList.tail();
            break;
            return;
        }
    }

    void compileInvokeSpecial(ASTree paramASTree, String paramString1, String paramString2, String paramString3, ASTList paramASTList) {
        paramASTree.accept(this);
        int i = getMethodArgsLength(paramASTList);
        atMethodArgs(paramASTList, new int[i], new int[i], new String[i]);
        setReturnType(paramString3);
        addNullIfVoid();
    }

    protected void compileUnwrapValue(CtClass paramCtClass) {
        if (paramCtClass == CtClass.voidType) {
            addNullIfVoid();
            return;
        }
        setType(paramCtClass);
    }

    public int getMethodArgsLength(ASTList paramASTList) {
        String str = this.codeGen.paramListName;
        int i = 0;
        if (paramASTList != null) {
            ASTree localASTree = paramASTList.head();
            if (((localASTree instanceof Member)) && (((Member) localASTree).get().equals(str))) {
                if (this.codeGen.paramTypeList == null) {
                    break label81;
                }
                i = this.codeGen.paramTypeList.length + i;
            }
        }
        label81:
        for (; ; ) {
            paramASTList = paramASTList.tail();
            break;
            i += 1;
            continue;
            return i;
        }
    }

    public boolean isParamListName(ASTList paramASTList) {
        if ((this.codeGen.paramTypeList != null) && (paramASTList != null) && (paramASTList.tail() == null)) {
            paramASTList = paramASTList.head();
            return ((paramASTList instanceof Member)) && (((Member) paramASTList).get().equals(this.codeGen.paramListName));
        }
        return false;
    }

    public void setType(CtClass paramCtClass) {
        setType(paramCtClass, 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/JvstTypeChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */