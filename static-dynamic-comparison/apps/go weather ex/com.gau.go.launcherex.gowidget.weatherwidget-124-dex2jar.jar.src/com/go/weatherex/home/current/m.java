package com.go.weatherex.home.current;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.w;
import com.go.weatherex.home.rain.CuvetteGraphs;
import java.util.List;

public class m
  extends x
  implements View.OnClickListener
{
  private com.gau.go.launcherex.gowidget.weather.util.f b;
  private Context c;
  private String d;
  private View e;
  private TextView f;
  private TextView g;
  private View h;
  private View i;
  private TextView j;
  private Button k;
  private CuvetteGraphs l;
  private boolean m = false;
  private Time n;
  
  public m(com.go.weatherex.framework.fragment.a parama, int paramInt)
  {
    super(parama, paramInt);
    this.c = parama.getActivity().getApplicationContext();
    this.b = c.a(parama.getActivity().getApplicationContext()).h();
    this.e = parama.getActivity().getLayoutInflater().inflate(2130903084, null);
    this.f = ((TextView)this.e.findViewById(2131231145));
    this.a.a(this.f, 4, true);
    this.l = ((CuvetteGraphs)this.e.findViewById(2131231140));
    this.g = ((TextView)this.e.findViewById(2131231139));
    this.h = this.e.findViewById(2131231138);
    this.i = this.e.findViewById(2131231141);
    this.i.setOnClickListener(this);
    this.j = ((TextView)this.e.findViewById(2131231142));
    this.k = ((Button)this.e.findViewById(2131231143));
    this.k.setOnClickListener(this);
    this.n = new Time();
    this.n.setToNow();
    this.a.a(this.g, 3, true);
    this.m = c.a(this.c).e().b();
  }
  
  private void m()
  {
    if (this.a.getActivity() != null)
    {
      Intent localIntent = new Intent(this.a.getActivity(), BillingActivity.class);
      localIntent.putExtra("recommend_type", 2);
      localIntent.putExtra("recommend_enterance", 1);
      this.a.getActivity().startActivity(localIntent);
    }
  }
  
  private boolean n()
  {
    Time localTime = new Time();
    localTime.setToNow();
    if ((this.n.year == localTime.year) && (this.n.month == localTime.month) && (this.n.monthDay == localTime.monthDay)) {
      return false;
    }
    this.n.setToNow();
    return true;
  }
  
  public void a()
  {
    super.a();
    if (!n()) {
      return;
    }
    a(this.d);
  }
  
  public void a(String paramString)
  {
    this.f.setText(this.c.getResources().getString(2131165960));
    if (TextUtils.isEmpty(paramString))
    {
      this.g.setText("--%");
      return;
    }
    this.d = paramString;
    if (this.m)
    {
      this.h.setVisibility(0);
      this.i.setVisibility(8);
      Object localObject = this.b.a(paramString);
      if (localObject != null)
      {
        int i1 = ((WeatherBean)localObject).k.o();
        if ((i1 >= 0) && (i1 <= 100)) {
          localObject = i1 + "%";
        }
      }
      for (;;)
      {
        this.g.post(new n(this, (String)localObject));
        this.g.setText((CharSequence)localObject);
        this.l.a(paramString, com.go.weatherex.h.a.b(this.c, paramString), true);
        return;
        localObject = "--%";
        continue;
        localObject = "--%";
      }
    }
    this.h.setVisibility(8);
    this.i.setVisibility(0);
  }
  
  public void a(List paramList, w paramw)
  {
    super.a(paramList, paramw);
    a(this.d);
  }
  
  public void b()
  {
    super.b();
    if (!n()) {
      return;
    }
    a(this.d);
  }
  
  public void c()
  {
    super.c();
    this.m = c.a(this.c).e().b();
    a(this.d);
  }
  
  public View f()
  {
    return this.e;
  }
  
  public void g() {}
  
  public void h()
  {
    this.j.setText(this.c.getResources().getString(2131166098));
    this.k.setText(this.c.getResources().getString(2131166099));
    a(this.d);
  }
  
  public void i()
  {
    this.l.a();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.equals(this.k)) || (paramView.equals(this.i))) {
      m();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */