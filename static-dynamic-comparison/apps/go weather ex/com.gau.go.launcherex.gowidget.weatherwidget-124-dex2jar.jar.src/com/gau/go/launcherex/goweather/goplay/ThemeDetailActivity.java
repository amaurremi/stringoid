package com.gau.go.launcherex.goweather.goplay;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.weather.globalview.b;
import com.gau.go.launcherex.gowidget.weather.view.ThemeSettingActivity;
import com.jiubang.playsdk.d.c;
import com.jiubang.playsdk.views.ad;
import java.util.ArrayList;
import java.util.Iterator;

public class ThemeDetailActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, com.jiubang.playsdk.main.u, ad
{
  private com.go.weatherex.themestore.detail.e a;
  private Object b;
  private h c;
  private ThemeDetailActivity.PackageChangeReceiver d;
  private int e = 1;
  private int f = 40;
  private final i g = new i();
  private String h;
  
  public static Intent a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    paramContext = new Intent(paramContext, ThemeDetailActivity.class);
    paramContext.putExtra("extra_src_app_package_name", paramString);
    paramContext.putExtra("extra_key_from", paramInt1);
    paramContext.putExtra("extra_key_type", paramInt2);
    return paramContext;
  }
  
  private String a(com.jiubang.playsdk.a.a parama)
  {
    if (parama != null) {
      return parama.a();
    }
    return "";
  }
  
  private ArrayList a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.h(paramString, this))
    {
      this.f = 40;
      i = 1;
    }
    for (;;)
    {
      if (-1 != i)
      {
        paramString = com.go.weatherex.themestore.u.f().a(this, i);
        if (paramString != null) {
          localArrayList.addAll(paramString);
        }
      }
      return localArrayList;
      if (com.gau.go.launcherex.gowidget.weather.globaltheme.a.i(paramString, this))
      {
        this.f = 39;
        i = 2;
      }
      else if ((com.gau.go.launcherex.gowidget.weather.globaltheme.a.f(paramString, this)) || (com.gau.go.launcherex.gowidget.weather.globaltheme.a.g(paramString, this)))
      {
        this.f = 41;
        i = 3;
      }
      else
      {
        i = -1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = ThemeSettingActivity.a(this, 33, 999, paramInt);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    finish();
  }
  
  private void f()
  {
    b localb = new b(this, com.gau.go.launcherex.gowidget.weather.globalview.e.b);
    localb.b(2131166447);
    localb.c(2131166449);
    localb.a(new g(this));
    localb.b();
  }
  
  private void g()
  {
    com.gau.go.launcherex.gowidget.weather.globaltheme.a.e(this, a((com.jiubang.playsdk.a.a)this.b));
  }
  
  private void h()
  {
    if (this.e == 2)
    {
      Intent localIntent = ThemeSettingActivity.a(this, 33, 999, this.f);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
  }
  
  public void a()
  {
    h();
    finish();
  }
  
  public Context b()
  {
    return this;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("operation", 2) == 1)) {
      this.a.b();
    }
  }
  
  public void onBackPressed()
  {
    h();
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == c.f) && ((this.b instanceof com.jiubang.playsdk.a.a))) {
      com.go.weatherex.themestore.u.f().h(b(), (com.jiubang.playsdk.a.a)this.b);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.go.weatherex.themestore.u.a(getApplicationContext());
    this.g.a(this);
    com.go.weatherex.themestore.u.f().a(this.g);
    paramBundle = getIntent();
    this.h = paramBundle.getStringExtra("cityId");
    this.e = paramBundle.getIntExtra("extra_key_from", 1);
    int i = paramBundle.getIntExtra("extra_key_type", 1);
    Object localObject;
    com.jiubang.playsdk.a.a locala;
    if (this.e == 2)
    {
      paramBundle = paramBundle.getStringExtra("extra_src_app_package_name");
      localObject = a(paramBundle).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        locala = (com.jiubang.playsdk.a.a)((Iterator)localObject).next();
      } while (!locala.a().equals(paramBundle));
    }
    for (this.b = locala; this.b == null; this.b = getIntent().getSerializableExtra("extra_key_bean"))
    {
      finish();
      return;
    }
    if ((this.b instanceof com.jiubang.playsdk.a.a))
    {
      if (ThemeDataHandler.a(getApplicationContext()).a((com.jiubang.playsdk.a.a)this.b) == null) {
        a(((com.jiubang.playsdk.a.a)this.b).a());
      }
      if (ThemeDataHandler.a(getApplicationContext()).a((com.jiubang.playsdk.a.a)this.b) == null)
      {
        finish();
        return;
      }
    }
    if (i == 2)
    {
      localObject = new int[1];
      localObject[0] = c.f;
      paramBundle = new int[1];
      paramBundle[0] = c.a;
    }
    for (;;)
    {
      this.a = new com.go.weatherex.themestore.detail.e(this, this.b, com.go.weatherex.themestore.u.f());
      this.a.a(this, this, this);
      setContentView(this.a.a(paramBundle, (int[])localObject));
      getWindow().clearFlags(134217728);
      this.c = new h(this, null);
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_SCROLL_CHANGE");
      registerReceiver(this.c, paramBundle);
      this.d = new ThemeDetailActivity.PackageChangeReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.PACKAGE_REMOVED");
      paramBundle.addDataScheme("package");
      registerReceiver(this.d, paramBundle);
      return;
      paramBundle = null;
      localObject = null;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.c != null) {
      unregisterReceiver(this.c);
    }
    if (this.d != null) {
      unregisterReceiver(this.d);
    }
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
    }
    com.go.weatherex.themestore.u.f().b(this.g);
    this.g.c();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramView.getId() == c.a) && ((this.b instanceof com.jiubang.playsdk.a.a)))
    {
      paramAdapterView = (com.jiubang.playsdk.a.a)this.b;
      if (!com.go.weatherex.themestore.u.f().d(this, paramAdapterView)) {
        g();
      }
    }
    else
    {
      return;
    }
    f();
  }
  
  protected void onStart()
  {
    super.onStart();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/ThemeDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */