package com.pocket.p;

import android.graphics.Paint;
import android.graphics.Rect;

public abstract class y
{
  public static float a(Paint paramPaint)
  {
    return -paramPaint.ascent() - paramPaint.descent();
  }
  
  public static float a(Rect paramRect, Paint paramPaint)
  {
    float f = a(paramPaint);
    return f + (paramRect.exactCenterY() - f / 2.0F);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */