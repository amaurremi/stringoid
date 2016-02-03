package mobi.ifunny.video;

import java.util.concurrent.atomic.AtomicBoolean;

public class g
        implements Runnable {
    protected g(c paramc) {
    }

    public void run() {
        if (!c.b(this.a).get()) {
            this.a.invalidateSelf();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/video/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */