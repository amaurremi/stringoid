package com.millennialmedia.android;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import android.widget.VideoView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class VideoPlayerActivity
  extends MMBaseActivity
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static final int CONTROLS_ID = 83756563;
  private static final String END_VIDEO = "endVideo";
  protected static final int MESSAGE_CHECK_PLAYING_VIDEO = 4;
  protected static final int MESSAGE_DELAYED_BUTTON = 3;
  protected static final int MESSAGE_INACTIVITY_ANIMATION = 1;
  protected static final int MESSAGE_ONE_SECOND_CHECK = 2;
  protected static final int MESSAGE_SET_TRANSPARENCY = 5;
  private static final String RESTART_VIDEO = "restartVideo";
  AdProperties adProperties;
  View blackView;
  protected int currentVideoPosition = 0;
  protected boolean hasBottomBar = true;
  private boolean hasFocus;
  boolean isPaused;
  boolean isUserPausing = false;
  protected boolean isVideoCompleted;
  private boolean isVideoCompletedOnce;
  String lastOverlayOrientation;
  protected VideoView mVideoView;
  Button pausePlay;
  ProgressBar progBar;
  HttpRedirection.RedirectionListenerImpl redirectListenerImpl;
  private boolean shouldSetUri = true;
  TransparentHandler transparentHandler = new TransparentHandler(this);
  RelativeLayout videoLayout;
  
  private void initBottomBar(RelativeLayout paramRelativeLayout)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.activity);
    localRelativeLayout.setId(83756563);
    localRelativeLayout.setBackgroundColor(-16777216);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    localRelativeLayout.setLayoutParams(localLayoutParams1);
    localLayoutParams1.addRule(12);
    Button localButton1 = new Button(this.activity);
    this.pausePlay = new Button(this.activity);
    Button localButton2 = new Button(this.activity);
    localButton1.setBackgroundResource(17301541);
    if (this.mVideoView.isPlaying()) {
      this.pausePlay.setBackgroundResource(17301539);
    }
    for (;;)
    {
      localButton2.setBackgroundResource(17301560);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
      RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.addRule(14);
      localRelativeLayout.addView(this.pausePlay, localLayoutParams2);
      localLayoutParams4.addRule(0, this.pausePlay.getId());
      localRelativeLayout.addView(localButton1);
      localLayoutParams3.addRule(11);
      localRelativeLayout.addView(localButton2, localLayoutParams3);
      localButton1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (VideoPlayerActivity.this.mVideoView != null) {
            VideoPlayerActivity.this.mVideoView.seekTo(0);
          }
        }
      });
      this.pausePlay.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (VideoPlayerActivity.this.mVideoView != null)
          {
            if (VideoPlayerActivity.this.mVideoView.isPlaying())
            {
              VideoPlayerActivity.this.pauseVideoByUser();
              VideoPlayerActivity.this.pausePlay.setBackgroundResource(17301540);
            }
          }
          else {
            return;
          }
          if (VideoPlayerActivity.this.isVideoCompleted) {
            VideoPlayerActivity.this.playVideo(0);
          }
          for (;;)
          {
            VideoPlayerActivity.this.pausePlay.setBackgroundResource(17301539);
            return;
            if ((VideoPlayerActivity.this.isUserPausing) && (!VideoPlayerActivity.this.isVideoCompleted)) {
              VideoPlayerActivity.this.resumeVideo();
            } else {
              VideoPlayerActivity.this.playVideo(VideoPlayerActivity.this.currentVideoPosition);
            }
          }
        }
      });
      localButton2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (VideoPlayerActivity.this.mVideoView != null)
          {
            VideoPlayerActivity.access$102(VideoPlayerActivity.this, true);
            VideoPlayerActivity.this.dismiss();
          }
        }
      });
      paramRelativeLayout.addView(localRelativeLayout, localLayoutParams1);
      return;
      this.pausePlay.setBackgroundResource(17301540);
    }
  }
  
  private void initRedirectListener()
  {
    this.redirectListenerImpl = new VideoRedirectionListener(this);
  }
  
  private void initVideoListeners()
  {
    this.mVideoView.setOnCompletionListener(this);
    this.mVideoView.setOnPreparedListener(this);
    this.mVideoView.setOnErrorListener(this);
  }
  
  private void initWindow()
  {
    requestWindowFeature(1);
    getWindow().clearFlags(2048);
    getWindow().addFlags(1024);
  }
  
  private boolean isActionSupported(String paramString)
  {
    return (paramString != null) && ((paramString.equalsIgnoreCase("restartVideo")) || (paramString.equalsIgnoreCase("endVideo")));
  }
  
  private boolean isActionable(Uri paramUri)
  {
    if (paramUri.getScheme().equalsIgnoreCase("mmsdk"))
    {
      if (isActionSupported(paramUri.getHost())) {
        return true;
      }
      MMSDK.Log.v("Unrecognized mmsdk:// URI %s.", new Object[] { paramUri });
    }
    return false;
  }
  
  private void makeTransparent()
  {
    if (!this.transparentHandler.hasMessages(4)) {
      this.transparentHandler.sendEmptyMessage(4);
    }
  }
  
  private void startVideo(int paramInt)
  {
    this.mVideoView.requestFocus();
    this.mVideoView.seekTo(paramInt);
    if (((PowerManager)getSystemService("power")).isScreenOn())
    {
      if (this.progBar != null)
      {
        this.progBar.bringToFront();
        this.progBar.setVisibility(0);
      }
      if (this.pausePlay != null) {
        this.pausePlay.setBackgroundResource(17301539);
      }
      this.mVideoView.start();
      makeTransparent();
    }
  }
  
  protected boolean canFadeButtons()
  {
    return !this.isVideoCompleted;
  }
  
  protected void dismiss()
  {
    MMSDK.Log.d("Video ad player closed");
    if (this.mVideoView != null)
    {
      if (this.mVideoView.isPlaying()) {
        this.mVideoView.stopPlayback();
      }
      this.mVideoView = null;
    }
    finish();
  }
  
  void dispatchButtonClick(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      MMSDK.Log.d("Button Click with URL: %s", new Object[] { paramString });
      this.redirectListenerImpl.url = paramString;
      this.redirectListenerImpl.weakContext = new WeakReference(this.activity);
    } while (this.redirectListenerImpl.isHandlingMMVideo(Uri.parse(paramString)));
    HttpRedirection.startActivityFromUri(this.redirectListenerImpl);
  }
  
  protected void enableButtons() {}
  
  protected void endVideo()
  {
    MMSDK.Log.d("End Video.");
    if (this.mVideoView != null)
    {
      this.shouldSetUri = true;
      dismiss();
    }
  }
  
  protected void errorPlayVideo(String paramString)
  {
    Toast.makeText(this.activity, "Sorry. There was a problem playing the video", 1).show();
    if (this.mVideoView != null) {
      this.mVideoView.stopPlayback();
    }
  }
  
  void handleTransparentMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if ((this.mVideoView != null) && (this.mVideoView.isPlaying()) && (this.mVideoView.getCurrentPosition() > 0))
      {
        this.mVideoView.setBackgroundColor(0);
        this.transparentHandler.sendEmptyMessageDelayed(5, 100L);
        return;
      }
      this.transparentHandler.sendEmptyMessageDelayed(4, 50L);
      return;
    } while ((this.mVideoView == null) || (!this.mVideoView.isPlaying()) || (this.mVideoView.getCurrentPosition() <= 0));
    this.blackView.setVisibility(4);
    this.progBar.setVisibility(4);
  }
  
  protected RelativeLayout initLayout()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.activity);
    localRelativeLayout.setId(400);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localRelativeLayout.setBackgroundColor(-16777216);
    this.videoLayout = new RelativeLayout(this.activity);
    this.videoLayout.setBackgroundColor(-16777216);
    this.videoLayout.setId(410);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams2.addRule(13);
    localLayoutParams1.addRule(13);
    this.mVideoView = new VideoView(this.activity);
    this.mVideoView.setId(411);
    this.mVideoView.getHolder().setFormat(-2);
    this.mVideoView.setBackgroundColor(-16777216);
    initVideoListeners();
    this.videoLayout.addView(this.mVideoView, localLayoutParams2);
    this.blackView = new View(this.activity);
    this.blackView.setBackgroundColor(-16777216);
    localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    localRelativeLayout.addView(this.videoLayout, localLayoutParams1);
    if (this.hasBottomBar)
    {
      localLayoutParams2.addRule(2, 83756563);
      initBottomBar(localRelativeLayout);
    }
    this.blackView.setLayoutParams(localLayoutParams2);
    localRelativeLayout.addView(this.blackView);
    this.progBar = new ProgressBar(this.activity);
    this.progBar.setIndeterminate(true);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(13);
    this.progBar.setLayoutParams(localLayoutParams1);
    localRelativeLayout.addView(this.progBar);
    this.progBar.setVisibility(4);
    return localRelativeLayout;
  }
  
  protected void initSavedInstance(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.isVideoCompleted = paramBundle.getBoolean("videoCompleted");
      this.isVideoCompletedOnce = paramBundle.getBoolean("videoCompletedOnce");
      this.currentVideoPosition = paramBundle.getInt("videoPosition");
      this.hasBottomBar = paramBundle.getBoolean("hasBottomBar");
      this.shouldSetUri = paramBundle.getBoolean("shouldSetUri");
    }
  }
  
  protected boolean isPlayable()
  {
    return (this.mVideoView != null) && (!this.mVideoView.isPlaying()) && (!this.isVideoCompleted);
  }
  
  protected void logButtonEvent(VideoImage paramVideoImage)
  {
    MMSDK.Log.d("Cached video button event logged");
    int i = 0;
    while (i < paramVideoImage.eventLoggingUrls.length)
    {
      MMSDK.Event.logEvent(paramVideoImage.eventLoggingUrls[i]);
      i += 1;
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.isVideoCompletedOnce = true;
    this.isVideoCompleted = true;
    if ((this.pausePlay != null) && (!this.mVideoView.isPlaying())) {
      this.pausePlay.setBackgroundResource(17301540);
    }
    MMSDK.Log.v("Video player on complete");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    setTheme(16973829);
    super.onCreate(paramBundle);
    MMSDK.Log.d("Setting up the video player");
    initWindow();
    initSavedInstance(paramBundle);
    initRedirectListener();
    setContentView(initLayout());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0) && (!this.isVideoCompletedOnce)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.isPaused = true;
    MMSDK.Log.v("VideoPlayer - onPause");
    pauseVideo();
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    MMSDK.Log.d("Video Prepared");
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    this.currentVideoPosition = paramBundle.getInt("currentVideoPosition");
    this.isVideoCompleted = paramBundle.getBoolean("isVideoCompleted");
    this.isVideoCompletedOnce = paramBundle.getBoolean("isVideoCompletedOnce");
    this.hasBottomBar = paramBundle.getBoolean("hasBottomBar", this.hasBottomBar);
    this.shouldSetUri = paramBundle.getBoolean("shouldSetUri", this.shouldSetUri);
    this.isUserPausing = paramBundle.getBoolean("isUserPausing", this.isUserPausing);
    this.isPaused = paramBundle.getBoolean("isPaused", this.isPaused);
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.blackView.bringToFront();
    this.blackView.setVisibility(0);
    this.isPaused = false;
    MMSDK.Log.v("VideoPlayer - onResume");
    if ((this.hasFocus) && (!this.isUserPausing)) {
      resumeVideo();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("currentVideoPosition", this.currentVideoPosition);
    paramBundle.putBoolean("isVideoCompleted", this.isVideoCompleted);
    paramBundle.putBoolean("isVideoCompletedOnce", this.isVideoCompletedOnce);
    paramBundle.putBoolean("hasBottomBar", this.hasBottomBar);
    paramBundle.putBoolean("shouldSetUri", this.shouldSetUri);
    paramBundle.putBoolean("isUserPausing", this.isUserPausing);
    paramBundle.putBoolean("isPaused", this.isPaused);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.hasFocus = paramBoolean;
    if ((!this.isPaused) && (paramBoolean) && (!this.isUserPausing)) {
      resumeVideo();
    }
  }
  
  protected void pauseVideo()
  {
    if ((this.mVideoView != null) && (this.mVideoView.isPlaying()))
    {
      this.currentVideoPosition = this.mVideoView.getCurrentPosition();
      this.mVideoView.pause();
      MMSDK.Log.v("Video paused");
    }
  }
  
  protected void pauseVideoByUser()
  {
    this.isUserPausing = true;
    pauseVideo();
  }
  
  protected void playVideo(int paramInt)
  {
    try
    {
      this.isUserPausing = false;
      String str = getIntent().getData().toString();
      MMSDK.Log.d("playVideo path: %s", new Object[] { str });
      if ((str == null) || (str.length() == 0) || (this.mVideoView == null))
      {
        errorPlayVideo("no name or null videoview");
        return;
      }
      this.isVideoCompleted = false;
      if ((this.shouldSetUri) && (this.mVideoView != null)) {
        this.mVideoView.setVideoURI(Uri.parse(str));
      }
      startVideo(paramInt);
      return;
    }
    catch (Exception localException)
    {
      MMSDK.Log.e("error: " + localException.getMessage(), new Object[] { localException });
      errorPlayVideo("error: " + localException.getMessage());
    }
  }
  
  void processVideoPlayerUri(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (paramString.equalsIgnoreCase("restartVideo")) {
          VideoPlayerActivity.this.restartVideo();
        }
        while (!paramString.equalsIgnoreCase("endVideo")) {
          return;
        }
        VideoPlayerActivity.this.endVideo();
      }
    });
  }
  
  protected void restartVideo()
  {
    MMSDK.Log.d("Restart Video.");
    if (this.mVideoView != null) {
      playVideo(0);
    }
  }
  
  protected void resumeVideo()
  {
    if (isPlayable()) {
      playVideo(this.currentVideoPosition);
    }
  }
  
  protected void setButtonAlpha(ImageButton paramImageButton, float paramFloat)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setFillBefore(true);
    localAlphaAnimation.setFillAfter(true);
    paramImageButton.startAnimation(localAlphaAnimation);
  }
  
  private static class TransparentHandler
    extends Handler
  {
    private WeakReference<VideoPlayerActivity> activityRef;
    
    public TransparentHandler(VideoPlayerActivity paramVideoPlayerActivity)
    {
      this.activityRef = new WeakReference(paramVideoPlayerActivity);
    }
    
    public void handleMessage(Message paramMessage)
    {
      VideoPlayerActivity localVideoPlayerActivity = (VideoPlayerActivity)this.activityRef.get();
      if (localVideoPlayerActivity != null) {
        localVideoPlayerActivity.handleTransparentMessage(paramMessage);
      }
    }
  }
  
  static class VideoRedirectionListener
    extends HttpRedirection.RedirectionListenerImpl
  {
    WeakReference<VideoPlayerActivity> activityRef;
    
    public VideoRedirectionListener(VideoPlayerActivity paramVideoPlayerActivity)
    {
      if (paramVideoPlayerActivity != null)
      {
        this.activityRef = new WeakReference(paramVideoPlayerActivity);
        if (paramVideoPlayerActivity.activity != null) {
          this.creatorAdImplInternalId = paramVideoPlayerActivity.activity.creatorAdImplInternalId;
        }
      }
    }
    
    public JSONObject getAdProperties()
    {
      VideoPlayerActivity localVideoPlayerActivity = (VideoPlayerActivity)this.activityRef.get();
      if ((localVideoPlayerActivity != null) && (localVideoPlayerActivity.adProperties != null)) {
        return localVideoPlayerActivity.adProperties.getAdProperties();
      }
      return null;
    }
    
    public OverlaySettings getOverlaySettings()
    {
      Object localObject2 = null;
      VideoPlayerActivity localVideoPlayerActivity = (VideoPlayerActivity)this.activityRef.get();
      Object localObject1 = localObject2;
      if (localVideoPlayerActivity != null)
      {
        localObject1 = localObject2;
        if (localVideoPlayerActivity.lastOverlayOrientation != null)
        {
          localObject1 = new OverlaySettings();
          ((OverlaySettings)localObject1).orientation = localVideoPlayerActivity.lastOverlayOrientation;
        }
      }
      return (OverlaySettings)localObject1;
    }
    
    public boolean isHandlingMMVideo(Uri paramUri)
    {
      final VideoPlayerActivity localVideoPlayerActivity = (VideoPlayerActivity)this.activityRef.get();
      if (localVideoPlayerActivity != null)
      {
        localVideoPlayerActivity.runOnUiThread(new Runnable()
        {
          public void run()
          {
            localVideoPlayerActivity.enableButtons();
          }
        });
        if ((paramUri != null) && (localVideoPlayerActivity.isActionable(paramUri)))
        {
          localVideoPlayerActivity.processVideoPlayerUri(paramUri.getHost());
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/VideoPlayerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */