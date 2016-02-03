package android.support.v4.a;

import android.os.Process;

import java.util.concurrent.atomic.AtomicBoolean;

class t
        extends z<Params, Result> {
    t(r paramr) {
        super(null);
    }

    public Result call() {
        r.a(this.a).set(true);
        Process.setThreadPriority(10);
        return (Result) r.a(this.a, this.a.a(this.b));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */