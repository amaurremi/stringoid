package com.gau.go.launcherex.gowidget.weather.globaltheme.view.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;

public abstract class a
  implements com.go.weatherex.framework.a.a
{
  protected Activity a;
  protected b b;
  protected boolean c = true;
  protected boolean d = true;
  protected boolean e = true;
  private com.go.weatherex.framework.a.a f;
  
  public a(Activity paramActivity)
  {
    if (paramActivity == null) {
      throw new IllegalArgumentException("com.gau.go.launcherex.gowidget.weather.globaltheme.view.action.ActionHelper.ActionHelper(Activity act) : act can't be null ");
    }
    this.a = paramActivity;
    if ((paramActivity instanceof com.go.weatherex.framework.a.a)) {
      this.f = ((com.go.weatherex.framework.a.a)paramActivity);
    }
  }
  
  public Intent a(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return this.a.getApplicationContext().registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  public abstract void a();
  
  public void a(BroadcastReceiver paramBroadcastReceiver)
  {
    this.a.getApplicationContext().unregisterReceiver(paramBroadcastReceiver);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.f != null) {
      this.f.a(paramView, paramInt1, paramInt2);
    }
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (this.f != null) {
      this.f.a(paramView, paramInt, paramBoolean);
    }
  }
  
  public abstract void a(e parame);
  
  public void a(b paramb)
  {
    this.b = paramb;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a(Activity paramActivity)
  {
    if ((paramActivity == null) || (this.a == paramActivity)) {
      return false;
    }
    this.a = paramActivity;
    return true;
  }
  
  public abstract void b();
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */