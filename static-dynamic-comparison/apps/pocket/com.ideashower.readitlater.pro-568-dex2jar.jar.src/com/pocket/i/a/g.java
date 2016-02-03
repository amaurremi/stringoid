package com.pocket.i.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;

public class g
{
  private final Path a = new Path();
  private final RectF b = new RectF();
  private float c = 0.0F;
  
  public float a()
  {
    return this.c;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f2 = paramFloat3 - paramFloat1;
    float f3 = paramFloat4 - paramFloat2;
    float f1 = f3 / 2.0F;
    float f4 = f2 / 2.0F;
    float f5 = f3 / 2.0F;
    this.a.rewind();
    if (f2 == f3) {
      this.a.addCircle(f4 + paramFloat1, f5 + paramFloat2, f1, Path.Direction.CW);
    }
    for (;;)
    {
      this.a.close();
      this.c = (paramFloat3 - paramFloat1);
      return;
      f2 = paramFloat1 + f1;
      f3 = paramFloat3 - f1;
      f4 = paramFloat1 + f1;
      this.a.moveTo(f2, paramFloat2);
      this.a.lineTo(f3, paramFloat2);
      this.b.set(f3 - f1, paramFloat2, paramFloat3 - f1 + f1, paramFloat4);
      this.a.arcTo(this.b, 270.0F, 180.0F);
      this.a.lineTo(f4, paramFloat4);
      this.b.set(f2 - f1, paramFloat2, f1 + f4, paramFloat4);
      this.a.arcTo(this.b, 90.0F, 180.0F);
    }
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    paramCanvas.drawPath(this.a, paramPaint);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/i/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */