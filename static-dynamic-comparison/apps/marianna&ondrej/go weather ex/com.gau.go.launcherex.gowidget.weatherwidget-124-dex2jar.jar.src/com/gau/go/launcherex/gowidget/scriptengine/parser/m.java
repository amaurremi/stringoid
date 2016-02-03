package com.gau.go.launcherex.gowidget.scriptengine.parser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gtp.a.a.b.c;

class m
  extends BroadcastReceiver
{
  private m(i parami) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    boolean bool;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              str = paramIntent.getAction();
              if (!"android.intent.action.PACKAGE_REMOVED".equals(str)) {
                break;
              }
              str = paramIntent.getDataString();
            } while (TextUtils.isEmpty(str));
            str = str.replace("package:", "");
            bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
            c.a("dynamicbg", "有apk包被删除,是不是正在使用的主题包被删了呢?pkgName: " + str + ", mPackageName:" + i.g(this.a) + ", replacing:" + bool);
          } while ((!i.g(this.a).equals(str)) || (bool));
          i.a(this.a, "com.gau.go.launcherex.gowidget.weatherwidget");
          i.i(this.a);
          this.a.b(paramContext);
          return;
        } while (!"android.intent.action.PACKAGE_REPLACED".equals(str));
        c.a("dynamicbg", "有apk包被替换安装,是不是正在使用的主题包被替换了呢?");
        str = paramIntent.getDataString();
      } while (TextUtils.isEmpty(str));
      str = str.replace("package:", "");
      bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
      c.a("dynamicbg", "有apk包被替换安装,是不是正在使用的主题包被替换了呢?replacing：" + bool);
    } while ((!bool) || (!i.g(this.a).equals(str)));
    i.a(this.a, str);
    i.i(this.a);
    this.a.b(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */