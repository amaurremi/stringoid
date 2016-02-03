package com.gau.go.launcherex.gowidget.weather.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class WaterDropView
  extends View
{
  public int a;
  private int b;
  private Bitmap c;
  private bf[] d = new bf[12];
  private int e;
  private int f;
  private int g;
  private boolean h;
  private boolean i = false;
  private be j;
  
  public WaterDropView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public WaterDropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private int a(int paramInt)
  {
    int k = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    switch (k)
    {
    default: 
      paramInt = 0;
    }
    return paramInt;
  }
  
  @SuppressLint({"NewApi"})
  private void d()
  {
    f();
    this.b = ((int)(7.0F * getResources().getDisplayMetrics().density));
    this.e = this.c.getWidth();
    this.f = this.c.getHeight();
    e();
  }
  
  private void e()
  {
    int n = this.d.length;
    int m = 0;
    int k = 0;
    if (m < n)
    {
      bf localbf = new bf(this, null);
      if (k != 0)
      {
        localbf.b = 0;
        label36:
        localbf.c = ((m + 1) * -80);
        this.d[m] = localbf;
        if (k != 0) {
          break label83;
        }
      }
      label83:
      for (k = 1;; k = 0)
      {
        m += 1;
        break;
        localbf.b = (this.e + 12);
        break label36;
      }
    }
  }
  
  private void f()
  {
    this.c = BitmapFactory.decodeResource(getResources(), 2130837577);
  }
  
  public void a()
  {
    bf[] arrayOfbf = this.d;
    int m = arrayOfbf.length;
    int k = 0;
    if (k < m)
    {
      bf localbf = arrayOfbf[k];
      localbf.c += this.b;
      if (localbf.c < -this.f) {
        localbf.a = false;
      }
      for (;;)
      {
        k += 1;
        break;
        if (localbf.c > this.g + this.f)
        {
          localbf.a = false;
          localbf.c -= 960;
          if ((!this.i) && (this.j != null))
          {
            this.i = true;
            this.j.d();
          }
        }
        else
        {
          localbf.a = true;
        }
      }
    }
  }
  
  public void a(be parambe)
  {
    this.j = parambe;
  }
  
  public void b()
  {
    this.h = true;
    invalidate();
  }
  
  public void c()
  {
    this.h = false;
    this.i = false;
    e();
    invalidate();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.c != null) && (!this.c.isRecycled())) {
      this.c.recycle();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    super.onDraw(paramCanvas);
    if (this.h)
    {
      a();
      invalidate();
    }
    paramCanvas.save();
    paramCanvas.clipRect(0, 0, getWidth(), this.a);
    bf[] arrayOfbf = this.d;
    int m = arrayOfbf.length;
    while (k < m)
    {
      bf localbf = arrayOfbf[k];
      if (localbf.a) {
        paramCanvas.drawBitmap(this.c, localbf.b, localbf.c, null);
      }
      k += 1;
    }
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.e * 2 + 12, a(paramInt2));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = paramInt2;
    this.a = this.g;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/WaterDropView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */