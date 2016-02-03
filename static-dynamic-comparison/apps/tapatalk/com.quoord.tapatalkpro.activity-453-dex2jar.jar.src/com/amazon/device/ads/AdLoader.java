package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
class AdLoader {
    public static final int AD_FAILED = -1;
    public static final int AD_NOT_READY = 1;
    public static final int AD_QUEUED = 0;
    protected static final String LOG_TAG = AdLoader.class.getSimpleName();
    private static AdLoaderFactory adLoaderFactory = new AdLoaderFactory();
    protected final AdRequest adRequest;
    protected MetricsCollector.CompositeMetricsCollector compositeMetricsCollector = null;
    protected AdError error = null;
    protected final Map<Integer, AdSlot> slots;
    protected int timeout = 20000;

    public AdLoader(AdRequest paramAdRequest, Map<Integer, AdSlot> paramMap) {
        this.adRequest = paramAdRequest;
        this.slots = paramMap;
    }

    protected static void adFailedToBeReady(int paramInt1, AtomicInteger paramAtomicInteger, AdTargetingOptions paramAdTargetingOptions, AdSlot[] paramArrayOfAdSlot, int paramInt2) {
        paramArrayOfAdSlot[paramInt2].setSlotNumber(-1);
        decrementCount(paramInt1, paramAtomicInteger, paramAdTargetingOptions, paramArrayOfAdSlot);
    }

    private static void beginFetchAds(int paramInt, AdTargetingOptions paramAdTargetingOptions, AdSlot[] paramArrayOfAdSlot) {
        Object localObject = new AdvertisingIdentifier().getAdvertisingIdentifierInfo();
        if (!((AdvertisingIdentifier.Info) localObject).canDo()) {
            failAds(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "An internal request was not made on a background thread."), paramArrayOfAdSlot);
        }
        do {
            return;
            paramAdTargetingOptions = new AdRequest(paramAdTargetingOptions).setAdvertisingIdentifierInfo((AdvertisingIdentifier.Info) localObject);
            localObject = new HashMap();
            int j = paramArrayOfAdSlot.length;
            int i = 0;
            while (i < j) {
                AdSlot localAdSlot = paramArrayOfAdSlot[i];
                if (localAdSlot.getSlotNumber() != -1) {
                    ((HashMap) localObject).put(Integer.valueOf(localAdSlot.getSlotNumber()), localAdSlot);
                    localAdSlot.getAdData().setSlotId(localAdSlot.getSlotNumber());
                    paramAdTargetingOptions.putSlot(localAdSlot.getAdData(), localAdSlot.getAdTargetingOptions());
                }
                i += 1;
            }
        } while (((HashMap) localObject).size() <= 0);
        paramAdTargetingOptions = adLoaderFactory.createAdLoader(paramAdTargetingOptions, (Map) localObject);
        paramAdTargetingOptions.setTimeout(paramInt);
        paramAdTargetingOptions.beginFetchAd();
    }

    private void beginFinalizeFetchAd() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AdLoader.this.finalizeFetchAd();
            }
        });
    }

    protected static void decrementCount(int paramInt, AtomicInteger paramAtomicInteger, final AdTargetingOptions paramAdTargetingOptions, final AdSlot[] paramArrayOfAdSlot) {
        if (paramAtomicInteger.decrementAndGet() == 0) {
            new StartUpWaiter() {
                protected void startUpFailed() {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            AdLoader.failAds(new AdError(AdError.ErrorCode.NETWORK_ERROR, "The configuration was unable to be loaded"), AdLoader
                            .3. this.val$adSlots);
                        }
                    });
                }

                protected void startUpReady() {
                    InternalAdRegistration.getInstance().register();
                    AdLoader.beginFetchAds(this.val$timeout, paramAdTargetingOptions, paramArrayOfAdSlot);
                }
            }.start();
        }
    }

    private static void failAds(AdError paramAdError, AdSlot[] paramArrayOfAdSlot) {
        int j = 0;
        int m = paramArrayOfAdSlot.length;
        int i = 0;
        while (i < m) {
            AdSlot localAdSlot = paramArrayOfAdSlot[i];
            int k = j;
            if (localAdSlot.getSlotNumber() != -1) {
                localAdSlot.getAdLoaderCallback().adFailed(paramAdError);
                k = j + 1;
            }
            i += 1;
            j = k;
        }
        if (j > 0) {
            Log.w(LOG_TAG, "%s; code: %s", new Object[]{paramAdError.getMessage(), paramAdError.getCode()});
        }
    }

    private WebRequest getAdRequest()
            throws AdLoader.AdFetchException {
        getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL);
        WebRequest localWebRequest = this.adRequest.getWebRequest();
        getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL);
        return localWebRequest;
    }

    private MetricsCollector getCompositeMetricsCollector() {
        if (this.compositeMetricsCollector == null) {
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = this.slots.entrySet().iterator();
            while (localIterator.hasNext()) {
                localArrayList.add(((AdSlot) ((Map.Entry) localIterator.next()).getValue()).getAdData().getMetricsCollector());
            }
            this.compositeMetricsCollector = new MetricsCollector.CompositeMetricsCollector(localArrayList);
        }
        return this.compositeMetricsCollector;
    }

    private static boolean isNoRetry(AdSlot[] paramArrayOfAdSlot) {
        int i = InternalAdRegistration.getInstance().getNoRetryTtlRemainingMillis();
        if (i > 0) {
            i /= 1000;
            Object localObject2;
            if (InternalAdRegistration.getInstance().getIsAppDisabled()) {
                localObject2 = "SDK Message: " + Utils.getDisabledAppServerMessage();
            }
            for (Object localObject1 = AdError.ErrorCode.INTERNAL_ERROR; ; localObject1 = AdError.ErrorCode.NO_FILL) {
                Log.e(LOG_TAG, (String) localObject2);
                localObject1 = new AdError((AdError.ErrorCode) localObject1, (String) localObject2);
                int j = paramArrayOfAdSlot.length;
                i = 0;
                while (i < j) {
                    localObject2 = paramArrayOfAdSlot[i];
                    if ((((AdSlot) localObject2).getAdData() != null) && (((AdSlot) localObject2).getAdData().getMetricsCollector() != null)) {
                        ((AdSlot) localObject2).getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_COUNTER_FAILED_DUE_TO_NO_RETRY);
                    }
                    if (((AdSlot) localObject2).getAdLoaderCallback() != null) {
                        ((AdSlot) localObject2).getAdLoaderCallback().adFailed((AdError) localObject1);
                    }
                    i += 1;
                }
                localObject2 = "SDK Message: " + "no results. Try again in " + i + " seconds.";
            }
            return true;
        }
        return false;
    }

    protected static boolean[] loadAds(int paramInt, AdTargetingOptions paramAdTargetingOptions, Ad... paramVarArgs) {
        AdSlot[] arrayOfAdSlot = new AdSlot[paramVarArgs.length];
        int i = 0;
        while (i < paramVarArgs.length) {
            arrayOfAdSlot[i] = new AdSlot(paramVarArgs[i], new AdTargetingOptions());
            i += 1;
        }
        return loadAds(paramInt, paramAdTargetingOptions, arrayOfAdSlot);
    }

    protected static boolean[] loadAds(int paramInt, AdTargetingOptions paramAdTargetingOptions, AdSlot... paramVarArgs) {
        AdTargetingOptions localAdTargetingOptions = paramAdTargetingOptions;
        if (paramAdTargetingOptions == null) {
            localAdTargetingOptions = new AdTargetingOptions();
        }
        paramAdTargetingOptions = new boolean[paramVarArgs.length];
        if (isNoRetry(paramVarArgs)) {
            Arrays.fill(paramAdTargetingOptions, true);
            return paramAdTargetingOptions;
        }
        AtomicInteger localAtomicInteger = new AtomicInteger(paramVarArgs.length);
        AdReadyToLoadListener localAdReadyToLoadListener = new AdReadyToLoadListener(paramInt, localAtomicInteger, localAdTargetingOptions, paramVarArgs);
        int j = 0;
        int k = paramVarArgs.length;
        int i = 0;
        label70:
        if (i < k) {
            AdSlot localAdSlot = paramVarArgs[i];
            localAdSlot.setSlotNumber(j + 1);
            int m = localAdSlot.getAdWrapper().prepareAd(localAdReadyToLoadListener);
            if (m == 0) {
                break label152;
            }
            adFailedToBeReady(paramInt, localAtomicInteger, localAdTargetingOptions, paramVarArgs, j);
            if (m != -1) {
                break label144;
            }
            paramAdTargetingOptions[j] = 0;
        }
        for (; ; ) {
            j += 1;
            i += 1;
            break label70;
            break;
            label144:
            paramAdTargetingOptions[j] = 1;
            continue;
            label152:
            paramAdTargetingOptions[j] = 1;
        }
    }

    private void parseResponse(JSONObject paramJSONObject) {
        long l1 = System.currentTimeMillis();
        Object localObject2 = JSONUtils.getStringFromJSON(paramJSONObject, "status", null);
        Object localObject1 = new HashSet(this.slots.keySet());
        AdError localAdError = getAdError(paramJSONObject);
        String str1 = JSONUtils.getStringFromJSON(paramJSONObject, "errorCode", "No Ad Received");
        this.adRequest.setInstrumentationPixelURL(JSONUtils.getStringFromJSON(paramJSONObject, "instrPixelURL", null));
        if ((localObject2 != null) && (((String) localObject2).equals("ok"))) {
            localObject2 = JSONUtils.getJSONArrayFromJSON(paramJSONObject, "ads");
            int m = 0;
            if (m < ((JSONArray) localObject2).length()) {
                JSONObject localJSONObject = JSONUtils.getJSONObjectFromJSONArray((JSONArray) localObject2, m);
                if (localJSONObject == null) {
                }
                for (; ; ) {
                    m += 1;
                    break;
                    int i = JSONUtils.getIntegerFromJSON(localJSONObject, "slotId", -1);
                    AdSlot localAdSlot = (AdSlot) this.slots.get(Integer.valueOf(i));
                    if (localAdSlot != null) {
                        ((HashSet) localObject1).remove(Integer.valueOf(i));
                        paramJSONObject = JSONUtils.getStringFromJSON(localJSONObject, "instrPixelURL", this.adRequest.getInstrumentationPixelURL());
                        localAdSlot.getAdData().setInstrumentationPixelUrl(paramJSONObject);
                        paramJSONObject = JSONUtils.getStringFromJSON(localJSONObject, "impPixelURL", null);
                        localAdSlot.getAdData().setImpressionPixelUrl(paramJSONObject);
                        if (localAdSlot.getAdData().getRequestedAdSize().isAuto()) {
                            localAdSlot.getAdData().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_COUNTER_AUTO_AD_SIZE);
                        }
                        String str2 = JSONUtils.getStringFromJSON(localJSONObject, "html", "");
                        JSONArray localJSONArray = JSONUtils.getJSONArrayFromJSON(localJSONObject, "creativeTypes");
                        HashSet localHashSet = new HashSet();
                        if (localJSONArray != null) {
                            i = 0;
                            while (i < localJSONArray.length()) {
                                paramJSONObject = AdData.AAXCreative.getCreative(JSONUtils.getIntegerFromJSONArray(localJSONArray, i, 0));
                                if (paramJSONObject != null) {
                                    localHashSet.add(paramJSONObject);
                                }
                                i += 1;
                            }
                        }
                        if (localHashSet.isEmpty()) {
                            localAdSlot.setAdError(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "No valid creative types found"));
                            Log.e(LOG_TAG, "No valid creative types found");
                        } else {
                            paramJSONObject = JSONUtils.getStringFromJSON(localJSONObject, "size", "");
                            int k = 0;
                            i = 0;
                            int i1 = 0;
                            int j = 0;
                            int n = 0;
                            if (!localHashSet.contains(AdData.AAXCreative.INTERSTITIAL)) {
                                int i2 = 0;
                                if (paramJSONObject != null) {
                                    paramJSONObject = paramJSONObject.split("x");
                                    label409:
                                    if ((paramJSONObject != null) && (paramJSONObject.length == 2)) {
                                        break label468;
                                    }
                                    k = 1;
                                    i = i1;
                                    j = n;
                                }
                                for (; ; ) {
                                    if (k == 0) {
                                        break label509;
                                    }
                                    localAdSlot.setAdError(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "Server returned an invalid ad size"));
                                    Log.e(LOG_TAG, "Server returned an invalid ad size");
                                    break;
                                    paramJSONObject = null;
                                    break label409;
                                    label468:
                                    i = k;
                                    try {
                                        k = Integer.parseInt(paramJSONObject[0]);
                                        i = k;
                                        j = Integer.parseInt(paramJSONObject[1]);
                                        i = k;
                                        k = i2;
                                    } catch (NumberFormatException paramJSONObject) {
                                        k = 1;
                                        j = n;
                                    }
                                }
                            }
                            label509:
                            long l2 = JSONUtils.getLongFromJSON(localJSONObject, "cacheTTL", -1L);
                            if (l2 > -1L) {
                                localAdSlot.getAdData().setExpirationTimeMillis(l1 + 1000L * l2);
                            }
                            paramJSONObject = new AdProperties(localJSONArray);
                            localAdSlot.getAdData().setHeight(j);
                            localAdSlot.getAdData().setWidth(i);
                            localAdSlot.getAdData().setCreative(str2);
                            localAdSlot.getAdData().setCreativeTypes(localHashSet);
                            localAdSlot.getAdData().setProperties(paramJSONObject);
                            localAdSlot.getAdData().setFetched(true);
                        }
                    }
                }
            }
        }
        paramJSONObject = ((HashSet) localObject1).iterator();
        while (paramJSONObject.hasNext()) {
            localObject1 = (Integer) paramJSONObject.next();
            ((AdSlot) this.slots.get(localObject1)).setAdError(localAdError);
            ((AdSlot) this.slots.get(localObject1)).getAdData().setInstrumentationPixelUrl(this.adRequest.getInstrumentationPixelURL());
            Log.w(LOG_TAG, "%s; code: %s", new Object[]{localAdError.getMessage(), str1});
        }
    }

    protected static void setAdLoaderFactory(AdLoaderFactory paramAdLoaderFactory) {
        adLoaderFactory = paramAdLoaderFactory;
    }

    private void setErrorForAllSlots(AdError paramAdError) {
        Iterator localIterator = this.slots.values().iterator();
        while (localIterator.hasNext()) {
            ((AdSlot) localIterator.next()).setAdError(paramAdError);
        }
    }

    public void beginFetchAd() {
        getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START);
        getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP);
        startFetchAdThread();
    }

    protected void fetchAd() {
        getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP);
        getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START);
        if (!Assets.getInstance().ensureAssetsCreated()) {
            this.error = new AdError(AdError.ErrorCode.REQUEST_ERROR, "Unable to create the assets needed to display ads");
            Log.e(LOG_TAG, "Unable to create the assets needed to display ads");
            setErrorForAllSlots(this.error);
            return;
        }
        try {
            Object localObject = fetchResponseFromNetwork();
            if (!((WebRequest.WebResponse) localObject).isHttpStatusCodeOK()) {
                localObject = ((WebRequest.WebResponse) localObject).getHttpStatusCode() + " - " + ((WebRequest.WebResponse) localObject).getHttpStatus();
                this.error = new AdError(AdError.ErrorCode.NETWORK_ERROR, (String) localObject);
                Log.e(LOG_TAG, (String) localObject);
                setErrorForAllSlots(this.error);
                return;
            }
        } catch (AdFetchException localAdFetchException) {
            this.error = localAdFetchException.getAdError();
            Log.e(LOG_TAG, localAdFetchException.getAdError().getMessage());
            setErrorForAllSlots(this.error);
            return;
        }
        JSONObject localJSONObject = localAdFetchException.getJSONObjectBody();
        if (localJSONObject == null) {
            this.error = new AdError(AdError.ErrorCode.INTERNAL_ERROR, "Unable to parse response");
            Log.e(LOG_TAG, "Unable to parse response");
            setErrorForAllSlots(this.error);
            return;
        }
        parseResponse(localJSONObject);
        getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END);
        getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP);
    }

    protected WebRequest.WebResponse fetchResponseFromNetwork()
            throws AdLoader.AdFetchException {
        Object localObject = getAdRequest();
        ((WebRequest) localObject).setMetricsCollector(getCompositeMetricsCollector());
        ((WebRequest) localObject).setServiceCallLatencyMetric(Metrics.MetricType.AAX_LATENCY_GET_AD);
        ((WebRequest) localObject).setTimeout(this.timeout);
        getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START);
        getCompositeMetricsCollector().incrementMetric(Metrics.MetricType.TLS_ENABLED);
        try {
            localObject = ((WebRequest) localObject).makeCall();
            getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END);
            return (WebRequest.WebResponse) localObject;
        } catch (WebRequest.WebRequestException localWebRequestException) {
            if (localWebRequestException.getStatus() != WebRequest.WebRequestStatus.NETWORK_FAILURE) {
                break label100;
            }
        }
        AdError localAdError = new AdError(AdError.ErrorCode.NETWORK_ERROR, "Could not contact Ad Server");
        for (; ; ) {
            throw new AdFetchException(localAdError);
            label100:
            if (localAdError.getStatus() == WebRequest.WebRequestStatus.NETWORK_TIMEOUT) {
                localAdError = new AdError(AdError.ErrorCode.NETWORK_TIMEOUT, "Connection to Ad Server timed out");
            } else {
                localAdError = new AdError(AdError.ErrorCode.INTERNAL_ERROR, localAdError.getMessage());
            }
        }
    }

    protected void finalizeFetchAd() {
        Iterator localIterator = this.slots.entrySet().iterator();
        while (localIterator.hasNext()) {
            AdSlot localAdSlot = (AdSlot) ((Map.Entry) localIterator.next()).getValue();
            IAdLoaderCallback localIAdLoaderCallback = localAdSlot.getAdLoaderCallback();
            AdData localAdData = localAdSlot.getAdData();
            localAdData.getMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP);
            if (!localAdData.getIsFetched()) {
                localAdData.getMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE);
                if (localAdSlot.getAdError() != null) {
                    localIAdLoaderCallback.adFailed(localAdSlot.getAdError());
                } else {
                    localIAdLoaderCallback.adFailed(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "Unknown error occurred."));
                }
            } else {
                localAdData.getMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START);
                localIAdLoaderCallback.handleResponse();
            }
        }
    }

    protected AdError getAdError(JSONObject paramJSONObject) {
        int i = retrieveNoRetryTtlSeconds(paramJSONObject);
        InternalAdRegistration.getInstance().setNoRetryTtl(i);
        paramJSONObject = JSONUtils.getStringFromJSON(paramJSONObject, "errorMessage", "No Ad Received");
        InternalAdRegistration.getInstance().setIsAppDisabled(paramJSONObject.equalsIgnoreCase(Utils.getDisabledAppServerMessage()));
        String str = "Server Message: " + paramJSONObject;
        if (i > 0) {
            getCompositeMetricsCollector().publishMetricInMilliseconds(Metrics.MetricType.AD_NO_RETRY_TTL_RECEIVED, i * 1000);
        }
        if ((i > 0) && (!InternalAdRegistration.getInstance().getIsAppDisabled())) {
            paramJSONObject = str + ". Try again in " + i + " seconds";
            return new AdError(AdError.ErrorCode.NO_FILL, paramJSONObject);
        }
        if (paramJSONObject.equals("no results")) {
            return new AdError(AdError.ErrorCode.NO_FILL, str);
        }
        return new AdError(AdError.ErrorCode.INTERNAL_ERROR, str);
    }

    protected int retrieveNoRetryTtlSeconds(JSONObject paramJSONObject) {
        return DebugProperties.getDebugPropertyAsInteger("debug.noRetryTTL", JSONUtils.getIntegerFromJSON(paramJSONObject, "noretryTTL", 0));
    }

    public void setTimeout(int paramInt) {
        this.timeout = paramInt;
    }

    protected void startFetchAdThread() {
        ThreadUtils.executeRunnable(new Runnable() {
            public void run() {
                AdLoader.this.fetchAd();
                AdLoader.this.beginFinalizeFetchAd();
            }
        });
    }

    protected class AdFetchException
            extends Exception {
        private static final long serialVersionUID = 1L;
        private final AdError adError;

        public AdFetchException(AdError paramAdError) {
            this.adError = paramAdError;
        }

        public AdFetchException(AdError paramAdError, Throwable paramThrowable) {
            super();
            this.adError = paramAdError;
        }

        public AdError getAdError() {
            return this.adError;
        }
    }

    protected static class AdLoaderFactory {
        public AdLoader createAdLoader(AdRequest paramAdRequest, Map<Integer, AdSlot> paramMap) {
            return new AdLoader(paramAdRequest, paramMap);
        }
    }

    protected static class AdReadyToLoadListener {
        private final AdSlot[] adSlots;
        private final AdTargetingOptions requestOptions;
        private final int timeout;
        private final AtomicInteger waitCount;

        public AdReadyToLoadListener(int paramInt, AtomicInteger paramAtomicInteger, AdTargetingOptions paramAdTargetingOptions, AdSlot... paramVarArgs) {
            this.waitCount = paramAtomicInteger;
            this.requestOptions = paramAdTargetingOptions;
            this.adSlots = paramVarArgs;
            this.timeout = paramInt;
        }

        public void onAdReady(Ad paramAd) {
            AdLoader.decrementCount(this.timeout, this.waitCount, this.requestOptions, this.adSlots);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */