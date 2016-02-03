package javassist.bytecode;

public class StackMapTable$Walker {
    byte[] info;
    int numOfEntries;

    public StackMapTable$Walker(StackMapTable paramStackMapTable) {
        this(paramStackMapTable.get());
    }

    public StackMapTable$Walker(byte[] paramArrayOfByte) {
        this.info = paramArrayOfByte;
        this.numOfEntries = ByteArray.readU16bit(paramArrayOfByte, 0);
    }

    private int appendFrame(int paramInt1, int paramInt2) {
        int j = paramInt2 - 251;
        int k = ByteArray.readU16bit(this.info, paramInt1 + 1);
        int[] arrayOfInt1 = new int[j];
        int[] arrayOfInt2 = new int[j];
        paramInt2 = paramInt1 + 3;
        int i = 0;
        if (i < j) {
            int m = this.info[paramInt2] & 0xFF;
            arrayOfInt1[i] = m;
            if ((m == 7) || (m == 8)) {
                arrayOfInt2[i] = ByteArray.readU16bit(this.info, paramInt2 + 1);
                paramInt2 += 3;
            }
            for (; ; ) {
                i += 1;
                break;
                arrayOfInt2[i] = 0;
                paramInt2 += 1;
            }
        }
        appendFrame(paramInt1, k, arrayOfInt1, arrayOfInt2);
        return paramInt2;
    }

    private int fullFrame(int paramInt) {
        int i = ByteArray.readU16bit(this.info, paramInt + 1);
        int j = ByteArray.readU16bit(this.info, paramInt + 3);
        int[] arrayOfInt1 = new int[j];
        int[] arrayOfInt2 = new int[j];
        j = verifyTypeInfo(paramInt + 5, j, arrayOfInt1, arrayOfInt2);
        int k = ByteArray.readU16bit(this.info, j);
        int[] arrayOfInt3 = new int[k];
        int[] arrayOfInt4 = new int[k];
        j = verifyTypeInfo(j + 2, k, arrayOfInt3, arrayOfInt4);
        fullFrame(paramInt, i, arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4);
        return j;
    }

    private int sameLocals(int paramInt1, int paramInt2) {
        int i;
        int m;
        int j;
        if (paramInt2 < 128) {
            i = paramInt2 - 64;
            paramInt2 = paramInt1;
            m = this.info[(paramInt2 + 1)] & 0xFF;
            if ((m != 7) && (m != 8)) {
                break label98;
            }
            j = ByteArray.readU16bit(this.info, paramInt2 + 2);
            int k = paramInt2 + 2;
            paramInt2 = j;
            j = k;
        }
        for (; ; ) {
            sameLocals(paramInt1, i, m, paramInt2);
            return j + 2;
            i = ByteArray.readU16bit(this.info, paramInt1 + 1);
            paramInt2 = paramInt1 + 2;
            break;
            label98:
            j = paramInt2;
            paramInt2 = 0;
        }
    }

    private int verifyTypeInfo(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
        int i = 0;
        while (i < paramInt2) {
            byte[] arrayOfByte = this.info;
            int j = paramInt1 + 1;
            int k = arrayOfByte[paramInt1] & 0xFF;
            paramArrayOfInt1[i] = k;
            if (k != 7) {
                paramInt1 = j;
                if (k != 8) {
                }
            } else {
                paramArrayOfInt2[i] = ByteArray.readU16bit(this.info, j);
                paramInt1 = j + 2;
            }
            i += 1;
        }
        return paramInt1;
    }

    public void appendFrame(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
    }

    public void chopFrame(int paramInt1, int paramInt2, int paramInt3) {
    }

    public void fullFrame(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4) {
    }

    public void parse() {
        int k = this.numOfEntries;
        int j = 2;
        int i = 0;
        while (i < k) {
            j = stackMapFrames(j, i);
            i += 1;
        }
    }

    public void sameFrame(int paramInt1, int paramInt2) {
    }

    public void sameLocals(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    }

    public final int size() {
        return this.numOfEntries;
    }

    int stackMapFrames(int paramInt1, int paramInt2) {
        paramInt2 = this.info[paramInt1] & 0xFF;
        if (paramInt2 < 64) {
            sameFrame(paramInt1, paramInt2);
            return paramInt1 + 1;
        }
        if (paramInt2 < 128) {
            return sameLocals(paramInt1, paramInt2);
        }
        if (paramInt2 < 247) {
            throw new BadBytecode("bad frame_type in StackMapTable");
        }
        if (paramInt2 == 247) {
            return sameLocals(paramInt1, paramInt2);
        }
        if (paramInt2 < 251) {
            chopFrame(paramInt1, ByteArray.readU16bit(this.info, paramInt1 + 1), 251 - paramInt2);
            return paramInt1 + 3;
        }
        if (paramInt2 == 251) {
            sameFrame(paramInt1, ByteArray.readU16bit(this.info, paramInt1 + 1));
            return paramInt1 + 3;
        }
        if (paramInt2 < 255) {
            return appendFrame(paramInt1, paramInt2);
        }
        return fullFrame(paramInt1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/StackMapTable$Walker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */