package com.flurry.android;

public final class CallbackEvent
{
  public static final int ADS_LOADED_FROM_CACHE = 201;
  public static final int ADS_UPDATED = 202;
  public static final int ERROR_MARKET_LAUNCH = 101;
  private int a;
  private long b;
  private String c;
  
  CallbackEvent(int paramInt)
  {
    this.a = paramInt;
    this.b = System.currentTimeMillis();
  }
  
  public final String getMessage()
  {
    return this.c;
  }
  
  public final long getTimestamp()
  {
    return this.b;
  }
  
  public final int getType()
  {
    return this.a;
  }
  
  public final void setMessage(String paramString)
  {
    this.c = paramString;
  }
  
  public final void setTimestamp(long paramLong)
  {
    this.b = paramLong;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/CallbackEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */