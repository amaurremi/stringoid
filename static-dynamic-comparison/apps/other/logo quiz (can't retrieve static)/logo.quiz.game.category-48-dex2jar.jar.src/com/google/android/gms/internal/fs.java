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

@ez
public final class fs
{
  private static final SimpleDateFormat up = new SimpleDateFormat("yyyyMMdd");
  
  public static fk a(Context paramContext, fi paramfi, String paramString)
  {
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
    for (;;)
    {
      try
      {
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
        if ("portrait".equals(localObject1))
        {
          i = gj.dn();
          if (!TextUtils.isEmpty(str2))
          {
            if (!TextUtils.isEmpty(str1)) {
              break label648;
            }
            gs.W("Could not parse the mediation config: Missing required ad_base_url field");
            return new fk(0);
          }
        }
        else
        {
          if (!"landscape".equals(localObject1)) {
            continue;
          }
          i = gj.dm();
          continue;
        }
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = fr.a(paramContext, paramfi.lD.wD, paramString, null, null);
          str1 = ((fk)localObject1).rP;
          str2 = ((fk)localObject1).tG;
          l2 = ((fk)localObject1).tM;
          localObject2 = localJSONObject.optJSONArray("click_urls");
          if (localObject1 == null)
          {
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
            if (j >= ((JSONArray)localObject2).length()) {
              break label668;
            }
            paramString.add(((JSONArray)localObject2).getString(j));
            j += 1;
            continue;
          }
        }
        else
        {
          gs.W("Could not parse the mediation config: Missing required ad_html or ad_url field.");
          paramContext = new fk(0);
          return paramContext;
        }
      }
      catch (JSONException paramContext)
      {
        gs.W("Could not parse the mediation config: " + paramContext.getMessage());
        return new fk(0);
      }
      paramContext = ((fk)localObject1).qf;
    }
    label336:
    Object localObject3 = localJSONObject.optJSONArray("impression_urls");
    if (localObject1 == null) {
      paramContext = null;
    }
    while (localObject3 != null)
    {
      paramString = paramContext;
      if (paramContext != null) {
        break label674;
      }
      paramString = new LinkedList();
      break label674;
      label374:
      while (j < ((JSONArray)localObject3).length())
      {
        paramString.add(((JSONArray)localObject3).getString(j));
        j += 1;
      }
      paramContext = ((fk)localObject1).qg;
      continue;
      label416:
      JSONArray localJSONArray = localJSONObject.optJSONArray("manual_impression_urls");
      if (localObject1 == null) {}
      for (paramContext = null; localJSONArray != null; paramContext = ((fk)localObject1).tK)
      {
        paramString = paramContext;
        if (paramContext != null) {
          break label686;
        }
        paramString = new LinkedList();
        break label686;
        label454:
        while (j < localJSONArray.length())
        {
          paramString.add(localJSONArray.getString(j));
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
        if (((fk)localObject1).orientation != -1) {
          i = ((fk)localObject1).orientation;
        }
        l3 = l1;
        j = i;
        if (((fk)localObject1).tH > 0L)
        {
          l3 = ((fk)localObject1).tH;
          j = i;
        }
      }
      localObject1 = localJSONObject.optString("active_view");
      paramString = null;
      boolean bool = localJSONObject.optBoolean("ad_is_javascript", false);
      if (bool) {
        paramString = localJSONObject.optString("ad_passback_url", null);
      }
      paramContext = new fk(str1, str2, (List)localObject2, (List)localObject3, l3, false, -1L, paramContext, -1L, j, str3, l2, str4, bool, paramString, (String)localObject1, false, false, paramfi.tF, false);
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
  
  public static String a(fi paramfi, fw paramfw, Location paramLocation, String paramString1, String paramString2)
  {
    try
    {
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
      if (paramfi.tw != null) {
        paramLocation.put("ad_pos", paramfi.tw);
      }
      a(paramLocation, paramfi.tx);
      paramLocation.put("format", paramfi.lH.of);
      if (paramfi.lH.width == -1) {
        paramLocation.put("smart_w", "full");
      }
      if (paramfi.lH.height == -2) {
        paramLocation.put("smart_h", "auto");
      }
      if (paramfi.lH.oh != null)
      {
        paramString1 = new StringBuilder();
        paramString2 = paramfi.lH.oh;
        int k = paramString2.length;
        int i = 0;
        if (i < k)
        {
          localArrayList = paramString2[i];
          if (paramString1.length() != 0) {
            paramString1.append("|");
          }
          if (localArrayList.width == -1)
          {
            j = (int)(localArrayList.widthPixels / paramfw.vi);
            label246:
            paramString1.append(j);
            paramString1.append("x");
            if (localArrayList.height != -2) {
              break label311;
            }
          }
          label311:
          for (int j = (int)(localArrayList.heightPixels / paramfw.vi);; j = localArrayList.height)
          {
            paramString1.append(j);
            i += 1;
            break;
            j = localArrayList.width;
            break label246;
          }
        }
        paramLocation.put("sz", paramString1);
      }
      if (paramfi.tD != 0)
      {
        paramLocation.put("native_version", Integer.valueOf(paramfi.tD));
        paramLocation.put("native_templates", paramfi.lS);
      }
      paramLocation.put("slotname", paramfi.lA);
      paramLocation.put("pn", paramfi.applicationInfo.packageName);
      if (paramfi.ty != null) {
        paramLocation.put("vc", Integer.valueOf(paramfi.ty.versionCode));
      }
      paramLocation.put("ms", paramfi.tz);
      paramLocation.put("seq_num", paramfi.tA);
      paramLocation.put("session_id", paramfi.tB);
      paramLocation.put("js", paramfi.lD.wD);
      a(paramLocation, paramfw);
      if ((paramfi.tx.versionCode >= 2) && (paramfi.tx.ob != null)) {
        a(paramLocation, paramfi.tx.ob);
      }
      if (paramfi.versionCode >= 2) {
        paramLocation.put("quality_signals", paramfi.tC);
      }
      if ((paramfi.versionCode >= 4) && (paramfi.tF)) {
        paramLocation.put("forceHttps", Boolean.valueOf(paramfi.tF));
      }
      if ((paramfi.versionCode >= 3) && (paramfi.tE != null)) {
        paramLocation.put("content_info", paramfi.tE);
      }
      if (gs.u(2))
      {
        paramfi = gj.t(paramLocation).toString(2);
        gs.V("Ad Request JSON: " + paramfi);
      }
      paramfi = gj.t(paramLocation).toString();
      return paramfi;
    }
    catch (JSONException paramfi)
    {
      gs.W("Problem serializing ad request to JSON: " + paramfi.getMessage());
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
  
  private static void a(HashMap<String, Object> paramHashMap, av paramav)
  {
    String str = gf.dj();
    if (str != null) {
      paramHashMap.put("abf", str);
    }
    if (paramav.nT != -1L) {
      paramHashMap.put("cust_age", up.format(new Date(paramav.nT)));
    }
    if (paramav.extras != null) {
      paramHashMap.put("extras", paramav.extras);
    }
    if (paramav.nU != -1) {
      paramHashMap.put("cust_gender", Integer.valueOf(paramav.nU));
    }
    if (paramav.nV != null) {
      paramHashMap.put("kw", paramav.nV);
    }
    if (paramav.nX != -1) {
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(paramav.nX));
    }
    if (paramav.nW) {
      paramHashMap.put("adtest", "on");
    }
    if (paramav.versionCode >= 2)
    {
      if (paramav.nY) {
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      }
      if (!TextUtils.isEmpty(paramav.nZ)) {
        paramHashMap.put("ppid", paramav.nZ);
      }
      if (paramav.oa != null) {
        a(paramHashMap, paramav.oa);
      }
    }
    if ((paramav.versionCode >= 3) && (paramav.oc != null)) {
      paramHashMap.put("url", paramav.oc);
    }
  }
  
  private static void a(HashMap<String, Object> paramHashMap, bj parambj)
  {
    Object localObject2 = null;
    if (Color.alpha(parambj.oH) != 0) {
      paramHashMap.put("acolor", t(parambj.oH));
    }
    if (Color.alpha(parambj.backgroundColor) != 0) {
      paramHashMap.put("bgcolor", t(parambj.backgroundColor));
    }
    if ((Color.alpha(parambj.oI) != 0) && (Color.alpha(parambj.oJ) != 0))
    {
      paramHashMap.put("gradientto", t(parambj.oI));
      paramHashMap.put("gradientfrom", t(parambj.oJ));
    }
    if (Color.alpha(parambj.oK) != 0) {
      paramHashMap.put("bcolor", t(parambj.oK));
    }
    paramHashMap.put("bthick", Integer.toString(parambj.oL));
    Object localObject1;
    switch (parambj.oM)
    {
    default: 
      localObject1 = null;
      if (localObject1 != null) {
        paramHashMap.put("btype", localObject1);
      }
      switch (parambj.oN)
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
      if (parambj.oO != null) {
        paramHashMap.put("channel", parambj.oO);
      }
      if (Color.alpha(parambj.oP) != 0) {
        paramHashMap.put("dcolor", t(parambj.oP));
      }
      if (parambj.oQ != null) {
        paramHashMap.put("font", parambj.oQ);
      }
      if (Color.alpha(parambj.oR) != 0) {
        paramHashMap.put("hcolor", t(parambj.oR));
      }
      paramHashMap.put("headersize", Integer.toString(parambj.oS));
      if (parambj.oT != null) {
        paramHashMap.put("q", parambj.oT);
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
  
  private static void a(HashMap<String, Object> paramHashMap, fw paramfw)
  {
    paramHashMap.put("am", Integer.valueOf(paramfw.uS));
    paramHashMap.put("cog", s(paramfw.uT));
    paramHashMap.put("coh", s(paramfw.uU));
    if (!TextUtils.isEmpty(paramfw.uV)) {
      paramHashMap.put("carrier", paramfw.uV);
    }
    paramHashMap.put("gl", paramfw.uW);
    if (paramfw.uX) {
      paramHashMap.put("simulator", Integer.valueOf(1));
    }
    paramHashMap.put("ma", s(paramfw.uY));
    paramHashMap.put("sp", s(paramfw.uZ));
    paramHashMap.put("hl", paramfw.va);
    if (!TextUtils.isEmpty(paramfw.vb)) {
      paramHashMap.put("mv", paramfw.vb);
    }
    paramHashMap.put("muv", Integer.valueOf(paramfw.vc));
    if (paramfw.vd != -2) {
      paramHashMap.put("cnt", Integer.valueOf(paramfw.vd));
    }
    paramHashMap.put("gnt", Integer.valueOf(paramfw.ve));
    paramHashMap.put("pt", Integer.valueOf(paramfw.vf));
    paramHashMap.put("rm", Integer.valueOf(paramfw.vg));
    paramHashMap.put("riv", Integer.valueOf(paramfw.vh));
    paramHashMap.put("u_sd", Float.valueOf(paramfw.vi));
    paramHashMap.put("sh", Integer.valueOf(paramfw.vk));
    paramHashMap.put("sw", Integer.valueOf(paramfw.vj));
    Bundle localBundle = new Bundle();
    localBundle.putInt("active_network_state", paramfw.vo);
    localBundle.putBoolean("active_network_metered", paramfw.vn);
    paramHashMap.put("connectivity", localBundle);
    localBundle = new Bundle();
    localBundle.putBoolean("is_charging", paramfw.vm);
    localBundle.putDouble("battery_level", paramfw.vl);
    paramHashMap.put("battery", localBundle);
  }
  
  private static Integer s(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return Integer.valueOf(i);
    }
  }
  
  private static String t(int paramInt)
  {
    return String.format(Locale.US, "#%06x", new Object[] { Integer.valueOf(0xFFFFFF & paramInt) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/fs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */