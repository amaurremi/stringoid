package com.millennialmedia.android;

final class MMSDK$Event$5
        implements Runnable {
    MMSDK$Event$5(MMAdImpl paramMMAdImpl) {
    }

    public void run() {
        if ((this.a != null) && (this.a.c != null)) {
        }
        try {
            this.a.c.MMAdOverlayClosed(this.a.d());
            return;
        } catch (Exception localException) {
            MMLog.a("MMSDK", "Exception raised in your RequestListener: ", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMSDK$Event$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */