package com.gtp.go.weather.coupon.view;

import android.widget.TextView;
import android.widget.Toast;
import com.gtp.go.weather.coupon.a.i;

class b
  implements i
{
  b(a parama) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.b.setText(this.a.c.getString(2131165871));
      CouponCollectActivity.h(this.a.c).a(this.a.c.getString(2131165872));
      CouponCollectActivity.h(this.a.c).d(this.a.c.getString(2131165868));
      return;
    }
    Toast.makeText(this.a.c.getApplicationContext(), this.a.c.getString(2131165873), 0).show();
    this.a.b.setClickable(true);
    this.a.b.setText(this.a.c.getString(2131165869));
    this.a.b.setBackgroundResource(2130839068);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */