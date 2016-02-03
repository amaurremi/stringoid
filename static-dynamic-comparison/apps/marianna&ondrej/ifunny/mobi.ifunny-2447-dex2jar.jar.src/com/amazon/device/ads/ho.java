package com.amazon.device.ads;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

public class ho {
    private static hr a = new hs();

    public static final <T> void a(AsyncTask<T, ?, ?> paramAsyncTask, T... paramVarArgs) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            cf.a(paramAsyncTask, paramVarArgs);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new hp(paramAsyncTask, paramVarArgs));
    }

    public static void a(Runnable paramRunnable) {
        a.a(paramRunnable);
    }

    public static boolean a() {
        return ht.a().b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */