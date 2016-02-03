package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dy
{
  private static final SimpleDateFormat qA = new SimpleDateFormat("yyyyMMdd");
  
  public static du a(Context paramContext, ds paramds, String paramString)
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
    label205:
    label243:
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
          break label646;
        }
        l1 = (localJSONObject.getDouble("interstitial_timeout") * 1000.0D);
        localObject2 = localJSONObject.optString("orientation", null);
        i = -1;
        if ("portrait".equals(localObject2))
        {
          i = eo.bS();
          if (!TextUtils.isEmpty(str1))
          {
            if (!TextUtils.isEmpty(paramString)) {
              break label640;
            }
            eu.D("Could not parse the mediation config: Missing required ad_base_url field");
            return new du(0);
          }
        }
        else
        {
          if (!"landscape".equals(localObject2)) {
            continue;
          }
          i = eo.bR();
          continue;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = dx.a(paramContext, paramds.kQ.sw, (String)localObject1, null, null);
          paramString = ((du)localObject1).oA;
          str1 = ((du)localObject1).qe;
          l2 = ((du)localObject1).qk;
          localObject2 = localJSONObject.optJSONArray("click_urls");
          if (localObject1 == null)
          {
            paramContext = null;
            if (localObject2 == null) {
              break;
            }
            paramds = paramContext;
            if (paramContext != null) {
              break label654;
            }
            paramds = new LinkedList();
            break label654;
            if (j >= ((JSONArray)localObject2).length()) {
              break label660;
            }
            paramds.add(((JSONArray)localObject2).getString(j));
            j += 1;
            continue;
          }
        }
        else
        {
          eu.D("Could not parse the mediation config: Missing required ad_html or ad_url field.");
          paramContext = new du(0);
          return paramContext;
        }
      }
      catch (JSONException paramContext)
      {
        eu.D("Could not parse the mediation config: " + paramContext.getMessage());
        return new du(0);
      }
      paramContext = ((du)localObject1).nt;
    }
    label336:
    Object localObject3 = localJSONObject.optJSONArray("impression_urls");
    if (localObject1 == null) {
      paramContext = null;
    }
    while (localObject3 != null)
    {
      paramds = paramContext;
      if (paramContext != null) {
        break label666;
      }
      paramds = new LinkedList();
      break label666;
      label374:
      while (j < ((JSONArray)localObject3).length())
      {
        paramds.add(((JSONArray)localObject3).getString(j));
        j += 1;
      }
      paramContext = ((du)localObject1).nu;
      continue;
      label416:
      JSONArray localJSONArray = localJSONObject.optJSONArray("manual_impression_urls");
      if (localObject1 == null) {}
      for (paramContext = null; localJSONArray != null; paramContext = ((du)localObject1).qi)
      {
        paramds = paramContext;
        if (paramContext != null) {
          break label678;
        }
        paramds = new LinkedList();
        break label678;
        label454:
        while (j < localJSONArray.length())
        {
          paramds.add(localJSONArray.getString(j));
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
        if (((du)localObject1).orientation != -1) {
          i = ((du)localObject1).orientation;
        }
        l3 = l1;
        j = i;
        if (((du)localObject1).qf > 0L)
        {
          l3 = ((du)localObject1).qf;
          j = i;
        }
      }
      localObject1 = localJSONObject.optString("active_view");
      paramds = null;
      boolean bool = localJSONObject.optBoolean("ad_is_javascript", false);
      if (bool) {
        paramds = localJSONObject.optString("ad_passback_url", null);
      }
      paramContext = new du(paramString, str1, (List)localObject2, (List)localObject3, l3, false, -1L, paramContext, -1L, j, str2, l2, str3, bool, paramds, (String)localObject1);
      return paramContext;
      continue;
      localObject3 = paramContext;
      break label416;
      localObject2 = paramContext;
      break label336;
      label640:
      localObject1 = null;
      break label205;
      label646:
      l1 = -1L;
      break;
      label654:
      j = 0;
      break label243;
      label660:
      localObject2 = paramds;
      break label336;
      label666:
      j = 0;
      break label374;
      localObject3 = paramds;
      break label416;
      label678:
      j = 0;
      break label454;
      paramContext = paramds;
    }
  }
  
  public static String a(ds paramds, ec paramec, Location paramLocation, String paramString)
  {
    try
    {
      paramLocation = new HashMap();
      if ((paramString != null) && (paramString.trim() != "")) {
        paramLocation.put("eid", paramString);
      }
      if (paramds.pW != null) {
        paramLocation.put("ad_pos", paramds.pW);
      }
      a(paramLocation, paramds.pX);
      paramLocation.put("format", paramds.kT.me);
      if (paramds.kT.width == -1) {
        paramLocation.put("smart_w", "full");
      }
      if (paramds.kT.height == -2) {
        paramLocation.put("smart_h", "auto");
      }
      if (paramds.kT.mg != null)
      {
        paramString = new StringBuilder();
        al[] arrayOfal = paramds.kT.mg;
        int k = arrayOfal.length;
        int i = 0;
        if (i < k)
        {
          al localal = arrayOfal[i];
          if (paramString.length() != 0) {
            paramString.append("|");
          }
          if (localal.width == -1)
          {
            j = (int)(localal.widthPixels / paramec.rr);
            label197:
            paramString.append(j);
            paramString.append("x");
            if (localal.height != -2) {
              break label262;
            }
          }
          label262:
          for (int j = (int)(localal.heightPixels / paramec.rr);; j = localal.height)
          {
            paramString.append(j);
            i += 1;
            break;
            j = localal.width;
            break label197;
          }
        }
        paramLocation.put("sz", paramString);
      }
      paramLocation.put("slotname", paramds.kN);
      paramLocation.put("pn", paramds.applicationInfo.packageName);
      if (paramds.pY != null) {
        paramLocation.put("vc", Integer.valueOf(paramds.pY.versionCode));
      }
      paramLocation.put("ms", paramds.pZ);
      paramLocation.put("ms2", paramds.qd);
      paramLocation.put("seq_num", paramds.qa);
      paramLocation.put("session_id", paramds.qb);
      paramLocation.put("js", paramds.kQ.sw);
      a(paramLocation, paramec);
      if ((paramds.pX.versionCode >= 2) && (paramds.pX.ma != null)) {
        a(paramLocation, paramds.pX.ma);
      }
      if (paramds.versionCode >= 2) {
        paramLocation.put("quality_signals", paramds.qc);
      }
      if (eu.p(2))
      {
        paramds = eo.o(paramLocation).toString(2);
        eu.C("Ad Request JSON: " + paramds);
      }
      paramds = eo.o(paramLocation).toString();
      return paramds;
    }
    catch (JSONException paramds)
    {
      eu.D("Problem serializing ad request to JSON: " + paramds.getMessage());
    }
    return null;
  }
  
  private static void a(HashMap<String, Object> paramHashMap, Location paramLocation)
  {
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
  
  private static void a(HashMap<String, Object> paramHashMap, ai paramai)
  {
    String str = el.bP();
    if (str != null) {
      paramHashMap.put("abf", str);
    }
    if (paramai.lS != -1L) {
      paramHashMap.put("cust_age", qA.format(new Date(paramai.lS)));
    }
    if (paramai.extras != null) {
      paramHashMap.put("extras", paramai.extras);
    }
    if (paramai.lT != -1) {
      paramHashMap.put("cust_gender", Integer.valueOf(paramai.lT));
    }
    if (paramai.lU != null) {
      paramHashMap.put("kw", paramai.lU);
    }
    if (paramai.lW != -1) {
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(paramai.lW));
    }
    if (paramai.lV) {
      paramHashMap.put("adtest", "on");
    }
    if (paramai.versionCode >= 2)
    {
      if (paramai.lX) {
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      }
      if (!TextUtils.isEmpty(paramai.lY)) {
        paramHashMap.put("ppid", paramai.lY);
      }
      if (paramai.lZ != null) {
        a(paramHashMap, paramai.lZ);
      }
    }
    if ((paramai.versionCode >= 3) && (paramai.mb != null)) {
      paramHashMap.put("url", paramai.mb);
    }
  }
  
  private static void a(HashMap<String, Object> paramHashMap, aw paramaw)
  {
    Object localObject2 = null;
    if (Color.alpha(paramaw.mD) != 0) {
      paramHashMap.put("acolor", o(paramaw.mD));
    }
    if (Color.alpha(paramaw.backgroundColor) != 0) {
      paramHashMap.put("bgcolor", o(paramaw.backgroundColor));
    }
    if ((Color.alpha(paramaw.mE) != 0) && (Color.alpha(paramaw.mF) != 0))
    {
      paramHashMap.put("gradientto", o(paramaw.mE));
      paramHashMap.put("gradientfrom", o(paramaw.mF));
    }
    if (Color.alpha(paramaw.mG) != 0) {
      paramHashMap.put("bcolor", o(paramaw.mG));
    }
    paramHashMap.put("bthick", Integer.toString(paramaw.mH));
    Object localObject1;
    switch (paramaw.mI)
    {
    default: 
      localObject1 = null;
      if (localObject1 != null) {
        paramHashMap.put("btype", localObject1);
      }
      switch (paramaw.mJ)
      {
      default: 
        localObject1 = localObject2;
      }
      break;
    }
    for (;;)
    {
      if (localObject1 != null) {
        paramHashMap.put("callbuttoncolor", localObject1);
      }
      if (paramaw.mK != null) {
        paramHashMap.put("channel", paramaw.mK);
      }
      if (Color.alpha(paramaw.mL) != 0) {
        paramHashMap.put("dcolor", o(paramaw.mL));
      }
      if (paramaw.mM != null) {
        paramHashMap.put("font", paramaw.mM);
      }
      if (Color.alpha(paramaw.mN) != 0) {
        paramHashMap.put("hcolor", o(paramaw.mN));
      }
      paramHashMap.put("headersize", Integer.toString(paramaw.mO));
      if (paramaw.mP != null) {
        paramHashMap.put("q", paramaw.mP);
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
  
  private static void a(HashMap<String, Object> paramHashMap, ec paramec)
  {
    paramHashMap.put("am", Integer.valueOf(paramec.rb));
    paramHashMap.put("cog", m(paramec.rc));
    paramHashMap.put("coh", m(paramec.rd));
    if (!TextUtils.isEmpty(paramec.re)) {
      paramHashMap.put("carrier", paramec.re);
    }
    paramHashMap.put("gl", paramec.rf);
    if (paramec.rg) {
      paramHashMap.put("simulator", Integer.valueOf(1));
    }
    paramHashMap.put("ma", m(paramec.rh));
    paramHashMap.put("sp", m(paramec.ri));
    paramHashMap.put("hl", paramec.rj);
    if (!TextUtils.isEmpty(paramec.rk)) {
      paramHashMap.put("mv", paramec.rk);
    }
    paramHashMap.put("muv", Integer.valueOf(paramec.rl));
    if (paramec.rm != -2) {
      paramHashMap.put("cnt", Integer.valueOf(paramec.rm));
    }
    paramHashMap.put("gnt", Integer.valueOf(paramec.rn));
    paramHashMap.put("pt", Integer.valueOf(paramec.ro));
    paramHashMap.put("rm", Integer.valueOf(paramec.rp));
    paramHashMap.put("riv", Integer.valueOf(paramec.rq));
    paramHashMap.put("u_sd", Float.valueOf(paramec.rr));
    paramHashMap.put("sh", Integer.valueOf(paramec.rt));
    paramHashMap.put("sw", Integer.valueOf(paramec.rs));
    Bundle localBundle = new Bundle();
    localBundle.putInt("active_network_state", paramec.rx);
    localBundle.putBoolean("active_network_metered", paramec.rw);
    paramHashMap.put("connectivity", localBundle);
    localBundle = new Bundle();
    localBundle.putBoolean("is_charging", paramec.rv);
    localBundle.putDouble("battery_level", paramec.ru);
    paramHashMap.put("battery", localBundle);
  }
  
  private static Integer m(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return Integer.valueOf(i);
    }
  }
  
  private static String o(int paramInt)
  {
    return String.format(Locale.US, "#%06x", new Object[] { Integer.valueOf(0xFFFFFF & paramInt) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */