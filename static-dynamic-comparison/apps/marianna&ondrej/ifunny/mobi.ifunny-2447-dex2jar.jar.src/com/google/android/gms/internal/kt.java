package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ii
public final class kt {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd");

    public static fk a(Context paramContext, fi paramfi, String paramString) {
        JSONObject localJSONObject;
        String str1;
        String str3;
        String str2;
        long l2;
        String str4;
        long l1;
        Object localObject1;
        int i;
        label205:
        Object localObject2;
        label243:
        int j;
        for (; ; ) {
            try {
                localJSONObject = new JSONObject(paramString);
                str1 = localJSONObject.optString("ad_base_url", null);
                paramString = localJSONObject.optString("ad_url", null);
                str3 = localJSONObject.optString("ad_size", null);
                str2 = localJSONObject.optString("ad_html", null);
                l2 = -1L;
                str4 = localJSONObject.optString("debug_dialog", null);
                if (!localJSONObject.has("interstitial_timeout")) {
                    break label654;
                }
                l1 = (localJSONObject.getDouble("interstitial_timeout") * 1000.0D);
                localObject1 = localJSONObject.optString("orientation", null);
                i = -1;
                if ("portrait".equals(localObject1)) {
                    i = lw.c();
                    if (!TextUtils.isEmpty(str2)) {
                        if (!TextUtils.isEmpty(str1)) {
                            break label648;
                        }
                        mx.e("Could not parse the mediation config: Missing required ad_base_url field");
                        return new fk(0);
                    }
                } else {
                    if (!"landscape".equals(localObject1)) {
                        continue;
                    }
                    i = lw.b();
                    continue;
                }
                if (!TextUtils.isEmpty(paramString)) {
                    localObject1 = kq.a(paramContext, paramfi.k.b, paramString, null, null);
                    str1 = ((fk) localObject1).b;
                    str2 = ((fk) localObject1).c;
                    l2 = ((fk) localObject1).n;
                    localObject2 = localJSONObject.optJSONArray("click_urls");
                    if (localObject1 == null) {
                        paramContext = null;
                        if (localObject2 == null) {
                            break;
                        }
                        paramString = paramContext;
                        if (paramContext != null) {
                            break label662;
                        }
                        paramString = new LinkedList();
                        break label662;
                        if (j >= ((JSONArray) localObject2).length()) {
                            break label668;
                        }
                        paramString.add(((JSONArray) localObject2).getString(j));
                        j += 1;
                        continue;
                    }
                } else {
                    mx.e("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                    paramContext = new fk(0);
                    return paramContext;
                }
            } catch (JSONException paramContext) {
                mx.e("Could not parse the mediation config: " + paramContext.getMessage());
                return new fk(0);
            }
            paramContext = ((fk) localObject1).d;
        }
        label336:
        Object localObject3 = localJSONObject.optJSONArray("impression_urls");
        if (localObject1 == null) {
            paramContext = null;
        }
        while (localObject3 != null) {
            paramString = paramContext;
            if (paramContext != null) {
                break label674;
            }
            paramString = new LinkedList();
            break label674;
            label374:
            while (j < ((JSONArray) localObject3).length()) {
                paramString.add(((JSONArray) localObject3).getString(j));
                j += 1;
            }
            paramContext = ((fk) localObject1).f;
            continue;
            label416:
            JSONArray localJSONArray = localJSONObject.optJSONArray("manual_impression_urls");
            if (localObject1 == null) {
            }
            for (paramContext = null; localJSONArray != null; paramContext = ((fk) localObject1).j) {
                paramString = paramContext;
                if (paramContext != null) {
                    break label686;
                }
                paramString = new LinkedList();
                break label686;
                label454:
                while (j < localJSONArray.length()) {
                    paramString.add(localJSONArray.getString(j));
                    j += 1;
                }
            }
        }
        for (; ; ) {
            long l3 = l1;
            j = i;
            if (localObject1 != null) {
                if (((fk) localObject1).l != -1) {
                    i = ((fk) localObject1).l;
                }
                l3 = l1;
                j = i;
                if (((fk) localObject1).g > 0L) {
                    l3 = ((fk) localObject1).g;
                    j = i;
                }
            }
            localObject1 = localJSONObject.optString("active_view");
            paramString = null;
            boolean bool = localJSONObject.optBoolean("ad_is_javascript", false);
            if (bool) {
                paramString = localJSONObject.optString("ad_passback_url", null);
            }
            paramContext = new fk(str1, str2, (List) localObject2, (List) localObject3, l3, false, -1L, paramContext, -1L, j, str3, l2, str4, bool, paramString, (String) localObject1, false, false, paramfi.p, false);
            return paramContext;
            continue;
            localObject3 = paramContext;
            break label416;
            localObject2 = paramContext;
            break label336;
            label648:
            localObject1 = null;
            break label205;
            label654:
            l1 = -1L;
            break;
            label662:
            j = 0;
            break label243;
            label668:
            localObject2 = paramString;
            break label336;
            label674:
            j = 0;
            break label374;
            localObject3 = paramString;
            break label416;
            label686:
            j = 0;
            break label454;
            paramContext = paramString;
        }
    }

    private static Integer a(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (int i = 1; ; i = 0) {
            return Integer.valueOf(i);
        }
    }

    private static String a(int paramInt) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(0xFFFFFF & paramInt)});
    }

    public static String a(fi paramfi, kz paramkz, Location paramLocation, String paramString1, String paramString2) {
        try {
            paramLocation = new HashMap();
            ArrayList localArrayList = new ArrayList();
            if (!TextUtils.isEmpty(paramString1)) {
                localArrayList.add(paramString1);
            }
            if (!TextUtils.isEmpty(paramString2)) {
                localArrayList.add(paramString2);
            }
            if (localArrayList.size() > 0) {
                paramLocation.put("eid", TextUtils.join(",", localArrayList));
            }
            if (paramfi.b != null) {
                paramLocation.put("ad_pos", paramfi.b);
            }
            a(paramLocation, paramfi.c);
            paramLocation.put("format", paramfi.d.b);
            if (paramfi.d.f == -1) {
                paramLocation.put("smart_w", "full");
            }
            if (paramfi.d.c == -2) {
                paramLocation.put("smart_h", "auto");
            }
            if (paramfi.d.h != null) {
                paramString1 = new StringBuilder();
                paramString2 = paramfi.d.h;
                int k = paramString2.length;
                int i = 0;
                if (i < k) {
                    localArrayList = paramString2[i];
                    if (paramString1.length() != 0) {
                        paramString1.append("|");
                    }
                    if (localArrayList.f == -1) {
                        j = (int) (localArrayList.g / paramkz.q);
                        label247:
                        paramString1.append(j);
                        paramString1.append("x");
                        if (localArrayList.c != -2) {
                            break label312;
                        }
                    }
                    label312:
                    for (int j = (int) (localArrayList.d / paramkz.q); ; j = localArrayList.c) {
                        paramString1.append(j);
                        i += 1;
                        break;
                        j = localArrayList.f;
                        break label247;
                    }
                }
                paramLocation.put("sz", paramString1);
            }
            if (paramfi.m != 0) {
                paramLocation.put("native_version", Integer.valueOf(paramfi.m));
                paramLocation.put("native_templates", paramfi.n);
            }
            paramLocation.put("slotname", paramfi.e);
            paramLocation.put("pn", paramfi.f.packageName);
            if (paramfi.g != null) {
                paramLocation.put("vc", Integer.valueOf(paramfi.g.versionCode));
            }
            paramLocation.put("ms", paramfi.h);
            paramLocation.put("seq_num", paramfi.i);
            paramLocation.put("session_id", paramfi.j);
            paramLocation.put("js", paramfi.k.b);
            a(paramLocation, paramkz);
            if ((paramfi.c.a >= 2) && (paramfi.c.k != null)) {
                a(paramLocation, paramfi.c.k);
            }
            if (paramfi.a >= 2) {
                paramLocation.put("quality_signals", paramfi.l);
            }
            if ((paramfi.a >= 4) && (paramfi.p)) {
                paramLocation.put("forceHttps", Boolean.valueOf(paramfi.p));
            }
            if ((paramfi.a >= 3) && (paramfi.o != null)) {
                paramLocation.put("content_info", paramfi.o);
            }
            if (mx.a(2)) {
                paramfi = lw.a(paramLocation).toString(2);
                mx.d("Ad Request JSON: " + paramfi);
            }
            paramfi = lw.a(paramLocation).toString();
            return paramfi;
        } catch (JSONException paramfi) {
            mx.e("Problem serializing ad request to JSON: " + paramfi.getMessage());
        }
        return null;
    }

    private static void a(HashMap<String, Object> paramHashMap, Location paramLocation) {
        HashMap localHashMap = new HashMap();
        float f = paramLocation.getAccuracy();
        long l1 = paramLocation.getTime();
        long l2 = (paramLocation.getLatitude() * 1.0E7D);
        long l3 = (paramLocation.getLongitude() * 1.0E7D);
        localHashMap.put("radius", Float.valueOf(f * 1000.0F));
        localHashMap.put("lat", Long.valueOf(l2));
        localHashMap.put("long", Long.valueOf(l3));
        localHashMap.put("time", Long.valueOf(l1 * 1000L));
        paramHashMap.put("uule", localHashMap);
    }

    private static void a(HashMap<String, Object> paramHashMap, av paramav) {
        String str = ln.a();
        if (str != null) {
            paramHashMap.put("abf", str);
        }
        if (paramav.b != -1L) {
            paramHashMap.put("cust_age", a.format(new Date(paramav.b)));
        }
        if (paramav.c != null) {
            paramHashMap.put("extras", paramav.c);
        }
        if (paramav.d != -1) {
            paramHashMap.put("cust_gender", Integer.valueOf(paramav.d));
        }
        if (paramav.e != null) {
            paramHashMap.put("kw", paramav.e);
        }
        if (paramav.g != -1) {
            paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(paramav.g));
        }
        if (paramav.f) {
            paramHashMap.put("adtest", "on");
        }
        if (paramav.a >= 2) {
            if (paramav.h) {
                paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(paramav.i)) {
                paramHashMap.put("ppid", paramav.i);
            }
            if (paramav.j != null) {
                a(paramHashMap, paramav.j);
            }
        }
        if ((paramav.a >= 3) && (paramav.l != null)) {
            paramHashMap.put("url", paramav.l);
        }
    }

    private static void a(HashMap<String, Object> paramHashMap, bj parambj) {
        Object localObject2 = null;
        if (Color.alpha(parambj.b) != 0) {
            paramHashMap.put("acolor", a(parambj.b));
        }
        if (Color.alpha(parambj.c) != 0) {
            paramHashMap.put("bgcolor", a(parambj.c));
        }
        if ((Color.alpha(parambj.d) != 0) && (Color.alpha(parambj.e) != 0)) {
            paramHashMap.put("gradientto", a(parambj.d));
            paramHashMap.put("gradientfrom", a(parambj.e));
        }
        if (Color.alpha(parambj.f) != 0) {
            paramHashMap.put("bcolor", a(parambj.f));
        }
        paramHashMap.put("bthick", Integer.toString(parambj.g));
        Object localObject1;
        switch (parambj.h) {
            default:
                localObject1 = null;
                if (localObject1 != null) {
                    paramHashMap.put("btype", localObject1);
                }
                switch (parambj.i) {
                    default:
                        localObject1 = localObject2;
                }
                break;
        }
        for (; ; ) {
            if (localObject1 != null) {
                paramHashMap.put("callbuttoncolor", localObject1);
            }
            if (parambj.j != null) {
                paramHashMap.put("channel", parambj.j);
            }
            if (Color.alpha(parambj.k) != 0) {
                paramHashMap.put("dcolor", a(parambj.k));
            }
            if (parambj.l != null) {
                paramHashMap.put("font", parambj.l);
            }
            if (Color.alpha(parambj.m) != 0) {
                paramHashMap.put("hcolor", a(parambj.m));
            }
            paramHashMap.put("headersize", Integer.toString(parambj.n));
            if (parambj.o != null) {
                paramHashMap.put("q", parambj.o);
            }
            return;
            localObject1 = "none";
            break;
            localObject1 = "dashed";
            break;
            localObject1 = "dotted";
            break;
            localObject1 = "solid";
            break;
            localObject1 = "dark";
            continue;
            localObject1 = "light";
            continue;
            localObject1 = "medium";
        }
    }

    private static void a(HashMap<String, Object> paramHashMap, kz paramkz) {
        paramHashMap.put("am", Integer.valueOf(paramkz.a));
        paramHashMap.put("cog", a(paramkz.b));
        paramHashMap.put("coh", a(paramkz.c));
        if (!TextUtils.isEmpty(paramkz.d)) {
            paramHashMap.put("carrier", paramkz.d);
        }
        paramHashMap.put("gl", paramkz.e);
        if (paramkz.f) {
            paramHashMap.put("simulator", Integer.valueOf(1));
        }
        paramHashMap.put("ma", a(paramkz.g));
        paramHashMap.put("sp", a(paramkz.h));
        paramHashMap.put("hl", paramkz.i);
        if (!TextUtils.isEmpty(paramkz.j)) {
            paramHashMap.put("mv", paramkz.j);
        }
        paramHashMap.put("muv", Integer.valueOf(paramkz.k));
        if (paramkz.l != -2) {
            paramHashMap.put("cnt", Integer.valueOf(paramkz.l));
        }
        paramHashMap.put("gnt", Integer.valueOf(paramkz.m));
        paramHashMap.put("pt", Integer.valueOf(paramkz.n));
        paramHashMap.put("rm", Integer.valueOf(paramkz.o));
        paramHashMap.put("riv", Integer.valueOf(paramkz.p));
        paramHashMap.put("u_sd", Float.valueOf(paramkz.q));
        paramHashMap.put("sh", Integer.valueOf(paramkz.s));
        paramHashMap.put("sw", Integer.valueOf(paramkz.r));
        Bundle localBundle = new Bundle();
        localBundle.putInt("active_network_state", paramkz.w);
        localBundle.putBoolean("active_network_metered", paramkz.v);
        paramHashMap.put("connectivity", localBundle);
        localBundle = new Bundle();
        localBundle.putBoolean("is_charging", paramkz.u);
        localBundle.putDouble("battery_level", paramkz.t);
        paramHashMap.put("battery", localBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/kt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */