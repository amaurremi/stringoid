package mobi.beyondpod.services.player.impl;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.services.player.PlayList;

public class MediaPlayerTrackBacked
  implements IMediaPlayerImpl
{
  private static final String TAG = MediaPlayerTrackBacked.class.getSimpleName();
  Context _Context;
  Track _CurrentTrack;
  
  public MediaPlayerTrackBacked(Context paramContext, Track paramTrack)
  {
    CoreHelper.WriteTraceEntry(TAG, "Created TrackBacked MediaPlayer");
    this._CurrentTrack = paramTrack;
    this._Context = paramContext;
  }
  
  public boolean canSetPitch()
  {
    return false;
  }
  
  public boolean canSetSpeed()
  {
    return false;
  }
  
  public int getCurrentPosition()
  {
    return (int)(this._CurrentTrack.getPlayedTime() * 1000L);
  }
  
  public float getCurrentSpeedMultiplier()
  {
    return 1.0F;
  }
  
  public int getDuration()
  {
    return (int)(this._CurrentTrack.getTotalTime() * 1000L);
  }
  
  public boolean isPlaying()
  {
    return false;
  }
  
  public boolean isSpeedAlterationLibraryInstalled()
  {
    return false;
  }
  
  public void pause() {}
  
  public int playerType()
  {
    return 2;
  }
  
  public void prepare()
    throws IllegalStateException, IOException
  {}
  
  public void prepareAsync() {}
  
  public void release() {}
  
  public void reset() {}
  
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    this._CurrentTrack.setPlayedTime(paramInt / 1000);
  }
  
  public void setAudioStreamType(int paramInt) {}
  
  public void setDataSource(Context paramContext, Uri paramUri)
    throws IllegalArgumentException, IllegalStateException, IOException
  {}
  
  public void setDataSource(String paramString)
    throws IllegalArgumentException, IllegalStateException, IOException
  {}
  
  public void setDataSource(IMediaPlayerImpl.TrackMetadata paramTrackMetadata)
    throws IllegalArgumentException, IllegalStateException, IOException
  {}
  
  public void setOnBufferingUpdateListener(IMediaPlayerImpl.OnBufferingUpdateListener paramOnBufferingUpdateListener) {}
  
  public void setOnCompletionListener(IMediaPlayerImpl.OnCompletionListener paramOnCompletionListener) {}
  
  public void setOnErrorListener(IMediaPlayerImpl.OnErrorListener paramOnErrorListener) {}
  
  public void setOnInfoListener(IMediaPlayerImpl.OnInfoListener paramOnInfoListener) {}
  
  public void setOnPreparedListener(IMediaPlayerImpl.OnPreparedListener paramOnPreparedListener) {}
  
  public void setOnSeekCompleteListener(IMediaPlayerImpl.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void setPlaybackPitch(float paramFloat) {}
  
  public void setPlaybackSpeed(float paramFloat) {}
  
  public void setVolume(float paramFloat1, float paramFloat2) {}
  
  public void setVolumeBoost(float paramFloat) {}
  
  public void setWakeMode(Context paramContext, int paramInt) {}
  
  public void start()
  {
    if (!PlayList.AllowStreaming(this._CurrentTrack))
    {
      CoreHelper.WriteTraceEntry(TAG, "Trying to play a streamed track when streaming is not allowed! Ignoring...");
      this._CurrentTrack.setCurrentPlayState(8);
      return;
    }
    BeyondPodApplication.GetInstance().StartVideoPlayback(this._CurrentTrack);
    CoreHelper.WriteTraceEntry(TAG, "=========> Mock Video Player - Started Playback of: " + this._CurrentTrack.getName());
  }
  
  public void stop() {}
  
  public boolean supportsFileFormatFor(String paramString1, String paramString2)
  {
    return true;
  }
  
  public boolean supportsSpeedAlteration()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/impl/MediaPlayerTrackBacked.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */