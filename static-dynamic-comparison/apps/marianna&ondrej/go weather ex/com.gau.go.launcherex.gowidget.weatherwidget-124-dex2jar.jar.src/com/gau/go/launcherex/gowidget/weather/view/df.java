package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.gau.go.launcherex.gowidget.weather.e.h;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.scroller.WidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.util.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class df
  extends Handler
{
  private final WeakReference a;
  
  public df(WeatherWidgetDays41 paramWeatherWidgetDays41)
  {
    this.a = new WeakReference(paramWeatherWidgetDays41);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = null;
    Object localObject2 = (WeatherWidgetDays41)this.a.get();
    if (localObject2 != null) {}
    label244:
    label257:
    Object localObject3;
    Object localObject4;
    switch (paramMessage.what)
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    default: 
    case 9: 
    case 1: 
      do
      {
        do
        {
          return;
          paramMessage = (String)paramMessage.obj;
        } while ((TextUtils.isEmpty(paramMessage)) || (!h.a(((WeatherWidgetDays41)localObject2).getContext(), WeatherWidgetDays41.c((WeatherWidgetDays41)localObject2), paramMessage)));
        if (paramMessage.equals("app_widget_theme_white"))
        {
          WeatherWidgetDays41.a((WeatherWidgetDays41)localObject2, ((WeatherWidgetDays41)localObject2).getContext().getPackageName());
          WeatherWidgetDays41.a((WeatherWidgetDays41)localObject2, 0);
        }
        for (;;)
        {
          WeatherWidgetDays41.b((WeatherWidgetDays41)localObject2, WeatherWidgetDays41.f((WeatherWidgetDays41)localObject2));
          return;
          if (paramMessage.equals("app_widget_theme_black"))
          {
            WeatherWidgetDays41.a((WeatherWidgetDays41)localObject2, ((WeatherWidgetDays41)localObject2).getContext().getPackageName());
            WeatherWidgetDays41.a((WeatherWidgetDays41)localObject2, 0);
          }
          else
          {
            WeatherWidgetDays41.a((WeatherWidgetDays41)localObject2, paramMessage);
            WeatherWidgetDays41.a((WeatherWidgetDays41)localObject2, 0);
          }
        }
        if (paramMessage.obj == null) {
          break;
        }
        paramMessage = (List)paramMessage.obj;
        localObject2 = WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).c().iterator();
      } while (!((Iterator)localObject2).hasNext());
      localObject3 = (bs)((Iterator)localObject2).next();
      localObject4 = paramMessage.iterator();
      do
      {
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject1 = (WeatherBean)((Iterator)localObject4).next();
      } while (!((WeatherBean)localObject1).c().equals(((bs)localObject3).c()));
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((bs)localObject3).a((WeatherBean)localObject1, true);
        ((bs)localObject3).h();
      }
      ((bs)localObject3).a(false);
      break label257;
      paramMessage = new ArrayList();
      break label244;
      paramMessage = paramMessage.getData();
      if (paramMessage == null) {
        break;
      }
      WeatherWidgetDays41.a((WeatherWidgetDays41)localObject2, paramMessage);
      return;
      e.a(paramMessage.arg1, paramMessage.arg2, WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2));
      WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).a();
      WeatherWidgetDays41.h((WeatherWidgetDays41)localObject2);
      return;
      paramMessage = (WeatherBean)paramMessage.obj;
      if (paramMessage == null) {
        break;
      }
      WeatherWidgetDays41.i((WeatherWidgetDays41)localObject2);
      paramMessage = WeatherWidgetDays41.a((WeatherWidgetDays41)localObject2, paramMessage);
      WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).a(WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).indexOfChild(paramMessage));
      return;
      localObject1 = (ArrayList)paramMessage.obj;
      if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
        break;
      }
      paramMessage = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      int i = 0;
      label482:
      Object localObject5;
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        localObject4 = WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).c().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (bs)((Iterator)localObject4).next();
          String str = ((bs)localObject5).c();
          if (((String)localObject3).equals(str))
          {
            if (str.equals(WeatherWidgetDays41.j((WeatherWidgetDays41)localObject2))) {
              i = 1;
            }
            paramMessage.add(localObject5);
          }
        }
      }
      for (;;)
      {
        break label482;
        localObject1 = (bs)WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).getChildAt(WeatherWidgetDays41.k((WeatherWidgetDays41)localObject2));
        paramMessage = paramMessage.iterator();
        while (paramMessage.hasNext())
        {
          localObject3 = (bs)paramMessage.next();
          WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).removeView((View)localObject3);
        }
        WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).a();
        if (i != 0)
        {
          WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).a(0);
          return;
        }
        WeatherWidgetDays41.b((WeatherWidgetDays41)localObject2, WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).indexOfChild((View)localObject1));
        if (WeatherWidgetDays41.k((WeatherWidgetDays41)localObject2) == -1) {
          WeatherWidgetDays41.b((WeatherWidgetDays41)localObject2, 0);
        }
        WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).a(WeatherWidgetDays41.k((WeatherWidgetDays41)localObject2));
        return;
        localObject3 = (WeatherBean)paramMessage.obj;
        if (localObject3 == null) {
          break;
        }
        localObject4 = ((WeatherBean)localObject3).c();
        localObject5 = WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).c().iterator();
        paramMessage = (Message)localObject1;
        if (((Iterator)localObject5).hasNext())
        {
          localObject1 = (bs)((Iterator)localObject5).next();
          if (localObject1 != null) {
            if (((bs)localObject1).c().equals(localObject4)) {
              paramMessage = (Message)localObject1;
            }
          }
          for (;;)
          {
            break;
            i = ((bs)localObject1).d().e();
            if (i == 2)
            {
              WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).removeView((View)localObject1);
              WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).a();
            }
            else if (i == 3)
            {
              ((bs)localObject1).d().a(1);
            }
          }
        }
        if (paramMessage != null) {
          paramMessage.d().a(3);
        }
        for (i = WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).indexOfChild(paramMessage); i != -1; i = WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).indexOfChild(paramMessage))
        {
          WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).a(i);
          return;
          paramMessage = WeatherWidgetDays41.a((WeatherWidgetDays41)localObject2, (WeatherBean)localObject3);
          WeatherWidgetDays41.g((WeatherWidgetDays41)localObject2).a();
        }
        ((WeatherWidgetDays41)localObject2).onBillingStatusChange(((Boolean)paramMessage.obj).booleanValue());
        return;
        WeatherWidgetDays41.a((WeatherWidgetDays41)localObject2, ((Boolean)paramMessage.obj).booleanValue());
        return;
      }
      localObject1 = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */