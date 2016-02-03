package com.jiubang.playsdk.e;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  implements Serializable
{
  public long a = 0L;
  private int b;
  private int c;
  private String d;
  private String e;
  private String f;
  private int g;
  private a h;
  
  public String a()
  {
    return this.e;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(a parama)
  {
    this.h = parama;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      this.b = paramString.optInt("type", 1);
      this.c = paramString.optInt("acttype", 0);
      this.d = paramString.optString("actvalue", "");
      this.e = paramString.optString("pic", "");
      this.f = paramString.optString("name", "");
      this.g = paramString.optInt("position", 0);
      paramString = paramString.optJSONObject("appinfo");
      if (paramString != null)
      {
        this.h = new a();
        this.h.a(this.g);
        this.h.a(this.a);
        this.h.a(paramString.toString());
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int c()
  {
    return this.g;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public a f()
  {
    return this.h;
  }
  
  public JSONObject g()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", this.b);
      localJSONObject.put("acttype", this.c);
      localJSONObject.put("actvalue", this.d);
      localJSONObject.put("pic", this.e);
      localJSONObject.put("name", this.f);
      localJSONObject.put("position", this.g);
      if (this.h != null) {
        localJSONObject.put("appinfo", this.h.r());
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */