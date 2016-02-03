package com.vungle.sdk;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class i
{
  long a;
  long b = 0L;
  long c;
  ArrayList<j> d = new ArrayList();
  private JSONArray e = new JSONArray();
  
  public final String a()
  {
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("clickedThrough", this.e);
      ((JSONObject)localObject1).put("adStartTime", this.a);
      ((JSONObject)localObject1).put("adDuration", this.b);
      ((JSONObject)localObject1).put("ttDownload", this.c);
      if ((!this.d.isEmpty()) && (this.d != null))
      {
        localObject2 = new JSONArray();
        int j = this.d.size();
        int i = 0;
        while (i < j)
        {
          ((JSONArray)localObject2).put(((j)this.d.get(i)).a());
          i += 1;
        }
        ((JSONObject)localObject1).put("plays", localObject2);
      }
      Object localObject2 = ay.a();
      if (localObject2 != null)
      {
        localObject1 = ((k)localObject2).a((JSONObject)localObject1);
        return (String)localObject1;
      }
    }
    catch (JSONException localJSONException)
    {
      av.a(e.u, "JSONException", localJSONException);
    }
    return null;
  }
  
  public final void a(String paramString)
  {
    if (this.e == null) {
      this.e = new JSONArray();
    }
    this.e.put(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */