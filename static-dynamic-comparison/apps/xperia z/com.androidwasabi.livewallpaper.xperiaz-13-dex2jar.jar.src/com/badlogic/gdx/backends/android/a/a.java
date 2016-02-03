package com.badlogic.gdx.backends.android.a;

import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.service.wallpaper.WallpaperService.Engine;
import android.util.Log;
import com.badlogic.gdx.backends.android.b.ag;
import com.badlogic.gdx.c;
import com.badlogic.gdx.g;
import com.badlogic.gdx.h;
import com.badlogic.gdx.k;
import com.badlogic.gdx.p;

public class a
  implements com.badlogic.gdx.a
{
  protected WallpaperService a;
  protected WallpaperService.Engine b;
  protected d c;
  protected f d;
  protected b e;
  protected com.badlogic.gdx.backends.android.d f;
  protected c g;
  protected Handler h;
  protected boolean i = true;
  protected final com.badlogic.gdx.utils.a<Runnable> j = new com.badlogic.gdx.utils.a();
  protected final com.badlogic.gdx.utils.a<Runnable> k = new com.badlogic.gdx.utils.a();
  protected int l = 2;
  private final String m = "AndroidApplicationLW";
  
  static {}
  
  public a(WallpaperService paramWallpaperService, WallpaperService.Engine paramEngine)
  {
    this.a = paramWallpaperService;
    this.b = paramEngine;
  }
  
  public h a()
  {
    return this.c;
  }
  
  public void a(c paramc, com.badlogic.gdx.backends.android.a parama, boolean paramBoolean)
  {
    if (parama.o == null) {}
    for (Object localObject = new com.badlogic.gdx.backends.android.b.b();; localObject = parama.o)
    {
      this.c = new d(this, parama, (ag)localObject, paramBoolean);
      this.d = new f(this, parama);
      this.e = new b(f(), parama);
      this.f = new com.badlogic.gdx.backends.android.d(f().getAssets());
      this.g = paramc;
      this.h = new Handler();
      g.a = this;
      g.d = k();
      g.c = i();
      g.e = j();
      g.b = a();
      return;
    }
  }
  
  public void a(p paramp) {}
  
  public void a(Runnable paramRunnable)
  {
    synchronized (this.j)
    {
      this.j.a(paramRunnable);
      g.b.h();
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.l >= 2) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (this.l >= 1) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public com.badlogic.gdx.b b()
  {
    return com.badlogic.gdx.b.a;
  }
  
  public void b(p paramp) {}
  
  public void b(String paramString1, String paramString2)
  {
    if (this.l >= 3) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public void c()
  {
    this.c.j();
    this.d.d();
    int[] arrayOfInt = this.d.h;
    int n = 0;
    for (;;)
    {
      if (n >= arrayOfInt.length) {
        return;
      }
      arrayOfInt[n] = -1;
      n += 1;
    }
  }
  
  public void d()
  {
    g.a = this;
    g.d = k();
    g.c = i();
    g.e = j();
    g.b = a();
    ((f)k()).c();
    if (!this.i)
    {
      this.c.i();
      return;
    }
    this.i = false;
  }
  
  public void e()
  {
    this.c.k();
  }
  
  public WallpaperService f()
  {
    return this.a;
  }
  
  public WallpaperService.Engine g()
  {
    return this.b;
  }
  
  public c h()
  {
    return this.g;
  }
  
  public com.badlogic.gdx.d i()
  {
    return this.e;
  }
  
  public com.badlogic.gdx.e j()
  {
    return this.f;
  }
  
  public k k()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */