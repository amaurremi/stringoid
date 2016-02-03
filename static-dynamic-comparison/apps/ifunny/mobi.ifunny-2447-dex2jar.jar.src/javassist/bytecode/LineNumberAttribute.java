package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;

public class LineNumberAttribute
        extends AttributeInfo {
    public static final String tag = "LineNumberTable";

    LineNumberAttribute(ConstPool paramConstPool, int paramInt, DataInputStream paramDataInputStream) {
        super(paramConstPool, paramInt, paramDataInputStream);
    }

    private LineNumberAttribute(ConstPool paramConstPool, byte[] paramArrayOfByte) {
        super(paramConstPool, "LineNumberTable", paramArrayOfByte);
    }

    public AttributeInfo copy(ConstPool paramConstPool, Map paramMap) {
        paramMap = this.info;
        int j = paramMap.length;
        byte[] arrayOfByte = new byte[j];
        int i = 0;
        while (i < j) {
            arrayOfByte[i] = paramMap[i];
            i += 1;
        }
        return new LineNumberAttribute(paramConstPool, arrayOfByte);
    }

    public int lineNumber(int paramInt) {
        return ByteArray.readU16bit(this.info, paramInt * 4 + 4);
    }

    void shiftPc(int paramInt1, int paramInt2, boolean paramBoolean) {
        int j = tableLength();
        int i = 0;
        while (i < j) {
            int k = i * 4 + 2;
            int m = ByteArray.readU16bit(this.info, k);
            if ((m > paramInt1) || ((paramBoolean) && (m == paramInt1))) {
                ByteArray.write16bit(m + paramInt2, this.info, k);
            }
            i += 1;
        }
    }

    public int startPc(int paramInt) {
        return ByteArray.readU16bit(this.info, paramInt * 4 + 2);
    }

    public int tableLength() {
        return ByteArray.readU16bit(this.info, 0);
    }

    public int toLineNumber(int paramInt) {
        int j = tableLength();
        int i = 0;
        while (i < j) {
            if (paramInt < startPc(i)) {
                if (i != 0) {
                    break;
                }
                return lineNumber(0);
            }
            i += 1;
        }
        return lineNumber(i - 1);
    }

    public LineNumberAttribute.Pc toNearPc(int paramInt) {
        int j = 0;
        int n = tableLength();
        int i;
        if (n > 0) {
            i = lineNumber(0) - paramInt;
            j = startPc(0);
        }
        for (; ; ) {
            int k = 1;
            int m = i;
            i = j;
            j = m;
            if (k < n) {
                m = lineNumber(k) - paramInt;
                if (((m >= 0) || (m <= j)) && ((m < 0) || ((m >= j) && (j >= 0)))) {
                    break label138;
                }
                j = startPc(k);
                i = m;
            }
            for (; ; ) {
                m = k + 1;
                k = j;
                j = i;
                i = k;
                k = m;
                break;
                LineNumberAttribute.Pc localPc = new LineNumberAttribute.Pc();
                localPc.index = i;
                localPc.line = (j + paramInt);
                return localPc;
                label138:
                m = i;
                i = j;
                j = m;
            }
            i = 0;
        }
    }

    public int toStartPc(int paramInt) {
        int j = tableLength();
        int i = 0;
        while (i < j) {
            if (paramInt == lineNumber(i)) {
                return startPc(i);
            }
            i += 1;
        }
        return -1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/LineNumberAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */