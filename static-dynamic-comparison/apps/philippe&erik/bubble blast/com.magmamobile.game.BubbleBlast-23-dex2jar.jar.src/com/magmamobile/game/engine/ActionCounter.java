package com.magmamobile.game.engine;

import android.os.SystemClock;

public class ActionCounter
{
  private static int counter;
  private static int frame;
  private static long nextTime;
  
  public static int getCounter()
  {
    return counter;
  }
  
  public static int getFPS()
  {
    return frame;
  }
  
  public static long getNextTime()
  {
    return nextTime;
  }
  
  public static void next()
  {
    counter += 1;
    long l = SystemClock.elapsedRealtime();
    if (l > nextTime)
    {
      nextTime = 1000L + l;
      frame = counter;
      counter = 0;
    }
  }
  
  public static void restart()
  {
    nextTime = SystemClock.elapsedRealtime() + 1000L;
    counter = 0;
    frame = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ActionCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */