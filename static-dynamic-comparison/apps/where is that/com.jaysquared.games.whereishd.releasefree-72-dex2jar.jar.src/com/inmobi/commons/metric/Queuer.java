package com.inmobi.commons.metric;

import com.inmobi.commons.internal.Log;

public class Queuer
{
  private StringBuffer a = new StringBuffer();
  private long b = 0L;
  
  long a()
  {
    return this.b;
  }
  
  public String get()
  {
    Log.debug("[InMobi]-[AdTracker]-4.1.1", "Reading from queue");
    synchronized (this.a)
    {
      String str = this.a.toString();
      return str;
    }
  }
  
  public void log(EventLog paramEventLog)
  {
    synchronized (this.a)
    {
      this.a.append(paramEventLog.toString()).append(',');
      this.b += 1L;
      return;
    }
  }
  
  public void reset()
  {
    Log.debug("[InMobi]-[AdTracker]-4.1.1", "Resetting queue");
    synchronized (this.a)
    {
      this.a = new StringBuffer();
      this.b = 0L;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/metric/Queuer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */