package com.gau.go.launcherex.gowidget.weather.b;

import android.content.Context;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.h;
import com.gtp.a.a.a.a;
import com.gtp.a.a.b.c;

public class aw
{
  private Context a;
  private com.gau.go.gostaticsdk.d b;
  private a c;
  
  public aw(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = com.gau.go.gostaticsdk.d.a(this.a);
    this.b.a(c.a());
    this.c = a.a();
  }
  
  public void a(String paramString)
  {
    c.a("StatisticsManager", "ThemeStatisticsHandler.postUploadPotentailInstalled" + paramString);
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.b(this.a, paramString))
    {
      h localh = new h(this.a);
      localh.e = paramString;
      localh.f = "b000";
      this.b.a(localh.a());
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("[操作：");
      localStringBuffer.append("安装主题");
      localStringBuffer.append(paramString);
      localStringBuffer.append("] ");
      localStringBuffer.append("[上传信息：");
      localStringBuffer.append(localh.a());
      localStringBuffer.append("]");
      this.c.a(localStringBuffer.toString(), "theme_statistics.txt");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */