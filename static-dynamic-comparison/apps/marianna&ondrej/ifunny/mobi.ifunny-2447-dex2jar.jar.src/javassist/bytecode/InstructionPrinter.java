package javassist.bytecode;

import java.io.PrintStream;

import javassist.CtMethod;

public class InstructionPrinter
        implements Opcode {
    private static final String[] opcodes = Mnemonic.OPCODE;
    private final PrintStream stream;

    public InstructionPrinter(PrintStream paramPrintStream) {
        this.stream = paramPrintStream;
    }

    private static String arrayInfo(int paramInt) {
        switch (paramInt) {
            default:
                throw new RuntimeException("Invalid array type");
            case 4:
                return "boolean";
            case 5:
                return "char";
            case 8:
                return "byte";
            case 9:
                return "short";
            case 10:
                return "int";
            case 11:
                return "long";
            case 6:
                return "float";
        }
        return "double";
    }

    private static String classInfo(ConstPool paramConstPool, int paramInt) {
        return "#" + paramInt + " = Class " + paramConstPool.getClassInfo(paramInt);
    }

    private static String fieldInfo(ConstPool paramConstPool, int paramInt) {
        return "#" + paramInt + " = Field " + paramConstPool.getFieldrefClassName(paramInt) + "." + paramConstPool.getFieldrefName(paramInt) + "(" + paramConstPool.getFieldrefType(paramInt) + ")";
    }

    public static String instructionString(CodeIterator paramCodeIterator, int paramInt, ConstPool paramConstPool) {
        int i = paramCodeIterator.byteAt(paramInt);
        if ((i > opcodes.length) || (i < 0)) {
            throw new IllegalArgumentException("Invalid opcode, opcode: " + i + " pos: " + paramInt);
        }
        String str = opcodes[i];
        switch (i) {
            default:
                return str;
            case 16:
                return str + " " + paramCodeIterator.byteAt(paramInt + 1);
            case 17:
                return str + " " + paramCodeIterator.s16bitAt(paramInt + 1);
            case 18:
                return str + " " + ldc(paramConstPool, paramCodeIterator.byteAt(paramInt + 1));
            case 19:
            case 20:
                return str + " " + ldc(paramConstPool, paramCodeIterator.u16bitAt(paramInt + 1));
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
                return str + " " + paramCodeIterator.byteAt(paramInt + 1);
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
            case 198:
            case 199:
                return str + " " + (paramCodeIterator.s16bitAt(paramInt + 1) + paramInt);
            case 132:
                return str + " " + paramCodeIterator.byteAt(paramInt + 1);
            case 167:
            case 168:
                return str + " " + (paramCodeIterator.s16bitAt(paramInt + 1) + paramInt);
            case 169:
                return str + " " + paramCodeIterator.byteAt(paramInt + 1);
            case 170:
                return tableSwitch(paramCodeIterator, paramInt);
            case 171:
                return lookupSwitch(paramCodeIterator, paramInt);
            case 178:
            case 179:
            case 180:
            case 181:
                return str + " " + fieldInfo(paramConstPool, paramCodeIterator.u16bitAt(paramInt + 1));
            case 182:
            case 183:
            case 184:
                return str + " " + methodInfo(paramConstPool, paramCodeIterator.u16bitAt(paramInt + 1));
            case 185:
                return str + " " + interfaceMethodInfo(paramConstPool, paramCodeIterator.u16bitAt(paramInt + 1));
            case 186:
                throw new RuntimeException("Bad opcode 186");
            case 187:
                return str + " " + classInfo(paramConstPool, paramCodeIterator.u16bitAt(paramInt + 1));
            case 188:
                return str + " " + arrayInfo(paramCodeIterator.byteAt(paramInt + 1));
            case 189:
            case 192:
                return str + " " + classInfo(paramConstPool, paramCodeIterator.u16bitAt(paramInt + 1));
            case 196:
                return wide(paramCodeIterator, paramInt);
            case 197:
                return str + " " + classInfo(paramConstPool, paramCodeIterator.u16bitAt(paramInt + 1));
        }
        return str + " " + (paramCodeIterator.s32bitAt(paramInt + 1) + paramInt);
    }

    private static String interfaceMethodInfo(ConstPool paramConstPool, int paramInt) {
        return "#" + paramInt + " = Method " + paramConstPool.getInterfaceMethodrefClassName(paramInt) + "." + paramConstPool.getInterfaceMethodrefName(paramInt) + "(" + paramConstPool.getInterfaceMethodrefType(paramInt) + ")";
    }

    private static String ldc(ConstPool paramConstPool, int paramInt) {
        int i = paramConstPool.getTag(paramInt);
        switch (i) {
            default:
                throw new RuntimeException("bad LDC: " + i);
            case 8:
                return "#" + paramInt + " = \"" + paramConstPool.getStringInfo(paramInt) + "\"";
            case 3:
                return "#" + paramInt + " = int " + paramConstPool.getIntegerInfo(paramInt);
            case 4:
                return "#" + paramInt + " = float " + paramConstPool.getFloatInfo(paramInt);
            case 5:
                return "#" + paramInt + " = long " + paramConstPool.getLongInfo(paramInt);
            case 6:
                return "#" + paramInt + " = int " + paramConstPool.getDoubleInfo(paramInt);
        }
        return classInfo(paramConstPool, paramInt);
    }

    private static String lookupSwitch(CodeIterator paramCodeIterator, int paramInt) {
        StringBuffer localStringBuffer = new StringBuffer("lookupswitch {\n");
        int i = (paramInt & 0xFFFFFFFC) + 4;
        localStringBuffer.append("\t\tdefault: ").append(paramCodeIterator.s32bitAt(i) + paramInt).append("\n");
        i += 4;
        int k = paramCodeIterator.s32bitAt(i);
        int j = i + 4;
        i = j;
        while (i < k * 8 + j) {
            int m = paramCodeIterator.s32bitAt(i);
            int n = paramCodeIterator.s32bitAt(i + 4);
            localStringBuffer.append("\t\t").append(m).append(": ").append(n + paramInt).append("\n");
            i += 8;
        }
        localStringBuffer.setCharAt(localStringBuffer.length() - 1, '}');
        return localStringBuffer.toString();
    }

    private static String methodInfo(ConstPool paramConstPool, int paramInt) {
        return "#" + paramInt + " = Method " + paramConstPool.getMethodrefClassName(paramInt) + "." + paramConstPool.getMethodrefName(paramInt) + "(" + paramConstPool.getMethodrefType(paramInt) + ")";
    }

    public static void print(CtMethod paramCtMethod, PrintStream paramPrintStream) {
        new InstructionPrinter(paramPrintStream).print(paramCtMethod);
    }

    private static String tableSwitch(CodeIterator paramCodeIterator, int paramInt) {
        StringBuffer localStringBuffer = new StringBuffer("tableswitch {\n");
        int i = (paramInt & 0xFFFFFFFC) + 4;
        localStringBuffer.append("\t\tdefault: ").append(paramCodeIterator.s32bitAt(i) + paramInt).append("\n");
        i += 4;
        int k = paramCodeIterator.s32bitAt(i);
        i += 4;
        int n = paramCodeIterator.s32bitAt(i);
        int m = i + 4;
        int j = m;
        i = k;
        while (j < (n - k + 1) * 4 + m) {
            int i1 = paramCodeIterator.s32bitAt(j);
            localStringBuffer.append("\t\t").append(i).append(": ").append(i1 + paramInt).append("\n");
            j += 4;
            i += 1;
        }
        localStringBuffer.setCharAt(localStringBuffer.length() - 1, '}');
        return localStringBuffer.toString();
    }

    private static String wide(CodeIterator paramCodeIterator, int paramInt) {
        int i = paramCodeIterator.byteAt(paramInt + 1);
        paramInt = paramCodeIterator.u16bitAt(paramInt + 2);
        switch (i) {
            default:
                throw new RuntimeException("Invalid WIDE operand");
        }
        return opcodes[i] + " " + paramInt;
    }

    public void print(CtMethod paramCtMethod) {
        Object localObject = paramCtMethod.getMethodInfo2();
        paramCtMethod = ((MethodInfo) localObject).getConstPool();
        localObject = ((MethodInfo) localObject).getCodeAttribute();
        if (localObject == null) {
            return;
        }
        localObject = ((CodeAttribute) localObject).iterator();
        while (((CodeIterator) localObject).hasNext()) {
            try {
                int i = ((CodeIterator) localObject).next();
                this.stream.println(i + ": " + instructionString((CodeIterator) localObject, i, paramCtMethod));
            } catch (BadBytecode paramCtMethod) {
                throw new RuntimeException(paramCtMethod);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/InstructionPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */