package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bj
{
  public final List<bi> nc;
  public final long nd;
  public final List<String> ne;
  public final List<String> nf;
  public final List<String> ng;
  public final String nh;
  public final long ni;
  public int nj;
  public int nk;
  
  public bj(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString);
    if (dw.n(2)) {
      dw.y("Mediation Response JSON: " + paramString.toString(2));
    }
    JSONArray localJSONArray = paramString.getJSONArray("ad_networks");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    int j = -1;
    int i = 0;
    while (i < localJSONArray.length())
    {
      bi localbi = new bi(localJSONArray.getJSONObject(i));
      localArrayList.add(localbi);
      int k = j;
      if (j < 0)
      {
        k = j;
        if (a(localbi)) {
          k = i;
        }
      }
      i += 1;
      j = k;
    }
    this.nj = j;
    this.nk = localJSONArray.length();
    this.nc = Collections.unmodifiableList(localArrayList);
    this.nh = paramString.getString("qdata");
    paramString = paramString.optJSONObject("settings");
    if (paramString != null)
    {
      this.nd = paramString.optLong("ad_network_timeout_millis", -1L);
      this.ne = bo.a(paramString, "click_urls");
      this.nf = bo.a(paramString, "imp_urls");
      this.ng = bo.a(paramString, "nofill_urls");
      long l = paramString.optLong("refresh", -1L);
      if (l > 0L) {}
      for (l *= 1000L;; l = -1L)
      {
        this.ni = l;
        return;
      }
    }
    this.nd = -1L;
    this.ne = null;
    this.nf = null;
    this.ng = null;
    this.ni = -1L;
  }
  
  private boolean a(bi parambi)
  {
    parambi = parambi.mY.iterator();
    while (parambi.hasNext()) {
      if (((String)parambi.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */