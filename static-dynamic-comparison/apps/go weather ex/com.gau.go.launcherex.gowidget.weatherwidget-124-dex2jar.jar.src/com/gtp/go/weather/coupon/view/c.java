package com.gtp.go.weather.coupon.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.gtp.go.weather.coupon.b.a;
import java.util.ArrayList;

class c
  extends BaseAdapter
{
  private c(CouponCollectActivity paramCouponCollectActivity) {}
  
  public int getCount()
  {
    return CouponCollectActivity.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if (getCount() == 0) {
      return null;
    }
    return (a)CouponCollectActivity.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new d(this);
      paramView = d.a(paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(paramInt);
      return paramView;
      paramViewGroup = (d)paramView.getTag();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/view/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */