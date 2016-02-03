package com.google.android.gms.analytics;

import com.google.android.gms.internal.di;
import java.util.List;
import java.util.Map;

abstract interface t
{
  public abstract void connect();
  
  public abstract void d(Map<String, String> paramMap, long paramLong, String paramString, List<di> paramList);
  
  public abstract void disconnect();
  
  public abstract void ld();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */