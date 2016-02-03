package com.flurry.sdk;

public class nd
        extends it
        implements Comparable<nd> {
    protected final String a;
    protected final String b;
    protected a<mp> c;
    protected a<mt> d;
    protected a<mr> e;
    protected a<mr> f;

    public nd(nd paramnd, String paramString) {
        this.b = paramnd.b;
        this.a = paramString;
        this.c = paramnd.c;
        this.d = paramnd.d;
        this.e = paramnd.e;
        this.f = paramnd.f;
    }

    public nd(String paramString) {
        this.b = paramString;
        this.a = paramString;
    }

    private mv a(int paramInt, a<? extends mq>... paramVarArgs) {
        mv localmv = ((mq) paramVarArgs[paramInt].a).j();
        paramInt += 1;
        while (paramInt < paramVarArgs.length) {
            if (paramVarArgs[paramInt] != null) {
                return mv.a(localmv, a(paramInt, paramVarArgs));
            }
            paramInt += 1;
        }
        return localmv;
    }

    private <T> a<T> a(a<T> parama) {
        if (parama == null) {
            return parama;
        }
        return parama.a();
    }

    private static <T> a<T> a(a<T> parama1, a<T> parama2) {
        if (parama1 == null) {
            return parama2;
        }
        if (parama2 == null) {
            return parama1;
        }
        return a.a(parama1, parama2);
    }

    private <T> a<T> b(a<T> parama) {
        if (parama == null) {
            return parama;
        }
        return parama.b();
    }

    private a<? extends mq> b(a<? extends mq> parama1, a<? extends mq> parama2) {
        if (parama1 != null) {
            String str = parama1.c;
            a<? extends mq> locala;
            if (str == null) {
                locala = parama2;
            }
            label50:
            do {
                for (; ; ) {
                    parama1 = parama1.b;
                    parama2 = locala;
                    break;
                    locala = parama2;
                    if (!str.equals(this.a)) {
                        if (parama2 != null) {
                            break label50;
                        }
                        locala = parama1;
                    }
                }
                locala = parama2;
            } while (str.equals(parama2.c));
            throw new IllegalStateException("Conflicting property name definitions: '" + parama2.c + "' (for " + parama2.a + ") vs '" + parama1.c + "' (for " + parama1.a + ")");
        }
        return parama2;
    }

    private <T> a<T> c(a<T> parama) {
        if (parama == null) {
            return parama;
        }
        return parama.c();
    }

    private <T> boolean d(a<T> parama) {
        while (parama != null) {
            if ((parama.c != null) && (parama.c.length() > 0)) {
                return true;
            }
            parama = parama.b;
        }
        return false;
    }

    private <T> boolean e(a<T> parama) {
        while (parama != null) {
            if (parama.d) {
                return true;
            }
            parama = parama.b;
        }
        return false;
    }

    private <T> boolean f(a<T> parama) {
        while (parama != null) {
            if (parama.e) {
                return true;
            }
            parama = parama.b;
        }
        return false;
    }

    public int a(nd paramnd) {
        if (this.d != null) {
            if (paramnd.d == null) {
                return -1;
            }
        } else if (paramnd.d != null) {
            return 1;
        }
        return a().compareTo(paramnd.a());
    }

    public nd a(String paramString) {
        return new nd(this, paramString);
    }

    public String a() {
        return this.a;
    }

    public void a(mp parammp, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        this.c = new a(parammp, this.c, paramString, paramBoolean1, paramBoolean2);
    }

    public void a(mr parammr, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        this.e = new a(parammr, this.e, paramString, paramBoolean1, paramBoolean2);
    }

    public void a(mt parammt, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        this.d = new a(parammt, this.d, paramString, paramBoolean1, paramBoolean2);
    }

    public void a(boolean paramBoolean) {
        if (paramBoolean) {
            if (this.e != null) {
                localmv = a(0, new a[]{this.e, this.c, this.d, this.f});
                this.e = this.e.a(((mr) this.e.a).a(localmv));
            }
        }
        do {
            do {
                return;
            } while (this.c == null);
            localmv = a(0, new a[]{this.c, this.d, this.f});
            this.c = this.c.a(((mp) this.c.a).a(localmv));
            return;
            if (this.d != null) {
                localmv = a(0, new a[]{this.d, this.f, this.c, this.e});
                this.d = this.d.a(((mt) this.d.a).a(localmv));
                return;
            }
            if (this.f != null) {
                localmv = a(0, new a[]{this.f, this.c, this.e});
                this.f = this.f.a(((mr) this.f.a).a(localmv));
                return;
            }
        } while (this.c == null);
        mv localmv = a(0, new a[]{this.c, this.e});
        this.c = this.c.a(((mp) this.c.a).a(localmv));
    }

    public void b(mr parammr, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
        this.f = new a(parammr, this.f, paramString, paramBoolean1, paramBoolean2);
    }

    public void b(nd paramnd) {
        this.c = a(this.c, paramnd.c);
        this.d = a(this.d, paramnd.d);
        this.e = a(this.e, paramnd.e);
        this.f = a(this.f, paramnd.f);
    }

    public boolean b() {
        return this.e != null;
    }

    public boolean c() {
        return this.f != null;
    }

    public boolean d() {
        return this.c != null;
    }

    public boolean e() {
        return this.d != null;
    }

    public mr g() {
        if (this.e == null) {
            localObject2 = null;
        }
        Object localObject1;
        a locala;
        do {
            return (mr) localObject2;
            localObject1 = (mr) this.e.a;
            locala = this.e.b;
            localObject2 = localObject1;
        } while (locala == null);
        Object localObject2 = (mr) locala.a;
        Class localClass1 = ((mr) localObject1).h();
        Class localClass2 = ((mr) localObject2).h();
        if (localClass1 != localClass2) {
            if (localClass1.isAssignableFrom(localClass2)) {
                localObject1 = localObject2;
            }
            while (localClass2.isAssignableFrom(localClass1)) {
                locala = locala.b;
                break;
            }
        }
        throw new IllegalArgumentException("Conflicting getter definitions for property \"" + a() + "\": " + ((mr) localObject1).n() + " vs " + ((mr) localObject2).n());
    }

    public mr h() {
        if (this.f == null) {
            localObject2 = null;
        }
        Object localObject1;
        a locala;
        do {
            return (mr) localObject2;
            localObject1 = (mr) this.f.a;
            locala = this.f.b;
            localObject2 = localObject1;
        } while (locala == null);
        Object localObject2 = (mr) locala.a;
        Class localClass1 = ((mr) localObject1).h();
        Class localClass2 = ((mr) localObject2).h();
        if (localClass1 != localClass2) {
            if (localClass1.isAssignableFrom(localClass2)) {
                localObject1 = localObject2;
            }
            while (localClass2.isAssignableFrom(localClass1)) {
                locala = locala.b;
                break;
            }
        }
        throw new IllegalArgumentException("Conflicting setter definitions for property \"" + a() + "\": " + ((mr) localObject1).n() + " vs " + ((mr) localObject2).n());
    }

    public mp i() {
        if (this.c == null) {
            localObject2 = null;
        }
        Object localObject1;
        a locala;
        do {
            return (mp) localObject2;
            localObject1 = (mp) this.c.a;
            locala = this.c.b;
            localObject2 = localObject1;
        } while (locala == null);
        Object localObject2 = (mp) locala.a;
        Class localClass1 = ((mp) localObject1).h();
        Class localClass2 = ((mp) localObject2).h();
        if (localClass1 != localClass2) {
            if (localClass1.isAssignableFrom(localClass2)) {
                localObject1 = localObject2;
            }
            while (localClass2.isAssignableFrom(localClass1)) {
                locala = locala.b;
                break;
            }
        }
        throw new IllegalArgumentException("Multiple fields representing property \"" + a() + "\": " + ((mp) localObject1).f() + " vs " + ((mp) localObject2).f());
    }

    public mq j() {
        mr localmr = g();
        Object localObject = localmr;
        if (localmr == null) {
            localObject = i();
        }
        return (mq) localObject;
    }

    public mq k() {
        Object localObject2 = m();
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject2 = h();
            localObject1 = localObject2;
            if (localObject2 == null) {
                localObject1 = i();
            }
        }
        return (mq) localObject1;
    }

    public String l() {
        return this.b;
    }

    public mt m() {
        if (this.d == null) {
            return null;
        }
        a locala = this.d;
        for (; ; ) {
            if ((((mt) locala.a).f() instanceof mo)) {
                return (mt) locala.a;
            }
            locala = locala.b;
            if (locala == null) {
                return (mt) this.d.a;
            }
        }
    }

    public void n() {
        this.c = a(this.c);
        this.e = a(this.e);
        this.f = a(this.f);
        this.d = a(this.d);
    }

    public void o() {
        this.e = b(this.e);
        this.d = b(this.d);
        if (this.e == null) {
            this.c = b(this.c);
            this.f = b(this.f);
        }
    }

    public void p() {
        this.c = c(this.c);
        this.e = c(this.e);
        this.f = c(this.f);
        this.d = c(this.d);
    }

    public boolean q() {
        return (d(this.c)) || (d(this.e)) || (d(this.f)) || (d(this.d));
    }

    public boolean r() {
        return (e(this.c)) || (e(this.e)) || (e(this.f)) || (e(this.d));
    }

    public boolean s() {
        return (f(this.c)) || (f(this.e)) || (f(this.f)) || (f(this.d));
    }

    public boolean t() {
        return (f(this.c)) || (f(this.f)) || (f(this.d));
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Property '").append(this.a).append("'; ctors: ").append(this.d).append(", field(s): ").append(this.c).append(", getter(s): ").append(this.e).append(", setter(s): ").append(this.f);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
    }

    public String u() {
        a locala = b(this.c, null);
        locala = b(this.e, locala);
        locala = b(this.f, locala);
        locala = b(this.d, locala);
        if (locala == null) {
            return null;
        }
        return locala.c;
    }

    static final class a<T> {
        public final T a;
        public final a<T> b;
        public final String c;
        public final boolean d;
        public final boolean e;

        public a(T paramT, a<T> parama, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
            this.a = paramT;
            this.b = parama;
            if (paramString == null) {
            }
            for (this.c = null; ; this.c = paramT) {
                this.d = paramBoolean1;
                this.e = paramBoolean2;
                return;
                paramT = paramString;
                if (paramString.length() == 0) {
                    paramT = null;
                }
            }
        }

        private a<T> b(a<T> parama) {
            if (this.b == null) {
                return a(parama);
            }
            return a(this.b.b(parama));
        }

        public a<T> a() {
            if (this.e) {
                if (this.b == null) {
                    return null;
                }
                return this.b.a();
            }
            if (this.b != null) {
                a locala = this.b.a();
                if (locala != this.b) {
                    return a(locala);
                }
            }
            return this;
        }

        public a<T> a(a<T> parama) {
            if (parama == this.b) {
                return this;
            }
            return new a(this.a, parama, this.c, this.d, this.e);
        }

        public a<T> a(T paramT) {
            if (paramT == this.a) {
                return this;
            }
            return new a(paramT, this.b, this.c, this.d, this.e);
        }

        public a<T> b() {
            if (this.b == null) {
            }
            for (a locala1 = null; ; locala1 = this.b.b()) {
                a locala2 = locala1;
                if (this.d) {
                    locala2 = a(locala1);
                }
                return locala2;
            }
        }

        public a<T> c() {
            Object localObject;
            if (this.b == null) {
                localObject = this;
            }
            do {
                a locala;
                do {
                    return (a<T>) localObject;
                    locala = this.b.c();
                    if (this.c != null) {
                        if (locala.c == null) {
                            return a(null);
                        }
                        return a(locala);
                    }
                    localObject = locala;
                } while (locala.c != null);
                if (this.d == locala.d) {
                    return a(locala);
                }
                localObject = locala;
            } while (!this.d);
            return a(null);
        }

        public String toString() {
            String str2 = this.a.toString() + "[visible=" + this.d + "]";
            String str1 = str2;
            if (this.b != null) {
                str1 = str2 + ", " + this.b.toString();
            }
            return str1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/nd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */