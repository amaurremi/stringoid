package com.jiubang.goweather.b;

import android.content.Context;
import android.os.Build.VERSION;
import com.jiubang.goweather.e.a;
import java.util.Date;

public class g
{
  public static e a(Context paramContext, e parame)
  {
    Object localObject = com.gau.go.launcherex.gowidget.language.d.a(paramContext);
    String str2 = ((com.gau.go.launcherex.gowidget.language.d)localObject).b();
    String str1 = ((com.gau.go.launcherex.gowidget.language.d)localObject).e();
    if (str1 != null)
    {
      localObject = str1;
      if (!"".endsWith(str1)) {}
    }
    else
    {
      localObject = "ZZ";
    }
    return a(paramContext, parame, str2 + "_" + (String)localObject);
  }
  
  public static e a(Context paramContext, e parame, String paramString)
  {
    parame.b("date", a());
    parame.a("lang", paramString);
    parame.a("sys", Build.VERSION.RELEASE);
    parame.a("ps", "2.0");
    parame.a("chan", "100");
    parame.a("cliVersion", a.d(paramContext));
    parame.a("cliId", com.gau.go.gostaticsdk.d.b(paramContext));
    return parame;
  }
  
  public static String a()
  {
    return Long.toString(new Date().getTime());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */