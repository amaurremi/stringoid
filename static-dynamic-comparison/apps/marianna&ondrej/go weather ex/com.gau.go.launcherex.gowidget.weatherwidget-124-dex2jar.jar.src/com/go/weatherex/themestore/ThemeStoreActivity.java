package com.go.weatherex.themestore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Window;
import com.gau.go.launcherex.gowidget.d.b;
import com.gau.go.launcherex.gowidget.d.e;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.globaltheme.a.d;
import com.gau.go.launcherex.gowidget.weather.view.WeatherDetailActivity;
import com.gau.go.launcherex.gowidget.weather.view.ba;
import com.go.weatherex.framework.fragment.BaseFragmentActivity;
import com.go.weatherex.framework.fragment.g;
import com.google.analytics.tracking.android.EasyTracker;
import com.gtp.a.a.b.c;

public class ThemeStoreActivity
  extends BaseFragmentActivity
  implements e
{
  private p a;
  private final ba b = new ba();
  private boolean c = false;
  private boolean d = false;
  
  public static Intent a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Intent localIntent = new Intent(paramContext, ThemeStoreActivity.class);
    localIntent.putExtra("extra_theme_entrance", paramInt1);
    localIntent.putExtra("first_level_tab_id", paramInt2);
    localIntent.putExtra("second_level_tab_id", paramInt3);
    localIntent.putExtra("cityId", paramString);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    return localIntent;
  }
  
  private boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = GoWidgetApplication.c(getApplicationContext()).b();
    boolean bool = localSharedPreferences.getBoolean(paramString, false);
    if (bool) {
      localSharedPreferences.edit().putBoolean(paramString, false).commit();
    }
    return bool;
  }
  
  private void g()
  {
    if ((this.c) || (isFinishing())) {
      return;
    }
    this.a.a(this.b);
    h();
  }
  
  private void h()
  {
    switch (this.b.c)
    {
    default: 
      return;
    case 2: 
      this.d = true;
      if (a("key_systemwidget_isfirst_open_theme"))
      {
        this.b.a = 999;
        this.b.b = 40;
        return;
      }
      this.b.a = 40;
      this.b.b = 40;
      return;
    case 20: 
      this.d = true;
      if (a("key_gowidget_isfirst_open_theme"))
      {
        this.b.a = 999;
        this.b.b = 39;
        return;
      }
      this.b.a = 39;
      this.b.b = 39;
      return;
    case 32: 
    case 36: 
      this.d = true;
      this.b.a = 40;
      this.b.b = 40;
      d.a(this, false);
      return;
    case 31: 
    case 35: 
      this.d = true;
      this.b.a = 39;
      this.b.b = 39;
      d.a(this, false);
      return;
    }
    this.d = true;
    this.b.a = 39;
    this.b.b = 39;
  }
  
  private void i()
  {
    c.a("ThemeSettingActivity", "restartActivity");
    finish();
    startActivity(a(this, this.b.c, this.b.a, this.b.b, this.b.d));
  }
  
  private void j()
  {
    if (this.d)
    {
      Intent localIntent = WeatherDetailActivity.a(this, this.b.d, true, 16, "", -1);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
  }
  
  public void a(b paramb)
  {
    switch (paramb.a)
    {
    default: 
      return;
    }
    j();
    finish();
  }
  
  protected g b()
  {
    this.a = new p(this);
    return this.a;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if ((this.a != null) && (this.a.b())) {
      return;
    }
    j();
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    c.a("ThemeSettingActivity", "onCreate: " + paramBundle);
    if (paramBundle != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      super.onCreate(null);
      this.b.a(getIntent());
      if (!this.c) {
        break;
      }
      i();
      return;
    }
    setContentView(2130903305);
    getWindow().setFormat(-3);
    getWindow().clearFlags(134217728);
    u.a(getApplicationContext());
    d().a(this, new int[] { 5 });
    g();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    c.a("ThemeSettingActivity", "onDestroy: ");
    d().a(this);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.b.a(paramIntent);
    if (this.a != null) {
      this.a.b(this.b);
    }
    h();
  }
  
  protected void onPause()
  {
    super.onPause();
    c.a("ThemeSettingActivity", "onPause: ");
  }
  
  protected void onRestart()
  {
    super.onRestart();
    c.a("ThemeSettingActivity", "onRestart: ");
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    c.a("ThemeSettingActivity", "onRestoreInstanceState: " + paramBundle);
  }
  
  protected void onResume()
  {
    super.onResume();
    c.a("ThemeSettingActivity", "onResume: ");
  }
  
  protected void onResumeFragments()
  {
    super.onResumeFragments();
    c.a("ThemeSettingActivity", "onResumeFragments: ");
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    c.a("ThemeSettingActivity", "onSaveInstanceState: ");
    this.c = true;
  }
  
  protected void onStart()
  {
    super.onStart();
    c.a("ThemeSettingActivity", "onStart: ");
    EasyTracker.getInstance().activityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    c.a("ThemeSettingActivity", "onStop: ");
    EasyTracker.getInstance().activityStop(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/ThemeStoreActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */