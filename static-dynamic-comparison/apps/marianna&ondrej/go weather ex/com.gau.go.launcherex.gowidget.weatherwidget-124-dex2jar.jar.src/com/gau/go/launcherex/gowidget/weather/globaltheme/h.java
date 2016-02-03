package com.gau.go.launcherex.gowidget.weather.globaltheme;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.globaltheme.c.d;
import com.gtp.a.a.b.c;
import java.util.ArrayList;

public class h
{
  public static ArrayList a(Context paramContext, e parame)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    if (parame == null) {
      return localArrayList;
    }
    if ((parame.C()) && ("app_widget_theme_white".equals(parame.x()))) {}
    for (;;)
    {
      try
      {
        paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130838049);
        if (paramContext != null) {
          localArrayList.add(paramContext);
        }
        return localArrayList;
      }
      catch (OutOfMemoryError parame)
      {
        paramContext = (Context)localObject1;
        if (!c.a()) {
          continue;
        }
        parame.printStackTrace();
        paramContext = (Context)localObject1;
        continue;
      }
      if ((parame.D()) && (parame.x().contains("app_widget_theme")))
      {
        if (d.a(paramContext, parame.x()).equals("1")) {
          try
          {
            parame = BitmapFactory.decodeResource(paramContext.getResources(), 2130838852);
            if (parame != null) {
              localArrayList.add(parame);
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            try
            {
              do
              {
                paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130838853);
                if (paramContext == null) {
                  break;
                }
                localArrayList.add(paramContext);
                break;
                localOutOfMemoryError = localOutOfMemoryError;
                parame = (e)localObject3;
              } while (!c.a());
              localOutOfMemoryError.printStackTrace();
              parame = (e)localObject3;
            }
            catch (OutOfMemoryError paramContext)
            {
              for (;;)
              {
                if (c.a()) {
                  paramContext.printStackTrace();
                }
                paramContext = parame;
              }
            }
          }
        }
      }
      else if ("com.gau.go.weatherex.nextwidget.style.one".equals(parame.x())) {
        try
        {
          paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130838344);
          if (paramContext != null) {
            localArrayList.add(paramContext);
          }
        }
        catch (OutOfMemoryError paramContext)
        {
          for (;;)
          {
            if (c.a()) {
              paramContext.printStackTrace();
            }
            paramContext = null;
          }
        }
      }
    }
    Object localObject2 = "theme_big_preview_default";
    if (parame.D()) {
      localObject2 = "theme_big_preview_appwidget";
    }
    for (;;)
    {
      localObject2 = a.d(paramContext, parame.x(), (String)localObject2);
      if (localObject2 == null) {
        break;
      }
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        localObject3 = localObject2[i];
        localObject3 = a.a(paramContext, parame.x(), (String)localObject3);
        if ((localObject3 != null) && ((localObject3 instanceof BitmapDrawable))) {
          localArrayList.add(((BitmapDrawable)localObject3).getBitmap());
        }
        i += 1;
      }
      break;
      if (parame.C()) {
        localObject2 = "theme_big_preview_gowidget";
      } else if ((parame.s()) && (parame.t())) {
        localObject2 = "theme_big_preview_background_wallpaper";
      } else if (parame.t()) {
        localObject2 = "theme_big_preview_wallpaper";
      } else if (parame.s()) {
        localObject2 = "theme_big_preview_background";
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */