package com.go.weatherex.home.current;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.util.w;
import com.go.weatherex.framework.fragment.a;
import com.go.weatherex.home.windforecast.WindInfoBase;
import java.util.List;

public class o
  extends x
{
  private String b;
  private View c;
  private TextView d;
  private WindInfoBase e;
  
  public o(a parama, int paramInt)
  {
    super(parama, paramInt);
    this.c = LayoutInflater.from(parama.getActivity()).inflate(2130903086, null);
    this.e = ((WindInfoBase)this.c.findViewById(2131231149));
    this.e.a(this.a);
    this.d = ((TextView)this.c.findViewById(2131231145));
    this.a.a(this.d, 4, true);
    this.d.setText(2131165959);
    this.e.setBackgroundResource(2130838186);
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
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    m();
  }
  
  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
  }
  
  public View f()
  {
    return this.c;
  }
  
  public void g() {}
  
  public void h()
  {
    this.d.setText(2131165959);
    m();
  }
  
  public void i()
  {
    this.e.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */