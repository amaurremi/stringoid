package com.go.weatherex.weatheralert;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.weather.model.ExtremeCityIdBean;
import java.util.ArrayList;
import java.util.Iterator;

class q
  extends BroadcastReceiver
{
  private q(i parami) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    do
    {
      do
      {
        paramContext = paramIntent.getAction();
        if ((!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_UPDATE_EXTREME_WEATHER")) && (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_EXPIRED_EXTREME_WEATHER"))) {
          break;
        }
        paramContext = paramIntent.getParcelableArrayListExtra("extra_extreme_city_ids").iterator();
      } while (!paramContext.hasNext());
      if ((!((ExtremeCityIdBean)paramContext.next()).a().equals(i.d(this.a))) || (i.e(this.a) == null)) {
        break;
      }
      i.e(this.a).a(i.d(this.a));
      return;
    } while (!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CLEAR_EXTREME_WEATHER"));
    i.b(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/weatheralert/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */