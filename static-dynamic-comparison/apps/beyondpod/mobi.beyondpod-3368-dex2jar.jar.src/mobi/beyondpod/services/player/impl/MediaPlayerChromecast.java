package mobi.beyondpod.services.player.impl;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class MediaPlayerChromecast
  implements IMediaPlayerImpl
{
  private static final String TAG = MediaPlayerChromecast.class.getSimpleName();
  ChromecastPlayer _MediaPlayer;
  
  public MediaPlayerChromecast(Context paramContext)
  {
    CoreHelper.WriteTraceEntry(TAG, "Created Chromecast MediaPlayer");
    this._MediaPlayer = new ChromecastPlayer(paramContext);
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
    return this._MediaPlayer.getCurrentPosition();
  }
  
  public float getCurrentSpeedMultiplier()
  {
    return 1.0F;
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
    return 5;
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
    throw new IllegalArgumentException("Use setDataSource(TrackMetadata)");
  }
  
  public void setDataSource(IMediaPlayerImpl.TrackMetadata paramTrackMetadata)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    this._MediaPlayer.setDataSource(paramTrackMetadata);
  }
  
  public void setOnBufferingUpdateListener(final IMediaPlayerImpl.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    if (paramOnBufferingUpdateListener != null)
    {
      this._MediaPlayer.setOnBufferingUpdateListener(new ChromecastPlayer.OnBufferingUpdateListener()
      {
        public void onBufferingUpdate(ChromecastPlayer paramAnonymousChromecastPlayer, int paramAnonymousInt)
        {
          paramOnBufferingUpdateListener.onBufferingUpdate(MediaPlayerChromecast.this, paramAnonymousInt);
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
      this._MediaPlayer.setOnCompletionListener(new ChromecastPlayer.OnCompletionListener()
      {
        public void onCompletion(ChromecastPlayer paramAnonymousChromecastPlayer)
        {
          paramOnCompletionListener.onCompletion(MediaPlayerChromecast.this);
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
      this._MediaPlayer.setOnErrorListener(new ChromecastPlayer.OnErrorListener()
      {
        public boolean onError(ChromecastPlayer paramAnonymousChromecastPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return paramOnErrorListener.onError(MediaPlayerChromecast.this, paramAnonymousInt1, paramAnonymousInt2);
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
      this._MediaPlayer.setOnInfoListener(new ChromecastPlayer.OnInfoListener()
      {
        public boolean onInfo(ChromecastPlayer paramAnonymousChromecastPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return paramOnInfoListener.onInfo(MediaPlayerChromecast.this, paramAnonymousInt1, paramAnonymousInt2);
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
      this._MediaPlayer.setOnPreparedListener(new ChromecastPlayer.OnPreparedListener()
      {
        public void onPrepared(ChromecastPlayer paramAnonymousChromecastPlayer)
        {
          paramOnPreparedListener.onPrepared(MediaPlayerChromecast.this);
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
      this._MediaPlayer.setOnSeekCompleteListener(new ChromecastPlayer.OnSeekCompleteListener()
      {
        public void onSeekComplete(ChromecastPlayer paramAnonymousChromecastPlayer)
        {
          paramOnSeekCompleteListener.onSeekComplete(MediaPlayerChromecast.this);
        }
      });
      return;
    }
    this._MediaPlayer.setOnSeekCompleteListener(null);
  }
  
  public void setPlaybackPitch(float paramFloat) {}
  
  public void setPlaybackSpeed(float paramFloat) {}
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this._MediaPlayer.setVolume(paramFloat1, paramFloat2);
  }
  
  public void setVolumeBoost(float paramFloat) {}
  
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
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/impl/MediaPlayerChromecast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */