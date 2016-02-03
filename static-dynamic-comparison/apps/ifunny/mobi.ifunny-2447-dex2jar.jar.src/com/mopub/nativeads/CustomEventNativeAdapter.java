package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.DownloadResponse;
import com.mopub.common.HttpResponses;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Json;
import com.mopub.common.util.ResponseHeader;
import com.mopub.nativeads.factories.CustomEventNativeFactory;

import java.util.HashMap;
import java.util.Map;

final class CustomEventNativeAdapter {
    static final String RESPONSE_BODY_KEY = "response_body_key";

    public static void loadNativeAd(Context paramContext, Map<String, Object> paramMap, DownloadResponse paramDownloadResponse, CustomEventNative.CustomEventNativeListener paramCustomEventNativeListener) {
        str = paramDownloadResponse.getFirstHeader(ResponseHeader.CUSTOM_EVENT_DATA);
        localObject = paramDownloadResponse.getFirstHeader(ResponseHeader.CUSTOM_EVENT_NAME);
        try {
            localCustomEventNative = CustomEventNativeFactory.create((String) localObject);
            localObject = new HashMap();
        } catch (Exception paramContext) {
            CustomEventNative localCustomEventNative;
            Map localMap;
            label45:
            MoPubLog.w("Failed to load Custom Event Native class: " + (String) localObject);
            paramCustomEventNativeListener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
            return;
        }
        try {
            localMap = Json.jsonStringToMap(str);
            localObject = localMap;
        } catch (Exception localException) {
            MoPubLog.w("Failed to create Map from JSON: " + str, localException);
            break label45;
        }
        ((Map) localObject).put("response_body_key", HttpResponses.asResponseString(paramDownloadResponse));
        localCustomEventNative.loadNativeAd(paramContext, paramCustomEventNativeListener, paramMap, (Map) localObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/CustomEventNativeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */