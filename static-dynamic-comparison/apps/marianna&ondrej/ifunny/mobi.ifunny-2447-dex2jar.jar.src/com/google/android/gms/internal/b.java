package com.google.android.gms.internal;

@ii
public class b {
    private final d a;
    private final Runnable b;
    private av c;
    private boolean d = false;
    private boolean e = false;
    private long f = 0L;

    public b(te paramte) {
        this(paramte, new d(mv.a));
    }

    b(te paramte, d paramd) {
        this.a = paramd;
        this.b = new c(this, paramte);
    }

    public void a() {
        this.d = false;
        this.a.a(this.b);
    }

    public void a(av paramav) {
        a(paramav, 60000L);
    }

    public void a(av paramav, long paramLong) {
        if (this.d) {
            mx.e("An ad refresh is already scheduled.");
        }
        do {
            return;
            this.c = paramav;
            this.d = true;
            this.f = paramLong;
        } while (this.e);
        mx.c("Scheduling ad refresh " + paramLong + " milliseconds from now.");
        this.a.a(this.b, paramLong);
    }

    public void b() {
        this.e = true;
        if (this.d) {
            this.a.a(this.b);
        }
    }

    public void c() {
        this.e = false;
        if (this.d) {
            this.d = false;
            a(this.c, this.f);
        }
    }

    public boolean d() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */