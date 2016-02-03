package com.gau.go.launcherex.gowidget.weather.globaltheme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.gau.go.gostaticsdk.d;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.h;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import com.gtp.a.a.a.a;
import com.gtp.a.a.b.c;
import java.util.ArrayList;

public class i
{
  private static i f;
  private Context a;
  private d b;
  private h c;
  private a d;
  private ArrayList e;
  
  private i(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = d.a(this.a);
    this.b.a(c.a());
    this.c = new h(this.a);
    this.e = new ArrayList();
    this.d = a.a();
  }
  
  public static i a(Context paramContext)
  {
    if (f == null) {
      f = new i(paramContext);
    }
    return f;
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!this.e.contains(paramString))
    {
      AlarmManager localAlarmManager = (AlarmManager)this.a.getSystemService("alarm");
      Object localObject = new Intent(this.a, NotifyService.class);
      ((Intent)localObject).putExtra("notify_request", 17);
      ((Intent)localObject).putExtra("request_extra_statistics_installed_theme_package_name", paramString);
      localObject = PendingIntent.getService(this.a, paramInt, (Intent)localObject, 134217728);
      localAlarmManager.set(0, System.currentTimeMillis() + 1800000L, (PendingIntent)localObject);
      this.e.add(paramString);
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    if (("c000".equals(paramString2)) || ("i000".equals(paramString2)))
    {
      if (paramString1 != null) {
        this.c.e = paramString1;
      }
      if (paramString2 != null) {
        this.c.f = paramString2;
      }
      if (paramString3 != null) {
        this.c.g = paramString3;
      }
      if (paramString4 != null) {
        this.c.l = paramString4;
      }
      if (paramString5 != null) {
        this.c.m = paramString5;
      }
      if (-1 != paramInt2) {
        this.c.n = String.valueOf(paramInt2);
      }
      this.b.a(this.c.a());
      if (("a000".equals(paramString2)) || ("a003".equals(paramString2))) {
        a(paramString1, paramInt1);
      }
      paramString2 = new StringBuffer();
      paramString2.append("[操作：");
      if (!"g001".equals(this.c.f)) {
        break label326;
      }
      if (!"100".equals(this.c.l)) {
        break label251;
      }
      paramString2.append("从主界面进入主题商店] ");
    }
    for (;;)
    {
      paramString2.append("[上传信息：");
      paramString2.append(this.c.a());
      paramString2.append("]");
      this.d.a(paramString2.toString(), "theme_statistics.txt");
      return;
      if (-1 == paramInt1) {
        break;
      }
      this.c.e = String.valueOf(paramInt1);
      break;
      label251:
      if ("101".equals(this.c.l))
      {
        paramString2.append("从设置界面进入主题商店] ");
      }
      else if ("102".equals(this.c.l))
      {
        paramString2.append("从WIDGET进入主题商店] ");
      }
      else if ("103".equals(this.c.l))
      {
        paramString2.append("从插件星星新主题提示入口] ");
        continue;
        label326:
        if ("h000".equals(this.c.f))
        {
          if ("25".equals(this.c.m)) {
            paramString2.append("切换到热门] ");
          } else if ("24".equals(this.c.m)) {
            paramString2.append("切换到精选] ");
          } else if ("31".equals(this.c.m)) {
            paramString2.append("切换到精选系统部件] ");
          } else if ("32".equals(this.c.m)) {
            paramString2.append("切换到精选背景] ");
          } else if ("33".equals(this.c.m)) {
            paramString2.append("切换到精选GO部件] ");
          } else if ("27".equals(this.c.m)) {
            paramString2.append("切换到本地] ");
          } else if ("34".equals(this.c.m)) {
            paramString2.append("切换到本地系统部件] ");
          } else if ("35".equals(this.c.m)) {
            paramString2.append("切换到本地背景] ");
          } else if ("36".equals(this.c.m)) {
            paramString2.append("切换到本地GO部件] ");
          }
        }
        else if ("c000".equals(this.c.f))
        {
          paramString2.append("进入主题");
          paramString2.append(this.c.e);
          paramString2.append("的详情页] ");
        }
        else if ("a000".equals(this.c.f))
        {
          paramString2.append("点击小图下方的下载按钮下载主题");
          paramString2.append(paramString1);
          paramString2.append("] ");
        }
        else if ("a003".equals(this.c.f))
        {
          paramString2.append("在详情页点击下载按钮下载主题");
          paramString2.append(paramString1);
          paramString2.append("] ");
        }
        else if ("i000".equals(this.c.f))
        {
          paramString2.append("应用主题");
          paramString2.append(this.c.e);
          paramString2.append("] ");
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */