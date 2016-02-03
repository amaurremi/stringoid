package com.badlogic.gdx.backends.android.a;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.Renderer;
import android.service.wallpaper.WallpaperService;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.badlogic.gdx.backends.android.AndroidGL20;
import com.badlogic.gdx.backends.android.a.a.ac;
import com.badlogic.gdx.backends.android.b.ag;
import com.badlogic.gdx.g;
import com.badlogic.gdx.graphics.f;
import com.badlogic.gdx.graphics.glutils.k;
import com.badlogic.gdx.graphics.p;
import com.badlogic.gdx.i;
import com.badlogic.gdx.j;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public final class d
  implements GLSurfaceView.Renderer, com.badlogic.gdx.h
{
  Object A = new Object();
  private final String B = "AndroidGraphicsLW";
  private boolean C = false;
  private final com.badlogic.gdx.backends.android.a D;
  private i E = new i(5, 6, 5, 0, 16, 0, 0, false);
  private boolean F = true;
  final com.badlogic.gdx.backends.android.a.a.c a;
  int b;
  int c;
  a d;
  protected f e;
  protected com.badlogic.gdx.graphics.c f;
  protected com.badlogic.gdx.graphics.d g;
  protected com.badlogic.gdx.graphics.e h;
  protected String i;
  protected long j = System.nanoTime();
  protected float k = 0.0F;
  protected long l = System.nanoTime();
  protected int m = 0;
  protected int n;
  protected com.badlogic.gdx.math.h o = new com.badlogic.gdx.math.h(5);
  volatile boolean p = false;
  volatile boolean q = false;
  volatile boolean r = false;
  volatile boolean s = false;
  volatile boolean t = false;
  protected float u = 0.0F;
  protected float v = 0.0F;
  protected float w = 0.0F;
  protected float x = 0.0F;
  protected float y = 1.0F;
  int[] z = new int[1];
  
  public d(a parama, com.badlogic.gdx.backends.android.a parama1, ag paramag, boolean paramBoolean)
  {
    this.D = parama1;
    this.C = paramBoolean;
    if (paramBoolean) {}
    for (this.a = a(parama, parama1.a, paramag);; this.a = b(parama, parama1.a, paramag))
    {
      this.d = parama;
      return;
    }
  }
  
  private int a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.z)) {
      paramInt2 = this.z[0];
    }
    return paramInt2;
  }
  
  private com.badlogic.gdx.backends.android.a.a.c a(a parama, boolean paramBoolean, ag paramag)
  {
    GLSurfaceView.EGLConfigChooser localEGLConfigChooser = o();
    if ((paramBoolean) && (q()))
    {
      parama = new com.badlogic.gdx.backends.android.a.a.af(parama.g(), paramag);
      if (localEGLConfigChooser != null) {
        parama.a(localEGLConfigChooser);
      }
      for (;;)
      {
        parama.a(this);
        return parama;
        parama.a(this.D.b, this.D.c, this.D.d, this.D.e, this.D.f, this.D.g);
      }
    }
    this.D.a = false;
    localEGLConfigChooser = o();
    parama = new com.badlogic.gdx.backends.android.a.a.b(parama.g(), paramag);
    if (localEGLConfigChooser != null) {
      parama.a(localEGLConfigChooser);
    }
    for (;;)
    {
      parama.a(this);
      return parama;
      parama.a(this.D.b, this.D.c, this.D.d, this.D.e, this.D.f, this.D.g);
    }
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
      g.a.a("AndroidGraphics", "framebuffer: (" + i1 + ", " + i2 + ", " + i3 + ", " + i4 + ")");
      g.a.a("AndroidGraphics", "depthbuffer: (" + i5 + ")");
      g.a.a("AndroidGraphics", "stencilbuffer: (" + i6 + ")");
      g.a.a("AndroidGraphics", "samples: (" + i7 + ")");
      g.a.a("AndroidGraphics", "coverage sampling: (" + bool + ")");
      this.E = new i(i1, i2, i3, i4, i5, i6, i7, bool);
      return;
    }
  }
  
  private void a(GL10 paramGL10)
  {
    if ((this.f != null) || (this.h != null)) {
      return;
    }
    if (((this.a instanceof ac)) || ((this.a instanceof com.badlogic.gdx.backends.android.a.a.af))) {
      this.h = new AndroidGL20();
    }
    for (this.e = this.h;; this.e = this.f)
    {
      g.g = this.e;
      g.h = this.f;
      g.i = this.g;
      g.j = this.h;
      g.a.a("AndroidGraphics", "OGL renderer: " + paramGL10.glGetString(7937));
      g.a.a("AndroidGraphics", "OGL vendor: " + paramGL10.glGetString(7936));
      g.a.a("AndroidGraphics", "OGL version: " + paramGL10.glGetString(7938));
      g.a.a("AndroidGraphics", "OGL extensions: " + paramGL10.glGetString(7939));
      return;
      this.f = new c(paramGL10);
    }
  }
  
  private com.badlogic.gdx.backends.android.a.a.c b(a parama, boolean paramBoolean, ag paramag)
  {
    GLSurfaceView.EGLConfigChooser localEGLConfigChooser = o();
    if ((paramBoolean) && (q()))
    {
      parama = new ac(parama.g(), paramag);
      if (localEGLConfigChooser != null) {
        parama.a(localEGLConfigChooser);
      }
      for (;;)
      {
        parama.a(this);
        return parama;
        parama.a(this.D.b, this.D.c, this.D.d, this.D.e, this.D.f, this.D.g);
      }
    }
    this.D.a = false;
    localEGLConfigChooser = o();
    parama = new com.badlogic.gdx.backends.android.a.a.a(parama.g(), paramag);
    if (localEGLConfigChooser != null) {
      parama.a(localEGLConfigChooser);
    }
    for (;;)
    {
      parama.a(this);
      return parama;
      parama.a(this.D.b, this.D.c, this.D.d, this.D.e, this.D.f, this.D.g);
    }
  }
  
  private GLSurfaceView.EGLConfigChooser o()
  {
    return new com.badlogic.gdx.backends.android.b.af(this.D.b, this.D.c, this.D.d, this.D.e, this.D.f, this.D.g, this.D.h, this.D.a);
  }
  
  private void p()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)this.d.f().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.u = localDisplayMetrics.xdpi;
    this.v = localDisplayMetrics.ydpi;
    this.w = (localDisplayMetrics.xdpi / 2.54F);
    this.x = (localDisplayMetrics.ydpi / 2.54F);
    this.y = localDisplayMetrics.density;
  }
  
  private boolean q()
  {
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    localEGL10.eglInitialize(localEGLDisplay, new int[2]);
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[10];
    int[] arrayOfInt = new int[1];
    localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344 }, arrayOfEGLConfig, 10, arrayOfInt);
    localEGL10.eglTerminate(localEGLDisplay);
    return arrayOfInt[0] > 0;
  }
  
  public boolean a()
  {
    return this.h != null;
  }
  
  public boolean a(String paramString)
  {
    if (this.i == null) {
      this.i = g.g.glGetString(7939);
    }
    return this.i.contains(paramString);
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
    if (this.o.c() == 0.0F) {
      return this.k;
    }
    return this.o.c();
  }
  
  public void h()
  {
    if ((this.a != null) && ((this.a instanceof com.badlogic.gdx.backends.android.a.a.c))) {
      this.a.a();
    }
  }
  
  void i()
  {
    synchronized (this.A)
    {
      this.q = true;
      this.s = true;
      if (this.d.e != null) {
        this.d.e.b();
      }
      this.d.h().b();
      return;
    }
  }
  
  void j()
  {
    synchronized (this.A)
    {
      if (!this.q) {
        return;
      }
      if (this.C) {
        l();
      }
      this.q = false;
      this.r = true;
      this.d.h().d();
      if (this.d.e != null) {
        this.d.e.a();
      }
      return;
    }
  }
  
  void k()
  {
    synchronized (this.A)
    {
      l();
      this.q = false;
      this.t = true;
      this.d.h().e();
      if (this.d.e != null) {
        this.d.e.c();
      }
      this.d.e = null;
      return;
    }
  }
  
  public void l()
  {
    com.badlogic.gdx.graphics.h.b(this.d);
    p.a(this.d);
    k.b(this.d);
    com.badlogic.gdx.graphics.glutils.d.b(this.d);
    try
    {
      g.a.a("AndroidGraphicsLW", com.badlogic.gdx.graphics.h.e());
      g.a.a("AndroidGraphicsLW", p.o());
      g.a.a("AndroidGraphicsLW", k.f());
      g.a.a("AndroidGraphicsLW", com.badlogic.gdx.graphics.glutils.d.b());
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public com.badlogic.gdx.backends.android.a.a.c m()
  {
    return this.a;
  }
  
  public j n()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)this.d.f().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return new e(this, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, 0, 0);
  }
  
  /* Error */
  public void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: invokestatic 72	java/lang/System:nanoTime	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: lload_3
    //   6: aload_0
    //   7: getfield 74	com/badlogic/gdx/backends/android/a/d:j	J
    //   10: lsub
    //   11: l2f
    //   12: ldc_w 445
    //   15: fdiv
    //   16: putfield 76	com/badlogic/gdx/backends/android/a/d:k	F
    //   19: aload_0
    //   20: lload_3
    //   21: putfield 74	com/badlogic/gdx/backends/android/a/d:j	J
    //   24: aload_0
    //   25: getfield 87	com/badlogic/gdx/backends/android/a/d:o	Lcom/badlogic/gdx/math/h;
    //   28: aload_0
    //   29: getfield 76	com/badlogic/gdx/backends/android/a/d:k	F
    //   32: invokevirtual 448	com/badlogic/gdx/math/h:a	(F)V
    //   35: aload_0
    //   36: getfield 120	com/badlogic/gdx/backends/android/a/d:A	Ljava/lang/Object;
    //   39: astore_1
    //   40: aload_1
    //   41: monitorenter
    //   42: aload_0
    //   43: getfield 91	com/badlogic/gdx/backends/android/a/d:q	Z
    //   46: istore 5
    //   48: aload_0
    //   49: getfield 93	com/badlogic/gdx/backends/android/a/d:r	Z
    //   52: istore 6
    //   54: aload_0
    //   55: getfield 97	com/badlogic/gdx/backends/android/a/d:t	Z
    //   58: istore 6
    //   60: aload_0
    //   61: getfield 95	com/badlogic/gdx/backends/android/a/d:s	Z
    //   64: istore 6
    //   66: aload_0
    //   67: getfield 95	com/badlogic/gdx/backends/android/a/d:s	Z
    //   70: ifeq +8 -> 78
    //   73: aload_0
    //   74: iconst_0
    //   75: putfield 95	com/badlogic/gdx/backends/android/a/d:s	Z
    //   78: aload_0
    //   79: getfield 93	com/badlogic/gdx/backends/android/a/d:r	Z
    //   82: ifeq +15 -> 97
    //   85: aload_0
    //   86: iconst_0
    //   87: putfield 93	com/badlogic/gdx/backends/android/a/d:r	Z
    //   90: aload_0
    //   91: getfield 120	com/badlogic/gdx/backends/android/a/d:A	Ljava/lang/Object;
    //   94: invokevirtual 451	java/lang/Object:notifyAll	()V
    //   97: aload_0
    //   98: getfield 97	com/badlogic/gdx/backends/android/a/d:t	Z
    //   101: ifeq +15 -> 116
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield 97	com/badlogic/gdx/backends/android/a/d:t	Z
    //   109: aload_0
    //   110: getfield 120	com/badlogic/gdx/backends/android/a/d:A	Ljava/lang/Object;
    //   113: invokevirtual 451	java/lang/Object:notifyAll	()V
    //   116: aload_1
    //   117: monitorexit
    //   118: iload 5
    //   120: ifeq +96 -> 216
    //   123: getstatic 454	com/badlogic/gdx/g:b	Lcom/badlogic/gdx/h;
    //   126: invokeinterface 456 1 0
    //   131: ifnonnull +25 -> 156
    //   134: getstatic 454	com/badlogic/gdx/g:b	Lcom/badlogic/gdx/h;
    //   137: invokeinterface 458 1 0
    //   142: ifnonnull +14 -> 156
    //   145: getstatic 454	com/badlogic/gdx/g:b	Lcom/badlogic/gdx/h;
    //   148: invokeinterface 460 1 0
    //   153: ifnull +63 -> 216
    //   156: aload_0
    //   157: getfield 133	com/badlogic/gdx/backends/android/a/d:d	Lcom/badlogic/gdx/backends/android/a/a;
    //   160: getfield 463	com/badlogic/gdx/backends/android/a/a:j	Lcom/badlogic/gdx/utils/a;
    //   163: astore_1
    //   164: aload_1
    //   165: monitorenter
    //   166: iconst_0
    //   167: istore_2
    //   168: iload_2
    //   169: aload_0
    //   170: getfield 133	com/badlogic/gdx/backends/android/a/d:d	Lcom/badlogic/gdx/backends/android/a/a;
    //   173: getfield 463	com/badlogic/gdx/backends/android/a/a:j	Lcom/badlogic/gdx/utils/a;
    //   176: getfield 466	com/badlogic/gdx/utils/a:b	I
    //   179: if_icmplt +86 -> 265
    //   182: aload_0
    //   183: getfield 133	com/badlogic/gdx/backends/android/a/d:d	Lcom/badlogic/gdx/backends/android/a/a;
    //   186: getfield 463	com/badlogic/gdx/backends/android/a/a:j	Lcom/badlogic/gdx/utils/a;
    //   189: invokevirtual 467	com/badlogic/gdx/utils/a:b	()V
    //   192: aload_1
    //   193: monitorexit
    //   194: aload_0
    //   195: getfield 133	com/badlogic/gdx/backends/android/a/d:d	Lcom/badlogic/gdx/backends/android/a/a;
    //   198: getfield 470	com/badlogic/gdx/backends/android/a/a:d	Lcom/badlogic/gdx/backends/android/a/f;
    //   201: invokevirtual 473	com/badlogic/gdx/backends/android/a/f:b	()V
    //   204: aload_0
    //   205: getfield 133	com/badlogic/gdx/backends/android/a/d:d	Lcom/badlogic/gdx/backends/android/a/a;
    //   208: invokevirtual 393	com/badlogic/gdx/backends/android/a/a:h	()Lcom/badlogic/gdx/c;
    //   211: invokeinterface 474 1 0
    //   216: lload_3
    //   217: aload_0
    //   218: getfield 78	com/badlogic/gdx/backends/android/a/d:l	J
    //   221: lsub
    //   222: ldc2_w 475
    //   225: lcmp
    //   226: ifle +21 -> 247
    //   229: aload_0
    //   230: aload_0
    //   231: getfield 80	com/badlogic/gdx/backends/android/a/d:m	I
    //   234: putfield 478	com/badlogic/gdx/backends/android/a/d:n	I
    //   237: aload_0
    //   238: iconst_0
    //   239: putfield 80	com/badlogic/gdx/backends/android/a/d:m	I
    //   242: aload_0
    //   243: lload_3
    //   244: putfield 78	com/badlogic/gdx/backends/android/a/d:l	J
    //   247: aload_0
    //   248: aload_0
    //   249: getfield 80	com/badlogic/gdx/backends/android/a/d:m	I
    //   252: iconst_1
    //   253: iadd
    //   254: putfield 80	com/badlogic/gdx/backends/android/a/d:m	I
    //   257: return
    //   258: astore 7
    //   260: aload_1
    //   261: monitorexit
    //   262: aload 7
    //   264: athrow
    //   265: aload_0
    //   266: getfield 133	com/badlogic/gdx/backends/android/a/d:d	Lcom/badlogic/gdx/backends/android/a/a;
    //   269: getfield 463	com/badlogic/gdx/backends/android/a/a:j	Lcom/badlogic/gdx/utils/a;
    //   272: iload_2
    //   273: invokevirtual 481	com/badlogic/gdx/utils/a:a	(I)Ljava/lang/Object;
    //   276: checkcast 483	java/lang/Runnable
    //   279: invokeinterface 486 1 0
    //   284: iload_2
    //   285: iconst_1
    //   286: iadd
    //   287: istore_2
    //   288: goto -120 -> 168
    //   291: astore 7
    //   293: aload_1
    //   294: monitorexit
    //   295: aload 7
    //   297: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	d
    //   0	298	1	paramGL10	GL10
    //   167	121	2	i1	int
    //   3	241	3	l1	long
    //   46	73	5	bool1	boolean
    //   52	13	6	bool2	boolean
    //   258	5	7	localObject1	Object
    //   291	5	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   42	78	258	finally
    //   78	97	258	finally
    //   97	116	258	finally
    //   116	118	258	finally
    //   260	262	258	finally
    //   168	194	291	finally
    //   265	284	291	finally
    //   293	295	291	finally
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    p();
    paramGL10.glViewport(0, 0, this.b, this.c);
    this.d.h().a(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    a(paramGL10);
    a(paramEGLConfig);
    p();
    com.badlogic.gdx.graphics.h.a(this.d);
    p.b(this.d);
    k.a(this.d);
    com.badlogic.gdx.graphics.glutils.d.a(this.d);
    try
    {
      g.a.a("AndroidGraphicsLW", com.badlogic.gdx.graphics.h.e());
      g.a.a("AndroidGraphicsLW", p.o());
      g.a.a("AndroidGraphicsLW", k.f());
      g.a.a("AndroidGraphicsLW", com.badlogic.gdx.graphics.glutils.d.b());
      paramEGLConfig = ((WindowManager)this.d.f().getSystemService("window")).getDefaultDisplay();
      this.b = paramEGLConfig.getWidth();
      this.c = paramEGLConfig.getHeight();
      this.o = new com.badlogic.gdx.math.h(5);
      this.j = System.nanoTime();
      paramGL10.glViewport(0, 0, this.b, this.c);
      if (!this.p)
      {
        this.d.h().a();
        this.p = true;
        try
        {
          this.q = true;
          return;
        }
        finally {}
      }
    }
    catch (Throwable paramEGLConfig)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */