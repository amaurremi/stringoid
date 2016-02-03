package com.pocket.p;

import android.graphics.Paint;
import android.widget.TextView;

public abstract class u
{
  public static float a(float paramFloat)
  {
    return Math.min(25.0F, paramFloat);
  }
  
  public static void a(Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    paramPaint.setShadowLayer(a(paramFloat1), paramFloat2, paramFloat3, paramInt);
  }
  
  public static void a(TextView paramTextView, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    paramTextView.setShadowLayer(a(paramFloat1), paramFloat2, paramFloat3, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */