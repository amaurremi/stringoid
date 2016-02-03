package com.aocate.media;

import android.content.Context;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class AndroidMediaPlayer
  extends MediaPlayerImpl
{
  private static final String AMP_TAG = "AocateAndroidMediaPlayer";
  android.media.MediaPlayer mp = null;
  private android.media.MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = new android.media.MediaPlayer.OnBufferingUpdateListener()
  {
    public void onBufferingUpdate(android.media.MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      if (AndroidMediaPlayer.this.owningMediaPlayer != null) {
        AndroidMediaPlayer.this.owningMediaPlayer.lock.lock();
      }
      try
      {
        if ((AndroidMediaPlayer.this.owningMediaPlayer.onBufferingUpdateListener != null) && (AndroidMediaPlayer.this.owningMediaPlayer.mpi == AndroidMediaPlayer.this)) {
          AndroidMediaPlayer.this.owningMediaPlayer.onBufferingUpdateListener.onBufferingUpdate(AndroidMediaPlayer.this.owningMediaPlayer, paramAnonymousInt);
        }
        return;
      }
      finally
      {
        AndroidMediaPlayer.this.owningMediaPlayer.lock.unlock();
      }
    }
  };
  private android.media.MediaPlayer.OnCompletionListener onCompletionListener = new android.media.MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(android.media.MediaPlayer paramAnonymousMediaPlayer)
    {
      Log.d("AocateAndroidMediaPlayer", "onCompletionListener being called");
      if (AndroidMediaPlayer.this.owningMediaPlayer != null) {
        AndroidMediaPlayer.this.owningMediaPlayer.lock.lock();
      }
      try
      {
        if (AndroidMediaPlayer.this.owningMediaPlayer.onCompletionListener != null) {
          AndroidMediaPlayer.this.owningMediaPlayer.onCompletionListener.onCompletion(AndroidMediaPlayer.this.owningMediaPlayer);
        }
        return;
      }
      finally
      {
        AndroidMediaPlayer.this.owningMediaPlayer.lock.unlock();
      }
    }
  };
  private android.media.MediaPlayer.OnErrorListener onErrorListener = new android.media.MediaPlayer.OnErrorListener()
  {
    public boolean onError(android.media.MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (AndroidMediaPlayer.this.owningMediaPlayer != null)
      {
        AndroidMediaPlayer.this.owningMediaPlayer.lock.lock();
        try
        {
          if (AndroidMediaPlayer.this.owningMediaPlayer.onErrorListener != null)
          {
            boolean bool = AndroidMediaPlayer.this.owningMediaPlayer.onErrorListener.onError(AndroidMediaPlayer.this.owningMediaPlayer, paramAnonymousInt1, paramAnonymousInt2);
            return bool;
          }
        }
        finally
        {
          AndroidMediaPlayer.this.owningMediaPlayer.lock.unlock();
        }
        AndroidMediaPlayer.this.owningMediaPlayer.lock.unlock();
      }
      return false;
    }
  };
  private android.media.MediaPlayer.OnInfoListener onInfoListener = new android.media.MediaPlayer.OnInfoListener()
  {
    public boolean onInfo(android.media.MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (AndroidMediaPlayer.this.owningMediaPlayer != null)
      {
        AndroidMediaPlayer.this.owningMediaPlayer.lock.lock();
        try
        {
          if ((AndroidMediaPlayer.this.owningMediaPlayer.onInfoListener != null) && (AndroidMediaPlayer.this.owningMediaPlayer.mpi == AndroidMediaPlayer.this))
          {
            boolean bool = AndroidMediaPlayer.this.owningMediaPlayer.onInfoListener.onInfo(AndroidMediaPlayer.this.owningMediaPlayer, paramAnonymousInt1, paramAnonymousInt2);
            return bool;
          }
        }
        finally
        {
          AndroidMediaPlayer.this.owningMediaPlayer.lock.unlock();
        }
        AndroidMediaPlayer.this.owningMediaPlayer.lock.unlock();
      }
      return false;
    }
  };
  private MediaPlayer.OnPreparedListener onPreparedListener = new MediaPlayer.OnPreparedListener()
  {
    /* Error */
    public void onPrepared(android.media.MediaPlayer paramAnonymousMediaPlayer)
    {
      // Byte code:
      //   0: ldc 22
      //   2: ldc 24
      //   4: invokestatic 30	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   7: pop
      //   8: aload_0
      //   9: getfield 14	com/aocate/media/AndroidMediaPlayer$5:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   12: getfield 34	com/aocate/media/AndroidMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
      //   15: ifnull +73 -> 88
      //   18: aload_0
      //   19: getfield 14	com/aocate/media/AndroidMediaPlayer$5:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   22: getfield 38	com/aocate/media/AndroidMediaPlayer:lockMuteOnPreparedCount	Ljava/util/concurrent/locks/ReentrantLock;
      //   25: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   28: aload_0
      //   29: getfield 14	com/aocate/media/AndroidMediaPlayer$5:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   32: getfield 47	com/aocate/media/AndroidMediaPlayer:muteOnPreparedCount	I
      //   35: ifle +54 -> 89
      //   38: aload_0
      //   39: getfield 14	com/aocate/media/AndroidMediaPlayer$5:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   42: astore_1
      //   43: aload_1
      //   44: aload_1
      //   45: getfield 47	com/aocate/media/AndroidMediaPlayer:muteOnPreparedCount	I
      //   48: iconst_1
      //   49: isub
      //   50: putfield 47	com/aocate/media/AndroidMediaPlayer:muteOnPreparedCount	I
      //   53: aload_0
      //   54: getfield 14	com/aocate/media/AndroidMediaPlayer$5:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   57: getfield 38	com/aocate/media/AndroidMediaPlayer:lockMuteOnPreparedCount	Ljava/util/concurrent/locks/ReentrantLock;
      //   60: invokevirtual 50	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   63: aload_0
      //   64: getfield 14	com/aocate/media/AndroidMediaPlayer$5:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   67: getfield 34	com/aocate/media/AndroidMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
      //   70: getfield 56	com/aocate/media/MediaPlayer:mpi	Lcom/aocate/media/MediaPlayerImpl;
      //   73: aload_0
      //   74: getfield 14	com/aocate/media/AndroidMediaPlayer$5:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   77: if_acmpeq +11 -> 88
      //   80: ldc 22
      //   82: ldc 58
      //   84: invokestatic 30	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   87: pop
      //   88: return
      //   89: aload_0
      //   90: getfield 14	com/aocate/media/AndroidMediaPlayer$5:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   93: iconst_0
      //   94: putfield 47	com/aocate/media/AndroidMediaPlayer:muteOnPreparedCount	I
      //   97: aload_0
      //   98: getfield 14	com/aocate/media/AndroidMediaPlayer$5:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   101: getfield 34	com/aocate/media/AndroidMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
      //   104: getfield 62	com/aocate/media/MediaPlayer:onPreparedListener	Lcom/aocate/media/MediaPlayer$OnPreparedListener;
      //   107: ifnull -54 -> 53
      //   110: ldc 22
      //   112: ldc 64
      //   114: invokestatic 30	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   117: pop
      //   118: aload_0
      //   119: getfield 14	com/aocate/media/AndroidMediaPlayer$5:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   122: getfield 34	com/aocate/media/AndroidMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
      //   125: getfield 62	com/aocate/media/MediaPlayer:onPreparedListener	Lcom/aocate/media/MediaPlayer$OnPreparedListener;
      //   128: aload_0
      //   129: getfield 14	com/aocate/media/AndroidMediaPlayer$5:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   132: getfield 34	com/aocate/media/AndroidMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
      //   135: invokeinterface 69 2 0
      //   140: goto -87 -> 53
      //   143: astore_1
      //   144: aload_0
      //   145: getfield 14	com/aocate/media/AndroidMediaPlayer$5:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   148: getfield 38	com/aocate/media/AndroidMediaPlayer:lockMuteOnPreparedCount	Ljava/util/concurrent/locks/ReentrantLock;
      //   151: invokevirtual 50	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   154: aload_1
      //   155: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	156	0	this	5
      //   0	156	1	paramAnonymousMediaPlayer	android.media.MediaPlayer
      // Exception table:
      //   from	to	target	type
      //   28	53	143	finally
      //   89	140	143	finally
    }
  };
  private MediaPlayer.OnSeekCompleteListener onSeekCompleteListener = new MediaPlayer.OnSeekCompleteListener()
  {
    /* Error */
    public void onSeekComplete(android.media.MediaPlayer paramAnonymousMediaPlayer)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	com/aocate/media/AndroidMediaPlayer$6:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   4: getfield 24	com/aocate/media/AndroidMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
      //   7: ifnull +74 -> 81
      //   10: aload_0
      //   11: getfield 14	com/aocate/media/AndroidMediaPlayer$6:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   14: getfield 24	com/aocate/media/AndroidMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
      //   17: getfield 30	com/aocate/media/MediaPlayer:lock	Ljava/util/concurrent/locks/ReentrantLock;
      //   20: invokevirtual 34	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   23: aload_0
      //   24: getfield 14	com/aocate/media/AndroidMediaPlayer$6:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   27: getfield 37	com/aocate/media/AndroidMediaPlayer:lockMuteOnSeekCount	Ljava/util/concurrent/locks/ReentrantLock;
      //   30: invokevirtual 34	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   33: aload_0
      //   34: getfield 14	com/aocate/media/AndroidMediaPlayer$6:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   37: getfield 41	com/aocate/media/AndroidMediaPlayer:muteOnSeekCount	I
      //   40: ifle +42 -> 82
      //   43: aload_0
      //   44: getfield 14	com/aocate/media/AndroidMediaPlayer$6:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   47: astore_1
      //   48: aload_1
      //   49: aload_1
      //   50: getfield 41	com/aocate/media/AndroidMediaPlayer:muteOnSeekCount	I
      //   53: iconst_1
      //   54: isub
      //   55: putfield 41	com/aocate/media/AndroidMediaPlayer:muteOnSeekCount	I
      //   58: aload_0
      //   59: getfield 14	com/aocate/media/AndroidMediaPlayer$6:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   62: getfield 37	com/aocate/media/AndroidMediaPlayer:lockMuteOnSeekCount	Ljava/util/concurrent/locks/ReentrantLock;
      //   65: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   68: aload_0
      //   69: getfield 14	com/aocate/media/AndroidMediaPlayer$6:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   72: getfield 24	com/aocate/media/AndroidMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
      //   75: getfield 30	com/aocate/media/MediaPlayer:lock	Ljava/util/concurrent/locks/ReentrantLock;
      //   78: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   81: return
      //   82: aload_0
      //   83: getfield 14	com/aocate/media/AndroidMediaPlayer$6:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   86: iconst_0
      //   87: putfield 41	com/aocate/media/AndroidMediaPlayer:muteOnSeekCount	I
      //   90: aload_0
      //   91: getfield 14	com/aocate/media/AndroidMediaPlayer$6:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   94: getfield 24	com/aocate/media/AndroidMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
      //   97: getfield 48	com/aocate/media/MediaPlayer:onSeekCompleteListener	Lcom/aocate/media/MediaPlayer$OnSeekCompleteListener;
      //   100: ifnull -42 -> 58
      //   103: aload_0
      //   104: getfield 14	com/aocate/media/AndroidMediaPlayer$6:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   107: getfield 24	com/aocate/media/AndroidMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
      //   110: getfield 48	com/aocate/media/MediaPlayer:onSeekCompleteListener	Lcom/aocate/media/MediaPlayer$OnSeekCompleteListener;
      //   113: aload_0
      //   114: getfield 14	com/aocate/media/AndroidMediaPlayer$6:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   117: getfield 24	com/aocate/media/AndroidMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
      //   120: invokeinterface 53 2 0
      //   125: goto -67 -> 58
      //   128: astore_1
      //   129: aload_0
      //   130: getfield 14	com/aocate/media/AndroidMediaPlayer$6:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   133: getfield 37	com/aocate/media/AndroidMediaPlayer:lockMuteOnSeekCount	Ljava/util/concurrent/locks/ReentrantLock;
      //   136: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   139: aload_1
      //   140: athrow
      //   141: astore_1
      //   142: aload_0
      //   143: getfield 14	com/aocate/media/AndroidMediaPlayer$6:this$0	Lcom/aocate/media/AndroidMediaPlayer;
      //   146: getfield 24	com/aocate/media/AndroidMediaPlayer:owningMediaPlayer	Lcom/aocate/media/MediaPlayer;
      //   149: getfield 30	com/aocate/media/MediaPlayer:lock	Ljava/util/concurrent/locks/ReentrantLock;
      //   152: invokevirtual 44	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   155: aload_1
      //   156: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	157	0	this	6
      //   0	157	1	paramAnonymousMediaPlayer	android.media.MediaPlayer
      // Exception table:
      //   from	to	target	type
      //   33	58	128	finally
      //   82	125	128	finally
      //   23	33	141	finally
      //   58	68	141	finally
      //   129	141	141	finally
    }
  };
  
  public AndroidMediaPlayer(MediaPlayer paramMediaPlayer, Context paramContext)
  {
    super(paramMediaPlayer, paramContext);
    if (this.mp == null) {
      throw new IllegalStateException("Did not instantiate android.media.MediaPlayer successfully");
    }
    this.mp.setOnBufferingUpdateListener(this.onBufferingUpdateListener);
    this.mp.setOnCompletionListener(this.onCompletionListener);
    this.mp.setOnErrorListener(this.onErrorListener);
    this.mp.setOnInfoListener(this.onInfoListener);
    Log.d("AocateAndroidMediaPlayer", " ++++++++++++++++++++++++++++++++ Setting prepared listener to this.onPreparedListener");
    this.mp.setOnPreparedListener(this.onPreparedListener);
    this.mp.setOnSeekCompleteListener(this.onSeekCompleteListener);
  }
  
  public boolean canSetPitch()
  {
    return false;
  }
  
  public boolean canSetSpeed()
  {
    return false;
  }
  
  public float getCurrentPitchStepsAdjustment()
  {
    return 0.0F;
  }
  
  public int getCurrentPosition()
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      int i = this.mp.getCurrentPosition();
      return i;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public float getCurrentSpeedMultiplier()
  {
    return 1.0F;
  }
  
  public int getDuration()
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      int i = this.mp.getDuration();
      return i;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public float getMaxSpeedMultiplier()
  {
    return 1.0F;
  }
  
  public float getMinSpeedMultiplier()
  {
    return 1.0F;
  }
  
  public boolean isLooping()
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      boolean bool = this.mp.isLooping();
      return bool;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public boolean isPlaying()
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      boolean bool = this.mp.isPlaying();
      return bool;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public void pause()
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      this.mp.pause();
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public void prepare()
    throws IllegalStateException, IOException
  {
    this.owningMediaPlayer.lock.lock();
    Log.d("AocateAndroidMediaPlayer", "prepare()");
    try
    {
      this.mp.prepare();
      Log.d("AocateAndroidMediaPlayer", "Finish prepare()");
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public void prepareAsync()
  {
    this.mp.prepareAsync();
  }
  
  public void release()
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      if (this.mp != null)
      {
        Log.d("AocateAndroidMediaPlayer", "mp.release()");
        this.mp.release();
      }
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public void reset()
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      this.mp.reset();
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public void seekTo(int paramInt)
    throws IllegalStateException
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      this.mp.setOnSeekCompleteListener(this.onSeekCompleteListener);
      this.mp.seekTo(paramInt);
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public void setAudioStreamType(int paramInt)
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      this.mp.setAudioStreamType(paramInt);
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      Log.d("AocateAndroidMediaPlayer", "setDataSource(context, " + paramUri.toString() + ")");
      this.mp.setDataSource(paramContext, paramUri);
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public void setDataSource(String paramString)
    throws IllegalArgumentException, IllegalStateException, IOException
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      Log.d("AocateAndroidMediaPlayer", "setDataSource(" + paramString + ")");
      this.mp.setDataSource(paramString);
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public void setEnableSpeedAdjustment(boolean paramBoolean) {}
  
  public void setLooping(boolean paramBoolean)
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      this.mp.setLooping(paramBoolean);
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public void setPitchStepsAdjustment(float paramFloat) {}
  
  public void setPlaybackPitch(float paramFloat) {}
  
  public void setPlaybackSpeed(float paramFloat)
  {
    Log.d("AocateAndroidMediaPlayer", "setPlaybackSpeed(" + paramFloat + ")");
  }
  
  public void setSpeedAdjustmentAlgorithm(int paramInt)
  {
    Log.d("AocateAndroidMediaPlayer", "setSpeedAdjustmentAlgorithm(" + paramInt + ")");
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      this.mp.setVolume(paramFloat1, paramFloat2);
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    this.owningMediaPlayer.lock.lock();
    if (paramInt != 0) {}
    try
    {
      this.mp.setWakeMode(paramContext, paramInt);
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public void start()
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      this.mp.start();
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
  
  public void stop()
  {
    this.owningMediaPlayer.lock.lock();
    try
    {
      this.mp.stop();
      return;
    }
    finally
    {
      this.owningMediaPlayer.lock.unlock();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/aocate/media/AndroidMediaPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */