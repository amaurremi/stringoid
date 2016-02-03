package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.lang.ref.WeakReference;

public class WeatherLouverView
  extends View
{
  private Bitmap a;
  private Paint b = null;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int[] g = new int[8];
  private int[] h = new int[8];
  private int i = 0;
  private boolean j = true;
  private Rect k = new Rect();
  private float l;
  private Rect m = new Rect();
  private bv n = new bv(new WeakReference(this));
  
  public WeatherLouverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.b = new Paint(1);
    this.b.setFilterBitmap(true);
    this.b.setAntiAlias(true);
    this.a = BitmapFactory.decodeResource(getResources(), 2130838176);
    b();
  }
  
  private void b()
  {
    int i3 = 0;
    int i2 = this.a.getWidth();
    int i1 = this.a.getHeight();
    int i4 = getSuggestedMinimumWidth();
    int i5 = getSuggestedMinimumHeight();
    this.l = Math.min(i4 / (i2 + 0.0F), i5 / (i1 + 0.0F));
    i2 = (int)(i2 * this.l);
    i4 = (int)(i1 * this.l);
    this.c = i2;
    this.d = i4;
    this.e = (this.d / 8);
    this.f = (i1 / 8);
    i1 = 0;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.g.length) {
        break;
      }
      this.g[i1] = (this.e * i1);
      i1 += 1;
    }
    while (i2 < this.h.length)
    {
      this.h[i2] = (this.f * i2);
      i2 += 1;
    }
  }
  
  private void c()
  {
    this.i += 1;
  }
  
  private boolean d()
  {
    return this.i > this.e;
  }
  
  private void e()
  {
    this.j = true;
    this.i = 0;
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.a = paramBitmap;
    b();
    onMeasure(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
    if ((paramBoolean) && (this.j))
    {
      this.j = false;
      this.n.sendEmptyMessage(0);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.j)
    {
      if ((this.a != null) && (!this.a.isRecycled()))
      {
        int i1 = 0;
        while (i1 < this.g.length)
        {
          this.k.set(0, this.g[i1], this.c, this.g[i1] + this.i);
          this.m.set(0, this.h[i1], this.a.getWidth(), this.h[i1] + this.i);
          paramCanvas.drawBitmap(this.a, this.m, this.k, this.b);
          i1 += 1;
        }
      }
    }
    else
    {
      this.k.set(0, 0, this.c, this.d);
      this.m.set(0, 0, this.a.getWidth(), this.a.getHeight());
      paramCanvas.drawBitmap(this.a, this.m, this.k, this.b);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
    requestLayout();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/WeatherLouverView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */