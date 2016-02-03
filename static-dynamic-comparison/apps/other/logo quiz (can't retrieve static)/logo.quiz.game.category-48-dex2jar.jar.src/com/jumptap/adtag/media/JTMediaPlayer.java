package com.jumptap.adtag.media;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.VideoView;
import java.io.FileDescriptor;

public class JTMediaPlayer
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, SurfaceHolder.Callback, View.OnTouchListener, MediaPlayer.OnErrorListener
{
  private static JTMediaPlayer jtMediaPlayer = null;
  private SurfaceHolder holder;
  private boolean isPrepared = false;
  private int mVideoHeight;
  private int mVideoWidth;
  private MediaPlayer mediaPlayer;
  private MediaPlayer.OnCompletionListener onCompletionListener;
  
  public static JTMediaPlayer getInstance()
  {
    if (jtMediaPlayer == null) {
      jtMediaPlayer = new JTMediaPlayer();
    }
    return jtMediaPlayer;
  }
  
  public int getCurrentPosition()
  {
    if ((this.mediaPlayer != null) && (this.isPrepared)) {
      return this.mediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    int j = -1;
    int i = j;
    if (this.mediaPlayer != null)
    {
      i = j;
      if (!this.isPrepared) {}
    }
    try
    {
      i = this.mediaPlayer.getDuration();
      return i;
    }
    catch (Exception localException)
    {
      Log.e("JtAd", "Problem in getDuration", localException);
    }
    return -1;
  }
  
  public boolean isReady()
  {
    return this.isPrepared;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    Log.d("JtAd", "onBufferingUpdate percent:" + paramInt);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    Log.d("JtAd", "onCompletion called");
    if (this.onCompletionListener != null) {
      this.onCompletionListener.onCompletion(this.mediaPlayer);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Log.e("ZL", "Error in playing video type=" + paramInt1 + "  extra=" + paramInt2);
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    Log.d("JtAd", "onPrepared called");
    this.mVideoWidth = this.mediaPlayer.getVideoWidth();
    this.mVideoHeight = this.mediaPlayer.getVideoHeight();
    this.isPrepared = true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.isPrepared) && (paramMotionEvent.getAction() == 0))
    {
      if (!this.mediaPlayer.isPlaying()) {
        break label30;
      }
      pause();
    }
    for (;;)
    {
      return true;
      label30:
      play();
    }
  }
  
  public void pause()
  {
    if ((this.mediaPlayer != null) && (this.isPrepared) && (this.mediaPlayer.isPlaying())) {
      this.mediaPlayer.pause();
    }
  }
  
  public void play()
  {
    if ((this.mediaPlayer != null) && (this.isPrepared)) {
      this.mediaPlayer.start();
    }
  }
  
  public void prepareVideo(FileDescriptor paramFileDescriptor)
  {
    try
    {
      this.mediaPlayer = new MediaPlayer();
      this.mediaPlayer.setDataSource(paramFileDescriptor);
      this.mediaPlayer.setScreenOnWhilePlaying(true);
      this.mediaPlayer.prepare();
      this.mediaPlayer.setOnBufferingUpdateListener(this);
      this.mediaPlayer.setOnCompletionListener(this);
      this.mediaPlayer.setOnPreparedListener(this);
      this.mediaPlayer.setAudioStreamType(3);
      return;
    }
    catch (Exception paramFileDescriptor)
    {
      Log.e("JtAd", "error: " + paramFileDescriptor.getMessage(), paramFileDescriptor);
    }
  }
  
  public void release()
  {
    if (this.mediaPlayer != null)
    {
      this.mediaPlayer.reset();
      this.mediaPlayer.release();
      this.mediaPlayer = null;
    }
    this.isPrepared = false;
    this.holder = null;
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.onCompletionListener = paramOnCompletionListener;
  }
  
  public void setVideoView(VideoView paramVideoView)
  {
    this.holder = paramVideoView.getHolder();
    this.holder.addCallback(this);
    this.holder.setType(3);
    paramVideoView.setOnTouchListener(this);
    paramVideoView.setFocusable(true);
    paramVideoView.setFocusableInTouchMode(true);
  }
  
  public void stop()
  {
    this.mediaPlayer.stop();
    this.isPrepared = false;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.d("JtAd", "surfaceChanged called");
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    Log.d("JtAd", "surfaceCreated called");
    if ((this.mediaPlayer != null) && (this.isPrepared))
    {
      this.mediaPlayer.setDisplay(paramSurfaceHolder);
      if ((this.mVideoWidth != 0) && (this.mVideoHeight != 0)) {
        this.mediaPlayer.start();
      }
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    Log.d("JtAd", "surfaceDestroyed called");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/media/JTMediaPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */