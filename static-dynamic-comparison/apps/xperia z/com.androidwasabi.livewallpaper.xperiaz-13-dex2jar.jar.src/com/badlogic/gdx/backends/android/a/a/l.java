package com.badlogic.gdx.backends.android.a.a;

import android.opengl.GLSurfaceView.Renderer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

class l
  extends Thread
{
  boolean a;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private int h = 0;
  private int i = 0;
  private int j = 1;
  private boolean k = true;
  private boolean l;
  private ArrayList<Runnable> m = new ArrayList();
  private GLSurfaceView.Renderer n;
  private k o;
  
  l(d paramd, GLSurfaceView.Renderer paramRenderer)
  {
    this.n = paramRenderer;
  }
  
  private void g()
  {
    if (this.g)
    {
      this.g = false;
      this.o.c();
      this.o.d();
      this.b.c.c(this);
    }
  }
  
  private void h()
  {
    this.o = new k(this.b);
    ??? = null;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    Object localObject3 = null;
    try
    {
      synchronized (this.b.c)
      {
        if (this.c) {
          synchronized (this.b.c)
          {
            g();
            return;
          }
        }
        if (!this.m.isEmpty())
        {
          ??? = (Runnable)this.m.remove(0);
          i7 = i2;
          i8 = i1;
          i2 = i4;
          i4 = i3;
          i1 = i7;
          i3 = i8;
        }
        for (;;)
        {
          if (??? == null) {
            break label577;
          }
          ((Runnable)???).run();
          i7 = i1;
          i8 = i2;
          ??? = null;
          i1 = i3;
          i2 = i7;
          i3 = i4;
          i4 = i8;
          break;
          if ((this.g) && (this.d)) {
            g();
          }
          if ((!this.e) && (!this.f))
          {
            if (this.g) {
              g();
            }
            this.f = true;
            this.b.c.notifyAll();
          }
          if ((this.e) && (this.f))
          {
            this.f = false;
            this.b.c.notifyAll();
          }
          i7 = i3;
          i8 = i4;
          if (i3 != 0)
          {
            this.l = true;
            this.b.c.notifyAll();
            i7 = 0;
            i8 = 0;
          }
          i9 = i5;
          i10 = i6;
          if (this.d) {
            break label549;
          }
          i9 = i5;
          i10 = i6;
          if (!this.e) {
            break label549;
          }
          i9 = i5;
          i10 = i6;
          if (this.h <= 0) {
            break label549;
          }
          i9 = i5;
          i10 = i6;
          if (this.i <= 0) {
            break label549;
          }
          if (!this.k)
          {
            i9 = i5;
            i10 = i6;
            if (this.j != 1) {
              break label549;
            }
          }
          i4 = i5;
          i3 = i6;
          if (!this.g)
          {
            i4 = i5;
            i3 = i6;
            if (this.b.c.b(this))
            {
              this.g = true;
              this.o.a();
              this.b.c.notifyAll();
              i4 = 1;
              i3 = 1;
            }
          }
          i9 = i4;
          i10 = i3;
          if (!this.g) {
            break label549;
          }
          if (!this.b.d) {
            break label509;
          }
          i2 = this.h;
          i1 = this.i;
          this.b.d = false;
          i8 = 1;
          i4 = 1;
          this.b.c.notifyAll();
          i5 = i4;
          i4 = i7;
          i6 = i3;
          i3 = i1;
          i1 = i2;
          i2 = i8;
        }
        label509:
        this.k = false;
      }
    }
    finally
    {
      int i7;
      int i8;
      synchronized (this.b.c)
      {
        for (;;)
        {
          int i9;
          int i10;
          g();
          throw ((Throwable)localObject5);
          label549:
          this.b.c.wait();
          i3 = i7;
          i4 = i8;
          i5 = i9;
          i6 = i10;
        }
        label577:
        i7 = i6;
        GL10 localGL10;
        if (i6 != 0)
        {
          localGL10 = (GL10)this.o.a(this.b.f());
          this.n.onSurfaceCreated(localGL10, this.o.d);
          i7 = 0;
        }
        i6 = i5;
        if (i5 != 0)
        {
          this.n.onSurfaceChanged(localGL10, i1, i3);
          i6 = 0;
        }
        this.n.onDrawFrame(localGL10);
        boolean bool = this.o.b();
        if ((bool) || (i2 != 0))
        {
          i4 = i2;
          i5 = i6;
          i6 = i7;
          i2 = i1;
          i7 = 1;
          i1 = i3;
          i3 = i7;
        }
      }
    }
  }
  
  public void a()
  {
    synchronized (this.b.c)
    {
      this.k = true;
      this.b.c.notifyAll();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.b.c)
    {
      this.h = paramInt1;
      this.i = paramInt2;
      this.b.d = true;
      this.k = true;
      this.l = false;
      this.b.c.notifyAll();
      for (;;)
      {
        if ((this.a) || (this.d) || (this.l)) {
          return;
        }
        try
        {
          Thread.sleep(200L);
          this.b.c.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
  
  public void b()
  {
    synchronized (this.b.c)
    {
      this.e = true;
      this.b.c.notifyAll();
      return;
    }
  }
  
  public void c()
  {
    synchronized (this.b.c)
    {
      this.e = false;
      this.b.c.notifyAll();
      for (;;)
      {
        if ((this.f) || (!isAlive()) || (this.a)) {
          return;
        }
        try
        {
          this.b.c.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
  
  public void d()
  {
    synchronized (this.b.c)
    {
      this.d = true;
      this.b.c.notifyAll();
      return;
    }
  }
  
  public void e()
  {
    synchronized (this.b.c)
    {
      this.d = false;
      this.k = true;
      this.b.c.notifyAll();
      return;
    }
  }
  
  public void f()
  {
    synchronized (this.b.c)
    {
      this.c = true;
      this.b.c.notifyAll();
      for (;;)
      {
        if (this.a) {
          return;
        }
        try
        {
          this.b.c.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
  
  public void run()
  {
    setName("GLThread " + getId());
    try
    {
      h();
      this.b.c.a(this);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException = localInterruptedException;
      this.b.c.a(this);
      return;
    }
    finally
    {
      localObject = finally;
      this.b.c.a(this);
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */