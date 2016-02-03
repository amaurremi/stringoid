package javassist.bytecode.analysis;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.Opcode;

public class Executor
        implements Opcode {
    private final Type CLASS_TYPE;
    private final Type STRING_TYPE;
    private final Type THROWABLE_TYPE;
    private final ClassPool classPool;
    private final ConstPool constPool;
    private int lastPos;

    public Executor(ClassPool paramClassPool, ConstPool paramConstPool) {
        this.constPool = paramConstPool;
        this.classPool = paramClassPool;
        try {
            this.STRING_TYPE = getType("java.lang.String");
            this.CLASS_TYPE = getType("java.lang.Class");
            this.THROWABLE_TYPE = getType("java.lang.Throwable");
            return;
        } catch (Exception paramClassPool) {
            throw new RuntimeException(paramClassPool);
        }
    }

    private void access(int paramInt, Type paramType, Subroutine paramSubroutine) {
        if (paramSubroutine == null) {
        }
        do {
            return;
            paramSubroutine.access(paramInt);
        } while (paramType.getSize() != 2);
        paramSubroutine.access(paramInt + 1);
    }

    private void evalArrayLoad(Type paramType, Frame paramFrame) {
        Type localType1 = paramFrame.pop();
        Type localType2 = paramFrame.pop();
        if (localType2 == Type.UNINIT) {
            verifyAssignable(Type.INTEGER, localType1);
            if (paramType == Type.OBJECT) {
                simplePush(Type.UNINIT, paramFrame);
                return;
            }
            simplePush(paramType, paramFrame);
            return;
        }
        localType2 = localType2.getComponent();
        if (localType2 == null) {
            throw new BadBytecode("Not an array! [pos = " + this.lastPos + "]: " + localType2);
        }
        localType2 = zeroExtend(localType2);
        verifyAssignable(paramType, localType2);
        verifyAssignable(Type.INTEGER, localType1);
        simplePush(localType2, paramFrame);
    }

    private void evalArrayStore(Type paramType, Frame paramFrame) {
        Type localType1 = simplePop(paramFrame);
        Type localType2 = paramFrame.pop();
        paramFrame = paramFrame.pop();
        if (paramFrame == Type.UNINIT) {
            verifyAssignable(Type.INTEGER, localType2);
            return;
        }
        paramFrame = paramFrame.getComponent();
        if (paramFrame == null) {
            throw new BadBytecode("Not an array! [pos = " + this.lastPos + "]: " + paramFrame);
        }
        paramFrame = zeroExtend(paramFrame);
        verifyAssignable(paramType, paramFrame);
        verifyAssignable(Type.INTEGER, localType2);
        if (paramType == Type.OBJECT) {
            verifyAssignable(paramType, localType1);
            return;
        }
        verifyAssignable(paramFrame, localType1);
    }

    private void evalBinaryMath(Type paramType, Frame paramFrame) {
        Type localType1 = simplePop(paramFrame);
        Type localType2 = simplePop(paramFrame);
        verifyAssignable(paramType, localType1);
        verifyAssignable(paramType, localType2);
        simplePush(localType2, paramFrame);
    }

    private void evalGetField(int paramInt1, int paramInt2, Frame paramFrame) {
        Type localType = zeroExtend(typeFromDesc(this.constPool.getFieldrefType(paramInt2)));
        if (paramInt1 == 180) {
            verifyAssignable(resolveClassInfo(this.constPool.getFieldrefClassName(paramInt2)), simplePop(paramFrame));
        }
        simplePush(localType, paramFrame);
    }

    private void evalInvokeIntfMethod(int paramInt1, int paramInt2, Frame paramFrame) {
        Object localObject = this.constPool.getInterfaceMethodrefType(paramInt2);
        Type[] arrayOfType = paramTypesFromDesc((String) localObject);
        paramInt1 = arrayOfType.length;
        while (paramInt1 > 0) {
            paramInt1 -= 1;
            verifyAssignable(zeroExtend(arrayOfType[paramInt1]), simplePop(paramFrame));
        }
        verifyAssignable(resolveClassInfo(this.constPool.getInterfaceMethodrefClassName(paramInt2)), simplePop(paramFrame));
        localObject = returnTypeFromDesc((String) localObject);
        if (localObject != Type.VOID) {
            simplePush(zeroExtend((Type) localObject), paramFrame);
        }
    }

    private void evalInvokeMethod(int paramInt1, int paramInt2, Frame paramFrame) {
        Object localObject = this.constPool.getMethodrefType(paramInt2);
        Type[] arrayOfType = paramTypesFromDesc((String) localObject);
        int i = arrayOfType.length;
        while (i > 0) {
            i -= 1;
            verifyAssignable(zeroExtend(arrayOfType[i]), simplePop(paramFrame));
        }
        if (paramInt1 != 184) {
            verifyAssignable(resolveClassInfo(this.constPool.getMethodrefClassName(paramInt2)), simplePop(paramFrame));
        }
        localObject = returnTypeFromDesc((String) localObject);
        if (localObject != Type.VOID) {
            simplePush(zeroExtend((Type) localObject), paramFrame);
        }
    }

    private void evalLDC(int paramInt, Frame paramFrame) {
        paramInt = this.constPool.getTag(paramInt);
        Type localType;
        switch (paramInt) {
            default:
                throw new BadBytecode("bad LDC [pos = " + this.lastPos + "]: " + paramInt);
            case 8:
                localType = this.STRING_TYPE;
        }
        for (; ; ) {
            simplePush(localType, paramFrame);
            return;
            localType = Type.INTEGER;
            continue;
            localType = Type.FLOAT;
            continue;
            localType = Type.LONG;
            continue;
            localType = Type.DOUBLE;
            continue;
            localType = this.CLASS_TYPE;
        }
    }

    private void evalLoad(Type paramType, int paramInt, Frame paramFrame, Subroutine paramSubroutine) {
        Type localType = paramFrame.getLocal(paramInt);
        verifyAssignable(paramType, localType);
        simplePush(localType, paramFrame);
        access(paramInt, localType, paramSubroutine);
    }

    private void evalNewArray(int paramInt, CodeIterator paramCodeIterator, Frame paramFrame) {
        verifyAssignable(Type.INTEGER, simplePop(paramFrame));
        int i = paramCodeIterator.byteAt(paramInt + 1);
        switch (i) {
            default:
                throw new BadBytecode("Invalid array type [pos = " + paramInt + "]: " + i);
            case 4:
                paramCodeIterator = getType("boolean[]");
        }
        for (; ; ) {
            paramFrame.push(paramCodeIterator);
            return;
            paramCodeIterator = getType("char[]");
            continue;
            paramCodeIterator = getType("byte[]");
            continue;
            paramCodeIterator = getType("short[]");
            continue;
            paramCodeIterator = getType("int[]");
            continue;
            paramCodeIterator = getType("long[]");
            continue;
            paramCodeIterator = getType("float[]");
            continue;
            paramCodeIterator = getType("double[]");
        }
    }

    private void evalNewObjectArray(int paramInt, CodeIterator paramCodeIterator, Frame paramFrame) {
        String str = resolveClassInfo(this.constPool.getClassInfo(paramCodeIterator.u16bitAt(paramInt + 1))).getCtClass().getName();
        if (paramCodeIterator.byteAt(paramInt) == 197) {
            paramInt = paramCodeIterator.byteAt(paramInt + 3);
            paramCodeIterator = str;
        }
        while (paramInt > 0) {
            verifyAssignable(Type.INTEGER, simplePop(paramFrame));
            paramInt -= 1;
            continue;
            paramCodeIterator = str + "[]";
            paramInt = 1;
        }
        simplePush(getType(paramCodeIterator), paramFrame);
    }

    private void evalPutField(int paramInt1, int paramInt2, Frame paramFrame) {
        verifyAssignable(zeroExtend(typeFromDesc(this.constPool.getFieldrefType(paramInt2))), simplePop(paramFrame));
        if (paramInt1 == 181) {
            verifyAssignable(resolveClassInfo(this.constPool.getFieldrefClassName(paramInt2)), simplePop(paramFrame));
        }
    }

    private void evalShift(Type paramType, Frame paramFrame) {
        Type localType1 = simplePop(paramFrame);
        Type localType2 = simplePop(paramFrame);
        verifyAssignable(Type.INTEGER, localType1);
        verifyAssignable(paramType, localType2);
        simplePush(localType2, paramFrame);
    }

    private void evalStore(Type paramType, int paramInt, Frame paramFrame, Subroutine paramSubroutine) {
        Type localType = simplePop(paramFrame);
        if ((paramType != Type.OBJECT) || (localType != Type.RETURN_ADDRESS)) {
            verifyAssignable(paramType, localType);
        }
        simpleSetLocal(paramInt, localType, paramFrame);
        access(paramInt, localType, paramSubroutine);
    }

    private void evalWide(int paramInt, CodeIterator paramCodeIterator, Frame paramFrame, Subroutine paramSubroutine) {
        int i = paramCodeIterator.byteAt(paramInt + 1);
        int j = paramCodeIterator.u16bitAt(paramInt + 2);
        switch (i) {
            default:
                throw new BadBytecode("Invalid WIDE operand [pos = " + paramInt + "]: " + i);
            case 21:
                evalLoad(Type.INTEGER, j, paramFrame, paramSubroutine);
                return;
            case 22:
                evalLoad(Type.LONG, j, paramFrame, paramSubroutine);
                return;
            case 23:
                evalLoad(Type.FLOAT, j, paramFrame, paramSubroutine);
                return;
            case 24:
                evalLoad(Type.DOUBLE, j, paramFrame, paramSubroutine);
                return;
            case 25:
                evalLoad(Type.OBJECT, j, paramFrame, paramSubroutine);
                return;
            case 54:
                evalStore(Type.INTEGER, j, paramFrame, paramSubroutine);
                return;
            case 55:
                evalStore(Type.LONG, j, paramFrame, paramSubroutine);
                return;
            case 56:
                evalStore(Type.FLOAT, j, paramFrame, paramSubroutine);
                return;
            case 57:
                evalStore(Type.DOUBLE, j, paramFrame, paramSubroutine);
                return;
            case 58:
                evalStore(Type.OBJECT, j, paramFrame, paramSubroutine);
                return;
            case 132:
                verifyAssignable(Type.INTEGER, paramFrame.getLocal(j));
                return;
        }
        verifyAssignable(Type.RETURN_ADDRESS, paramFrame.getLocal(j));
    }

    private Type getType(String paramString) {
        try {
            Type localType = Type.get(this.classPool.get(paramString));
            return localType;
        } catch (NotFoundException localNotFoundException) {
            throw new BadBytecode("Could not find class [pos = " + this.lastPos + "]: " + paramString);
        }
    }

    private Type[] paramTypesFromDesc(String paramString) {
        CtClass[] arrayOfCtClass;
        try {
            arrayOfCtClass = Descriptor.getParameterTypes(paramString, this.classPool);
            if (arrayOfCtClass == null) {
                throw new BadBytecode("Could not obtain parameters for descriptor [pos = " + this.lastPos + "]: " + paramString);
            }
        } catch (NotFoundException paramString) {
            throw new BadBytecode("Could not find class in descriptor [pos = " + this.lastPos + "]: " + paramString.getMessage());
        }
        paramString = new Type[arrayOfCtClass.length];
        int i = 0;
        while (i < paramString.length) {
            paramString[i] = Type.get(arrayOfCtClass[i]);
            i += 1;
        }
        return paramString;
    }

    private Type resolveClassInfo(String paramString) {
        try {
            if (paramString.charAt(0) == '[') {
            }
            for (CtClass localCtClass = Descriptor.toCtClass(paramString, this.classPool); localCtClass == null; localCtClass = this.classPool.get(paramString)) {
                throw new BadBytecode("Could not obtain type for descriptor [pos = " + this.lastPos + "]: " + paramString);
            }
            return Type.get(localCtClass);
        } catch (NotFoundException paramString) {
            throw new BadBytecode("Could not find class in descriptor [pos = " + this.lastPos + "]: " + paramString.getMessage());
        }
    }

    private Type returnTypeFromDesc(String paramString) {
        CtClass localCtClass;
        try {
            localCtClass = Descriptor.getReturnType(paramString, this.classPool);
            if (localCtClass == null) {
                throw new BadBytecode("Could not obtain return type for descriptor [pos = " + this.lastPos + "]: " + paramString);
            }
        } catch (NotFoundException paramString) {
            throw new BadBytecode("Could not find class in descriptor [pos = " + this.lastPos + "]: " + paramString.getMessage());
        }
        return Type.get(localCtClass);
    }

    private Type simplePeek(Frame paramFrame) {
        Type localType2 = paramFrame.peek();
        Type localType1 = localType2;
        if (localType2 == Type.TOP) {
            localType1 = paramFrame.getStack(paramFrame.getTopIndex() - 1);
        }
        return localType1;
    }

    private Type simplePop(Frame paramFrame) {
        Type localType2 = paramFrame.pop();
        Type localType1 = localType2;
        if (localType2 == Type.TOP) {
            localType1 = paramFrame.pop();
        }
        return localType1;
    }

    private void simplePush(Type paramType, Frame paramFrame) {
        paramFrame.push(paramType);
        if (paramType.getSize() == 2) {
            paramFrame.push(Type.TOP);
        }
    }

    private void simpleSetLocal(int paramInt, Type paramType, Frame paramFrame) {
        paramFrame.setLocal(paramInt, paramType);
        if (paramType.getSize() == 2) {
            paramFrame.setLocal(paramInt + 1, Type.TOP);
        }
    }

    private Type typeFromDesc(String paramString) {
        CtClass localCtClass;
        try {
            localCtClass = Descriptor.toCtClass(paramString, this.classPool);
            if (localCtClass == null) {
                throw new BadBytecode("Could not obtain type for descriptor [pos = " + this.lastPos + "]: " + paramString);
            }
        } catch (NotFoundException paramString) {
            throw new BadBytecode("Could not find class in descriptor [pos = " + this.lastPos + "]: " + paramString.getMessage());
        }
        return Type.get(localCtClass);
    }

    private void verifyAssignable(Type paramType1, Type paramType2) {
        if (!paramType1.isAssignableFrom(paramType2)) {
            throw new BadBytecode("Expected type: " + paramType1 + " Got: " + paramType2 + " [pos = " + this.lastPos + "]");
        }
    }

    private Type zeroExtend(Type paramType) {
        Type localType;
        if ((paramType != Type.SHORT) && (paramType != Type.BYTE) && (paramType != Type.CHAR)) {
            localType = paramType;
            if (paramType != Type.BOOLEAN) {
            }
        } else {
            localType = Type.INTEGER;
        }
        return localType;
    }

    public void execute(MethodInfo paramMethodInfo, int paramInt, CodeIterator paramCodeIterator, Frame paramFrame, Subroutine paramSubroutine) {
        this.lastPos = paramInt;
        int i = paramCodeIterator.byteAt(paramInt);
        switch (i) {
            case 0:
            case 167:
            case 177:
            case 200:
            default:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
                do {
                    return;
                    paramFrame.push(Type.UNINIT);
                    return;
                    paramFrame.push(Type.INTEGER);
                    return;
                    paramFrame.push(Type.LONG);
                    paramFrame.push(Type.TOP);
                    return;
                    paramFrame.push(Type.FLOAT);
                    return;
                    paramFrame.push(Type.DOUBLE);
                    paramFrame.push(Type.TOP);
                    return;
                    paramFrame.push(Type.INTEGER);
                    return;
                    evalLDC(paramCodeIterator.byteAt(paramInt + 1), paramFrame);
                    return;
                    evalLDC(paramCodeIterator.u16bitAt(paramInt + 1), paramFrame);
                    return;
                    evalLoad(Type.INTEGER, paramCodeIterator.byteAt(paramInt + 1), paramFrame, paramSubroutine);
                    return;
                    evalLoad(Type.LONG, paramCodeIterator.byteAt(paramInt + 1), paramFrame, paramSubroutine);
                    return;
                    evalLoad(Type.FLOAT, paramCodeIterator.byteAt(paramInt + 1), paramFrame, paramSubroutine);
                    return;
                    evalLoad(Type.DOUBLE, paramCodeIterator.byteAt(paramInt + 1), paramFrame, paramSubroutine);
                    return;
                    evalLoad(Type.OBJECT, paramCodeIterator.byteAt(paramInt + 1), paramFrame, paramSubroutine);
                    return;
                    evalLoad(Type.INTEGER, i - 26, paramFrame, paramSubroutine);
                    return;
                    evalLoad(Type.LONG, i - 30, paramFrame, paramSubroutine);
                    return;
                    evalLoad(Type.FLOAT, i - 34, paramFrame, paramSubroutine);
                    return;
                    evalLoad(Type.DOUBLE, i - 38, paramFrame, paramSubroutine);
                    return;
                    evalLoad(Type.OBJECT, i - 42, paramFrame, paramSubroutine);
                    return;
                    evalArrayLoad(Type.INTEGER, paramFrame);
                    return;
                    evalArrayLoad(Type.LONG, paramFrame);
                    return;
                    evalArrayLoad(Type.FLOAT, paramFrame);
                    return;
                    evalArrayLoad(Type.DOUBLE, paramFrame);
                    return;
                    evalArrayLoad(Type.OBJECT, paramFrame);
                    return;
                    evalArrayLoad(Type.INTEGER, paramFrame);
                    return;
                    evalStore(Type.INTEGER, paramCodeIterator.byteAt(paramInt + 1), paramFrame, paramSubroutine);
                    return;
                    evalStore(Type.LONG, paramCodeIterator.byteAt(paramInt + 1), paramFrame, paramSubroutine);
                    return;
                    evalStore(Type.FLOAT, paramCodeIterator.byteAt(paramInt + 1), paramFrame, paramSubroutine);
                    return;
                    evalStore(Type.DOUBLE, paramCodeIterator.byteAt(paramInt + 1), paramFrame, paramSubroutine);
                    return;
                    evalStore(Type.OBJECT, paramCodeIterator.byteAt(paramInt + 1), paramFrame, paramSubroutine);
                    return;
                    evalStore(Type.INTEGER, i - 59, paramFrame, paramSubroutine);
                    return;
                    evalStore(Type.LONG, i - 63, paramFrame, paramSubroutine);
                    return;
                    evalStore(Type.FLOAT, i - 67, paramFrame, paramSubroutine);
                    return;
                    evalStore(Type.DOUBLE, i - 71, paramFrame, paramSubroutine);
                    return;
                    evalStore(Type.OBJECT, i - 75, paramFrame, paramSubroutine);
                    return;
                    evalArrayStore(Type.INTEGER, paramFrame);
                    return;
                    evalArrayStore(Type.LONG, paramFrame);
                    return;
                    evalArrayStore(Type.FLOAT, paramFrame);
                    return;
                    evalArrayStore(Type.DOUBLE, paramFrame);
                    return;
                    evalArrayStore(Type.OBJECT, paramFrame);
                    return;
                    evalArrayStore(Type.INTEGER, paramFrame);
                    return;
                } while (paramFrame.pop() != Type.TOP);
                throw new BadBytecode("POP can not be used with a category 2 value, pos = " + paramInt);
            case 88:
                paramFrame.pop();
                paramFrame.pop();
                return;
            case 89:
                if (paramFrame.peek() == Type.TOP) {
                    throw new BadBytecode("DUP can not be used with a category 2 value, pos = " + paramInt);
                }
                paramFrame.push(paramFrame.peek());
                return;
            case 90:
            case 91:
                paramMethodInfo = paramFrame.peek();
                if (paramMethodInfo == Type.TOP) {
                    throw new BadBytecode("DUP can not be used with a category 2 value, pos = " + paramInt);
                }
                paramInt = paramFrame.getTopIndex();
                i = paramInt - (i - 90) - 1;
                paramFrame.push(paramMethodInfo);
                while (paramInt > i) {
                    paramFrame.setStack(paramInt, paramFrame.getStack(paramInt - 1));
                    paramInt -= 1;
                }
                paramFrame.setStack(i, paramMethodInfo);
                return;
            case 92:
                paramFrame.push(paramFrame.getStack(paramFrame.getTopIndex() - 1));
                paramFrame.push(paramFrame.getStack(paramFrame.getTopIndex() - 1));
                return;
            case 93:
            case 94:
                paramInt = paramFrame.getTopIndex();
                i = paramInt - (i - 93) - 1;
                paramMethodInfo = paramFrame.getStack(paramFrame.getTopIndex() - 1);
                paramCodeIterator = paramFrame.peek();
                paramFrame.push(paramMethodInfo);
                paramFrame.push(paramCodeIterator);
                while (paramInt > i) {
                    paramFrame.setStack(paramInt, paramFrame.getStack(paramInt - 2));
                    paramInt -= 1;
                }
                paramFrame.setStack(i, paramCodeIterator);
                paramFrame.setStack(i - 1, paramMethodInfo);
                return;
            case 95:
                paramMethodInfo = paramFrame.pop();
                paramCodeIterator = paramFrame.pop();
                if ((paramMethodInfo.getSize() == 2) || (paramCodeIterator.getSize() == 2)) {
                    throw new BadBytecode("Swap can not be used with category 2 values, pos = " + paramInt);
                }
                paramFrame.push(paramMethodInfo);
                paramFrame.push(paramCodeIterator);
                return;
            case 96:
                evalBinaryMath(Type.INTEGER, paramFrame);
                return;
            case 97:
                evalBinaryMath(Type.LONG, paramFrame);
                return;
            case 98:
                evalBinaryMath(Type.FLOAT, paramFrame);
                return;
            case 99:
                evalBinaryMath(Type.DOUBLE, paramFrame);
                return;
            case 100:
                evalBinaryMath(Type.INTEGER, paramFrame);
                return;
            case 101:
                evalBinaryMath(Type.LONG, paramFrame);
                return;
            case 102:
                evalBinaryMath(Type.FLOAT, paramFrame);
                return;
            case 103:
                evalBinaryMath(Type.DOUBLE, paramFrame);
                return;
            case 104:
                evalBinaryMath(Type.INTEGER, paramFrame);
                return;
            case 105:
                evalBinaryMath(Type.LONG, paramFrame);
                return;
            case 106:
                evalBinaryMath(Type.FLOAT, paramFrame);
                return;
            case 107:
                evalBinaryMath(Type.DOUBLE, paramFrame);
                return;
            case 108:
                evalBinaryMath(Type.INTEGER, paramFrame);
                return;
            case 109:
                evalBinaryMath(Type.LONG, paramFrame);
                return;
            case 110:
                evalBinaryMath(Type.FLOAT, paramFrame);
                return;
            case 111:
                evalBinaryMath(Type.DOUBLE, paramFrame);
                return;
            case 112:
                evalBinaryMath(Type.INTEGER, paramFrame);
                return;
            case 113:
                evalBinaryMath(Type.LONG, paramFrame);
                return;
            case 114:
                evalBinaryMath(Type.FLOAT, paramFrame);
                return;
            case 115:
                evalBinaryMath(Type.DOUBLE, paramFrame);
                return;
            case 116:
                verifyAssignable(Type.INTEGER, simplePeek(paramFrame));
                return;
            case 117:
                verifyAssignable(Type.LONG, simplePeek(paramFrame));
                return;
            case 118:
                verifyAssignable(Type.FLOAT, simplePeek(paramFrame));
                return;
            case 119:
                verifyAssignable(Type.DOUBLE, simplePeek(paramFrame));
                return;
            case 120:
                evalShift(Type.INTEGER, paramFrame);
                return;
            case 121:
                evalShift(Type.LONG, paramFrame);
                return;
            case 122:
                evalShift(Type.INTEGER, paramFrame);
                return;
            case 123:
                evalShift(Type.LONG, paramFrame);
                return;
            case 124:
                evalShift(Type.INTEGER, paramFrame);
                return;
            case 125:
                evalShift(Type.LONG, paramFrame);
                return;
            case 126:
                evalBinaryMath(Type.INTEGER, paramFrame);
                return;
            case 127:
                evalBinaryMath(Type.LONG, paramFrame);
                return;
            case 128:
                evalBinaryMath(Type.INTEGER, paramFrame);
                return;
            case 129:
                evalBinaryMath(Type.LONG, paramFrame);
                return;
            case 130:
                evalBinaryMath(Type.INTEGER, paramFrame);
                return;
            case 131:
                evalBinaryMath(Type.LONG, paramFrame);
                return;
            case 132:
                paramInt = paramCodeIterator.byteAt(paramInt + 1);
                verifyAssignable(Type.INTEGER, paramFrame.getLocal(paramInt));
                access(paramInt, Type.INTEGER, paramSubroutine);
                return;
            case 133:
                verifyAssignable(Type.INTEGER, simplePop(paramFrame));
                simplePush(Type.LONG, paramFrame);
                return;
            case 134:
                verifyAssignable(Type.INTEGER, simplePop(paramFrame));
                simplePush(Type.FLOAT, paramFrame);
                return;
            case 135:
                verifyAssignable(Type.INTEGER, simplePop(paramFrame));
                simplePush(Type.DOUBLE, paramFrame);
                return;
            case 136:
                verifyAssignable(Type.LONG, simplePop(paramFrame));
                simplePush(Type.INTEGER, paramFrame);
                return;
            case 137:
                verifyAssignable(Type.LONG, simplePop(paramFrame));
                simplePush(Type.FLOAT, paramFrame);
                return;
            case 138:
                verifyAssignable(Type.LONG, simplePop(paramFrame));
                simplePush(Type.DOUBLE, paramFrame);
                return;
            case 139:
                verifyAssignable(Type.FLOAT, simplePop(paramFrame));
                simplePush(Type.INTEGER, paramFrame);
                return;
            case 140:
                verifyAssignable(Type.FLOAT, simplePop(paramFrame));
                simplePush(Type.LONG, paramFrame);
                return;
            case 141:
                verifyAssignable(Type.FLOAT, simplePop(paramFrame));
                simplePush(Type.DOUBLE, paramFrame);
                return;
            case 142:
                verifyAssignable(Type.DOUBLE, simplePop(paramFrame));
                simplePush(Type.INTEGER, paramFrame);
                return;
            case 143:
                verifyAssignable(Type.DOUBLE, simplePop(paramFrame));
                simplePush(Type.LONG, paramFrame);
                return;
            case 144:
                verifyAssignable(Type.DOUBLE, simplePop(paramFrame));
                simplePush(Type.FLOAT, paramFrame);
                return;
            case 145:
            case 146:
            case 147:
                verifyAssignable(Type.INTEGER, paramFrame.peek());
                return;
            case 148:
                verifyAssignable(Type.LONG, simplePop(paramFrame));
                verifyAssignable(Type.LONG, simplePop(paramFrame));
                paramFrame.push(Type.INTEGER);
                return;
            case 149:
            case 150:
                verifyAssignable(Type.FLOAT, simplePop(paramFrame));
                verifyAssignable(Type.FLOAT, simplePop(paramFrame));
                paramFrame.push(Type.INTEGER);
                return;
            case 151:
            case 152:
                verifyAssignable(Type.DOUBLE, simplePop(paramFrame));
                verifyAssignable(Type.DOUBLE, simplePop(paramFrame));
                paramFrame.push(Type.INTEGER);
                return;
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
                verifyAssignable(Type.INTEGER, simplePop(paramFrame));
                return;
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
                verifyAssignable(Type.INTEGER, simplePop(paramFrame));
                verifyAssignable(Type.INTEGER, simplePop(paramFrame));
                return;
            case 165:
            case 166:
                verifyAssignable(Type.OBJECT, simplePop(paramFrame));
                verifyAssignable(Type.OBJECT, simplePop(paramFrame));
                return;
            case 168:
                paramFrame.push(Type.RETURN_ADDRESS);
                return;
            case 169:
                verifyAssignable(Type.RETURN_ADDRESS, paramFrame.getLocal(paramCodeIterator.byteAt(paramInt + 1)));
                return;
            case 170:
            case 171:
            case 172:
                verifyAssignable(Type.INTEGER, simplePop(paramFrame));
                return;
            case 173:
                verifyAssignable(Type.LONG, simplePop(paramFrame));
                return;
            case 174:
                verifyAssignable(Type.FLOAT, simplePop(paramFrame));
                return;
            case 175:
                verifyAssignable(Type.DOUBLE, simplePop(paramFrame));
                return;
            case 176:
                try {
                    verifyAssignable(Type.get(Descriptor.getReturnType(paramMethodInfo.getDescriptor(), this.classPool)), simplePop(paramFrame));
                    return;
                } catch (NotFoundException paramMethodInfo) {
                    throw new RuntimeException(paramMethodInfo);
                }
            case 178:
                evalGetField(i, paramCodeIterator.u16bitAt(paramInt + 1), paramFrame);
                return;
            case 179:
                evalPutField(i, paramCodeIterator.u16bitAt(paramInt + 1), paramFrame);
                return;
            case 180:
                evalGetField(i, paramCodeIterator.u16bitAt(paramInt + 1), paramFrame);
                return;
            case 181:
                evalPutField(i, paramCodeIterator.u16bitAt(paramInt + 1), paramFrame);
                return;
            case 182:
            case 183:
            case 184:
                evalInvokeMethod(i, paramCodeIterator.u16bitAt(paramInt + 1), paramFrame);
                return;
            case 185:
                evalInvokeIntfMethod(i, paramCodeIterator.u16bitAt(paramInt + 1), paramFrame);
                return;
            case 186:
                throw new RuntimeException("Bad opcode 186");
            case 187:
                paramFrame.push(resolveClassInfo(this.constPool.getClassInfo(paramCodeIterator.u16bitAt(paramInt + 1))));
                return;
            case 188:
                evalNewArray(paramInt, paramCodeIterator, paramFrame);
                return;
            case 189:
                evalNewObjectArray(paramInt, paramCodeIterator, paramFrame);
                return;
            case 190:
                paramMethodInfo = simplePop(paramFrame);
                if ((!paramMethodInfo.isArray()) && (paramMethodInfo != Type.UNINIT)) {
                    throw new BadBytecode("Array length passed a non-array [pos = " + paramInt + "]: " + paramMethodInfo);
                }
                paramFrame.push(Type.INTEGER);
                return;
            case 191:
                verifyAssignable(this.THROWABLE_TYPE, simplePop(paramFrame));
                return;
            case 192:
                verifyAssignable(Type.OBJECT, simplePop(paramFrame));
                paramFrame.push(typeFromDesc(this.constPool.getClassInfoByDescriptor(paramCodeIterator.u16bitAt(paramInt + 1))));
                return;
            case 193:
                verifyAssignable(Type.OBJECT, simplePop(paramFrame));
                paramFrame.push(Type.INTEGER);
                return;
            case 194:
            case 195:
                verifyAssignable(Type.OBJECT, simplePop(paramFrame));
                return;
            case 196:
                evalWide(paramInt, paramCodeIterator, paramFrame, paramSubroutine);
                return;
            case 197:
                evalNewObjectArray(paramInt, paramCodeIterator, paramFrame);
                return;
            case 198:
            case 199:
                verifyAssignable(Type.OBJECT, simplePop(paramFrame));
                return;
        }
        paramFrame.push(Type.RETURN_ADDRESS);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/Executor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */