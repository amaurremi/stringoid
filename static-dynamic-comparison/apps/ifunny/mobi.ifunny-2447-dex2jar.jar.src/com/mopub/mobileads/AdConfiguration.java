package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings.Secure;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mopub.common.util.DateAndTime;
import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Utils;
import com.mopub.common.util.VersionCode;
import com.mopub.mobileads.util.HttpResponses;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.apache.http.HttpResponse;

public class AdConfiguration
        implements Serializable {
    private static final int DEFAULT_REFRESH_TIME_MILLISECONDS = 60000;
    private static final int MINIMUM_REFRESH_TIME_MILLISECONDS = 10000;
    private static final String mPlatform = "Android";
    private static final long serialVersionUID = 0L;
    private Integer mAdTimeoutDelay;
    private String mAdType;
    private String mAdUnitId;
    private long mBroadcastIdentifier;
    private String mClickthroughUrl;
    private final String mDeviceLocale;
    private final String mDeviceModel;
    private String mDspCreativeId;
    private String mFailUrl;
    private final String mHashedUdid;
    private int mHeight;
    private String mImpressionUrl;
    private String mNetworkType;
    private final int mPlatformVersion;
    private String mRedirectUrl;
    private int mRefreshTimeMilliseconds;
    private String mResponseString;
    private final String mSdkVersion;
    private long mTimeStamp;
    private final String mUserAgent;
    private int mWidth;

    AdConfiguration(Context paramContext) {
        setDefaults();
        String str;
        if (paramContext != null) {
            str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
            if (str != null) {
                this.mHashedUdid = Utils.sha1(str);
                this.mUserAgent = new WebView(paramContext).getSettings().getUserAgentString();
            }
        }
        for (this.mDeviceLocale = paramContext.getResources().getConfiguration().locale.toString(); ; this.mDeviceLocale = null) {
            this.mBroadcastIdentifier = Utils.generateUniqueId();
            this.mDeviceModel = (Build.MANUFACTURER + " " + Build.MODEL);
            this.mPlatformVersion = VersionCode.currentApiLevel().getApiLevel();
            this.mSdkVersion = "3.0.0";
            return;
            str = "";
            break;
            this.mHashedUdid = null;
            this.mUserAgent = null;
        }
    }

    static AdConfiguration extractFromMap(Map<String, Object> paramMap) {
        if (paramMap == null) {
            return null;
        }
        paramMap = paramMap.get("Ad-Configuration");
        if ((paramMap instanceof AdConfiguration)) {
            return (AdConfiguration) paramMap;
        }
        return null;
    }

    private void setDefaults() {
        this.mBroadcastIdentifier = 0L;
        this.mAdUnitId = null;
        this.mResponseString = null;
        this.mAdType = null;
        this.mNetworkType = null;
        this.mRedirectUrl = null;
        this.mClickthroughUrl = null;
        this.mImpressionUrl = null;
        this.mTimeStamp = DateAndTime.now().getTime();
        this.mWidth = 0;
        this.mHeight = 0;
        this.mAdTimeoutDelay = null;
        this.mRefreshTimeMilliseconds = 60000;
        this.mFailUrl = null;
        this.mDspCreativeId = null;
    }

    void addHttpResponse(HttpResponse paramHttpResponse) {
        this.mAdType = HttpResponses.extractHeader(paramHttpResponse, ResponseHeader.AD_TYPE);
        this.mNetworkType = HttpResponses.extractHeader(paramHttpResponse, ResponseHeader.NETWORK_TYPE);
        this.mRedirectUrl = HttpResponses.extractHeader(paramHttpResponse, ResponseHeader.REDIRECT_URL);
        this.mClickthroughUrl = HttpResponses.extractHeader(paramHttpResponse, ResponseHeader.CLICKTHROUGH_URL);
        this.mFailUrl = HttpResponses.extractHeader(paramHttpResponse, ResponseHeader.FAIL_URL);
        this.mImpressionUrl = HttpResponses.extractHeader(paramHttpResponse, ResponseHeader.IMPRESSION_URL);
        this.mTimeStamp = DateAndTime.now().getTime();
        this.mWidth = HttpResponses.extractIntHeader(paramHttpResponse, ResponseHeader.WIDTH, 0);
        this.mHeight = HttpResponses.extractIntHeader(paramHttpResponse, ResponseHeader.HEIGHT, 0);
        this.mAdTimeoutDelay = HttpResponses.extractIntegerHeader(paramHttpResponse, ResponseHeader.AD_TIMEOUT);
        if (!paramHttpResponse.containsHeader(ResponseHeader.REFRESH_TIME.getKey())) {
        }
        for (this.mRefreshTimeMilliseconds = 0; ; this.mRefreshTimeMilliseconds = Math.max(this.mRefreshTimeMilliseconds, 10000)) {
            this.mDspCreativeId = HttpResponses.extractHeader(paramHttpResponse, ResponseHeader.DSP_CREATIVE_ID);
            return;
            this.mRefreshTimeMilliseconds = (HttpResponses.extractIntHeader(paramHttpResponse, ResponseHeader.REFRESH_TIME, 0) * 1000);
        }
    }

    void cleanup() {
        setDefaults();
    }

    Integer getAdTimeoutDelay() {
        return this.mAdTimeoutDelay;
    }

    String getAdType() {
        return this.mAdType;
    }

    String getAdUnitId() {
        return this.mAdUnitId;
    }

    long getBroadcastIdentifier() {
        return this.mBroadcastIdentifier;
    }

    String getClickthroughUrl() {
        return this.mClickthroughUrl;
    }

    String getDeviceLocale() {
        return this.mDeviceLocale;
    }

    String getDeviceModel() {
        return this.mDeviceModel;
    }

    String getDspCreativeId() {
        return this.mDspCreativeId;
    }

    String getFailUrl() {
        return this.mFailUrl;
    }

    String getHashedUdid() {
        return this.mHashedUdid;
    }

    int getHeight() {
        return this.mHeight;
    }

    String getImpressionUrl() {
        return this.mImpressionUrl;
    }

    String getNetworkType() {
        return this.mNetworkType;
    }

    String getPlatform() {
        return "Android";
    }

    int getPlatformVersion() {
        return this.mPlatformVersion;
    }

    String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    int getRefreshTimeMilliseconds() {
        return this.mRefreshTimeMilliseconds;
    }

    String getResponseString() {
        return this.mResponseString;
    }

    String getSdkVersion() {
        return this.mSdkVersion;
    }

    long getTimeStamp() {
        return this.mTimeStamp;
    }

    String getUserAgent() {
        return this.mUserAgent;
    }

    int getWidth() {
        return this.mWidth;
    }

    void setAdUnitId(String paramString) {
        this.mAdUnitId = paramString;
    }

    @Deprecated
    void setClickthroughUrl(String paramString) {
        this.mClickthroughUrl = paramString;
    }

    void setFailUrl(String paramString) {
        this.mFailUrl = paramString;
    }

    @Deprecated
    void setRefreshTimeMilliseconds(int paramInt) {
        this.mRefreshTimeMilliseconds = paramInt;
    }

    void setResponseString(String paramString) {
        this.mResponseString = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */