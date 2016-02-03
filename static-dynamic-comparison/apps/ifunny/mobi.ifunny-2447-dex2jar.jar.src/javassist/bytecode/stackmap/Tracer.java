package javassist.bytecode.stackmap;

import javassist.ClassPool;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.ByteArray;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;

public abstract class Tracer
        implements TypeTag {
    protected ClassPool classPool;
    protected ConstPool cpool;
    protected TypeData[] localsTypes;
    protected String returnType;
    protected int stackTop;
    protected TypeData[] stackTypes;

    public Tracer(ClassPool paramClassPool, ConstPool paramConstPool, int paramInt1, int paramInt2, String paramString) {
        this.classPool = paramClassPool;
        this.cpool = paramConstPool;
        this.returnType = paramString;
        this.stackTop = 0;
        this.stackTypes = new TypeData[paramInt1];
        this.localsTypes = new TypeData[paramInt2];
    }

    public Tracer(Tracer paramTracer, boolean paramBoolean) {
        this.classPool = paramTracer.classPool;
        this.cpool = paramTracer.cpool;
        this.returnType = paramTracer.returnType;
        this.stackTop = paramTracer.stackTop;
        this.stackTypes = new TypeData[paramTracer.stackTypes.length];
        if (paramBoolean) {
            copyFrom(paramTracer.stackTop, paramTracer.stackTypes, this.stackTypes);
        }
        int i = paramTracer.localsTypes.length;
        this.localsTypes = new TypeData[i];
        copyFrom(i, paramTracer.localsTypes, this.localsTypes);
    }

    private void checkParamTypes(String paramString, int paramInt) {
        int j = paramString.charAt(paramInt);
        if (j == 41) {
        }
        int k;
        do {
            return;
            int i = paramInt;
            int m = 0;
            k = i;
            for (i = m; j == 91; i = 1) {
                k += 1;
                j = paramString.charAt(k);
            }
            if (j == 76) {
                m = paramString.indexOf(';', k) + 1;
                k = m;
                if (m <= 0) {
                    throw new IndexOutOfBoundsException("bad descriptor");
                }
            } else {
                k += 1;
            }
            checkParamTypes(paramString, k);
            if ((i == 0) && ((j == 74) || (j == 68))) {
            }
            for (this.stackTop -= 2; i != 0; this.stackTop -= 1) {
                TypeData.setType(this.stackTypes[this.stackTop], paramString.substring(paramInt, k), this.classPool);
                return;
            }
        } while (j != 76);
        TypeData.setType(this.stackTypes[this.stackTop], paramString.substring(paramInt + 1, k - 1).replace('/', '.'), this.classPool);
    }

    protected static int copyFrom(int paramInt, TypeData[] paramArrayOfTypeData1, TypeData[] paramArrayOfTypeData2) {
        int i = -1;
        int j = 0;
        TypeData localTypeData2;
        TypeData localTypeData1;
        if (j < paramInt) {
            localTypeData2 = paramArrayOfTypeData1[j];
            if (localTypeData2 == TOP) {
                localTypeData1 = TOP;
                label30:
                paramArrayOfTypeData2[j] = localTypeData1;
                if (localTypeData2 == TOP) {
                    break label86;
                }
                if (!localTypeData2.is2WordType()) {
                    break label76;
                }
                i = j + 1;
            }
        }
        label76:
        label86:
        for (; ; ) {
            j += 1;
            break;
            localTypeData1 = localTypeData2.getSelf();
            break label30;
            i = j;
            continue;
            return i + 1;
        }
    }

    private int doALOAD(int paramInt) {
        TypeData[] arrayOfTypeData = this.stackTypes;
        int i = this.stackTop;
        this.stackTop = (i + 1);
        arrayOfTypeData[i] = this.localsTypes[paramInt];
        return 2;
    }

    private int doASTORE(int paramInt) {
        this.stackTop -= 1;
        this.localsTypes[paramInt] = this.stackTypes[this.stackTop].copy();
        return 2;
    }

    private void doDUP_XX(int paramInt1, int paramInt2) {
        TypeData[] arrayOfTypeData = this.stackTypes;
        int j = this.stackTop - 1;
        int i = j;
        while (i > j - paramInt2) {
            arrayOfTypeData[(i + paramInt1)] = arrayOfTypeData[i];
            i -= 1;
        }
    }

    private int doGetField(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean) {
        paramInt = ByteArray.readU16bit(paramArrayOfByte, paramInt + 1);
        setFieldTarget(paramBoolean, paramInt);
        pushMemberType(this.cpool.getFieldrefType(paramInt));
        return 3;
    }

    private int doInvokeIntfMethod(int paramInt, byte[] paramArrayOfByte) {
        paramInt = ByteArray.readU16bit(paramArrayOfByte, paramInt + 1);
        paramArrayOfByte = this.cpool.getInterfaceMethodrefType(paramInt);
        checkParamTypes(paramArrayOfByte, 1);
        String str = this.cpool.getInterfaceMethodrefClassName(paramInt);
        TypeData[] arrayOfTypeData = this.stackTypes;
        paramInt = this.stackTop - 1;
        this.stackTop = paramInt;
        TypeData.setType(arrayOfTypeData[paramInt], str, this.classPool);
        pushMemberType(paramArrayOfByte);
        return 5;
    }

    private int doInvokeMethod(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean) {
        paramInt = ByteArray.readU16bit(paramArrayOfByte, paramInt + 1);
        paramArrayOfByte = this.cpool.getMethodrefType(paramInt);
        checkParamTypes(paramArrayOfByte, 1);
        if (paramBoolean) {
            String str = this.cpool.getMethodrefClassName(paramInt);
            TypeData[] arrayOfTypeData = this.stackTypes;
            paramInt = this.stackTop - 1;
            this.stackTop = paramInt;
            TypeData.setType(arrayOfTypeData[paramInt], str, this.classPool);
        }
        pushMemberType(paramArrayOfByte);
        return 3;
    }

    private void doLDC(int paramInt) {
        TypeData[] arrayOfTypeData = this.stackTypes;
        paramInt = this.cpool.getTag(paramInt);
        if (paramInt == 8) {
            paramInt = this.stackTop;
            this.stackTop = (paramInt + 1);
            arrayOfTypeData[paramInt] = new TypeData.ClassName("java.lang.String");
            return;
        }
        if (paramInt == 3) {
            paramInt = this.stackTop;
            this.stackTop = (paramInt + 1);
            arrayOfTypeData[paramInt] = INTEGER;
            return;
        }
        if (paramInt == 4) {
            paramInt = this.stackTop;
            this.stackTop = (paramInt + 1);
            arrayOfTypeData[paramInt] = FLOAT;
            return;
        }
        if (paramInt == 5) {
            paramInt = this.stackTop;
            this.stackTop = (paramInt + 1);
            arrayOfTypeData[paramInt] = LONG;
            paramInt = this.stackTop;
            this.stackTop = (paramInt + 1);
            arrayOfTypeData[paramInt] = TOP;
            return;
        }
        if (paramInt == 6) {
            paramInt = this.stackTop;
            this.stackTop = (paramInt + 1);
            arrayOfTypeData[paramInt] = DOUBLE;
            paramInt = this.stackTop;
            this.stackTop = (paramInt + 1);
            arrayOfTypeData[paramInt] = TOP;
            return;
        }
        if (paramInt == 7) {
            paramInt = this.stackTop;
            this.stackTop = (paramInt + 1);
            arrayOfTypeData[paramInt] = new TypeData.ClassName("java.lang.Class");
            return;
        }
        throw new RuntimeException("bad LDC: " + paramInt);
    }

    private int doMultiANewArray(int paramInt, byte[] paramArrayOfByte) {
        int i = ByteArray.readU16bit(paramArrayOfByte, paramInt + 1);
        paramInt = paramArrayOfByte[(paramInt + 3)];
        this.stackTop -= (paramInt & 0xFF) - 1;
        paramArrayOfByte = this.cpool.getClassInfo(i).replace('.', '/');
        this.stackTypes[(this.stackTop - 1)] = new TypeData.ClassName(paramArrayOfByte);
        return 4;
    }

    private int doNEWARRAY(int paramInt, byte[] paramArrayOfByte) {
        int i = this.stackTop;
        switch (paramArrayOfByte[(paramInt + 1)] & 0xFF) {
            default:
                throw new RuntimeException("bad newarray");
            case 4:
                paramArrayOfByte = "[Z";
        }
        for (; ; ) {
            this.stackTypes[(i - 1)] = new TypeData.ClassName(paramArrayOfByte);
            return 2;
            paramArrayOfByte = "[C";
            continue;
            paramArrayOfByte = "[F";
            continue;
            paramArrayOfByte = "[D";
            continue;
            paramArrayOfByte = "[B";
            continue;
            paramArrayOfByte = "[S";
            continue;
            paramArrayOfByte = "[I";
            continue;
            paramArrayOfByte = "[J";
        }
    }

    private int doOpcode0_53(int paramInt1, byte[] paramArrayOfByte, int paramInt2) {
        int i = 3;
        TypeData[] arrayOfTypeData = this.stackTypes;
        switch (paramInt2) {
            default:
                throw new RuntimeException("fatal");
            case 1:
                paramInt1 = this.stackTop;
                this.stackTop = (paramInt1 + 1);
                arrayOfTypeData[paramInt1] = new TypeData.NullType();
        }
        for (; ; ) {
            paramInt1 = 1;
            do {
                return paramInt1;
                paramInt1 = this.stackTop;
                this.stackTop = (paramInt1 + 1);
                arrayOfTypeData[paramInt1] = INTEGER;
                break;
                paramInt1 = this.stackTop;
                this.stackTop = (paramInt1 + 1);
                arrayOfTypeData[paramInt1] = LONG;
                paramInt1 = this.stackTop;
                this.stackTop = (paramInt1 + 1);
                arrayOfTypeData[paramInt1] = TOP;
                break;
                paramInt1 = this.stackTop;
                this.stackTop = (paramInt1 + 1);
                arrayOfTypeData[paramInt1] = FLOAT;
                break;
                paramInt1 = this.stackTop;
                this.stackTop = (paramInt1 + 1);
                arrayOfTypeData[paramInt1] = DOUBLE;
                paramInt1 = this.stackTop;
                this.stackTop = (paramInt1 + 1);
                arrayOfTypeData[paramInt1] = TOP;
                break;
                paramInt1 = this.stackTop;
                this.stackTop = (paramInt1 + 1);
                arrayOfTypeData[paramInt1] = INTEGER;
                paramInt1 = i;
            } while (paramInt2 == 17);
            return 2;
            doLDC(paramArrayOfByte[(paramInt1 + 1)] & 0xFF);
            return 2;
            doLDC(ByteArray.readU16bit(paramArrayOfByte, paramInt1 + 1));
            return 3;
            return doXLOAD(INTEGER, paramArrayOfByte, paramInt1);
            return doXLOAD(LONG, paramArrayOfByte, paramInt1);
            return doXLOAD(FLOAT, paramArrayOfByte, paramInt1);
            return doXLOAD(DOUBLE, paramArrayOfByte, paramInt1);
            return doALOAD(paramArrayOfByte[(paramInt1 + 1)] & 0xFF);
            paramInt1 = this.stackTop;
            this.stackTop = (paramInt1 + 1);
            arrayOfTypeData[paramInt1] = INTEGER;
            continue;
            paramInt1 = this.stackTop;
            this.stackTop = (paramInt1 + 1);
            arrayOfTypeData[paramInt1] = LONG;
            paramInt1 = this.stackTop;
            this.stackTop = (paramInt1 + 1);
            arrayOfTypeData[paramInt1] = TOP;
            continue;
            paramInt1 = this.stackTop;
            this.stackTop = (paramInt1 + 1);
            arrayOfTypeData[paramInt1] = FLOAT;
            continue;
            paramInt1 = this.stackTop;
            this.stackTop = (paramInt1 + 1);
            arrayOfTypeData[paramInt1] = DOUBLE;
            paramInt1 = this.stackTop;
            this.stackTop = (paramInt1 + 1);
            arrayOfTypeData[paramInt1] = TOP;
            continue;
            paramInt1 = this.stackTop;
            this.stackTop = (paramInt1 + 1);
            arrayOfTypeData[paramInt1] = this.localsTypes[(paramInt2 - 42)];
            continue;
            paramInt1 = this.stackTop - 1;
            this.stackTop = paramInt1;
            arrayOfTypeData[(paramInt1 - 1)] = INTEGER;
            continue;
            arrayOfTypeData[(this.stackTop - 2)] = LONG;
            arrayOfTypeData[(this.stackTop - 1)] = TOP;
            continue;
            paramInt1 = this.stackTop - 1;
            this.stackTop = paramInt1;
            arrayOfTypeData[(paramInt1 - 1)] = FLOAT;
            continue;
            arrayOfTypeData[(this.stackTop - 2)] = DOUBLE;
            arrayOfTypeData[(this.stackTop - 1)] = TOP;
            continue;
            paramInt1 = this.stackTop - 1;
            this.stackTop = paramInt1;
            paramInt1 -= 1;
            paramArrayOfByte = arrayOfTypeData[paramInt1];
            if ((paramArrayOfByte == null) || (!paramArrayOfByte.isObjectType())) {
                throw new BadBytecode("bad AALOAD");
            }
            arrayOfTypeData[paramInt1] = new TypeData.ArrayElement(paramArrayOfByte);
            continue;
            paramInt1 = this.stackTop - 1;
            this.stackTop = paramInt1;
            arrayOfTypeData[(paramInt1 - 1)] = INTEGER;
        }
    }

    private int doOpcode148_201(int paramInt1, byte[] paramArrayOfByte, int paramInt2) {
        switch (paramInt2) {
            default:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 169:
            case 170:
            case 171:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case 189:
            case 190:
            case 191:
            case 192:
            case 193:
            case 194:
            case 195:
                for (; ; ) {
                    return 1;
                    this.stackTypes[(this.stackTop - 4)] = INTEGER;
                    this.stackTop -= 3;
                    continue;
                    paramArrayOfByte = this.stackTypes;
                    paramInt1 = this.stackTop - 1;
                    this.stackTop = paramInt1;
                    paramArrayOfByte[(paramInt1 - 1)] = INTEGER;
                    continue;
                    this.stackTypes[(this.stackTop - 4)] = INTEGER;
                    this.stackTop -= 3;
                    continue;
                    this.stackTop -= 1;
                    visitBranch(paramInt1, paramArrayOfByte, ByteArray.readS16bit(paramArrayOfByte, paramInt1 + 1));
                    return 3;
                    this.stackTop -= 2;
                    visitBranch(paramInt1, paramArrayOfByte, ByteArray.readS16bit(paramArrayOfByte, paramInt1 + 1));
                    return 3;
                    visitGoto(paramInt1, paramArrayOfByte, ByteArray.readS16bit(paramArrayOfByte, paramInt1 + 1));
                    return 3;
                    visitJSR(paramInt1, paramArrayOfByte);
                    return 3;
                    visitRET(paramInt1, paramArrayOfByte);
                    return 2;
                    this.stackTop -= 1;
                    paramInt2 = (paramInt1 & 0xFFFFFFFC) + 8;
                    int i = ByteArray.read32bit(paramArrayOfByte, paramInt2);
                    i = ByteArray.read32bit(paramArrayOfByte, paramInt2 + 4) - i + 1;
                    visitTableSwitch(paramInt1, paramArrayOfByte, i, paramInt2 + 8, ByteArray.read32bit(paramArrayOfByte, paramInt2 - 4));
                    return i * 4 + 16 - (paramInt1 & 0x3);
                    this.stackTop -= 1;
                    paramInt2 = (paramInt1 & 0xFFFFFFFC) + 8;
                    i = ByteArray.read32bit(paramArrayOfByte, paramInt2);
                    visitLookupSwitch(paramInt1, paramArrayOfByte, i, paramInt2 + 4, ByteArray.read32bit(paramArrayOfByte, paramInt2 - 4));
                    return i * 8 + 12 - (paramInt1 & 0x3);
                    this.stackTop -= 1;
                    visitReturn(paramInt1, paramArrayOfByte);
                    continue;
                    this.stackTop -= 2;
                    visitReturn(paramInt1, paramArrayOfByte);
                    continue;
                    this.stackTop -= 1;
                    visitReturn(paramInt1, paramArrayOfByte);
                    continue;
                    this.stackTop -= 2;
                    visitReturn(paramInt1, paramArrayOfByte);
                    continue;
                    TypeData[] arrayOfTypeData = this.stackTypes;
                    paramInt2 = this.stackTop - 1;
                    this.stackTop = paramInt2;
                    TypeData.setType(arrayOfTypeData[paramInt2], this.returnType, this.classPool);
                    visitReturn(paramInt1, paramArrayOfByte);
                    continue;
                    visitReturn(paramInt1, paramArrayOfByte);
                    continue;
                    return doGetField(paramInt1, paramArrayOfByte, false);
                    return doPutField(paramInt1, paramArrayOfByte, false);
                    return doGetField(paramInt1, paramArrayOfByte, true);
                    return doPutField(paramInt1, paramArrayOfByte, true);
                    return doInvokeMethod(paramInt1, paramArrayOfByte, true);
                    return doInvokeMethod(paramInt1, paramArrayOfByte, false);
                    return doInvokeIntfMethod(paramInt1, paramArrayOfByte);
                    throw new RuntimeException("bad opcode 186");
                    paramInt2 = ByteArray.readU16bit(paramArrayOfByte, paramInt1 + 1);
                    paramArrayOfByte = this.stackTypes;
                    i = this.stackTop;
                    this.stackTop = (i + 1);
                    paramArrayOfByte[i] = new TypeData.UninitData(paramInt1, this.cpool.getClassInfo(paramInt2));
                    return 3;
                    return doNEWARRAY(paramInt1, paramArrayOfByte);
                    paramInt1 = ByteArray.readU16bit(paramArrayOfByte, paramInt1 + 1);
                    paramArrayOfByte = this.cpool.getClassInfo(paramInt1).replace('.', '/');
                    if (paramArrayOfByte.charAt(0) == '[') {
                    }
                    for (paramArrayOfByte = "[" + paramArrayOfByte; ; paramArrayOfByte = "[L" + paramArrayOfByte + ";") {
                        this.stackTypes[(this.stackTop - 1)] = new TypeData.ClassName(paramArrayOfByte);
                        return 3;
                    }
                    TypeData.setType(this.stackTypes[(this.stackTop - 1)], "[Ljava.lang.Object;", this.classPool);
                    this.stackTypes[(this.stackTop - 1)] = INTEGER;
                    continue;
                    arrayOfTypeData = this.stackTypes;
                    paramInt2 = this.stackTop - 1;
                    this.stackTop = paramInt2;
                    TypeData.setType(arrayOfTypeData[paramInt2], "java.lang.Throwable", this.classPool);
                    visitThrow(paramInt1, paramArrayOfByte);
                    continue;
                    paramInt1 = ByteArray.readU16bit(paramArrayOfByte, paramInt1 + 1);
                    this.stackTypes[(this.stackTop - 1)] = new TypeData.ClassName(this.cpool.getClassInfo(paramInt1));
                    return 3;
                    this.stackTypes[(this.stackTop - 1)] = INTEGER;
                    return 3;
                    this.stackTop -= 1;
                }
            case 196:
                return doWIDE(paramInt1, paramArrayOfByte);
            case 197:
                return doMultiANewArray(paramInt1, paramArrayOfByte);
            case 198:
            case 199:
                this.stackTop -= 1;
                visitBranch(paramInt1, paramArrayOfByte, ByteArray.readS16bit(paramArrayOfByte, paramInt1 + 1));
                return 3;
            case 200:
                visitGoto(paramInt1, paramArrayOfByte, ByteArray.read32bit(paramArrayOfByte, paramInt1 + 1));
                return 5;
        }
        visitJSR(paramInt1, paramArrayOfByte);
        return 5;
    }

    private int doOpcode54_95(int paramInt1, byte[] paramArrayOfByte, int paramInt2) {
        TypeData[] arrayOfTypeData2 = this.localsTypes;
        TypeData[] arrayOfTypeData1 = this.stackTypes;
        switch (paramInt2) {
            default:
                throw new RuntimeException("fatal");
            case 54:
                return doXSTORE(paramInt1, paramArrayOfByte, INTEGER);
            case 55:
                return doXSTORE(paramInt1, paramArrayOfByte, LONG);
            case 56:
                return doXSTORE(paramInt1, paramArrayOfByte, FLOAT);
            case 57:
                return doXSTORE(paramInt1, paramArrayOfByte, DOUBLE);
            case 58:
                return doASTORE(paramArrayOfByte[(paramInt1 + 1)] & 0xFF);
            case 59:
            case 60:
            case 61:
            case 62:
                arrayOfTypeData2[(paramInt2 - 59)] = INTEGER;
                this.stackTop -= 1;
        }
        for (; ; ) {
            return 1;
            paramInt1 = paramInt2 - 63;
            arrayOfTypeData2[paramInt1] = LONG;
            arrayOfTypeData2[(paramInt1 + 1)] = TOP;
            this.stackTop -= 2;
            continue;
            arrayOfTypeData2[(paramInt2 - 67)] = FLOAT;
            this.stackTop -= 1;
            continue;
            paramInt1 = paramInt2 - 71;
            arrayOfTypeData2[paramInt1] = DOUBLE;
            arrayOfTypeData2[(paramInt1 + 1)] = TOP;
            this.stackTop -= 2;
            continue;
            doASTORE(paramInt2 - 75);
            continue;
            int i = this.stackTop;
            if ((paramInt2 == 80) || (paramInt2 == 82)) {
            }
            for (paramInt1 = 4; ; paramInt1 = 3) {
                this.stackTop = (i - paramInt1);
                break;
            }
            TypeData.setType(arrayOfTypeData1[(this.stackTop - 1)], TypeData.ArrayElement.getElementType(arrayOfTypeData1[(this.stackTop - 3)].getName()), this.classPool);
            this.stackTop -= 3;
            continue;
            this.stackTop -= 3;
            continue;
            this.stackTop -= 1;
            continue;
            this.stackTop -= 2;
            continue;
            paramInt1 = this.stackTop;
            arrayOfTypeData1[paramInt1] = arrayOfTypeData1[(paramInt1 - 1)];
            this.stackTop = (paramInt1 + 1);
            continue;
            paramInt1 = paramInt2 - 90 + 2;
            doDUP_XX(1, paramInt1);
            paramInt2 = this.stackTop;
            arrayOfTypeData1[(paramInt2 - paramInt1)] = arrayOfTypeData1[paramInt2];
            this.stackTop = (paramInt2 + 1);
            continue;
            doDUP_XX(2, 2);
            this.stackTop += 2;
            continue;
            paramInt1 = paramInt2 - 93 + 3;
            doDUP_XX(2, paramInt1);
            paramInt2 = this.stackTop;
            arrayOfTypeData1[(paramInt2 - paramInt1)] = arrayOfTypeData1[paramInt2];
            arrayOfTypeData1[(paramInt2 - paramInt1 + 1)] = arrayOfTypeData1[(paramInt2 + 1)];
            this.stackTop = (paramInt2 + 2);
            continue;
            paramInt1 = this.stackTop - 1;
            paramArrayOfByte = arrayOfTypeData1[paramInt1];
            arrayOfTypeData1[paramInt1] = arrayOfTypeData1[(paramInt1 - 1)];
            arrayOfTypeData1[(paramInt1 - 1)] = paramArrayOfByte;
        }
    }

    private int doOpcode96_147(int paramInt1, byte[] paramArrayOfByte, int paramInt2) {
        if (paramInt2 <= 131) {
            this.stackTop += javassist.bytecode.Opcode.STACK_GROW[paramInt2];
            return 1;
        }
        switch (paramInt2) {
            case 145:
            case 146:
            case 147:
            default:
                throw new RuntimeException("fatal");
            case 132:
                return 3;
            case 133:
                this.stackTypes[this.stackTop] = LONG;
                this.stackTypes[(this.stackTop - 1)] = TOP;
                this.stackTop += 1;
                return 1;
            case 134:
                this.stackTypes[(this.stackTop - 1)] = FLOAT;
                return 1;
            case 135:
                this.stackTypes[this.stackTop] = DOUBLE;
                this.stackTypes[(this.stackTop - 1)] = TOP;
                this.stackTop += 1;
                return 1;
            case 136:
                paramArrayOfByte = this.stackTypes;
                paramInt1 = this.stackTop - 1;
                this.stackTop = paramInt1;
                paramArrayOfByte[(paramInt1 - 1)] = INTEGER;
                return 1;
            case 137:
                paramArrayOfByte = this.stackTypes;
                paramInt1 = this.stackTop - 1;
                this.stackTop = paramInt1;
                paramArrayOfByte[(paramInt1 - 1)] = FLOAT;
                return 1;
            case 138:
                this.stackTypes[(this.stackTop - 1)] = DOUBLE;
                return 1;
            case 139:
                this.stackTypes[(this.stackTop - 1)] = INTEGER;
                return 1;
            case 140:
                this.stackTypes[(this.stackTop - 1)] = TOP;
                paramArrayOfByte = this.stackTypes;
                paramInt1 = this.stackTop;
                this.stackTop = (paramInt1 + 1);
                paramArrayOfByte[paramInt1] = LONG;
                return 1;
            case 141:
                this.stackTypes[(this.stackTop - 1)] = TOP;
                paramArrayOfByte = this.stackTypes;
                paramInt1 = this.stackTop;
                this.stackTop = (paramInt1 + 1);
                paramArrayOfByte[paramInt1] = DOUBLE;
                return 1;
            case 142:
                paramArrayOfByte = this.stackTypes;
                paramInt1 = this.stackTop - 1;
                this.stackTop = paramInt1;
                paramArrayOfByte[(paramInt1 - 1)] = INTEGER;
                return 1;
            case 143:
                this.stackTypes[(this.stackTop - 1)] = LONG;
                return 1;
        }
        paramArrayOfByte = this.stackTypes;
        paramInt1 = this.stackTop - 1;
        this.stackTop = paramInt1;
        paramArrayOfByte[(paramInt1 - 1)] = FLOAT;
        return 1;
    }

    private int doPutField(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean) {
        paramInt = ByteArray.readU16bit(paramArrayOfByte, paramInt + 1);
        paramArrayOfByte = this.cpool.getFieldrefType(paramInt);
        this.stackTop -= Descriptor.dataSize(paramArrayOfByte);
        int i = paramArrayOfByte.charAt(0);
        if (i == 76) {
            TypeData.setType(this.stackTypes[this.stackTop], getFieldClassName(paramArrayOfByte, 0), this.classPool);
        }
        for (; ; ) {
            setFieldTarget(paramBoolean, paramInt);
            return 3;
            if (i == 91) {
                TypeData.setType(this.stackTypes[this.stackTop], paramArrayOfByte, this.classPool);
            }
        }
    }

    private int doWIDE(int paramInt, byte[] paramArrayOfByte) {
        int i = paramArrayOfByte[(paramInt + 1)] & 0xFF;
        switch (i) {
            default:
                throw new RuntimeException("bad WIDE instruction: " + i);
            case 21:
                doWIDE_XLOAD(paramInt, paramArrayOfByte, INTEGER);
        }
        for (; ; ) {
            return 4;
            doWIDE_XLOAD(paramInt, paramArrayOfByte, LONG);
            continue;
            doWIDE_XLOAD(paramInt, paramArrayOfByte, FLOAT);
            continue;
            doWIDE_XLOAD(paramInt, paramArrayOfByte, DOUBLE);
            continue;
            doALOAD(ByteArray.readU16bit(paramArrayOfByte, paramInt + 2));
            continue;
            doWIDE_STORE(paramInt, paramArrayOfByte, INTEGER);
            continue;
            doWIDE_STORE(paramInt, paramArrayOfByte, LONG);
            continue;
            doWIDE_STORE(paramInt, paramArrayOfByte, FLOAT);
            continue;
            doWIDE_STORE(paramInt, paramArrayOfByte, DOUBLE);
            continue;
            doASTORE(ByteArray.readU16bit(paramArrayOfByte, paramInt + 2));
            continue;
            return 6;
            visitRET(paramInt, paramArrayOfByte);
        }
    }

    private void doWIDE_STORE(int paramInt, byte[] paramArrayOfByte, TypeData paramTypeData) {
        doXSTORE(ByteArray.readU16bit(paramArrayOfByte, paramInt + 2), paramTypeData);
    }

    private void doWIDE_XLOAD(int paramInt, byte[] paramArrayOfByte, TypeData paramTypeData) {
        doXLOAD(ByteArray.readU16bit(paramArrayOfByte, paramInt + 2), paramTypeData);
    }

    private int doXLOAD(int paramInt, TypeData paramTypeData) {
        TypeData[] arrayOfTypeData = this.stackTypes;
        paramInt = this.stackTop;
        this.stackTop = (paramInt + 1);
        arrayOfTypeData[paramInt] = paramTypeData;
        if (paramTypeData.is2WordType()) {
            paramTypeData = this.stackTypes;
            paramInt = this.stackTop;
            this.stackTop = (paramInt + 1);
            paramTypeData[paramInt] = TOP;
        }
        return 2;
    }

    private int doXLOAD(TypeData paramTypeData, byte[] paramArrayOfByte, int paramInt) {
        return doXLOAD(paramArrayOfByte[(paramInt + 1)] & 0xFF, paramTypeData);
    }

    private int doXSTORE(int paramInt, TypeData paramTypeData) {
        this.stackTop -= 1;
        this.localsTypes[paramInt] = paramTypeData;
        if (paramTypeData.is2WordType()) {
            this.stackTop -= 1;
            this.localsTypes[(paramInt + 1)] = TOP;
        }
        return 2;
    }

    private int doXSTORE(int paramInt, byte[] paramArrayOfByte, TypeData paramTypeData) {
        return doXSTORE(paramArrayOfByte[(paramInt + 1)] & 0xFF, paramTypeData);
    }

    private static String getFieldClassName(String paramString, int paramInt) {
        return paramString.substring(paramInt + 1, paramString.length() - 1).replace('/', '.');
    }

    private void pushMemberType(String paramString) {
        int i = 0;
        if (paramString.charAt(0) == '(') {
            j = paramString.indexOf(')') + 1;
            i = j;
            if (j < 1) {
                throw new IndexOutOfBoundsException("bad descriptor: " + paramString);
            }
        }
        TypeData[] arrayOfTypeData = this.stackTypes;
        int j = this.stackTop;
        switch (paramString.charAt(i)) {
            default:
                arrayOfTypeData[j] = INTEGER;
            case 'V':
            case '[':
            case 'L':
            case 'J':
            case 'F':
                for (; ; ) {
                    this.stackTop += 1;
                    return;
                    arrayOfTypeData[j] = new TypeData.ClassName(paramString.substring(i));
                    continue;
                    arrayOfTypeData[j] = new TypeData.ClassName(getFieldClassName(paramString, i));
                    continue;
                    arrayOfTypeData[j] = LONG;
                    arrayOfTypeData[(j + 1)] = TOP;
                    this.stackTop += 2;
                    return;
                    arrayOfTypeData[j] = FLOAT;
                }
        }
        arrayOfTypeData[j] = DOUBLE;
        arrayOfTypeData[(j + 1)] = TOP;
        this.stackTop += 2;
    }

    private void setFieldTarget(boolean paramBoolean, int paramInt) {
        if (paramBoolean) {
            String str = this.cpool.getFieldrefClassName(paramInt);
            TypeData[] arrayOfTypeData = this.stackTypes;
            paramInt = this.stackTop - 1;
            this.stackTop = paramInt;
            TypeData.setType(arrayOfTypeData[paramInt], str, this.classPool);
        }
    }

    protected int doOpcode(int paramInt, byte[] paramArrayOfByte) {
        int i = paramArrayOfByte[paramInt] & 0xFF;
        if ((i >= 96) || (i < 54)) {
        }
        try {
            return doOpcode0_53(paramInt, paramArrayOfByte, i);
        } catch (ArrayIndexOutOfBoundsException paramArrayOfByte) {
            throw new BadBytecode("inconsistent stack height " + paramArrayOfByte.getMessage());
        }
        return doOpcode54_95(paramInt, paramArrayOfByte, i);
        if (i < 148) {
            return doOpcode96_147(paramInt, paramArrayOfByte, i);
        }
        paramInt = doOpcode148_201(paramInt, paramArrayOfByte, i);
        return paramInt;
    }

    protected void visitBranch(int paramInt1, byte[] paramArrayOfByte, int paramInt2) {
    }

    protected void visitGoto(int paramInt1, byte[] paramArrayOfByte, int paramInt2) {
    }

    protected void visitJSR(int paramInt, byte[] paramArrayOfByte) {
    }

    protected void visitLookupSwitch(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4) {
    }

    protected void visitRET(int paramInt, byte[] paramArrayOfByte) {
    }

    protected void visitReturn(int paramInt, byte[] paramArrayOfByte) {
    }

    protected void visitTableSwitch(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4) {
    }

    protected void visitThrow(int paramInt, byte[] paramArrayOfByte) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/stackmap/Tracer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */