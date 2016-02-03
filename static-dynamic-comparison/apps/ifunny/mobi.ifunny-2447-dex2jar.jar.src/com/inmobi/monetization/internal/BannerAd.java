package com.inmobi.monetization.internal;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.AnimationType;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.Response;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import com.inmobi.monetization.internal.imai.IMAIController;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.IMWebView.ViewState;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class BannerAd
        extends Ad {
    protected static final String KEY_MANUAL_REFRESH = "u-rt";
    protected static final String KEY_TYPE_OF_ADREQ = "requestactivity";
    protected static final String VALUE_OF_ADREQ = "AdRequest";
    AnimationType a = AnimationType.ROTATE_HORIZONTAL_AXIS;
    private Activity b;
    private IMWebView d;
    private IMWebView e;
    private boolean f = true;
    private boolean g = false;
    private int h = 15;
    private long i = 0L;
    private boolean j = true;
    private int k = Initializer.getConfigParams().getDefaultRefreshRate();
    private a l;
    private Animation m;
    public IMWebView mCurrentWebView;
    private Animation n;
    private long o = 0L;
    private boolean p = false;
    private boolean q = true;
    private AtomicBoolean r = new AtomicBoolean(false);
    private Response s = null;
    private boolean t = false;
    private IMWebView.IMWebViewListener u = new d(this);
    private BannerAd.b v = new BannerAd.b(this);
    private Animation.AnimationListener w = new e(this);

    public BannerAd(Activity paramActivity, IMBanner paramIMBanner, long paramLong, int paramInt) {
        super(paramLong);
        this.h = paramInt;
        this.o = paramLong;
        this.b = paramActivity;
        this.t = initialize();
    }

    public BannerAd(Activity paramActivity, IMBanner paramIMBanner, String paramString, int paramInt) {
        super(paramString);
        this.h = paramInt;
        this.b = paramActivity;
        this.t = initialize();
    }

    private void a(boolean paramBoolean) {
        if (!this.t) {
            this.t = initialize();
        }
        if (!this.t) {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;
        }
        this.g = false;
        this.p = paramBoolean;
        if (!g()) {
            super.loadAd();
        }
        for (; ; ) {
            this.v.removeMessages(101);
            if (this.k <= 0) {
                break;
            }
            this.v.sendEmptyMessageDelayed(101, this.k * 1000);
            return;
            if (this.mAdListener != null) {
                AdErrorCode localAdErrorCode = AdErrorCode.INVALID_REQUEST;
                localAdErrorCode.setMessage("Ad click is in progress.Cannot load new ad");
                Log.debug("[InMobi]-[Monetization]", "Ad click is in progress.Cannot load new ad");
                this.mAdListener.onAdRequestFailed(localAdErrorCode);
            }
        }
    }

    private void b(boolean paramBoolean) {
        this.f = paramBoolean;
        if (paramBoolean) {
            this.d.deinit();
            this.d = null;
            return;
        }
        this.e.deinit();
        this.e = null;
    }

    private ViewGroup d() {
        ViewGroup localViewGroup2 = (ViewGroup) this.d.getParent();
        ViewGroup localViewGroup1 = localViewGroup2;
        if (localViewGroup2 == null) {
            localViewGroup1 = (ViewGroup) this.e.getParent();
        }
        return localViewGroup1;
    }

    private boolean e() {
        return this.f;
    }

    private void f() {
        try {
            if (this.e != null) {
                this.e.setBackgroundColor(0);
            }
            if (this.d != null) {
                this.d.setBackgroundColor(0);
            }
            return;
        } catch (Exception localException) {
            Log.debug("[InMobi]-[Monetization]", "Error setNormalBGColor", localException);
        }
    }

    private boolean g() {
        if (e()) {
        }
        for (IMWebView localIMWebView = this.e; ; localIMWebView = this.d) {
            String str = localIMWebView.getState();
            Log.debug("[InMobi]-[Monetization]", "Current Ad State: " + str);
            if ((!IMWebView.ViewState.EXPANDED.toString().equalsIgnoreCase(str)) && (!IMWebView.ViewState.RESIZED.toString().equalsIgnoreCase(str)) && (!IMWebView.ViewState.RESIZING.toString().equalsIgnoreCase(str)) && (!IMWebView.ViewState.EXPANDING.toString().equalsIgnoreCase(str))) {
                break;
            }
            Log.debug("[InMobi]-[Monetization]", "Current Ad State is neither default nor loading. New ad will not be shown.");
            return true;
        }
        if (localIMWebView.isBusy()) {
            Log.debug("[InMobi]-[Monetization]", "New ad will not be shown because the present ad is busy. Eg. Video/audio is playing, etc.");
            return true;
        }
        return this.r.get();
    }

    private void h() {
        if (!this.g) {
        }
        for (; ; ) {
            try {
                localViewGroup = d();
                if (localViewGroup == null) {
                    continue;
                }
                if (!e()) {
                    continue;
                }
                localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
                this.mCurrentWebView = this.d;
                localViewGroup.addView(this.d, localLayoutParams);
                if (e()) {
                    continue;
                }
                bool = true;
            } catch (Exception localException) {
                ViewGroup localViewGroup;
                RelativeLayout.LayoutParams localLayoutParams;
                localException.printStackTrace();
                Log.debug("[InMobi]-[Monetization]", "Error swapping banner ads", localException);
                return;
                boolean bool = false;
                continue;
            } finally {
                if (this.mAdListener == null) {
                    continue;
                }
                this.mAdListener.onAdRequestSucceeded();
                if (this.v == null) {
                    continue;
                }
                this.v.removeMessages(102);
            }
            b(bool);
            f();
            if (this.mAdListener != null) {
                this.mAdListener.onAdRequestSucceeded();
            }
            if (this.v != null) {
                this.v.removeMessages(102);
            }
            return;
            localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.mCurrentWebView = this.e;
            localViewGroup.addView(this.e, localLayoutParams);
        }
    }

    private void i() {
        if ((!this.g) && (this.s != null)) {
            String str = this.s.getResponseBody();
            long l1 = System.currentTimeMillis();
            long l2 = this.mFetchStartTime;
            if (str == null) {
                break label335;
            }
            str = str.replace("@__imm_aft@", "" + (l1 - l2));
            if (Build.VERSION.SDK_INT <= 8) {
                str.replaceAll("%", "%25");
            }
            if (!e()) {
                break label255;
            }
            if (this.d == null) {
                this.d = new IMWebView(this.b, this.u, false, false);
                if (!this.q) {
                    this.d.disableHardwareAcceleration();
                }
            }
            this.mCurrentWebView = this.d;
            this.mCurrentWebView.addJavascriptInterface(new IMAIController(this.mCurrentWebView), "imaiController");
            this.i = System.currentTimeMillis();
            this.v.sendEmptyMessageDelayed(102, Initializer.getConfigParams().getRenderTimeOut());
            this.mCurrentWebView.resetMraid();
            this.mCurrentWebView.loadDataWithBaseURL("", str, "text/html", null, null);
            l1 = System.currentTimeMillis();
            l2 = this.mFetchStartTime;
            collectMetrics(this.s, l1 - l2, NetworkEventType.RENDER_COMPLETE);
            if (!this.j) {
                break label308;
            }
            h();
            this.j = false;
        }
        label255:
        label308:
        label335:
        do {
            return;
            if (this.e == null) {
                this.e = new IMWebView(this.b, this.u, false, false);
                if (!this.q) {
                    this.e.disableHardwareAcceleration();
                }
            }
            this.mCurrentWebView = this.e;
            break;
            if (this.a == AnimationType.ANIMATION_OFF) {
                h();
                return;
            }
            this.l.a(this.a);
            return;
            Log.debug("[InMobi]-[Monetization]", "Cannot load Ad. Invalid Ad Response");
        } while (this.mAdListener == null);
        this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
    }

    Animation a() {
        return this.m;
    }

    void a(Animation paramAnimation) {
        this.m = paramAnimation;
    }

    int b() {
        try {
            ViewGroup localViewGroup = d();
            if (localViewGroup != null) {
                int i1 = localViewGroup.getWidth();
                return i1;
            }
        } catch (Exception localException) {
            Log.internal("[InMobi]-[Monetization]", "Exception getting width of banner view", localException);
        }
        return 0;
    }

    void b(Animation paramAnimation) {
        this.n = paramAnimation;
    }

    int c() {
        try {
            ViewGroup localViewGroup = d();
            if (localViewGroup != null) {
                int i1 = localViewGroup.getHeight();
                return i1;
            }
        } catch (Exception localException) {
            Log.internal("[InMobi]-[Monetization]", "Exception getting height of banner view", localException);
        }
        return 0;
    }

    void c(Animation paramAnimation) {
        try {
            ViewGroup localViewGroup = d();
            if (localViewGroup != null) {
                localViewGroup.startAnimation(paramAnimation);
            }
            return;
        } catch (Exception paramAnimation) {
            paramAnimation.printStackTrace();
            Log.internal("[InMobi]-[Monetization]", "Exception animating  banner view", paramAnimation);
        }
    }

    public void disableHardwareAcceleration() {
        if (!this.t) {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
        }
        do {
            return;
            this.q = false;
        } while (this.mCurrentWebView == null);
        this.mCurrentWebView.disableHardwareAcceleration();
    }

    protected Map<String, String> getAdFormatParams() {
        HashMap localHashMap = new HashMap();
        localHashMap.put("format", Ad.AD_FORMAT.IMAI.toString().toLowerCase(Locale.getDefault()));
        localHashMap.put("mk-ads", "1");
        localHashMap.put("requestactivity", "AdRequest");
        if (this.p) {
            localHashMap.put("u-rt", String.valueOf(1));
        }
        for (; ; ) {
            if (this.o > 0L) {
                localHashMap.put("placement-size", b() + "x" + c());
            }
            localHashMap.put("mk-ad-slot", String.valueOf(this.h));
            return localHashMap;
            localHashMap.put("u-rt", String.valueOf(0));
        }
    }

    public View getView() {
        return this.mCurrentWebView;
    }

    public void handleResponse(i parami, Response paramResponse) {
        if (paramResponse != null) {
        }
        try {
            if (this.b != null) {
                this.s = paramResponse;
                this.b.runOnUiThread(new BannerAd.a(this));
            }
            return;
        } catch (Exception parami) {
            do {
                Log.debug("[InMobi]-[Monetization]", "Failed to render banner ad");
            } while (this.mAdListener == null);
            this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
        }
    }

    protected boolean initialize() {
        if (this.h < 0) {
            Log.debug("[InMobi]-[Monetization]", "Invalid Ad Size. Please provide a valid Ad Size. If Ad Size is declared in the layout XML, please provide a valid 'adSize' attribute in the 'com.inmobi.monetization.IMBanner' tag of layout XML. For example, adSize=\"yourAdSize\"");
            return false;
        }
        if (this.b == null) {
            Log.debug("[InMobi]-[Monetization]", "Activity cannot be null");
            return false;
        }
        this.b = h.a(this.b);
        if (this.d == null) {
            this.d = new IMWebView(this.b, this.u, false, false);
            if (!this.q) {
                this.d.disableHardwareAcceleration();
            }
            this.d.addJavascriptInterface(new IMAIController(this.d), "imaiController");
        }
        if (this.e == null) {
            this.e = new IMWebView(this.b, this.u, false, false);
            this.mCurrentWebView = this.e;
            if (!this.q) {
                this.e.disableHardwareAcceleration();
            }
            this.e.addJavascriptInterface(new IMAIController(this.e), "imaiController");
        }
        this.l = new a(this, this.w);
        return super.initialize();
    }

    public void loadAd() {
        a(false);
    }

    public void refreshAd() {
        this.p = true;
        this.v.removeMessages(101);
        if (this.k > 0) {
            this.v.sendEmptyMessageDelayed(101, this.k * 1000);
        }
    }

    public void setAdSize(int paramInt) {
        this.h = paramInt;
    }

    public void setAnimation(AnimationType paramAnimationType) {
        this.a = paramAnimationType;
    }

    public void setRefreshInterval(int paramInt) {
        if (!this.t) {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
        }
        for (; ; ) {
            return;
            int i1 = Initializer.getConfigParams().getMinimumRefreshRate();
            this.v.removeMessages(101);
            if (paramInt <= 0) {
                this.k = 0;
                return;
            }
            if (paramInt < i1) {
                Log.debug("[InMobi]-[Monetization]", "Refresh Interval cannot be less than " + i1 + " seconds. Setting refresh rate to " + i1);
            }
            for (this.k = i1; this.k != 0; this.k = paramInt) {
                this.v.sendEmptyMessageDelayed(101, this.k * 1000);
                return;
            }
        }
    }

    public void stopLoading() {
        if (!this.t) {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;
        }
        super.stopLoading();
        if ((this.v != null) && (this.v.hasMessages(102))) {
            this.v.removeMessages(102);
        }
        this.g = true;
    }

    public void stopRefresh() {
        if (!this.t) {
            Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
            return;
        }
        this.v.removeMessages(101);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/BannerAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */