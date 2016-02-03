package com.quoord.tapatalkpro.util;

import java.util.Arrays;

public class Base64 {
    private static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final int[] IA = new int['Ā'];

    static {
        Arrays.fill(IA, -1);
        int i = 0;
        int j = CA.length;
        for (; ; ) {
            if (i >= j) {
                IA[61] = 0;
                return;
            }
            IA[CA[i]] = i;
            i += 1;
        }
    }

    public static final byte[] decode(String paramString) {
        if (paramString != null) {
        }
        Object localObject;
        for (int i = paramString.length(); i == 0; i = 0) {
            localObject = new byte[0];
            return (byte[]) localObject;
        }
        int j = 0;
        int k = 0;
        for (; ; ) {
            if (k >= i) {
                if ((i - j) % 4 == 0) {
                    break;
                }
                return null;
            }
            m = j;
            if (IA[paramString.charAt(k)] < 0) {
                m = j + 1;
            }
            k += 1;
            j = m;
        }
        int m = 0;
        k = i;
        label80:
        int n;
        byte[] arrayOfByte;
        if (k > 1) {
            localObject = IA;
            n = k - 1;
            if (localObject[paramString.charAt(n)] <= 0) {
            }
        } else {
            n = ((i - j) * 6 >> 3) - m;
            arrayOfByte = new byte[n];
            i = 0;
            j = 0;
        }
        label283:
        for (; ; ) {
            localObject = arrayOfByte;
            if (j >= n) {
                break;
            }
            m = 0;
            k = 0;
            if (k >= 4) {
                k = j + 1;
                arrayOfByte[j] = ((byte) (m >> 16));
                j = k;
                if (k < n) {
                    j = k + 1;
                    arrayOfByte[k] = ((byte) (m >> 8));
                    if (j >= n) {
                        break label283;
                    }
                    k = j + 1;
                    arrayOfByte[j] = ((byte) m);
                    j = k;
                }
                continue;
                k = n;
                if (paramString.charAt(n) != '=') {
                    break label80;
                }
                m += 1;
                k = n;
                break label80;
            }
            int i1 = IA[paramString.charAt(i)];
            if (i1 >= 0) {
                m |= i1 << 18 - k * 6;
            }
            for (; ; ) {
                k += 1;
                i += 1;
                break;
                k -= 1;
            }
        }
    }

    public static final byte[] decode(byte[] paramArrayOfByte) {
        int m = paramArrayOfByte.length;
        int i = 0;
        int j = 0;
        Object localObject;
        for (; ; ) {
            if (j >= m) {
                if ((m - i) % 4 == 0) {
                    break;
                }
                localObject = null;
                return (byte[]) localObject;
            }
            k = i;
            if (IA[(paramArrayOfByte[j] & 0xFF)] < 0) {
                k = i + 1;
            }
            j += 1;
            i = k;
        }
        int k = 0;
        j = m;
        label63:
        int n;
        byte[] arrayOfByte;
        if (j > 1) {
            localObject = IA;
            n = j - 1;
            if (localObject[(paramArrayOfByte[n] & 0xFF)] <= 0) {
            }
        } else {
            n = ((m - i) * 6 >> 3) - k;
            arrayOfByte = new byte[n];
            i = 0;
            j = 0;
        }
        label266:
        for (; ; ) {
            localObject = arrayOfByte;
            if (j >= n) {
                break;
            }
            m = 0;
            k = 0;
            if (k >= 4) {
                k = j + 1;
                arrayOfByte[j] = ((byte) (m >> 16));
                j = k;
                if (k < n) {
                    j = k + 1;
                    arrayOfByte[k] = ((byte) (m >> 8));
                    if (j >= n) {
                        break label266;
                    }
                    k = j + 1;
                    arrayOfByte[j] = ((byte) m);
                    j = k;
                }
                continue;
                j = n;
                if (paramArrayOfByte[n] != 61) {
                    break label63;
                }
                k += 1;
                j = n;
                break label63;
            }
            int i1 = IA[(paramArrayOfByte[i] & 0xFF)];
            if (i1 >= 0) {
                m |= i1 << 18 - k * 6;
            }
            for (; ; ) {
                k += 1;
                i += 1;
                break;
                k -= 1;
            }
        }
    }

    public static final byte[] decode(char[] paramArrayOfChar) {
        if (paramArrayOfChar != null) {
        }
        Object localObject;
        for (int i = paramArrayOfChar.length; i == 0; i = 0) {
            localObject = new byte[0];
            return (byte[]) localObject;
        }
        int j = 0;
        int k = 0;
        for (; ; ) {
            if (k >= i) {
                if ((i - j) % 4 == 0) {
                    break;
                }
                return null;
            }
            m = j;
            if (IA[paramArrayOfChar[k]] < 0) {
                m = j + 1;
            }
            k += 1;
            j = m;
        }
        int m = 0;
        k = i;
        label76:
        int n;
        byte[] arrayOfByte;
        if (k > 1) {
            localObject = IA;
            n = k - 1;
            if (localObject[paramArrayOfChar[n]] <= 0) {
            }
        } else {
            n = ((i - j) * 6 >> 3) - m;
            arrayOfByte = new byte[n];
            i = 0;
            j = 0;
        }
        label273:
        for (; ; ) {
            localObject = arrayOfByte;
            if (j >= n) {
                break;
            }
            m = 0;
            k = 0;
            if (k >= 4) {
                k = j + 1;
                arrayOfByte[j] = ((byte) (m >> 16));
                j = k;
                if (k < n) {
                    j = k + 1;
                    arrayOfByte[k] = ((byte) (m >> 8));
                    if (j >= n) {
                        break label273;
                    }
                    k = j + 1;
                    arrayOfByte[j] = ((byte) m);
                    j = k;
                }
                continue;
                k = n;
                if (paramArrayOfChar[n] != '=') {
                    break label76;
                }
                m += 1;
                k = n;
                break label76;
            }
            int i1 = IA[paramArrayOfChar[i]];
            if (i1 >= 0) {
                m |= i1 << 18 - k * 6;
            }
            for (; ; ) {
                k += 1;
                i += 1;
                break;
                k -= 1;
            }
        }
    }

    public static final byte[] decodeFast(String paramString) {
        int m = paramString.length();
        if (m == 0) {
            return new byte[0];
        }
        int i = 0;
        int j = m - 1;
        int n = j;
        label49:
        int k;
        label97:
        int i2;
        label129:
        int i1;
        label134:
        int i3;
        byte[] arrayOfByte;
        int i4;
        if (i < j) {
            if (IA[(paramString.charAt(i) & 0xFF)] >= 0) {
                n = j;
            }
        } else {
            if ((n > 0) && (IA[(paramString.charAt(n) & 0xFF)] < 0)) {
                break label230;
            }
            if (paramString.charAt(n) != '=') {
                break label244;
            }
            if (paramString.charAt(n - 1) != '=') {
                break label239;
            }
            k = 2;
            i2 = n - i + 1;
            if (m <= 76) {
                break label254;
            }
            if (paramString.charAt(76) != '\r') {
                break label249;
            }
            j = i2 / 78;
            i1 = j << 1;
            i3 = ((i2 - i1) * 6 >> 3) - k;
            arrayOfByte = new byte[i3];
            m = 0;
            i4 = i3 / 3;
            i2 = 0;
            j = i;
            i = i2;
        }
        for (; ; ) {
            label171:
            if (i >= i4 * 3) {
                m = i;
                m = j;
                if (i < i3) {
                    m = 0;
                    i1 = 0;
                    label197:
                    if (j <= n - k) {
                        break label438;
                    }
                    k = 16;
                }
            }
            for (; ; ) {
                if (i >= i3) {
                    m = j;
                    m = i;
                    return arrayOfByte;
                    i += 1;
                    break;
                    label230:
                    n -= 1;
                    break label49;
                    label239:
                    k = 1;
                    break label97;
                    label244:
                    k = 0;
                    break label97;
                    label249:
                    j = 0;
                    break label129;
                    label254:
                    i1 = 0;
                    break label134;
                    int[] arrayOfInt = IA;
                    int i5 = j + 1;
                    j = arrayOfInt[paramString.charAt(j)];
                    arrayOfInt = IA;
                    i2 = i5 + 1;
                    i5 = arrayOfInt[paramString.charAt(i5)];
                    arrayOfInt = IA;
                    int i6 = i2 + 1;
                    int i7 = arrayOfInt[paramString.charAt(i2)];
                    arrayOfInt = IA;
                    i2 = i6 + 1;
                    j = j << 18 | i5 << 12 | i7 << 6 | arrayOfInt[paramString.charAt(i6)];
                    i5 = i + 1;
                    arrayOfByte[i] = ((byte) (j >> 16));
                    i6 = i5 + 1;
                    arrayOfByte[i5] = ((byte) (j >> 8));
                    i = i6 + 1;
                    arrayOfByte[i6] = ((byte) j);
                    j = m;
                    if (i1 <= 0) {
                        break label495;
                    }
                    m += 1;
                    j = m;
                    if (m != 19) {
                        break label495;
                    }
                    m = 0;
                    j = i2 + 2;
                    break label171;
                    label438:
                    m |= IA[paramString.charAt(j)] << 18 - i1 * 6;
                    i1 += 1;
                    j += 1;
                    break label197;
                }
                arrayOfByte[i] = ((byte) (m >> k));
                k -= 8;
                i += 1;
            }
            label495:
            m = j;
            j = i2;
        }
    }

    public static final byte[] decodeFast(byte[] paramArrayOfByte) {
        int m = paramArrayOfByte.length;
        if (m == 0) {
            return new byte[0];
        }
        int i = 0;
        int j = m - 1;
        int n = j;
        label45:
        int k;
        label87:
        int i2;
        label117:
        int i1;
        label122:
        int i3;
        byte[] arrayOfByte;
        int i4;
        if (i < j) {
            if (IA[(paramArrayOfByte[i] & 0xFF)] >= 0) {
                n = j;
            }
        } else {
            if ((n > 0) && (IA[(paramArrayOfByte[n] & 0xFF)] < 0)) {
                break label218;
            }
            if (paramArrayOfByte[n] != 61) {
                break label232;
            }
            if (paramArrayOfByte[(n - 1)] != 61) {
                break label227;
            }
            k = 2;
            i2 = n - i + 1;
            if (m <= 76) {
                break label242;
            }
            if (paramArrayOfByte[76] != 13) {
                break label237;
            }
            j = i2 / 78;
            i1 = j << 1;
            i3 = ((i2 - i1) * 6 >> 3) - k;
            arrayOfByte = new byte[i3];
            m = 0;
            i4 = i3 / 3;
            i2 = 0;
            j = i;
            i = i2;
        }
        for (; ; ) {
            label159:
            if (i >= i4 * 3) {
                m = i;
                m = j;
                if (i < i3) {
                    m = 0;
                    i1 = 0;
                    label185:
                    if (j <= n - k) {
                        break label418;
                    }
                    k = 16;
                }
            }
            for (; ; ) {
                if (i >= i3) {
                    m = j;
                    m = i;
                    return arrayOfByte;
                    i += 1;
                    break;
                    label218:
                    n -= 1;
                    break label45;
                    label227:
                    k = 1;
                    break label87;
                    label232:
                    k = 0;
                    break label87;
                    label237:
                    j = 0;
                    break label117;
                    label242:
                    i1 = 0;
                    break label122;
                    int[] arrayOfInt = IA;
                    int i5 = j + 1;
                    j = arrayOfInt[paramArrayOfByte[j]];
                    arrayOfInt = IA;
                    i2 = i5 + 1;
                    i5 = arrayOfInt[paramArrayOfByte[i5]];
                    arrayOfInt = IA;
                    int i6 = i2 + 1;
                    int i7 = arrayOfInt[paramArrayOfByte[i2]];
                    arrayOfInt = IA;
                    i2 = i6 + 1;
                    j = j << 18 | i5 << 12 | i7 << 6 | arrayOfInt[paramArrayOfByte[i6]];
                    i5 = i + 1;
                    arrayOfByte[i] = ((byte) (j >> 16));
                    i6 = i5 + 1;
                    arrayOfByte[i5] = ((byte) (j >> 8));
                    i = i6 + 1;
                    arrayOfByte[i6] = ((byte) j);
                    j = m;
                    if (i1 <= 0) {
                        break label473;
                    }
                    m += 1;
                    j = m;
                    if (m != 19) {
                        break label473;
                    }
                    m = 0;
                    j = i2 + 2;
                    break label159;
                    label418:
                    m |= IA[paramArrayOfByte[j]] << 18 - i1 * 6;
                    i1 += 1;
                    j += 1;
                    break label185;
                }
                arrayOfByte[i] = ((byte) (m >> k));
                k -= 8;
                i += 1;
            }
            label473:
            m = j;
            j = i2;
        }
    }

    public static final byte[] decodeFast(char[] paramArrayOfChar) {
        int m = paramArrayOfChar.length;
        if (m == 0) {
            return new byte[0];
        }
        int i = 0;
        int j = m - 1;
        int n = j;
        label41:
        int k;
        label79:
        int i2;
        label109:
        int i1;
        label114:
        int i3;
        byte[] arrayOfByte;
        int i4;
        if (i < j) {
            if (IA[paramArrayOfChar[i]] >= 0) {
                n = j;
            }
        } else {
            if ((n > 0) && (IA[paramArrayOfChar[n]] < 0)) {
                break label210;
            }
            if (paramArrayOfChar[n] != '=') {
                break label224;
            }
            if (paramArrayOfChar[(n - 1)] != '=') {
                break label219;
            }
            k = 2;
            i2 = n - i + 1;
            if (m <= 76) {
                break label234;
            }
            if (paramArrayOfChar[76] != '\r') {
                break label229;
            }
            j = i2 / 78;
            i1 = j << 1;
            i3 = ((i2 - i1) * 6 >> 3) - k;
            arrayOfByte = new byte[i3];
            m = 0;
            i4 = i3 / 3;
            i2 = 0;
            j = i;
            i = i2;
        }
        for (; ; ) {
            label151:
            if (i >= i4 * 3) {
                m = i;
                m = j;
                if (i < i3) {
                    m = 0;
                    i1 = 0;
                    label177:
                    if (j <= n - k) {
                        break label410;
                    }
                    k = 16;
                }
            }
            for (; ; ) {
                if (i >= i3) {
                    m = j;
                    m = i;
                    return arrayOfByte;
                    i += 1;
                    break;
                    label210:
                    n -= 1;
                    break label41;
                    label219:
                    k = 1;
                    break label79;
                    label224:
                    k = 0;
                    break label79;
                    label229:
                    j = 0;
                    break label109;
                    label234:
                    i1 = 0;
                    break label114;
                    int[] arrayOfInt = IA;
                    int i5 = j + 1;
                    j = arrayOfInt[paramArrayOfChar[j]];
                    arrayOfInt = IA;
                    i2 = i5 + 1;
                    i5 = arrayOfInt[paramArrayOfChar[i5]];
                    arrayOfInt = IA;
                    int i6 = i2 + 1;
                    int i7 = arrayOfInt[paramArrayOfChar[i2]];
                    arrayOfInt = IA;
                    i2 = i6 + 1;
                    j = j << 18 | i5 << 12 | i7 << 6 | arrayOfInt[paramArrayOfChar[i6]];
                    i5 = i + 1;
                    arrayOfByte[i] = ((byte) (j >> 16));
                    i6 = i5 + 1;
                    arrayOfByte[i5] = ((byte) (j >> 8));
                    i = i6 + 1;
                    arrayOfByte[i6] = ((byte) j);
                    j = m;
                    if (i1 <= 0) {
                        break label465;
                    }
                    m += 1;
                    j = m;
                    if (m != 19) {
                        break label465;
                    }
                    m = 0;
                    j = i2 + 2;
                    break label151;
                    label410:
                    m |= IA[paramArrayOfChar[j]] << 18 - i1 * 6;
                    i1 += 1;
                    j += 1;
                    break label177;
                }
                arrayOfByte[i] = ((byte) (m >> k));
                k -= 8;
                i += 1;
            }
            label465:
            m = j;
            j = i2;
        }
    }

    public static final byte[] encodeToByte(byte[] paramArrayOfByte, boolean paramBoolean) {
        if (paramArrayOfByte != null) {
        }
        Object localObject;
        for (int n = paramArrayOfByte.length; n == 0; n = 0) {
            localObject = new byte[0];
            return (byte[]) localObject;
        }
        int i3 = n / 3 * 3;
        int k = (n - 1) / 3 + 1 << 2;
        int j;
        int i2;
        byte[] arrayOfByte;
        int m;
        if (paramBoolean) {
            j = (k - 1) / 76 << 1;
            i2 = k + j;
            arrayOfByte = new byte[i2];
            j = 0;
            k = 0;
            m = 0;
        }
        for (; ; ) {
            label81:
            if (m >= i3) {
                k = n - i3;
                localObject = arrayOfByte;
                if (k <= 0) {
                    break;
                }
                m = paramArrayOfByte[i3];
                if (k != 2) {
                    break label430;
                }
                j = (paramArrayOfByte[(n - 1)] & 0xFF) << 2;
                label129:
                j = (m & 0xFF) << 10 | j;
                arrayOfByte[(i2 - 4)] = ((byte) CA[(j >> 12)]);
                arrayOfByte[(i2 - 3)] = ((byte) CA[(j >>> 6 & 0x3F)]);
                if (k != 2) {
                    break label435;
                }
            }
            int i1;
            label430:
            label435:
            for (int i = (byte) CA[(j & 0x3F)]; ; i = 61) {
                arrayOfByte[(i2 - 2)] = i;
                arrayOfByte[(i2 - 1)] = 61;
                return arrayOfByte;
                j = 0;
                break;
                int i5 = m + 1;
                i1 = paramArrayOfByte[m];
                int i4 = i5 + 1;
                i5 = paramArrayOfByte[i5];
                m = i4 + 1;
                i4 = (i1 & 0xFF) << 16 | (i5 & 0xFF) << 8 | paramArrayOfByte[i4] & 0xFF;
                i1 = k + 1;
                arrayOfByte[k] = ((byte) CA[(i4 >>> 18 & 0x3F)]);
                k = i1 + 1;
                arrayOfByte[i1] = ((byte) CA[(i4 >>> 12 & 0x3F)]);
                i5 = k + 1;
                arrayOfByte[k] = ((byte) CA[(i4 >>> 6 & 0x3F)]);
                i1 = i5 + 1;
                arrayOfByte[i5] = ((byte) CA[(i4 & 0x3F)]);
                k = j;
                if (!paramBoolean) {
                    break label441;
                }
                j += 1;
                k = j;
                if (j != 19) {
                    break label441;
                }
                k = j;
                if (i1 >= i2 - 2) {
                    break label441;
                }
                j = i1 + 1;
                arrayOfByte[i1] = 13;
                k = j + 1;
                arrayOfByte[j] = 10;
                j = 0;
                break label81;
                j = 0;
                break label129;
            }
            label441:
            j = k;
            k = i1;
        }
    }

    public static final char[] encodeToChar(byte[] paramArrayOfByte, boolean paramBoolean) {
        if (paramArrayOfByte != null) {
        }
        Object localObject;
        for (int n = paramArrayOfByte.length; n == 0; n = 0) {
            localObject = new char[0];
            return (char[]) localObject;
        }
        int i3 = n / 3 * 3;
        int k = (n - 1) / 3 + 1 << 2;
        int j;
        int i2;
        char[] arrayOfChar;
        int m;
        if (paramBoolean) {
            j = (k - 1) / 76 << 1;
            i2 = k + j;
            arrayOfChar = new char[i2];
            j = 0;
            k = 0;
            m = 0;
        }
        for (; ; ) {
            label81:
            if (m >= i3) {
                k = n - i3;
                localObject = arrayOfChar;
                if (k <= 0) {
                    break;
                }
                m = paramArrayOfByte[i3];
                if (k != 2) {
                    break label423;
                }
                j = (paramArrayOfByte[(n - 1)] & 0xFF) << 2;
                label129:
                j = (m & 0xFF) << 10 | j;
                arrayOfChar[(i2 - 4)] = CA[(j >> 12)];
                arrayOfChar[(i2 - 3)] = CA[(j >>> 6 & 0x3F)];
                if (k != 2) {
                    break label428;
                }
            }
            int i1;
            label423:
            label428:
            for (int i = CA[(j & 0x3F)]; ; i = 61) {
                arrayOfChar[(i2 - 2)] = i;
                arrayOfChar[(i2 - 1)] = '=';
                return arrayOfChar;
                j = 0;
                break;
                int i5 = m + 1;
                i1 = paramArrayOfByte[m];
                int i4 = i5 + 1;
                i5 = paramArrayOfByte[i5];
                m = i4 + 1;
                i4 = (i1 & 0xFF) << 16 | (i5 & 0xFF) << 8 | paramArrayOfByte[i4] & 0xFF;
                i1 = k + 1;
                arrayOfChar[k] = CA[(i4 >>> 18 & 0x3F)];
                k = i1 + 1;
                arrayOfChar[i1] = CA[(i4 >>> 12 & 0x3F)];
                i5 = k + 1;
                arrayOfChar[k] = CA[(i4 >>> 6 & 0x3F)];
                i1 = i5 + 1;
                arrayOfChar[i5] = CA[(i4 & 0x3F)];
                k = j;
                if (!paramBoolean) {
                    break label434;
                }
                j += 1;
                k = j;
                if (j != 19) {
                    break label434;
                }
                k = j;
                if (i1 >= i2 - 2) {
                    break label434;
                }
                j = i1 + 1;
                arrayOfChar[i1] = '\r';
                k = j + 1;
                arrayOfChar[j] = '\n';
                j = 0;
                break label81;
                j = 0;
                break label129;
            }
            label434:
            j = k;
            k = i1;
        }
    }

    public static final String encodeToString(byte[] paramArrayOfByte, boolean paramBoolean) {
        return new String(encodeToChar(paramArrayOfByte, paramBoolean));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */