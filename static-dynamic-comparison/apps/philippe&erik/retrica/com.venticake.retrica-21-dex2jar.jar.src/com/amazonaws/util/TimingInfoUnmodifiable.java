package com.amazonaws.util;

import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
final class TimingInfoUnmodifiable
  extends TimingInfo
{
  TimingInfoUnmodifiable(Long paramLong1, long paramLong, Long paramLong2)
  {
    super(paramLong1, paramLong, paramLong2);
  }
  
  public TimingInfo endTiming()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/TimingInfoUnmodifiable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */