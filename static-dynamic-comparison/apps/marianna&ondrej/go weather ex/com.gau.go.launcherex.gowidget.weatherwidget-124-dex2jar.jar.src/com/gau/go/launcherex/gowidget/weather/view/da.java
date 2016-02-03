package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.gau.go.launcherex.gowidget.weather.e.h;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.scroller.WidgetScrollGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class da
  extends Handler
{
  private final WeakReference a;
  
  public da(WeatherWidget42 paramWeatherWidget42)
  {
    this.a = new WeakReference(paramWeatherWidget42);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = (WeatherWidget42)this.a.get();
    if (localObject2 != null) {}
    label319:
    label332:
    Object localObject3;
    Object localObject4;
    Object localObject1;
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
    case 18: 
    case 19: 
    case 1: 
      do
      {
        do
        {
          return;
          paramMessage = (String)paramMessage.obj;
        } while ((TextUtils.isEmpty(paramMessage)) || (!h.a(((WeatherWidget42)localObject2).getContext(), WeatherWidget42.c((WeatherWidget42)localObject2), paramMessage)));
        if (paramMessage.equals("app_widget_theme_white"))
        {
          WeatherWidget42.a((WeatherWidget42)localObject2, ((WeatherWidget42)localObject2).getContext().getPackageName());
          WeatherWidget42.a((WeatherWidget42)localObject2, 0);
        }
        for (;;)
        {
          WeatherWidget42.g((WeatherWidget42)localObject2);
          WeatherWidget42.b((WeatherWidget42)localObject2, WeatherWidget42.h((WeatherWidget42)localObject2));
          return;
          if (paramMessage.equals("app_widget_theme_black"))
          {
            WeatherWidget42.a((WeatherWidget42)localObject2, ((WeatherWidget42)localObject2).getContext().getPackageName());
            WeatherWidget42.a((WeatherWidget42)localObject2, 0);
          }
          else
          {
            WeatherWidget42.a((WeatherWidget42)localObject2, paramMessage);
            WeatherWidget42.a((WeatherWidget42)localObject2, 0);
          }
        }
        paramMessage = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)WeatherWidget42.j((WeatherWidget42)localObject2).get(WeatherWidget42.i((WeatherWidget42)localObject2) % WeatherWidget42.j((WeatherWidget42)localObject2).size());
        WeatherWidget42.k((WeatherWidget42)localObject2).a(2, paramMessage);
        return;
        WeatherWidget42.a((WeatherWidget42)localObject2, com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.e(WeatherWidget42.l((WeatherWidget42)localObject2), ((WeatherWidget42)localObject2).getResources()));
        WeatherWidget42.g((WeatherWidget42)localObject2);
        return;
        if (paramMessage.obj == null) {
          break;
        }
        paramMessage = (List)paramMessage.obj;
        localObject2 = WeatherWidget42.m((WeatherWidget42)localObject2).c().iterator();
      } while (!((Iterator)localObject2).hasNext());
      localObject3 = (bg)((Iterator)localObject2).next();
      localObject4 = paramMessage.iterator();
      do
      {
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject1 = (WeatherBean)((Iterator)localObject4).next();
      } while (!((WeatherBean)localObject1).c().equals(((bg)localObject3).h()));
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((bg)localObject3).a((WeatherBean)localObject1);
        ((bg)localObject3).l();
      }
      ((bg)localObject3).b(false);
      break label332;
      paramMessage = new ArrayList();
      break label319;
      paramMessage = paramMessage.getData();
      if (paramMessage == null) {
        break;
      }
      WeatherWidget42.a((WeatherWidget42)localObject2, paramMessage);
      return;
      com.gau.go.launcherex.gowidget.weather.util.e.a(paramMessage.arg1, paramMessage.arg2, WeatherWidget42.m((WeatherWidget42)localObject2));
      WeatherWidget42.m((WeatherWidget42)localObject2).a();
      WeatherWidget42.n((WeatherWidget42)localObject2);
      return;
      paramMessage = (WeatherBean)paramMessage.obj;
      if (paramMessage == null) {
        break;
      }
      WeatherWidget42.o((WeatherWidget42)localObject2);
      paramMessage = WeatherWidget42.a((WeatherWidget42)localObject2, paramMessage);
      WeatherWidget42.m((WeatherWidget42)localObject2).a(WeatherWidget42.m((WeatherWidget42)localObject2).indexOfChild(paramMessage));
      return;
      localObject1 = (ArrayList)paramMessage.obj;
      if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
        break;
      }
      paramMessage = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      int i = 0;
      label556:
      Object localObject5;
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        localObject4 = WeatherWidget42.m((WeatherWidget42)localObject2).c().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (bg)((Iterator)localObject4).next();
          String str = ((bg)localObject5).h();
          if (((String)localObject3).equals(str))
          {
            if (str.equals(WeatherWidget42.p((WeatherWidget42)localObject2))) {
              i = 1;
            }
            paramMessage.add(localObject5);
          }
        }
      }
      for (;;)
      {
        break label556;
        localObject1 = (bg)WeatherWidget42.m((WeatherWidget42)localObject2).getChildAt(WeatherWidget42.q((WeatherWidget42)localObject2));
        paramMessage = paramMessage.iterator();
        while (paramMessage.hasNext())
        {
          localObject3 = (bg)paramMessage.next();
          WeatherWidget42.m((WeatherWidget42)localObject2).removeView((View)localObject3);
        }
        WeatherWidget42.m((WeatherWidget42)localObject2).a();
        if (i != 0)
        {
          WeatherWidget42.m((WeatherWidget42)localObject2).a(0);
          return;
        }
        WeatherWidget42.b((WeatherWidget42)localObject2, WeatherWidget42.m((WeatherWidget42)localObject2).indexOfChild((View)localObject1));
        if (WeatherWidget42.q((WeatherWidget42)localObject2) == -1) {
          WeatherWidget42.b((WeatherWidget42)localObject2, 0);
        }
        WeatherWidget42.m((WeatherWidget42)localObject2).a(WeatherWidget42.q((WeatherWidget42)localObject2));
        return;
        localObject3 = (WeatherBean)paramMessage.obj;
        if (localObject3 == null) {
          break;
        }
        localObject4 = ((WeatherBean)localObject3).c();
        paramMessage = null;
        localObject5 = WeatherWidget42.m((WeatherWidget42)localObject2).c().iterator();
        if (((Iterator)localObject5).hasNext())
        {
          localObject1 = (bg)((Iterator)localObject5).next();
          if (localObject1 != null) {
            if (((bg)localObject1).h().equals(localObject4)) {
              paramMessage = (Message)localObject1;
            }
          }
          for (;;)
          {
            break;
            i = ((bg)localObject1).j().e();
            if (i == 2)
            {
              WeatherWidget42.m((WeatherWidget42)localObject2).removeView((View)localObject1);
              WeatherWidget42.m((WeatherWidget42)localObject2).a();
            }
            else if (i == 3)
            {
              ((bg)localObject1).j().a(1);
            }
          }
        }
        if (paramMessage != null) {
          paramMessage.j().a(3);
        }
        for (i = WeatherWidget42.m((WeatherWidget42)localObject2).indexOfChild(paramMessage); i != -1; i = WeatherWidget42.m((WeatherWidget42)localObject2).indexOfChild(paramMessage))
        {
          WeatherWidget42.m((WeatherWidget42)localObject2).a(i);
          return;
          paramMessage = WeatherWidget42.a((WeatherWidget42)localObject2, (WeatherBean)localObject3);
          WeatherWidget42.m((WeatherWidget42)localObject2).a();
        }
        ((WeatherWidget42)localObject2).onBillingStatusChange(((Boolean)paramMessage.obj).booleanValue());
        return;
        WeatherWidget42.a((WeatherWidget42)localObject2, ((Boolean)paramMessage.obj).booleanValue());
        return;
      }
      localObject1 = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */