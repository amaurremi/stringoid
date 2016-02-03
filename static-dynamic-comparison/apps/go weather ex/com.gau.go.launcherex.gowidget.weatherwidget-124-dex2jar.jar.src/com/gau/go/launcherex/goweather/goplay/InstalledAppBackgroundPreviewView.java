package com.gau.go.launcherex.goweather.goplay;

import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.dynamicbackground.DynamicBackgroundView;
import com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview.DynamicBgPreviewView;
import com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview.DynamicbgDescriptionView;
import com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview.a;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.scroller.WeatherDetailScrollGroup;
import com.gau.go.launcherex.gowidget.weather.scroller.l;
import com.gau.go.launcherex.gowidget.weather.view.al;
import com.go.weatherex.themestore.detail.IndicatorView;

public class InstalledAppBackgroundPreviewView
  implements l
{
  private Context a;
  private InstalledAppBackgroundPreviewView.DynamicBackgroundActionReceiver b;
  private e c;
  private View d;
  private DynamicBgPreviewView e;
  private WeatherDetailScrollGroup f;
  private IndicatorView g;
  private com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview.d h;
  private FrameLayout i;
  private TextView j;
  private Dialog k;
  private a l;
  private DynamicBackgroundView m;
  private int n = 0;
  private ImageView o;
  private final Runnable p = new c(this);
  private final Runnable q = new d(this);
  
  public InstalledAppBackgroundPreviewView(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.l = new a(this.a);
      this.l.c(paramString);
      this.h.a(this.l);
      return;
    }
    e();
    this.h.a(-1);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.o.setVisibility(0);
      this.g.setVisibility(4);
      this.m.setVisibility(8);
      this.j.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    this.o.setVisibility(8);
    this.g.setVisibility(0);
    this.m.setVisibility(0);
    this.j.setVisibility(0);
    this.e.setVisibility(0);
  }
  
  private void b()
  {
    if (this.c == null) {
      return;
    }
    d();
    this.i.post(this.p);
  }
  
  private void c()
  {
    if (this.c == null) {
      return;
    }
    this.i.post(this.q);
  }
  
  private void d()
  {
    this.k = al.a(this.a);
    this.k.show();
  }
  
  private void e()
  {
    if ((this.k != null) && (this.k.isShowing()))
    {
      this.k.dismiss();
      this.k = null;
    }
  }
  
  public View a(Context paramContext, e parame)
  {
    this.a = paramContext;
    this.c = parame;
    if (this.d == null)
    {
      this.d = LayoutInflater.from(this.a).inflate(2130903222, null);
      this.g = ((IndicatorView)this.d.findViewById(2131231693));
      int i1 = this.a.getResources().getDimensionPixelSize(2131427362);
      this.g.a(i1);
      this.i = ((FrameLayout)this.d.findViewById(2131231689));
      this.m = ((DynamicBackgroundView)this.d.findViewById(2131231690));
      this.h = new com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview.d(this.a);
      this.h.a(this.m);
      this.j = ((TextView)this.d.findViewById(2131231300));
      this.e = ((DynamicBgPreviewView)this.d.findViewById(2131231691));
      this.o = ((ImageView)this.d.findViewById(2131231692));
      this.o.setClickable(true);
      this.f = this.e.a();
      this.f.a(this);
      this.f.a(true);
    }
    this.n = 0;
    this.f.a(this.n);
    if (this.c != null)
    {
      if (!com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(this.c.x())) {
        break label262;
      }
      a(true);
      c();
    }
    for (;;)
    {
      return this.d;
      label262:
      if (this.b == null)
      {
        paramContext = new IntentFilter();
        paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SCREEN_BACKGROUND_PREVIEW_DONE");
        paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_DONE");
        paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_ALL_SCRIPT_DONE");
        paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_THEME_PURCHASE_SUCCESS");
        this.b = new InstalledAppBackgroundPreviewView.DynamicBackgroundActionReceiver(this);
        this.a.registerReceiver(this.b, paramContext);
      }
      a(false);
      b();
    }
  }
  
  protected void a()
  {
    if (this.i != null)
    {
      this.i.removeCallbacks(this.p);
      this.i.removeCallbacks(this.q);
      this.i = null;
    }
    if (this.h != null)
    {
      this.h.a();
      this.h = null;
    }
    if (this.l != null)
    {
      this.l.b();
      this.l = null;
    }
    if (this.d != null) {
      this.d = null;
    }
    if (this.b != null) {
      this.a.unregisterReceiver(this.b);
    }
  }
  
  public void a(WeatherDetailScrollGroup paramWeatherDetailScrollGroup, int paramInt) {}
  
  public void b(WeatherDetailScrollGroup paramWeatherDetailScrollGroup, int paramInt)
  {
    if (this.n == paramInt) {
      return;
    }
    paramWeatherDetailScrollGroup.setTag(Boolean.valueOf(true));
    this.n = paramInt;
    this.g.c(this.n);
    this.e.a(this.n);
  }
  
  public void c(WeatherDetailScrollGroup paramWeatherDetailScrollGroup, int paramInt)
  {
    Object localObject = paramWeatherDetailScrollGroup.getTag();
    if (localObject == null) {}
    while (!((Boolean)localObject).booleanValue()) {
      return;
    }
    localObject = (DynamicbgDescriptionView)paramWeatherDetailScrollGroup.getChildAt(paramInt);
    if (localObject != null)
    {
      this.j.setText(((DynamicbgDescriptionView)localObject).c());
      this.h.a(((DynamicbgDescriptionView)localObject).a(), ((DynamicbgDescriptionView)localObject).b(), true);
    }
    paramWeatherDetailScrollGroup.setTag(Boolean.valueOf(false));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/InstalledAppBackgroundPreviewView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */