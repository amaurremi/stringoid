package com.google.android.gms.analytics;

import android.text.TextUtils;

class an
{
  private String pT;
  private final long pU;
  private final long pV;
  private String pW = "https:";
  
  an(String paramString, long paramLong1, long paramLong2)
  {
    this.pT = paramString;
    this.pU = paramLong1;
    this.pV = paramLong2;
  }
  
  void aj(String paramString)
  {
    this.pT = paramString;
  }
  
  void ak(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString.trim()))) {}
    while (!paramString.toLowerCase().startsWith("http:")) {
      return;
    }
    this.pW = "http:";
  }
  
  String lT()
  {
    return this.pT;
  }
  
  long lU()
  {
    return this.pU;
  }
  
  long lV()
  {
    return this.pV;
  }
  
  String lW()
  {
    return this.pW;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */