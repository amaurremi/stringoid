package com.inneractive.api.ads.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;

public class InneractiveAdView
        extends FrameLayout {
    protected IAadViewController a;
    boolean b = true;
    boolean c = false;
    private h d;
    private Context e;
    private BroadcastReceiver f;
    private boolean g;
    private boolean h = true;
    private InneractiveAdView.InneractiveBannerAdListener i;
    private boolean j = false;
    private boolean k = true;

    public InneractiveAdView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.e = paramContext;
        this.a = g.a(paramContext, this);
        if (paramAttributeSet != null) {
            String str = "http://schemas.android.com/apk/res/" + paramContext.getPackageName();
            this.a.b(paramAttributeSet.getAttributeValue(str, "appId"));
            this.a.a(paramAttributeSet.getAttributeValue(str, "keywords"));
            this.a.c(paramAttributeSet.getAttributeValue(str, "zipCode"));
            this.a.b(paramAttributeSet.getAttributeIntValue(str, "age", -1));
            this.a.c(paramAttributeSet.getAttributeIntValue(str, "refreshInterval", -1));
            int m = paramAttributeSet.getAttributeIntValue(str, "adType", -1);
            if ((m >= 0) && (m <= 1)) {
                this.a.a(InneractiveAdView.InternalAdType.values()[m]);
            }
            m = paramAttributeSet.getAttributeIntValue(str, "mediationName", -1);
            if ((m >= 0) && (m <= 2)) {
                this.a.a(InneractiveAdView.MediationName.values()[m]);
            }
            m = paramAttributeSet.getAttributeIntValue(str, "gender", -1);
            if ((m >= 0) && (m <= 1)) {
                this.a.a(InneractiveAdView.Gender.values()[m]);
            }
        }
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (WebViewDatabase.getInstance(paramContext) == null) {
            InneractiveAdView.Log.v("Inneractive_verbose", "Could not proceed :-(. http://code.google.com/p/android/issues/detail?id=10789");
        }
    }

    public InneractiveAdView(Context paramContext, String paramString, InneractiveAdView.AdType paramAdType) {
        this(paramContext, paramString, InneractiveAdView.AdType.a(paramAdType));
    }

    InneractiveAdView(Context paramContext, String paramString, InneractiveAdView.InternalAdType paramInternalAdType) {
        this(paramContext, null);
        this.a.b(paramString);
        this.a.a(paramInternalAdType);
        if ((IAdefines.ApiLevel.a().equals(IAdefines.ApiLevel.a)) || (IAdefines.ApiLevel.a().equals(IAdefines.ApiLevel.b))) {
            IAadConfig.b(true);
        }
        do {
            return;
            paramContext = (Activity) paramContext;
        } while (paramContext == null);
        IAadConfig.b(c.a(paramContext));
    }

    void a() {
        if (this.a != null) {
            this.a.a();
        }
    }

    final void a(View paramView) {
        if (this.a != null) {
            this.a.a(paramView);
        }
    }

    protected final void a(IAdefines.IAIntegratedSdksTrackingAction paramIAIntegratedSdksTrackingAction) {
        InneractiveAdView.Log.v("Inneractive_verbose", "Tracking native action. ");
        if (this.a != null) {
            new Thread(new IAadViewController .4 (this.a, paramIAIntegratedSdksTrackingAction)).start();
        }
    }

    void a(IAresponseData paramIAresponseData) {
        if (this.a == null) {
            return;
        }
        if (paramIAresponseData == null) {
            InneractiveAdView.Log.d("Inneractive_debug", "Couldn't load ad because the server did not specify one.");
            b(InneractiveAdView.InneractiveErrorCode.SDK_INTERNAL_ERROR);
            return;
        }
        if (this.d != null) {
            this.d.j();
        }
        this.d = i.a(this, paramIAresponseData);
        this.d.i();
    }

    protected final void a(InneractiveAdView.InneractiveErrorCode paramInneractiveErrorCode) {
        InneractiveAdView.Log.v("Inneractive_verbose", "Error Code: " + paramInneractiveErrorCode);
        if (InneractiveAdView.InneractiveErrorCode.NO_FILL.equals(paramInneractiveErrorCode)) {
            if (this.a != null) {
                this.a.l().h = "inneractive_mraid";
                a(this.a.l());
            }
            return;
        }
        b(paramInneractiveErrorCode);
    }

    final void a(boolean paramBoolean) {
        if (this.a != null) {
            this.a.c(false);
        }
    }

    Integer b() {
        if (this.a != null) {
            return this.a.o();
        }
        return null;
    }

    protected void b(InneractiveAdView.InneractiveErrorCode paramInneractiveErrorCode) {
        InneractiveAdView.Log.v("Inneractive_verbose", "adFailed");
        this.c = false;
        if (this.i != null) {
            this.i.inneractiveBannerFailed(this, paramInneractiveErrorCode);
        }
        if ((InneractiveAdView.InneractiveErrorCode.INVALID_INPUT.equals(paramInneractiveErrorCode)) || (InneractiveAdView.InneractiveErrorCode.UNKNOWN_APP_ID.equals(paramInneractiveErrorCode))) {
            this.a.c(false);
            return;
        }
        this.a.a(15000);
    }

    protected final void c() {
        if (this.a != null) {
            new Thread(new IAadViewController .3 (this.a)).start();
        }
    }

    protected void d() {
        InneractiveAdView.Log.v("Inneractive_verbose", "adLoaded");
        this.c = false;
        if ((this.a != null) && (this.a.m() != null)) {
            String str = this.a.m().D();
            if ((str != null) && (!"".equals(str))) {
                a(IAdefines.IAIntegratedSdksTrackingAction.a);
            }
        }
        if (this.i != null) {
            this.i.inneractiveBannerLoaded(this);
        }
        this.a.a(this.a.g() * 1000);
    }

    public void destroy() {
        try {
            this.e.unregisterReceiver(this.f);
            removeAllViews();
            if (this.a != null) {
                this.a.n();
                this.a = null;
            }
            if (this.d != null) {
                this.d.j();
                this.d = null;
            }
            return;
        } catch (Exception localException) {
            for (; ; ) {
                InneractiveAdView.Log.v("Inneractive_verbose", "Broadcast receiver was not registered and therfore won't be released.");
            }
        }
    }

    protected void e() {
        InneractiveAdView.Log.v("Inneractive_verbose", "defaultAdLoaded");
        this.c = false;
        if ((this.a != null) && (this.a.m() != null)) {
            String str = this.a.m().D();
            if ((str != null) && (!"".equals(str))) {
                a(IAdefines.IAIntegratedSdksTrackingAction.a);
            }
        }
        if (this.i != null) {
            this.i.inneractiveDefaultBannerLoaded(this);
        }
        this.a.a(this.a.g() * 1000);
    }

    protected final void f() {
        InneractiveAdView.Log.v("Inneractive_verbose", "adExpanded");
        this.j = true;
        this.c = false;
        if (this.i != null) {
            this.i.inneractiveBannerExpanded(this);
        }
        this.a.c(false);
    }

    public void forceRefresh() {
        if ((this instanceof InneractiveInterstitialView)) {
            InneractiveAdView.Log.i("Inneractive_info", "The option to set the refresh interval for is available ONLY for banner/rectangle!");
        }
        do {
            return;
            if (this.d != null) {
                this.d.j();
                this.d = null;
            }
        } while (this.a == null);
        this.a.b();
    }

    protected final void g() {
        InneractiveAdView.Log.v("Inneractive_verbose", "adCollapsed");
        this.j = false;
        this.c = false;
        if (this.i != null) {
            this.i.inneractiveBannerCollapsed(this);
        }
        boolean bool = ((PowerManager) this.e.getSystemService("power")).isScreenOn();
        if ((isShown()) && (bool)) {
            this.a.c(true);
            return;
        }
        this.a.a(1000);
    }

    public int getAdHeight() {
        if (this.a != null) {
            return this.a.j();
        }
        return 0;
    }

    public int getAdWidth() {
        if (this.a != null) {
            return this.a.i();
        }
        return 0;
    }

    public int getAge() {
        if (this.a != null) {
            return this.a.f();
        }
        return -1;
    }

    public InneractiveAdView.InneractiveBannerAdListener getBannerAdListener() {
        return this.i;
    }

    public String getGender() {
        if (this.a != null) {
            return this.a.e();
        }
        return null;
    }

    public String getKeywords() {
        if (this.a != null) {
            return this.a.d();
        }
        return null;
    }

    public int getRefreshInterval() {
        if (this.a != null) {
            return this.a.g();
        }
        return -1;
    }

    public String getSDKversion() {
        return "5.0.1";
    }

    public String getZipCode() {
        if (this.a != null) {
            return this.a.h();
        }
        return null;
    }

    protected final void h() {
        InneractiveAdView.Log.v("Inneractive_verbose", "adResized");
        this.c = false;
        if (this.i != null) {
            this.i.inneractiveBannerResized(this);
        }
    }

    protected void i() {
        InneractiveAdView.Log.v("Inneractive_verbose", "adClicked");
        this.c = true;
        if ((this.a != null) && (this.a.m() != null)) {
            String str = this.a.m().E();
            if ((str != null) && (!"".equals(str)) && (!"IA".equals(str))) {
                a(IAdefines.IAIntegratedSdksTrackingAction.b);
            }
        }
        if (this.i != null) {
            this.i.inneractiveBannerClicked(this);
        }
    }

    protected void j() {
        InneractiveAdView.Log.v("Inneractive_verbose", "applicationInTheBackground");
        if (this.i != null) {
            this.i.inneractiveAdWillOpenExternalApp(this);
        }
    }

    protected void k() {
        InneractiveAdView.Log.v("Inneractive_verbose", "intenalBrowserDissmissed");
        if (this.i != null) {
            this.i.inneractiveInternalBrowserDismissed(this);
        }
    }

    final Activity l() {
        return (Activity) this.e;
    }

    public void loadAd() {
        this.b = true;
        if (!(this instanceof InneractiveInterstitialView)) {
            InneractiveAdView.Log.v("Inneractive_verbose", "register to screen state broadcast receiver");
            if ((this.a != null) && (!(this instanceof InneractiveInterstitialView))) {
                this.f = new InneractiveAdView .1 (this);
                IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
                localIntentFilter.addAction("android.intent.action.SCREEN_ON");
                localIntentFilter.addAction("android.intent.action.USER_PRESENT");
                this.e.registerReceiver(this.f, localIntentFilter);
            }
        }
        a();
    }

    final boolean m() {
        if (this.a != null) {
            return this.a.k();
        }
        InneractiveAdView.Log.v("Inneractive_verbose", "Can't get auto refresh status");
        return false;
    }

    final IAadViewController n() {
        return this.a;
    }

    protected void onWindowVisibilityChanged(int paramInt) {
        InneractiveAdView.Log.v("Inneractive_verbose", "onWindowVisibilityChanged");
        if (this.a == null) {
        }
        while ((this instanceof InneractiveInterstitialView)) {
            return;
        }
        if ((paramInt == 0) && (!this.j) && (!this.k)) {
            InneractiveAdView.Log.v("Inneractive_verbose", "Enable Refresh (ad is visible).");
            this.g = true;
            this.a.c(true);
            return;
        }
        if ((paramInt == 0) && (!this.j) && (this.k)) {
            this.g = true;
            this.k = false;
            return;
        }
        InneractiveAdView.Log.v("Inneractive_verbose", "Refresh Disabled (ad is invisible).");
        if (!this.c) {
            this.g = false;
        }
        this.a.c(false);
    }

    public void setAge(int paramInt) {
        if (this.a != null) {
            this.a.b(paramInt);
        }
    }

    public void setAndroidIdEnabled(boolean paramBoolean) {
        if (this.a != null) {
            this.a.a(paramBoolean);
        }
    }

    public void setBannerAdListener(InneractiveAdView.InneractiveBannerAdListener paramInneractiveBannerAdListener) {
        this.i = paramInneractiveBannerAdListener;
    }

    public void setDeviceIdEnabled(boolean paramBoolean) {
        if (this.a != null) {
            this.a.b(paramBoolean);
        }
    }

    public void setGender(InneractiveAdView.Gender paramGender) {
        if (this.a != null) {
            this.a.a(paramGender);
        }
    }

    public void setKeywords(String paramString) {
        if (this.a != null) {
            this.a.a(paramString);
        }
    }

    public void setMediationName(InneractiveAdView.MediationName paramMediationName) {
        if ((this.a != null) && (paramMediationName != null)) {
            this.a.a(paramMediationName);
            InneractiveAdView.Log.i("Inneractive_info", "Setting the mediation Name to: " + paramMediationName + " as the refresh interval should be turned off for mediation, the refresh interval will be set to 0 and autoRefresh will be turned off");
            this.a.c(false);
            this.a.c(0);
        }
    }

    public void setRefreshInterval(int paramInt) {
        if ((this instanceof InneractiveInterstitialView)) {
            InneractiveAdView.Log.i("Inneractive_info", "The option to set the refresh interval for is available ONLY for banner/rectangle!");
        }
        while (this.a == null) {
            return;
        }
        this.a.c(paramInt);
    }

    public void setZipCode(String paramString) {
        if (this.a != null) {
            this.a.c(paramString);
        }
    }

    public void testEnvironmentConfigurationName(String paramString) {
        if (this.a != null) {
            this.a.d(paramString);
        }
    }

    public void testEnvironmentConfigurationNumber(String paramString) {
        if (this.a != null) {
            this.a.e(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/InneractiveAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */