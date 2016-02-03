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

public class OverCast
  extends Wall
{
  public static float sWallB = 0.0F;
  private final int a = 3;
  private GLDrawable[] b = new GLDrawable[3];
  private float[] c = { 0.55F, 0.6F, 0.65F };
  private boolean d = false;
  private long e = 0L;
  private long f = 5000L;
  private int[] g = new int[3];
  private int[] h = new int[3];
  private float[] i = { 0.2F, 0.25F, 0.5F, 1.0F };
  private float j = 1.0F;
  private boolean k = false;
  private float[][] l = new float[3][];
  private boolean m = false;
  private float[] n = new float[3];
  private boolean o = false;
  private final float p = 1000.0F;
  private float q = 1.0F;
  private long r = 0L;
  private boolean s = false;
  private boolean t = true;
  
  public OverCast(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a()
  {
    this.d = false;
    if (this.mWallHoder != null) {
      this.mWallHoder.onPreviewAnimationEnd();
    }
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat < this.i[0]) {
      this.j = (1.0F - paramFloat / this.i[0]);
    }
    for (;;)
    {
      if (paramFloat == 1.0F) {
        a();
      }
      invalidate();
      return;
      if (!this.k)
      {
        int i1 = 0;
        while (i1 < 3)
        {
          this.h[i1] = this.g[i1];
          i1 += 1;
        }
        this.k = true;
      }
      this.j = 1.0F;
      float f1;
      if (paramFloat >= this.i[0])
      {
        f1 = paramFloat / (1.0F - this.i[0]);
        f1 = InterpolatorFactory.getInterpolator(2, 5).getInterpolation(f1);
        this.h[0] = ((int)(this.g[0] - f1 * this.g[0]));
      }
      if (paramFloat >= this.i[1])
      {
        f1 = (paramFloat - this.i[1]) / (1.0F - this.i[1]);
        f1 = InterpolatorFactory.getInterpolator(2, 5).getInterpolation(f1);
        this.h[1] = ((int)(this.g[1] - f1 * this.g[1]));
      }
      if (paramFloat >= this.i[2])
      {
        f1 = (paramFloat - this.i[2]) / (1.0F - this.i[2]);
        f1 = InterpolatorFactory.getInterpolator(2, 5).getInterpolation(f1);
        this.h[2] = ((int)(this.g[2] - f1 * this.g[2]));
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat1 = new float[2];
    float[] tmp7_5 = arrayOfFloat1;
    tmp7_5[0] = 0.5F;
    float[] tmp12_7 = tmp7_5;
    tmp12_7[1] = 0.5F;
    tmp12_7;
    float[] arrayOfFloat2 = new float[2];
    float[] tmp25_23 = arrayOfFloat2;
    tmp25_23[0] = 0.6F;
    float[] tmp30_25 = tmp25_23;
    tmp30_25[1] = -1.0F;
    tmp30_25;
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
    float[] tmp88_86 = arrayOfFloat5;
    tmp88_86[0] = 1.5F;
    float[] tmp93_88 = tmp88_86;
    tmp93_88[1] = 0.8F;
    float[] tmp98_93 = tmp93_88;
    tmp98_93[2] = 1.0F;
    tmp98_93;
    if (paramInt2 < paramInt1)
    {
      arrayOfFloat2[0] = -1.0F;
      arrayOfFloat5[0] = 0.8F;
      arrayOfFloat5[1] = 0.4F;
      arrayOfFloat5[2] = 0.6F;
    }
    int i1 = 0;
    if (i1 < 3)
    {
      if (paramInt1 >= paramInt2) {
        break label162;
      }
      arrayOfFloat2[0] = arrayOfFloat5[i1];
    }
    while (this.b[i1] == null)
    {
      return;
      label162:
      arrayOfFloat2[1] = arrayOfFloat5[i1];
    }
    a(this.b[i1], arrayOfFloat1, arrayOfFloat2, this.c[i1], paramInt1, paramInt2, arrayOfFloat3, arrayOfFloat4);
    if (i1 == 0) {
      this.g[i1] = ((int)(arrayOfFloat4[0] + paramInt1 / 2 / this.c[i1]));
    }
    for (;;)
    {
      i1 += 1;
      break;
      this.g[i1] = ((int)-(arrayOfFloat4[0] + paramInt1 / 2 / this.c[i1]));
    }
  }
  
  private void a(Context paramContext)
  {
    this.mContext = paramContext;
    b(paramContext);
    setBackgroundColor(16777215);
  }
  
  private void a(GLCanvas paramGLCanvas)
  {
    if (this.e == -1L) {
      this.e = getDrawingTime();
    }
    long l1;
    long l2;
    if (this.d)
    {
      l1 = getDrawingTime();
      l2 = this.e;
      if (this.f == 0L) {
        break label155;
      }
    }
    label155:
    for (float f1 = (float)(l1 - l2) / (float)this.f;; f1 = 1.0F)
    {
      a(Math.max(0.0F, Math.min(f1, 1.0F)));
      int i1 = 0;
      while (i1 < 3)
      {
        int i2 = paramGLCanvas.getAlpha();
        paramGLCanvas.setAlpha((int)(this.j * i2));
        int i3 = paramGLCanvas.save();
        paramGLCanvas.translate(this.h[i1], 0.0F);
        if (this.b[i1] != null) {
          this.b[i1].draw(paramGLCanvas);
        }
        paramGLCanvas.setAlpha(i2);
        paramGLCanvas.restoreToCount(i3);
        i1 += 1;
      }
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
  
  private void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    this.m = false;
  }
  
  private void b(Context paramContext)
  {
    this.m = true;
    this.b[0] = e.a().y(paramContext);
    this.b[1] = e.a().z(paramContext);
    this.b[2] = e.a().A(paramContext);
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
    int i1 = 0;
    while (i1 < 3)
    {
      if (this.b[i1] != null)
      {
        this.b[i1].clear();
        this.b[i1] = null;
      }
      i1 += 1;
    }
    this.t = true;
  }
  
  public void dispatchDraw(GLCanvas paramGLCanvas)
  {
    if (this.t) {
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
    if (this.d) {
      a(1.0F);
    }
  }
  
  public void initDrawable()
  {
    this.t = true;
    g localg = new g(this);
    this.mScheduledExecutorService.submit(localg);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b(paramInt1, paramInt2);
  }
  
  public void startCloudAnimation()
  {
    if ((this.d) || (this.t))
    {
      this.s = true;
      return;
    }
    this.s = false;
    this.d = true;
    this.e = -1L;
    this.k = false;
    invalidate();
  }
  
  public boolean startForeAnimation(boolean paramBoolean)
  {
    return true;
  }
  
  public void startWeatherAnimaiton()
  {
    if ((this.t) || (this.o))
    {
      this.s = true;
      return;
    }
    this.s = false;
    startCloudAnimation();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/OverCast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */