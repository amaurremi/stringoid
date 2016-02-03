package com.appbrain.d;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class g
  extends Drawable
{
  private Bitmap a = null;
  private Paint b;
  
  public g(int paramInt1, int paramInt2)
  {
    Canvas localCanvas = new Canvas(this.a);
    localCanvas.drawColor(paramInt1);
    Paint localPaint = new Paint();
    localPaint.setColor(paramInt2);
    localPaint.setStrokeWidth(1.0F);
    localCanvas.drawLine(0.0F, 5.0F, 5.0F, 0.0F, localPaint);
    this.b = new Paint();
    this.b.setShader(new BitmapShader(this.a, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawPaint(this.b);
  }
  
  public int getOpacity()
  {
    return -1;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */