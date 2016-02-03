package mobi.beyondpod.services.player.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.aocate.media.MediaPlayer;
import com.aocate.media.MediaPlayer.OnBufferingUpdateListener;
import com.aocate.media.MediaPlayer.OnCompletionListener;
import com.aocate.media.MediaPlayer.OnErrorListener;
import com.aocate.media.MediaPlayer.OnInfoListener;
import com.aocate.media.MediaPlayer.OnPreparedListener;
import com.aocate.media.MediaPlayer.OnSeekCompleteListener;
import java.io.IOException;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class MediaPlayerOSPlay
  implements IMediaPlayerImpl
{
  private static final int DELAY_WARNING = 1500;
  private static final String TAG = MediaPlayerOSPlay.class.getSimpleName();
  Runnable _GetCurrentPositionRunnable = new Runnable()
  {
    public void run()
    {
      try
      {
        long l = System.currentTimeMillis();
        MediaPlayerOSPlay.this._LastPosition = MediaPlayerOSPlay.this._MediaPlayer.getCurrentPosition();
        l = System.currentTimeMillis() - l;
        if (l > 1500L) {
          CoreHelper.WriteTraceEntry(MediaPlayerOSPlay.TAG, "Unusual delay executing getCurrentPosition() :" + l + " ms.");
        }
        return;
      }
      catch (Exception localException)
      {
        CoreHelper.LogException(MediaPlayerOSPlay.TAG, "OSPlay getCurrentPosition failed", localException);
      }
    }
  };
  Runnable _GetDurationRunnable = new Runnable()
  {
    public void run()
    {
      try
      {
        long l = System.currentTimeMillis();
        MediaPlayerOSPlay.this._LastDuration = MediaPlayerOSPlay.this._MediaPlayer.getDuration();
        l = System.currentTimeMillis() - l;
        if (l > 1500L) {
          CoreHelper.WriteTraceEntry(MediaPlayerOSPlay.TAG, "Unusual delay executing getDuration() :" + l + " ms.");
        }
        return;
      }
      catch (Exception localException)
      {
        CoreHelper.LogException(MediaPlayerOSPlay.TAG, "OSPlay getDuration failed", localException);
      }
    }
  };
  boolean _IsPlaying = false;
  Runnable _IsPlayingRunnable = new Runnable()
  {
    public void run()
    {
      try
      {
        long l = System.currentTimeMillis();
        MediaPlayerOSPlay.this._IsPlaying = MediaPlayerOSPlay.this._MediaPlayer.isPlaying();
        l = System.currentTimeMillis() - l;
        if (l > 1500L) {
          CoreHelper.WriteTraceEntry(MediaPlayerOSPlay.TAG, "Unusual delay executing isPlaying() :" + l + " ms.");
        }
        return;
      }
      catch (Exception localException)
      {
        CoreHelper.LogException(MediaPlayerOSPlay.TAG, "OSPlay IsPlaying failed", localException);
      }
    }
  };
  private int _LastDuration = -1;
  private long _LastDurationCheck;
  private float _LastMultiplier = 1.0F;
  private int _LastPosition = 0;
  private int _LastSeekPos;
  private MediaPlayer _MediaPlayer;
  Runnable _PauseRunnable = new Runnable()
  {
    public void run()
    {
      try
      {
        long l = System.currentTimeMillis();
        MediaPlayerOSPlay.this._MediaPlayer.pause();
        l = System.currentTimeMillis() - l;
        if (l > 1500L) {
          CoreHelper.WriteTraceEntry(MediaPlayerOSPlay.TAG, "Unusual delay executing Pause() :" + l + " ms.");
        }
        return;
      }
      catch (Exception localException)
      {
        CoreHelper.WriteLogEntryInProduction(MediaPlayerOSPlay.TAG, "OSPlay pause failed! Reason: " + localException.getMessage());
      }
    }
  };
  Runnable _SeekRunnable = new Runnable()
  {
    public void run()
    {
      try
      {
        long l = System.currentTimeMillis();
        MediaPlayerOSPlay.this._MediaPlayer.seekTo(MediaPlayerOSPlay.this._LastSeekPos);
        l = System.currentTimeMillis() - l;
        if (l > 1500L) {
          CoreHelper.WriteTraceEntry(MediaPlayerOSPlay.TAG, "Unusual delay executing seekTo() :" + l + " ms.");
        }
        return;
      }
      catch (Exception localException)
      {
        CoreHelper.LogException(MediaPlayerOSPlay.TAG, "OSPlay setPlaybackSpeed failed", localException);
      }
    }
  };
  Runnable _SetPlaybackSpeedRunnable = new Runnable()
  {
    public void run()
    {
      try
      {
        long l = System.currentTimeMillis();
        MediaPlayerOSPlay.this._MediaPlayer.setPlaybackSpeed(MediaPlayerOSPlay.this._LastMultiplier);
        l = System.currentTimeMillis() - l;
        if (l > 1500L) {
          CoreHelper.WriteTraceEntry(MediaPlayerOSPlay.TAG, "Unusual delay executing setPlaybackSpeed() :" + l + " ms.");
        }
        return;
      }
      catch (Exception localException)
      {
        CoreHelper.LogException(MediaPlayerOSPlay.TAG, "OSPlay setPlaybackSpeed failed", localException);
      }
    }
  };
  private PrestoWorker _Worker = new PrestoWorker(null);
  
  public MediaPlayerOSPlay(Context paramContext)
  {
    CoreHelper.WriteTraceEntry(TAG, "Created OSPlay MediaPlayer");
    this._MediaPlayer = new MediaPlayer(paramContext);
    this._Worker.setName("Presto Worker Thread");
    this._Worker.setPriority(10);
    this._Worker.start();
    for (;;)
    {
      if (this._Worker._IsReady) {
        return;
      }
      try
      {
        Thread.sleep(10L);
      }
      catch (InterruptedException paramContext) {}
    }
  }
  
  public Handler PrestoHandler()
  {
    return this._Worker.workerHandler;
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
    PrestoHandler().removeCallbacks(this._GetCurrentPositionRunnable);
    PrestoHandler().post(this._GetCurrentPositionRunnable);
    return this._LastPosition;
  }
  
  public float getCurrentSpeedMultiplier()
  {
    return this._LastMultiplier;
  }
  
  public int getDuration()
  {
    if (this._LastDuration < 0) {
      this._GetDurationRunnable.run();
    }
    for (;;)
    {
      return this._LastDuration;
      if (System.currentTimeMillis() - this._LastDurationCheck > 5000L)
      {
        PrestoHandler().removeCallbacks(this._GetDurationRunnable);
        PrestoHandler().post(this._GetDurationRunnable);
      }
    }
  }
  
  public boolean isPlaying()
  {
    PrestoHandler().removeCallbacks(this._IsPlayingRunnable);
    PrestoHandler().post(this._IsPlayingRunnable);
    return this._IsPlaying;
  }
  
  public boolean isSpeedAlterationLibraryInstalled()
  {
    try
    {
      boolean bool = this._MediaPlayer.isPrestoLibraryInstalled();
      return bool;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException(TAG, "OSPlay isPrestoLibraryInstalled failed", localException);
    }
    return false;
  }
  
  public void pause()
  {
    this._IsPlaying = false;
    PrestoHandler().removeCallbacks(this._PauseRunnable);
    PrestoHandler().post(this._PauseRunnable);
  }
  
  public int playerType()
  {
    return 1;
  }
  
  public void prepare()
    throws IllegalStateException, IOException
  {
    try
    {
      this._LastDurationCheck = -1L;
      this._MediaPlayer.prepare();
      return;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException(TAG, "OSPlay prepare failed", localException);
    }
  }
  
  public void prepareAsync()
  {
    try
    {
      this._LastDurationCheck = -1L;
      this._MediaPlayer.prepareAsync();
      return;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException(TAG, "OSPlay prepareAsync failed", localException);
    }
  }
  
  public void release()
  {
    try
    {
      this._MediaPlayer.release();
      return;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException(TAG, "OSPlay release failed", localException);
    }
  }
  
  public void reset()
  {
    try
    {
      this._MediaPlayer.reset();
      return;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException(TAG, "OSPlay reset failed", localException);
    }
  }
  
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    this._LastSeekPos = paramInt;
    PrestoHandler().removeCallbacks(this._SeekRunnable);
    PrestoHandler().post(this._SeekRunnable);
  }
  
  public void setAudioStreamType(int paramInt)
  {
    try
    {
      this._MediaPlayer.setAudioStreamType(paramInt);
      return;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException(TAG, "OSPlay setAudioStreamType failed", localException);
    }
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
          paramOnBufferingUpdateListener.onBufferingUpdate(MediaPlayerOSPlay.this, paramAnonymousInt);
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
          paramOnCompletionListener.onCompletion(MediaPlayerOSPlay.this);
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
          return paramOnErrorListener.onError(MediaPlayerOSPlay.this, paramAnonymousInt1, paramAnonymousInt2);
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
          return paramOnInfoListener.onInfo(MediaPlayerOSPlay.this, paramAnonymousInt1, paramAnonymousInt2);
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
          paramOnPreparedListener.onPrepared(MediaPlayerOSPlay.this);
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
          paramOnSeekCompleteListener.onSeekComplete(MediaPlayerOSPlay.this);
        }
      });
      return;
    }
    this._MediaPlayer.setOnSeekCompleteListener(null);
  }
  
  public void setPlaybackPitch(float paramFloat) {}
  
  public void setPlaybackSpeed(float paramFloat)
  {
    this._LastMultiplier = paramFloat;
    PrestoHandler().removeCallbacks(this._SetPlaybackSpeedRunnable);
    PrestoHandler().post(this._SetPlaybackSpeedRunnable);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    try
    {
      this._MediaPlayer.setVolume(paramFloat1, paramFloat2);
      return;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException(TAG, "OSPlay setVolume failed", localException);
    }
  }
  
  public void setVolumeBoost(float paramFloat) {}
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    try
    {
      this._MediaPlayer.setWakeMode(paramContext, paramInt);
      return;
    }
    catch (Exception paramContext)
    {
      CoreHelper.LogException(TAG, "OSPlay setWakeMode failed", paramContext);
    }
  }
  
  public void start()
  {
    try
    {
      this._IsPlaying = true;
      this._MediaPlayer.start();
      return;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException(TAG, "OSPlay start failed", localException);
    }
  }
  
  public void stop()
  {
    try
    {
      this._MediaPlayer.stop();
      return;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException(TAG, "OSPlay stop failed", localException);
    }
  }
  
  public boolean supportsFileFormatFor(String paramString1, String paramString2)
  {
    return true;
  }
  
  public boolean supportsSpeedAlteration()
  {
    return isSpeedAlterationLibraryInstalled();
  }
  
  private static class PrestoWorker
    extends Thread
  {
    private volatile boolean _IsReady = false;
    private Handler workerHandler;
    
    public void run()
    {
      Looper.prepare();
      this.workerHandler = new Handler();
      this._IsReady = true;
      Looper.loop();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/impl/MediaPlayerOSPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */