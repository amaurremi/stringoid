package com.gtp.go.weather.sharephoto.award;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class i
  extends BaseAdapter
{
  private i(c paramc) {}
  
  public int getCount()
  {
    return c.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if (getCount() == 0) {
      return null;
    }
    return (h)c.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new j(this);
      paramView = j.a(paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(paramInt);
      return paramView;
      paramViewGroup = (j)paramView.getTag();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */