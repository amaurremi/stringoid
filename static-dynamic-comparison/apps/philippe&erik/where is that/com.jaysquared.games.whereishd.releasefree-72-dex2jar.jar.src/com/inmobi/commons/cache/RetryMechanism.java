package com.inmobi.commons.cache;

import com.inmobi.commons.internal.Log;
import java.util.Timer;
import java.util.TimerTask;

public class RetryMechanism
{
  private Timer a;
  private int b = 0;
  private int c = 0;
  private int d = 1000;
  
  public RetryMechanism(int paramInt1, int paramInt2, Timer paramTimer)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.a = paramTimer;
  }
  
  private void a(final RetryRunnable paramRetryRunnable, int paramInt)
  {
    this.a.schedule(new a(paramRetryRunnable), paramInt);
  }
  
  public void rescheduleTimer(RetryRunnable paramRetryRunnable)
  {
    this.b = 0;
    a(paramRetryRunnable, 0);
  }
  
  public static abstract interface RetryRunnable
  {
    public abstract void completed();
    
    public abstract void run()
      throws Exception;
  }
  
  class a
    extends TimerTask
  {
    a(RetryMechanism.RetryRunnable paramRetryRunnable) {}
    
    public void run()
    {
      try
      {
        paramRetryRunnable.run();
        paramRetryRunnable.completed();
        return;
      }
      catch (Exception localException)
      {
        RetryMechanism.a(RetryMechanism.this);
        if (RetryMechanism.b(RetryMechanism.this) > RetryMechanism.c(RetryMechanism.this))
        {
          Log.internal("[InMobi]-4.1.1", "Exception occured while running retry mechanism and will the limit for retrying has been reached.");
          paramRetryRunnable.completed();
          return;
        }
        Log.internal("[InMobi]-4.1.1", "Exception occured while running retry mechanism and will retry in " + RetryMechanism.b(RetryMechanism.this) * RetryMechanism.d(RetryMechanism.this) + " ms");
        RetryMechanism.a(RetryMechanism.this, paramRetryRunnable, RetryMechanism.b(RetryMechanism.this) * RetryMechanism.d(RetryMechanism.this));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/cache/RetryMechanism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */