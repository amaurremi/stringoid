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

public final class dz
{
  private static final SimpleDateFormat qx = new SimpleDateFormat("yyyyMMdd");
  
  public static dv a(Context paramContext, dt paramdt, String paramString)
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
          i = ep.bN();
          if (!TextUtils.isEmpty(str1))
          {
            if (!TextUtils.isEmpty(paramString)) {
              break label640;
            }
            ev.D("Could not parse the mediation config: Missing required ad_base_url field");
            return new dv(0);
          }
        }
        else
        {
          if (!"landscape".equals(localObject2)) {
            continue;
          }
          i = ep.bM();
          continue;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = dy.a(paramContext, paramdt.kO.st, (String)localObject1, null, null);
          paramString = ((dv)localObject1).oy;
          str1 = ((dv)localObject1).qb;
          l2 = ((dv)localObject1).qh;
          localObject2 = localJSONObject.optJSONArray("click_urls");
          if (localObject1 == null)
          {
            paramContext = null;
            if (localObject2 == null) {
              break;
            }
            paramdt = paramContext;
            if (paramContext != null) {
              break label654;
            }
            paramdt = new LinkedList();
            break label654;
            if (j >= ((JSONArray)localObject2).length()) {
              break label660;
            }
            paramdt.add(((JSONArray)localObject2).getString(j));
            j += 1;
            continue;
          }
        }
        else
        {
          ev.D("Could not parse the mediation config: Missing required ad_html or ad_url field.");
          paramContext = new dv(0);
          return paramContext;
        }
      }
      catch (JSONException paramContext)
      {
        ev.D("Could not parse the mediation config: " + paramContext.getMessage());
        return new dv(0);
      }
      paramContext = ((dv)localObject1).nr;
    }
    label336:
    Object localObject3 = localJSONObject.optJSONArray("impression_urls");
    if (localObject1 == null) {
      paramContext = null;
    }
    while (localObject3 != null)
    {
      paramdt = paramContext;
      if (paramContext != null) {
        break label666;
      }
      paramdt = new LinkedList();
      break label666;
      label374:
      while (j < ((JSONArray)localObject3).length())
      {
        paramdt.add(((JSONArray)localObject3).getString(j));
        j += 1;
      }
      paramContext = ((dv)localObject1).ns;
      continue;
      label416:
      JSONArray localJSONArray = localJSONObject.optJSONArray("manual_impression_urls");
      if (localObject1 == null) {}
      for (paramContext = null; localJSONArray != null; paramContext = ((dv)localObject1).qf)
      {
        paramdt = paramContext;
        if (paramContext != null) {
          break label678;
        }
        paramdt = new LinkedList();
        break label678;
        label454:
        while (j < localJSONArray.length())
        {
          paramdt.add(localJSONArray.getString(j));
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
        if (((dv)localObject1).orientation != -1) {
          i = ((dv)localObject1).orientation;
        }
        l3 = l1;
        j = i;
        if (((dv)localObject1).qc > 0L)
        {
          l3 = ((dv)localObject1).qc;
          j = i;
        }
      }
      localObject1 = localJSONObject.optString("active_view");
      paramdt = null;
      boolean bool = localJSONObject.optBoolean("ad_is_javascript", false);
      if (bool) {
        paramdt = localJSONObject.optString("ad_passback_url", null);
      }
      paramContext = new dv(paramString, str1, (List)localObject2, (List)localObject3, l3, false, -1L, paramContext, -1L, j, str2, l2, str3, bool, paramdt, (String)localObject1);
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
      localObject2 = paramdt;
      break label336;
      label666:
      j = 0;
      break label374;
      localObject3 = paramdt;
      break label416;
      label678:
      j = 0;
      break label454;
      paramContext = paramdt;
    }
  }
  
  public static String a(dt paramdt, ed paramed, Location paramLocation, String paramString)
  {
    try
    {
      paramLocation = new HashMap();
      if ((paramString != null) && (paramString.trim() != "")) {
        paramLocation.put("eid", paramString);
      }
      if (paramdt.pU != null) {
        paramLocation.put("ad_pos", paramdt.pU);
      }
      a(paramLocation, paramdt.pV);
      paramLocation.put("format", paramdt.kR.mc);
      if (paramdt.kR.width == -1) {
        paramLocation.put("smart_w", "full");
      }
      if (paramdt.kR.height == -2) {
        paramLocation.put("smart_h", "auto");
      }
      if (paramdt.kR.me != null)
      {
        paramString = new StringBuilder();
        am[] arrayOfam = paramdt.kR.me;
        int k = arrayOfam.length;
        int i = 0;
        if (i < k)
        {
          am localam = arrayOfam[i];
          if (paramString.length() != 0) {
            paramString.append("|");
          }
          if (localam.width == -1)
          {
            j = (int)(localam.widthPixels / paramed.ro);
            label197:
            paramString.append(j);
            paramString.append("x");
            if (localam.height != -2) {
              break label262;
            }
          }
          label262:
          for (int j = (int)(localam.heightPixels / paramed.ro);; j = localam.height)
          {
            paramString.append(j);
            i += 1;
            break;
            j = localam.width;
            break label197;
          }
        }
        paramLocation.put("sz", paramString);
      }
      paramLocation.put("slotname", paramdt.kL);
      paramLocation.put("pn", paramdt.applicationInfo.packageName);
      if (paramdt.pW != null) {
        paramLocation.put("vc", Integer.valueOf(paramdt.pW.versionCode));
      }
      paramLocation.put("ms", paramdt.pX);
      paramLocation.put("seq_num", paramdt.pY);
      paramLocation.put("session_id", paramdt.pZ);
      paramLocation.put("js", paramdt.kO.st);
      a(paramLocation, paramed);
      if ((paramdt.pV.versionCode >= 2) && (paramdt.pV.lY != null)) {
        a(paramLocation, paramdt.pV.lY);
      }
      if (paramdt.versionCode >= 2) {
        paramLocation.put("quality_signals", paramdt.qa);
      }
      if (ev.p(2))
      {
        paramdt = ep.o(paramLocation).toString(2);
        ev.C("Ad Request JSON: " + paramdt);
      }
      paramdt = ep.o(paramLocation).toString();
      return paramdt;
    }
    catch (JSONException paramdt)
    {
      ev.D("Problem serializing ad request to JSON: " + paramdt.getMessage());
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
  
  private static void a(HashMap<String, Object> paramHashMap, aj paramaj)
  {
    String str = em.bK();
    if (str != null) {
      paramHashMap.put("abf", str);
    }
    if (paramaj.lQ != -1L) {
      paramHashMap.put("cust_age", qx.format(new Date(paramaj.lQ)));
    }
    if (paramaj.extras != null) {
      paramHashMap.put("extras", paramaj.extras);
    }
    if (paramaj.lR != -1) {
      paramHashMap.put("cust_gender", Integer.valueOf(paramaj.lR));
    }
    if (paramaj.lS != null) {
      paramHashMap.put("kw", paramaj.lS);
    }
    if (paramaj.lU != -1) {
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(paramaj.lU));
    }
    if (paramaj.lT) {
      paramHashMap.put("adtest", "on");
    }
    if (paramaj.versionCode >= 2)
    {
      if (paramaj.lV) {
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      }
      if (!TextUtils.isEmpty(paramaj.lW)) {
        paramHashMap.put("ppid", paramaj.lW);
      }
      if (paramaj.lX != null) {
        a(paramHashMap, paramaj.lX);
      }
    }
    if ((paramaj.versionCode >= 3) && (paramaj.lZ != null)) {
      paramHashMap.put("url", paramaj.lZ);
    }
  }
  
  private static void a(HashMap<String, Object> paramHashMap, ax paramax)
  {
    Object localObject2 = null;
    if (Color.alpha(paramax.mB) != 0) {
      paramHashMap.put("acolor", o(paramax.mB));
    }
    if (Color.alpha(paramax.backgroundColor) != 0) {
      paramHashMap.put("bgcolor", o(paramax.backgroundColor));
    }
    if ((Color.alpha(paramax.mC) != 0) && (Color.alpha(paramax.mD) != 0))
    {
      paramHashMap.put("gradientto", o(paramax.mC));
      paramHashMap.put("gradientfrom", o(paramax.mD));
    }
    if (Color.alpha(paramax.mE) != 0) {
      paramHashMap.put("bcolor", o(paramax.mE));
    }
    paramHashMap.put("bthick", Integer.toString(paramax.mF));
    Object localObject1;
    switch (paramax.mG)
    {
    default: 
      localObject1 = null;
      if (localObject1 != null) {
        paramHashMap.put("btype", localObject1);
      }
      switch (paramax.mH)
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
      if (paramax.mI != null) {
        paramHashMap.put("channel", paramax.mI);
      }
      if (Color.alpha(paramax.mJ) != 0) {
        paramHashMap.put("dcolor", o(paramax.mJ));
      }
      if (paramax.mK != null) {
        paramHashMap.put("font", paramax.mK);
      }
      if (Color.alpha(paramax.mL) != 0) {
        paramHashMap.put("hcolor", o(paramax.mL));
      }
      paramHashMap.put("headersize", Integer.toString(paramax.mM));
      if (paramax.mN != null) {
        paramHashMap.put("q", paramax.mN);
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
  
  private static void a(HashMap<String, Object> paramHashMap, ed paramed)
  {
    paramHashMap.put("am", Integer.valueOf(paramed.qY));
    paramHashMap.put("cog", m(paramed.qZ));
    paramHashMap.put("coh", m(paramed.ra));
    if (!TextUtils.isEmpty(paramed.rb)) {
      paramHashMap.put("carrier", paramed.rb);
    }
    paramHashMap.put("gl", paramed.rc);
    if (paramed.rd) {
      paramHashMap.put("simulator", Integer.valueOf(1));
    }
    paramHashMap.put("ma", m(paramed.re));
    paramHashMap.put("sp", m(paramed.rf));
    paramHashMap.put("hl", paramed.rg);
    if (!TextUtils.isEmpty(paramed.rh)) {
      paramHashMap.put("mv", paramed.rh);
    }
    paramHashMap.put("muv", Integer.valueOf(paramed.ri));
    if (paramed.rj != -2) {
      paramHashMap.put("cnt", Integer.valueOf(paramed.rj));
    }
    paramHashMap.put("gnt", Integer.valueOf(paramed.rk));
    paramHashMap.put("pt", Integer.valueOf(paramed.rl));
    paramHashMap.put("rm", Integer.valueOf(paramed.rm));
    paramHashMap.put("riv", Integer.valueOf(paramed.rn));
    paramHashMap.put("u_sd", Float.valueOf(paramed.ro));
    paramHashMap.put("sh", Integer.valueOf(paramed.rq));
    paramHashMap.put("sw", Integer.valueOf(paramed.rp));
    Bundle localBundle = new Bundle();
    localBundle.putInt("active_network_state", paramed.ru);
    localBundle.putBoolean("active_network_metered", paramed.rt);
    paramHashMap.put("connectivity", localBundle);
    localBundle = new Bundle();
    localBundle.putBoolean("is_charging", paramed.rs);
    localBundle.putDouble("battery_level", paramed.rr);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */