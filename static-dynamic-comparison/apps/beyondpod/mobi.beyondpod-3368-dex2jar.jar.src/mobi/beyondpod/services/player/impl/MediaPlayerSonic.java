package mobi.beyondpod.services.player.impl;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class MediaPlayerSonic
  implements IMediaPlayerImpl
{
  private static final String TAG = MediaPlayerSonic.class.getSimpleName();
  SonicPlayer _MediaPlayer;
  
  public MediaPlayerSonic(Context paramContext)
  {
    CoreHelper.WriteTraceEntry(TAG, "Created Sonic MediaPlayer");
    this._MediaPlayer = new SonicPlayer();
  }
  
  public boolean canSetPitch()
  {
    return true;
  }
  
  public boolean canSetSpeed()
  {
    return true;
  }
  
  public int getCurrentPosition()
  {
    return this._MediaPlayer.getCurrentPosition();
  }
  
  public float getCurrentSpeedMultiplier()
  {
    return this._MediaPlayer.getPlaybackSpeed();
  }
  
  public int getDuration()
  {
    return this._MediaPlayer.getDuration();
  }
  
  public boolean isPlaying()
  {
    return this._MediaPlayer.isPlaying();
  }
  
  public boolean isSpeedAlterationLibraryInstalled()
  {
    return CoreHelper.ApiLevel() > 15;
  }
  
  public void pause()
  {
    this._MediaPlayer.pause();
  }
  
  public int playerType()
  {
    return 3;
  }
  
  public void prepare()
    throws IllegalStateException, IOException
  {
    this._MediaPlayer.prepare();
  }
  
  public void prepareAsync()
  {
    this._MediaPlayer.prepareAsync();
  }
  
  public void release()
  {
    this._MediaPlayer.release();
  }
  
  public void reset()
  {
    this._MediaPlayer.reset();
  }
  
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    this._MediaPlayer.seekTo(paramInt);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    this._MediaPlayer.setAudioStreamType(paramInt);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
    throws IllegalArgumentException, IllegalStateException, IOException
  {}
  
  public void setDataSource(String paramString)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    this._MediaPlayer.setDataSource(paramString);
  }
  
  public void setDataSource(IMediaPlayerImpl.TrackMetadata paramTrackMetadata)
    throws IllegalArgumentException, IllegalStateException, IOException
  {}
  
  public void setOnBufferingUpdateListener(final IMediaPlayerImpl.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    if (paramOnBufferingUpdateListener != null)
    {
      this._MediaPlayer.setOnBufferingUpdateListener(new SonicPlayer.OnBufferingUpdateListener()
      {
        public void onBufferingUpdate(SonicPlayer paramAnonymousSonicPlayer, int paramAnonymousInt)
        {
          paramOnBufferingUpdateListener.onBufferingUpdate(MediaPlayerSonic.this, paramAnonymousInt);
        }
      });
      return;
    }
    this._MediaPlayer.setOnBufferingUpdateListener(null);
  }
  
  public void setOnCompletionListener(final IMediaPlayerImpl.OnCompletionListener paramOnCompletionListener)
  {
    if (paramOnCompletionListener != null)
    {
      this._MediaPlayer.setOnCompletionListener(new SonicPlayer.OnCompletionListener()
      {
        public void onCompletion(SonicPlayer paramAnonymousSonicPlayer)
        {
          paramOnCompletionListener.onCompletion(MediaPlayerSonic.this);
        }
      });
      return;
    }
    this._MediaPlayer.setOnCompletionListener(null);
  }
  
  public void setOnErrorListener(final IMediaPlayerImpl.OnErrorListener paramOnErrorListener)
  {
    if (paramOnErrorListener != null)
    {
      this._MediaPlayer.setOnErrorListener(new SonicPlayer.OnErrorListener()
      {
        public boolean onError(SonicPlayer paramAnonymousSonicPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return paramOnErrorListener.onError(MediaPlayerSonic.this, paramAnonymousInt1, paramAnonymousInt2);
        }
      });
      return;
    }
    this._MediaPlayer.setOnErrorListener(null);
  }
  
  public void setOnInfoListener(final IMediaPlayerImpl.OnInfoListener paramOnInfoListener)
  {
    if (paramOnInfoListener != null)
    {
      this._MediaPlayer.setOnInfoListener(new SonicPlayer.OnInfoListener()
      {
        public boolean onInfo(SonicPlayer paramAnonymousSonicPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return paramOnInfoListener.onInfo(MediaPlayerSonic.this, paramAnonymousInt1, paramAnonymousInt2);
        }
      });
      return;
    }
    this._MediaPlayer.setOnInfoListener(null);
  }
  
  public void setOnPreparedListener(final IMediaPlayerImpl.OnPreparedListener paramOnPreparedListener)
  {
    if (paramOnPreparedListener != null)
    {
      this._MediaPlayer.setOnPreparedListener(new SonicPlayer.OnPreparedListener()
      {
        public void onPrepared(SonicPlayer paramAnonymousSonicPlayer)
        {
          paramOnPreparedListener.onPrepared(MediaPlayerSonic.this);
        }
      });
      return;
    }
    this._MediaPlayer.setOnPreparedListener(null);
  }
  
  public void setOnSeekCompleteListener(final IMediaPlayerImpl.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    if (paramOnSeekCompleteListener != null)
    {
      this._MediaPlayer.setOnSeekCompleteListener(new SonicPlayer.OnSeekCompleteListener()
      {
        public void onSeekComplete(SonicPlayer paramAnonymousSonicPlayer)
        {
          paramOnSeekCompleteListener.onSeekComplete(MediaPlayerSonic.this);
        }
      });
      return;
    }
    this._MediaPlayer.setOnSeekCompleteListener(null);
  }
  
  public void setPlaybackPitch(float paramFloat)
  {
    this._MediaPlayer.setPitch(paramFloat);
  }
  
  public void setPlaybackSpeed(float paramFloat)
  {
    this._MediaPlayer.setPlaybackSpeed(paramFloat);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this._MediaPlayer.setVolume(paramFloat1, paramFloat2);
  }
  
  public void setVolumeBoost(float paramFloat)
  {
    this._MediaPlayer.setVolumeBoost(paramFloat);
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    this._MediaPlayer.setWakeMode(paramContext, paramInt);
  }
  
  public void start()
  {
    this._MediaPlayer.start();
  }
  
  public void stop()
  {
    this._MediaPlayer.stop();
  }
  
  public boolean supportsFileFormatFor(String paramString1, String paramString2)
  {
    return true;
  }
  
  public boolean supportsSpeedAlteration()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/impl/MediaPlayerSonic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */