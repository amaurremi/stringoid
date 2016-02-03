package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;

class CtNewWrappedConstructor
        extends CtNewWrappedMethod {
    private static final int PASS_NONE = 0;
    private static final int PASS_PARAMS = 2;

    protected static Bytecode makeBody(CtClass paramCtClass, ClassFile paramClassFile, int paramInt, CtMethod paramCtMethod, CtClass[] paramArrayOfCtClass, CtMethod.ConstParameter paramConstParameter) {
        int i = 1;
        int j = paramClassFile.getSuperclassId();
        Bytecode localBytecode = new Bytecode(paramClassFile.getConstPool(), 0, 0);
        localBytecode.setMaxLocals(false, paramArrayOfCtClass, 0);
        localBytecode.addAload(0);
        if (paramInt == 0) {
            localBytecode.addInvokespecial(j, "<init>", "()V");
            paramInt = i;
        }
        label72:
        String str;
        for (; ; ) {
            if (paramCtMethod == null) {
                localBytecode.add(177);
                i = paramInt;
                localBytecode.setMaxStack(i);
                return localBytecode;
                if (paramInt == 2) {
                    paramInt = localBytecode.addLoadParameters(paramArrayOfCtClass, 1) + 1;
                    localBytecode.addInvokespecial(j, "<init>", Descriptor.ofConstructor(paramArrayOfCtClass));
                } else {
                    i = compileParameterList(localBytecode, paramArrayOfCtClass, 1);
                    if (paramConstParameter == null) {
                        str = CtMethod.ConstParameter.defaultConstDescriptor();
                        paramInt = 2;
                        label137:
                        if (i >= paramInt) {
                            break label213;
                        }
                    }
                }
            }
        }
        for (; ; ) {
            localBytecode.addInvokespecial(j, "<init>", str);
            break;
            paramInt = paramConstParameter.compile(localBytecode);
            str = paramConstParameter.constDescriptor();
            paramInt += 2;
            break label137;
            j = makeBody0(paramCtClass, paramClassFile, paramCtMethod, false, paramArrayOfCtClass, CtClass.voidType, paramConstParameter, localBytecode);
            i = j;
            if (paramInt < j) {
                break label72;
            }
            i = paramInt;
            break label72;
            label213:
            paramInt = i;
        }
    }

    public static CtConstructor wrapped(CtClass[] paramArrayOfCtClass1, CtClass[] paramArrayOfCtClass2, int paramInt, CtMethod paramCtMethod, CtMethod.ConstParameter paramConstParameter, CtClass paramCtClass) {
        try {
            CtConstructor localCtConstructor = new CtConstructor(paramArrayOfCtClass1, paramCtClass);
            localCtConstructor.setExceptionTypes(paramArrayOfCtClass2);
            paramArrayOfCtClass1 = makeBody(paramCtClass, paramCtClass.getClassFile2(), paramInt, paramCtMethod, paramArrayOfCtClass1, paramConstParameter);
            localCtConstructor.getMethodInfo2().setCodeAttribute(paramArrayOfCtClass1.toCodeAttribute());
            return localCtConstructor;
        } catch (NotFoundException paramArrayOfCtClass1) {
            throw new CannotCompileException(paramArrayOfCtClass1);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtNewWrappedConstructor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */