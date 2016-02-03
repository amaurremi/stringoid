package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;

class SendHitRateLimiter
  implements RateLimiter
{
  private long mLastTrackTime;
  private final int mMaxTokens;
  private final long mMillisecondsPerToken;
  private final Object mTokenLock = new Object();
  private double mTokens;
  
  public SendHitRateLimiter()
  {
    this(60, 2000L);
  }
  
  public SendHitRateLimiter(int paramInt, long paramLong)
  {
    this.mMaxTokens = paramInt;
    this.mTokens = this.mMaxTokens;
    this.mMillisecondsPerToken = paramLong;
  }
  
  @VisibleForTesting
  void setLastTrackTime(long paramLong)
  {
    this.mLastTrackTime = paramLong;
  }
  
  @VisibleForTesting
  void setTokensAvailable(long paramLong)
  {
    this.mTokens = paramLong;
  }
  
  public boolean tokenAvailable()
  {
    synchronized (this.mTokenLock)
    {
      long l = System.currentTimeMillis();
      if (this.mTokens < this.mMaxTokens)
      {
        double d = (l - this.mLastTrackTime) / this.mMillisecondsPerToken;
        if (d > 0.0D) {
          this.mTokens = Math.min(this.mMaxTokens, this.mTokens + d);
        }
      }
      this.mLastTrackTime = l;
      if (this.mTokens >= 1.0D)
      {
        this.mTokens -= 1.0D;
        return true;
      }
      Log.w("Excessive tracking detected.  Tracking call ignored.");
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/analytics/tracking/android/SendHitRateLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */