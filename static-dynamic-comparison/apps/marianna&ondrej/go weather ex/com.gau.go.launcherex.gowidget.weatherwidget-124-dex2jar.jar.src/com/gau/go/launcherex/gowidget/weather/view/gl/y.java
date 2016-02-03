package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.e.h;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.model.WidgetSettingBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class y
  extends Handler
{
  private final WeakReference a;
  
  public y(GLWeatherWidget41Style2 paramGLWeatherWidget41Style2)
  {
    this.a = new WeakReference(paramGLWeatherWidget41Style2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    GLWeatherWidget41Style2 localGLWeatherWidget41Style2 = (GLWeatherWidget41Style2)this.a.get();
    if (localGLWeatherWidget41Style2 == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          case 5: 
          default: 
            return;
          case 1: 
            localGLWeatherWidget41Style2.mIsPro = true;
            localGLWeatherWidget41Style2.mSettings.h = true;
            GLWeatherWidget41Style2.access$800(localGLWeatherWidget41Style2).a(true);
            GLWeatherWidget41Style2.access$1100(localGLWeatherWidget41Style2);
            return;
          case 2: 
            localGLWeatherWidget41Style2.mSettings.h = ((Boolean)paramMessage.obj).booleanValue();
          }
        } while ((localGLWeatherWidget41Style2.mSettings.h) && (!localGLWeatherWidget41Style2.mIsPro));
        GLWeatherWidget41Style2.access$800(localGLWeatherWidget41Style2).a(localGLWeatherWidget41Style2.mSettings.h);
        GLWeatherWidget41Style2.access$1100(localGLWeatherWidget41Style2);
        return;
        paramMessage = (String)paramMessage.obj;
      } while ((TextUtils.isEmpty(GLWeatherWidget41Style2.access$2300(localGLWeatherWidget41Style2))) || (!h.a(localGLWeatherWidget41Style2.getContext(), GLWeatherWidget41Style2.access$200(localGLWeatherWidget41Style2), GLWeatherWidget41Style2.access$2300(localGLWeatherWidget41Style2))));
      if (GLWeatherWidget41Style2.access$2300(localGLWeatherWidget41Style2).equals("app_widget_theme_white"))
      {
        GLWeatherWidget41Style2.access$2302(localGLWeatherWidget41Style2, localGLWeatherWidget41Style2.getContext().getPackageName());
        GLWeatherWidget41Style2.access$2402(localGLWeatherWidget41Style2, 0);
      }
      for (;;)
      {
        GLWeatherWidget41Style2.access$2000(localGLWeatherWidget41Style2);
        GLWeatherWidget41Style2.access$2500(localGLWeatherWidget41Style2, GLWeatherWidget41Style2.access$2300(localGLWeatherWidget41Style2));
        return;
        if (paramMessage.equals("app_widget_theme_black"))
        {
          GLWeatherWidget41Style2.access$2302(localGLWeatherWidget41Style2, localGLWeatherWidget41Style2.getContext().getPackageName());
          GLWeatherWidget41Style2.access$2402(localGLWeatherWidget41Style2, 0);
        }
        else
        {
          GLWeatherWidget41Style2.access$2302(localGLWeatherWidget41Style2, paramMessage);
          GLWeatherWidget41Style2.access$2402(localGLWeatherWidget41Style2, 0);
        }
      }
      GLWeatherWidget41Style2.access$2600(localGLWeatherWidget41Style2);
      return;
    } while (GLWeatherWidget41Style2.access$1700(localGLWeatherWidget41Style2).isEmpty());
    paramMessage = (e)GLWeatherWidget41Style2.access$1700(localGLWeatherWidget41Style2).get(GLWeatherWidget41Style2.access$2700(localGLWeatherWidget41Style2) % GLWeatherWidget41Style2.access$1700(localGLWeatherWidget41Style2).size());
    GLWeatherWidget41Style2.access$2800(localGLWeatherWidget41Style2).a(2, paramMessage);
    return;
    GLWeatherWidget41Style2.access$1702(localGLWeatherWidget41Style2, com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.e(GLWeatherWidget41Style2.access$2900(localGLWeatherWidget41Style2), localGLWeatherWidget41Style2.getResources()));
    GLWeatherWidget41Style2.access$1900(localGLWeatherWidget41Style2);
    GLWeatherWidget41Style2.access$2000(localGLWeatherWidget41Style2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */