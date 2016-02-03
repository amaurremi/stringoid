package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.DoubleConst;
import javassist.compiler.ast.IntConst;
import javassist.compiler.ast.StringL;

abstract class CtField$CodeInitializer0
        extends CtField.Initializer {
    int compile(CtClass paramCtClass, String paramString, Bytecode paramBytecode, CtClass[] paramArrayOfCtClass, Javac paramJavac) {
        try {
            paramBytecode.addAload(0);
            compileExpr(paramJavac);
            paramBytecode.addPutfield(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
            int i = paramBytecode.getMaxStack();
            return i;
        } catch (CompileError paramCtClass) {
            throw new CannotCompileException(paramCtClass);
        }
    }

    abstract void compileExpr(Javac paramJavac);

    int compileIfStatic(CtClass paramCtClass, String paramString, Bytecode paramBytecode, Javac paramJavac) {
        try {
            compileExpr(paramJavac);
            paramBytecode.addPutstatic(Bytecode.THIS, paramString, Descriptor.of(paramCtClass));
            int i = paramBytecode.getMaxStack();
            return i;
        } catch (CompileError paramCtClass) {
            throw new CannotCompileException(paramCtClass);
        }
    }

    int getConstantValue2(ConstPool paramConstPool, CtClass paramCtClass, ASTree paramASTree) {
        if (paramCtClass.isPrimitive()) {
            if ((paramASTree instanceof IntConst)) {
                long l = ((IntConst) paramASTree).get();
                if (paramCtClass == CtClass.doubleType) {
                    return paramConstPool.addDoubleInfo(l);
                }
                if (paramCtClass == CtClass.floatType) {
                    return paramConstPool.addFloatInfo((float) l);
                }
                if (paramCtClass == CtClass.longType) {
                    return paramConstPool.addLongInfo(l);
                }
                if (paramCtClass != CtClass.voidType) {
                    return paramConstPool.addIntegerInfo((int) l);
                }
            } else if ((paramASTree instanceof DoubleConst)) {
                double d = ((DoubleConst) paramASTree).get();
                if (paramCtClass == CtClass.floatType) {
                    return paramConstPool.addFloatInfo((float) d);
                }
                if (paramCtClass == CtClass.doubleType) {
                    return paramConstPool.addDoubleInfo(d);
                }
            }
        } else if (((paramASTree instanceof StringL)) && (paramCtClass.getName().equals("java.lang.String"))) {
            return paramConstPool.addStringInfo(((StringL) paramASTree).get());
        }
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtField$CodeInitializer0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */