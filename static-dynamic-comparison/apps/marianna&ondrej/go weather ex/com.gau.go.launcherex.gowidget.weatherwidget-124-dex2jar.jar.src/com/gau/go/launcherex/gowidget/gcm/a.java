package com.gau.go.launcherex.gowidget.gcm;

import com.jiubang.goweather.b.c;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.b.f;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private String a;
  private int b;
  
  public a(String paramString)
  {
    this.a = paramString;
    this.b = 400;
  }
  
  private void a(String paramString)
  {
    if (paramString.length() > 0) {}
    try
    {
      this.b = new JSONObject(paramString).optInt("result", 400);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      this.b = -2;
    }
  }
  
  public int a()
  {
    Object localObject = new e(this.a, "GET");
    localObject = d.a().b(this.a, (e)localObject, new f());
    if (localObject != null) {
      a((String)localObject);
    }
    for (;;)
    {
      return this.b;
      this.b = 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/gcm/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */