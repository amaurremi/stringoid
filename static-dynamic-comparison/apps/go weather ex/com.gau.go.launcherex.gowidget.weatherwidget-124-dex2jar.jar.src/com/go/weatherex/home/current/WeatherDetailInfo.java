package com.go.weatherex.home.current;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.go.weatherex.framework.fragment.a;

public class WeatherDetailInfo
  extends RelativeLayout
{
  private Context a;
  private com.gau.go.launcherex.gowidget.weather.util.f b;
  private e c;
  private WeatherBean d;
  private com.gau.go.launcherex.gowidget.weather.model.q e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private TextView r;
  private TextView s;
  private String t;
  private String u;
  
  public WeatherDetailInfo(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WeatherDetailInfo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    this.u = this.a.getString(2131165323);
  }
  
  private void d()
  {
    Object localObject3 = this.d.k.j();
    String str = this.d.k.k();
    Object localObject1;
    if (!r.a((String)localObject3))
    {
      localObject1 = this.u;
      if (r.a(str)) {
        break label167;
      }
      localObject3 = this.u;
    }
    for (;;)
    {
      if ((!((String)localObject1).equals(this.u)) && (!((String)localObject3).equals(this.u)))
      {
        this.f.setText((CharSequence)localObject1);
        this.g.setText((CharSequence)localObject3);
      }
      return;
      localObject1 = localObject3;
      if (r.b(this.a)) {
        break;
      }
      int i1;
      StringBuffer localStringBuffer;
      try
      {
        localObject1 = ((String)localObject3).split(":");
        i1 = Integer.parseInt(localObject1[0]);
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(i1 % 12).append(":").append(localObject1[1]).append(" AM");
        localObject1 = localStringBuffer.toString();
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        localNumberFormatException1.printStackTrace();
        Object localObject2 = localObject3;
      }
      break;
      label167:
      localObject3 = str;
      if (!r.b(this.a)) {
        try
        {
          localObject3 = str.split(":");
          i1 = Integer.parseInt(localObject3[0]);
          localStringBuffer = new StringBuffer();
          localStringBuffer.append(i1 % 12).append(":").append(localObject3[1]).append(" PM");
          localObject3 = localStringBuffer.toString();
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          localNumberFormatException2.printStackTrace();
          Object localObject4 = str;
        }
      }
    }
  }
  
  private void e()
  {
    int i1 = this.d.k.c();
    View localView = (View)this.n.getParent();
    if (r.b(i1))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(i1).append("%");
      this.n.setText(localStringBuffer);
      this.h.setText(2131165905);
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void f()
  {
    float f1 = this.d.k.l();
    View localView = (View)this.r.getParent();
    if (r.b(f1))
    {
      this.r.setText(f1 + "");
      this.l.setText(2131165908);
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void g()
  {
    View localView = (View)this.s.getParent();
    if (c.a(this.a).e().b())
    {
      localView.setVisibility(8);
      return;
    }
    int i1 = this.d.k.o();
    if ((i1 >= 0) && (i1 <= 100))
    {
      this.s.setText(i1 + "%");
      this.m.setText(2131165910);
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  public void a()
  {
    float f1 = this.d.k.h();
    View localView = (View)this.o.getParent();
    if (r.b(f1))
    {
      if (this.e.A == 2) {
        f1 = com.gau.go.launcherex.gowidget.weather.util.q.i(f1, 2);
      }
      for (String str = this.a.getString(2131165799);; str = this.a.getString(2131165798))
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(f1).append(" ").append(str);
        this.o.setText(localStringBuffer);
        this.i.setText(2131165906);
        localView.setVisibility(0);
        return;
      }
    }
    localView.setVisibility(8);
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      return;
    }
    parama.a(this.f, 4, true);
    parama.a(this.g, 4, true);
    parama.a(this.h, 2, true);
    parama.a(this.i, 2, true);
    parama.a(this.j, 2, true);
    parama.a(this.k, 2, true);
    parama.a(this.l, 2, true);
    parama.a(this.m, 2, true);
    parama.a(this.n, 4, true);
    parama.a(this.o, 4, true);
    parama.a(this.p, 4, true);
    parama.a(this.q, 4, true);
    parama.a(this.r, 4, true);
    parama.a(this.s, 4, true);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.b == null)
    {
      localObject = com.gau.go.launcherex.gowidget.weather.util.f.a(this.a.getApplicationContext());
      label26:
      this.b = ((com.gau.go.launcherex.gowidget.weather.util.f)localObject);
      if (this.c != null) {
        break label149;
      }
      localObject = e.a(this.a.getApplicationContext());
      label49:
      this.c = ((e)localObject);
      if (this.e != null) {
        break label157;
      }
    }
    label149:
    label157:
    for (Object localObject = this.c.a();; localObject = this.e)
    {
      this.e = ((com.gau.go.launcherex.gowidget.weather.model.q)localObject);
      if (!paramString.equals(this.t))
      {
        this.t = paramString;
        this.d = this.b.a(this.t);
      }
      if (this.d == null) {
        break;
      }
      d();
      e();
      a();
      c();
      b();
      f();
      g();
      return;
      localObject = this.b;
      break label26;
      localObject = this.c;
      break label49;
    }
  }
  
  public void b()
  {
    float f1 = this.d.k.i();
    View localView = (View)this.p.getParent();
    if (r.b(f1))
    {
      int i1 = this.e.B;
      String str;
      if (i1 == 1)
      {
        f1 = com.gau.go.launcherex.gowidget.weather.util.q.j(f1, 1);
        str = this.a.getString(2131165801);
      }
      for (;;)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(f1).append(" ").append(str);
        this.p.setText(localStringBuffer);
        this.j.setText(2131165909);
        localView.setVisibility(0);
        return;
        if (i1 == 2)
        {
          f1 = com.gau.go.launcherex.gowidget.weather.util.q.k(f1, 1);
          str = this.a.getString(2131165802);
        }
        else if (i1 == 4)
        {
          f1 = com.gau.go.launcherex.gowidget.weather.util.q.l(f1, 1);
          str = this.a.getString(2131165804);
        }
        else if (i1 == 5)
        {
          f1 = com.gau.go.launcherex.gowidget.weather.util.q.m(f1, 1);
          str = this.a.getString(2131165805);
        }
        else if (i1 == 6)
        {
          f1 = com.gau.go.launcherex.gowidget.weather.util.q.n(f1, 1);
          str = this.a.getString(2131165807);
        }
        else
        {
          str = this.a.getString(2131165803);
        }
      }
    }
    localView.setVisibility(8);
  }
  
  public void c()
  {
    float f1 = this.d.k.f(this.e.g);
    View localView = (View)this.q.getParent();
    if (r.b(f1))
    {
      if (this.e.g == 1) {}
      for (String str = "°C";; str = "°F")
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(f1).append(str);
        this.q.setText(localStringBuffer);
        this.k.setText(2131165907);
        localView.setVisibility(0);
        return;
      }
    }
    localView.setVisibility(8);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.f = ((TextView)findViewById(2131232079));
    this.g = ((TextView)findViewById(2131232080));
    this.h = ((TextView)findViewById(2131232081));
    this.i = ((TextView)findViewById(2131232083));
    this.j = ((TextView)findViewById(2131232085));
    this.k = ((TextView)findViewById(2131232087));
    this.l = ((TextView)findViewById(2131232089));
    this.m = ((TextView)findViewById(2131232091));
    this.n = ((TextView)findViewById(2131232082));
    this.o = ((TextView)findViewById(2131232084));
    this.p = ((TextView)findViewById(2131232086));
    this.q = ((TextView)findViewById(2131232088));
    this.r = ((TextView)findViewById(2131232090));
    this.s = ((TextView)findViewById(2131232092));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/WeatherDetailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */