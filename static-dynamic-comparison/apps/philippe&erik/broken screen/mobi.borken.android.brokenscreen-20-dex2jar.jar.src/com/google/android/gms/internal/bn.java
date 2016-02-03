package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bn
{
  public final List<bm> np;
  public final long nq;
  public final List<String> nr;
  public final List<String> ns;
  public final List<String> nt;
  public final String nu;
  public final long nv;
  public int nw;
  public int nx;
  
  public bn(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString);
    if (ev.p(2)) {
      ev.C("Mediation Response JSON: " + paramString.toString(2));
    }
    JSONArray localJSONArray = paramString.getJSONArray("ad_networks");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    int j = -1;
    int i = 0;
    while (i < localJSONArray.length())
    {
      bm localbm = new bm(localJSONArray.getJSONObject(i));
      localArrayList.add(localbm);
      int k = j;
      if (j < 0)
      {
        k = j;
        if (a(localbm)) {
          k = i;
        }
      }
      i += 1;
      j = k;
    }
    this.nw = j;
    this.nx = localJSONArray.length();
    this.np = Collections.unmodifiableList(localArrayList);
    this.nu = paramString.getString("qdata");
    paramString = paramString.optJSONObject("settings");
    if (paramString != null)
    {
      this.nq = paramString.optLong("ad_network_timeout_millis", -1L);
      this.nr = bs.a(paramString, "click_urls");
      this.ns = bs.a(paramString, "imp_urls");
      this.nt = bs.a(paramString, "nofill_urls");
      long l = paramString.optLong("refresh", -1L);
      if (l > 0L) {}
      for (l *= 1000L;; l = -1L)
      {
        this.nv = l;
        return;
      }
    }
    this.nq = -1L;
    this.nr = null;
    this.ns = null;
    this.nt = null;
    this.nv = -1L;
  }
  
  private boolean a(bm parambm)
  {
    parambm = parambm.nk.iterator();
    while (parambm.hasNext()) {
      if (((String)parambm.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */