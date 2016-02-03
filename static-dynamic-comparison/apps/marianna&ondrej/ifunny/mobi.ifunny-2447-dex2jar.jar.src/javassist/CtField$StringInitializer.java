package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$StringInitializer
        extends CtField.Initializer {
    String value;

    CtField$StringInitializer(String paramString) {
        this.value = paramString;
    }

    int compile(CtClass paramCtClass, String paramString, Bytecode paramBytecode, CtClass[] paramArrayOfCtClass, Javac paramJavac) {
        paramBytecode.addAload(0);
        paramBytecode.addLdc(this.value);
        paramBytecode.addPutfield(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
        return 2;
    }

    int compileIfStatic(CtClass paramCtClass, String paramString, Bytecode paramBytecode, Javac paramJavac) {
        paramBytecode.addLdc(this.value);
        paramBytecode.addPutstatic(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
        return 1;
    }

    int getConstantValue(ConstPool paramConstPool, CtClass paramCtClass) {
        if (paramCtClass.getName().equals("java.lang.String")) {
            return paramConstPool.addStringInfo(this.value);
        }
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtField$StringInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */