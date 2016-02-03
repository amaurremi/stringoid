package com.google.android.gms.analytics;

import android.text.TextUtils;

class x {
    private String vh;
    private final long vi;
    private final long vj;
    private String vk = "https:";

    x(String paramString, long paramLong1, long paramLong2) {
        this.vh = paramString;
        this.vi = paramLong1;
        this.vj = paramLong2;
    }

    void J(String paramString) {
        this.vh = paramString;
    }

    void K(String paramString) {
        if ((paramString == null) || (TextUtils.isEmpty(paramString.trim()))) {
        }
        while (!paramString.toLowerCase().startsWith("http:")) {
            return;
        }
        this.vk = "http:";
    }

    String cO() {
        return this.vh;
    }

    long cP() {
        return this.vi;
    }

    long cQ() {
        return this.vj;
    }

    String cR() {
        return this.vk;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/analytics/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */