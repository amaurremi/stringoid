package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.Time;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.util.p;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.view.GLWidgetThemeSwitcher;
import com.gau.go.launcherex.gowidget.weather.view.dh;
import com.go.gl.animation.Animation;
import com.go.gl.animation.Translate3DAnimation;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gl.widget.GLImageView;
import com.go.gl.widget.GLTextViewWrapper;
import java.util.HashMap;

public class GLWeather41Style2
  extends GLWidgetChildView
  implements GLView.OnClickListener, GLView.OnLongClickListener
{
  private WeatherBean a = null;
  private Animation b = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
  private Animation c;
  private GLWeatherLouverView d = null;
  private GLImageView e = null;
  private GLProgressBar f = null;
  private GLTextViewWrapper g;
  private GLTextViewWrapper h;
  private GLTextViewWrapper i;
  private GLTextViewWrapper j;
  private GLTextViewWrapper k;
  private GLTextViewWrapper l;
  private GLView m;
  boolean mAnimationWeatherIcon = true;
  private GLWeatherWidget41Style2 n;
  private com.gau.go.launcherex.gowidget.weather.f.a o = null;
  private String[] p = null;
  private GLWidgetThemeSwitcher q;
  private GLImageView r;
  
  public GLWeather41Style2(Context paramContext)
  {
    super(paramContext, dh.a);
    this.b.setDuration(500L);
    this.c = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F, 1, 0.0F);
    this.c.setDuration(500L);
    a(paramContext);
    a();
  }
  
  private void a()
  {
    this.d = ((GLWeatherLouverView)findViewById(2131231987));
    this.e = ((GLImageView)findViewById(2131232029));
    this.f = ((GLProgressBar)findViewById(2131232030));
    this.g = ((GLTextViewWrapper)findViewById(2131231995));
    this.h = ((GLTextViewWrapper)findViewById(2131232027));
    this.i = ((GLTextViewWrapper)findViewById(2131232028));
    this.j = ((GLTextViewWrapper)findViewById(2131232024));
    Typeface localTypeface = Typeface.createFromAsset(this.mContext.getAssets(), "fonts/Roboto-Light.ttf");
    this.j.getTextView().setTypeface(localTypeface);
    this.k = ((GLTextViewWrapper)findViewById(2131232025));
    this.l = ((GLTextViewWrapper)findViewById(2131232026));
    this.q = ((GLWidgetThemeSwitcher)findViewById(2131231998));
    this.q.setColorType(true);
    this.r = ((GLImageView)findViewById(2131232000));
    this.m = findViewById(2131231694);
    showProgerssView(false);
    b();
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.g.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.h.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.k.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.j.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.l.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.i.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
  }
  
  private void a(Context paramContext)
  {
    this.o = new com.gau.go.launcherex.gowidget.weather.f.a();
    this.o.a = paramContext.getPackageName();
    this.o.b = paramContext.getResources();
    this.o.c = new String[] { "go_widget_41_style2_na", "go_widget_41_style2_sunny_day", "go_widget_41_style2_sunny_night", "go_widget_41_style2_cloudy_day", "go_widget_41_style2_cloudy_night", "go_widget_41_style2_overcast", "go_widget_41_style2_snowy", "go_widget_41_style2_foggy", "go_widget_41_style2_rainy", "go_widget_41_style2_thunderstrom" };
    paramContext = new HashMap();
    paramContext.put("gw_weather_41_bg", "");
    paramContext.put("gw_weather_41_txt_selector", "go_widget_41_style2_text_selector");
    paramContext.put("gw_weather_41_txt_shadow_color", "#66FFFFFF");
    paramContext.put("gw_weather_41_txt_shadow_dx", "0");
    paramContext.put("gw_weather_41_txt_shadow_dy", "1");
    paramContext.put("gw_weather_41_txt_shadow_radius", "1");
    paramContext.put("gw_weather_41_refresh_selector", "go_widget_41_style2_refresh_selector");
    paramContext.put("refresh_progress_41", "go_widget_41_style2_refresh_progress");
    this.o.a(paramContext);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    this.g.setTextColor(paramColorStateList);
    this.h.setTextColor(paramColorStateList);
    this.k.setTextColor(paramColorStateList);
    this.j.setTextColor(paramColorStateList);
    this.l.setTextColor(paramColorStateList);
    this.i.setTextColor(paramColorStateList);
  }
  
  private void a(Time paramTime, boolean paramBoolean)
  {
    int i1 = paramTime.hour;
    if (paramBoolean)
    {
      this.k.setVisibility(8);
      return;
    }
    this.k.setVisibility(0);
    if ((i1 >= 0) && (i1 < 12))
    {
      this.k.setText("AM");
      return;
    }
    this.k.setText("PM");
  }
  
  private void a(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramBoolean3);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = h();
    if ((localObject == null) || (((Drawable)localObject).getIntrinsicWidth() <= 0) || (((Drawable)localObject).getIntrinsicHeight() <= 0)) {}
    do
    {
      return;
      localObject = GLDrawable.getDrawable((Drawable)localObject);
    } while (localObject == null);
    this.d.setWeather((GLDrawable)localObject, paramBoolean);
  }
  
  private void b()
  {
    setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.e.setOnLongClickListener(this);
    this.g.setOnLongClickListener(this);
    this.h.setOnLongClickListener(this);
    this.i.setOnLongClickListener(this);
    this.k.setOnLongClickListener(this);
    this.l.setOnLongClickListener(this);
    this.j.setOnLongClickListener(this);
    this.d.setOnLongClickListener(this);
    this.q.setOnLongClickListener(this);
    this.r.setOnLongClickListener(this);
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
    this.j.setText(localStringBuilder.toString());
  }
  
  private void c()
  {
    Object localObject = "";
    if (this.a != null) {
      localObject = this.a.c();
    }
    for (int i1 = this.a.e();; i1 = -1)
    {
      localObject = p.a(getContext(), (String)localObject, true, 5, "", -1);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("gowidget_Id", this.n.getWidgetId());
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
  
  private void d()
  {
    String str;
    if (this.a == null) {
      if (this.n.isLocatingCity()) {
        str = this.mContext.getString(2131166458);
      }
    }
    for (;;)
    {
      this.g.setText(str);
      return;
      if (this.n.isLoadingDatas())
      {
        str = this.mContext.getString(2131166457);
      }
      else
      {
        str = this.mContext.getString(2131166455);
        continue;
        str = this.a.d();
      }
    }
  }
  
  private void e()
  {
    String str;
    if (this.n.isLoadingDatas()) {
      str = "--";
    }
    for (;;)
    {
      this.i.setText(str);
      return;
      if (this.a == null) {
        str = this.mContext.getString(2131165323);
      } else {
        str = this.a.k.e();
      }
    }
  }
  
  private Time f()
  {
    g localg = this.n.getTimeManager();
    boolean bool1 = this.n.mSettings.h;
    boolean bool2 = this.n.mIsPro;
    if ((this.a != null) && (bool2) && (bool1)) {
      return localg.b(this.a.k.n());
    }
    return localg.c();
  }
  
  private boolean g()
  {
    if (this.a == null) {
      return true;
    }
    g localg = this.n.getTimeManager();
    String str1 = this.a.k.j();
    String str2 = this.a.k.k();
    if (localg.d()) {
      return r.a(str1, str2, localg.b(this.a.k.n()));
    }
    return r.a(str1, str2);
  }
  
  private Drawable h()
  {
    String str2 = this.o.c[0];
    boolean bool = g();
    String str1 = str2;
    if (this.a != null) {
      switch (this.a.k.d())
      {
      default: 
        str1 = str2;
      }
    }
    for (;;)
    {
      return com.gau.go.launcherex.gowidget.weather.f.c.a(this.o.b, str1, this.o.a);
      if (bool)
      {
        str1 = this.o.c[1];
      }
      else
      {
        str1 = this.o.c[2];
        continue;
        if (bool)
        {
          str1 = this.o.c[3];
        }
        else
        {
          str1 = this.o.c[4];
          continue;
          str1 = this.o.c[5];
          continue;
          str1 = this.o.c[6];
          continue;
          str1 = this.o.c[7];
          continue;
          str1 = this.o.c[8];
          continue;
          str1 = this.o.c[9];
        }
      }
    }
  }
  
  private void i()
  {
    setOnClickListener(null);
    if (this.e != null) {
      this.e.setOnClickListener(null);
    }
    if (this.g != null) {
      this.g.setOnClickListener(null);
    }
    if (this.h != null) {
      this.h.setOnClickListener(null);
    }
    if (this.i != null) {
      this.i.setOnClickListener(null);
    }
    if (this.k != null) {
      this.k.setOnClickListener(null);
    }
    if (this.l != null) {
      this.l.setOnClickListener(null);
    }
    if (this.j != null) {
      this.j.setOnClickListener(null);
    }
    if (this.d != null) {
      this.d.setOnClickListener(null);
    }
    setOnLongClickListener(null);
    if (this.e != null) {
      this.e.setOnLongClickListener(null);
    }
    if (this.g != null) {
      this.g.setOnLongClickListener(null);
    }
    if (this.h != null) {
      this.h.setOnLongClickListener(null);
    }
    if (this.i != null) {
      this.i.setOnLongClickListener(null);
    }
    if (this.k != null) {
      this.k.setOnLongClickListener(null);
    }
    if (this.l != null) {
      this.l.setOnLongClickListener(null);
    }
    if (this.j != null) {
      this.j.setOnLongClickListener(null);
    }
    if (this.d != null) {
      this.d.setOnLongClickListener(null);
    }
  }
  
  public void cleanup()
  {
    super.cleanup();
    i();
  }
  
  public String getCityId()
  {
    if (this.a != null) {
      return this.a.c();
    }
    return null;
  }
  
  public int getContentViewLayoutId()
  {
    return 2130903336;
  }
  
  public WeatherBean getWeatherBean()
  {
    return this.a;
  }
  
  public boolean isEmptyCity()
  {
    return TextUtils.isEmpty(getCityId());
  }
  
  public void notifyLanguageChanged()
  {
    this.p = com.gau.go.launcherex.gowidget.weather.util.c.h(this.mContext);
    d();
    updateDateWeek();
  }
  
  public void onApplyTheme(com.gau.go.launcherex.gowidget.weather.f.a parama)
  {
    float f3 = 1.0F;
    this.o = parama;
    Object localObject = this.o.c[0];
    localObject = com.gau.go.launcherex.gowidget.weather.f.c.a(this.o.b, (String)localObject, this.o.a);
    if (localObject != null)
    {
      localObject = GLDrawable.getDrawable((Drawable)localObject);
      if (localObject != null) {
        this.d.setWeather((GLDrawable)localObject, false);
      }
    }
    localObject = com.gau.go.launcherex.gowidget.weather.f.c.b(this.o.b, this.o.a("gw_weather_41_txt_selector"), this.o.a);
    if (localObject != null)
    {
      a((ColorStateList)localObject);
      this.m.setBackgroundColor(((ColorStateList)localObject).getDefaultColor());
    }
    try
    {
      int i1 = com.gau.go.launcherex.gowidget.weather.f.c.a(this.o.a("gw_weather_41_txt_shadow_color"), 16777215);
      String str = this.o.a("gw_weather_41_txt_shadow_dx");
      if (!TextUtils.isEmpty(str))
      {
        f1 = Float.parseFloat(str);
        str = this.o.a("gw_weather_41_txt_shadow_dy");
        if (!TextUtils.isEmpty(str))
        {
          f2 = Float.parseFloat(str);
          str = this.o.a("gw_weather_41_txt_shadow_radius");
          if (!TextUtils.isEmpty(str)) {
            f3 = Float.parseFloat(str);
          }
          a(i1, f1, f2, f3);
          if (localObject != null)
          {
            if ((((ColorStateList)localObject).getDefaultColor() & 0xFFFFFF) < 8388607) {
              this.q.setColorType(false);
            }
          }
          else
          {
            localObject = this.o.a("gw_weather_41_theme_setting_selector");
            localObject = com.gau.go.launcherex.gowidget.weather.f.c.a(this.o.b, (String)localObject, this.o.a);
            if (localObject == null) {
              break label431;
            }
            this.r.setVisibility(0);
            this.r.setImageDrawable((Drawable)localObject);
            i1 = this.e.getVisibility();
            this.e.setBackgroundDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.o.b, parama.a("gw_weather_41_refresh_selector"), this.o.a));
            this.e.setVisibility(i1);
            i1 = this.f.getVisibility();
            parama = this.o.a("gw_weather_41_refresh_selector");
            this.f.setBackgroundDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.o.b, parama, this.o.a));
            this.f.setVisibility(i1);
            updateAllViews();
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
        this.q.setColorType(true);
        continue;
        label431:
        this.r.setVisibility(4);
        continue;
        float f2 = 1.0F;
        continue;
        float f1 = 0.0F;
      }
    }
  }
  
  public void onClick(GLView paramGLView)
  {
    if (this.n.isLoadingDatas()) {}
    do
    {
      return;
      if (paramGLView.equals(this.e))
      {
        this.n.refreshWeather();
        return;
      }
      if (paramGLView.equals(this))
      {
        c();
        return;
      }
      if (paramGLView.equals(this.g))
      {
        c();
        return;
      }
      if (paramGLView.equals(this.h))
      {
        c();
        return;
      }
      if (paramGLView.equals(this.i))
      {
        c();
        return;
      }
      if (paramGLView.equals(this.d))
      {
        c();
        return;
      }
      if (paramGLView.equals(this.k))
      {
        this.n.gotoClock();
        return;
      }
      if (paramGLView.equals(this.j))
      {
        this.n.gotoClock();
        return;
      }
      if (paramGLView.equals(this.l))
      {
        this.n.gotoCalendar();
        return;
      }
      if (paramGLView.equals(this.q))
      {
        this.n.onThemeSwitcherClick();
        return;
      }
    } while (!paramGLView.equals(this.r));
    this.n.gotoThemeStore();
  }
  
  public boolean onLongClick(GLView paramGLView)
  {
    performLongClick();
    return true;
  }
  
  public void playThemeChangeAnimation()
  {
    this.q.playAnimation();
  }
  
  public void setThemeSwitcherVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.q.setVisibility(0);
      return;
    }
    this.q.setVisibility(8);
  }
  
  public void setWeatherBean(WeatherBean paramWeatherBean)
  {
    this.a = paramWeatherBean;
  }
  
  public void setWidgetView(GLWeatherWidget41Style2 paramGLWeatherWidget41Style2)
  {
    this.n = paramGLWeatherWidget41Style2;
  }
  
  public void showProgerssView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.setVisibility(4);
      this.f.setVisibility(0);
      this.f.startAnimation();
      return;
    }
    this.e.setVisibility(0);
    this.f.setVisibility(4);
    this.f.stopAnimation();
  }
  
  public void updateAllViews()
  {
    d();
    updateWeatherIcon();
    e();
    updateNowTemp();
    updateTime();
    updateDateWeek();
  }
  
  public void updateDateWeek()
  {
    g localg = this.n.getTimeManager();
    Time localTime = f();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.p[localTime.weekDay].replace(".", ""));
    localStringBuffer.append(" , ");
    localStringBuffer.append(localg.a(localTime));
    this.l.setText(localStringBuffer.toString());
  }
  
  public void updateNowTemp()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    WidgetSettingBean localWidgetSettingBean = this.n.mSettings;
    if (this.n.isLoadingDatas())
    {
      localStringBuilder.append("--");
      if (localWidgetSettingBean.a != 1) {
        break label126;
      }
      localStringBuilder.append("°C");
    }
    for (;;)
    {
      this.h.setText(localStringBuilder.toString());
      return;
      if (this.a == null)
      {
        localStringBuilder.append("--");
        break;
      }
      float f1 = this.a.k.a(localWidgetSettingBean.a);
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
  
  public void updateTime()
  {
    Time localTime = f();
    boolean bool = r.b(this.mContext);
    a(localTime, bool);
    b(localTime, bool);
  }
  
  public void updateWeatherIcon()
  {
    a(this.n.getDynamicIconManager(), this.n.mIsPro, this.n.mSettings.g, this.mAnimationWeatherIcon);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeather41Style2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */