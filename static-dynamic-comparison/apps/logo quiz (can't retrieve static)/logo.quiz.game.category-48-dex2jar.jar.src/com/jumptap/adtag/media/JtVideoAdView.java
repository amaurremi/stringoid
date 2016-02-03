package com.jumptap.adtag.media;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.io.IOException;

public class JtVideoAdView
  extends SurfaceView
  implements MediaController.MediaPlayerControl
{
  private static JtVideoAdView videoViewInstance;
  private MediaPlayer.OnBufferingUpdateListener bufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener()
  {
    public void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      JtVideoAdView.access$002(JtVideoAdView.this, paramAnonymousInt);
    }
  };
  private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener()
  {
    public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      if (JtVideoAdView.this.mediaController != null) {
        JtVideoAdView.this.mediaController.hide();
      }
      if (JtVideoAdView.this.onCompletionListener != null) {
        JtVideoAdView.this.onCompletionListener.onCompletion(JtVideoAdView.this.mediaPlayer);
      }
      JtVideoAdView.this.setVisibility(8);
    }
  };
  private Context context;
  private int currentBufferPercentage;
  private boolean isPrepared;
  private MediaController mediaController;
  private MediaPlayer mediaPlayer = null;
  private MediaPlayer.OnCompletionListener onCompletionListener;
  private MediaPlayer.OnPreparedListener onPreparedListener;
  MediaPlayer.OnPreparedListener preparedListener = new MediaPlayer.OnPreparedListener()
  {
    public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
    {
      Log.d("ZL", "OnPreparedListenerOnPreparedListener");
      JtVideoAdView.access$402(JtVideoAdView.this, true);
      if (JtVideoAdView.this.onPreparedListener != null) {
        JtVideoAdView.this.onPreparedListener.onPrepared(JtVideoAdView.this.mediaPlayer);
      }
      if (JtVideoAdView.this.mediaController != null) {
        JtVideoAdView.this.mediaController.setEnabled(true);
      }
      JtVideoAdView.access$602(JtVideoAdView.this, paramAnonymousMediaPlayer.getVideoWidth());
      JtVideoAdView.access$702(JtVideoAdView.this, paramAnonymousMediaPlayer.getVideoHeight());
      if ((JtVideoAdView.this.videoWidth != 0) && (JtVideoAdView.this.videoHeight != 0))
      {
        JtVideoAdView.this.getHolder().setFixedSize(JtVideoAdView.this.videoWidth, JtVideoAdView.this.videoHeight);
        if (JtVideoAdView.this.seekWhenPrepared != 0) {
          JtVideoAdView.this.mediaPlayer.seekTo(JtVideoAdView.this.seekWhenPrepared);
        }
        if (JtVideoAdView.this.mediaController != null) {
          JtVideoAdView.this.mediaController.show();
        }
      }
    }
  };
  private int seekWhenPrepared;
  SurfaceHolder.Callback shCallback = new SurfaceHolder.Callback()
  {
    public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      Log.d("ZL", "####################surfaceChanged  getHolder()=" + JtVideoAdView.this.isPrepared);
      if ((JtVideoAdView.this.isPrepared) && (JtVideoAdView.this.videoWidth == paramAnonymousInt2) && (JtVideoAdView.this.videoHeight == paramAnonymousInt3))
      {
        if (JtVideoAdView.this.seekWhenPrepared != 0) {
          JtVideoAdView.this.mediaPlayer.seekTo(JtVideoAdView.this.seekWhenPrepared);
        }
        if (JtVideoAdView.this.mediaController != null) {
          JtVideoAdView.this.mediaController.show();
        }
      }
    }
    
    public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      JtVideoAdView.access$902(JtVideoAdView.this, paramAnonymousSurfaceHolder);
      Log.d("ZL", "####################surfaceCreated");
      JtVideoAdView.this.openVideo();
    }
    
    public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      Log.d("ZL", "####################surfaceDestroyed");
      JtVideoAdView.access$902(JtVideoAdView.this, null);
      if (JtVideoAdView.this.mediaController != null) {
        JtVideoAdView.this.mediaController.hide();
      }
      if (JtVideoAdView.this.mediaPlayer != null)
      {
        JtVideoAdView.this.mediaPlayer.reset();
        JtVideoAdView.this.mediaPlayer.release();
        JtVideoAdView.access$302(JtVideoAdView.this, null);
      }
    }
  };
  private SurfaceHolder surfaceHolder = null;
  private Uri uri;
  private int videoHeight;
  private int videoWidth;
  
  private JtVideoAdView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    initVideoView();
  }
  
  private void attachMediaController()
  {
    if ((this.mediaPlayer != null) && (this.mediaController != null))
    {
      this.mediaController.setAnchorView(this);
      this.mediaController.setMediaPlayer(this);
      this.mediaController.setEnabled(true);
    }
  }
  
  public static JtVideoAdView getInstance(Context paramContext)
  {
    if (videoViewInstance == null) {
      videoViewInstance = new JtVideoAdView(paramContext);
    }
    return videoViewInstance;
  }
  
  private void initVideoView()
  {
    this.videoWidth = 0;
    this.videoHeight = 0;
    getHolder().addCallback(this.shCallback);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
  }
  
  private void openVideo()
  {
    if ((this.uri == null) || (this.surfaceHolder == null))
    {
      Log.d("ZL", "XXXXXXXXXXXXXXXXXXXXXX");
      return;
    }
    Log.d("ZL", "YYYYYYYYYYYYYYYYY");
    Intent localIntent = new Intent("com.android.music.musicservicecommand");
    localIntent.putExtra("command", "pause");
    this.context.sendBroadcast(localIntent);
    if (this.mediaPlayer != null)
    {
      this.mediaPlayer.reset();
      this.mediaPlayer.release();
      this.mediaPlayer = null;
    }
    try
    {
      this.mediaPlayer = new MediaPlayer();
      this.mediaPlayer.setOnPreparedListener(this.preparedListener);
      this.isPrepared = false;
      this.mediaPlayer.setOnCompletionListener(this.completionListener);
      this.mediaPlayer.setOnBufferingUpdateListener(this.bufferingUpdateListener);
      this.currentBufferPercentage = 0;
      this.mediaPlayer.setDataSource(this.context, this.uri);
      this.mediaPlayer.setDisplay(this.surfaceHolder);
      this.mediaPlayer.setAudioStreamType(3);
      this.mediaPlayer.setScreenOnWhilePlaying(true);
      this.mediaPlayer.prepareAsync();
      attachMediaController();
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("JtAd", "Unable to open content: " + this.uri, localIOException);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.w("JtAd", "Unable to open content: " + this.uri, localIllegalArgumentException);
    }
  }
  
  private void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }
  
  private void setVideoURI(Uri paramUri)
  {
    this.uri = paramUri;
    this.seekWhenPrepared = 0;
    openVideo();
    requestLayout();
    invalidate();
  }
  
  private void toggleMediaControlsVisiblity()
  {
    if (this.mediaController.isShowing())
    {
      this.mediaController.hide();
      return;
    }
    this.mediaController.show();
  }
  
  public boolean canPause()
  {
    return true;
  }
  
  public boolean canSeekBackward()
  {
    return true;
  }
  
  public boolean canSeekForward()
  {
    return true;
  }
  
  public int getBufferPercentage()
  {
    if (this.mediaPlayer != null) {
      return this.currentBufferPercentage;
    }
    return 0;
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
  
  public boolean isPlaying()
  {
    if ((this.mediaPlayer != null) && (this.isPrepared)) {
      return this.mediaPlayer.isPlaying();
    }
    return false;
  }
  
  public boolean isReady()
  {
    return (this.mediaPlayer != null) && (this.isPrepared);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.isPrepared) && (paramInt != 4) && (paramInt != 24) && (paramInt != 25) && (paramInt != 82) && (paramInt != 5) && (paramInt != 6) && (this.mediaPlayer != null) && (this.mediaController != null))
    {
      if (paramInt == 79)
      {
        if (this.mediaPlayer.isPlaying())
        {
          pause();
          this.mediaController.show();
        }
        for (;;)
        {
          return true;
          start();
          this.mediaController.hide();
        }
      }
      toggleMediaControlsVisiblity();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.isPrepared)
    {
      if ((this.mediaPlayer == null) || (this.mediaController == null)) {
        break label27;
      }
      toggleMediaControlsVisiblity();
    }
    for (;;)
    {
      return true;
      label27:
      if (paramMotionEvent.getAction() == 0) {
        if (this.mediaPlayer.isPlaying()) {
          pause();
        } else {
          start();
        }
      }
    }
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((this.isPrepared) && (this.mediaPlayer != null) && (this.mediaController != null)) {
      toggleMediaControlsVisiblity();
    }
    return false;
  }
  
  public void pause()
  {
    if ((this.mediaPlayer != null) && (this.isPrepared) && (this.mediaPlayer.isPlaying())) {
      this.mediaPlayer.pause();
    }
  }
  
  public void prepare(String paramString)
  {
    setVideoPath(paramString);
    requestFocus();
  }
  
  public void seekTo(int paramInt)
  {
    if ((this.mediaPlayer != null) && (this.isPrepared))
    {
      this.mediaPlayer.seekTo(paramInt);
      return;
    }
    this.seekWhenPrepared = paramInt;
  }
  
  public void setMediaController(MediaController paramMediaController)
  {
    if (this.mediaController != null) {
      this.mediaController.hide();
    }
    this.mediaController = paramMediaController;
    attachMediaController();
  }
  
  public void start()
  {
    Log.d("ZL", "start  mediaPlayer=" + this.mediaPlayer.toString() + "   isPrepared" + this.isPrepared);
    if ((this.mediaPlayer != null) && (this.isPrepared)) {
      this.mediaPlayer.start();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/media/JtVideoAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */