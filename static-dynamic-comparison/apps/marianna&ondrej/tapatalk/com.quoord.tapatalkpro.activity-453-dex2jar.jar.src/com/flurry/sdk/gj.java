package com.flurry.sdk;

import java.io.OutputStream;

public class gj {
    private static final gj c = new a(null);
    protected int a = 2048;
    protected int b = 65536;

    public static gj a() {
        return c;
    }

    public gc a(OutputStream paramOutputStream, gc paramgc) {
        if ((paramgc == null) || (!paramgc.getClass().equals(gd.class))) {
            return new gd(paramOutputStream, this.a);
        }
        return ((gd) paramgc).a(paramOutputStream, this.a);
    }

    public gj a(int paramInt) {
        int i = 16777216;
        int j = 32;
        if (paramInt < 32) {
            paramInt = j;
        }
        for (; ; ) {
            if (paramInt > 16777216) {
                paramInt = i;
            }
            for (; ; ) {
                this.a = paramInt;
                return this;
            }
        }
    }

    public gc b(OutputStream paramOutputStream, gc paramgc) {
        if ((paramgc == null) || (!paramgc.getClass().equals(gh.class))) {
            return new gh(paramOutputStream);
        }
        return ((gh) paramgc).a(paramOutputStream);
    }

    static class a
            extends gj {
        public gj a(int paramInt) {
            throw new fk("Default EncoderFactory cannot be configured");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */