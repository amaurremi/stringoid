package com.magmamobile.game.engine;

import android.os.SystemClock;

public final class TimeCounter
{
  private boolean _next;
  public boolean alt;
  public int count;
  public long current;
  public int delay;
  public long next;
  public int step;
  
  public final boolean cycle()
  {
    boolean bool = false;
    this._next = false;
    this.current = SystemClock.elapsedRealtime();
    if (this.current >= this.next)
    {
      if (this.step > 0) {
        this.step -= 1;
      }
      this.next = (this.current + this.delay);
      this._next = true;
      if (!this.alt) {
        break label79;
      }
    }
    for (;;)
    {
      this.alt = bool;
      return this._next;
      label79:
      bool = true;
    }
  }
  
  public boolean next()
  {
    return this._next;
  }
  
  public final void start(int paramInt1, int paramInt2)
  {
    this.alt = false;
    this.delay = paramInt1;
    this.count = paramInt2;
    this.step = paramInt2;
    this.current = SystemClock.elapsedRealtime();
    this.next = (this.current + this.delay);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/TimeCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */