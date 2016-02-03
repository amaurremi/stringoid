package com.magmamobile.game.engine.interpolation;

public class OvershootInterpolator
  implements Interpolator
{
  private float tension;
  
  public OvershootInterpolator()
  {
    this.tension = 2.0F;
  }
  
  public OvershootInterpolator(float paramFloat)
  {
    this.tension = paramFloat;
  }
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * paramFloat * ((this.tension + 1.0F) * paramFloat + this.tension) + 1.0F;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/interpolation/OvershootInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */