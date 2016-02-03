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

public class NightWallView
  extends Wall
{
  public static float sWallB = 0.0F;
  private boolean A = false;
  private long B;
  private boolean C = true;
  private int D = 0;
  private int E = 0;
  private int F = 0;
  private float G = 0.0F;
  private float H = 0.0F;
  private int I = 0;
  private float[] J = { 0.75F, 0.8F, 0.85F };
  private boolean K = false;
  private long L = 0L;
  private long M = 5000L;
  private int[] N = new int[3];
  private int[] O = new int[3];
  private float[] P = { 0.2F, 0.25F, 0.5F, 1.0F };
  private float Q = 1.0F;
  private boolean R = false;
  private boolean S = false;
  private boolean T = false;
  private boolean U = false;
  private boolean V = false;
  private boolean W = false;
  private final float X = 1000.0F;
  private float Y = 1.0F;
  private long Z = 0L;
  private int a = 1000;
  private boolean aa = false;
  private boolean ab = true;
  private GLDrawable b;
  private GLDrawable c;
  private GLDrawable d;
  private GLDrawable e;
  private float[] f = new float[3];
  private float[] g = new float[3];
  private boolean h = false;
  private GLDrawable[] i = new GLDrawable[3];
  private final float j = 1.0F;
  private final float k = 1.0F;
  private final float l = 0.8F;
  private final float m = 0.7F;
  float[] mCenterPercent = { 0.6F, 0.5F };
  float[] mGetCenter = new float[3];
  float[] mGetSize = new float[2];
  float[] mSizePercent = { 0.6F, -1.0F };
  private final float n = 0.8F;
  private final float o = 0.5F;
  private float p = 0.6F;
  private final int q = 18;
  private float[] r = new float[18];
  private float[] s = new float[18];
  private boolean[] t = new boolean[18];
  private long[] u = new long[18];
  private int[] v = new int[18];
  private float[] w = new float[18];
  int weatherDeepth;
  private boolean[] x = new boolean[18];
  private int y = 15;
  private int z = 0;
  
  public NightWallView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a()
  {
    this.A = false;
  }
  
  private void a(float paramFloat)
  {
    float f1 = getInterpor(paramFloat);
    if (this.C)
    {
      this.E = ((int)(this.D * f1) + this.F);
      this.G = (this.I / 2 * f1);
    }
    for (this.H = (f1 * (this.I / 2));; this.H = ((1.0F - f1) * (this.I / 2)))
    {
      if (paramFloat == 1.0F) {
        a();
      }
      invalidate();
      return;
      this.E = ((int)((1.0F - f1) * this.D));
      this.G = (this.I / 2 * (1.0F - f1));
    }
  }
  
  private void a(int paramInt)
  {
    if (this.z >= this.y)
    {
      if ((!this.h) && (this.mWallHoder != null)) {
        this.mWallHoder.onPreviewAnimationEnd();
      }
      return;
    }
    this.t[paramInt] = false;
    this.z += 1;
    c(this.mContext);
    this.u[paramInt] = -1L;
    this.x[paramInt] = true;
    invalidate();
  }
  
  private void a(int paramInt, float paramFloat)
  {
    this.w[paramInt] = (4.0F * (paramFloat - 0.5F) * (paramFloat - 0.5F));
    if (paramFloat == 1.0F) {
      c(paramInt);
    }
    if ((paramFloat > 0.5D) && (this.t[paramInt] == 0)) {
      b(paramInt);
    }
    invalidate();
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
    int i1 = 0;
    while (i1 < 18)
    {
      this.v[i1] = 500;
      this.x[i1] = false;
      this.w[i1] = 1.0F;
      i1 += 1;
    }
  }
  
  private void a(GLCanvas paramGLCanvas)
  {
    if (this.L == -1L) {
      this.L = getDrawingTime();
    }
    long l1;
    long l2;
    if (this.K)
    {
      l1 = getDrawingTime();
      l2 = this.L;
      if (this.M == 0L) {
        break label139;
      }
    }
    label139:
    for (float f1 = (float)(l1 - l2) / (float)this.M;; f1 = 1.0F)
    {
      b(Math.max(0.0F, Math.min(f1, 1.0F)));
      int i1 = paramGLCanvas.getAlpha();
      paramGLCanvas.setAlpha((int)(this.Q * i1));
      int i2 = paramGLCanvas.save();
      paramGLCanvas.translate(this.O[0], 0.0F);
      if (this.i[0] != null) {
        this.i[0].draw(paramGLCanvas);
      }
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
    Object localObject2 = this.f;
    ((GLContentView)localObject1).getCameraWorldPosition((float[])localObject2);
    localObject2 = new Point(localObject2[0], localObject2[1], localObject2[2]);
    float[] arrayOfFloat = this.f;
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
  
  private boolean a(boolean paramBoolean)
  {
    if (this.A) {
      return false;
    }
    this.C = paramBoolean;
    this.F = this.E;
    this.B = -1L;
    this.A = true;
    invalidate();
    return true;
  }
  
  private void b()
  {
    this.K = false;
    if (this.mWallHoder != null) {
      this.mWallHoder.onPreviewAnimationEnd();
    }
  }
  
  private void b(float paramFloat)
  {
    if (paramFloat < this.P[0]) {
      this.Q = (1.0F - paramFloat / this.P[0]);
    }
    for (;;)
    {
      if (paramFloat == 1.0F) {
        b();
      }
      invalidate();
      return;
      if (!this.R)
      {
        int i1 = 0;
        while (i1 < 3)
        {
          this.O[i1] = this.N[i1];
          i1 += 1;
        }
        this.R = true;
      }
      this.Q = 1.0F;
      float f1;
      if (paramFloat >= this.P[0])
      {
        f1 = paramFloat / (1.0F - this.P[0]);
        f1 = InterpolatorFactory.getInterpolator(2, 5).getInterpolation(f1);
        this.O[0] = ((int)(this.N[0] - f1 * this.N[0]));
      }
      if (paramFloat >= this.P[1])
      {
        f1 = (paramFloat - this.P[1]) / (1.0F - this.P[1]);
        f1 = InterpolatorFactory.getInterpolator(2, 5).getInterpolation(f1);
        this.O[1] = ((int)(this.N[1] - f1 * this.N[1]));
      }
      if (paramFloat >= this.P[2])
      {
        f1 = (paramFloat - this.P[2]) / (1.0F - this.P[2]);
        f1 = InterpolatorFactory.getInterpolator(2, 5).getInterpolation(f1);
        this.O[2] = ((int)(this.N[2] - f1 * this.N[2]));
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.t[paramInt] = true;
    a(Math.min(17, Math.max(0, (int)(Math.random() * 18.0D))));
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    if (this.e != null)
    {
      a(this.e, this.mCenterPercent, this.mSizePercent, 0.8F, paramInt1, paramInt2, this.mGetCenter, this.mGetSize);
      this.T = true;
    }
  }
  
  private void b(Context paramContext)
  {
    this.i[0] = e.a().x(paramContext);
    this.i[1] = e.a().B(paramContext);
    this.i[2] = e.a().C(paramContext);
  }
  
  private void b(GLCanvas paramGLCanvas)
  {
    int i1 = 1;
    while (i1 < 3)
    {
      int i2 = paramGLCanvas.getAlpha();
      paramGLCanvas.setAlpha((int)(this.Q * i2));
      int i3 = paramGLCanvas.save();
      paramGLCanvas.translate(this.O[i1], 0.0F);
      if (this.i[i1] != null) {
        this.i[i1].draw(paramGLCanvas);
      }
      paramGLCanvas.setAlpha(i2);
      paramGLCanvas.restoreToCount(i3);
      i1 += 1;
    }
  }
  
  private float c(float paramFloat)
  {
    return -(float)Math.pow(2.0D, -paramFloat);
  }
  
  private void c()
  {
    this.z = 0;
    a(1);
  }
  
  private void c(int paramInt)
  {
    this.x[paramInt] = false;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (this.i[2] == null) {
      return;
    }
    if (this.h)
    {
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
          if (this.i[i1] == null) {
            break label186;
          }
          a(this.i[i1], this.mCenterPercent, this.mSizePercent, this.J[i1], paramInt1, paramInt2, null, null);
          if (i1 != 0) {
            break label188;
          }
          this.N[i1] = ((int)(this.mGetSize[0] + paramInt1 / 2 / this.J[i1]));
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
          this.N[i1] = ((int)-(this.mGetSize[0] + paramInt1 / 2 / this.J[i1]));
        }
      }
    }
    this.U = true;
  }
  
  private void c(Context paramContext)
  {
    this.b = e.a().l(paramContext);
    this.c = e.a().m(paramContext);
    this.d = e.a().n(paramContext);
  }
  
  private void c(GLCanvas paramGLCanvas)
  {
    int i1 = 0;
    if (i1 < 18)
    {
      int i2 = paramGLCanvas.save();
      paramGLCanvas.translate(this.r[i1], this.s[i1], 0.0F);
      if (this.u[i1] == -1L) {
        this.u[i1] = getDrawingTime();
      }
      if (this.x[i1] != 0) {
        a(i1, Math.min(1.0F, Math.max(0.0F, (float)(getDrawingTime() - this.u[i1]) / this.v[i1])));
      }
      int i3 = paramGLCanvas.getAlpha();
      paramGLCanvas.setAlpha((int)(i3 * this.w[i1]));
      if (i1 < 6) {
        if (this.c != null) {
          this.c.draw(paramGLCanvas);
        }
      }
      for (;;)
      {
        paramGLCanvas.setAlpha(i3);
        paramGLCanvas.restoreToCount(i2);
        i1 += 1;
        break;
        if (i1 < 12)
        {
          if (this.b != null) {
            this.b.draw(paramGLCanvas);
          }
        }
        else if (this.d != null) {
          this.d.draw(paramGLCanvas);
        }
      }
    }
  }
  
  private void d()
  {
    if (this.Z == -1L) {
      this.Z = getDrawingTime();
    }
    if (this.W) {
      d(Math.max(0.0F, Math.min(1.0F, (float)(getDrawingTime() - this.Z) / 1000.0F)));
    }
  }
  
  private void d(float paramFloat)
  {
    this.Y = paramFloat;
    if (paramFloat == 1.0F) {
      f();
    }
    invalidate();
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if ((this.b == null) || (this.c == null) || (this.d == null)) {}
    do
    {
      return;
      localObject = getGLRootView();
    } while (localObject == null);
    this.D = ((int)this.mGetCenter[2]);
    this.weatherDeepth = ((int)this.mGetCenter[2]);
    this.I = ((int)this.mGetSize[0]);
    float f5 = this.mGetCenter[0] - this.mGetSize[0] / 2.0F;
    float f6 = this.mGetSize[0];
    float f2 = this.mGetCenter[1] + this.mGetSize[1] / 2.0F;
    float f3 = this.mGetSize[1];
    float f1 = this.b.getIntrinsicWidth() / 0.8F;
    float f4 = this.b.getIntrinsicHeight() / 0.8F;
    f5 = (f5 + (f6 + f5)) / 2.0F;
    f6 = (f2 + (f2 - f3)) / 2.0F;
    f2 = (int)(f5 - f1 / 2.0F);
    f3 = (int)(f2 + f1);
    f5 = (int)(f4 / 2.0F + f6);
    f4 = (int)(f5 - f4);
    f6 = this.weatherDeepth;
    float f7 = this.weatherDeepth;
    float f8 = this.weatherDeepth;
    this.b.setBounds3D(new float[] { f2, f5, f6, f2, f4, f7, f3, f5, f8 }, 0, 3, 6, false, false);
    f6 = ((GLContentView)localObject).getDepthForProjectScale(0.7F);
    this.c.setBounds3D(new float[] { f2, f5, f6, f2, f4, f6, f3, f5, f6 }, 0, 3, 6, false, false);
    f6 = ((GLContentView)localObject).getDepthForProjectScale(0.8F);
    this.d.setBounds3D(new float[] { f2, f5, f6, f2, f4, f6, f3, f5, f6 }, 0, 3, 6, false, false);
    f2 = this.mGetSize[1] / 2.0F;
    Object localObject = new double[18];
    Object tmp455_453 = localObject;
    tmp455_453[0] = 0.19634954084936207D;
    Object tmp461_455 = tmp455_453;
    tmp461_455[1] = 1.1780972450961724D;
    Object tmp467_461 = tmp461_455;
    tmp467_461[2] = 2.356194490192345D;
    Object tmp473_467 = tmp467_461;
    tmp473_467[3] = 2.748893571891069D;
    Object tmp479_473 = tmp473_467;
    tmp479_473[4] = 3.5342917352885173D;
    Object tmp485_479 = tmp479_473;
    tmp485_479[5] = 5.497787143782138D;
    Object tmp491_485 = tmp485_479;
    tmp491_485[6] = 0.39269908169872414D;
    Object tmp498_491 = tmp491_485;
    tmp498_491[7] = 0.7853981633974483D;
    Object tmp505_498 = tmp498_491;
    tmp505_498[8] = 1.5707963267948966D;
    Object tmp512_505 = tmp505_498;
    tmp512_505[9] = 3.9269908169872414D;
    Object tmp519_512 = tmp512_505;
    tmp519_512[10] = 4.71238898038469D;
    Object tmp526_519 = tmp519_512;
    tmp526_519[11] = 5.105088062083414D;
    Object tmp533_526 = tmp526_519;
    tmp533_526[12] = 0.19634954084936207D;
    Object tmp540_533 = tmp533_526;
    tmp540_533[13] = 1.1780972450961724D;
    Object tmp547_540 = tmp540_533;
    tmp547_540[14] = 2.356194490192345D;
    Object tmp554_547 = tmp547_540;
    tmp554_547[15] = 2.748893571891069D;
    Object tmp561_554 = tmp554_547;
    tmp561_554[16] = 3.5342917352885173D;
    Object tmp568_561 = tmp561_554;
    tmp568_561[17] = 5.497787143782138D;
    tmp568_561;
    f1 /= 2.0F;
    float[] arrayOfFloat = new float[18];
    arrayOfFloat[0] = f2;
    arrayOfFloat[1] = (f2 + f1);
    arrayOfFloat[2] = (f2 + f1);
    arrayOfFloat[3] = (f2 + f1);
    arrayOfFloat[4] = f2;
    arrayOfFloat[5] = (f2 + f1);
    arrayOfFloat[6] = (2.0F * f1 + f2);
    arrayOfFloat[7] = (f1 / 2.0F + f2);
    arrayOfFloat[8] = (f2 + f1);
    arrayOfFloat[9] = (f2 + f1);
    arrayOfFloat[10] = (f1 / 2.0F + f2);
    arrayOfFloat[11] = (f2 + f1);
    arrayOfFloat[12] = f2;
    arrayOfFloat[13] = (f2 + f1);
    arrayOfFloat[14] = (f2 + f1);
    arrayOfFloat[15] = (f2 + f1);
    arrayOfFloat[16] = f2;
    arrayOfFloat[17] = (f2 + f1);
    paramInt1 = 0;
    while (paramInt1 < 18)
    {
      this.r[paramInt1] = ((float)(arrayOfFloat[paramInt1] * Math.sin(localObject[paramInt1])));
      this.s[paramInt1] = ((float)(arrayOfFloat[paramInt1] * Math.cos(localObject[paramInt1])));
      paramInt1 += 1;
    }
    this.V = true;
  }
  
  private void e()
  {
    this.W = true;
    this.Z = -1L;
    invalidate();
  }
  
  private void f()
  {
    this.W = false;
    if (this.aa)
    {
      startWeatherAnimaiton();
      this.aa = false;
    }
  }
  
  public void clearDrawable()
  {
    if (this.e != null)
    {
      this.e.clear();
      this.e = null;
    }
    if (this.b != null) {
      this.b.clear();
    }
    if (this.c != null) {
      this.c.clear();
    }
    if (this.d != null) {
      this.d.clear();
    }
    int i1 = 0;
    while (i1 < 3)
    {
      if (this.i[i1] != null) {
        this.i[i1].clear();
      }
      i1 += 1;
    }
    this.ab = true;
  }
  
  public void dispatchDraw(GLCanvas paramGLCanvas)
  {
    if ((this.e == null) || (this.ab)) {
      return;
    }
    d();
    int i1 = paramGLCanvas.getAlpha();
    paramGLCanvas.setAlpha((int)(i1 * this.Y));
    if (this.B == -1L) {
      this.B = getDrawingTime();
    }
    long l1 = getDrawingTime();
    long l2 = this.B;
    if (this.a != 0) {}
    for (float f1 = (float)(l1 - l2) / this.a;; f1 = 1.0F)
    {
      f1 = Math.max(0.0F, Math.min(f1, 1.0F));
      if (this.A) {
        a(f1);
      }
      paramGLCanvas.translate(this.G, this.H, this.E);
      if ((this.h) && (this.U)) {
        a(paramGLCanvas);
      }
      if (this.T) {
        this.e.draw(paramGLCanvas);
      }
      c(paramGLCanvas);
      if ((this.h) && (this.U)) {
        b(paramGLCanvas);
      }
      paramGLCanvas.setAlpha(i1);
      return;
    }
  }
  
  public void forceAnimationStop()
  {
    if (this.K) {
      b(1.0F);
    }
  }
  
  public float getInterpor(float paramFloat)
  {
    paramFloat = c(10 * paramFloat + -2);
    float f1 = c(8);
    float f2 = c(-2);
    return (paramFloat - f2) / (f1 - f2);
  }
  
  public void initDrawable()
  {
    if (this.e == null) {
      this.ab = true;
    }
    if ((this.h) && (this.i[0] == null)) {
      this.ab = true;
    }
    f localf = new f(this);
    this.mScheduledExecutorService.submit(localf);
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
      this.U = false;
      this.V = false;
      this.T = false;
    }
    if (!this.T) {
      b(paramInt1, paramInt2);
    }
    if ((this.h) && (!this.U)) {
      c(paramInt1, paramInt2);
    }
    if (!this.V) {
      d(paramInt1, paramInt2);
    }
  }
  
  public void setDrawingCacheEnabled(boolean paramBoolean)
  {
    super.setDrawingCacheEnabled(paramBoolean);
  }
  
  public void setHasCloud(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void startCloudAnimation()
  {
    if (this.K) {
      return;
    }
    this.K = true;
    this.L = -1L;
    this.R = false;
    invalidate();
  }
  
  public boolean startForeAnimation(boolean paramBoolean)
  {
    return a(paramBoolean);
  }
  
  public void startWeatherAnimaiton()
  {
    if ((this.ab) || (this.W)) {
      this.aa = true;
    }
    do
    {
      return;
      this.aa = false;
      c();
    } while (!this.h);
    startCloudAnimation();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/NightWallView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */