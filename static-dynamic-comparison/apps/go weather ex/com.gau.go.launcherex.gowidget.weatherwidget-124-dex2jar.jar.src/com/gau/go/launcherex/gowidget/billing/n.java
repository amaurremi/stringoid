package com.gau.go.launcherex.gowidget.billing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.gau.go.launcherex.gowidget.statistics.o;
import com.gau.go.launcherex.gowidget.statistics.p;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.view.bb;

class n
  extends BroadcastReceiver
{
  private n(BillingActivity paramBillingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null) {
        break label14;
      }
    }
    label14:
    do
    {
      boolean bool;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE")) {
                break;
              }
              BillingActivity.d(this.a);
              BillingActivity.a(this.a, false);
              if (BillingActivity.e(this.a).b())
              {
                if (BillingActivity.f(this.a) != 1) {
                  BillingActivity.h(this.a).a(new o(BillingActivity.g(this.a), 0, 0, BillingActivity.f(this.a), 0, 1));
                }
                if (BillingActivity.i(this.a) != null) {
                  BillingActivity.i(this.a).setVisibility(8);
                }
                BillingActivity.j(this.a);
              }
            } while (BillingActivity.k(this.a) == null);
            BillingActivity.k(this.a).a(BillingActivity.e(this.a).c(), BillingActivity.e(this.a).b());
            return;
          } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION"));
          BillingActivity.d(this.a);
          BillingActivity.a(this.a, false);
          bool = BillingActivity.e(this.a).c();
        } while (!bool);
        BillingActivity.h(this.a).a(new o(BillingActivity.g(this.a), 0, 0, BillingActivity.f(this.a), 0, 1));
      } while (BillingActivity.k(this.a) == null);
      BillingActivity.k(this.a).a(bool, BillingActivity.e(this.a).b());
    } while (BillingActivity.l(this.a).getVisibility() == 0);
    BillingActivity.b(this.a, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */