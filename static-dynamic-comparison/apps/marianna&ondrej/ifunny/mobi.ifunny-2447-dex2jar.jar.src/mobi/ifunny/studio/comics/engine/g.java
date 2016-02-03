package mobi.ifunny.studio.comics.engine;

import android.os.Handler;
import android.os.SystemClock;

import java.util.concurrent.atomic.AtomicBoolean;

class g
        implements Runnable {
    g(f paramf) {
    }

    public void run() {
        long l2 = SystemClock.uptimeMillis();
        if (f.a(this.a)) {
        }
        for (long l1 = 20L; ; l1 = 250L) {
            l2 = l1 - (SystemClock.uptimeMillis() - l2);
            l1 = l2;
            if (l2 < 0L) {
                l1 = 0L;
            }
            if ((f.b(this.a).get()) && (f.c(this.a) == h.b)) {
                f.d(this.a).postDelayed(this, l1);
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */