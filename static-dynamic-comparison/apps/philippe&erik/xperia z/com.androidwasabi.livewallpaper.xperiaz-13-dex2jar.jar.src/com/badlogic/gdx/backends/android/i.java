package com.badlogic.gdx.backends.android;

import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.badlogic.gdx.backends.android.b.x;
import com.badlogic.gdx.g;
import com.badlogic.gdx.graphics.glutils.k;
import com.badlogic.gdx.graphics.p;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public final class i
  implements GLSurfaceView.Renderer, com.badlogic.gdx.h
{
  boolean A;
  int[] B;
  Object C;
  private com.badlogic.gdx.i D;
  final View a;
  int b;
  int c;
  n d;
  protected com.badlogic.gdx.graphics.f e;
  protected com.badlogic.gdx.graphics.c f;
  protected com.badlogic.gdx.graphics.d g;
  protected com.badlogic.gdx.graphics.e h;
  protected EGLContext i;
  protected String j;
  protected long k;
  protected float l;
  protected long m;
  protected int n;
  protected int o;
  protected com.badlogic.gdx.math.h p;
  volatile boolean q;
  volatile boolean r;
  volatile boolean s;
  volatile boolean t;
  volatile boolean u;
  protected float v;
  protected float w;
  protected float x;
  protected float y;
  protected float z;
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.B)) {
      paramInt2 = this.B[0];
    }
    return paramInt2;
  }
  
  private void a(EGLConfig paramEGLConfig)
  {
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int i1 = a(localEGL10, localEGLDisplay, paramEGLConfig, 12324, 0);
    int i2 = a(localEGL10, localEGLDisplay, paramEGLConfig, 12323, 0);
    int i3 = a(localEGL10, localEGLDisplay, paramEGLConfig, 12322, 0);
    int i4 = a(localEGL10, localEGLDisplay, paramEGLConfig, 12321, 0);
    int i5 = a(localEGL10, localEGLDisplay, paramEGLConfig, 12325, 0);
    int i6 = a(localEGL10, localEGLDisplay, paramEGLConfig, 12326, 0);
    int i7 = Math.max(a(localEGL10, localEGLDisplay, paramEGLConfig, 12337, 0), a(localEGL10, localEGLDisplay, paramEGLConfig, 12513, 0));
    if (a(localEGL10, localEGLDisplay, paramEGLConfig, 12513, 0) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (!this.A)
      {
        if (this.e != null)
        {
          g.a.a("AndroidGraphics", "OGL renderer: " + this.e.glGetString(7937));
          g.a.a("AndroidGraphics", "OGL vendor: " + this.e.glGetString(7936));
          g.a.a("AndroidGraphics", "OGL version: " + this.e.glGetString(7938));
          g.a.a("AndroidGraphics", "OGL extensions: " + this.e.glGetString(7939));
          this.A = true;
        }
        g.a.a("AndroidGraphics", "framebuffer: (" + i1 + ", " + i2 + ", " + i3 + ", " + i4 + ")");
        g.a.a("AndroidGraphics", "depthbuffer: (" + i5 + ")");
        g.a.a("AndroidGraphics", "stencilbuffer: (" + i6 + ")");
        g.a.a("AndroidGraphics", "samples: (" + i7 + ")");
        g.a.a("AndroidGraphics", "coverage sampling: (" + bool + ")");
      }
      this.D = new com.badlogic.gdx.i(i1, i2, i3, i4, i5, i6, i7, bool);
      return;
    }
  }
  
  private void a(GL10 paramGL10)
  {
    if ((this.f != null) || (this.h != null)) {
      return;
    }
    if ((this.a instanceof com.badlogic.gdx.backends.android.b.h))
    {
      this.h = new AndroidGL20();
      this.e = this.h;
    }
    for (;;)
    {
      g.g = this.e;
      g.h = this.f;
      g.i = this.g;
      g.j = this.h;
      return;
      this.f = new e(paramGL10);
      this.e = this.f;
      if ((paramGL10 instanceof GL11))
      {
        String str = paramGL10.glGetString(7937);
        if ((str != null) && (!str.toLowerCase().contains("pixelflinger")) && (!Build.MODEL.equals("MB200")) && (!Build.MODEL.equals("MB220")) && (!Build.MODEL.contains("Behold")))
        {
          this.g = new f((GL11)paramGL10);
          this.f = this.g;
        }
      }
    }
  }
  
  private void k()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.d.e().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.v = localDisplayMetrics.xdpi;
    this.w = localDisplayMetrics.ydpi;
    this.x = (localDisplayMetrics.xdpi / 2.54F);
    this.y = (localDisplayMetrics.ydpi / 2.54F);
    this.z = localDisplayMetrics.density;
  }
  
  public boolean a()
  {
    return this.h != null;
  }
  
  public boolean a(String paramString)
  {
    if (this.j == null) {
      this.j = g.g.glGetString(7939);
    }
    return this.j.contains(paramString);
  }
  
  public com.badlogic.gdx.graphics.c b()
  {
    return this.f;
  }
  
  public com.badlogic.gdx.graphics.d c()
  {
    return this.g;
  }
  
  public com.badlogic.gdx.graphics.e d()
  {
    return this.h;
  }
  
  public int e()
  {
    return this.b;
  }
  
  public int f()
  {
    return this.c;
  }
  
  public float g()
  {
    if (this.p.c() == 0.0F) {
      return this.l;
    }
    return this.p.c();
  }
  
  public void h()
  {
    if (this.a != null)
    {
      if ((this.a instanceof x)) {
        ((x)this.a).a();
      }
    }
    else {
      return;
    }
    if ((this.a instanceof com.badlogic.gdx.backends.android.b.j))
    {
      ((com.badlogic.gdx.backends.android.b.j)this.a).a();
      return;
    }
    if ((this.a instanceof GLSurfaceView))
    {
      ((GLSurfaceView)this.a).requestRender();
      return;
    }
    throw new RuntimeException("unimplemented");
  }
  
  void i()
  {
    synchronized (this.C)
    {
      this.r = true;
      this.t = true;
      for (;;)
      {
        boolean bool = this.t;
        if (bool) {
          try
          {
            this.C.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            g.a.a("AndroidGraphics", "waiting for resume synchronization failed!");
          }
        }
      }
    }
  }
  
  public void j()
  {
    com.badlogic.gdx.graphics.h.b(this.d);
    p.a(this.d);
    k.b(this.d);
    com.badlogic.gdx.graphics.glutils.d.b(this.d);
    if (AndroidLiveWallpaperService.a)
    {
      g.a.b("AndroidGraphics", com.badlogic.gdx.graphics.h.e());
      g.a.b("AndroidGraphics", p.o());
      g.a.b("AndroidGraphics", k.f());
      g.a.b("AndroidGraphics", com.badlogic.gdx.graphics.glutils.d.b());
    }
  }
  
  public void onDrawFrame(GL10 arg1)
  {
    long l1 = System.nanoTime();
    this.l = ((float)(l1 - this.k) / 1.0E9F);
    this.k = l1;
    ??? = this.p;
    float f1;
    if (this.t) {
      f1 = 0.0F;
    }
    boolean bool2;
    boolean bool3;
    for (;;)
    {
      ???.a(f1);
      synchronized (this.C)
      {
        boolean bool1 = this.r;
        bool2 = this.s;
        bool3 = this.u;
        boolean bool4 = this.t;
        if (this.t)
        {
          this.t = false;
          this.C.notifyAll();
        }
        if (this.s)
        {
          this.s = false;
          this.C.notifyAll();
        }
        if (this.u)
        {
          this.u = false;
          this.C.notifyAll();
        }
        if (bool4)
        {
          this.d.f.b();
          g.a.a("AndroidGraphics", "resumed");
        }
        if (!bool1) {
          break label353;
        }
        if ((g.b.b() == null) && (g.b.c() == null)) {
          if (g.b.d() == null) {
            break label353;
          }
        }
      }
      synchronized (this.d.h)
      {
        this.d.i.b();
        this.d.i.a(this.d.h);
        this.d.h.b();
        int i1 = 0;
        label253:
        int i2 = this.d.i.b;
        if (i1 < i2) {
          try
          {
            ((Runnable)this.d.i.a(i1)).run();
            i1 += 1;
            break label253;
            f1 = this.l;
            continue;
            localObject1 = finally;
            throw ((Throwable)localObject1);
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localThrowable.printStackTrace();
            }
          }
        }
      }
    }
    this.d.c.b();
    this.d.f.c();
    label353:
    if (bool2)
    {
      this.d.f.d();
      g.a.a("AndroidGraphics", "paused");
    }
    if (bool3)
    {
      this.d.f.e();
      g.a.a("AndroidGraphics", "destroyed");
    }
    if (l1 - this.m > 1000000000L)
    {
      this.o = this.n;
      this.n = 0;
      this.m = l1;
    }
    this.n += 1;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    k();
    paramGL10.glViewport(0, 0, this.b, this.c);
    if (!this.q)
    {
      this.d.f.a();
      this.q = true;
    }
    try
    {
      this.r = true;
      this.d.f.a(paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.i = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
    a(paramGL10);
    a(paramEGLConfig);
    k();
    com.badlogic.gdx.graphics.h.a(this.d);
    p.b(this.d);
    k.a(this.d);
    com.badlogic.gdx.graphics.glutils.d.a(this.d);
    if (AndroidLiveWallpaperService.a)
    {
      g.a.b("AndroidGraphics", com.badlogic.gdx.graphics.h.e());
      g.a.b("AndroidGraphics", p.o());
      g.a.b("AndroidGraphics", k.f());
      g.a.b("AndroidGraphics", com.badlogic.gdx.graphics.glutils.d.b());
    }
    paramEGLConfig = this.d.e().getDefaultDisplay();
    this.b = paramEGLConfig.getWidth();
    this.c = paramEGLConfig.getHeight();
    this.p = new com.badlogic.gdx.math.h(5);
    this.k = System.nanoTime();
    paramGL10.glViewport(0, 0, this.b, this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */