package com.google.android.gms.internal;

class ju
        implements Runnable {
    ju(jq paramjq, jk paramjk) {
    }

    public void run() {
        synchronized (jq.a(this.b)) {
            if (jq.c(this.b).e != -2) {
                return;
            }
            jq.d(this.b).f().a(this.b);
            this.a.a(jq.c(this.b));
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */