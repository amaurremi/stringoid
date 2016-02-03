package com.gau.go.launcherex.gowidget.weather.globalview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class l
  extends BaseAdapter
{
  private l(i parami) {}
  
  public int getCount()
  {
    return i.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if (getCount() == 0) {
      return null;
    }
    return (a)i.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new k(this.a);
      paramView = k.a(paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(paramInt);
      return paramView;
      paramViewGroup = (k)paramView.getTag();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */