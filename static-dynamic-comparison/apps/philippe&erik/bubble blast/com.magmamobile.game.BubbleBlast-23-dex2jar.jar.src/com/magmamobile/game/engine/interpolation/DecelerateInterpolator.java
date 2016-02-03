package com.magmamobile.game.engine.interpolation;

public class DecelerateInterpolator
  implements Interpolator
{
  private float factor;
  
  public DecelerateInterpolator()
  {
    this.factor = 1.0F;
  }
  
  public DecelerateInterpolator(float paramFloat)
  {
    this.factor = paramFloat;
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (this.factor == 1.0F) {
      return 1.0F - (1.0F - paramFloat) * (1.0F - paramFloat);
    }
    return (float)(1.0D - Math.pow(1.0F - paramFloat, 2.0F * this.factor));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/interpolation/DecelerateInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */