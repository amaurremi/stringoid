package com.mopub.mobileads.util;

import java.io.UnsupportedEncodingException;

public class Base64 {
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    static {
        if (!Base64.class.desiredAssertionStatus()) {
        }
        for (boolean bool = true; ; bool = false) {
            a = bool;
            return;
        }
    }

    public static byte[] decode(String paramString, int paramInt) {
        return decode(paramString.getBytes(), paramInt);
    }

    public static byte[] decode(byte[] paramArrayOfByte, int paramInt) {
        return decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
    }

    public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3) {
        b localb = new b(paramInt3, new byte[paramInt2 * 3 / 4]);
        if (!localb.process(paramArrayOfByte, paramInt1, paramInt2, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (localb.op == localb.output.length) {
            return localb.output;
        }
        paramArrayOfByte = new byte[localb.op];
        System.arraycopy(localb.output, 0, paramArrayOfByte, 0, localb.op);
        return paramArrayOfByte;
    }

    public static byte[] encode(byte[] paramArrayOfByte, int paramInt) {
        return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
    }

    public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3) {
        c localc = new c(paramInt3, null);
        int i = paramInt2 / 3 * 4;
        int j;
        if (localc.do_padding) {
            paramInt3 = i;
            if (paramInt2 % 3 > 0) {
                paramInt3 = i + 4;
            }
            i = paramInt3;
            if (localc.do_newline) {
                i = paramInt3;
                if (paramInt2 > 0) {
                    j = (paramInt2 - 1) / 57;
                    if (!localc.do_cr) {
                        break label186;
                    }
                }
            }
        }
        label186:
        for (i = 2; ; i = 1) {
            i = paramInt3 + i * (j + 1);
            localc.output = new byte[i];
            localc.process(paramArrayOfByte, paramInt1, paramInt2, true);
            if ((a) || (localc.op == i)) {
                break label192;
            }
            throw new AssertionError();
            paramInt3 = i;
            switch (paramInt2 % 3) {
                case 0:
                default:
                    paramInt3 = i;
                    break;
                case 1:
                    paramInt3 = i + 2;
                    break;
                case 2:
                    paramInt3 = i + 3;
                    break;
            }
        }
        label192:
        return localc.output;
    }

    public static String encodeToString(byte[] paramArrayOfByte, int paramInt) {
        try {
            paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt), "US-ASCII");
            return paramArrayOfByte;
        } catch (UnsupportedEncodingException paramArrayOfByte) {
            throw new AssertionError(paramArrayOfByte);
        }
    }

    public static String encodeToString(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3) {
        try {
            paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt1, paramInt2, paramInt3), "US-ASCII");
            return paramArrayOfByte;
        } catch (UnsupportedEncodingException paramArrayOfByte) {
            throw new AssertionError(paramArrayOfByte);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */