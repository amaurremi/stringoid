package com.google.android.gms.tagmanager;

import android.util.Log;

class x
        implements bi {
    private int sz = 5;

    public void b(String paramString, Throwable paramThrowable) {
        if (this.sz <= 6) {
            Log.e("GoogleTagManager", paramString, paramThrowable);
        }
    }

    public void c(String paramString, Throwable paramThrowable) {
        if (this.sz <= 5) {
            Log.w("GoogleTagManager", paramString, paramThrowable);
        }
    }

    public void setLogLevel(int paramInt) {
        this.sz = paramInt;
    }

    public void v(String paramString) {
        if (this.sz <= 3) {
            Log.d("GoogleTagManager", paramString);
        }
    }

    public void w(String paramString) {
        if (this.sz <= 6) {
            Log.e("GoogleTagManager", paramString);
        }
    }

    public void x(String paramString) {
        if (this.sz <= 4) {
            Log.i("GoogleTagManager", paramString);
        }
    }

    public void y(String paramString) {
        if (this.sz <= 2) {
            Log.v("GoogleTagManager", paramString);
        }
    }

    public void z(String paramString) {
        if (this.sz <= 5) {
            Log.w("GoogleTagManager", paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */