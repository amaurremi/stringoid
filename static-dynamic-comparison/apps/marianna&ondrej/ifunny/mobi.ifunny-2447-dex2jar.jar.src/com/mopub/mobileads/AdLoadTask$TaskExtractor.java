package com.mopub.mobileads;

import android.net.Uri;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Json;
import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.HttpResponses;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

class AdLoadTask$TaskExtractor {
    private String adType;
    private String adTypeCustomEventName;
    private final AdViewController adViewController;
    private String fullAdType;
    private final HttpResponse response;

    AdLoadTask$TaskExtractor(HttpResponse paramHttpResponse, AdViewController paramAdViewController) {
        this.response = paramHttpResponse;
        this.adViewController = paramAdViewController;
    }

    private AdLoadTask createCustomEventAdLoadTask(String paramString) {
        HashMap localHashMap = new HashMap();
        localHashMap.put(ResponseHeader.CUSTOM_EVENT_NAME.getKey(), this.adTypeCustomEventName);
        if (paramString != null) {
            localHashMap.put(ResponseHeader.CUSTOM_EVENT_DATA.getKey(), paramString);
        }
        return new AdLoadTask.CustomEventAdLoadTask(this.adViewController, localHashMap);
    }

    private boolean eventDataIsInResponseBody(String paramString) {
        return ("mraid".equals(paramString)) || ("html".equals(paramString)) || (("interstitial".equals(paramString)) && ("vast".equals(this.fullAdType)));
    }

    private AdLoadTask extractCustomEventAdLoadTask() {
        MoPubLog.i("Performing custom event.");
        this.adTypeCustomEventName = HttpResponses.extractHeader(this.response, ResponseHeader.CUSTOM_EVENT_NAME);
        if (this.adTypeCustomEventName != null) {
            localObject = HttpResponses.extractHeader(this.response, ResponseHeader.CUSTOM_EVENT_DATA);
            this.adViewController.getMoPubView().report(this.adType + "\n" + this.adTypeCustomEventName);
            return createCustomEventAdLoadTask((String) localObject);
        }
        Object localObject = this.response.getFirstHeader(ResponseHeader.CUSTOM_SELECTOR.getKey());
        this.adViewController.getMoPubView().report(this.adType + "\n" + localObject);
        return new AdLoadTask.LegacyCustomEventAdLoadTask(this.adViewController, (Header) localObject);
    }

    private AdLoadTask extractCustomEventAdLoadTaskFromNativeParams() {
        String str = HttpResponses.extractHeader(this.response, ResponseHeader.NATIVE_PARAMS);
        this.adViewController.getMoPubView().report(this.adType + "\n" + this.adTypeCustomEventName);
        return createCustomEventAdLoadTask(str);
    }

    private AdLoadTask extractCustomEventAdLoadTaskFromResponseBody() {
        Object localObject = this.response.getEntity();
        if (localObject != null) {
        }
        for (localObject = Strings.fromStream(((HttpEntity) localObject).getContent()); ; localObject = "") {
            this.adViewController.getAdConfiguration().setResponseString((String) localObject);
            String str1 = HttpResponses.extractHeader(this.response, ResponseHeader.REDIRECT_URL);
            String str2 = HttpResponses.extractHeader(this.response, ResponseHeader.CLICKTHROUGH_URL);
            boolean bool = HttpResponses.extractBooleanHeader(this.response, ResponseHeader.SCROLLABLE, false);
            HashMap localHashMap = new HashMap();
            localHashMap.put("Html-Response-Body", Uri.encode((String) localObject));
            localHashMap.put("Scrollable", Boolean.toString(bool));
            if (str1 != null) {
                localHashMap.put("Redirect-Url", str1);
            }
            if (str2 != null) {
                localHashMap.put("Clickthrough-Url", str2);
            }
            return createCustomEventAdLoadTask(Json.mapToJsonString(localHashMap));
        }
    }

    AdLoadTask extract() {
        this.adType = HttpResponses.extractHeader(this.response, ResponseHeader.AD_TYPE);
        this.fullAdType = HttpResponses.extractHeader(this.response, ResponseHeader.FULL_AD_TYPE);
        MoPubLog.d("Loading ad type: " + AdTypeTranslator.getAdNetworkType(this.adType, this.fullAdType));
        this.adTypeCustomEventName = AdTypeTranslator.getCustomEventNameForAdType(this.adViewController.getMoPubView(), this.adType, this.fullAdType);
        this.adViewController.getMoPubView().report(this.adType + "\n" + this.adTypeCustomEventName);
        if ("custom".equals(this.adType)) {
            return extractCustomEventAdLoadTask();
        }
        if (eventDataIsInResponseBody(this.adType)) {
            return extractCustomEventAdLoadTaskFromResponseBody();
        }
        return extractCustomEventAdLoadTaskFromNativeParams();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdLoadTask$TaskExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */