package com.magmamobile.game.engine;

import java.util.concurrent.Semaphore;

final class GameThreadTemporal
  extends Thread
{
  private static final Semaphore se = new Semaphore(1);
  
  public void run()
  {
    for (;;)
    {
      try
      {
        se.acquire();
        if (Game.parameters.DEFAULT_RENDERER == 1)
        {
          Game.onTemporalCycleSoftware();
          se.release();
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        return;
      }
      Game.onTemporalCycleHardware();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameThreadTemporal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */