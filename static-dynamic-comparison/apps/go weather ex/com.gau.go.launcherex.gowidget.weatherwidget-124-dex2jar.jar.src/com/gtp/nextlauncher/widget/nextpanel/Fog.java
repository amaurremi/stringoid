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

public class Fog
  extends Wall
{
  private final int a = 3;
  private final float[] b = { 0.5F, 0.55F, 0.66F };
  private GLDrawable[] c = new GLDrawable[3];
  private boolean d = false;
  private boolean e = true;
  private long f = 0L;
  private long g = 5000L;
  private int[] h = new int[3];
  private int[] i = new int[3];
  private float[] j = { 0.2F, 0.4F, 0.5F, 1.0F };
  private float[] k = new float[3];
  private boolean l = false;
  private boolean m = false;
  private float[] n = new float[3];
  private boolean o = false;
  private final float p = 1000.0F;
  private float q = 1.0F;
  private long r = 0L;
  private boolean s = false;
  private boolean t = true;
  
  public Fog(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a()
  {
    this.e = false;
    if (this.mWallHoder != null) {
      this.mWallHoder.onPreviewAnimationEnd();
    }
  }
  
  private void a(float paramFloat)
  {
    int i2 = 0;
    int i1 = 0;
    float f1;
    if (paramFloat < this.j[0])
    {
      f1 = paramFloat / this.j[0];
      while (i1 < 3)
      {
        this.k[i1] = (1.0F - f1);
        i1 += 1;
      }
    }
    if (!this.l)
    {
      i1 = 0;
      while (i1 < 3)
      {
        this.i[i1] = this.h[i1];
        i1 += 1;
      }
      this.l = true;
    }
    if (paramFloat >= this.j[0])
    {
      f1 = (paramFloat - this.j[0]) / (1.0F - this.j[0]);
      f1 = InterpolatorFactory.getInterpolator(2, 5).getInterpolation(f1);
      this.i[0] = ((int)(this.h[0] - this.h[0] * f1));
      i1 = i2;
      while (i1 < 3)
      {
        this.k[i1] = f1;
        i1 += 1;
      }
    }
    if (paramFloat >= this.j[1])
    {
      f1 = (paramFloat - this.j[1]) / (1.0F - this.j[1]);
      f1 = InterpolatorFactory.getInterpolator(2, 5).getInterpolation(f1);
      this.i[1] = ((int)(this.h[1] - f1 * this.h[1]));
    }
    if (paramFloat >= this.j[2])
    {
      f1 = (paramFloat - this.j[2]) / (1.0F - this.j[2]);
      f1 = InterpolatorFactory.getInterpolator(2, 5).getInterpolation(f1);
      this.i[2] = ((int)(this.h[2] - f1 * this.h[2]));
    }
    if (paramFloat == 1.0F) {
      a();
    }
    invalidate();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.c[2] == null) {
      return;
    }
    float[] arrayOfFloat1 = new float[2];
    float[] tmp17_15 = arrayOfFloat1;
    tmp17_15[0] = 0.5F;
    float[] tmp22_17 = tmp17_15;
    tmp22_17[1] = 0.5F;
    tmp22_17;
    float[] arrayOfFloat2 = new float[2];
    float[] tmp35_33 = arrayOfFloat2;
    tmp35_33[0] = 0.6F;
    float[] tmp40_35 = tmp35_33;
    tmp40_35[1] = -1.0F;
    tmp40_35;
    float[] arrayOfFloat3 = new float[3];
    float[] arrayOfFloat4 = new float[2];
    if (paramInt1 > paramInt2)
    {
      arrayOfFloat2[0] = -1.0F;
      arrayOfFloat2[1] = 0.6F;
      arrayOfFloat1[1] = 0.5F;
      arrayOfFloat1[0] = 0.6F;
    }
    arrayOfFloat2[1] = -1.0F;
    float[] arrayOfFloat5 = new float[3];
    float[] tmp98_96 = arrayOfFloat5;
    tmp98_96[0] = 1.5F;
    float[] tmp103_98 = tmp98_96;
    tmp103_98[1] = 1.5F;
    float[] tmp108_103 = tmp103_98;
    tmp108_103[2] = 1.5F;
    tmp108_103;
    if (paramInt2 < paramInt1)
    {
      arrayOfFloat2[0] = -1.0F;
      arrayOfFloat5[0] = 0.8F;
      arrayOfFloat5[1] = 0.8F;
      arrayOfFloat5[2] = 0.8F;
    }
    float[] arrayOfFloat6 = new float[3];
    float[] tmp150_148 = arrayOfFloat6;
    tmp150_148[0] = 0.0F;
    float[] tmp154_150 = tmp150_148;
    tmp154_150[1] = -0.25F;
    float[] tmp159_154 = tmp154_150;
    tmp159_154[2] = -0.25F;
    tmp159_154;
    int i1 = 0;
    if (i1 < 3)
    {
      if (paramInt1 < paramInt2) {
        arrayOfFloat2[0] = arrayOfFloat5[i1];
      }
      for (;;)
      {
        arrayOfFloat1[1] -= arrayOfFloat6[i1];
        a(this.c[i1], arrayOfFloat1, arrayOfFloat2, this.b[i1], paramInt1, paramInt2, arrayOfFloat3, arrayOfFloat4);
        arrayOfFloat1[1] += arrayOfFloat6[i1];
        int i2 = (int)Math.max(arrayOfFloat4[0], paramInt1 / this.b[i1]);
        this.h[i1] = ((int)(i2 * new int[] { 1, 1, -1 }[i1] * new float[] { 1.0F, 1.0F, 1.0F }[i1]));
        i1 += 1;
        break;
        arrayOfFloat2[1] = arrayOfFloat5[i1];
      }
    }
    this.d = false;
    this.m = true;
  }
  
  private void a(Context paramContext)
  {
    setBackgroundColor(16777215);
    int i1 = 0;
    while (i1 < 3)
    {
      this.k[i1] = 1.0F;
      i1 += 1;
    }
  }
  
  private void a(GLCanvas paramGLCanvas)
  {
    if (!this.m) {
      return;
    }
    if (this.f == -1L) {
      this.f = getDrawingTime();
    }
    long l1 = getDrawingTime();
    long l2 = this.f;
    if (this.g != 0L) {}
    for (float f1 = (float)(l1 - l2) / (float)this.g;; f1 = 1.0F)
    {
      if (this.e) {
        a(Math.max(0.0F, Math.min(f1, 1.0F)));
      }
      int i1 = 0;
      while (i1 < 3)
      {
        int i2 = paramGLCanvas.getAlpha();
        paramGLCanvas.setAlpha((int)(this.k[i1] * i2));
        int i3 = paramGLCanvas.save();
        paramGLCanvas.translate(this.i[i1], 0.0F);
        if (this.c[i1] != null) {
          this.c[i1].draw(paramGLCanvas);
        }
        paramGLCanvas.setAlpha(i2);
        paramGLCanvas.restoreToCount(i3);
        i1 += 1;
      }
      break;
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
    Object localObject2 = this.n;
    ((GLContentView)localObject1).getCameraWorldPosition((float[])localObject2);
    localObject2 = new Point(localObject2[0], localObject2[1], localObject2[2]);
    float[] arrayOfFloat = this.n;
    paramArrayOfFloat1[0] *= paramInt1;
    arrayOfFloat[1] = (-paramArrayOfFloat1[1] * paramInt2);
    arrayOfFloat[2] = 0.0F;
    paramArrayOfFloat1 = new Ray((Point)localObject2, new Point(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]));
    Object localObject1 = new Plane(new Point(0.0F, 0.0F, ((GLContentView)localObject1).getDepthForProjectScale(paramFloat)), new Vector(0.0F, 0.0F, 1.0F));
    paramArrayOfFloat1.startCast();
    ((Plane)localObject1).intersect(paramArrayOfFloat1);
    paramArrayOfFloat1 = paramArrayOfFloat1.getHitPoint();
    paramArrayOfFloat3[0] = paramArrayOfFloat1.x;
    paramArrayOfFloat3[1] = paramArrayOfFloat1.y;
    paramArrayOfFloat3[2] = paramArrayOfFloat1.z;
    float f1;
    if (paramArrayOfFloat2[0] == -1.0F)
    {
      paramFloat = paramArrayOfFloat2[1] * paramInt2 / paramFloat;
      f1 = paramFloat / paramGLDrawable.getIntrinsicHeight() * paramGLDrawable.getIntrinsicWidth();
    }
    for (;;)
    {
      paramArrayOfFloat4[0] = f1;
      paramArrayOfFloat4[1] = paramFloat;
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
    if (this.r == -1L) {
      this.r = getDrawingTime();
    }
    if (this.o) {
      b(Math.max(0.0F, Math.min(1.0F, (float)(getDrawingTime() - this.r) / 1000.0F)));
    }
  }
  
  private void b(float paramFloat)
  {
    this.q = paramFloat;
    if (paramFloat == 1.0F) {
      d();
    }
    invalidate();
  }
  
  private void c()
  {
    this.o = true;
    this.r = -1L;
    invalidate();
  }
  
  private void d()
  {
    this.o = false;
    if (this.s)
    {
      startWeatherAnimaiton();
      this.s = false;
    }
  }
  
  public void clearDrawable()
  {
    this.c[0] = null;
    this.c[1] = null;
    this.c[2] = null;
    this.t = true;
  }
  
  public void dispatchDraw(GLCanvas paramGLCanvas)
  {
    if (this.c[0] == null) {
      return;
    }
    b();
    int i1 = paramGLCanvas.getAlpha();
    paramGLCanvas.setAlpha((int)(i1 * this.q));
    a(paramGLCanvas);
    paramGLCanvas.setAlpha(i1);
  }
  
  public void forceAnimationStop()
  {
    if (this.e) {
      a(1.0F);
    }
  }
  
  public void initDrawable()
  {
    this.t = true;
    d locald = new d(this);
    this.mScheduledExecutorService.submit(locald);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
  }
  
  public void startCloudAnimation()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    this.f = -1L;
    this.l = false;
    invalidate();
  }
  
  public boolean startForeAnimation(boolean paramBoolean)
  {
    return true;
  }
  
  public void startWeatherAnimaiton()
  {
    if (this.t)
    {
      this.s = true;
      return;
    }
    this.s = false;
    startCloudAnimation();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/Fog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */