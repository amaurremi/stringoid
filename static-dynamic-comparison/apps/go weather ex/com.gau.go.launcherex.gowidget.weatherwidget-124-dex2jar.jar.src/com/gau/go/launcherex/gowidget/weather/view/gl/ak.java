package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.e.h;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.scroller.GLWidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.util.e;
import com.go.gl.view.GLView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ak
  extends Handler
{
  private final WeakReference a;
  
  public ak(GLWeatherWidgetDays41 paramGLWeatherWidgetDays41)
  {
    this.a = new WeakReference(paramGLWeatherWidgetDays41);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = null;
    Object localObject2 = (GLWeatherWidgetDays41)this.a.get();
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
        } while ((TextUtils.isEmpty(paramMessage)) || (!h.a(((GLWeatherWidgetDays41)localObject2).getContext(), GLWeatherWidgetDays41.access$200((GLWeatherWidgetDays41)localObject2), paramMessage)));
        if (paramMessage.equals("app_widget_theme_white"))
        {
          GLWeatherWidgetDays41.access$602((GLWeatherWidgetDays41)localObject2, ((GLWeatherWidgetDays41)localObject2).getContext().getPackageName());
          GLWeatherWidgetDays41.access$702((GLWeatherWidgetDays41)localObject2, 0);
        }
        for (;;)
        {
          GLWeatherWidgetDays41.access$800((GLWeatherWidgetDays41)localObject2, GLWeatherWidgetDays41.access$600((GLWeatherWidgetDays41)localObject2));
          return;
          if (paramMessage.equals("app_widget_theme_black"))
          {
            GLWeatherWidgetDays41.access$602((GLWeatherWidgetDays41)localObject2, ((GLWeatherWidgetDays41)localObject2).getContext().getPackageName());
            GLWeatherWidgetDays41.access$702((GLWeatherWidgetDays41)localObject2, 0);
          }
          else
          {
            GLWeatherWidgetDays41.access$602((GLWeatherWidgetDays41)localObject2, paramMessage);
            GLWeatherWidgetDays41.access$702((GLWeatherWidgetDays41)localObject2, 0);
          }
        }
        if (paramMessage.obj == null) {
          break;
        }
        paramMessage = (List)paramMessage.obj;
        localObject2 = GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).getCitys().iterator();
      } while (!((Iterator)localObject2).hasNext());
      localObject3 = (GLWeatherDays41)((Iterator)localObject2).next();
      localObject4 = paramMessage.iterator();
      do
      {
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject1 = (WeatherBean)((Iterator)localObject4).next();
      } while (!((WeatherBean)localObject1).c().equals(((GLWeatherDays41)localObject3).getCityId()));
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((GLWeatherDays41)localObject3).setWeatherBean((WeatherBean)localObject1, true);
        ((GLWeatherDays41)localObject3).updateAllViews();
      }
      ((GLWeatherDays41)localObject3).showProgerssView(false);
      break label257;
      paramMessage = new ArrayList();
      break label244;
      paramMessage = paramMessage.getData();
      if (paramMessage == null) {
        break;
      }
      GLWeatherWidgetDays41.access$1000((GLWeatherWidgetDays41)localObject2, paramMessage);
      return;
      e.a(paramMessage.arg1, paramMessage.arg2, GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2));
      GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).notifyViewsChanged();
      GLWeatherWidgetDays41.access$1100((GLWeatherWidgetDays41)localObject2);
      return;
      paramMessage = (WeatherBean)paramMessage.obj;
      if (paramMessage == null) {
        break;
      }
      GLWeatherWidgetDays41.access$1200((GLWeatherWidgetDays41)localObject2);
      paramMessage = GLWeatherWidgetDays41.access$1300((GLWeatherWidgetDays41)localObject2, paramMessage);
      GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).setCurScreen(GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).indexOfChild(paramMessage));
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
        localObject4 = GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).getCitys().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (GLWeatherDays41)((Iterator)localObject4).next();
          String str = ((GLWeatherDays41)localObject5).getCityId();
          if (((String)localObject3).equals(str))
          {
            if (str.equals(GLWeatherWidgetDays41.access$1400((GLWeatherWidgetDays41)localObject2))) {
              i = 1;
            }
            paramMessage.add(localObject5);
          }
        }
      }
      for (;;)
      {
        break label482;
        localObject1 = (GLWeatherDays41)GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).getChildAt(GLWeatherWidgetDays41.access$1500((GLWeatherWidgetDays41)localObject2));
        paramMessage = paramMessage.iterator();
        while (paramMessage.hasNext())
        {
          localObject3 = (GLWeatherDays41)paramMessage.next();
          GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).removeView((GLView)localObject3);
          GLWeatherWidgetDays41.access$1600((GLWeatherWidgetDays41)localObject2, (GLView)localObject3);
        }
        GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).notifyViewsChanged();
        if (i != 0)
        {
          GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).setCurScreen(0);
          return;
        }
        GLWeatherWidgetDays41.access$1502((GLWeatherWidgetDays41)localObject2, GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).indexOfChild((GLView)localObject1));
        if (GLWeatherWidgetDays41.access$1500((GLWeatherWidgetDays41)localObject2) == -1) {
          GLWeatherWidgetDays41.access$1502((GLWeatherWidgetDays41)localObject2, 0);
        }
        GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).setCurScreen(GLWeatherWidgetDays41.access$1500((GLWeatherWidgetDays41)localObject2));
        return;
        localObject3 = (WeatherBean)paramMessage.obj;
        if (localObject3 == null) {
          break;
        }
        localObject4 = ((WeatherBean)localObject3).c();
        localObject5 = GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).getCitys().iterator();
        paramMessage = (Message)localObject1;
        if (((Iterator)localObject5).hasNext())
        {
          localObject1 = (GLWeatherDays41)((Iterator)localObject5).next();
          if (localObject1 != null) {
            if (((GLWeatherDays41)localObject1).getCityId().equals(localObject4)) {
              paramMessage = (Message)localObject1;
            }
          }
          for (;;)
          {
            break;
            i = ((GLWeatherDays41)localObject1).getWeatherBean().e();
            if (i == 2)
            {
              GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).removeView((GLView)localObject1);
              GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).notifyViewsChanged();
              GLWeatherWidgetDays41.access$1600((GLWeatherWidgetDays41)localObject2, (GLView)localObject1);
            }
            else if (i == 3)
            {
              ((GLWeatherDays41)localObject1).getWeatherBean().a(1);
            }
          }
        }
        if (paramMessage != null) {
          paramMessage.getWeatherBean().a(3);
        }
        for (i = GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).indexOfChild(paramMessage); i != -1; i = GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).indexOfChild(paramMessage))
        {
          GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).setCurScreen(i);
          return;
          paramMessage = GLWeatherWidgetDays41.access$1300((GLWeatherWidgetDays41)localObject2, (WeatherBean)localObject3);
          GLWeatherWidgetDays41.access$900((GLWeatherWidgetDays41)localObject2).notifyViewsChanged();
        }
        ((GLWeatherWidgetDays41)localObject2).onBillingStatusChange(((Boolean)paramMessage.obj).booleanValue());
        return;
        GLWeatherWidgetDays41.access$1700((GLWeatherWidgetDays41)localObject2, ((Boolean)paramMessage.obj).booleanValue());
        return;
      }
      localObject1 = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */