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

public final class cf
{
  private static final SimpleDateFormat hJ = new SimpleDateFormat("yyyyMMdd");
  
  public static cb a(Context paramContext, bz parambz, String paramString)
  {
    Object localObject4;
    Object localObject1;
    String str2;
    String str1;
    long l1;
    Object localObject2;
    int i;
    label181:
    label219:
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
        if (!((JSONObject)localObject4).has("interstitial_timeout")) {
          break label578;
        }
        l1 = (((JSONObject)localObject4).getDouble("interstitial_timeout") * 1000.0D);
        localObject2 = ((JSONObject)localObject4).optString("orientation", null);
        i = -1;
        if ("portrait".equals(localObject2))
        {
          i = co.av();
          if (!TextUtils.isEmpty(str1))
          {
            if (!TextUtils.isEmpty(paramString)) {
              break label572;
            }
            ct.v("Could not parse the mediation config: Missing required ad_base_url field");
            return new cb(0);
          }
        }
        else
        {
          if (!"landscape".equals(localObject2)) {
            continue;
          }
          i = co.au();
          continue;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = ce.a(paramContext, parambz.ej.iJ, (String)localObject1);
          paramString = ((cb)localObject1).gL;
          str1 = ((cb)localObject1).hw;
          localObject2 = ((JSONObject)localObject4).optJSONArray("click_urls");
          if (localObject1 == null)
          {
            paramContext = null;
            if (localObject2 == null) {
              break;
            }
            parambz = paramContext;
            if (paramContext != null) {
              break label586;
            }
            parambz = new LinkedList();
            break label586;
            if (j >= ((JSONArray)localObject2).length()) {
              break label592;
            }
            parambz.add(((JSONArray)localObject2).getString(j));
            j += 1;
            continue;
          }
        }
        else
        {
          ct.v("Could not parse the mediation config: Missing required ad_html or ad_url field.");
          paramContext = new cb(0);
          return paramContext;
        }
      }
      catch (JSONException paramContext)
      {
        ct.v("Could not parse the mediation config: " + paramContext.getMessage());
        return new cb(0);
      }
      paramContext = ((cb)localObject1).fK;
    }
    label312:
    Object localObject3 = ((JSONObject)localObject4).optJSONArray("impression_urls");
    if (localObject1 == null) {
      paramContext = null;
    }
    while (localObject3 != null)
    {
      parambz = paramContext;
      if (paramContext != null) {
        break label598;
      }
      parambz = new LinkedList();
      break label598;
      label350:
      while (j < ((JSONArray)localObject3).length())
      {
        parambz.add(((JSONArray)localObject3).getString(j));
        j += 1;
      }
      paramContext = ((cb)localObject1).fL;
      continue;
      label392:
      localObject4 = ((JSONObject)localObject4).optJSONArray("manual_impression_urls");
      if (localObject1 == null) {}
      for (paramContext = null; localObject4 != null; paramContext = ((cb)localObject1).hA)
      {
        parambz = paramContext;
        if (paramContext != null) {
          break label610;
        }
        parambz = new LinkedList();
        break label610;
        label430:
        while (j < ((JSONArray)localObject4).length())
        {
          parambz.add(((JSONArray)localObject4).getString(j));
          j += 1;
        }
      }
    }
    for (;;)
    {
      long l2 = l1;
      j = i;
      if (localObject1 != null)
      {
        if (((cb)localObject1).orientation != -1) {
          i = ((cb)localObject1).orientation;
        }
        l2 = l1;
        j = i;
        if (((cb)localObject1).hx > 0L)
        {
          l2 = ((cb)localObject1).hx;
          j = i;
        }
      }
      paramContext = new cb(paramString, str1, (List)localObject2, (List)localObject3, l2, false, -1L, paramContext, -1L, j, str2);
      return paramContext;
      continue;
      localObject3 = paramContext;
      break label392;
      localObject2 = paramContext;
      break label312;
      label572:
      localObject1 = null;
      break label181;
      label578:
      l1 = -1L;
      break;
      label586:
      j = 0;
      break label219;
      label592:
      localObject2 = parambz;
      break label312;
      label598:
      j = 0;
      break label350;
      localObject3 = parambz;
      break label392;
      label610:
      j = 0;
      break label430;
      paramContext = parambz;
    }
  }
  
  public static String a(bz parambz, ci paramci, Location paramLocation)
  {
    try
    {
      paramLocation = new HashMap();
      if (parambz.hq != null) {
        paramLocation.put("ad_pos", parambz.hq);
      }
      a(paramLocation, parambz.hr);
      paramLocation.put("format", parambz.em.eF);
      if (parambz.em.width == -1) {
        paramLocation.put("smart_w", "full");
      }
      if (parambz.em.height == -2) {
        paramLocation.put("smart_h", "auto");
      }
      if (parambz.em.eH != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        x[] arrayOfx = parambz.em.eH;
        int k = arrayOfx.length;
        int i = 0;
        if (i < k)
        {
          x localx = arrayOfx[i];
          if (localStringBuilder.length() != 0) {
            localStringBuilder.append("|");
          }
          if (localx.width == -1)
          {
            j = (int)(localx.widthPixels / paramci.ip);
            label175:
            localStringBuilder.append(j);
            localStringBuilder.append("x");
            if (localx.height != -2) {
              break label240;
            }
          }
          label240:
          for (int j = (int)(localx.heightPixels / paramci.ip);; j = localx.height)
          {
            localStringBuilder.append(j);
            i += 1;
            break;
            j = localx.width;
            break label175;
          }
        }
        paramLocation.put("sz", localStringBuilder);
      }
      paramLocation.put("slotname", parambz.adUnitId);
      paramLocation.put("pn", parambz.applicationInfo.packageName);
      if (parambz.hs != null) {
        paramLocation.put("vc", Integer.valueOf(parambz.hs.versionCode));
      }
      paramLocation.put("ms", parambz.ht);
      paramLocation.put("seq_num", parambz.hu);
      paramLocation.put("session_id", parambz.hv);
      paramLocation.put("js", parambz.ej.iJ);
      a(paramLocation, paramci);
      if ((parambz.hr.versionCode >= 2) && (parambz.hr.eE != null)) {
        a(paramLocation, parambz.hr.eE);
      }
      if (ct.n(2))
      {
        parambz = co.m(paramLocation).toString(2);
        ct.u("Ad Request JSON: " + parambz);
      }
      parambz = co.m(paramLocation).toString();
      return parambz;
    }
    catch (JSONException parambz)
    {
      ct.v("Problem serializing ad request to JSON: " + parambz.getMessage());
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
    Object localObject2 = null;
    if (Color.alpha(paramai.eZ) != 0) {
      paramHashMap.put("acolor", m(paramai.eZ));
    }
    if (Color.alpha(paramai.backgroundColor) != 0) {
      paramHashMap.put("bgcolor", m(paramai.backgroundColor));
    }
    if ((Color.alpha(paramai.fa) != 0) && (Color.alpha(paramai.fb) != 0))
    {
      paramHashMap.put("gradientto", m(paramai.fa));
      paramHashMap.put("gradientfrom", m(paramai.fb));
    }
    if (Color.alpha(paramai.fc) != 0) {
      paramHashMap.put("bcolor", m(paramai.fc));
    }
    paramHashMap.put("bthick", Integer.toString(paramai.fd));
    Object localObject1;
    switch (paramai.fe)
    {
    default: 
      localObject1 = null;
      if (localObject1 != null) {
        paramHashMap.put("btype", localObject1);
      }
      switch (paramai.ff)
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
      if (paramai.fg != null) {
        paramHashMap.put("channel", paramai.fg);
      }
      if (Color.alpha(paramai.fh) != 0) {
        paramHashMap.put("dcolor", m(paramai.fh));
      }
      if (paramai.fi != null) {
        paramHashMap.put("font", paramai.fi);
      }
      if (Color.alpha(paramai.fj) != 0) {
        paramHashMap.put("hcolor", m(paramai.fj));
      }
      paramHashMap.put("headersize", Integer.toString(paramai.fk));
      if (paramai.fl != null) {
        paramHashMap.put("q", paramai.fl);
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
  
  private static void a(HashMap<String, Object> paramHashMap, ci paramci)
  {
    paramHashMap.put("am", Integer.valueOf(paramci.hZ));
    paramHashMap.put("cog", j(paramci.ia));
    paramHashMap.put("coh", j(paramci.ib));
    if (!TextUtils.isEmpty(paramci.ic)) {
      paramHashMap.put("carrier", paramci.ic);
    }
    paramHashMap.put("gl", paramci.id);
    if (paramci.ie) {
      paramHashMap.put("simulator", Integer.valueOf(1));
    }
    paramHashMap.put("ma", j(paramci.jdField_if));
    paramHashMap.put("sp", j(paramci.ig));
    paramHashMap.put("hl", paramci.ih);
    if (!TextUtils.isEmpty(paramci.ii)) {
      paramHashMap.put("mv", paramci.ii);
    }
    paramHashMap.put("muv", Integer.valueOf(paramci.ij));
    if (paramci.ik != -2) {
      paramHashMap.put("cnt", Integer.valueOf(paramci.ik));
    }
    paramHashMap.put("gnt", Integer.valueOf(paramci.il));
    paramHashMap.put("pt", Integer.valueOf(paramci.im));
    paramHashMap.put("rm", Integer.valueOf(paramci.in));
    paramHashMap.put("riv", Integer.valueOf(paramci.io));
    paramHashMap.put("u_sd", Float.valueOf(paramci.ip));
    paramHashMap.put("sh", Integer.valueOf(paramci.ir));
    paramHashMap.put("sw", Integer.valueOf(paramci.iq));
  }
  
  private static void a(HashMap<String, Object> paramHashMap, v paramv)
  {
    String str = cl.as();
    if (str != null) {
      paramHashMap.put("abf", str);
    }
    if (paramv.ex != -1L) {
      paramHashMap.put("cust_age", hJ.format(new Date(paramv.ex)));
    }
    if (paramv.extras != null) {
      paramHashMap.put("extras", paramv.extras);
    }
    if (paramv.ey != -1) {
      paramHashMap.put("cust_gender", Integer.valueOf(paramv.ey));
    }
    if (paramv.ez != null) {
      paramHashMap.put("kw", paramv.ez);
    }
    if (paramv.tagForChildDirectedTreatment != -1) {
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(paramv.tagForChildDirectedTreatment));
    }
    if (paramv.eA) {
      paramHashMap.put("adtest", "on");
    }
    if (paramv.versionCode >= 2)
    {
      if (paramv.eB) {
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      }
      if (!TextUtils.isEmpty(paramv.eC)) {
        paramHashMap.put("ppid", paramv.eC);
      }
      if (paramv.eD != null) {
        a(paramHashMap, paramv.eD);
      }
    }
  }
  
  private static Integer j(boolean paramBoolean)
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */