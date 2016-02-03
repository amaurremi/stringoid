package com.jiubang.playsdk.e;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private long a;
  private String b;
  private int c;
  private String d;
  
  public long a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      this.a = paramString.optLong("typeid", 0L);
      this.b = paramString.optString("name", "");
      this.c = paramString.optInt("ishome", 0);
      this.d = paramString.optString("home", "");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a(int paramInt)
  {
    if ((TextUtils.isEmpty(this.d)) || (this.d.contains("#"))) {}
    while (!String.valueOf(paramInt).equals(this.d)) {
      return false;
    }
    return true;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public JSONObject d()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("typeid", this.a);
      localJSONObject.put("name", this.b);
      localJSONObject.put("ishome", this.c);
      localJSONObject.put("home", this.d);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */