package com.google.android.gms.a;

class am
        extends Thread {
    am(al paramal, String paramString) {
        super(paramString);
    }

    public void run() {
        synchronized (al.a(this.a)) {
            al.a(this.a, this.a.d());
            al.a(this.a, true);
            al.a(this.a).notifyAll();
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */