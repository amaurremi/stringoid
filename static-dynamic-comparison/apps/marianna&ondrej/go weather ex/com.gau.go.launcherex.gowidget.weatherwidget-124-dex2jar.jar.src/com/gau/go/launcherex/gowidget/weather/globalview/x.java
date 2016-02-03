package com.gau.go.launcherex.gowidget.weather.globalview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class x
  extends BaseAdapter
{
  private x(t paramt) {}
  
  public int getCount()
  {
    return t.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if (getCount() == 0) {
      return null;
    }
    return (a)t.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new v(this.a);
      paramView = v.a(paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(paramInt);
      return paramView;
      paramViewGroup = (v)paramView.getTag();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */