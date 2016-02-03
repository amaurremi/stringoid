package com.google.android.gms.a;

import android.util.Log;

class aq
        implements k {
    private int a = 2;

    private String e(String paramString) {
        return Thread.currentThread().toString() + ": " + paramString;
    }

    public int a() {
        return this.a;
    }

    public void a(int paramInt) {
        this.a = paramInt;
    }

    public void a(String paramString) {
        if (this.a <= 0) {
            Log.v("GAV4", e(paramString));
        }
    }

    public void b(String paramString) {
        if (this.a <= 1) {
            Log.i("GAV4", e(paramString));
        }
    }

    public void c(String paramString) {
        if (this.a <= 2) {
            Log.w("GAV4", e(paramString));
        }
    }

    public void d(String paramString) {
        if (this.a <= 3) {
            Log.e("GAV4", e(paramString));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */