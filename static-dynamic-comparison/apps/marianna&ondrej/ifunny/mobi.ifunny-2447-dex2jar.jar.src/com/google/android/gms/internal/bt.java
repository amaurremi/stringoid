package com.google.android.gms.internal;

import android.os.Bundle;

@ii
public final class bt {
    public static or<String> a;
    public static or<String> b;
    public static or<Boolean> c;
    public static or<Boolean> d;
    public static or<Boolean> e;
    public static or<String> f;
    public static or<Boolean> g = a("gads:enable_content_fetching", false);
    public static or<Integer> h = a("gads:content_length_weight", 1);
    public static or<Integer> i = a("gads:content_age_weight", 1);
    public static or<Integer> j = a("gads:min_content_len", 11);
    public static or<Integer> k = a("gads:fingerprint_number", 10);
    public static or<Integer> l = a("gads:sleep_sec", 10);
    private static final Bundle m = new Bundle();
    private static boolean n = false;

    static {
        a = a("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
        b = a("gads:sdk_core_experiment_id", (String) null);
        c = a("gads:sdk_crash_report_enabled", false);
        d = a("gads:sdk_crash_report_full_stacktrace", false);
        e = a("gads:block_autoclicks", false);
        f = a("gads:block_autoclicks_experiment_id", (String) null);
        n = true;
    }

    public static Bundle a() {
        return m;
    }

    private static or<Integer> a(String paramString, int paramInt) {
        m.putInt(paramString, paramInt);
        return or.a(paramString, Integer.valueOf(paramInt));
    }

    private static or<String> a(String paramString1, String paramString2) {
        m.putString(paramString1, paramString2);
        return or.a(paramString1, paramString2);
    }

    private static or<Boolean> a(String paramString, boolean paramBoolean) {
        m.putBoolean(paramString, paramBoolean);
        return or.a(paramString, paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */