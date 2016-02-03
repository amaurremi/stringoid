package com.amazonaws.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class TimingInfo
{
  private Long endTimeNano;
  private final Long startEpochTimeMilli;
  private final long startTimeNano;
  
  protected TimingInfo(Long paramLong1, long paramLong, Long paramLong2)
  {
    this.startEpochTimeMilli = paramLong1;
    this.startTimeNano = paramLong;
    this.endTimeNano = paramLong2;
  }
  
  public static double durationMilliOf(long paramLong1, long paramLong2)
  {
    return TimeUnit.NANOSECONDS.toMicros(paramLong2 - paramLong1) / 1000.0D;
  }
  
  public static TimingInfo startTiming()
  {
    return new TimingInfo(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
  }
  
  public static TimingInfo startTimingFullSupport()
  {
    return new TimingInfoFullSupport(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
  }
  
  public static TimingInfo startTimingFullSupport(long paramLong)
  {
    return new TimingInfoFullSupport(null, paramLong, null);
  }
  
  public static TimingInfo unmodifiableTimingInfo(long paramLong, Long paramLong1)
  {
    return new TimingInfoUnmodifiable(null, paramLong, paramLong1);
  }
  
  public void addSubMeasurement(String paramString, TimingInfo paramTimingInfo) {}
  
  public TimingInfo endTiming()
  {
    this.endTimeNano = Long.valueOf(System.nanoTime());
    return this;
  }
  
  public Map<String, Number> getAllCounters()
  {
    return Collections.emptyMap();
  }
  
  public Number getCounter(String paramString)
  {
    return null;
  }
  
  public final long getEndTimeNano()
  {
    if (this.endTimeNano == null) {
      return -1L;
    }
    return this.endTimeNano.longValue();
  }
  
  public final long getStartTimeNano()
  {
    return this.startTimeNano;
  }
  
  public Map<String, List<TimingInfo>> getSubMeasurementsByName()
  {
    return Collections.emptyMap();
  }
  
  @Deprecated
  public final double getTimeTakenMillis()
  {
    Double localDouble = getTimeTakenMillisIfKnown();
    if (localDouble == null) {
      return -1.0D;
    }
    return localDouble.doubleValue();
  }
  
  public final Double getTimeTakenMillisIfKnown()
  {
    if (isEndTimeKnown()) {
      return Double.valueOf(durationMilliOf(this.startTimeNano, this.endTimeNano.longValue()));
    }
    return null;
  }
  
  public void incrementCounter(String paramString) {}
  
  public final boolean isEndTimeKnown()
  {
    return this.endTimeNano != null;
  }
  
  public void setCounter(String paramString, long paramLong) {}
  
  public final String toString()
  {
    return String.valueOf(getTimeTakenMillis());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/TimingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */