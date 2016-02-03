package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;

public class LocalVariableAttribute
        extends AttributeInfo {
    public static final String tag = "LocalVariableTable";
    public static final String typeTag = "LocalVariableTypeTable";

    public LocalVariableAttribute(ConstPool paramConstPool) {
        super(paramConstPool, "LocalVariableTable", new byte[2]);
        ByteArray.write16bit(0, this.info, 0);
    }

    LocalVariableAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    public LocalVariableAttribute(ConstPool paramConstPool, String paramString) {
        super(paramConstPool, paramString, new byte[2]);
        ByteArray.write16bit(0, this.info, 0);
    }

    LocalVariableAttribute(ConstPool paramConstPool, String paramString, byte[] paramArrayOfByte) {
        super(paramConstPool, paramString, paramArrayOfByte);
    }

    public void addEntry(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        int j = this.info.length;
        byte[] arrayOfByte = new byte[j + 10];
        ByteArray.write16bit(tableLength() + 1, arrayOfByte, 0);
        int i = 2;
        while (i < j) {
            arrayOfByte[i] = this.info[i];
            i += 1;
        }
        ByteArray.write16bit(paramInt1, arrayOfByte, j);
        ByteArray.write16bit(paramInt2, arrayOfByte, j + 2);
        ByteArray.write16bit(paramInt3, arrayOfByte, j + 4);
        ByteArray.write16bit(paramInt4, arrayOfByte, j + 6);
        ByteArray.write16bit(paramInt5, arrayOfByte, j + 8);
        this.info = arrayOfByte;
    }

    public int codeLength(int paramInt) {
        return ByteArray.readU16bit(this.info, paramInt * 10 + 4);
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        byte[] arrayOfByte1 = get();
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
        ConstPool localConstPool = getConstPool();
        LocalVariableAttribute localLocalVariableAttribute = makeThisAttr(paramConstPool, arrayOfByte2);
        int i1 = ByteArray.readU16bit(arrayOfByte1, 0);
        ByteArray.write16bit(i1, arrayOfByte2, 0);
        int j = 0;
        int i = 2;
        int m;
        int i2;
        if (j < i1) {
            k = ByteArray.readU16bit(arrayOfByte1, i);
            int i3 = ByteArray.readU16bit(arrayOfByte1, i + 2);
            int n = ByteArray.readU16bit(arrayOfByte1, i + 4);
            m = ByteArray.readU16bit(arrayOfByte1, i + 6);
            i2 = ByteArray.readU16bit(arrayOfByte1, i + 8);
            ByteArray.write16bit(k, arrayOfByte2, i);
            ByteArray.write16bit(i3, arrayOfByte2, i + 2);
            k = n;
            if (n != 0) {
                k = localConstPool.copy(n, paramConstPool, null);
            }
            ByteArray.write16bit(k, arrayOfByte2, i + 4);
            if (m == 0) {
                break label215;
            }
        }
        label215:
        for (int k = paramConstPool.addUtf8Info(Descriptor.rename(localConstPool.getUtf8Info(m), paramMap)); ; k = m) {
            ByteArray.write16bit(k, arrayOfByte2, i + 6);
            ByteArray.write16bit(i2, arrayOfByte2, i + 8);
            j += 1;
            i += 10;
            break;
            return localLocalVariableAttribute;
        }
    }

    public String descriptor(int paramInt) {
        return getConstPool().getUtf8Info(descriptorIndex(paramInt));
    }

    public int descriptorIndex(int paramInt) {
        return ByteArray.readU16bit(this.info, paramInt * 10 + 8);
    }

    public int index(int paramInt) {
        return ByteArray.readU16bit(this.info, paramInt * 10 + 10);
    }

    LocalVariableAttribute makeThisAttr(ConstPool paramConstPool, byte[] paramArrayOfByte) {
        return new LocalVariableAttribute(paramConstPool, "LocalVariableTable", paramArrayOfByte);
    }

    public int nameIndex(int paramInt) {
        return ByteArray.readU16bit(this.info, paramInt * 10 + 6);
    }

    void renameClass(String paramString1, String paramString2) {
        ConstPool localConstPool = getConstPool();
        int j = tableLength();
        int i = 0;
        while (i < j) {
            int k = i * 10 + 2;
            int m = ByteArray.readU16bit(this.info, k + 6);
            if (m != 0) {
                ByteArray.write16bit(localConstPool.addUtf8Info(renameEntry(localConstPool.getUtf8Info(m), paramString1, paramString2)), this.info, k + 6);
            }
            i += 1;
        }
    }

    void renameClass(Map paramMap) {
        ConstPool localConstPool = getConstPool();
        int j = tableLength();
        int i = 0;
        while (i < j) {
            int k = i * 10 + 2;
            int m = ByteArray.readU16bit(this.info, k + 6);
            if (m != 0) {
                ByteArray.write16bit(localConstPool.addUtf8Info(renameEntry(localConstPool.getUtf8Info(m), paramMap)), this.info, k + 6);
            }
            i += 1;
        }
    }

    String renameEntry(String paramString1, String paramString2, String paramString3) {
        return Descriptor.rename(paramString1, paramString2, paramString3);
    }

    String renameEntry(String paramString, Map paramMap) {
        return Descriptor.rename(paramString, paramMap);
    }

    public void shiftIndex(int paramInt1, int paramInt2) {
        int j = this.info.length;
        int i = 2;
        while (i < j) {
            int k = ByteArray.readU16bit(this.info, i + 8);
            if (k >= paramInt1) {
                ByteArray.write16bit(k + paramInt2, this.info, i + 8);
            }
            i += 10;
        }
    }

    void shiftPc(int paramInt1, int paramInt2, boolean paramBoolean) {
        int j = tableLength();
        int i = 0;
        if (i < j) {
            int k = i * 10 + 2;
            int m = ByteArray.readU16bit(this.info, k);
            int n = ByteArray.readU16bit(this.info, k + 2);
            if ((m > paramInt1) || ((paramBoolean) && (m == paramInt1) && (m != 0))) {
                ByteArray.write16bit(m + paramInt2, this.info, k);
            }
            for (; ; ) {
                i += 1;
                break;
                if ((m + n > paramInt1) || ((paramBoolean) && (m + n == paramInt1))) {
                    ByteArray.write16bit(n + paramInt2, this.info, k + 2);
                }
            }
        }
    }

    public String signature(int paramInt) {
        return descriptor(paramInt);
    }

    public int signatureIndex(int paramInt) {
        return descriptorIndex(paramInt);
    }

    public int startPc(int paramInt) {
        return ByteArray.readU16bit(this.info, paramInt * 10 + 2);
    }

    public int tableLength() {
        return ByteArray.readU16bit(this.info, 0);
    }

    public String variableName(int paramInt) {
        return getConstPool().getUtf8Info(nameIndex(paramInt));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/LocalVariableAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */