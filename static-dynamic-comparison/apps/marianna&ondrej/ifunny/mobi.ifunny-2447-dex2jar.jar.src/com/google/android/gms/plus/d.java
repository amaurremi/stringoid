package com.google.android.gms.plus;

import com.google.android.gms.common.api.t;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.internal.rn;
import com.google.android.gms.internal.rq;
import com.google.android.gms.internal.rr;
import com.google.android.gms.internal.rs;
import com.google.android.gms.internal.rt;
import com.google.android.gms.plus.internal.i;

public final class d {
    public static final com.google.android.gms.common.api.d<i> a = new com.google.android.gms.common.api.d();
    static final com.google.android.gms.common.api.c<i, f> b = new e();
    public static final com.google.android.gms.common.api.a<f> c = new com.google.android.gms.common.api.a(b, a, new t[0]);
    public static final t d = new t("https://www.googleapis.com/auth/plus.login");
    public static final t e = new t("https://www.googleapis.com/auth/plus.me");
    public static final b f = new rs();
    public static final c g = new rt();
    public static final a h = new rn();
    public static final k i = new rr();
    public static final j j = new rq();

    public static i a(com.google.android.gms.common.api.k paramk, com.google.android.gms.common.api.d<i> paramd) {
        boolean bool2 = true;
        if (paramk != null) {
            bool1 = true;
            ag.b(bool1, "GoogleApiClient parameter is required.");
            ag.a(paramk.c(), "GoogleApiClient must be connected.");
            paramk = (i) paramk.a(paramd);
            if (paramk == null) {
                break label55;
            }
        }
        label55:
        for (boolean bool1 = bool2; ; bool1 = false) {
            ag.a(bool1, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
            return paramk;
            bool1 = false;
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/plus/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */