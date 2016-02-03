package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

import java.util.HashMap;

public class iy
        extends jn.c<a, iy> {
    protected rd<ja> a;
    protected final rs b;
    protected boolean c;

    public iy(iu<? extends ir> paramiu, iq paramiq, ne<?> paramne, ng paramng, jr paramjr, qs paramqs, je paramje) {
        super(paramiu, paramiq, paramne, paramng, paramjr, paramqs, paramje, d(a.class));
        this.b = rs.a;
    }

    protected iy(iy paramiy, jn.a parama) {
        super(paramiy, parama, paramiy.h);
        this.a = paramiy.a;
        this.b = paramiy.b;
        this.c = paramiy.c;
    }

    private iy(iy paramiy, HashMap<qj, Class<?>> paramHashMap, ng paramng) {
        this(paramiy, paramiy.e);
        this.f = paramHashMap;
        this.h = paramng;
    }

    public iq a() {
        if (a(a.a)) {
            return super.a();
        }
        return nb.a;
    }

    public <T extends ir> T a(sh paramsh) {
        return i().a(this, paramsh, this);
    }

    protected iy a(int paramInt) {
        if ((ju.a.l.b() & paramInt) != 0) {
        }
        for (boolean bool = true; ; bool = false) {
            this.c = bool;
            return this;
        }
    }

    public iy a(ng paramng) {
        HashMap localHashMap = this.f;
        this.g = true;
        return new iy(this, localHashMap, paramng);
    }

    public jg<Object> a(mm parammm, Class<? extends jg<?>> paramClass) {
        je localje = k();
        if (localje != null) {
            parammm = localje.a(this, parammm, paramClass);
            if (parammm != null) {
                return parammm;
            }
        }
        return (jg) qy.b(paramClass, c());
    }

    @Deprecated
    public void a(a parama, boolean paramBoolean) {
        super.a(parama, paramBoolean);
    }

    public boolean a(a parama) {
        return (this.i & parama.b()) != 0;
    }

    public <T extends ir> T b(sh paramsh) {
        return i().a(this, paramsh, this);
    }

    public jl b(mm parammm, Class<? extends jl> paramClass) {
        je localje = k();
        if (localje != null) {
            parammm = localje.b(this, parammm, paramClass);
            if (parammm != null) {
                return parammm;
            }
        }
        return (jl) qy.b(paramClass, c());
    }

    @Deprecated
    public void b(a parama) {
        super.b(parama);
    }

    public boolean b() {
        return a(a.a);
    }

    public <T extends ir> T c(sh paramsh) {
        return i().b(this, paramsh, this);
    }

    public kx c(mm parammm, Class<? extends kx> paramClass) {
        je localje = k();
        if (localje != null) {
            parammm = localje.c(this, parammm, paramClass);
            if (parammm != null) {
                return parammm;
            }
        }
        return (kx) qy.b(paramClass, c());
    }

    @Deprecated
    public void c(a parama) {
        super.a(parama);
    }

    public boolean c() {
        return a(a.f);
    }

    public boolean d() {
        return this.c;
    }

    public ne<?> e() {
        Object localObject2 = super.e();
        Object localObject1 = localObject2;
        if (!a(a.b)) {
            localObject1 = ((ne) localObject2).c(JsonAutoDetect.Visibility.NONE);
        }
        localObject2 = localObject1;
        if (!a(a.c)) {
            localObject2 = ((ne) localObject1).d(JsonAutoDetect.Visibility.NONE);
        }
        localObject1 = localObject2;
        if (!a(a.d)) {
            localObject1 = ((ne) localObject2).e(JsonAutoDetect.Visibility.NONE);
        }
        return (ne<?>) localObject1;
    }

    public rd<ja> f() {
        return this.a;
    }

    public ha g() {
        return hb.a();
    }

    public final rs h() {
        return this.b;
    }

    public static enum a
            implements jn.b {
        final boolean r;

        private a(boolean paramBoolean) {
            this.r = paramBoolean;
        }

        public boolean a() {
            return this.r;
        }

        public int b() {
            return 1 << ordinal();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/iy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */