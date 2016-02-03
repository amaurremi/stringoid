package com.google.analytics.tracking.android;

import android.text.TextUtils;

class t
{
  private String kU;
  private final long kV;
  private final long kW;
  private String kX = "https:";
  
  t(String paramString, long paramLong1, long paramLong2)
  {
    this.kU = paramString;
    this.kV = paramLong1;
    this.kW = paramLong2;
  }
  
  String kb()
  {
    return this.kU;
  }
  
  long kc()
  {
    return this.kV;
  }
  
  long kd()
  {
    return this.kW;
  }
  
  String ke()
  {
    return this.kX;
  }
  
  void y(String paramString)
  {
    this.kU = paramString;
  }
  
  void z(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString.trim()))) {}
    while (!paramString.toLowerCase().startsWith("http:")) {
      return;
    }
    this.kX = "http:";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */