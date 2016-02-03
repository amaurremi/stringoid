package com.inmobi.androidsdk.impl.metric;

import com.inmobi.commons.internal.Log;

public class Queuer
{
  public static Queuer queuer = new Queuer();
  StringBuffer a = new StringBuffer();
  public long number = 0L;
  
  protected void finalize()
    throws Throwable
  {
    Storage.saveToLatest();
    super.finalize();
  }
  
  public String get()
  {
    Log.debug("InMobiAndroidSDK_3.7.1", "Reading from queue");
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
      this.number += 1L;
      return;
    }
  }
  
  public void reset()
  {
    Log.debug("InMobiAndroidSDK_3.7.1", "Resetting queue");
    synchronized (this.a)
    {
      this.a = new StringBuffer();
      this.number = 0L;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/metric/Queuer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */