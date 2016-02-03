package com.gtp.go.weather.coupon.view;

import android.widget.TextView;
import android.widget.Toast;
import com.gtp.a.a.c.d;
import com.gtp.go.weather.coupon.a.e;

class a
  implements g
{
  a(CouponCollectActivity paramCouponCollectActivity, com.gtp.go.weather.coupon.b.b paramb, TextView paramTextView) {}
  
  public void a()
  {
    switch (this.a.f())
    {
    default: 
      return;
    case 1: 
      com.gtp.go.weather.coupon.c.a.a(this.c.getApplicationContext(), CouponCollectActivity.h(this.c).c());
      CouponCollectActivity.h(this.c).d(this.c.getString(2131165877));
      this.b.setText(this.c.getString(2131165879));
      this.b.setBackgroundResource(2130839069);
      this.b.setClickable(false);
      return;
    }
    if (com.gtp.go.weather.coupon.c.a.b(CouponCollectActivity.h(this.c).e()))
    {
      if (d.b(this.c.getApplicationContext()))
      {
        this.b.setText(this.c.getString(2131165870));
        this.b.setClickable(false);
        this.b.setBackgroundResource(2130839069);
        new e(this.c.getApplicationContext()).a(CouponCollectActivity.h(this.c).e(), this.a.c(), new b(this));
        return;
      }
      Toast.makeText(this.c.getApplicationContext(), this.c.getString(2131165748), 0).show();
      return;
    }
    Toast.makeText(this.c.getApplicationContext(), this.c.getString(2131165874), 0).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */