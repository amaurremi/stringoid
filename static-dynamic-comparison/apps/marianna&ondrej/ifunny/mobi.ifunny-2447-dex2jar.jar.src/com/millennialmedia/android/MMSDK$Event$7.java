package com.millennialmedia.android;

final class MMSDK$Event$7
        implements Runnable {
    MMSDK$Event$7(MMAdImpl paramMMAdImpl, MMException paramMMException) {
    }

    public void run() {
        if ((this.a != null) && (this.a.c != null)) {
        }
        try {
            this.a.c.requestFailed(this.a.d(), this.b);
            return;
        } catch (Exception localException) {
            MMLog.a("MMSDK", "Exception raised in your RequestListener: ", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMSDK$Event$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */