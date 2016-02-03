package com.google.android.apps.analytics;

class Referrer
{
  private final int index;
  private final String referrer;
  private final long timeStamp;
  private final int visit;
  
  Referrer(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    this.referrer = paramString;
    this.timeStamp = paramLong;
    this.visit = paramInt1;
    this.index = paramInt2;
  }
  
  int getIndex()
  {
    return this.index;
  }
  
  String getReferrerString()
  {
    return this.referrer;
  }
  
  long getTimeStamp()
  {
    return this.timeStamp;
  }
  
  int getVisit()
  {
    return this.visit;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/android/apps/analytics/Referrer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */