package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

@ii
public final class di {
    public final List<dh> a;
    public final long b;
    public final List<String> c;
    public final List<String> d;
    public final List<String> e;
    public final String f;
    public final long g;
    public int h;
    public int i;

    public di(String paramString) {
        paramString = new JSONObject(paramString);
        if (mx.a(2)) {
            mx.d("Mediation Response JSON: " + paramString.toString(2));
        }
        JSONArray localJSONArray = paramString.getJSONArray("ad_networks");
        ArrayList localArrayList = new ArrayList(localJSONArray.length());
        int k = -1;
        int j = 0;
        while (j < localJSONArray.length()) {
            dh localdh = new dh(localJSONArray.getJSONObject(j));
            localArrayList.add(localdh);
            int m = k;
            if (k < 0) {
                m = k;
                if (a(localdh)) {
                    m = j;
                }
            }
            j += 1;
            k = m;
        }
        this.h = k;
        this.i = localJSONArray.length();
        this.a = Collections.unmodifiableList(localArrayList);
        this.f = paramString.getString("qdata");
        paramString = paramString.optJSONObject("settings");
        if (paramString != null) {
            this.b = paramString.optLong("ad_network_timeout_millis", -1L);
            this.c = dr.a(paramString, "click_urls");
            this.d = dr.a(paramString, "imp_urls");
            this.e = dr.a(paramString, "nofill_urls");
            long l = paramString.optLong("refresh", -1L);
            if (l > 0L) {
            }
            for (l *= 1000L; ; l = -1L) {
                this.g = l;
                return;
            }
        }
        this.b = -1L;
        this.c = null;
        this.d = null;
        this.e = null;
        this.g = -1L;
    }

    private boolean a(dh paramdh) {
        paramdh = paramdh.c.iterator();
        while (paramdh.hasNext()) {
            if (((String) paramdh.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */