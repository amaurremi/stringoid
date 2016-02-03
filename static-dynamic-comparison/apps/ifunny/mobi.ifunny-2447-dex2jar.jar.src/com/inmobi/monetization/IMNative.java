package com.inmobi.monetization;

import android.view.ViewGroup;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.IMAdListener;
import com.inmobi.monetization.internal.NativeAd;
import com.inmobi.monetization.internal.NativeAdObject;

import java.util.HashMap;
import java.util.Map;

public class IMNative {
    NativeAd a;
    private String b = null;
    private String c = null;
    private String d = null;
    private IMNativeListener e = null;
    private String f;
    private IMAdListener g = new b(this);

    public IMNative(IMNativeListener paramIMNativeListener) {
        this.f = InMobi.getAppId();
        a(paramIMNativeListener);
    }

    public IMNative(String paramString, IMNativeListener paramIMNativeListener) {
        this.f = paramString;
        a(paramIMNativeListener);
    }

    protected IMNative(String paramString1, String paramString2, String paramString3) {
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramString3;
    }

    private void a(IMNativeListener paramIMNativeListener) {
        new NativeAdObject(null, null, null);
        this.e = paramIMNativeListener;
        this.a = new NativeAd(this.f);
        this.a.setAdListener(this.g);
    }

    public void attachToView(ViewGroup paramViewGroup) {
        if (this.a != null) {
            this.a.attachToView(paramViewGroup, this.c, this.d);
        }
    }

    public void detachFromView() {
        if (this.a != null) {
            this.a.detachFromView();
        }
    }

    public String getContent() {
        return this.b;
    }

    public void handleClick(HashMap<String, String> paramHashMap) {
        if (this.a != null) {
            this.a.handleClick(paramHashMap);
        }
    }

    public void loadAd() {
        if (this.a != null) {
            this.a.loadAd();
        }
    }

    public void setKeywords(String paramString) {
        if ((paramString == null) || ("".equals(paramString.trim()))) {
            Log.debug("[InMobi]-[Monetization]", "Keywords cannot be null or blank.");
        }
        while (this.a == null) {
            return;
        }
        this.a.setKeywords(paramString);
    }

    @Deprecated
    public void setRefTagParam(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString2 == null)) {
            Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be null");
        }
        HashMap localHashMap;
        do {
            return;
            if ((paramString1.trim().equals("")) || (paramString2.trim().equals(""))) {
                Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be empty");
                return;
            }
            localHashMap = new HashMap();
            localHashMap.put(paramString1, paramString2);
        } while (this.a == null);
        this.a.setRequestParams(localHashMap);
    }

    public void setRequestParams(Map<String, String> paramMap) {
        if ((paramMap == null) || (paramMap.isEmpty())) {
            Log.debug("[InMobi]-[Monetization]", "Request params cannot be null or empty.");
        }
        while (this.a == null) {
            return;
        }
        this.a.setRequestParams(paramMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/IMNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */