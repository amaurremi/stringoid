package com.go.weatherex.home.dayforecast;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.scriptengine.parser.i;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.globalview.GoWeatherEXTextView;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.go.weatherex.framework.fragment.a;
import java.util.ArrayList;

public class ForecastDaysColumn
  extends LinearLayout
{
  private Context a;
  private String b;
  private String[] c;
  private Time d;
  private f e;
  private e f;
  private g g;
  private LinearLayout h;
  private ColumnGraphs i;
  private LinearLayout j;
  private a k;
  private float l;
  
  public ForecastDaysColumn(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ForecastDaysColumn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(this.a);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localImageView.setImageResource(r.a(i.h, paramInt, true));
    localImageView.setPadding(Math.round(this.l * 4.0F), 0, Math.round(this.l * 4.0F), 0);
    return localImageView;
  }
  
  private String a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d.setToNow();
    this.d.set(paramInt3, paramInt2 - 1, paramInt1);
    this.d.normalize(false);
    return this.c[this.d.weekDay];
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    com.gau.go.launcherex.gowidget.weather.c.c localc = com.gau.go.launcherex.gowidget.weather.c.c.a(paramContext);
    this.e = localc.h();
    this.f = localc.f();
    this.g = localc.g();
    this.d = new Time();
    this.l = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(String paramString, Context paramContext, ArrayList paramArrayList)
  {
    this.h.removeAllViews();
    this.j.removeAllViews();
    int i1 = paramArrayList.size();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(com.gau.go.launcherex.gowidget.weather.util.q.a((Math.min(paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels) - this.a.getResources().getDimension(2131427665) * 2.0F) / i1), -2);
    paramString = this.e.a(paramString);
    if (paramString != null) {}
    Time localTime;
    int n;
    ForecastBean localForecastBean;
    for (int m = paramString.k.n();; m = 0)
    {
      localTime = this.g.c(m);
      m = 0;
      n = 0;
      for (;;)
      {
        if (n >= i1) {
          return;
        }
        localForecastBean = (ForecastBean)paramArrayList.get(n);
        if (localForecastBean != null) {
          break;
        }
        n += 1;
      }
    }
    GoWeatherEXTextView localGoWeatherEXTextView = b();
    int i2 = this.f.a().k;
    if ((n == 0) || (localForecastBean.g() == 1))
    {
      paramString = r.a(localForecastBean.e(), localForecastBean.f(), localForecastBean.g(), false, i2);
      if ((m != 0) || (!r.a(localForecastBean.e(), localForecastBean.f(), localForecastBean.g(), localTime))) {
        break label381;
      }
      m = 1;
      paramContext = this.b;
      localGoWeatherEXTextView.setTypeface(Typeface.defaultFromStyle(1));
      localGoWeatherEXTextView.getPaint().setFakeBoldText(true);
    }
    for (;;)
    {
      localGoWeatherEXTextView.setText(paramContext + "\n" + paramString);
      localGoWeatherEXTextView.setVisibility(0);
      this.h.addView(localGoWeatherEXTextView, localLayoutParams);
      paramString = a(localForecastBean.i());
      this.j.addView(paramString, localLayoutParams);
      break;
      if (localForecastBean.g() < 10) {}
      for (paramString = "0" + localForecastBean.g();; paramString = String.valueOf(localForecastBean.g())) {
        break;
      }
      label381:
      paramContext = a(localForecastBean.e(), localForecastBean.f(), localForecastBean.g());
      localGoWeatherEXTextView.setTypeface(Typeface.defaultFromStyle(0));
      localGoWeatherEXTextView.getPaint().setFakeBoldText(false);
    }
  }
  
  private GoWeatherEXTextView b()
  {
    GoWeatherEXTextView localGoWeatherEXTextView = new GoWeatherEXTextView(this.a);
    localGoWeatherEXTextView.setGravity(17);
    localGoWeatherEXTextView.setTextColor(-1);
    localGoWeatherEXTextView.setMaxLines(2);
    localGoWeatherEXTextView.setTextSize(0, this.a.getResources().getDimension(2131427666));
    if (this.k != null) {
      this.k.a(localGoWeatherEXTextView, 4, true);
    }
    return localGoWeatherEXTextView;
  }
  
  public void a()
  {
    this.h.removeAllViews();
    this.i.a();
  }
  
  public void a(a parama)
  {
    this.k = parama;
  }
  
  public void a(String paramString, boolean paramBoolean, ArrayList paramArrayList)
  {
    this.b = r.e(this.a.getResources().getString(2131165919));
    this.c = com.gau.go.launcherex.gowidget.weather.util.c.h(this.a);
    int m = this.c.length - 1;
    while (m > -1)
    {
      this.c[m] = r.e(this.c[m]);
      m -= 1;
    }
    a(paramString, this.a, paramArrayList);
    this.i.a(paramString, paramArrayList, paramBoolean);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.i = ((ColumnGraphs)findViewById(2131231309));
    this.h = ((LinearLayout)findViewById(2131231307));
    this.j = ((LinearLayout)findViewById(2131231308));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/dayforecast/ForecastDaysColumn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */