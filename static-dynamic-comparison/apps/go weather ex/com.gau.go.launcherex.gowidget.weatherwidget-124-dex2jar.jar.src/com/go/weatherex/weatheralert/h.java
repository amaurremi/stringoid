package com.go.weatherex.weatheralert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.b;
import com.gau.go.launcherex.gowidget.weather.model.c;
import java.util.ArrayList;

class h
  extends BaseAdapter
{
  private ArrayList b = new ArrayList();
  
  public h(WeatherAlertActivity paramWeatherAlertActivity) {}
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    this.b.clear();
    this.b.addAll(paramArrayList);
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.b == null) {
      return null;
    }
    return (c)this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new g(this.a);
      paramView = this.a.getLayoutInflater().inflate(2130903342, null, false);
      paramViewGroup.a = paramView.findViewById(2131231144);
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131232051));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131232043));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131232052));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131232053));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      c localc = (c)WeatherAlertActivity.d(this.a).get(paramInt);
      paramViewGroup.d.setText(WeatherAlertActivity.a(this.a, localc.c()));
      paramViewGroup.c.setText(localc.f());
      paramViewGroup.e.setText(localc.i());
      switch (localc.h())
      {
      default: 
        paramViewGroup.b.setImageResource(2130838964);
        paramViewGroup.c.setTextColor(this.a.e().getColor(2131361904));
        return paramView;
        paramViewGroup = (g)paramView.getTag();
      }
    }
    paramViewGroup.b.setImageResource(2130838966);
    paramViewGroup.c.setTextColor(this.a.e().getColor(2131361905));
    return paramView;
    paramViewGroup.b.setImageResource(2130838965);
    paramViewGroup.c.setTextColor(this.a.e().getColor(2131361906));
    return paramView;
    paramViewGroup.b.setImageResource(2130838967);
    paramViewGroup.c.setTextColor(this.a.e().getColor(2131361907));
    return paramView;
    paramViewGroup.b.setImageResource(2130838963);
    paramViewGroup.c.setTextColor(this.a.e().getColor(2131361908));
    return paramView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/weatheralert/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */