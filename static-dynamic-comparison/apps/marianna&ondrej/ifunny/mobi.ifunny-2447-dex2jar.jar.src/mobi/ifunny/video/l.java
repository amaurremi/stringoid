package mobi.ifunny.video;

import android.os.Handler;
import android.os.SystemClock;

import java.util.concurrent.atomic.AtomicBoolean;

public class l
        implements Runnable {
    protected l(c paramc) {
    }

    public void run() {
        if (c.b(this.a).get()) {
        }
        long l1 = SystemClock.uptimeMillis();
        if (!this.a.b.readFrameLooped()) {
            this.a.a = 0L;
        }
        long l2 = this.a.b.getCurrentFrameTimeStamp();
        long l3 = Math.max(20L, Math.round((float) (l2 - this.a.a) / c.c(this.a)));
        long l4 = Math.max(l3 - (SystemClock.uptimeMillis() - l1), 10L);
        this.a.b.decodeCurrentFrame(l4 * 800L);
        this.a.a = l2;
        l1 = l1 + l3 - SystemClock.uptimeMillis();
        c.d(this.a).postDelayed(this.a.f, l1);
        c.d(this.a).postDelayed(this.a.e, l1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/video/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */