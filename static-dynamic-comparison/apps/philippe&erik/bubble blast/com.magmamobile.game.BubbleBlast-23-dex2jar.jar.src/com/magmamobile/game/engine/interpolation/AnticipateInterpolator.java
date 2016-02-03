package com.magmamobile.game.engine.interpolation;

public class AnticipateInterpolator
  implements Interpolator
{
  private float tension;
  
  public AnticipateInterpolator()
  {
    this.tension = 2.0F;
  }
  
  public AnticipateInterpolator(float paramFloat)
  {
    this.tension = paramFloat;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return paramFloat * paramFloat * ((this.tension + 1.0F) * paramFloat - this.tension);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/interpolation/AnticipateInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */