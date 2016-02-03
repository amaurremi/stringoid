package com.inmobi.commons.network;

import com.inmobi.commons.internal.InternalSDKUtil;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Request {
    protected static HashMap<String, Object> mHeaders;
    private Request.Format a = Request.Format.KEY_VAL;
    private final String b = "User-Agent";
    private String c = null;
    private Request.Method d = Request.Method.POST;
    private int e = 0;
    protected HashMap<String, Object> mReqParams = new HashMap();

    public Request(String paramString, Request.Format paramFormat, Request.Method paramMethod) {
        mHeaders = new HashMap();
        RequestBuilderUtils.fillIdentityMap(this.mReqParams, null, true);
        mHeaders.put("User-Agent", InternalSDKUtil.getUserAgent());
        this.a = paramFormat;
        this.c = paramString;
        this.d = paramMethod;
    }

    private String a() {
        Map localMap = InternalSDKUtil.getEncodedMap(this.mReqParams);
        switch (Request.a.a[this.a.ordinal()]) {
            default:
                return null;
            case 1:
                return InternalSDKUtil.encodeMapAndconvertToDelimitedString(this.mReqParams, "&");
        }
        return new JSONObject(localMap).toString();
    }

    public void fillAppInfo() {
        RequestBuilderUtils.fillAppInfoMap(this.mReqParams);
    }

    public void fillCustomInfo(Map<String, Object> paramMap) {
        if (paramMap != null) {
            this.mReqParams.putAll(paramMap);
        }
    }

    public void fillDemogInfo() {
        RequestBuilderUtils.fillDemogMap(this.mReqParams);
    }

    public void fillDeviceInfo() {
        RequestBuilderUtils.fillDeviceMap(this.mReqParams);
    }

    public void fillLocationInfo() {
        RequestBuilderUtils.fillLocationMap(this.mReqParams);
    }

    public Map<String, String> getHeaders() {
        return InternalSDKUtil.getEncodedMap(mHeaders);
    }

    protected String getPostBody() {
        if (this.d != Request.Method.GET) {
            return a();
        }
        return null;
    }

    protected String getQueryParams() {
        if (this.d == Request.Method.GET) {
            return a();
        }
        return null;
    }

    protected Request.Method getRequestMethod() {
        return this.d;
    }

    public int getTimeout() {
        return this.e;
    }

    protected String getUrl() {
        return this.c;
    }

    public void setTimeout(int paramInt) {
        this.e = paramInt;
    }

    protected void setUrl(String paramString) {
        int j = 1;
        int i;
        if (paramString != null) {
            i = 1;
            if ("".equals(paramString.trim())) {
                break label37;
            }
        }
        for (; ; ) {
            if ((i & j) != 0) {
                this.c = paramString;
            }
            return;
            i = 0;
            break;
            label37:
            j = 0;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/network/Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */