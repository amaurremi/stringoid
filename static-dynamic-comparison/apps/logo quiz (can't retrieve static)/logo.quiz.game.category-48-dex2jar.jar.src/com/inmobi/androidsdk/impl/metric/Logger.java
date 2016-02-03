package com.inmobi.androidsdk.impl.metric;

import android.content.Context;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.bootstrapper.MetricConfigParams;

public class Logger
{
  private static String a = null;
  public static MetricAction action = null;
  private static Integer b = Integer.valueOf(2147483646);
  
  public static String getUrl()
  {
    return a;
  }
  
  public static void logEvent(Context paramContext, EventLog paramEventLog)
  {
    Storage.readNumberOfEventsAndTimeStampFromPersistent(paramContext);
    MetricConfigParams localMetricConfigParams = Initializer.getConfigParams(paramContext).getMetric();
    Queuer.queuer.log(paramEventLog);
    if (Queuer.queuer.number >= localMetricConfigParams.getDumpThreshhold()) {
      Storage.saveLocalCache(paramContext);
    }
    if ((Storage.events >= localMetricConfigParams.getMaxInQueue()) || (Storage.timestamp + localMetricConfigParams.getNextRetryInterval() <= System.currentTimeMillis() / 1000L)) {
      new Thread(new a(paramContext)).start();
    }
  }
  
  public static boolean startNewSample(Context paramContext)
  {
    synchronized (b)
    {
      Integer localInteger2 = b;
      b = Integer.valueOf(b.intValue() + 1);
      if (b.intValue() >= Initializer.getConfigParams(paramContext).getMetric().getSamplingFactor())
      {
        b = Integer.valueOf(0);
        paramContext = action;
        if (paramContext == null) {}
      }
    }
    try
    {
      action.metricCalcEvent();
      return true;
      return false;
      paramContext = finally;
      throw paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  static final class a
    implements Runnable
  {
    a(Context paramContext) {}
    
    public void run()
    {
      Storage.sendFile(this.a);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/metric/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */