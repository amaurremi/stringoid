package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.location.Location;
import android.provider.Settings.Secure;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IAadConfig
        implements Serializable {
    private static boolean A = true;
    private static String B;
    private static String m;
    private static int n;
    private static Location o;
    private static String r;
    private static String s;
    private static String t;
    private static String u;
    private static String v;
    private static String w;
    private static String x;
    private static boolean y;
    private static WeakHashMap z;
    private String C;
    private String D;
    private String E;
    private String F;
    private int G;
    private int H;
    private int I;
    private String J;
    private String K;
    private Map L;
    private Integer M;
    private String N;
    private IAresponseData O;
    public String a;
    InneractiveAdView.InternalAdType b;
    int c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private InneractiveAdView.MediationName i;
    private String j;
    private boolean k;
    private boolean l;
    private String p;
    private boolean q;

    IAadConfig(Context paramContext) {
        K();
        if (paramContext != null) {
            String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
            if (str != null) {
                t = c.d(str);
            }
            if (str != null) {
                u = c.e(str);
            }
            str = c.f(paramContext);
            if (str != null) {
                r = c.d(str);
            }
            if (str != null) {
                s = c.e(str);
            }
            f(c.a(paramContext, "AdvertisingIdFile"));
            y = Boolean.parseBoolean(c.a(paramContext, "LimitAdTrackingFile"));
            new IAadConfig .1 (this, paramContext).start();
            str = "";
            if (c.b(paramContext, "MM")) {
                str = "" + "MM";
            }
            B = str;
            v = paramContext.getPackageName();
            w = c.g(paramContext);
            m = new WebView(paramContext).getSettings().getUserAgentString();
        }
    }

    static boolean B() {
        return A;
    }

    static String G() {
        return B;
    }

    static Location H() {
        return o;
    }

    private void K() {
        this.d = -1;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = true;
        this.l = true;
        this.a = null;
        this.b = null;
        this.c = 60;
        m = null;
        x = null;
        n = 628;
        o = null;
        z = null;
        this.q = false;
        r = null;
        s = null;
        t = null;
        u = null;
        v = null;
        w = null;
        this.G = -1;
        this.H = -1;
        this.F = null;
        this.J = null;
        this.M = null;
        this.N = null;
        this.L = null;
        this.O = null;
        this.C = "";
        this.D = "";
        this.E = "";
        this.j = (IAdefines.a + IAdefines.b);
        this.p = (IAdefines.a + IAdefines.b);
        this.i = null;
        B = null;
    }

    static IAadConfig a(IAresponseData paramIAresponseData) {
        if (paramIAresponseData == null) {
            return null;
        }
        return paramIAresponseData.i;
    }

    static void a(Location paramLocation) {
        o = paramLocation;
    }

    static void a(View paramView) {
        if (z == null) {
            z = new WeakHashMap();
        }
        z.put(paramView, Boolean.valueOf(true));
    }

    public static void a(boolean paramBoolean) {
        y = paramBoolean;
    }

    static void b(boolean paramBoolean) {
        InneractiveAdView.Log.v("Inneractive_verbose", "isHardwareAccelerated = " + paramBoolean);
        A = paramBoolean;
    }

    static void c(int paramInt) {
        if (paramInt > 116) {
            n = paramInt;
            return;
        }
        n = 116;
    }

    static void f(String paramString) {
        if (!c.b(paramString)) {
            x = paramString;
            return;
        }
        InneractiveAdView.Log.v("Inneractive_verbose", "The advertising id is empty.");
    }

    static String g() {
        return m;
    }

    static String h() {
        return x;
    }

    public static boolean i() {
        return y;
    }

    static int m() {
        return n;
    }

    static String r() {
        return t;
    }

    static String s() {
        return u;
    }

    static String t() {
        return s;
    }

    static String u() {
        return r;
    }

    static String v() {
        return v;
    }

    static String w() {
        return w;
    }

    public final boolean A() {
        return this.q;
    }

    final String C() {
        return this.C;
    }

    final String D() {
        return this.D;
    }

    final String E() {
        return this.E;
    }

    final InneractiveAdView.MediationName F() {
        return this.i;
    }

    final boolean I() {
        return this.k;
    }

    final boolean J() {
        return this.l;
    }

    final FrameLayout.LayoutParams a(View paramView, Context paramContext) {
        int i3 = 0;
        int i2 = -2;
        int i5 = this.G;
        int i4 = this.H;
        int i1 = i3;
        if (z != null) {
            i1 = i3;
            if (z.get(paramView) != null) {
                i1 = 1;
            }
        }
        if ((i1 != 0) && (i5 > 0) && (i4 > 0)) {
            i2 = c.a(i5, paramContext);
            i1 = c.a(i4, paramContext);
        }
        for (; ; ) {
            return new FrameLayout.LayoutParams(i2, i1, 17);
            if (c.l(paramContext)) {
                i1 = c.a(IAdefines.IAbannerDefaultHeight.d.e, paramContext);
            } else {
                if (c.m(paramContext)) {
                    if (c.n(paramContext) == 1) {
                    }
                    for (float f1 = IAdefines.IAbannerDefaultHeight.b.e; ; f1 = IAdefines.IAbannerDefaultHeight.c.e) {
                        i1 = c.a(f1, paramContext);
                        break;
                    }
                }
                i1 = c.a(IAdefines.IAbannerDefaultHeight.a.e, paramContext);
            }
        }
    }

    final void a() {
        K();
    }

    final void a(int paramInt) {
        if ((paramInt > 0) && (paramInt <= 120)) {
            this.d = paramInt;
            return;
        }
        InneractiveAdView.Log.w("Inneractive_warning", "The Age is invalid. Please use a number between 1 and 120");
    }

    public final void a(InneractiveAdView.Gender paramGender) {
        if (paramGender != null) {
            if (InneractiveAdView.Gender.MALE.equals(paramGender)) {
                this.e = "m";
            }
            while (!InneractiveAdView.Gender.FEMALE.equals(paramGender)) {
                return;
            }
            this.e = "f";
            return;
        }
        InneractiveAdView.Log.w("Inneractive_warning", "The gender is invalid. Please use one of the suggested InneractiveAdView.Gender");
    }

    final void a(InneractiveAdView.MediationName paramMediationName) {
        if (paramMediationName != null) {
            this.i = paramMediationName;
        }
    }

    final void a(String paramString) {
        this.F = paramString;
    }

    final String b() {
        return this.F;
    }

    final void b(int paramInt) {
        if ((paramInt > 0) && (this.i != null)) {
            InneractiveAdView.Log.d("Inneractive_debug", "As the refresh interval should be turned off for mediation, the refresh interval will be set to 0 and autoRefresh will be turned off");
            this.c = 0;
        }
        for (; ; ) {
            InneractiveAdView.Log.d("Inneractive_debug", "refresh interval set to: " + this.c + " seconds.");
            return;
            if ((paramInt >= 15) && (paramInt <= 300)) {
                this.c = paramInt;
                InneractiveAdView.Log.d("Inneractive_debug", "The refreshInterval was set to: " + this.c);
            } else if (paramInt == 0) {
                this.c = 0;
                InneractiveAdView.Log.i("Inneractive_info", "The refreshInterval is 0. setting the refresh interval to be the max (5 minutes)");
            } else if ((paramInt < 15) && (paramInt > 0)) {
                this.c = 15;
                InneractiveAdView.Log.i("Inneractive_info", "The refreshInterval is less than the minimum. setting the refresh interval to the min (15 seconds)");
            } else if (paramInt < 0) {
                this.c = 60;
                InneractiveAdView.Log.w("Inneractive_warning", "The refreshInterval is less than 0. setting the refresh interval to the default (60 seconds)");
            } else if (paramInt > 300) {
                this.c = 300;
                InneractiveAdView.Log.i("Inneractive_info", "The refreshInterval is greater than the maximum available (5 minutes). setting the refresh interval to the max (5 minutes)");
            }
        }
    }

    public final void b(IAresponseData paramIAresponseData) {
        this.O = paramIAresponseData;
    }

    public final void b(String paramString) {
        if (!c.b(paramString)) {
            this.j = (paramString + IAdefines.d);
            this.p = (paramString + IAdefines.d);
            InneractiveAdView.Log.v("Inneractive_verbose", "base url is: " + paramString);
            this.q = true;
        }
    }

    public final String c() {
        return this.f;
    }

    public final void c(String paramString) {
        if (!c.b(paramString)) {
            this.h = paramString;
            InneractiveAdView.Log.v("Inneractive_verbose", "internal portal is: " + paramString);
        }
    }

    final void c(boolean paramBoolean) {
        this.k = paramBoolean;
    }

    public final String d() {
        return this.e;
    }

    final void d(int paramInt) {
        this.G = paramInt;
    }

    public final void d(String paramString) {
        if (!c.b(paramString)) {
            this.f = c.c(paramString);
            return;
        }
        InneractiveAdView.Log.i("Inneractive_info", "No keywords found. For targetting you can add keywords separated by comma.");
    }

    final void d(boolean paramBoolean) {
        this.l = paramBoolean;
    }

    final int e() {
        return this.d;
    }

    final void e(int paramInt) {
        this.H = paramInt;
    }

    public final void e(String paramString) {
        if ((paramString != null) && (Pattern.compile("(^\\d{5}$)|(^\\d{5}-\\d{4}$)").matcher(paramString).matches())) {
            this.g = paramString;
        }
    }

    public final String f() {
        return this.g;
    }

    final void f(int paramInt) {
        this.I = paramInt;
    }

    final void g(String paramString) {
        if (!c.b(paramString)) {
            this.K = paramString;
            return;
        }
        InneractiveAdView.Log.v("Inneractive_verbose", "internal session id is Empty");
    }

    final void h(String paramString) {
        if (!c.b(paramString)) {
            if (this.L == null) {
                this.L = new HashMap();
            }
            paramString = c.c(paramString).split(",");
            int i2 = paramString.length;
            int i1 = 0;
            while (i1 < i2) {
                Object localObject = paramString[i1];
                this.L.put(localObject.split("=")[0], localObject.split("=")[1]);
                i1 += 1;
            }
        }
        InneractiveAdView.Log.v("Inneractive_verbose", "integrated sdk's siteIds list is Empty");
    }

    final void i(String paramString) {
        this.J = paramString;
    }

    final String j() {
        return this.h;
    }

    final void j(String paramString) {
        if ("".equals(this.C)) {
            this.C += paramString;
            return;
        }
        this.C = (this.C + "," + paramString);
    }

    public final String k() {
        return this.j;
    }

    final void k(String paramString) {
        this.C = paramString;
    }

    final String l() {
        return this.p;
    }

    final void l(String paramString) {
        this.D = paramString;
    }

    final void m(String paramString) {
        this.E = paramString;
    }

    final String n() {
        return this.K;
    }

    final Map o() {
        return this.L;
    }

    final int p() {
        return this.G;
    }

    final int q() {
        return this.H;
    }

    final int x() {
        return this.I;
    }

    final String y() {
        return this.J;
    }

    public final IAresponseData z() {
        return this.O;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAadConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */