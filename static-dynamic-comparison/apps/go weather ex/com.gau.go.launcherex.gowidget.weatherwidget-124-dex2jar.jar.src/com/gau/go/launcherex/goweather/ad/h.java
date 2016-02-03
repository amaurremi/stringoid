package com.gau.go.launcherex.goweather.ad;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class h
{
  public static Bitmap a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if ("".equals(paramString)) {}
    }
    try
    {
      paramString = Base64.decode(paramString, 0);
      localObject1 = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      return (Bitmap)localObject1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/ad/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */