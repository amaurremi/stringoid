package com.flurry.sdk;

import java.io.IOException;

public abstract class qq
        extends sh
        implements jj {
    volatile String c;

    protected qq(Class<?> paramClass, int paramInt, Object paramObject1, Object paramObject2) {
        super(paramClass, paramInt);
        this.f = paramObject1;
        this.g = paramObject2;
    }

    protected abstract String a();

    public void a(hf paramhf, jw paramjw)
            throws IOException, hk {
        paramhf.b(m());
    }

    public void a(hf paramhf, jw paramjw, jz paramjz)
            throws IOException, hk {
        paramjz.a(this, paramhf);
        a(paramhf, paramjw);
        paramjz.d(this, paramhf);
    }

    public String m() {
        String str2 = this.c;
        String str1 = str2;
        if (str2 == null) {
            str1 = a();
        }
        return str1;
    }

    public <T> T n() {
        return (T) this.f;
    }

    public <T> T o() {
        return (T) this.g;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */