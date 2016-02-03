package com.getjar.sdk.data.usage;

import java.util.Locale;

public class AggregateUsageRecord
{
  private final String _packageName;
  private long _timestampStart;
  private long _timestampStop;
  private int _totalSessionsCount;
  private int _totalUseDuration;
  
  protected AggregateUsageRecord(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this._packageName = paramString;
    this._timestampStart = paramLong1;
    this._timestampStop = paramLong2;
    this._totalUseDuration = paramInt1;
    this._totalSessionsCount = paramInt2;
  }
  
  public String getPackageName()
  {
    return this._packageName;
  }
  
  public long getTimestampStart()
  {
    return this._timestampStart;
  }
  
  public long getTimestampStop()
  {
    return this._timestampStop;
  }
  
  public int getTotalSessionsCount()
  {
    return this._totalSessionsCount;
  }
  
  public int getTotalUseDuration()
  {
    return this._totalUseDuration;
  }
  
  protected void setTimestampStart(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("'timestampStart' cannot be negative");
    }
    this._timestampStart = paramLong;
  }
  
  protected void setTimestampStop(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("'timestampStop' cannot be negative");
    }
    this._timestampStop = paramLong;
  }
  
  protected void setTotalSessionsCount(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("'totalSessionsCount' cannot be negative");
    }
    this._totalSessionsCount = paramInt;
  }
  
  protected void setTotalUseDuration(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("'totalUseDuration' cannot be negative");
    }
    this._totalUseDuration = paramInt;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "[packageName:%1$s sessions:%2$d duration:%3$d start:%4$d stop:%5$d]", new Object[] { this._packageName, Integer.valueOf(this._totalSessionsCount), Integer.valueOf(this._totalUseDuration), Long.valueOf(this._timestampStart), Long.valueOf(this._timestampStop) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/usage/AggregateUsageRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */