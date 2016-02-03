package fr.castorflex.android.smoothprogressbar;

import android.os.SystemClock;

class l
        implements Runnable {
    l(k paramk) {
    }

    public void run() {
        if (this.a.c()) {
            k.a(this.a, k.a(this.a) * 0.01F);
            k.b(this.a, k.a(this.a) * 0.01F);
            if (k.b(this.a) >= 1.0F) {
                this.a.stop();
            }
        }
        for (; ; ) {
            if (k.e(this.a) >= k.f(this.a)) {
                k.a(this.a, true);
                k.c(this.a, k.f(this.a));
            }
            this.a.scheduleSelf(k.g(this.a), SystemClock.uptimeMillis() + 16L);
            this.a.invalidateSelf();
            return;
            if (this.a.b()) {
                k.b(this.a, k.c(this.a) * 0.01F);
            } else {
                k.b(this.a, k.d(this.a) * 0.01F);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/fr/castorflex/android/smoothprogressbar/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */