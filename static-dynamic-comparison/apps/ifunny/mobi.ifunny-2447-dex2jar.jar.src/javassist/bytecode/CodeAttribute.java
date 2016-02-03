package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CodeAttribute
        extends AttributeInfo
        implements Opcode {
    public static final String tag = "Code";
    private ArrayList attributes;
    private ExceptionTable exceptions;
    private int maxLocals;
    private int maxStack;

    public CodeAttribute(ConstPool paramConstPool, int paramInt1, int paramInt2, byte[] paramArrayOfByte, ExceptionTable paramExceptionTable) {
        super(paramConstPool, "Code");
        this.maxStack = paramInt1;
        this.maxLocals = paramInt2;
        this.info = paramArrayOfByte;
        this.exceptions = paramExceptionTable;
        this.attributes = new ArrayList();
    }

    CodeAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, (byte[]) null);
        paramDataInputStream.readInt();
        this.maxStack = paramDataInputStream.readUnsignedShort();
        this.maxLocals = paramDataInputStream.readUnsignedShort();
        this.info = new byte[paramDataInputStream.readInt()];
        paramDataInputStream.readFully(this.info);
        this.exceptions = new ExceptionTable(paramConstPool, paramDataInputStream);
        this.attributes = new ArrayList();
        int i = paramDataInputStream.readUnsignedShort();
        paramInt = 0;
        while (paramInt < i) {
            this.attributes.add(AttributeInfo.read(paramConstPool, paramDataInputStream));
            paramInt += 1;
        }
    }

    private CodeAttribute(ConstPool paramConstPool, CodeAttribute paramCodeAttribute, Map paramMap) {
        super(paramConstPool, "Code");
        this.maxStack = paramCodeAttribute.getMaxStack();
        this.maxLocals = paramCodeAttribute.getMaxLocals();
        this.exceptions = paramCodeAttribute.getExceptionTable().copy(paramConstPool, paramMap);
        this.attributes = new ArrayList();
        List localList = paramCodeAttribute.getAttributes();
        int j = localList.size();
        int i = 0;
        while (i < j) {
            AttributeInfo localAttributeInfo = (AttributeInfo) localList.get(i);
            this.attributes.add(localAttributeInfo.copy(paramConstPool, paramMap));
            i += 1;
        }
        this.info = paramCodeAttribute.copyCode(paramConstPool, paramMap, this.exceptions, this);
    }

    private static CodeAttribute.LdcEntry copyCode(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, ConstPool paramConstPool1, byte[] paramArrayOfByte2, ConstPool paramConstPool2, Map paramMap) {
        Object localObject = null;
        int j;
        if (paramInt1 < paramInt2) {
            j = CodeIterator.nextOpcode(paramArrayOfByte1, paramInt1);
            int i = paramArrayOfByte1[paramInt1];
            paramArrayOfByte2[paramInt1] = i;
            switch (i & 0xFF) {
                default:
                    for (; ; ) {
                        paramInt1 += 1;
                        if (paramInt1 >= j) {
                            break;
                        }
                        paramArrayOfByte2[paramInt1] = paramArrayOfByte1[paramInt1];
                    }
                case 19:
                case 20:
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 187:
                case 189:
                case 192:
                case 193:
                    copyConstPoolInfo(paramInt1 + 1, paramArrayOfByte1, paramConstPool1, paramArrayOfByte2, paramConstPool2, paramMap);
            }
        }
        for (; ; ) {
            paramInt1 = j;
            break;
            int k = paramConstPool1.copy(paramArrayOfByte1[(paramInt1 + 1)] & 0xFF, paramConstPool2, paramMap);
            if (k < 256) {
                paramArrayOfByte2[(paramInt1 + 1)] = ((byte) k);
            } else {
                paramArrayOfByte2[paramInt1] = 0;
                paramArrayOfByte2[(paramInt1 + 1)] = 0;
                CodeAttribute.LdcEntry localLdcEntry = new CodeAttribute.LdcEntry();
                localLdcEntry.where = paramInt1;
                localLdcEntry.index = k;
                localLdcEntry.next = ((CodeAttribute.LdcEntry) localObject);
                localObject = localLdcEntry;
                continue;
                copyConstPoolInfo(paramInt1 + 1, paramArrayOfByte1, paramConstPool1, paramArrayOfByte2, paramConstPool2, paramMap);
                paramArrayOfByte2[(paramInt1 + 3)] = paramArrayOfByte1[(paramInt1 + 3)];
                paramArrayOfByte2[(paramInt1 + 4)] = paramArrayOfByte1[(paramInt1 + 4)];
                continue;
                copyConstPoolInfo(paramInt1 + 1, paramArrayOfByte1, paramConstPool1, paramArrayOfByte2, paramConstPool2, paramMap);
                paramArrayOfByte2[(paramInt1 + 3)] = paramArrayOfByte1[(paramInt1 + 3)];
                continue;
                return (CodeAttribute.LdcEntry) localObject;
            }
        }
    }

    private byte[] copyCode(ConstPool paramConstPool, Map paramMap, ExceptionTable paramExceptionTable, CodeAttribute paramCodeAttribute) {
        int i = getCodeLength();
        byte[] arrayOfByte = new byte[i];
        paramCodeAttribute.info = arrayOfByte;
        return CodeAttribute.LdcEntry.doit(arrayOfByte, copyCode(this.info, 0, i, getConstPool(), arrayOfByte, paramConstPool, paramMap), paramExceptionTable, paramCodeAttribute);
    }

    private static void copyConstPoolInfo(int paramInt, byte[] paramArrayOfByte1, ConstPool paramConstPool1, byte[] paramArrayOfByte2, ConstPool paramConstPool2, Map paramMap) {
        int i = paramConstPool1.copy((paramArrayOfByte1[paramInt] & 0xFF) << 8 | paramArrayOfByte1[(paramInt + 1)] & 0xFF, paramConstPool2, paramMap);
        paramArrayOfByte2[paramInt] = ((byte) (i >> 8));
        paramArrayOfByte2[(paramInt + 1)] = ((byte) i);
    }

    private static void shiftIndex(CodeIterator paramCodeIterator, int paramInt1, int paramInt2) {
        int i = paramCodeIterator.next();
        int j = paramCodeIterator.byteAt(i);
        if (j < 21) {
        }
        do {
            do {
                do {
                    do {
                        return;
                        if (j >= 79) {
                            break;
                        }
                        if (j < 26) {
                            shiftIndex8(paramCodeIterator, i, j, paramInt1, paramInt2);
                            return;
                        }
                        if (j < 46) {
                            shiftIndex0(paramCodeIterator, i, j, paramInt1, paramInt2, 26, 21);
                            return;
                        }
                    } while (j < 54);
                    if (j < 59) {
                        shiftIndex8(paramCodeIterator, i, j, paramInt1, paramInt2);
                        return;
                    }
                    shiftIndex0(paramCodeIterator, i, j, paramInt1, paramInt2, 59, 54);
                    return;
                    if (j != 132) {
                        break;
                    }
                    j = paramCodeIterator.byteAt(i + 1);
                } while (j < paramInt1);
                paramInt1 = j + paramInt2;
                if (paramInt1 < 256) {
                    paramCodeIterator.writeByte(paramInt1, i + 1);
                    return;
                }
                paramInt2 = (byte) paramCodeIterator.byteAt(i + 2);
                i = paramCodeIterator.insertExGap(3);
                paramCodeIterator.writeByte(196, i - 3);
                paramCodeIterator.writeByte(132, i - 2);
                paramCodeIterator.write16bit(paramInt1, i - 1);
                paramCodeIterator.write16bit(paramInt2, i + 1);
                return;
                if (j == 169) {
                    shiftIndex8(paramCodeIterator, i, j, paramInt1, paramInt2);
                    return;
                }
            } while (j != 196);
            j = paramCodeIterator.u16bitAt(i + 2);
        } while (j < paramInt1);
        paramCodeIterator.write16bit(j + paramInt2, i + 2);
    }

    private static void shiftIndex0(CodeIterator paramCodeIterator, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
        int i = (paramInt2 - paramInt5) % 4;
        if (i < paramInt3) {
            return;
        }
        paramInt3 = i + paramInt4;
        if (paramInt3 < 4) {
            paramCodeIterator.writeByte(paramInt2 + paramInt4, paramInt1);
            return;
        }
        paramInt1 = (paramInt2 - paramInt5) / 4 + paramInt6;
        if (paramInt3 < 256) {
            paramInt2 = paramCodeIterator.insertExGap(1);
            paramCodeIterator.writeByte(paramInt1, paramInt2 - 1);
            paramCodeIterator.writeByte(paramInt3, paramInt2);
            return;
        }
        paramInt2 = paramCodeIterator.insertExGap(3);
        paramCodeIterator.writeByte(196, paramInt2 - 1);
        paramCodeIterator.writeByte(paramInt1, paramInt2);
        paramCodeIterator.write16bit(paramInt3, paramInt2 + 1);
    }

    private static void shiftIndex8(CodeIterator paramCodeIterator, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = paramCodeIterator.byteAt(paramInt1 + 1);
        if (i < paramInt3) {
            return;
        }
        paramInt3 = i + paramInt4;
        if (paramInt3 < 256) {
            paramCodeIterator.writeByte(paramInt3, paramInt1 + 1);
            return;
        }
        paramInt1 = paramCodeIterator.insertExGap(2);
        paramCodeIterator.writeByte(196, paramInt1 - 2);
        paramCodeIterator.writeByte(paramInt2, paramInt1 - 1);
        paramCodeIterator.write16bit(paramInt3, paramInt1);
    }

    public int computeMaxStack() {
        this.maxStack = new CodeAnalyzer(this).computeMaxStack();
        return this.maxStack;
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        try {
            paramConstPool = new CodeAttribute(paramConstPool, this, paramMap);
            return paramConstPool;
        } catch (BadBytecode paramConstPool) {
            throw new CodeAttribute.RuntimeCopyException("bad bytecode. fatal?");
        }
    }

    public byte[] get() {
        throw new UnsupportedOperationException("CodeAttribute.get()");
    }

    public AttributeInfo getAttribute(String paramString) {
        return AttributeInfo.lookup(this.attributes, paramString);
    }

    public List getAttributes() {
        return this.attributes;
    }

    public byte[] getCode() {
        return this.info;
    }

    public int getCodeLength() {
        return this.info.length;
    }

    public String getDeclaringClass() {
        return getConstPool().getClassName();
    }

    public ExceptionTable getExceptionTable() {
        return this.exceptions;
    }

    public int getMaxLocals() {
        return this.maxLocals;
    }

    public int getMaxStack() {
        return this.maxStack;
    }

    void getRefClasses(Map paramMap) {
        AttributeInfo.getRefClasses(this.attributes, paramMap);
    }

    public void insertLocalVar(int paramInt1, int paramInt2) {
        CodeIterator localCodeIterator = iterator();
        while (localCodeIterator.hasNext()) {
            shiftIndex(localCodeIterator, paramInt1, paramInt2);
        }
        setMaxLocals(getMaxLocals() + paramInt2);
    }

    public CodeIterator iterator() {
        return new CodeIterator(this);
    }

    public int length() {
        return this.info.length + 18 + this.exceptions.size() * 8 + AttributeInfo.getLength(this.attributes);
    }

    void renameClass(String paramString1, String paramString2) {
        AttributeInfo.renameClass(this.attributes, paramString1, paramString2);
    }

    void renameClass(Map paramMap) {
        AttributeInfo.renameClass(this.attributes, paramMap);
    }

    public void set(byte[] paramArrayOfByte) {
        throw new UnsupportedOperationException("CodeAttribute.set()");
    }

    public void setAttribute(StackMap paramStackMap) {
        AttributeInfo.remove(this.attributes, "StackMap");
        if (paramStackMap != null) {
            this.attributes.add(paramStackMap);
        }
    }

    public void setAttribute(StackMapTable paramStackMapTable) {
        AttributeInfo.remove(this.attributes, "StackMapTable");
        if (paramStackMapTable != null) {
            this.attributes.add(paramStackMapTable);
        }
    }

    void setCode(byte[] paramArrayOfByte) {
        super.set(paramArrayOfByte);
    }

    public void setMaxLocals(int paramInt) {
        this.maxLocals = paramInt;
    }

    public void setMaxStack(int paramInt) {
        this.maxStack = paramInt;
    }

    void write(DataOutputStream paramDataOutputStream) {
        paramDataOutputStream.writeShort(this.name);
        paramDataOutputStream.writeInt(length() - 6);
        paramDataOutputStream.writeShort(this.maxStack);
        paramDataOutputStream.writeShort(this.maxLocals);
        paramDataOutputStream.writeInt(this.info.length);
        paramDataOutputStream.write(this.info);
        this.exceptions.write(paramDataOutputStream);
        paramDataOutputStream.writeShort(this.attributes.size());
        AttributeInfo.writeAll(this.attributes, paramDataOutputStream);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */