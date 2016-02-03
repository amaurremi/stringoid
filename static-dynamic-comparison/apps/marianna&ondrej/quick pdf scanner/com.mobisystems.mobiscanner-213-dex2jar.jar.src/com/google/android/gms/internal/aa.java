package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class aa
{
  public final List<y> yg;
  public final long yh;
  public final List<String> yi;
  public final List<String> yj;
  public final List<String> yk;
  public final String yl;
  public final long ym;
  public int yn;
  public int yo;
  
  public aa(String paramString)
  {
    paramString = new JSONObject(paramString);
    if (ce.cB(2)) {
      ce.C("Mediation Response JSON: " + paramString.toString(2));
    }
    JSONArray localJSONArray = paramString.getJSONArray("ad_networks");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    int j = -1;
    int i = 0;
    while (i < localJSONArray.length())
    {
      y localy = new y(localJSONArray.getJSONObject(i));
      localArrayList.add(localy);
      int k = j;
      if (j < 0)
      {
        k = j;
        if (a(localy)) {
          k = i;
        }
      }
      i += 1;
      j = k;
    }
    this.yn = j;
    this.yo = localJSONArray.length();
    this.yg = Collections.unmodifiableList(localArrayList);
    this.yl = paramString.getString("qdata");
    paramString = paramString.optJSONObject("settings");
    if (paramString != null)
    {
      this.yh = paramString.optLong("ad_network_timeout_millis", -1L);
      this.yi = ag.a(paramString, "click_urls");
      this.yj = ag.a(paramString, "imp_urls");
      this.yk = ag.a(paramString, "nofill_urls");
      long l = paramString.optLong("refresh", -1L);
      if (l > 0L) {}
      for (l *= 1000L;; l = -1L)
      {
        this.ym = l;
        return;
      }
    }
    this.yh = -1L;
    this.yi = null;
    this.yj = null;
    this.yk = null;
    this.ym = -1L;
  }
  
  private boolean a(y paramy)
  {
    paramy = paramy.yc.iterator();
    while (paramy.hasNext()) {
      if (((String)paramy.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */