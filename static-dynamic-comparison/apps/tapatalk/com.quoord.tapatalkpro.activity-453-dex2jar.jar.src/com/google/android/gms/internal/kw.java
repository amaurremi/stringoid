package com.google.android.gms.internal;

import java.io.IOException;

public final class kw {
    public static final int[] aea = new int[0];
    public static final long[] aeb = new long[0];
    public static final float[] aec = new float[0];
    public static final double[] aed = new double[0];
    public static final boolean[] aee = new boolean[0];
    public static final String[] aef = new String[0];
    public static final byte[][] aeg = new byte[0][];
    public static final byte[] aeh = new byte[0];

    public static final int b(kn paramkn, int paramInt)
            throws IOException {
        int i = 1;
        int j = paramkn.getPosition();
        paramkn.cQ(paramInt);
        for (; ; ) {
            if ((paramkn.ms() <= 0) || (paramkn.mh() != paramInt)) {
                paramkn.cT(j);
                return i;
            }
            paramkn.cQ(paramInt);
            i += 1;
        }
    }

    static int de(int paramInt) {
        return paramInt & 0x7;
    }

    public static int df(int paramInt) {
        return paramInt >>> 3;
    }

    static int l(int paramInt1, int paramInt2) {
        return paramInt1 << 3 | paramInt2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/kw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */