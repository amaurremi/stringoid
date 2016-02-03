package com.gau.go.launcherex.gowidget.weather.util;

import android.view.View;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.scroller.GLWidgetScrollGroup;
import com.gau.go.launcherex.gowidget.weather.scroller.WidgetScrollGroup;
import com.go.gl.view.GLView;
import java.util.List;

public class e
{
  public static GLWidgetScrollGroup a(int paramInt1, int paramInt2, GLWidgetScrollGroup paramGLWidgetScrollGroup)
  {
    int i = 0;
    if (paramGLWidgetScrollGroup != null) {
      i = paramGLWidgetScrollGroup.getChildCount();
    }
    if ((i > 1) && (paramInt1 != paramInt2) && (paramInt1 >= 0) && (paramInt1 < i) && (paramInt2 >= 0) && (paramInt2 < i))
    {
      GLView localGLView = paramGLWidgetScrollGroup.getChildAt(paramInt1);
      paramGLWidgetScrollGroup.removeView(localGLView);
      paramGLWidgetScrollGroup.addView(localGLView, paramInt2);
      return paramGLWidgetScrollGroup;
    }
    return null;
  }
  
  public static WidgetScrollGroup a(int paramInt1, int paramInt2, WidgetScrollGroup paramWidgetScrollGroup)
  {
    int i = 0;
    if (paramWidgetScrollGroup != null) {
      i = paramWidgetScrollGroup.getChildCount();
    }
    if ((i > 1) && (paramInt1 != paramInt2) && (paramInt1 >= 0) && (paramInt1 < i) && (paramInt2 >= 0) && (paramInt2 < i))
    {
      View localView = paramWidgetScrollGroup.getChildAt(paramInt1);
      paramWidgetScrollGroup.removeView(localView);
      paramWidgetScrollGroup.addView(localView, paramInt2);
      return paramWidgetScrollGroup;
    }
    return null;
  }
  
  public static boolean a(int paramInt1, int paramInt2, List paramList)
  {
    boolean bool2 = false;
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      boolean bool1 = bool2;
      if (i > 1)
      {
        bool1 = bool2;
        if (paramInt1 != paramInt2)
        {
          bool1 = bool2;
          if (paramInt1 >= 0)
          {
            bool1 = bool2;
            if (paramInt1 < i)
            {
              bool1 = bool2;
              if (paramInt2 >= 0)
              {
                bool1 = bool2;
                if (paramInt2 < i)
                {
                  WeatherBean localWeatherBean = (WeatherBean)paramList.get(paramInt1);
                  if (paramInt1 < paramInt2)
                  {
                    i = paramInt1 + 1;
                    while (i < paramInt2 + 1)
                    {
                      ((WeatherBean)paramList.get(i)).e(i - 1);
                      i += 1;
                    }
                  }
                  if (paramInt1 > paramInt2)
                  {
                    i = paramInt2;
                    while (i < paramInt1)
                    {
                      ((WeatherBean)paramList.get(i)).e(i + 1);
                      i += 1;
                    }
                  }
                  localWeatherBean.e(paramInt2);
                  paramList.add(paramInt2, (WeatherBean)paramList.remove(paramInt1));
                  bool1 = true;
                }
              }
            }
          }
        }
      }
      return bool1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */