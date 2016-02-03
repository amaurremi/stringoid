package com.gau.go.launcherex.gowidget.language;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.go.weatherex.framework.a.a;

public abstract class GoWeatherExFragmentActivity
  extends FragmentActivity
  implements a
{
  private final a a = com.go.weatherex.framework.a.b.a();
  private final BroadcastReceiver b = new c(this);
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    this.a.a(paramView, paramInt1, paramInt2);
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    this.a.a(paramView, paramInt, paramBoolean);
  }
  
  public void a(b paramb) {}
  
  public b b_()
  {
    return d.a(getApplicationContext()).a();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968606, 2130968589);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_USER_LANGUAGE_CHANGED");
    registerReceiver(this.b, paramBundle);
  }
  
  protected void onDestroy()
  {
    unregisterReceiver(this.b);
    super.onDestroy();
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(paramIntent);
    overridePendingTransition(2130968587, 2130968606);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt);
    overridePendingTransition(2130968587, 2130968606);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/language/GoWeatherExFragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */