package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.Descriptor;
import javassist.compiler.Javac;

class CtField$ParamInitializer
        extends CtField.Initializer {
    int nthParam;

    static int nthParamToLocal(int paramInt, CtClass[] paramArrayOfCtClass, boolean paramBoolean) {
        int j = 0;
        CtClass localCtClass1 = CtClass.longType;
        CtClass localCtClass2 = CtClass.doubleType;
        int i;
        if (paramBoolean) {
            i = 0;
            if (j >= paramInt) {
                return i;
            }
            CtClass localCtClass3 = paramArrayOfCtClass[j];
            if ((localCtClass3 != localCtClass1) && (localCtClass3 != localCtClass2)) {
                break label63;
            }
            i += 2;
        }
        for (; ; ) {
            j += 1;
            break;
            i = 1;
            break;
            label63:
            i += 1;
        }
        return i;
    }

    int compile(CtClass paramCtClass, String paramString, Bytecode paramBytecode, CtClass[] paramArrayOfCtClass, Javac paramJavac) {
        int j = 0;
        int i = j;
        if (paramArrayOfCtClass != null) {
            i = j;
            if (this.nthParam < paramArrayOfCtClass.length) {
                paramBytecode.addAload(0);
                i = paramBytecode.addLoad(nthParamToLocal(this.nthParam, paramArrayOfCtClass, false), paramCtClass) + 1;
                paramBytecode.addPutfield(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
            }
        }
        return i;
    }

    int compileIfStatic(CtClass paramCtClass, String paramString, Bytecode paramBytecode, Javac paramJavac) {
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtField$ParamInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */