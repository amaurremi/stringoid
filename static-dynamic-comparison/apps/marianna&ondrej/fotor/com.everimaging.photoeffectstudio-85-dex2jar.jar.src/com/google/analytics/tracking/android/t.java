package com.google.analytics.tracking.android;

import android.text.TextUtils;

class t {
    private String a;
    private final long b;
    private final long c;
    private String d = "https:";

    t(String paramString, long paramLong1, long paramLong2) {
        this.a = paramString;
        this.b = paramLong1;
        this.c = paramLong2;
    }

    String a() {
        return this.a;
    }

    void a(String paramString) {
        this.a = paramString;
    }

    long b() {
        return this.b;
    }

    void b(String paramString) {
        if ((paramString == null) || (TextUtils.isEmpty(paramString.trim()))) {
        }
        while (!paramString.toLowerCase().startsWith("http:")) {
            return;
        }
        this.d = "http:";
    }

    long c() {
        return this.c;
    }

    String d() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */