package com.facebook.ads.internal;

import android.content.Context;
import com.facebook.ads.AdError;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class AdResponse {
    private static final int DEFAULT_REFRESH_INTERVAL_SECONDS = 0;
    private static final int DEFAULT_REFRESH_THRESHOLD_SECONDS = 20;
    private final List<AdDataModel> dataModels;
    private final AdError error;
    private final int refreshIntervalMillis;
    private final int refreshThresholdMillis;

    private AdResponse(int paramInt1, int paramInt2, List<AdDataModel> paramList, AdError paramAdError) {
        this.refreshIntervalMillis = paramInt1;
        this.refreshThresholdMillis = paramInt2;
        this.dataModels = paramList;
        this.error = paramAdError;
    }

    public static AdResponse parseResponse(Context paramContext, JSONObject paramJSONObject) {
        int i = 0;
        int j = paramJSONObject.optInt("refresh", 0);
        int k = paramJSONObject.optInt("refresh_threshold", 20);
        Object localObject = paramJSONObject.optJSONObject("reason");
        if (localObject != null) {
        }
        for (localObject = new AdError(((JSONObject) localObject).optInt("code"), ((JSONObject) localObject).optString("message")); ; localObject = null) {
            int m = paramJSONObject.optInt("ad_type");
            ArrayList localArrayList = new ArrayList();
            JSONArray localJSONArray = paramJSONObject.optJSONArray("ads");
            paramJSONObject = (JSONObject) localObject;
            if (localJSONArray != null) {
                paramJSONObject = (JSONObject) localObject;
                if (localJSONArray.length() > 0) {
                    if (i < localJSONArray.length()) {
                        paramJSONObject = localJSONArray.optJSONObject(i);
                        if (paramJSONObject != null) {
                        }
                    }
                }
            }
            label238:
            for (; ; ) {
                i += 1;
                break;
                if (m == AdType.HTML.getValue()) {
                    paramJSONObject = HtmlAdDataModel.fromJSONObject(paramJSONObject.optJSONObject("data"));
                }
                for (; ; ) {
                    if ((paramJSONObject == null) || (AdInvalidationUtils.shouldInvalidate(paramContext, paramJSONObject))) {
                        break label238;
                    }
                    localArrayList.add(paramJSONObject);
                    break;
                    if (m == AdType.NATIVE.getValue()) {
                        paramJSONObject = NativeAdDataModel.fromJSONObject(paramJSONObject.optJSONObject("metadata"));
                        continue;
                        paramJSONObject = (JSONObject) localObject;
                        if (localArrayList.isEmpty()) {
                            paramJSONObject = AdError.NO_FILL;
                        }
                        return new AdResponse(j * 1000, k * 1000, localArrayList, paramJSONObject);
                    } else {
                        paramJSONObject = null;
                    }
                }
            }
        }
    }

    public AdDataModel getDataModel() {
        if ((this.dataModels == null) || (this.dataModels.isEmpty())) {
            return null;
        }
        return (AdDataModel) this.dataModels.get(0);
    }

    public AdError getError() {
        return this.error;
    }

    public int getRefreshIntervalMillis() {
        return this.refreshIntervalMillis;
    }

    public int getRefreshThresholdMillis() {
        return this.refreshThresholdMillis;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */