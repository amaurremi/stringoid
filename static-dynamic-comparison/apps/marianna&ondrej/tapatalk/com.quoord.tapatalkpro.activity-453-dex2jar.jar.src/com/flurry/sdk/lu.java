package com.flurry.sdk;

import java.io.IOException;

public class lu
        extends mc<sh> {
    public lu() {
        super(sh.class);
    }

    public sh b(hj paramhj, iz paramiz)
            throws IOException, hk {
        hm localhm = paramhj.e();
        if (localhm == hm.h) {
            paramhj = paramhj.k().trim();
            if (paramhj.length() == 0) {
                return (sh) c();
            }
            return paramiz.f().b(paramhj);
        }
        if (localhm == hm.g) {
            return (sh) paramhj.z();
        }
        throw paramiz.b(this.q);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */