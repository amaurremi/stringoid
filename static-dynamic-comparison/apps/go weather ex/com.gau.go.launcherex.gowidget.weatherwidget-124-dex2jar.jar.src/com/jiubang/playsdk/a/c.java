package com.jiubang.playsdk.a;

import com.jiubang.playsdk.e.d;
import com.jiubang.playsdk.main.b;
import org.json.JSONObject;

public class c
  implements r
{
  public d a(String paramString)
  {
    try
    {
      String str = new String(com.jiubang.playsdk.g.c.a(a() + paramString));
      paramString = new d();
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        paramString.a(str);
        return paramString;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localException1 = localException1;
      paramString = null;
    }
    return paramString;
  }
  
  public String a()
  {
    String str = "";
    if (aa.a().b() != null) {}
    for (int i = aa.a().b().o();; i = 80)
    {
      if (i == 80) {
        str = "sms";
      }
      for (;;)
      {
        return b.c + str + "/";
        if (i == 81) {
          str = "keyboard";
        } else if (i == 84) {
          str = "weather";
        } else if (i == 83) {
          str = "locker";
        } else if (i == 82) {
          str = "launcher";
        }
      }
    }
  }
  
  public boolean a(String paramString, d paramd)
  {
    try
    {
      com.jiubang.playsdk.g.c.a(paramd.m().toString().getBytes(), a() + paramString);
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    return com.jiubang.playsdk.g.c.c(a() + paramString);
  }
  
  public boolean c(String paramString)
  {
    return com.jiubang.playsdk.g.c.b(a() + paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */