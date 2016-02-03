package com.getjar.sdk.utilities;

public class ManualResetEvent
{
  private final Object monitor = new Object();
  private volatile boolean open = false;
  
  public ManualResetEvent(boolean paramBoolean)
  {
    this.open = paramBoolean;
  }
  
  public void close()
  {
    this.open = false;
  }
  
  public void open()
  {
    synchronized (this.monitor)
    {
      this.open = true;
      this.monitor.notifyAll();
      return;
    }
  }
  
  public void waitForOpen()
    throws InterruptedException
  {
    synchronized (this.monitor)
    {
      if (!this.open) {
        this.monitor.wait();
      }
    }
  }
  
  public void waitForOpen(long paramLong)
    throws InterruptedException
  {
    synchronized (this.monitor)
    {
      if (!this.open) {
        this.monitor.wait(paramLong);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/ManualResetEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */