package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.MethodInfo;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;

public class CtNewConstructor {
    public static final int PASS_ARRAY = 1;
    public static final int PASS_NONE = 0;
    public static final int PASS_PARAMS = 2;

    public static CtConstructor copy(CtConstructor paramCtConstructor, CtClass paramCtClass, ClassMap paramClassMap) {
        return new CtConstructor(paramCtConstructor, paramCtClass, paramClassMap);
    }

    public static CtConstructor defaultConstructor(CtClass paramCtClass) {
        CtConstructor localCtConstructor = new CtConstructor((CtClass[]) null, paramCtClass);
        Bytecode localBytecode = new Bytecode(paramCtClass.getClassFile2().getConstPool(), 1, 1);
        localBytecode.addAload(0);
        try {
            localBytecode.addInvokespecial(paramCtClass.getSuperclass(), "<init>", "()V");
            localBytecode.add(177);
            localCtConstructor.getMethodInfo2().setCodeAttribute(localBytecode.toCodeAttribute());
            return localCtConstructor;
        } catch (NotFoundException paramCtClass) {
            throw new CannotCompileException(paramCtClass);
        }
    }

    public static CtConstructor make(String paramString, CtClass paramCtClass) {
        paramCtClass = new Javac(paramCtClass);
        try {
            paramString = paramCtClass.compile(paramString);
            if ((paramString instanceof CtConstructor)) {
                paramString = (CtConstructor) paramString;
                return paramString;
            }
        } catch (CompileError paramString) {
            throw new CannotCompileException(paramString);
        }
        throw new CannotCompileException("not a constructor");
    }

    public static CtConstructor make(CtClass[] paramArrayOfCtClass1, CtClass[] paramArrayOfCtClass2, int paramInt, CtMethod paramCtMethod, CtMethod.ConstParameter paramConstParameter, CtClass paramCtClass) {
        return CtNewWrappedConstructor.wrapped(paramArrayOfCtClass1, paramArrayOfCtClass2, paramInt, paramCtMethod, paramConstParameter, paramCtClass);
    }

    public static CtConstructor make(CtClass[] paramArrayOfCtClass1, CtClass[] paramArrayOfCtClass2, String paramString, CtClass paramCtClass) {
        try {
            paramArrayOfCtClass1 = new CtConstructor(paramArrayOfCtClass1, paramCtClass);
            paramArrayOfCtClass1.setExceptionTypes(paramArrayOfCtClass2);
            paramArrayOfCtClass1.setBody(paramString);
            return paramArrayOfCtClass1;
        } catch (NotFoundException paramArrayOfCtClass1) {
            throw new CannotCompileException(paramArrayOfCtClass1);
        }
    }

    public static CtConstructor make(CtClass[] paramArrayOfCtClass1, CtClass[] paramArrayOfCtClass2, CtClass paramCtClass) {
        return make(paramArrayOfCtClass1, paramArrayOfCtClass2, 2, null, null, paramCtClass);
    }

    public static CtConstructor skeleton(CtClass[] paramArrayOfCtClass1, CtClass[] paramArrayOfCtClass2, CtClass paramCtClass) {
        return make(paramArrayOfCtClass1, paramArrayOfCtClass2, 0, null, null, paramCtClass);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtNewConstructor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */