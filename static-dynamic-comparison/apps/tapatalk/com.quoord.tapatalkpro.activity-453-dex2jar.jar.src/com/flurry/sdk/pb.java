package com.flurry.sdk;

import java.io.IOException;

public abstract class pb<T>
        extends pf<T>
        implements jt {
    protected final boolean a;
    protected final sh b;
    protected final jz c;
    protected jk<Object> d;
    protected final is e;
    protected ov f;

    protected pb(Class<?> paramClass, sh paramsh, boolean paramBoolean, jz paramjz, is paramis, jk<Object> paramjk) {
        super(paramClass, false);
        this.b = paramsh;
        if (!paramBoolean) {
            paramBoolean = bool;
            if (paramsh != null) {
                paramBoolean = bool;
                if (!paramsh.u()) {
                }
            }
        } else {
            paramBoolean = true;
        }
        this.a = paramBoolean;
        this.c = paramjz;
        this.e = paramis;
        this.d = paramjk;
        this.f = ov.a();
    }

    protected final jk<Object> a(ov paramov, sh paramsh, jw paramjw)
            throws jh {
        paramsh = paramov.a(paramsh, paramjw, this.e);
        if (paramov != paramsh.b) {
            this.f = paramsh.b;
        }
        return paramsh.a;
    }

    protected final jk<Object> a(ov paramov, Class<?> paramClass, jw paramjw)
            throws jh {
        paramClass = paramov.a(paramClass, paramjw, this.e);
        if (paramov != paramClass.b) {
            this.f = paramClass.b;
        }
        return paramClass.a;
    }

    public void a(jw paramjw)
            throws jh {
        if ((this.a) && (this.b != null) && (this.d == null)) {
            this.d = paramjw.a(this.b, this.e);
        }
    }

    public final void a(T paramT, hf paramhf, jw paramjw)
            throws IOException, he {
        paramhf.b();
        b(paramT, paramhf, paramjw);
        paramhf.c();
    }

    public final void a(T paramT, hf paramhf, jw paramjw, jz paramjz)
            throws IOException, he {
        paramjz.c(paramT, paramhf);
        b(paramT, paramhf, paramjw);
        paramjz.f(paramT, paramhf);
    }

    protected abstract void b(T paramT, hf paramhf, jw paramjw)
            throws IOException, he;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */