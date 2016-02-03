package com.gau.go.launcherex.gowidget.weather.globaltheme.b;

import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public class d
  extends i
{
  private String a;
  private int b;
  private String c;
  private int d = -1;
  private int e = -1;
  private WeakReference f;
  private String g;
  private int h;
  
  public String a()
  {
    return this.g;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int c()
  {
    return this.h;
  }
  
  public void d()
  {
    if (this.f != null)
    {
      Drawable localDrawable = (Drawable)this.f.get();
      if (localDrawable != null) {
        localDrawable.setCallback(null);
      }
      this.f = null;
    }
  }
  
  public String toString()
  {
    return "FeaturedThemeBean [mPreviewPath=" + this.a + ", mDetailtype=" + this.b + ", mDetailurl=" + this.c + ", mPaytype=" + this.d + ", mFeaturedType=" + this.e + ", mPreview=" + this.f + "]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */