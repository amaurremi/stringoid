package com.getjar.sdk.data.usage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AggregateUsageReport
{
  private final List<AggregateUsageRecord> _records;
  private final long _timestampStart;
  private final long _timestampStop;
  
  protected AggregateUsageReport(long paramLong1, long paramLong2, List<AggregateUsageRecord> paramList)
  {
    this._timestampStart = paramLong1;
    this._timestampStop = paramLong2;
    this._records = Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public List<AggregateUsageRecord> getRecords()
  {
    return this._records;
  }
  
  public long getTimestampStart()
  {
    return this._timestampStart;
  }
  
  public long getTimestampStop()
  {
    return this._timestampStop;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/usage/AggregateUsageReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */