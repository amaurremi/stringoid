package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$IntInitializer
        extends CtField.Initializer {
    int value;

    CtField$IntInitializer(int paramInt) {
        this.value = paramInt;
    }

    void check(String paramString) {
        int i = paramString.charAt(0);
        if ((i != 73) && (i != 83) && (i != 66) && (i != 67) && (i != 90)) {
            throw new CannotCompileException("type mismatch");
        }
    }

    int compile(CtClass paramCtClass, String paramString, Bytecode paramBytecode, CtClass[] paramArrayOfCtClass, Javac paramJavac) {
        paramBytecode.addAload(0);
        paramBytecode.addIconst(this.value);
        paramBytecode.addPutfield(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
        return 2;
    }

    int compileIfStatic(CtClass paramCtClass, String paramString, Bytecode paramBytecode, Javac paramJavac) {
        paramBytecode.addIconst(this.value);
        paramBytecode.addPutstatic(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
        return 1;
    }

    int getConstantValue(ConstPool paramConstPool, CtClass paramCtClass) {
        return paramConstPool.addIntegerInfo(this.value);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtField$IntInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */