package com.gau.go.launcherex.gowidget.weather.d;

import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.statistics.y;
import java.util.HashMap;
import java.util.Map;

public class f
{
  private static f a;
  private Map b = new HashMap();
  private Context c;
  private int d;
  
  private f(Context paramContext)
  {
    this.c = paramContext;
    h();
  }
  
  public static f a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      a = new f(paramContext);
      return a;
    }
    finally {}
  }
  
  private boolean c(String paramString)
  {
    return a(paramString).a();
  }
  
  private void h()
  {
    this.d &= 0x0;
    if (i()) {
      this.d |= 0x10;
    }
    if ((c("com.gau.go.launcherex.gowidget.weatherwidge.billingpay1")) || (c("go_weather_ex_premium_pack_promotions"))) {
      this.d |= 0x2;
    }
    if ((c("go_weather_ex_premium_pack_vip")) || (c("go_weather_ex_premium_pack_vip_promo"))) {
      this.d |= 0x20;
    }
    if ((c("go_weather_ex_premium_pack_theme_vip")) || (c("go_weather_ex_premium_pack_theme_vip_promo"))) {
      this.d |= 0x40;
    }
    if (c("goweatherex_getjar_id")) {
      this.d |= 0x1;
    }
    if (c("goweatherex_apk_id")) {
      this.d |= 0x8;
    }
    if (c("go_weather_ex_premium_activation")) {
      this.d |= 0x80;
    }
  }
  
  private boolean i()
  {
    return y.p(this.c);
  }
  
  public g a(String paramString)
  {
    g localg2 = (g)this.b.get(paramString);
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg2 = new g(this.c, paramString);
      localg1 = localg2;
      if (localg2 != null)
      {
        this.b.put(paramString, localg2);
        localg1 = localg2;
      }
    }
    return localg1;
  }
  
  public boolean a()
  {
    return (b()) || (c());
  }
  
  public boolean a(int paramInt)
  {
    return (this.d & paramInt) != 0;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    if (paramString.a() != paramBoolean)
    {
      paramString.a(paramBoolean);
      h();
      return true;
    }
    return false;
  }
  
  public void b(String paramString)
  {
    if ((paramString.equals("com.gau.go.launcherex.gowidget.weatherwidge.billingpay1")) || (paramString.equals("go_weather_ex_premium_pack_promotions")) || (paramString.equals("go_weather_ex_premium_pack_vip")) || (paramString.equals("go_weather_ex_premium_pack_vip_promo")) || (paramString.equals("goweatherex_getjar_id")) || (paramString.equals("goweatherex_apk_id")) || (paramString.equals("go_weather_ex_premium_activation")))
    {
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
      this.c.sendBroadcast(localIntent);
    }
    if ((paramString.equals("go_weather_ex_premium_pack_theme_vip")) || (paramString.equals("go_weather_ex_premium_pack_theme_vip_promo")) || (paramString.equals("go_weather_ex_premium_pack_vip")) || (paramString.equals("go_weather_ex_premium_pack_vip_promo")))
    {
      paramString = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION");
      this.c.sendBroadcast(paramString);
    }
  }
  
  public boolean b()
  {
    return (a(16)) || (a(2)) || (a(32)) || (a(1)) || (a(8)) || (a(128));
  }
  
  public boolean c()
  {
    return (a(32)) || (a(64));
  }
  
  public boolean d()
  {
    return a(32);
  }
  
  public boolean e()
  {
    return this.d == 0;
  }
  
  public void f()
  {
    this.b.clear();
    h();
  }
  
  public void g()
  {
    this.b.clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */