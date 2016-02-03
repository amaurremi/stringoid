package mobi.ifunny.video;

import java.util.concurrent.atomic.AtomicBoolean;

public class d
        implements Runnable {
    protected d(c paramc) {
    }

    public void run() {
        c.g(this.a);
        if (this.a.b != null) {
            c.h(this.a);
        }
        c.g(this.a);
        c.b(this.a).set(true);
        c.i(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/video/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */