package com.inmobi.monetization;

import android.app.Activity;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.IMAdListener;
import com.inmobi.monetization.internal.InterstitialAd;

import java.util.HashMap;
import java.util.Map;

public class IMInterstitial {
    InterstitialAd a;
    boolean b = false;
    IMAdListener c = new a(this);
    private IMInterstitialListener d;
    private IMIncentivisedListener e;
    private long f = -1L;
    private Activity g;
    private IMInterstitial.State h = IMInterstitial.State.INIT;
    private String i = null;

    public IMInterstitial(Activity paramActivity, long paramLong) {
        this.g = paramActivity;
        this.f = paramLong;
        a();
    }

    public IMInterstitial(Activity paramActivity, String paramString) {
        this.g = paramActivity;
        this.i = paramString;
        a();
    }

    private void a() {
        if (this.f > 0L) {
        }
        for (this.a = new InterstitialAd(this.g, this.f); ; this.a = new InterstitialAd(this.g, this.i)) {
            this.a.setAdListener(this.c);
            return;
        }
    }

    private void a(int paramInt, AdErrorCode paramAdErrorCode, Map<?, ?> paramMap) {
        if (this.d == null) {
            return;
        }
        this.g.runOnUiThread(new IMInterstitial.a(this, paramInt, paramAdErrorCode, paramMap));
    }

    @Deprecated
    public void destroy() {
    }

    public void disableHardwareAcceleration() {
        this.b = true;
    }

    public IMInterstitial.State getState() {
        return this.h;
    }

    public void loadInterstitial() {
        if (this.a != null) {
            if (this.h == IMInterstitial.State.LOADING) {
                localIMErrorCode = IMErrorCode.INVALID_REQUEST;
                localIMErrorCode.setMessage("Ad download in progress. Your request cannot be processed at this time. Try again later.");
                Log.debug("[InMobi]-[Monetization]", "Ad download in progress. Your request cannot be processed at this time. Try again later.");
                this.d.onInterstitialFailed(this, localIMErrorCode);
                return;
            }
            if (this.h == IMInterstitial.State.ACTIVE) {
                localIMErrorCode = IMErrorCode.INVALID_REQUEST;
                localIMErrorCode.setMessage("Interstitial ad is in ACTIVE state. Try again after sometime.");
                Log.debug("[InMobi]-[Monetization]", "Interstitial ad is in ACTIVE state. Try again after sometime.");
                this.d.onInterstitialFailed(this, localIMErrorCode);
                return;
            }
            this.h = IMInterstitial.State.LOADING;
            this.a.loadAd();
            return;
        }
        IMErrorCode localIMErrorCode = IMErrorCode.INVALID_REQUEST;
        Log.debug("[InMobi]-[Monetization]", "Interstitial ad is in ACTIVE state. Try again after sometime.");
        this.d.onInterstitialFailed(this, localIMErrorCode);
    }

    public void setAppId(String paramString) {
        if (this.a != null) {
            this.a.setAppId(paramString);
        }
    }

    public void setIMIncentivisedListener(IMIncentivisedListener paramIMIncentivisedListener) {
        this.e = paramIMIncentivisedListener;
    }

    public void setIMInterstitialListener(IMInterstitialListener paramIMInterstitialListener) {
        this.d = paramIMInterstitialListener;
    }

    public void setKeywords(String paramString) {
        if ((paramString == null) || ("".equals(paramString.trim()))) {
            Log.debug("[InMobi]-[Monetization]", "Keywords cannot be null or blank.");
        }
        while (this.a == null) {
            return;
        }
        this.a.setKeywords(paramString);
    }

    @Deprecated
    public void setRefTagParam(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString2 == null)) {
            Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be null");
        }
        HashMap localHashMap;
        do {
            return;
            if ((paramString1.trim().equals("")) || (paramString2.trim().equals(""))) {
                Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be empty");
                return;
            }
            localHashMap = new HashMap();
            localHashMap.put(paramString1, paramString2);
        } while (this.a == null);
        this.a.setRequestParams(localHashMap);
    }

    public void setRequestParams(Map<String, String> paramMap) {
        if ((paramMap == null) || (paramMap.isEmpty())) {
            Log.debug("[InMobi]-[Monetization]", "Request params cannot be null or empty.");
        }
        while (this.a == null) {
            return;
        }
        this.a.setRequestParams(paramMap);
    }

    public void setSlotId(long paramLong) {
        if (this.a != null) {
            this.a.setSlotId(paramLong);
        }
    }

    public void show() {
        if ((this.a != null) && (this.h == IMInterstitial.State.READY)) {
            this.a.show();
            return;
        }
        Log.debug("[InMobi]-[Monetization]", "Interstitial ad is not in the 'READY' state. Current state: " + this.h);
    }

    @Deprecated
    public void show(long paramLong) {
        if (this.a != null) {
            this.a.show(paramLong);
        }
    }

    public void stopLoading() {
        if (this.a != null) {
            this.a.stopLoading();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/IMInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */