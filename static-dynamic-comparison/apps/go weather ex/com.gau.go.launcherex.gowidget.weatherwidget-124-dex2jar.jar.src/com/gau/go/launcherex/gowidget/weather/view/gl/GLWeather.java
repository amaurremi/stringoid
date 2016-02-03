package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.Time;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.f.a;
import com.gau.go.launcherex.gowidget.weather.f.d;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.util.c;
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

public class GLWeather
  extends GLWidgetChildView
  implements Animation.AnimationListener, GLView.OnClickListener, GLView.OnLongClickListener
{
  private static String[] P = null;
  private GLImageView A;
  private GLImageView B;
  private GLImageView C;
  private GLImageView D;
  private GLImageView E;
  private Animation F;
  private Animation G;
  private Animation H;
  private int I;
  private int J;
  private GLImageView K;
  private GLImageView L;
  private GLProgressBar M;
  private GLImageView N;
  private a O = null;
  private int Q;
  private int R;
  private int S;
  private int T;
  private g U = null;
  private int V = 55536;
  private GLWeatherWidget42 W;
  private GLWidgetThemeSwitcher X;
  private Context a = null;
  private WeatherBean b = null;
  private GLTextViewWrapper c = null;
  private GLWeatherLouverView d = null;
  private GLLinearLayout e = null;
  private GLImageView f;
  private GLImageView g;
  private GLImageView h;
  private GLImageView i;
  private GLImageView j;
  private GLTextViewWrapper k;
  private GLTextViewWrapper l;
  private GLTextViewWrapper m;
  private GLTextViewWrapper n;
  private GLTextViewWrapper o = null;
  private GLTextViewWrapper p = null;
  private GLTextViewWrapper q = null;
  private GLLinearLayout r = null;
  private GLLinearLayout s = null;
  private GLLinearLayout t = null;
  private GLLinearLayout u = null;
  private GLLinearLayout v = null;
  private GLImageView w = null;
  private GLImageView x;
  private GLImageView y;
  private GLImageView z;
  
  public GLWeather(Context paramContext)
  {
    super(paramContext, dh.a);
    this.a = paramContext;
    a();
    a(paramContext);
  }
  
  private String a(Context paramContext, int paramInt, float paramFloat)
  {
    if (paramInt == 1) {
      return String.format(getResources().getString(2131165809), new Object[] { Float.valueOf(q.c(paramFloat, 1)) });
    }
    if (paramInt == 4) {
      return String.format(getResources().getString(2131165812), new Object[] { Float.valueOf(q.e(paramFloat, 1)) });
    }
    if (paramInt == 3) {
      return String.format(getResources().getString(2131165811), new Object[] { Float.valueOf(q.d(paramFloat, 1)) });
    }
    if (paramInt == 5) {
      return String.format(getResources().getString(2131165813), new Object[] { Integer.valueOf(q.a(paramFloat)) });
    }
    if (paramInt == 6) {
      return String.format(getResources().getString(2131165814), new Object[] { Float.valueOf(q.f(paramFloat, 1)) });
    }
    return String.format(getResources().getString(2131165810), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void a()
  {
    P = c.h(this.a);
    this.n = ((GLTextViewWrapper)findViewById(2131230831));
    this.o = ((GLTextViewWrapper)findViewById(2131232032));
    this.p = ((GLTextViewWrapper)findViewById(2131232033));
    this.q = ((GLTextViewWrapper)findViewById(2131232034));
    this.r = ((GLLinearLayout)findViewById(2131231277));
    this.r.setClipChildren(true);
    this.w = ((GLImageView)findViewById(2131231285));
    this.s = ((GLLinearLayout)this.r.findViewById(2131231279));
    this.t = ((GLLinearLayout)this.r.findViewById(2131231282));
    this.x = ((GLImageView)this.s.findViewById(2131231280));
    this.y = ((GLImageView)this.s.findViewById(2131231281));
    this.z = ((GLImageView)this.t.findViewById(2131231283));
    this.A = ((GLImageView)this.t.findViewById(2131231284));
    this.u = ((GLLinearLayout)this.r.findViewById(2131231287));
    this.v = ((GLLinearLayout)this.r.findViewById(2131231290));
    this.B = ((GLImageView)this.u.findViewById(2131231288));
    this.C = ((GLImageView)this.u.findViewById(2131231289));
    this.D = ((GLImageView)this.v.findViewById(2131231291));
    this.E = ((GLImageView)this.v.findViewById(2131231292));
    this.F = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    this.F.setDuration(500L);
    this.F.setAnimationListener(this);
    this.G = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    this.G.setDuration(500L);
    this.G.setAnimationListener(this);
    this.H = new Translate3DAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F, 1, 0.0F);
    this.H.setDuration(500L);
    this.L = ((GLImageView)findViewById(2131232023));
    this.L.setOnClickListener(this);
    this.M = ((GLProgressBar)findViewById(2131232022));
    this.K = ((GLImageView)findViewById(2131232035));
    this.c = ((GLTextViewWrapper)findViewById(2131231359));
    this.d = ((GLWeatherLouverView)findViewById(2131231979));
    try
    {
      this.d.setWeather(GLDrawable.getDrawable(getResources(), 2130838042), false);
      this.e = ((GLLinearLayout)findViewById(2131232038));
      this.f = ((GLImageView)findViewById(2131231982));
      this.g = ((GLImageView)findViewById(2131231983));
      this.h = ((GLImageView)findViewById(2131231984));
      this.i = ((GLImageView)findViewById(2131231985));
      this.j = ((GLImageView)findViewById(2131231986));
      this.k = ((GLTextViewWrapper)findViewById(2131232039));
      this.l = ((GLTextViewWrapper)findViewById(2131232040));
      this.m = ((GLTextViewWrapper)findViewById(2131232041));
      this.m.setText(getResources().getString(2131166456) + "---");
      this.N = ((GLImageView)findViewById(2131232036));
      this.X = ((GLWidgetThemeSwitcher)findViewById(2131231998));
      this.X.setColorType(false);
      b();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.c.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.n.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.o.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.q.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.p.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.k.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.l.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.m.getTextView().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.b == null) {}
    while (((paramInt1 != this.Q) || (paramInt2 != this.R)) && ((paramInt1 != this.S) || (paramInt2 != this.T))) {
      return;
    }
    showWeatherInfo(true);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramInt1, paramInt2);
    int i1 = paramInt1;
    if (!r.b(this.a))
    {
      paramInt1 %= 12;
      i1 = paramInt1;
      if (paramInt1 == 0) {
        i1 = 12;
      }
    }
    if ((paramBoolean) && (this.I != i1))
    {
      this.I = i1;
      this.z.setImageDrawable(d.a(this.O.b, b(i1 / 10, true), this.O.a));
      this.A.setImageDrawable(d.a(this.O.b, b(i1 % 10, true), this.O.a));
      this.t.setVisibility(0);
      this.s.startAnimation(this.H);
      this.t.startAnimation(this.F);
    }
    while ((paramBoolean) && (this.J != paramInt2))
    {
      this.J = paramInt2;
      this.D.setImageDrawable(d.a(this.O.b, b(paramInt2 / 10, true), this.O.a));
      this.E.setImageDrawable(d.a(this.O.b, b(paramInt2 % 10, true), this.O.a));
      this.v.setVisibility(0);
      this.u.startAnimation(this.H);
      this.v.startAnimation(this.G);
      return;
      this.I = i1;
      this.x.setImageDrawable(d.a(this.O.b, b(i1 / 10, true), this.O.a));
      this.y.setImageDrawable(d.a(this.O.b, b(i1 % 10, true), this.O.a));
    }
    this.J = paramInt2;
    this.B.setImageDrawable(d.a(this.O.b, b(paramInt2 / 10, true), this.O.a));
    this.C.setImageDrawable(d.a(this.O.b, b(paramInt2 % 10, true), this.O.a));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.K.setVisibility(8);
      return;
    }
    String str;
    if ((paramInt >= 0) && (paramInt < 12))
    {
      str = this.O.a("gw_weather_42_time_am");
      this.K.setImageDrawable(d.a(this.O.b, str, this.O.a));
    }
    for (;;)
    {
      this.K.setVisibility(0);
      return;
      str = this.O.a("gw_weather_42_time_pm");
      this.K.setImageDrawable(d.a(this.O.b, str, this.O.a));
    }
  }
  
  private void a(Context paramContext)
  {
    this.O = new a();
    this.O.a = paramContext.getPackageName();
    this.O.b = paramContext.getResources();
    this.O.d = new String[] { "gw_weather_42_time_num0_w", "gw_weather_42_time_num1_w", "gw_weather_42_time_num2_w", "gw_weather_42_time_num3_w", "gw_weather_42_time_num4_w", "gw_weather_42_time_num5_w", "gw_weather_42_time_num6_w", "gw_weather_42_time_num7_w", "gw_weather_42_time_num8_w", "gw_weather_42_time_num9_w" };
    this.O.e = new String[] { "gw_weather_42_temp_num0_w", "gw_weather_42_temp_num1_w", "gw_weather_42_temp_num2_w", "gw_weather_42_temp_num3_w", "gw_weather_42_temp_num4_w", "gw_weather_42_temp_num5_w", "gw_weather_42_temp_num6_w", "gw_weather_42_temp_num7_w", "gw_weather_42_temp_num8_w", "gw_weather_42_temp_num9_w" };
    this.O.c = new String[] { "gowidget_42_weather_na", "gowidget_42_weather_sunny_day", "gowidget_42_weather_sunny_night", "gowidget_42_weather_cloudy_day", "gowidget_42_weather_cloudy_night", "gowidget_42_weather_overcast", "gowidget_42_weather_snowy", "gowidget_42_weather_foggy", "gowidget_42_weather_rainy", "gowidget_42_weather_thunderstorm" };
    paramContext = new HashMap();
    paramContext.put("gw_weather_42_temp_minus", "gw_weather_42_temp_minus_w");
    paramContext.put("gw_weather_42_temp_unit", "gw_weather_42_temp_unit_w");
    paramContext.put("gw_weather_42_temp_unit_celsius", "widget_l_temp_centigrade_w");
    paramContext.put("gw_weather_42_temp_unit_fahrenheit", "widget_l_temp_fahrenheit_w");
    paramContext.put("gw_weather_42_time_divider", "gw_weather_42_time_divider_w");
    paramContext.put("gw_weather_42_time_bg", "gw_weather_42_time_bg_w");
    paramContext.put("gw_weather_42_time_am", "gw_weather_42_am_w");
    paramContext.put("gw_weather_42_time_pm", "gw_weather_42_pm_w");
    paramContext.put("gw_weather_42_bg", "gw_weather_42_bg_w");
    paramContext.put("gw_weather_42_txt_selector", "text_selector_w");
    paramContext.put("gw_weather_42_txt_shadow_color", "#66FFFFFF");
    paramContext.put("gw_weather_42_txt_shadow_dx", "0");
    paramContext.put("gw_weather_42_txt_shadow_dy", "1");
    paramContext.put("gw_weather_42_txt_shadow_radius", "1");
    paramContext.put("gw_weather_42_refresh_selector", "gw_weather_42_refresh_selector_w");
    paramContext.put("refresh_progress_42", "refresh_progress_w");
    this.O.a(paramContext);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    this.c.getTextView().setTextColor(paramColorStateList);
    this.n.getTextView().setTextColor(paramColorStateList);
    this.o.getTextView().setTextColor(paramColorStateList);
    this.q.getTextView().setTextColor(paramColorStateList);
    this.p.getTextView().setTextColor(paramColorStateList);
    this.k.getTextView().setTextColor(paramColorStateList);
    this.l.getTextView().setTextColor(paramColorStateList);
    this.m.getTextView().setTextColor(paramColorStateList);
  }
  
  private String b(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String[] arrayOfString = this.O.d;; arrayOfString = this.O.e)
    {
      String str = arrayOfString[0];
      switch (paramInt)
      {
      default: 
        return str;
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
  
  private void b()
  {
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.M.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.N.setOnClickListener(this);
    this.X.setOnClickListener(this);
    this.c.setOnLongClickListener(this);
    this.r.setOnLongClickListener(this);
    this.d.setOnLongClickListener(this);
    this.e.setOnLongClickListener(this);
    this.k.setOnLongClickListener(this);
    this.l.setOnLongClickListener(this);
    this.m.setOnLongClickListener(this);
    this.N.setOnLongClickListener(this);
    this.n.setOnLongClickListener(this);
    this.o.setOnLongClickListener(this);
    this.p.setOnLongClickListener(this);
    this.q.setOnLongClickListener(this);
    this.M.setOnLongClickListener(this);
    this.K.setOnLongClickListener(this);
    this.X.setOnLongClickListener(this);
  }
  
  private void c()
  {
    setOnClickListener(null);
    setOnLongClickListener(null);
    unSetComponentOnClickListener(this.d);
    unSetComponentOnClickListener(this.e);
    unSetComponentOnClickListener(this.k);
    unSetComponentOnClickListener(this.l);
    unSetComponentOnClickListener(this.m);
    unSetComponentOnClickListener(this.r);
    unSetComponentOnClickListener(this.n);
    unSetComponentOnClickListener(this.o);
    unSetComponentOnClickListener(this.p);
    unSetComponentOnClickListener(this.q);
    unSetComponentOnClickListener(this.L);
    unSetComponentOnClickListener(this.M);
    unSetComponentOnClickListener(this.c);
    unSetComponentOnClickListener(this.N);
    unSetComponentOnClickListener(this.X);
    unSetComponentOnLongClickListener(this.c);
    unSetComponentOnLongClickListener(this.r);
    unSetComponentOnLongClickListener(this.d);
    unSetComponentOnLongClickListener(this.e);
    unSetComponentOnLongClickListener(this.k);
    unSetComponentOnLongClickListener(this.l);
    unSetComponentOnLongClickListener(this.m);
    unSetComponentOnLongClickListener(this.N);
    unSetComponentOnLongClickListener(this.n);
    unSetComponentOnLongClickListener(this.o);
    unSetComponentOnLongClickListener(this.p);
    unSetComponentOnLongClickListener(this.q);
    unSetComponentOnLongClickListener(this.M);
    unSetComponentOnLongClickListener(this.K);
    unSetComponentOnLongClickListener(this.X);
  }
  
  public void adjustTime()
  {
    if ((this.U.d()) && (this.b != null) && (this.b.k.n() != this.V)) {
      this.V = this.b.k.n();
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
    if (this.b != null) {
      return this.b.c();
    }
    return null;
  }
  
  public Time getCityTime()
  {
    if (this.b != null)
    {
      this.V = this.b.k.n();
      return this.U.b(this.V);
    }
    return this.U.c();
  }
  
  public int getContentViewLayoutId()
  {
    return 2130903340;
  }
  
  public int getMyLocation()
  {
    return this.b.e();
  }
  
  public WeatherBean getWeatherBean()
  {
    return this.b;
  }
  
  public boolean isDayTime()
  {
    if (this.b == null) {
      return true;
    }
    String str1 = this.b.k.j();
    String str2 = this.b.k.k();
    if (this.U.d())
    {
      int i1 = this.b.k.n();
      return r.a(str1, str2, this.U.b(i1));
    }
    return r.a(str1, str2);
  }
  
  public boolean isEmptyCity()
  {
    return TextUtils.isEmpty(getCityId());
  }
  
  public void notifyLanguageChanged()
  {
    Object localObject = getCityTime();
    P = c.h(this.a);
    if (localObject != null)
    {
      localObject = P[localObject.weekDay];
      this.o.setText((CharSequence)localObject);
    }
    if (this.b != null)
    {
      localObject = this.b.k.b();
      if (r.a((String)localObject)) {
        break label102;
      }
      localObject = this.a.getString(2131165323);
      this.m.setText((CharSequence)localObject);
    }
    for (;;)
    {
      if (this.b == null) {
        setTip(this.a.getString(2131166455));
      }
      return;
      label102:
      float f1 = this.b.k.a();
      if (!r.b(f1))
      {
        this.m.setText(this.a.getString(2131166456) + (String)localObject);
      }
      else
      {
        String str = a(this.a, this.W.mSettings.b, f1);
        if (this.W.mSettings.b == 5) {
          this.m.setText(this.a.getString(2131166456) + (String)localObject + " ,  " + str);
        } else {
          this.m.setText(this.a.getString(2131166456) + str + " , " + (String)localObject);
        }
      }
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.F))
    {
      this.t.setVisibility(8);
      this.x.setImageDrawable(d.a(this.O.b, b(this.I / 10, true), this.O.a));
      this.y.setImageDrawable(d.a(this.O.b, b(this.I % 10, true), this.O.a));
    }
    while (!paramAnimation.equals(this.G)) {
      return;
    }
    this.v.setVisibility(8);
    this.B.setImageDrawable(d.a(this.O.b, b(this.J / 10, true), this.O.a));
    this.C.setImageDrawable(d.a(this.O.b, b(this.J % 10, true), this.O.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onApplyTheme(a parama)
  {
    this.O = parama;
    Object localObject1 = parama.c[0];
    try
    {
      localObject1 = d.a(this.O.b, (String)localObject1, this.O.a);
      if (localObject1 != null) {
        this.d.setWeather(GLDrawable.getDrawable((Drawable)localObject1), false);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
    localObject1 = parama.a("gw_weather_42_temp_minus");
    localObject1 = d.a(parama.b, (String)localObject1, parama.a);
    this.h.setImageDrawable((Drawable)localObject1);
    this.i.setImageDrawable((Drawable)localObject1);
    this.f.setImageDrawable((Drawable)localObject1);
    localObject1 = parama.a("gw_weather_42_time_bg");
    this.r.setBackgroundDrawable(d.a(parama.b, (String)localObject1, parama.a));
    localObject1 = parama.a("gw_weather_42_time_divider");
    this.w.setImageDrawable(d.a(parama.b, (String)localObject1, parama.a));
    if (this.W.mSettings.a == 1) {
      localObject1 = parama.a("gw_weather_42_temp_unit_celsius");
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = parama.a("gw_weather_42_temp_unit");
      }
      this.j.setImageDrawable(d.a(parama.b, (String)localObject2, parama.a));
      localObject1 = parama.a("gw_weather_42_txt_selector");
      localObject1 = d.b(parama.b, (String)localObject1, parama.a);
      a((ColorStateList)localObject1);
      try
      {
        a(d.a(parama.a("gw_weather_42_txt_shadow_color"), 16777215), Float.parseFloat(parama.a("gw_weather_42_txt_shadow_dx")), Float.parseFloat(parama.a("gw_weather_42_txt_shadow_dy")), Float.parseFloat(parama.a("gw_weather_42_txt_shadow_radius")));
        if (localObject1 != null)
        {
          if ((((ColorStateList)localObject1).getDefaultColor() & 0xFFFFFF) < 8388607) {
            this.X.setColorType(false);
          }
        }
        else
        {
          localObject1 = parama.a("gw_weather_42_theme_setting_selector");
          localObject1 = d.a(parama.b, (String)localObject1, parama.a);
          if (localObject1 == null) {
            break label522;
          }
          this.N.setVisibility(0);
          this.N.setImageDrawable((Drawable)localObject1);
          int i1 = this.L.getVisibility();
          localObject1 = parama.a("gw_weather_42_refresh_selector");
          this.L.setBackgroundDrawable(d.a(parama.b, (String)localObject1, parama.a));
          this.L.setVisibility(i1);
          i1 = this.M.getVisibility();
          localObject1 = parama.a("gw_weather_42_refresh_selector");
          this.M.setBackgroundDrawable(d.a(parama.b, (String)localObject1, parama.a));
          this.M.setVisibility(i1);
          this.s.clearAnimation();
          this.t.clearAnimation();
          this.u.clearAnimation();
          this.v.clearAnimation();
          this.t.setVisibility(8);
          this.v.setVisibility(8);
          syncTime(false);
          showWeatherInfo(false);
          return;
          localObject1 = parama.a("gw_weather_42_temp_unit_fahrenheit");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          localNumberFormatException.printStackTrace();
          continue;
          this.X.setColorType(true);
          continue;
          label522:
          this.N.setVisibility(4);
        }
      }
    }
  }
  
  public void onClick(GLView paramGLView)
  {
    if ((paramGLView.equals(this.d)) || (paramGLView.equals(this.e)) || (paramGLView.equals(this.k)) || (paramGLView.equals(this.l)) || (paramGLView.equals(this.m)) || (paramGLView.equals(this.c))) {
      this.W.gotoWeatherDetail(getCityId());
    }
    do
    {
      return;
      if ((paramGLView.equals(this.n)) || (paramGLView.equals(this.o)) || (paramGLView.equals(this.p)) || (paramGLView.equals(this.q)))
      {
        this.W.gotoCalendar();
        return;
      }
      if (paramGLView.equals(this.r))
      {
        this.W.gotoClock();
        return;
      }
      if (paramGLView.equals(this.N))
      {
        this.W.gotoThemeSetting();
        return;
      }
      if (paramGLView.equals(this.L))
      {
        this.W.doRefresh();
        return;
      }
    } while (!paramGLView.equals(this.X));
    this.W.onThemeSwitcherClick();
  }
  
  public boolean onLongClick(GLView paramGLView)
  {
    performLongClick();
    return true;
  }
  
  public void playThemeChangeAnimation()
  {
    this.X.playAnimation();
  }
  
  public void refreshTemp()
  {
    if (this.b == null) {
      return;
    }
    int i1 = this.W.mSettings.a;
    showTempNow(this.b.k.a(i1));
    float f1 = this.b.k.c(i1);
    float f2 = this.b.k.b(i1);
    StringBuffer localStringBuffer = new StringBuffer();
    if (f2 == -10000.0F)
    {
      localStringBuffer.append("--");
      localStringBuffer.append("°/");
      if (f1 != -10000.0F) {
        break label145;
      }
      localStringBuffer.append("--");
    }
    for (;;)
    {
      localStringBuffer.append("° ,");
      this.l.setText(localStringBuffer.toString());
      return;
      localStringBuffer.append(q.a(f2));
      break;
      label145:
      localStringBuffer.append(q.a(f1));
    }
  }
  
  public void refreshWind()
  {
    if (this.b == null) {
      return;
    }
    String str1 = this.b.k.b();
    if (!r.a(str1))
    {
      str1 = this.a.getString(2131165323);
      this.m.setText(str1);
      return;
    }
    float f1 = this.b.k.a();
    if (!r.b(f1))
    {
      this.m.setText(this.a.getString(2131166456) + str1);
      return;
    }
    String str2 = a(this.a, this.W.mSettings.b, f1);
    if (this.W.mSettings.b == 5)
    {
      this.m.setText(this.a.getString(2131166456) + str1 + " ,  " + str2);
      return;
    }
    this.m.setText(this.a.getString(2131166456) + str2 + " , " + str1);
  }
  
  public void setMyLocation(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void setThemeSwitcherVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.X.setVisibility(0);
      return;
    }
    this.X.setVisibility(8);
  }
  
  public void setTimeManager(g paramg)
  {
    this.U = paramg;
  }
  
  public void setTip(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void setWeatherBean(WeatherBean paramWeatherBean)
  {
    Object localObject;
    if (paramWeatherBean != null)
    {
      this.b = paramWeatherBean;
      localObject = paramWeatherBean.k.j();
      paramWeatherBean = paramWeatherBean.k.k();
      if ((!r.a((String)localObject)) || (!r.a(paramWeatherBean))) {}
    }
    else
    {
      try
      {
        localObject = ((String)localObject).split(":");
        this.Q = Integer.parseInt(localObject[0]);
        this.R = Integer.parseInt(localObject[1]);
        paramWeatherBean = paramWeatherBean.split(":");
        this.S = Integer.parseInt(paramWeatherBean[0]);
        this.T = Integer.parseInt(paramWeatherBean[1]);
        return;
      }
      catch (Exception paramWeatherBean)
      {
        paramWeatherBean.printStackTrace();
        return;
      }
    }
    this.Q = 6;
    this.R = 0;
    this.S = 18;
    this.T = 0;
  }
  
  public void setWidgetView(GLWeatherWidget42 paramGLWeatherWidget42)
  {
    this.W = paramGLWeatherWidget42;
  }
  
  public void showCity()
  {
    this.c.setText(this.b.d());
  }
  
  public void showDate(Time paramTime)
  {
    if (paramTime != null)
    {
      String str = P[paramTime.weekDay];
      paramTime = this.U.a(paramTime);
      this.n.setText(paramTime);
      this.o.setText(str);
    }
  }
  
  public void showFestival(Time paramTime)
  {
    if (paramTime != null)
    {
      paramTime = this.U.c(paramTime);
      if ((paramTime != null) && (!"".equals(paramTime)))
      {
        this.q.setText(paramTime);
        this.q.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.q.setVisibility(8);
  }
  
  public void showLunar(Time paramTime)
  {
    if (paramTime != null)
    {
      paramTime = this.U.d(paramTime);
      if ((paramTime != null) && (!"".equals(paramTime)))
      {
        this.p.setText(paramTime);
        this.p.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.p.setVisibility(4);
  }
  
  public void showTempNow(float paramFloat)
  {
    if (paramFloat == -10000.0F)
    {
      localObject1 = this.O.a("gw_weather_42_temp_minus");
      localObject1 = d.a(this.O.b, (String)localObject1, this.O.a);
      this.f.setVisibility(8);
      this.g.setVisibility(8);
      this.h.setVisibility(0);
      this.i.setVisibility(0);
      this.h.setImageDrawable((Drawable)localObject1);
      this.i.setImageDrawable((Drawable)localObject1);
      return;
    }
    int i1 = q.a(paramFloat);
    int i2;
    label134:
    int i3;
    if (i1 < 0)
    {
      this.f.setVisibility(0);
      i1 = Math.abs(i1);
      i2 = i1 / 100;
      if (i2 != 0) {
        break label285;
      }
      this.g.setVisibility(8);
      i3 = (i1 - i2 * 100) / 10;
      if ((i3 != 0) || (i2 != 0)) {
        break label326;
      }
      this.h.setVisibility(8);
      label163:
      this.i.setImageDrawable(d.a(this.O.b, b(i1 % 10, false), this.O.a));
      if (this.W.mSettings.a != 1) {
        break label368;
      }
    }
    label285:
    label326:
    label368:
    for (Object localObject1 = this.O.a("gw_weather_42_temp_unit_celsius");; localObject1 = this.O.a("gw_weather_42_temp_unit_fahrenheit"))
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.O.a("gw_weather_42_temp_unit");
      }
      this.j.setImageDrawable(d.a(this.O.b, (String)localObject2, this.O.a));
      return;
      this.f.setVisibility(8);
      break;
      this.g.setImageDrawable(d.a(this.O.b, b(i2, false), this.O.a));
      this.g.setVisibility(0);
      break label134;
      this.h.setImageDrawable(d.a(this.O.b, b(i3, false), this.O.a));
      this.h.setVisibility(0);
      break label163;
    }
  }
  
  public void showWeatherInfo(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    showCity();
    Object localObject = this.O.c[0];
    boolean bool = isDayTime();
    switch (this.b.k.d())
    {
    }
    for (;;)
    {
      localObject = d.a(this.O.b, (String)localObject, this.O.a);
      if (localObject != null) {
        this.d.setWeather(GLDrawable.getDrawable((Drawable)localObject), paramBoolean);
      }
      refreshTemp();
      this.k.setText(this.b.k.e());
      localObject = this.b.k.b();
      if (r.a((String)localObject)) {
        break;
      }
      localObject = this.a.getString(2131165323);
      this.m.setText((CharSequence)localObject);
      return;
      if (bool)
      {
        localObject = this.O.c[1];
      }
      else
      {
        localObject = this.O.c[2];
        continue;
        if (bool)
        {
          localObject = this.O.c[3];
        }
        else
        {
          localObject = this.O.c[4];
          continue;
          localObject = this.O.c[5];
          continue;
          localObject = this.O.c[6];
          continue;
          localObject = this.O.c[7];
          continue;
          localObject = this.O.c[8];
          continue;
          localObject = this.O.c[9];
        }
      }
    }
    float f1 = this.b.k.a();
    if (!r.b(f1))
    {
      this.m.setText(this.a.getString(2131166456) + (String)localObject);
      return;
    }
    String str = a(this.a, this.W.mSettings.b, f1);
    if (this.W.mSettings.b == 5)
    {
      this.m.setText(this.a.getString(2131166456) + (String)localObject + " ,  " + str);
      return;
    }
    this.m.setText(this.a.getString(2131166456) + str + " , " + (String)localObject);
  }
  
  public void startRefreshAni(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.L.setVisibility(8);
      this.M.setVisibility(0);
      this.M.startAnimation();
      return;
    }
    this.L.setVisibility(0);
    this.M.setVisibility(8);
    this.M.stopAnimation();
  }
  
  public void syncTime(boolean paramBoolean)
  {
    Time localTime = getCityTime();
    showDate(localTime);
    showFestival(localTime);
    showLunar(localTime);
    a(localTime.hour, localTime.minute, paramBoolean);
    a(localTime.hour, r.b(this.a));
    invalidate();
  }
  
  public void updateAllViews()
  {
    syncTime(true);
    showWeatherInfo(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeather.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */