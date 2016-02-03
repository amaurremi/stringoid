package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
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

public class bl
  extends dg
  implements View.OnClickListener, View.OnLongClickListener, b
{
  private ImageView A = null;
  private TextView B = null;
  private TextView C = null;
  private TextView D = null;
  private GoWidgetDynamicIconView E = null;
  private ImageView F = null;
  private ProgressBar G = null;
  private LinearLayout H = null;
  private LinearLayout I = null;
  private FrameLayout J = null;
  private ImageView K = null;
  private String[] L = null;
  private int M = 1;
  private com.gau.go.launcherex.gowidget.weather.f.a N = null;
  private int O;
  private int P;
  private int Q;
  private int R;
  private g S = null;
  private WeatherWidget41 T;
  private WidgetThemeSwitcher U;
  private WeatherBean a = null;
  private LinearLayout d = null;
  private LinearLayout e = null;
  private LinearLayout f = null;
  private LinearLayout g = null;
  private ImageView h;
  private ImageView i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private ImageView m;
  private ImageView n;
  private ImageView o;
  private Animation p;
  private Animation q;
  private Animation r;
  private int s;
  private int t;
  private ImageView u = null;
  private ImageView v = null;
  private ImageView w = null;
  private ImageView x = null;
  private ImageView y = null;
  private ImageView z = null;
  
  public bl(Context paramContext)
  {
    super(paramContext, dh.a);
    a(paramContext);
    l();
  }
  
  private String a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String[] arrayOfString = this.N.d;; arrayOfString = this.N.e)
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
  
  private void a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.D.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.B.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    this.C.setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.a == null) {}
    while (((paramInt1 != this.O) || (paramInt2 != this.P)) && ((paramInt1 != this.Q) || (paramInt2 != this.R))) {
      return;
    }
    a(null, false, false, false);
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
        i1 = paramInt1 + 12;
      }
    }
    if ((paramBoolean) && (this.s != i1))
    {
      this.s = i1;
      this.j.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, a(i1 / 10, true), this.N.a));
      this.k.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, a(i1 % 10, true), this.N.a));
      this.e.setVisibility(0);
      this.d.startAnimation(this.r);
      this.e.startAnimation(this.p);
    }
    while ((paramBoolean) && (this.t != paramInt2))
    {
      this.t = paramInt2;
      this.n.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, a(paramInt2 / 10, true), this.N.a));
      this.o.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, a(paramInt2 % 10, true), this.N.a));
      this.g.setVisibility(0);
      this.f.startAnimation(this.r);
      this.g.startAnimation(this.q);
      return;
      this.s = i1;
      this.h.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, a(i1 / 10, true), this.N.a));
      this.i.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, a(i1 % 10, true), this.N.a));
    }
    this.t = paramInt2;
    this.l.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, a(paramInt2 / 10, true), this.N.a));
    this.m.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, a(paramInt2 % 10, true), this.N.a));
  }
  
  private void a(Context paramContext)
  {
    this.N = new com.gau.go.launcherex.gowidget.weather.f.a();
    this.N.a = paramContext.getPackageName();
    this.N.b = paramContext.getResources();
    this.N.d = new String[] { "gw_weather_42_time_num0_w", "gw_weather_42_time_num1_w", "gw_weather_42_time_num2_w", "gw_weather_42_time_num3_w", "gw_weather_42_time_num4_w", "gw_weather_42_time_num5_w", "gw_weather_42_time_num6_w", "gw_weather_42_time_num7_w", "gw_weather_42_time_num8_w", "gw_weather_42_time_num9_w" };
    this.N.e = new String[] { "gw_weather_42_temp_num0_w", "gw_weather_42_temp_num1_w", "gw_weather_42_temp_num2_w", "gw_weather_42_temp_num3_w", "gw_weather_42_temp_num4_w", "gw_weather_42_temp_num5_w", "gw_weather_42_temp_num6_w", "gw_weather_42_temp_num7_w", "gw_weather_42_temp_num8_w", "gw_weather_42_temp_num9_w" };
    this.N.c = new String[] { "gowidget_42_weather_na", "gowidget_42_weather_sunny_day", "gowidget_42_weather_sunny_night", "gowidget_42_weather_cloudy_day", "gowidget_42_weather_cloudy_night", "gowidget_42_weather_overcast", "gowidget_42_weather_snowy", "gowidget_42_weather_foggy", "gowidget_42_weather_rainy", "gowidget_42_weather_thunderstorm" };
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
    this.N.a(paramContext);
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    this.D.setTextColor(paramColorStateList);
    this.B.setTextColor(paramColorStateList);
    this.C.setTextColor(paramColorStateList);
  }
  
  private void d(int paramInt)
  {
    if (r.b(this.b))
    {
      this.v.setVisibility(8);
      return;
    }
    if ((paramInt >= 0) && (paramInt < 12)) {
      if (this.N != null) {
        this.v.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, this.N.a("gw_weather_41_time_am"), this.N.a));
      }
    }
    for (;;)
    {
      this.v.setVisibility(0);
      return;
      this.v.setImageResource(2130838100);
      continue;
      if (this.N != null)
      {
        Drawable localDrawable = com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, this.N.a("gw_weather_41_time_pm"), this.N.a);
        this.v.setImageDrawable(localDrawable);
      }
      else
      {
        this.v.setImageResource(2130838102);
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    String str = this.N.c[0];
    boolean bool = j();
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
      localObject = com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, (String)localObject, this.N.a);
      if (localObject != null)
      {
        localObject = f.a((Drawable)localObject);
        if (localObject != null) {
          this.E.a((Bitmap)localObject, paramBoolean);
        }
      }
      return;
      if (bool)
      {
        localObject = this.N.c[1];
      }
      else
      {
        localObject = this.N.c[2];
        continue;
        if (bool)
        {
          localObject = this.N.c[3];
        }
        else
        {
          localObject = this.N.c[4];
          continue;
          localObject = this.N.c[5];
          continue;
          localObject = this.N.c[6];
          continue;
          localObject = this.N.c[7];
          continue;
          localObject = this.N.c[8];
          continue;
          localObject = this.N.c[9];
        }
      }
    }
  }
  
  private void l()
  {
    this.u = ((ImageView)findViewById(2131232009));
    this.d = ((LinearLayout)findViewById(2131231279));
    this.h = ((ImageView)this.d.findViewById(2131232005));
    this.i = ((ImageView)this.d.findViewById(2131232006));
    this.e = ((LinearLayout)findViewById(2131231282));
    this.j = ((ImageView)this.e.findViewById(2131232007));
    this.k = ((ImageView)this.e.findViewById(2131232008));
    this.f = ((LinearLayout)findViewById(2131231287));
    this.l = ((ImageView)this.f.findViewById(2131232010));
    this.m = ((ImageView)this.f.findViewById(2131232011));
    this.g = ((LinearLayout)findViewById(2131231290));
    this.n = ((ImageView)this.g.findViewById(2131232012));
    this.o = ((ImageView)this.g.findViewById(2131232013));
    this.p = AnimationUtils.loadAnimation(this.b, 2130968620);
    this.p.setAnimationListener(new bm(this));
    this.q = AnimationUtils.loadAnimation(this.b, 2130968620);
    this.q.setAnimationListener(new bn(this));
    this.r = AnimationUtils.loadAnimation(this.b, 2130968583);
    this.v = ((ImageView)findViewById(2131232003));
    this.F = ((ImageView)findViewById(2131232002));
    this.w = ((ImageView)findViewById(2131231990));
    this.x = ((ImageView)findViewById(2131231991));
    this.y = ((ImageView)findViewById(2131231992));
    this.z = ((ImageView)findViewById(2131231993));
    this.A = ((ImageView)findViewById(2131231994));
    this.K = ((ImageView)findViewById(2131232000));
    this.K.setOnClickListener(this);
    this.J = ((FrameLayout)findViewById(2131232001));
    this.G = new ProgressBar(this.b);
    float f1 = this.b.getResources().getDisplayMetrics().density;
    this.G.setLayoutParams(new FrameLayout.LayoutParams((int)(18.0F * f1), (int)(f1 * 18.0F)));
    Object localObject = getResources().getDrawable(2130838480);
    this.G.setIndeterminateDrawable((Drawable)localObject);
    this.G.setVisibility(4);
    this.J.addView(this.G);
    this.B = ((TextView)findViewById(2131232015));
    this.C = ((TextView)findViewById(2131232016));
    this.D = ((TextView)findViewById(2131231995));
    this.E = ((GoWidgetDynamicIconView)findViewById(2131231987));
    try
    {
      localObject = BitmapFactory.decodeResource(getResources(), 2130838042);
      this.E.a((Bitmap)localObject, false);
      this.H = ((LinearLayout)findViewById(2131231989));
      this.I = ((LinearLayout)findViewById(2131232004));
      this.U = ((WidgetThemeSwitcher)findViewById(2131231998));
      this.U.a(false);
      m();
      this.L = com.gau.go.launcherex.gowidget.weather.util.c.h(this.b);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
  }
  
  private void m()
  {
    this.F.setOnClickListener(this);
    this.I.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.U.setOnClickListener(this);
    this.D.setOnLongClickListener(this);
    this.F.setOnLongClickListener(this);
    this.v.setOnLongClickListener(this);
    this.I.setOnLongClickListener(this);
    this.E.setOnLongClickListener(this);
    this.H.setOnLongClickListener(this);
    this.B.setOnLongClickListener(this);
    this.C.setOnLongClickListener(this);
    this.J.setOnLongClickListener(this);
    this.G.setOnLongClickListener(this);
    this.U.setOnLongClickListener(this);
  }
  
  public int a()
  {
    return 2130903331;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == -10000.0F)
    {
      localObject1 = this.N.a("gw_weather_41_temp_minus");
      localObject1 = com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, (String)localObject1, this.N.a);
      this.w.setVisibility(8);
      this.x.setVisibility(8);
      this.y.setVisibility(0);
      this.z.setVisibility(0);
      this.y.setImageDrawable((Drawable)localObject1);
      this.z.setImageDrawable((Drawable)localObject1);
      return;
    }
    int i1 = q.a(paramFloat);
    int i2;
    label134:
    int i3;
    if (i1 < 0)
    {
      this.w.setVisibility(0);
      i1 = Math.abs(i1);
      i2 = i1 / 100;
      if (i2 != 0) {
        break label279;
      }
      this.x.setVisibility(8);
      i3 = (i1 - i2 * 100) / 10;
      if ((i3 != 0) || (i2 != 0)) {
        break label320;
      }
      this.y.setVisibility(8);
      label163:
      this.z.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, a(i1 % 10, false), this.N.a));
      if (this.M != 1) {
        break label362;
      }
    }
    label279:
    label320:
    label362:
    for (Object localObject1 = this.N.a("gw_weather_41_temp_unit_celsius");; localObject1 = this.N.a("gw_weather_41_temp_unit_fahrenheit"))
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.N.a("gw_weather_41_temp_unit");
      }
      this.A.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, (String)localObject2, this.N.a));
      return;
      this.w.setVisibility(8);
      break;
      this.x.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, a(i2, false), this.N.a));
      this.x.setVisibility(0);
      break label134;
      this.y.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, a(i3, false), this.N.a));
      this.y.setVisibility(0);
      break label163;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.M = paramInt;
    a(this.a.k.a(paramInt));
    float f1 = this.a.k.c(this.M);
    float f2 = this.a.k.b(this.M);
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
      this.B.setText(localStringBuffer.toString());
      return;
      localStringBuffer.append(q.a(f2));
      break;
      label161:
      localStringBuffer.append(q.a(f1));
    }
  }
  
  public void a(Time paramTime)
  {
    if (paramTime != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(this.S.a(paramTime));
      localStringBuffer.append(" " + this.L[paramTime.weekDay]);
      this.C.setText(localStringBuffer.toString());
    }
  }
  
  public void a(g paramg)
  {
    this.S = paramg;
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.f.a parama)
  {
    this.N = parama;
    Object localObject1 = this.N.c[0];
    localObject1 = com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, (String)localObject1, this.N.a);
    if (localObject1 != null)
    {
      localObject1 = f.a((Drawable)localObject1);
      if (localObject1 != null) {
        this.E.a((Bitmap)localObject1, false);
      }
    }
    localObject1 = this.N.a("gw_weather_41_temp_minus");
    localObject1 = com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, (String)localObject1, this.N.a);
    this.y.setImageDrawable((Drawable)localObject1);
    this.z.setImageDrawable((Drawable)localObject1);
    this.w.setImageDrawable((Drawable)localObject1);
    localObject1 = parama.a("gw_weather_41_time_divider");
    this.u.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, (String)localObject1, this.N.a));
    if (this.M == 1) {
      localObject1 = this.N.a("gw_weather_41_temp_unit_celsius");
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.N.a("gw_weather_41_temp_unit");
      }
      this.A.setImageDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, (String)localObject2, this.N.a));
      localObject1 = com.gau.go.launcherex.gowidget.weather.f.c.b(this.N.b, parama.a("gw_weather_41_txt_selector"), this.N.a);
      a((ColorStateList)localObject1);
      try
      {
        a(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.a("gw_weather_41_txt_shadow_color"), 16777215), Float.parseFloat(this.N.a("gw_weather_41_txt_shadow_dx")), Float.parseFloat(this.N.a("gw_weather_41_txt_shadow_dy")), Float.parseFloat(this.N.a("gw_weather_41_txt_shadow_radius")));
        if (localObject1 != null)
        {
          if ((((ColorStateList)localObject1).getDefaultColor() & 0xFFFFFF) < 8388607) {
            this.U.a(false);
          }
        }
        else
        {
          localObject1 = this.N.a("gw_weather_41_theme_setting_selector");
          localObject1 = com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, (String)localObject1, this.N.a);
          if (localObject1 == null) {
            break label674;
          }
          this.K.setVisibility(0);
          this.K.setImageDrawable((Drawable)localObject1);
          int i1 = this.F.getVisibility();
          this.F.setBackgroundDrawable(com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, parama.a("gw_weather_41_refresh_selector"), this.N.a));
          this.F.setVisibility(i1);
          i1 = this.G.getVisibility();
          this.J.removeView(this.G);
          this.G = new ProgressBar(this.b);
          parama = parama.a("refresh_progress_41");
          parama = com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, parama, this.N.a);
          float f1 = this.b.getResources().getDisplayMetrics().density;
          this.G.setLayoutParams(new FrameLayout.LayoutParams((int)(18.0F * f1), (int)(f1 * 18.0F)));
          this.G.setIndeterminateDrawable(parama);
          this.G.setVisibility(i1);
          this.J.addView(this.G);
          this.d.clearAnimation();
          this.e.clearAnimation();
          this.f.clearAnimation();
          this.g.clearAnimation();
          this.e.setVisibility(8);
          this.g.setVisibility(8);
          a(false);
          a(null, false, false, false);
          return;
          localObject1 = this.N.a("gw_weather_41_temp_unit_fahrenheit");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          localNumberFormatException.printStackTrace();
          continue;
          this.U.a(true);
          continue;
          label674:
          this.K.setVisibility(4);
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
        this.O = Integer.parseInt(localObject[0]);
        this.P = Integer.parseInt(localObject[1]);
        paramWeatherBean = paramWeatherBean.split(":");
        this.Q = Integer.parseInt(paramWeatherBean[0]);
        this.R = Integer.parseInt(paramWeatherBean[1]);
        return;
      }
      catch (Exception paramWeatherBean)
      {
        paramWeatherBean.printStackTrace();
        return;
      }
    }
    this.O = 6;
    this.P = 0;
    this.Q = 18;
    this.R = 0;
  }
  
  public void a(WeatherWidget41 paramWeatherWidget41)
  {
    this.T = paramWeatherWidget41;
  }
  
  public void a(b paramb, l paraml, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paraml != null)
    {
      if (this.a != null) {
        if (this.a.k.d() == paramInt) {
          this.E.a(paraml, paramBoolean2);
        }
      }
      while (paramInt != 1) {
        return;
      }
      this.E.a(paraml, paramBoolean2);
      return;
    }
    d(paramBoolean2);
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.a == null) {
      return;
    }
    g();
    b(parama, paramBoolean1, paramBoolean2, paramBoolean3);
    a(this.M);
  }
  
  public void a(String paramString)
  {
    this.D.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    Time localTime = c();
    if (localTime != null)
    {
      a(localTime.hour, localTime.minute, paramBoolean);
      d(localTime.hour);
      a(localTime);
    }
  }
  
  public int b()
  {
    if (this.a != null) {
      return this.a.k.n();
    }
    return 55536;
  }
  
  public void b(int paramInt)
  {
    this.M = paramInt;
  }
  
  public void b(com.gau.go.launcherex.gowidget.weather.widget.dynamicicon.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = this.N.c[0];
    boolean bool = j();
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
      localObject = com.gau.go.launcherex.gowidget.weather.f.c.a(this.N.b, (String)localObject, this.N.a);
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
            localObject = this.N.c[1];
            break;
          }
          localObject = this.N.c[2];
          break;
          if (bool)
          {
            localObject = this.N.c[3];
            break;
          }
          localObject = this.N.c[4];
          break;
          localObject = this.N.c[5];
          break;
          localObject = this.N.c[6];
          break;
          localObject = this.N.c[7];
          break;
          localObject = this.N.c[8];
          break;
          localObject = this.N.c[9];
          break;
          this.E.a((l)localObject, true);
          return;
        } while (localObject == null);
        parama = f.a((Drawable)localObject);
      } while (parama == null);
      this.E.a(parama, paramBoolean3);
      return;
      i1 = 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.F.setVisibility(4);
      this.G.setVisibility(0);
      return;
    }
    this.F.setVisibility(0);
    this.G.setVisibility(4);
  }
  
  public Time c()
  {
    if (this.a != null) {
      return this.S.b(b());
    }
    return this.S.c();
  }
  
  public void c(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.U.setVisibility(0);
      return;
    }
    this.U.setVisibility(8);
  }
  
  public boolean d()
  {
    return TextUtils.isEmpty(e());
  }
  
  public String e()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.c();
  }
  
  public WeatherBean f()
  {
    return this.a;
  }
  
  public void g()
  {
    this.D.setText(this.a.d());
  }
  
  public void h()
  {
    a(true);
    a(this.T.getDynamicIconManager(), this.T.b, this.T.c.g, true);
  }
  
  public int i()
  {
    return this.a.e();
  }
  
  public boolean j()
  {
    if (this.a == null) {
      return true;
    }
    String str1 = this.a.k.j();
    String str2 = this.a.k.k();
    if (this.S.d())
    {
      int i1 = this.a.k.n();
      return r.a(str1, str2, this.S.b(i1));
    }
    return r.a(str1, str2);
  }
  
  public void k()
  {
    this.U.a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.K)) {
      this.T.gotoThemeStore();
    }
    do
    {
      return;
      if (paramView.equals(this.I))
      {
        this.T.gotoClock();
        return;
      }
      if ((paramView.equals(this.D)) || (paramView.equals(this.E)) || (paramView.equals(this.H)) || (paramView.equals(this.B)))
      {
        this.T.gotoWeatherDetail(e());
        return;
      }
      if (paramView.equals(this.F))
      {
        this.T.refreshWeather();
        return;
      }
      if (paramView.equals(this.C))
      {
        this.T.gotoCalendar();
        return;
      }
    } while (!paramView.equals(this.U));
    this.T.onThemeSwitcherClick();
  }
  
  public boolean onLongClick(View paramView)
  {
    performLongClick();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */