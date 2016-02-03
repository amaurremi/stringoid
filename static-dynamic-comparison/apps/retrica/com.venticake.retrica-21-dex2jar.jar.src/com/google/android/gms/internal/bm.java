package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bm
{
  public final List<bl> nr;
  public final long ns;
  public final List<String> nt;
  public final List<String> nu;
  public final List<String> nv;
  public final String nw;
  public final long nx;
  public int ny;
  public int nz;
  
  public bm(String paramString)
  {
    paramString = new JSONObject(paramString);
    if (eu.p(2)) {
      eu.C("Mediation Response JSON: " + paramString.toString(2));
    }
    JSONArray localJSONArray = paramString.getJSONArray("ad_networks");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    int j = -1;
    int i = 0;
    while (i < localJSONArray.length())
    {
      bl localbl = new bl(localJSONArray.getJSONObject(i));
      localArrayList.add(localbl);
      int k = j;
      if (j < 0)
      {
        k = j;
        if (a(localbl)) {
          k = i;
        }
      }
      i += 1;
      j = k;
    }
    this.ny = j;
    this.nz = localJSONArray.length();
    this.nr = Collections.unmodifiableList(localArrayList);
    this.nw = paramString.getString("qdata");
    paramString = paramString.optJSONObject("settings");
    if (paramString != null)
    {
      this.ns = paramString.optLong("ad_network_timeout_millis", -1L);
      this.nt = br.a(paramString, "click_urls");
      this.nu = br.a(paramString, "imp_urls");
      this.nv = br.a(paramString, "nofill_urls");
      long l = paramString.optLong("refresh", -1L);
      if (l > 0L) {}
      for (l *= 1000L;; l = -1L)
      {
        this.nx = l;
        return;
      }
    }
    this.ns = -1L;
    this.nt = null;
    this.nu = null;
    this.nv = null;
    this.nx = -1L;
  }
  
  private boolean a(bl parambl)
  {
    parambl = parambl.nm.iterator();
    while (parambl.hasNext()) {
      if (((String)parambl.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */