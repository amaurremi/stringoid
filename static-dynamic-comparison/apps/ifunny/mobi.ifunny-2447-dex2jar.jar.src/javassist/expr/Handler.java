package javassist.expr;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.Bytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.ExceptionTable;
import javassist.bytecode.MethodInfo;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;

public class Handler
        extends Expr {
    private static String EXCEPTION_NAME = "$1";
    private ExceptionTable etable;
    private int index;

    protected Handler(ExceptionTable paramExceptionTable, int paramInt, CodeIterator paramCodeIterator, CtClass paramCtClass, MethodInfo paramMethodInfo) {
        super(paramExceptionTable.handlerPc(paramInt), paramCodeIterator, paramCtClass, paramMethodInfo);
        this.etable = paramExceptionTable;
        this.index = paramInt;
    }

    public String getFileName() {
        return super.getFileName();
    }

    public int getLineNumber() {
        return super.getLineNumber();
    }

    public CtClass getType() {
        int i = this.etable.catchType(this.index);
        if (i == 0) {
            return null;
        }
        String str = getConstPool().getClassInfo(i);
        return this.thisClass.getClassPool().getCtClass(str);
    }

    public void insertBefore(String paramString) {
        this.edited = true;
        getConstPool();
        Object localObject = this.iterator.get();
        Javac localJavac = new Javac(this.thisClass);
        Bytecode localBytecode = localJavac.getBytecode();
        localBytecode.setStackDepth(1);
        localBytecode.setMaxLocals(((CodeAttribute) localObject).getMaxLocals());
        try {
            localObject = getType();
            int i = localJavac.recordVariable((CtClass) localObject, EXCEPTION_NAME);
            localJavac.recordReturnType((CtClass) localObject, false);
            localBytecode.addAstore(i);
            localJavac.compileStmnt(paramString);
            localBytecode.addAload(i);
            i = this.etable.handlerPc(this.index);
            localBytecode.addOpcode(167);
            localBytecode.addIndex(i - this.iterator.getCodeLength() - localBytecode.currentPc() + 1);
            this.maxStack = localBytecode.getMaxStack();
            this.maxLocals = localBytecode.getMaxLocals();
            i = this.iterator.append(localBytecode.get());
            this.iterator.append(localBytecode.getExceptionTable(), i);
            this.etable.setHandlerPc(this.index, i);
            return;
        } catch (NotFoundException paramString) {
            throw new CannotCompileException(paramString);
        } catch (CompileError paramString) {
            throw new CannotCompileException(paramString);
        }
    }

    public boolean isFinally() {
        return this.etable.catchType(this.index) == 0;
    }

    public CtClass[] mayThrow() {
        return super.mayThrow();
    }

    public void replace(String paramString) {
        throw new RuntimeException("not implemented yet");
    }

    public CtBehavior where() {
        return super.where();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/expr/Handler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */