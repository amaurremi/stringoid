package com.google.analytics.tracking.android;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

abstract interface e
{
  public abstract void b(Map<String, String> paramMap);
  
  public abstract Thread getThread();
  
  public abstract void jn();
  
  public abstract void jp();
  
  public abstract LinkedBlockingQueue<Runnable> jq();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */