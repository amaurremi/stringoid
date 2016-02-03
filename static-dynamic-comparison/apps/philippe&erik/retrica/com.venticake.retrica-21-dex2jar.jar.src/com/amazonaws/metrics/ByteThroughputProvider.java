package com.amazonaws.metrics;

public abstract class ByteThroughputProvider
{
  private int byteCount;
  private long duration;
  private final ThroughputMetricType throughputType;
  
  protected ByteThroughputProvider(ThroughputMetricType paramThroughputMetricType)
  {
    this.throughputType = paramThroughputMetricType;
  }
  
  public int getByteCount()
  {
    return this.byteCount;
  }
  
  public long getDurationNano()
  {
    return this.duration;
  }
  
  public String getProviderId()
  {
    return super.toString();
  }
  
  protected void increment(int paramInt, long paramLong)
  {
    this.byteCount += paramInt;
    this.duration += System.nanoTime() - paramLong;
  }
  
  protected void reset()
  {
    this.byteCount = 0;
    this.duration = 0L;
  }
  
  public String toString()
  {
    return String.format("providerId=%s, throughputType=%s, byteCount=%d, duration=%d", new Object[] { getProviderId(), this.throughputType, Integer.valueOf(this.byteCount), Long.valueOf(this.duration) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/metrics/ByteThroughputProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */