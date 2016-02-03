package com.gau.go.launcherex.gowidget.weather.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.gau.go.launcherex.goweather.goplay.ThemeDataHandler;
import com.gau.go.launcherex.goweather.goplay.f;
import com.gau.go.launcherex.goweather.goplay.l;
import com.gau.go.launcherex.goweather.goplay.n;
import com.gau.go.launcherex.goweather.goplay.q;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.globaltheme.a.d;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.jiubang.core.b.a;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.main.e;
import com.jiubang.playsdk.main.u;
import com.jiubang.playsdk.views.ad;

public class ThemeSettingActivityOld
  extends Activity
  implements View.OnClickListener, AdapterView.OnItemClickListener, f, u, ad
{
  private aa a;
  private c b;
  private q c;
  private e d;
  private boolean e = false;
  private final l f = new l();
  private String g;
  
  private void c()
  {
    if (this.e)
    {
      Intent localIntent = WeatherDetailActivity.a(this, this.g, true, 16, "", -1);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
  }
  
  private boolean d(String paramString)
  {
    SharedPreferences localSharedPreferences = GoWidgetApplication.c(getApplicationContext()).b();
    boolean bool = localSharedPreferences.getBoolean(paramString, false);
    if (bool) {
      localSharedPreferences.edit().putBoolean(paramString, false).commit();
    }
    return bool;
  }
  
  public void a()
  {
    c();
    finish();
  }
  
  public void a(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW_RELOAD_ADDED");
    paramString.addCategory(getPackageName());
    sendBroadcast(paramString);
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW_REFRESH");
    localIntent.addCategory(getPackageName());
    sendBroadcast(localIntent);
  }
  
  public void a_() {}
  
  public Context b()
  {
    return this;
  }
  
  public void b(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW_RELOAD_REMOVED");
    paramString.addCategory(getPackageName());
    sendBroadcast(paramString);
  }
  
  public void c(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW_RELOAD");
    paramString.addCategory(getPackageName());
    sendBroadcast(paramString);
  }
  
  public void onBackPressed()
  {
    c();
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2130838005) && (r.a(paramView, 1200)))
    {
      paramView = new Intent(getApplicationContext(), BillingActivity.class);
      paramView.putExtra("recommend_type", 6);
      startActivity(paramView);
      n.a(this).a();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.d.a(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    int i = -1;
    int k = 39;
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.g = paramBundle.getStringExtra("cityId");
      i = paramBundle.getIntExtra("extra_theme_entrance", -1);
    }
    int j;
    switch (i)
    {
    default: 
      k = 40;
      j = 40;
      this.a = aa.a();
      this.a.a(this);
      this.b = this.a.b();
      if ((this.b != null) && ((this.b instanceof q))) {
        this.c = ((q)this.b);
      }
      break;
    }
    for (;;)
    {
      this.c.a(this.f);
      this.c.a(j);
      this.c.b(k);
      this.c.a(this.g);
      this.d = new e(this);
      setContentView(this.d.a(null, new int[] { 2130838005 }));
      this.d.a(this, this, this);
      getWindow().clearFlags(134217728);
      ThemeDataHandler.a(getApplicationContext()).a(this);
      n.a(this).a(n.a(i));
      return;
      this.e = true;
      if (d("key_systemwidget_isfirst_open_theme"))
      {
        j = 999;
        k = 40;
        break;
      }
      k = 40;
      j = 40;
      break;
      this.e = true;
      if (d("key_gowidget_isfirst_open_theme"))
      {
        j = 999;
        break;
      }
      j = 39;
      break;
      this.e = true;
      d.a(this, false);
      k = 40;
      j = 40;
      break;
      this.e = true;
      d.a(this, false);
      j = 39;
      break;
      this.e = true;
      j = 39;
      break;
      j = paramBundle.getIntExtra("first_level_tab_id", 40);
      k = paramBundle.getIntExtra("second_level_tab_id", 40);
      break;
      this.c = new q();
      this.a.a(this.c);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.d != null)
    {
      this.d.i();
      this.d = null;
    }
    this.c.b(this.f);
    this.f.c();
    if (this.c != this.b)
    {
      this.a.a(this.b);
      this.c = null;
    }
    ThemeDataHandler.a(getApplicationContext()).b(this);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  protected void onStart()
  {
    super.onStart();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/ThemeSettingActivityOld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */