package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;

public class InnerClassesAttribute
        extends AttributeInfo {
    public static final String tag = "InnerClasses";

    public InnerClassesAttribute(ConstPool paramConstPool) {
        super(paramConstPool, "InnerClasses", new byte[2]);
        ByteArray.write16bit(0, get(), 0);
    }

    InnerClassesAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    private InnerClassesAttribute(ConstPool paramConstPool, byte[] paramArrayOfByte) {
        super(paramConstPool, "InnerClasses", paramArrayOfByte);
    }

    public int accessFlags(int paramInt) {
        return ByteArray.readU16bit(get(), paramInt * 8 + 8);
    }

    public void append(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        byte[] arrayOfByte1 = get();
        int j = arrayOfByte1.length;
        byte[] arrayOfByte2 = new byte[j + 8];
        int i = 2;
        while (i < j) {
            arrayOfByte2[i] = arrayOfByte1[i];
            i += 1;
        }
        ByteArray.write16bit(ByteArray.readU16bit(arrayOfByte1, 0) + 1, arrayOfByte2, 0);
        ByteArray.write16bit(paramInt1, arrayOfByte2, j);
        ByteArray.write16bit(paramInt2, arrayOfByte2, j + 2);
        ByteArray.write16bit(paramInt3, arrayOfByte2, j + 4);
        ByteArray.write16bit(paramInt4, arrayOfByte2, j + 6);
        set(arrayOfByte2);
    }

    public void append(String paramString1, String paramString2, String paramString3, int paramInt) {
        append(this.constPool.addClassInfo(paramString1), this.constPool.addClassInfo(paramString2), this.constPool.addUtf8Info(paramString3), paramInt);
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        byte[] arrayOfByte1 = get();
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
        ConstPool localConstPool = getConstPool();
        InnerClassesAttribute localInnerClassesAttribute = new InnerClassesAttribute(paramConstPool, arrayOfByte2);
        int i2 = ByteArray.readU16bit(arrayOfByte1, 0);
        ByteArray.write16bit(i2, arrayOfByte2, 0);
        int j = 0;
        int i = 2;
        int n;
        int m;
        int i3;
        if (j < i2) {
            int i1 = ByteArray.readU16bit(arrayOfByte1, i);
            n = ByteArray.readU16bit(arrayOfByte1, i + 2);
            m = ByteArray.readU16bit(arrayOfByte1, i + 4);
            i3 = ByteArray.readU16bit(arrayOfByte1, i + 6);
            k = i1;
            if (i1 != 0) {
                k = localConstPool.copy(i1, paramConstPool, paramMap);
            }
            ByteArray.write16bit(k, arrayOfByte2, i);
            if (n == 0) {
                break label213;
            }
        }
        label213:
        for (int k = localConstPool.copy(n, paramConstPool, paramMap); ; k = n) {
            ByteArray.write16bit(k, arrayOfByte2, i + 2);
            if (m != 0) {
            }
            for (k = localConstPool.copy(m, paramConstPool, paramMap); ; k = m) {
                ByteArray.write16bit(k, arrayOfByte2, i + 4);
                ByteArray.write16bit(i3, arrayOfByte2, i + 6);
                j += 1;
                i += 8;
                break;
                return localInnerClassesAttribute;
            }
        }
    }

    public String innerClass(int paramInt) {
        paramInt = innerClassIndex(paramInt);
        if (paramInt == 0) {
            return null;
        }
        return this.constPool.getClassInfo(paramInt);
    }

    public int innerClassIndex(int paramInt) {
        return ByteArray.readU16bit(get(), paramInt * 8 + 2);
    }

    public String innerName(int paramInt) {
        paramInt = innerNameIndex(paramInt);
        if (paramInt == 0) {
            return null;
        }
        return this.constPool.getUtf8Info(paramInt);
    }

    public int innerNameIndex(int paramInt) {
        return ByteArray.readU16bit(get(), paramInt * 8 + 6);
    }

    public String outerClass(int paramInt) {
        paramInt = outerClassIndex(paramInt);
        if (paramInt == 0) {
            return null;
        }
        return this.constPool.getClassInfo(paramInt);
    }

    public int outerClassIndex(int paramInt) {
        return ByteArray.readU16bit(get(), paramInt * 8 + 4);
    }

    public void setAccessFlags(int paramInt1, int paramInt2) {
        ByteArray.write16bit(paramInt2, get(), paramInt1 * 8 + 8);
    }

    public void setInnerClassIndex(int paramInt1, int paramInt2) {
        ByteArray.write16bit(paramInt2, get(), paramInt1 * 8 + 2);
    }

    public void setInnerNameIndex(int paramInt1, int paramInt2) {
        ByteArray.write16bit(paramInt2, get(), paramInt1 * 8 + 6);
    }

    public void setOuterClassIndex(int paramInt1, int paramInt2) {
        ByteArray.write16bit(paramInt2, get(), paramInt1 * 8 + 4);
    }

    public int tableLength() {
        return ByteArray.readU16bit(get(), 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/InnerClassesAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */