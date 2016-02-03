package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

import android.app.Activity;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.globaltheme.d;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget21Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget41Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidget42Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetDays41Provider;
import com.gau.go.launcherex.gowidget.weather.systemwidget.AppWidgetDays42Provider;
import com.gau.go.launcherex.gowidget.weather.viewframe.viewholder.b;
import com.gtp.a.a.b.c;

public class q
  extends b
{
  private LinearLayout a;
  private AppWidgetManager b;
  private AppWidgetProviderInfo c;
  private AppWidgetHostView d;
  private int g = 0;
  private int h = 1;
  private int i = 72;
  private int j;
  private DisplayMetrics k;
  private d l;
  private e m;
  private e n;
  private Activity o;
  private BroadcastReceiver p = new r(this);
  
  public q(Activity paramActivity, View paramView)
  {
    super(paramActivity, paramView);
    this.o = paramActivity;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    c.a("PreviewWidgetPanel", "width: " + paramInt1 + ", height: " + paramInt2);
    paramInt1 = Math.round(paramInt1 * 1.0F / this.i);
    if (paramInt1 == 4) {
      paramInt1 = -1;
    }
    for (;;)
    {
      Math.round(paramInt2 * 1.0F / this.i);
      paramInt2 = this.j;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, -2);
      localLayoutParams.gravity = 17;
      this.a.addView(paramView, localLayoutParams);
      return;
      paramInt1 *= this.j;
    }
  }
  
  private void a(RemoteViews paramRemoteViews)
  {
    this.d = new AppWidgetHostView(this.o);
    this.d.setAppWidget(this.g, this.c);
    this.a.removeAllViews();
    a(this.d, this.c.minWidth, this.c.minHeight);
    this.d.updateAppWidget(paramRemoteViews);
    this.d.requestLayout();
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_ENABLED_UPDATE_PREVIEW");
    localIntent.putExtra("extra_widget_type", this.h);
    localIntent.putExtra("extra_enabled_widget_update_preview", paramBoolean);
    localIntent.putExtra("extra_app_widget_theme_package", paramString);
    switch (this.h)
    {
    default: 
      return;
    case 1: 
      AppWidget42Provider.a(this.o.getApplicationContext(), 5, localIntent);
      return;
    case 2: 
      AppWidget41Provider.a(this.o.getApplicationContext(), 9, localIntent);
      return;
    case 3: 
      AppWidget21Provider.a(this.o.getApplicationContext(), 3, localIntent);
      return;
    case 4: 
      AppWidgetDays42Provider.a(this.o.getApplicationContext(), 7, localIntent);
      return;
    }
    AppWidgetDays41Provider.a(this.o.getApplicationContext(), 11, localIntent);
  }
  
  private void g() {}
  
  public void a(e parame)
  {
    this.m = parame;
    this.n = parame;
    a(true, this.n.x());
  }
  
  public boolean a()
  {
    this.l = new d(this.o.getApplicationContext());
    this.o.setResult(0);
    Object localObject = this.o.getIntent().getExtras();
    if (localObject != null) {
      this.g = ((Bundle)localObject).getInt("appWidgetId", 0);
    }
    this.b = AppWidgetManager.getInstance(this.o.getApplicationContext());
    this.c = this.b.getAppWidgetInfo(this.g);
    if ((this.g == 0) || (this.c == null))
    {
      this.o.finish();
      this.p = null;
      return false;
    }
    this.a = ((LinearLayout)b(2131231943));
    this.k = this.o.getResources().getDisplayMetrics();
    this.i = ((int)(this.k.density * this.i));
    this.j = (this.k.widthPixels / 4);
    c.a("PreviewWidgetPanel", "AppWidget42Provider.class.getName(): " + AppWidget42Provider.class.getName() + ", mAppWidgetInfo.provider.getClassName(): " + this.c.provider.getClassName());
    if (AppWidget42Provider.class.getName().equals(this.c.provider.getClassName())) {
      this.h = 1;
    }
    for (;;)
    {
      g();
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_APPWIDGET_UPDATE_PREVIEW");
      this.o.registerReceiver(this.p, (IntentFilter)localObject);
      if ((this.h == 1) || (this.h == 4)) {
        this.e.getLayoutParams().height = this.o.getResources().getDimensionPixelSize(2131427516);
      }
      return true;
      if (AppWidget41Provider.class.getName().equals(this.c.provider.getClassName())) {
        this.h = 2;
      } else if (AppWidget21Provider.class.getName().equals(this.c.provider.getClassName())) {
        this.h = 3;
      } else if (AppWidgetDays42Provider.class.getName().equals(this.c.provider.getClassName())) {
        this.h = 4;
      } else if (AppWidgetDays41Provider.class.getName().equals(this.c.provider.getClassName())) {
        this.h = 5;
      }
    }
  }
  
  public int b()
  {
    return this.h;
  }
  
  public void b(e parame)
  {
    if (parame == null) {}
    while ((this.n != null) && (this.n.x() != null) && (this.n.x().equals(parame.x()))) {
      return;
    }
    this.n = parame;
    a(true, this.n.x());
  }
  
  public void c()
  {
    if ((this.n != null) && (!this.n.x().equals(this.m.x()))) {
      this.l.a(0, this.n);
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("appWidgetId", this.g);
    this.o.setResult(-1, localIntent);
    this.o.finish();
  }
  
  public boolean c(e parame)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    boolean bool;
    switch (this.h)
    {
    default: 
      bool = true;
    }
    for (;;)
    {
      if (!bool)
      {
        parame = String.format(this.o.getString(2131166533), new Object[] { localStringBuffer.toString() });
        Toast.makeText(this.o, parame, 0).show();
      }
      return bool;
      bool = parame.j();
      localStringBuffer.append(this.o.getString(2131166507));
      continue;
      bool = parame.k();
      localStringBuffer.append(this.o.getString(2131166508));
    }
  }
  
  public void d()
  {
    a(false, "");
    if (this.p != null) {
      this.o.unregisterReceiver(this.p);
    }
    f();
    this.l.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */