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

public final class dd
{
  private static final SimpleDateFormat pH = new SimpleDateFormat("yyyyMMdd");
  
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
          break label644;
        }
        l1 = (localJSONObject.getDouble("interstitial_timeout") * 1000.0D);
        localObject2 = localJSONObject.optString("orientation", null);
        i = -1;
        if ("portrait".equals(localObject2))
        {
          i = dq.bA();
          if (!TextUtils.isEmpty(str1))
          {
            if (!TextUtils.isEmpty(paramString)) {
              break label638;
            }
            dw.z("Could not parse the mediation config: Missing required ad_base_url field");
            return new cz(0);
          }
        }
        else
        {
          if (!"landscape".equals(localObject2)) {
            continue;
          }
          i = dq.bz();
          continue;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = dc.a(paramContext, paramcx.kK.rq, (String)localObject1);
          paramString = ((cz)localObject1).ol;
          str1 = ((cz)localObject1).pm;
          l2 = ((cz)localObject1).ps;
          localObject2 = localJSONObject.optJSONArray("click_urls");
          if (localObject1 == null)
          {
            paramContext = null;
            if (localObject2 == null) {
              break;
            }
            paramcx = paramContext;
            if (paramContext != null) {
              break label652;
            }
            paramcx = new LinkedList();
            break label652;
            if (j >= ((JSONArray)localObject2).length()) {
              break label658;
            }
            paramcx.add(((JSONArray)localObject2).getString(j));
            j += 1;
            continue;
          }
        }
        else
        {
          dw.z("Could not parse the mediation config: Missing required ad_html or ad_url field.");
          paramContext = new cz(0);
          return paramContext;
        }
      }
      catch (JSONException paramContext)
      {
        dw.z("Could not parse the mediation config: " + paramContext.getMessage());
        return new cz(0);
      }
      paramContext = ((cz)localObject1).ne;
    }
    label334:
    Object localObject3 = localJSONObject.optJSONArray("impression_urls");
    if (localObject1 == null) {
      paramContext = null;
    }
    while (localObject3 != null)
    {
      paramcx = paramContext;
      if (paramContext != null) {
        break label664;
      }
      paramcx = new LinkedList();
      break label664;
      label372:
      while (j < ((JSONArray)localObject3).length())
      {
        paramcx.add(((JSONArray)localObject3).getString(j));
        j += 1;
      }
      paramContext = ((cz)localObject1).nf;
      continue;
      label414:
      JSONArray localJSONArray = localJSONObject.optJSONArray("manual_impression_urls");
      if (localObject1 == null) {}
      for (paramContext = null; localJSONArray != null; paramContext = ((cz)localObject1).pq)
      {
        paramcx = paramContext;
        if (paramContext != null) {
          break label676;
        }
        paramcx = new LinkedList();
        break label676;
        label452:
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
        if (((cz)localObject1).orientation != -1) {
          i = ((cz)localObject1).orientation;
        }
        l3 = l1;
        j = i;
        if (((cz)localObject1).pn > 0L)
        {
          l3 = ((cz)localObject1).pn;
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
      break label414;
      localObject2 = paramContext;
      break label334;
      label638:
      localObject1 = null;
      break label203;
      label644:
      l1 = -1L;
      break;
      label652:
      j = 0;
      break label241;
      label658:
      localObject2 = paramcx;
      break label334;
      label664:
      j = 0;
      break label372;
      localObject3 = paramcx;
      break label414;
      label676:
      j = 0;
      break label452;
      paramContext = paramcx;
    }
  }
  
  public static String a(cx paramcx, dg paramdg, Location paramLocation, String paramString)
  {
    try
    {
      paramLocation = new HashMap();
      if ((paramString != null) && (paramString.trim() != "")) {
        paramLocation.put("eid", paramString);
      }
      if (paramcx.pf != null) {
        paramLocation.put("ad_pos", paramcx.pf);
      }
      a(paramLocation, paramcx.pg);
      paramLocation.put("format", paramcx.kN.lS);
      if (paramcx.kN.width == -1) {
        paramLocation.put("smart_w", "full");
      }
      if (paramcx.kN.height == -2) {
        paramLocation.put("smart_h", "auto");
      }
      if (paramcx.kN.lU != null)
      {
        paramString = new StringBuilder();
        ak[] arrayOfak = paramcx.kN.lU;
        int k = arrayOfak.length;
        int i = 0;
        if (i < k)
        {
          ak localak = arrayOfak[i];
          if (paramString.length() != 0) {
            paramString.append("|");
          }
          if (localak.width == -1)
          {
            j = (int)(localak.widthPixels / paramdg.qp);
            label197:
            paramString.append(j);
            paramString.append("x");
            if (localak.height != -2) {
              break label262;
            }
          }
          label262:
          for (int j = (int)(localak.heightPixels / paramdg.qp);; j = localak.height)
          {
            paramString.append(j);
            i += 1;
            break;
            j = localak.width;
            break label197;
          }
        }
        paramLocation.put("sz", paramString);
      }
      paramLocation.put("slotname", paramcx.kH);
      paramLocation.put("pn", paramcx.applicationInfo.packageName);
      if (paramcx.ph != null) {
        paramLocation.put("vc", Integer.valueOf(paramcx.ph.versionCode));
      }
      paramLocation.put("ms", paramcx.pi);
      paramLocation.put("seq_num", paramcx.pj);
      paramLocation.put("session_id", paramcx.pk);
      paramLocation.put("js", paramcx.kK.rq);
      a(paramLocation, paramdg);
      if ((paramcx.pg.versionCode >= 2) && (paramcx.pg.lP != null)) {
        a(paramLocation, paramcx.pg.lP);
      }
      if (paramcx.versionCode >= 2) {
        paramLocation.put("quality_signals", paramcx.pl);
      }
      if (dw.n(2))
      {
        paramcx = dq.p(paramLocation).toString(2);
        dw.y("Ad Request JSON: " + paramcx);
      }
      paramcx = dq.p(paramLocation).toString();
      return paramcx;
    }
    catch (JSONException paramcx)
    {
      dw.z("Problem serializing ad request to JSON: " + paramcx.getMessage());
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
  
  private static void a(HashMap<String, Object> paramHashMap, ah paramah)
  {
    String str = dn.bx();
    if (str != null) {
      paramHashMap.put("abf", str);
    }
    if (paramah.lH != -1L) {
      paramHashMap.put("cust_age", pH.format(new Date(paramah.lH)));
    }
    if (paramah.extras != null) {
      paramHashMap.put("extras", paramah.extras);
    }
    if (paramah.lI != -1) {
      paramHashMap.put("cust_gender", Integer.valueOf(paramah.lI));
    }
    if (paramah.lJ != null) {
      paramHashMap.put("kw", paramah.lJ);
    }
    if (paramah.lL != -1) {
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(paramah.lL));
    }
    if (paramah.lK) {
      paramHashMap.put("adtest", "on");
    }
    if (paramah.versionCode >= 2)
    {
      if (paramah.lM) {
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      }
      if (!TextUtils.isEmpty(paramah.lN)) {
        paramHashMap.put("ppid", paramah.lN);
      }
      if (paramah.lO != null) {
        a(paramHashMap, paramah.lO);
      }
    }
    if ((paramah.versionCode >= 3) && (paramah.lQ != null)) {
      paramHashMap.put("url", paramah.lQ);
    }
  }
  
  private static void a(HashMap<String, Object> paramHashMap, av paramav)
  {
    Object localObject2 = null;
    if (Color.alpha(paramav.mq) != 0) {
      paramHashMap.put("acolor", m(paramav.mq));
    }
    if (Color.alpha(paramav.backgroundColor) != 0) {
      paramHashMap.put("bgcolor", m(paramav.backgroundColor));
    }
    if ((Color.alpha(paramav.mr) != 0) && (Color.alpha(paramav.ms) != 0))
    {
      paramHashMap.put("gradientto", m(paramav.mr));
      paramHashMap.put("gradientfrom", m(paramav.ms));
    }
    if (Color.alpha(paramav.mt) != 0) {
      paramHashMap.put("bcolor", m(paramav.mt));
    }
    paramHashMap.put("bthick", Integer.toString(paramav.mu));
    Object localObject1;
    switch (paramav.mv)
    {
    default: 
      localObject1 = null;
      if (localObject1 != null) {
        paramHashMap.put("btype", localObject1);
      }
      switch (paramav.mw)
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
      if (paramav.mx != null) {
        paramHashMap.put("channel", paramav.mx);
      }
      if (Color.alpha(paramav.my) != 0) {
        paramHashMap.put("dcolor", m(paramav.my));
      }
      if (paramav.mz != null) {
        paramHashMap.put("font", paramav.mz);
      }
      if (Color.alpha(paramav.mA) != 0) {
        paramHashMap.put("hcolor", m(paramav.mA));
      }
      paramHashMap.put("headersize", Integer.toString(paramav.mB));
      if (paramav.mC != null) {
        paramHashMap.put("q", paramav.mC);
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
  
  private static void a(HashMap<String, Object> paramHashMap, dg paramdg)
  {
    paramHashMap.put("am", Integer.valueOf(paramdg.pZ));
    paramHashMap.put("cog", l(paramdg.qa));
    paramHashMap.put("coh", l(paramdg.qb));
    if (!TextUtils.isEmpty(paramdg.qc)) {
      paramHashMap.put("carrier", paramdg.qc);
    }
    paramHashMap.put("gl", paramdg.qd);
    if (paramdg.qe) {
      paramHashMap.put("simulator", Integer.valueOf(1));
    }
    paramHashMap.put("ma", l(paramdg.qf));
    paramHashMap.put("sp", l(paramdg.qg));
    paramHashMap.put("hl", paramdg.qh);
    if (!TextUtils.isEmpty(paramdg.qi)) {
      paramHashMap.put("mv", paramdg.qi);
    }
    paramHashMap.put("muv", Integer.valueOf(paramdg.qj));
    if (paramdg.qk != -2) {
      paramHashMap.put("cnt", Integer.valueOf(paramdg.qk));
    }
    paramHashMap.put("gnt", Integer.valueOf(paramdg.ql));
    paramHashMap.put("pt", Integer.valueOf(paramdg.qm));
    paramHashMap.put("rm", Integer.valueOf(paramdg.qn));
    paramHashMap.put("riv", Integer.valueOf(paramdg.qo));
    paramHashMap.put("u_sd", Float.valueOf(paramdg.qp));
    paramHashMap.put("sh", Integer.valueOf(paramdg.qr));
    paramHashMap.put("sw", Integer.valueOf(paramdg.qq));
  }
  
  private static Integer l(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return Integer.valueOf(i);
    }
  }
  
  private static String m(int paramInt)
  {
    return String.format(Locale.US, "#%06x", new Object[] { Integer.valueOf(0xFFFFFF & paramInt) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */