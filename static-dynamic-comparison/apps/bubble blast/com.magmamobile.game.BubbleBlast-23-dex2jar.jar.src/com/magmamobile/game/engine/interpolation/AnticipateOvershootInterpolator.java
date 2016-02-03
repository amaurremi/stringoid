package com.magmamobile.game.engine.interpolation;

public class AnticipateOvershootInterpolator
  implements Interpolator
{
  private float tension;
  
  public AnticipateOvershootInterpolator()
  {
    this.tension = 3.0F;
  }
  
  public AnticipateOvershootInterpolator(float paramFloat)
  {
    this.tension = (1.5F * paramFloat);
  }
  
  private static float a(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 * paramFloat1 * ((1.0F + paramFloat2) * paramFloat1 - paramFloat2);
  }
  
  private static float o(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 * paramFloat1 * ((1.0F + paramFloat2) * paramFloat1 + paramFloat2);
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.5F) {
      return a(paramFloat * 2.0F, this.tension) * 0.5F;
    }
    return (o(paramFloat * 2.0F - 2.0F, this.tension) + 2.0F) * 0.5F;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/interpolation/AnticipateOvershootInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */