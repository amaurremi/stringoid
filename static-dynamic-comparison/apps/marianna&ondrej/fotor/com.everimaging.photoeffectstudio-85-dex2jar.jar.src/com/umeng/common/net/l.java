package com.umeng.common.net;

import org.json.JSONObject;

public abstract class l {
    protected static String b = "POST";
    protected static String c = "GET";
    protected String d;

    public l(String paramString) {
        this.d = paramString;
    }

    public abstract JSONObject a();

    public void a(String paramString) {
        this.d = paramString;
    }

    public abstract String b();

    protected String c() {
        return b;
    }

    public String d() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/common/net/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */