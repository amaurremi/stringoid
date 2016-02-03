package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.location.Location;
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

public final class be
{
  private static final SimpleDateFormat DY = new SimpleDateFormat("yyyyMMdd");
  
  private static Integer A(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return Integer.valueOf(i);
    }
  }
  
  public static cf a(Context paramContext, cd paramcd, String paramString)
  {
    Object localObject4;
    Object localObject1;
    String str2;
    String str1;
    long l2;
    long l1;
    Object localObject2;
    int i;
    label193:
    label231:
    int j;
    for (;;)
    {
      try
      {
        localObject4 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject4).optString("ad_base_url", null);
        localObject1 = ((JSONObject)localObject4).optString("ad_url", null);
        str2 = ((JSONObject)localObject4).optString("ad_size", null);
        str1 = ((JSONObject)localObject4).optString("ad_html", null);
        l2 = -1L;
        if (!((JSONObject)localObject4).has("interstitial_timeout")) {
          break label592;
        }
        l1 = (((JSONObject)localObject4).getDouble("interstitial_timeout") * 1000.0D);
        localObject2 = ((JSONObject)localObject4).optString("orientation", null);
        i = -1;
        if ("portrait".equals(localObject2))
        {
          i = bw.pO();
          if (!TextUtils.isEmpty(str1))
          {
            if (!TextUtils.isEmpty(paramString)) {
              break label586;
            }
            ce.D("Could not parse the mediation config: Missing required ad_base_url field");
            return new cf(0);
          }
        }
        else
        {
          if (!"landscape".equals(localObject2)) {
            continue;
          }
          i = bw.pN();
          continue;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = bd.b(paramContext, paramcd.CY.FK, (String)localObject1);
          paramString = ((cf)localObject1).CT;
          str1 = ((cf)localObject1).DL;
          l2 = ((cf)localObject1).DR;
          localObject2 = ((JSONObject)localObject4).optJSONArray("click_urls");
          if (localObject1 == null)
          {
            paramContext = null;
            if (localObject2 == null) {
              break;
            }
            paramcd = paramContext;
            if (paramContext != null) {
              break label600;
            }
            paramcd = new LinkedList();
            break label600;
            if (j >= ((JSONArray)localObject2).length()) {
              break label606;
            }
            paramcd.add(((JSONArray)localObject2).getString(j));
            j += 1;
            continue;
          }
        }
        else
        {
          ce.D("Could not parse the mediation config: Missing required ad_html or ad_url field.");
          paramContext = new cf(0);
          return paramContext;
        }
      }
      catch (JSONException paramContext)
      {
        ce.D("Could not parse the mediation config: " + paramContext.getMessage());
        return new cf(0);
      }
      paramContext = ((cf)localObject1).yi;
    }
    label324:
    Object localObject3 = ((JSONObject)localObject4).optJSONArray("impression_urls");
    if (localObject1 == null) {
      paramContext = null;
    }
    while (localObject3 != null)
    {
      paramcd = paramContext;
      if (paramContext != null) {
        break label612;
      }
      paramcd = new LinkedList();
      break label612;
      label362:
      while (j < ((JSONArray)localObject3).length())
      {
        paramcd.add(((JSONArray)localObject3).getString(j));
        j += 1;
      }
      paramContext = ((cf)localObject1).yj;
      continue;
      label404:
      localObject4 = ((JSONObject)localObject4).optJSONArray("manual_impression_urls");
      if (localObject1 == null) {}
      for (paramContext = null; localObject4 != null; paramContext = ((cf)localObject1).DP)
      {
        paramcd = paramContext;
        if (paramContext != null) {
          break label624;
        }
        paramcd = new LinkedList();
        break label624;
        label442:
        while (j < ((JSONArray)localObject4).length())
        {
          paramcd.add(((JSONArray)localObject4).getString(j));
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
        if (((cf)localObject1).orientation != -1) {
          i = ((cf)localObject1).orientation;
        }
        l3 = l1;
        j = i;
        if (((cf)localObject1).DM > 0L)
        {
          l3 = ((cf)localObject1).DM;
          j = i;
        }
      }
      paramContext = new cf(paramString, str1, (List)localObject2, (List)localObject3, l3, false, -1L, paramContext, -1L, j, str2, l2);
      return paramContext;
      continue;
      localObject3 = paramContext;
      break label404;
      localObject2 = paramContext;
      break label324;
      label586:
      localObject1 = null;
      break label193;
      label592:
      l1 = -1L;
      break;
      label600:
      j = 0;
      break label231;
      label606:
      localObject2 = paramcd;
      break label324;
      label612:
      j = 0;
      break label362;
      localObject3 = paramcd;
      break label404;
      label624:
      j = 0;
      break label442;
      paramContext = paramcd;
    }
  }
  
  public static String a(cd paramcd, bh parambh, Location paramLocation)
  {
    try
    {
      paramLocation = new HashMap();
      if (paramcd.DA != null) {
        paramLocation.put("ad_pos", paramcd.DA);
      }
      a(paramLocation, paramcd.DB);
      paramLocation.put("format", paramcd.DC.wZ);
      if (paramcd.DC.width == -1) {
        paramLocation.put("smart_w", "full");
      }
      if (paramcd.DC.height == -2) {
        paramLocation.put("smart_h", "auto");
      }
      if (paramcd.DC.xb != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        ab[] arrayOfab = paramcd.DC.xb;
        int k = arrayOfab.length;
        int i = 0;
        if (i < k)
        {
          ab localab = arrayOfab[i];
          if (localStringBuilder.length() != 0) {
            localStringBuilder.append("|");
          }
          if (localab.width == -1)
          {
            j = (int)(localab.widthPixels / parambh.EF);
            label175:
            localStringBuilder.append(j);
            localStringBuilder.append("x");
            if (localab.height != -2) {
              break label241;
            }
          }
          label241:
          for (int j = (int)(localab.heightPixels / parambh.EF);; j = localab.height)
          {
            localStringBuilder.append(j);
            i += 1;
            break;
            j = localab.width;
            break label175;
          }
        }
        paramLocation.put("sz", localStringBuilder);
      }
      paramLocation.put("slotname", paramcd.DD);
      paramLocation.put("pn", paramcd.applicationInfo.packageName);
      if (paramcd.DE != null) {
        paramLocation.put("vc", Integer.valueOf(paramcd.DE.versionCode));
      }
      paramLocation.put("ms", paramcd.DF);
      paramLocation.put("seq_num", paramcd.DG);
      paramLocation.put("session_id", paramcd.DI);
      paramLocation.put("js", paramcd.CY.FK);
      a(paramLocation, parambh);
      if ((paramcd.DB.versionCode >= 2) && (paramcd.DB.TS != null)) {
        a(paramLocation, paramcd.DB.TS);
      }
      if (paramcd.versionCode >= 2) {
        paramLocation.put("quality_signals", paramcd.DJ);
      }
      if (ce.cB(2))
      {
        paramcd = bw.B(paramLocation).toString(2);
        ce.C("Ad Request JSON: " + paramcd);
      }
      paramcd = bw.B(paramLocation).toString();
      return paramcd;
    }
    catch (JSONException paramcd)
    {
      ce.D("Problem serializing ad request to JSON: " + paramcd.getMessage());
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
  
  private static void a(HashMap<String, Object> paramHashMap, am paramam)
  {
    Object localObject2 = null;
    if (Color.alpha(paramam.xw) != 0) {
      paramHashMap.put("acolor", cA(paramam.xw));
    }
    if (Color.alpha(paramam.backgroundColor) != 0) {
      paramHashMap.put("bgcolor", cA(paramam.backgroundColor));
    }
    if ((Color.alpha(paramam.xx) != 0) && (Color.alpha(paramam.xy) != 0))
    {
      paramHashMap.put("gradientto", cA(paramam.xx));
      paramHashMap.put("gradientfrom", cA(paramam.xy));
    }
    if (Color.alpha(paramam.xz) != 0) {
      paramHashMap.put("bcolor", cA(paramam.xz));
    }
    paramHashMap.put("bthick", Integer.toString(paramam.xA));
    Object localObject1;
    switch (paramam.xB)
    {
    default: 
      localObject1 = null;
      if (localObject1 != null) {
        paramHashMap.put("btype", localObject1);
      }
      switch (paramam.xC)
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
      if (paramam.xD != null) {
        paramHashMap.put("channel", paramam.xD);
      }
      if (Color.alpha(paramam.xE) != 0) {
        paramHashMap.put("dcolor", cA(paramam.xE));
      }
      if (paramam.xF != null) {
        paramHashMap.put("font", paramam.xF);
      }
      if (Color.alpha(paramam.xG) != 0) {
        paramHashMap.put("hcolor", cA(paramam.xG));
      }
      paramHashMap.put("headersize", Integer.toString(paramam.xH));
      if (paramam.xI != null) {
        paramHashMap.put("q", paramam.xI);
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
  
  private static void a(HashMap<String, Object> paramHashMap, bh parambh)
  {
    paramHashMap.put("am", Integer.valueOf(parambh.Ep));
    paramHashMap.put("cog", A(parambh.Eq));
    paramHashMap.put("coh", A(parambh.Er));
    if (!TextUtils.isEmpty(parambh.Es)) {
      paramHashMap.put("carrier", parambh.Es);
    }
    paramHashMap.put("gl", parambh.wK);
    if (parambh.Et) {
      paramHashMap.put("simulator", Integer.valueOf(1));
    }
    paramHashMap.put("ma", A(parambh.Eu));
    paramHashMap.put("sp", A(parambh.Ev));
    paramHashMap.put("hl", parambh.Ew);
    if (!TextUtils.isEmpty(parambh.Ex)) {
      paramHashMap.put("mv", parambh.Ex);
    }
    paramHashMap.put("muv", Integer.valueOf(parambh.Ey));
    if (parambh.Ez != -2) {
      paramHashMap.put("cnt", Integer.valueOf(parambh.Ez));
    }
    paramHashMap.put("gnt", Integer.valueOf(parambh.EA));
    paramHashMap.put("pt", Integer.valueOf(parambh.EB));
    paramHashMap.put("rm", Integer.valueOf(parambh.ED));
    paramHashMap.put("riv", Integer.valueOf(parambh.EE));
    paramHashMap.put("u_sd", Float.valueOf(parambh.EF));
    paramHashMap.put("sh", Integer.valueOf(parambh.EH));
    paramHashMap.put("sw", Integer.valueOf(parambh.EG));
  }
  
  private static void a(HashMap<String, Object> paramHashMap, z paramz)
  {
    String str = bp.pL();
    if (str != null) {
      paramHashMap.put("abf", str);
    }
    if (paramz.TL != -1L) {
      paramHashMap.put("cust_age", DY.format(new Date(paramz.TL)));
    }
    if (paramz.extras != null) {
      paramHashMap.put("extras", paramz.extras);
    }
    if (paramz.TM != -1) {
      paramHashMap.put("cust_gender", Integer.valueOf(paramz.TM));
    }
    if (paramz.TN != null) {
      paramHashMap.put("kw", paramz.TN);
    }
    if (paramz.gU != -1) {
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(paramz.gU));
    }
    if (paramz.TO) {
      paramHashMap.put("adtest", "on");
    }
    if (paramz.versionCode >= 2)
    {
      if (paramz.TP) {
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      }
      if (!TextUtils.isEmpty(paramz.TQ)) {
        paramHashMap.put("ppid", paramz.TQ);
      }
      if (paramz.TR != null) {
        a(paramHashMap, paramz.TR);
      }
    }
    if ((paramz.versionCode >= 3) && (paramz.TT != null)) {
      paramHashMap.put("url", paramz.TT);
    }
  }
  
  private static String cA(int paramInt)
  {
    return String.format(Locale.US, "#%06x", new Object[] { Integer.valueOf(0xFFFFFF & paramInt) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */