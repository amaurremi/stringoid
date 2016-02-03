package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$NewInitializer
        extends CtField.Initializer {
    CtClass objectType;
    String[] stringParams;
    boolean withConstructorParams;

    private String getDescriptor() {
        if (this.stringParams == null) {
            if (this.withConstructorParams) {
                return "(Ljava/lang/Object;[Ljava/lang/Object;)V";
            }
            return "(Ljava/lang/Object;)V";
        }
        if (this.withConstructorParams) {
            return "(Ljava/lang/Object;[Ljava/lang/String;[Ljava/lang/Object;)V";
        }
        return "(Ljava/lang/Object;[Ljava/lang/String;)V";
    }

    int compile(CtClass paramCtClass, String paramString, Bytecode paramBytecode, CtClass[] paramArrayOfCtClass, Javac paramJavac) {
        paramBytecode.addAload(0);
        paramBytecode.addNew(this.objectType);
        paramBytecode.add(89);
        paramBytecode.addAload(0);
        if (this.stringParams == null) {
        }
        for (int i = 4; ; i = compileStringParameter(paramBytecode) + 4) {
            int j = i;
            if (this.withConstructorParams) {
                j = i + CtNewWrappedMethod.compileParameterList(paramBytecode, paramArrayOfCtClass, 1);
            }
            paramBytecode.addInvokespecial(this.objectType, "<init>", getDescriptor());
            paramBytecode.addPutfield(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
            return j;
        }
    }

    int compileIfStatic(CtClass paramCtClass, String paramString, Bytecode paramBytecode, Javac paramJavac) {
        paramBytecode.addNew(this.objectType);
        paramBytecode.add(89);
        int i = 2;
        if (this.stringParams == null) {
            paramJavac = "()V";
        }
        for (; ; ) {
            paramBytecode.addInvokespecial(this.objectType, "<init>", paramJavac);
            paramBytecode.addPutstatic(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
            return i;
            paramJavac = "([Ljava/lang/String;)V";
            i = 2 + compileStringParameter(paramBytecode);
        }
    }

    protected final int compileStringParameter(Bytecode paramBytecode) {
        int j = this.stringParams.length;
        paramBytecode.addIconst(j);
        paramBytecode.addAnewarray("java.lang.String");
        int i = 0;
        while (i < j) {
            paramBytecode.add(89);
            paramBytecode.addIconst(i);
            paramBytecode.addLdc(this.stringParams[i]);
            paramBytecode.add(83);
            i += 1;
        }
        return 4;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtField$NewInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */