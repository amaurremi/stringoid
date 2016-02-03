package uk.co.a.a.b;

import android.os.Handler;

class h
        implements Runnable {
    h(g paramg) {
    }

    public void run() {
        if (g.a(this.a)) {
            this.a.a(g.b(this.a));
        }
        while (g.c(this.a)) {
            return;
        }
        g.d(this.a).post(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/a/a/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */