package com.facebook.ads.internal;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class AppSiteData {
    private final String appLinkUri;
    private final String className;
    private final String fallbackUrl;
    private final List<String> keyHashes;
    private final String marketUri;
    private final String packageName;

    private AppSiteData(String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, String paramString5) {
        this.packageName = paramString1;
        this.className = paramString2;
        this.appLinkUri = paramString3;
        this.keyHashes = paramList;
        this.marketUri = paramString4;
        this.fallbackUrl = paramString5;
    }

    public static AppSiteData fromJSONObject(JSONObject paramJSONObject) {
        if (paramJSONObject == null) {
            return null;
        }
        String str1 = paramJSONObject.optString("package");
        String str2 = paramJSONObject.optString("appsite");
        String str3 = paramJSONObject.optString("appsite_url");
        JSONArray localJSONArray = paramJSONObject.optJSONArray("key_hashes");
        ArrayList localArrayList = new ArrayList();
        if (localJSONArray != null) {
            int i = 0;
            while (i < localJSONArray.length()) {
                localArrayList.add(localJSONArray.optString(i));
                i += 1;
            }
        }
        return new AppSiteData(str1, str2, str3, localArrayList, paramJSONObject.optString("market_uri"), paramJSONObject.optString("fallback_url"));
    }

    public String getAppLinkUri() {
        return this.appLinkUri;
    }

    public String getClassName() {
        return this.className;
    }

    public String getFallbackUrl() {
        return this.fallbackUrl;
    }

    public List<String> getKeyHashes() {
        return this.keyHashes;
    }

    public String getMarketUri() {
        return this.marketUri;
    }

    public String getPackageName() {
        return this.packageName;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AppSiteData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */