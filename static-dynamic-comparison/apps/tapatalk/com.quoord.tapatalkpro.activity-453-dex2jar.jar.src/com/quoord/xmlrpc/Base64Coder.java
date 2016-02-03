package com.quoord.xmlrpc;

import java.io.ByteArrayOutputStream;

class Base64Coder {
    private static char[] map1 = new char[64];
    private static byte[] map2;

    static {
        int i = 65;
        int j = 0;
        if (i > 90) {
            i = 97;
            label21:
            if (i <= 122) {
                break label101;
            }
            i = 48;
            label30:
            if (i <= 57) {
                break label119;
            }
            char[] arrayOfChar = map1;
            int k = j + 1;
            arrayOfChar[j] = '+';
            map1[k] = '/';
            map2 = new byte[''];
            j = 0;
            label66:
            if (j < map2.length) {
                break label137;
            }
            j = 0;
        }
        for (; ; ) {
            if (j >= 64) {
                return;
                map1[j] = i;
                i = (char) (i + 1);
                j += 1;
                break;
                label101:
                map1[j] = i;
                i = (char) (i + 1);
                j += 1;
                break label21;
                label119:
                map1[j] = i;
                i = (char) (i + 1);
                j += 1;
                break label30;
                label137:
                map2[j] = -1;
                j += 1;
                break label66;
            }
            map2[map1[j]] = ((byte) j);
            j += 1;
        }
    }

    static byte[] decode(String paramString) {
        return decode(paramString.toCharArray());
    }

    static byte[] decode(char[] paramArrayOfChar) {
        int i = paramArrayOfChar.length;
        int k = i;
        if (i % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while ((k > 0) && (paramArrayOfChar[(k - 1)] == '=')) {
            k -= 1;
        }
        int i2 = k * 3 / 4;
        byte[] arrayOfByte = new byte[i2];
        int j = 0;
        i = 0;
        if (i >= k) {
            return arrayOfByte;
        }
        int m = i + 1;
        int i3 = paramArrayOfChar[i];
        i = m + 1;
        int i4 = paramArrayOfChar[m];
        if (i < k) {
            m = paramArrayOfChar[i];
            i += 1;
            if (i >= k) {
                break label166;
            }
            n = i + 1;
            i1 = paramArrayOfChar[i];
            i = n;
        }
        label166:
        for (int n = i1; ; n = 65) {
            if ((i3 <= 127) && (i4 <= 127) && (m <= 127) && (n <= 127)) {
                break label173;
            }
            throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            m = 65;
            break;
        }
        label173:
        i3 = map2[i3];
        i4 = map2[i4];
        int i1 = map2[m];
        n = map2[n];
        if ((i3 < 0) || (i4 < 0) || (i1 < 0) || (n < 0)) {
            throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
        }
        m = j + 1;
        arrayOfByte[j] = ((byte) (i3 << 2 | i4 >>> 4));
        if (m < i2) {
            j = m + 1;
            arrayOfByte[m] = ((byte) ((i4 & 0xF) << 4 | i1 >>> 2));
        }
        for (; ; ) {
            if (j < i2) {
                arrayOfByte[j] = ((byte) ((i1 & 0x3) << 6 | n));
                j += 1;
                break;
            }
            break;
            j = m;
        }
    }

    static String decodeString(String paramString) {
        return new String(decode(paramString));
    }

    static char[] encode(ByteArrayOutputStream paramByteArrayOutputStream) {
        paramByteArrayOutputStream = paramByteArrayOutputStream.toByteArray();
        int i2 = paramByteArrayOutputStream.length;
        int i3 = (i2 * 4 + 2) / 3;
        char[] arrayOfChar = new char[(i2 + 2) / 3 * 4];
        int k = 0;
        int j = 0;
        if (j >= i2) {
            return arrayOfChar;
        }
        int m = j + 1;
        int i4 = paramByteArrayOutputStream[j] & 0xFF;
        label80:
        int n;
        if (m < i2) {
            j = m + 1;
            m = paramByteArrayOutputStream[m] & 0xFF;
            if (j >= i2) {
                break label223;
            }
            n = j + 1;
            int i1 = paramByteArrayOutputStream[j] & 0xFF;
            j = n;
            n = i1;
            label107:
            i1 = k + 1;
            arrayOfChar[k] = map1[(i4 >>> 2)];
            k = i1 + 1;
            arrayOfChar[i1] = map1[((i4 & 0x3) << 4 | m >>> 4)];
            if (k >= i3) {
                break label229;
            }
            i = map1[((m & 0xF) << 2 | n >>> 6)];
            label173:
            arrayOfChar[k] = i;
            k += 1;
            if (k >= i3) {
                break label235;
            }
        }
        label223:
        label229:
        label235:
        for (int i = map1[(n & 0x3F)]; ; i = 61) {
            arrayOfChar[k] = i;
            k += 1;
            break;
            n = 0;
            j = m;
            m = n;
            break label80;
            n = 0;
            break label107;
            i = 61;
            break label173;
        }
    }

    static char[] encode(byte[] paramArrayOfByte) {
        int i2 = paramArrayOfByte.length;
        int i3 = (i2 * 4 + 2) / 3;
        char[] arrayOfChar = new char[(i2 + 2) / 3 * 4];
        int k = 0;
        int j = 0;
        if (j >= i2) {
            return arrayOfChar;
        }
        int m = j + 1;
        int i4 = paramArrayOfByte[j] & 0xFF;
        label75:
        int n;
        if (m < i2) {
            j = m + 1;
            m = paramArrayOfByte[m] & 0xFF;
            if (j >= i2) {
                break label218;
            }
            n = j + 1;
            int i1 = paramArrayOfByte[j] & 0xFF;
            j = n;
            n = i1;
            label102:
            i1 = k + 1;
            arrayOfChar[k] = map1[(i4 >>> 2)];
            k = i1 + 1;
            arrayOfChar[i1] = map1[((i4 & 0x3) << 4 | m >>> 4)];
            if (k >= i3) {
                break label224;
            }
            i = map1[((m & 0xF) << 2 | n >>> 6)];
            label168:
            arrayOfChar[k] = i;
            k += 1;
            if (k >= i3) {
                break label230;
            }
        }
        label218:
        label224:
        label230:
        for (int i = map1[(n & 0x3F)]; ; i = 61) {
            arrayOfChar[k] = i;
            k += 1;
            break;
            n = 0;
            j = m;
            m = n;
            break label75;
            n = 0;
            break label102;
            i = 61;
            break label168;
        }
    }

    static String encodeString(String paramString) {
        return new String(encode(paramString.getBytes()));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/Base64Coder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */