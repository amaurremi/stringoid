package com.flurry.sdk;

import java.io.IOException;

@kb
public class mf
        extends mc<String> {
    public mf() {
        super(String.class);
    }

    public String b(hj paramhj, iz paramiz)
            throws IOException, hk {
        hm localhm = paramhj.e();
        if (localhm == hm.h) {
            return paramhj.k();
        }
        if (localhm == hm.g) {
            paramhj = paramhj.z();
            if (paramhj == null) {
                return null;
            }
            if ((paramhj instanceof byte[])) {
                return hb.a().a((byte[]) paramhj, false);
            }
            return paramhj.toString();
        }
        if (localhm.d()) {
            return paramhj.k();
        }
        throw paramiz.a(this.q, localhm);
    }

    public String b(hj paramhj, iz paramiz, jy paramjy)
            throws IOException, hk {
        return b(paramhj, paramiz);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */