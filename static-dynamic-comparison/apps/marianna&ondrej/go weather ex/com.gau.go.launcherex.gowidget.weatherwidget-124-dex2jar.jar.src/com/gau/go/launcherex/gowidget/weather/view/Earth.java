package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class Earth
  extends View
{
  private Bitmap a;
  private Bitmap b;
  private Bitmap c;
  private Paint d;
  private Bitmap e;
  private Canvas f;
  private float g;
  private float h;
  private float i;
  private Runnable j = new u(this);
  
  public Earth(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.d = new Paint(1);
    this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.i = getContext().getResources().getDisplayMetrics().density;
    this.a = BitmapFactory.decodeResource(getResources(), 2130837884);
    this.b = BitmapFactory.decodeResource(getResources(), 2130837886);
    this.c = BitmapFactory.decodeResource(getResources(), 2130837885);
    this.e = Bitmap.createBitmap(this.a.getWidth(), this.a.getHeight(), Bitmap.Config.ARGB_8888);
    this.f = new Canvas(this.e);
    this.h = (this.a.getWidth() - this.c.getWidth());
  }
  
  private void b()
  {
    this.g += 1.0F * this.i;
    if (this.g > 0.0F) {
      this.g = this.h;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.e.eraseColor(0);
    this.f.drawBitmap(this.c, this.g, 0.0F, null);
    this.f.drawBitmap(this.b, 0.0F, 0.0F, this.d);
    paramCanvas.drawBitmap(this.a, 0.0F, 0.0F, null);
    paramCanvas.drawBitmap(this.e, 0.0F, 0.0F, null);
    postDelayed(this.j, 50L);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.a.getWidth(), this.a.getHeight());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/Earth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */