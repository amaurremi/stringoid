package com.gtp.go.weather.coupon.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gtp.go.weather.coupon.b.b;
import java.util.ArrayList;
import java.util.Iterator;

class q
  extends BroadcastReceiver
{
  q(CouponsActivity paramCouponsActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (!TextUtils.isEmpty(paramContext)) {
        break label25;
      }
    }
    label25:
    int i;
    do
    {
      do
      {
        return;
        paramContext = null;
        break;
      } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_COUPON_DELETE"));
      paramContext = paramIntent.getLongArrayExtra("extra_coupon_delete_id");
      i = j;
      if (paramContext != null)
      {
        i = j;
        if (paramContext.length > 0)
        {
          j = 0;
          int k;
          for (i = 0; j < paramContext.length; i = k)
          {
            long l = paramContext[j];
            paramIntent = CouponsActivity.c(this.a).iterator();
            b localb;
            do
            {
              k = i;
              if (!paramIntent.hasNext()) {
                break;
              }
              localb = (b)paramIntent.next();
            } while (l != localb.b());
            localb.c(false);
            k = 1;
            j += 1;
          }
        }
      }
    } while (i == 0);
    CouponsActivity.g(this.a).notifyDataSetChanged();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/view/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */