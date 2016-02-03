package mobi.ifunny.studio.comics.engine;

import mobi.ifunny.studio.comics.engine.b.i;
import mobi.ifunny.util.d;

public class a {
    protected final d<i> a;
    protected final d<i> b;
    private boolean c;
    private boolean d;
    private final f e;
    private b f;
    private a g;
    private boolean h;

    public a(f paramf, int paramInt) {
        this.a = new d(paramInt);
        this.b = new d(paramInt);
        this.e = paramf;
    }

    private void a(i parami) {
        this.b.a(parami);
        if (!this.d) {
            this.d = true;
            if (this.f != null) {
                this.f.c(true);
            }
        }
    }

    private void b(i parami) {
        this.a.a(parami);
        if (!this.c) {
            this.c = true;
            if (this.f != null) {
                this.f.d(true);
            }
        }
    }

    private i h() {
        i locali = (i) this.b.c();
        if (this.d != g()) {
            this.d = g();
            if (this.f != null) {
                this.f.c(g());
            }
        }
        return locali;
    }

    private i i() {
        i locali = (i) this.a.c();
        if (this.c != f()) {
            this.c = f();
            if (this.f != null) {
                this.f.d(f());
            }
        }
        return locali;
    }

    public a a() {
        return this.g;
    }

    public void a(a parama) {
        this.g = parama;
        if (parama != null) {
            this.h = true;
            parama.a(this.f);
            if (this.f != null) {
                this.f.c(parama.d);
                this.f.d(parama.c);
            }
        }
        do {
            return;
            this.h = false;
        } while (this.f == null);
        this.f.c(this.d);
        this.f.d(this.c);
    }

    public void a(i parami, c paramc) {
        if (this.h) {
            this.g.a(parami, paramc);
        }
        do {
            return;
            if (paramc != c.b) {
                parami.c(this.e);
            }
            if (paramc != c.c) {
                b(parami);
                this.b.clear();
                if (this.d) {
                    this.d = false;
                    if (this.f != null) {
                        this.f.c(false);
                    }
                }
            }
        } while (this.f == null);
        this.f.a(parami, paramc);
    }

    public void a(b paramb) {
        this.f = paramb;
    }

    public void b() {
        if (this.h) {
            this.g.b();
        }
        do {
            i locali;
            do {
                return;
                locali = c();
            } while (locali == null);
            locali.b(this.e);
            i();
            a(locali);
        } while (this.f == null);
        this.f.p();
    }

    public i c() {
        if (this.h) {
            return this.g.c();
        }
        return (i) this.a.d();
    }

    public i d() {
        if (this.h) {
            return this.g.d();
        }
        return (i) this.b.d();
    }

    public void e() {
        if (this.h) {
            this.g.e();
        }
        do {
            i locali;
            do {
                return;
                locali = d();
            } while (locali == null);
            locali.a(this.e);
            h();
            b(locali);
        } while (this.f == null);
        this.f.q();
    }

    public boolean f() {
        if (this.h) {
            if (this.g.a.isEmpty()) {
            }
        }
        while (!this.a.isEmpty()) {
            return true;
            return false;
        }
        return false;
    }

    public boolean g() {
        if (this.h) {
            if (this.g.b.isEmpty()) {
            }
        }
        while (!this.b.isEmpty()) {
            return true;
            return false;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */