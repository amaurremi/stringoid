package android.support.v7.media;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;

public final class MediaSessionStatus
{
  private static final String KEY_EXTRAS = "extras";
  private static final String KEY_QUEUE_PAUSED = "queuePaused";
  private static final String KEY_SESSION_STATE = "sessionState";
  private static final String KEY_TIMESTAMP = "timestamp";
  public static final int SESSION_STATE_ACTIVE = 0;
  public static final int SESSION_STATE_ENDED = 1;
  public static final int SESSION_STATE_INVALIDATED = 2;
  private final Bundle mBundle;
  
  private MediaSessionStatus(Bundle paramBundle)
  {
    this.mBundle = paramBundle;
  }
  
  public static MediaSessionStatus fromBundle(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return new MediaSessionStatus(paramBundle);
    }
    return null;
  }
  
  private static String sessionStateToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Integer.toString(paramInt);
    case 0: 
      return "active";
    case 1: 
      return "ended";
    }
    return "invalidated";
  }
  
  public Bundle asBundle()
  {
    return this.mBundle;
  }
  
  public Bundle getExtras()
  {
    return this.mBundle.getBundle("extras");
  }
  
  public int getSessionState()
  {
    return this.mBundle.getInt("sessionState", 2);
  }
  
  public long getTimestamp()
  {
    return this.mBundle.getLong("timestamp");
  }
  
  public boolean isQueuePaused()
  {
    return this.mBundle.getBoolean("queuePaused");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MediaSessionStatus{ ");
    localStringBuilder.append("timestamp=");
    TimeUtils.formatDuration(SystemClock.elapsedRealtime() - getTimestamp(), localStringBuilder);
    localStringBuilder.append(" ms ago");
    localStringBuilder.append(", sessionState=").append(sessionStateToString(getSessionState()));
    localStringBuilder.append(", queuePaused=").append(isQueuePaused());
    localStringBuilder.append(", extras=").append(getExtras());
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  public static final class Builder
  {
    private final Bundle mBundle;
    
    public Builder(int paramInt)
    {
      this.mBundle = new Bundle();
      setTimestamp(SystemClock.elapsedRealtime());
      setSessionState(paramInt);
    }
    
    public Builder(MediaSessionStatus paramMediaSessionStatus)
    {
      if (paramMediaSessionStatus == null) {
        throw new IllegalArgumentException("status must not be null");
      }
      this.mBundle = new Bundle(paramMediaSessionStatus.mBundle);
    }
    
    public MediaSessionStatus build()
    {
      return new MediaSessionStatus(this.mBundle, null);
    }
    
    public Builder setExtras(Bundle paramBundle)
    {
      this.mBundle.putBundle("extras", paramBundle);
      return this;
    }
    
    public Builder setQueuePaused(boolean paramBoolean)
    {
      this.mBundle.putBoolean("queuePaused", paramBoolean);
      return this;
    }
    
    public Builder setSessionState(int paramInt)
    {
      this.mBundle.putInt("sessionState", paramInt);
      return this;
    }
    
    public Builder setTimestamp(long paramLong)
    {
      this.mBundle.putLong("timestamp", paramLong);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/media/MediaSessionStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */