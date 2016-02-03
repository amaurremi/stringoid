package com.amazonaws.metrics;

public class SimpleThroughputMetricType
  extends SimpleServiceMetricType
  implements ThroughputMetricType
{
  private final ServiceMetricType byteCountMetricType;
  
  public SimpleThroughputMetricType(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2);
    this.byteCountMetricType = new SimpleServiceMetricType(paramString3, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/metrics/SimpleThroughputMetricType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */