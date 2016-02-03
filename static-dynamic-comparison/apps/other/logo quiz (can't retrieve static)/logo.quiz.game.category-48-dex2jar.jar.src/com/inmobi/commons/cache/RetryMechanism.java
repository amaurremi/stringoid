package com.inmobi.commons.cache;

import com.inmobi.commons.internal.Log;
import java.util.Timer;
import java.util.TimerTask;

public class RetryMechanism
{
  private static Timer a = new Timer();
  private int b = 0;
  private int c = 0;
  private int d = 1000;
  
  public RetryMechanism(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  private void a(final RetryRunnable paramRetryRunnable, int paramInt)
  {
    a.schedule(new a(paramRetryRunnable), paramInt);
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
        Log.internal("IMCOMMONS_3.7.1", "Exception occured while running retry mechanism");
        RetryMechanism.a(RetryMechanism.this);
        if (RetryMechanism.b(RetryMechanism.this) > RetryMechanism.c(RetryMechanism.this))
        {
          paramRetryRunnable.completed();
          return;
        }
        RetryMechanism.a(RetryMechanism.this, paramRetryRunnable, RetryMechanism.b(RetryMechanism.this) * RetryMechanism.d(RetryMechanism.this));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/cache/RetryMechanism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */