package com.google.ads.internal;

import com.google.ads.util.b;
import org.json.JSONException;
import org.json.JSONObject;

public class j$a
{
  private final String a;
  
  public j$a(String paramString)
  {
    this.a = paramString;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("debugHeader", this.a);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      b.b("Could not build ReportAdJson from inputs.", localJSONException);
    }
    return localJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/internal/j$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */