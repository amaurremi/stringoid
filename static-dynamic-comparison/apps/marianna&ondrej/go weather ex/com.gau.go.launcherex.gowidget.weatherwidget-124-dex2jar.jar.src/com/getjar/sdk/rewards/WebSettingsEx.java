package com.getjar.sdk.rewards;

import android.webkit.WebSettings;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

public abstract class WebSettingsEx
{
  private static Class _ZoomDensityClass = null;
  
  static
  {
    _ZoomDensityClass = null;
    Class[] arrayOfClass = WebSettings.class.getDeclaredClasses();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        if ("ZoomDensity".equals(localClass.getSimpleName())) {
          _ZoomDensityClass = localClass;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public static void setDefaultZoom(WebSettings paramWebSettings, Object paramObject)
  {
    try
    {
      if (_ZoomDensityClass != null)
      {
        if (paramObject != null) {
          break label45;
        }
        throw new IllegalArgumentException("'value' can not be NULL");
      }
    }
    catch (Exception paramWebSettings)
    {
      paramWebSettings.printStackTrace();
      Logger.w(Area.UI.value(), "Unable to call WebSettings.setDefaultZoom(ZoomDensity.%1$s)", new Object[] { paramObject });
    }
    return;
    label45:
    if (!_ZoomDensityClass.isInstance(paramObject)) {
      throw new IllegalArgumentException(String.format(Locale.US, "'value' must be an instance of %1$s", new Object[] { _ZoomDensityClass.getName() }));
    }
    paramWebSettings.getClass().getMethod("setDefaultZoom", new Class[] { _ZoomDensityClass }).invoke(paramWebSettings, new Object[] { paramObject });
    Logger.v(Area.UI.value(), "WebSettings.setDefaultZoom(ZoomDensity.%1$s) successfully called", new Object[] { paramObject });
  }
  
  public static class ZoomDensity
  {
    public static Object CLOSE = null;
    public static Object FAR = null;
    public static Object MEDIUM = null;
    
    static
    {
      for (;;)
      {
        int i;
        Object localObject;
        try
        {
          if (WebSettingsEx._ZoomDensityClass != null)
          {
            Object[] arrayOfObject = WebSettingsEx._ZoomDensityClass.getEnumConstants();
            int j = arrayOfObject.length;
            i = 0;
            if (i < j)
            {
              localObject = arrayOfObject[i];
              localObject.getClass().getDeclaredField("value").setAccessible(true);
              if ("FAR".equals(localObject.toString())) {
                FAR = localObject;
              } else if ("MEDIUM".equals(localObject.toString())) {
                MEDIUM = localObject;
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        return;
        if ("CLOSE".equals(localObject.toString())) {
          CLOSE = localObject;
        }
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/WebSettingsEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */