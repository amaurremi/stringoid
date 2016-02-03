package com.millennialmedia.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RelativeLayout.LayoutParams;

import java.lang.ref.WeakReference;
import java.util.Map;

abstract class MMAdImpl
        implements MMAd {
    private static long a = 1L;
    protected MMRequest b;
    RequestListener c;
    boolean d = false;
    String e = "28911";
    String f;
    long g;
    long h;
    boolean i;
    WeakReference<Context> j;
    MMAdImplController k;
    MMWebViewClient l;
    MMWebViewClient.MMWebViewClientListener m;
    long n;

    public MMAdImpl(Context paramContext) {
        this.j = new WeakReference(paramContext);
        this.m = new MMAdImpl.BasicWebViewClientListener(this);
        try {
            this.h = a;
            a += 1L;
            MMLog.a("MMAdImpl", String.format("Assigning MMAdImpl internal id: %d", new Object[]{Long.valueOf(this.h)}));
            return;
        } finally {
        }
    }

    static String[] l() {
        return new String[]{"b", "i"};
    }

    void a() {
    }

    void a(Bitmap paramBitmap) {
    }

    void a(Map<String, String> paramMap) {
        Context localContext = j();
        paramMap.put("apid", this.e);
        paramMap.put("do", MMSDK.v(localContext));
        paramMap.put("olock", MMSDK.w(localContext));
        if (!hasCachedVideoSupport()) {
            paramMap.put("cachedvideo", "false");
        }
        paramMap.put("reqtype", o());
        if (this.b != null) {
            this.b.a(paramMap);
        }
        if (HandShake.a(localContext).a(localContext, this.f)) {
            paramMap.put("video", "true");
        }
        while (this.f != null) {
            if ((this.f.equals("b")) || (this.f.equals("i"))) {
                paramMap.put("at", this.f);
                return;
                paramMap.put("video", "false");
            } else {
                MMLog.e("MMAdImpl", "******* ERROR: INCORRECT AD TYPE IN MMADVIEW OBJECT PARAMETERS (" + this.f + ") **********");
                return;
            }
        }
        MMLog.e("MMAdImpl", "******* SDK DEFAULTED TO MMBannerAdBottom. THIS MAY AFFECT THE ADS YOU RECIEVE!!! **********");
        paramMap.put("at", "b");
    }

    void addView(MMWebView paramMMWebView, RelativeLayout.LayoutParams paramLayoutParams) {
    }

    boolean b() {
        return false;
    }

    MMWebViewClient c() {
        MMLog.b("MMAdImpl", "Returning a client for user: DefaultWebViewClient, adimpl=" + this);
        return new BannerWebViewClient(this.m, new MMAdImpl.MMAdImplRedirectionListenerImpl(this));
    }

    abstract MMAd d();

    int e() {
        return -1;
    }

    void f() {
        MMAdImplController.b(this);
        if (this.k != null) {
            this.k.a();
        }
    }

    boolean g() {
        if (MMSDK.b) {
            MMLog.b("MMAdImpl", "Minimum adrefresh time ignored");
            return true;
        }
        long l1 = System.currentTimeMillis();
        int i1 = (int) ((l1 - this.g) / 1000L);
        long l2 = HandShake.a(j()).h;
        if (i1 >= l2) {
            this.g = l1;
            return true;
        }
        MMLog.b("MMAdImpl", String.format("Cannot request ad. Last ad request was %d seconds ago. Next ad can be requested in %d seconds.", new Object[]{Integer.valueOf(i1), Long.valueOf(l2 - i1)}));
        return false;
    }

    public String getApid() {
        return this.e;
    }

    public boolean getIgnoresDensityScaling() {
        return this.d;
    }

    public RequestListener getListener() {
        return this.c;
    }

    public MMRequest getMMRequest() {
        return this.b;
    }

    boolean h() {
        return false;
    }

    public boolean hasCachedVideoSupport() {
        return true;
    }

    void i() {
    }

    public boolean isBanner() {
        return false;
    }

    Context j() {
        if (this.j != null) {
            return (Context) this.j.get();
        }
        return null;
    }

    String k() {
        if ((this.f != null) && (this.e != null)) {
            return this.f + "_" + this.e;
        }
        return null;
    }

    String m() {
        return "millennialmedia.action.ACTION_FETCH_FAILED";
    }

    String n() {
        return "millennialmedia.action.ACTION_FETCH_SUCCEEDED";
    }

    String o() {
        return "fetch";
    }

    void p() {
        if (this.k != null) {
            this.k.d();
        }
    }

    boolean q() {
        return false;
    }

    void removeView(MMWebView paramMMWebView) {
    }

    public void setApid(String paramString) {
        if ((paramString != null) && (!paramString.isEmpty())) {
            HandShake.a = paramString;
        }
        this.e = paramString;
    }

    void setClickable(boolean paramBoolean) {
    }

    public void setIgnoresDensityScaling(boolean paramBoolean) {
        this.d = paramBoolean;
    }

    public void setListener(RequestListener paramRequestListener) {
        this.c = paramRequestListener;
    }

    public void setMMRequest(MMRequest paramMMRequest) {
        this.b = paramMMRequest;
    }

    public String toString() {
        return "AdType[(" + this.f + ") InternalId(" + this.h + ") LinkedId(" + this.n + ") isFinishing(" + this.i + ")]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMAdImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */