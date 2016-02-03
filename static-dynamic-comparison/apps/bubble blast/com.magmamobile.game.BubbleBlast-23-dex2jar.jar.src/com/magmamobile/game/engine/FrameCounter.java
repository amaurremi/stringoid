package com.magmamobile.game.engine;

public class FrameCounter
{
  private int _frame;
  private int _modulo;
  private long _tick;
  
  public FrameCounter(int paramInt1, int paramInt2)
  {
    this._frame = paramInt1;
    this._modulo = paramInt2;
    this._tick = Game.tick;
  }
  
  public int getModulo()
  {
    return this._modulo;
  }
  
  public int getValue()
  {
    return (int)((Game.tick - this._tick) / this._frame % this._modulo);
  }
  
  public void reset()
  {
    this._tick = Game.tick;
  }
  
  public void setModulo(int paramInt)
  {
    this._modulo = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/FrameCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */