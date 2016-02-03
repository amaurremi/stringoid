package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.internal.InternalSDKUtil;

import java.util.Map;

public class PlayableAdsConfigParams {
    String a = "3b3941b6-4683-400a-a542-6ccd3d13abe6";
    String b = "f1478eab-8535-4c85-8ab7-5bdf3f2f7706";

    public String getSecretKey() {
        return this.b;
    }

    public String getSecretToken() {
        return this.a;
    }

    public void setFromMap(Map<String, Object> paramMap) {
        this.a = InternalSDKUtil.getStringFromMap(paramMap, "st");
        this.b = InternalSDKUtil.getStringFromMap(paramMap, "sk");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/configs/PlayableAdsConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */