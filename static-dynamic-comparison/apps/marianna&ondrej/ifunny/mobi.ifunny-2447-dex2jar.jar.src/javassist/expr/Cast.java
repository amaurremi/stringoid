package javassist.expr;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.MethodInfo;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;

public class Cast
        extends Expr {
    protected Cast(int paramInt, CodeIterator paramCodeIterator, CtClass paramCtClass, MethodInfo paramMethodInfo) {
        super(paramInt, paramCodeIterator, paramCtClass, paramMethodInfo);
    }

    public String getFileName() {
        return super.getFileName();
    }

    public int getLineNumber() {
        return super.getLineNumber();
    }

    public CtClass getType() {
        Object localObject = getConstPool();
        int i = this.currentPos;
        localObject = ((ConstPool) localObject).getClassInfo(this.iterator.u16bitAt(i + 1));
        return this.thisClass.getClassPool().getCtClass((String) localObject);
    }

    public CtClass[] mayThrow() {
        return super.mayThrow();
    }

    public void replace(String paramString) {
        this.thisClass.getClassFile();
        getConstPool();
        int i = this.currentPos;
        int j = this.iterator.u16bitAt(i + 1);
        Javac localJavac = new Javac(this.thisClass);
        Object localObject = this.thisClass.getClassPool();
        CodeAttribute localCodeAttribute = this.iterator.get();
        try {
            CtClass[] arrayOfCtClass = new CtClass[1];
            arrayOfCtClass[0] = ((ClassPool) localObject).get("java.lang.Object");
            localObject = getType();
            int k = localCodeAttribute.getMaxLocals();
            localJavac.recordParams("java.lang.Object", arrayOfCtClass, true, k, withinStatic());
            int m = localJavac.recordReturnType((CtClass) localObject, true);
            localJavac.recordProceed(new Cast.ProceedForCast(j, (CtClass) localObject));
            checkResultValue((CtClass) localObject, paramString);
            Bytecode localBytecode = localJavac.getBytecode();
            storeStack(arrayOfCtClass, true, k, localBytecode);
            localJavac.recordLocalVariables(localCodeAttribute, i);
            localBytecode.addConstZero((CtClass) localObject);
            localBytecode.addStore(m, (CtClass) localObject);
            localJavac.compileStmnt(paramString);
            localBytecode.addLoad(m, (CtClass) localObject);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/Cast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */