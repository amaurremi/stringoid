package com.badlogic.gdx.backends.android;

import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.badlogic.gdx.backends.android.b.x;
import com.badlogic.gdx.graphics.glutils.k;
import com.badlogic.gdx.i;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public final class g
  implements GLSurfaceView.Renderer, com.badlogic.gdx.h
{
  private float A;
  private float B;
  private i C;
  private boolean D;
  final View a;
  int b;
  int c;
  AndroidApplication d;
  com.badlogic.gdx.graphics.f e;
  com.badlogic.gdx.graphics.c f;
  com.badlogic.gdx.graphics.d g;
  com.badlogic.gdx.graphics.e h;
  EGLContext i;
  String j;
  volatile boolean k;
  volatile boolean l;
  volatile boolean m;
  volatile boolean n;
  volatile boolean o;
  int[] p;
  Object q;
  private long r;
  private float s;
  private long t;
  private int u;
  private int v;
  private com.badlogic.gdx.math.h w;
  private float x;
  private float y;
  private float z;
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.p)) {
      paramInt2 = this.p[0];
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
      com.badlogic.gdx.g.a.a("AndroidGraphics", "framebuffer: (" + i1 + ", " + i2 + ", " + i3 + ", " + i4 + ")");
      com.badlogic.gdx.g.a.a("AndroidGraphics", "depthbuffer: (" + i5 + ")");
      com.badlogic.gdx.g.a.a("AndroidGraphics", "stencilbuffer: (" + i6 + ")");
      com.badlogic.gdx.g.a.a("AndroidGraphics", "samples: (" + i7 + ")");
      com.badlogic.gdx.g.a.a("AndroidGraphics", "coverage sampling: (" + bool + ")");
      this.C = new i(i1, i2, i3, i4, i5, i6, i7, bool);
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
      com.badlogic.gdx.g.g = this.e;
      com.badlogic.gdx.g.h = this.f;
      com.badlogic.gdx.g.i = this.g;
      com.badlogic.gdx.g.j = this.h;
      com.badlogic.gdx.g.a.a("AndroidGraphics", "OGL renderer: " + paramGL10.glGetString(7937));
      com.badlogic.gdx.g.a.a("AndroidGraphics", "OGL vendor: " + paramGL10.glGetString(7936));
      com.badlogic.gdx.g.a.a("AndroidGraphics", "OGL version: " + paramGL10.glGetString(7938));
      com.badlogic.gdx.g.a.a("AndroidGraphics", "OGL extensions: " + paramGL10.glGetString(7939));
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
  
  private void n()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.d.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.x = localDisplayMetrics.xdpi;
    this.y = localDisplayMetrics.ydpi;
    this.z = (localDisplayMetrics.xdpi / 2.54F);
    this.A = (localDisplayMetrics.ydpi / 2.54F);
    this.B = localDisplayMetrics.density;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null)
    {
      this.D = paramBoolean;
      if (!paramBoolean) {
        break label89;
      }
    }
    label89:
    for (int i1 = 1;; i1 = 0)
    {
      if ((this.a instanceof x)) {
        ((x)this.a).setRenderMode(i1);
      }
      if ((this.a instanceof com.badlogic.gdx.backends.android.b.j)) {
        ((com.badlogic.gdx.backends.android.b.j)this.a).setRenderMode(i1);
      }
      if ((this.a instanceof GLSurfaceView)) {
        ((GLSurfaceView)this.a).setRenderMode(i1);
      }
      this.w.b();
      return;
    }
  }
  
  public boolean a()
  {
    return this.h != null;
  }
  
  public boolean a(String paramString)
  {
    if (this.j == null) {
      this.j = com.badlogic.gdx.g.g.glGetString(7939);
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
    if (this.w.c() == 0.0F) {
      return this.s;
    }
    return this.w.c();
  }
  
  public void h()
  {
    if (this.a != null)
    {
      if ((this.a instanceof x)) {
        ((x)this.a).a();
      }
      if ((this.a instanceof com.badlogic.gdx.backends.android.b.j)) {
        ((com.badlogic.gdx.backends.android.b.j)this.a).a();
      }
      if ((this.a instanceof GLSurfaceView)) {
        ((GLSurfaceView)this.a).requestRender();
      }
    }
  }
  
  void i()
  {
    synchronized (this.q)
    {
      this.l = true;
      this.n = true;
      return;
    }
  }
  
  void j()
  {
    synchronized (this.q)
    {
      if (!this.l) {
        return;
      }
      this.l = false;
      this.m = true;
      for (;;)
      {
        boolean bool = this.m;
        if (bool) {
          try
          {
            this.q.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            com.badlogic.gdx.g.a.a("AndroidGraphics", "waiting for pause synchronization failed!");
          }
        }
      }
    }
  }
  
  void k()
  {
    synchronized (this.q)
    {
      this.l = false;
      this.o = true;
      for (;;)
      {
        boolean bool = this.o;
        if (bool) {
          try
          {
            this.q.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            com.badlogic.gdx.g.a.a("AndroidGraphics", "waiting for destroy synchronization failed!");
          }
        }
      }
    }
  }
  
  public void l()
  {
    com.badlogic.gdx.graphics.h.b(this.d);
    com.badlogic.gdx.graphics.p.a(this.d);
    k.b(this.d);
    com.badlogic.gdx.graphics.glutils.d.b(this.d);
    com.badlogic.gdx.g.a.a("AndroidGraphics", com.badlogic.gdx.graphics.h.e());
    com.badlogic.gdx.g.a.a("AndroidGraphics", com.badlogic.gdx.graphics.p.o());
    com.badlogic.gdx.g.a.a("AndroidGraphics", k.f());
    com.badlogic.gdx.g.a.a("AndroidGraphics", com.badlogic.gdx.graphics.glutils.d.b());
  }
  
  public boolean m()
  {
    return this.D;
  }
  
  public void onDrawFrame(GL10 arg1)
  {
    long l1 = System.nanoTime();
    this.s = ((float)(l1 - this.r) / 1.0E9F);
    this.r = l1;
    this.w.a(this.s);
    boolean bool1;
    boolean bool2;
    boolean bool3;
    synchronized (this.q)
    {
      bool1 = this.l;
      bool2 = this.m;
      bool3 = this.o;
      boolean bool4 = this.n;
      if (this.n) {
        this.n = false;
      }
      if (this.m)
      {
        this.m = false;
        this.q.notifyAll();
      }
      if (this.o)
      {
        this.o = false;
        this.q.notifyAll();
      }
      if (!bool4) {
        break label218;
      }
      this.d.c.b();
      synchronized (this.d.j)
      {
        Iterator localIterator1 = ???.iterator();
        if (localIterator1.hasNext()) {
          ((com.badlogic.gdx.p)localIterator1.next()).b();
        }
      }
    }
    this.d.f.b();
    com.badlogic.gdx.g.a.a("AndroidGraphics", "resumed");
    label218:
    if (bool1)
    {
      for (;;)
      {
        int i1;
        synchronized (this.d.h)
        {
          this.d.i.b();
          this.d.i.a(this.d.h);
          this.d.h.b();
          i1 = 0;
          if (i1 >= this.d.i.b) {
            break label329;
          }
        }
        try
        {
          ((Runnable)this.d.i.a(i1)).run();
          i1 += 1;
          continue;
          localObject3 = finally;
          throw ((Throwable)localObject3);
        }
        catch (Throwable ???)
        {
          for (;;)
          {
            ???.printStackTrace();
          }
        }
      }
      label329:
      this.d.b.b();
      this.d.f.c();
    }
    if (bool2)
    {
      synchronized (this.d.j)
      {
        Iterator localIterator2 = ???.iterator();
        if (localIterator2.hasNext()) {
          ((com.badlogic.gdx.p)localIterator2.next()).a();
        }
      }
      this.d.f.d();
      this.d.c.a();
      com.badlogic.gdx.g.a.a("AndroidGraphics", "paused");
    }
    if (bool3)
    {
      synchronized (this.d.j)
      {
        Iterator localIterator3 = ???.iterator();
        if (localIterator3.hasNext()) {
          ((com.badlogic.gdx.p)localIterator3.next()).c();
        }
      }
      this.d.f.e();
      this.d.c.c();
      this.d.c = null;
      com.badlogic.gdx.g.a.a("AndroidGraphics", "destroyed");
    }
    if (l1 - this.t > 1000000000L)
    {
      this.v = this.u;
      this.u = 0;
      this.t = l1;
    }
    this.u += 1;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    n();
    paramGL10.glViewport(0, 0, this.b, this.c);
    if (!this.k)
    {
      this.d.f.a();
      this.k = true;
    }
    try
    {
      this.l = true;
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
    n();
    com.badlogic.gdx.graphics.h.a(this.d);
    com.badlogic.gdx.graphics.p.b(this.d);
    k.a(this.d);
    com.badlogic.gdx.graphics.glutils.d.a(this.d);
    com.badlogic.gdx.g.a.a("AndroidGraphics", com.badlogic.gdx.graphics.h.e());
    com.badlogic.gdx.g.a.a("AndroidGraphics", com.badlogic.gdx.graphics.p.o());
    com.badlogic.gdx.g.a.a("AndroidGraphics", k.f());
    com.badlogic.gdx.g.a.a("AndroidGraphics", com.badlogic.gdx.graphics.glutils.d.b());
    paramEGLConfig = this.d.getWindowManager().getDefaultDisplay();
    this.b = paramEGLConfig.getWidth();
    this.c = paramEGLConfig.getHeight();
    this.w = new com.badlogic.gdx.math.h(5);
    this.r = System.nanoTime();
    paramGL10.glViewport(0, 0, this.b, this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */