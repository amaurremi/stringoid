package com.gau.go.launcherex.gowidget.weather.globaltheme.view.a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.globalview.y;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.view.GoWidgetGuideActivity;
import com.gtp.go.weather.billing.view.PayActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class s
  extends a
{
  private com.gau.go.launcherex.gowidget.weather.globaltheme.d f;
  private SharedPreferences g = null;
  private com.gau.go.launcherex.gowidget.weather.globalview.b h;
  private y i;
  private x j;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.b.e k;
  private boolean l = true;
  private boolean m = false;
  private boolean n = false;
  private w o;
  
  public s(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private String a(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  private void a(String paramString)
  {
    if (this.i == null)
    {
      this.i = new y(this.a, com.gau.go.launcherex.gowidget.weather.globalview.aa.b);
      this.i.a(2131165780);
      this.i.c(2131166038);
    }
    this.i.b(paramString);
    if ((!this.a.isFinishing()) && (!this.i.isShowing())) {
      this.i.show();
    }
  }
  
  private void b(int paramInt)
  {
    com.gau.go.launcherex.gowidget.weather.globalview.b localb = new com.gau.go.launcherex.gowidget.weather.globalview.b(this.a, com.gau.go.launcherex.gowidget.weather.globalview.e.c);
    localb.b(2131166447);
    localb.a(true);
    localb.b(false);
    localb.a(new u(this, paramInt));
    switch (paramInt)
    {
    }
    for (;;)
    {
      localb.b();
      return;
      localb.c(2131166532);
      localb.d(2131166486);
      if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(this.a))
      {
        localb.e(2131166040);
      }
      else
      {
        localb.e(2131166038);
        continue;
        localb.c(2131166530);
        localb.d(2131166531);
        localb.e(2131166038);
      }
    }
  }
  
  private void b(String paramString)
  {
    Toast.makeText(this.a, paramString, 0).show();
  }
  
  private boolean b(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    if ((!parame.A()) && (!com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.b(this.a.getApplicationContext(), parame.x()))) {
      b(this.a.getString(2131166420));
    }
    Object localObject;
    do
    {
      return false;
      localObject = com.gau.go.launcherex.gowidget.weather.c.c.a(this.a.getApplicationContext()).e();
      if (((f)localObject).c()) {
        break;
      }
      if ((parame.l() == 2) && (!((f)localObject).b()))
      {
        c(1);
        return false;
      }
      if ((parame.l() != 3) || (parame.g())) {
        break;
      }
      if (com.jiubang.playsdk.a.aa.a().f(this.k.x()))
      {
        parame = new com.go.weatherex.managegood.b.a(this.k.x(), 2, com.jiubang.playsdk.a.aa.a().g(this.k.x()));
        com.go.weatherex.managegood.a.n.a().a(this.a, parame);
        return false;
      }
      localObject = com.gau.go.launcherex.gowidget.weather.globaltheme.a.c(this.a.getApplicationContext(), this.k.x(), "theme_pay_type");
      com.gtp.a.a.b.c.a("theme_pay", "themePayType = " + (String)localObject);
      if (((String)localObject).equals("0"))
      {
        if (parame.a())
        {
          c(parame);
          return false;
        }
        d(parame);
        return false;
      }
    } while ((!((String)localObject).equals("2")) && (!((String)localObject).equals("1")));
    parame = new Intent(this.a, PayActivity.class);
    parame.putExtra("extra_package_name", this.k.x());
    parame.putExtra("theme_pay_type", (String)localObject);
    parame.putExtra("key_isApkAward", this.k.a());
    if ((this.k.e()) && (this.k.d()))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.k.c().iterator();
      while (localIterator.hasNext())
      {
        com.gau.go.launcherex.gowidget.weather.globaltheme.b.a locala = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.a)localIterator.next();
        ((ArrayList)localObject).add(locala.a());
        parame.putExtra(locala.a(), locala.b());
      }
      parame.putStringArrayListExtra("extra_coupon_ids_arraylist", (ArrayList)localObject);
    }
    this.a.startActivity(parame);
    return false;
    if (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.b(this.a.getApplicationContext(), parame))
    {
      e();
      return false;
    }
    if (!com.gau.go.launcherex.gowidget.weather.util.k.a(this.a.getApplicationContext()))
    {
      b(4);
      return false;
    }
    if (this.e) {}
    for (boolean bool = c();; bool = false)
    {
      if ((this.d) && (!bool)) {
        e(this.k);
      }
      parame.i(true);
      if (this.c) {
        this.f.a(2, parame);
      }
      if (this.b != null) {
        this.b.a(this.k);
      }
      return true;
    }
  }
  
  private void c(int paramInt)
  {
    Intent localIntent = new Intent(this.a, BillingActivity.class);
    localIntent.putExtra("recommend_type", paramInt);
    localIntent.putExtra("recommend_enterance", 8);
    this.a.startActivity(localIntent);
  }
  
  private void c(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    com.gtp.go.weather.sharephoto.award.k localk = new com.gtp.go.weather.sharephoto.award.k(this.a);
    localk.a(new t(this, parame, localk));
    com.gtp.go.weather.sharephoto.award.k.a(this.a, parame.x());
  }
  
  private boolean c()
  {
    if ((this.g.getBoolean("show_widget_tip_dialog", true)) && (!this.l))
    {
      b(3);
      return true;
    }
    return false;
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this.a, GoWidgetGuideActivity.class);
    this.a.startActivity(localIntent);
  }
  
  private void d(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(parame.x(), "com.gau.go.weatherex.framework.billing.PayActivity");
    if ((this.k.e()) && (this.k.d()))
    {
      parame = new ArrayList();
      Iterator localIterator = this.k.c().iterator();
      while (localIterator.hasNext())
      {
        com.gau.go.launcherex.gowidget.weather.globaltheme.b.a locala = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.a)localIterator.next();
        parame.add(locala.a());
        localIntent.putExtra(locala.a(), locala.b());
      }
      localIntent.putStringArrayListExtra("extra_coupon_ids_arraylist", parame);
    }
    try
    {
      this.a.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException parame)
    {
      while (!com.gtp.a.a.b.c.a()) {}
      parame.printStackTrace();
    }
  }
  
  private void e()
  {
    if (this.h == null)
    {
      this.h = new com.gau.go.launcherex.gowidget.weather.globalview.b(this.a, com.gau.go.launcherex.gowidget.weather.globalview.e.b);
      this.h.b(2131165780);
      this.h.c(2131166419);
      this.h.d(2131165363);
      this.h.a(new v(this));
    }
    if ((!this.a.isFinishing()) && (!this.h.isShowing())) {
      this.h.b();
    }
  }
  
  private boolean e(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((this.m) && (!parame.h())) {
      localStringBuffer.append(a(2131166478));
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (this.n)
      {
        bool2 = bool1;
        if (!parame.i())
        {
          if (bool1) {
            localStringBuffer.append(", ");
          }
          localStringBuffer.append(a(2131166479));
          bool2 = true;
        }
      }
      if (bool2) {
        a(String.format(a(2131166534), new Object[] { localStringBuffer.toString() }));
      }
      return bool2;
    }
  }
  
  private void f()
  {
    Intent localIntent1 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.gau.go.launcherex.gowidget.weatherwidget&referrer=utm_source%3Dthemeupdate%26utm_medium%3DHyperlink%26utm_campaign%3Dthemes"));
    localIntent1.setPackage("com.android.vending");
    localIntent1.setFlags(268435456);
    try
    {
      this.a.startActivity(localIntent1);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException1)
    {
      Intent localIntent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.gau.go.launcherex.gowidget.weatherwidget&referrer=utm_source%3Dthemeupdate%26utm_medium%3DHyperlink%26utm_campaign%3Dthemes"));
      localIntent2.setFlags(268435456);
      try
      {
        this.a.startActivity(localIntent2);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException2)
      {
        localActivityNotFoundException2.printStackTrace();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void g()
  {
    com.gau.go.launcherex.gowidget.weather.util.k.a(this.a.getApplicationContext(), 2);
  }
  
  public void a()
  {
    this.f = new com.gau.go.launcherex.gowidget.weather.globaltheme.d(this.a.getApplicationContext());
    this.g = GoWidgetApplication.c(this.a.getApplicationContext()).a();
    this.j = new x(this, null);
    new IntentFilter();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION");
    a(this.j, localIntentFilter);
    this.o = new w(this.a.getContentResolver(), this);
    if (com.gau.go.launcherex.gowidget.weather.util.k.a(this.a.getApplicationContext()))
    {
      this.o.a(-1, null, WeatherContentProvider.l, new String[] { "go_widget_type" }, null, null, null);
      return;
    }
    this.m = false;
    this.n = false;
    this.l = false;
    this.o.a(-1, null, WeatherContentProvider.l, null, null);
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    this.k = parame;
    boolean bool = b(parame);
    com.gau.go.launcherex.goweather.goplay.n.a(this.a).a(this.k.x(), bool);
  }
  
  public boolean a(Activity paramActivity)
  {
    boolean bool = super.a(paramActivity);
    if (bool)
    {
      this.h = null;
      this.i = null;
    }
    return bool;
  }
  
  public void b()
  {
    this.f.a();
    a(this.j);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */