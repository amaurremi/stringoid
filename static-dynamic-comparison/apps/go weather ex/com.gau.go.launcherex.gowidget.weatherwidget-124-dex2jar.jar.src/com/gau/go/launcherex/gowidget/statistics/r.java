package com.gau.go.launcherex.gowidget.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.gau.go.gostaticsdk.d;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;

public class r
{
  private static r a;
  private Context b;
  
  private r(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static r a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new r(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 3: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return "4";
    case 0: 
      return "1";
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      return "2";
    }
    return "3";
  }
  
  private String a(Context paramContext, com.gau.go.launcherex.gowidget.statistics.a.a parama)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = GoWidgetApplication.c(paramContext.getApplicationContext()).a();
    localStringBuffer.append("41").append("||");
    y.a(localStringBuffer, Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
    y.a(localStringBuffer, y.a((SharedPreferences)localObject));
    localStringBuffer.append(parama.a()).append("||");
    localStringBuffer.append(parama.b()).append("||");
    y.a(localStringBuffer, parama.c());
    localStringBuffer.append(parama.d()).append("||");
    y.a(localStringBuffer, y.n(paramContext));
    y.a(localStringBuffer, y.f(paramContext));
    localStringBuffer.append(y.e(paramContext)).append("||");
    y.a(localStringBuffer, y.c(paramContext));
    localStringBuffer.append(parama.e()).append("||");
    localStringBuffer.append(parama.f()).append("||");
    localStringBuffer.append(parama.g()).append("||");
    String str = y.d(paramContext);
    localObject = str;
    if (str == null) {
      localObject = "0000000000000000";
    }
    y.a(localStringBuffer, (String)localObject);
    y.a(localStringBuffer, d.b(paramContext));
    localStringBuffer.append(parama.h()).append("||");
    localStringBuffer.append(parama.i()).append("||");
    localStringBuffer.append(parama.j()).append("||");
    localStringBuffer.append(parama.k()).append("||");
    localStringBuffer.append(y.w(paramContext)).append("\r\n");
    paramContext = localStringBuffer.toString();
    a(parama, paramContext);
    return paramContext;
  }
  
  private void a(com.gau.go.launcherex.gowidget.statistics.a.a parama, String paramString) {}
  
  public void a(com.gau.go.launcherex.gowidget.statistics.a.a parama)
  {
    if (!TextUtils.isEmpty(parama.c())) {
      new s(this, parama).execute(new Void[0]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */