package com.google.tagmanager;

import android.text.TextUtils;

class Hit
{
  private final long mHitFirstDispatchTime;
  private final long mHitId;
  private final long mHitTime;
  private String mHitUrl;
  
  Hit(long paramLong1, long paramLong2)
  {
    this.mHitId = paramLong1;
    this.mHitTime = paramLong2;
    this.mHitFirstDispatchTime = 0L;
  }
  
  Hit(long paramLong1, long paramLong2, long paramLong3)
  {
    this.mHitId = paramLong1;
    this.mHitTime = paramLong2;
    this.mHitFirstDispatchTime = paramLong3;
  }
  
  long getHitFirstDispatchTime()
  {
    return this.mHitFirstDispatchTime;
  }
  
  long getHitId()
  {
    return this.mHitId;
  }
  
  long getHitTime()
  {
    return this.mHitTime;
  }
  
  String getHitUrl()
  {
    return this.mHitUrl;
  }
  
  void setHitUrl(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString.trim()))) {
      return;
    }
    this.mHitUrl = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/Hit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */