package com.magmamobile.game.engine.interpolation;

public class AccelerateInterpolator
  implements Interpolator
{
  private float doubleFactor;
  private float factor;
  
  public AccelerateInterpolator()
  {
    this.factor = 1.0F;
    this.doubleFactor = (2.0F * this.factor);
  }
  
  public AccelerateInterpolator(float paramFloat)
  {
    this.factor = paramFloat;
    this.doubleFactor = (2.0F * paramFloat);
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (this.factor == 1.0F) {
      return paramFloat * paramFloat;
    }
    return (float)Math.pow(paramFloat, this.doubleFactor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/interpolation/AccelerateInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */