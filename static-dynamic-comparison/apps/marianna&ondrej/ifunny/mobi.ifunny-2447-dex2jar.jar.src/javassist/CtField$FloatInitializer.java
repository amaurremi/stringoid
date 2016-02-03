package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$FloatInitializer
        extends CtField.Initializer {
    float value;

    CtField$FloatInitializer(float paramFloat) {
        this.value = paramFloat;
    }

    void check(String paramString) {
        if (!paramString.equals("F")) {
            throw new CannotCompileException("type mismatch");
        }
    }

    int compile(CtClass paramCtClass, String paramString, Bytecode paramBytecode, CtClass[] paramArrayOfCtClass, Javac paramJavac) {
        paramBytecode.addAload(0);
        paramBytecode.addFconst(this.value);
        paramBytecode.addPutfield(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
        return 3;
    }

    int compileIfStatic(CtClass paramCtClass, String paramString, Bytecode paramBytecode, Javac paramJavac) {
        paramBytecode.addFconst(this.value);
        paramBytecode.addPutstatic(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
        return 2;
    }

    int getConstantValue(ConstPool paramConstPool, CtClass paramCtClass) {
        if (paramCtClass == CtClass.floatType) {
            return paramConstPool.addFloatInfo(this.value);
        }
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtField$FloatInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */