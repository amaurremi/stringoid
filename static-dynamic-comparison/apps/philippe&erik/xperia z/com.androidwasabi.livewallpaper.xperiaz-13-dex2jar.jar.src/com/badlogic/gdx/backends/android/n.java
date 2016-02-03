package com.badlogic.gdx.backends.android;

import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.WindowManager;
import com.badlogic.gdx.backends.android.b.x;
import com.badlogic.gdx.c;
import com.badlogic.gdx.h;
import com.badlogic.gdx.p;
import com.badlogic.gdx.utils.e;

public class n
  implements com.badlogic.gdx.a
{
  protected AndroidLiveWallpaperService a;
  protected i b;
  protected j c;
  protected b d;
  protected d e;
  protected c f;
  protected boolean g = true;
  protected final com.badlogic.gdx.utils.a<Runnable> h = new com.badlogic.gdx.utils.a();
  protected final com.badlogic.gdx.utils.a<Runnable> i = new com.badlogic.gdx.utils.a();
  protected final com.badlogic.gdx.utils.a<p> j = new com.badlogic.gdx.utils.a();
  protected int k = 2;
  
  static {}
  
  public n(AndroidLiveWallpaperService paramAndroidLiveWallpaperService)
  {
    this.a = paramAndroidLiveWallpaperService;
  }
  
  public h a()
  {
    return this.b;
  }
  
  public void a(p paramp)
  {
    synchronized (this.j)
    {
      this.j.a(paramp);
      return;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (this.h)
    {
      this.h.a(paramRunnable);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.k >= 2) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (this.k >= 1) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public com.badlogic.gdx.b b()
  {
    return com.badlogic.gdx.b.a;
  }
  
  public void b(p paramp)
  {
    synchronized (this.j)
    {
      this.j.b(paramp, true);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (this.k >= 3) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public void c()
  {
    if (AndroidLiveWallpaperService.a) {
      Log.d("WallpaperService", " > AndroidLiveWallpaper - onPause()");
    }
    this.d.a();
    this.c.d();
    Object localObject = this.c.i;
    int m = 0;
    while (m < localObject.length)
    {
      localObject[m] = -1;
      m += 1;
    }
    localObject = this.c.h;
    m = 0;
    while (m < localObject.length)
    {
      localObject[m] = 0;
      m += 1;
    }
    if ((this.b != null) && (this.b.a != null))
    {
      if (!(this.b.a instanceof x)) {
        break label140;
      }
      ((x)this.b.a).b();
    }
    for (;;)
    {
      if (AndroidLiveWallpaperService.a) {
        Log.d("WallpaperService", " > AndroidLiveWallpaper - onPause() done!");
      }
      return;
      label140:
      if ((this.b.a instanceof com.badlogic.gdx.backends.android.b.j))
      {
        ((com.badlogic.gdx.backends.android.b.j)this.b.a).b();
      }
      else
      {
        if (!(this.b.a instanceof GLSurfaceView)) {
          break;
        }
        ((GLSurfaceView)this.b.a).onPause();
      }
    }
    throw new RuntimeException("unimplemented");
  }
  
  public void d()
  {
    com.badlogic.gdx.g.a = this;
    com.badlogic.gdx.g.d = this.c;
    com.badlogic.gdx.g.c = this.d;
    com.badlogic.gdx.g.e = this.e;
    com.badlogic.gdx.g.b = this.b;
    this.c.c();
    if ((this.b != null) && (this.b.a != null))
    {
      if (!(this.b.a instanceof x)) {
        break label104;
      }
      ((x)this.b.a).c();
    }
    while (!this.g)
    {
      this.d.b();
      this.b.i();
      return;
      label104:
      if ((this.b.a instanceof com.badlogic.gdx.backends.android.b.j)) {
        ((com.badlogic.gdx.backends.android.b.j)this.b.a).c();
      } else if ((this.b.a instanceof GLSurfaceView)) {
        ((GLSurfaceView)this.b.a).onResume();
      } else {
        throw new RuntimeException("unimplemented");
      }
    }
    this.g = false;
  }
  
  public WindowManager e()
  {
    return this.a.c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */