package com.gtp.go.weather.sharephoto;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.gau.go.launcherex.gowidget.weather.globalview.a;
import java.util.ArrayList;

class w
  extends BaseAdapter
{
  private w(PhotoReportActivity paramPhotoReportActivity) {}
  
  public int getCount()
  {
    return PhotoReportActivity.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if (getCount() == 0) {
      return null;
    }
    return (a)PhotoReportActivity.a(this.a).get(paramInt);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */