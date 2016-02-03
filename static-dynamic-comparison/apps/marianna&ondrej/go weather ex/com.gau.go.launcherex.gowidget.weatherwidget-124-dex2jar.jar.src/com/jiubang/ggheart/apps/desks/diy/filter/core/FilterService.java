package com.jiubang.ggheart.apps.desks.diy.filter.core;

import android.content.Context;
import android.graphics.Bitmap;
import com.gtp.a.a.b.c;
import java.util.List;

public class FilterService
{
  public static final int USE_TYPE_ICON = 1;
  public static final int USE_TYPE_WALLPAPER = 0;
  private static FilterService a;
  public static boolean sLoadLibError;
  private FilterParameterBuidler b;
  private FilterRender c;
  private Context d;
  
  static
  {
    try
    {
      System.loadLibrary("GOFilter");
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        sLoadLibError = true;
      } while (!c.a());
      localThrowable.printStackTrace();
    }
  }
  
  private FilterService(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
    this.b = new FilterParameterBuidler(paramContext);
    this.c = new FilterRender(paramContext);
  }
  
  private void a()
  {
    if (this.b != null)
    {
      this.b.cleanUp();
      this.b = null;
    }
    if (this.c != null)
    {
      this.c.cleanUp();
      this.c = null;
    }
  }
  
  public static void destroy()
  {
    try
    {
      if (a != null)
      {
        a.a();
        a = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static FilterService getService(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new FilterService(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public List getAllFilter(int paramInt)
  {
    if (this.b == null) {
      this.b = new FilterParameterBuidler(this.d);
    }
    return this.b.buildParameter(paramInt);
  }
  
  public Bitmap render(FilterParameter paramFilterParameter)
  {
    if (this.c == null) {
      this.c = new FilterRender(this.d);
    }
    return this.c.render(paramFilterParameter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/ggheart/apps/desks/diy/filter/core/FilterService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */