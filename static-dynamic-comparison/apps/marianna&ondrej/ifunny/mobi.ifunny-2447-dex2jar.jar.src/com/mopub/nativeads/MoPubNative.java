package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.DownloadTask;
import com.mopub.common.GpsHelper;
import com.mopub.common.HttpClient;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.ManifestUtils;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpUriRequest;

public class MoPubNative {
    static final MoPubNative.MoPubNativeEventListener EMPTY_EVENT_LISTENER = new MoPubNative
    .2();
    static final MoPubNative.MoPubNativeNetworkListener EMPTY_NETWORK_LISTENER = new MoPubNative
    .1();
    private final String mAdUnitId;
    private final WeakReference<Context> mContext;
    private Map<String, Object> mLocalExtras;
    private MoPubNative.MoPubNativeEventListener mMoPubNativeEventListener;
    private MoPubNative.MoPubNativeNetworkListener mMoPubNativeNetworkListener;

    @Deprecated
    public MoPubNative(Context paramContext, String paramString, MoPubNative.MoPubNativeListener paramMoPubNativeListener) {
        this(paramContext, paramString, paramMoPubNativeListener);
        setNativeEventListener(paramMoPubNativeListener);
    }

    public MoPubNative(Context paramContext, String paramString, MoPubNative.MoPubNativeNetworkListener paramMoPubNativeNetworkListener) {
        if (paramContext == null) {
            throw new IllegalArgumentException("Context may not be null.");
        }
        if (paramString == null) {
            throw new IllegalArgumentException("AdUnitId may not be null.");
        }
        if (paramMoPubNativeNetworkListener == null) {
            throw new IllegalArgumentException("MoPubNativeNetworkListener may not be null.");
        }
        ManifestUtils.checkNativeActivitiesDeclared(paramContext);
        this.mContext = new WeakReference(paramContext);
        this.mAdUnitId = paramString;
        this.mMoPubNativeNetworkListener = paramMoPubNativeNetworkListener;
        this.mMoPubNativeEventListener = EMPTY_EVENT_LISTENER;
        GpsHelper.asyncFetchAdvertisingInfo(paramContext);
    }

    private void downloadJson(HttpUriRequest paramHttpUriRequest) {
        DownloadTask localDownloadTask = new DownloadTask(new MoPubNative .3 (this));
        try {
            AsyncTasks.safeExecuteOnExecutor(localDownloadTask, new HttpUriRequest[]{paramHttpUriRequest});
            return;
        } catch (Exception paramHttpUriRequest) {
            MoPubLog.d("Failed to download json", paramHttpUriRequest);
            this.mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.UNSPECIFIED);
        }
    }

    public void destroy() {
        this.mContext.clear();
        this.mMoPubNativeNetworkListener = EMPTY_NETWORK_LISTENER;
        this.mMoPubNativeEventListener = EMPTY_EVENT_LISTENER;
    }

    Context getContextOrDestroy() {
        Context localContext = (Context) this.mContext.get();
        if (localContext == null) {
            destroy();
            MoPubLog.d("Weak reference to Activity Context in MoPubNative became null. This instance of MoPubNative is destroyed and No more requests will be processed.");
        }
        return localContext;
    }

    @Deprecated
    @VisibleForTesting
    MoPubNative.MoPubNativeEventListener getMoPubNativeEventListener() {
        return this.mMoPubNativeEventListener;
    }

    @Deprecated
    @VisibleForTesting
    MoPubNative.MoPubNativeNetworkListener getMoPubNativeNetworkListener() {
        return this.mMoPubNativeNetworkListener;
    }

    void loadNativeAd(RequestParameters paramRequestParameters) {
        loadNativeAd(paramRequestParameters, null);
    }

    void loadNativeAd(RequestParameters paramRequestParameters, Integer paramInteger) {
        Context localContext = getContextOrDestroy();
        if (localContext == null) {
            return;
        }
        paramRequestParameters = new NativeUrlGenerator(localContext).withAdUnitId(this.mAdUnitId).withRequest(paramRequestParameters);
        if (paramInteger != null) {
            paramRequestParameters.withSequenceNumber(paramInteger.intValue());
        }
        paramRequestParameters = paramRequestParameters.generateUrlString("ads.mopub.com");
        if (paramRequestParameters != null) {
            MoPubLog.d("Loading ad from: " + paramRequestParameters);
        }
        requestNativeAd(paramRequestParameters);
    }

    public void makeRequest() {
        makeRequest((RequestParameters) null);
    }

    void makeRequest(MoPubNative.NativeGpsHelperListener paramNativeGpsHelperListener) {
        Context localContext = getContextOrDestroy();
        if (localContext == null) {
            return;
        }
        if (!DeviceUtils.isNetworkAvailable(localContext)) {
            this.mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
            return;
        }
        GpsHelper.asyncFetchAdvertisingInfoIfNotCached(localContext, paramNativeGpsHelperListener);
    }

    public void makeRequest(RequestParameters paramRequestParameters) {
        makeRequest(new MoPubNative.NativeGpsHelperListener(this, paramRequestParameters));
    }

    void requestNativeAd(String paramString) {
        Context localContext = getContextOrDestroy();
        if (localContext == null) {
            return;
        }
        if (paramString == null) {
            this.mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.INVALID_REQUEST_URL);
            return;
        }
        try {
            paramString = HttpClient.initializeHttpGet(paramString, localContext);
            downloadJson(paramString);
            return;
        } catch (IllegalArgumentException paramString) {
            this.mMoPubNativeNetworkListener.onNativeFail(NativeErrorCode.INVALID_REQUEST_URL);
        }
    }

    public void setLocalExtras(Map<String, Object> paramMap) {
        this.mLocalExtras = new HashMap(paramMap);
    }

    public void setNativeEventListener(MoPubNative.MoPubNativeEventListener paramMoPubNativeEventListener) {
        MoPubNative.MoPubNativeEventListener localMoPubNativeEventListener = paramMoPubNativeEventListener;
        if (paramMoPubNativeEventListener == null) {
            localMoPubNativeEventListener = EMPTY_EVENT_LISTENER;
        }
        this.mMoPubNativeEventListener = localMoPubNativeEventListener;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */