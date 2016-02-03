package com.gau.go.launcherex.goweather.livewallpaper.a;

import android.content.res.Resources;

public class d
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  private int a(Resources paramResources1, Resources paramResources2, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    int j = paramResources1.getIdentifier(paramString2, "array", paramString1);
    int i = j;
    if (j == 0)
    {
      i = paramInt1;
      paramResources1 = paramResources2;
    }
    paramString1 = paramResources1.getIntArray(i);
    paramResources1 = paramString1;
    if (paramInt2 >= paramString1.length) {
      paramResources1 = paramResources2.getIntArray(paramInt1);
    }
    return paramResources1[paramInt2];
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt, boolean paramBoolean, Resources paramResources1, String paramString, Resources paramResources2)
  {
    if (paramInt >= 2)
    {
      i = paramInt;
      if (paramInt <= 8) {}
    }
    else
    {
      i = 2;
    }
    int i = (i - 2) * 2;
    paramInt = i;
    if (!paramBoolean) {
      paramInt = i + 1;
    }
    this.a = a(paramResources1, paramResources2, 2131558461, paramString, paramInt, "wp_text_color_top");
    this.b = a(paramResources1, paramResources2, 2131558463, paramString, paramInt, "wp_text_color_hightemp");
    this.c = a(paramResources1, paramResources2, 2131558464, paramString, paramInt, "wp_text_color_lowtemp");
    this.d = a(paramResources1, paramResources2, 2131558465, paramString, paramInt, "wp_text_color_main");
    this.e = a(paramResources1, paramResources2, 2131558462, paramString, paramInt, "wp_text_color_desp");
    this.h = a(paramResources1, paramResources2, 2131558468, paramString, paramInt, "wp_text_shadow_main");
    this.f = a(paramResources1, paramResources2, 2131558466, paramString, paramInt, "wp_text_shadow_hightemp");
    this.g = a(paramResources1, paramResources2, 2131558467, paramString, paramInt, "wp_text_shadow_lowtemp");
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public int h()
  {
    return this.h;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */