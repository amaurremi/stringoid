package com.badlogic.gdx.backends.android.b;

import android.opengl.GLSurfaceView.Renderer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

class ab
  extends Thread
{
  private boolean b = false;
  private boolean c;
  private boolean d;
  private int e = 0;
  private int f = 0;
  private int g = 1;
  private boolean h = true;
  private GLSurfaceView.Renderer i;
  private ArrayList<Runnable> j = new ArrayList();
  private aa k;
  private boolean l;
  
  ab(x paramx, GLSurfaceView.Renderer paramRenderer)
  {
    this.i = paramRenderer;
    this.l = true;
    setName("GLThread");
  }
  
  private void g()
  {
    this.k = new aa(this.a);
    this.k.a();
    int n = 1;
    Object localObject1 = null;
    int m = 1;
    Object localObject4;
    if (!this.b)
    {
      try
      {
        for (;;)
        {
          localObject4 = i();
          if (localObject4 == null) {
            break;
          }
          ((Runnable)localObject4).run();
        }
        if (!this.c) {
          break label300;
        }
      }
      finally {}
      this.k.c();
      i1 = 1;
      label82:
      while (h()) {
        wait();
      }
      if (!this.b) {}
    }
    else
    {
      this.k.c();
      return;
    }
    boolean bool = this.l;
    int i3 = this.e;
    int i4 = this.f;
    this.l = false;
    this.h = false;
    if (i1 != 0)
    {
      this.k.a();
      bool = true;
      n = 1;
      label159:
      localObject4 = localObject2;
      if (bool)
      {
        localObject4 = (GL10)this.k.a(this.a.getHolder());
        m = 1;
      }
      if (n == 0) {
        break label305;
      }
      this.i.onSurfaceCreated((GL10)localObject4, this.k.d);
    }
    label300:
    label305:
    for (int i1 = 0;; i1 = n)
    {
      int i2 = m;
      if (m != 0)
      {
        this.i.onSurfaceChanged((GL10)localObject4, i3, i4);
        i2 = 0;
      }
      m = i2;
      n = i1;
      Object localObject3 = localObject4;
      if (i3 <= 0) {
        break;
      }
      m = i2;
      n = i1;
      localObject3 = localObject4;
      if (i4 <= 0) {
        break;
      }
      this.i.onDrawFrame((GL10)localObject4);
      this.k.b();
      m = i2;
      n = i1;
      localObject3 = localObject4;
      break;
      break label159;
      i1 = 0;
      break label82;
    }
  }
  
  private boolean h()
  {
    if (this.b) {}
    do
    {
      return false;
      if ((this.c) || (!this.d)) {
        return true;
      }
    } while ((this.e > 0) && (this.f > 0) && ((this.h) || (this.g == 1)));
    return true;
  }
  
  private Runnable i()
  {
    try
    {
      if (this.j.size() > 0)
      {
        Runnable localRunnable = (Runnable)this.j.remove(0);
        return localRunnable;
      }
      return null;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      this.h = true;
      notify();
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1)) {
      throw new IllegalArgumentException("renderMode");
    }
    try
    {
      this.g = paramInt;
      if (paramInt == 1) {
        notify();
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      this.e = paramInt1;
      this.f = paramInt2;
      this.l = true;
      notify();
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      this.d = true;
      notify();
      return;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      this.d = false;
      notify();
      return;
    }
    finally {}
  }
  
  public void d()
  {
    try
    {
      this.c = true;
      return;
    }
    finally {}
  }
  
  public void e()
  {
    try
    {
      this.c = false;
      notify();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 37	com/badlogic/gdx/backends/android/b/ab:b	Z
    //   7: aload_0
    //   8: invokevirtual 128	java/lang/Object:notify	()V
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_0
    //   14: invokevirtual 141	com/badlogic/gdx/backends/android/b/ab:join	()V
    //   17: return
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    //   23: astore_1
    //   24: invokestatic 145	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   27: invokevirtual 148	java/lang/Thread:interrupt	()V
    //   30: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	ab
    //   18	4	1	localObject	Object
    //   23	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	13	18	finally
    //   19	21	18	finally
    //   13	17	23	java/lang/InterruptedException
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 151	com/badlogic/gdx/backends/android/b/x:b	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: invokespecial 153	com/badlogic/gdx/backends/android/b/ab:g	()V
    //   10: aload_1
    //   11: monitorexit
    //   12: return
    //   13: astore_2
    //   14: aload_1
    //   15: monitorexit
    //   16: aload_2
    //   17: athrow
    //   18: astore_1
    //   19: return
    //   20: astore_1
    //   21: aload_1
    //   22: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	23	0	this	ab
    //   18	1	1	localInterruptedException	InterruptedException
    //   20	2	1	localObject2	Object
    //   13	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   6	12	13	finally
    //   14	16	13	finally
    //   0	6	18	java/lang/InterruptedException
    //   16	18	18	java/lang/InterruptedException
    //   0	6	20	finally
    //   16	18	20	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */