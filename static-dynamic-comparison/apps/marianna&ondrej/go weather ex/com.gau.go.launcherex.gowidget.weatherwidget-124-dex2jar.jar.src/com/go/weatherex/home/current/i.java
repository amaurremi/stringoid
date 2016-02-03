package com.go.weatherex.home.current;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.statistics.r;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.view.MapDetailActivity;

public class i
  extends x
  implements View.OnClickListener
{
  private View b;
  private Context c = this.a.getActivity();
  private WeatherBean d;
  private TextView e;
  
  public i(com.go.weatherex.framework.fragment.a parama, int paramInt)
  {
    super(parama, paramInt);
    this.b = parama.i().a(2130903082, null);
    this.b.setClickable(true);
    this.b.setOnClickListener(this);
    this.e = ((TextView)this.b.findViewById(2131231145));
    this.a.a(this.e, 4, true);
    o();
  }
  
  private void b(String paramString)
  {
    r.a(m()).a(new com.gau.go.launcherex.gowidget.statistics.a.a(93, paramString));
  }
  
  private Context m()
  {
    return this.c.getApplicationContext();
  }
  
  private void n()
  {
    boolean bool2 = true;
    if (this.d == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("cityId", this.d.c());
    NowBean localNowBean = this.d.k;
    Intent localIntent = new Intent(this.a.getActivity(), MapDetailActivity.class);
    String str = this.d.d();
    double d1 = localNowBean.w();
    double d2 = localNowBean.v();
    boolean bool1;
    if (localNowBean.x() == 1)
    {
      bool1 = true;
      if (localNowBean.y() != 1) {
        break label151;
      }
    }
    for (;;)
    {
      MapDetailActivity.a(localIntent, str, d1, d2, bool1, bool2);
      localIntent.putExtras(localBundle);
      this.a.getActivity().startActivity(localIntent);
      b("c000_radio");
      return;
      bool1 = false;
      break;
      label151:
      bool2 = false;
    }
  }
  
  private void o()
  {
    this.e.setText(this.c.getString(2131165961));
  }
  
  public void a(String paramString)
  {
    this.d = com.gau.go.launcherex.gowidget.weather.util.f.a(m()).a(paramString);
  }
  
  public View f()
  {
    return this.b;
  }
  
  public void g() {}
  
  public void h()
  {
    o();
  }
  
  public void i() {}
  
  public void j()
  {
    super.j();
  }
  
  public void k()
  {
    super.k();
  }
  
  public void onClick(View paramView)
  {
    n();
    l();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */