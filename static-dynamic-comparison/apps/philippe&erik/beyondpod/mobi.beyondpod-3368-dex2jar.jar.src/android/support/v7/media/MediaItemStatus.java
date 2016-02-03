package android.support.v7.media;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;

public final class MediaItemStatus
{
  public static final String EXTRA_HTTP_RESPONSE_HEADERS = "android.media.status.extra.HTTP_RESPONSE_HEADERS";
  public static final String EXTRA_HTTP_STATUS_CODE = "android.media.status.extra.HTTP_STATUS_CODE";
  private static final String KEY_CONTENT_DURATION = "contentDuration";
  private static final String KEY_CONTENT_POSITION = "contentPosition";
  private static final String KEY_EXTRAS = "extras";
  private static final String KEY_PLAYBACK_STATE = "playbackState";
  private static final String KEY_TIMESTAMP = "timestamp";
  public static final int PLAYBACK_STATE_BUFFERING = 3;
  public static final int PLAYBACK_STATE_CANCELED = 5;
  public static final int PLAYBACK_STATE_ERROR = 7;
  public static final int PLAYBACK_STATE_FINISHED = 4;
  public static final int PLAYBACK_STATE_INVALIDATED = 6;
  public static final int PLAYBACK_STATE_PAUSED = 2;
  public static final int PLAYBACK_STATE_PENDING = 0;
  public static final int PLAYBACK_STATE_PLAYING = 1;
  private final Bundle mBundle;
  
  private MediaItemStatus(Bundle paramBundle)
  {
    this.mBundle = paramBundle;
  }
  
  public static MediaItemStatus fromBundle(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return new MediaItemStatus(paramBundle);
    }
    return null;
  }
  
  private static String playbackStateToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Integer.toString(paramInt);
    case 0: 
      return "pending";
    case 3: 
      return "buffering";
    case 1: 
      return "playing";
    case 2: 
      return "paused";
    case 4: 
      return "finished";
    case 5: 
      return "canceled";
    case 6: 
      return "invalidated";
    }
    return "error";
  }
  
  public Bundle asBundle()
  {
    return this.mBundle;
  }
  
  public long getContentDuration()
  {
    return this.mBundle.getLong("contentDuration", -1L);
  }
  
  public long getContentPosition()
  {
    return this.mBundle.getLong("contentPosition", -1L);
  }
  
  public Bundle getExtras()
  {
    return this.mBundle.getBundle("extras");
  }
  
  public int getPlaybackState()
  {
    return this.mBundle.getInt("playbackState", 7);
  }
  
  public long getTimestamp()
  {
    return this.mBundle.getLong("timestamp");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MediaItemStatus{ ");
    localStringBuilder.append("timestamp=");
    TimeUtils.formatDuration(SystemClock.elapsedRealtime() - getTimestamp(), localStringBuilder);
    localStringBuilder.append(" ms ago");
    localStringBuilder.append(", playbackState=").append(playbackStateToString(getPlaybackState()));
    localStringBuilder.append(", contentPosition=").append(getContentPosition());
    localStringBuilder.append(", contentDuration=").append(getContentDuration());
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
      setPlaybackState(paramInt);
    }
    
    public Builder(MediaItemStatus paramMediaItemStatus)
    {
      if (paramMediaItemStatus == null) {
        throw new IllegalArgumentException("status must not be null");
      }
      this.mBundle = new Bundle(paramMediaItemStatus.mBundle);
    }
    
    public MediaItemStatus build()
    {
      return new MediaItemStatus(this.mBundle, null);
    }
    
    public Builder setContentDuration(long paramLong)
    {
      this.mBundle.putLong("contentDuration", paramLong);
      return this;
    }
    
    public Builder setContentPosition(long paramLong)
    {
      this.mBundle.putLong("contentPosition", paramLong);
      return this;
    }
    
    public Builder setExtras(Bundle paramBundle)
    {
      this.mBundle.putBundle("extras", paramBundle);
      return this;
    }
    
    public Builder setPlaybackState(int paramInt)
    {
      this.mBundle.putInt("playbackState", paramInt);
      return this;
    }
    
    public Builder setTimestamp(long paramLong)
    {
      this.mBundle.putLong("timestamp", paramLong);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/media/MediaItemStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */