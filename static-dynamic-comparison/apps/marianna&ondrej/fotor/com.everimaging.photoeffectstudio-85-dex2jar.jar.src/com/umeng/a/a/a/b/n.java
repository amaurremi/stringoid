package com.umeng.a.a.a.b;

import com.umeng.a.a.a.c.a;
import com.umeng.a.a.a.c.d;
import com.umeng.a.a.a.d.c;

import java.util.BitSet;

public final class n
        extends b {
    public n(c paramc) {
        super(paramc);
    }

    public static BitSet a(byte[] paramArrayOfByte) {
        BitSet localBitSet = new BitSet();
        int i = 0;
        while (i < paramArrayOfByte.length * 8) {
            if ((paramArrayOfByte[(paramArrayOfByte.length - i / 8 - 1)] & 1 << i % 8) > 0) {
                localBitSet.set(i);
            }
            i += 1;
        }
        return localBitSet;
    }

    public static byte[] b(BitSet paramBitSet, int paramInt) {
        byte[] arrayOfByte = new byte[(int) Math.ceil(paramInt / 8.0D)];
        paramInt = 0;
        while (paramInt < paramBitSet.length()) {
            if (paramBitSet.get(paramInt)) {
                int i = arrayOfByte.length - paramInt / 8 - 1;
                arrayOfByte[i] = ((byte) (arrayOfByte[i] | 1 << paramInt % 8));
            }
            paramInt += 1;
        }
        return arrayOfByte;
    }

    public Class<? extends a> D() {
        return d.class;
    }

    public void a(BitSet paramBitSet, int paramInt)
            throws com.umeng.a.a.a.j {
        paramBitSet = b(paramBitSet, paramInt);
        int i = paramBitSet.length;
        paramInt = 0;
        while (paramInt < i) {
            a(paramBitSet[paramInt]);
            paramInt += 1;
        }
    }

    public BitSet b(int paramInt)
            throws com.umeng.a.a.a.j {
        int i = (int) Math.ceil(paramInt / 8.0D);
        byte[] arrayOfByte = new byte[i];
        paramInt = 0;
        while (paramInt < i) {
            arrayOfByte[paramInt] = u();
            paramInt += 1;
        }
        return a(arrayOfByte);
    }

    public static class a
            implements j {
        public h a(c paramc) {
            return new n(paramc);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */