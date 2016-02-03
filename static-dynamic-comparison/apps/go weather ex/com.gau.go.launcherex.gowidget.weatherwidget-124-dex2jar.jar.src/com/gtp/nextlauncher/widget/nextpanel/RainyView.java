package com.gtp.nextlauncher.widget.nextpanel;

import android.content.Context;
import android.graphics.Rect;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLView;
import java.lang.reflect.Array;
import java.util.concurrent.ExecutorService;

public class RainyView
  extends Wall
{
  private boolean A = false;
  private float B = 0.0F;
  private float[] C = new float[2];
  private final int D = 10;
  private int E = 0;
  private boolean F = false;
  private float[] G = new float[3];
  private final float H = 1.0F;
  private boolean[] I = new boolean[10];
  private float[] J = new float[10];
  private float[] K = new float[10];
  private long[] L = new long[10];
  private float M = 2000.0F;
  private float[][] N = (float[][])Array.newInstance(Float.TYPE, new int[] { 10, 3 });
  private boolean[] O = new boolean[10];
  private float P = 0.2F;
  private boolean Q = false;
  private final int R = 6;
  private float[] S = new float[6];
  private long T;
  private final int U = 1000;
  private final float V = 0.33333334F;
  private GLDrawable[] W;
  private final float X = 0.4F;
  private GLView Y;
  private float[] Z = { 2.0F, 1.0F, 1.5F, 1.0F, 2.0F, 3.0F, 1.5F, 2.0F, 1.5F, 3.0F };
  private Context a;
  private boolean aa = false;
  private boolean ab = false;
  private boolean ac = false;
  private boolean ad = false;
  private final float ae = 1000.0F;
  private float af = 1.0F;
  private long ag = 0L;
  private boolean ah = false;
  private boolean ai = true;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private GLDrawable e;
  private GLDrawable f;
  private final int g = 3;
  private GLDrawable[] h = new GLDrawable[3];
  private GLDrawable i;
  private final float j = 0.5F;
  private final float[] k = { 0.3F, 0.35F, 0.4F };
  private Rect l = new Rect();
  private float m = 0.0F;
  private boolean n = false;
  private final float o = 0.6F;
  private final int p = 100;
  private final int q = 200;
  private int[][] r = (int[][])Array.newInstance(Integer.TYPE, new int[] { 3, 100 });
  private int[][] s = (int[][])Array.newInstance(Integer.TYPE, new int[] { 3, 100 });
  private int[][] t = (int[][])Array.newInstance(Integer.TYPE, new int[] { 3, 100 });
  private boolean[][] u = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 100 });
  private long[][] v = (long[][])Array.newInstance(Long.TYPE, new int[] { 3, 100 });
  private final int w = 800;
  private final float x = 0.05F;
  private boolean[][] y = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 100 });
  private boolean z = false;
  
  public RainyView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    setBackgroundColor(16777215);
  }
  
  private void a()
  {
    if (!this.z) {}
    double d1;
    int i1;
    do
    {
      return;
      d1 = Math.random();
      i1 = (int)(10.0D * d1);
    } while (this.I[i1] != 0);
    int i2 = (int)(this.G[2] * (1.0D - d1));
    int i3 = (int)(this.mWidth / (0.6000000238418579D * d1));
    this.N[i1][0] = ((float)((d1 - 0.5D) * i3));
    this.N[i1][2] = i2;
    a(i1);
    this.F = false;
  }
  
  private void a(float paramFloat)
  {
    int i1 = 0;
    if (i1 < 6)
    {
      float f1 = (paramFloat - 0.16666667F * i1) / 0.33333334F;
      if ((f1 < 0.0F) || (f1 > 1.0F)) {
        this.S[i1] = 0.0F;
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.S[i1] = 1.0F;
      }
    }
    if ((paramFloat < 0.1F) || ((paramFloat > 0.2D) && (paramFloat < 0.3D)) || ((paramFloat > 0.6D) && (paramFloat < 0.7D))) {}
    for (this.B = 1.0F;; this.B = 0.0F)
    {
      if (paramFloat == 1.0F) {
        c();
      }
      invalidate();
      return;
    }
  }
  
  private void a(int paramInt)
  {
    this.I[paramInt] = true;
    this.L[paramInt] = -1L;
    this.O[paramInt] = false;
    invalidate();
  }
  
  private void a(int paramInt, float paramFloat)
  {
    this.J[paramInt] = (1.0F - paramFloat);
    this.K[paramInt] = (this.Z[paramInt] * paramFloat);
    if ((paramFloat > this.P) && (this.O[paramInt] == 0))
    {
      a();
      this.O[paramInt] = true;
    }
    if (paramFloat == 1.0F) {
      b(paramInt);
    }
    invalidate();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    float f1 = 0.8F;
    float f2 = 0.4F;
    if ((this.e == null) || (this.f == null)) {
      return;
    }
    if (paramInt1 < paramInt2)
    {
      this.C[1] = -1.0F;
      this.C[0] = 1.2F;
      f1 = 0.4F;
    }
    for (;;)
    {
      if (this.e != null) {
        e.a(this, this.e, paramInt1, paramInt2, 0.5F, this.C, f1, f2, null);
      }
      if (this.f != null) {
        e.a(this, this.f, paramInt1, paramInt2, 0.5F, this.C, f1, f2, null);
      }
      this.aa = true;
      return;
      this.C[1] = 0.8F;
      this.C[0] = -1.0F;
      f2 = 0.3F;
    }
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat)
  {
    this.t[paramInt1][paramInt2] = ((int)(this.m * paramFloat));
    if (paramFloat == 1.0F) {
      g(paramInt1, paramInt2);
    }
    if ((this.y[paramInt1][paramInt2] == 0) && (paramFloat > 0.05F))
    {
      f(paramInt1, paramInt2);
      this.y[paramInt1][paramInt2] = 1;
    }
    invalidate();
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if ((this.h[2] == null) || (this.i == null)) {
      return;
    }
    this.C[0] = -1.0F;
    this.C[1] = 0.1F;
    if (this.h[0] != null) {
      e.a(this, this.h[0], paramInt1, paramInt2, this.k[0], this.C, paramFloat1, paramFloat2, null);
    }
    e.a(this, this.h[1], paramInt1, paramInt2, this.k[1], this.C, paramFloat1 + 0.1F, paramFloat2, null);
    e.a(this, this.h[2], paramInt1, paramInt2, this.k[2], this.C, paramFloat1 - 0.1F, paramFloat2, null);
    this.m = (0.7F * paramInt2);
    this.C[0] = 0.2F;
    e.a(this, this.i, paramInt1, paramInt2, 0.6F, this.C, paramFloat1, 1.0F, this.G);
    d(paramInt1, paramInt2);
  }
  
  private void a(Context paramContext)
  {
    if (this.e == null) {
      this.e = e.a().v(paramContext);
    }
    if (this.f == null) {
      this.f = e.a().w(paramContext);
    }
  }
  
  private void a(GLCanvas paramGLCanvas)
  {
    int i3 = paramGLCanvas.getAlpha();
    paramGLCanvas.setAlpha((int)(i3 * 1.0F));
    int i1 = 0;
    while (i1 < 3)
    {
      int i2 = 0;
      while (i2 < 100)
      {
        if (this.v[i1][i2] == -1L) {
          this.v[i1][i2] = getDrawingTime();
        }
        if (this.u[i1][i2] != 0)
        {
          float f1 = Math.max(0.0F, Math.min((float)(getDrawingTime() - this.v[i1][i2]) / 800.0F, 1.0F));
          if (!this.F) {
            a(i1, i2, f1);
          }
          int i4 = paramGLCanvas.save();
          paramGLCanvas.translate(this.r[i1][i2], this.t[i1][i2]);
          if (this.h[i1] != null) {
            this.h[i1].draw(paramGLCanvas);
          }
          paramGLCanvas.restoreToCount(i4);
        }
        i2 += 1;
      }
      i1 += 1;
    }
    paramGLCanvas.setAlpha(i3);
  }
  
  private void b()
  {
    this.Q = true;
    this.T = -1L;
    invalidate();
  }
  
  private void b(float paramFloat)
  {
    this.af = paramFloat;
    if (paramFloat == 1.0F) {
      f();
    }
    invalidate();
  }
  
  private void b(int paramInt)
  {
    this.I[paramInt] = false;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    float f2 = 0.8F;
    float f1 = 0.4F;
    if (paramInt1 < paramInt2)
    {
      this.C[1] = -1.0F;
      this.C[0] = 1.2F;
      f2 = 0.4F;
    }
    for (;;)
    {
      if (this.c) {
        a(paramInt1, paramInt2, f2, f1);
      }
      this.ab = true;
      return;
      this.C[1] = 0.8F;
      this.C[0] = -1.0F;
      f1 = 0.3F;
    }
  }
  
  private void b(Context paramContext)
  {
    if (this.h[0] == null) {
      this.h[0] = e.a().G(paramContext);
    }
    if (this.h[1] == null) {
      this.h[1] = e.a().H(paramContext);
    }
    if (this.h[2] == null) {
      this.h[2] = e.a().I(paramContext);
    }
    if (this.i == null) {
      this.i = e.a().J(paramContext);
    }
  }
  
  private void b(GLCanvas paramGLCanvas)
  {
    int i1 = 0;
    while (i1 < 10)
    {
      if (this.L[i1] == -1L) {
        this.L[i1] = getDrawingTime();
      }
      if (this.I[i1] != 0)
      {
        float f1 = Math.min(1.0F, Math.max(0.0F, (float)(getDrawingTime() - this.L[i1]) / this.M));
        if (!this.F) {
          a(i1, f1);
        }
        int i2 = paramGLCanvas.save();
        int i3 = paramGLCanvas.getAlpha();
        paramGLCanvas.setAlpha((int)(i3 * this.J[i1]));
        paramGLCanvas.translate(this.N[i1][0], this.N[i1][1], this.N[i1][2]);
        paramGLCanvas.translate(this.G[0], this.G[1], this.G[2]);
        paramGLCanvas.scale(this.K[i1], this.K[i1], this.K[i1]);
        paramGLCanvas.translate(-this.G[0], -this.G[1], -this.G[2]);
        if (this.i != null) {
          this.i.draw(paramGLCanvas);
        }
        paramGLCanvas.setAlpha(i3);
        paramGLCanvas.restoreToCount(i2);
      }
      i1 += 1;
    }
  }
  
  private void c()
  {
    this.Q = false;
    this.F = true;
    this.A = false;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if ((this.W == null) || (this.W[5] == null)) {
      return;
    }
    if (paramInt1 < paramInt2)
    {
      this.C[1] = -1.0F;
      this.C[0] = 1.2F;
    }
    for (;;)
    {
      this.C[0] = -1.0F;
      this.C[1] = 0.5F;
      int i1 = 0;
      while (i1 < 6)
      {
        if (this.W[i1] != null) {
          e.a(this, this.W[i1], paramInt1, paramInt2, 0.4F, this.C, 0.5F, 0.75F, null);
        }
        i1 += 1;
      }
      this.C[1] = 0.8F;
      this.C[0] = -1.0F;
    }
    this.C[0] = 1.0F;
    this.C[1] = -1.0F;
    this.ac = true;
  }
  
  private void c(Context paramContext)
  {
    this.W = e.a().K(paramContext);
  }
  
  private void c(GLCanvas paramGLCanvas)
  {
    if (this.W == null) {}
    do
    {
      for (;;)
      {
        return;
        if (!this.Q) {
          break;
        }
        if (this.T == -1L) {
          this.T = getDrawingTime();
        }
        a(Math.max(0.0F, Math.min(1.0F, (float)(getDrawingTime() - this.T) / 1000.0F)));
        int i1 = 0;
        while (i1 < 6)
        {
          int i2 = paramGLCanvas.getAlpha();
          paramGLCanvas.setAlpha((int)(i2 * this.S[i1]));
          if (this.W[i1] != null) {
            this.W[i1].draw(paramGLCanvas);
          }
          paramGLCanvas.setAlpha(i2);
          i1 += 1;
        }
      }
    } while (this.W[5] == null);
    this.W[5].draw(paramGLCanvas);
  }
  
  private void d()
  {
    if (this.ag == -1L) {
      this.ag = getDrawingTime();
    }
    if (this.ad) {
      b(Math.max(0.0F, Math.min(1.0F, (float)(getDrawingTime() - this.ag) / 1000.0F)));
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    if (paramInt1 > paramInt2) {
      i1 = (int)(paramInt1 * 0.4F);
    }
    paramInt1 = 0;
    while (paramInt1 < 3)
    {
      int i2 = 0;
      while (i2 < 100)
      {
        int i3 = (int)(i1 / (this.k[paramInt1] * 1.5F)) / 100;
        this.r[paramInt1][i2] = (i3 * (i2 - 50));
        i3 = (int)(paramInt2 / this.k[paramInt1]);
        this.s[paramInt1][i2] = i3;
        this.u[paramInt1][i2] = 0;
        this.y[paramInt1][i2] = 0;
        i2 += 1;
      }
      paramInt1 += 1;
    }
  }
  
  private void e()
  {
    this.ad = true;
    this.ag = -1L;
    invalidate();
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    this.u[paramInt1][paramInt2] = 1;
    this.v[paramInt1][paramInt2] = -1L;
    this.y[paramInt1][paramInt2] = 0;
    invalidate();
  }
  
  private void f()
  {
    this.ad = false;
    if (this.ah)
    {
      startWeatherAnimaiton();
      this.ah = false;
    }
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    if (!this.z) {
      return;
    }
    if (this.E > 200)
    {
      this.mWallHoder.onPreviewAnimationEnd();
      this.F = true;
      this.A = false;
      return;
    }
    this.E += 1;
    e(paramInt1, (paramInt1 * 11 + paramInt2) % 100);
  }
  
  private void g(int paramInt1, int paramInt2)
  {
    this.u[paramInt1][paramInt2] = 0;
    a();
  }
  
  public void clearDrawable()
  {
    int i2 = 0;
    int i1;
    if (this.W != null)
    {
      i1 = 0;
      while (i1 < 6)
      {
        if (this.W[i1] != null) {
          this.W[i1].clear();
        }
        i1 += 1;
      }
    }
    if (this.e != null)
    {
      this.e.clear();
      this.e = null;
    }
    if (this.f != null)
    {
      this.f.clear();
      this.f = null;
    }
    if (this.h != null)
    {
      i1 = i2;
      while (i1 < 3)
      {
        if (this.h[i1] != null)
        {
          this.h[i1].clear();
          this.h[i1] = null;
        }
        i1 += 1;
      }
    }
    if (this.i != null)
    {
      this.i.clear();
      this.i = null;
    }
    this.ai = true;
  }
  
  public void dispatchDraw(GLCanvas paramGLCanvas)
  {
    if ((this.e == null) || (this.ai)) {
      return;
    }
    d();
    int i1 = paramGLCanvas.getAlpha();
    paramGLCanvas.setAlpha((int)(i1 * this.af));
    if (this.d)
    {
      int i2 = paramGLCanvas.getAlpha();
      paramGLCanvas.setAlpha((int)(i2 * this.B));
      if (this.Y != null) {
        this.Y.draw(paramGLCanvas);
      }
      paramGLCanvas.setAlpha(i2);
    }
    super.dispatchDraw(paramGLCanvas);
    if (this.c)
    {
      a(paramGLCanvas);
      b(paramGLCanvas);
    }
    if ((this.e != null) && (this.aa)) {
      this.e.draw(paramGLCanvas);
    }
    if (this.d) {
      c(paramGLCanvas);
    }
    if ((this.f != null) && (this.aa)) {
      this.f.draw(paramGLCanvas);
    }
    paramGLCanvas.setAlpha(i1);
  }
  
  public void forceAnimationStop()
  {
    if (this.Q) {
      a(1.0F);
    }
  }
  
  public void initDrawable()
  {
    this.aa = false;
    this.ai = true;
    i locali = new i(this);
    this.mScheduledExecutorService.submit(locali);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.l.set(0, 0, paramInt1, paramInt2);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
    {
      this.aa = false;
      this.ab = false;
      this.ac = false;
    }
    if (!this.aa) {
      a(paramInt1, paramInt2);
    }
    if ((this.c) && (!this.ab)) {
      b(paramInt1, paramInt2);
    }
    if ((this.d) && (!this.ac)) {
      c(paramInt1, paramInt2);
    }
    if (this.Y != null)
    {
      this.Y.layout(0, 0, paramInt1, paramInt2);
      this.b = true;
    }
  }
  
  public void setHasRain(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setHasThunder(boolean paramBoolean)
  {
    this.d = paramBoolean;
    this.Y = new GLView(this.a);
    this.Y.setBackgroundColor(1438838527);
    if ((!this.b) && (this.mWidth > 0) && (this.mHeight > 0))
    {
      this.Y.layout(0, 0, this.mWidth, this.mHeight);
      this.b = true;
    }
  }
  
  public boolean startForeAnimation(boolean paramBoolean)
  {
    return true;
  }
  
  public void startWeatherAnimaiton()
  {
    if ((this.A) || (this.ai)) {
      return;
    }
    this.ah = false;
    this.E = 0;
    this.z = true;
    if (!this.F)
    {
      e(2, 0);
      e(0, 16);
      e(1, 33);
      e(0, 99);
      e(1, 80);
      e(2, 50);
    }
    for (;;)
    {
      this.F = false;
      this.A = true;
      b();
      invalidate();
      return;
      int i1 = 0;
      int i4 = 0;
      int i2 = 0;
      while (i1 < 3)
      {
        int i3 = 0;
        if (i3 < 100)
        {
          int i5 = i4;
          int i6 = i2;
          if (this.u[i1][i3] != 0)
          {
            this.v[i1][i3] = (((float)getDrawingTime() - this.t[i1][i3] / this.m * 800.0F));
            if (this.y[i1][i3] == 0) {
              break label202;
            }
            i6 = i2 + 1;
            i5 = i4;
          }
          for (;;)
          {
            i3 += 1;
            i4 = i5;
            i2 = i6;
            break;
            label202:
            i5 = i4 + 1;
            i6 = i2;
          }
        }
        i1 += 1;
      }
      if ((i2 > i4) || (i4 + i2 < 6))
      {
        e(0, 16);
        e(1, 33);
        e(0, 99);
        e(1, 80);
      }
      i1 = 0;
      while (i1 < 10)
      {
        if (this.I[i1] != 0) {
          this.L[i1] = (((float)getDrawingTime() - this.K[i1] / this.Z[i1] * this.M));
        }
        i1 += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/RainyView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */