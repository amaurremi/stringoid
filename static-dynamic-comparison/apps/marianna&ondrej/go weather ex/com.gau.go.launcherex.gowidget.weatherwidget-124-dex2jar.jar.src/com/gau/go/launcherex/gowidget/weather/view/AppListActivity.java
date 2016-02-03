package com.gau.go.launcherex.gowidget.weather.view;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.weather.globalview.b;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.go.weatherex.setting.bm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppListActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener
{
  private ListView a;
  private n b;
  private List c;
  private View d;
  private q e;
  private int f;
  private TextView g;
  private View h;
  private String i = "";
  
  private void a()
  {
    Object localObject1 = new Intent("android.intent.action.MAIN", null);
    ((Intent)localObject1).addCategory("android.intent.category.LAUNCHER");
    try
    {
      localObject1 = getPackageManager().queryIntentActivities((Intent)localObject1, 32);
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject1).next();
          if ((!getPackageName().equals(localResolveInfo.activityInfo.packageName)) && (localResolveInfo.activityInfo.exported == true)) {
            this.c.add(localResolveInfo);
          }
        }
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        localRuntimeException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  private void a(int paramInt)
  {
    String str = "";
    if (this.f == 1) {
      str = getString(2131166302);
    }
    for (;;)
    {
      b localb = new b(this);
      localb.b(str);
      localb.a(((ResolveInfo)this.c.get(paramInt)).activityInfo.loadLabel(getPackageManager()).toString());
      localb.d(2131165344);
      localb.a(new m(this, paramInt));
      localb.b();
      return;
      if (this.f == 2) {
        str = getString(2131166301);
      }
    }
  }
  
  private void a(int paramInt1, Object paramObject, int paramInt2)
  {
    Object localObject = (ResolveInfo)paramObject;
    if (paramInt2 > 0)
    {
      paramObject = ((ResolveInfo)localObject).activityInfo.packageName + "#" + ((ResolveInfo)localObject).activityInfo.name;
      localObject = ((ResolveInfo)localObject).activityInfo.loadLabel(getPackageManager()).toString();
      switch (this.f)
      {
      }
      for (;;)
      {
        setResult(-1, new Intent());
        finish();
        overridePendingTransition(2130968606, 2130968585);
        return;
        Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.action_calendar_binding_app");
        localIntent.putExtra("extra_calendar_binding_app", (String)paramObject);
        localIntent.putExtra("app_name", (String)localObject);
        localIntent.putExtra("app_package_name", (String)paramObject);
        getApplicationContext().sendBroadcast(localIntent);
        continue;
        localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.action_clock_binding_app");
        localIntent.putExtra("extra_clock_binding_app", (String)paramObject);
        localIntent.putExtra("app_name", (String)localObject);
        localIntent.putExtra("app_package_name", (String)paramObject);
        getApplicationContext().sendBroadcast(localIntent);
      }
    }
    Toast.makeText(this, getString(2131166303), 0).show();
  }
  
  private void a(ResolveInfo paramResolveInfo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("setting_value", paramResolveInfo.activityInfo.packageName + "#" + paramResolveInfo.activityInfo.name);
    this.e.a(2, paramResolveInfo, WeatherContentProvider.g, localContentValues, "setting_key='widgt_clock'", null);
  }
  
  private void b(ResolveInfo paramResolveInfo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("setting_value", paramResolveInfo.activityInfo.packageName + "#" + paramResolveInfo.activityInfo.name);
    this.e.a(1, paramResolveInfo, WeatherContentProvider.g, localContentValues, "setting_key='widgt_calendar'", null);
  }
  
  protected void c() {}
  
  protected void d() {}
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.h)) {
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903062);
    getWindow().clearFlags(134217728);
    this.f = getIntent().getIntExtra("calendar_clock_binding_app", 0);
    this.i = getIntent().getStringExtra("app_widget");
    if (this.i == null) {
      this.i = "";
    }
    if (this.f == 0) {
      finish();
    }
    this.g = ((TextView)findViewById(2131230934));
    if (this.f == 1) {
      this.g.setText(getString(2131166280));
    }
    for (;;)
    {
      this.h = findViewById(2131230796);
      this.h.setOnClickListener(this);
      this.e = new q(getContentResolver(), this);
      this.d = findViewById(2131230936);
      this.d.setVisibility(0);
      this.a = ((ListView)findViewById(2131230935));
      this.c = new ArrayList();
      new Handler().postDelayed(new l(this), 100L);
      return;
      if (this.f == 2) {
        this.g.setText(getString(2131166279));
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.c != null) && (!this.c.isEmpty()))
    {
      this.c.clear();
      this.c = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      setResult(-1, new Intent(this, bm.class));
      finish();
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AppListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */