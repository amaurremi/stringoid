package com.gau.go.launcherex.gowidget.weather.globaltheme.view.a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.d.g;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.globalview.y;
import com.gau.go.launcherex.gowidget.weather.view.AppInSDPromptActivity;
import com.gau.go.launcherex.gowidget.weather.view.AppWidgetGuideActivity;
import com.gau.go.launcherex.gowidget.weather.view.al;
import com.gtp.go.weather.billing.view.PayActivity;
import com.gtp.go.weather.sharephoto.award.k;
import java.util.ArrayList;
import java.util.Iterator;

public class m
  extends a
{
  private com.gau.go.launcherex.gowidget.weather.globaltheme.d f;
  private SharedPreferences g = null;
  private com.gau.go.launcherex.gowidget.weather.globalview.b h;
  private y i;
  private r j;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.b.e k;
  private al l;
  
  public m(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(int paramInt)
  {
    com.gau.go.launcherex.gowidget.weather.globalview.b localb = new com.gau.go.launcherex.gowidget.weather.globalview.b(this.a, com.gau.go.launcherex.gowidget.weather.globalview.e.c);
    localb.b(2131166447);
    localb.a(true);
    localb.b(false);
    localb.a(new o(this, paramInt));
    switch (paramInt)
    {
    }
    for (;;)
    {
      localb.b();
      return;
      localb.b(b(2131166528));
      localb.c(b(2131166485));
      localb.d(b(2131166039));
      continue;
      localb.b(b(2131166529));
      localb.c(b(2131166485));
      localb.d(b(2131166038));
    }
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
  
  private String b(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  private void b(String paramString)
  {
    Toast.makeText(this.a, paramString, 0).show();
  }
  
  private boolean b(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    if ((!parame.A()) && (!com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.b(this.a.getApplicationContext(), parame.x())))
    {
      b(this.a.getString(2131166420));
      return false;
    }
    Object localObject = com.gau.go.launcherex.gowidget.weather.c.c.a(this.a.getApplicationContext()).e();
    if (!((f)localObject).c())
    {
      if ((parame.l() == 2) && (!((f)localObject).b()))
      {
        c(1);
        return false;
      }
      if ((parame.l() == 3) && (!parame.g()))
      {
        if (!g.a(this.a))
        {
          Toast.makeText(this.a, this.a.getString(2131165656), 0).show();
          return false;
        }
        if (com.jiubang.playsdk.a.aa.a().f(this.k.x()))
        {
          parame = new com.go.weatherex.managegood.b.a(this.k.x(), 2, com.jiubang.playsdk.a.aa.a().g(this.k.x()));
          com.go.weatherex.managegood.a.n.a().a(this.a, parame);
          return false;
        }
        localObject = com.gau.go.launcherex.gowidget.weather.globaltheme.a.c(this.a.getApplicationContext(), this.k.x(), "theme_pay_type");
        com.gtp.a.a.b.c.a("theme_pay", "themePayType = " + (String)localObject);
        if (((String)localObject).equals("0")) {
          if (parame.a()) {
            c(parame);
          }
        }
        for (;;)
        {
          return false;
          d(parame);
          continue;
          if ((((String)localObject).equals("2")) || (((String)localObject).equals("1")))
          {
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
            i();
          }
        }
      }
    }
    if (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.b(this.a.getApplicationContext(), parame))
    {
      e();
      return false;
    }
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.b(this.a.getApplicationContext())) {
      g();
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = c();
      }
      if ((this.d) && (!bool2)) {
        e(this.k);
      }
      parame.i(true);
      if (this.c) {
        this.f.a(0, parame);
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
    k localk = new k(this.a);
    localk.a(new n(this, parame, localk));
    k.a(this.a, parame.x());
    h();
  }
  
  private boolean c()
  {
    boolean bool1 = this.g.getBoolean("show_widget_tip_dialog", true);
    Context localContext = this.a.getApplicationContext();
    if (bool1)
    {
      bool1 = com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(localContext);
      boolean bool2 = com.gau.go.launcherex.gowidget.weather.globaltheme.a.f(localContext);
      if (!bool1)
      {
        if (!bool2)
        {
          a(3);
          return true;
        }
        a(2);
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this.a, AppWidgetGuideActivity.class);
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
      this.h.a(new p(this));
    }
    if ((!this.a.isFinishing()) && (!this.h.isShowing())) {
      this.h.b();
    }
  }
  
  private boolean e(com.gau.go.launcherex.gowidget.weather.globaltheme.b.e parame)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int m;
    if ((com.gau.go.launcherex.gowidget.weather.globaltheme.a.b(this.a.getApplicationContext())) && (!parame.j()))
    {
      localStringBuffer.append(b(2131166507));
      m = 1;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      int n = m;
      boolean bool1 = bool2;
      if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.d(this.a.getApplicationContext()))
      {
        n = m;
        bool1 = bool2;
        if (!parame.k())
        {
          if (m != 0) {
            localStringBuffer.append(b(2131166494));
          }
          localStringBuffer.append(b(2131166508));
          n = 1;
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.e(this.a.getApplicationContext()))
      {
        bool2 = bool1;
        if (!parame.q())
        {
          if (n != 0) {
            localStringBuffer.append(b(2131166494));
          }
          localStringBuffer.append(b(2131166524));
          bool2 = true;
        }
      }
      if (bool2) {
        a(String.format(b(2131166533), new Object[] { localStringBuffer.toString() }));
      }
      return bool2;
      m = 0;
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
    Intent localIntent = new Intent(this.a, AppInSDPromptActivity.class);
    this.a.startActivity(localIntent);
  }
  
  private void h()
  {
    if (!this.a.isFinishing())
    {
      if (this.l == null) {
        break label35;
      }
      if (!this.l.isShowing()) {
        this.l.show();
      }
    }
    return;
    label35:
    this.l = al.a(this.a);
    this.l.setCanceledOnTouchOutside(false);
    this.l.setOnKeyListener(new q(this));
    this.l.a(b(2131166397));
    this.l.show();
  }
  
  private void i()
  {
    if ((!this.a.isFinishing()) && (this.l != null) && (this.l.isShowing()))
    {
      this.l.dismiss();
      this.l = null;
    }
  }
  
  public void a()
  {
    this.f = new com.gau.go.launcherex.gowidget.weather.globaltheme.d(this.a.getApplicationContext());
    this.g = GoWidgetApplication.c(this.a.getApplicationContext()).a();
    this.j = new r(this, null);
    new IntentFilter();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION");
    a(this.j, localIntentFilter);
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
      this.l = null;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */