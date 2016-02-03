package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.f.d;
import com.gau.go.launcherex.gowidget.weather.f.f;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import com.gau.go.launcherex.gowidget.weather.util.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.GoWidgetDynamicIconView;
import com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a.b;
import com.jiubang.core.a.l;
import java.util.HashMap;

public class bg
  extends dg
  implements View.OnClickListener, View.OnLongClickListener, b
{
  private static String[] R = null;
  private ImageView A;
  private ImageView B;
  private ImageView C;
  private ImageView D;
  private ImageView E;
  private ImageView F;
  private Animation G;
  private Animation H;
  private Animation I;
  private int J;
  private int K;
  private ImageView L;
  private FrameLayout M = null;
  private ImageView N;
  private ProgressBar O;
  private ImageView P;
  private com.gau.go.launcherex.gowidget.weather.f.a Q = null;
  private int S;
  private int T;
  private int U;
  private int V;
  private g W = null;
  private WeatherWidget42 Z;
  private WeatherBean a = null;
  private WidgetThemeSwitcher aa;
  private TextView d = null;
  private GoWidgetDynamicIconView e = null;
  private LinearLayout f = null;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  private ImageView j;
  private ImageView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p = null;
  private TextView q = null;
  private TextView r = null;
  private LinearLayout s = null;
  private LinearLayout t = null;
  private LinearLayout u = null;
  private LinearLayout v = null;
  private LinearLayout w = null;
  private ImageView x = null;
  private ImageView y;
  private ImageView z;
  
  public bg(Context paramContext)
  {
    super(paramContext, dh.a);
    a(paramContext);
    o();
  }
  
  private static String a(Context paramContext, int paramInt, float paramFloat)
  {
    paramContext = paramContext.getResources();
    if (paramInt == 1) {
      return String.format(paramContext.getString(2131165809), new Object[] { Float.valueOf(q.c(paramFloat, 1)) });
    }
    if (paramInt == 4) {
      return String.format(paramContext.getString(2131165812), new Object[] { Float.valueOf(q.e(paramFloat, 1)) });
    }
    if (paramInt == 3) {
      return String.format(paramContext.getString(2131165811), new Object[] { Float.valueOf(q.d(paramFloat, 1)) });
    }
    if (paramInt == 5) {
      return String.format(paramContext.getString(2131165813), new Object[] { Integer.valueOf(q.a(paramFloat)) });
    }
    if (paramInt == 6) {
      return String.format(paramContext.getString(2131165814), new Object[] { Float.valueOf(q.f(paramFloat, 1)) });
    }
    return String.format(paramContext.getString(2131165810), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.d.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.o.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.p.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.r.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.q.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.l.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.m.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.n.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.a == null) {}
    while (((paramInt1 != this.S) || (paramInt2 != this.T)) && ((paramInt1 != this.U) || (paramInt2 != this.V))) {
      return;
    }
    a(null, false, false, true);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramInt1, paramInt2);
    int i1 = paramInt1;
    if (!r.b(this.b))
    {
      paramInt1 %= 12;
      i1 = paramInt1;
      if (paramInt1 == 0) {
        i1 = 12;
      }
    }
    if ((paramBoolean) && (this.J != i1))
    {
      this.J = i1;
      this.A.setImageDrawable(d.a(this.Q.b, b(i1 / 10, true), this.Q.a));
      this.B.setImageDrawable(d.a(this.Q.b, b(i1 % 10, true), this.Q.a));
      this.u.setVisibility(0);
      this.t.startAnimation(this.I);
      this.u.startAnimation(this.G);
    }
    while ((paramBoolean) && (this.K != paramInt2))
    {
      this.K = paramInt2;
      this.E.setImageDrawable(d.a(this.Q.b, b(paramInt2 / 10, true), this.Q.a));
      this.F.setImageDrawable(d.a(this.Q.b, b(paramInt2 % 10, true), this.Q.a));
      this.w.setVisibility(0);
      this.v.startAnimation(this.I);
      this.w.startAnimation(this.H);
      return;
      this.J = i1;
      this.y.setImageDrawable(d.a(this.Q.b, b(i1 / 10, true), this.Q.a));
      this.z.setImageDrawable(d.a(this.Q.b, b(i1 % 10, true), this.Q.a));
    }
    this.K = paramInt2;
    this.C.setImageDrawable(d.a(this.Q.b, b(paramInt2 / 10, true), this.Q.a));
    this.D.setImageDrawable(d.a(this.Q.b, b(paramInt2 % 10, true), this.Q.a));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.L.setVisibility(8);
      return;
    }
    String str;
    if ((paramInt >= 0) && (paramInt < 12))
    {
      str = this.Q.a("gw_weather_42_time_am");
      this.L.setImageDrawable(d.a(this.Q.b, str, this.Q.a));
    }
    for (;;)
    {
      this.L.setVisibility(0);
      return;
      str = this.Q.a("gw_weather_42_time_pm");
      this.L.setImageDrawable(d.a(this.Q.b, str, this.Q.a));
    }
  }
  
  private void a(Context paramContext)
  {
    this.Q = new com.gau.go.launcherex.gowidget.weather.f.a();
    this.Q.a = paramContext.getPackageName();
    this.Q.b = paramContext.getResources();
    this.Q.d = new String[] { "gw_weather_42_time_num0_w", "gw_weather_42_time_num1_w", "gw_weather_42_time_num2_w", "gw_weather_42_time_num3_w", "gw_weather_42_time_num4_w", "gw_weather_42_time_num5_w", "gw_weather_42_time_num6_w", "gw_weather_42_time_num7_w", "gw_weather_42_time_num8_w", "gw_weather_42_time_num9_w" };
    this.Q.e = new String[] { "gw_weather_42_temp_num0_w", "gw_weather_42_temp_num1_w", "gw_weather_42_temp_num2_w", "gw_weather_42_temp_num3_w", "gw_weather_42_temp_num4_w", "gw_weather_42_temp_num5_w", "gw_weather_42_temp_num6_w", "gw_weather_42_temp_num7_w", "gw_weather_42_temp_num8_w", "gw_weather_42_temp_num9_w" };
    this.Q.c = new String[] { "gowidget_42_weather_na", "gowidget_42_weather_sunny_day", "gowidget_42_weather_sunny_night", "gowidget_42_weather_cloudy_day", "gowidget_42_weather_cloudy_night", "gowidget_42_weather_overcast", "gowidget_42_weather_snowy", "gowidget_42_weather_foggy", "gowidget_42_weather_rainy", "gowidget_42_weather_thunderstorm" };
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
    this.Q.a(paramContext);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    this.d.setTextColor(paramColorStateList);
    this.o.setTextColor(paramColorStateList);
    this.p.setTextColor(paramColorStateList);
    this.r.setTextColor(paramColorStateList);
    this.q.setTextColor(paramColorStateList);
    this.l.setTextColor(paramColorStateList);
    this.m.setTextColor(paramColorStateList);
    this.n.setTextColor(paramColorStateList);
  }
  
  private String b(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String[] arrayOfString = this.Q.d;; arrayOfString = this.Q.e)
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
  
  private void d(boolean paramBoolean)
  {
    String str = this.Q.c[0];
    boolean bool = k();
    Object localObject = str;
    if (this.a != null) {
      switch (this.a.k.d())
      {
      default: 
        localObject = str;
      }
    }
    for (;;)
    {
      localObject = d.a(this.Q.b, (String)localObject, this.Q.a);
      if (localObject != null)
      {
        localObject = f.a((Drawable)localObject);
        if (localObject != null) {
          this.e.a((Bitmap)localObject, paramBoolean);
        }
      }
      return;
      if (bool)
      {
        localObject = this.Q.c[1];
      }
      else
      {
        localObject = this.Q.c[2];
        continue;
        if (bool)
        {
          localObject = this.Q.c[3];
        }
        else
        {
          localObject = this.Q.c[4];
          continue;
          localObject = this.Q.c[5];
          continue;
          localObject = this.Q.c[6];
          continue;
          localObject = this.Q.c[7];
          continue;
          localObject = this.Q.c[8];
          continue;
          localObject = this.Q.c[9];
        }
      }
    }
  }
  
  private void o()
  {
    R = com.gau.go.launcherex.gowidget.weather.util.c.h(this.b);
    this.o = ((TextView)findViewById(2131230831));
    this.p = ((TextView)findViewById(2131232032));
    this.q = ((TextView)findViewById(2131232033));
    this.r = ((TextView)findViewById(2131232034));
    this.s = ((LinearLayout)findViewById(2131231277));
    this.x = ((ImageView)findViewById(2131231285));
    this.t = ((LinearLayout)this.s.findViewById(2131231279));
    this.u = ((LinearLayout)this.s.findViewById(2131231282));
    this.y = ((ImageView)this.t.findViewById(2131231280));
    this.z = ((ImageView)this.t.findViewById(2131231281));
    this.A = ((ImageView)this.u.findViewById(2131231283));
    this.B = ((ImageView)this.u.findViewById(2131231284));
    this.v = ((LinearLayout)this.s.findViewById(2131231287));
    this.w = ((LinearLayout)this.s.findViewById(2131231290));
    this.C = ((ImageView)this.v.findViewById(2131231288));
    this.D = ((ImageView)this.v.findViewById(2131231289));
    this.E = ((ImageView)this.w.findViewById(2131231291));
    this.F = ((ImageView)this.w.findViewById(2131231292));
    this.G = AnimationUtils.loadAnimation(this.b, 2130968620);
    this.G.setAnimationListener(new bh(this));
    this.H = AnimationUtils.loadAnimation(this.b, 2130968620);
    this.H.setAnimationListener(new bi(this));
    this.I = AnimationUtils.loadAnimation(this.b, 2130968583);
    this.L = ((ImageView)findViewById(2131232035));
    this.M = ((FrameLayout)findViewById(2131232001));
    this.N = ((ImageView)findViewById(2131232037));
    this.O = new ProgressBar(this.b);
    int i1 = (int)this.b.getResources().getDimension(2131427938);
    this.O.setLayoutParams(new FrameLayout.LayoutParams(i1, i1));
    Object localObject = getResources().getDrawable(2130838480);
    this.O.setIndeterminateDrawable((Drawable)localObject);
    this.O.setVisibility(4);
    this.M.addView(this.O);
    this.d = ((TextView)findViewById(2131231359));
    this.e = ((GoWidgetDynamicIconView)findViewById(2131231979));
    try
    {
      localObject = BitmapFactory.decodeResource(getResources(), 2130838042);
      this.e.a((Bitmap)localObject, false);
      this.f = ((LinearLayout)findViewById(2131232038));
      this.g = ((ImageView)findViewById(2131231982));
      this.h = ((ImageView)findViewById(2131231983));
      this.i = ((ImageView)findViewById(2131231984));
      this.j = ((ImageView)findViewById(2131231985));
      this.k = ((ImageView)findViewById(2131231986));
      this.l = ((TextView)findViewById(2131232039));
      this.m = ((TextView)findViewById(2131232040));
      this.n = ((TextView)findViewById(2131232041));
      this.n.setText(getResources().getString(2131166456) + "---");
      this.P = ((ImageView)findViewById(2131232036));
      this.aa = ((WidgetThemeSwitcher)findViewById(2131231998));
      this.aa.a(false);
      p();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
  }
  
  private void p()
  {
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.N.setOnClickListener(this);
    this.P.setOnClickListener(this);
    this.aa.setOnClickListener(this);
    this.d.setOnLongClickListener(this);
    this.s.setOnLongClickListener(this);
    this.e.setOnLongClickListener(this);
    this.f.setOnLongClickListener(this);
    this.l.setOnLongClickListener(this);
    this.m.setOnLongClickListener(this);
    this.n.setOnLongClickListener(this);
    this.P.setOnLongClickListener(this);
    this.o.setOnLongClickListener(this);
    this.p.setOnLongClickListener(this);
    this.q.setOnLongClickListener(this);
    this.r.setOnLongClickListener(this);
    this.M.setOnLongClickListener(this);
    this.N.setOnLongClickListener(this);
    this.O.setOnLongClickListener(this);
    this.L.setOnLongClickListener(this);
    this.aa.setOnLongClickListener(this);
  }
  
  public int a()
  {
    return 2130903339;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == -10000.0F)
    {
      localObject1 = this.Q.a("gw_weather_42_temp_minus");
      localObject1 = d.a(this.Q.b, (String)localObject1, this.Q.a);
      this.g.setVisibility(8);
      this.h.setVisibility(8);
      this.i.setVisibility(0);
      this.j.setVisibility(0);
      this.i.setImageDrawable((Drawable)localObject1);
      this.j.setImageDrawable((Drawable)localObject1);
      return;
    }
    int i1 = q.a(paramFloat);
    int i2;
    label134:
    int i3;
    if (i1 < 0)
    {
      this.g.setVisibility(0);
      i1 = Math.abs(i1);
      i2 = i1 / 100;
      if (i2 != 0) {
        break label285;
      }
      this.h.setVisibility(8);
      i3 = (i1 - i2 * 100) / 10;
      if ((i3 != 0) || (i2 != 0)) {
        break label326;
      }
      this.i.setVisibility(8);
      label163:
      this.j.setImageDrawable(d.a(this.Q.b, b(i1 % 10, false), this.Q.a));
      if (this.Z.c.a != 1) {
        break label368;
      }
    }
    label285:
    label326:
    label368:
    for (Object localObject1 = this.Q.a("gw_weather_42_temp_unit_celsius");; localObject1 = this.Q.a("gw_weather_42_temp_unit_fahrenheit"))
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.Q.a("gw_weather_42_temp_unit");
      }
      this.k.setImageDrawable(d.a(this.Q.b, (String)localObject2, this.Q.a));
      return;
      this.g.setVisibility(8);
      break;
      this.h.setImageDrawable(d.a(this.Q.b, b(i2, false), this.Q.a));
      this.h.setVisibility(0);
      break label134;
      this.i.setImageDrawable(d.a(this.Q.b, b(i3, false), this.Q.a));
      this.i.setVisibility(0);
      break label163;
    }
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(Time paramTime)
  {
    if (paramTime != null)
    {
      String str = R[paramTime.weekDay];
      paramTime = this.W.a(paramTime);
      this.o.setText(paramTime);
      this.p.setText(str);
    }
  }
  
  public void a(g paramg)
  {
    this.W = paramg;
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.f.a parama)
  {
    this.Q = parama;
    Object localObject1 = parama.c[0];
    localObject1 = d.a(parama.b, (String)localObject1, parama.a);
    if (localObject1 != null)
    {
      localObject1 = f.a((Drawable)localObject1);
      if (localObject1 != null) {
        this.e.a((Bitmap)localObject1, false);
      }
    }
    localObject1 = parama.a("gw_weather_42_temp_minus");
    localObject1 = d.a(parama.b, (String)localObject1, parama.a);
    this.i.setImageDrawable((Drawable)localObject1);
    this.j.setImageDrawable((Drawable)localObject1);
    this.g.setImageDrawable((Drawable)localObject1);
    localObject1 = parama.a("gw_weather_42_time_bg");
    this.s.setBackgroundDrawable(d.a(parama.b, (String)localObject1, parama.a));
    localObject1 = parama.a("gw_weather_42_time_divider");
    this.x.setImageDrawable(d.a(parama.b, (String)localObject1, parama.a));
    if (this.Z.c.a == 1) {
      localObject1 = parama.a("gw_weather_42_temp_unit_celsius");
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = parama.a("gw_weather_42_temp_unit");
      }
      this.k.setImageDrawable(d.a(parama.b, (String)localObject2, parama.a));
      localObject1 = parama.a("gw_weather_42_txt_selector");
      localObject1 = com.gau.go.launcherex.gowidget.weather.f.c.b(parama.b, (String)localObject1, parama.a);
      a((ColorStateList)localObject1);
      try
      {
        a(d.a(parama.a("gw_weather_42_txt_shadow_color"), 16777215), Float.parseFloat(parama.a("gw_weather_42_txt_shadow_dx")), Float.parseFloat(parama.a("gw_weather_42_txt_shadow_dy")), Float.parseFloat(parama.a("gw_weather_42_txt_shadow_radius")));
        if (localObject1 != null)
        {
          if ((((ColorStateList)localObject1).getDefaultColor() & 0xFFFFFF) < 8388607) {
            this.aa.a(false);
          }
        }
        else
        {
          localObject1 = parama.a("gw_weather_42_theme_setting_selector");
          localObject1 = d.a(parama.b, (String)localObject1, parama.a);
          if (localObject1 == null) {
            break label640;
          }
          this.P.setVisibility(0);
          this.P.setImageDrawable((Drawable)localObject1);
          int i1 = this.N.getVisibility();
          localObject1 = parama.a("gw_weather_42_refresh_selector");
          this.N.setBackgroundDrawable(null);
          this.N.setBackgroundDrawable(d.a(parama.b, (String)localObject1, parama.a));
          this.N.setVisibility(i1);
          i1 = this.O.getVisibility();
          this.M.removeView(this.O);
          this.O = new ProgressBar(this.b);
          localObject1 = parama.a("refresh_progress_42");
          parama = d.a(parama.b, (String)localObject1, parama.a);
          int i2 = (int)this.b.getResources().getDimension(2131427938);
          this.O.setLayoutParams(new FrameLayout.LayoutParams(i2, i2));
          this.O.setIndeterminateDrawable(parama);
          this.O.setVisibility(i1);
          this.M.addView(this.O);
          this.t.clearAnimation();
          this.u.clearAnimation();
          this.v.clearAnimation();
          this.w.clearAnimation();
          this.u.setVisibility(8);
          this.w.setVisibility(8);
          a(false);
          a(null, false, false, false);
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
          this.aa.a(true);
          continue;
          label640:
          this.P.setVisibility(4);
        }
      }
    }
  }
  
  public void a(WeatherBean paramWeatherBean)
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
        this.S = Integer.parseInt(localObject[0]);
        this.T = Integer.parseInt(localObject[1]);
        paramWeatherBean = paramWeatherBean.split(":");
        this.U = Integer.parseInt(paramWeatherBean[0]);
        this.V = Integer.parseInt(paramWeatherBean[1]);
        return;
      }
      catch (Exception paramWeatherBean)
      {
        paramWeatherBean.printStackTrace();
        return;
      }
    }
    this.S = 6;
    this.T = 0;
    this.U = 18;
    this.V = 0;
  }
  
  public void a(WeatherWidget42 paramWeatherWidget42)
  {
    this.Z = paramWeatherWidget42;
  }
  
  public void a(b paramb, l paraml, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paraml != null)
    {
      if (this.a != null) {
        if (this.a.k.d() == paramInt) {
          this.e.a(paraml, paramBoolean2);
        }
      }
      while (paramInt != 1) {
        return;
      }
      this.e.a(paraml, paramBoolean2);
      return;
    }
    d(paramBoolean2);
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.a == null) {
      return;
    }
    d();
    b(parama, paramBoolean1, paramBoolean2, paramBoolean3);
    e();
    this.l.setText(this.a.k.e());
    parama = this.a.k.b();
    if (!r.a(parama))
    {
      parama = this.b.getString(2131165323);
      this.n.setText(parama);
      return;
    }
    float f1 = this.a.k.a();
    if (!r.b(f1))
    {
      this.n.setText(this.b.getString(2131166456) + parama);
      return;
    }
    String str = a(this.b, this.Z.c.b, f1);
    if (this.Z.c.b == 5)
    {
      this.n.setText(this.b.getString(2131166456) + parama + " ,  " + str);
      return;
    }
    this.n.setText(this.b.getString(2131166456) + str + " , " + parama);
  }
  
  public void a(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    Time localTime = c();
    a(localTime);
    b(localTime);
    c(localTime);
    a(localTime.hour, localTime.minute, paramBoolean);
    a(localTime.hour, r.b(this.b));
    invalidate();
  }
  
  public int b()
  {
    if (this.a != null) {
      return this.a.k.n();
    }
    return 55536;
  }
  
  public void b(Time paramTime)
  {
    if (paramTime != null)
    {
      paramTime = this.W.c(paramTime);
      if (!TextUtils.isEmpty(paramTime))
      {
        this.r.setText(paramTime);
        this.r.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.r.setVisibility(8);
  }
  
  public void b(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = this.Q.c[0];
    boolean bool = k();
    int i1;
    if (this.a != null)
    {
      i1 = this.a.k.d();
      switch (this.a.k.d())
      {
      }
    }
    for (;;)
    {
      localObject = d.a(this.Q.b, (String)localObject, this.Q.a);
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
          if (bool)
          {
            localObject = this.Q.c[1];
            break;
          }
          localObject = this.Q.c[2];
          break;
          if (bool)
          {
            localObject = this.Q.c[3];
            break;
          }
          localObject = this.Q.c[4];
          break;
          localObject = this.Q.c[5];
          break;
          localObject = this.Q.c[6];
          break;
          localObject = this.Q.c[7];
          break;
          localObject = this.Q.c[8];
          break;
          localObject = this.Q.c[9];
          break;
          this.e.a((l)localObject, true);
          return;
        } while (localObject == null);
        parama = f.a((Drawable)localObject);
      } while (parama == null);
      this.e.a(parama, paramBoolean3);
      return;
      i1 = 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.N.setVisibility(4);
      this.O.setVisibility(0);
      return;
    }
    this.O.setVisibility(4);
    this.N.setVisibility(0);
  }
  
  public Time c()
  {
    if (this.a != null) {
      return this.W.b(b());
    }
    return this.W.c();
  }
  
  public void c(Time paramTime)
  {
    if (paramTime != null)
    {
      paramTime = this.W.d(paramTime);
      if (!TextUtils.isEmpty(paramTime))
      {
        this.q.setText(paramTime);
        this.q.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.q.setVisibility(4);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.aa.setVisibility(0);
      return;
    }
    this.aa.setVisibility(8);
  }
  
  public void d()
  {
    this.d.setText(this.a.d());
  }
  
  public void e()
  {
    if (this.a == null) {
      return;
    }
    int i1 = this.Z.c.a;
    a(this.a.k.a(i1));
    float f1 = this.a.k.c(i1);
    float f2 = this.a.k.b(i1);
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
      this.m.setText(localStringBuffer.toString());
      return;
      localStringBuffer.append(q.a(f2));
      break;
      label145:
      localStringBuffer.append(q.a(f1));
    }
  }
  
  public void f()
  {
    if (this.a == null) {
      return;
    }
    String str1 = this.a.k.b();
    if (!r.a(str1))
    {
      str1 = this.b.getString(2131165323);
      this.n.setText(str1);
      return;
    }
    float f1 = this.a.k.a();
    if (!r.b(f1))
    {
      this.n.setText(this.b.getString(2131166456) + str1);
      return;
    }
    String str2 = a(this.b, this.Z.c.b, f1);
    if (this.Z.c.b == 5)
    {
      this.n.setText(this.b.getString(2131166456) + str1 + " ,  " + str2);
      return;
    }
    this.n.setText(this.b.getString(2131166456) + str2 + " , " + str1);
  }
  
  public boolean g()
  {
    return TextUtils.isEmpty(h());
  }
  
  public String h()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.c();
  }
  
  public int i()
  {
    return this.a.e();
  }
  
  public WeatherBean j()
  {
    return this.a;
  }
  
  public boolean k()
  {
    if (this.a == null) {
      return true;
    }
    String str1 = this.a.k.j();
    String str2 = this.a.k.k();
    if (this.W.d())
    {
      int i1 = this.a.k.n();
      return r.a(str1, str2, this.W.b(i1));
    }
    return r.a(str1, str2);
  }
  
  public void l()
  {
    a(true);
    a(this.Z.getDynamicIconManager(), this.Z.b, this.Z.c.g, true);
  }
  
  public void m()
  {
    this.aa.a();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.equals(this.e)) || (paramView.equals(this.d)) || (paramView.equals(this.f)) || (paramView.equals(this.l)) || (paramView.equals(this.m)) || (paramView.equals(this.n))) {
      this.Z.gotoWeatherDetail(h());
    }
    do
    {
      return;
      if ((paramView.equals(this.o)) || (paramView.equals(this.p)) || (paramView.equals(this.q)) || (paramView.equals(this.r)))
      {
        this.Z.gotoCalendar();
        return;
      }
      if (paramView.equals(this.s))
      {
        this.Z.gotoClock();
        return;
      }
      if (paramView.equals(this.N))
      {
        this.Z.doRefresh();
        return;
      }
      if (paramView.equals(this.P))
      {
        this.Z.gotoThemeSetting();
        return;
      }
    } while (!paramView.equals(this.aa));
    this.Z.onThemeSwitcherClick();
  }
  
  public boolean onLongClick(View paramView)
  {
    performLongClick();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */