package com.inmobi.monetization.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.Response;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import com.inmobi.monetization.internal.imai.IMAIController;
import com.inmobi.monetization.internal.imai.IMAIController.InterstitialAdStateListener;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class InterstitialAd
        extends Ad
        implements IMAIController.InterstitialAdStateListener {
    long a = 0L;
    boolean b = true;
    private Activity d;
    private long e;
    private IMWebView f;
    private long g = 0L;
    private Object h = null;
    private Response i = null;
    private boolean j = false;
    private boolean k = false;
    private InterstitialAd.b l = new InterstitialAd.b(this);
    private IMWebView.IMWebViewListener m = new c(this);

    public InterstitialAd(Activity paramActivity, long paramLong) {
        super(paramLong);
        this.d = paramActivity;
        this.j = initialize();
    }

    public InterstitialAd(Activity paramActivity, String paramString) {
        super(paramString);
        this.d = paramActivity;
        this.j = initialize();
    }

    private static int a() {
        int n = 14;
        if (DeviceInfo.isTablet(InternalSDKUtil.getContext())) {
            n = 17;
        }
        return n;
    }

    private boolean a(Object paramObject) {
        try {
            Field localField = paramObject.getClass().getDeclaredField("mIsPlayableReady");
            localField.setAccessible(true);
            boolean bool = ((Boolean) localField.get(paramObject)).booleanValue();
            return bool;
        } catch (Exception paramObject) {
        }
        return false;
    }

    private void b() {
        try {
            if (this.mAdListener != null) {
                this.mAdListener.onShowAdScreen();
            }
            Intent localIntent = new Intent(this.d, IMBrowserActivity.class);
            localIntent.putExtra("extra_browser_type", 101);
            localIntent.putExtra("isAnimationEnabledOnDimiss", this.g);
            IMBrowserActivity.setWebview(this.f);
            IMBrowserActivity.setOriginalActivity(this.d);
            this.d.startActivity(localIntent);
            return;
        } catch (Exception localException) {
            Log.debug("[InMobi]-[Monetization]", "Error showing ad ", localException);
        }
    }

    private void b(Object paramObject) {
        try {
            Method localMethod = paramObject.getClass().getDeclaredMethod("show", new Class[]{IMAdListener.class});
            localMethod.setAccessible(true);
            localMethod.invoke(paramObject, new Object[]{this.mAdListener});
            return;
        } catch (Exception paramObject) {
            Log.internal("[InMobi]-[Monetization]", "Failed to display playable ad");
            b();
        }
    }

    private void c() {
        long l1;
        long l2;
        if (!this.k) {
            l1 = System.currentTimeMillis();
            l2 = this.mFetchStartTime;
            if (this.i == null) {
                break label155;
            }
        }
        label155:
        for (String str = this.i.getResponseBody(); ; str = null) {
            if (str != null) {
                str = str.replace("@__imm_aft@", "" + (l1 - l2));
                if (Build.VERSION.SDK_INT <= 8) {
                    str.replaceAll("%", "%25");
                }
                this.e = System.currentTimeMillis();
                this.l.sendEmptyMessageDelayed(301, Initializer.getConfigParams().getRenderTimeOut());
                this.f.loadDataWithBaseURL("", str, "text/html", null, null);
            }
            do {
                return;
                Log.debug("[InMobi]-[Monetization]", "Cannot load Ad. Invalid Ad Response");
            } while (this.mAdListener == null);
            this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
            return;
        }
    }

    private boolean d() {
        try {
            Class.forName("com.inmobi.monetization.internal.thirdparty.PlayableAdsManager");
            return true;
        } catch (Exception localException) {
        }
        return false;
    }

    private Object e() {
        try {
            Object localObject = Class.forName("com.inmobi.monetization.internal.thirdparty.PlayableAdsManager").getConstructor(new Class[]{Activity.class, IMWebView.class}).newInstance(new Object[]{this.d, this.f});
            return localObject;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[Monetization]", "Exception creating playable ads", localException);
        }
        return null;
    }

    private void f() {
        if (this.f == null) {
            this.f = new IMWebView(this.d, this.m, true, false);
            if (!this.b) {
                this.f.disableHardwareAcceleration();
            }
            IMAIController localIMAIController = new IMAIController(this.f);
            localIMAIController.setInterstitialAdStateListener(this);
            this.f.addJavascriptInterface(localIMAIController, "imaiController");
        }
    }

    public void disableHardwareAcceleration() {
        if (!this.j) {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
        }
        do {
            return;
            this.b = false;
        } while (this.f == null);
        this.f.disableHardwareAcceleration();
    }

    protected Map<String, String> getAdFormatParams() {
        HashMap localHashMap = new HashMap();
        localHashMap.put("format", Ad.AD_FORMAT.IMAI.toString().toLowerCase(Locale.getDefault()));
        localHashMap.put("mk-ads", "1");
        localHashMap.put("mk-ad-slot", String.valueOf(a()));
        localHashMap.put("adtype", "int");
        if (d()) {
            localHashMap.put("playable", String.valueOf(1));
        }
        return localHashMap;
    }

    public void handleResponse(i parami, Response paramResponse) {
        try {
            this.i = paramResponse;
            this.d.runOnUiThread(new InterstitialAd.a(this));
            return;
        } catch (Exception parami) {
            do {
                Log.debug("[InMobi]-[Monetization]", "Error retrieving ad ", parami);
            } while (this.mAdListener == null);
            this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
        }
    }

    protected boolean initialize() {
        if (this.d == null) {
            Log.debug("[InMobi]-[Monetization]", "Activity cannot be null");
            return false;
        }
        this.d = h.a(this.d);
        f();
        if (d()) {
            this.h = e();
        }
        return super.initialize();
    }

    public void loadAd() {
        if (!this.j) {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;
        }
        this.k = false;
        f();
        super.loadAd();
    }

    public void onAdFailed() {
        this.l.removeMessages(301);
        if ((!this.k) && (this.mAdListener != null)) {
            this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
        }
    }

    public void onAdReady() {
        long l1 = System.currentTimeMillis();
        long l2 = this.e;
        collectMetrics(this.i, l1 - l2, NetworkEventType.RENDER_COMPLETE);
        if (!this.k) {
            this.l.removeMessages(301);
            if (this.mAdListener != null) {
                this.mAdListener.onAdRequestSucceeded();
            }
        }
    }

    public void show() {
        try {
            if (!this.j) {
                Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
                return;
            }
            Log.debug("[InMobi]-[Monetization]", "Showing the Interstitial Ad. ");
            if ((d()) && (this.h != null) && (a(this.h))) {
                b(this.h);
                return;
            }
        } catch (Exception localException) {
            Log.debug("[InMobi]-[Monetization]", "Error showing ad ", localException);
            return;
        }
        b();
    }

    public void show(long paramLong) {
        if (!this.j) {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;
        }
        this.g = paramLong;
        show();
    }

    public void stopLoading() {
        if (!this.j) {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;
        }
        super.stopLoading();
        if ((this.l != null) && (this.l.hasMessages(301))) {
            this.l.removeMessages(301);
        }
        this.k = true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/InterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */