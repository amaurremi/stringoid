package com.amazonaws.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
class TimingInfoFullSupport
  extends TimingInfo
{
  private final Map<String, Number> countersByName = new HashMap();
  private final Map<String, List<TimingInfo>> subMeasurementsByName = new HashMap();
  
  TimingInfoFullSupport(Long paramLong1, long paramLong, Long paramLong2)
  {
    super(paramLong1, paramLong, paramLong2);
  }
  
  public void addSubMeasurement(String paramString, TimingInfo paramTimingInfo)
  {
    List localList = (List)this.subMeasurementsByName.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.subMeasurementsByName.put(paramString, localObject);
    }
    if (paramTimingInfo.isEndTimeKnown())
    {
      ((List)localObject).add(paramTimingInfo);
      return;
    }
    LogFactory.getLog(getClass()).debug("Skip submeasurement timing info with no end time for " + paramString);
  }
  
  public Map<String, Number> getAllCounters()
  {
    return this.countersByName;
  }
  
  public Number getCounter(String paramString)
  {
    return (Number)this.countersByName.get(paramString);
  }
  
  public Map<String, List<TimingInfo>> getSubMeasurementsByName()
  {
    return this.subMeasurementsByName;
  }
  
  public void incrementCounter(String paramString)
  {
    int i = 0;
    Number localNumber = getCounter(paramString);
    if (localNumber != null) {
      i = localNumber.intValue();
    }
    setCounter(paramString, i + 1);
  }
  
  public void setCounter(String paramString, long paramLong)
  {
    this.countersByName.put(paramString, Long.valueOf(paramLong));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/TimingInfoFullSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */