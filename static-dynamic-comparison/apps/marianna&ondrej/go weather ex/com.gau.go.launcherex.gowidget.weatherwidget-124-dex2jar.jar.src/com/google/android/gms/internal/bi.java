package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bi
{
  public final String mW;
  public final String mX;
  public final List<String> mY;
  public final String mZ;
  public final List<String> na;
  public final String nb;
  
  public bi(JSONObject paramJSONObject)
    throws JSONException
  {
    this.mX = paramJSONObject.getString("id");
    Object localObject1 = paramJSONObject.getJSONArray("adapters");
    ArrayList localArrayList = new ArrayList(((JSONArray)localObject1).length());
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      localArrayList.add(((JSONArray)localObject1).getString(i));
      i += 1;
    }
    this.mY = Collections.unmodifiableList(localArrayList);
    this.mZ = paramJSONObject.optString("allocation_id", null);
    this.na = bo.a(paramJSONObject, "imp_urls");
    localObject1 = paramJSONObject.optJSONObject("ad");
    if (localObject1 != null) {}
    for (localObject1 = ((JSONObject)localObject1).toString();; localObject1 = null)
    {
      this.mW = ((String)localObject1);
      localObject1 = paramJSONObject.optJSONObject("data");
      paramJSONObject = (JSONObject)localObject2;
      if (localObject1 != null) {
        paramJSONObject = ((JSONObject)localObject1).toString();
      }
      this.nb = paramJSONObject;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */