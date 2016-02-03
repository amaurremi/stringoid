package com.go.weatherex.home.hourforecast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.scriptengine.parser.i;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.HourlyBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.go.weatherex.home.view.DashedLinearLayout;
import java.util.ArrayList;
import java.util.Locale;

class b
  extends BaseAdapter
{
  private LayoutInflater b;
  private ArrayList c = new ArrayList();
  
  public b(ForecastHourForm paramForecastHourForm, Context paramContext)
  {
    this.b = LayoutInflater.from(paramContext);
  }
  
  private void a(int paramInt, HourlyBean paramHourlyBean, a parama)
  {
    if ((paramInt == 0) || (a(paramInt - 1).c() != paramHourlyBean.c()))
    {
      parama.a.setVisibility(0);
      if (a(paramHourlyBean))
      {
        parama.a.setText(2131165919);
        return;
      }
      StringBuffer localStringBuffer = new StringBuffer();
      paramInt = ForecastHourForm.a(this.a).a().k;
      String str = String.format(Locale.US, "%02d", new Object[] { Integer.valueOf(paramHourlyBean.b()) });
      paramHourlyBean = String.format(Locale.US, "%02d", new Object[] { Integer.valueOf(paramHourlyBean.c()) });
      if ((paramInt == 1) || (paramInt == 2))
      {
        parama.a.setText(localStringBuffer.append(str).append("/").append(paramHourlyBean));
        return;
      }
      parama.a.setText(localStringBuffer.append(paramHourlyBean).append("/").append(str));
      return;
    }
    parama.a.setText("");
    parama.a.setVisibility(4);
  }
  
  private void a(HourlyBean paramHourlyBean, a parama)
  {
    int i = com.gau.go.launcherex.gowidget.weather.util.q.a(paramHourlyBean.b(ForecastHourForm.a(this.a).a().g));
    parama.e.setText(String.format("%d°", new Object[] { Integer.valueOf(i) }));
  }
  
  private boolean a(HourlyBean paramHourlyBean)
  {
    WeatherBean localWeatherBean = ForecastHourForm.c(this.a).a(ForecastHourForm.b(this.a));
    return r.a(paramHourlyBean.a(), paramHourlyBean.b(), paramHourlyBean.c(), ForecastHourForm.d(this.a).b(localWeatherBean.k.n()));
  }
  
  private void b(HourlyBean paramHourlyBean, a parama)
  {
    parama.c.setImageResource(r.a(i.h, paramHourlyBean.e(), b(paramHourlyBean.d())));
  }
  
  public HourlyBean a(int paramInt)
  {
    return (HourlyBean)this.c.get(paramInt);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {
      this.c = paramArrayList;
    }
  }
  
  public boolean b(int paramInt)
  {
    boolean bool = true;
    Object localObject = ForecastHourForm.c(this.a).a(ForecastHourForm.b(this.a));
    if (localObject != null)
    {
      String str = ((WeatherBean)localObject).k.j();
      localObject = ((WeatherBean)localObject).k.k();
      bool = r.a(paramInt, r.a(true, str), r.a(false, (String)localObject));
    }
    return bool;
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.b.inflate(2130903134, paramViewGroup, false);
      paramViewGroup = new a(this.a, paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      HourlyBean localHourlyBean = a(paramInt);
      paramViewGroup.d.setText(localHourlyBean.g());
      a(paramInt, localHourlyBean, paramViewGroup);
      paramViewGroup.b.setText(String.format(Locale.US, "%02d:00", new Object[] { Integer.valueOf(localHourlyBean.d()) }));
      a(localHourlyBean, paramViewGroup);
      b(localHourlyBean, paramViewGroup);
      paramViewGroup = (DashedLinearLayout)paramView;
      if (paramInt != getCount() - 1) {
        break;
      }
      paramViewGroup.a(false);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.a(true);
    return paramView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/hourforecast/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */