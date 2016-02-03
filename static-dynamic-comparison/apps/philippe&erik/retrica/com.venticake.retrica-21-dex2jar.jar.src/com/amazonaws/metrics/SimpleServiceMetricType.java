package com.amazonaws.metrics;

public class SimpleServiceMetricType
  extends SimpleMetricType
  implements ServiceMetricType
{
  private final String name;
  private final String serviceName;
  
  public SimpleServiceMetricType(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.serviceName = paramString2;
  }
  
  public String name()
  {
    return this.name;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/metrics/SimpleServiceMetricType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */