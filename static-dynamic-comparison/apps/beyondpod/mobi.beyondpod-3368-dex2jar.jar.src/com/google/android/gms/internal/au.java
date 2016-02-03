package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class au
{
  public final List<at> fI;
  public final long fJ;
  public final List<String> fK;
  public final List<String> fL;
  public final List<String> fM;
  public final String fN;
  public final long fO;
  
  public au(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString);
    if (ct.n(2)) {
      ct.u("Mediation Response JSON: " + paramString.toString(2));
    }
    JSONArray localJSONArray = paramString.getJSONArray("ad_networks");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    int i = 0;
    while (i < localJSONArray.length())
    {
      localArrayList.add(new at(localJSONArray.getJSONObject(i)));
      i += 1;
    }
    this.fI = Collections.unmodifiableList(localArrayList);
    this.fN = paramString.getString("qdata");
    paramString = paramString.optJSONObject("settings");
    if (paramString != null)
    {
      this.fJ = paramString.optLong("ad_network_timeout_millis", -1L);
      this.fK = az.a(paramString, "click_urls");
      this.fL = az.a(paramString, "imp_urls");
      this.fM = az.a(paramString, "nofill_urls");
      long l = paramString.optLong("refresh", -1L);
      if (l > 0L) {}
      for (l = 1000L * l;; l = -1L)
      {
        this.fO = l;
        return;
      }
    }
    this.fJ = -1L;
    this.fK = null;
    this.fL = null;
    this.fM = null;
    this.fO = -1L;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */