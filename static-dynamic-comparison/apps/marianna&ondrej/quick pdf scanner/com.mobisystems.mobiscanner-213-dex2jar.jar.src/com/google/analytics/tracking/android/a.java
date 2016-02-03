package com.google.analytics.tracking.android;

import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

abstract interface a
{
  public abstract void a(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList);
  
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract void ji();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */