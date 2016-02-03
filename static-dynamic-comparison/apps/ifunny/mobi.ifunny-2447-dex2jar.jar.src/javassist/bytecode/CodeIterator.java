package javassist.bytecode;

import java.util.ArrayList;

public class CodeIterator
        implements Opcode {
    private static final int[] opcodeLength = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 2, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 0, 0, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 5, 0, 3, 2, 3, 1, 1, 3, 3, 1, 1, 0, 4, 3, 3, 5, 5};
    protected byte[] bytecode;
    protected CodeAttribute codeAttr;
    protected int currentPos;
    protected int endPos;
    protected int mark;

    protected CodeIterator(CodeAttribute paramCodeAttribute) {
        this.codeAttr = paramCodeAttribute;
        this.bytecode = paramCodeAttribute.getCode();
        begin();
    }

    private static void addLdcW(CodeAttribute.LdcEntry paramLdcEntry, ArrayList paramArrayList) {
        int j = paramLdcEntry.where;
        paramLdcEntry = new CodeIterator.LdcW(j, paramLdcEntry.index);
        int k = paramArrayList.size();
        int i = 0;
        while (i < k) {
            if (j < ((CodeIterator.Branch) paramArrayList.get(i)).orgPos) {
                paramArrayList.add(i, paramLdcEntry);
                return;
            }
            i += 1;
        }
        paramArrayList.add(paramLdcEntry);
    }

    static byte[] changeLdcToLdcW(byte[] paramArrayOfByte, ExceptionTable paramExceptionTable, CodeAttribute paramCodeAttribute, CodeAttribute.LdcEntry paramLdcEntry) {
        ArrayList localArrayList = makeJumpList(paramArrayOfByte, paramArrayOfByte.length);
        while (paramLdcEntry != null) {
            addLdcW(paramLdcEntry, localArrayList);
            paramLdcEntry = paramLdcEntry.next;
        }
        return insertGap2w(paramArrayOfByte, 0, 0, false, localArrayList, new CodeIterator.Pointers(0, 0, 0, paramExceptionTable, paramCodeAttribute));
    }

    private static int copyGapBytes(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3) {
        int i = paramInt1;
        int j = paramInt2;
        int k = paramInt1;
        int m = paramInt2;
        int i1 = paramInt1;
        int n = paramInt2;
        switch (paramInt3 - paramInt2) {
            default:
                return paramInt1;
            case 4:
                paramArrayOfByte1[paramInt1] = paramArrayOfByte2[paramInt2];
                j = paramInt2 + 1;
                i = paramInt1 + 1;
            case 3:
                paramArrayOfByte1[i] = paramArrayOfByte2[j];
                m = j + 1;
                k = i + 1;
            case 2:
                paramArrayOfByte1[k] = paramArrayOfByte2[m];
                n = m + 1;
                i1 = k + 1;
        }
        paramArrayOfByte1[i1] = paramArrayOfByte2[n];
        return i1 + 1;
    }

    private int insert0(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean) {
        int m = paramArrayOfByte.length;
        int k;
        if (m <= 0) {
            k = paramInt;
            return k;
        }
        paramInt = insertGapAt(paramInt, m, paramBoolean).position;
        int j = 0;
        int i = paramInt;
        for (; ; ) {
            k = paramInt;
            if (j >= m) {
                break;
            }
            this.bytecode[i] = paramArrayOfByte[j];
            j += 1;
            i += 1;
        }
    }

    private static void insertGap2(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, boolean paramBoolean) {
        int i = 0;
        int j = 0;
        int k;
        int n;
        if (j < paramInt3) {
            k = i;
            if (j == paramInt1) {
                for (k = i; ; k = m + 1) {
                    m = k;
                    k = m;
                    if (m >= i + paramInt2) {
                        break;
                    }
                    paramArrayOfByte2[m] = 0;
                }
            }
            n = nextOpcode(paramArrayOfByte1, j);
            i = paramArrayOfByte1[j] & 0xFF;
            if (((153 <= i) && (i <= 168)) || (i == 198) || (i == 199)) {
                i = newOffset(j, paramArrayOfByte1[(j + 1)] << 8 | paramArrayOfByte1[(j + 2)] & 0xFF, paramInt1, paramInt2, paramBoolean);
                paramArrayOfByte2[k] = paramArrayOfByte1[j];
                ByteArray.write16bit(i, paramArrayOfByte2, k + 1);
            }
            for (i = k + 3; ; i = m + 4) {
                j = n;
                break;
                if ((i != 200) && (i != 201)) {
                    break label240;
                }
                i = newOffset(j, ByteArray.read32bit(paramArrayOfByte1, j + 1), paramInt1, paramInt2, paramBoolean);
                m = k + 1;
                paramArrayOfByte2[k] = paramArrayOfByte1[j];
                ByteArray.write32bit(i, paramArrayOfByte2, m);
            }
            label240:
            if (i == 170) {
                if ((j != k) && ((paramInt2 & 0x3) != 0)) {
                    throw new CodeIterator.AlignmentException();
                }
                i = (j & 0xFFFFFFFC) + 4;
                k = copyGapBytes(paramArrayOfByte2, k, paramArrayOfByte1, j, i);
                ByteArray.write32bit(newOffset(j, ByteArray.read32bit(paramArrayOfByte1, i), paramInt1, paramInt2, paramBoolean), paramArrayOfByte2, k);
                i2 = ByteArray.read32bit(paramArrayOfByte1, i + 4);
                ByteArray.write32bit(i2, paramArrayOfByte2, k + 4);
                int i3 = ByteArray.read32bit(paramArrayOfByte1, i + 8);
                ByteArray.write32bit(i3, paramArrayOfByte2, k + 8);
                i1 = i + 12;
                k += 12;
                m = i1;
                for (; ; ) {
                    i = k;
                    if (m >= i1 + (i3 - i2 + 1) * 4) {
                        break;
                    }
                    ByteArray.write32bit(newOffset(j, ByteArray.read32bit(paramArrayOfByte1, m), paramInt1, paramInt2, paramBoolean), paramArrayOfByte2, k);
                    m += 4;
                    k += 4;
                }
            }
            if (i != 171) {
                break label653;
            }
            if ((j != k) && ((paramInt2 & 0x3) != 0)) {
                throw new CodeIterator.AlignmentException();
            }
            i = (j & 0xFFFFFFFC) + 4;
            k = copyGapBytes(paramArrayOfByte2, k, paramArrayOfByte1, j, i);
            ByteArray.write32bit(newOffset(j, ByteArray.read32bit(paramArrayOfByte1, i), paramInt1, paramInt2, paramBoolean), paramArrayOfByte2, k);
            int i2 = ByteArray.read32bit(paramArrayOfByte1, i + 4);
            ByteArray.write32bit(i2, paramArrayOfByte2, k + 4);
            int i1 = i + 8;
            k += 8;
            int m = i1;
            for (; ; ) {
                i = k;
                if (m >= i1 + i2 * 8) {
                    break;
                }
                ByteArray.copy32bit(paramArrayOfByte1, m, paramArrayOfByte2, k);
                ByteArray.write32bit(newOffset(j, ByteArray.read32bit(paramArrayOfByte1, m + 4), paramInt1, paramInt2, paramBoolean), paramArrayOfByte2, k + 4);
                m += 8;
                k += 8;
            }
        }
        label653:
        for (; ; ) {
            i = k;
            if (j >= n) {
                break;
            }
            paramArrayOfByte2[k] = paramArrayOfByte1[j];
            k += 1;
            j += 1;
            continue;
            return;
        }
    }

    private static byte[] insertGap2w(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean, ArrayList paramArrayList, CodeIterator.Pointers paramPointers) {
        int m = paramArrayList.size();
        int i;
        if (paramInt2 > 0) {
            paramPointers.shiftPc(paramInt1, paramInt2, paramBoolean);
            i = 0;
            while (i < m) {
                ((CodeIterator.Branch) paramArrayList.get(i)).shift(paramInt1, paramInt2, paramBoolean);
                i += 1;
            }
        }
        int j = 1;
        int k;
        label68:
        CodeIterator.Branch localBranch;
        int n;
        while (j != 0) {
            k = 0;
            i = 0;
            j = i;
            if (k < m) {
                localBranch = (CodeIterator.Branch) paramArrayList.get(k);
                if (!localBranch.expanded()) {
                    break label297;
                }
                j = localBranch.pos;
                n = localBranch.deltaSize();
                paramPointers.shiftPc(j, n, false);
                i = 0;
                while (i < m) {
                    ((CodeIterator.Branch) paramArrayList.get(i)).shift(j, n, false);
                    i += 1;
                }
                i = 1;
            }
        }
        label179:
        label294:
        label297:
        for (; ; ) {
            k += 1;
            break label68;
            k = 0;
            i = j;
            if (k < m) {
                localBranch = (CodeIterator.Branch) paramArrayList.get(k);
                j = localBranch.gapChanged();
                if (j <= 0) {
                    break label294;
                }
                n = localBranch.pos;
                paramPointers.shiftPc(n, j, false);
                i = 0;
                while (i < m) {
                    ((CodeIterator.Branch) paramArrayList.get(i)).shift(n, j, false);
                    i += 1;
                }
                i = 1;
            }
            for (; ; ) {
                k += 1;
                break label179;
                j = i;
                if (i != 0) {
                    break;
                }
                return makeExapndedCode(paramArrayOfByte, paramArrayList, paramInt1, paramInt2);
            }
        }
    }

    static byte[] insertGapCore0(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean, ExceptionTable paramExceptionTable, CodeAttribute paramCodeAttribute) {
        if (paramInt2 <= 0) {
            return paramArrayOfByte;
        }
        try {
            byte[] arrayOfByte = insertGapCore1(paramArrayOfByte, paramInt1, paramInt2, paramBoolean, paramExceptionTable, paramCodeAttribute);
            return arrayOfByte;
        } catch (CodeIterator.AlignmentException localAlignmentException) {
            try {
                paramArrayOfByte = insertGapCore1(paramArrayOfByte, paramInt1, paramInt2 + 3 & 0xFFFFFFFC, paramBoolean, paramExceptionTable, paramCodeAttribute);
                return paramArrayOfByte;
            } catch (CodeIterator.AlignmentException paramArrayOfByte) {
                throw new RuntimeException("fatal error?");
            }
        }
    }

    private byte[] insertGapCore0w(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean, ExceptionTable paramExceptionTable, CodeAttribute paramCodeAttribute, CodeIterator.Gap paramGap) {
        if (paramInt2 <= 0) {
            return paramArrayOfByte;
        }
        ArrayList localArrayList = makeJumpList(paramArrayOfByte, paramArrayOfByte.length);
        paramExceptionTable = new CodeIterator.Pointers(this.currentPos, this.mark, paramInt1, paramExceptionTable, paramCodeAttribute);
        paramArrayOfByte = insertGap2w(paramArrayOfByte, paramInt1, paramInt2, paramBoolean, localArrayList, paramExceptionTable);
        this.currentPos = paramExceptionTable.cursor;
        this.mark = paramExceptionTable.mark;
        int i = paramExceptionTable.mark0;
        if ((i == this.currentPos) && (!paramBoolean)) {
            this.currentPos += paramInt2;
        }
        paramInt1 = i;
        if (paramBoolean) {
            paramInt1 = i - paramInt2;
        }
        paramGap.position = paramInt1;
        paramGap.length = paramInt2;
        return paramArrayOfByte;
    }

    private static byte[] insertGapCore1(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean, ExceptionTable paramExceptionTable, CodeAttribute paramCodeAttribute) {
        int i = paramArrayOfByte.length;
        byte[] arrayOfByte = new byte[i + paramInt2];
        insertGap2(paramArrayOfByte, paramInt1, paramInt2, i, arrayOfByte, paramBoolean);
        paramExceptionTable.shiftPc(paramInt1, paramInt2, paramBoolean);
        paramArrayOfByte = (LineNumberAttribute) paramCodeAttribute.getAttribute("LineNumberTable");
        if (paramArrayOfByte != null) {
            paramArrayOfByte.shiftPc(paramInt1, paramInt2, paramBoolean);
        }
        paramArrayOfByte = (LocalVariableAttribute) paramCodeAttribute.getAttribute("LocalVariableTable");
        if (paramArrayOfByte != null) {
            paramArrayOfByte.shiftPc(paramInt1, paramInt2, paramBoolean);
        }
        paramArrayOfByte = (LocalVariableAttribute) paramCodeAttribute.getAttribute("LocalVariableTypeTable");
        if (paramArrayOfByte != null) {
            paramArrayOfByte.shiftPc(paramInt1, paramInt2, paramBoolean);
        }
        paramArrayOfByte = (StackMapTable) paramCodeAttribute.getAttribute("StackMapTable");
        if (paramArrayOfByte != null) {
            paramArrayOfByte.shiftPc(paramInt1, paramInt2, paramBoolean);
        }
        paramArrayOfByte = (StackMap) paramCodeAttribute.getAttribute("StackMap");
        if (paramArrayOfByte != null) {
            paramArrayOfByte.shiftPc(paramInt1, paramInt2, paramBoolean);
        }
        return arrayOfByte;
    }

    private static byte[] makeExapndedCode(byte[] paramArrayOfByte, ArrayList paramArrayList, int paramInt1, int paramInt2) {
        int i3 = paramArrayList.size();
        int j = paramArrayOfByte.length + paramInt2;
        int i = 0;
        while (i < i3) {
            j += ((CodeIterator.Branch) paramArrayList.get(i)).deltaSize();
            i += 1;
        }
        byte[] arrayOfByte = new byte[j];
        int i1 = paramArrayOfByte.length;
        CodeIterator.Branch localBranch;
        int m;
        int k;
        if (i3 > 0) {
            localBranch = (CodeIterator.Branch) paramArrayList.get(0);
            m = localBranch.orgPos;
            j = 0;
            k = 0;
            i = 0;
        }
        while (j < i1) {
            int n = i;
            int i2;
            if (j == paramInt1) {
                for (n = i; ; n = i2 + 1) {
                    i2 = n;
                    n = i2;
                    if (i2 >= i + paramInt2) {
                        break;
                    }
                    arrayOfByte[i2] = 0;
                }
                j = 0;
                k = 0;
                m = i1;
                localBranch = null;
                i = 0;
            } else if (j != m) {
                arrayOfByte[n] = paramArrayOfByte[j];
                i = n + 1;
                j += 1;
            } else {
                i2 = localBranch.write(j, paramArrayOfByte, n, arrayOfByte);
                j += i2;
                int i4 = localBranch.deltaSize();
                k += 1;
                if (k < i3) {
                    localBranch = (CodeIterator.Branch) paramArrayList.get(k);
                }
                for (i = localBranch.orgPos; ; i = i1) {
                    m = i;
                    i = n + (i2 + i4);
                    break;
                    localBranch = null;
                }
            }
        }
        return arrayOfByte;
    }

    private static ArrayList makeJumpList(byte[] paramArrayOfByte, int paramInt) {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        if (i < paramInt) {
            int m = nextOpcode(paramArrayOfByte, i);
            int j = paramArrayOfByte[i] & 0xFF;
            int k;
            Object localObject;
            if (((153 <= j) && (j <= 168)) || (j == 198) || (j == 199)) {
                k = paramArrayOfByte[(i + 1)] << 8 | paramArrayOfByte[(i + 2)] & 0xFF;
                if ((j == 167) || (j == 168)) {
                    localObject = new CodeIterator.Jump16(i, k);
                    label105:
                    localArrayList.add(localObject);
                }
            }
            for (; ; ) {
                i = m;
                break;
                localObject = new CodeIterator.If16(i, k);
                break label105;
                if ((j == 200) || (j == 201)) {
                    localArrayList.add(new CodeIterator.Jump32(i, ByteArray.read32bit(paramArrayOfByte, i + 1)));
                } else {
                    int n;
                    int i1;
                    if (j == 170) {
                        j = (i & 0xFFFFFFFC) + 4;
                        n = ByteArray.read32bit(paramArrayOfByte, j);
                        i1 = ByteArray.read32bit(paramArrayOfByte, j + 4);
                        int i2 = ByteArray.read32bit(paramArrayOfByte, j + 8);
                        int i3 = i2 - i1 + 1;
                        localObject = new int[i3];
                        k = j + 12;
                        j = 0;
                        while (j < i3) {
                            localObject[j] = ByteArray.read32bit(paramArrayOfByte, k);
                            k += 4;
                            j += 1;
                        }
                        localArrayList.add(new CodeIterator.Table(i, n, i1, i2, (int[]) localObject));
                    } else if (j == 171) {
                        j = (i & 0xFFFFFFFC) + 4;
                        n = ByteArray.read32bit(paramArrayOfByte, j);
                        i1 = ByteArray.read32bit(paramArrayOfByte, j + 4);
                        localObject = new int[i1];
                        int[] arrayOfInt = new int[i1];
                        k = j + 8;
                        j = 0;
                        while (j < i1) {
                            localObject[j] = ByteArray.read32bit(paramArrayOfByte, k);
                            arrayOfInt[j] = ByteArray.read32bit(paramArrayOfByte, k + 4);
                            k += 8;
                            j += 1;
                        }
                        localArrayList.add(new CodeIterator.Lookup(i, n, (int[]) localObject, arrayOfInt));
                    }
                }
            }
        }
        return localArrayList;
    }

    private static int newOffset(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
        int i = paramInt1 + paramInt2;
        if (paramInt1 < paramInt3) {
            if (paramInt3 >= i) {
                paramInt1 = paramInt2;
                if (paramBoolean) {
                    paramInt1 = paramInt2;
                    if (paramInt3 != i) {
                    }
                }
            } else {
                paramInt1 = paramInt2 + paramInt4;
            }
        }
        do {
            do {
                do {
                    return paramInt1;
                    if (paramInt1 != paramInt3) {
                        break;
                    }
                    paramInt1 = paramInt2;
                } while (i >= paramInt3);
                return paramInt2 - paramInt4;
                if (i < paramInt3) {
                    break;
                }
                paramInt1 = paramInt2;
            } while (paramBoolean);
            paramInt1 = paramInt2;
        } while (paramInt3 != i);
        return paramInt2 - paramInt4;
    }

    static int nextOpcode(byte[] paramArrayOfByte, int paramInt) {
        int i = paramArrayOfByte[paramInt] & 0xFF;
        try {
            int j = opcodeLength[i];
            if (j > 0) {
                return paramInt + j;
            }
            if (i == 196) {
                if (paramArrayOfByte[(paramInt + 1)] != -124) {
                    break label118;
                }
                return paramInt + 6;
            }
            paramInt = (paramInt & 0xFFFFFFFC) + 8;
            if (i == 171) {
                return ByteArray.read32bit(paramArrayOfByte, paramInt) * 8 + paramInt + 4;
            }
            if (i == 170) {
                j = ByteArray.read32bit(paramArrayOfByte, paramInt);
                int k = ByteArray.read32bit(paramArrayOfByte, paramInt + 4);
                return (k - j + 1) * 4 + paramInt + 8;
            }
        } catch (IndexOutOfBoundsException paramArrayOfByte) {
        }
        throw new BadBytecode(i);
        label118:
        return paramInt + 4;
    }

    private int skipSuperConstructor0(int paramInt) {
        boolean bool1 = false;
        begin();
        ConstPool localConstPool = this.codeAttr.getConstPool();
        String str = this.codeAttr.getDeclaringClass();
        int i = 0;
        while (hasNext()) {
            int k = next();
            int j = byteAt(k);
            if (j == 187) {
                i += 1;
            } else if (j == 183) {
                int m = ByteArray.readU16bit(this.bytecode, k + 1);
                if (localConstPool.getMethodrefName(m).equals("<init>")) {
                    j = i - 1;
                    i = j;
                    if (j < 0) {
                        if (paramInt < 0) {
                            return k;
                        }
                        boolean bool2 = localConstPool.getMethodrefClassName(m).equals(str);
                        if (paramInt > 0) {
                            bool1 = true;
                        }
                        if (bool2 == bool1) {
                            return k;
                        }
                    }
                }
            }
        }
        begin();
        return -1;
    }

    public int append(byte[] paramArrayOfByte) {
        int j = getCodeLength();
        int k = paramArrayOfByte.length;
        if (k <= 0) {
        }
        for (; ; ) {
            return j;
            appendGap(k);
            byte[] arrayOfByte = this.bytecode;
            int i = 0;
            while (i < k) {
                arrayOfByte[(i + j)] = paramArrayOfByte[i];
                i += 1;
            }
        }
    }

    public void append(ExceptionTable paramExceptionTable, int paramInt) {
        ExceptionTable localExceptionTable = this.codeAttr.getExceptionTable();
        localExceptionTable.add(localExceptionTable.size(), paramExceptionTable, paramInt);
    }

    public void appendGap(int paramInt) {
        byte[] arrayOfByte1 = this.bytecode;
        int j = arrayOfByte1.length;
        byte[] arrayOfByte2 = new byte[j + paramInt];
        int i = 0;
        while (i < j) {
            arrayOfByte2[i] = arrayOfByte1[i];
            i += 1;
        }
        i = j;
        while (i < j + paramInt) {
            arrayOfByte2[i] = 0;
            i += 1;
        }
        this.codeAttr.setCode(arrayOfByte2);
        this.bytecode = arrayOfByte2;
        this.endPos = getCodeLength();
    }

    public void begin() {
        this.mark = 0;
        this.currentPos = 0;
        this.endPos = getCodeLength();
    }

    public int byteAt(int paramInt) {
        return this.bytecode[paramInt] & 0xFF;
    }

    public CodeAttribute get() {
        return this.codeAttr;
    }

    public int getCodeLength() {
        return this.bytecode.length;
    }

    public int getMark() {
        return this.mark;
    }

    public boolean hasNext() {
        return this.currentPos < this.endPos;
    }

    public int insert(byte[] paramArrayOfByte) {
        return insert0(this.currentPos, paramArrayOfByte, false);
    }

    public void insert(int paramInt, byte[] paramArrayOfByte) {
        insert0(paramInt, paramArrayOfByte, false);
    }

    public void insert(ExceptionTable paramExceptionTable, int paramInt) {
        this.codeAttr.getExceptionTable().add(0, paramExceptionTable, paramInt);
    }

    public int insertAt(int paramInt, byte[] paramArrayOfByte) {
        return insert0(paramInt, paramArrayOfByte, false);
    }

    public int insertEx(byte[] paramArrayOfByte) {
        return insert0(this.currentPos, paramArrayOfByte, true);
    }

    public void insertEx(int paramInt, byte[] paramArrayOfByte) {
        insert0(paramInt, paramArrayOfByte, true);
    }

    public int insertExAt(int paramInt, byte[] paramArrayOfByte) {
        return insert0(paramInt, paramArrayOfByte, true);
    }

    public int insertExGap(int paramInt) {
        return insertGapAt(this.currentPos, paramInt, true).position;
    }

    public int insertExGap(int paramInt1, int paramInt2) {
        return insertGapAt(paramInt1, paramInt2, true).length;
    }

    public int insertGap(int paramInt) {
        return insertGapAt(this.currentPos, paramInt, false).position;
    }

    public int insertGap(int paramInt1, int paramInt2) {
        return insertGapAt(paramInt1, paramInt2, false).length;
    }

    public CodeIterator.Gap insertGapAt(int paramInt1, int paramInt2, boolean paramBoolean) {
        CodeIterator.Gap localGap = new CodeIterator.Gap();
        if (paramInt2 <= 0) {
            localGap.position = paramInt1;
            localGap.length = 0;
            return localGap;
        }
        Object localObject;
        int i;
        if (this.bytecode.length + paramInt2 > 32767) {
            localObject = insertGapCore0w(this.bytecode, paramInt1, paramInt2, paramBoolean, get().getExceptionTable(), this.codeAttr, localGap);
            i = localGap.position;
        }
        for (; ; ) {
            this.codeAttr.setCode((byte[]) localObject);
            this.bytecode = ((byte[]) localObject);
            this.endPos = getCodeLength();
            updateCursors(i, paramInt2);
            return localGap;
            i = this.currentPos;
            byte[] arrayOfByte = insertGapCore0(this.bytecode, paramInt1, paramInt2, paramBoolean, get().getExceptionTable(), this.codeAttr);
            int j = arrayOfByte.length - this.bytecode.length;
            localGap.position = paramInt1;
            localGap.length = j;
            if (i >= paramInt1) {
                this.currentPos = (i + j);
            }
            if (this.mark <= paramInt1) {
                localObject = arrayOfByte;
                i = paramInt1;
                paramInt2 = j;
                if (this.mark == paramInt1) {
                    localObject = arrayOfByte;
                    i = paramInt1;
                    paramInt2 = j;
                    if (!paramBoolean) {
                    }
                }
            } else {
                this.mark += j;
                localObject = arrayOfByte;
                i = paramInt1;
                paramInt2 = j;
            }
        }
    }

    public int lookAhead() {
        return this.currentPos;
    }

    public void move(int paramInt) {
        this.currentPos = paramInt;
    }

    public int next() {
        int i = this.currentPos;
        this.currentPos = nextOpcode(this.bytecode, i);
        return i;
    }

    public int s16bitAt(int paramInt) {
        return ByteArray.readS16bit(this.bytecode, paramInt);
    }

    public int s32bitAt(int paramInt) {
        return ByteArray.read32bit(this.bytecode, paramInt);
    }

    public void setMark(int paramInt) {
        this.mark = paramInt;
    }

    public int skipConstructor() {
        return skipSuperConstructor0(-1);
    }

    public int skipSuperConstructor() {
        return skipSuperConstructor0(0);
    }

    public int skipThisConstructor() {
        return skipSuperConstructor0(1);
    }

    public int u16bitAt(int paramInt) {
        return ByteArray.readU16bit(this.bytecode, paramInt);
    }

    protected void updateCursors(int paramInt1, int paramInt2) {
    }

    public void write(byte[] paramArrayOfByte, int paramInt) {
        int j = paramArrayOfByte.length;
        int i = 0;
        while (i < j) {
            this.bytecode[paramInt] = paramArrayOfByte[i];
            i += 1;
            paramInt += 1;
        }
    }

    public void write16bit(int paramInt1, int paramInt2) {
        ByteArray.write16bit(paramInt1, this.bytecode, paramInt2);
    }

    public void write32bit(int paramInt1, int paramInt2) {
        ByteArray.write32bit(paramInt1, this.bytecode, paramInt2);
    }

    public void writeByte(int paramInt1, int paramInt2) {
        this.bytecode[paramInt2] = ((byte) paramInt1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/CodeIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */