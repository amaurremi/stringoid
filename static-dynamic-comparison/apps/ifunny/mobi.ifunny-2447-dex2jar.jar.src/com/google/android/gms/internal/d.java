package com.google.android.gms.internal;

import android.os.Handler;

public class d {
    private final Handler a;

    public d(Handler paramHandler) {
        this.a = paramHandler;
    }

    public void a(Runnable paramRunnable) {
        this.a.removeCallbacks(paramRunnable);
    }

    public boolean a(Runnable paramRunnable, long paramLong) {
        return this.a.postDelayed(paramRunnable, paramLong);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */