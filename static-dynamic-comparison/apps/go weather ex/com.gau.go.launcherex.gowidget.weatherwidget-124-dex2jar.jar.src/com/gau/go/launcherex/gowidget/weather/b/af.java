package com.gau.go.launcherex.gowidget.weather.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.a.a;
import com.gau.go.launcherex.gowidget.statistics.r;
import com.gau.go.launcherex.gowidget.weather.model.ExtremeCityIdBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.c;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.util.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class af
  extends BroadcastReceiver
{
  af(ae paramae) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    boolean bool = false;
    paramContext = paramIntent.getAction();
    label33:
    Object localObject2;
    if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_UPDATE_EXTREME_WEATHER"))
    {
      if (ae.a(this.a).t == 0) {}
      do
      {
        break label33;
        break label33;
        do
        {
          return;
        } while (!paramIntent.getBooleanExtra("extra_extreme_notify", true));
        paramIntent = paramIntent.getParcelableArrayListExtra("extra_extreme_city_ids");
      } while (paramIntent.size() <= 0);
      localObject2 = new HashMap();
      paramContext = ae.a(this.a).F;
      if (TextUtils.isEmpty(paramContext)) {
        break label952;
      }
      if (paramContext.contains("#")) {
        paramContext = paramContext.split("#");
      }
    }
    for (;;)
    {
      label101:
      Object localObject3 = paramIntent.iterator();
      label107:
      label188:
      label461:
      label611:
      label942:
      label945:
      label947:
      label950:
      for (;;)
      {
        String str;
        Object localObject1;
        c localc;
        if (((Iterator)localObject3).hasNext())
        {
          paramIntent = (ExtremeCityIdBean)((Iterator)localObject3).next();
          str = paramIntent.a();
          localObject1 = ae.b(this.a).a(str);
          if (localObject1 == null) {
            continue;
          }
          localc = ((WeatherBean)localObject1).d(paramIntent.b());
          if ((localc == null) || (!localc.l())) {
            continue;
          }
          if ((paramContext == null) || (paramContext.length <= 0)) {
            break label947;
          }
          i = 0;
          if (i >= paramContext.length) {
            break label947;
          }
          if (!str.equals(paramContext[i])) {}
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label950;
          }
          localObject1 = (ArrayList)ae.c(this.a).get(str);
          paramIntent = (Intent)localObject1;
          if (localObject1 == null) {
            paramIntent = new ArrayList();
          }
          ae.c(this.a).put(str, paramIntent);
          paramIntent.add(localc);
          localObject1 = (ArrayList)((HashMap)localObject2).get(str);
          paramIntent = (Intent)localObject1;
          if (localObject1 == null) {
            paramIntent = new ArrayList();
          }
          paramIntent.add(localc);
          ((HashMap)localObject2).put(str, paramIntent);
          break label107;
          paramContext = new String[] { paramContext };
          break label101;
          i += 1;
          break label188;
          if (((HashMap)localObject2).isEmpty()) {
            break;
          }
          paramContext = this.a;
          if (ae.a(this.a).z == 1) {
            bool = true;
          }
          ae.a(paramContext, (HashMap)localObject2, bool);
          r.a(ae.d(this.a)).a(new a(93, "news002"));
          return;
          if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_EXPIRED_EXTREME_WEATHER")) {
            if ((!ae.c(this.a).isEmpty()) && (!ae.e(this.a).isEmpty()))
            {
              paramContext = paramIntent.getParcelableArrayListExtra("extra_extreme_city_ids");
              if ((paramContext == null) || (paramContext.isEmpty())) {
                break;
              }
              paramIntent = new HashMap();
              localObject1 = paramContext.iterator();
            }
          }
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject3 = (ExtremeCityIdBean)((Iterator)localObject1).next();
              if (localObject3 == null) {
                continue;
              }
              localObject2 = ((ExtremeCityIdBean)localObject3).a();
              if (localObject3 == null) {
                break label942;
              }
            }
            for (paramContext = (ArrayList)ae.c(this.a).get(localObject2);; paramContext = null)
            {
              if (paramContext == null) {
                break label945;
              }
              i = 0;
              for (;;)
              {
                if (i < paramContext.size())
                {
                  if (((c)paramContext.get(i)).k() == ((ExtremeCityIdBean)localObject3).b()) {
                    paramContext.remove(i);
                  }
                }
                else
                {
                  paramContext = (ArrayList)ae.c(this.a).get(localObject2);
                  if ((paramContext == null) || (paramContext.isEmpty())) {
                    break label611;
                  }
                  paramIntent.put(localObject2, ae.c(this.a).get(localObject2));
                  break;
                }
                i += 1;
              }
              ae.c(this.a).remove(localObject2);
              ae.a(this.a, ((Long)ae.e(this.a).get(localObject2)).longValue());
              ae.e(this.a).remove(localObject2);
              break label461;
              if ((!ae.c(this.a).isEmpty()) && (!ae.e(this.a).isEmpty()))
              {
                ae.a(this.a, paramIntent, false);
                return;
              }
              this.a.b();
              return;
              this.a.b();
              this.a.a();
              return;
              if (paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CLEAR_EXTREME_WEATHER"))
              {
                this.a.a();
                this.a.b();
                return;
              }
              if ((!paramContext.equals("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION")) || (ae.c(this.a).isEmpty()) || (ae.e(this.a).isEmpty())) {
                break;
              }
              paramContext = new ArrayList();
              paramIntent = ae.e(this.a).entrySet().iterator();
              for (;;)
              {
                i = j;
                if (!paramIntent.hasNext()) {
                  break;
                }
                localObject1 = (String)((Map.Entry)paramIntent.next()).getKey();
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramContext.add(localObject1);
                }
              }
              while (i < paramContext.size())
              {
                paramIntent = (String)paramContext.get(i);
                if (ae.b(this.a).a(paramIntent) == null)
                {
                  ae.c(this.a).remove(paramIntent);
                  ae.a(this.a, ((Long)ae.e(this.a).get(paramIntent)).longValue());
                  ae.e(this.a).remove(paramIntent);
                }
                i += 1;
              }
              break label33;
            }
          }
        }
      }
      label952:
      paramContext = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/b/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */