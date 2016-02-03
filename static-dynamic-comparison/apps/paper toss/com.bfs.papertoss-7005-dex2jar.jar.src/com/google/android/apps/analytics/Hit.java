package com.google.android.apps.analytics;

public class Hit
{
  final long hitId;
  final String hitString;
  
  Hit(String paramString, long paramLong)
  {
    this.hitString = paramString;
    this.hitId = paramLong;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/android/apps/analytics/Hit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */