package com.gtp.go.weather.sharephoto.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;

public class b
{
  private int a;
  private int b;
  private Context c;
  private BitmapFactory.Options d;
  
  public b(Context paramContext)
  {
    this.c = paramContext;
    a();
  }
  
  public void a()
  {
    DisplayMetrics localDisplayMetrics = this.c.getResources().getDisplayMetrics();
    this.a = Math.min(1200, localDisplayMetrics.widthPixels * 2);
    this.b = Math.min(1600, localDisplayMetrics.heightPixels * 2);
  }
  
  public void a(BitmapFactory.Options paramOptions)
  {
    this.d = paramOptions;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public BitmapFactory.Options d()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */