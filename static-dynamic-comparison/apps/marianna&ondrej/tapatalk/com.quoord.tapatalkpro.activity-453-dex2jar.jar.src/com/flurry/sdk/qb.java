package com.flurry.sdk;

import java.io.IOException;
import java.util.Date;

public class qb
        extends pw<Object> {
    static final qb a = new qb();

    public qb() {
        super(Object.class);
    }

    public void a(Object paramObject, hf paramhf, jw paramjw)
            throws IOException, he {
        if ((paramObject instanceof Date)) {
            paramjw.b((Date) paramObject, paramhf);
            return;
        }
        paramhf.a(paramObject.toString());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */