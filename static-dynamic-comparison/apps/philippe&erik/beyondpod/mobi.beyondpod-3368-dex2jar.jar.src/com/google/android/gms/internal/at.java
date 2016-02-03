package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class at
{
  public final String adJson;
  public final String fD;
  public final List<String> fE;
  public final String fF;
  public final List<String> fG;
  public final String fH;
  
  public at(JSONObject paramJSONObject)
    throws JSONException
  {
    this.fD = paramJSONObject.getString("id");
    Object localObject1 = paramJSONObject.getJSONArray("adapters");
    ArrayList localArrayList = new ArrayList(((JSONArray)localObject1).length());
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      localArrayList.add(((JSONArray)localObject1).getString(i));
      i += 1;
    }
    this.fE = Collections.unmodifiableList(localArrayList);
    this.fF = paramJSONObject.optString("allocation_id", null);
    this.fG = az.a(paramJSONObject, "imp_urls");
    localObject1 = paramJSONObject.optJSONObject("ad");
    if (localObject1 != null) {}
    for (localObject1 = ((JSONObject)localObject1).toString();; localObject1 = null)
    {
      this.adJson = ((String)localObject1);
      localObject1 = paramJSONObject.optJSONObject("data");
      paramJSONObject = (JSONObject)localObject2;
      if (localObject1 != null) {
        paramJSONObject = ((JSONObject)localObject1).toString();
      }
      this.fH = paramJSONObject;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */