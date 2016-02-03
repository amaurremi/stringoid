package com.gtp.go.weather.billing.view;

import android.view.View;
import android.view.View.OnClickListener;

class f
  implements View.OnClickListener
{
  f(PayActivity paramPayActivity) {}
  
  public void onClick(View paramView)
  {
    PayActivity.a(this.a, null);
    if (PayActivity.d(this.a))
    {
      PayActivity.n(this.a);
      return;
    }
    PayActivity.g(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/billing/view/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */