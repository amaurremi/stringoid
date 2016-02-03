package com.bluebird.mobile.tools.timecounter;

import java.util.concurrent.TimeUnit;

public class SimpleTimeCounter
  implements TimeCounter
{
  private long allTimeInPause = 0L;
  private boolean isPaused = false;
  private long lastStartPause;
  private long startTime;
  
  public long currentInMillis()
  {
    if (this.isPaused) {
      return 0L;
    }
    return System.currentTimeMillis() - this.startTime - this.allTimeInPause;
  }
  
  public void pause()
  {
    if (!this.isPaused)
    {
      this.lastStartPause = System.currentTimeMillis();
      this.isPaused = true;
    }
  }
  
  public void resume()
  {
    if (this.isPaused)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.lastStartPause;
      this.allTimeInPause += l1 - l2;
    }
    this.isPaused = false;
  }
  
  public void start()
  {
    this.startTime = System.currentTimeMillis();
    this.allTimeInPause = 0L;
  }
  
  public long stop(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(System.currentTimeMillis() - this.startTime - this.allTimeInPause, TimeUnit.MILLISECONDS);
  }
  
  public void stop()
  {
    stop(TimeUnit.MILLISECONDS);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/timecounter/SimpleTimeCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */