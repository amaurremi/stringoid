package com.jirbo.adcolony;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.io.FileDescriptor;
import java.io.IOException;

class ADCCustomVideoView
  extends SurfaceView
  implements MediaController.MediaPlayerControl
{
  static final int STATE_ERROR = -1;
  static final int STATE_IDLE = 0;
  static final int STATE_PAUSED = 4;
  static final int STATE_PLAYBACK_COMPLETED = 5;
  static final int STATE_PLAYING = 3;
  static final int STATE_PREPARED = 2;
  static final int STATE_PREPARING = 1;
  static final int STATE_RESUME = 7;
  static final int STATE_SUSPEND = 6;
  static final int STATE_SUSPEND_UNSUPPORTED = 8;
  String TAG = "ADCCustomVideoView";
  FileDescriptor fd;
  private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener()
  {
    public void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      ADCCustomVideoView.this.mCurrentBufferPercentage = paramAnonymousInt;
    }
  };
  boolean mCanPause;
  boolean mCanSeekBack;
  boolean mCanSeekForward;
  private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      ADCCustomVideoView.this.mCurrentState = 5;
      ADCCustomVideoView.this.mTargetState = 5;
      if (ADCCustomVideoView.this.mMediaController != null) {
        ADCCustomVideoView.this.mMediaController.hide();
      }
      if (ADCCustomVideoView.this.mOnCompletionListener != null) {
        ADCCustomVideoView.this.mOnCompletionListener.onCompletion(ADCCustomVideoView.this.mMediaPlayer);
      }
    }
  };
  int mCurrentBufferPercentage;
  int mCurrentState = 0;
  int mDuration;
  private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener()
  {
    public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      Log.d(ADCCustomVideoView.this.TAG, "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      ADCCustomVideoView.this.mCurrentState = -1;
      ADCCustomVideoView.this.mTargetState = -1;
      if (ADCCustomVideoView.this.mMediaController != null) {
        ADCCustomVideoView.this.mMediaController.hide();
      }
      if ((ADCCustomVideoView.this.mOnErrorListener != null) && (ADCCustomVideoView.this.mOnErrorListener.onError(ADCCustomVideoView.this.mMediaPlayer, paramAnonymousInt1, paramAnonymousInt2))) {}
      while (ADCCustomVideoView.this.getWindowToken() == null) {
        return true;
      }
      ADCCustomVideoView.this.activity().getResources();
      if (paramAnonymousInt1 == 200) {}
      for (paramAnonymousMediaPlayer = "Invalid progressive playback";; paramAnonymousMediaPlayer = "Unknown error")
      {
        new AlertDialog.Builder(ADCCustomVideoView.this.activity()).setTitle("ERROR").setMessage(paramAnonymousMediaPlayer).setPositiveButton("OKAY", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            if (ADCCustomVideoView.this.mOnCompletionListener != null) {
              ADCCustomVideoView.this.mOnCompletionListener.onCompletion(ADCCustomVideoView.this.mMediaPlayer);
            }
          }
        }).setCancelable(false).show();
        return true;
      }
    }
  };
  MediaController mMediaController;
  MediaPlayer mMediaPlayer = null;
  MediaPlayer.OnCompletionListener mOnCompletionListener;
  MediaPlayer.OnErrorListener mOnErrorListener;
  MediaPlayer.OnPreparedListener mOnPreparedListener;
  MediaPlayer.OnPreparedListener mPreparedListener = new MediaPlayer.OnPreparedListener()
  {
    public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
    {
      ADCCustomVideoView.this.mCurrentState = 2;
      ADCCustomVideoView localADCCustomVideoView1 = ADCCustomVideoView.this;
      ADCCustomVideoView localADCCustomVideoView2 = ADCCustomVideoView.this;
      ADCCustomVideoView.this.mCanSeekForward = true;
      localADCCustomVideoView2.mCanSeekBack = true;
      localADCCustomVideoView1.mCanPause = true;
      if (ADCCustomVideoView.this.mOnPreparedListener != null) {
        ADCCustomVideoView.this.mOnPreparedListener.onPrepared(ADCCustomVideoView.this.mMediaPlayer);
      }
      if (ADCCustomVideoView.this.mMediaController != null) {
        ADCCustomVideoView.this.mMediaController.setEnabled(true);
      }
      ADCCustomVideoView.this.mVideoWidth = paramAnonymousMediaPlayer.getVideoWidth();
      ADCCustomVideoView.this.mVideoHeight = paramAnonymousMediaPlayer.getVideoHeight();
      int i = ADCCustomVideoView.this.mSeekWhenPrepared;
      if (i != 0) {
        ADCCustomVideoView.this.seekTo(i);
      }
      if ((ADCCustomVideoView.this.mVideoWidth != 0) && (ADCCustomVideoView.this.mVideoHeight != 0))
      {
        ADCCustomVideoView.this.getHolder().setFixedSize(ADCCustomVideoView.this.mVideoWidth, ADCCustomVideoView.this.mVideoHeight);
        if ((ADCCustomVideoView.this.mSurfaceWidth == ADCCustomVideoView.this.mVideoWidth) && (ADCCustomVideoView.this.mSurfaceHeight == ADCCustomVideoView.this.mVideoHeight))
        {
          if (ADCCustomVideoView.this.mTargetState != 3) {
            break label249;
          }
          ADCCustomVideoView.this.start();
          if (ADCCustomVideoView.this.mMediaController != null) {
            ADCCustomVideoView.this.mMediaController.show();
          }
        }
      }
      label249:
      while (ADCCustomVideoView.this.mTargetState != 3)
      {
        do
        {
          return;
        } while ((ADCCustomVideoView.this.isPlaying()) || ((i == 0) && (ADCCustomVideoView.this.getCurrentPosition() <= 0)) || (ADCCustomVideoView.this.mMediaController == null));
        ADCCustomVideoView.this.mMediaController.show(0);
        return;
      }
      ADCCustomVideoView.this.start();
    }
  };
  SurfaceHolder.Callback mSHCallback = new SurfaceHolder.Callback()
  {
    public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      ADCCustomVideoView.this.mSurfaceWidth = paramAnonymousInt2;
      ADCCustomVideoView.this.mSurfaceHeight = paramAnonymousInt3;
      if (ADCCustomVideoView.this.mTargetState == 3)
      {
        paramAnonymousInt1 = 1;
        if ((ADCCustomVideoView.this.mVideoWidth != paramAnonymousInt2) || (ADCCustomVideoView.this.mVideoHeight != paramAnonymousInt3)) {
          break label130;
        }
      }
      label130:
      for (paramAnonymousInt2 = 1;; paramAnonymousInt2 = 0)
      {
        if ((ADCCustomVideoView.this.mMediaPlayer != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0))
        {
          if (ADCCustomVideoView.this.mSeekWhenPrepared != 0) {
            ADCCustomVideoView.this.seekTo(ADCCustomVideoView.this.mSeekWhenPrepared);
          }
          ADCCustomVideoView.this.start();
          if (ADCCustomVideoView.this.mMediaController != null) {
            ADCCustomVideoView.this.mMediaController.show();
          }
        }
        return;
        paramAnonymousInt1 = 0;
        break;
      }
    }
    
    public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      ADCCustomVideoView.this.mSurfaceHolder = paramAnonymousSurfaceHolder;
      if ((ADCCustomVideoView.this.mMediaPlayer != null) && (ADCCustomVideoView.this.mCurrentState == 6) && (ADCCustomVideoView.this.mTargetState == 7))
      {
        ADCCustomVideoView.this.mMediaPlayer.setDisplay(ADCCustomVideoView.this.mSurfaceHolder);
        ADCCustomVideoView.this.resume();
        return;
      }
      ADCCustomVideoView.this.openVideo();
    }
    
    public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      ADCCustomVideoView.this.mSurfaceHolder = null;
      if (ADCCustomVideoView.this.mMediaController != null) {
        ADCCustomVideoView.this.mMediaController.hide();
      }
      if (ADCCustomVideoView.this.mCurrentState != 6) {
        ADCCustomVideoView.this.release(true);
      }
    }
  };
  int mSeekWhenPrepared;
  MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener()
  {
    public void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      ADCCustomVideoView.this.mVideoWidth = paramAnonymousMediaPlayer.getVideoWidth();
      ADCCustomVideoView.this.mVideoHeight = paramAnonymousMediaPlayer.getVideoHeight();
      if ((ADCCustomVideoView.this.mVideoWidth != 0) && (ADCCustomVideoView.this.mVideoHeight != 0)) {
        ADCCustomVideoView.this.getHolder().setFixedSize(ADCCustomVideoView.this.mVideoWidth, ADCCustomVideoView.this.mVideoHeight);
      }
    }
  };
  int mStateWhenSuspended;
  int mSurfaceHeight;
  SurfaceHolder mSurfaceHolder = null;
  int mSurfaceWidth;
  int mTargetState = 0;
  Uri mUri;
  int mVideoHeight;
  int mVideoWidth;
  
  ADCCustomVideoView(Context paramContext)
  {
    super(paramContext);
    initVideoView();
  }
  
  public ADCCustomVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    initVideoView();
  }
  
  public ADCCustomVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initVideoView();
  }
  
  private void attachMediaController()
  {
    if ((this.mMediaPlayer != null) && (this.mMediaController != null))
    {
      this.mMediaController.setMediaPlayer(this);
      if (!(getParent() instanceof View)) {
        break label60;
      }
    }
    label60:
    for (Object localObject = (View)getParent();; localObject = this)
    {
      this.mMediaController.setAnchorView((View)localObject);
      this.mMediaController.setEnabled(isInPlaybackState());
      return;
    }
  }
  
  private void initVideoView()
  {
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    getHolder().addCallback(this.mSHCallback);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    this.mCurrentState = 0;
    this.mTargetState = 0;
  }
  
  private boolean isInPlaybackState()
  {
    return (this.mMediaPlayer != null) && (this.mCurrentState != -1) && (this.mCurrentState != 0) && (this.mCurrentState != 1);
  }
  
  private void openVideo()
  {
    if (((this.mUri == null) && (this.fd == null)) || (this.mSurfaceHolder == null)) {
      return;
    }
    Intent localIntent = new Intent("com.android.music.musicservicecommand");
    localIntent.putExtra("command", "pause");
    activity().sendBroadcast(localIntent);
    release(false);
    try
    {
      this.mMediaPlayer = new MediaPlayer();
      this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
      this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
      this.mDuration = -1;
      this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
      this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
      this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
      this.mCurrentBufferPercentage = 0;
      if (this.mUri != null)
      {
        this.mMediaPlayer.setDataSource(activity(), this.mUri);
        this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
        this.mMediaPlayer.setAudioStreamType(3);
        this.mMediaPlayer.setScreenOnWhilePlaying(true);
        this.mMediaPlayer.prepare();
        this.mCurrentState = 1;
        attachMediaController();
        return;
      }
    }
    catch (IOException localIOException)
    {
      while (this.mUri != null)
      {
        Log.w(this.TAG, "Unable to open content: " + this.mUri, localIOException);
        this.mCurrentState = -1;
        this.mTargetState = -1;
        this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
        return;
        this.mMediaPlayer.setDataSource(this.fd);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (this.mUri == null) {
        break label358;
      }
    }
    Log.w(this.TAG, "Unable to open content: " + this.mUri, localIllegalArgumentException);
    for (;;)
    {
      this.mCurrentState = -1;
      this.mTargetState = -1;
      this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
      return;
      Log.w(this.TAG, "Unable to open content");
      break;
      label358:
      Log.w(this.TAG, "Unable to open content");
    }
  }
  
  private void release(boolean paramBoolean)
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.reset();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      this.mCurrentState = 0;
      if (paramBoolean) {
        this.mTargetState = 0;
      }
    }
  }
  
  private void toggleMediaControlsVisiblity()
  {
    if (this.mMediaController.isShowing())
    {
      this.mMediaController.hide();
      return;
    }
    this.mMediaController.show();
  }
  
  Activity activity()
  {
    return AdColony.activity();
  }
  
  public boolean canPause()
  {
    return this.mCanPause;
  }
  
  public boolean canSeekBackward()
  {
    return this.mCanSeekBack;
  }
  
  public boolean canSeekForward()
  {
    return this.mCanSeekForward;
  }
  
  public int getAudioSessionId()
  {
    return 0;
  }
  
  public int getBufferPercentage()
  {
    if (this.mMediaPlayer != null) {
      return this.mCurrentBufferPercentage;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (isInPlaybackState()) {
      return this.mMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (isInPlaybackState())
    {
      if (this.mDuration > 0) {
        return this.mDuration;
      }
      this.mDuration = this.mMediaPlayer.getDuration();
      return this.mDuration;
    }
    this.mDuration = -1;
    return this.mDuration;
  }
  
  public boolean isPlaying()
  {
    return (isInPlaybackState()) && (this.mMediaPlayer.isPlaying());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i;
    if ((paramInt != 4) && (paramInt != 24) && (paramInt != 25) && (paramInt != 82) && (paramInt != 5) && (paramInt != 6)) {
      i = 1;
    }
    while ((isInPlaybackState()) && (i != 0) && (this.mMediaController != null)) {
      if ((paramInt == 79) || (paramInt == 85))
      {
        if (this.mMediaPlayer.isPlaying())
        {
          pause();
          this.mMediaController.show();
          return true;
          i = 0;
        }
        else
        {
          start();
          this.mMediaController.hide();
          return true;
        }
      }
      else
      {
        if ((paramInt != 86) || (!this.mMediaPlayer.isPlaying())) {
          break label141;
        }
        pause();
        this.mMediaController.show();
      }
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      label141:
      toggleMediaControlsVisiblity();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getDefaultSize(this.mVideoWidth, paramInt1);
    int j = getDefaultSize(this.mVideoHeight, paramInt2);
    paramInt1 = j;
    paramInt2 = i;
    if (this.mVideoWidth > 0)
    {
      paramInt1 = j;
      paramInt2 = i;
      if (this.mVideoHeight > 0)
      {
        if (this.mVideoWidth * j <= this.mVideoHeight * i) {
          break label80;
        }
        paramInt1 = this.mVideoHeight * i / this.mVideoWidth;
        paramInt2 = i;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      label80:
      paramInt1 = j;
      paramInt2 = i;
      if (this.mVideoWidth * j < this.mVideoHeight * i)
      {
        paramInt2 = this.mVideoWidth * j / this.mVideoHeight;
        paramInt1 = j;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((isInPlaybackState()) && (this.mMediaController != null)) {
      toggleMediaControlsVisiblity();
    }
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((isInPlaybackState()) && (this.mMediaController != null)) {
      toggleMediaControlsVisiblity();
    }
    return false;
  }
  
  public void pause()
  {
    if ((isInPlaybackState()) && (this.mMediaPlayer.isPlaying()))
    {
      this.mMediaPlayer.pause();
      this.mCurrentState = 4;
    }
    this.mTargetState = 4;
  }
  
  public int resolveAdjustedSize(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    default: 
      return paramInt1;
    case 0: 
      return paramInt1;
    case -2147483648: 
      return Math.min(paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public void resume()
  {
    if ((this.mSurfaceHolder == null) && (this.mCurrentState == 6)) {
      this.mTargetState = 7;
    }
    do
    {
      return;
      if ((this.mMediaPlayer != null) && (this.mCurrentState == 6))
      {
        this.mMediaPlayer.start();
        this.mCurrentState = this.mStateWhenSuspended;
        this.mTargetState = this.mStateWhenSuspended;
        return;
      }
    } while (this.mCurrentState != 8);
    openVideo();
  }
  
  public void seekTo(int paramInt)
  {
    if (isInPlaybackState())
    {
      this.mMediaPlayer.seekTo(paramInt);
      this.mSeekWhenPrepared = 0;
      return;
    }
    this.mSeekWhenPrepared = paramInt;
  }
  
  public void setMediaController(MediaController paramMediaController)
  {
    if (this.mMediaController != null) {
      this.mMediaController.hide();
    }
    this.mMediaController = paramMediaController;
    attachMediaController();
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.mOnCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.mOnPreparedListener = paramOnPreparedListener;
  }
  
  public void setVideoPath(FileDescriptor paramFileDescriptor)
  {
    this.fd = paramFileDescriptor;
    this.mSeekWhenPrepared = 0;
    openVideo();
    requestLayout();
    invalidate();
  }
  
  public void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }
  
  public void setVideoURI(Uri paramUri)
  {
    this.mUri = paramUri;
    this.mSeekWhenPrepared = 0;
    openVideo();
    requestLayout();
    invalidate();
  }
  
  public void start()
  {
    if (isInPlaybackState())
    {
      this.mMediaPlayer.start();
      this.mCurrentState = 3;
    }
    this.mTargetState = 3;
  }
  
  public void stopPlayback()
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      this.mCurrentState = 0;
      this.mTargetState = 0;
    }
  }
  
  public void suspend()
  {
    if (isInPlaybackState())
    {
      this.mMediaPlayer.stop();
      this.mStateWhenSuspended = this.mCurrentState;
      this.mCurrentState = 6;
      this.mTargetState = 6;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCCustomVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */