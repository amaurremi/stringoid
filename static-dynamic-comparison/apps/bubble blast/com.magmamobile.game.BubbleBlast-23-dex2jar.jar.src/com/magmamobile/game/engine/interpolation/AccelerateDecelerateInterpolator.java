package com.magmamobile.game.engine.interpolation;

public class AccelerateDecelerateInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.cos((1.0F + paramFloat) * 3.141592653589793D) / 2.0D) + 0.5F;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/interpolation/AccelerateDecelerateInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */