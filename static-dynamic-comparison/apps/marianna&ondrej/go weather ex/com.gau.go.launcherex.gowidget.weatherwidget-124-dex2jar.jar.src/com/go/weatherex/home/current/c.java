package com.go.weatherex.home.current;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.util.w;
import com.go.weatherex.framework.fragment.a;
import java.util.List;

public class c
  extends x
  implements View.OnClickListener
{
  private String b;
  private View c;
  private TextView d;
  private WeatherDetailInfo e;
  
  public c(a parama, int paramInt)
  {
    super(parama, paramInt);
    this.c = LayoutInflater.from(parama.getActivity()).inflate(2130903080, null);
    this.e = ((WeatherDetailInfo)this.c.findViewById(2131231123));
    this.e.a(parama);
    this.d = ((TextView)this.c.findViewById(2131231145));
    this.d.setText(2131165902);
    this.a.a(this.d, 4, true);
    this.c.setOnClickListener(this);
  }
  
  private void m()
  {
    this.e.a(this.b);
  }
  
  public void a()
  {
    super.a();
    m();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    m();
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
    m();
  }
  
  public void a(List paramList, w paramw)
  {
    super.a(paramList, paramw);
    m();
  }
  
  public void b()
  {
    super.b();
    m();
  }
  
  public void c()
  {
    super.c();
    m();
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    m();
  }
  
  public void d(int paramInt)
  {
    super.d(paramInt);
    m();
  }
  
  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
  }
  
  public void e(int paramInt)
  {
    m();
  }
  
  public View f()
  {
    return this.c;
  }
  
  public void g() {}
  
  public void h()
  {
    this.d.setText(2131165902);
    m();
  }
  
  public void i() {}
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.c)) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */