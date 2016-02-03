package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$MultiArrayInitializer
        extends CtField.Initializer {
    int[] dim;
    CtClass type;

    CtField$MultiArrayInitializer(CtClass paramCtClass, int[] paramArrayOfInt) {
        this.type = paramCtClass;
        this.dim = paramArrayOfInt;
    }

    void check(String paramString) {
        if (paramString.charAt(0) != '[') {
            throw new CannotCompileException("type mismatch");
        }
    }

    int compile(CtClass paramCtClass, String paramString, Bytecode paramBytecode, CtClass[] paramArrayOfCtClass, Javac paramJavac) {
        paramBytecode.addAload(0);
        int i = paramBytecode.addMultiNewarray(paramCtClass, this.dim);
        paramBytecode.addPutfield(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
        return i + 1;
    }

    int compileIfStatic(CtClass paramCtClass, String paramString, Bytecode paramBytecode, Javac paramJavac) {
        int i = paramBytecode.addMultiNewarray(paramCtClass, this.dim);
        paramBytecode.addPutstatic(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
        return i;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtField$MultiArrayInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */