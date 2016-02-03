package com.gau.go.launcherex.goweather.livewallpaper;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.service.wallpaper.WallpaperService;
import android.service.wallpaper.WallpaperService.Engine;
import android.util.DisplayMetrics;
import com.gau.go.launcherex.goweather.livewallpaper.b.a;
import com.gau.go.launcherex.goweather.livewallpaper.b.b;
import com.jiubang.core.a.l;
import java.util.ArrayList;

public class GOWeatherWallpaperService
  extends WallpaperService
  implements a, b, com.gau.go.launcherex.goweather.livewallpaper.b.c, com.gau.go.launcherex.goweather.livewallpaper.b.d, com.gau.go.launcherex.goweather.livewallpaper.b.e, com.gau.go.launcherex.goweather.livewallpaper.b.f, com.gau.go.launcherex.goweather.livewallpaper.b.g
{
  private int a;
  private int b;
  private boolean c = false;
  private h d;
  private f e;
  private p f;
  private k g;
  private boolean h = true;
  private boolean i = true;
  private int j;
  private int k;
  private float l = 0.0F;
  private float m = 0.0F;
  private float n = 0.0F;
  private float o = 0.0F;
  private float p = 0.0F;
  private boolean q = false;
  private ArrayList r = new ArrayList();
  
  private void a()
  {
    int i2 = 0;
    if (!this.h) {}
    for (int i1 = 20;; i1 = 0)
    {
      int i3 = this.r.size();
      while (i2 < i3)
      {
        ((d)this.r.get(i2)).a(i1);
        i2 += 1;
      }
      return;
    }
  }
  
  private void a(float paramFloat)
  {
    int i2 = this.r.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((d)this.r.get(i1)).a(paramFloat);
      i1 += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.l = (paramInt1 * 0.5F);
    this.m = (paramInt2 * 0.5F);
    if (paramInt1 > paramInt2)
    {
      this.c = true;
      this.o = ((paramInt1 - paramInt2) * 0.5F);
      this.p = (-this.o);
      this.n = -90.0F;
      this.a = paramInt2;
      this.b = paramInt1;
      return;
    }
    this.c = false;
    this.o = 0.0F;
    this.p = 0.0F;
    this.n = 0.0F;
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  private void b()
  {
    int i2 = this.r.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((d)this.r.get(i1)).a();
      i1 += 1;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i2 = this.r.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((d)this.r.get(i1)).a(paramBoolean);
      i1 += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.f.a(paramInt, paramBoolean))
    {
      b(this.h);
      a();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d.a(paramInt, paramBoolean1, paramBoolean2, false);
  }
  
  public void a(com.gau.go.launcherex.goweather.livewallpaper.a.e parame, com.gau.go.launcherex.goweather.livewallpaper.a.g paramg, Resources paramResources)
  {
    if (this.f.a(parame, paramg, paramResources)) {
      a();
    }
  }
  
  public void a(com.gau.go.launcherex.goweather.livewallpaper.a.e parame, com.gau.go.launcherex.goweather.livewallpaper.a.g paramg, com.gau.go.launcherex.goweather.livewallpaper.a.c paramc, boolean paramBoolean, Resources paramResources)
  {
    com.gtp.a.a.b.c.a("wallpaper", "GOWeatherWallpaperService.onLoadingWeatherInfoCompleted()");
    this.f.a(parame, paramg, paramc, paramBoolean, paramResources);
    a();
  }
  
  public void a(l paraml, boolean paramBoolean, int paramInt, String paramString)
  {
    float f1 = com.jiubang.core.a.e.a();
    if (f1 > this.a) {}
    for (this.i = false;; this.i = true)
    {
      a(f1);
      if (!this.h)
      {
        this.h = true;
        b();
      }
      this.e.a(paraml, paramBoolean);
      this.f.a(paramInt, this.g.b(), paramString);
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.d.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    a();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    com.gtp.a.a.b.c.a("wallpaper", "GOWeatherWallpaperService.onLoadingWeatherInfoCompleted(boolean, String):[isDynamic]=" + paramBoolean + "|[theme]=" + paramString);
    this.d.a(paramBoolean);
    this.d.a(paramString);
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f.a(paramInt, paramBoolean1, paramBoolean2))
    {
      b(this.h);
      a();
    }
  }
  
  public void b(com.gau.go.launcherex.goweather.livewallpaper.a.e parame, com.gau.go.launcherex.goweather.livewallpaper.a.g paramg, Resources paramResources)
  {
    if (this.f.b(parame, paramg, paramResources)) {
      a();
    }
  }
  
  public void b(com.gau.go.launcherex.goweather.livewallpaper.a.e parame, com.gau.go.launcherex.goweather.livewallpaper.a.g paramg, com.gau.go.launcherex.goweather.livewallpaper.a.c paramc, boolean paramBoolean, Resources paramResources)
  {
    com.gtp.a.a.b.c.a("wallpaper", "GOWeatherWallpaperService.onUpdateWeatherInfo()");
    this.f.a(parame, paramg, paramc, paramBoolean, paramResources);
    this.d.a(parame.i(), paramc.d(), paramBoolean, false);
    b(this.h);
    a();
  }
  
  public void b(String paramString)
  {
    com.gtp.a.a.b.c.a("wallpaper", "onLoadingBackgroundScriptAllCompleted:[packageName]=" + paramString);
    this.g.a(paramString);
    this.d.a(this.g.d().i(), this.g.c().d(), this.g.b(), true);
  }
  
  public void c(com.gau.go.launcherex.goweather.livewallpaper.a.e parame, com.gau.go.launcherex.goweather.livewallpaper.a.g paramg, Resources paramResources)
  {
    this.f.c(parame, paramg, paramResources);
    b(this.h);
    a();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      this.c = false;
      return;
    }
    this.c = true;
  }
  
  public WallpaperService.Engine onCreateEngine()
  {
    Object localObject = getResources().getDisplayMetrics();
    this.j = ((DisplayMetrics)localObject).widthPixels;
    this.k = ((DisplayMetrics)localObject).heightPixels;
    a(this.j, this.k);
    if (this.e == null)
    {
      localObject = getApplicationContext();
      this.e = new f(this);
      this.e.a();
      this.d = new h((Context)localObject, this, this);
      this.f = new p((Context)localObject);
      this.g = new k((Context)localObject, this, this, this, this);
      this.g.a();
    }
    localObject = new d(this);
    this.r.add(localObject);
    return (WallpaperService.Engine)localObject;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.e != null) {
      this.e.b();
    }
    if (this.f != null) {
      this.f.a();
    }
    if (this.g != null) {
      this.g.f();
    }
    if (this.d != null) {
      this.d.b();
    }
    this.r.clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/livewallpaper/GOWeatherWallpaperService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */