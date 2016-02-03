package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.Time;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.f.a;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.view.GLWidgetThemeSwitcher;
import com.gau.go.launcherex.gowidget.weather.view.dh;
import com.go.gl.animation.Animation;
import com.go.gl.animation.Animation.AnimationListener;
import com.go.gl.animation.Translate3DAnimation;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLLinearLayout;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;
import com.go.gl.view.GLView.OnLongClickListener;
import com.go.gl.widget.GLImageView;
import com.go.gl.widget.GLTextViewWrapper;
import java.util.HashMap;

public class GLWeather41
  extends GLWidgetChildView
  implements Animation.AnimationListener, GLView.OnClickListener, GLView.OnLongClickListener
{
  private GLTextViewWrapper A = null;
  private GLTextViewWrapper B = null;
  private GLWeatherLouverView C = null;
  private GLImageView D = null;
  private GLImageView E = null;
  private GLProgressBar F = null;
  private GLLinearLayout G = null;
  private GLLinearLayout H = null;
  private String[] I = null;
  private int J = 1;
  private a K = null;
  private int L;
  private int M;
  private int N;
  private int O;
  private g P = null;
  private int Q = 55536;
  private GLWeatherWidget41 R;
  private GLWidgetThemeSwitcher S;
  private WeatherBean a = null;
  private GLLinearLayout b = null;
  private GLLinearLayout c = null;
  private GLLinearLayout d = null;
  private GLLinearLayout e = null;
  private GLImageView f;
  private GLImageView g;
  private GLImageView h;
  private GLImageView i;
  private GLImageView j;
  private GLImageView k;
  private GLImageView l;
  private GLImageView m;
  private Animation n;
  private Animation o;
  private Animation p;
  private int q;
  private int r;
  private GLImageView s = null;
  private GLImageView t = null;
  private GLImageView u = null;
  private GLImageView v = null;
  private GLImageView w = null;
  private GLImageView x = null;
  private GLImageView y = null;
  private GLTextViewWrapper z = null;
  
  public GLWeather41(Context paramContext)
  {
    super(paramContext, dh.a);
    this.mContext = paramContext;
    a(paramContext);
    a();
  }
  
  private String a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String[] arrayOfString = this.K.d;; arrayOfString = this.K.e)
    {
      String str = arrayOfString[0];
      switch (paramInt)
      {
      default: 
        return arrayOfString[0];
      }
    }
    return arrayOfString[0];
    return arrayOfString[1];
    return arrayOfString[2];
    return arrayOfString[3];
    return arrayOfString[4];
    return arrayOfString[5];
    return arrayOfString[6];
    return arrayOfString[7];
    return arrayOfString[8];
    return arrayOfString[9];
  }
  
  private void a()
  {
    this.s = ((GLImageView)findViewById(2131232009));
    this.b = ((GLLinearLayout)findViewById(2131231279));
    this.f = ((GLImageView)this.b.findViewById(2131232005));
    this.g = ((GLImageView)this.b.findViewById(2131232006));
    this.c = ((GLLinearLayout)findViewById(2131231282));
    this.h = ((GLImageView)this.c.findViewById(2131232007));
    this.i = ((GLImageView)this.c.findViewById(2131232008));
    this.d = ((GLLinearLayout)findViewById(2131231287));
    this.j = ((GLImageView)this.d.findViewById(2131232010));
    this.k = ((GLImageView)this.d.findViewById(2131232011));
    this.e = ((GLLinearLayout)findViewById(2131231290));
    this.l = ((GLImageView)this.e.findViewById(2131232012));
    this.m = ((GLImageView)this.e.findViewById(2131232013));
    this.n = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    this.n.setDuration(500L);
    this.n.setAnimationListener(this);
    this.o = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    this.o.setDuration(500L);
    this.o.setAnimationListener(this);
    this.p = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F, 1, 0.0F);
    this.p.setDuration(500L);
    this.t = ((GLImageView)findViewById(2131232003));
    this.u = ((GLImageView)findViewById(2131231990));
    this.v = ((GLImageView)findViewById(2131231991));
    this.w = ((GLImageView)findViewById(2131231992));
    this.x = ((GLImageView)findViewById(2131231993));
    this.y = ((GLImageView)findViewById(2131231994));
    this.D = ((GLImageView)findViewById(2131232000));
    this.D.setOnClickListener(this);
    this.E = ((GLImageView)findViewById(2131232023));
    this.E.setOnClickListener(this);
    this.F = ((GLProgressBar)findViewById(2131232022));
    this.z = ((GLTextViewWrapper)findViewById(2131232015));
    this.A = ((GLTextViewWrapper)findViewById(2131232016));
    this.B = ((GLTextViewWrapper)findViewById(2131231995));
    this.C = ((GLWeatherLouverView)findViewById(2131231987));
    try
    {
      GLDrawable localGLDrawable = GLDrawable.getDrawable(getResources(), 2130838042);
      this.C.setWeather(localGLDrawable, false);
      this.G = ((GLLinearLayout)findViewById(2131231989));
      this.H = ((GLLinearLayout)findViewById(2131232004));
      this.H.setClipChildren(true);
      this.S = ((GLWidgetThemeSwitcher)findViewById(2131231998));
      this.S.setColorType(false);
      b();
      this.I = com.gau.go.launcherex.gowidget.weather.util.c.h(this.mContext);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
  }
  
  private void a(int paramInt)
  {
    if (r.b(this.mContext))
    {
      this.t.setVisibility(8);
      return;
    }
    if ((paramInt >= 0) && (paramInt < 12)) {
      if (this.K != null) {
        this.t.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, this.K.a("gw_weather_41_time_am"), this.K.a));
      }
    }
    for (;;)
    {
      this.t.setVisibility(0);
      return;
      this.t.setImageResource(2130838100);
      continue;
      if (this.K != null)
      {
        Drawable localDrawable = com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, this.K.a("gw_weather_41_time_pm"), this.K.a);
        this.t.setImageDrawable(localDrawable);
      }
      else
      {
        this.t.setImageResource(2130838102);
      }
    }
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.B.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.z.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.A.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.a == null) {}
    while (((paramInt1 != this.L) || (paramInt2 != this.M)) && ((paramInt1 != this.N) || (paramInt2 != this.O))) {
      return;
    }
    showWeatherInfo(true);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramInt1, paramInt2);
    int i1 = paramInt1;
    if (!r.b(this.mContext))
    {
      paramInt1 %= 12;
      i1 = paramInt1;
      if (paramInt1 == 0) {
        i1 = paramInt1 + 12;
      }
    }
    if ((paramBoolean) && (this.q != i1))
    {
      this.q = i1;
      this.h.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(i1 / 10, true), this.K.a));
      this.i.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(i1 % 10, true), this.K.a));
      this.c.setVisibility(0);
      this.b.startAnimation(this.p);
      this.c.startAnimation(this.n);
    }
    while ((paramBoolean) && (this.r != paramInt2))
    {
      this.r = paramInt2;
      this.l.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(paramInt2 / 10, true), this.K.a));
      this.m.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(paramInt2 % 10, true), this.K.a));
      this.e.setVisibility(0);
      this.d.startAnimation(this.p);
      this.e.startAnimation(this.o);
      return;
      this.q = i1;
      this.f.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(i1 / 10, true), this.K.a));
      this.g.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(i1 % 10, true), this.K.a));
    }
    this.r = paramInt2;
    this.j.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(paramInt2 / 10, true), this.K.a));
    this.k.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(paramInt2 % 10, true), this.K.a));
  }
  
  private void a(Context paramContext)
  {
    this.K = new a();
    this.K.a = paramContext.getPackageName();
    this.K.b = paramContext.getResources();
    this.K.d = new String[] { "gw_weather_42_time_num0_w", "gw_weather_42_time_num1_w", "gw_weather_42_time_num2_w", "gw_weather_42_time_num3_w", "gw_weather_42_time_num4_w", "gw_weather_42_time_num5_w", "gw_weather_42_time_num6_w", "gw_weather_42_time_num7_w", "gw_weather_42_time_num8_w", "gw_weather_42_time_num9_w" };
    this.K.e = new String[] { "gw_weather_42_temp_num0_w", "gw_weather_42_temp_num1_w", "gw_weather_42_temp_num2_w", "gw_weather_42_temp_num3_w", "gw_weather_42_temp_num4_w", "gw_weather_42_temp_num5_w", "gw_weather_42_temp_num6_w", "gw_weather_42_temp_num7_w", "gw_weather_42_temp_num8_w", "gw_weather_42_temp_num9_w" };
    this.K.c = new String[] { "gowidget_42_weather_na", "gowidget_42_weather_sunny_day", "gowidget_42_weather_sunny_night", "gowidget_42_weather_cloudy_day", "gowidget_42_weather_cloudy_night", "gowidget_42_weather_overcast", "gowidget_42_weather_snowy", "gowidget_42_weather_foggy", "gowidget_42_weather_rainy", "gowidget_42_weather_thunderstorm" };
    paramContext = new HashMap();
    paramContext.put("gw_weather_41_temp_minus", "gw_weather_42_temp_minus_w");
    paramContext.put("gw_weather_41_temp_unit", "gw_weather_42_temp_unit_w");
    paramContext.put("gw_weather_41_temp_unit_celsius", "widget_l_temp_centigrade_w");
    paramContext.put("gw_weather_41_temp_unit_fahrenheit", "widget_l_temp_fahrenheit_w");
    paramContext.put("gw_weather_41_time_divider", "gw_weather_41_time_divider_w");
    paramContext.put("gw_weather_41_time_am", "gw_weather_41_am_w");
    paramContext.put("gw_weather_41_time_pm", "gw_weather_41_pm_w");
    paramContext.put("gw_weather_41_bg", "gw_weather_41_bg_w");
    paramContext.put("gw_weather_41_txt_selector", "text_selector_w");
    paramContext.put("gw_weather_41_txt_shadow_color", "#66FFFFFF");
    paramContext.put("gw_weather_41_txt_shadow_dx", "0");
    paramContext.put("gw_weather_41_txt_shadow_dy", "1");
    paramContext.put("gw_weather_41_txt_shadow_radius", "1");
    paramContext.put("gw_weather_41_refresh_selector", "gw_weather_41_refresh_selector_w");
    paramContext.put("refresh_progress_41", "refresh_progress_41_w");
    this.K.a(paramContext);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    this.B.getTextView().setTextColor(paramColorStateList);
    this.z.getTextView().setTextColor(paramColorStateList);
    this.A.getTextView().setTextColor(paramColorStateList);
  }
  
  private void b()
  {
    this.B.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.S.setOnClickListener(this);
    this.B.setOnLongClickListener(this);
    this.E.setOnLongClickListener(this);
    this.t.setOnLongClickListener(this);
    this.H.setOnLongClickListener(this);
    this.C.setOnLongClickListener(this);
    this.G.setOnLongClickListener(this);
    this.z.setOnLongClickListener(this);
    this.A.setOnLongClickListener(this);
    this.S.setOnLongClickListener(this);
  }
  
  private void c()
  {
    setOnClickListener(null);
    setOnLongClickListener(null);
    unSetComponentOnClickListener(this.B);
    unSetComponentOnClickListener(this.E);
    unSetComponentOnClickListener(this.H);
    unSetComponentOnClickListener(this.C);
    unSetComponentOnClickListener(this.G);
    unSetComponentOnClickListener(this.z);
    unSetComponentOnClickListener(this.A);
    unSetComponentOnClickListener(this.S);
    unSetComponentOnLongClickListener(this.B);
    unSetComponentOnLongClickListener(this.E);
    unSetComponentOnLongClickListener(this.t);
    unSetComponentOnLongClickListener(this.H);
    unSetComponentOnLongClickListener(this.C);
    unSetComponentOnLongClickListener(this.G);
    unSetComponentOnLongClickListener(this.z);
    unSetComponentOnLongClickListener(this.A);
    unSetComponentOnLongClickListener(this.S);
  }
  
  public void adjustTime()
  {
    if ((this.P.d()) && (this.a != null) && (this.a.k.n() != this.Q)) {
      this.Q = this.a.k.n();
    }
    syncTime(false);
  }
  
  public void cleanup()
  {
    super.cleanup();
    c();
  }
  
  public String getCityId()
  {
    if (this.a != null) {
      return this.a.c();
    }
    return null;
  }
  
  public Time getCityTime()
  {
    if (this.a != null)
    {
      this.Q = this.a.k.n();
      return this.P.b(this.Q);
    }
    return this.P.c();
  }
  
  public int getContentViewLayoutId()
  {
    return 2130903332;
  }
  
  public int getMyLocation()
  {
    return this.a.e();
  }
  
  public WeatherBean getWeatherBean()
  {
    return this.a;
  }
  
  public boolean isDayTime()
  {
    if (this.a == null) {
      return true;
    }
    String str1 = this.a.k.j();
    String str2 = this.a.k.k();
    if (this.P.d())
    {
      int i1 = this.a.k.n();
      return r.a(str1, str2, this.P.b(i1));
    }
    return r.a(str1, str2);
  }
  
  public boolean isEmptyCity()
  {
    return TextUtils.isEmpty(getCityId());
  }
  
  public void notifyLanguageChanged()
  {
    Time localTime = getCityTime();
    this.I = com.gau.go.launcherex.gowidget.weather.util.c.h(this.mContext);
    if (localTime != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(this.P.a(localTime));
      localStringBuffer.append(" " + this.I[localTime.weekDay]);
      this.A.setText(localStringBuffer.toString());
    }
    if (this.a == null) {
      setTip(this.mContext.getString(2131166455));
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.n))
    {
      this.c.setVisibility(8);
      this.f.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(this.q / 10, true), this.K.a));
      this.g.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(this.q % 10, true), this.K.a));
    }
    while (!paramAnimation.equals(this.o)) {
      return;
    }
    this.e.setVisibility(8);
    this.j.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(this.r / 10, true), this.K.a));
    this.k.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(this.r % 10, true), this.K.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onApplyTheme(a parama)
  {
    this.K = parama;
    Object localObject1 = this.K.c[0];
    try
    {
      localObject1 = com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, (String)localObject1, this.K.a);
      if (localObject1 != null)
      {
        localObject1 = GLDrawable.getDrawable((Drawable)localObject1);
        this.C.setWeather((GLDrawable)localObject1, false);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
    localObject1 = this.K.a("gw_weather_41_temp_minus");
    localObject1 = com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, (String)localObject1, this.K.a);
    this.w.setImageDrawable((Drawable)localObject1);
    this.x.setImageDrawable((Drawable)localObject1);
    this.u.setImageDrawable((Drawable)localObject1);
    localObject1 = parama.a("gw_weather_41_time_divider");
    this.s.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, (String)localObject1, this.K.a));
    if (this.J == 1) {
      localObject1 = this.K.a("gw_weather_41_temp_unit_celsius");
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.K.a("gw_weather_41_temp_unit");
      }
      this.y.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, (String)localObject2, this.K.a));
      parama = com.gau.go.launcherex.gowidget.weather.f.c.b(this.K.b, parama.a("gw_weather_41_txt_selector"), this.K.a);
      a(parama);
      try
      {
        a(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.a("gw_weather_41_txt_shadow_color"), 16777215), Float.parseFloat(this.K.a("gw_weather_41_txt_shadow_dx")), Float.parseFloat(this.K.a("gw_weather_41_txt_shadow_dy")), Float.parseFloat(this.K.a("gw_weather_41_txt_shadow_radius")));
        if (parama != null)
        {
          if ((parama.getDefaultColor() & 0xFFFFFF) < 8388607) {
            this.S.setColorType(false);
          }
        }
        else
        {
          parama = this.K.a("gw_weather_41_theme_setting_selector");
          parama = com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, parama, this.K.a);
          if (parama == null) {
            break label565;
          }
          this.D.setVisibility(0);
          this.D.setImageDrawable(parama);
          int i1 = this.E.getVisibility();
          parama = this.K.a("gw_weather_41_refresh_selector");
          this.E.setBackgroundDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, parama, this.K.a));
          this.E.setVisibility(i1);
          i1 = this.F.getVisibility();
          parama = this.K.a("gw_weather_41_refresh_selector");
          this.F.setBackgroundDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, parama, this.K.a));
          this.F.setVisibility(i1);
          this.b.clearAnimation();
          this.c.clearAnimation();
          this.d.clearAnimation();
          this.e.clearAnimation();
          this.c.setVisibility(8);
          this.e.setVisibility(8);
          syncTime(false);
          showWeatherInfo(false);
          return;
          localObject1 = this.K.a("gw_weather_41_temp_unit_fahrenheit");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          localNumberFormatException.printStackTrace();
          continue;
          this.S.setColorType(true);
          continue;
          label565:
          this.D.setVisibility(4);
        }
      }
    }
  }
  
  public void onClick(GLView paramGLView)
  {
    if ((paramGLView.equals(this.C)) || (paramGLView.equals(this.G)) || (paramGLView.equals(this.z)) || (paramGLView.equals(this.B))) {
      this.R.gotoWeatherDetail(getCityId());
    }
    do
    {
      return;
      if (paramGLView.equals(this.E))
      {
        this.R.refreshWeather();
        return;
      }
      if (paramGLView.equals(this.A))
      {
        this.R.gotoCalendar();
        return;
      }
      if (paramGLView.equals(this.H))
      {
        this.R.gotoClock();
        return;
      }
      if (paramGLView.equals(this.D))
      {
        this.R.gotoThemeStore();
        return;
      }
    } while (!paramGLView.equals(this.S));
    this.R.onThemeSwitcherClick();
  }
  
  public boolean onLongClick(GLView paramGLView)
  {
    performLongClick();
    return true;
  }
  
  public void playThemeChangeAnimation()
  {
    this.S.playAnimation();
  }
  
  public void setMyLocation(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void setTempUnit(int paramInt)
  {
    this.J = paramInt;
  }
  
  public void setThemeBean(a parama)
  {
    this.K = parama;
  }
  
  public void setThemeSwitcherVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.S.setVisibility(0);
      return;
    }
    this.S.setVisibility(8);
  }
  
  public void setTimeManager(g paramg)
  {
    this.P = paramg;
  }
  
  public void setTip(String paramString)
  {
    this.B.setText(paramString);
  }
  
  public void setWeatherBean(WeatherBean paramWeatherBean)
  {
    Object localObject;
    if (paramWeatherBean != null)
    {
      this.a = paramWeatherBean;
      localObject = paramWeatherBean.k.j();
      paramWeatherBean = paramWeatherBean.k.k();
      if ((!r.a((String)localObject)) || (!r.a(paramWeatherBean))) {}
    }
    else
    {
      try
      {
        localObject = ((String)localObject).split(":");
        this.L = Integer.parseInt(localObject[0]);
        this.M = Integer.parseInt(localObject[1]);
        paramWeatherBean = paramWeatherBean.split(":");
        this.N = Integer.parseInt(paramWeatherBean[0]);
        this.O = Integer.parseInt(paramWeatherBean[1]);
        return;
      }
      catch (Exception paramWeatherBean)
      {
        paramWeatherBean.printStackTrace();
        return;
      }
    }
    this.L = 6;
    this.M = 0;
    this.N = 18;
    this.O = 0;
  }
  
  public void setWidgetView(GLWeatherWidget41 paramGLWeatherWidget41)
  {
    this.R = paramGLWeatherWidget41;
  }
  
  public void showCity()
  {
    this.B.setText(this.a.d());
  }
  
  public void showTemp(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.J = paramInt;
    showTempNow(this.a.k.a(paramInt));
    float f1 = this.a.k.c(this.J);
    float f2 = this.a.k.b(this.J);
    StringBuffer localStringBuffer = new StringBuffer();
    if (f2 == -10000.0F)
    {
      localStringBuffer.append("--");
      localStringBuffer.append("°/");
      if (f1 != -10000.0F) {
        break label161;
      }
      localStringBuffer.append("--");
    }
    for (;;)
    {
      localStringBuffer.append("° , ");
      localStringBuffer.append(this.a.k.e());
      this.z.setText(localStringBuffer.toString());
      return;
      localStringBuffer.append(q.a(f2));
      break;
      label161:
      localStringBuffer.append(q.a(f1));
    }
  }
  
  public void showTempNow(float paramFloat)
  {
    if (paramFloat == -10000.0F)
    {
      localObject1 = this.K.a("gw_weather_41_temp_minus");
      localObject1 = com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, (String)localObject1, this.K.a);
      this.u.setVisibility(8);
      this.v.setVisibility(8);
      this.w.setVisibility(0);
      this.x.setVisibility(0);
      this.w.setImageDrawable((Drawable)localObject1);
      this.x.setImageDrawable((Drawable)localObject1);
      return;
    }
    int i1 = q.a(paramFloat);
    int i2;
    label134:
    int i3;
    if (i1 < 0)
    {
      this.u.setVisibility(0);
      i1 = Math.abs(i1);
      i2 = i1 / 100;
      if (i2 != 0) {
        break label279;
      }
      this.v.setVisibility(8);
      i3 = (i1 - i2 * 100) / 10;
      if ((i3 != 0) || (i2 != 0)) {
        break label320;
      }
      this.w.setVisibility(8);
      label163:
      this.x.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(i1 % 10, false), this.K.a));
      if (this.J != 1) {
        break label362;
      }
    }
    label279:
    label320:
    label362:
    for (Object localObject1 = this.K.a("gw_weather_41_temp_unit_celsius");; localObject1 = this.K.a("gw_weather_41_temp_unit_fahrenheit"))
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.K.a("gw_weather_41_temp_unit");
      }
      this.y.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, (String)localObject2, this.K.a));
      return;
      this.u.setVisibility(8);
      break;
      this.v.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(i2, false), this.K.a));
      this.v.setVisibility(0);
      break label134;
      this.w.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, a(i3, false), this.K.a));
      this.w.setVisibility(0);
      break label163;
    }
  }
  
  public void showWeatherInfo(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    showCity();
    Object localObject = this.K.c[0];
    boolean bool = isDayTime();
    switch (this.a.k.d())
    {
    default: 
      localObject = this.K.c[0];
    }
    for (;;)
    {
      localObject = com.gau.go.launcherex.gowidget.weather.f.c.a(this.K.b, (String)localObject, this.K.a);
      if (localObject != null) {
        this.C.setWeather(GLDrawable.getDrawable((Drawable)localObject), paramBoolean);
      }
      showTemp(this.J);
      return;
      if (bool)
      {
        localObject = this.K.c[1];
      }
      else
      {
        localObject = this.K.c[2];
        continue;
        if (bool)
        {
          localObject = this.K.c[3];
        }
        else
        {
          localObject = this.K.c[4];
          continue;
          localObject = this.K.c[5];
          continue;
          localObject = this.K.c[6];
          continue;
          localObject = this.K.c[7];
          continue;
          localObject = this.K.c[8];
          continue;
          localObject = this.K.c[9];
        }
      }
    }
  }
  
  public void startRefreshAni(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.E.setVisibility(8);
      this.F.setVisibility(0);
      this.F.startAnimation();
      return;
    }
    this.E.setVisibility(0);
    this.F.setVisibility(8);
    this.F.stopAnimation();
  }
  
  public void syncTime(boolean paramBoolean)
  {
    Time localTime = getCityTime();
    if (localTime != null)
    {
      a(localTime.hour, localTime.minute, paramBoolean);
      a(localTime.hour);
      updateDataStyle(localTime);
    }
  }
  
  public void updateAllViews()
  {
    syncTime(true);
    showWeatherInfo(true);
  }
  
  public void updateDataStyle(Time paramTime)
  {
    if (paramTime != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(this.P.a(paramTime));
      localStringBuffer.append(" " + this.I[paramTime.weekDay]);
      this.A.setText(localStringBuffer.toString());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeather41.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */