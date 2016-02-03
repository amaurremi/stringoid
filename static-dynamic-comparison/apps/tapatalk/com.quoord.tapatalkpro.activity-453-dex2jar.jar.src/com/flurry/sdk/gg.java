package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;

public class gg {
    private static final gg b = new a(null);
    int a = 8192;

    public static gg a() {
        return b;
    }

    public gb a(InputStream paramInputStream, gb paramgb) {
        if ((paramgb == null) || (!paramgb.getClass().equals(gb.class))) {
            return new gb(paramInputStream, this.a);
        }
        return paramgb.a(paramInputStream, this.a);
    }

    public gb a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, gb paramgb) {
        if ((paramgb == null) || (!paramgb.getClass().equals(gb.class))) {
            return new gb(paramArrayOfByte, paramInt1, paramInt2);
        }
        return paramgb.a(paramArrayOfByte, paramInt1, paramInt2);
    }

    public gb a(byte[] paramArrayOfByte, gb paramgb) {
        return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramgb);
    }

    public gl a(fn paramfn1, fn paramfn2, gf paramgf)
            throws IOException {
        return new gl(paramfn1, paramfn2, paramgf);
    }

    static class a
            extends gg {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */