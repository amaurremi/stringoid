package com.gau.go.launcherex.goweather.goplay;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.gtp.a.a.a.a;
import java.util.HashMap;
import java.util.Map;

public class n
{
  private static n e;
  private final Context a;
  private final Map b;
  private final com.gau.go.launcherex.goweather.goplay.a.c c;
  private final com.gau.go.launcherex.goweather.goplay.a.d d;
  private final p f;
  
  private n(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    com.gau.go.gostaticsdk.d.a(this.a).a(com.gtp.a.a.b.c.a());
    this.b = new HashMap();
    this.c = new com.gau.go.launcherex.goweather.goplay.a.c(this.a);
    this.d = new com.gau.go.launcherex.goweather.goplay.a.d(this.a);
    this.f = new p(this, null);
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.PACKAGE_ADDED");
    paramContext.addDataScheme("package");
    this.a.registerReceiver(this.f, paramContext);
  }
  
  public static n a(Context paramContext)
  {
    if (e == null) {
      e = new n(paramContext);
    }
    return e;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "102";
    case 2: 
      return "103";
    case 20: 
      return "102";
    case 32: 
      return "105";
    case 31: 
      return "104";
    case 6: 
      return "102";
    case 35: 
      return "108";
    case 36: 
      return "109";
    case 34: 
      return "101";
    case 33: 
      return "100";
    }
    return "100";
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.b.get(paramString1) != null)) {
      return;
    }
    this.b.put(paramString1, paramString2);
  }
  
  private void b(String paramString)
  {
    paramString = (String)this.b.remove(paramString);
    if (paramString == null) {
      return;
    }
    com.gau.go.gostaticsdk.d.a(this.a).a(paramString);
    b("成功下载安装主题", paramString);
  }
  
  private void b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[操作：");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("] ");
    localStringBuilder.append("[上传信息：");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("]");
    paramString1 = localStringBuilder.toString();
    com.gtp.a.a.b.c.a("ThemeStatisticsManager", paramString1);
    a.a().a(paramString1, "theme_statistics.txt");
  }
  
  private static String c(String paramString)
  {
    String str = "从天气主界面进入商店";
    if ("101".equals(paramString)) {
      str = "从天气主界面的更多菜单进入商店";
    }
    do
    {
      return str;
      if ("102".equals(paramString)) {
        return "从GOWidget进入商店";
      }
      if ("103".equals(paramString)) {
        return "从系统Widget进入商店";
      }
      if ("104".equals(paramString)) {
        return "从GOWidget的小星星进入商店";
      }
      if ("105".equals(paramString)) {
        return "从系统Widget的小星星进入商店";
      }
      if ("109".equals(paramString)) {
        return "从系统Widget一键切换主题进入商店";
      }
      if ("108".equals(paramString)) {
        return "从GOWidget一键切换主题进入商店";
      }
    } while (!"100".equals(paramString));
    return "从天气主界面进入商店";
  }
  
  public void a()
  {
    this.c.a();
    this.c.f = "click_vip";
    String str = this.c.b();
    com.gau.go.gostaticsdk.d.a(this.a).a(str);
    b("点击VIP入口", str);
  }
  
  public void a(String paramString)
  {
    this.c.a();
    this.c.f = "g001";
    this.c.l = paramString;
    String str = this.c.b();
    com.gau.go.gostaticsdk.d.a(this.a).a(str);
    b(c(paramString), str);
  }
  
  public void a(String paramString, int paramInt, float paramFloat)
  {
    a(paramString, paramInt, paramFloat, "0");
  }
  
  public void a(String paramString1, int paramInt, float paramFloat, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.d.a();
    this.d.e = paramString1;
    this.d.f = "j001";
    this.d.g = String.valueOf(paramInt);
    this.d.q = (paramFloat + ":coin");
    paramString2 = this.d.b();
    com.gau.go.gostaticsdk.d.a(this.a).a(paramString2);
    if (paramInt == 1) {}
    for (paramString1 = "Getjar成功购买主题";; paramString1 = "点击Getjar购买主题")
    {
      b(paramString1, paramString2);
      return;
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    this.c.a();
    this.c.e = String.valueOf(paramLong);
    this.c.m = paramString2;
    this.c.n = String.valueOf(paramInt);
    this.c.f = "b000";
    a(paramString1, this.c.b());
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.c.a();
    this.c.e = paramString;
    Object localObject = this.c;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      paramString = "1";
      ((com.gau.go.launcherex.goweather.goplay.a.c)localObject).g = paramString;
      this.c.f = "i000";
      localObject = this.c.b();
      com.gau.go.gostaticsdk.d.a(this.a).a((String)localObject);
      localStringBuilder = new StringBuilder().append("应用主题");
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (paramString = "成功";; paramString = "失败")
    {
      b(paramString, (String)localObject);
      return;
      paramString = "0";
      break;
    }
  }
  
  public void b(String paramString, int paramInt, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.d.a();
    this.d.e = paramString;
    this.d.f = "j009";
    this.d.g = String.valueOf(paramInt);
    this.d.q = (paramFloat + ":coin");
    String str = this.d.b();
    com.gau.go.gostaticsdk.d.a(this.a).a(str);
    if (paramInt == 1) {}
    for (paramString = "Fortumo成功购买主题";; paramString = "点击Fortumo购买主题")
    {
      b(paramString, str);
      return;
    }
  }
  
  public void c(String paramString, int paramInt, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.d.a();
    this.d.e = paramString;
    this.d.f = "j005";
    this.d.g = String.valueOf(paramInt);
    this.d.q = (paramFloat + ":coin");
    String str = this.d.b();
    com.gau.go.gostaticsdk.d.a(this.a).a(str);
    if (paramInt == 1) {}
    for (paramString = "GooglePlay成功购买主题";; paramString = "点击GooglePlay购买主题")
    {
      b(paramString, str);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */