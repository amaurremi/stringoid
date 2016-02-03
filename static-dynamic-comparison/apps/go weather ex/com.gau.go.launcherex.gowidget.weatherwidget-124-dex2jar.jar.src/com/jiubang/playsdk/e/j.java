package com.jiubang.playsdk.e;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class j
{
  private int a;
  
  public int a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.a = new JSONObject(paramString).optInt("status", 0);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/e/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */