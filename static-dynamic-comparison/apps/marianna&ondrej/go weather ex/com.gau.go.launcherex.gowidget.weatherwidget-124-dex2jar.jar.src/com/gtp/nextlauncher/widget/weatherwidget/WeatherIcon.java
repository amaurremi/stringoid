package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import com.go.gl.animation.Transformation3D;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLView;
import com.go.gl.widget.GLImageView;

public class WeatherIcon
  extends GLImageView
{
  private float A;
  private float B = -90.0F;
  private float C = 0.0F;
  private int D = 0;
  private int E = 0;
  private float F = 0.0F;
  private float G = 1.0F;
  private boolean H = false;
  private float[] I = { 0.25F, 0.5F };
  private float J = 0.7F;
  private int K = 30;
  private double L = 12.566370614359172D;
  private float M;
  private float N;
  private float[] O = new float[3];
  private float[] P = new float[3];
  private float Q = 1.0F;
  private long R = 3000L;
  private long S = 0L;
  private boolean T = false;
  private boolean U;
  private float V = 0.0F;
  private boolean W = false;
  private boolean X = false;
  private Transformation3D Y = new Transformation3D();
  private Transformation3D Z = new Transformation3D();
  private final int a = 8;
  private GLDrawable[] b = new GLDrawable[8];
  private final int c = 2;
  private int[] d = { -1, 0, 1, -1, -1, -1, -1, -1 };
  private GLDrawable[] e = new GLDrawable[2];
  private int f = -1;
  private boolean g = false;
  private Rect h;
  private GLDrawable i;
  private boolean j = false;
  private boolean k = false;
  private Handler l = new ad(this);
  private boolean m = false;
  int mCx;
  int mCy;
  private long n = 0L;
  private int o = 1100;
  private boolean p = false;
  private float q = 0.0F;
  private float r = 0.0F;
  private final float s = 15.707963F;
  private boolean t = false;
  private int u = 1000;
  private int v = 0;
  private long w = 0L;
  private int x;
  private int y;
  private float z = 0.0F;
  
  public WeatherIcon(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private GLDrawable a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= 8)) {
      return null;
    }
    if (paramBoolean)
    {
      int i1 = this.d[paramInt];
      if (i1 > -1) {
        return this.e[i1];
      }
    }
    return this.b[paramInt];
  }
  
  private void a()
  {
    if ((!this.m) && (!this.k))
    {
      this.m = true;
      this.n = -1L;
    }
    setWeather(this.f, this.g);
    if ((this.f < 0) || (this.f >= 8)) {
      return;
    }
    if (this.g)
    {
      int i1 = this.d[this.f];
      if (i1 > -1)
      {
        setImageDrawable(this.e[i1]);
        invalidate();
        return;
      }
    }
    setImageDrawable(this.b[this.f]);
    this.p = false;
    invalidate();
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat < 0.1F) {
      return;
    }
    paramFloat = (paramFloat - 0.1F) / 0.9F;
    if (paramFloat < 0.3D)
    {
      this.r = ((float)(paramFloat / 0.3D * this.q));
      invalidate();
      return;
    }
    if (!this.p)
    {
      this.p = true;
      setWeather(this.f, this.g);
    }
    if (paramFloat < 0.5D) {}
    float f1;
    for (this.r = ((float)((1.0D - (paramFloat - 0.3D) / 0.2D) * this.q));; this.r = ((float)(Math.sin(this.L * (1.0F - f1)) * this.q * 0.30000001192092896D * (1.0F - f1))))
    {
      if (paramFloat == 1.0F) {
        c();
      }
      invalidate();
      return;
      f1 = (paramFloat - 0.5F) / 0.5F;
    }
  }
  
  private void a(Context paramContext)
  {
    int i1 = 0;
    while (i1 < 8)
    {
      this.b[i1] = p.a(paramContext, new int[] { 2130838337, 2130838330, 2130838294, 2130838325, 2130838329, 2130838301, 2130838328, 2130838331 }[i1]);
      i1 += 1;
    }
    i1 = 0;
    while (i1 < 2)
    {
      this.e[i1] = p.a(paramContext, new int[] { 2130838313, 2130838295 }[i1]);
      i1 += 1;
    }
    setIsClearForUpdate(false);
    this.i = this.b[0];
  }
  
  private void b()
  {
    this.k = true;
    this.l.removeMessages(0);
    this.l.sendEmptyMessageDelayed(0, 500L);
  }
  
  private void b(float paramFloat)
  {
    if (paramFloat < 0.3D)
    {
      this.F = (this.z + (this.A - this.z) * paramFloat / 0.3F);
      this.M = (this.B + (this.C - this.B) * paramFloat / 0.3F);
      this.G = ((float)(Math.abs(0.3D - paramFloat) / 0.3D));
      this.N = (paramFloat / 0.3F);
    }
    for (;;)
    {
      if (paramFloat == 1.0F) {
        d();
      }
      invalidate();
      return;
      if (!this.p)
      {
        this.p = true;
        setWeather(this.f, this.g);
        this.N = 0.0F;
        this.G = 1.0F;
      }
      float f1 = (paramFloat - 0.3F) / 0.7F;
      this.F = ((float)(Math.sin(this.L * f1) * 35.0D * (1.0F - f1)));
    }
  }
  
  private void c()
  {
    this.m = false;
    invalidate();
  }
  
  private void c(float paramFloat)
  {
    this.Q = ((float)(Math.sin(15.707963F * paramFloat) * 0.2F) + 1.0F + this.V);
    if (this.W)
    {
      this.U = true;
      this.W = false;
      f();
      return;
    }
    if (paramFloat == 1.0F) {
      f();
    }
    invalidate();
  }
  
  private void d()
  {
    this.G = 1.0F;
    this.F = 0.0F;
    this.t = false;
    this.D = this.E;
    invalidate();
  }
  
  private void e()
  {
    this.V = 0.0F;
    this.W = true;
  }
  
  private void f()
  {
    this.Q = 1.0F;
    this.T = false;
    invalidate();
  }
  
  public void changeWeather(int paramInt, boolean paramBoolean)
  {
    this.f = paramInt;
    this.g = paramBoolean;
    if (this.T) {
      e();
    }
    a();
    b();
  }
  
  public void cleanup()
  {
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= 8) {
        break;
      }
      this.b[i1].clear();
      i1 += 1;
    }
    while (i2 < 2)
    {
      this.e[i2].clear();
      i2 += 1;
    }
    super.cleanup();
  }
  
  public void draw(GLCanvas paramGLCanvas)
  {
    if (!this.X) {
      return;
    }
    int i1 = paramGLCanvas.save();
    if (this.n == -1L) {
      this.n = getDrawingTime();
    }
    if (this.m) {
      a(Math.max(0.0F, Math.min((float)(getDrawingTime() - this.n) / this.o, 1.0F)));
    }
    if (this.w == -1L) {
      this.w = getDrawingTime();
    }
    if (this.t) {
      b(Math.max(0.0F, Math.min((float)(getDrawingTime() - this.w) / this.v, 1.0F)));
    }
    if (this.S == -1L) {
      this.S = getDrawingTime();
    }
    if (this.T) {
      c(Math.max(0.0F, Math.min((float)(getDrawingTime() - this.S) / (float)this.R, 1.0F)));
    }
    paramGLCanvas.clipRect(this.h);
    paramGLCanvas.translate(0.0F, this.r, 0.0F);
    paramGLCanvas.translate(this.x - this.mWidth / 2, this.y - this.mHeight / 2, 0.0F);
    paramGLCanvas.rotate(this.F);
    paramGLCanvas.translate(-this.x + this.mWidth / 2, -this.y + this.mHeight / 2, 0.0F);
    paramGLCanvas.translate(this.mWidth / 2, -this.mHeight / 2, 0.0F);
    paramGLCanvas.rotate(-this.F);
    paramGLCanvas.translate(-this.mWidth / 2, this.mHeight / 2, 0.0F);
    int i2 = paramGLCanvas.getAlpha();
    paramGLCanvas.setAlpha((int)(i2 * this.G));
    paramGLCanvas.scale(this.Q, this.Q, this.P[0], this.P[1]);
    super.draw(paramGLCanvas);
    paramGLCanvas.setAlpha(i2);
    paramGLCanvas.restoreToCount(i1);
    i1 = paramGLCanvas.save();
    if (this.t)
    {
      paramGLCanvas.clipRect(this.h);
      paramGLCanvas.translate(this.x - this.mWidth / 2, this.y - this.mHeight / 2, 0.0F);
      paramGLCanvas.rotate(this.M);
      paramGLCanvas.translate(-this.x + this.mWidth / 2, -this.y + this.mHeight / 2, 0.0F);
      paramGLCanvas.translate(this.mWidth / 2, -this.mHeight / 2, 0.0F);
      paramGLCanvas.rotate(-this.M);
      paramGLCanvas.translate(-this.mWidth / 2, this.mHeight / 2, 0.0F);
      i2 = paramGLCanvas.getAlpha();
      paramGLCanvas.setAlpha((int)(i2 * this.N));
      this.i.draw(paramGLCanvas);
      paramGLCanvas.setAlpha(i2);
    }
    paramGLCanvas.restoreToCount(i1);
  }
  
  public Transformation3D getTransformation()
  {
    this.Y.clear();
    this.Z.clear();
    this.Y.setTranslate(this.x - this.mWidth, this.y - this.mHeight, 0.0F);
    this.Z.setRotate(this.F);
    this.Y.compose(this.Z);
    this.Z.clear();
    this.Z.setTranslate(-this.x + this.mWidth, -this.y + this.mHeight, 0.0F);
    this.Y.compose(this.Z);
    this.Z.clear();
    this.Z.setTranslate(this.mWidth / 2, -this.mHeight / 2, 0.0F);
    this.Y.compose(this.Z);
    this.Z.clear();
    this.Z.setRotate(-this.F);
    this.Y.compose(this.Z);
    this.Z.clear();
    this.Z.setTranslate(-this.mWidth / 2, this.mHeight / 2, 0.0F);
    this.Y.compose(this.Z);
    this.Z.clear();
    return this.Y;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt3 = this.i.getIntrinsicWidth();
    paramInt2 = this.i.getIntrinsicHeight();
    paramInt1 = Math.max(0, (this.mWidth - paramInt3) / 2);
    paramInt3 = (paramInt3 + this.mWidth) / 2;
    paramInt3 = Math.min(this.mWidth, paramInt3);
    paramInt4 = Math.max(0, (this.mHeight - paramInt2) / 2);
    paramInt2 = (paramInt2 + this.mHeight) / 2;
    paramInt2 = Math.min(this.mHeight, paramInt2);
    this.i.setBounds(paramInt1, paramInt4, paramInt3, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.q = (-3.0F * paramInt2);
    GLView localGLView = (GLView)getGLParent();
    if (localGLView != null)
    {
      this.mCx = localGLView.getWidth();
      this.mCy = 0;
    }
    for (paramInt3 = localGLView.getHeight();; paramInt3 = 0)
    {
      this.h = new Rect(-paramInt1, paramInt2 * -10, paramInt1 * 4, paramInt3 * 6 / 4);
      this.X = true;
      return;
    }
  }
  
  public void setCenter(int paramInt)
  {
    this.x = paramInt;
    this.y = ((int)-(this.x / Math.tan(1.0471975511965976D)));
  }
  
  public void setDrawingCacheEnabled(boolean paramBoolean)
  {
    this.j = paramBoolean;
    if (paramBoolean)
    {
      this.W = true;
      return;
    }
    if (this.U) {
      postDelayed(new ae(this), 500L);
    }
    this.W = false;
  }
  
  public void setWeather(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= 8)) {
      return;
    }
    if (paramBoolean)
    {
      int i1 = this.d[paramInt];
      if (i1 > -1)
      {
        setImageDrawable(this.e[i1]);
        invalidate();
        return;
      }
    }
    setImageDrawable(this.b[paramInt]);
    invalidate();
  }
  
  public void startRotate(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.H = false;
    this.H = true;
    this.g = paramBoolean;
    this.f = paramInt2;
    this.E = paramInt1;
    this.v = this.u;
    this.t = true;
    this.w = -1L;
    this.A = 90.0F;
    this.z = 0.0F;
    this.F = this.z;
    this.p = false;
    this.G = 1.0F;
    this.i = a(this.f, this.g);
    this.N = 0.0F;
    this.M = this.B;
    invalidate();
  }
  
  public void startZoom()
  {
    if (this.j)
    {
      this.U = true;
      return;
    }
    this.U = false;
    this.T = true;
    this.Q = 1.0F;
    this.S = -1L;
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/WeatherIcon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */