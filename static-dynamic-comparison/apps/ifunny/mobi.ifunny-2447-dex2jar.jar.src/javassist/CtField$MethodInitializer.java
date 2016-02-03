package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$MethodInitializer
        extends CtField.NewInitializer {
    String methodName;

    private String getDescriptor() {
        if (this.stringParams == null) {
            if (this.withConstructorParams) {
                return "(Ljava/lang/Object;[Ljava/lang/Object;)";
            }
            return "(Ljava/lang/Object;)";
        }
        if (this.withConstructorParams) {
            return "(Ljava/lang/Object;[Ljava/lang/String;[Ljava/lang/Object;)";
        }
        return "(Ljava/lang/Object;[Ljava/lang/String;)";
    }

    int compile(CtClass paramCtClass, String paramString, Bytecode paramBytecode, CtClass[] paramArrayOfCtClass, Javac paramJavac) {
        paramBytecode.addAload(0);
        paramBytecode.addAload(0);
        if (this.stringParams == null) {
        }
        for (int i = 2; ; i = compileStringParameter(paramBytecode) + 2) {
            int j = i;
            if (this.withConstructorParams) {
                j = i + CtNewWrappedMethod.compileParameterList(paramBytecode, paramArrayOfCtClass, 1);
            }
            paramCtClass = Descriptor.of(paramCtClass);
            paramArrayOfCtClass = getDescriptor() + paramCtClass;
            paramBytecode.addInvokestatic(this.objectType, this.methodName, paramArrayOfCtClass);
            paramBytecode.addPutfield(Bytecode.THIS, paramString, paramCtClass);
            return j;
        }
    }

    int compileIfStatic(CtClass paramCtClass, String paramString, Bytecode paramBytecode, Javac paramJavac) {
        int i = 1;
        if (this.stringParams == null) {
            paramJavac = "()";
        }
        for (; ; ) {
            paramCtClass = Descriptor.of(paramCtClass);
            paramBytecode.addInvokestatic(this.objectType, this.methodName, paramJavac + paramCtClass);
            paramBytecode.addPutstatic(Bytecode.THIS, paramString, paramCtClass);
            return i;
            paramJavac = "([Ljava/lang/String;)";
            i = 1 + compileStringParameter(paramBytecode);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtField$MethodInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */