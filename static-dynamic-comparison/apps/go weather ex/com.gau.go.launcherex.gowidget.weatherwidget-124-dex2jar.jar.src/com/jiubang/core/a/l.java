package com.jiubang.core.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import java.lang.ref.SoftReference;

public abstract class l
{
  private volatile boolean A;
  private float B;
  private int C;
  private float D;
  private int E;
  private int F;
  private int G;
  private int H;
  protected volatile int a;
  protected volatile int b;
  protected volatile int c;
  protected volatile int d;
  protected volatile int e;
  protected volatile int f;
  protected u g;
  protected boolean h = true;
  protected Paint i;
  protected Bitmap j;
  protected Rect k;
  protected boolean l;
  protected s m;
  protected v n;
  protected Matrix o;
  protected volatile boolean p;
  protected Bitmap q;
  int r;
  int s;
  int t;
  int u = 255;
  SoftReference v;
  private Context w;
  private int x = 0;
  private k y;
  private float z;
  
  public l(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Bitmap paramBitmap)
  {
    this.a = paramInt2;
    this.b = paramInt3;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.j = paramBitmap;
    this.k = new Rect(paramInt2, paramInt3, paramInt2 + paramInt4, paramInt3 + paramInt5);
    this.i = new Paint();
    this.w = paramContext;
    this.m = new s();
    this.o = new Matrix();
    this.z = 1.0F;
    this.A = false;
    this.B = 1.0F;
    this.D = 1.0F;
    this.F = 0;
    this.n = new v();
  }
  
  private boolean c(float paramFloat, int paramInt)
  {
    boolean bool = true;
    paramFloat = this.a + paramFloat;
    if ((this.e + paramFloat < 0.0F) || (paramFloat > paramInt)) {
      bool = false;
    }
    return bool;
  }
  
  private void t()
  {
    this.n.i();
    this.m.c();
    this.m.a(this.z);
    Matrix localMatrix = this.m.a();
    localMatrix.postTranslate(this.c, this.d);
    localMatrix.postScale(this.B, this.D, this.C, this.E);
    localMatrix.postRotate(this.F, this.G, this.H);
  }
  
  public int a()
  {
    return this.e;
  }
  
  public Bitmap a(float paramFloat, int paramInt)
  {
    if ((this.r & 0x8000) == 32768) {
      b(paramFloat, paramInt);
    }
    if (this.v == null) {
      return null;
    }
    return (Bitmap)this.v.get();
  }
  
  public void a(float paramFloat)
  {
    this.z = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.k.left = paramInt1;
    this.k.top = paramInt2;
    this.k.right = (this.e + paramInt1);
    this.k.bottom = (this.f + paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.j = paramBitmap;
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    a(paramCanvas, paramFloat1, paramFloat2, paramFloat3, paramInt1, paramInt2, true);
  }
  
  public void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.p = paramBoolean;
    if ((this.A) && (c(paramFloat3, paramInt1))) {
      b(paramCanvas, paramFloat3, paramInt1, paramInt2);
    }
  }
  
  protected abstract void a(Canvas paramCanvas, float paramFloat, int paramInt1, int paramInt2);
  
  public void a(k paramk)
  {
    this.y = paramk;
  }
  
  public void a(u paramu)
  {
    this.g = paramu;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a(long paramLong)
  {
    if (!this.A) {
      this.A = true;
    }
    this.a = this.c;
    this.b = this.d;
    t();
    boolean bool1 = false;
    if (this.y != null) {
      bool1 = this.y.b(this.m, this, paramLong, this.n);
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (this.y != null)
      {
        bool2 = bool1;
        if (this.y.c())
        {
          if (!this.y.d()) {
            this.y = null;
          }
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public void b(float paramFloat)
  {
    this.B = paramFloat;
  }
  
  public void b(float paramFloat, int paramInt)
  {
    Context localContext;
    int i3;
    int i4;
    int i2;
    if (((this.s & 0x8000) == 0) || (this.v == null) || (this.v.get() == null))
    {
      localContext = j();
      i3 = a();
      i4 = b();
      i2 = this.t;
      if ((i2 == 0) && (!i())) {
        break label93;
      }
    }
    label93:
    for (int i1 = 1; (i3 <= 0) || (i4 <= 0) || (i3 * i4 * 4 > ViewConfiguration.getMaximumDrawingCacheSize()); i1 = 0)
    {
      m();
      return;
    }
    Bitmap localBitmap;
    label108:
    Object localObject;
    if (this.v == null)
    {
      localBitmap = null;
      if ((localBitmap != null) && (localBitmap.getWidth() == i3) && (localBitmap.getHeight() == i4)) {
        break label322;
      }
      localObject = Bitmap.Config.ARGB_8888;
      if (i1 != 0) {
        localObject = Bitmap.Config.ARGB_8888;
      }
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
    for (;;)
    {
      try
      {
        localBitmap = Bitmap.createBitmap(i3, i4, (Bitmap.Config)localObject);
        if ((localBitmap != null) && (localContext != null))
        {
          localBitmap.setDensity(localContext.getResources().getDisplayMetrics().densityDpi);
          this.v = new SoftReference(localBitmap);
        }
        if (i2 == 0) {
          break label317;
        }
        i1 = 1;
        if (localBitmap == null) {
          break;
        }
        localObject = new Canvas(localBitmap);
        if (i1 != 0) {
          localBitmap.eraseColor(i2);
        }
        i1 = ((Canvas)localObject).save();
        this.s |= 0x20;
        this.s |= 0x8000;
        a((Canvas)localObject, 0.0F, 0.0F, paramFloat, paramInt, 255);
        ((Canvas)localObject).restoreToCount(i1);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        this.v = null;
        return;
      }
      localBitmap = (Bitmap)this.v.get();
      break label108;
      label317:
      i1 = 0;
      continue;
      label322:
      i1 = 1;
    }
  }
  
  public void b(int paramInt)
  {
    this.i.setFlags(paramInt);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.e = (paramInt3 - paramInt1);
    this.f = (paramInt4 - paramInt2);
    this.k.left = paramInt1;
    this.k.top = paramInt2;
    this.k.right = paramInt3;
    this.k.bottom = paramInt4;
  }
  
  public void b(Bitmap paramBitmap)
  {
    this.q = paramBitmap;
  }
  
  public final void b(Canvas paramCanvas, float paramFloat, int paramInt1, int paramInt2)
  {
    if (this.x != 0)
    {
      int i1 = this.i.getColor();
      int i2 = this.i.getAlpha();
      this.i.setColor(this.x);
      this.i.setAlpha(paramInt2);
      paramCanvas.drawRect(0.0F, 0.0F, this.e, this.f, this.i);
      this.i.setColor(i1);
      this.i.setAlpha(i2);
    }
    a(paramCanvas, paramFloat, paramInt1, paramInt2);
  }
  
  public void c(int paramInt)
  {
    this.C = paramInt;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public void d()
  {
    if (!this.l)
    {
      this.l = true;
      e();
    }
  }
  
  public void d(int paramInt)
  {
    this.E = paramInt;
  }
  
  protected void e() {}
  
  public void e(int paramInt)
  {
    this.F = paramInt;
  }
  
  public int f()
  {
    return this.a;
  }
  
  public void f(int paramInt)
  {
    this.G = paramInt;
  }
  
  public int g()
  {
    return this.b;
  }
  
  public void g(int paramInt)
  {
    this.H = paramInt;
  }
  
  public abstract void h();
  
  boolean i()
  {
    return false;
  }
  
  public Context j()
  {
    return this.w;
  }
  
  public int k()
  {
    return this.u;
  }
  
  public boolean l()
  {
    return (this.r & 0x8000) == 32768;
  }
  
  public void m()
  {
    if (this.v != null)
    {
      Bitmap localBitmap = (Bitmap)this.v.get();
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      this.v = null;
    }
  }
  
  public void n()
  {
    if ((this.s & 0x20) == 32) {
      this.s &= 0xFFFF7FDF;
    }
  }
  
  public Bitmap o()
  {
    return this.j;
  }
  
  public void p() {}
  
  public void q() {}
  
  public Bitmap r()
  {
    return this.q;
  }
  
  public abstract boolean s();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */