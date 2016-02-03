package twitter4j.management;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class APIStatistics
  implements APIStatisticsMBean
{
  private final InvocationStatisticsCalculator API_STATS_CALCULATOR;
  private final int HISTORY_SIZE;
  private final Map METHOD_STATS_MAP;
  
  public APIStatistics(int paramInt)
  {
    this.API_STATS_CALCULATOR = new InvocationStatisticsCalculator("API", paramInt);
    this.METHOD_STATS_MAP = new HashMap(100);
    this.HISTORY_SIZE = paramInt;
  }
  
  private InvocationStatisticsCalculator getMethodStatistics(String paramString)
  {
    try
    {
      InvocationStatisticsCalculator localInvocationStatisticsCalculator2 = (InvocationStatisticsCalculator)this.METHOD_STATS_MAP.get(paramString);
      InvocationStatisticsCalculator localInvocationStatisticsCalculator1 = localInvocationStatisticsCalculator2;
      if (localInvocationStatisticsCalculator2 == null)
      {
        localInvocationStatisticsCalculator1 = new InvocationStatisticsCalculator(paramString, this.HISTORY_SIZE);
        this.METHOD_STATS_MAP.put(paramString, localInvocationStatisticsCalculator1);
      }
      return localInvocationStatisticsCalculator1;
    }
    finally {}
  }
  
  public long getAverageTime()
  {
    return this.API_STATS_CALCULATOR.getAverageTime();
  }
  
  public long getCallCount()
  {
    return this.API_STATS_CALCULATOR.getCallCount();
  }
  
  public long getErrorCount()
  {
    return this.API_STATS_CALCULATOR.getErrorCount();
  }
  
  public Iterable getInvocationStatistics()
  {
    try
    {
      Collection localCollection = this.METHOD_STATS_MAP.values();
      return localCollection;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Map getMethodLevelSummariesAsString()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.METHOD_STATS_MAP.values().iterator();
      while (localIterator.hasNext())
      {
        InvocationStatisticsCalculator localInvocationStatisticsCalculator = (InvocationStatisticsCalculator)localIterator.next();
        localHashMap.put(localInvocationStatisticsCalculator.getName(), localInvocationStatisticsCalculator.toString());
      }
    }
    finally {}
    return localMap;
  }
  
  public String getMethodLevelSummary(String paramString)
  {
    try
    {
      paramString = ((InvocationStatisticsCalculator)this.METHOD_STATS_MAP.get(paramString)).toString();
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String getName()
  {
    return this.API_STATS_CALCULATOR.getName();
  }
  
  public long getTotalTime()
  {
    return this.API_STATS_CALCULATOR.getTotalTime();
  }
  
  public void methodCalled(String paramString, long paramLong, boolean paramBoolean)
  {
    try
    {
      getMethodStatistics(paramString).increment(paramLong, paramBoolean);
      this.API_STATS_CALCULATOR.increment(paramLong, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void reset()
  {
    try
    {
      this.API_STATS_CALCULATOR.reset();
      this.METHOD_STATS_MAP.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/management/APIStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */