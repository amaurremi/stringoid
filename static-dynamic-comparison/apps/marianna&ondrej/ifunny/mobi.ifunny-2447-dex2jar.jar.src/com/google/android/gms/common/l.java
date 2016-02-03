package com.google.android.gms.common;

import java.util.Comparator;

final class l
        implements Comparator<byte[]> {
    public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        int j = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
        int i = 0;
        while (i < j) {
            int k = paramArrayOfByte1[i] & 0xFF;
            int m = paramArrayOfByte2[i] & 0xFF;
            if (k != m) {
                return k - m;
            }
            i += 1;
        }
        return paramArrayOfByte1.length - paramArrayOfByte2.length;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */