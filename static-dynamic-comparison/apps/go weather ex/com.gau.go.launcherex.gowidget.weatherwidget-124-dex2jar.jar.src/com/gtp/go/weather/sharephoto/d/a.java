package com.gtp.go.weather.sharephoto.d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class a
{
  public static HashMap a = new HashMap();
  
  public static Bitmap a(String paramString)
  {
    paramString = (SoftReference)a.get(paramString);
    if (paramString != null) {
      return (Bitmap)paramString.get();
    }
    return null;
  }
  
  public static void a()
  {
    if (a != null) {
      a.clear();
    }
  }
  
  public static void a(String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBitmap != null))
    {
      paramBitmap = new SoftReference(paramBitmap);
      a.put(paramString, paramBitmap);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */