package com.gtp.go.weather.billing.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper;
import com.gau.go.launcherex.gowidget.statistics.y;

class d
  implements View.OnClickListener
{
  d(PayActivity paramPayActivity) {}
  
  public void onClick(View paramView)
  {
    PayActivity.a(this.a, null);
    if (PayActivity.d(this.a))
    {
      if (PayActivity.h(this.a).equals("1"))
      {
        PayActivity.i(this.a);
        PayActivity.j(this.a);
      }
      do
      {
        return;
        if (!y.s(this.a.getApplicationContext())) {
          break;
        }
        PayActivity.i(this.a);
      } while ((PayActivity.e(this.a)) || (PayActivity.f(this.a) == null));
      PayActivity.a(this.a, true);
      PayActivity.f(this.a).startSetup(this.a);
      return;
      PayActivity.a(this.a, this.a.getString(2131166044), true, false);
      return;
    }
    PayActivity.g(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/billing/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */