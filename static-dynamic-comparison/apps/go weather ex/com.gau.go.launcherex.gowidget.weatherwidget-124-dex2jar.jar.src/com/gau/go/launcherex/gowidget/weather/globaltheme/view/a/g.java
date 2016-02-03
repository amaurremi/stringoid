package com.gau.go.launcherex.gowidget.weather.globaltheme.view.a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.b.ar;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.view.al;
import com.gtp.go.weather.billing.view.PayActivity;
import com.gtp.go.weather.sharephoto.x;
import com.jiubang.playsdk.a.aa;
import java.util.ArrayList;
import java.util.Iterator;

public class g
  extends a
{
  private com.gau.go.launcherex.gowidget.weather.globaltheme.d f;
  private al g;
  private com.gau.go.launcherex.gowidget.weather.globalview.b h;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.b.e i;
  private SharedPreferences j = null;
  private boolean k;
  private BroadcastReceiver l = new k(this);
  
  public g(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent(this.a, BillingActivity.class);
    localIntent.putExtra("recommend_type", paramInt);
    localIntent.putExtra("recommend_enterance", 8);
    this.a.startActivity(localIntent);
  }
  
  private void b(int paramInt)
  {
    if (!this.a.isFinishing())
    {
      if (this.g == null) {
        break label35;
      }
      if (!this.g.isShowing()) {
        this.g.show();
      }
    }
    return;
    label35:
    this.g = al.a(this.a);
    this.g.setCanceledOnTouchOutside(false);
    this.g.setOnKeyListener(new j(this));
    this.g.a(c(paramInt));
    this.g.show();
  }
  
  private boolean b(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(parame.x()))
    {
      if (!com.gtp.go.weather.sharephoto.d.h.b(x.a))
      {
        Toast.makeText(this.a, 2131166383, 0).show();
        return false;
      }
      e(parame);
      if (this.b != null) {
        this.b.a(parame);
      }
      return true;
    }
    Object localObject1 = com.gau.go.launcherex.gowidget.weather.c.c.a(this.a.getApplicationContext()).e();
    if (!((f)localObject1).c()) {
      switch (parame.l())
      {
      }
    }
    int m;
    do
    {
      for (m = 0;; m = 1)
      {
        if (m == 0)
        {
          if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.b(this.a.getApplicationContext(), parame)) {
            break label518;
          }
          c();
        }
        return false;
        if (((f)localObject1).b()) {
          break;
        }
        a(1);
      }
    } while (parame.g());
    if (!com.gau.go.launcherex.gowidget.d.g.a(this.a))
    {
      Toast.makeText(this.a, this.a.getString(2131165656), 0).show();
      return false;
    }
    if (aa.a().f(this.i.x()))
    {
      parame = new com.go.weatherex.managegood.b.a(this.i.x(), 2, aa.a().g(this.i.x()));
      com.go.weatherex.managegood.a.n.a().a(this.a, parame);
      return false;
    }
    Object localObject2 = com.gau.go.launcherex.gowidget.weather.globaltheme.a.c(this.a.getApplicationContext(), this.i.x(), "theme_pay_type");
    com.gtp.a.a.b.c.a("theme_pay", "themePayType = " + (String)localObject2);
    if (((String)localObject2).equals("0")) {
      if (parame.a()) {
        c(parame);
      }
    }
    for (;;)
    {
      m = 1;
      break;
      d(parame);
      continue;
      if ((((String)localObject2).equals("2")) || (((String)localObject2).equals("1")))
      {
        localObject1 = new Intent(this.a, PayActivity.class);
        ((Intent)localObject1).putExtra("extra_package_name", this.i.x());
        ((Intent)localObject1).putExtra("theme_pay_type", (String)localObject2);
        ((Intent)localObject1).putExtra("key_isApkAward", this.i.a());
        if ((this.i.e()) && (this.i.d()))
        {
          localObject2 = new ArrayList();
          Iterator localIterator = this.i.c().iterator();
          while (localIterator.hasNext())
          {
            com.gau.go.launcherex.gowidget.weather.globaltheme.b.a locala = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.a)localIterator.next();
            ((ArrayList)localObject2).add(locala.a());
            ((Intent)localObject1).putExtra(locala.a(), locala.b());
          }
          ((Intent)localObject1).putStringArrayListExtra("extra_coupon_ids_arraylist", (ArrayList)localObject2);
        }
        this.a.startActivity((Intent)localObject1);
        e();
      }
    }
    label518:
    e(parame);
    return true;
  }
  
  private String c(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  private void c()
  {
    if (this.h == null)
    {
      this.h = new com.gau.go.launcherex.gowidget.weather.globalview.b(this.a);
      this.h.b(2131165780);
      this.h.c(2131166419);
      this.h.d(2131165364);
      this.h.a(new i(this));
    }
    if ((!this.a.isFinishing()) && (!this.h.isShowing())) {
      this.h.b();
    }
  }
  
  private void c(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    com.gtp.go.weather.sharephoto.award.k localk = new com.gtp.go.weather.sharephoto.award.k(this.a);
    localk.a(new h(this, parame, localk));
    com.gtp.go.weather.sharephoto.award.k.a(this.a, parame.x());
    b(2131166397);
  }
  
  private void d()
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
  
  private void d(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(parame.x(), "com.gau.go.weatherex.framework.billing.PayActivity");
    if ((this.i.e()) && (this.i.d()))
    {
      parame = new ArrayList();
      Iterator localIterator = this.i.c().iterator();
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
    if ((!this.a.isFinishing()) && (this.g != null) && (this.g.isShowing()))
    {
      this.g.dismiss();
      this.g = null;
    }
  }
  
  private void e(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    parame.i(true);
    this.f.a(1, parame);
    b(2131166409);
  }
  
  private void f()
  {
    int n = 0;
    if ((this.i == null) || (this.a == null) || (this.a.isFinishing())) {}
    int m;
    do
    {
      do
      {
        return;
      } while ("com.gtp.go.weather.phototheme".equals(this.i.x()));
      m = n;
      if (this.i.f())
      {
        m = n;
        if (!this.k)
        {
          m = n;
          if (!this.j.getBoolean("key_not_remind_open_dynamic_effect", false)) {
            m = 1;
          }
        }
      }
    } while (m == 0);
    com.gau.go.launcherex.gowidget.weather.globalview.b localb = new com.gau.go.launcherex.gowidget.weather.globalview.b(this.a, com.gau.go.launcherex.gowidget.weather.globalview.e.b);
    localb.b(2131166447);
    localb.c(2131166448);
    localb.a(true);
    localb.a(new l(this));
    localb.b();
  }
  
  public void a()
  {
    this.f = new com.gau.go.launcherex.gowidget.weather.globaltheme.d(this.a.getApplicationContext());
    this.j = GoWidgetApplication.c(this.a.getApplicationContext()).a();
    this.k = ar.a(this.a);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SCREEN_BACKGROUND_PREVIEW_DONE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_ALL_SCRIPT_DONE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_DONE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION");
    a(this.l, localIntentFilter);
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    this.i = parame;
    boolean bool = b(parame);
    com.gau.go.launcherex.goweather.goplay.n.a(this.a).a(this.i.x(), bool);
  }
  
  public boolean a(Activity paramActivity)
  {
    boolean bool = super.a(paramActivity);
    if (bool)
    {
      this.g = null;
      this.h = null;
    }
    return bool;
  }
  
  public void b()
  {
    this.f.a();
    a(this.l);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */