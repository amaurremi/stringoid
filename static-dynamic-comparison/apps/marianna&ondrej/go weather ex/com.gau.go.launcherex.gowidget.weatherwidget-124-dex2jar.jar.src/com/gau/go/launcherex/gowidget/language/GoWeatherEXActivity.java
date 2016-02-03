package com.gau.go.launcherex.gowidget.language;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public abstract class GoWeatherEXActivity
  extends Activity
  implements com.go.weatherex.framework.a.a
{
  private final com.go.weatherex.framework.a.a a = com.go.weatherex.framework.a.b.a();
  private BroadcastReceiver b = new a(this);
  
  public void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.startActivity(paramIntent);
    overridePendingTransition(paramInt1, paramInt2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    this.a.a(paramView, paramInt1, paramInt2);
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    this.a.a(paramView, paramInt, paramBoolean);
  }
  
  public void a(b paramb)
  {
    c();
    d();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.finish();
    overridePendingTransition(paramInt1, paramInt2);
  }
  
  protected void c() {}
  
  public void c(int paramInt)
  {
    super.finish();
    overridePendingTransition(2130968606, paramInt);
  }
  
  protected void d() {}
  
  public b e()
  {
    return d.a(this).a();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968606, 2130968585);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED");
    registerReceiver(this.b, paramBundle);
  }
  
  protected void onDestroy()
  {
    if (this.b != null)
    {
      unregisterReceiver(this.b);
      this.b = null;
    }
    super.onDestroy();
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(paramIntent);
    overridePendingTransition(2130968584, 2130968606);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt);
    overridePendingTransition(2130968584, 2130968606);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/language/GoWeatherEXActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */