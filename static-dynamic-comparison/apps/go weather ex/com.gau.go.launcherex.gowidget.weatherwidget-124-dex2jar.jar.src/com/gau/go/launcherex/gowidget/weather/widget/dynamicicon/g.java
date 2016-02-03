package com.gau.go.launcherex.gowidget.weather.widget.dynamicicon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class g
  extends f
{
  private Bitmap b;
  private Paint c = null;
  private int d = 0;
  private int e = 0;
  private float f = 0.0F;
  private float[] g = new float[10];
  private float h = 0.0F;
  private boolean i = true;
  private boolean j = true;
  private float k = 1.0F;
  private float l;
  private float m;
  
  public g(Context paramContext)
  {
    super(paramContext);
    this.c.setFilterBitmap(true);
    this.c.setAntiAlias(true);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.d = this.b.getWidth();
    this.e = this.b.getHeight();
    if ((this.d > paramInt2) || (this.e > paramInt2))
    {
      this.k = Math.min(paramInt1 / this.d, paramInt2 / this.e);
      this.l = ((paramInt2 - this.e * this.k) / 2.0F);
      this.m = ((paramInt1 - this.d * this.k) / 2.0F);
    }
    for (;;)
    {
      this.f = (this.e / 10);
      paramInt1 = 0;
      while (paramInt1 < this.g.length)
      {
        this.g[paramInt1] = (this.f * paramInt1);
        paramInt1 += 1;
      }
      this.k = 1.0F;
      this.m = ((paramInt1 - this.d) / 2);
      this.l = ((paramInt2 - this.e) / 2);
    }
  }
  
  private void c()
  {
    this.h += 2.0F;
    if (this.h > this.f) {
      this.h = this.f;
    }
  }
  
  private void d()
  {
    this.j = true;
    this.h = 0.0F;
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.b = paramBitmap;
    if (this.b != null) {
      a(paramInt1, paramInt2);
    }
    d();
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.j = bool;
      this.i = paramBoolean;
      return;
    }
  }
  
  public void a(Canvas paramCanvas, View paramView)
  {
    if ((this.b != null) && (!this.b.isRecycled()))
    {
      int n;
      if ((this.i) && (!this.j))
      {
        c();
        n = 0;
      }
      while (n < this.g.length)
      {
        paramCanvas.save();
        paramCanvas.translate(this.m, this.l);
        if (this.k != 1.0F) {
          paramCanvas.scale(this.k, this.k);
        }
        paramCanvas.clipRect(0.0F, this.g[n], this.d, this.g[n] + this.h);
        paramCanvas.drawBitmap(this.b, 0.0F, 0.0F, this.c);
        paramCanvas.restore();
        n += 1;
        continue;
        paramCanvas.save();
        paramCanvas.translate(this.m, this.l);
        if (this.k != 1.0F) {
          paramCanvas.scale(this.k, this.k);
        }
        paramCanvas.drawBitmap(this.b, 0.0F, 0.0F, this.c);
        paramCanvas.restore();
      }
    }
  }
  
  public void a(View paramView)
  {
    if (this.b != null) {
      a(paramView.getWidth(), paramView.getHeight());
    }
  }
  
  public boolean a()
  {
    if (this.h >= this.f) {}
    for (boolean bool = true;; bool = false)
    {
      this.j = bool;
      return this.j;
    }
  }
  
  public void b()
  {
    d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/widget/dynamicicon/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */