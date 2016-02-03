package com.flurry.sdk;

import java.io.IOException;

public class pa
        extends pc {
    public pa(pc parampc) {
        super(parampc);
    }

    public jk<Object> a() {
        return this;
    }

    public final void a(Object paramObject, hf paramhf, jw paramjw)
            throws IOException, he {
        if (this.e != null) {
            c(paramObject, paramhf, paramjw);
            return;
        }
        b(paramObject, paramhf, paramjw);
    }

    public boolean b() {
        return true;
    }

    public String toString() {
        return "UnwrappingBeanSerializer for " + c().getName();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */