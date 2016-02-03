package com.magmamobile.game.engine.interpolation;

public final class BounceInterpolator
  implements Interpolator
{
  private float amplitude = 1.0F;
  private boolean bounce = false;
  private float mass = 0.09F;
  private float phase = 0.0F;
  private float stiffness = 12.0F;
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat = (float)(-Math.cos(Math.sqrt(this.stiffness / this.mass) * paramFloat + this.phase + 3.141592653589793D) * (1.0F - paramFloat) * this.amplitude);
    if (this.bounce) {
      return 1.0F - Math.abs(paramFloat);
    }
    return 1.0F - paramFloat;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/interpolation/BounceInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */