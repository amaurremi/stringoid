package com.pocket.widget;

import android.view.animation.Interpolator;

class c
  implements Interpolator
{
  private final float a;
  private final double b;
  
  public c(float paramFloat)
  {
    this.a = paramFloat;
    this.b = (2.0F * this.a);
  }
  
  public float a(float paramFloat)
  {
    if (this.a == 1.0F) {
      return (float)Math.sqrt(paramFloat);
    }
    return (float)Math.pow(paramFloat, 1.0D / this.b);
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (this.a == 1.0F) {
      return paramFloat * paramFloat;
    }
    return (float)Math.pow(paramFloat, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */