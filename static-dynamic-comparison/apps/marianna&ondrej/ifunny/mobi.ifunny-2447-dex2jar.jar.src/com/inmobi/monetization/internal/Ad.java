package com.inmobi.monetization.internal;

import android.content.Context;
import android.content.IntentFilter;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.ActivityRecognitionManager;
import com.inmobi.commons.internal.Base64;
import com.inmobi.commons.internal.EncryptionUtils;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.network.ErrorCode;
import com.inmobi.commons.network.Response;
import com.inmobi.commons.uid.UID;
import com.inmobi.monetization.internal.carb.CARB;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import com.inmobi.monetization.internal.imai.IMAIController;
import com.inmobi.monetization.internal.objects.LtvpRuleCache;
import com.inmobi.re.container.IMWebView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.json.JSONObject;

public abstract class Ad {
    public static final String AD_TYPE_NATIVE = "native";
    protected static final String DEFAULT_NO_OF_ADS = "1";
    protected static final String KEY_AD_FORMAT = "format";
    protected static final String KEY_AD_SIZE = "mk-ad-slot";
    protected static final String KEY_NO_OF_ADS = "mk-ads";
    protected static final String KEY_PLACEMENT_SIZE = "placement-size";
    private static ConnBroadcastReciever e = null;
    private String a = null;
    private long b = 0L;
    boolean c = false;
    private AtomicBoolean d = new AtomicBoolean();
    private Map<String, String> f;
    private String g = null;
    private String h = null;
    private String i = null;
    private i j = null;
    private Ad.c k = new Ad.c(this);
    private LtvpRuleProcessor.ActionsRule l = LtvpRuleProcessor.ActionsRule.MEDIATION;
    private HashMap<String, String> m = null;
    protected IMAdListener mAdListener = null;
    protected boolean mEnableHardwareAcceleration = true;
    protected long mFetchStartTime = 0L;
    protected String mImpressionId = null;

    public Ad(long paramLong) {
        this.b = paramLong;
    }

    public Ad(String paramString) {
        if ((paramString == null) || ("".equals(paramString.trim()))) {
            this.a = InMobi.getAppId();
            return;
        }
        this.a = paramString;
    }

    private Map<String, String> a() {
        HashMap localHashMap = new HashMap();
        if (localHashMap != null) {
            if (this.m != null) {
                Iterator localIterator = this.m.keySet().iterator();
                while (localIterator.hasNext()) {
                    String str = (String) localIterator.next();
                    localHashMap.put(str, this.m.get(str));
                }
            }
            if ((this.h != null) && (this.i != null)) {
                localHashMap.put(this.h, this.i);
            }
            if (this.g != null) {
                localHashMap.put("p-keywords", this.g);
            }
        }
        return localHashMap;
    }

    private void a(JSONObject paramJSONObject, NetworkEventType paramNetworkEventType) {
        if (this.c) {
            Initializer.getLogger().logEvent(new EventLog(paramNetworkEventType, paramJSONObject));
        }
    }

    private boolean b() {
        return this.d.get();
    }

    private LtvpRuleProcessor.ActionsRule c() {
        return LtvpRuleProcessor.getInstance().getLtvpRuleConfig(this.b);
    }

    protected void collectMetrics(Response paramResponse, long paramLong, NetworkEventType paramNetworkEventType) {
        for (; ; ) {
            JSONObject localJSONObject;
            try {
                if (!this.c) {
                    break;
                }
                localJSONObject = new JSONObject();
                if (paramResponse.getStatusCode() > 400) {
                    localJSONObject.put("m", paramResponse.getError());
                    localJSONObject.put("t", paramLong);
                    Initializer.getLogger().logEvent(new EventLog(paramNetworkEventType, localJSONObject));
                    return;
                }
                if (paramResponse.getStatusCode() != 200) {
                    localJSONObject.put("m", paramResponse.getStatusCode());
                    continue;
                }
                paramResponse = paramResponse.getHeaders();
            } catch (Exception paramResponse) {
                com.inmobi.commons.internal.Log.internal("[InMobi]-[Monetization]", "Error creating metric logs for ad fetch at " + System.currentTimeMillis());
                return;
            }
            if (paramResponse != null) {
                this.mImpressionId = ((String) ((List) paramResponse.get("im-id")).get(0));
                paramResponse = (String) ((List) paramResponse.get("im-ec")).get(0);
                if (paramResponse != null) {
                    com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Sandbox error Id: " + paramResponse);
                }
            }
            localJSONObject.put("ad", this.mImpressionId);
        }
    }

    public void destroy() {
        if (!InternalSDKUtil.isInitializedSuccessfully()) {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please initialize the sdk");
            return;
        }
        e = null;
    }

    protected abstract Map<String, String> getAdFormatParams();

    protected Response getDecryptedResponse(i parami, Response paramResponse) {
        try {
            parami = new Response(new String(EncryptionUtils.DeAe(Base64.decode(paramResponse.getResponseBody().getBytes(), 0), parami.b(), parami.a())), paramResponse.getStatusCode(), paramResponse.getHeaders());
            return parami;
        } catch (Exception parami) {
            parami.printStackTrace();
        }
        return null;
    }

    protected void handleError(i parami, Response paramResponse) {
        long l1 = System.currentTimeMillis() - this.mFetchStartTime;
        if (this.mAdListener != null) {
            if (paramResponse.getStatusCode() == 204) {
                this.mAdListener.onAdRequestFailed(AdErrorCode.NO_FILL);
                collectMetrics(paramResponse, l1, NetworkEventType.RESPONSE_ERROR);
            }
        } else {
            return;
        }
        if (paramResponse.getStatusCode() == 400) {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Check the app Id passed in the ad");
            this.mAdListener.onAdRequestFailed(AdErrorCode.INVALID_APP_ID);
            collectMetrics(paramResponse, l1, NetworkEventType.RESPONSE_ERROR);
            return;
        }
        if (paramResponse.getError() != null) {
            parami = paramResponse.getError();
            if (parami.equals(ErrorCode.INTERNAL_ERROR)) {
                this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
            }
            for (; ; ) {
                collectMetrics(paramResponse, l1, NetworkEventType.CONNECT_ERROR);
                return;
                if (parami.equals(ErrorCode.INVALID_REQUEST)) {
                    this.mAdListener.onAdRequestFailed(AdErrorCode.INVALID_REQUEST);
                } else if (parami.equals(ErrorCode.NETWORK_ERROR)) {
                    this.mAdListener.onAdRequestFailed(AdErrorCode.NETWORK_ERROR);
                } else if (!parami.equals(ErrorCode.CONNECTION_ERROR)) {
                }
            }
        }
        this.mAdListener.onAdRequestFailed(AdErrorCode.INTERNAL_ERROR);
    }

    protected abstract void handleResponse(i parami, Response paramResponse);

    protected boolean initialize() {
        if (!InternalSDKUtil.isInitializedSuccessfully()) {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please initialize the sdk");
            return false;
        }
        if (((this.a == null) || ("".equals(this.a.trim()))) && (0L == this.b)) {
            android.util.Log.e("[InMobi]-[Monetization]", "Please create an instance of  ad with valid appId/ slotid");
            return false;
        }
        try {
            ThinICE.start(InternalSDKUtil.getContext());
        } catch (Exception localException) {
            try {
                for (; ; ) {
                    h.a(InternalSDKUtil.getContext());
                    InternalSDKUtil.getUserAgent();
                    CARB.getInstance().startCarb();
                    UID.getInstance().printPublisherTestId();
                    IMWebView.setIMAIController(IMAIController.class);
                    if (e == null) {
                        e = new ConnBroadcastReciever();
                    }
                    InternalSDKUtil.getContext().registerReceiver(e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    if (this.b > 0L) {
                        this.l = c();
                    }
                    return true;
                    localException = localException;
                    com.inmobi.commons.internal.Log.internal("[InMobi]-[Monetization]", "Cannot start ice. Activity is null");
                }
            } catch (InvalidManifestConfigException localInvalidManifestConfigException) {
                for (; ; ) {
                    com.inmobi.commons.internal.Log.internal("[InMobi]-[Monetization]", "IMConfigException occured while initializing interstitial while validating adView", localInvalidManifestConfigException);
                }
            }
        }
    }

    protected void loadAd() {
        if (!InternalSDKUtil.isInitializedSuccessfully()) {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please initialize the sdk");
            if (this.mAdListener != null) {
                this.mAdListener.onAdRequestFailed(AdErrorCode.INVALID_REQUEST);
            }
        }
        do {
            for (; ; ) {
                return;
                DeviceInfo.updateDeviceInfo();
                UID.getInstance().printPublisherTestId();
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", " >>>> Start loading new Ad <<<<");
                try {
                    if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) {
                        if (this.mAdListener == null) {
                            continue;
                        }
                        this.mAdListener.onAdRequestFailed(AdErrorCode.NETWORK_ERROR);
                    }
                } catch (Exception localException) {
                    handleError(this.j, new Response(ErrorCode.INTERNAL_ERROR));
                    com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Error in loading ad ", localException);
                    return;
                }
            }
            if (!b()) {
                break;
            }
        } while (this.mAdListener == null);
        this.mAdListener.onAdRequestFailed(AdErrorCode.AD_DOWNLOAD_IN_PROGRESS);
        return;
        if (getAdFormatParams() == null) {
            this.f = new HashMap();
            if (!this.f.containsKey("format")) {
                this.f.put("format", Ad.AD_FORMAT.IMAI.toString().toLowerCase(Locale.getDefault()));
            }
            if (!this.f.containsKey("mk-ads")) {
                this.f.put("mk-ads", "1");
            }
            if ((this.a != null) && (!"".equals(this.a))) {
                this.f.put("mk-siteid", this.a);
            }
            this.j = new i();
            this.j.b(a());
            if (this.b <= 0L) {
                break label556;
            }
            this.l = c();
            if (this.l == null) {
                break label556;
            }
            switch (Ad.b.a[this.l.ordinal()]) {
            }
        }
        for (; ; ) {
            if (this.mAdListener != null) {
                this.mAdListener.onAdRequestFailed(AdErrorCode.NO_FILL);
            }
            for (; ; ) {
                if ((this.l == LtvpRuleProcessor.ActionsRule.ACTIONS_ONLY) || (this.l == LtvpRuleProcessor.ActionsRule.ACTIONS_TO_MEDIATION)) {
                    break label556;
                }
                com.inmobi.commons.internal.Log.internal("[InMobi]-[Monetization]", "No actions returned by rule");
                return;
                this.f = getAdFormatParams();
                break;
                this.f.put("mk-site-slotid", Long.toString(this.b));
                this.f.put("rule-id", LtvpRuleCache.getInstance(InternalSDKUtil.getContext()).getLtvpRuleId());
                int n = ActivityRecognitionManager.getDetectedActivity();
                if (n != -1) {
                    this.f.put("u-activity-type", n + "");
                }
                if (this.j != null) {
                    this.j.setUrl(AnalyticsInitializer.getConfigParams().getEndPoints().getHouseUrl());
                    continue;
                    if (this.mAdListener != null) {
                        this.mAdListener.onAdRequestFailed(AdErrorCode.DO_MONETIZE);
                        continue;
                        if (this.mAdListener != null) {
                            this.mAdListener.onAdRequestFailed(AdErrorCode.DO_NOTHING);
                        }
                    }
                }
            }
            label556:
            this.j.a(this.f);
            setDownloadingNewAd(true);
            b.a().a(this.a, this.j, new Ad.a(this));
            this.mFetchStartTime = System.currentTimeMillis();
            this.k.sendEmptyMessageDelayed(101, Initializer.getConfigParams().getFetchTimeOut());
            this.c = Initializer.getLogger().startNewSample();
            return;
        }
    }

    public void setAdListener(IMAdListener paramIMAdListener) {
        this.mAdListener = paramIMAdListener;
    }

    protected void setAdRequest(i parami) {
        this.j = parami;
    }

    public void setAppId(String paramString) {
        if ((paramString != null) && (!"".equals(paramString))) {
            this.a = paramString;
            return;
        }
        com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "AppId cannot be null or blank.");
    }

    protected void setDownloadingNewAd(boolean paramBoolean) {
        this.d.set(paramBoolean);
    }

    public void setKeywords(String paramString) {
        if (!InternalSDKUtil.isInitializedSuccessfully()) {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please initialize the sdk");
        }
        while ((paramString == null) || ("".equals(paramString))) {
            return;
        }
        this.g = paramString;
    }

    public void setRequestParams(Map<String, String> paramMap) {
        if (!InternalSDKUtil.isInitializedSuccessfully()) {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please initialize the sdk");
        }
        for (; ; ) {
            return;
            if ((paramMap != null) && (!paramMap.isEmpty())) {
                if (this.m == null) {
                    this.m = new HashMap();
                }
                Iterator localIterator = paramMap.keySet().iterator();
                while (localIterator.hasNext()) {
                    String str = (String) localIterator.next();
                    this.m.put(str, paramMap.get(str));
                }
            }
        }
    }

    public void setSlotId(long paramLong) {
        if (paramLong > 0L) {
            this.b = paramLong;
            return;
        }
        com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Invalid slot id");
    }

    public void stopLoading() {
        if (b()) {
            if ((this.k != null) && (this.k.hasMessages(101))) {
                this.k.removeMessages(101);
            }
            setDownloadingNewAd(false);
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Stopped loading an ad");
            if (this.mAdListener != null) {
                this.mAdListener.onAdRequestFailed(AdErrorCode.ADREQUEST_CANCELLED);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/Ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */