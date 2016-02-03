package com.badlogic.gdx.backends.android;

import android.content.res.Configuration;
import android.opengl.GLSurfaceView;
import android.os.PowerManager.WakeLock;
import android.service.dreams.DreamService;
import android.util.Log;
import com.badlogic.gdx.backends.android.b.x;
import com.badlogic.gdx.c;
import com.badlogic.gdx.g;
import com.badlogic.gdx.k;
import com.badlogic.gdx.p;
import com.badlogic.gdx.q;

public class AndroidDaydream
  extends DreamService
  implements com.badlogic.gdx.a
{
  protected h a;
  protected j b;
  protected b c;
  protected d d;
  protected t e;
  protected c f;
  protected boolean g = true;
  protected final com.badlogic.gdx.utils.a<Runnable> h = new com.badlogic.gdx.utils.a();
  protected final com.badlogic.gdx.utils.a<Runnable> i = new com.badlogic.gdx.utils.a();
  protected final com.badlogic.gdx.utils.a<p> j = new com.badlogic.gdx.utils.a();
  protected PowerManager.WakeLock k = null;
  protected int l = 2;
  
  static {}
  
  public com.badlogic.gdx.h a()
  {
    return this.a;
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
    if (this.l >= 3) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public com.badlogic.gdx.d c()
  {
    return this.c;
  }
  
  public com.badlogic.gdx.e d()
  {
    return this.d;
  }
  
  public k e()
  {
    return this.b;
  }
  
  public q f()
  {
    return this.e;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    boolean bool = true;
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.hardKeyboardHidden == 1) {}
    for (;;)
    {
      this.b.m = bool;
      return;
      bool = false;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onDreamingStarted()
  {
    if (this.k != null) {
      this.k.acquire();
    }
    g.a = this;
    g.d = e();
    g.c = c();
    g.e = d();
    g.b = a();
    g.f = f();
    ((j)e()).c();
    if ((this.a != null) && (this.a.a != null))
    {
      if ((this.a.a instanceof x)) {
        ((x)this.a.a).c();
      }
      if ((this.a.a instanceof com.badlogic.gdx.backends.android.b.j)) {
        ((com.badlogic.gdx.backends.android.b.j)this.a.a).c();
      }
      if ((this.a.a instanceof GLSurfaceView)) {
        ((GLSurfaceView)this.a.a).onResume();
      }
    }
    if (!this.g) {
      this.a.i();
    }
    for (;;)
    {
      super.onDreamingStarted();
      return;
      this.g = false;
    }
  }
  
  public void onDreamingStopped()
  {
    if (this.k != null) {
      this.k.release();
    }
    boolean bool = this.a.m();
    this.a.a(true);
    this.a.j();
    this.b.d();
    Object localObject = this.b.i;
    int m = 0;
    while (m < localObject.length)
    {
      localObject[m] = -1;
      m += 1;
    }
    localObject = this.b.h;
    m = 0;
    while (m < localObject.length)
    {
      localObject[m] = 0;
      m += 1;
    }
    this.a.l();
    this.a.k();
    this.a.a(bool);
    if ((this.a != null) && (this.a.a != null))
    {
      if ((this.a.a instanceof x)) {
        ((x)this.a.a).b();
      }
      if ((this.a.a instanceof com.badlogic.gdx.backends.android.b.j)) {
        ((com.badlogic.gdx.backends.android.b.j)this.a.a).b();
      }
      if ((this.a.a instanceof GLSurfaceView)) {
        ((GLSurfaceView)this.a.a).onPause();
      }
    }
    super.onDreamingStopped();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/AndroidDaydream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */