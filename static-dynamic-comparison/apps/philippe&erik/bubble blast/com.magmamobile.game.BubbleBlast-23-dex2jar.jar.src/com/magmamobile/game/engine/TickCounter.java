package com.magmamobile.game.engine;

public final class TickCounter
{
  private int _modulo;
  private long _tick;
  
  public TickCounter(int paramInt)
  {
    this._modulo = paramInt;
    this._tick = Game.tick;
  }
  
  public int getModulo()
  {
    return this._modulo;
  }
  
  public int getValue()
  {
    return (int)((Game.tick - this._tick) % this._modulo);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/TickCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */