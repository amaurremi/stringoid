package a;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;

class c
        implements Executor {
    public void execute(Runnable paramRunnable) {
        new Handler(Looper.getMainLooper()).post(paramRunnable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */