package com.millennialmedia.android;

import java.util.TreeMap;

final class MMConversionTracker$1
        implements Runnable {
    MMConversionTracker$1(String paramString, boolean paramBoolean, long paramLong, TreeMap paramTreeMap) {
    }

    public void run() {
        HttpGetRequest localHttpGetRequest = new HttpGetRequest();
        try {
            localHttpGetRequest.a(this.a, this.b, this.c, this.d);
            return;
        } catch (Exception localException) {
            MMLog.a("MMConversionTracker", "Problem doing conversion tracking.", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMConversionTracker$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */