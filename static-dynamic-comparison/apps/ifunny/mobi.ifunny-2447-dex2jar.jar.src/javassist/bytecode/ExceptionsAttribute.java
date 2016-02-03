package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;

public class ExceptionsAttribute
        extends AttributeInfo {
    public static final String tag = "Exceptions";

    public ExceptionsAttribute(ConstPool paramConstPool) {
        super(paramConstPool, "Exceptions");
        this.info = new byte[]{0, 0};
    }

    ExceptionsAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    private ExceptionsAttribute(ConstPool paramConstPool, ExceptionsAttribute paramExceptionsAttribute, Map paramMap) {
        super(paramConstPool, "Exceptions");
        copyFrom(paramExceptionsAttribute, paramMap);
    }

    private void copyFrom(ExceptionsAttribute paramExceptionsAttribute, Map paramMap) {
        ConstPool localConstPool1 = paramExceptionsAttribute.constPool;
        ConstPool localConstPool2 = this.constPool;
        paramExceptionsAttribute = paramExceptionsAttribute.info;
        int j = paramExceptionsAttribute.length;
        byte[] arrayOfByte = new byte[j];
        arrayOfByte[0] = paramExceptionsAttribute[0];
        arrayOfByte[1] = paramExceptionsAttribute[1];
        int i = 2;
        while (i < j) {
            ByteArray.write16bit(localConstPool1.copy(ByteArray.readU16bit(paramExceptionsAttribute, i), localConstPool2, paramMap), arrayOfByte, i);
            i += 2;
        }
        this.info = arrayOfByte;
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        return new ExceptionsAttribute(paramConstPool, this, paramMap);
    }

    public int getException(int paramInt) {
        paramInt = paramInt * 2 + 2;
        int i = this.info[paramInt];
        return this.info[(paramInt + 1)] & 0xFF | (i & 0xFF) << 8;
    }

    public int[] getExceptionIndexes() {
        int j = 2;
        byte[] arrayOfByte = this.info;
        int k = arrayOfByte.length;
        Object localObject;
        if (k <= 2) {
            localObject = null;
            return (int[]) localObject;
        }
        int[] arrayOfInt = new int[k / 2 - 1];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfInt;
            if (j >= k) {
                break;
            }
            arrayOfInt[i] = ((arrayOfByte[j] & 0xFF) << 8 | arrayOfByte[(j + 1)] & 0xFF);
            j += 2;
            i += 1;
        }
    }

    public String[] getExceptions() {
        int j = 2;
        byte[] arrayOfByte = this.info;
        int k = arrayOfByte.length;
        Object localObject;
        if (k <= 2) {
            localObject = null;
            return (String[]) localObject;
        }
        String[] arrayOfString = new String[k / 2 - 1];
        int i = 0;
        for (; ; ) {
            localObject = arrayOfString;
            if (j >= k) {
                break;
            }
            int m = arrayOfByte[j];
            int n = arrayOfByte[(j + 1)];
            arrayOfString[i] = this.constPool.getClassInfo(n & 0xFF | (m & 0xFF) << 8);
            j += 2;
            i += 1;
        }
    }

    public void setExceptionIndexes(int[] paramArrayOfInt) {
        int i = 0;
        int j = paramArrayOfInt.length;
        byte[] arrayOfByte = new byte[j * 2 + 2];
        ByteArray.write16bit(j, arrayOfByte, 0);
        while (i < j) {
            ByteArray.write16bit(paramArrayOfInt[i], arrayOfByte, i * 2 + 2);
            i += 1;
        }
        this.info = arrayOfByte;
    }

    public void setExceptions(String[] paramArrayOfString) {
        int i = 0;
        int j = paramArrayOfString.length;
        byte[] arrayOfByte = new byte[j * 2 + 2];
        ByteArray.write16bit(j, arrayOfByte, 0);
        while (i < j) {
            ByteArray.write16bit(this.constPool.addClassInfo(paramArrayOfString[i]), arrayOfByte, i * 2 + 2);
            i += 1;
        }
        this.info = arrayOfByte;
    }

    public int tableLength() {
        return this.info.length / 2 - 1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ExceptionsAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */