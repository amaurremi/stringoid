package com.go.weatherex.home.windforecast;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.go.weatherex.home.view.DashedLinearLayout;
import java.util.ArrayList;

class a
  extends BaseAdapter
{
  private LayoutInflater b;
  private ArrayList c = new ArrayList();
  private ForecastBean d;
  private b e;
  private Time f;
  
  public a(WeatherWindViewHolder paramWeatherWindViewHolder, Context paramContext, ArrayList paramArrayList, Time paramTime)
  {
    this.b = LayoutInflater.from(paramContext);
    this.c = paramArrayList;
    this.f = paramTime;
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.b.inflate(2130903136, null);
      this.e = new b(this.a);
      this.e.a = ((TextView)paramView.findViewById(2131231329));
      this.e.b = ((TextView)paramView.findViewById(2131231330));
      this.e.c = ((LinearLayout)paramView.findViewById(2131231331));
      this.e.d = ((ImageView)paramView.findViewById(2131231332));
      this.e.e = ((TextView)paramView.findViewById(2131231333));
      this.e.f = ((TextView)paramView.findViewById(2131231334));
      this.e.g = ((TextView)paramView.findViewById(2131231335));
      paramView.setTag(this.e);
    }
    int j;
    int k;
    int m;
    for (;;)
    {
      this.d = ((ForecastBean)this.c.get(paramInt));
      i = this.d.e();
      j = this.d.f();
      k = this.d.g();
      m = r.b(i, j, k);
      if (m != 7) {
        break;
      }
      paramView.setVisibility(8);
      return paramView;
      this.e = ((b)paramView.getTag());
    }
    int n = WeatherWindViewHolder.a(this.a).a().k;
    if (r.a(i, j, k, this.f))
    {
      paramViewGroup = WeatherWindViewHolder.b(this.a);
      this.e.a.setText(paramViewGroup + "\n" + r.a(i, j, k, false, n));
      paramViewGroup = (DashedLinearLayout)paramView;
      if (paramInt != getCount() - 1) {
        break label391;
      }
      paramViewGroup.a(false);
    }
    float f1;
    for (;;)
    {
      f1 = this.d.l();
      if (f1 != -10000.0F) {
        break label399;
      }
      this.e.b.setVisibility(0);
      this.e.c.setVisibility(8);
      return paramView;
      paramViewGroup = WeatherWindViewHolder.c(this.a)[m];
      break;
      label391:
      paramViewGroup.a(true);
    }
    label399:
    this.e.b.setVisibility(8);
    this.e.c.setVisibility(0);
    paramInt = com.gau.go.launcherex.gowidget.weather.util.q.a(f1);
    int i = WeatherWindViewHolder.a(this.a, paramInt);
    this.e.d.setImageResource(i);
    paramInt = WeatherWindViewHolder.b(this.a, paramInt);
    this.e.e.setText(paramInt);
    paramViewGroup = WeatherWindViewHolder.a(this.a, f1);
    this.e.f.setText(paramViewGroup);
    paramInt = WeatherWindViewHolder.c(this.a, this.d.k());
    if (paramInt != 0) {
      this.e.g.setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
    }
    while (r.a(this.d.j()))
    {
      this.e.g.setText(this.d.j());
      return paramView;
      this.e.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    this.e.g.setText(2131165323);
    return paramView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/windforecast/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */