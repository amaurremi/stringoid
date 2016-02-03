package com.gtp.nextlauncher.widget.weatherwidget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.view.GLView;

public class TemperatureCubeView
  extends GLView
{
  private float a;
  private aa b;
  private aa c;
  private float d;
  private float e;
  private String f = "°F";
  private boolean g = true;
  private int h = 1;
  private int i = 40;
  private float j;
  private float k = 20.0F;
  private float l = 0.0F;
  private float m;
  boolean mDrawingCacheEnabled = false;
  private float n;
  private boolean o;
  private int p = 0;
  private final int q = 10;
  
  public TemperatureCubeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources().getDisplayMetrics();
    float f1 = this.k;
    this.k = (paramContext.density * f1);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 2130838337;
    case 2: 
      if (paramBoolean) {
        return 2130838330;
      }
      return 2130838313;
    case 3: 
      if (paramBoolean) {
        return 2130838294;
      }
      return 2130838295;
    case 4: 
      return 2130838325;
    case 5: 
      return 2130838329;
    case 6: 
      return 2130838301;
    case 7: 
      return 2130838328;
    }
    return 2130838331;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0) && (this.c == null))
    {
      BitmapDrawable localBitmapDrawable = (BitmapDrawable)getResources().getDrawable(2130838330);
      int i1 = localBitmapDrawable.getIntrinsicWidth() / 2;
      int i2 = localBitmapDrawable.getIntrinsicHeight() / 2;
      float f1 = Math.min(paramInt1 - 5.0F, i1 * 0.65F);
      float f2 = paramInt2 - i2;
      this.c = new aa(this, f1, f2, this.k, i1, i2, false, 0.0F, this.l);
      this.c.a(2130838312);
      this.b = new aa(this, f1, f2, this.k, i1, i2, true, this.l, 2.0F * this.l);
      this.b.a(2130838303);
      this.i = ((int)(f1 * 0.8D));
      this.j = (this.i / f2);
      this.j = Math.min(0.5F, this.j);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if (this.c == null)
      {
        localBitmapDrawable = (BitmapDrawable)getResources().getDrawable(2130838330);
        i1 = localBitmapDrawable.getIntrinsicWidth() / 2;
        i2 = localBitmapDrawable.getIntrinsicHeight() / 2;
        f1 = Math.min(paramInt1 - 5.0F, i1 * 0.65F);
        f2 = paramInt2 - i2;
        this.c = new aa(this, f1, f2, this.k, i1, i2, false, 0.0F, this.l);
        this.c.a(2130838312);
        this.b = new aa(this, f1, f2, this.k, i1, i2, true, this.l, 2.0F * this.l);
        this.b.a(2130838303);
        this.i = ((int)(f1 * 0.8D));
        this.j = (this.i / f2);
        this.j = Math.min(0.5F, this.j);
      }
    }
    else {
      return;
    }
    BitmapDrawable localBitmapDrawable = (BitmapDrawable)getResources().getDrawable(2130838330);
    int i1 = localBitmapDrawable.getIntrinsicWidth() / 2;
    int i2 = localBitmapDrawable.getIntrinsicHeight() / 2;
    float f1 = Math.min(paramInt1 - 5.0F, i1 * 0.65F);
    float f2 = paramInt2 - i2;
    this.c.a(f1, f2, this.k, i1, i2);
    this.b.a(f1, f2, this.k, i1, i2);
    this.i = ((int)(f1 * 0.8D));
    this.j = (this.i / f2);
    this.j = Math.min(0.5F, this.j);
    this.c.a((int)this.e + this.f, false);
    this.b.a((int)this.d + this.f, true);
    float f3 = Math.max((this.d - this.n) / (this.m - this.n), 2.0F * this.j);
    f2 = Math.min((this.e - this.n) / (this.m - this.n), f3 - this.j);
    f1 = f2;
    if (f2 < this.j) {
      f1 = this.j;
    }
    this.c.a(f1);
    this.b.a(f3);
  }
  
  public void cleanup()
  {
    if (this.b != null) {
      this.b.e();
    }
    if (this.c != null) {
      this.c.e();
    }
    super.cleanup();
  }
  
  public boolean isNoData()
  {
    return this.o;
  }
  
  protected void onDraw(GLCanvas paramGLCanvas)
  {
    if (this.c == null) {
      return;
    }
    paramGLCanvas.save();
    paramGLCanvas.translate(getWidth() / 2, -getHeight(), -this.k);
    paramGLCanvas.rotateAxisAngle(this.a, 0.0F, 1.0F, 0.0F);
    this.b.a(paramGLCanvas);
    paramGLCanvas.translate(0.0F, 0.0F, this.k);
    this.c.a(paramGLCanvas);
    super.onDraw(paramGLCanvas);
    paramGLCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b(paramInt1, paramInt2);
  }
  
  public void resetCubes()
  {
    if (this.b != null) {
      this.b.a();
    }
    if (this.c != null) {
      this.c.a();
    }
  }
  
  public void setDrawingCacheEnabled(boolean paramBoolean)
  {
    this.mDrawingCacheEnabled = paramBoolean;
  }
  
  public void setHighTemperature(float paramFloat)
  {
    this.d = paramFloat;
    if (this.b != null) {
      this.b.a((int)this.d + this.f, true);
    }
  }
  
  public void setLowTemperature(float paramFloat)
  {
    this.e = paramFloat;
    if (this.c != null) {
      this.c.a((int)this.e + this.f, false);
    }
  }
  
  public void setNoData(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setTemperatureUnit(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.f = "°C";
      return;
    }
    this.f = "°F";
  }
  
  public void setWeatherType(int paramInt, boolean paramBoolean)
  {
    if ((this.h != paramInt) || (this.g != paramBoolean))
    {
      this.h = paramInt;
      this.g = paramBoolean;
      if (this.b != null) {
        this.b.b(a(this.h, this.g));
      }
    }
  }
  
  public void startAnimating(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.c == null) {
      a(getWidth(), getHeight());
    }
    if (this.c == null)
    {
      if (this.p < 10) {
        postDelayed(new ac(this, paramFloat1, paramFloat2, paramBoolean), 10L);
      }
      this.p += 1;
      return;
    }
    this.c.a((int)this.e + this.f, false);
    this.b.a((int)this.d + this.f, true);
    this.b.b(a(this.h, this.g));
    this.m = paramFloat1;
    this.n = (paramFloat2 - 5.0F);
    float f1 = Math.max((this.d - this.n) / (this.m - this.n), 2.0F * this.j);
    paramFloat2 = Math.min((this.e - this.n) / (this.m - this.n), f1 - this.j);
    paramFloat1 = paramFloat2;
    if (paramFloat2 < this.j) {
      paramFloat1 = this.j;
    }
    if (paramBoolean)
    {
      this.b.a(0.0F, f1, paramBoolean);
      this.c.a(0.0F, paramFloat1, paramBoolean);
    }
    for (;;)
    {
      this.b.d();
      return;
      this.b.a(f1, paramBoolean);
      this.c.a(paramFloat1, paramBoolean);
    }
  }
  
  public void updateAngleByAccelerometer(float paramFloat)
  {
    this.a = (-paramFloat * 10.0F * 0.5625F);
    invalidate();
  }
  
  public void updateLastWeatherMark()
  {
    if (this.b != null)
    {
      this.b.c(a(this.h, this.g));
      this.b.d();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/TemperatureCubeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */