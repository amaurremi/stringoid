package com.amazonaws.util;

import com.amazonaws.metrics.MetricType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class AWSRequestMetricsFullSupport
  extends AWSRequestMetrics
{
  private static final Object COMMA_SEPARATOR = ", ";
  private static final Object KEY_VALUE_SEPARATOR;
  private static final Log latencyLogger = LogFactory.getLog("com.amazonaws.latency");
  private final Map<String, TimingInfo> eventsBeingProfiled = new HashMap();
  private final Map<String, List<Object>> properties = new HashMap();
  
  static
  {
    KEY_VALUE_SEPARATOR = "=";
  }
  
  public AWSRequestMetricsFullSupport()
  {
    super(TimingInfo.startTimingFullSupport());
  }
  
  private void keyValueFormat(Object paramObject1, Object paramObject2, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramObject1).append(KEY_VALUE_SEPARATOR).append(paramObject2).append(COMMA_SEPARATOR);
  }
  
  public void addProperty(MetricType paramMetricType, Object paramObject)
  {
    addProperty(paramMetricType.name(), paramObject);
  }
  
  public void addProperty(String paramString, Object paramObject)
  {
    List localList = (List)this.properties.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.properties.put(paramString, localObject);
    }
    ((List)localObject).add(paramObject);
  }
  
  public void endEvent(MetricType paramMetricType)
  {
    endEvent(paramMetricType.name());
  }
  
  public void endEvent(String paramString)
  {
    TimingInfo localTimingInfo = (TimingInfo)this.eventsBeingProfiled.get(paramString);
    if (localTimingInfo == null)
    {
      LogFactory.getLog(getClass()).warn("Trying to end an event which was never started: " + paramString);
      return;
    }
    localTimingInfo.endTiming();
    this.timingInfo.addSubMeasurement(paramString, TimingInfo.unmodifiableTimingInfo(localTimingInfo.getStartTimeNano(), Long.valueOf(localTimingInfo.getEndTimeNano())));
  }
  
  public void incrementCounter(MetricType paramMetricType)
  {
    incrementCounter(paramMetricType.name());
  }
  
  public void incrementCounter(String paramString)
  {
    this.timingInfo.incrementCounter(paramString);
  }
  
  public final boolean isEnabled()
  {
    return true;
  }
  
  public void log()
  {
    if (latencyLogger.isInfoEnabled())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.properties.entrySet().iterator();
      Map.Entry localEntry;
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        keyValueFormat(localEntry.getKey(), localEntry.getValue(), localStringBuilder);
      }
      localIterator = this.timingInfo.getAllCounters().entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        keyValueFormat(localEntry.getKey(), localEntry.getValue(), localStringBuilder);
      }
      localIterator = this.timingInfo.getSubMeasurementsByName().entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        keyValueFormat(localEntry.getKey(), localEntry.getValue(), localStringBuilder);
      }
      latencyLogger.info(localStringBuilder.toString());
    }
  }
  
  public void setCounter(MetricType paramMetricType, long paramLong)
  {
    setCounter(paramMetricType.name(), paramLong);
  }
  
  public void setCounter(String paramString, long paramLong)
  {
    this.timingInfo.setCounter(paramString, paramLong);
  }
  
  public void startEvent(MetricType paramMetricType)
  {
    startEvent(paramMetricType.name());
  }
  
  public void startEvent(String paramString)
  {
    this.eventsBeingProfiled.put(paramString, TimingInfo.startTimingFullSupport(System.nanoTime()));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/AWSRequestMetricsFullSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */