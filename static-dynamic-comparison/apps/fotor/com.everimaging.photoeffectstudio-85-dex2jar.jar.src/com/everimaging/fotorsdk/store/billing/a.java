package com.everimaging.fotorsdk.store.billing;

public class a {
    private static final byte[] b;
    private static final byte[] c;
    private static final byte[] d;
    private static final byte[] e;

    static {
        if (!a.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            a = bool;
            b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            c = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
            d = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
            e = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};
            return;
        }
    }

    private static int a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3) {
        if (paramArrayOfByte1[(paramInt1 + 2)] == 61) {
            paramArrayOfByte2[paramInt2] = ((byte) ((paramArrayOfByte3[paramArrayOfByte1[paramInt1]] << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 1)]] << 24 >>> 12) >>> 16));
            return 1;
        }
        if (paramArrayOfByte1[(paramInt1 + 3)] == 61) {
            paramInt1 = paramArrayOfByte3[paramArrayOfByte1[paramInt1]] << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 1)]] << 24 >>> 12 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 2)]] << 24 >>> 18;
            paramArrayOfByte2[paramInt2] = ((byte) (paramInt1 >>> 16));
            paramArrayOfByte2[(paramInt2 + 1)] = ((byte) (paramInt1 >>> 8));
            return 2;
        }
        paramInt1 = paramArrayOfByte3[paramArrayOfByte1[paramInt1]] << 24 >>> 6 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 1)]] << 24 >>> 12 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 2)]] << 24 >>> 18 | paramArrayOfByte3[paramArrayOfByte1[(paramInt1 + 3)]] << 24 >>> 24;
        paramArrayOfByte2[paramInt2] = ((byte) (paramInt1 >> 16));
        paramArrayOfByte2[(paramInt2 + 1)] = ((byte) (paramInt1 >> 8));
        paramArrayOfByte2[(paramInt2 + 2)] = ((byte) paramInt1);
        return 3;
    }

    public static byte[] a(String paramString)
            throws Base64DecoderException {
        paramString = paramString.getBytes();
        return a(paramString, 0, paramString.length);
    }

    public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
            throws Base64DecoderException {
        return a(paramArrayOfByte, paramInt1, paramInt2, d);
    }

    public static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
            throws Base64DecoderException {
        byte[] arrayOfByte1 = new byte[paramInt2 * 3 / 4 + 2];
        byte[] arrayOfByte2 = new byte[4];
        int m = 0;
        int k = 0;
        int j = 0;
        int n;
        if (m < paramInt2) {
            int i = (byte) (paramArrayOfByte1[(m + paramInt1)] & 0x7F);
            n = paramArrayOfByte2[i];
            if (n >= -5) {
                if (n < -1) {
                    break label401;
                }
                if (i == 61) {
                    n = paramInt2 - m;
                    paramInt1 = (byte) (paramArrayOfByte1[(paramInt2 - 1 + paramInt1)] & 0x7F);
                    if ((k == 0) || (k == 1)) {
                        throw new Base64DecoderException("invalid padding byte '=' at byte offset " + m);
                    }
                    if (((k == 3) && (n > 2)) || ((k == 4) && (n > 1))) {
                        throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset " + m);
                    }
                    if ((paramInt1 == 61) || (paramInt1 == 10)) {
                        break label310;
                    }
                    throw new Base64DecoderException("encoded value has invalid trailing byte");
                }
                n = k + 1;
                arrayOfByte2[k] = i;
                if (n != 4) {
                    break label390;
                }
                k = a(arrayOfByte2, 0, arrayOfByte1, j, paramArrayOfByte2) + j;
                j = 0;
            }
        }
        for (; ; ) {
            n = m + 1;
            m = k;
            k = j;
            j = m;
            m = n;
            break;
            throw new Base64DecoderException("Bad Base64 input character at " + m + ": " + paramArrayOfByte1[(m + paramInt1)] + "(decimal)");
            label310:
            paramInt1 = j;
            if (k != 0) {
                if (k == 1) {
                    throw new Base64DecoderException("single trailing character at offset " + (paramInt2 - 1));
                }
                arrayOfByte2[k] = 61;
                paramInt1 = j + a(arrayOfByte2, 0, arrayOfByte1, j, paramArrayOfByte2);
            }
            paramArrayOfByte1 = new byte[paramInt1];
            System.arraycopy(arrayOfByte1, 0, paramArrayOfByte1, 0, paramInt1);
            return paramArrayOfByte1;
            label390:
            k = j;
            j = n;
            continue;
            label401:
            n = j;
            j = k;
            k = n;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/billing/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */