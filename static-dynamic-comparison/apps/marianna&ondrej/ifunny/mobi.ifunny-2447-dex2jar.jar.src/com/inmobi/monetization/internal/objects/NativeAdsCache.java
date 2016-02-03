package com.inmobi.monetization.internal.objects;

import android.content.Context;
import android.util.Base64;
import com.inmobi.commons.ads.cache.AdData;
import com.inmobi.commons.ads.cache.AdDatabaseManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.NativeAdObject;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.NativeConfigParams;

import java.util.List;

import org.json.JSONObject;

public class NativeAdsCache {
    static NativeAdsCache a;

    private NativeAdsCache(Context paramContext) {
    }

    public static NativeAdsCache getInstance() {
        if (a == null) {
        }
        try {
            a = new NativeAdsCache(InternalSDKUtil.getContext());
            AdDatabaseManager.getInstance().setDBLimit(Initializer.getConfigParams().getNativeSdkConfigParams().getmMaxCacheSize());
            return a;
        } finally {
        }
    }

    public NativeAdObject getCachedAd(String paramString) {
        try {
            paramString = new JSONObject(AdDatabaseManager.getInstance().getAd(paramString).getContent());
            paramString = new NativeAdObject(new String(Base64.decode(paramString.getString("pubContent"), 0)).trim(), paramString.getString("contextCode"), paramString.getString("namespace"));
            return paramString;
        } catch (Exception paramString) {
            Log.internal("[InMobi]-[Monetization]", "Exception getting cached ad", paramString);
        }
        return null;
    }

    public int getNumCachedAds(String paramString) {
        try {
            int i = AdDatabaseManager.getInstance().getNoOfAds(paramString);
            return i;
        } catch (Exception paramString) {
        }
        return 0;
    }

    public void removeExpiredAds() {
        long l = Initializer.getConfigParams().getNativeSdkConfigParams().getTimeToLive();
        AdDatabaseManager.getInstance().removeExpiredAds(l, "native");
    }

    public void saveNativeAds(String paramString, List<String> paramList) {
        if ((paramList != null) && (paramList.size() > 0)) {
            int i = 0;
            while (i < paramList.size()) {
                AdData localAdData = new AdData();
                localAdData.setContent((String) paramList.get(i));
                localAdData.setTimestamp(System.currentTimeMillis());
                localAdData.setAppId(paramString);
                localAdData.setAdType("native");
                AdDatabaseManager.getInstance().insertAd(localAdData);
                i += 1;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/objects/NativeAdsCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */