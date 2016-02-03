package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

import java.util.HashMap;

public class ju
        extends jn.c<a, ju> {
    protected kg.a a = null;
    protected Class<?> b;
    protected on c;

    public ju(iu<? extends ir> paramiu, iq paramiq, ne<?> paramne, ng paramng, jr paramjr, qs paramqs, je paramje) {
        super(paramiu, paramiq, paramne, paramng, paramjr, paramqs, paramje, d(a.class));
        this.c = null;
    }

    protected ju(ju paramju, jn.a parama) {
        super(paramju, parama, paramju.h);
        this.a = paramju.a;
        this.b = paramju.b;
        this.c = paramju.c;
    }

    protected ju(ju paramju, HashMap<qj, Class<?>> paramHashMap, ng paramng) {
        this(paramju, paramju.e);
        this.f = paramHashMap;
        this.h = paramng;
    }

    public iq a() {
        if (a(a.a)) {
            return super.a();
        }
        return iq.a();
    }

    public <T extends ir> T a(sh paramsh) {
        return i().a(this, paramsh, this);
    }

    public jk<Object> a(mm parammm, Class<? extends jk<?>> paramClass) {
        je localje = k();
        if (localje != null) {
            parammm = localje.a(this, parammm, paramClass);
            if (parammm != null) {
                return parammm;
            }
        }
        return (jk) qy.b(paramClass, c());
    }

    public ju a(ng paramng) {
        HashMap localHashMap = this.f;
        this.g = true;
        return new ju(this, localHashMap, paramng);
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

    @Deprecated
    public void b(a parama) {
        super.b(parama);
    }

    public boolean b() {
        return a(a.a);
    }

    @Deprecated
    public void c(a parama) {
        super.a(parama);
    }

    public boolean c() {
        return a(a.e);
    }

    public boolean d() {
        return a(a.l);
    }

    public ne<?> e() {
        Object localObject2 = super.e();
        Object localObject1 = localObject2;
        if (!a(a.b)) {
            localObject1 = ((ne) localObject2).a(JsonAutoDetect.Visibility.NONE);
        }
        localObject2 = localObject1;
        if (!a(a.c)) {
            localObject2 = ((ne) localObject1).b(JsonAutoDetect.Visibility.NONE);
        }
        localObject1 = localObject2;
        if (!a(a.d)) {
            localObject1 = ((ne) localObject2).e(JsonAutoDetect.Visibility.NONE);
        }
        return (ne<?>) localObject1;
    }

    public Class<?> f() {
        return this.b;
    }

    public kg.a g() {
        if (this.a != null) {
            return this.a;
        }
        if (a(a.g)) {
            return kg.a.a;
        }
        return kg.a.b;
    }

    public on h() {
        return this.c;
    }

    public String toString() {
        return "[SerializationConfig: flags=0x" + Integer.toHexString(this.i) + "]";
    }

    public static enum a
            implements jn.b {
        final boolean x;

        private a(boolean paramBoolean) {
            this.x = paramBoolean;
        }

        public boolean a() {
            return this.x;
        }

        public int b() {
            return 1 << ordinal();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */