package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class Clock
  extends View
{
  private Paint a = new Paint(1);
  private Bitmap b;
  private Bitmap c;
  private Bitmap d;
  private Bitmap e;
  private int f;
  private int g;
  private int h = -60;
  private int i = 0;
  private TextView j;
  private int k;
  private int l;
  private int m;
  
  public Clock(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public Clock(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    this.b = BitmapFactory.decodeResource(paramContext, 2130837533);
    this.f = this.b.getWidth();
    this.g = this.b.getHeight();
    this.c = BitmapFactory.decodeResource(paramContext, 2130837542);
    this.d = BitmapFactory.decodeResource(paramContext, 2130837551);
    this.e = BitmapFactory.decodeResource(paramContext, 2130837534);
    this.m = (this.g - this.c.getHeight());
    this.k = (this.f / 2);
    this.l = ((this.g - this.m) / 2);
  }
  
  private void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.h == 0)
    {
      paramCanvas.drawBitmap(this.c, 0.0F, 0.0F, this.a);
      return;
    }
    int n = paramCanvas.save();
    paramCanvas.rotate(this.h, this.k, this.l);
    paramCanvas.drawBitmap(this.c, 0.0F, 0.0F, this.a);
    paramCanvas.restoreToCount(n);
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.i == 0)
    {
      paramCanvas.drawBitmap(this.d, 0.0F, 0.0F, this.a);
      return;
    }
    int n = paramCanvas.save();
    paramCanvas.rotate(this.i, this.k, this.l);
    paramCanvas.drawBitmap(this.d, 0.0F, 0.0F, this.a);
    paramCanvas.restoreToCount(n);
  }
  
  public void a()
  {
    clearAnimation();
    this.h = -60;
    this.i = 0;
    invalidate();
  }
  
  public void a(TextView paramTextView)
  {
    this.j = paramTextView;
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.b, 0.0F, 0.0F, null);
    int n = paramCanvas.save();
    paramCanvas.translate(0.0F, this.m);
    b(paramCanvas);
    a(paramCanvas);
    paramCanvas.drawBitmap(this.e, 0.0F, 0.0F, null);
    paramCanvas.restoreToCount(n);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a(this.b);
    a(this.c);
    a(this.d);
    a(this.e);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.f, this.g);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/Clock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */