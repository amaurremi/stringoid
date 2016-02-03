package android.support.v4.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class s
        implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    public Thread newThread(Runnable paramRunnable) {
        return new Thread(paramRunnable, "ModernAsyncTask #" + this.a.getAndIncrement());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */