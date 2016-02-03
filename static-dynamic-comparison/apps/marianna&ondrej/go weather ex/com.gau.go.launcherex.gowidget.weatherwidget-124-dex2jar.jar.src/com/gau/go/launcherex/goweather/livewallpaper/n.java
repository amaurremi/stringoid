package com.gau.go.launcherex.goweather.livewallpaper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.globaltheme.a;
import com.gtp.a.a.b.c;

class n
  extends BroadcastReceiver
{
  private n(k paramk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    boolean bool;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramContext = paramIntent.getAction();
            if (!"android.intent.action.PACKAGE_REMOVED".equals(paramContext)) {
              break;
            }
            paramContext = paramIntent.getDataString();
          } while (TextUtils.isEmpty(paramContext));
          paramContext = paramContext.replace("package:", "");
          bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
          c.a("wallpaper", "有apk包被删除,是不是正在使用的主题包被删了呢?pkgName: " + paramContext + ", replacing:" + bool);
          return;
        } while (!"android.intent.action.PACKAGE_REPLACED".equals(paramContext));
        c.a("wallpaper", "有apk包被替换安装,是不是正在使用的主题包被替换了呢?");
        paramContext = paramIntent.getDataString();
      } while (TextUtils.isEmpty(paramContext));
      paramContext = paramContext.replace("package:", "");
      bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
      c.a("wallpaper", "有apk包被替换安装,是不是正在使用的主题包被替换了呢?replacing：" + bool);
    } while ((!bool) || (!a.g(paramContext, k.f(this.a))));
    k.a(this.a, paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */