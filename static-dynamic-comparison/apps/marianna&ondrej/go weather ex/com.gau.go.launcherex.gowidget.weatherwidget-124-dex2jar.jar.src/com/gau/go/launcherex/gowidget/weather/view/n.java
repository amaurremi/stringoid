package com.gau.go.launcherex.gowidget.weather.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

class n
  extends BaseAdapter
{
  private LayoutInflater b;
  private List c;
  
  public n(AppListActivity paramAppListActivity, List paramList)
  {
    this.b = ((LayoutInflater)paramAppListActivity.getSystemService("layout_inflater"));
    this.c = paramList;
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
      paramViewGroup = new o(this);
      paramView = paramViewGroup.a;
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(paramInt);
      return paramView;
      paramViewGroup = (o)paramView.getTag();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */