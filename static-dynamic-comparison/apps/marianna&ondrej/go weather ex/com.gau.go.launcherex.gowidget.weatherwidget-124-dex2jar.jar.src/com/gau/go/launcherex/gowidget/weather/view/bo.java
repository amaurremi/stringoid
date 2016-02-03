package com.gau.go.launcherex.gowidget.weather.view;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.f.f;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.util.p;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.GoWidgetDynamicIconView;
import com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a.b;
import com.jiubang.core.a.l;
import java.util.HashMap;

public class bo
  extends dg
  implements View.OnClickListener, View.OnLongClickListener, b
{
  boolean a = true;
  private WeatherBean d = null;
  private GoWidgetDynamicIconView e = null;
  private FrameLayout f;
  private ImageView g = null;
  private ProgressBar h = null;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private View o;
  private WeatherWidget41Style2 p;
  private com.gau.go.launcherex.gowidget.weather.f.a q = null;
  private String[] r = null;
  private WidgetThemeSwitcher s;
  private ImageView t = null;
  
  public bo(Context paramContext)
  {
    super(paramContext, dh.a);
    a(paramContext);
    l();
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.i.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.j.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.m.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.l.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.n.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.k.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
  }
  
  private void a(Context paramContext)
  {
    this.q = new com.gau.go.launcherex.gowidget.weather.f.a();
    this.q.a = paramContext.getPackageName();
    this.q.b = paramContext.getResources();
    this.q.c = new String[] { "go_widget_41_style2_na", "go_widget_41_style2_sunny_day", "go_widget_41_style2_sunny_night", "go_widget_41_style2_cloudy_day", "go_widget_41_style2_cloudy_night", "go_widget_41_style2_overcast", "go_widget_41_style2_snowy", "go_widget_41_style2_foggy", "go_widget_41_style2_rainy", "go_widget_41_style2_thunderstrom" };
    paramContext = new HashMap();
    paramContext.put("gw_weather_41_bg", "");
    paramContext.put("gw_weather_41_txt_selector", "go_widget_41_style2_text_selector");
    paramContext.put("gw_weather_41_txt_shadow_color", "#66FFFFFF");
    paramContext.put("gw_weather_41_txt_shadow_dx", "0");
    paramContext.put("gw_weather_41_txt_shadow_dy", "1");
    paramContext.put("gw_weather_41_txt_shadow_radius", "1");
    paramContext.put("gw_weather_41_refresh_selector", "go_widget_41_style2_refresh_selector");
    paramContext.put("refresh_progress_41", "go_widget_41_style2_refresh_progress");
    this.q.a(paramContext);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    this.i.setTextColor(paramColorStateList);
    this.j.setTextColor(paramColorStateList);
    this.m.setTextColor(paramColorStateList);
    this.l.setTextColor(paramColorStateList);
    this.n.setTextColor(paramColorStateList);
    this.k.setTextColor(paramColorStateList);
  }
  
  private void a(Time paramTime, boolean paramBoolean)
  {
    int i1 = paramTime.hour;
    if (paramBoolean)
    {
      this.m.setVisibility(4);
      return;
    }
    this.m.setVisibility(0);
    if ((i1 >= 0) && (i1 < 12))
    {
      this.m.setText("AM");
      return;
    }
    this.m.setText("PM");
  }
  
  private void a(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = t();
    boolean bool = s();
    if (this.d != null) {}
    for (int i1 = this.d.k.d();; i1 = 1)
    {
      if ((parama != null) && (paramBoolean1) && (paramBoolean2) && (paramBoolean3))
      {
        localObject = parama.a(i1, bool, true);
        if (localObject == null) {
          parama.a(i1, bool, true, this);
        }
      }
      do
      {
        do
        {
          return;
          this.e.a((l)localObject, true);
          return;
        } while (localObject == null);
        parama = f.a((Drawable)localObject);
      } while (parama == null);
      this.e.a(parama, paramBoolean3);
      return;
    }
  }
  
  private void b(Time paramTime, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = paramTime.hour;
    int i1 = i2;
    if (!paramBoolean)
    {
      i2 %= 12;
      i1 = i2;
      if (i2 == 0) {
        i1 = 12;
      }
    }
    if (i1 < 10) {
      localStringBuilder.append(0);
    }
    localStringBuilder.append(i1);
    localStringBuilder.append(":");
    i1 = paramTime.minute;
    if (i1 < 10) {
      localStringBuilder.append(0);
    }
    localStringBuilder.append(i1);
    this.l.setText(localStringBuilder.toString());
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = t();
    if (localObject != null)
    {
      localObject = f.a((Drawable)localObject);
      if (localObject != null) {
        this.e.a((Bitmap)localObject, paramBoolean);
      }
    }
  }
  
  private void l()
  {
    this.e = ((GoWidgetDynamicIconView)findViewById(2131231987));
    this.f = ((FrameLayout)findViewById(2131232001));
    this.g = ((ImageView)findViewById(2131232029));
    this.h = ((ProgressBar)findViewById(2131232030));
    this.i = ((TextView)findViewById(2131231995));
    this.j = ((TextView)findViewById(2131232027));
    this.k = ((TextView)findViewById(2131232028));
    this.l = ((TextView)findViewById(2131232024));
    Typeface localTypeface = Typeface.createFromAsset(this.b.getAssets(), "fonts/Roboto-Light.ttf");
    this.l.setTypeface(localTypeface);
    this.m = ((TextView)findViewById(2131232025));
    this.n = ((TextView)findViewById(2131232026));
    this.s = ((WidgetThemeSwitcher)findViewById(2131231998));
    this.s.a(true);
    this.t = ((ImageView)findViewById(2131232000));
    this.o = findViewById(2131231694);
    b(false);
    m();
  }
  
  private void m()
  {
    setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.g.setOnLongClickListener(this);
    this.i.setOnLongClickListener(this);
    this.j.setOnLongClickListener(this);
    this.k.setOnLongClickListener(this);
    this.m.setOnLongClickListener(this);
    this.n.setOnLongClickListener(this);
    this.l.setOnLongClickListener(this);
    this.e.setOnLongClickListener(this);
    this.s.setOnLongClickListener(this);
    this.t.setOnLongClickListener(this);
  }
  
  private void o()
  {
    Object localObject = "";
    if (this.d != null) {
      localObject = this.d.c();
    }
    for (int i1 = this.d.e();; i1 = -1)
    {
      localObject = p.a(this.b, (String)localObject, true, 5, "", -1);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("gowidget_Id", this.p.getWidgetId());
      ((Intent)localObject).putExtra("isMyLocation", i1);
      try
      {
        getContext().startActivity((Intent)localObject);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        localActivityNotFoundException.printStackTrace();
        return;
      }
    }
  }
  
  private void p()
  {
    String str;
    if (this.d == null) {
      if (this.p.isLocatingCity()) {
        str = this.b.getString(2131166458);
      }
    }
    for (;;)
    {
      this.i.setText(str);
      return;
      if (this.p.isLoadingDatas())
      {
        str = this.b.getString(2131166457);
      }
      else
      {
        str = this.b.getString(2131166455);
        continue;
        str = this.d.d();
      }
    }
  }
  
  private void q()
  {
    String str;
    if (this.p.isLoadingDatas()) {
      str = "--";
    }
    for (;;)
    {
      this.k.setText(str);
      return;
      if (this.d == null) {
        str = this.b.getString(2131165323);
      } else {
        str = this.d.k.e();
      }
    }
  }
  
  private Time r()
  {
    g localg = this.p.getTimeManager();
    boolean bool1 = this.p.c.h;
    boolean bool2 = this.p.b;
    if ((this.d != null) && (bool2) && (bool1)) {
      return localg.b(this.d.k.n());
    }
    return localg.c();
  }
  
  private boolean s()
  {
    if (this.d == null) {
      return true;
    }
    g localg = this.p.getTimeManager();
    String str1 = this.d.k.j();
    String str2 = this.d.k.k();
    if (localg.d()) {
      return r.a(str1, str2, localg.b(this.d.k.n()));
    }
    return r.a(str1, str2);
  }
  
  private Drawable t()
  {
    String str2 = this.q.c[0];
    boolean bool = s();
    String str1 = str2;
    if (this.d != null) {
      switch (this.d.k.d())
      {
      default: 
        str1 = str2;
      }
    }
    for (;;)
    {
      return com.gau.go.launcherex.gowidget.weather.f.c.a(this.q.b, str1, this.q.a);
      if (bool)
      {
        str1 = this.q.c[1];
      }
      else
      {
        str1 = this.q.c[2];
        continue;
        if (bool)
        {
          str1 = this.q.c[3];
        }
        else
        {
          str1 = this.q.c[4];
          continue;
          str1 = this.q.c[5];
          continue;
          str1 = this.q.c[6];
          continue;
          str1 = this.q.c[7];
          continue;
          str1 = this.q.c[8];
          continue;
          str1 = this.q.c[9];
        }
      }
    }
  }
  
  public int a()
  {
    return 2130903335;
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.f.a parama)
  {
    float f3 = 1.0F;
    this.q = parama;
    Object localObject = this.q.c[0];
    localObject = com.gau.go.launcherex.gowidget.weather.f.c.a(this.q.b, (String)localObject, this.q.a);
    if (localObject != null)
    {
      localObject = f.a((Drawable)localObject);
      if (localObject != null) {
        this.e.a((Bitmap)localObject, false);
      }
    }
    localObject = com.gau.go.launcherex.gowidget.weather.f.c.b(this.q.b, parama.a("gw_weather_41_txt_selector"), this.q.a);
    if (localObject != null)
    {
      a((ColorStateList)localObject);
      this.o.setBackgroundColor(((ColorStateList)localObject).getDefaultColor());
    }
    try
    {
      int i1 = com.gau.go.launcherex.gowidget.weather.f.c.a(this.q.a("gw_weather_41_txt_shadow_color"), 16777215);
      String str = this.q.a("gw_weather_41_txt_shadow_dx");
      if (!TextUtils.isEmpty(str))
      {
        f1 = Float.parseFloat(str);
        str = this.q.a("gw_weather_41_txt_shadow_dy");
        if (!TextUtils.isEmpty(str))
        {
          f2 = Float.parseFloat(str);
          str = this.q.a("gw_weather_41_txt_shadow_radius");
          if (!TextUtils.isEmpty(str)) {
            f3 = Float.parseFloat(str);
          }
          a(i1, f1, f2, f3);
          if (localObject != null)
          {
            if ((((ColorStateList)localObject).getDefaultColor() & 0xFFFFFF) < 8388607) {
              this.s.a(false);
            }
          }
          else
          {
            localObject = this.q.a("gw_weather_41_theme_setting_selector");
            localObject = com.gau.go.launcherex.gowidget.weather.f.c.a(this.q.b, (String)localObject, this.q.a);
            if (localObject == null) {
              break label504;
            }
            this.t.setVisibility(0);
            this.t.setImageDrawable((Drawable)localObject);
            i1 = this.g.getVisibility();
            this.g.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.q.b, parama.a("gw_weather_41_refresh_selector"), this.q.a));
            this.g.setVisibility(i1);
            i1 = this.h.getVisibility();
            this.f.removeView(this.h);
            this.h = new ProgressBar(this.b);
            parama = parama.a("refresh_progress_41");
            parama = com.gau.go.launcherex.gowidget.weather.f.c.a(this.q.b, parama, this.q.a);
            f1 = this.b.getResources().getDisplayMetrics().density;
            this.h.setLayoutParams(new FrameLayout.LayoutParams((int)(18.0F * f1), (int)(f1 * 18.0F)));
            this.h.setIndeterminateDrawable(parama);
            this.h.setVisibility(i1);
            this.f.addView(this.h);
            f();
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        this.s.a(true);
        continue;
        label504:
        this.t.setVisibility(4);
        continue;
        float f2 = 1.0F;
        continue;
        float f1 = 0.0F;
      }
    }
  }
  
  public void a(WeatherBean paramWeatherBean)
  {
    this.d = paramWeatherBean;
  }
  
  public void a(WeatherWidget41Style2 paramWeatherWidget41Style2)
  {
    this.p = paramWeatherWidget41Style2;
  }
  
  public void a(b paramb, l paraml, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paraml != null)
    {
      if (this.d != null) {
        if (this.d.k.d() == paramInt) {
          this.e.a(paraml, paramBoolean2);
        }
      }
      while (paramInt != 1) {
        return;
      }
      this.e.a(paraml, paramBoolean2);
      return;
    }
    c(paramBoolean2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.s.setVisibility(0);
      return;
    }
    this.s.setVisibility(8);
  }
  
  public void b()
  {
    this.s.a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.g.setVisibility(4);
      this.h.setVisibility(0);
      return;
    }
    this.g.setVisibility(0);
    this.h.setVisibility(4);
  }
  
  public WeatherBean c()
  {
    return this.d;
  }
  
  public String d()
  {
    if (this.d != null) {
      return this.d.c();
    }
    return null;
  }
  
  public boolean e()
  {
    return TextUtils.isEmpty(d());
  }
  
  public void f()
  {
    p();
    i();
    q();
    h();
    j();
    g();
  }
  
  public void g()
  {
    g localg = this.p.getTimeManager();
    Time localTime = r();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.r[localTime.weekDay].replace(".", ""));
    localStringBuffer.append(" , ");
    localStringBuffer.append(localg.a(localTime));
    this.n.setText(localStringBuffer.toString());
  }
  
  public void h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    WidgetSettingBean localWidgetSettingBean = this.p.c;
    if (this.p.isLoadingDatas())
    {
      localStringBuilder.append("--");
      if (localWidgetSettingBean.a != 1) {
        break label126;
      }
      localStringBuilder.append("°C");
    }
    for (;;)
    {
      this.j.setText(localStringBuilder.toString());
      return;
      if (this.d == null)
      {
        localStringBuilder.append("--");
        break;
      }
      float f1 = this.d.k.a(localWidgetSettingBean.a);
      if (f1 == -10000.0F)
      {
        localStringBuilder.append("--");
        break;
      }
      localStringBuilder.append(q.a(f1));
      break;
      label126:
      localStringBuilder.append("°F");
    }
  }
  
  public void i()
  {
    a(this.p.getDynamicIconManager(), this.p.b, this.p.c.g, this.a);
  }
  
  public void j()
  {
    Time localTime = r();
    boolean bool = r.b(this.b);
    a(localTime, bool);
    b(localTime, bool);
  }
  
  public void k()
  {
    this.r = com.gau.go.launcherex.gowidget.weather.util.c.h(this.b);
    p();
    g();
  }
  
  public void onClick(View paramView)
  {
    if (this.p.isLoadingDatas()) {}
    do
    {
      return;
      if (paramView.equals(this.g))
      {
        this.p.refreshWeather();
        return;
      }
      if (paramView.equals(this))
      {
        o();
        return;
      }
      if (paramView.equals(this.i))
      {
        o();
        return;
      }
      if (paramView.equals(this.j))
      {
        o();
        return;
      }
      if (paramView.equals(this.k))
      {
        o();
        return;
      }
      if (paramView.equals(this.e))
      {
        o();
        return;
      }
      if (paramView.equals(this.m))
      {
        this.p.gotoCalendar();
        return;
      }
      if (paramView.equals(this.l))
      {
        this.p.gotoClock();
        return;
      }
      if (paramView.equals(this.n))
      {
        this.p.gotoCalendar();
        return;
      }
      if (paramView.equals(this.s))
      {
        this.p.onThemeSwitcherClick();
        return;
      }
    } while (!paramView.equals(this.t));
    this.p.gotoThemeStore();
  }
  
  public boolean onLongClick(View paramView)
  {
    performLongClick();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */