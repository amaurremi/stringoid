package com.go.weatherex.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.a.i;
import com.gau.go.launcherex.gowidget.a.l;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.b.u;
import com.gau.go.launcherex.gowidget.weather.d.p;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import com.getjar.sdk.Account;
import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.GetjarConnectionResult;
import com.gtp.a.a.b.c;
import com.gtp.a.a.c.d;
import com.gtp.go.weather.sharephoto.a.a;

public class m
  implements i, l
{
  private com.gau.go.launcherex.gowidget.a.g a;
  private GetjarClient b;
  private short c = 0;
  private u d;
  private Activity e;
  private volatile boolean f = false;
  
  private void b()
  {
    if (this.e == null) {
      return;
    }
    Intent localIntent = new Intent(this.e.getApplicationContext(), NotifyService.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("notify_request", 34);
    localIntent.putExtras(localBundle);
    this.e.getApplicationContext().startService(localIntent);
  }
  
  public void a()
  {
    if (this.f) {
      return;
    }
    this.a.b();
    c.a("adid", "InterstitialAdvertisementHandler: Getjar - onConnected");
    this.e.runOnUiThread(new n(this));
    this.c = 0;
  }
  
  public void a(Activity paramActivity)
  {
    if (!y.i(paramActivity.getApplicationContext()))
    {
      this.a.a(this);
      this.a.a(this);
      c.a("adid", "InterstitialAdvertisementHandler: Getjar - connect : ");
      this.b.connect();
      return;
    }
    this.d.b();
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      this.a.a(paramIntent);
    }
  }
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    this.a.a(paramIntent);
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    this.e = paramActivity;
    this.f = false;
    paramBundle = paramActivity.getIntent();
    this.a = com.gau.go.launcherex.gowidget.a.g.a(paramActivity);
    this.b = this.a.c();
    this.a.a(paramBundle);
    p.a(paramActivity.getApplicationContext()).a(this.a);
    if ((TextUtils.isEmpty(com.gtp.go.weather.sharephoto.a.g.a(paramActivity.getApplicationContext()).b().a())) && (y.h(paramActivity.getApplicationContext()))) {
      if (this.b == null) {
        break label155;
      }
    }
    label155:
    for (paramBundle = this.b.getCurrentAccount();; paramBundle = null)
    {
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getName();
        if (!TextUtils.isEmpty(paramBundle)) {
          com.gtp.go.weather.sharephoto.a.g.a(paramActivity.getApplicationContext()).c().a(false, paramBundle);
        }
      }
      this.d = new u(paramActivity);
      this.d.a();
      b();
      return;
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (this.e == null) {
      return;
    }
    this.a.a(paramIntent);
  }
  
  public void a(GetjarConnectionResult paramGetjarConnectionResult)
  {
    if (this.f) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramGetjarConnectionResult.getErrorCode();
        c.a("adid", "InterstitialAdvertisementHandler: Getjar - onConnectionFailed : " + i);
      } while ((i != 6) || (!paramGetjarConnectionResult.hasResolution()));
      i = this.c;
      this.c = ((short)(i + 1));
    } while ((i >= 1) || (!d.b(this.e.getApplicationContext())));
    this.e.runOnUiThread(new o(this));
  }
  
  public void b(Activity paramActivity)
  {
    if (!y.i(paramActivity.getApplicationContext()))
    {
      this.a.a(this);
      this.a.a(this);
    }
  }
  
  public void c(Activity paramActivity)
  {
    if (!y.i(paramActivity.getApplicationContext()))
    {
      this.a.b(this);
      this.a.b(this);
    }
  }
  
  public void d(Activity paramActivity) {}
  
  public void e(Activity paramActivity)
  {
    this.f = true;
    this.e = null;
    if (this.d != null) {
      this.d.d();
    }
  }
  
  public boolean f(Activity paramActivity)
  {
    if ((!com.go.weatherex.b.a.g.a) && (this.d != null)) {
      this.d.c();
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */