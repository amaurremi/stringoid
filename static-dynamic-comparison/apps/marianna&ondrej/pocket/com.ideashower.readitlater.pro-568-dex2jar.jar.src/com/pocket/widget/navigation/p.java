package com.pocket.widget.navigation;

import android.view.animation.Interpolator;

public class p
  implements Interpolator
{
  private final float b;
  private final Interpolator c;
  
  public p(o paramo, float paramFloat, Interpolator paramInterpolator)
  {
    this.b = paramFloat;
    this.c = paramInterpolator;
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat > 1.0F - this.b) {
      return 1.0F;
    }
    float f = this.b;
    return this.c.getInterpolation((1.0F + f) * paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */