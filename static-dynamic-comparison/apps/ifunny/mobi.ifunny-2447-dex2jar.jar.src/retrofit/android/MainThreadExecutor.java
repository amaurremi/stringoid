package retrofit.android;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;

public final class MainThreadExecutor
        implements Executor {
    private final Handler handler = new Handler(Looper.getMainLooper());

    public void execute(Runnable paramRunnable) {
        this.handler.post(paramRunnable);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/android/MainThreadExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */