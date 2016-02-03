package com.google.analytics.tracking.android;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

public class w {
    private Map<String, String> a = new HashMap();

    public static w a(String paramString, Boolean paramBoolean) {
        GAUsage.a().a(GAUsage.Field.CONSTRUCT_EXCEPTION);
        w localw = new w();
        localw.a("&t", "exception");
        localw.a("&exd", paramString);
        localw.a("&exf", a(paramBoolean));
        return localw;
    }

    public static w a(String paramString1, String paramString2, String paramString3, Long paramLong) {
        GAUsage.a().a(GAUsage.Field.CONSTRUCT_EVENT);
        w localw = new w();
        localw.a("&t", "event");
        localw.a("&ec", paramString1);
        localw.a("&ea", paramString2);
        localw.a("&el", paramString3);
        if (paramLong == null) {
        }
        for (paramString1 = null; ; paramString1 = Long.toString(paramLong.longValue())) {
            localw.a("&ev", paramString1);
            return localw;
        }
    }

    static String a(Boolean paramBoolean) {
        if (paramBoolean == null) {
            return null;
        }
        if (paramBoolean.booleanValue()) {
            return "1";
        }
        return "0";
    }

    public w a(String paramString) {
        GAUsage.a().a(GAUsage.Field.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
        paramString = aj.b(paramString);
        if (TextUtils.isEmpty(paramString)) {
            return this;
        }
        paramString = aj.a(paramString);
        a("&cc", (String) paramString.get("utm_content"));
        a("&cm", (String) paramString.get("utm_medium"));
        a("&cn", (String) paramString.get("utm_campaign"));
        a("&cs", (String) paramString.get("utm_source"));
        a("&ck", (String) paramString.get("utm_term"));
        a("&ci", (String) paramString.get("utm_id"));
        a("&gclid", (String) paramString.get("gclid"));
        a("&dclid", (String) paramString.get("dclid"));
        a("&gmob_t", (String) paramString.get("gmob_t"));
        return this;
    }

    public w a(String paramString1, String paramString2) {
        GAUsage.a().a(GAUsage.Field.MAP_BUILDER_SET);
        if (paramString1 != null) {
            this.a.put(paramString1, paramString2);
            return this;
        }
        v.d(" MapBuilder.set() called with a null paramName.");
        return this;
    }

    public Map<String, String> a() {
        return new HashMap(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */