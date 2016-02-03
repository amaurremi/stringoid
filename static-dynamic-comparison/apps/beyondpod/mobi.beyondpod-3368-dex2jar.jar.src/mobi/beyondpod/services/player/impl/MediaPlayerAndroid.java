package mobi.beyondpod.services.player.impl;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.Uri;
import java.io.IOException;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class MediaPlayerAndroid
  implements IMediaPlayerImpl
{
  private static final String TAG = MediaPlayerAndroid.class.getSimpleName();
  MediaPlayer _MediaPlayer;
  
  public MediaPlayerAndroid(Context paramContext)
  {
    CoreHelper.WriteTraceEntry(TAG, "Created Android MediaPlayer");
    this._MediaPlayer = new MediaPlayer();
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
    return false;
  }
  
  public void pause()
  {
    this._MediaPlayer.pause();
  }
  
  public int playerType()
  {
    return 0;
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
  {
    this._MediaPlayer.setDataSource(paramContext, paramUri);
  }
  
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
      this._MediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener()
      {
        public void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
        {
          paramOnBufferingUpdateListener.onBufferingUpdate(MediaPlayerAndroid.this, paramAnonymousInt);
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
      this._MediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          paramOnCompletionListener.onCompletion(MediaPlayerAndroid.this);
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
      this._MediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return paramOnErrorListener.onError(MediaPlayerAndroid.this, paramAnonymousInt1, paramAnonymousInt2);
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
      this._MediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener()
      {
        public boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return paramOnInfoListener.onInfo(MediaPlayerAndroid.this, paramAnonymousInt1, paramAnonymousInt2);
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
      this._MediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
      {
        public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
        {
          paramOnPreparedListener.onPrepared(MediaPlayerAndroid.this);
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
      this._MediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener()
      {
        public void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
        {
          paramOnSeekCompleteListener.onSeekComplete(MediaPlayerAndroid.this);
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
    if (CoreHelper.IsCGBuild()) {
      this._MediaPlayer.seekTo(this._MediaPlayer.getCurrentPosition());
    }
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/impl/MediaPlayerAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */