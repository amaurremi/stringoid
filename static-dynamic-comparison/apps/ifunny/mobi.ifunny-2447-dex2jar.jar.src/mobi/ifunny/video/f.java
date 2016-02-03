package mobi.ifunny.video;

public class f
        implements Runnable {
    protected f(c paramc) {
    }

    public void run() {
        try {
            synchronized (c.a(this.a)) {
                c.a(this.a).wait();
                return;
            }
            return;
        } catch (InterruptedException localInterruptedException) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/video/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */