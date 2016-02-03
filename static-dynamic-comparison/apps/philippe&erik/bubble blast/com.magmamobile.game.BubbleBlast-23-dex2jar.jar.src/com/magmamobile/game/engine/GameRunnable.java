package com.magmamobile.game.engine;

public class GameRunnable
  implements Runnable
{
  public void execute()
  {
    Game.mHandler.post(this);
  }
  
  public void run() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */