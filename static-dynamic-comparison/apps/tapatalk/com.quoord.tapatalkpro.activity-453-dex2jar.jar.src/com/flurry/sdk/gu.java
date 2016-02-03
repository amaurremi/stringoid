package com.flurry.sdk;

import java.io.IOException;

public class gu<T>
        extends fv<T> {
    public gu() {
        super(gs.b());
    }

    public gu(Class<T> paramClass) {
        super(gs.b().a(paramClass), gs.b());
    }

    protected void c(fn paramfn, Object paramObject, gi paramgi)
            throws IOException {
        if (!(paramObject instanceof Enum)) {
            super.c(paramfn, paramObject, paramgi);
            return;
        }
        paramgi.a(((Enum) paramObject).ordinal());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */