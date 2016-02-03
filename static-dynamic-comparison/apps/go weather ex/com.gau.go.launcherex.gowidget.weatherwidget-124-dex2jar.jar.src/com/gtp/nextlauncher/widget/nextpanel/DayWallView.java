package com.gtp.nextlauncher.widget.nextpanel;

import android.content.Context;
import android.view.animation.Interpolator;
import com.go.gl.animation.InterpolatorFactory;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.math3d.Plane;
import com.go.gl.math3d.Point;
import com.go.gl.math3d.Ray;
import com.go.gl.math3d.Vector;
import com.go.gl.view.GLContentView;
import java.util.concurrent.ExecutorService;

public class DayWallView
  extends Wall
{
  private float A = 0.0F;
  private float B = 0.0F;
  private float C = 0.0F;
  private float D = 0.0F;
  private float E = 0.0F;
  private float F = 0.0F;
  private float G = 0.0F;
  private float H = 0.0F;
  private float I = 0.0F;
  private float J = 0.0F;
  private float K = 0.0F;
  private float[] L = { 0.75F, 0.8F, 0.85F };
  private boolean M = false;
  private float N = 1.0F;
  private boolean O = false;
  private boolean P = false;
  private long Q = 0L;
  private long R = 2000L;
  private float S = 0.0F;
  private float T = 0.0F;
  private float U = 0.0F;
  private float V = 0.0F;
  private float W = 0.0F;
  private float X = 1.0F;
  private float[] Y = new float[3];
  private float Z = 0.0F;
  private final int a = 3;
  private float aa = 180.0F;
  private boolean ab = false;
  private long ac = 0L;
  private long ad = 5000L;
  private int[] ae = new int[3];
  private int[] af = new int[3];
  private final float ag = 2.0F;
  private final float ah = 1.0F;
  private boolean ai = false;
  private boolean aj = false;
  private boolean ak = false;
  private boolean al = false;
  private boolean am = true;
  private boolean an = false;
  private final float ao = 1000.0F;
  private float ap = 1.0F;
  private long aq = 0L;
  private final int b = 1000;
  private GLDrawable c;
  private GLDrawable d;
  private GLDrawable e;
  private GLDrawable f;
  private GLDrawable g;
  private GLDrawable[] h = new GLDrawable[3];
  private boolean i = false;
  private long j;
  private boolean k = true;
  private int l = 0;
  private int m = 0;
  float[] mCenterPercent = { 0.5F, 0.5F };
  float[] mCloudStartTimeP = { 0.2F, 0.25F, 0.5F, 1.0F };
  float[] mGetCenter = new float[3];
  float[] mGetSize = new float[2];
  float mLight2Width = 0.0F;
  float mLight3Width = 0.0F;
  float mLight4Width = 0.0F;
  float[] mSizePercent = { 0.6F, -1.0F };
  private int n = 0;
  private float o = 0.0F;
  private float p = 0.0F;
  private int q = 0;
  private float[] r = new float[3];
  private float[] s = new float[3];
  private final float t = 1.0F;
  private final float u = 1.0F;
  private final float v = 0.8F;
  private final float w = 0.5F;
  int weatherDeepth;
  private float x = 0.5F;
  private float y = 0.0F;
  private float z = 0.0F;
  
  public DayWallView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a()
  {
    this.i = false;
  }
  
  private void a(float paramFloat)
  {
    float f1 = getInterpor(paramFloat);
    if (this.k)
    {
      this.m = ((int)(this.l * f1) + this.n);
      this.o = (this.q / 2 * f1);
    }
    for (this.p = (f1 * (this.q / 2));; this.p = ((1.0F - f1) * (this.q / 2)))
    {
      if (paramFloat == 1.0F) {
        a();
      }
      invalidate();
      return;
      this.m = ((int)((1.0F - f1) * this.l));
      this.o = (this.q / 2 * (1.0F - f1));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.mCenterPercent[0] = 0.5F;
    this.mCenterPercent[1] = 0.5F;
    this.mSizePercent[0] = 0.6F;
    this.mSizePercent[1] = -1.0F;
    if (paramInt1 > paramInt2)
    {
      this.mSizePercent[0] = -1.0F;
      this.mSizePercent[1] = 0.6F;
      this.mCenterPercent[1] = 0.5F;
      this.mCenterPercent[0] = 0.6F;
    }
  }
  
  private void a(Context paramContext)
  {
    this.mContext = paramContext;
    setBackgroundColor(16777215);
  }
  
  private void a(GLCanvas paramGLCanvas)
  {
    if (this.h[0] == null) {
      return;
    }
    if (this.ac == -1L) {
      this.ac = getDrawingTime();
    }
    long l1;
    long l2;
    if (this.ab)
    {
      l1 = getDrawingTime();
      l2 = this.ac;
      if (this.ad == 0L) {
        break label140;
      }
    }
    label140:
    for (float f1 = (float)(l1 - l2) / (float)this.ad;; f1 = 1.0F)
    {
      f(Math.max(0.0F, Math.min(f1, 1.0F)));
      int i1 = paramGLCanvas.getAlpha();
      paramGLCanvas.setAlpha((int)(this.N * i1));
      int i2 = paramGLCanvas.save();
      paramGLCanvas.translate(this.af[0], 0.0F);
      this.h[0].draw(paramGLCanvas);
      paramGLCanvas.setAlpha(i1);
      paramGLCanvas.restoreToCount(i2);
      return;
    }
  }
  
  private void a(GLDrawable paramGLDrawable, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat, int paramInt1, int paramInt2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    if (paramGLDrawable == null) {}
    do
    {
      return;
      localObject1 = getGLRootView();
    } while (localObject1 == null);
    Object localObject2 = this.r;
    ((GLContentView)localObject1).getCameraWorldPosition((float[])localObject2);
    localObject2 = new Point(localObject2[0], localObject2[1], localObject2[2]);
    float[] arrayOfFloat = this.r;
    paramArrayOfFloat1[0] *= paramInt1;
    arrayOfFloat[1] = (-paramArrayOfFloat1[1] * paramInt2);
    arrayOfFloat[2] = 0.0F;
    paramArrayOfFloat1 = new Ray((Point)localObject2, new Point(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]));
    Object localObject1 = new Plane(new Point(0.0F, 0.0F, ((GLContentView)localObject1).getDepthForProjectScale(paramFloat)), new Vector(0.0F, 0.0F, 1.0F));
    paramArrayOfFloat1.startCast();
    ((Plane)localObject1).intersect(paramArrayOfFloat1);
    paramArrayOfFloat1 = paramArrayOfFloat1.getHitPoint();
    if (paramArrayOfFloat3 != null)
    {
      paramArrayOfFloat3[0] = paramArrayOfFloat1.x;
      paramArrayOfFloat3[1] = paramArrayOfFloat1.y;
      paramArrayOfFloat3[2] = paramArrayOfFloat1.z;
    }
    float f1;
    if (paramArrayOfFloat2[0] == -1.0F)
    {
      paramFloat = paramArrayOfFloat2[1] * paramInt2 / paramFloat;
      f1 = paramFloat / paramGLDrawable.getIntrinsicHeight() * paramGLDrawable.getIntrinsicWidth();
    }
    for (;;)
    {
      if (paramArrayOfFloat4 != null)
      {
        paramArrayOfFloat4[0] = f1;
        paramArrayOfFloat4[1] = paramFloat;
      }
      float f2 = paramArrayOfFloat1.x - f1 / 2.0F;
      float f3 = paramArrayOfFloat1.y;
      f3 = paramFloat / 2.0F + f3;
      float f4 = paramArrayOfFloat1.z;
      paramGLDrawable.setBounds3D(new float[] { f2, f3, f4, f2, f3 - paramFloat, f4, f2 + f1, f3, f4 }, 0, 3, 6, false, false);
      return;
      f1 = paramArrayOfFloat2[0] * paramInt1 / paramFloat;
      paramFloat = f1 / paramGLDrawable.getIntrinsicWidth() * paramGLDrawable.getIntrinsicHeight();
    }
  }
  
  private void b()
  {
    this.P = false;
    if ((!this.M) && (this.mWallHoder != null)) {
      this.mWallHoder.onPreviewAnimationEnd();
    }
  }
  
  private void b(float paramFloat)
  {
    if (this.e == null) {
      return;
    }
    float f1 = this.mLight2Width * paramFloat;
    paramFloat = this.C * paramFloat;
    float f2 = this.D - f1 / 2.0F;
    float f3 = this.E + paramFloat / 2.0F;
    float f4 = this.weatherDeepth;
    float f5 = this.weatherDeepth;
    float f6 = this.weatherDeepth;
    this.e.setBounds3D(new float[] { f2, f3, f4, f2, f3 - paramFloat, f5, f1 + f2, f3, f6 }, 0, 3, 6, false, false);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    if (this.c != null)
    {
      a(this.c, this.mCenterPercent, this.mSizePercent, 0.8F, paramInt1, paramInt2, this.mGetCenter, this.mGetSize);
      this.aj = true;
    }
  }
  
  private void b(GLCanvas paramGLCanvas)
  {
    if (this.h[2] == null) {}
    for (;;)
    {
      return;
      int i1 = 1;
      while (i1 < 3)
      {
        int i2 = paramGLCanvas.getAlpha();
        paramGLCanvas.setAlpha((int)(this.N * i2));
        int i3 = paramGLCanvas.save();
        paramGLCanvas.translate(this.af[i1], 0.0F);
        if (this.h[i1] != null) {
          this.h[i1].draw(paramGLCanvas);
        }
        paramGLCanvas.setAlpha(i2);
        paramGLCanvas.restoreToCount(i3);
        i1 += 1;
      }
    }
  }
  
  private void c()
  {
    this.ab = false;
    if (this.mWallHoder != null) {
      this.mWallHoder.onPreviewAnimationEnd();
    }
  }
  
  private void c(float paramFloat)
  {
    if (this.f == null) {
      return;
    }
    float f1 = this.mLight3Width * paramFloat;
    paramFloat = this.F * paramFloat;
    float f2 = this.G - f1 / 2.0F;
    float f3 = this.H + paramFloat / 2.0F;
    float f4 = this.weatherDeepth;
    float f5 = this.weatherDeepth;
    float f6 = this.weatherDeepth;
    this.f.setBounds3D(new float[] { f2, f3, f4, f2, f3 - paramFloat, f5, f1 + f2, f3, f6 }, 0, 3, 6, false, false);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if ((this.g == null) || (this.d == null) || (this.e == null) || (this.f == null)) {
      return;
    }
    this.l = ((int)this.mGetCenter[2]);
    this.weatherDeepth = ((int)this.mGetCenter[2]);
    this.q = ((int)this.mGetSize[0]);
    float f4 = this.mGetCenter[0];
    float f5 = this.mGetCenter[1];
    float f2 = this.mGetSize[1] / 2.0F;
    float f1 = f4 - this.mGetSize[0] / 2.0F;
    paramInt2 = (int)this.mGetSize[0];
    int i1 = (int)this.mGetSize[1];
    f2 = f2 + f5 - i1 / 8;
    float f3 = f1 - paramInt2 / 2;
    float f6 = paramInt2;
    float f7 = f2 + i1 / 2;
    float f8 = i1;
    float f9 = this.weatherDeepth;
    float f10 = this.weatherDeepth;
    float f11 = this.weatherDeepth;
    if (this.d != null) {
      this.d.setBounds3D(new float[] { f3, f7, f9, f3, f7 - f8, f10, f3 + f6, f7, f11 }, 0, 3, 6, false, false);
    }
    this.Y[2] = this.weatherDeepth;
    this.Y[1] = f2;
    this.Y[0] = f1;
    f2 = this.mGetCenter[0] + this.mGetSize[0] / 2.0F;
    f6 = this.mGetCenter[1];
    f7 = this.mGetSize[1] / 2.0F;
    if (this.e != null)
    {
      f1 = this.mGetSize[0] / 10.0F;
      f3 = f1 / this.e.getIntrinsicWidth() * this.e.getIntrinsicHeight();
    }
    for (;;)
    {
      this.D = f2;
      this.E = (f3 / 2.0F + (f6 - f7));
      f6 = this.E;
      this.mLight2Width = f1;
      this.C = f3;
      f2 -= f1 / 2.0F;
      f7 = f6 + f3 / 2.0F;
      f8 = this.weatherDeepth;
      f9 = this.weatherDeepth;
      f10 = this.weatherDeepth;
      if (this.e != null) {
        this.e.setBounds3D(new float[] { f2, f7, f8, f2, f7 - f3, f9, f1 + f2, f7, f10 }, 0, 3, 6, false, false);
      }
      this.z = (-this.mGetSize[0] - paramInt1 * (1.0F - this.x) / 2.0F / 0.8F);
      this.y = (-this.z / 2.0F);
      f6 -= f3 / 2.0F;
      this.H = f6;
      if (this.f != null)
      {
        f1 = 2.0F * this.mLight2Width;
        f2 = f1 / this.f.getIntrinsicWidth() * this.f.getIntrinsicHeight();
      }
      for (;;)
      {
        this.mLight3Width = f1;
        this.F = f2;
        f7 = this.D + this.mLight2Width / 2.0F;
        this.G = f7;
        f7 += f1 / 2.0F;
        f6 += f2 / 2.0F;
        f8 = this.weatherDeepth;
        f9 = this.weatherDeepth;
        f10 = this.weatherDeepth;
        if (this.f != null) {
          this.f.setBounds3D(new float[] { f7, f6, f8, f7, f6 - f2, f9, f7 + f1, f6, f10 }, 0, 3, 6, false, false);
        }
        this.A = (-(this.mGetSize[1] + f3) - paramInt1 * (1.0F - this.x) / 2.0F / 0.8F);
        f5 -= (this.mGetSize[1] + f3 + f2) / 2.0F;
        f4 = (this.mGetSize[1] + f3 + f2) / 2.0F + f4;
        this.K = f5;
        this.J = f4;
        if (this.g != null)
        {
          f1 = this.mLight3Width * 2.0F;
          f2 = f1 / this.g.getIntrinsicWidth();
          f2 = this.g.getIntrinsicHeight() * f2;
        }
        this.mLight4Width = f1;
        this.I = f2;
        f4 = f1 / 2.0F + f4;
        f5 += f2 / 2.0F;
        f6 = this.weatherDeepth;
        f7 = this.weatherDeepth;
        f8 = this.weatherDeepth;
        if (this.g != null) {
          this.g.setBounds3D(new float[] { f4, f5, f6, f4, f5 - f2, f7, f4 + f1, f5, f8 }, 0, 3, 6, false, false);
        }
        this.B = (-(this.mGetSize[1] + f3 + f2) - paramInt1 * (1.0F - this.x) / 2.0F / 0.8F);
        this.ak = true;
        return;
        f2 = 0.0F;
        f1 = 0.0F;
      }
      f3 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  private void d()
  {
    if (this.aq == -1L) {
      this.aq = getDrawingTime();
    }
    if (this.an) {
      g(Math.max(0.0F, Math.min(1.0F, (float)(getDrawingTime() - this.aq) / 1000.0F)));
    }
  }
  
  private void d(float paramFloat)
  {
    if (this.g == null) {
      return;
    }
    float f1 = this.mLight4Width * paramFloat;
    paramFloat = this.I * paramFloat;
    float f2 = this.J - f1 / 2.0F;
    float f3 = this.K + paramFloat / 2.0F;
    float f4 = this.weatherDeepth;
    float f5 = this.weatherDeepth;
    float f6 = this.weatherDeepth;
    this.g.setBounds3D(new float[] { f2, f3, f4, f2, f3 - paramFloat, f5, f1 + f2, f3, f6 }, 0, 3, 6, false, false);
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (this.M)
    {
      if (this.h[2] == null) {
        return;
      }
      this.mSizePercent[1] = -1.0F;
      float[] arrayOfFloat = new float[3];
      float[] tmp32_30 = arrayOfFloat;
      tmp32_30[0] = 1.5F;
      float[] tmp38_32 = tmp32_30;
      tmp38_32[1] = 0.8F;
      float[] tmp43_38 = tmp38_32;
      tmp43_38[2] = 1.0F;
      tmp43_38;
      if (paramInt2 < paramInt1)
      {
        this.mSizePercent[0] = -1.0F;
        arrayOfFloat[0] = 0.8F;
        arrayOfFloat[1] = 0.4F;
        arrayOfFloat[2] = 0.6F;
      }
      int i1 = 0;
      label82:
      if (i1 < 3)
      {
        if (paramInt1 < paramInt2)
        {
          this.mSizePercent[0] = arrayOfFloat[i1];
          label102:
          if (this.h[i1] == null) {
            break label186;
          }
          a(this.h[i1], this.mCenterPercent, this.mSizePercent, this.L[i1], paramInt1, paramInt2, null, null);
          if (i1 != 0) {
            break label188;
          }
          this.ae[i1] = ((int)(this.mGetSize[0] + paramInt1 / 2 / this.L[i1]));
        }
        for (;;)
        {
          i1 += 1;
          break label82;
          this.mSizePercent[1] = arrayOfFloat[i1];
          break label102;
          label186:
          break;
          label188:
          this.ae[i1] = ((int)-(this.mGetSize[0] + paramInt1 / 2 / this.L[i1]));
        }
      }
    }
    this.al = true;
  }
  
  private void e()
  {
    this.an = true;
    this.aq = -1L;
    invalidate();
  }
  
  private void e(float paramFloat)
  {
    this.S = (this.y * paramFloat);
    this.T = (this.z * paramFloat);
    this.U = (this.A * paramFloat);
    this.V = (this.B * paramFloat);
    if (paramFloat < 0.5F) {}
    for (this.W = (paramFloat / 0.5F);; this.W = (1.0F - (paramFloat - 0.5F) / 0.5F))
    {
      this.X = (4.0F * (paramFloat - 0.5F) * (paramFloat - 0.5F) + 1.0F);
      b(this.X);
      c(this.X);
      d(this.X);
      this.Z = (this.aa * paramFloat);
      if (paramFloat == 1.0F) {
        b();
      }
      invalidate();
      return;
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    if (!this.aj) {
      b(paramInt1, paramInt2);
    }
    if ((this.M) && (!this.al)) {
      d(paramInt1, paramInt2);
    }
    if (!this.ak) {
      c(paramInt1, paramInt2);
    }
  }
  
  private void f()
  {
    this.an = false;
    if (this.ai)
    {
      startWeatherAnimaiton();
      this.ai = false;
    }
  }
  
  private void f(float paramFloat)
  {
    if (paramFloat < this.mCloudStartTimeP[0]) {
      this.N = (1.0F - paramFloat / this.mCloudStartTimeP[0]);
    }
    for (;;)
    {
      if (paramFloat == 1.0F) {
        c();
      }
      invalidate();
      return;
      if (!this.O)
      {
        int i1 = 0;
        while (i1 < 3)
        {
          this.af[i1] = this.ae[i1];
          i1 += 1;
        }
        this.O = true;
      }
      this.N = 1.0F;
      float f1;
      if (paramFloat >= this.mCloudStartTimeP[0])
      {
        f1 = paramFloat / (1.0F - this.mCloudStartTimeP[0]);
        f1 = InterpolatorFactory.getInterpolator(2, 5).getInterpolation(f1);
        this.af[0] = ((int)(this.ae[0] - f1 * this.ae[0]));
      }
      if (paramFloat >= this.mCloudStartTimeP[1])
      {
        f1 = (paramFloat - this.mCloudStartTimeP[1]) / (1.0F - this.mCloudStartTimeP[1]);
        f1 = InterpolatorFactory.getInterpolator(2, 5).getInterpolation(f1);
        this.af[1] = ((int)(this.ae[1] - f1 * this.ae[1]));
      }
      if (paramFloat >= this.mCloudStartTimeP[2])
      {
        f1 = (paramFloat - this.mCloudStartTimeP[2]) / (1.0F - this.mCloudStartTimeP[2]);
        f1 = InterpolatorFactory.getInterpolator(2, 5).getInterpolation(f1);
        this.af[2] = ((int)(this.ae[2] - f1 * this.ae[2]));
      }
    }
  }
  
  private void g(float paramFloat)
  {
    this.ap = paramFloat;
    if (paramFloat == 1.0F) {
      f();
    }
    invalidate();
  }
  
  private float h(float paramFloat)
  {
    return -(float)Math.pow(2.0D, -paramFloat);
  }
  
  public void clearDrawable()
  {
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
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
    if (this.f != null)
    {
      this.f.clear();
      this.f = null;
    }
    if (this.g != null)
    {
      this.g.clear();
      this.g = null;
    }
    if (this.h != null)
    {
      int i1 = 0;
      while (i1 < this.h.length)
      {
        if (this.h[i1] != null) {
          this.h[i1].clear();
        }
        i1 += 1;
      }
    }
    this.am = true;
  }
  
  public void dispatchDraw(GLCanvas paramGLCanvas)
  {
    if (this.am) {
      return;
    }
    d();
    int i1 = paramGLCanvas.getAlpha();
    paramGLCanvas.setAlpha((int)(i1 * this.ap));
    if (this.j == -1L) {
      this.j = getDrawingTime();
    }
    float f1 = Math.max(0.0F, Math.min((float)(getDrawingTime() - this.j) / 1000.0F, 1.0F));
    if (this.i) {
      a(f1);
    }
    if (this.Q == -1L) {
      this.Q = getDrawingTime();
    }
    long l1;
    long l2;
    if (this.P)
    {
      l1 = getDrawingTime();
      l2 = this.Q;
      if (this.R == 0L) {
        break label474;
      }
    }
    label474:
    for (f1 = (float)(l1 - l2) / (float)this.R;; f1 = 1.0F)
    {
      e(Math.max(0.0F, Math.min(f1, 1.0F)));
      paramGLCanvas.translate(this.o, this.p, this.m);
      if ((this.M) && (this.al)) {
        a(paramGLCanvas);
      }
      if ((this.c != null) && (this.aj)) {
        this.c.draw(paramGLCanvas);
      }
      if (this.P)
      {
        int i3 = paramGLCanvas.save();
        int i2 = paramGLCanvas.getAlpha();
        paramGLCanvas.setAlpha((int)(i2 * this.W));
        paramGLCanvas.translate(this.S, 0.0F);
        paramGLCanvas.translate(this.Y[0], this.Y[1], this.Y[2]);
        paramGLCanvas.rotateAxisAngle(-this.Z, 0.0F, 0.0F, 1.0F);
        paramGLCanvas.translate(-this.Y[0], -this.Y[1], -this.Y[2]);
        if (this.d != null) {
          this.d.draw(paramGLCanvas);
        }
        paramGLCanvas.restoreToCount(i3);
        i3 = paramGLCanvas.save();
        paramGLCanvas.translate(this.T, 0.0F, 0.0F);
        if (this.e != null) {
          this.e.draw(paramGLCanvas);
        }
        paramGLCanvas.translate(-this.T, 0.0F, 0.0F);
        paramGLCanvas.translate(this.U, 0.0F, 0.0F);
        if (this.f != null) {
          this.f.draw(paramGLCanvas);
        }
        paramGLCanvas.translate(-this.U, 0.0F, 0.0F);
        paramGLCanvas.translate(this.V, 0.0F, 0.0F);
        if (this.g != null) {
          this.g.draw(paramGLCanvas);
        }
        paramGLCanvas.restoreToCount(i3);
        paramGLCanvas.setAlpha(i2);
      }
      if ((this.M) && (this.al)) {
        b(paramGLCanvas);
      }
      paramGLCanvas.setAlpha(i1);
      return;
    }
  }
  
  public void forceAnimationStop()
  {
    if (this.ab) {
      f(1.0F);
    }
    if (this.P) {
      e(1.0F);
    }
  }
  
  public float getInterpor(float paramFloat)
  {
    paramFloat = h(10 * paramFloat + -2);
    float f1 = h(8);
    float f2 = h(-2);
    return (paramFloat - f2) / (f1 - f2);
  }
  
  public void initDrawable()
  {
    this.am = true;
    c localc = new c(this);
    this.mScheduledExecutorService.submit(localc);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
    {
      this.al = false;
      this.ak = false;
      this.aj = false;
    }
    e(paramInt1, paramInt2);
  }
  
  public void setHasCloud(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }
  
  public void startCloudAnimation()
  {
    if (this.ab) {
      return;
    }
    this.ab = true;
    this.ac = -1L;
    this.O = false;
    invalidate();
  }
  
  public boolean startForeAnimation(boolean paramBoolean)
  {
    if (this.i) {
      return false;
    }
    this.k = paramBoolean;
    this.n = this.m;
    this.j = -1L;
    this.i = true;
    invalidate();
    return true;
  }
  
  public void startLightAnimation()
  {
    if (this.P) {
      return;
    }
    this.S = 0.0F;
    this.T = 0.0F;
    this.U = 0.0F;
    this.V = 0.0F;
    this.W = 0.0F;
    this.P = true;
    this.Q = -1L;
    invalidate();
  }
  
  public void startWeatherAnimaiton()
  {
    if (this.am)
    {
      this.ai = true;
      return;
    }
    if ((!this.ak) || (!this.aj) || ((this.M) && (!this.al)))
    {
      this.ai = true;
      return;
    }
    if (this.M) {
      startCloudAnimation();
    }
    startLightAnimation();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/DayWallView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */