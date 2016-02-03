package com.vungle.sdk;

import org.json.JSONException;
import org.json.JSONObject;

final class j
{
  long a;
  long b;
  long c;
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("startTime", this.a);
      localJSONObject.put("videoLength", this.b);
      localJSONObject.put("videoViewed", this.c);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      av.a(e.u, "JSONException", localJSONException);
    }
    return localJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */