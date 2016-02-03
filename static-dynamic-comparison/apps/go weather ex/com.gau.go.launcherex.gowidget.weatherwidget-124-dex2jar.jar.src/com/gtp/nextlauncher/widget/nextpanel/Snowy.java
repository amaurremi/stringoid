package com.gtp.nextlauncher.widget.nextpanel;

import android.content.Context;
import android.graphics.Rect;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.graphics.GLDrawable;
import java.lang.reflect.Array;
import java.util.concurrent.ExecutorService;

public class Snowy
  extends Wall
{
  private boolean A = false;
  private boolean B = false;
  private final float C = 1000.0F;
  private float D = 1.0F;
  private long E = 0L;
  private boolean F = false;
  private boolean G = true;
  private final float a = 0.5F;
  private final int b = 3;
  private final int c = 10;
  private GLDrawable d;
  private GLDrawable e;
  private GLDrawable[] f = new GLDrawable[3];
  private float[] g = { 0.4F, 0.43F, 0.45F };
  private Rect h = new Rect();
  private float[] i = new float[2];
  private final int j = 15;
  private int k = 0;
  private float[] l = new float[2];
  private boolean m = false;
  private float[][] n = (float[][])Array.newInstance(Float.TYPE, new int[] { 3, 10 });
  private float[] o = new float[3];
  private float[] p = new float[3];
  private final int q = 3000;
  private int[][] r = (int[][])Array.newInstance(Integer.TYPE, new int[] { 3, 10 });
  private int[][] s = (int[][])Array.newInstance(Integer.TYPE, new int[] { 3, 10 });
  private boolean[][] t = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 10 });
  private long[][] u = (long[][])Array.newInstance(Long.TYPE, new int[] { 3, 10 });
  private final float v = 0.2F;
  private boolean[][] w = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 10 });
  private float[] x = new float[3];
  private float[][] y = (float[][])Array.newInstance(Float.TYPE, new int[] { 3, 10 });
  private boolean z = false;
  
  public Snowy(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(16777215);
  }
  
  private void a()
  {
    if (this.k > 15)
    {
      this.z = true;
      this.mWallHoder.onPreviewAnimationEnd();
      return;
    }
    int i2 = (int)(Math.random() * 3.0D);
    int i1 = (int)(Math.random() * 10.0D);
    if (this.t[i2][i1] == 0) {
      d(i2, i1);
    }
    label108:
    for (;;)
    {
      this.k += 1;
      return;
      i1 = 0;
      for (;;)
      {
        if (i1 >= this.t[i2].length) {
          break label108;
        }
        if (this.t[i2][i1] == 0)
        {
          d(i2, i1);
          break;
        }
        i1 += 1;
      }
    }
  }
  
  private void a(float paramFloat)
  {
    this.D = paramFloat;
    if (paramFloat == 1.0F) {
      d();
    }
    invalidate();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    float f1 = 0.8F;
    float f2 = 0.4F;
    if ((this.e == null) || (this.d == null)) {
      return;
    }
    if (paramInt1 < paramInt2)
    {
      this.l[1] = -1.0F;
      this.l[0] = 1.2F;
      f1 = 0.4F;
    }
    for (;;)
    {
      if (this.d != null) {
        e.a(this, this.d, paramInt1, paramInt2, 0.5F, this.l, f1, f2, this.i);
      }
      if (this.e != null) {
        e.a(this, this.e, paramInt1, paramInt2, 0.5F, this.l, f1, f2, this.i);
      }
      this.A = true;
      return;
      this.l[1] = 0.8F;
      this.l[0] = -1.0F;
      f2 = 0.3F;
    }
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat)
  {
    this.s[paramInt1][paramInt2] = ((int)(this.x[paramInt1] * paramFloat));
    this.y[paramInt1][paramInt2] = (360.0F * paramFloat);
    if (paramFloat < 0.2D) {
      this.n[paramInt1][paramInt2] = (paramFloat / 0.2F);
    }
    if (paramFloat > 0.8D) {
      this.n[paramInt1][paramInt2] = ((1.0F - paramFloat) / 0.2F);
    }
    if (paramFloat == 1.0F) {
      e(paramInt1, paramInt2);
    }
    if ((this.w[paramInt1][paramInt2] == 0) && (paramFloat > 0.2F))
    {
      a();
      this.w[paramInt1][paramInt2] = 1;
    }
    invalidate();
  }
  
  private void a(Context paramContext)
  {
    this.A = false;
    if (this.d == null) {
      this.d = e.a().v(paramContext);
    }
    if (this.e == null) {
      this.e = e.a().w(paramContext);
    }
    if ((this.mWidth > 0) && (this.mHeight > 0)) {
      a(this.mWidth, this.mHeight);
    }
    if (this.f[0] == null) {
      this.f[0] = e.a().D(paramContext);
    }
    if (this.f[1] == null) {
      this.f[1] = e.a().E(paramContext);
    }
    if (this.f[2] == null) {
      this.f[2] = e.a().F(paramContext);
    }
    if ((this.mWidth > 0) && (this.mHeight > 0)) {
      b(this.mWidth, this.mHeight);
    }
  }
  
  private void a(GLCanvas paramGLCanvas)
  {
    int i1 = 0;
    while (i1 < 3)
    {
      int i2 = 0;
      while (i2 < 10)
      {
        if (this.u[i1][i2] == -1L) {
          this.u[i1][i2] = getDrawingTime();
        }
        if (this.t[i1][i2] != 0)
        {
          if (!this.z) {
            a(i1, i2, Math.max(0.0F, Math.min((float)(getDrawingTime() - this.u[i1][i2]) / 3000.0F, 1.0F)));
          }
          int i3 = paramGLCanvas.save();
          int i4 = paramGLCanvas.getAlpha();
          paramGLCanvas.setAlpha((int)(i4 * this.n[i1][i2]));
          paramGLCanvas.translate(this.r[i1][i2], this.s[i1][i2]);
          paramGLCanvas.translate(this.o[i1], this.p[i1], 0.0F);
          paramGLCanvas.rotateAxisAngle(this.y[i1][i2], 0.0F, 0.0F, -1.0F);
          paramGLCanvas.translate(-this.o[i1], -this.p[i1], 0.0F);
          if (this.f[i1] != null) {
            this.f[i1].draw(paramGLCanvas);
          }
          paramGLCanvas.setAlpha(i4);
          paramGLCanvas.restoreToCount(i3);
        }
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  private void b()
  {
    if (this.E == -1L) {
      this.E = getDrawingTime();
    }
    if (this.B) {
      a(Math.max(0.0F, Math.min(1.0F, (float)(getDrawingTime() - this.E) / 1000.0F)));
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.f[2] == null) {
      return;
    }
    float f1 = 0.4F;
    float f2 = 0.4F;
    if (paramInt1 < paramInt2)
    {
      this.l[0] = 0.05F;
      this.l[1] = -1.0F;
      if (paramInt1 > paramInt2)
      {
        f1 = 0.85F;
        f2 = 0.3F;
      }
      if (this.f[0] != null) {
        e.a(this, this.f[0], paramInt1, paramInt2, this.g[0], this.l, f1, f2, this.i);
      }
      this.o[0] = this.i[0];
      this.p[0] = this.i[1];
      if (paramInt1 >= paramInt2) {
        break label355;
      }
      this.l[0] = 0.08F;
      this.l[1] = -1.0F;
      label136:
      if (this.f[1] != null) {
        e.a(this, this.f[1], paramInt1, paramInt2, this.g[1], this.l, f1, f2, this.i);
      }
      this.o[1] = this.i[0];
      this.p[1] = this.i[1];
      if (paramInt1 >= paramInt2) {
        break label375;
      }
      this.l[0] = 0.07F;
      this.l[1] = -1.0F;
    }
    for (;;)
    {
      if (this.f[2] != null) {
        e.a(this, this.f[2], paramInt1, paramInt2, this.g[2], this.l, f1, f2, this.i);
      }
      this.o[2] = this.i[0];
      this.p[2] = this.i[1];
      float[] arrayOfFloat1 = this.x;
      float[] arrayOfFloat2 = this.x;
      float[] arrayOfFloat3 = this.x;
      f1 = paramInt2 * (1.0F - f2);
      arrayOfFloat3[0] = f1;
      arrayOfFloat2[1] = f1;
      arrayOfFloat1[2] = f1;
      c(paramInt1, paramInt2);
      this.m = false;
      return;
      this.l[1] = 0.05F;
      this.l[0] = -1.0F;
      break;
      label355:
      this.l[1] = 0.08F;
      this.l[0] = -1.0F;
      break label136;
      label375:
      this.l[1] = 0.07F;
      this.l[0] = -1.0F;
    }
  }
  
  private void c()
  {
    this.B = true;
    this.E = -1L;
    invalidate();
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    if (paramInt1 > paramInt2) {
      i1 = (int)(paramInt1 * 0.6F);
    }
    paramInt1 = 0;
    while (paramInt1 < 3)
    {
      paramInt2 = 0;
      while (paramInt2 < 10)
      {
        int i2 = (int)(i1 / this.g[paramInt1]) / 10;
        this.r[paramInt1][paramInt2] = (i2 * (paramInt2 - 5));
        this.y[paramInt1][paramInt2] = 0;
        this.t[paramInt1][paramInt2] = 0;
        this.w[paramInt1][paramInt2] = 0;
        paramInt2 += 1;
      }
      paramInt1 += 1;
    }
  }
  
  private void d()
  {
    this.B = false;
    if (this.F)
    {
      startWeatherAnimaiton();
      this.F = false;
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    this.t[paramInt1][paramInt2] = 1;
    this.u[paramInt1][paramInt2] = -1L;
    this.w[paramInt1][paramInt2] = 0;
    invalidate();
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    this.t[paramInt1][paramInt2] = 0;
  }
  
  public void clearDrawable()
  {
    if (this.d != null)
    {
      this.d.clear();
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.clear();
      this.e = null;
    }
    if (this.f[0] != null)
    {
      this.f[0].clear();
      this.f[0] = null;
    }
    if (this.f[1] != null)
    {
      this.f[1].clear();
      this.f[1] = null;
    }
    if (this.f[2] != null)
    {
      this.f[2].clear();
      this.f[2] = null;
    }
    this.G = true;
  }
  
  public void dispatchDraw(GLCanvas paramGLCanvas)
  {
    if ((this.d == null) || (this.G)) {
      return;
    }
    b();
    int i1 = paramGLCanvas.getAlpha();
    paramGLCanvas.setAlpha((int)(i1 * this.D));
    if (this.A) {
      this.d.draw(paramGLCanvas);
    }
    a(paramGLCanvas);
    if ((this.e != null) && (this.A)) {
      this.e.draw(paramGLCanvas);
    }
    paramGLCanvas.setAlpha(i1);
  }
  
  public void forceAnimationStop() {}
  
  public void initDrawable()
  {
    this.G = true;
    j localj = new j(this);
    this.mScheduledExecutorService.submit(localj);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.h.set(0, 0, paramInt1, paramInt2);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
    {
      a(paramInt1, paramInt2);
      b(paramInt1, paramInt2);
    }
  }
  
  public boolean startForeAnimation(boolean paramBoolean)
  {
    return true;
  }
  
  public void startWeatherAnimaiton()
  {
    if (this.G) {
      return;
    }
    this.F = false;
    this.G = false;
    this.k = 0;
    if (!this.z)
    {
      a();
      a();
    }
    for (;;)
    {
      this.z = false;
      return;
      int i1 = 0;
      int i4 = 0;
      int i2 = 0;
      while (i1 < 3)
      {
        int i3 = 0;
        if (i3 < 10)
        {
          int i5 = i4;
          int i6 = i2;
          if (this.t[i1][i3] != 0)
          {
            this.u[i1][i3] = (((float)getDrawingTime() - this.s[i1][i3] / this.x[i1] * 3000.0F));
            if (this.w[i1][i3] == 0) {
              break label150;
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
            label150:
            i5 = i4 + 1;
            i6 = i2;
          }
        }
        if ((i2 > 2) && (i4 < 2))
        {
          a();
          a();
        }
        i1 += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/Snowy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */