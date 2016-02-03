package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.e.h;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.scroller.GLWidgetScrollGroup;
import com.go.gl.view.GLView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class s
  extends Handler
{
  private final WeakReference a;
  
  public s(GLWeatherWidget41 paramGLWeatherWidget41)
  {
    this.a = new WeakReference(paramGLWeatherWidget41);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = (GLWeatherWidget41)this.a.get();
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
        } while ((TextUtils.isEmpty(paramMessage)) || (!h.a(((GLWeatherWidget41)localObject2).getContext(), GLWeatherWidget41.access$200((GLWeatherWidget41)localObject2), paramMessage)));
        if (paramMessage.equals("app_widget_theme_white"))
        {
          GLWeatherWidget41.access$802((GLWeatherWidget41)localObject2, ((GLWeatherWidget41)localObject2).getContext().getPackageName());
          GLWeatherWidget41.access$902((GLWeatherWidget41)localObject2, 0);
        }
        for (;;)
        {
          GLWeatherWidget41.access$1000((GLWeatherWidget41)localObject2);
          GLWeatherWidget41.access$1100((GLWeatherWidget41)localObject2, GLWeatherWidget41.access$800((GLWeatherWidget41)localObject2));
          return;
          if (paramMessage.equals("app_widget_theme_black"))
          {
            GLWeatherWidget41.access$802((GLWeatherWidget41)localObject2, ((GLWeatherWidget41)localObject2).getContext().getPackageName());
            GLWeatherWidget41.access$902((GLWeatherWidget41)localObject2, 0);
          }
          else
          {
            GLWeatherWidget41.access$802((GLWeatherWidget41)localObject2, paramMessage);
            GLWeatherWidget41.access$902((GLWeatherWidget41)localObject2, 0);
          }
        }
        paramMessage = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)GLWeatherWidget41.access$1300((GLWeatherWidget41)localObject2).get(GLWeatherWidget41.access$1200((GLWeatherWidget41)localObject2) % GLWeatherWidget41.access$1300((GLWeatherWidget41)localObject2).size());
        GLWeatherWidget41.access$1400((GLWeatherWidget41)localObject2).a(2, paramMessage);
        return;
        GLWeatherWidget41.access$1302((GLWeatherWidget41)localObject2, com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.e(GLWeatherWidget41.access$1500((GLWeatherWidget41)localObject2), ((GLWeatherWidget41)localObject2).getResources()));
        GLWeatherWidget41.access$1000((GLWeatherWidget41)localObject2);
        return;
        if (paramMessage.obj == null) {
          break;
        }
        paramMessage = (List)paramMessage.obj;
        localObject2 = GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).getCitys().iterator();
      } while (!((Iterator)localObject2).hasNext());
      localObject3 = (GLWeather41)((Iterator)localObject2).next();
      localObject4 = paramMessage.iterator();
      do
      {
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject1 = (WeatherBean)((Iterator)localObject4).next();
      } while (!((WeatherBean)localObject1).c().equals(((GLWeather41)localObject3).getCityId()));
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((GLWeather41)localObject3).setWeatherBean((WeatherBean)localObject1);
        ((GLWeather41)localObject3).updateAllViews();
      }
      ((GLWeather41)localObject3).startRefreshAni(false);
      break label332;
      paramMessage = new ArrayList();
      break label319;
      paramMessage = paramMessage.getData();
      if (paramMessage == null) {
        break;
      }
      GLWeatherWidget41.access$1700((GLWeatherWidget41)localObject2, paramMessage);
      return;
      com.gau.go.launcherex.gowidget.weather.util.e.a(paramMessage.arg1, paramMessage.arg2, GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2));
      GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).notifyViewsChanged();
      GLWeatherWidget41.access$1800((GLWeatherWidget41)localObject2);
      return;
      paramMessage = (WeatherBean)paramMessage.obj;
      if (paramMessage == null) {
        break;
      }
      GLWeatherWidget41.access$1900((GLWeatherWidget41)localObject2);
      paramMessage = GLWeatherWidget41.access$2000((GLWeatherWidget41)localObject2, paramMessage);
      GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).setCurScreen(GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).indexOfChild(paramMessage));
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
        localObject4 = GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).getCitys().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (GLWeather41)((Iterator)localObject4).next();
          String str = ((GLWeather41)localObject5).getCityId();
          if (((String)localObject3).equals(str))
          {
            if (str.equals(GLWeatherWidget41.access$2100((GLWeatherWidget41)localObject2))) {
              i = 1;
            }
            paramMessage.add(localObject5);
          }
        }
      }
      for (;;)
      {
        break label556;
        localObject1 = (GLWeather41)GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).getChildAt(GLWeatherWidget41.access$2200((GLWeatherWidget41)localObject2));
        paramMessage = paramMessage.iterator();
        while (paramMessage.hasNext())
        {
          localObject3 = (GLWeather41)paramMessage.next();
          GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).removeView((GLView)localObject3);
          GLWeatherWidget41.access$2300((GLWeatherWidget41)localObject2, (GLView)localObject3);
        }
        GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).notifyViewsChanged();
        if (i != 0)
        {
          GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).setCurScreen(0);
          return;
        }
        GLWeatherWidget41.access$2202((GLWeatherWidget41)localObject2, GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).indexOfChild((GLView)localObject1));
        if (GLWeatherWidget41.access$2200((GLWeatherWidget41)localObject2) == -1) {
          GLWeatherWidget41.access$2202((GLWeatherWidget41)localObject2, 0);
        }
        GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).setCurScreen(GLWeatherWidget41.access$2200((GLWeatherWidget41)localObject2));
        return;
        localObject3 = (WeatherBean)paramMessage.obj;
        if (localObject3 == null) {
          break;
        }
        localObject4 = ((WeatherBean)localObject3).c();
        paramMessage = null;
        localObject5 = GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).getCitys().iterator();
        if (((Iterator)localObject5).hasNext())
        {
          localObject1 = (GLWeather41)((Iterator)localObject5).next();
          if (localObject1 != null) {
            if (((GLWeather41)localObject1).getCityId().equals(localObject4)) {
              paramMessage = (Message)localObject1;
            }
          }
          for (;;)
          {
            break;
            i = ((GLWeather41)localObject1).getWeatherBean().e();
            if (i == 2)
            {
              GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).removeView((GLView)localObject1);
              GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).notifyViewsChanged();
              GLWeatherWidget41.access$2300((GLWeatherWidget41)localObject2, (GLView)localObject1);
            }
            else if (i == 3)
            {
              ((GLWeather41)localObject1).getWeatherBean().a(1);
            }
          }
        }
        if (paramMessage != null) {
          paramMessage.getWeatherBean().a(3);
        }
        for (i = GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).indexOfChild(paramMessage); i != -1; i = GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).indexOfChild(paramMessage))
        {
          GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).setCurScreen(i);
          return;
          paramMessage = GLWeatherWidget41.access$2000((GLWeatherWidget41)localObject2, (WeatherBean)localObject3);
          GLWeatherWidget41.access$1600((GLWeatherWidget41)localObject2).notifyViewsChanged();
        }
        ((GLWeatherWidget41)localObject2).onBillingStatusChange(((Boolean)paramMessage.obj).booleanValue());
        return;
        GLWeatherWidget41.access$2400((GLWeatherWidget41)localObject2, ((Boolean)paramMessage.obj).booleanValue());
        return;
      }
      localObject1 = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */