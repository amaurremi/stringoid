package javassist;

import java.util.Hashtable;
import java.util.Map;

import javassist.bytecode.AccessFlag;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.SyntheticAttribute;
import javassist.compiler.JvstCodeGen;

class CtNewWrappedMethod {
    private static final String addedWrappedMethod = "_added_m$";

    private static String addBodyMethod(CtClassType paramCtClassType, ClassFile paramClassFile, CtMethod paramCtMethod) {
        Hashtable localHashtable = paramCtClassType.getHiddenMethods();
        String str = (String) localHashtable.get(paramCtMethod);
        Object localObject = str;
        if (str == null) {
            do {
                str = "_added_m$" + paramCtClassType.getUniqueNumber();
            } while (paramClassFile.getMethod(str) != null);
            localObject = new ClassMap();
            ((ClassMap) localObject).put(paramCtMethod.getDeclaringClass().getName(), paramCtClassType.getName());
            MethodInfo localMethodInfo = new MethodInfo(paramClassFile.getConstPool(), str, paramCtMethod.getMethodInfo2(), (Map) localObject);
            localMethodInfo.setAccessFlags(AccessFlag.setPrivate(localMethodInfo.getAccessFlags()));
            localMethodInfo.addAttribute(new SyntheticAttribute(paramClassFile.getConstPool()));
            paramClassFile.addMethod(localMethodInfo);
            localHashtable.put(paramCtMethod, str);
            paramClassFile = paramCtClassType.hasMemberCache();
            localObject = str;
            if (paramClassFile != null) {
                paramClassFile.addMethod(new CtMethod(localMethodInfo, paramCtClassType));
                localObject = str;
            }
        }
        return (String) localObject;
    }

    private static void checkSignature(CtMethod paramCtMethod, String paramString) {
        if (!paramString.equals(paramCtMethod.getMethodInfo2().getDescriptor())) {
            throw new CannotCompileException("wrapped method with a bad signature: " + paramCtMethod.getDeclaringClass().getName() + '.' + paramCtMethod.getName());
        }
    }

    static int compileParameterList(Bytecode paramBytecode, CtClass[] paramArrayOfCtClass, int paramInt) {
        return JvstCodeGen.compileParameterList(paramBytecode, paramArrayOfCtClass, paramInt);
    }

    private static void compileReturn(Bytecode paramBytecode, CtClass paramCtClass) {
        if (paramCtClass.isPrimitive()) {
            paramCtClass = (CtPrimitiveType) paramCtClass;
            if (paramCtClass != CtClass.voidType) {
                String str = paramCtClass.getWrapperName();
                paramBytecode.addCheckcast(str);
                paramBytecode.addInvokevirtual(str, paramCtClass.getGetMethodName(), paramCtClass.getGetMethodDescriptor());
            }
            paramBytecode.addOpcode(paramCtClass.getReturnOp());
            return;
        }
        paramBytecode.addCheckcast(paramCtClass);
        paramBytecode.addOpcode(176);
    }

    static Bytecode makeBody(CtClass paramCtClass1, ClassFile paramClassFile, CtMethod paramCtMethod, CtClass[] paramArrayOfCtClass, CtClass paramCtClass2, CtMethod.ConstParameter paramConstParameter) {
        boolean bool = Modifier.isStatic(paramCtMethod.getModifiers());
        Bytecode localBytecode = new Bytecode(paramClassFile.getConstPool(), 0, 0);
        localBytecode.setMaxStack(makeBody0(paramCtClass1, paramClassFile, paramCtMethod, bool, paramArrayOfCtClass, paramCtClass2, paramConstParameter, localBytecode));
        localBytecode.setMaxLocals(bool, paramArrayOfCtClass, 0);
        return localBytecode;
    }

    protected static int makeBody0(CtClass paramCtClass1, ClassFile paramClassFile, CtMethod paramCtMethod, boolean paramBoolean, CtClass[] paramArrayOfCtClass, CtClass paramCtClass2, CtMethod.ConstParameter paramConstParameter, Bytecode paramBytecode) {
        int j = 0;
        if (!(paramCtClass1 instanceof CtClassType)) {
            throw new CannotCompileException("bad declaring class" + paramCtClass1.getName());
        }
        if (!paramBoolean) {
            paramBytecode.addAload(0);
        }
        int i;
        int k;
        if (paramBoolean) {
            i = 0;
            k = compileParameterList(paramBytecode, paramArrayOfCtClass, i);
            if (paramConstParameter != null) {
                break label140;
            }
            paramArrayOfCtClass = CtMethod.ConstParameter.defaultDescriptor();
            i = j;
            label82:
            checkSignature(paramCtMethod, paramArrayOfCtClass);
        }
        for (; ; ) {
            try {
                paramCtClass1 = addBodyMethod((CtClassType) paramCtClass1, paramClassFile, paramCtMethod);
                if (!paramBoolean) {
                    break label169;
                }
                paramBytecode.addInvokestatic(Bytecode.THIS, paramCtClass1, paramArrayOfCtClass);
                compileReturn(paramBytecode, paramCtClass2);
                if (k >= i + 2) {
                    break label183;
                }
                return i + 2;
            } catch (BadBytecode paramCtClass1) {
                label140:
                throw new CannotCompileException(paramCtClass1);
            }
            i = 1;
            break;
            i = paramConstParameter.compile(paramBytecode);
            paramArrayOfCtClass = paramConstParameter.descriptor();
            break label82;
            label169:
            paramBytecode.addInvokespecial(Bytecode.THIS, paramCtClass1, paramArrayOfCtClass);
        }
        label183:
        return k;
    }

    public static CtMethod wrapped(CtClass paramCtClass1, String paramString, CtClass[] paramArrayOfCtClass1, CtClass[] paramArrayOfCtClass2, CtMethod paramCtMethod, CtMethod.ConstParameter paramConstParameter, CtClass paramCtClass2) {
        paramString = new CtMethod(paramCtClass1, paramString, paramArrayOfCtClass1, paramCtClass2);
        paramString.setModifiers(paramCtMethod.getModifiers());
        try {
            paramString.setExceptionTypes(paramArrayOfCtClass2);
            paramCtClass1 = makeBody(paramCtClass2, paramCtClass2.getClassFile2(), paramCtMethod, paramArrayOfCtClass1, paramCtClass1, paramConstParameter);
            paramString.getMethodInfo2().setCodeAttribute(paramCtClass1.toCodeAttribute());
            return paramString;
        } catch (NotFoundException paramCtClass1) {
            throw new CannotCompileException(paramCtClass1);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtNewWrappedMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */