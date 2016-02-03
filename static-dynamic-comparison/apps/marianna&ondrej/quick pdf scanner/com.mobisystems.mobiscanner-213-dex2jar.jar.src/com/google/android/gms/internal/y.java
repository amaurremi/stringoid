package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class y
{
  public final String gT;
  public final String yb;
  public final List<String> yc;
  public final String yd;
  public final List<String> ye;
  public final String yf;
  
  public y(JSONObject paramJSONObject)
  {
    this.yb = paramJSONObject.getString("id");
    Object localObject1 = paramJSONObject.getJSONArray("adapters");
    ArrayList localArrayList = new ArrayList(((JSONArray)localObject1).length());
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      localArrayList.add(((JSONArray)localObject1).getString(i));
      i += 1;
    }
    this.yc = Collections.unmodifiableList(localArrayList);
    this.yd = paramJSONObject.optString("allocation_id", null);
    this.ye = ag.a(paramJSONObject, "imp_urls");
    localObject1 = paramJSONObject.optJSONObject("ad");
    if (localObject1 != null) {}
    for (localObject1 = ((JSONObject)localObject1).toString();; localObject1 = null)
    {
      this.gT = ((String)localObject1);
      localObject1 = paramJSONObject.optJSONObject("data");
      paramJSONObject = (JSONObject)localObject2;
      if (localObject1 != null) {
        paramJSONObject = ((JSONObject)localObject1).toString();
      }
      this.yf = paramJSONObject;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */