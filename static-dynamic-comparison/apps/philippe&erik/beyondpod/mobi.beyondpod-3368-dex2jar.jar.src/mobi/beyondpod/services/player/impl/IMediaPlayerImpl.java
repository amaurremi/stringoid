package mobi.beyondpod.services.player.impl;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import java.util.Date;

public abstract interface IMediaPlayerImpl
{
  public static final int PLAYER_TYPE_3RD_PARTY = 1;
  public static final int PLAYER_TYPE_ANDROID = 0;
  public static final int PLAYER_TYPE_CHROMECAST = 5;
  public static final int PLAYER_TYPE_MPG123 = 4;
  public static final int PLAYER_TYPE_SONIC = 3;
  public static final int PLAYER_TYPE_TRACK_BACKED = 2;
  public static final int PLAYER_TYPE_UNKNOWN = -1;
  
  public abstract boolean canSetPitch();
  
  public abstract boolean canSetSpeed();
  
  public abstract int getCurrentPosition();
  
  public abstract float getCurrentSpeedMultiplier();
  
  public abstract int getDuration();
  
  public abstract boolean isPlaying();
  
  public abstract boolean isSpeedAlterationLibraryInstalled();
  
  public abstract void pause();
  
  public abstract int playerType();
  
  public abstract void prepare()
    throws IllegalStateException, IOException;
  
  public abstract void prepareAsync();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(int paramInt)
    throws IllegalStateException;
  
  public abstract void setAudioStreamType(int paramInt);
  
  public abstract void setDataSource(Context paramContext, Uri paramUri)
    throws IllegalArgumentException, IllegalStateException, IOException;
  
  public abstract void setDataSource(String paramString)
    throws IllegalArgumentException, IllegalStateException, IOException;
  
  public abstract void setDataSource(TrackMetadata paramTrackMetadata)
    throws IllegalArgumentException, IllegalStateException, IOException;
  
  public abstract void setOnBufferingUpdateListener(OnBufferingUpdateListener paramOnBufferingUpdateListener);
  
  public abstract void setOnCompletionListener(OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnErrorListener(OnErrorListener paramOnErrorListener);
  
  public abstract void setOnInfoListener(OnInfoListener paramOnInfoListener);
  
  public abstract void setOnPreparedListener(OnPreparedListener paramOnPreparedListener);
  
  public abstract void setOnSeekCompleteListener(OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void setPlaybackPitch(float paramFloat);
  
  public abstract void setPlaybackSpeed(float paramFloat);
  
  public abstract void setVolume(float paramFloat1, float paramFloat2);
  
  public abstract void setVolumeBoost(float paramFloat);
  
  public abstract void setWakeMode(Context paramContext, int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract boolean supportsFileFormatFor(String paramString1, String paramString2);
  
  public abstract boolean supportsSpeedAlteration();
  
  public static abstract interface OnBufferingUpdateListener
  {
    public abstract void onBufferingUpdate(IMediaPlayerImpl paramIMediaPlayerImpl, int paramInt);
  }
  
  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion(IMediaPlayerImpl paramIMediaPlayerImpl);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract boolean onError(IMediaPlayerImpl paramIMediaPlayerImpl, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnInfoListener
  {
    public abstract boolean onInfo(IMediaPlayerImpl paramIMediaPlayerImpl, int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnPreparedListener
  {
    public abstract void onPrepared(IMediaPlayerImpl paramIMediaPlayerImpl);
  }
  
  public static abstract interface OnSeekCompleteListener
  {
    public abstract void onSeekComplete(IMediaPlayerImpl paramIMediaPlayerImpl);
  }
  
  public static class TrackMetadata
  {
    public String FeedName;
    public String MimeType;
    public Date TrackDate;
    public String TrackImageUrl;
    public String TrackName;
    public String TrackURL;
    
    public TrackMetadata(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Date paramDate)
    {
      this.TrackURL = paramString1;
      this.TrackName = paramString2;
      this.MimeType = paramString3;
      this.TrackImageUrl = paramString4;
      this.FeedName = paramString5;
      this.TrackDate = paramDate;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/impl/IMediaPlayerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */