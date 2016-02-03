package javassist.convert;

import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.Bytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;

public class TransformBefore
        extends TransformCall {
    protected byte[] loadCode;
    protected int locals;
    protected int maxLocals;
    protected CtClass[] parameterTypes;
    protected byte[] saveCode;

    public TransformBefore(Transformer paramTransformer, CtMethod paramCtMethod1, CtMethod paramCtMethod2) {
        super(paramTransformer, paramCtMethod1, paramCtMethod2);
        this.methodDescriptor = paramCtMethod1.getMethodInfo2().getDescriptor();
        this.parameterTypes = paramCtMethod1.getParameterTypes();
        this.locals = 0;
        this.maxLocals = 0;
        this.loadCode = null;
        this.saveCode = null;
    }

    private void makeCode2(Bytecode paramBytecode1, Bytecode paramBytecode2, int paramInt1, int paramInt2, CtClass[] paramArrayOfCtClass, int paramInt3) {
        if (paramInt1 < paramInt2) {
            makeCode2(paramBytecode1, paramBytecode2, paramInt1 + 1, paramInt2, paramArrayOfCtClass, paramInt3 + paramBytecode2.addLoad(paramInt3, paramArrayOfCtClass[paramInt1]));
            paramBytecode1.addStore(paramInt3, paramArrayOfCtClass[paramInt1]);
            return;
        }
        this.locals = (paramInt3 - this.maxLocals);
    }

    public int extraLocals() {
        return this.locals;
    }

    public void initialize(ConstPool paramConstPool, CodeAttribute paramCodeAttribute) {
        super.initialize(paramConstPool, paramCodeAttribute);
        this.locals = 0;
        this.maxLocals = paramCodeAttribute.getMaxLocals();
        this.loadCode = null;
        this.saveCode = null;
    }

    protected void makeCode(CtClass[] paramArrayOfCtClass, ConstPool paramConstPool) {
        Bytecode localBytecode = new Bytecode(paramConstPool, 0, 0);
        paramConstPool = new Bytecode(paramConstPool, 0, 0);
        int j = this.maxLocals;
        if (paramArrayOfCtClass == null) {
        }
        for (int i = 0; ; i = paramArrayOfCtClass.length) {
            paramConstPool.addAload(j);
            makeCode2(localBytecode, paramConstPool, 0, i, paramArrayOfCtClass, j + 1);
            localBytecode.addAstore(j);
            this.saveCode = localBytecode.get();
            this.loadCode = paramConstPool.get();
            return;
        }
    }

    protected int match(int paramInt1, int paramInt2, CodeIterator paramCodeIterator, int paramInt3, ConstPool paramConstPool) {
        if (this.newIndex == 0) {
            String str = Descriptor.ofParameters(this.parameterTypes) + 'V';
            str = Descriptor.insertParameter(this.classname, str);
            paramInt1 = paramConstPool.addNameAndTypeInfo(this.newMethodname, str);
            this.newIndex = paramConstPool.addMethodrefInfo(paramConstPool.addClassInfo(this.newClassname), paramInt1);
            this.constPool = paramConstPool;
        }
        if (this.saveCode == null) {
            makeCode(this.parameterTypes, paramConstPool);
        }
        return match2(paramInt2, paramCodeIterator);
    }

    protected int match2(int paramInt, CodeIterator paramCodeIterator) {
        paramCodeIterator.move(paramInt);
        paramCodeIterator.insert(this.saveCode);
        paramCodeIterator.insert(this.loadCode);
        paramInt = paramCodeIterator.insertGap(3);
        paramCodeIterator.writeByte(184, paramInt);
        paramCodeIterator.write16bit(this.newIndex, paramInt + 1);
        paramCodeIterator.insert(this.loadCode);
        return paramCodeIterator.next();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/convert/TransformBefore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */