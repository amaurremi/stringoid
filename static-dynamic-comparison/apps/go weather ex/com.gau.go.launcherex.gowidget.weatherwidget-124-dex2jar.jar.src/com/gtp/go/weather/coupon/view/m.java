package com.gtp.go.weather.coupon.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.gtp.go.weather.coupon.a.a;
import com.gtp.go.weather.coupon.b.b;

class m
  implements View.OnClickListener
{
  m(k paramk, b paramb) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.l())
    {
      this.a.c(true);
      CouponsActivity.g(this.b.a).notifyDataSetChanged();
      a.a(this.b.a.getApplicationContext()).a(this.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/view/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */