package com.flurry.sdk;

import java.io.IOException;
import java.util.TimeZone;

public class qf
        extends pt<TimeZone> {
    public static final qf a = new qf();

    public qf() {
        super(TimeZone.class);
    }

    public void a(TimeZone paramTimeZone, hf paramhf, jw paramjw)
            throws IOException, he {
        paramhf.b(paramTimeZone.getID());
    }

    public void a(TimeZone paramTimeZone, hf paramhf, jw paramjw, jz paramjz)
            throws IOException, he {
        paramjz.a(paramTimeZone, paramhf, TimeZone.class);
        a(paramTimeZone, paramhf, paramjw);
        paramjz.d(paramTimeZone, paramhf);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */