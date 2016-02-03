package com.badlogic.gdx.backends.android.a.a;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.Renderer;
import android.view.SurfaceHolder;
import java.util.ArrayList;

class y
  extends Thread
{
  public SurfaceHolder a;
  public boolean b = false;
  private final z d = new z(this, null);
  private y e;
  private GLSurfaceView.EGLConfigChooser f;
  private v g;
  private w h;
  private aa i;
  private boolean j = true;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private int o = 0;
  private int p = 0;
  private int q = 1;
  private boolean r = true;
  private boolean s;
  private GLSurfaceView.Renderer t;
  private ArrayList<Runnable> u = new ArrayList();
  private x v;
  
  y(q paramq, GLSurfaceView.Renderer paramRenderer, GLSurfaceView.EGLConfigChooser paramEGLConfigChooser, v paramv, w paramw, aa paramaa)
  {
    this.t = paramRenderer;
    this.f = paramEGLConfigChooser;
    this.g = paramv;
    this.h = paramw;
    this.i = paramaa;
  }
  
  private void f()
  {
    if (this.n)
    {
      this.n = false;
      this.v.c();
      this.d.c(this);
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 92	com/badlogic/gdx/backends/android/a/a/x
    //   4: dup
    //   5: aload_0
    //   6: getfield 44	com/badlogic/gdx/backends/android/a/a/y:c	Lcom/badlogic/gdx/backends/android/a/a/q;
    //   9: aload_0
    //   10: getfield 75	com/badlogic/gdx/backends/android/a/a/y:f	Landroid/opengl/GLSurfaceView$EGLConfigChooser;
    //   13: aload_0
    //   14: getfield 77	com/badlogic/gdx/backends/android/a/a/y:g	Lcom/badlogic/gdx/backends/android/a/a/v;
    //   17: aload_0
    //   18: getfield 79	com/badlogic/gdx/backends/android/a/a/y:h	Lcom/badlogic/gdx/backends/android/a/a/w;
    //   21: aload_0
    //   22: getfield 81	com/badlogic/gdx/backends/android/a/a/y:i	Lcom/badlogic/gdx/backends/android/a/a/aa;
    //   25: invokespecial 100	com/badlogic/gdx/backends/android/a/a/x:<init>	(Lcom/badlogic/gdx/backends/android/a/a/q;Landroid/opengl/GLSurfaceView$EGLConfigChooser;Lcom/badlogic/gdx/backends/android/a/a/v;Lcom/badlogic/gdx/backends/android/a/a/w;Lcom/badlogic/gdx/backends/android/a/a/aa;)V
    //   28: putfield 90	com/badlogic/gdx/backends/android/a/a/y:v	Lcom/badlogic/gdx/backends/android/a/a/x;
    //   31: iconst_1
    //   32: istore_2
    //   33: iconst_1
    //   34: istore_3
    //   35: aconst_null
    //   36: astore 8
    //   38: aload_0
    //   39: invokespecial 103	com/badlogic/gdx/backends/android/a/a/y:h	()Z
    //   42: istore 7
    //   44: iload 7
    //   46: ifeq +27 -> 73
    //   49: aload_0
    //   50: getfield 54	com/badlogic/gdx/backends/android/a/a/y:d	Lcom/badlogic/gdx/backends/android/a/a/z;
    //   53: astore 8
    //   55: aload 8
    //   57: monitorenter
    //   58: aload_0
    //   59: invokespecial 105	com/badlogic/gdx/backends/android/a/a/y:f	()V
    //   62: aload_0
    //   63: getfield 90	com/badlogic/gdx/backends/android/a/a/y:v	Lcom/badlogic/gdx/backends/android/a/a/x;
    //   66: invokevirtual 107	com/badlogic/gdx/backends/android/a/a/x:d	()V
    //   69: aload 8
    //   71: monitorexit
    //   72: return
    //   73: aload_0
    //   74: getfield 54	com/badlogic/gdx/backends/android/a/a/y:d	Lcom/badlogic/gdx/backends/android/a/a/z;
    //   77: astore 9
    //   79: aload 9
    //   81: monitorenter
    //   82: iconst_0
    //   83: istore_1
    //   84: aload_0
    //   85: getfield 109	com/badlogic/gdx/backends/android/a/a/y:k	Z
    //   88: ifeq +7 -> 95
    //   91: aload_0
    //   92: invokespecial 105	com/badlogic/gdx/backends/android/a/a/y:f	()V
    //   95: aload_0
    //   96: getfield 111	com/badlogic/gdx/backends/android/a/a/y:l	Z
    //   99: ifne +68 -> 167
    //   102: aload_0
    //   103: getfield 113	com/badlogic/gdx/backends/android/a/a/y:m	Z
    //   106: ifne +485 -> 591
    //   109: aload_0
    //   110: invokespecial 105	com/badlogic/gdx/backends/android/a/a/y:f	()V
    //   113: aload_0
    //   114: iconst_1
    //   115: putfield 113	com/badlogic/gdx/backends/android/a/a/y:m	Z
    //   118: aload_0
    //   119: getfield 54	com/badlogic/gdx/backends/android/a/a/y:d	Lcom/badlogic/gdx/backends/android/a/a/z;
    //   122: invokevirtual 118	java/lang/Object:notifyAll	()V
    //   125: aload_0
    //   126: getfield 63	com/badlogic/gdx/backends/android/a/a/y:b	Z
    //   129: ifeq +78 -> 207
    //   132: aload 9
    //   134: monitorexit
    //   135: aload_0
    //   136: getfield 54	com/badlogic/gdx/backends/android/a/a/y:d	Lcom/badlogic/gdx/backends/android/a/a/z;
    //   139: astore 8
    //   141: aload 8
    //   143: monitorenter
    //   144: aload_0
    //   145: invokespecial 105	com/badlogic/gdx/backends/android/a/a/y:f	()V
    //   148: aload_0
    //   149: getfield 90	com/badlogic/gdx/backends/android/a/a/y:v	Lcom/badlogic/gdx/backends/android/a/a/x;
    //   152: invokevirtual 107	com/badlogic/gdx/backends/android/a/a/x:d	()V
    //   155: aload 8
    //   157: monitorexit
    //   158: return
    //   159: astore 9
    //   161: aload 8
    //   163: monitorexit
    //   164: aload 9
    //   166: athrow
    //   167: aload_0
    //   168: getfield 88	com/badlogic/gdx/backends/android/a/a/y:n	Z
    //   171: ifne +420 -> 591
    //   174: aload_0
    //   175: getfield 54	com/badlogic/gdx/backends/android/a/a/y:d	Lcom/badlogic/gdx/backends/android/a/a/z;
    //   178: aload_0
    //   179: invokevirtual 121	com/badlogic/gdx/backends/android/a/a/z:b	(Lcom/badlogic/gdx/backends/android/a/a/y;)Z
    //   182: ifeq +409 -> 591
    //   185: aload_0
    //   186: iconst_1
    //   187: putfield 88	com/badlogic/gdx/backends/android/a/a/y:n	Z
    //   190: aload_0
    //   191: getfield 90	com/badlogic/gdx/backends/android/a/a/y:v	Lcom/badlogic/gdx/backends/android/a/a/x;
    //   194: invokevirtual 123	com/badlogic/gdx/backends/android/a/a/x:a	()V
    //   197: aload_0
    //   198: iconst_1
    //   199: putfield 69	com/badlogic/gdx/backends/android/a/a/y:r	Z
    //   202: iconst_1
    //   203: istore_1
    //   204: goto -79 -> 125
    //   207: aload_0
    //   208: getfield 125	com/badlogic/gdx/backends/android/a/a/y:s	Z
    //   211: ifeq +89 -> 300
    //   214: aload_0
    //   215: iconst_0
    //   216: putfield 125	com/badlogic/gdx/backends/android/a/a/y:s	Z
    //   219: iconst_1
    //   220: istore 6
    //   222: iconst_0
    //   223: istore 7
    //   225: iconst_0
    //   226: istore 4
    //   228: iconst_0
    //   229: istore 5
    //   231: aload 9
    //   233: monitorexit
    //   234: iload 6
    //   236: ifeq +223 -> 459
    //   239: aload_0
    //   240: invokespecial 128	com/badlogic/gdx/backends/android/a/a/y:i	()Ljava/lang/Runnable;
    //   243: astore 9
    //   245: aload 9
    //   247: ifnull -209 -> 38
    //   250: aload 9
    //   252: invokeinterface 133 1 0
    //   257: aload_0
    //   258: invokespecial 103	com/badlogic/gdx/backends/android/a/a/y:h	()Z
    //   261: istore 7
    //   263: iload 7
    //   265: ifeq -26 -> 239
    //   268: aload_0
    //   269: getfield 54	com/badlogic/gdx/backends/android/a/a/y:d	Lcom/badlogic/gdx/backends/android/a/a/z;
    //   272: astore 8
    //   274: aload 8
    //   276: monitorenter
    //   277: aload_0
    //   278: invokespecial 105	com/badlogic/gdx/backends/android/a/a/y:f	()V
    //   281: aload_0
    //   282: getfield 90	com/badlogic/gdx/backends/android/a/a/y:v	Lcom/badlogic/gdx/backends/android/a/a/x;
    //   285: invokevirtual 107	com/badlogic/gdx/backends/android/a/a/x:d	()V
    //   288: aload 8
    //   290: monitorexit
    //   291: return
    //   292: astore 9
    //   294: aload 8
    //   296: monitorexit
    //   297: aload 9
    //   299: athrow
    //   300: aload_0
    //   301: getfield 109	com/badlogic/gdx/backends/android/a/a/y:k	Z
    //   304: ifne +109 -> 413
    //   307: aload_0
    //   308: getfield 111	com/badlogic/gdx/backends/android/a/a/y:l	Z
    //   311: ifeq +102 -> 413
    //   314: aload_0
    //   315: getfield 88	com/badlogic/gdx/backends/android/a/a/y:n	Z
    //   318: ifeq +95 -> 413
    //   321: aload_0
    //   322: getfield 65	com/badlogic/gdx/backends/android/a/a/y:o	I
    //   325: ifle +88 -> 413
    //   328: aload_0
    //   329: getfield 67	com/badlogic/gdx/backends/android/a/a/y:p	I
    //   332: ifle +81 -> 413
    //   335: aload_0
    //   336: getfield 69	com/badlogic/gdx/backends/android/a/a/y:r	Z
    //   339: ifne +11 -> 350
    //   342: aload_0
    //   343: getfield 71	com/badlogic/gdx/backends/android/a/a/y:q	I
    //   346: iconst_1
    //   347: if_icmpne +66 -> 413
    //   350: aload_0
    //   351: getfield 56	com/badlogic/gdx/backends/android/a/a/y:j	Z
    //   354: istore 7
    //   356: aload_0
    //   357: getfield 65	com/badlogic/gdx/backends/android/a/a/y:o	I
    //   360: istore 5
    //   362: aload_0
    //   363: getfield 67	com/badlogic/gdx/backends/android/a/a/y:p	I
    //   366: istore 4
    //   368: aload_0
    //   369: iconst_0
    //   370: putfield 56	com/badlogic/gdx/backends/android/a/a/y:j	Z
    //   373: aload_0
    //   374: iconst_0
    //   375: putfield 69	com/badlogic/gdx/backends/android/a/a/y:r	Z
    //   378: aload_0
    //   379: getfield 111	com/badlogic/gdx/backends/android/a/a/y:l	Z
    //   382: ifeq +203 -> 585
    //   385: aload_0
    //   386: getfield 113	com/badlogic/gdx/backends/android/a/a/y:m	Z
    //   389: ifeq +196 -> 585
    //   392: aload_0
    //   393: iconst_0
    //   394: putfield 113	com/badlogic/gdx/backends/android/a/a/y:m	Z
    //   397: aload_0
    //   398: getfield 54	com/badlogic/gdx/backends/android/a/a/y:d	Lcom/badlogic/gdx/backends/android/a/a/z;
    //   401: invokevirtual 118	java/lang/Object:notifyAll	()V
    //   404: iconst_1
    //   405: istore 7
    //   407: iconst_0
    //   408: istore 6
    //   410: goto -179 -> 231
    //   413: aload_0
    //   414: getfield 54	com/badlogic/gdx/backends/android/a/a/y:d	Lcom/badlogic/gdx/backends/android/a/a/z;
    //   417: invokevirtual 136	java/lang/Object:wait	()V
    //   420: goto -336 -> 84
    //   423: astore 8
    //   425: aload 9
    //   427: monitorexit
    //   428: aload 8
    //   430: athrow
    //   431: astore 9
    //   433: aload_0
    //   434: getfield 54	com/badlogic/gdx/backends/android/a/a/y:d	Lcom/badlogic/gdx/backends/android/a/a/z;
    //   437: astore 8
    //   439: aload 8
    //   441: monitorenter
    //   442: aload_0
    //   443: invokespecial 105	com/badlogic/gdx/backends/android/a/a/y:f	()V
    //   446: aload_0
    //   447: getfield 90	com/badlogic/gdx/backends/android/a/a/y:v	Lcom/badlogic/gdx/backends/android/a/a/x;
    //   450: invokevirtual 107	com/badlogic/gdx/backends/android/a/a/x:d	()V
    //   453: aload 8
    //   455: monitorexit
    //   456: aload 9
    //   458: athrow
    //   459: iload_1
    //   460: ifeq +8 -> 468
    //   463: iconst_1
    //   464: istore 7
    //   466: iconst_1
    //   467: istore_3
    //   468: iload 7
    //   470: ifeq +112 -> 582
    //   473: aload_0
    //   474: getfield 90	com/badlogic/gdx/backends/android/a/a/y:v	Lcom/badlogic/gdx/backends/android/a/a/x;
    //   477: aload_0
    //   478: getfield 138	com/badlogic/gdx/backends/android/a/a/y:a	Landroid/view/SurfaceHolder;
    //   481: invokevirtual 141	com/badlogic/gdx/backends/android/a/a/x:a	(Landroid/view/SurfaceHolder;)Ljavax/microedition/khronos/opengles/GL;
    //   484: checkcast 143	javax/microedition/khronos/opengles/GL10
    //   487: astore 8
    //   489: iconst_1
    //   490: istore_2
    //   491: iload_3
    //   492: istore_1
    //   493: iload_3
    //   494: ifeq +23 -> 517
    //   497: aload_0
    //   498: getfield 73	com/badlogic/gdx/backends/android/a/a/y:t	Landroid/opengl/GLSurfaceView$Renderer;
    //   501: aload 8
    //   503: aload_0
    //   504: getfield 90	com/badlogic/gdx/backends/android/a/a/y:v	Lcom/badlogic/gdx/backends/android/a/a/x;
    //   507: getfield 146	com/badlogic/gdx/backends/android/a/a/x:a	Ljavax/microedition/khronos/egl/EGLConfig;
    //   510: invokeinterface 152 3 0
    //   515: iconst_0
    //   516: istore_1
    //   517: iload_2
    //   518: istore_3
    //   519: iload_2
    //   520: ifeq +20 -> 540
    //   523: aload_0
    //   524: getfield 73	com/badlogic/gdx/backends/android/a/a/y:t	Landroid/opengl/GLSurfaceView$Renderer;
    //   527: aload 8
    //   529: iload 5
    //   531: iload 4
    //   533: invokeinterface 156 4 0
    //   538: iconst_0
    //   539: istore_3
    //   540: aload_0
    //   541: getfield 73	com/badlogic/gdx/backends/android/a/a/y:t	Landroid/opengl/GLSurfaceView$Renderer;
    //   544: aload 8
    //   546: invokeinterface 160 2 0
    //   551: aload_0
    //   552: getfield 90	com/badlogic/gdx/backends/android/a/a/y:v	Lcom/badlogic/gdx/backends/android/a/a/x;
    //   555: invokevirtual 162	com/badlogic/gdx/backends/android/a/a/x:b	()Z
    //   558: pop
    //   559: iload_3
    //   560: istore_2
    //   561: iload_1
    //   562: istore_3
    //   563: goto -525 -> 38
    //   566: astore 9
    //   568: aload 8
    //   570: monitorexit
    //   571: aload 9
    //   573: athrow
    //   574: astore 9
    //   576: aload 8
    //   578: monitorexit
    //   579: aload 9
    //   581: athrow
    //   582: goto -91 -> 491
    //   585: iconst_0
    //   586: istore 6
    //   588: goto -357 -> 231
    //   591: goto -466 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	y
    //   83	479	1	i1	int
    //   32	529	2	i2	int
    //   34	529	3	i3	int
    //   226	306	4	i4	int
    //   229	301	5	i5	int
    //   220	367	6	i6	int
    //   42	427	7	bool	boolean
    //   423	6	8	localObject1	Object
    //   77	56	9	localz2	z
    //   159	73	9	localObject3	Object
    //   243	8	9	localRunnable	Runnable
    //   292	134	9	localObject4	Object
    //   431	26	9	localObject5	Object
    //   566	6	9	localObject6	Object
    //   574	6	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   144	158	159	finally
    //   161	164	159	finally
    //   277	291	292	finally
    //   294	297	292	finally
    //   84	95	423	finally
    //   95	125	423	finally
    //   125	135	423	finally
    //   167	202	423	finally
    //   207	219	423	finally
    //   231	234	423	finally
    //   300	350	423	finally
    //   350	404	423	finally
    //   413	420	423	finally
    //   425	428	423	finally
    //   38	44	431	finally
    //   73	82	431	finally
    //   239	245	431	finally
    //   250	263	431	finally
    //   428	431	431	finally
    //   473	489	431	finally
    //   497	515	431	finally
    //   523	538	431	finally
    //   540	559	431	finally
    //   442	456	566	finally
    //   568	571	566	finally
    //   58	72	574	finally
    //   576	579	574	finally
  }
  
  private boolean h()
  {
    synchronized (this.d)
    {
      boolean bool = this.b;
      return bool;
    }
  }
  
  private Runnable i()
  {
    try
    {
      if (this.u.size() > 0)
      {
        Runnable localRunnable = (Runnable)this.u.remove(0);
        return localRunnable;
      }
      return null;
    }
    finally {}
  }
  
  public void a()
  {
    synchronized (this.d)
    {
      this.r = true;
      this.d.notifyAll();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.d)
    {
      this.o = paramInt1;
      this.p = paramInt2;
      this.j = true;
      this.d.notifyAll();
      return;
    }
  }
  
  public void a(SurfaceHolder arg1)
  {
    this.a = ???;
    synchronized (this.d)
    {
      this.l = true;
      this.d.notifyAll();
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.d)
    {
      this.l = false;
      this.d.notifyAll();
      for (;;)
      {
        if ((this.m) || (!isAlive()) || (this.b)) {
          return;
        }
        try
        {
          this.d.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
  
  public void c()
  {
    synchronized (this.d)
    {
      this.k = true;
      this.d.notifyAll();
      return;
    }
  }
  
  public void d()
  {
    synchronized (this.d)
    {
      this.k = false;
      this.r = true;
      this.d.notifyAll();
      return;
    }
  }
  
  public void e()
  {
    synchronized (this.d)
    {
      this.b = true;
      this.d.notifyAll();
    }
  }
  
  public void run()
  {
    setName("GLThread " + getId());
    try
    {
      g();
      this.d.a(this);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException = localInterruptedException;
      this.d.a(this);
      return;
    }
    finally
    {
      localObject = finally;
      this.d.a(this);
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */