package javassist.expr;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;

public class NewExpr
        extends Expr {
    int newPos;
    String newTypeName;

    protected NewExpr(int paramInt1, CodeIterator paramCodeIterator, CtClass paramCtClass, MethodInfo paramMethodInfo, String paramString, int paramInt2) {
        super(paramInt1, paramCodeIterator, paramCtClass, paramMethodInfo);
        this.newTypeName = paramString;
        this.newPos = paramInt2;
    }

    private int canReplace() {
        int i = this.iterator.byteAt(this.newPos + 3);
        if (i == 89) {
            return 4;
        }
        if ((i == 90) && (this.iterator.byteAt(this.newPos + 4) == 95)) {
            return 5;
        }
        return 3;
    }

    private CtClass getCtClass() {
        return this.thisClass.getClassPool().get(this.newTypeName);
    }

    public String getClassName() {
        return this.newTypeName;
    }

    public CtConstructor getConstructor() {
        String str = getConstPool().getMethodrefType(this.iterator.u16bitAt(this.currentPos + 1));
        return getCtClass().getConstructor(str);
    }

    public String getFileName() {
        return super.getFileName();
    }

    public int getLineNumber() {
        return super.getLineNumber();
    }

    public String getSignature() {
        return getConstPool().getMethodrefType(this.iterator.u16bitAt(this.currentPos + 1));
    }

    public CtClass[] mayThrow() {
        return super.mayThrow();
    }

    public void replace(String paramString) {
        this.thisClass.getClassFile();
        int j = this.newPos;
        int k = this.iterator.u16bitAt(j + 1);
        int m = canReplace();
        int i = j;
        while (i < j + m) {
            this.iterator.writeByte(0, i);
            i += 1;
        }
        Object localObject1 = getConstPool();
        i = this.currentPos;
        j = this.iterator.u16bitAt(i + 1);
        Object localObject2 = ((ConstPool) localObject1).getMethodrefType(j);
        localObject1 = new Javac(this.thisClass);
        Object localObject3 = this.thisClass.getClassPool();
        CodeAttribute localCodeAttribute = this.iterator.get();
        try {
            localObject2 = Descriptor.getParameterTypes((String) localObject2, (ClassPool) localObject3);
            localObject3 = ((ClassPool) localObject3).get(this.newTypeName);
            int n = localCodeAttribute.getMaxLocals();
            ((Javac) localObject1).recordParams(this.newTypeName, (CtClass[]) localObject2, true, n, withinStatic());
            int i1 = ((Javac) localObject1).recordReturnType((CtClass) localObject3, true);
            ((Javac) localObject1).recordProceed(new NewExpr.ProceedForNew((CtClass) localObject3, k, j));
            checkResultValue((CtClass) localObject3, paramString);
            Bytecode localBytecode = ((Javac) localObject1).getBytecode();
            storeStack((CtClass[]) localObject2, true, n, localBytecode);
            ((Javac) localObject1).recordLocalVariables(localCodeAttribute, i);
            localBytecode.addConstZero((CtClass) localObject3);
            localBytecode.addStore(i1, (CtClass) localObject3);
            ((Javac) localObject1).compileStmnt(paramString);
            if (m > 3) {
                localBytecode.addAload(i1);
            }
            replace0(i, localBytecode, 3);
            return;
        } catch (CompileError paramString) {
            throw new CannotCompileException(paramString);
        } catch (NotFoundException paramString) {
            throw new CannotCompileException(paramString);
        } catch (BadBytecode paramString) {
            throw new CannotCompileException("broken method");
        }
    }

    public CtBehavior where() {
        return super.where();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/NewExpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */