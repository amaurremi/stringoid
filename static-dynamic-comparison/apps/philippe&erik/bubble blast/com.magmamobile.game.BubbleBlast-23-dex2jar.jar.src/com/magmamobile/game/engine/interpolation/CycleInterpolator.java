package com.magmamobile.game.engine.interpolation;

public class CycleInterpolator
  implements Interpolator
{
  private int cycles;
  
  public CycleInterpolator()
  {
    this.cycles = 2;
  }
  
  public CycleInterpolator(int paramInt)
  {
    this.cycles = paramInt;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return (float)Math.abs(Math.sin(this.cycles * 3.141592653589793D * paramFloat));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/interpolation/CycleInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */