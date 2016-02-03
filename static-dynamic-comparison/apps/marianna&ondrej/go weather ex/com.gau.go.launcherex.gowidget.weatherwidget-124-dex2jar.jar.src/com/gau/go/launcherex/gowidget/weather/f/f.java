package com.gau.go.launcherex.gowidget.weather.f;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class f
{
  private static f a = new f();
  private Context b;
  private Resources c;
  
  public static Bitmap a(Drawable paramDrawable)
  {
    try
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      return paramDrawable;
    }
    catch (Exception paramDrawable) {}
    return null;
  }
  
  public static f a(Context paramContext)
  {
    if (a == null) {
      a = new f();
    }
    return a;
  }
  
  public int a(String paramString1, String paramString2)
  {
    int j = 0;
    int i = j;
    if (paramString1 != null)
    {
      i = j;
      if (paramString1.equals("")) {}
    }
    try
    {
      i = this.c.getIdentifier(paramString1, "layout", paramString2);
      return i;
    }
    catch (Exception paramString1) {}
    return 0;
  }
  
  public void a(Context paramContext, String paramString)
  {
    Resources localResources = paramContext.getApplicationContext().getResources();
    if (!paramString.equals(paramContext.getPackageName())) {}
    try
    {
      for (this.b = paramContext.getApplicationContext().createPackageContext(paramString, 2); this.b != null; this.b = paramContext)
      {
        this.c = this.b.getResources();
        return;
      }
      this.c = localResources;
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  public int b(String paramString1, String paramString2)
  {
    int j = 0;
    int i = j;
    if (paramString1 != null)
    {
      i = j;
      if (!paramString1.equals("")) {
        i = j;
      }
    }
    try
    {
      if (this.c != null) {
        i = this.c.getIdentifier(paramString1, "id", paramString2);
      }
      return i;
    }
    catch (Exception paramString1) {}
    return 0;
  }
  
  public int c(String paramString1, String paramString2)
  {
    int j = 0;
    int i = j;
    if (paramString1 != null)
    {
      i = j;
      if (paramString1.equals("")) {}
    }
    try
    {
      i = this.c.getIdentifier(paramString1, "drawable", paramString2);
      return i;
    }
    catch (Exception paramString1) {}
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */