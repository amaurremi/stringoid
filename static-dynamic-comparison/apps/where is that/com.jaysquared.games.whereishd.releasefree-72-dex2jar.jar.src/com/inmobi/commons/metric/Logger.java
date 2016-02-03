package com.inmobi.commons.metric;

public class Logger
{
  private MetricConfigParams a = new MetricConfigParams();
  private Integer b = Integer.valueOf(2147483646);
  private Storage c = null;
  private Queuer d = new Queuer();
  private MetricsCallback e = null;
  
  public Logger(int paramInt, String paramString)
  {
    this.c = new Storage(paramInt, paramString, this.d, this.a);
  }
  
  public Logger(int paramInt, String paramString, Storage.PreProcessor paramPreProcessor)
  {
    this.c = new Storage(paramInt, paramString, this.d, this.a, paramPreProcessor);
  }
  
  protected void finalize()
    throws Throwable
  {
    this.c.saveToLatest();
    super.finalize();
  }
  
  public void logEvent(EventLog paramEventLog)
  {
    this.c.readNumberOfEventsAndTimeStampFromPersistent();
    if (this.e != null) {
      this.e.dataCollected(paramEventLog);
    }
    this.d.log(paramEventLog);
    if (this.d.a() >= this.a.getDumpThreshhold()) {
      this.c.saveLocalCache();
    }
    if ((this.c.getEvents() >= this.a.getMaxInQueue()) || (this.c.getTimestamp() + this.a.getNextRetryInterval() <= System.currentTimeMillis() / 1000L)) {
      new Thread(new a()).start();
    }
  }
  
  public void setCallback(MetricsCallback paramMetricsCallback)
  {
    this.e = paramMetricsCallback;
    this.c.setCallback(paramMetricsCallback);
  }
  
  public void setMetricConfigParams(MetricConfigParams paramMetricConfigParams)
  {
    if (paramMetricConfigParams != null)
    {
      this.a = paramMetricConfigParams;
      this.c.a = paramMetricConfigParams;
    }
  }
  
  public boolean startNewSample()
  {
    synchronized (this.b)
    {
      Integer localInteger2 = this.b;
      this.b = Integer.valueOf(this.b.intValue() + 1);
      if (this.b.intValue() >= this.a.getSamplingFactor())
      {
        this.b = Integer.valueOf(0);
        return true;
      }
      return false;
    }
  }
  
  public static abstract interface MetricsCallback
  {
    public abstract void dataCollected(EventLog paramEventLog);
    
    public abstract void movedMetricDataToFileMemory(String paramString);
    
    public abstract void reportingFailure();
    
    public abstract void reportingStartedWithRequest(String paramString);
    
    public abstract void reportingSuccess();
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      Logger.a(Logger.this).sendFile();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/metric/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */