package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$ArrayInitializer
        extends CtField.Initializer {
    int size;
    CtClass type;

    CtField$ArrayInitializer(CtClass paramCtClass, int paramInt) {
        this.type = paramCtClass;
        this.size = paramInt;
    }

    private void addNewarray(Bytecode paramBytecode) {
        if (this.type.isPrimitive()) {
            paramBytecode.addNewarray(((CtPrimitiveType) this.type).getArrayType(), this.size);
            return;
        }
        paramBytecode.addAnewarray(this.type, this.size);
    }

    int compile(CtClass paramCtClass, String paramString, Bytecode paramBytecode, CtClass[] paramArrayOfCtClass, Javac paramJavac) {
        paramBytecode.addAload(0);
        addNewarray(paramBytecode);
        paramBytecode.addPutfield(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
        return 2;
    }

    int compileIfStatic(CtClass paramCtClass, String paramString, Bytecode paramBytecode, Javac paramJavac) {
        addNewarray(paramBytecode);
        paramBytecode.addPutstatic(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
        return 1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtField$ArrayInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */