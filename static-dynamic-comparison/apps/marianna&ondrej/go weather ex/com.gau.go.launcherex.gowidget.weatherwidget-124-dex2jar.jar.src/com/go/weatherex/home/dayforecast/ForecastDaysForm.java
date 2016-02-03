package com.go.weatherex.home.dayforecast;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.ArrayList;

public class ForecastDaysForm
  extends FrameLayout
{
  private Context a;
  private String b;
  private String[] c;
  private Time d;
  private Time e;
  private f f;
  private com.gau.go.launcherex.gowidget.weather.c.e g;
  private g h;
  private LayoutInflater i;
  private ArrayList j = new ArrayList();
  private ForecastDaysColumn k;
  private View l;
  private View m;
  private ListView n;
  private com.jiubang.a.a.e o;
  private String p = "";
  private boolean q = false;
  
  public ForecastDaysForm(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
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
    paramContext = com.gau.go.launcherex.gowidget.weather.c.c.a(paramContext);
    this.f = paramContext.h();
    this.g = paramContext.f();
    this.h = paramContext.g();
    this.d = new Time();
    b(this.a);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    paramString = this.f.a(paramString);
    if ((paramString != null) && (paramString.g != null))
    {
      this.j.clear();
      this.e = this.h.c(paramString.k.n());
      this.j = com.go.weatherex.h.a.b(this.a, this.p);
      this.o.notifyDataSetChanged();
    }
  }
  
  private void b(Context paramContext)
  {
    this.b = r.e(paramContext.getResources().getString(2131165919));
    this.c = com.gau.go.launcherex.gowidget.weather.util.c.h(paramContext);
    int i1 = this.c.length - 1;
    while (i1 > -1)
    {
      this.c[i1] = r.e(this.c[i1]);
      i1 -= 1;
    }
  }
  
  public void a()
  {
    a(this.p, false, true);
  }
  
  public void a(com.go.weatherex.framework.fragment.a parama)
  {
    if (this.k != null) {
      this.k.a(parama);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramBoolean2) && (this.p.equals(paramString)) && (this.q))) {
      return;
    }
    this.p = paramString;
    this.q = true;
    if (paramBoolean1)
    {
      this.o.a(280L, 130L, 420L, 50.0F);
      a(this.p, paramBoolean1);
      if (this.j.isEmpty()) {
        break label130;
      }
      this.l.setVisibility(8);
      this.m.setVisibility(0);
      this.k.a(paramString, paramBoolean1, this.j);
    }
    for (;;)
    {
      invalidate();
      return;
      this.o.a(0L, 0L, 0L, 0.0F);
      break;
      label130:
      this.m.setVisibility(8);
      this.l.setVisibility(0);
    }
  }
  
  public void b()
  {
    Resources localResources = this.a.getResources();
    this.c = com.gau.go.launcherex.gowidget.weather.util.c.a(localResources);
    int i1 = this.c.length - 1;
    while (i1 > -1)
    {
      this.c[i1] = r.e(this.c[i1]);
      i1 -= 1;
    }
    this.b = r.e(localResources.getString(2131165919));
    a();
  }
  
  protected void onFinishInflate()
  {
    this.l = findViewById(2131231121);
    this.i = LayoutInflater.from(this.a);
    this.k = ((ForecastDaysColumn)findViewById(2131231313));
    this.m = findViewById(2131231312);
    this.n = ((ListView)findViewById(2131231314));
    this.o = new com.jiubang.a.a.e(new e(this));
    this.o.a(this.n);
    this.n.setAdapter(this.o);
    this.n.setCacheColorHint(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/dayforecast/ForecastDaysForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */