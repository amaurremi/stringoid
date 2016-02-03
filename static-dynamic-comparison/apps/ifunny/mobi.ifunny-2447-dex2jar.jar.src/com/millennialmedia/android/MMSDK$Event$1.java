package com.millennialmedia.android;

final class MMSDK$Event$1
        implements Runnable {
    MMSDK$Event$1(String paramString) {
    }

    public void run() {
        HttpGetRequest localHttpGetRequest = new HttpGetRequest();
        try {
            localHttpGetRequest.a(this.a);
            return;
        } catch (Exception localException) {
            MMLog.a(MMSDK.Event.a, "Error logging event: ", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMSDK$Event$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */