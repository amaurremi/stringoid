package mobi.ifunny.video;

import android.os.Handler;

public class i
        implements Runnable {
    protected i(c paramc) {
    }

    public void run() {
        c.d(this.a).removeCallbacks(this.a.f);
        c.e(this.a).removeCallbacks(this.a.d);
        this.a.b.resetCodec();
        this.a.b.readFrame();
        this.a.a = this.a.b.getCurrentFrameTimeStamp();
        this.a.b.decodeCurrentFrame(100000L);
        this.a.b.getBuffer(this.a.c);
        c.e(this.a).postAtFrontOfQueue(this.a.d);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/video/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */