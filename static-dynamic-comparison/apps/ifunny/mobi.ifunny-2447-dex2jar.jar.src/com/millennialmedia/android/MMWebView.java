package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.json.JSONObject;

class MMWebView
        extends WebView {
    long a;
    volatile boolean b;
    volatile String c;
    boolean d = true;
    final String e;
    final GestureDetector f;
    volatile boolean g;
    String h;
    int i;
    volatile boolean j;
    int k = -50;
    int l = -50;
    volatile boolean m = false;
    boolean n = false;
    boolean o = false;
    private HttpMMHeaders p;

    public MMWebView(Context paramContext, long paramLong) {
        super(paramContext);
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnTouchListener(new MMWebView.WebTouchListener(this));
        this.c = "loading";
        this.a = paramLong;
        MMLog.a("MMWebView", String.format("Assigning WebView internal id: %d", new Object[]{Long.valueOf(this.a)}));
        setId((int) (15063L + this.a));
        if (HandShake.a(paramContext).e) {
            c();
        }
        for (; ; ) {
            setWebChromeClient(new MMWebView.MyWebChromeClient(this));
            WebSettings localWebSettings = getSettings();
            this.e = localWebSettings.getUserAgentString();
            localWebSettings.setJavaScriptEnabled(true);
            localWebSettings.setCacheMode(-1);
            localWebSettings.setDefaultTextEncodingName("UTF-8");
            localWebSettings.setLoadWithOverviewMode(true);
            localWebSettings.setGeolocationEnabled(true);
            if (Build.VERSION.SDK_INT >= 17) {
                MMLog.c("MMWebView", "Disabling user gesture requirement for media playback");
                localWebSettings.setMediaPlaybackRequiresUserGesture(false);
            }
            localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
            this.f = new GestureDetector(paramContext.getApplicationContext(), new MMWebView.BannerGestureListener(this));
            return;
            a();
        }
    }

    private boolean B() {
        int i1 = Integer.parseInt(Build.VERSION.SDK);
        return ("Nexus S".equals(Build.MODEL)) && ("samsung".equals(Build.MANUFACTURER)) && ((i1 == 16) || (i1 == 17));
    }

    private boolean C() {
        return (this.l == -50) && (this.k == -50);
    }

    private boolean D() {
        return k() == null;
    }

    void A() {
        this.d = true;
    }

    void a() {
        if (Build.VERSION.SDK_INT >= 11) {
            MMLog.c("MMWebView", "Disabling acceleration");
            setLayerType(0, null);
        }
    }

    void a(DTOResizeParameters paramDTOResizeParameters) {
        try {
            if (MMSDK.c()) {
                MMAdView localMMAdView = g();
                this.j = false;
                MMLog.b("MMWebView", "New DTOResizeParameters = " + paramDTOResizeParameters);
                if (localMMAdView != null) {
                    MMSDK.a(new MMWebView .4 (this, localMMAdView, paramDTOResizeParameters));
                }
            }
            return;
        } finally {
        }
    }

    void a(HttpMMHeaders paramHttpMMHeaders) {
        this.p = paramHttpMMHeaders;
    }

    void a(MMAdImpl paramMMAdImpl) {
        paramMMAdImpl = new FutureTask(new MMWebView .3 (this, paramMMAdImpl));
        MMSDK.a(paramMMAdImpl);
        try {
            paramMMAdImpl.get();
            return;
        } catch (InterruptedException paramMMAdImpl) {
        } catch (ExecutionException paramMMAdImpl) {
        }
    }

    void a(String paramString1, String paramString2, Context paramContext) {
        if ((paramString1 == null) || (paramString2 == null)) {
            return;
        }
        String str = paramString2.substring(0, paramString2.lastIndexOf("/") + 1);
        d();
        if (MRaid.c(paramContext)) {
        }
        for (paramContext = MRaid.a(paramContext, paramString1); ; paramContext = paramString1) {
            if (MMSDK.a >= 5) {
                MMLog.a("MMWebView", String.format("Received ad with base url %s.", new Object[]{paramString2}));
                MMLog.a("MMWebView", paramString1);
            }
            MMSDK.a(new MMWebView .2 (this, str, paramContext));
            return;
            MMLog.e("MMWebView", "MMJS is not downloaded");
        }
    }

    void a(String paramString1, String paramString2, MMAdImpl paramMMAdImpl) {
        if ((paramString1 == null) || (paramString2 == null) || (paramMMAdImpl == null)) {
            return;
        }
        b(paramMMAdImpl);
        d();
        String str = paramString2.substring(0, paramString2.lastIndexOf("/") + 1);
        if (MMSDK.a >= 5) {
            MMLog.a("MMWebView", String.format("Received ad with base url %s.", new Object[]{str}));
            MMLog.a("MMWebView", paramString1);
        }
        if (paramMMAdImpl.h()) {
            a(paramMMAdImpl);
        }
        paramString2 = paramString1;
        if (paramMMAdImpl.d) {
            paramString2 = "<head><meta name=\"viewport\" content=\"target-densitydpi=device-dpi\" /></head>" + paramString1;
        }
        if (MRaid.c(paramMMAdImpl.j())) {
            paramString2 = MRaid.a(paramMMAdImpl.j(), paramString2);
        }
        for (; ; ) {
            MMSDK.a(new MMWebView .1 (this, paramMMAdImpl, str, paramString2));
            return;
            MMLog.e("MMWebView", "MMJS is not downloaded");
        }
    }

    void a(Map<String, String> paramMap) {
        if (e()) {
        }
        for (String str = "true"; ; str = "false") {
            paramMap.put("PROPERTY_BANNER_TYPE", str);
            paramMap.put("PROPERTY_STATE", this.c);
            paramMap.put("PROPERTY_EXPANDING", String.valueOf(this.a));
            return;
        }
    }

    boolean a(long paramLong) {
        ViewParent localViewParent = getParent();
        if (localViewParent == null) {
            return false;
        }
        MMLog.d("MMWebView", "Id check for parent: " + paramLong + " versus " + ((MMLayout) localViewParent).h.h);
        if (paramLong == ((MMLayout) localViewParent).h.h) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    boolean a(String paramString) {
        return ((!TextUtils.isEmpty(this.h)) && (paramString.equals(this.h + "?"))) || (paramString.equals(this.h + "#"));
    }

    void b() {
        if (!B()) {
        }
        try {
            WebView.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{Integer.valueOf(1), null});
            MMLog.b("MMWebView", "Enable softwareAcceleration");
            return;
        } catch (Exception localException) {
        }
    }

    void b(MMAdImpl paramMMAdImpl) {
        try {
            if ((MMSDK.c()) && (w()) && (paramMMAdImpl != null)) {
                paramMMAdImpl = paramMMAdImpl.d();
                if ((paramMMAdImpl instanceof MMAdView)) {
                    paramMMAdImpl = (MMAdView) paramMMAdImpl;
                    this.j = true;
                    MMSDK.a(new MMWebView .5 (this, paramMMAdImpl));
                }
            }
            return;
        } finally {
        }
    }

    void c() {
        if (!B()) {
        }
        try {
            WebView.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{Integer.valueOf(2), null});
            MMLog.b("MMWebView", "Enabled hardwareAcceleration");
            return;
        } catch (Exception localException) {
        }
    }

    void d() {
        BridgeMMSpeechkit.a();
        this.n = false;
        this.o = false;
    }

    boolean e() {
        if (getParent() != null) {
            return (ViewGroup) getParent() instanceof MMAdView;
        }
        return false;
    }

    boolean f() {
        return getParent() instanceof MMAdView;
    }

    MMAdView g() {
        if ((getParent() instanceof MMAdView)) {
            return (MMAdView) getParent();
        }
        return null;
    }

    MMLayout h() {
        if ((getParent() instanceof MMLayout)) {
            return (MMLayout) getParent();
        }
        return null;
    }

    /* Error */
    Activity i() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: invokevirtual 358	com/millennialmedia/android/MMWebView:getParent	()Landroid/view/ViewParent;
        //   6: astore_1
        //   7: aload_1
        //   8: ifnull +38 -> 46
        //   11: aload_1
        //   12: instanceof 436
        //   15: ifeq +31 -> 46
        //   18: aload_1
        //   19: checkcast 436	android/view/ViewGroup
        //   22: invokevirtual 441	android/view/ViewGroup:getContext	()Landroid/content/Context;
        //   25: astore_1
        //   26: aload_1
        //   27: ifnull +19 -> 46
        //   30: aload_1
        //   31: instanceof 443
        //   34: ifeq +12 -> 46
        //   37: aload_1
        //   38: checkcast 443	com/millennialmedia/android/MMActivity
        //   41: astore_1
        //   42: aload_0
        //   43: monitorexit
        //   44: aload_1
        //   45: areturn
        //   46: aconst_null
        //   47: astore_1
        //   48: goto -6 -> 42
        //   51: astore_1
        //   52: aload_0
        //   53: monitorexit
        //   54: aload_1
        //   55: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	56	0	this	MMWebView
        //   6	42	1	localObject1	Object
        //   51	4	1	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   2	7	51	finally
        //   11	26	51	finally
        //   30	42	51	finally
    }

    /* Error */
    AdViewOverlayView j() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: invokevirtual 358	com/millennialmedia/android/MMWebView:getParent	()Landroid/view/ViewParent;
        //   6: astore_1
        //   7: aload_1
        //   8: ifnull +19 -> 27
        //   11: aload_1
        //   12: instanceof 446
        //   15: ifeq +12 -> 27
        //   18: aload_1
        //   19: checkcast 446	com/millennialmedia/android/AdViewOverlayView
        //   22: astore_1
        //   23: aload_0
        //   24: monitorexit
        //   25: aload_1
        //   26: areturn
        //   27: aconst_null
        //   28: astore_1
        //   29: goto -6 -> 23
        //   32: astore_1
        //   33: aload_0
        //   34: monitorexit
        //   35: aload_1
        //   36: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	37	0	this	MMWebView
        //   6	23	1	localObject1	Object
        //   32	4	1	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   2	7	32	finally
        //   11	23	32	finally
    }

    /* Error */
    MMAdView k() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: invokevirtual 358	com/millennialmedia/android/MMWebView:getParent	()Landroid/view/ViewParent;
        //   6: astore_1
        //   7: aload_1
        //   8: ifnull +19 -> 27
        //   11: aload_1
        //   12: instanceof 423
        //   15: ifeq +12 -> 27
        //   18: aload_1
        //   19: checkcast 423	com/millennialmedia/android/MMAdView
        //   22: astore_1
        //   23: aload_0
        //   24: monitorexit
        //   25: aload_1
        //   26: areturn
        //   27: aconst_null
        //   28: astore_1
        //   29: goto -6 -> 23
        //   32: astore_1
        //   33: aload_0
        //   34: monitorexit
        //   35: aload_1
        //   36: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	37	0	this	MMWebView
        //   6	23	1	localObject1	Object
        //   32	4	1	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   2	7	32	finally
        //   11	23	32	finally
    }

    void l() {
        loadUrl("javascript:MMJS.sdk.setPlacementType('interstitial');");
    }

    public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        this.h = paramString1;
        try {
            super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
            return;
        } catch (Exception paramString1) {
            MMLog.a("MMWebView", "Error hit when calling through to loadDataWithBaseUrl", paramString1);
        }
    }

    public void loadUrl(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return;
        }
        if (paramString.startsWith("http")) {
            this.h = paramString;
        }
        MMLog.a("MMWebView", "loadUrl @@" + paramString);
        if (MMSDK.a()) {
            try {
                super.loadUrl(paramString);
                return;
            } catch (Exception paramString) {
                return;
            }
        }
        MMSDK.a(new MMWebView .6 (this, paramString));
    }

    void m() {
        loadUrl("javascript:MMJS.sdk.setPlacementType('inline');");
    }

    void n() {
        loadUrl("javascript:MMJS.sdk.setState('default')");
        this.c = "default";
        this.d = true;
    }

    void o() {
        loadUrl("javascript:MMJS.sdk.setState('hidden')");
        this.c = "hidden";
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        int i1 = View.MeasureSpec.getSize(paramInt1);
        paramInt1 = getMeasuredHeight();
        if (paramInt1 == 0) {
            paramInt1 = paramInt2;
        }
        for (; ; ) {
            if (this.g) {
                setMeasuredDimension(1, 1);
                return;
            }
            setMeasuredDimension(i1, paramInt1);
            return;
        }
    }

    public void onPauseWebView() {
        if (Build.VERSION.SDK_INT >= 11) {
        }
        try {
            WebView.class.getMethod("onPause", new Class[0]).invoke(this, new Object[0]);
            return;
        } catch (Exception localException) {
            MMLog.d("MMWebView", "No onPause()");
        }
    }

    public void onResumeWebView() {
        if ((!e()) && (Build.VERSION.SDK_INT >= 19)) {
            Activity localActivity = i();
            if (localActivity != null) {
                localActivity.setRequestedOrientation(14);
            }
        }
        if (Build.VERSION.SDK_INT >= 11) {
        }
        try {
            WebView.class.getMethod("onResume", new Class[0]).invoke(this, new Object[0]);
            return;
        } catch (Exception localException) {
            MMLog.d("MMWebView", "No onResume()");
        }
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if ((getContext().getResources().getDisplayMetrics() != null) && (this.d)) {
            u();
            if ((getHeight() != 1) || (getWidth() != 1)) {
                MMSDK.a(new MMWebView .7 (this), 800L);
            }
        }
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (paramMotionEvent.getAction() == 0) {
            requestFocus();
        }
        if (this.f != null) {
            this.f.onTouchEvent(paramMotionEvent);
        }
        if (paramMotionEvent.getAction() == 1) {
            MMLog.a("MMWebView", String.format("Ad clicked: action=%d x=%f y=%f", new Object[]{Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY())}));
        }
        return super.onTouchEvent(paramMotionEvent);
    }

    void p() {
        loadUrl("javascript:MMJS.sdk.setViewable(false)");
        this.m = false;
    }

    void q() {
        loadUrl("javascript:MMJS.sdk.setViewable(true)");
        this.m = true;
    }

    void r() {
        loadUrl("javascript:MMJS.sdk.setState('expanded');");
        this.c = "expanded";
        this.n = false;
        this.o = false;
        this.d = true;
    }

    void s() {
        loadUrl("javascript:MMJS.sdk.ready();");
    }

    public void setBackgroundColor(int paramInt) {
        this.i = paramInt;
        if (paramInt == 0) {
            b();
        }
        super.setBackgroundColor(paramInt);
    }

    void t() {
        JSONObject localJSONObject = new AdProperties(getContext()).getAdProperties(this);
        loadUrl("javascript:MMJS.sdk.setAdProperties(" + localJSONObject + ");");
    }

    public String toString() {
        return "MMWebView originally from(" + this.a + ") MRaidState(" + this.c + ")." + super.toString();
    }

    void u() {
        JSONObject localJSONObject = Utils.a(this);
        loadUrl("javascript:MMJS.sdk.setAdSize(" + localJSONObject + ");");
    }

    void v() {
        ViewParent localViewParent = getParent();
        if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
            ((ViewGroup) localViewParent).removeView(this);
        }
    }

    boolean w() {
        return "resized".equals(this.c);
    }

    String x() {
        if ((this.p != null) && (!TextUtils.isEmpty(this.p.f))) {
            return this.p.f;
        }
        return "DEFAULT_AD_ID";
    }

    boolean y() {
        boolean bool = true;
        if (this.n) {
            bool = z();
        }
        do {
            return bool;
            this.n = true;
        } while ((D()) && (this.m));
        return false;
    }

    boolean z() {
        return (hasWindowFocus()) && (D());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */