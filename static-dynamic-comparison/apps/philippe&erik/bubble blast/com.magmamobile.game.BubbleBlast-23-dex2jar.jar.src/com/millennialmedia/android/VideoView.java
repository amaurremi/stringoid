package com.millennialmedia.android;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
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
import java.io.IOException;
import java.util.Map;

public class VideoView
  extends SurfaceView
  implements MediaController.MediaPlayerControl
{
  private static final int STATE_ERROR = -1;
  private static final int STATE_IDLE = 0;
  private static final int STATE_PAUSED = 4;
  private static final int STATE_PLAYBACK_COMPLETED = 5;
  private static final int STATE_PLAYING = 3;
  private static final int STATE_PREPARED = 2;
  private static final int STATE_PREPARING = 1;
  private static final int STATE_RESUME = 7;
  private static final int STATE_SUSPEND = 6;
  private static final int STATE_SUSPEND_UNSUPPORTED = 8;
  private String TAG = "VideoView";
  private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener()
  {
    public void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      VideoView.access$1602(VideoView.this, paramAnonymousInt);
    }
  };
  private boolean mCanPause;
  private boolean mCanSeekBack;
  private boolean mCanSeekForward;
  private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      VideoView.access$202(VideoView.this, 5);
      VideoView.access$1202(VideoView.this, 5);
      if (VideoView.this.mMediaController != null) {
        VideoView.this.mMediaController.hide();
      }
      if (VideoView.this.mOnCompletionListener != null) {
        VideoView.this.mOnCompletionListener.onCompletion(VideoView.this.mMediaPlayer);
      }
    }
  };
  private Context mContext;
  private int mCurrentBufferPercentage;
  private int mCurrentState = 0;
  private int mDuration;
  private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener()
  {
    public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (VideoView.this.videoHackBgListener != null) {
        VideoView.this.videoHackBgListener.callback(0L);
      }
      MMAdViewSDK.Log.d("Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      VideoView.access$202(VideoView.this, -1);
      VideoView.access$1202(VideoView.this, -1);
      if (VideoView.this.mMediaController != null) {
        VideoView.this.mMediaController.hide();
      }
      if ((VideoView.this.mOnErrorListener != null) && (VideoView.this.mOnErrorListener.onError(VideoView.this.mMediaPlayer, paramAnonymousInt1, paramAnonymousInt2))) {}
      while (VideoView.this.getWindowToken() == null) {
        return true;
      }
      VideoView.this.mContext.getResources();
      if (paramAnonymousInt1 == 200) {}
      for (paramAnonymousInt1 = 17039381;; paramAnonymousInt1 = 17039377)
      {
        new AlertDialog.Builder(VideoView.this.mContext).setTitle("Sorry").setMessage(paramAnonymousInt1).setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            if (VideoView.this.mOnCompletionListener != null) {
              VideoView.this.mOnCompletionListener.onCompletion(VideoView.this.mMediaPlayer);
            }
          }
        }).setCancelable(false).show();
        return true;
      }
    }
  };
  private Map<String, String> mHeaders;
  private MediaPlayer.OnInfoListener mInfoListener = new MediaPlayer.OnInfoListener()
  {
    public boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt1 == 801) {
        VideoView.access$402(VideoView.this, VideoView.access$502(VideoView.this, false));
      }
      return false;
    }
  };
  private MediaController mMediaController;
  private MediaPlayer mMediaPlayer = null;
  private MediaPlayer.OnCompletionListener mOnCompletionListener;
  private MediaPlayer.OnErrorListener mOnErrorListener;
  private MediaPlayer.OnPreparedListener mOnPreparedListener;
  MediaPlayer.OnPreparedListener mPreparedListener = new MediaPlayer.OnPreparedListener()
  {
    public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
    {
      if (VideoView.this.videoHackBgListener != null) {
        VideoView.this.videoHackBgListener.callback(100L);
      }
      VideoView.access$202(VideoView.this, 2);
      VideoView.access$302(VideoView.this, VideoView.access$402(VideoView.this, VideoView.access$502(VideoView.this, true)));
      if (VideoView.this.mOnPreparedListener != null) {
        VideoView.this.mOnPreparedListener.onPrepared(VideoView.this.mMediaPlayer);
      }
      if (VideoView.this.mMediaController != null) {
        VideoView.this.mMediaController.setEnabled(true);
      }
      VideoView.access$002(VideoView.this, paramAnonymousMediaPlayer.getVideoWidth());
      VideoView.access$102(VideoView.this, paramAnonymousMediaPlayer.getVideoHeight());
      int i = VideoView.this.mSeekWhenPrepared;
      if (i != 0) {
        VideoView.this.seekTo(i);
      }
      if ((VideoView.this.mVideoWidth != 0) && (VideoView.this.mVideoHeight != 0))
      {
        VideoView.this.getHolder().setFixedSize(VideoView.this.mVideoWidth, VideoView.this.mVideoHeight);
        if ((VideoView.this.mSurfaceWidth == VideoView.this.mVideoWidth) && (VideoView.this.mSurfaceHeight == VideoView.this.mVideoHeight))
        {
          if (VideoView.this.mTargetState != 3) {
            break label270;
          }
          VideoView.this.start();
          if (VideoView.this.mMediaController != null) {
            VideoView.this.mMediaController.show();
          }
        }
      }
      label270:
      while (VideoView.this.mTargetState != 3)
      {
        do
        {
          return;
        } while ((VideoView.this.isPlaying()) || ((i == 0) && (VideoView.this.getCurrentPosition() <= 0)) || (VideoView.this.mMediaController == null));
        VideoView.this.mMediaController.show(0);
        return;
      }
      VideoView.this.start();
    }
  };
  SurfaceHolder.Callback mSHCallback = new SurfaceHolder.Callback()
  {
    public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      VideoView.access$1002(VideoView.this, paramAnonymousInt2);
      VideoView.access$1102(VideoView.this, paramAnonymousInt3);
      if (VideoView.this.mTargetState == 3)
      {
        paramAnonymousInt1 = 1;
        if ((VideoView.this.mVideoWidth != paramAnonymousInt2) || (VideoView.this.mVideoHeight != paramAnonymousInt3)) {
          break label155;
        }
      }
      label155:
      for (paramAnonymousInt2 = 1;; paramAnonymousInt2 = 0)
      {
        if ((VideoView.this.mMediaPlayer != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0))
        {
          if (VideoView.this.mSeekWhenPrepared != 0) {
            VideoView.this.seekTo(VideoView.this.mSeekWhenPrepared);
          }
          VideoView.this.start();
          if (VideoView.this.mMediaController != null)
          {
            if (VideoView.this.mMediaController.isShowing()) {
              VideoView.this.mMediaController.hide();
            }
            VideoView.this.mMediaController.show();
          }
        }
        return;
        paramAnonymousInt1 = 0;
        break;
      }
    }
    
    public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      VideoView.access$1702(VideoView.this, paramAnonymousSurfaceHolder);
      if ((VideoView.this.mMediaPlayer != null) && (VideoView.this.mCurrentState == 6) && (VideoView.this.mTargetState == 7))
      {
        VideoView.this.mMediaPlayer.setDisplay(VideoView.this.mSurfaceHolder);
        return;
      }
      VideoView.this.openVideo();
    }
    
    public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      VideoView.access$1702(VideoView.this, null);
      if (VideoView.this.mMediaController != null) {
        VideoView.this.mMediaController.hide();
      }
      if (VideoView.this.mCurrentState != 6) {
        VideoView.this.release(true);
      }
    }
  };
  private int mSeekWhenPrepared;
  MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener()
  {
    public void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      VideoView.access$002(VideoView.this, paramAnonymousMediaPlayer.getVideoWidth());
      VideoView.access$102(VideoView.this, paramAnonymousMediaPlayer.getVideoHeight());
      if ((VideoView.this.mVideoWidth != 0) && (VideoView.this.mVideoHeight != 0)) {
        VideoView.this.getHolder().setFixedSize(VideoView.this.mVideoWidth, VideoView.this.mVideoHeight);
      }
    }
  };
  private int mStateWhenSuspended;
  private int mSurfaceHeight;
  private SurfaceHolder mSurfaceHolder = null;
  private int mSurfaceWidth;
  private int mTargetState = 0;
  private Uri mUri;
  private int mVideoHeight;
  private int mVideoWidth;
  VideoPlayerActivity.VideoHackBgListener videoHackBgListener;
  
  public VideoView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    initVideoView();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.mContext = paramContext;
    initVideoView();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
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
  
  public boolean isInErrorState()
  {
    return this.mCurrentState == -1;
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
  
  public void openVideo()
  {
    if ((this.mUri == null) || (this.mSurfaceHolder == null)) {
      return;
    }
    Intent localIntent = new Intent("com.android.music.musicservicecommand");
    localIntent.putExtra("command", "pause");
    this.mContext.sendBroadcast(localIntent);
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
      this.mMediaPlayer.setDataSource(this.mContext, this.mUri);
      this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
      this.mMediaPlayer.setAudioStreamType(3);
      this.mMediaPlayer.setScreenOnWhilePlaying(true);
      this.mMediaPlayer.prepareAsync();
      this.mCurrentState = 1;
      attachMediaController();
      return;
    }
    catch (IOException localIOException)
    {
      Log.w(this.TAG, "Unable to open content: " + this.mUri, localIOException);
      this.mCurrentState = -1;
      this.mTargetState = -1;
      this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.w(this.TAG, "Unable to open content: " + this.mUri, localIllegalArgumentException);
      this.mCurrentState = -1;
      this.mTargetState = -1;
      this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
    }
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
  
  void setCallBack(VideoPlayerActivity.VideoHackBgListener paramVideoHackBgListener)
  {
    this.videoHackBgListener = paramVideoHackBgListener;
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
  
  public void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }
  
  public void setVideoURI(Uri paramUri)
  {
    setVideoURI(paramUri, null);
  }
  
  public void setVideoURI(Uri paramUri, Map<String, String> paramMap)
  {
    this.mUri = paramUri;
    this.mHeaders = paramMap;
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
      if (this.mMediaPlayer.isPlaying()) {
        this.mMediaPlayer.stop();
      }
      this.mMediaPlayer.release();
      this.mUri = null;
      this.mMediaPlayer = null;
      this.mCurrentState = 0;
      this.mTargetState = 0;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/millennialmedia/android/VideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */