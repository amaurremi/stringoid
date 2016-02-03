package com.inmobi.monetization.internal;

import com.inmobi.commons.internal.EncryptionUtils;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.Request.Format;
import com.inmobi.commons.network.Request.Method;
import com.inmobi.commons.network.RequestBuilderUtils;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.PkInitilaizer;
import com.inmobi.monetization.internal.configs.PkParams;

import java.util.HashMap;
import java.util.Map;

class i
        extends Request {
    protected static String a = "http://i.w.inmobi.com/showad.asm";
    private static byte[] e;
    private static byte[] f;
    private static byte[] g;
    String b = "";
    String c = "";
    String d = "";

    public i() {
        super(a, Request.Format.KEY_VAL, Request.Method.POST);
        RequestBuilderUtils.fillIdentityMap(this.mReqParams, Initializer.getConfigParams().getDeviceIdMaskMap(), false);
        RequestBuilderUtils.fillAppInfoMap(this.mReqParams);
        RequestBuilderUtils.fillDemogMap(this.mReqParams);
        RequestBuilderUtils.fillDeviceMap(this.mReqParams);
        RequestBuilderUtils.fillLocationMap(this.mReqParams);
        setTimeout(Initializer.getConfigParams().getFetchTimeOut());
    }

    String a(String paramString) {
        HashMap localHashMap = new HashMap();
        g = EncryptionUtils.generateKey(8);
        f = EncryptionUtils.generateKey(16);
        e = EncryptionUtils.keag();
        this.b = PkInitilaizer.getConfigParams().getExponent();
        this.c = PkInitilaizer.getConfigParams().getModulus();
        this.d = PkInitilaizer.getConfigParams().getVersion();
        if ((this.b.equals("")) || (this.c.equals("")) || (this.d.equals(""))) {
            Log.debug("[InMobi]-[Monetization]", "Exception retreiving Ad due to key problem");
            return null;
        }
        localHashMap.put("sm", EncryptionUtils.SeMeGe(paramString, e, f, g, this.c, this.b));
        localHashMap.put("sn", this.d);
        return InternalSDKUtil.encodeMapAndconvertToDelimitedString(localHashMap, "&");
    }

    void a(Map<String, String> paramMap) {
        if ((this.mReqParams != null) && (paramMap != null) && (!paramMap.isEmpty())) {
            this.mReqParams.putAll(paramMap);
        }
    }

    byte[] a() {
        return f;
    }

    void b(Map<String, String> paramMap) {
        if ((this.mReqParams != null) && (paramMap != null)) {
            this.mReqParams.putAll(paramMap);
        }
    }

    byte[] b() {
        return e;
    }

    protected String getPostBody() {
        String str = super.getPostBody();
        Log.internal("[InMobi]-[Monetization]", "Raw Postbody: " + str);
        return a(str);
    }

    protected void setUrl(String paramString) {
        super.setUrl(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */