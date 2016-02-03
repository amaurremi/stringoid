package com.gau.go.launcherex.gowidget.weather.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.gau.go.launcherex.goweather.goplay.ThemeDetailActivity;
import com.gau.go.launcherex.gowidget.statistics.a.a;
import com.gau.go.launcherex.gowidget.statistics.r;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.go.weatherex.framework.b;
import com.go.weatherex.framework.fragment.BaseFragmentActivity;
import com.go.weatherex.framework.fragment.g;
import com.go.weatherex.home.l;
import com.go.weatherex.home.m;
import com.go.weatherex.home.q;
import com.go.weatherex.home.s;
import com.go.weatherex.home.x;
import com.go.weatherex.home.z;
import com.google.analytics.tracking.android.EasyTracker;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

public class WeatherDetailActivity
  extends BaseFragmentActivity
{
  private l a;
  private final bu b = new bu();
  private m c;
  private z d;
  private s e;
  private q f;
  private x g;
  private boolean h = false;
  
  public static Intent a(Context paramContext, String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, WeatherDetailActivity.class);
    localIntent.putExtra("cityId", paramString1);
    localIntent.putExtra("EXTRA_BG_LOADING_IMMEDIATELY_", paramBoolean);
    localIntent.putExtra("detailSrc", paramInt1);
    localIntent.putExtra("extra_src_app_package_name", paramString2);
    localIntent.putExtra("detail_goto", paramInt2);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    return localIntent;
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {}
    label122:
    for (;;)
    {
      return;
      InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        String[] arrayOfString = new String[3];
        arrayOfString[0] = "mCurRootView";
        arrayOfString[1] = "mServedView";
        arrayOfString[2] = "mNextServedView";
        int i = 0;
        for (;;)
        {
          if (i >= arrayOfString.length) {
            break label122;
          }
          Object localObject1 = arrayOfString[i];
          try
          {
            localObject1 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
            if (!((Field)localObject1).isAccessible()) {
              ((Field)localObject1).setAccessible(true);
            }
            Object localObject2 = ((Field)localObject1).get(localInputMethodManager);
            if ((localObject2 != null) && ((localObject2 instanceof View)))
            {
              if (((View)localObject2).getContext() != paramContext) {
                break;
              }
              ((Field)localObject1).set(localInputMethodManager, null);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localThrowable.printStackTrace();
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void g()
  {
    if ((this.h) || (isFinishing())) {
      return;
    }
    if (TextUtils.isEmpty(this.b.a))
    {
      f localf = f.a(getApplicationContext());
      if (!localf.c().isEmpty()) {
        this.b.a = ((WeatherBean)localf.d().get(0)).c();
      }
    }
    this.a.a(this.b);
    h();
  }
  
  private void h()
  {
    String str1 = "go_in_detail";
    Object localObject = str1;
    switch (this.b.c)
    {
    default: 
      localObject = str1;
    }
    for (;;)
    {
      y.a((String)localObject, this);
      localObject = new a(93, "g001");
      ((a)localObject).c(r.a(this.b.c));
      r.a(getApplicationContext()).a((a)localObject);
      return;
      localObject = "enter_to_detail";
      continue;
      localObject = "widget42_to_detail";
      continue;
      localObject = "widget41_to_detail";
      continue;
      localObject = "widget21_to_detail";
      continue;
      localObject = "widget11_to_detail";
      continue;
      localObject = "appwidget42_to_detail";
      continue;
      localObject = "appwidget41_to_detail";
      continue;
      localObject = "appwidget21_to_detail";
      continue;
      localObject = "notification_to_detail";
      continue;
      str1 = "skin_to_detail";
      String str2 = this.b.d;
      localObject = str1;
      if (!TextUtils.isEmpty(str2))
      {
        localObject = str1;
        if (!"--".equals(str2))
        {
          localObject = ThemeDetailActivity.a(this, 2, 2, str2);
          ((Intent)localObject).addFlags(67108864);
          startActivity((Intent)localObject);
          localObject = str1;
          continue;
          localObject = "language_to_detail";
          continue;
          localObject = "camera_to_detail";
        }
      }
    }
  }
  
  private void i()
  {
    com.gtp.a.a.b.c.a("WeatherDetailActivity", "restartActivity");
    finish();
    startActivity(a(this, this.b.a, this.b.b, this.b.c, this.b.d, this.b.e));
  }
  
  protected g b()
  {
    this.a = new l(this);
    return this.a;
  }
  
  protected b c()
  {
    return new com.go.weatherex.framework.c(this);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.c.a(this, paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if ((this.a != null) && (this.a.b())) {}
    for (;;)
    {
      return;
      if (getSupportFragmentManager().getBackStackEntryCount() == 0) {}
      for (int i = 1; (i == 0) || (this.c == null) || (!this.c.f(this)); i = 0)
      {
        super.onBackPressed();
        return;
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    com.gtp.a.a.b.c.a("WeatherDetailActivity", "onCreate: " + paramBundle);
    if (paramBundle != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.h = bool;
      super.onCreate(null);
      this.b.a(getIntent());
      if (!this.h) {
        break;
      }
      i();
      return;
    }
    setContentView(2130903216);
    getWindow().setFormat(-3);
    getWindow().clearFlags(134217728);
    this.c = new m();
    this.c.a(this, null);
    this.d = new z();
    this.d.a(this, null);
    this.e = new s();
    this.e.a(this, null);
    this.f = new q();
    this.f.a(this, null);
    this.g = new x();
    this.g.a(this, null);
    paramBundle = com.gau.go.launcherex.gowidget.weather.c.c.a(getApplicationContext());
    if (paramBundle.b())
    {
      g();
      return;
    }
    paramBundle.a(new bt(this, paramBundle));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.gtp.a.a.b.c.a("WeatherDetailActivity", "onDestroy: ");
    if (this.c != null) {
      this.c.e(this);
    }
    if (this.e != null) {
      this.e.a(this);
    }
    a(this);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.b.a(paramIntent);
    if (!com.gau.go.launcherex.gowidget.weather.c.c.a(getApplicationContext()).b()) {
      return;
    }
    switch (this.b.e)
    {
    case 6: 
    default: 
      if (this.c != null) {
        this.c.a(this, paramIntent);
      }
      if (this.a != null) {
        this.a.b(this.b);
      }
      if (this.f != null) {
        this.f.a(this, paramIntent);
      }
      h();
      return;
    }
    i();
  }
  
  protected void onPause()
  {
    super.onPause();
    com.gtp.a.a.b.c.a("WeatherDetailActivity", "onPause: ");
    if (this.c != null) {
      this.c.c(this);
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    com.gtp.a.a.b.c.a("WeatherDetailActivity", "onRestart: ");
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    com.gtp.a.a.b.c.a("WeatherDetailActivity", "onRestoreInstanceState: " + paramBundle);
  }
  
  protected void onResume()
  {
    super.onResume();
    com.gtp.a.a.b.c.a("WeatherDetailActivity", "onResume: ");
    if (this.c != null) {
      this.c.b(this);
    }
  }
  
  protected void onResumeFragments()
  {
    super.onResumeFragments();
    com.gtp.a.a.b.c.a("WeatherDetailActivity", "onResumeFragments: ");
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    com.gtp.a.a.b.c.a("WeatherDetailActivity", "onSaveInstanceState: ");
    this.h = true;
  }
  
  protected void onStart()
  {
    super.onStart();
    com.gtp.a.a.b.c.a("WeatherDetailActivity", "onStart: ");
    EasyTracker.getInstance().activityStart(this);
    if (this.c != null) {
      this.c.a(this);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    com.gtp.a.a.b.c.a("WeatherDetailActivity", "onStop: ");
    EasyTracker.getInstance().activityStop(this);
    if (this.c != null) {
      this.c.d(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/WeatherDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */