package mobi.ifunny.video;

import android.os.Handler;

import java.util.concurrent.atomic.AtomicBoolean;

public class e
        implements Runnable {
    protected e(c paramc) {
    }

    public void run() {
        if (c.b(this.a).get()) {
        }
        this.a.b.getBuffer(this.a.c);
        c.e(this.a).postAtFrontOfQueue(this.a.d);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/video/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */