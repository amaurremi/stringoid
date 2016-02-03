package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.go.gl.graphics.GLCanvas;
import com.go.gl.graphics.GLDrawable;
import com.go.gl.view.GLView;
import com.gtp.a.a.b.c;
import java.lang.ref.WeakReference;

public class GLWeatherLouverView
  extends GLView
{
  private Paint a = null;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int[] f = new int[8];
  private int[] g = new int[8];
  private int h = 0;
  private boolean i = true;
  private float j;
  private b k = new b(new WeakReference(this));
  private GLDrawable l;
  private boolean m = false;
  
  public GLWeatherLouverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.a = new Paint(1);
    this.a.setFilterBitmap(true);
    this.a.setAntiAlias(true);
    Object localObject2 = null;
    try
    {
      localObject1 = GLDrawable.getDrawable(getResources(), 2130838042);
      setWeather((GLDrawable)localObject1, false);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (c.a())
        {
          localOutOfMemoryError.printStackTrace();
          localObject1 = localObject2;
        }
      }
    }
  }
  
  private void b()
  {
    int i2 = 0;
    this.m = false;
    int n = this.l.getIntrinsicWidth();
    int i1 = this.l.getIntrinsicHeight();
    int i3 = getWidth();
    int i4 = getHeight();
    this.j = Math.min(i3 / (n + 0.0F), i4 / (i1 + 0.0F));
    this.b = n;
    this.c = i1;
    this.d = (this.c / 8);
    this.e = (i1 / 8);
    n = 0;
    for (;;)
    {
      i1 = i2;
      if (n >= this.f.length) {
        break;
      }
      this.f[n] = (this.d * n);
      n += 1;
    }
    while (i1 < this.g.length)
    {
      this.g[i1] = (this.e * i1);
      i1 += 1;
    }
  }
  
  private void c()
  {
    this.h += 1;
  }
  
  private boolean d()
  {
    return this.h >= this.d;
  }
  
  private void e()
  {
    this.i = true;
    this.h = 0;
  }
  
  public void cleanup()
  {
    super.cleanup();
    if (this.l != null)
    {
      releaseDrawableReference(this.l);
      this.l.clear();
      this.l.setCallback(null);
      this.l = null;
    }
  }
  
  protected void onDraw(GLCanvas paramGLCanvas)
  {
    super.onDraw(paramGLCanvas);
    if (this.l == null) {}
    float f1;
    float f2;
    for (;;)
    {
      return;
      if (this.m) {
        b();
      }
      f1 = (getWidth() - this.b * this.j) / 2.0F;
      f2 = (getHeight() - this.c * this.j) / 2.0F;
      if (this.i) {
        break;
      }
      int n = 0;
      while (n < this.f.length)
      {
        paramGLCanvas.save();
        paramGLCanvas.translate(f1, f2);
        paramGLCanvas.scale(this.j, this.j, this.j);
        paramGLCanvas.clipRect(0.0F, this.f[n], this.b, this.f[n] + this.h);
        paramGLCanvas.drawDrawable(this.l);
        paramGLCanvas.restore();
        n += 1;
      }
    }
    paramGLCanvas.save();
    paramGLCanvas.translate(f1, f2);
    paramGLCanvas.scale(this.j, this.j, this.j);
    paramGLCanvas.drawDrawable(this.l);
    paramGLCanvas.restore();
  }
  
  public void setWeather(GLDrawable paramGLDrawable, boolean paramBoolean)
  {
    if (paramGLDrawable == null) {}
    do
    {
      return;
      if (this.l != null)
      {
        releaseDrawableReference(this.l);
        this.l.clear();
        this.l.setCallback(null);
      }
      this.l = paramGLDrawable;
      this.m = true;
    } while ((!paramBoolean) || (!this.i));
    this.i = false;
    this.k.sendEmptyMessage(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLWeatherLouverView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */