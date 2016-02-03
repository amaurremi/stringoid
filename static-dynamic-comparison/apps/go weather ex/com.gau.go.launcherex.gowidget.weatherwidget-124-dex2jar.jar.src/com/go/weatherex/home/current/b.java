package com.go.weatherex.home.current;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.util.w;
import com.go.weatherex.home.dayforecast.ForecastDaysColumn;
import java.util.ArrayList;
import java.util.List;

public class b
  extends x
{
  private Context b;
  private ForecastDaysColumn c;
  private View d;
  private TextView e;
  private String f;
  private View g;
  private Time h;
  
  public b(com.go.weatherex.framework.fragment.a parama, int paramInt)
  {
    super(parama, paramInt);
    this.b = parama.getActivity().getApplicationContext();
    this.d = parama.getActivity().getLayoutInflater().inflate(2130903079, null);
    this.c = ((ForecastDaysColumn)this.d.findViewById(2131231120));
    this.e = ((TextView)this.d.findViewById(2131231145));
    this.a.a(this.e, 4, true);
    this.g = this.d.findViewById(2131231121);
    this.h = new Time();
    this.h.setToNow();
  }
  
  private boolean m()
  {
    Time localTime = new Time();
    localTime.setToNow();
    if ((this.h.year == localTime.year) && (this.h.month == localTime.month) && (this.h.monthDay == localTime.monthDay)) {
      return false;
    }
    this.h.setToNow();
    return true;
  }
  
  public void a()
  {
    super.a();
    if (!m()) {
      return;
    }
    a(this.f);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    a(this.f);
  }
  
  public void a(String paramString)
  {
    this.e.setText(this.b.getResources().getString(2131165958));
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.f = paramString;
    ArrayList localArrayList = com.go.weatherex.h.a.b(this.b, paramString);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      this.c.setVisibility(0);
      this.g.setVisibility(8);
      this.c.a(paramString, false, localArrayList);
      return;
    }
    this.c.setVisibility(8);
    this.g.setVisibility(0);
  }
  
  public void a(List paramList, w paramw)
  {
    super.a(paramList, paramw);
    a(this.f);
  }
  
  public void b()
  {
    super.b();
    if (!m()) {
      return;
    }
    a(this.f);
  }
  
  public void c()
  {
    super.c();
    a(this.f);
  }
  
  public void e(int paramInt)
  {
    super.e(paramInt);
    a(this.f);
  }
  
  public View f()
  {
    return this.d;
  }
  
  public void g() {}
  
  public void h()
  {
    a(this.f);
  }
  
  public void i()
  {
    this.c.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */