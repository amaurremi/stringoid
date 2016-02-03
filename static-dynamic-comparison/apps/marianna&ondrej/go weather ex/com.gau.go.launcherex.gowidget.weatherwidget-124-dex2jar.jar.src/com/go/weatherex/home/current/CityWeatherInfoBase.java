package com.go.weatherex.home.current;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.b.an;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.PollenIndexBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.ArrayList;
import java.util.List;

public class CityWeatherInfoBase
  extends LinearLayout
  implements View.OnClickListener
{
  private int A;
  private int B;
  private g C = null;
  private com.gau.go.launcherex.gowidget.weather.model.q D = null;
  private String E = "";
  private f F;
  private Context a = null;
  private int[] b = { 2130837647, 2130837651, 2130837652, 2130837644, 2130837645, 2130837648, 2130837650, 2130837646, 2130837649, 2130837653 };
  private String c = "";
  private String d = "";
  private WeatherBean e = null;
  private TextView f;
  private TextView g;
  private View h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private View m;
  private TextView n;
  private TextView o;
  private ImageView p;
  private View q;
  private TextView r;
  private TextView s;
  private View t;
  private TextView u;
  private TextView v;
  private ImageView w;
  private TextView x = null;
  private int y;
  private int z;
  
  public CityWeatherInfoBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    paramContext = c.a(this.a.getApplicationContext());
    this.F = paramContext.e();
    this.C = paramContext.g();
    this.D = paramContext.f().a();
    this.E = this.a.getText(2131165323).toString();
    setOnClickListener(this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    float f1 = this.e.k.a(paramInt);
    if (!r.b(f1))
    {
      this.f.setText("--°");
      return false;
    }
    paramInt = com.gau.go.launcherex.gowidget.weather.util.q.a(f1);
    this.f.setText(paramInt + "°");
    return true;
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
  
  private void b(int paramInt, String paramString)
  {
    float f1 = this.e.k.j(paramInt);
    if (f1 != -10000.0F)
    {
      this.n.setText(2131165899);
      this.o.setText(com.gau.go.launcherex.gowidget.weather.util.q.a(f1) + paramString);
      this.m.setVisibility(0);
      return;
    }
    this.m.setVisibility(8);
  }
  
  private void c(int paramInt, String paramString)
  {
    float f1 = this.e.k.b(paramInt);
    String str;
    if (!r.b(f1))
    {
      str = this.E;
      f1 = this.e.k.c(paramInt);
      if (r.b(f1)) {
        break label111;
      }
    }
    label111:
    for (paramString = this.E;; paramString = com.gau.go.launcherex.gowidget.weather.util.q.a(f1) + paramString)
    {
      this.i.setText(2131165341);
      this.k.setText(2131165342);
      this.j.setText(str);
      this.l.setText(paramString);
      return;
      str = com.gau.go.launcherex.gowidget.weather.util.q.a(f1) + paramString;
      break;
    }
  }
  
  private void d()
  {
    if ((!com.go.weatherex.h.a.a(this.e)) && (!an.a(this.a).b()))
    {
      a(this.a.getText(2131165772).toString());
      return;
    }
    a(null);
  }
  
  private void e()
  {
    if (this.e == null) {
      return;
    }
    int i1 = this.e.k.p();
    if ((i1 != 55536) && (i1 != 0))
    {
      this.r.setText(2131165931);
      this.s.setText(i1 + "");
      this.q.setVisibility(0);
      return;
    }
    this.q.setVisibility(8);
  }
  
  private void f()
  {
    if (this.e == null) {}
    label198:
    for (;;)
    {
      return;
      ArrayList localArrayList = this.e.i;
      if ((localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      this.u.setText(2131165938);
      this.v.setText("N/A");
      this.t.setVisibility(0);
      Time localTime = c.a(this.a.getApplicationContext()).g().c(this.e.k.n());
      int i1 = 0;
      for (;;)
      {
        if (i1 >= localArrayList.size()) {
          break label198;
        }
        PollenIndexBean localPollenIndexBean = (PollenIndexBean)localArrayList.get(i1);
        if ((localPollenIndexBean != null) && (r.a(localPollenIndexBean.b(), localPollenIndexBean.c() + 1, localPollenIndexBean.d(), localTime)))
        {
          float f1 = localPollenIndexBean.f();
          if (f1 == -10000.0F) {
            break;
          }
          f1 = Math.round(f1 * 10.0F) / 10.0F;
          this.v.setText(f1 + "");
          return;
        }
        i1 += 1;
      }
    }
    this.t.setVisibility(8);
  }
  
  private void g()
  {
    int i1 = 8;
    ImageView localImageView = this.w;
    if ((this.q.getVisibility() == 8) && (this.t.getVisibility() == 8)) {}
    for (;;)
    {
      localImageView.setVisibility(i1);
      return;
      i1 = 0;
    }
  }
  
  private void h()
  {
    if (r.a(this.q, 1000))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this.a, AirQualityIndex.class);
      localIntent.putExtra("cityId", this.c);
      ((Activity)this.a).startActivityForResult(localIntent, 0);
      ((Activity)this.a).overridePendingTransition(2130968584, 2130968606);
    }
  }
  
  private void i()
  {
    if (r.a(this.t, 1000))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this.a, PollenIndex.class);
      localIntent.putExtra("cityId", this.c);
      ((Activity)this.a).startActivityForResult(localIntent, 0);
      ((Activity)this.a).overridePendingTransition(2130968584, 2130968606);
    }
  }
  
  public void a()
  {
    int i1 = 0;
    if (this.e == null) {
      return;
    }
    this.g.setCompoundDrawablesWithIntrinsicBounds(r.a(this.b, this.e.k.d(), a(this.e)), 0, 0, 0);
    int i2 = this.D.g;
    String str;
    label63:
    boolean bool;
    Object localObject;
    if (i2 == 1)
    {
      str = "°C";
      bool = a(i2, str);
      localObject = this.e.k.e();
      if (r.a((String)localObject)) {
        break label169;
      }
      this.g.setText(this.E);
      label102:
      localObject = this.h;
      if (!bool) {
        break label185;
      }
    }
    for (;;)
    {
      ((View)localObject).setVisibility(i1);
      if (!bool) {
        break;
      }
      e();
      f();
      g();
      b();
      c(i2, str);
      b(i2, str);
      d();
      requestLayout();
      return;
      str = "°F";
      break label63;
      label169:
      this.g.setText(b((String)localObject));
      break label102;
      label185:
      i1 = 8;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      a(this.a.getText(2131165771).toString());
      return;
    case 1: 
    case 2: 
      a("");
      return;
    }
    a(this.a.getText(2131165772).toString());
  }
  
  public void a(com.go.weatherex.framework.fragment.a parama)
  {
    parama.a(this.g, 4, 0);
    parama.a(this.f, 3, 0);
    parama.a(this.n, 4, 0);
    parama.a(this.o, 2, 0);
    parama.a(this.i, 4, 0);
    parama.a(this.j, 2, 0);
    parama.a(this.k, 4, 0);
    parama.a(this.l, 2, 0);
    parama.a(this.r, 4, 0);
    parama.a(this.s, 2, 0);
    parama.a(this.u, 4, 0);
    parama.a(this.v, 2, 0);
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!com.go.weatherex.h.a.a(this.e)))
    {
      this.x.setVisibility(0);
      this.x.setText(paramString);
      return;
    }
    this.x.setVisibility(8);
  }
  
  public boolean a(WeatherBean paramWeatherBean)
  {
    if (paramWeatherBean == null) {
      return true;
    }
    String str1 = paramWeatherBean.k.j();
    String str2 = paramWeatherBean.k.k();
    if ((this.F.b()) && (this.C.d()))
    {
      int i1 = paramWeatherBean.k.n();
      return r.a(str1, str2, this.C.b(i1));
    }
    return r.a(str1, str2);
  }
  
  public void b()
  {
    if ((this.e != null) && (this.e.p()))
    {
      this.p.setVisibility(0);
      return;
    }
    this.p.setVisibility(8);
  }
  
  public void b(WeatherBean paramWeatherBean)
  {
    Object localObject;
    if (paramWeatherBean != null)
    {
      this.e = paramWeatherBean;
      a(this.e.c(), this.e.d());
      localObject = paramWeatherBean.k.j();
      paramWeatherBean = paramWeatherBean.k.k();
      if ((!r.a((String)localObject)) || (!r.a(paramWeatherBean))) {
        break label126;
      }
    }
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split(":");
        this.y = Integer.parseInt(localObject[0]);
        this.z = Integer.parseInt(localObject[1]);
        paramWeatherBean = paramWeatherBean.split(":");
        this.A = Integer.parseInt(paramWeatherBean[0]);
        this.B = Integer.parseInt(paramWeatherBean[1]);
        d();
        return;
      }
      catch (Exception paramWeatherBean)
      {
        paramWeatherBean.printStackTrace();
        continue;
      }
      label126:
      this.y = 6;
      this.z = 0;
      this.A = 18;
      this.B = 0;
    }
  }
  
  public View c()
  {
    return this.p;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.w)) {
      if (this.q.getVisibility() == 0) {
        h();
      }
    }
    do
    {
      do
      {
        return;
      } while (this.t.getVisibility() != 0);
      i();
      return;
      if (paramView.equals(this.q))
      {
        h();
        return;
      }
    } while (!paramView.equals(this.t));
    i();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.f = ((TextView)findViewById(2131231156));
    this.h = findViewById(2131231158);
    this.i = ((TextView)findViewById(2131231163));
    this.j = ((TextView)findViewById(2131231164));
    this.k = ((TextView)findViewById(2131231165));
    this.l = ((TextView)findViewById(2131231166));
    this.g = ((TextView)findViewById(2131231155));
    this.m = findViewById(2131231159);
    this.n = ((TextView)findViewById(2131231160));
    this.o = ((TextView)findViewById(2131231161));
    this.p = ((ImageView)findViewById(2131231157));
    this.q = findViewById(2131231167);
    this.r = ((TextView)findViewById(2131231168));
    this.s = ((TextView)findViewById(2131231169));
    this.q.setOnClickListener(this);
    this.t = findViewById(2131231170);
    this.u = ((TextView)findViewById(2131231171));
    this.v = ((TextView)findViewById(2131231172));
    this.t.setOnClickListener(this);
    this.w = ((ImageView)findViewById(2131231173));
    this.w.setOnClickListener(this);
    this.x = ((TextView)findViewById(2131231174));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/CityWeatherInfoBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */