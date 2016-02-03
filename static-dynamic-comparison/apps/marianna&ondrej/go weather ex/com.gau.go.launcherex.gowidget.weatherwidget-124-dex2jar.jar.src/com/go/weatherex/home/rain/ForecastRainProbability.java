package com.go.weatherex.home.rain;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.d;
import com.a.a.s;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.scriptengine.parser.i;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.globalview.GoWeatherEXTextView;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.ArrayList;
import java.util.Iterator;

public class ForecastRainProbability
  extends RelativeLayout
{
  private Context a;
  private ArrayList b;
  private com.gau.go.launcherex.gowidget.weather.util.f c;
  private g d;
  private e e;
  private Time f;
  private ForecastRainProbabilityGraphs g;
  private View h;
  private TextView i;
  private TextView j;
  private View k;
  private LinearLayout.LayoutParams l = null;
  private DisplayMetrics m;
  private LinearLayout n;
  private int o;
  private String p = "";
  private boolean q = false;
  private int r = -1;
  private String[] s;
  private String t;
  private TextView u;
  private TextView v;
  private TextView w;
  private boolean x = false;
  private com.go.weatherex.framework.fragment.a y;
  
  public ForecastRainProbability(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private String a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.f.setToNow();
    this.f.set(paramInt3, paramInt2 - 1, paramInt1);
    this.f.normalize(false);
    return this.s[this.f.weekDay];
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ArrayList();
    paramContext = com.gau.go.launcherex.gowidget.weather.c.c.a(this.a.getApplicationContext());
    this.c = paramContext.h();
    this.e = paramContext.f();
    this.d = this.c.a();
    this.f = new Time();
    this.s = com.gau.go.launcherex.gowidget.weather.util.c.h(this.a);
    int i1 = this.s.length - 1;
    while (i1 > -1)
    {
      this.s[i1] = r.e(this.s[i1]);
      i1 -= 1;
    }
    this.t = r.e(this.a.getResources().getString(2131165919));
    this.m = this.a.getResources().getDisplayMetrics();
  }
  
  private void a(String paramString)
  {
    paramString = c(paramString);
    Object localObject1 = this.c.a(paramString);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((WeatherBean)localObject1).k;
      localObject3 = ((NowBean)localObject2).e();
      if (r.a((String)localObject3)) {
        break label122;
      }
      this.u.setText(this.a.getText(2131165323).toString());
      i1 = r.a(i.h, ((NowBean)localObject2).d(), a((WeatherBean)localObject1));
      this.u.setCompoundDrawablesWithIntrinsicBounds(i1, 0, 0, 0);
      i1 = ((NowBean)localObject2).o();
      if ((i1 < 0) || (i1 > 100)) {
        break label138;
      }
      this.v.setText(String.valueOf(i1));
    }
    for (;;)
    {
      if (((WeatherBean)localObject1).g != null) {
        break label150;
      }
      return;
      label122:
      this.u.setText(b((String)localObject3));
      break;
      label138:
      this.v.setText("--");
    }
    label150:
    this.b.clear();
    this.q = true;
    this.r = -1;
    localObject1 = this.d.c(((WeatherBean)localObject1).k.n());
    paramString = com.go.weatherex.h.a.b(this.a, paramString).iterator();
    int i1 = 0;
    label196:
    if (paramString.hasNext())
    {
      localObject2 = (ForecastBean)paramString.next();
      localObject3 = new ForecastBean();
      ((ForecastBean)localObject3).a(((ForecastBean)localObject2).e(), ((ForecastBean)localObject2).f(), ((ForecastBean)localObject2).g());
      ((ForecastBean)localObject3).e(((ForecastBean)localObject2).m());
      ((ForecastBean)localObject3).d(((ForecastBean)localObject2).d());
      ((ForecastBean)localObject3).c(((ForecastBean)localObject2).i());
      ((ForecastBean)localObject3).f(((ForecastBean)localObject2).h());
      if ((((ForecastBean)localObject3).m() >= 0) && (((ForecastBean)localObject3).m() <= 100)) {
        break label355;
      }
      ((ForecastBean)localObject3).e(55536);
    }
    for (;;)
    {
      if (r.a(((ForecastBean)localObject3).e(), ((ForecastBean)localObject3).f(), ((ForecastBean)localObject3).g(), (Time)localObject1)) {
        this.r = i1;
      }
      this.b.add(localObject3);
      i1 += 1;
      break label196;
      break;
      label355:
      this.q = false;
    }
  }
  
  private String b(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!"--".equals(paramString)) {}
    }
    else
    {
      str = getResources().getString(2131165323);
    }
    return str;
  }
  
  private String c(String paramString)
  {
    WeatherBean localWeatherBean = this.c.a(paramString);
    paramString = localWeatherBean;
    if (localWeatherBean == null)
    {
      ArrayList localArrayList = this.c.d();
      paramString = localWeatherBean;
      if (localArrayList != null)
      {
        paramString = localWeatherBean;
        if (localArrayList.size() > 0) {
          paramString = (WeatherBean)localArrayList.get(0);
        }
      }
    }
    if (paramString != null) {
      return paramString.c();
    }
    return null;
  }
  
  private GoWeatherEXTextView d()
  {
    GoWeatherEXTextView localGoWeatherEXTextView = new GoWeatherEXTextView(this.a);
    localGoWeatherEXTextView.setGravity(17);
    localGoWeatherEXTextView.setTextColor(-1);
    localGoWeatherEXTextView.setMaxLines(2);
    localGoWeatherEXTextView.setTextSize(0, this.a.getResources().getDimension(2131427666));
    localGoWeatherEXTextView.setVisibility(4);
    if (this.y != null) {
      this.y.a(localGoWeatherEXTextView, 4, true);
    }
    return localGoWeatherEXTextView;
  }
  
  public void a()
  {
    if (TextUtils.isEmpty(this.p)) {}
    WeatherBean localWeatherBean;
    do
    {
      return;
      localWeatherBean = this.c.a(this.p);
    } while ((localWeatherBean == null) || (localWeatherBean.k == null));
    int i1 = r.a(i.h, localWeatherBean.k.d(), a(localWeatherBean));
    this.u.setCompoundDrawablesWithIntrinsicBounds(i1, 0, 0, 0);
  }
  
  public void a(View paramView)
  {
    paramView = s.a(paramView, "alpha", new float[] { 0.0F });
    d locald = new d();
    locald.a(paramView);
    locald.c(0L);
    locald.a();
  }
  
  public void a(View paramView, int paramInt)
  {
    s locals = s.a(paramView, "translationY", new float[] { 100.0F, 0.0F });
    paramView = s.a(paramView, "alpha", new float[] { 0.0F, 1.0F });
    d locald = new d();
    locald.a(new com.a.a.a[] { locals, paramView });
    locald.b(paramInt * 150 + 450L);
    locald.c(420L);
    locald.a();
  }
  
  public void a(com.go.weatherex.framework.fragment.a parama)
  {
    this.y = parama;
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (this.p.equals(paramString)) && (this.x)) {
      return;
    }
    this.p = paramString;
    if (!this.x)
    {
      this.x = true;
      if (this.y != null)
      {
        this.y.a(this.v, 3, true);
        this.y.a(this.w, 3, true);
        this.y.a(this.u, 4, true);
      }
    }
    if (paramBoolean1)
    {
      a(this.k);
      a(this.k, 0);
    }
    a(paramString);
    if (this.b.size() == 0)
    {
      this.i.setVisibility(0);
      this.j.setVisibility(8);
      this.h.setVisibility(8);
      invalidate();
      return;
    }
    int i2;
    if (paramBoolean1)
    {
      this.h.setVisibility(4);
      this.n.removeAllViews();
      i2 = this.b.size();
      if (i2 >= 10) {
        break label621;
      }
    }
    label344:
    label479:
    label621:
    for (int i1 = i2;; i1 = 10)
    {
      this.l = new LinearLayout.LayoutParams((Math.min(this.m.widthPixels, this.m.heightPixels) - (this.n.getPaddingLeft() + this.n.getPaddingRight())) / i1, -2);
      i1 = 0;
      for (;;)
      {
        if (i1 < i2)
        {
          Object localObject = (ForecastBean)this.b.get(i1);
          if (localObject == null)
          {
            i1 += 1;
            continue;
            this.h.setVisibility(0);
            break;
          }
          GoWeatherEXTextView localGoWeatherEXTextView = d();
          int i3 = this.e.a().k;
          if ((i1 == 0) || (((ForecastBean)localObject).g() == 1))
          {
            paramString = r.a(((ForecastBean)localObject).e(), ((ForecastBean)localObject).f(), ((ForecastBean)localObject).g(), false, i3);
            if (this.r != i1) {
              break label479;
            }
            localObject = this.t;
            localGoWeatherEXTextView.setTypeface(Typeface.defaultFromStyle(1));
            localGoWeatherEXTextView.getPaint().setFakeBoldText(true);
          }
          for (;;)
          {
            localGoWeatherEXTextView.setText((String)localObject + "\n" + paramString);
            localGoWeatherEXTextView.setVisibility(0);
            this.n.addView(localGoWeatherEXTextView, this.l);
            break;
            if (((ForecastBean)localObject).g() < 10)
            {
              paramString = "0" + ((ForecastBean)localObject).g();
              break label344;
            }
            paramString = String.valueOf(((ForecastBean)localObject).g());
            break label344;
            localObject = a(((ForecastBean)localObject).e(), ((ForecastBean)localObject).f(), ((ForecastBean)localObject).g());
            localGoWeatherEXTextView.setTypeface(Typeface.defaultFromStyle(0));
            localGoWeatherEXTextView.getPaint().setFakeBoldText(false);
          }
        }
      }
      this.i.setVisibility(8);
      if (paramBoolean1)
      {
        this.h.postDelayed(new c(this, paramBoolean1), 870L);
        break;
      }
      if (this.q)
      {
        this.j.setVisibility(0);
        this.g.a(this.b, false, this.q, false);
        break;
      }
      this.j.setVisibility(8);
      this.g.a(this.b, paramBoolean1, this.q, false);
      break;
    }
  }
  
  public boolean a(WeatherBean paramWeatherBean)
  {
    if (paramWeatherBean == null) {
      return true;
    }
    String str1 = paramWeatherBean.k.j();
    String str2 = paramWeatherBean.k.k();
    if ((GoWidgetApplication.b(this.a.getApplicationContext()).b()) && (this.d.d()))
    {
      int i1 = paramWeatherBean.k.n();
      return r.a(str1, str2, this.d.b(i1));
    }
    return r.a(str1, str2);
  }
  
  public void b()
  {
    a(this.p, false, true);
  }
  
  public void c()
  {
    Resources localResources = this.a.getResources();
    this.s = com.gau.go.launcherex.gowidget.weather.util.c.a(localResources);
    int i1 = this.s.length - 1;
    while (i1 > -1)
    {
      this.s[i1] = r.e(this.s[i1]);
      i1 -= 1;
    }
    this.t = r.e(localResources.getString(2131165919));
    this.i.setText(localResources.getString(2131165918));
    this.j.setText(localResources.getString(2131165984));
    b();
  }
  
  protected void onFinishInflate()
  {
    this.h = findViewById(2131231325);
    this.i = ((TextView)findViewById(2131231324));
    this.j = ((TextView)findViewById(2131231327));
    this.u = ((TextView)findViewById(2131231321));
    this.v = ((TextView)findViewById(2131231322));
    this.w = ((TextView)findViewById(2131231323));
    this.k = findViewById(2131231320);
    this.g = ((ForecastRainProbabilityGraphs)findViewById(2131231326));
    this.n = ((LinearLayout)findViewById(2131231328));
    int i1 = this.n.getPaddingLeft();
    this.o = ((Math.min(this.a.getResources().getDisplayMetrics().widthPixels, this.a.getResources().getDisplayMetrics().heightPixels) - this.h.getPaddingLeft() - this.h.getPaddingRight() - i1) / 10);
    this.g.a(this.o);
    this.g.b(i1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/rain/ForecastRainProbability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */