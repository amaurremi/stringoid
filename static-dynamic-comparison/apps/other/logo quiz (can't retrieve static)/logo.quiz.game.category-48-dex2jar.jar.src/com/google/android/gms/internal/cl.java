package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ez
public final class cl
{
  public final String pW;
  public final String pX;
  public final List<String> pY;
  public final String pZ;
  public final String qa;
  public final List<String> qb;
  public final String qc;
  
  public cl(JSONObject paramJSONObject)
    throws JSONException
  {
    this.pX = paramJSONObject.getString("id");
    Object localObject1 = paramJSONObject.getJSONArray("adapters");
    ArrayList localArrayList = new ArrayList(((JSONArray)localObject1).length());
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      localArrayList.add(((JSONArray)localObject1).getString(i));
      i += 1;
    }
    this.pY = Collections.unmodifiableList(localArrayList);
    this.pZ = paramJSONObject.optString("allocation_id", null);
    this.qb = cr.a(paramJSONObject, "imp_urls");
    localObject1 = paramJSONObject.optJSONObject("ad");
    if (localObject1 != null)
    {
      localObject1 = ((JSONObject)localObject1).toString();
      this.pW = ((String)localObject1);
      localObject1 = paramJSONObject.optJSONObject("data");
      if (localObject1 == null) {
        break label164;
      }
    }
    label164:
    for (paramJSONObject = ((JSONObject)localObject1).toString();; paramJSONObject = null)
    {
      this.qc = paramJSONObject;
      paramJSONObject = (JSONObject)localObject2;
      if (localObject1 != null) {
        paramJSONObject = ((JSONObject)localObject1).optString("class_name");
      }
      this.qa = paramJSONObject;
      return;
      localObject1 = null;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */