package com.flurry.sdk;

import java.io.IOException;

@kb
public class pi
        extends pt<Enum<?>> {
    protected final rb a;

    public pi(rb paramrb) {
        super(Enum.class, false);
        this.a = paramrb;
    }

    public static pi a(Class<Enum<?>> paramClass, ju paramju, mw parammw) {
        parammw = paramju.a();
        if (paramju.a(ju.a.t)) {
        }
        for (paramClass = rb.c(paramClass, parammw); ; paramClass = rb.b(paramClass, parammw)) {
            return new pi(paramClass);
        }
    }

    public final void a(Enum<?> paramEnum, hf paramhf, jw paramjw)
            throws IOException, he {
        if (paramjw.a(ju.a.u)) {
            paramhf.b(paramEnum.ordinal());
            return;
        }
        paramhf.b(this.a.a(paramEnum));
    }

    public rb d() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */