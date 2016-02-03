package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.os.Handler;
import android.os.Message;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.scroller.GLWidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.util.e;
import com.go.gl.view.GLView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class z
  extends Handler
{
  z(GLWeatherWidget41Style2 paramGLWeatherWidget41Style2) {}
  
  public void handleMessage(Message paramMessage)
  {
    label68:
    Object localObject2;
    label83:
    Object localObject3;
    Object localObject4;
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return;
        if (paramMessage.obj == null) {
          break;
        }
        paramMessage = (List)paramMessage.obj;
        localObject2 = GLWeatherWidget41Style2.access$500(this.a).getCitys().iterator();
      } while (!((Iterator)localObject2).hasNext());
      localObject3 = (GLWeather41Style2)((Iterator)localObject2).next();
      localObject4 = paramMessage.iterator();
      do
      {
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject1 = (WeatherBean)((Iterator)localObject4).next();
      } while (!((WeatherBean)localObject1).c().equals(((GLWeather41Style2)localObject3).getCityId()));
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((GLWeather41Style2)localObject3).setWeatherBean((WeatherBean)localObject1);
        ((GLWeather41Style2)localObject3).mAnimationWeatherIcon = true;
        ((GLWeather41Style2)localObject3).updateAllViews();
      }
      ((GLWeather41Style2)localObject3).showProgerssView(false);
      break label83;
      paramMessage = new ArrayList();
      break label68;
      paramMessage = paramMessage.getData();
      if (paramMessage == null) {
        break;
      }
      GLWeatherWidget41Style2.access$3100(this.a, paramMessage);
      return;
      e.a(paramMessage.arg1, paramMessage.arg2, GLWeatherWidget41Style2.access$500(this.a));
      GLWeatherWidget41Style2.access$500(this.a).notifyViewsChanged();
      GLWeatherWidget41Style2.access$3200(this.a);
      return;
      paramMessage = (WeatherBean)paramMessage.obj;
      if (paramMessage == null) {
        break;
      }
      GLWeatherWidget41Style2.access$3300(this.a);
      paramMessage = GLWeatherWidget41Style2.access$3400(this.a, paramMessage);
      GLWeatherWidget41Style2.access$500(this.a).setCurScreen(GLWeatherWidget41Style2.access$500(this.a).indexOfChild(paramMessage));
      return;
      localObject1 = (ArrayList)paramMessage.obj;
      if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
        break;
      }
      paramMessage = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      int i = 0;
      label329:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = GLWeatherWidget41Style2.access$500(this.a).getCitys().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (GLWeather41Style2)((Iterator)localObject3).next();
          String str = ((GLWeather41Style2)localObject4).getCityId();
          if (((String)localObject2).equals(str))
          {
            if (str.equals(GLWeatherWidget41Style2.access$3500(this.a))) {
              i = 1;
            }
            paramMessage.add(localObject4);
          }
        }
      }
      for (;;)
      {
        break label329;
        localObject1 = (GLWeather41Style2)GLWeatherWidget41Style2.access$500(this.a).getChildAt(GLWeatherWidget41Style2.access$3600(this.a));
        paramMessage = paramMessage.iterator();
        while (paramMessage.hasNext())
        {
          localObject2 = (GLWeather41Style2)paramMessage.next();
          GLWeatherWidget41Style2.access$500(this.a).removeView((GLView)localObject2);
        }
        GLWeatherWidget41Style2.access$500(this.a).notifyViewsChanged();
        if (i != 0)
        {
          GLWeatherWidget41Style2.access$500(this.a).setCurScreen(0);
          return;
        }
        GLWeatherWidget41Style2.access$3602(this.a, GLWeatherWidget41Style2.access$500(this.a).indexOfChild((GLView)localObject1));
        if (GLWeatherWidget41Style2.access$3600(this.a) == -1) {
          GLWeatherWidget41Style2.access$3602(this.a, 0);
        }
        GLWeatherWidget41Style2.access$500(this.a).setCurScreen(GLWeatherWidget41Style2.access$3600(this.a));
        return;
        localObject2 = (WeatherBean)paramMessage.obj;
        if (localObject2 == null) {
          break;
        }
        localObject3 = ((WeatherBean)localObject2).c();
        localObject4 = GLWeatherWidget41Style2.access$500(this.a).getCitys().iterator();
        paramMessage = null;
        if (((Iterator)localObject4).hasNext())
        {
          localObject1 = (GLWeather41Style2)((Iterator)localObject4).next();
          if (localObject1 != null) {
            if (((GLWeather41Style2)localObject1).getCityId().equals(localObject3)) {
              paramMessage = (Message)localObject1;
            }
          }
          for (;;)
          {
            break;
            i = ((GLWeather41Style2)localObject1).getWeatherBean().e();
            if (i == 2)
            {
              GLWeatherWidget41Style2.access$500(this.a).removeView((GLView)localObject1);
              GLWeatherWidget41Style2.access$500(this.a).notifyViewsChanged();
            }
            else if (i == 3)
            {
              ((GLWeather41Style2)localObject1).getWeatherBean().a(1);
            }
          }
        }
        if (paramMessage != null) {
          paramMessage.getWeatherBean().a(3);
        }
        for (i = GLWeatherWidget41Style2.access$500(this.a).indexOfChild(paramMessage); i != -1; i = GLWeatherWidget41Style2.access$500(this.a).indexOfChild(paramMessage))
        {
          GLWeatherWidget41Style2.access$500(this.a).setCurScreen(i);
          return;
          paramMessage = GLWeatherWidget41Style2.access$3400(this.a, (WeatherBean)localObject2);
          GLWeatherWidget41Style2.access$500(this.a).notifyViewsChanged();
        }
        this.a.onBillingStatusChange(((Boolean)paramMessage.obj).booleanValue());
        return;
        GLWeatherWidget41Style2.access$3700(this.a, ((Boolean)paramMessage.obj).booleanValue());
        return;
      }
      localObject1 = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */