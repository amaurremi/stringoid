package com.pocket.p;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class d
{
  public static void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Paint paramPaint)
  {
    Paint.Style localStyle = paramPaint.getStyle();
    paramPaint.setStyle(Paint.Style.FILL);
    float f = paramFloat4;
    if (paramFloat4 == 0.0F) {
      f = 1.0F;
    }
    paramCanvas.drawRect(paramFloat1, paramFloat2, paramFloat3, paramFloat2 + f, paramPaint);
    paramPaint.setStyle(localStyle);
  }
  
  public static void b(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Paint paramPaint)
  {
    Paint.Style localStyle = paramPaint.getStyle();
    paramPaint.setStyle(Paint.Style.FILL);
    float f = paramFloat4;
    if (paramFloat4 == 0.0F) {
      f = 1.0F;
    }
    paramCanvas.drawRect(paramFloat1, paramFloat2 - f, paramFloat3, paramFloat2, paramPaint);
    paramPaint.setStyle(localStyle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */