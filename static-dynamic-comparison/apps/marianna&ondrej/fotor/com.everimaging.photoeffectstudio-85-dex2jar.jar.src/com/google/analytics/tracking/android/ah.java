package com.google.analytics.tracking.android;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

public class ah {
    private final String a;
    private final ai b;
    private final Map<String, String> c = new HashMap();
    private aa d;
    private final g e;
    private final ab f;
    private final f g;

    ah(String paramString1, String paramString2, ai paramai) {
        this(paramString1, paramString2, paramai, g.a(), ab.a(), f.a(), new ac());
    }

    ah(String paramString1, String paramString2, ai paramai, g paramg, ab paramab, f paramf, aa paramaa) {
        if (TextUtils.isEmpty(paramString1)) {
            throw new IllegalArgumentException("Tracker name cannot be empty.");
        }
        this.a = paramString1;
        this.b = paramai;
        this.c.put("&tid", paramString2);
        this.c.put("useSecure", "1");
        this.e = paramg;
        this.f = paramab;
        this.g = paramf;
        this.d = paramaa;
    }

    public void a(String paramString1, String paramString2) {
        GAUsage.a().a(GAUsage.Field.SET);
        if (paramString2 == null) {
            this.c.remove(paramString1);
            return;
        }
        this.c.put(paramString1, paramString2);
    }

    public void a(Map<String, String> paramMap) {
        GAUsage.a().a(GAUsage.Field.SEND);
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(this.c);
        if (paramMap != null) {
            localHashMap.putAll(paramMap);
        }
        if (TextUtils.isEmpty((CharSequence) localHashMap.get("&tid"))) {
            v.d(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str = (String) localHashMap.get("&t");
        paramMap = str;
        if (TextUtils.isEmpty(str)) {
            v.d(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            paramMap = "";
        }
        if ((!paramMap.equals("transaction")) && (!paramMap.equals("item")) && (!this.d.a())) {
            v.d("Too many hits sent too quickly, rate limiting invoked.");
            return;
        }
        this.b.a(localHashMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/google/analytics/tracking/android/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */