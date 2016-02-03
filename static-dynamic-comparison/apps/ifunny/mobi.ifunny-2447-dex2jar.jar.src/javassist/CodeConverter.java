package javassist;

import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.MethodInfo;
import javassist.convert.TransformAccessArrayField;
import javassist.convert.TransformAfter;
import javassist.convert.TransformBefore;
import javassist.convert.TransformCall;
import javassist.convert.TransformFieldAccess;
import javassist.convert.TransformNew;
import javassist.convert.TransformNewClass;
import javassist.convert.TransformReadField;
import javassist.convert.TransformWriteField;
import javassist.convert.Transformer;

public class CodeConverter {
    protected Transformer transformers = null;

    protected void doit(CtClass paramCtClass, MethodInfo paramMethodInfo, ConstPool paramConstPool) {
        int j = 0;
        CodeAttribute localCodeAttribute = paramMethodInfo.getCodeAttribute();
        if ((localCodeAttribute == null) || (this.transformers == null)) {
            return;
        }
        for (Object localObject = this.transformers; localObject != null; localObject = ((Transformer) localObject).getNext()) {
            ((Transformer) localObject).initialize(paramConstPool, paramCtClass, paramMethodInfo);
        }
        localObject = localCodeAttribute.iterator();
        while (((CodeIterator) localObject).hasNext()) {
            try {
                i = ((CodeIterator) localObject).next();
                for (paramMethodInfo = this.transformers; paramMethodInfo != null; paramMethodInfo = paramMethodInfo.getNext()) {
                    i = paramMethodInfo.transform(paramCtClass, i, (CodeIterator) localObject, paramConstPool);
                }
                paramCtClass = this.transformers;
            } catch (BadBytecode paramCtClass) {
                throw new CannotCompileException(paramCtClass);
            }
        }
        int k = 0;
        int i = j;
        j = k;
        label128:
        if (paramCtClass != null) {
            k = paramCtClass.extraLocals();
            if (k <= j) {
                break label235;
            }
            j = k;
        }
        label235:
        for (; ; ) {
            k = paramCtClass.extraStack();
            if (k > i) {
                i = k;
            }
            for (; ; ) {
                paramCtClass = paramCtClass.getNext();
                break label128;
                for (paramCtClass = this.transformers; paramCtClass != null; paramCtClass = paramCtClass.getNext()) {
                    paramCtClass.clean();
                }
                if (j > 0) {
                    localCodeAttribute.setMaxLocals(localCodeAttribute.getMaxLocals() + j);
                }
                if (i <= 0) {
                    break;
                }
                localCodeAttribute.setMaxStack(localCodeAttribute.getMaxStack() + i);
                return;
            }
        }
    }

    public void insertAfterMethod(CtMethod paramCtMethod1, CtMethod paramCtMethod2) {
        try {
            this.transformers = new TransformAfter(this.transformers, paramCtMethod1, paramCtMethod2);
            return;
        } catch (NotFoundException paramCtMethod1) {
            throw new CannotCompileException(paramCtMethod1);
        }
    }

    public void insertBeforeMethod(CtMethod paramCtMethod1, CtMethod paramCtMethod2) {
        try {
            this.transformers = new TransformBefore(this.transformers, paramCtMethod1, paramCtMethod2);
            return;
        } catch (NotFoundException paramCtMethod1) {
            throw new CannotCompileException(paramCtMethod1);
        }
    }

    public void redirectFieldAccess(CtField paramCtField, CtClass paramCtClass, String paramString) {
        this.transformers = new TransformFieldAccess(this.transformers, paramCtField, paramCtClass.getName(), paramString);
    }

    public void redirectMethodCall(String paramString, CtMethod paramCtMethod) {
        this.transformers = new TransformCall(this.transformers, paramString, paramCtMethod);
    }

    public void redirectMethodCall(CtMethod paramCtMethod1, CtMethod paramCtMethod2) {
        if (!paramCtMethod1.getMethodInfo2().getDescriptor().equals(paramCtMethod2.getMethodInfo2().getDescriptor())) {
            throw new CannotCompileException("signature mismatch: " + paramCtMethod2.getLongName());
        }
        int i = paramCtMethod1.getModifiers();
        int j = paramCtMethod2.getModifiers();
        if ((Modifier.isStatic(i) != Modifier.isStatic(j)) || ((Modifier.isPrivate(i)) && (!Modifier.isPrivate(j))) || (paramCtMethod1.getDeclaringClass().isInterface() != paramCtMethod2.getDeclaringClass().isInterface())) {
            throw new CannotCompileException("invoke-type mismatch " + paramCtMethod2.getLongName());
        }
        this.transformers = new TransformCall(this.transformers, paramCtMethod1, paramCtMethod2);
    }

    public void replaceArrayAccess(CtClass paramCtClass, CodeConverter.ArrayAccessReplacementMethodNames paramArrayAccessReplacementMethodNames) {
        this.transformers = new TransformAccessArrayField(this.transformers, paramCtClass.getName(), paramArrayAccessReplacementMethodNames);
    }

    public void replaceFieldRead(CtField paramCtField, CtClass paramCtClass, String paramString) {
        this.transformers = new TransformReadField(this.transformers, paramCtField, paramCtClass.getName(), paramString);
    }

    public void replaceFieldWrite(CtField paramCtField, CtClass paramCtClass, String paramString) {
        this.transformers = new TransformWriteField(this.transformers, paramCtField, paramCtClass.getName(), paramString);
    }

    public void replaceNew(CtClass paramCtClass1, CtClass paramCtClass2) {
        this.transformers = new TransformNewClass(this.transformers, paramCtClass1.getName(), paramCtClass2.getName());
    }

    public void replaceNew(CtClass paramCtClass1, CtClass paramCtClass2, String paramString) {
        this.transformers = new TransformNew(this.transformers, paramCtClass1.getName(), paramCtClass2.getName(), paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CodeConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */