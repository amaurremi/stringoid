package com.gtp.go.weather.billing.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.a;

class b
  implements View.OnClickListener
{
  b(PayActivity paramPayActivity, a parama) {}
  
  public void onClick(View paramView)
  {
    PayActivity.a(this.b, this.a);
    if (PayActivity.d(this.b))
    {
      if ((!PayActivity.e(this.b)) && (PayActivity.f(this.b) != null))
      {
        PayActivity.a(this.b, true);
        PayActivity.f(this.b).startSetup(this.b);
      }
      return;
    }
    PayActivity.g(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/billing/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */