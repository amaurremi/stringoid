package com.inmobi.commons.analytics.db;

import com.inmobi.commons.internal.Log;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class AnalyticsEventsQueue
  extends Vector<AnalyticsFunctions>
{
  private static AnalyticsEventsQueue a;
  private static final long serialVersionUID = -1291938489149189478L;
  private AtomicBoolean b = new AtomicBoolean(false);
  
  private void a(AnalyticsFunctions paramAnalyticsFunctions)
  {
    paramAnalyticsFunctions.processFunction();
  }
  
  public static AnalyticsEventsQueue getInstance()
  {
    try
    {
      if (a == null) {
        a = new AnalyticsEventsQueue();
      }
      AnalyticsEventsQueue localAnalyticsEventsQueue = a;
      return localAnalyticsEventsQueue;
    }
    finally {}
  }
  
  public boolean isEmpty()
  {
    try
    {
      boolean bool = super.isEmpty();
      if (bool) {
        this.b.set(false);
      }
      return bool;
    }
    finally {}
  }
  
  public void processFunctions()
  {
    try
    {
      if (!this.b.get())
      {
        this.b.set(true);
        new a().start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  class a
    extends Thread
  {
    a() {}
    
    public void run()
    {
      try
      {
        while (!AnalyticsEventsQueue.this.isEmpty()) {
          AnalyticsEventsQueue.a(AnalyticsEventsQueue.this, (AnalyticsFunctions)AnalyticsEventsQueue.this.remove(0));
        }
        return;
      }
      catch (Exception localException)
      {
        Log.internal("[InMobi]-[Analytics]-4.1.1", "Exception processing function", localException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/analytics/db/AnalyticsEventsQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */