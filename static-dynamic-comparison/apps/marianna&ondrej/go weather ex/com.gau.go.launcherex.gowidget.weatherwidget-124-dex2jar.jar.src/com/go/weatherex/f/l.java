package com.go.weatherex.f;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.model.b;
import java.util.ArrayList;

class l
  extends BaseAdapter
{
  private l(j paramj) {}
  
  public int getCount()
  {
    if (j.a(this.a) != null) {
      return j.a(this.a).size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new m(this.a);
      paramView = paramViewGroup.a;
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      b localb = (b)j.a(this.a).get(paramInt);
      paramViewGroup.b.setText(localb.f());
      return paramView;
      paramViewGroup = (m)paramView.getTag();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */