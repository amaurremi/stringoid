package com.gau.go.launcherex.gowidget.weather.scroller;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

public class h
  extends g
{
  protected int A = 1;
  protected int B;
  protected int C;
  protected int D = 1;
  protected int E;
  protected int F;
  protected boolean G;
  protected int H;
  protected int I;
  protected int J;
  protected int K;
  protected int L;
  protected int M;
  protected int N;
  protected int O;
  protected int P = 1000;
  protected int Q = 500;
  protected int R;
  protected int S;
  protected int T;
  protected int U;
  boolean V = true;
  boolean W = true;
  protected boolean X;
  protected boolean Y;
  protected Drawable Z;
  protected Bitmap aa;
  protected Paint ab;
  protected int ac = 49;
  protected int ad;
  protected d m;
  protected int n;
  protected i o;
  protected Interpolator p;
  protected Interpolator q;
  protected int r;
  protected int s;
  protected int t;
  protected int u;
  protected int v;
  protected float w;
  protected float x;
  protected float y;
  protected float z = 0.5F;
  
  static
  {
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      ae = bool;
      return;
    }
  }
  
  public h(i parami)
  {
    this(parami, null);
  }
  
  public h(i parami, d paramd)
  {
    if ((!ae) && (parami == null)) {
      throw new AssertionError();
    }
    this.q = g.l;
    this.p = this.q;
    this.o = parami;
    if (paramd != null) {}
    for (;;)
    {
      this.m = paramd;
      return;
      paramd = new d();
    }
  }
  
  private static void a(h paramh1, h paramh2)
  {
    paramh2.F = paramh1.a();
    paramh2.T = paramh1.T;
    paramh2.z = paramh1.z;
    paramh2.A = paramh1.A;
    paramh2.f = paramh1.f;
    paramh2.c(paramh1.B, paramh1.C);
    paramh2.a(paramh1.n());
    paramh2.h(paramh1.P);
    paramh2.a(paramh1.i);
    paramh2.a(paramh1.Z);
    paramh2.b(paramh1.Y);
    paramh2.k(paramh1.ac);
    paramh2.a(Boolean.valueOf(paramh1.V));
  }
  
  public static void a(i parami, boolean paramBoolean)
  {
    if (parami == null) {}
    h localh;
    do
    {
      return;
      localh = parami.getScreenScroller();
    } while ((localh != null) && (localh.s() == paramBoolean));
    if (paramBoolean) {}
    for (Object localObject = new b(parami);; localObject = new h(parami))
    {
      parami.setScreenScroller((h)localObject);
      if (localh == null) {
        break;
      }
      a(localh, (h)localObject);
      localh.u();
      return;
    }
  }
  
  private static float l(int paramInt)
  {
    float[] arrayOfFloat = new float[11];
    float[] tmp6_5 = arrayOfFloat;
    tmp6_5[0] = 0.0F;
    float[] tmp10_6 = tmp6_5;
    tmp10_6[1] = 1.1652954F;
    float[] tmp15_10 = tmp10_6;
    tmp15_10[2] = 1.7015402F;
    float[] tmp20_15 = tmp15_10;
    tmp20_15[3] = 2.1642938F;
    float[] tmp25_20 = tmp20_15;
    tmp25_20[4] = 2.5923889F;
    float[] tmp30_25 = tmp25_20;
    tmp30_25[5] = 3.0F;
    float[] tmp35_30 = tmp30_25;
    tmp35_30[6] = 3.3940518F;
    float[] tmp41_35 = tmp35_30;
    tmp41_35[7] = 3.7784798F;
    float[] tmp47_41 = tmp41_35;
    tmp47_41[8] = 4.155745F;
    float[] tmp53_47 = tmp47_41;
    tmp53_47[9] = 4.5274878F;
    float[] tmp59_53 = tmp53_47;
    tmp59_53[10] = 4.8948593F;
    tmp59_53;
    paramInt = Math.max(0, Math.min(paramInt, 49));
    int i = paramInt / 5;
    float f = arrayOfFloat[i];
    return (arrayOfFloat[(i + 1)] - arrayOfFloat[i]) * (paramInt / 5.0F - i) + f;
  }
  
  public int a()
  {
    return this.F;
  }
  
  public void a(float paramFloat)
  {
    float f = 0.0F;
    f();
    if (this.z == paramFloat) {
      return;
    }
    this.z = Math.max(0.0F, Math.min(paramFloat, 0.5F));
    this.r = Math.max(-(int)(this.D * paramFloat), -this.D / 2);
    this.s = Math.min(this.t + (int)(this.D * paramFloat), this.t + this.D / 2 - 1);
    this.s = Math.max(this.r, this.s);
    paramFloat = f;
    if (this.s > this.r) {
      paramFloat = 1.0F / (this.s - this.r);
    }
    this.w = paramFloat;
    a(a() * this.D);
  }
  
  protected void a(int paramInt)
  {
    this.u = this.e;
    this.e = paramInt;
    if (this.e != this.u)
    {
      if (this.f != 0) {
        break label107;
      }
      this.o.scrollBy(this.e - this.u, 0);
    }
    for (;;)
    {
      this.o.onScrollChanged(this.e, this.u);
      paramInt = this.E;
      this.E = b(this.e);
      if (this.E != paramInt) {
        this.o.onScreenChanged(this.E, paramInt);
      }
      return;
      label107:
      this.o.scrollBy(0, this.e - this.u);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {}
    int i;
    for (;;)
    {
      this.p = paramInterpolator;
      this.F = d(paramInt1);
      i = this.F * this.D - this.e;
      if ((i != 0) || (j() != 0.0F)) {
        break;
      }
      this.g = 0;
      this.o.onScrollFinish(a());
      return;
      paramInterpolator = g.l;
    }
    paramInt1 = paramInt2;
    if (this.n != 0)
    {
      paramInt1 = paramInt2;
      if (this.p != k)
      {
        paramInt1 = Math.min(paramInt2, d(i, this.n));
        this.n = 0;
      }
    }
    a(this.e, i, paramInt1);
    this.o.onFlingStart();
    this.o.postInvalidate();
  }
  
  public void a(Drawable paramDrawable)
  {
    this.Z = paramDrawable;
    this.aa = null;
    if (this.Z != null)
    {
      this.R = this.Z.getIntrinsicWidth();
      this.S = this.Z.getIntrinsicHeight();
      this.Z.setBounds(0, 0, this.R, this.S);
      t();
      if ((this.Z instanceof BitmapDrawable)) {
        this.aa = ((BitmapDrawable)this.Z).getBitmap();
      }
    }
  }
  
  public void a(Interpolator paramInterpolator)
  {
    Interpolator localInterpolator = paramInterpolator;
    if (paramInterpolator == null) {
      localInterpolator = g.l;
    }
    this.p = localInterpolator;
    this.q = this.p;
  }
  
  public void a(Boolean paramBoolean)
  {
    this.V = paramBoolean.booleanValue();
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    this.N = ((int)paramMotionEvent.getX());
    this.O = ((int)paramMotionEvent.getY());
    if (this.f == 0) {}
    int j;
    for (int i = this.N;; i = this.O)
    {
      j = this.M;
      this.M = i;
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    this.m.a();
    this.m.a(paramMotionEvent);
    this.I = this.M;
    this.J = this.N;
    this.K = this.O;
    this.L = this.e;
    this.H = this.E;
    if (this.g == 1) {
      this.o.onFlingIntercepted();
    }
    if (this.g != 0) {
      this.g = 2;
    }
    for (;;)
    {
      return true;
      this.m.a(paramMotionEvent);
      e(j - i);
      continue;
      this.m.a(paramMotionEvent);
      this.m.a(1000);
      if (this.f == 0) {}
      for (float f = this.m.b();; f = this.m.c())
      {
        this.n = ((int)f);
        if ((this.n <= 500) || (this.I >= i)) {
          break label279;
        }
        b(this.H - 1, this.P);
        break;
      }
      label279:
      if ((this.n < 65036) && (this.I > i))
      {
        b(this.H + 1, this.P);
      }
      else
      {
        this.n = 500;
        b(b(this.e), this.P);
        continue;
        b(this.H, this.P);
      }
    }
  }
  
  public int b()
  {
    int j = this.E;
    int i = j;
    if (r() > 0) {
      i = j - 1;
    }
    if (i >= 0)
    {
      j = i;
      if (i < this.A) {}
    }
    else
    {
      j = -1;
    }
    return j;
  }
  
  protected int b(int paramInt)
  {
    return (this.D / 2 + paramInt) / this.D;
  }
  
  protected void b(float paramFloat)
  {
    paramFloat = this.p.getInterpolation(paramFloat);
    int i;
    if (e())
    {
      i = this.c;
      if ((e()) || (paramFloat <= 1.0F)) {
        break label97;
      }
    }
    label97:
    for (boolean bool = true;; bool = false)
    {
      this.G = bool;
      a(i);
      if (d()) {
        this.o.onScrollFinish(a());
      }
      this.o.postInvalidate();
      return;
      i = this.b + Math.round(this.d * paramFloat);
      break;
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    Interpolator localInterpolator = this.q;
    int i;
    if ((this.e < 0) || (paramInt1 < 0))
    {
      i = 0;
      paramInt2 = this.Q;
      localInterpolator = g.k;
    }
    for (;;)
    {
      a(i, paramInt2, localInterpolator);
      return;
      if (this.e < this.t)
      {
        i = paramInt1;
        if (paramInt1 < this.A) {}
      }
      else
      {
        i = this.A - 1;
        paramInt2 = this.Q;
        localInterpolator = g.k;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.Y = paramBoolean;
  }
  
  public int c()
  {
    int j = this.E;
    int k = r();
    if (k == 0) {}
    int i;
    do
    {
      return -1;
      i = j;
      if (k < 0) {
        i = j + 1;
      }
    } while ((i < 0) || (i >= this.A));
    return i;
  }
  
  protected int c(int paramInt)
  {
    paramInt /= 2;
    return Math.max(this.r - this.e, Math.min(paramInt, this.s - this.e));
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    f();
    if ((this.B == paramInt1) && (this.C == paramInt2)) {}
    while ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    this.B = paramInt1;
    this.C = paramInt2;
    t();
    m();
  }
  
  protected int d(int paramInt)
  {
    return Math.max(0, Math.min(paramInt, this.A - 1));
  }
  
  protected int d(int paramInt1, int paramInt2)
  {
    return (int)Math.abs(this.p.getInterpolation(1.0E-6F) * 1000000.0F * paramInt1 * 1000.0F / paramInt2);
  }
  
  protected void e(int paramInt)
  {
    int j = this.e + paramInt;
    int i;
    if (j >= 0)
    {
      i = paramInt;
      if (j < this.t) {}
    }
    else
    {
      i = c(paramInt);
    }
    if (i == 0) {
      return;
    }
    if (this.g == 0)
    {
      h();
      this.o.onScrollStart();
    }
    a(this.e + i);
  }
  
  public void f()
  {
    if (this.g == 1)
    {
      super.f();
      b(1.0F);
    }
  }
  
  public void f(int paramInt)
  {
    f();
    if (paramInt == this.f) {
      return;
    }
    this.e = 0;
    if (paramInt == 0) {
      this.o.scrollBy(0, -this.o.getScrollY());
    }
    for (;;)
    {
      this.f = paramInt;
      m();
      return;
      this.o.scrollBy(-this.o.getScrollX(), 0);
    }
  }
  
  public void g(int paramInt)
  {
    float f2 = 0.0F;
    f();
    if (this.A == paramInt) {}
    while (paramInt <= 0) {
      return;
    }
    this.A = paramInt;
    if (this.A > 0) {}
    for (float f1 = 1.0F / this.A;; f1 = 0.0F)
    {
      this.y = f1;
      this.t = (this.D * (this.A - 1));
      this.v = (this.D * this.A);
      f1 = f2;
      if (this.v > 0) {
        f1 = 1.0F / this.v;
      }
      this.x = f1;
      f1 = this.z;
      this.z = -1.0F;
      a(f1);
      return;
    }
  }
  
  public void h(int paramInt)
  {
    this.P = Math.max(1, paramInt);
  }
  
  protected void i()
  {
    this.o.postInvalidate();
  }
  
  public void i(int paramInt)
  {
    f();
    this.F = paramInt;
    if ((this.F == 0) && (this.e == 0))
    {
      paramInt = this.E;
      this.E = 0;
      if (this.E != paramInt) {
        this.o.onScreenChanged(this.E, paramInt);
      }
      return;
    }
    a(this.F * this.D);
  }
  
  public void j(int paramInt)
  {
    if ((!this.W) && (paramInt != this.ac)) {}
    do
    {
      return;
      paramInt = Math.min(paramInt, this.ac);
    } while (this.ad == paramInt);
    this.ad = paramInt;
    if (paramInt <= 0)
    {
      a(l);
      return;
    }
    a(new OvershootInterpolator(l(paramInt)));
  }
  
  public void k(int paramInt)
  {
    this.ac = Math.max(0, Math.min(paramInt, 49));
    j(this.ac);
  }
  
  protected void m()
  {
    this.e = 0;
    if (this.f == 0)
    {
      this.D = this.B;
      this.o.scrollBy(-this.o.getScrollX(), 0);
    }
    for (;;)
    {
      int i = this.A;
      this.A = -1;
      g(i);
      return;
      this.D = this.C;
      this.o.scrollBy(0, -this.o.getScrollY());
    }
  }
  
  public final Interpolator n()
  {
    return this.q;
  }
  
  public final int o()
  {
    return this.B;
  }
  
  public final int p()
  {
    return this.C;
  }
  
  public final int q()
  {
    return this.D;
  }
  
  public final int r()
  {
    return this.E * this.D - this.e;
  }
  
  public boolean s()
  {
    return this.X;
  }
  
  protected void t()
  {
    this.U = ((this.T + this.S - this.C) / 2);
  }
  
  void u() {}
  
  public float v()
  {
    this.m.a(1000);
    return (float)Math.sqrt(this.m.b() * this.m.b() + this.m.c() * this.m.c());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/scroller/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */