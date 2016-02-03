package com.google.android.gms.common.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class a {
    private final c<?, O> a;
    private final d<?> b;
    private final ArrayList<t> c;

    public <C extends b> a(c<C, O> paramc, d<C> paramd, t... paramVarArgs) {
        this.a = paramc;
        this.b = paramd;
        this.c = new ArrayList(Arrays.asList(paramVarArgs));
    }

    public c<?, O> a() {
        return this.a;
    }

    public List<t> b() {
        return this.c;
    }

    public d<?> c() {
        return this.b;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/api/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */