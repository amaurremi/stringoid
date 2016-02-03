package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.ConstPool;
import javassist.compiler.Javac;
import javassist.compiler.ast.ASTree;

public abstract class CtField$Initializer {
    public static Initializer byCall(CtClass paramCtClass, String paramString) {
        CtField.MethodInitializer localMethodInitializer = new CtField.MethodInitializer();
        localMethodInitializer.objectType = paramCtClass;
        localMethodInitializer.methodName = paramString;
        localMethodInitializer.stringParams = null;
        localMethodInitializer.withConstructorParams = false;
        return localMethodInitializer;
    }

    public static Initializer byCall(CtClass paramCtClass, String paramString, String[] paramArrayOfString) {
        CtField.MethodInitializer localMethodInitializer = new CtField.MethodInitializer();
        localMethodInitializer.objectType = paramCtClass;
        localMethodInitializer.methodName = paramString;
        localMethodInitializer.stringParams = paramArrayOfString;
        localMethodInitializer.withConstructorParams = false;
        return localMethodInitializer;
    }

    public static Initializer byCallWithParams(CtClass paramCtClass, String paramString) {
        CtField.MethodInitializer localMethodInitializer = new CtField.MethodInitializer();
        localMethodInitializer.objectType = paramCtClass;
        localMethodInitializer.methodName = paramString;
        localMethodInitializer.stringParams = null;
        localMethodInitializer.withConstructorParams = true;
        return localMethodInitializer;
    }

    public static Initializer byCallWithParams(CtClass paramCtClass, String paramString, String[] paramArrayOfString) {
        CtField.MethodInitializer localMethodInitializer = new CtField.MethodInitializer();
        localMethodInitializer.objectType = paramCtClass;
        localMethodInitializer.methodName = paramString;
        localMethodInitializer.stringParams = paramArrayOfString;
        localMethodInitializer.withConstructorParams = true;
        return localMethodInitializer;
    }

    public static Initializer byExpr(String paramString) {
        return new CtField.CodeInitializer(paramString);
    }

    static Initializer byExpr(ASTree paramASTree) {
        return new CtField.PtreeInitializer(paramASTree);
    }

    public static Initializer byNew(CtClass paramCtClass) {
        CtField.NewInitializer localNewInitializer = new CtField.NewInitializer();
        localNewInitializer.objectType = paramCtClass;
        localNewInitializer.stringParams = null;
        localNewInitializer.withConstructorParams = false;
        return localNewInitializer;
    }

    public static Initializer byNew(CtClass paramCtClass, String[] paramArrayOfString) {
        CtField.NewInitializer localNewInitializer = new CtField.NewInitializer();
        localNewInitializer.objectType = paramCtClass;
        localNewInitializer.stringParams = paramArrayOfString;
        localNewInitializer.withConstructorParams = false;
        return localNewInitializer;
    }

    public static Initializer byNewArray(CtClass paramCtClass, int paramInt) {
        return new CtField.ArrayInitializer(paramCtClass.getComponentType(), paramInt);
    }

    public static Initializer byNewArray(CtClass paramCtClass, int[] paramArrayOfInt) {
        return new CtField.MultiArrayInitializer(paramCtClass, paramArrayOfInt);
    }

    public static Initializer byNewWithParams(CtClass paramCtClass) {
        CtField.NewInitializer localNewInitializer = new CtField.NewInitializer();
        localNewInitializer.objectType = paramCtClass;
        localNewInitializer.stringParams = null;
        localNewInitializer.withConstructorParams = true;
        return localNewInitializer;
    }

    public static Initializer byNewWithParams(CtClass paramCtClass, String[] paramArrayOfString) {
        CtField.NewInitializer localNewInitializer = new CtField.NewInitializer();
        localNewInitializer.objectType = paramCtClass;
        localNewInitializer.stringParams = paramArrayOfString;
        localNewInitializer.withConstructorParams = true;
        return localNewInitializer;
    }

    public static Initializer byParameter(int paramInt) {
        CtField.ParamInitializer localParamInitializer = new CtField.ParamInitializer();
        localParamInitializer.nthParam = paramInt;
        return localParamInitializer;
    }

    public static Initializer constant(double paramDouble) {
        return new CtField.DoubleInitializer(paramDouble);
    }

    public static Initializer constant(float paramFloat) {
        return new CtField.FloatInitializer(paramFloat);
    }

    public static Initializer constant(int paramInt) {
        return new CtField.IntInitializer(paramInt);
    }

    public static Initializer constant(long paramLong) {
        return new CtField.LongInitializer(paramLong);
    }

    public static Initializer constant(String paramString) {
        return new CtField.StringInitializer(paramString);
    }

    public static Initializer constant(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (int i = 1; ; i = 0) {
            return new CtField.IntInitializer(i);
        }
    }

    void check(String paramString) {
    }

    abstract int compile(CtClass paramCtClass, String paramString, Bytecode paramBytecode, CtClass[] paramArrayOfCtClass, Javac paramJavac);

    abstract int compileIfStatic(CtClass paramCtClass, String paramString, Bytecode paramBytecode, Javac paramJavac);

    int getConstantValue(ConstPool paramConstPool, CtClass paramCtClass) {
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtField$Initializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */