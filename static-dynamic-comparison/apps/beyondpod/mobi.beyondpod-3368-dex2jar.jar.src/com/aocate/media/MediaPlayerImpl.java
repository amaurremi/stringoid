package com.aocate.media;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public abstract class MediaPlayerImpl
{
  private static final String MPI_TAG = "AocateMediaPlayerImpl";
  protected ReentrantLock lockMuteOnPreparedCount = new ReentrantLock();
  protected ReentrantLock lockMuteOnSeekCount = new ReentrantLock();
  protected final Context mContext;
  protected int muteOnPreparedCount = 0;
  protected int muteOnSeekCount = 0;
  protected final MediaPlayer owningMediaPlayer;
  
  public MediaPlayerImpl(MediaPlayer paramMediaPlayer, Context paramContext)
  {
    this.owningMediaPlayer = paramMediaPlayer;
    this.mContext = paramContext;
  }
  
  public abstract boolean canSetPitch();
  
  public abstract boolean canSetSpeed();
  
  public abstract float getCurrentPitchStepsAdjustment();
  
  public abstract int getCurrentPosition();
  
  public abstract float getCurrentSpeedMultiplier();
  
  public abstract int getDuration();
  
  public abstract float getMaxSpeedMultiplier();
  
  public abstract float getMinSpeedMultiplier();
  
  public abstract boolean isLooping();
  
  public abstract boolean isPlaying();
  
  public void muteNextOnPrepare()
  {
    this.lockMuteOnPreparedCount.lock();
    Log.d("AocateMediaPlayerImpl", "muteNextOnPrepare()");
    try
    {
      this.muteOnPreparedCount += 1;
      return;
    }
    finally
    {
      this.lockMuteOnPreparedCount.unlock();
    }
  }
  
  public void muteNextSeek()
  {
    this.lockMuteOnSeekCount.lock();
    Log.d("AocateMediaPlayerImpl", "muteNextOnSeek()");
    try
    {
      this.muteOnSeekCount += 1;
      return;
    }
    finally
    {
      this.lockMuteOnSeekCount.unlock();
    }
  }
  
  public abstract void pause();
  
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
  
  public abstract void setEnableSpeedAdjustment(boolean paramBoolean);
  
  public abstract void setLooping(boolean paramBoolean);
  
  public abstract void setPitchStepsAdjustment(float paramFloat);
  
  public abstract void setPlaybackPitch(float paramFloat);
  
  public abstract void setPlaybackSpeed(float paramFloat);
  
  public abstract void setSpeedAdjustmentAlgorithm(int paramInt);
  
  public abstract void setVolume(float paramFloat1, float paramFloat2);
  
  public abstract void setWakeMode(Context paramContext, int paramInt);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/aocate/media/MediaPlayerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */