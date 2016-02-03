package com.go.weatherex.f;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.gau.go.launcherex.gowidget.weather.model.b;
import java.util.List;

class r
  extends BaseAdapter
{
  private r(n paramn) {}
  
  public int getCount()
  {
    return n.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return n.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new p(this.a);
      localView = paramView.e();
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a((b)getItem(paramInt));
      return localView;
      paramViewGroup = (p)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */