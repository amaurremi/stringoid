package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.location.Location;
import android.text.TextUtils;
import com.atomic.apps.ringtone.cutter.aa;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bu
{
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd");
  
  public static cz a(Context paramContext, cx paramcx, String paramString)
  {
    JSONObject localJSONObject;
    Object localObject1;
    String str2;
    String str1;
    long l2;
    String str3;
    long l1;
    Object localObject2;
    int i;
    label203:
    label241:
    int j;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optString("ad_base_url", null);
        localObject1 = localJSONObject.optString("ad_url", null);
        str2 = localJSONObject.optString("ad_size", null);
        str1 = localJSONObject.optString("ad_html", null);
        l2 = -1L;
        str3 = localJSONObject.optString("debug_dialog", null);
        if (!localJSONObject.has("interstitial_timeout")) {
          break label641;
        }
        l1 = (localJSONObject.getDouble("interstitial_timeout") * 1000.0D);
        localObject2 = localJSONObject.optString("orientation", null);
        i = -1;
        if ("portrait".equals(localObject2))
        {
          i = bN.c();
          if (!TextUtils.isEmpty(str1))
          {
            if (!TextUtils.isEmpty(paramString)) {
              break label635;
            }
            aa.e("Could not parse the mediation config: Missing required ad_base_url field");
            return new cz(0);
          }
        }
        else
        {
          if (!"landscape".equals(localObject2)) {
            continue;
          }
          i = bN.b();
          continue;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = br.a(paramContext, paramcx.k.b, (String)localObject1);
          paramString = ((cz)localObject1).b;
          str1 = ((cz)localObject1).c;
          l2 = ((cz)localObject1).n;
          localObject2 = localJSONObject.optJSONArray("click_urls");
          if (localObject1 == null)
          {
            paramContext = null;
            if (localObject2 == null) {
              break;
            }
            paramcx = paramContext;
            if (paramContext != null) {
              break label649;
            }
            paramcx = new LinkedList();
            break label649;
            if (j >= ((JSONArray)localObject2).length()) {
              break label655;
            }
            paramcx.add(((JSONArray)localObject2).getString(j));
            j += 1;
            continue;
          }
        }
        else
        {
          aa.e("Could not parse the mediation config: Missing required ad_html or ad_url field.");
          paramContext = new cz(0);
          return paramContext;
        }
      }
      catch (JSONException paramContext)
      {
        aa.e("Could not parse the mediation config: " + paramContext.getMessage());
        return new cz(0);
      }
      paramContext = ((cz)localObject1).d;
    }
    label331:
    Object localObject3 = localJSONObject.optJSONArray("impression_urls");
    if (localObject1 == null) {
      paramContext = null;
    }
    while (localObject3 != null)
    {
      paramcx = paramContext;
      if (paramContext != null) {
        break label661;
      }
      paramcx = new LinkedList();
      break label661;
      label369:
      while (j < ((JSONArray)localObject3).length())
      {
        paramcx.add(((JSONArray)localObject3).getString(j));
        j += 1;
      }
      paramContext = ((cz)localObject1).f;
      continue;
      label411:
      JSONArray localJSONArray = localJSONObject.optJSONArray("manual_impression_urls");
      if (localObject1 == null) {}
      for (paramContext = null; localJSONArray != null; paramContext = ((cz)localObject1).j)
      {
        paramcx = paramContext;
        if (paramContext != null) {
          break label673;
        }
        paramcx = new LinkedList();
        break label673;
        label449:
        while (j < localJSONArray.length())
        {
          paramcx.add(localJSONArray.getString(j));
          j += 1;
        }
      }
    }
    for (;;)
    {
      long l3 = l1;
      j = i;
      if (localObject1 != null)
      {
        if (((cz)localObject1).l != -1) {
          i = ((cz)localObject1).l;
        }
        l3 = l1;
        j = i;
        if (((cz)localObject1).g > 0L)
        {
          l3 = ((cz)localObject1).g;
          j = i;
        }
      }
      localObject1 = localJSONObject.optString("active_view");
      paramcx = null;
      boolean bool = localJSONObject.optBoolean("ad_is_javascript", false);
      if (bool) {
        paramcx = localJSONObject.optString("ad_passback_url", null);
      }
      paramContext = new cz(paramString, str1, (List)localObject2, (List)localObject3, l3, false, -1L, paramContext, -1L, j, str2, l2, str3, bool, paramcx, (String)localObject1);
      return paramContext;
      continue;
      localObject3 = paramContext;
      break label411;
      localObject2 = paramContext;
      break label331;
      label635:
      localObject1 = null;
      break label203;
      label641:
      l1 = -1L;
      break;
      label649:
      j = 0;
      break label241;
      label655:
      localObject2 = paramcx;
      break label331;
      label661:
      j = 0;
      break label369;
      localObject3 = paramcx;
      break label411;
      label673:
      j = 0;
      break label449;
      paramContext = paramcx;
    }
  }
  
  private static Integer a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return Integer.valueOf(i);
    }
  }
  
  private static String a(int paramInt)
  {
    return String.format(Locale.US, "#%06x", new Object[] { Integer.valueOf(0xFFFFFF & paramInt) });
  }
  
  public static String a(cx paramcx, bz parambz, String paramString)
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        if ((paramString != null) && (paramString.trim() != "")) {
          localHashMap.put("eid", paramString);
        }
        if (paramcx.b != null) {
          localHashMap.put("ad_pos", paramcx.b);
        }
        Object localObject = paramcx.c;
        paramString = bH.a();
        if (paramString != null) {
          localHashMap.put("abf", paramString);
        }
        if (((ah)localObject).b != -1L) {
          localHashMap.put("cust_age", a.format(new Date(((ah)localObject).b)));
        }
        if (((ah)localObject).c != null) {
          localHashMap.put("extras", ((ah)localObject).c);
        }
        if (((ah)localObject).d != -1) {
          localHashMap.put("cust_gender", Integer.valueOf(((ah)localObject).d));
        }
        if (((ah)localObject).e != null) {
          localHashMap.put("kw", ((ah)localObject).e);
        }
        if (((ah)localObject).g != -1) {
          localHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(((ah)localObject).g));
        }
        if (((ah)localObject).f) {
          localHashMap.put("adtest", "on");
        }
        av localav;
        if (((ah)localObject).a >= 2)
        {
          if (((ah)localObject).h) {
            localHashMap.put("d_imp_hdr", Integer.valueOf(1));
          }
          if (!TextUtils.isEmpty(((ah)localObject).i)) {
            localHashMap.put("ppid", ((ah)localObject).i);
          }
          if (((ah)localObject).j != null)
          {
            localav = ((ah)localObject).j;
            if (Color.alpha(localav.b) != 0) {
              localHashMap.put("acolor", a(localav.b));
            }
            if (Color.alpha(localav.c) != 0) {
              localHashMap.put("bgcolor", a(localav.c));
            }
            if ((Color.alpha(localav.d) != 0) && (Color.alpha(localav.e) != 0))
            {
              localHashMap.put("gradientto", a(localav.d));
              localHashMap.put("gradientfrom", a(localav.e));
            }
            if (Color.alpha(localav.f) != 0) {
              localHashMap.put("bcolor", a(localav.f));
            }
            localHashMap.put("bthick", Integer.toString(localav.g));
          }
        }
        switch (localav.h)
        {
        default: 
          if (paramString != null) {
            localHashMap.put("btype", paramString);
          }
          switch (localav.i)
          {
          default: 
            if (paramString != null) {
              localHashMap.put("callbuttoncolor", paramString);
            }
            if (localav.j != null) {
              localHashMap.put("channel", localav.j);
            }
            if (Color.alpha(localav.k) != 0) {
              localHashMap.put("dcolor", a(localav.k));
            }
            if (localav.l != null) {
              localHashMap.put("font", localav.l);
            }
            if (Color.alpha(localav.m) != 0) {
              localHashMap.put("hcolor", a(localav.m));
            }
            localHashMap.put("headersize", Integer.toString(localav.n));
            if (localav.o != null) {
              localHashMap.put("q", localav.o);
            }
            if ((((ah)localObject).a >= 3) && (((ah)localObject).l != null)) {
              localHashMap.put("url", ((ah)localObject).l);
            }
            localHashMap.put("format", paramcx.d.b);
            if (paramcx.d.f == -1) {
              localHashMap.put("smart_w", "full");
            }
            if (paramcx.d.c == -2) {
              localHashMap.put("smart_h", "auto");
            }
            if (paramcx.d.h != null)
            {
              paramString = new StringBuilder();
              localObject = paramcx.d.h;
              int k = localObject.length;
              int i = 0;
              if (i < k)
              {
                localav = localObject[i];
                if (paramString.length() != 0) {
                  paramString.append("|");
                }
                if (localav.f == -1)
                {
                  j = (int)(localav.g / parambz.q);
                  paramString.append(j);
                  paramString.append("x");
                  if (localav.c == -2)
                  {
                    j = (int)(localav.d / parambz.q);
                    paramString.append(j);
                    i += 1;
                  }
                }
                else
                {
                  j = localav.f;
                  continue;
                }
                int j = localav.c;
                continue;
              }
              localHashMap.put("sz", paramString);
            }
            localHashMap.put("slotname", paramcx.e);
            localHashMap.put("pn", paramcx.f.packageName);
            if (paramcx.g != null) {
              localHashMap.put("vc", Integer.valueOf(paramcx.g.versionCode));
            }
            localHashMap.put("ms", paramcx.h);
            localHashMap.put("seq_num", paramcx.i);
            localHashMap.put("session_id", paramcx.j);
            localHashMap.put("js", paramcx.k.b);
            localHashMap.put("am", Integer.valueOf(parambz.a));
            localHashMap.put("cog", a(parambz.b));
            localHashMap.put("coh", a(parambz.c));
            if (!TextUtils.isEmpty(parambz.d)) {
              localHashMap.put("carrier", parambz.d);
            }
            localHashMap.put("gl", parambz.e);
            if (parambz.f) {
              localHashMap.put("simulator", Integer.valueOf(1));
            }
            localHashMap.put("ma", a(parambz.g));
            localHashMap.put("sp", a(parambz.h));
            localHashMap.put("hl", parambz.i);
            if (!TextUtils.isEmpty(parambz.j)) {
              localHashMap.put("mv", parambz.j);
            }
            localHashMap.put("muv", Integer.valueOf(parambz.k));
            if (parambz.l != -2) {
              localHashMap.put("cnt", Integer.valueOf(parambz.l));
            }
            localHashMap.put("gnt", Integer.valueOf(parambz.m));
            localHashMap.put("pt", Integer.valueOf(parambz.n));
            localHashMap.put("rm", Integer.valueOf(parambz.o));
            localHashMap.put("riv", Integer.valueOf(parambz.p));
            localHashMap.put("u_sd", Float.valueOf(parambz.q));
            localHashMap.put("sh", Integer.valueOf(parambz.s));
            localHashMap.put("sw", Integer.valueOf(parambz.r));
            if ((paramcx.c.a >= 2) && (paramcx.c.k != null))
            {
              parambz = paramcx.c.k;
              paramString = new HashMap();
              float f = parambz.getAccuracy();
              long l1 = parambz.getTime();
              long l2 = (parambz.getLatitude() * 1.0E7D);
              long l3 = (parambz.getLongitude() * 1.0E7D);
              paramString.put("radius", Float.valueOf(f * 1000.0F));
              paramString.put("lat", Long.valueOf(l2));
              paramString.put("long", Long.valueOf(l3));
              paramString.put("time", Long.valueOf(l1 * 1000L));
              localHashMap.put("uule", paramString);
            }
            if (paramcx.a >= 2) {
              localHashMap.put("quality_signals", paramcx.l);
            }
            if (aa.a(2))
            {
              paramcx = bN.a(localHashMap).toString(2);
              aa.d("Ad Request JSON: " + paramcx);
            }
            paramcx = bN.a(localHashMap).toString();
            return paramcx;
          }
          break;
        }
      }
      catch (JSONException paramcx)
      {
        aa.e("Problem serializing ad request to JSON: " + paramcx.getMessage());
        return null;
      }
      paramString = null;
      continue;
      paramString = null;
      continue;
      paramString = "none";
      continue;
      paramString = "dashed";
      continue;
      paramString = "dotted";
      continue;
      paramString = "solid";
      continue;
      paramString = "dark";
      continue;
      paramString = "light";
      continue;
      paramString = "medium";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */