package com.inmobi.monetization.internal;

import android.os.Handler;
import android.view.ViewGroup;
import com.inmobi.commons.network.Response;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.NativeConfigParams;
import com.inmobi.monetization.internal.objects.NativeAdsCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class NativeAd
        extends Ad {
    public static final String KEY_CONTEXTCODE = "contextCode";
    public static final String KEY_NAMESPACE = "namespace";
    public static final String KEY_PUBCONTENT = "pubContent";
    g a = null;
    private Handler b;
    private NativeAd.a d = NativeAd.a.f;
    private String e = null;
    public boolean loggingEnabled;
    public Object mImpId;

    public NativeAd(String paramString) {
        super(paramString);
        if (initialize()) {
            a(NativeAd.a.a);
        }
        this.e = paramString;
    }

    private void a() {
        NativeAdsCache.getInstance().removeExpiredAds();
        int i = NativeAdsCache.getInstance().getNumCachedAds(this.e);
        int j = Initializer.getConfigParams().getNativeSdkConfigParams().getmMinLimit();
        if (i == 0) {
            super.loadAd();
        }
        do {
            return;
            a(NativeAd.a.c);
            if (i <= j) {
                super.loadAd();
            }
        } while (this.mAdListener == null);
        this.mAdListener.onAdRequestSucceeded();
    }

    private void a(AdErrorCode paramAdErrorCode) {
        if (paramAdErrorCode != null) {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", paramAdErrorCode.toString());
        }
        if ((this.mAdListener != null) && (b() == NativeAd.a.b)) {
            this.mAdListener.onAdRequestFailed(paramAdErrorCode);
        }
        a(NativeAd.a.e);
    }

    private void a(NativeAd.a parama) {
        try {
            this.d = parama;
            return;
        } finally {
            parama =finally;
            throw parama;
        }
    }

    private NativeAd.a b() {
        try {
            NativeAd.a locala = this.d;
            return locala;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void attachToView(ViewGroup paramViewGroup, String paramString1, String paramString2) {
        if (paramViewGroup == null) {
        }
        try {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please pass a valid view to attach");
            return;
        } catch (Exception paramViewGroup) {
            android.util.Log.e("[InMobi]-[Monetization]", "Please pass a valid view to attach");
            return;
        }
        switch (NativeAd.c.a[b().ordinal()]) {
            case 1:
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
                return;
            case 4:
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please load a native ad before attach");
                return;
            case 5:
                if (this.b == null) {
                    android.util.Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
                    return;
                }
                this.b.post(new NativeAd.d(this, paramViewGroup, paramString1, paramString2));
                a(NativeAd.a.d);
                return;
            case 2:
            case 6:
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Cannot attach an ad when it is not loaded");
                return;
            case 3:
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Ad is already attached");
                return;
        }
    }

    public void detachFromView() {
        switch (NativeAd.c.a[b().ordinal()]) {
            default:
                return;
            case 1:
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
                return;
            case 4:
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please load an ad before calling detach");
                return;
            case 2:
            case 6:
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Cannot detach an ad when it is not loaded");
                return;
            case 5:
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Cannot detach an ad when it is not attached");
                return;
        }
        if (this.b == null) {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
            return;
        }
        this.b.post(new NativeAd.e(this));
        a(NativeAd.a.a);
    }

    protected Map<String, String> getAdFormatParams() {
        HashMap localHashMap = new HashMap();
        localHashMap.put("format", Ad.AD_FORMAT.NATIVE.toString().toLowerCase(Locale.getDefault()));
        localHashMap.put("mk-ads", String.valueOf(Initializer.getConfigParams().getNativeSdkConfigParams().getmFetchLimit()));
        return localHashMap;
    }

    public Handler getHandler() {
        return this.b;
    }

    public NativeAdObject getNativeAdObject() {
        return NativeAdsCache.getInstance().getCachedAd(this.e);
    }

    public void handleClick(HashMap<String, String> paramHashMap) {
        switch (NativeAd.c.a[b().ordinal()]) {
            default:
                return;
            case 1:
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
                return;
            case 2:
            case 4:
            case 6:
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Cannot handle click, native ad not loaded");
                return;
            case 5:
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Cannot handle click, native ad not attached");
                return;
        }
        if (this.b == null) {
            android.util.Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
            return;
        }
        this.b.post(new NativeAd.b(this, paramHashMap));
    }

    public void handleResponse(i parami, Response paramResponse) {
        if (paramResponse != null) {
        }
        for (; ; ) {
            int j;
            int i;
            try {
                if (paramResponse.getStatusCode() != 200) {
                    break label299;
                }
                parami = new JSONObject(paramResponse.getResponseBody()).getJSONArray("ads");
                if (parami == null) {
                    break label291;
                }
                if (parami.length() == 0) {
                    a(AdErrorCode.NO_FILL);
                    return;
                }
                paramResponse = new ArrayList();
                j = parami.length();
                i = Initializer.getConfigParams().getNativeSdkConfigParams().getmFetchLimit();
                if (j <= i) {
                    break label333;
                }
                j = 0;
                if (j < i) {
                    try {
                        JSONObject localJSONObject = parami.getJSONObject(j);
                        String str1 = localJSONObject.optString("pubContent");
                        String str2 = localJSONObject.optString("contextCode");
                        String str3 = localJSONObject.optString("namespace");
                        if ((str1 == null) || ("".equals(str1.trim())) || (str2 == null) || ("".equals(str2.trim())) || (str3 == null) || ("".equals(str3.trim()))) {
                            break label340;
                        }
                        paramResponse.add(localJSONObject.toString());
                    } catch (Exception localException) {
                        com.inmobi.commons.internal.Log.internal("[InMobi]-[Monetization]", "JSON Exception", localException);
                    }
                }
                if (paramResponse.size() <= 0) {
                    break label283;
                }
            } catch (Exception parami) {
                com.inmobi.commons.internal.Log.internal("[InMobi]-[Monetization]", "Exception retrieving native ad", parami);
                a(AdErrorCode.INTERNAL_ERROR);
                return;
            }
            NativeAdsCache.getInstance().saveNativeAds(this.e, paramResponse);
            if (b() == NativeAd.a.b) {
                a(NativeAd.a.c);
                if (this.mAdListener != null) {
                    this.mAdListener.onAdRequestSucceeded();
                    return;
                    label283:
                    a(AdErrorCode.INTERNAL_ERROR);
                    return;
                    label291:
                    a(AdErrorCode.INTERNAL_ERROR);
                    return;
                    label299:
                    if (paramResponse.getStatusCode() == 400) {
                        a(AdErrorCode.INVALID_APP_ID);
                        return;
                    }
                    a(AdErrorCode.INTERNAL_ERROR);
                    return;
                    a(AdErrorCode.INTERNAL_ERROR);
                    return;
                    label333:
                    i = j;
                    continue;
                }
            }
            return;
            label340:
            j += 1;
        }
    }

    protected boolean initialize() {
        try {
            this.b = new Handler();
            return super.initialize();
        } catch (Throwable localThrowable) {
            android.util.Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
        }
        return false;
    }

    public void loadAd() {
        if (this.b == null) {
            android.util.Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
            return;
        }
        switch (NativeAd.c.a[b().ordinal()]) {
            default:
                return;
            case 1:
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please check for initialization error on the ad. The activity or appId cannot be null or blank");
                return;
            case 2:
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Ad is already loading. Please wait");
                return;
            case 3:
                detachFromView();
        }
        com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Loading native ad");
        a(NativeAd.a.b);
        a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/NativeAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */