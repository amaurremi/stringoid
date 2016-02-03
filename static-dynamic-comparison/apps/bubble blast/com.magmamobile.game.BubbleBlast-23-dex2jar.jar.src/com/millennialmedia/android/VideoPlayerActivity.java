package com.millennialmedia.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoPlayerActivity
  extends MMBaseActivity
  implements Handler.Callback, HttpRedirection.Listener
{
  private static final int MESSAGE_DELAYED_BUTTON = 3;
  private static final int MESSAGE_EVENTLOG_CHECK = 2;
  private static final int MESSAGE_INACTIVITY_ANIMATION = 1;
  private RelativeLayout buttonsLayout;
  private RelativeLayout controlsLayout;
  private String current;
  private int currentVideoPosition = 0;
  private Handler handler;
  private TextView hudSeconds;
  private TextView hudStaticText;
  private boolean isCachedAd;
  private int lastVideoPosition;
  private Button mPausePlay;
  private Button mRewind;
  private Button mStop;
  private VideoView mVideoView;
  private boolean paused = false;
  private ScreenReceiver receiver;
  private RelativeLayout relLayout;
  private boolean showBottomBar = true;
  private boolean showCountdownHud = true;
  View testView;
  private VideoAd videoAd;
  private boolean videoCompleted;
  private boolean videoCompletedOnce;
  protected VideoServer videoServer;
  private boolean waitForUserPresent;
  
  private boolean canFadeButtons()
  {
    return (!this.videoAd.stayInPlayer) || (!this.videoCompleted);
  }
  
  private void dismiss()
  {
    MMAdViewSDK.Log.d("Video ad player closed");
    if (this.mVideoView != null) {
      this.mVideoView.stopPlayback();
    }
    finish();
  }
  
  private void dispatchButtonClick(String paramString1, String paramString2, ImageButton paramImageButton)
  {
    if (paramImageButton != null) {
      paramImageButton.setEnabled(false);
    }
    if (paramString1 == null) {
      return;
    }
    MMAdViewSDK.Log.d("Button Click with URL: %s", new Object[] { paramString1 });
    paramImageButton = new OverlaySettings();
    if (paramString2 != null) {
      paramImageButton.orientation = paramString2;
    }
    paramImageButton.shouldLaunchToOverlay = true;
    HttpRedirection.startActivityFromUri(this.activity, paramString1, paramImageButton, this, null);
  }
  
  private void hideHud()
  {
    if (this.hudStaticText != null) {
      this.hudStaticText.setVisibility(4);
    }
    if (this.hudSeconds != null) {
      this.hudSeconds.setVisibility(4);
    }
  }
  
  private void pauseVideo()
  {
    if (this.mVideoView != null)
    {
      if (this.mVideoView.isPlaying())
      {
        this.mVideoView.pause();
        this.paused = true;
        MMAdViewSDK.Log.v("Video paused");
      }
      this.currentVideoPosition = this.mVideoView.getCurrentPosition();
    }
    if (this.isCachedAd)
    {
      this.handler.removeMessages(1);
      this.handler.removeMessages(2);
      this.handler.removeMessages(3);
      stopServer();
    }
  }
  
  private void playVideo(int paramInt)
  {
    try
    {
      String str = getIntent().getData().toString();
      MMAdViewSDK.Log.d("playVideo path: %s", new Object[] { str });
      if ((str == null) || (str.length() == 0))
      {
        Toast.makeText(this.activity, "Sorry. There was a problem playing the video", 1).show();
        if (this.videoAd != null) {
          HttpGetRequest.log(this.videoAd.videoError);
        }
      }
      else
      {
        this.videoCompleted = false;
        if ((str.equals(this.current)) && (this.mVideoView != null)) {
          if (this.isCachedAd)
          {
            if (this.videoAd == null) {
              return;
            }
            if (this.videoAd.storedOnSdCard)
            {
              this.mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
              {
                public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
                {
                  MMAdViewSDK.Log.d("Video Playing Complete");
                  if (VideoPlayerActivity.this.showCountdownHud) {
                    VideoPlayerActivity.this.hideHud();
                  }
                  if (VideoPlayerActivity.this.videoAd != null) {
                    VideoPlayerActivity.this.videoPlayerOnCompletion(VideoPlayerActivity.this.videoAd.onCompletionUrl);
                  }
                }
              });
              this.mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
              {
                public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
                {
                  MMAdViewSDK.Log.d("Video Prepared");
                }
              });
              this.mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener()
              {
                public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
                {
                  if (VideoPlayerActivity.this.videoAd != null) {
                    HttpGetRequest.log(VideoPlayerActivity.this.videoAd.videoError);
                  }
                  return false;
                }
              });
              this.mVideoView.setVideoURI(Uri.parse(str));
              this.mVideoView.requestFocus();
              this.mVideoView.seekTo(paramInt);
              this.mVideoView.start();
              this.paused = false;
              return;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      MMAdViewSDK.Log.e("error: " + localException.getMessage(), new Object[] { localException });
      Toast.makeText(this.activity, "Sorry. There was a problem playing the video", 1).show();
      if (this.mVideoView != null) {
        this.mVideoView.stopPlayback();
      }
      if (this.videoAd != null)
      {
        HttpGetRequest.log(this.videoAd.videoError);
        return;
        startServer(localException, paramInt, false);
        return;
        this.mVideoView.requestFocus();
        this.mVideoView.seekTo(paramInt);
        this.mVideoView.start();
        this.paused = false;
        return;
        this.current = localException;
        if (this.mVideoView != null)
        {
          if (this.isCachedAd)
          {
            if (this.videoAd != null)
            {
              if (!this.videoAd.storedOnSdCard)
              {
                MMAdViewSDK.Log.d("Cached Ad. Starting Server");
                startServer(localException, paramInt, false);
                return;
              }
              this.mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
              {
                public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
                {
                  MMAdViewSDK.Log.d("Video Playing Complete");
                  if (VideoPlayerActivity.this.showCountdownHud) {
                    VideoPlayerActivity.this.hideHud();
                  }
                  if (VideoPlayerActivity.this.videoAd != null) {
                    VideoPlayerActivity.this.videoPlayerOnCompletion(VideoPlayerActivity.this.videoAd.onCompletionUrl);
                  }
                }
              });
              this.mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
              {
                public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
                {
                  MMAdViewSDK.Log.d("Video Prepared");
                }
              });
              this.mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener()
              {
                public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
                {
                  if (VideoPlayerActivity.this.videoAd != null) {
                    HttpGetRequest.log(VideoPlayerActivity.this.videoAd.videoError);
                  }
                  return false;
                }
              });
              this.mVideoView.setVideoURI(Uri.parse(localException));
              this.mVideoView.requestFocus();
              this.mVideoView.seekTo(paramInt);
              this.mVideoView.start();
              this.paused = false;
            }
          }
          else
          {
            this.mVideoView.setVideoURI(Uri.parse(localException));
            this.mVideoView.requestFocus();
            this.mVideoView.seekTo(paramInt);
            this.mVideoView.start();
            this.paused = false;
          }
        }
        else {
          MMAdViewSDK.Log.e("Video Player is Null");
        }
      }
    }
  }
  
  private void resumeVideo()
  {
    if ((this.mVideoView != null) && (!this.mVideoView.isPlaying()) && (!this.videoCompleted))
    {
      if ((this.isCachedAd) && (!this.handler.hasMessages(2)) && (this.videoAd != null))
      {
        this.handler.sendMessageDelayed(Message.obtain(this.handler, 2), 1000L);
        long l1;
        if (this.showCountdownHud)
        {
          l1 = (this.videoAd.duration - this.currentVideoPosition) / 1000L;
          if (l1 <= 0L) {
            break label286;
          }
          if (this.hudSeconds != null) {
            this.hudSeconds.setText(String.valueOf(l1));
          }
        }
        for (;;)
        {
          int i = 0;
          while (i < this.videoAd.buttons.size())
          {
            VideoImage localVideoImage = (VideoImage)this.videoAd.buttons.get(i);
            long l2 = 0L;
            l1 = l2;
            Message localMessage;
            if (localVideoImage.appearanceDelay > 0L)
            {
              l1 = l2;
              if (this.buttonsLayout.indexOfChild(localVideoImage.button) == -1)
              {
                localMessage = Message.obtain(this.handler, 3, localVideoImage);
                l2 = localVideoImage.appearanceDelay - this.currentVideoPosition;
                l1 = l2;
                if (l2 < 0L) {
                  l1 = 500L;
                }
                this.handler.sendMessageDelayed(localMessage, l1);
              }
            }
            if (localVideoImage.inactivityTimeout > 0L)
            {
              localMessage = Message.obtain(this.handler, 1, localVideoImage);
              this.handler.sendMessageDelayed(localMessage, localVideoImage.inactivityTimeout + l1 + localVideoImage.fadeDuration);
            }
            i += 1;
          }
          label286:
          hideHud();
        }
      }
      playVideo(this.currentVideoPosition);
    }
  }
  
  private void setButtonAlpha(ImageButton paramImageButton, float paramFloat)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setFillBefore(true);
    localAlphaAnimation.setFillAfter(true);
    paramImageButton.startAnimation(localAlphaAnimation);
  }
  
  private void showHud(boolean paramBoolean)
  {
    if ((this.hudStaticText == null) || (this.hudSeconds == null))
    {
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      this.hudStaticText = new TextView(this.activity);
      this.hudStaticText.setText(" seconds remaining ...");
      this.hudStaticText.setTextColor(-1);
      this.hudStaticText.setPadding(0, 0, 5, 0);
      this.hudSeconds = new TextView(this.activity);
      if (paramBoolean) {
        if (this.videoAd != null) {
          this.hudSeconds.setText(String.valueOf(this.videoAd.duration / 1000L));
        }
      }
      for (;;)
      {
        this.hudSeconds.setTextColor(-1);
        this.hudSeconds.setId(401);
        this.hudStaticText.setId(402);
        localLayoutParams1.addRule(10);
        localLayoutParams1.addRule(11);
        this.buttonsLayout.addView(this.hudStaticText, localLayoutParams1);
        localLayoutParams2.addRule(10);
        localLayoutParams2.addRule(0, this.hudStaticText.getId());
        this.buttonsLayout.addView(this.hudSeconds, localLayoutParams2);
        return;
        if (this.currentVideoPosition != 0) {
          this.hudSeconds.setText(String.valueOf(this.currentVideoPosition / 1000));
        } else if (this.videoAd != null) {
          this.hudSeconds.setText(String.valueOf(this.videoAd.duration / 1000L));
        }
      }
    }
    if (paramBoolean)
    {
      if (this.videoAd == null) {
        break label320;
      }
      this.hudSeconds.setText(String.valueOf(this.videoAd.duration / 1000L));
    }
    for (;;)
    {
      this.hudStaticText.setVisibility(0);
      this.hudSeconds.setVisibility(0);
      return;
      label320:
      this.hudSeconds.setText("");
    }
  }
  
  private void videoPlayerOnCompletion(String paramString)
  {
    this.videoCompletedOnce = true;
    this.videoCompleted = true;
    if (!this.mVideoView.isInErrorState()) {
      logEndEvent(this.videoAd);
    }
    stopServer();
    MMAdViewSDK.Log.v("Video player on complete");
    if (paramString != null) {
      dispatchButtonClick(paramString, null, null);
    }
    if (this.videoAd != null)
    {
      if (!this.videoAd.stayInPlayer) {
        dismiss();
      }
    }
    else {
      return;
    }
    if (this.videoAd.buttons != null)
    {
      int i = 0;
      while (i < this.videoAd.buttons.size())
      {
        paramString = (VideoImage)this.videoAd.buttons.get(i);
        setButtonAlpha(paramString.button, paramString.fromAlpha);
        if (paramString.button.getParent() == null) {
          this.buttonsLayout.addView(paramString.button, paramString.layoutParams);
        }
        int j = 0;
        while (j < this.videoAd.buttons.size())
        {
          this.buttonsLayout.bringChildToFront(((VideoImage)this.videoAd.buttons.get(j)).button);
          j += 1;
        }
        MMAdViewSDK.Log.v("Button: %d alpha: %f", new Object[] { Integer.valueOf(i), Float.valueOf(paramString.fromAlpha) });
        i += 1;
      }
    }
    this.handler.removeMessages(1);
    this.handler.removeMessages(2);
    this.handler.removeMessages(3);
  }
  
  public void didFailToResolveUri(Uri paramUri)
  {
    enableButtons();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.videoAd != null)
    {
      if (this.handler != null) {
        this.handler.removeMessages(1);
      }
      int i = 0;
      if (i < this.videoAd.buttons.size())
      {
        VideoImage localVideoImage = (VideoImage)this.videoAd.buttons.get(i);
        setButtonAlpha(localVideoImage.button, localVideoImage.fromAlpha);
        Object localObject;
        if (localVideoImage.inactivityTimeout > 0L)
        {
          localObject = Message.obtain(this.handler, 1, localVideoImage);
          this.handler.sendMessageDelayed((Message)localObject, localVideoImage.inactivityTimeout);
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramMotionEvent.getAction() == 1)
          {
            if (canFadeButtons())
            {
              localObject = new AlphaAnimation(localVideoImage.fromAlpha, localVideoImage.toAlpha);
              ((AlphaAnimation)localObject).setDuration(localVideoImage.fadeDuration);
              ((AlphaAnimation)localObject).setFillEnabled(true);
              ((AlphaAnimation)localObject).setFillBefore(true);
              ((AlphaAnimation)localObject).setFillAfter(true);
              localVideoImage.button.startAnimation((Animation)localObject);
            }
          }
          else if (paramMotionEvent.getAction() == 0) {
            setButtonAlpha(localVideoImage.button, localVideoImage.fromAlpha);
          }
        }
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  void enableButtons()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        Object localObject = null;
        if (VideoPlayerActivity.this.videoAd != null) {
          localObject = VideoPlayerActivity.this.videoAd.buttons;
        }
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            VideoImage localVideoImage = (VideoImage)((Iterator)localObject).next();
            if (localVideoImage.button != null) {
              localVideoImage.button.setEnabled(true);
            }
          }
        }
      }
    });
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 3: 
      for (;;)
      {
        return true;
        if (canFadeButtons())
        {
          paramMessage = (VideoImage)paramMessage.obj;
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramMessage.fromAlpha, paramMessage.toAlpha);
          localAlphaAnimation.setDuration(paramMessage.fadeDuration);
          localAlphaAnimation.setFillEnabled(true);
          localAlphaAnimation.setFillBefore(true);
          localAlphaAnimation.setFillAfter(true);
          paramMessage.button.startAnimation(localAlphaAnimation);
          continue;
          paramMessage = (VideoImage)paramMessage.obj;
          try
          {
            if (this.buttonsLayout.indexOfChild(paramMessage.button) == -1) {
              this.buttonsLayout.addView(paramMessage.button, paramMessage.layoutParams);
            }
            localAlphaAnimation = new AlphaAnimation(paramMessage.toAlpha, paramMessage.fromAlpha);
            localAlphaAnimation.setDuration(paramMessage.fadeDuration);
            localAlphaAnimation.setAnimationListener(new DelayedAnimationListener(paramMessage.button, paramMessage.layoutParams));
            localAlphaAnimation.setFillEnabled(true);
            localAlphaAnimation.setFillBefore(true);
            localAlphaAnimation.setFillAfter(true);
            MMAdViewSDK.Log.v("Beginning animation to visibility. Fade duration: %d Button: %d Time: %d", new Object[] { Long.valueOf(paramMessage.fadeDuration), Integer.valueOf(paramMessage.button.getId()), Long.valueOf(System.currentTimeMillis()) });
            paramMessage.button.startAnimation(localAlphaAnimation);
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              localIllegalStateException.printStackTrace();
            }
          }
        }
      }
    }
    for (;;)
    {
      int k;
      try
      {
        if (!this.mVideoView.isPlaying()) {
          break label495;
        }
        k = this.mVideoView.getCurrentPosition();
        if (k <= this.lastVideoPosition) {
          break label445;
        }
        if (this.videoAd == null) {
          break label439;
        }
        if (this.lastVideoPosition != 0) {
          break label524;
        }
        logBeginEvent(this.videoAd);
      }
      catch (IllegalStateException paramMessage)
      {
        int j;
        int m;
        paramMessage.printStackTrace();
      }
      if (i < this.videoAd.activities.size())
      {
        paramMessage = (VideoLogEvent)this.videoAd.activities.get(i);
        if ((paramMessage != null) && (paramMessage.position >= this.lastVideoPosition) && (paramMessage.position < k))
        {
          j = 0;
          m = paramMessage.activities.length;
          if (j < m)
          {
            try
            {
              logEvent(paramMessage.activities[j]);
              j += 1;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              localUnsupportedEncodingException.printStackTrace();
              continue;
            }
            break;
          }
        }
        i += 1;
        continue;
      }
      label439:
      this.lastVideoPosition = k;
      label445:
      if (this.showCountdownHud)
      {
        long l = (this.videoAd.duration - k) / 1000L;
        if (l <= 0L) {
          break label517;
        }
        if (this.hudSeconds != null) {
          this.hudSeconds.setText(String.valueOf(l));
        }
      }
      for (;;)
      {
        label495:
        this.handler.sendMessageDelayed(Message.obtain(this.handler, 2), 1000L);
        break;
        label517:
        hideHud();
      }
      label524:
      int i = 0;
    }
  }
  
  protected void logBeginEvent(VideoAd paramVideoAd)
  {
    if ((paramVideoAd != null) && (paramVideoAd.startActivity != null)) {
      try
      {
        MMAdViewSDK.Log.d("Cached video begin event logged");
        int i = 0;
        while (i < paramVideoAd.startActivity.length)
        {
          logEvent(paramVideoAd.startActivity[i]);
          i += 1;
        }
        return;
      }
      catch (UnsupportedEncodingException paramVideoAd)
      {
        paramVideoAd.printStackTrace();
      }
    }
  }
  
  protected void logButtonEvent(VideoImage paramVideoImage)
  {
    MMAdViewSDK.Log.d("Cached video button event logged");
    int i = 0;
    try
    {
      while (i < paramVideoImage.activity.length)
      {
        logEvent(paramVideoImage.activity[i]);
        i += 1;
      }
      return;
    }
    catch (UnsupportedEncodingException paramVideoImage)
    {
      paramVideoImage.printStackTrace();
    }
  }
  
  protected void logEndEvent(VideoAd paramVideoAd)
  {
    MMAdViewSDK.Log.d("Cached video end event logged");
    int i = 0;
    try
    {
      while (i < paramVideoAd.endActivity.length)
      {
        logEvent(paramVideoAd.endActivity[i]);
        i += 1;
      }
      return;
    }
    catch (UnsupportedEncodingException paramVideoAd)
    {
      paramVideoAd.printStackTrace();
    }
  }
  
  protected void logEvent(final String paramString)
    throws UnsupportedEncodingException
  {
    MMAdViewSDK.Log.d("Logging event to: %s", new Object[] { paramString });
    new Thread(new Runnable()
    {
      public void run()
      {
        HttpGetRequest localHttpGetRequest = new HttpGetRequest();
        try
        {
          localHttpGetRequest.get(paramString);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }).start();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    setTheme(16973829);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().clearFlags(2048);
    getWindow().addFlags(1024);
    MMAdViewSDK.Log.d("Setting up the video player");
    Object localObject1;
    Object localObject2;
    final Object localObject3;
    label473:
    int i;
    label542:
    final Object localObject4;
    if (paramBundle != null)
    {
      this.isCachedAd = paramBundle.getBoolean("isCachedAd");
      this.videoCompleted = paramBundle.getBoolean("videoCompleted");
      this.videoCompletedOnce = paramBundle.getBoolean("videoCompletedOnce");
      this.currentVideoPosition = paramBundle.getInt("videoPosition");
      this.lastVideoPosition = paramBundle.getInt("lastVideoPosition");
      this.receiver = new ScreenReceiver(null);
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject1).addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.receiver, (IntentFilter)localObject1);
      this.relLayout = new RelativeLayout(this.activity);
      this.relLayout.setId(400);
      this.relLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.relLayout.setBackgroundColor(-16777216);
      this.relLayout.setDrawingCacheBackgroundColor(-16777216);
      localObject1 = new RelativeLayout(this.activity);
      ((RelativeLayout)localObject1).setBackgroundColor(-16777216);
      ((RelativeLayout)localObject1).setId(410);
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).setDrawingCacheBackgroundColor(-16777216);
      localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      this.mVideoView = new VideoView(this.activity);
      this.mVideoView.setId(411);
      this.mVideoView.getHolder().setFormat(-2);
      ((RelativeLayout)localObject1).addView(this.mVideoView, (ViewGroup.LayoutParams)localObject3);
      this.mVideoView.setDrawingCacheBackgroundColor(-16777216);
      this.relLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject1 = new RelativeLayout.LayoutParams(-1, -1);
      MMAdViewSDK.Log.v("Is Cached Ad: %b", new Object[] { Boolean.valueOf(this.isCachedAd) });
      if (!this.isCachedAd) {
        break label1459;
      }
      this.handler = new Handler(this);
      setRequestedOrientation(0);
      if (paramBundle != null) {
        break label986;
      }
      paramBundle = getIntent().getStringExtra("videoId");
      this.videoAd = ((VideoAd)AdCache.load(this.activity, paramBundle));
      if (this.videoAd != null)
      {
        this.showBottomBar = this.videoAd.showControls;
        this.showCountdownHud = this.videoAd.showCountdown;
      }
      this.buttonsLayout = new RelativeLayout(this.activity);
      this.buttonsLayout.setId(1000);
      if (this.showCountdownHud) {
        showHud(false);
      }
      paramBundle = null;
      if (this.videoAd != null) {
        paramBundle = this.videoAd.buttons;
      }
      if (paramBundle == null) {
        break label1129;
      }
      localObject2 = AdCache.getCacheDirectory(this.activity);
      i = 0;
      if (i >= paramBundle.size()) {
        break label1117;
      }
      localObject3 = (VideoImage)paramBundle.get(i);
      localObject4 = new ImageButton(this.activity);
      ((VideoImage)localObject3).button = ((ImageButton)localObject4);
    }
    for (;;)
    {
      try
      {
        localObject5 = BitmapFactory.decodeFile(((File)localObject2).getAbsolutePath() + File.separator + this.videoAd.id + Uri.parse(((VideoImage)localObject3).imageUrl).getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat"));
        if (localObject5 == null) {
          continue;
        }
        ((ImageButton)localObject4).setImageBitmap((Bitmap)localObject5);
      }
      catch (Exception localException)
      {
        Object localObject5;
        label986:
        MMAdViewSDK.Log.e(localException);
        continue;
        this.buttonsLayout.addView((View)localObject4, localException);
        continue;
      }
      ((ImageButton)localObject4).setPadding(0, 0, 0, 0);
      ((ImageButton)localObject4).setBackgroundColor(0);
      setButtonAlpha((ImageButton)localObject4, ((VideoImage)localObject3).fromAlpha);
      ((ImageButton)localObject4).setId(i + 1);
      localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      MMAdViewSDK.Log.v("Button: %d Anchor: %d Position: %d Anchor2: %d Position2: %d", new Object[] { Integer.valueOf(((ImageButton)localObject4).getId()), Integer.valueOf(((VideoImage)localObject3).anchor), Integer.valueOf(((VideoImage)localObject3).position), Integer.valueOf(((VideoImage)localObject3).anchor2), Integer.valueOf(((VideoImage)localObject3).position2) });
      ((RelativeLayout.LayoutParams)localObject5).addRule(((VideoImage)localObject3).position, ((VideoImage)localObject3).anchor);
      ((RelativeLayout.LayoutParams)localObject5).addRule(((VideoImage)localObject3).position2, ((VideoImage)localObject3).anchor2);
      ((RelativeLayout.LayoutParams)localObject5).setMargins(((VideoImage)localObject3).paddingLeft, ((VideoImage)localObject3).paddingTop, ((VideoImage)localObject3).paddingRight, ((VideoImage)localObject3).paddingBottom);
      if (!TextUtils.isEmpty(((VideoImage)localObject3).linkUrl)) {
        ((ImageButton)localObject4).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            VideoPlayerActivity.this.dispatchButtonClick(localObject3.linkUrl, localObject3.overlayOrientation, localObject4);
            VideoPlayerActivity.this.logButtonEvent(localObject3);
          }
        });
      }
      if (((VideoImage)localObject3).appearanceDelay <= 0L) {
        continue;
      }
      ((VideoImage)localObject3).layoutParams = ((RelativeLayout.LayoutParams)localObject5);
      localObject4 = Message.obtain(this.handler, 3, localObject3);
      this.handler.sendMessageDelayed((Message)localObject4, ((VideoImage)localObject3).appearanceDelay);
      if (((VideoImage)localObject3).inactivityTimeout > 0L)
      {
        localObject4 = Message.obtain(this.handler, 1, localObject3);
        this.handler.sendMessageDelayed((Message)localObject4, ((VideoImage)localObject3).inactivityTimeout + ((VideoImage)localObject3).appearanceDelay + ((VideoImage)localObject3).fadeDuration);
      }
      i += 1;
      break label542;
      this.isCachedAd = getIntent().getBooleanExtra("cached", false);
      this.currentVideoPosition = 0;
      this.videoCompletedOnce = false;
      this.videoCompleted = false;
      break;
      this.videoAd = ((VideoAd)paramBundle.getParcelable("videoAd"));
      this.showBottomBar = paramBundle.getBoolean("shouldShowBottomBar");
      this.showCountdownHud = this.videoAd.showCountdown;
      break label473;
      ((ImageButton)localObject4).setImageURI(Uri.parse(((File)localObject2).getAbsolutePath() + File.separator + this.videoAd.id + Uri.parse(((VideoImage)localObject3).imageUrl).getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat")));
    }
    label1117:
    this.relLayout.addView(this.buttonsLayout, (ViewGroup.LayoutParams)localObject1);
    for (;;)
    {
      label1129:
      if (this.showBottomBar)
      {
        this.controlsLayout = new RelativeLayout(this.activity);
        this.controlsLayout.setBackgroundColor(-16777216);
        paramBundle = new RelativeLayout.LayoutParams(-1, -2);
        this.controlsLayout.setLayoutParams(paramBundle);
        paramBundle.addRule(12);
        this.mRewind = new Button(this.activity);
        this.mPausePlay = new Button(this.activity);
        this.mStop = new Button(this.activity);
        this.mRewind.setBackgroundResource(17301541);
        this.mPausePlay.setBackgroundResource(17301539);
        this.mStop.setBackgroundResource(17301560);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        this.controlsLayout.addView(this.mPausePlay, (ViewGroup.LayoutParams)localObject1);
        ((RelativeLayout.LayoutParams)localObject3).addRule(0, this.mPausePlay.getId());
        this.controlsLayout.addView(this.mRewind);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        this.controlsLayout.addView(this.mStop, (ViewGroup.LayoutParams)localObject2);
        this.mRewind.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (VideoPlayerActivity.this.mVideoView != null) {
              VideoPlayerActivity.this.mVideoView.seekTo(0);
            }
          }
        });
        this.mPausePlay.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (VideoPlayerActivity.this.paused)
            {
              if (VideoPlayerActivity.this.mVideoView != null) {
                VideoPlayerActivity.this.playVideo(VideoPlayerActivity.this.mVideoView.getCurrentPosition());
              }
              VideoPlayerActivity.this.mPausePlay.setBackgroundResource(17301539);
              VideoPlayerActivity.access$302(VideoPlayerActivity.this, false);
            }
            while (VideoPlayerActivity.this.mVideoView == null) {
              return;
            }
            VideoPlayerActivity.this.mVideoView.pause();
            VideoPlayerActivity.this.mPausePlay.setBackgroundResource(17301540);
            VideoPlayerActivity.access$302(VideoPlayerActivity.this, true);
          }
        });
        this.mStop.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (VideoPlayerActivity.this.mVideoView != null)
            {
              VideoPlayerActivity.access$602(VideoPlayerActivity.this, null);
              VideoPlayerActivity.this.mVideoView.stopPlayback();
              VideoPlayerActivity.this.dismiss();
            }
          }
        });
        this.relLayout.addView(this.controlsLayout, paramBundle);
      }
      if (this.controlsLayout != null) {
        this.controlsLayout.bringToFront();
      }
      if (this.buttonsLayout != null) {
        this.relLayout.bringChildToFront(this.buttonsLayout);
      }
      setContentView(this.relLayout);
      return;
      label1459:
      this.testView = new View(this.activity);
      this.testView.setBackgroundColor(-16777216);
      this.relLayout.addView(this.testView, new RelativeLayout.LayoutParams(-1, -1));
      this.mVideoView.setCallBack(new VideoHackBgListener()
      {
        public void callback(long paramAnonymousLong)
        {
          VideoPlayerActivity.this.testView.postDelayed(new Runnable()
          {
            public void run()
            {
              if (VideoPlayerActivity.this.testView.getVisibility() != 4) {
                VideoPlayerActivity.this.testView.setVisibility(4);
              }
            }
          }, paramAnonymousLong);
        }
      });
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.receiver);
    if (this.isCachedAd) {
      stopServer();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0) && (!this.videoCompletedOnce)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    MMAdViewSDK.Log.v("VideoPlayer - onPause");
    if (!this.waitForUserPresent) {
      pauseVideo();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    MMAdViewSDK.Log.v("VideoPlayer - onResume");
    if (!this.waitForUserPresent) {
      resumeVideo();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.mVideoView != null)
    {
      paramBundle.putInt("videoPosition", this.mVideoView.getCurrentPosition());
      paramBundle.putInt("lastVideoPosition", this.lastVideoPosition);
    }
    paramBundle.putBoolean("isCachedAd", this.isCachedAd);
    paramBundle.putBoolean("videoCompleted", this.videoCompleted);
    paramBundle.putBoolean("videoCompletedOnce", this.videoCompletedOnce);
    paramBundle.putBoolean("shouldShowBottomBar", this.showBottomBar);
    paramBundle.putParcelable("videoAd", this.videoAd);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.videoAd != null) && (this.videoAd.stayInPlayer == true) && (this.videoCompleted == true) && (this.videoAd.buttons != null))
    {
      int i = 0;
      while (i < this.videoAd.buttons.size())
      {
        VideoImage localVideoImage = (VideoImage)this.videoAd.buttons.get(i);
        setButtonAlpha(localVideoImage.button, localVideoImage.fromAlpha);
        if (localVideoImage.button.getParent() == null) {
          this.buttonsLayout.addView(localVideoImage.button, localVideoImage.layoutParams);
        }
        int j = 0;
        while (j < this.videoAd.buttons.size())
        {
          this.buttonsLayout.bringChildToFront(((VideoImage)this.videoAd.buttons.get(j)).button);
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  boolean processVideoPlayerUri(Uri paramUri)
  {
    if (paramUri == null) {}
    String str;
    do
    {
      do
      {
        return false;
      } while (!paramUri.getScheme().equalsIgnoreCase("mmsdk"));
      str = paramUri.getHost();
    } while (str == null);
    if (str.equalsIgnoreCase("restartVideo"))
    {
      runOnUiThread(new Runnable()
      {
        public void run()
        {
          MMAdViewSDK.Log.d("Restart Video.");
          if ((VideoPlayerActivity.this.isCachedAd) && (VideoPlayerActivity.this.videoAd != null))
          {
            ArrayList localArrayList = VideoPlayerActivity.this.videoAd.buttons;
            if ((VideoPlayerActivity.this.buttonsLayout != null) && (localArrayList != null))
            {
              VideoPlayerActivity.this.handler.removeMessages(1);
              VideoPlayerActivity.this.handler.removeMessages(2);
              VideoPlayerActivity.this.handler.removeMessages(3);
              VideoPlayerActivity.access$1502(VideoPlayerActivity.this, 0);
              int i = 0;
              while (i < localArrayList.size())
              {
                VideoImage localVideoImage = (VideoImage)localArrayList.get(i);
                if (localVideoImage != null)
                {
                  Object localObject;
                  if (localVideoImage.appearanceDelay > 0L)
                  {
                    localObject = localVideoImage.button;
                    VideoPlayerActivity.this.buttonsLayout.removeView((View)localObject);
                    localObject = Message.obtain(VideoPlayerActivity.this.handler, 3, localVideoImage);
                    VideoPlayerActivity.this.handler.sendMessageDelayed((Message)localObject, localVideoImage.appearanceDelay);
                  }
                  if (localVideoImage.inactivityTimeout > 0L)
                  {
                    localObject = Message.obtain(VideoPlayerActivity.this.handler, 1, localVideoImage);
                    VideoPlayerActivity.this.handler.sendMessageDelayed((Message)localObject, localVideoImage.inactivityTimeout + localVideoImage.appearanceDelay + localVideoImage.fadeDuration);
                  }
                  if (VideoPlayerActivity.this.showCountdownHud) {
                    VideoPlayerActivity.this.showHud(true);
                  }
                  if (VideoPlayerActivity.this.handler != null) {
                    VideoPlayerActivity.this.handler.sendMessageDelayed(Message.obtain(VideoPlayerActivity.this.handler, 2), 1000L);
                  }
                }
                i += 1;
              }
            }
          }
          if (VideoPlayerActivity.this.mVideoView != null) {
            VideoPlayerActivity.this.playVideo(0);
          }
        }
      });
      return true;
    }
    if (str.equalsIgnoreCase("endVideo"))
    {
      runOnUiThread(new Runnable()
      {
        public void run()
        {
          MMAdViewSDK.Log.d("End Video.");
          if (VideoPlayerActivity.this.mVideoView != null)
          {
            VideoPlayerActivity.access$602(VideoPlayerActivity.this, null);
            VideoPlayerActivity.this.mVideoView.stopPlayback();
            if (VideoPlayerActivity.this.videoAd != null) {
              VideoPlayerActivity.this.dismiss();
            }
          }
        }
      });
      return true;
    }
    MMAdViewSDK.Log.v("Unrecognized mmsdk:// URI %s.", new Object[] { paramUri });
    return false;
  }
  
  public boolean shouldStartActivityForUri(Uri paramUri)
  {
    enableButtons();
    if (processVideoPlayerUri(paramUri)) {
      return false;
    }
    MMAdViewSDK.Log.d("Starting activity for %s", new Object[] { paramUri });
    return true;
  }
  
  /* Error */
  public void startServer(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1045	com/millennialmedia/android/VideoPlayerActivity:videoServer	Lcom/millennialmedia/android/VideoPlayerActivity$VideoServer;
    //   6: ifnonnull +176 -> 182
    //   9: aload_0
    //   10: new 57	com/millennialmedia/android/VideoPlayerActivity$VideoServer
    //   13: dup
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 238	com/millennialmedia/android/VideoPlayerActivity:activity	Lcom/millennialmedia/android/MMActivity;
    //   19: aload_1
    //   20: invokespecial 1048	com/millennialmedia/android/VideoPlayerActivity$VideoServer:<init>	(Lcom/millennialmedia/android/VideoPlayerActivity;Landroid/content/Context;Ljava/lang/String;)V
    //   23: putfield 1045	com/millennialmedia/android/VideoPlayerActivity:videoServer	Lcom/millennialmedia/android/VideoPlayerActivity$VideoServer;
    //   26: new 682	java/lang/Thread
    //   29: dup
    //   30: aload_0
    //   31: getfield 1045	com/millennialmedia/android/VideoPlayerActivity:videoServer	Lcom/millennialmedia/android/VideoPlayerActivity$VideoServer;
    //   34: invokespecial 686	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   37: astore 4
    //   39: aload 4
    //   41: invokevirtual 687	java/lang/Thread:start	()V
    //   44: aload 4
    //   46: invokevirtual 1050	java/lang/Thread:getId	()J
    //   49: pop2
    //   50: aload_0
    //   51: getfield 164	com/millennialmedia/android/VideoPlayerActivity:mVideoView	Lcom/millennialmedia/android/VideoView;
    //   54: ifnull +131 -> 185
    //   57: aload_0
    //   58: getfield 164	com/millennialmedia/android/VideoPlayerActivity:mVideoView	Lcom/millennialmedia/android/VideoView;
    //   61: new 365	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 366	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 1052
    //   71: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_0
    //   75: getfield 1045	com/millennialmedia/android/VideoPlayerActivity:videoServer	Lcom/millennialmedia/android/VideoPlayerActivity$VideoServer;
    //   78: getfield 1056	com/millennialmedia/android/VideoPlayerActivity$VideoServer:port	Ljava/lang/Integer;
    //   81: invokevirtual 1059	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: ldc_w 1061
    //   87: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_1
    //   91: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 1063
    //   97: invokevirtual 372	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 350	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   106: invokevirtual 354	com/millennialmedia/android/VideoView:setVideoURI	(Landroid/net/Uri;)V
    //   109: aload_0
    //   110: getfield 164	com/millennialmedia/android/VideoPlayerActivity:mVideoView	Lcom/millennialmedia/android/VideoView;
    //   113: new 24	com/millennialmedia/android/VideoPlayerActivity$16
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 1064	com/millennialmedia/android/VideoPlayerActivity$16:<init>	(Lcom/millennialmedia/android/VideoPlayerActivity;)V
    //   121: invokevirtual 336	com/millennialmedia/android/VideoView:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   124: aload_0
    //   125: getfield 164	com/millennialmedia/android/VideoPlayerActivity:mVideoView	Lcom/millennialmedia/android/VideoView;
    //   128: new 26	com/millennialmedia/android/VideoPlayerActivity$17
    //   131: dup
    //   132: aload_0
    //   133: invokespecial 1065	com/millennialmedia/android/VideoPlayerActivity$17:<init>	(Lcom/millennialmedia/android/VideoPlayerActivity;)V
    //   136: invokevirtual 341	com/millennialmedia/android/VideoView:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   139: aload_0
    //   140: getfield 164	com/millennialmedia/android/VideoPlayerActivity:mVideoView	Lcom/millennialmedia/android/VideoView;
    //   143: new 28	com/millennialmedia/android/VideoPlayerActivity$18
    //   146: dup
    //   147: aload_0
    //   148: invokespecial 1066	com/millennialmedia/android/VideoPlayerActivity$18:<init>	(Lcom/millennialmedia/android/VideoPlayerActivity;)V
    //   151: invokevirtual 346	com/millennialmedia/android/VideoView:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   154: aload_0
    //   155: getfield 164	com/millennialmedia/android/VideoPlayerActivity:mVideoView	Lcom/millennialmedia/android/VideoView;
    //   158: invokevirtual 357	com/millennialmedia/android/VideoView:requestFocus	()Z
    //   161: pop
    //   162: aload_0
    //   163: getfield 164	com/millennialmedia/android/VideoPlayerActivity:mVideoView	Lcom/millennialmedia/android/VideoView;
    //   166: iload_2
    //   167: invokevirtual 360	com/millennialmedia/android/VideoView:seekTo	(I)V
    //   170: aload_0
    //   171: getfield 164	com/millennialmedia/android/VideoPlayerActivity:mVideoView	Lcom/millennialmedia/android/VideoView;
    //   174: invokevirtual 363	com/millennialmedia/android/VideoView:start	()V
    //   177: aload_0
    //   178: iconst_0
    //   179: putfield 106	com/millennialmedia/android/VideoPlayerActivity:paused	Z
    //   182: aload_0
    //   183: monitorexit
    //   184: return
    //   185: ldc_w 1068
    //   188: invokestatic 392	com/millennialmedia/android/MMAdViewSDK$Log:e	(Ljava/lang/String;)V
    //   191: goto -9 -> 182
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	VideoPlayerActivity
    //   0	199	1	paramString	String
    //   0	199	2	paramInt	int
    //   0	199	3	paramBoolean	boolean
    //   37	8	4	localThread	Thread
    // Exception table:
    //   from	to	target	type
    //   2	182	194	finally
    //   185	191	194	finally
  }
  
  public void stopServer()
  {
    try
    {
      if (this.videoServer != null)
      {
        MMAdViewSDK.Log.d("Stop video server");
        if (this.mVideoView != null) {
          this.mVideoView.stopPlayback();
        }
        this.videoServer.requestStop();
        this.videoServer = null;
      }
      return;
    }
    finally {}
  }
  
  private class DelayedAnimationListener
    implements Animation.AnimationListener
  {
    private ImageButton button;
    private RelativeLayout.LayoutParams layoutParams;
    
    DelayedAnimationListener(ImageButton paramImageButton, RelativeLayout.LayoutParams paramLayoutParams)
    {
      this.button = paramImageButton;
      this.layoutParams = paramLayoutParams;
    }
    
    public void onAnimationEnd(Animation paramAnimation) {}
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  private class ScreenReceiver
    extends BroadcastReceiver
  {
    private ScreenReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
      {
        MMAdViewSDK.Log.v("VideoPlayerActivity - Screen off");
        VideoPlayerActivity.access$1702(VideoPlayerActivity.this, true);
      }
      do
      {
        return;
        if (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"))
        {
          MMAdViewSDK.Log.v("VideoPlayerActivity - Screen on");
          return;
        }
      } while (!paramIntent.getAction().equals("android.intent.action.USER_PRESENT"));
      MMAdViewSDK.Log.v("VideoPlayerActivity - Screen unlocked");
      VideoPlayerActivity.this.resumeVideo();
      VideoPlayerActivity.access$1702(VideoPlayerActivity.this, false);
    }
  }
  
  static abstract interface VideoHackBgListener
  {
    public abstract void callback(long paramLong);
  }
  
  private class VideoServer
    implements Runnable
  {
    private File cacheDir;
    boolean done = false;
    private final String fileName;
    Integer port;
    private ServerSocket serverSocket = null;
    
    public VideoServer(Context paramContext, String paramString)
    {
      this.fileName = paramString;
      this.cacheDir = AdCache.getCacheDirectory(paramContext);
      try
      {
        this.serverSocket = new ServerSocket();
        this.serverSocket.bind(null);
        this.serverSocket.setSoTimeout(0);
        this.port = new Integer(this.serverSocket.getLocalPort());
        MMAdViewSDK.Log.v("Video Server Port: %d", new Object[] { this.port });
        return;
      }
      catch (IOException this$1)
      {
        VideoPlayerActivity.this.printStackTrace();
      }
    }
    
    public void requestStop()
    {
      try
      {
        this.done = true;
        MMAdViewSDK.Log.v("Requested video server stop. Done: " + this.done);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 11
      //   3: aconst_null
      //   4: astore 9
      //   6: aconst_null
      //   7: astore 10
      //   9: sipush 1024
      //   12: newarray <illegal type>
      //   14: astore 23
      //   16: aload_0
      //   17: getfield 34	com/millennialmedia/android/VideoPlayerActivity$VideoServer:done	Z
      //   20: ifne +1433 -> 1453
      //   23: aload 11
      //   25: astore 17
      //   27: aload 10
      //   29: astore 19
      //   31: aload 9
      //   33: astore 16
      //   35: aload 11
      //   37: astore 21
      //   39: aload 10
      //   41: astore 18
      //   43: aload 9
      //   45: astore 15
      //   47: aload 11
      //   49: astore 13
      //   51: aload 10
      //   53: astore 14
      //   55: aload 9
      //   57: astore 12
      //   59: aload 11
      //   61: astore 22
      //   63: aload 10
      //   65: astore 20
      //   67: aload 9
      //   69: astore 11
      //   71: aload_0
      //   72: getfield 32	com/millennialmedia/android/VideoPlayerActivity$VideoServer:serverSocket	Ljava/net/ServerSocket;
      //   75: invokevirtual 106	java/net/ServerSocket:accept	()Ljava/net/Socket;
      //   78: astore 8
      //   80: aload 8
      //   82: astore 17
      //   84: aload 10
      //   86: astore 19
      //   88: aload 9
      //   90: astore 16
      //   92: aload 8
      //   94: astore 21
      //   96: aload 10
      //   98: astore 18
      //   100: aload 9
      //   102: astore 15
      //   104: aload 8
      //   106: astore 13
      //   108: aload 10
      //   110: astore 14
      //   112: aload 9
      //   114: astore 12
      //   116: aload 8
      //   118: astore 22
      //   120: aload 10
      //   122: astore 20
      //   124: aload 9
      //   126: astore 11
      //   128: ldc 108
      //   130: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   133: aload 8
      //   135: astore 17
      //   137: aload 10
      //   139: astore 19
      //   141: aload 9
      //   143: astore 16
      //   145: aload 8
      //   147: astore 21
      //   149: aload 10
      //   151: astore 18
      //   153: aload 9
      //   155: astore 15
      //   157: aload 8
      //   159: astore 13
      //   161: aload 10
      //   163: astore 14
      //   165: aload 9
      //   167: astore 12
      //   169: aload 8
      //   171: astore 22
      //   173: aload 10
      //   175: astore 20
      //   177: aload 9
      //   179: astore 11
      //   181: aload 8
      //   183: invokevirtual 114	java/net/Socket:getInputStream	()Ljava/io/InputStream;
      //   186: astore 24
      //   188: aload 8
      //   190: astore 17
      //   192: aload 10
      //   194: astore 19
      //   196: aload 9
      //   198: astore 16
      //   200: aload 8
      //   202: astore 21
      //   204: aload 10
      //   206: astore 18
      //   208: aload 9
      //   210: astore 15
      //   212: aload 8
      //   214: astore 13
      //   216: aload 10
      //   218: astore 14
      //   220: aload 9
      //   222: astore 12
      //   224: aload 8
      //   226: astore 22
      //   228: aload 10
      //   230: astore 20
      //   232: aload 9
      //   234: astore 11
      //   236: aload 8
      //   238: invokevirtual 118	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
      //   241: astore 9
      //   243: aload 8
      //   245: astore 17
      //   247: aload 10
      //   249: astore 19
      //   251: aload 9
      //   253: astore 16
      //   255: aload 8
      //   257: astore 21
      //   259: aload 10
      //   261: astore 18
      //   263: aload 9
      //   265: astore 15
      //   267: aload 8
      //   269: astore 13
      //   271: aload 10
      //   273: astore 14
      //   275: aload 9
      //   277: astore 12
      //   279: aload 8
      //   281: astore 22
      //   283: aload 10
      //   285: astore 20
      //   287: aload 9
      //   289: astore 11
      //   291: new 80	java/lang/StringBuilder
      //   294: dup
      //   295: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   298: astore 26
      //   300: aload 8
      //   302: astore 17
      //   304: aload 10
      //   306: astore 19
      //   308: aload 9
      //   310: astore 16
      //   312: aload 8
      //   314: astore 21
      //   316: aload 10
      //   318: astore 18
      //   320: aload 9
      //   322: astore 15
      //   324: aload 8
      //   326: astore 13
      //   328: aload 10
      //   330: astore 14
      //   332: aload 9
      //   334: astore 12
      //   336: aload 8
      //   338: astore 22
      //   340: aload 10
      //   342: astore 20
      //   344: aload 9
      //   346: astore 11
      //   348: aload 24
      //   350: aload 23
      //   352: invokevirtual 124	java/io/InputStream:read	([B)I
      //   355: pop
      //   356: aload 8
      //   358: astore 17
      //   360: aload 10
      //   362: astore 19
      //   364: aload 9
      //   366: astore 16
      //   368: aload 8
      //   370: astore 21
      //   372: aload 10
      //   374: astore 18
      //   376: aload 9
      //   378: astore 15
      //   380: aload 8
      //   382: astore 13
      //   384: aload 10
      //   386: astore 14
      //   388: aload 9
      //   390: astore 12
      //   392: aload 8
      //   394: astore 22
      //   396: aload 10
      //   398: astore 20
      //   400: aload 9
      //   402: astore 11
      //   404: aload 26
      //   406: new 126	java/lang/String
      //   409: dup
      //   410: aload 23
      //   412: invokespecial 129	java/lang/String:<init>	([B)V
      //   415: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   418: pop
      //   419: aload 8
      //   421: astore 17
      //   423: aload 10
      //   425: astore 19
      //   427: aload 9
      //   429: astore 16
      //   431: aload 8
      //   433: astore 21
      //   435: aload 10
      //   437: astore 18
      //   439: aload 9
      //   441: astore 15
      //   443: aload 8
      //   445: astore 13
      //   447: aload 10
      //   449: astore 14
      //   451: aload 9
      //   453: astore 12
      //   455: aload 8
      //   457: astore 22
      //   459: aload 10
      //   461: astore 20
      //   463: aload 9
      //   465: astore 11
      //   467: aload 26
      //   469: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   472: astore 25
      //   474: aload 8
      //   476: astore 17
      //   478: aload 10
      //   480: astore 19
      //   482: aload 9
      //   484: astore 16
      //   486: aload 8
      //   488: astore 21
      //   490: aload 10
      //   492: astore 18
      //   494: aload 9
      //   496: astore 15
      //   498: aload 8
      //   500: astore 13
      //   502: aload 10
      //   504: astore 14
      //   506: aload 9
      //   508: astore 12
      //   510: aload 8
      //   512: astore 22
      //   514: aload 10
      //   516: astore 20
      //   518: aload 9
      //   520: astore 11
      //   522: aload 25
      //   524: ldc -125
      //   526: invokevirtual 135	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   529: ifeq -229 -> 300
      //   532: aload 8
      //   534: astore 17
      //   536: aload 10
      //   538: astore 19
      //   540: aload 9
      //   542: astore 16
      //   544: aload 8
      //   546: astore 21
      //   548: aload 10
      //   550: astore 18
      //   552: aload 9
      //   554: astore 15
      //   556: aload 8
      //   558: astore 13
      //   560: aload 10
      //   562: astore 14
      //   564: aload 9
      //   566: astore 12
      //   568: aload 8
      //   570: astore 22
      //   572: aload 10
      //   574: astore 20
      //   576: aload 9
      //   578: astore 11
      //   580: ldc -119
      //   582: iconst_1
      //   583: anewarray 4	java/lang/Object
      //   586: dup
      //   587: iconst_0
      //   588: aload 25
      //   590: aastore
      //   591: invokestatic 73	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   594: aload 8
      //   596: astore 17
      //   598: aload 10
      //   600: astore 19
      //   602: aload 9
      //   604: astore 16
      //   606: aload 8
      //   608: astore 21
      //   610: aload 10
      //   612: astore 18
      //   614: aload 9
      //   616: astore 15
      //   618: aload 8
      //   620: astore 13
      //   622: aload 10
      //   624: astore 14
      //   626: aload 9
      //   628: astore 12
      //   630: aload 8
      //   632: astore 22
      //   634: aload 10
      //   636: astore 20
      //   638: aload 9
      //   640: astore 11
      //   642: ldc -117
      //   644: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   647: aload 8
      //   649: astore 17
      //   651: aload 10
      //   653: astore 19
      //   655: aload 9
      //   657: astore 16
      //   659: aload 8
      //   661: astore 21
      //   663: aload 10
      //   665: astore 18
      //   667: aload 9
      //   669: astore 15
      //   671: aload 8
      //   673: astore 13
      //   675: aload 10
      //   677: astore 14
      //   679: aload 9
      //   681: astore 12
      //   683: aload 8
      //   685: astore 22
      //   687: aload 10
      //   689: astore 20
      //   691: aload 9
      //   693: astore 11
      //   695: aload 25
      //   697: new 80	java/lang/StringBuilder
      //   700: dup
      //   701: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   704: ldc -115
      //   706: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   709: aload_0
      //   710: getfield 36	com/millennialmedia/android/VideoPlayerActivity$VideoServer:fileName	Ljava/lang/String;
      //   713: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   716: ldc -113
      //   718: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   721: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   724: invokevirtual 147	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   727: ifeq +520 -> 1247
      //   730: aload 8
      //   732: astore 17
      //   734: aload 10
      //   736: astore 19
      //   738: aload 9
      //   740: astore 16
      //   742: aload 8
      //   744: astore 21
      //   746: aload 10
      //   748: astore 18
      //   750: aload 9
      //   752: astore 15
      //   754: aload 8
      //   756: astore 13
      //   758: aload 10
      //   760: astore 14
      //   762: aload 9
      //   764: astore 12
      //   766: aload 8
      //   768: astore 22
      //   770: aload 10
      //   772: astore 20
      //   774: aload 9
      //   776: astore 11
      //   778: new 149	java/io/File
      //   781: dup
      //   782: aload_0
      //   783: getfield 44	com/millennialmedia/android/VideoPlayerActivity$VideoServer:cacheDir	Ljava/io/File;
      //   786: new 80	java/lang/StringBuilder
      //   789: dup
      //   790: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   793: getstatic 152	java/io/File:separator	Ljava/lang/String;
      //   796: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   799: aload_0
      //   800: getfield 27	com/millennialmedia/android/VideoPlayerActivity$VideoServer:this$0	Lcom/millennialmedia/android/VideoPlayerActivity;
      //   803: invokestatic 156	com/millennialmedia/android/VideoPlayerActivity:access$1000	(Lcom/millennialmedia/android/VideoPlayerActivity;)Lcom/millennialmedia/android/VideoAd;
      //   806: getfield 161	com/millennialmedia/android/VideoAd:id	Ljava/lang/String;
      //   809: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   812: aload_0
      //   813: getfield 36	com/millennialmedia/android/VideoPlayerActivity$VideoServer:fileName	Ljava/lang/String;
      //   816: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   819: ldc -113
      //   821: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   824: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   827: invokespecial 164	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   830: astore 24
      //   832: aload 8
      //   834: astore 17
      //   836: aload 10
      //   838: astore 19
      //   840: aload 9
      //   842: astore 16
      //   844: aload 8
      //   846: astore 21
      //   848: aload 10
      //   850: astore 18
      //   852: aload 9
      //   854: astore 15
      //   856: aload 8
      //   858: astore 13
      //   860: aload 10
      //   862: astore 14
      //   864: aload 9
      //   866: astore 12
      //   868: aload 8
      //   870: astore 22
      //   872: aload 10
      //   874: astore 20
      //   876: aload 9
      //   878: astore 11
      //   880: aload 9
      //   882: ldc -90
      //   884: invokevirtual 170	java/lang/String:getBytes	()[B
      //   887: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   890: aload 8
      //   892: astore 17
      //   894: aload 10
      //   896: astore 19
      //   898: aload 9
      //   900: astore 16
      //   902: aload 8
      //   904: astore 21
      //   906: aload 10
      //   908: astore 18
      //   910: aload 9
      //   912: astore 15
      //   914: aload 8
      //   916: astore 13
      //   918: aload 10
      //   920: astore 14
      //   922: aload 9
      //   924: astore 12
      //   926: aload 8
      //   928: astore 22
      //   930: aload 10
      //   932: astore 20
      //   934: aload 9
      //   936: astore 11
      //   938: aload 9
      //   940: ldc -79
      //   942: invokevirtual 170	java/lang/String:getBytes	()[B
      //   945: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   948: aload 8
      //   950: astore 17
      //   952: aload 10
      //   954: astore 19
      //   956: aload 9
      //   958: astore 16
      //   960: aload 8
      //   962: astore 21
      //   964: aload 10
      //   966: astore 18
      //   968: aload 9
      //   970: astore 15
      //   972: aload 8
      //   974: astore 13
      //   976: aload 10
      //   978: astore 14
      //   980: aload 9
      //   982: astore 12
      //   984: aload 8
      //   986: astore 22
      //   988: aload 10
      //   990: astore 20
      //   992: aload 9
      //   994: astore 11
      //   996: aload 9
      //   998: new 126	java/lang/String
      //   1001: dup
      //   1002: new 80	java/lang/StringBuilder
      //   1005: dup
      //   1006: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   1009: ldc -77
      //   1011: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1014: aload 24
      //   1016: invokevirtual 183	java/io/File:length	()J
      //   1019: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1022: ldc -68
      //   1024: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1027: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1030: invokespecial 190	java/lang/String:<init>	(Ljava/lang/String;)V
      //   1033: invokevirtual 170	java/lang/String:getBytes	()[B
      //   1036: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   1039: aload 8
      //   1041: astore 17
      //   1043: aload 10
      //   1045: astore 19
      //   1047: aload 9
      //   1049: astore 16
      //   1051: aload 8
      //   1053: astore 21
      //   1055: aload 10
      //   1057: astore 18
      //   1059: aload 9
      //   1061: astore 15
      //   1063: aload 8
      //   1065: astore 13
      //   1067: aload 10
      //   1069: astore 14
      //   1071: aload 9
      //   1073: astore 12
      //   1075: aload 8
      //   1077: astore 22
      //   1079: aload 10
      //   1081: astore 20
      //   1083: aload 9
      //   1085: astore 11
      //   1087: aload 9
      //   1089: ldc -64
      //   1091: invokevirtual 170	java/lang/String:getBytes	()[B
      //   1094: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   1097: aload 8
      //   1099: astore 17
      //   1101: aload 10
      //   1103: astore 19
      //   1105: aload 9
      //   1107: astore 16
      //   1109: aload 8
      //   1111: astore 21
      //   1113: aload 10
      //   1115: astore 18
      //   1117: aload 9
      //   1119: astore 15
      //   1121: aload 8
      //   1123: astore 13
      //   1125: aload 10
      //   1127: astore 14
      //   1129: aload 9
      //   1131: astore 12
      //   1133: aload 8
      //   1135: astore 22
      //   1137: aload 10
      //   1139: astore 20
      //   1141: aload 9
      //   1143: astore 11
      //   1145: aload 9
      //   1147: ldc -62
      //   1149: invokevirtual 170	java/lang/String:getBytes	()[B
      //   1152: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   1155: aload 9
      //   1157: astore 12
      //   1159: aload 10
      //   1161: astore 13
      //   1163: ldc -60
      //   1165: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   1168: aload 8
      //   1170: ifnull +8 -> 1178
      //   1173: aload 8
      //   1175: invokevirtual 199	java/net/Socket:close	()V
      //   1178: aload 13
      //   1180: ifnull +8 -> 1188
      //   1183: aload 13
      //   1185: invokevirtual 202	java/io/FileInputStream:close	()V
      //   1188: aload 8
      //   1190: astore 11
      //   1192: aload 13
      //   1194: astore 10
      //   1196: aload 12
      //   1198: astore 9
      //   1200: aload 12
      //   1202: ifnull -1186 -> 16
      //   1205: aload 12
      //   1207: invokevirtual 203	java/io/OutputStream:close	()V
      //   1210: aload 8
      //   1212: astore 11
      //   1214: aload 13
      //   1216: astore 10
      //   1218: aload 12
      //   1220: astore 9
      //   1222: goto -1206 -> 16
      //   1225: astore 9
      //   1227: aload 9
      //   1229: invokevirtual 76	java/io/IOException:printStackTrace	()V
      //   1232: aload 8
      //   1234: astore 11
      //   1236: aload 13
      //   1238: astore 10
      //   1240: aload 12
      //   1242: astore 9
      //   1244: goto -1228 -> 16
      //   1247: aload 8
      //   1249: astore 17
      //   1251: aload 10
      //   1253: astore 19
      //   1255: aload 9
      //   1257: astore 16
      //   1259: aload 8
      //   1261: astore 21
      //   1263: aload 10
      //   1265: astore 18
      //   1267: aload 9
      //   1269: astore 15
      //   1271: aload 8
      //   1273: astore 13
      //   1275: aload 10
      //   1277: astore 14
      //   1279: aload 9
      //   1281: astore 12
      //   1283: aload 8
      //   1285: astore 22
      //   1287: aload 10
      //   1289: astore 20
      //   1291: aload 9
      //   1293: astore 11
      //   1295: aload 25
      //   1297: new 80	java/lang/StringBuilder
      //   1300: dup
      //   1301: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   1304: ldc -51
      //   1306: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1309: aload_0
      //   1310: getfield 36	com/millennialmedia/android/VideoPlayerActivity$VideoServer:fileName	Ljava/lang/String;
      //   1313: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1316: ldc -113
      //   1318: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1321: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1324: invokevirtual 147	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   1327: ifeq +2624 -> 3951
      //   1330: aload 8
      //   1332: astore 17
      //   1334: aload 10
      //   1336: astore 19
      //   1338: aload 9
      //   1340: astore 16
      //   1342: aload 8
      //   1344: astore 21
      //   1346: aload 10
      //   1348: astore 18
      //   1350: aload 9
      //   1352: astore 15
      //   1354: aload 8
      //   1356: astore 13
      //   1358: aload 10
      //   1360: astore 14
      //   1362: aload 9
      //   1364: astore 12
      //   1366: aload 8
      //   1368: astore 22
      //   1370: aload 10
      //   1372: astore 20
      //   1374: aload 9
      //   1376: astore 11
      //   1378: new 149	java/io/File
      //   1381: dup
      //   1382: aload_0
      //   1383: getfield 44	com/millennialmedia/android/VideoPlayerActivity$VideoServer:cacheDir	Ljava/io/File;
      //   1386: new 80	java/lang/StringBuilder
      //   1389: dup
      //   1390: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   1393: aload_0
      //   1394: getfield 36	com/millennialmedia/android/VideoPlayerActivity$VideoServer:fileName	Ljava/lang/String;
      //   1397: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1400: ldc -113
      //   1402: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1405: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1408: invokespecial 164	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   1411: astore 24
      //   1413: aload 24
      //   1415: ifnonnull +90 -> 1505
      //   1418: ldc -60
      //   1420: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   1423: aload 8
      //   1425: ifnull +8 -> 1433
      //   1428: aload 8
      //   1430: invokevirtual 199	java/net/Socket:close	()V
      //   1433: aload 10
      //   1435: ifnull +8 -> 1443
      //   1438: aload 10
      //   1440: invokevirtual 202	java/io/FileInputStream:close	()V
      //   1443: aload 9
      //   1445: ifnull +8 -> 1453
      //   1448: aload 9
      //   1450: invokevirtual 203	java/io/OutputStream:close	()V
      //   1453: aload_0
      //   1454: getfield 34	com/millennialmedia/android/VideoPlayerActivity$VideoServer:done	Z
      //   1457: ifeq +8 -> 1465
      //   1460: ldc -49
      //   1462: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   1465: aload_0
      //   1466: getfield 32	com/millennialmedia/android/VideoPlayerActivity$VideoServer:serverSocket	Ljava/net/ServerSocket;
      //   1469: ifnull +25 -> 1494
      //   1472: aload_0
      //   1473: getfield 32	com/millennialmedia/android/VideoPlayerActivity$VideoServer:serverSocket	Ljava/net/ServerSocket;
      //   1476: invokevirtual 211	java/net/ServerSocket:isBound	()Z
      //   1479: ifeq +15 -> 1494
      //   1482: ldc -43
      //   1484: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   1487: aload_0
      //   1488: getfield 32	com/millennialmedia/android/VideoPlayerActivity$VideoServer:serverSocket	Ljava/net/ServerSocket;
      //   1491: invokevirtual 214	java/net/ServerSocket:close	()V
      //   1494: return
      //   1495: astore 8
      //   1497: aload 8
      //   1499: invokevirtual 76	java/io/IOException:printStackTrace	()V
      //   1502: goto -49 -> 1453
      //   1505: aload 8
      //   1507: astore 17
      //   1509: aload 10
      //   1511: astore 19
      //   1513: aload 9
      //   1515: astore 16
      //   1517: aload 8
      //   1519: astore 21
      //   1521: aload 10
      //   1523: astore 18
      //   1525: aload 9
      //   1527: astore 15
      //   1529: aload 8
      //   1531: astore 13
      //   1533: aload 10
      //   1535: astore 14
      //   1537: aload 9
      //   1539: astore 12
      //   1541: aload 8
      //   1543: astore 22
      //   1545: aload 10
      //   1547: astore 20
      //   1549: aload 9
      //   1551: astore 11
      //   1553: aload 8
      //   1555: invokevirtual 118	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
      //   1558: astore 9
      //   1560: aload 8
      //   1562: astore 17
      //   1564: aload 10
      //   1566: astore 19
      //   1568: aload 9
      //   1570: astore 16
      //   1572: aload 8
      //   1574: astore 21
      //   1576: aload 10
      //   1578: astore 18
      //   1580: aload 9
      //   1582: astore 15
      //   1584: aload 8
      //   1586: astore 13
      //   1588: aload 10
      //   1590: astore 14
      //   1592: aload 9
      //   1594: astore 12
      //   1596: aload 8
      //   1598: astore 22
      //   1600: aload 10
      //   1602: astore 20
      //   1604: aload 9
      //   1606: astore 11
      //   1608: aload 25
      //   1610: ldc -40
      //   1612: invokevirtual 135	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   1615: ifeq +1758 -> 3373
      //   1618: aload 8
      //   1620: astore 17
      //   1622: aload 10
      //   1624: astore 19
      //   1626: aload 9
      //   1628: astore 16
      //   1630: aload 8
      //   1632: astore 21
      //   1634: aload 10
      //   1636: astore 18
      //   1638: aload 9
      //   1640: astore 15
      //   1642: aload 8
      //   1644: astore 13
      //   1646: aload 10
      //   1648: astore 14
      //   1650: aload 9
      //   1652: astore 12
      //   1654: aload 8
      //   1656: astore 22
      //   1658: aload 10
      //   1660: astore 20
      //   1662: aload 9
      //   1664: astore 11
      //   1666: ldc -38
      //   1668: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   1671: aload 8
      //   1673: astore 17
      //   1675: aload 10
      //   1677: astore 19
      //   1679: aload 9
      //   1681: astore 16
      //   1683: aload 8
      //   1685: astore 21
      //   1687: aload 10
      //   1689: astore 18
      //   1691: aload 9
      //   1693: astore 15
      //   1695: aload 8
      //   1697: astore 13
      //   1699: aload 10
      //   1701: astore 14
      //   1703: aload 9
      //   1705: astore 12
      //   1707: aload 8
      //   1709: astore 22
      //   1711: aload 10
      //   1713: astore 20
      //   1715: aload 9
      //   1717: astore 11
      //   1719: ldc -36
      //   1721: invokestatic 226	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
      //   1724: aload 25
      //   1726: invokevirtual 230	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      //   1729: astore 26
      //   1731: lconst_1
      //   1732: lstore 4
      //   1734: lconst_1
      //   1735: lstore_2
      //   1736: aload 8
      //   1738: astore 17
      //   1740: aload 10
      //   1742: astore 19
      //   1744: aload 9
      //   1746: astore 16
      //   1748: aload 8
      //   1750: astore 21
      //   1752: aload 10
      //   1754: astore 18
      //   1756: aload 9
      //   1758: astore 15
      //   1760: aload 8
      //   1762: astore 13
      //   1764: aload 10
      //   1766: astore 14
      //   1768: aload 9
      //   1770: astore 12
      //   1772: aload 8
      //   1774: astore 22
      //   1776: aload 10
      //   1778: astore 20
      //   1780: aload 9
      //   1782: astore 11
      //   1784: aload 26
      //   1786: invokevirtual 235	java/util/regex/Matcher:find	()Z
      //   1789: ifeq +127 -> 1916
      //   1792: aload 8
      //   1794: astore 17
      //   1796: aload 10
      //   1798: astore 19
      //   1800: aload 9
      //   1802: astore 16
      //   1804: aload 8
      //   1806: astore 21
      //   1808: aload 10
      //   1810: astore 18
      //   1812: aload 9
      //   1814: astore 15
      //   1816: aload 8
      //   1818: astore 13
      //   1820: aload 10
      //   1822: astore 14
      //   1824: aload 9
      //   1826: astore 12
      //   1828: aload 8
      //   1830: astore 22
      //   1832: aload 10
      //   1834: astore 20
      //   1836: aload 9
      //   1838: astore 11
      //   1840: new 57	java/lang/Integer
      //   1843: dup
      //   1844: aload 26
      //   1846: iconst_1
      //   1847: invokevirtual 239	java/util/regex/Matcher:group	(I)Ljava/lang/String;
      //   1850: invokespecial 240	java/lang/Integer:<init>	(Ljava/lang/String;)V
      //   1853: invokevirtual 243	java/lang/Integer:intValue	()I
      //   1856: i2l
      //   1857: lstore 4
      //   1859: aload 8
      //   1861: astore 17
      //   1863: aload 10
      //   1865: astore 19
      //   1867: aload 9
      //   1869: astore 16
      //   1871: aload 8
      //   1873: astore 21
      //   1875: aload 10
      //   1877: astore 18
      //   1879: aload 9
      //   1881: astore 15
      //   1883: aload 8
      //   1885: astore 13
      //   1887: aload 10
      //   1889: astore 14
      //   1891: aload 9
      //   1893: astore 12
      //   1895: aload 8
      //   1897: astore 22
      //   1899: aload 10
      //   1901: astore 20
      //   1903: aload 9
      //   1905: astore 11
      //   1907: aload 24
      //   1909: invokevirtual 183	java/io/File:length	()J
      //   1912: lstore_2
      //   1913: goto -177 -> 1736
      //   1916: aload 8
      //   1918: astore 17
      //   1920: aload 10
      //   1922: astore 19
      //   1924: aload 9
      //   1926: astore 16
      //   1928: aload 8
      //   1930: astore 21
      //   1932: aload 10
      //   1934: astore 18
      //   1936: aload 9
      //   1938: astore 15
      //   1940: aload 8
      //   1942: astore 13
      //   1944: aload 10
      //   1946: astore 14
      //   1948: aload 9
      //   1950: astore 12
      //   1952: aload 8
      //   1954: astore 22
      //   1956: aload 10
      //   1958: astore 20
      //   1960: aload 9
      //   1962: astore 11
      //   1964: ldc -11
      //   1966: invokestatic 226	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
      //   1969: aload 25
      //   1971: invokevirtual 230	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      //   1974: astore 25
      //   1976: aload 8
      //   1978: astore 17
      //   1980: aload 10
      //   1982: astore 19
      //   1984: aload 9
      //   1986: astore 16
      //   1988: aload 8
      //   1990: astore 21
      //   1992: aload 10
      //   1994: astore 18
      //   1996: aload 9
      //   1998: astore 15
      //   2000: aload 8
      //   2002: astore 13
      //   2004: aload 10
      //   2006: astore 14
      //   2008: aload 9
      //   2010: astore 12
      //   2012: aload 8
      //   2014: astore 22
      //   2016: aload 10
      //   2018: astore 20
      //   2020: aload 9
      //   2022: astore 11
      //   2024: aload 25
      //   2026: invokevirtual 235	java/util/regex/Matcher:find	()Z
      //   2029: ifeq +307 -> 2336
      //   2032: aload 8
      //   2034: astore 17
      //   2036: aload 10
      //   2038: astore 19
      //   2040: aload 9
      //   2042: astore 16
      //   2044: aload 8
      //   2046: astore 21
      //   2048: aload 10
      //   2050: astore 18
      //   2052: aload 9
      //   2054: astore 15
      //   2056: aload 8
      //   2058: astore 13
      //   2060: aload 10
      //   2062: astore 14
      //   2064: aload 9
      //   2066: astore 12
      //   2068: aload 8
      //   2070: astore 22
      //   2072: aload 10
      //   2074: astore 20
      //   2076: aload 9
      //   2078: astore 11
      //   2080: aload 25
      //   2082: iconst_1
      //   2083: invokevirtual 239	java/util/regex/Matcher:group	(I)Ljava/lang/String;
      //   2086: astore 26
      //   2088: aload 8
      //   2090: astore 17
      //   2092: aload 10
      //   2094: astore 19
      //   2096: aload 9
      //   2098: astore 16
      //   2100: aload 8
      //   2102: astore 21
      //   2104: aload 10
      //   2106: astore 18
      //   2108: aload 9
      //   2110: astore 15
      //   2112: aload 8
      //   2114: astore 13
      //   2116: aload 10
      //   2118: astore 14
      //   2120: aload 9
      //   2122: astore 12
      //   2124: aload 8
      //   2126: astore 22
      //   2128: aload 10
      //   2130: astore 20
      //   2132: aload 9
      //   2134: astore 11
      //   2136: aload 25
      //   2138: iconst_2
      //   2139: invokevirtual 239	java/util/regex/Matcher:group	(I)Ljava/lang/String;
      //   2142: astore 27
      //   2144: aload 8
      //   2146: astore 17
      //   2148: aload 10
      //   2150: astore 19
      //   2152: aload 9
      //   2154: astore 16
      //   2156: aload 8
      //   2158: astore 21
      //   2160: aload 10
      //   2162: astore 18
      //   2164: aload 9
      //   2166: astore 15
      //   2168: aload 8
      //   2170: astore 13
      //   2172: aload 10
      //   2174: astore 14
      //   2176: aload 9
      //   2178: astore 12
      //   2180: aload 8
      //   2182: astore 22
      //   2184: aload 10
      //   2186: astore 20
      //   2188: aload 9
      //   2190: astore 11
      //   2192: new 57	java/lang/Integer
      //   2195: dup
      //   2196: aload 26
      //   2198: invokespecial 240	java/lang/Integer:<init>	(Ljava/lang/String;)V
      //   2201: invokevirtual 243	java/lang/Integer:intValue	()I
      //   2204: i2l
      //   2205: lstore 4
      //   2207: aload 27
      //   2209: ifnull +68 -> 2277
      //   2212: aload 8
      //   2214: astore 17
      //   2216: aload 10
      //   2218: astore 19
      //   2220: aload 9
      //   2222: astore 16
      //   2224: aload 8
      //   2226: astore 21
      //   2228: aload 10
      //   2230: astore 18
      //   2232: aload 9
      //   2234: astore 15
      //   2236: aload 8
      //   2238: astore 13
      //   2240: aload 10
      //   2242: astore 14
      //   2244: aload 9
      //   2246: astore 12
      //   2248: aload 8
      //   2250: astore 22
      //   2252: aload 10
      //   2254: astore 20
      //   2256: aload 9
      //   2258: astore 11
      //   2260: new 57	java/lang/Integer
      //   2263: dup
      //   2264: aload 27
      //   2266: invokespecial 240	java/lang/Integer:<init>	(Ljava/lang/String;)V
      //   2269: invokevirtual 243	java/lang/Integer:intValue	()I
      //   2272: i2l
      //   2273: lstore_2
      //   2274: goto -298 -> 1976
      //   2277: aload 8
      //   2279: astore 17
      //   2281: aload 10
      //   2283: astore 19
      //   2285: aload 9
      //   2287: astore 16
      //   2289: aload 8
      //   2291: astore 21
      //   2293: aload 10
      //   2295: astore 18
      //   2297: aload 9
      //   2299: astore 15
      //   2301: aload 8
      //   2303: astore 13
      //   2305: aload 10
      //   2307: astore 14
      //   2309: aload 9
      //   2311: astore 12
      //   2313: aload 8
      //   2315: astore 22
      //   2317: aload 10
      //   2319: astore 20
      //   2321: aload 9
      //   2323: astore 11
      //   2325: aload 24
      //   2327: invokevirtual 183	java/io/File:length	()J
      //   2330: lconst_1
      //   2331: lsub
      //   2332: lstore_2
      //   2333: goto -357 -> 1976
      //   2336: aload 8
      //   2338: astore 17
      //   2340: aload 10
      //   2342: astore 19
      //   2344: aload 9
      //   2346: astore 16
      //   2348: aload 8
      //   2350: astore 21
      //   2352: aload 10
      //   2354: astore 18
      //   2356: aload 9
      //   2358: astore 15
      //   2360: aload 8
      //   2362: astore 13
      //   2364: aload 10
      //   2366: astore 14
      //   2368: aload 9
      //   2370: astore 12
      //   2372: aload 8
      //   2374: astore 22
      //   2376: aload 10
      //   2378: astore 20
      //   2380: aload 9
      //   2382: astore 11
      //   2384: new 80	java/lang/StringBuilder
      //   2387: dup
      //   2388: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   2391: ldc -9
      //   2393: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2396: lload 4
      //   2398: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2401: ldc -7
      //   2403: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2406: lload_2
      //   2407: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2410: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2413: invokestatic 252	com/millennialmedia/android/MMAdViewSDK$Log:i	(Ljava/lang/String;)V
      //   2416: aload 8
      //   2418: astore 17
      //   2420: aload 10
      //   2422: astore 19
      //   2424: aload 9
      //   2426: astore 16
      //   2428: aload 8
      //   2430: astore 21
      //   2432: aload 10
      //   2434: astore 18
      //   2436: aload 9
      //   2438: astore 15
      //   2440: aload 8
      //   2442: astore 13
      //   2444: aload 10
      //   2446: astore 14
      //   2448: aload 9
      //   2450: astore 12
      //   2452: aload 8
      //   2454: astore 22
      //   2456: aload 10
      //   2458: astore 20
      //   2460: aload 9
      //   2462: astore 11
      //   2464: new 201	java/io/FileInputStream
      //   2467: dup
      //   2468: aload 24
      //   2470: invokespecial 255	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   2473: astore 10
      //   2475: aload 10
      //   2477: astore 11
      //   2479: aload 10
      //   2481: astore 12
      //   2483: aload 10
      //   2485: astore 13
      //   2487: aload 10
      //   2489: astore 14
      //   2491: aload 10
      //   2493: lload 4
      //   2495: invokevirtual 259	java/io/FileInputStream:skip	(J)J
      //   2498: lstore 6
      //   2500: aload 10
      //   2502: astore 11
      //   2504: aload 10
      //   2506: astore 12
      //   2508: aload 10
      //   2510: astore 13
      //   2512: aload 10
      //   2514: astore 14
      //   2516: ldc_w 261
      //   2519: iconst_1
      //   2520: anewarray 4	java/lang/Object
      //   2523: dup
      //   2524: iconst_0
      //   2525: lload 6
      //   2527: invokestatic 267	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   2530: aastore
      //   2531: invokestatic 73	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   2534: lload_2
      //   2535: lload 6
      //   2537: lsub
      //   2538: lconst_1
      //   2539: ladd
      //   2540: lstore 6
      //   2542: aload 10
      //   2544: astore 11
      //   2546: aload 10
      //   2548: astore 12
      //   2550: aload 10
      //   2552: astore 13
      //   2554: aload 10
      //   2556: astore 14
      //   2558: aload 9
      //   2560: ldc_w 269
      //   2563: invokevirtual 170	java/lang/String:getBytes	()[B
      //   2566: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   2569: aload 10
      //   2571: astore 11
      //   2573: aload 10
      //   2575: astore 12
      //   2577: aload 10
      //   2579: astore 13
      //   2581: aload 10
      //   2583: astore 14
      //   2585: aload 9
      //   2587: ldc_w 271
      //   2590: invokevirtual 170	java/lang/String:getBytes	()[B
      //   2593: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   2596: aload 10
      //   2598: astore 11
      //   2600: aload 10
      //   2602: astore 12
      //   2604: aload 10
      //   2606: astore 13
      //   2608: aload 10
      //   2610: astore 14
      //   2612: aload 9
      //   2614: ldc_w 273
      //   2617: invokevirtual 170	java/lang/String:getBytes	()[B
      //   2620: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   2623: lload_2
      //   2624: lconst_1
      //   2625: lcmp
      //   2626: ifle +539 -> 3165
      //   2629: aload 10
      //   2631: astore 11
      //   2633: aload 10
      //   2635: astore 12
      //   2637: aload 10
      //   2639: astore 13
      //   2641: aload 10
      //   2643: astore 14
      //   2645: aload 9
      //   2647: new 126	java/lang/String
      //   2650: dup
      //   2651: new 80	java/lang/StringBuilder
      //   2654: dup
      //   2655: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   2658: ldc_w 275
      //   2661: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2664: lload 4
      //   2666: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2669: ldc -7
      //   2671: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2674: lload_2
      //   2675: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2678: ldc -68
      //   2680: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2683: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2686: invokespecial 190	java/lang/String:<init>	(Ljava/lang/String;)V
      //   2689: invokevirtual 170	java/lang/String:getBytes	()[B
      //   2692: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   2695: aload 10
      //   2697: astore 11
      //   2699: aload 10
      //   2701: astore 12
      //   2703: aload 10
      //   2705: astore 13
      //   2707: aload 10
      //   2709: astore 14
      //   2711: aload 9
      //   2713: ldc -79
      //   2715: invokevirtual 170	java/lang/String:getBytes	()[B
      //   2718: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   2721: aload 10
      //   2723: astore 11
      //   2725: aload 10
      //   2727: astore 12
      //   2729: aload 10
      //   2731: astore 13
      //   2733: aload 10
      //   2735: astore 14
      //   2737: aload 9
      //   2739: new 126	java/lang/String
      //   2742: dup
      //   2743: new 80	java/lang/StringBuilder
      //   2746: dup
      //   2747: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   2750: ldc -77
      //   2752: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2755: lload 6
      //   2757: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2760: ldc -68
      //   2762: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2765: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2768: invokespecial 190	java/lang/String:<init>	(Ljava/lang/String;)V
      //   2771: invokevirtual 170	java/lang/String:getBytes	()[B
      //   2774: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   2777: aload 10
      //   2779: astore 11
      //   2781: aload 10
      //   2783: astore 12
      //   2785: aload 10
      //   2787: astore 13
      //   2789: aload 10
      //   2791: astore 14
      //   2793: aload 9
      //   2795: ldc -62
      //   2797: invokevirtual 170	java/lang/String:getBytes	()[B
      //   2800: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   2803: lload 6
      //   2805: lstore_2
      //   2806: aload 10
      //   2808: astore 11
      //   2810: aload 10
      //   2812: astore 12
      //   2814: aload 10
      //   2816: astore 13
      //   2818: aload 10
      //   2820: astore 14
      //   2822: aload 10
      //   2824: aload 23
      //   2826: invokevirtual 276	java/io/FileInputStream:read	([B)I
      //   2829: istore_1
      //   2830: iload_1
      //   2831: ifgt +407 -> 3238
      //   2834: aload 10
      //   2836: astore 11
      //   2838: aload 10
      //   2840: astore 12
      //   2842: aload 10
      //   2844: astore 13
      //   2846: aload 10
      //   2848: astore 14
      //   2850: ldc_w 278
      //   2853: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   2856: aload 8
      //   2858: astore 17
      //   2860: aload 10
      //   2862: astore 19
      //   2864: aload 9
      //   2866: astore 16
      //   2868: aload 8
      //   2870: astore 21
      //   2872: aload 10
      //   2874: astore 18
      //   2876: aload 9
      //   2878: astore 15
      //   2880: aload 8
      //   2882: astore 13
      //   2884: aload 10
      //   2886: astore 14
      //   2888: aload 9
      //   2890: astore 12
      //   2892: aload 8
      //   2894: astore 22
      //   2896: aload 10
      //   2898: astore 20
      //   2900: aload 9
      //   2902: astore 11
      //   2904: aload 9
      //   2906: ldc -68
      //   2908: invokevirtual 170	java/lang/String:getBytes	()[B
      //   2911: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   2914: aload 8
      //   2916: astore 17
      //   2918: aload 10
      //   2920: astore 19
      //   2922: aload 9
      //   2924: astore 16
      //   2926: aload 8
      //   2928: astore 21
      //   2930: aload 10
      //   2932: astore 18
      //   2934: aload 9
      //   2936: astore 15
      //   2938: aload 8
      //   2940: astore 13
      //   2942: aload 10
      //   2944: astore 14
      //   2946: aload 9
      //   2948: astore 12
      //   2950: aload 8
      //   2952: astore 22
      //   2954: aload 10
      //   2956: astore 20
      //   2958: aload 9
      //   2960: astore 11
      //   2962: ldc_w 280
      //   2965: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   2968: aload 8
      //   2970: astore 17
      //   2972: aload 10
      //   2974: astore 19
      //   2976: aload 9
      //   2978: astore 16
      //   2980: aload 8
      //   2982: astore 21
      //   2984: aload 10
      //   2986: astore 18
      //   2988: aload 9
      //   2990: astore 15
      //   2992: aload 8
      //   2994: astore 13
      //   2996: aload 10
      //   2998: astore 14
      //   3000: aload 9
      //   3002: astore 12
      //   3004: aload 8
      //   3006: astore 22
      //   3008: aload 10
      //   3010: astore 20
      //   3012: aload 9
      //   3014: astore 11
      //   3016: aload_0
      //   3017: iconst_1
      //   3018: putfield 34	com/millennialmedia/android/VideoPlayerActivity$VideoServer:done	Z
      //   3021: aload 10
      //   3023: astore 13
      //   3025: aload 9
      //   3027: astore 12
      //   3029: goto -1866 -> 1163
      //   3032: astore 10
      //   3034: aload 19
      //   3036: astore 15
      //   3038: aload 17
      //   3040: astore 8
      //   3042: aload 8
      //   3044: astore 13
      //   3046: aload 15
      //   3048: astore 14
      //   3050: aload 16
      //   3052: astore 12
      //   3054: aload 10
      //   3056: invokevirtual 281	java/net/SocketTimeoutException:printStackTrace	()V
      //   3059: aload 8
      //   3061: ifnull +20 -> 3081
      //   3064: aload 8
      //   3066: astore 13
      //   3068: aload 15
      //   3070: astore 14
      //   3072: aload 16
      //   3074: astore 12
      //   3076: aload 8
      //   3078: invokevirtual 199	java/net/Socket:close	()V
      //   3081: ldc -60
      //   3083: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   3086: aload 8
      //   3088: ifnull +8 -> 3096
      //   3091: aload 8
      //   3093: invokevirtual 199	java/net/Socket:close	()V
      //   3096: aload 15
      //   3098: ifnull +8 -> 3106
      //   3101: aload 15
      //   3103: invokevirtual 202	java/io/FileInputStream:close	()V
      //   3106: aload 8
      //   3108: astore 11
      //   3110: aload 15
      //   3112: astore 10
      //   3114: aload 16
      //   3116: astore 9
      //   3118: aload 16
      //   3120: ifnull -3104 -> 16
      //   3123: aload 16
      //   3125: invokevirtual 203	java/io/OutputStream:close	()V
      //   3128: aload 8
      //   3130: astore 11
      //   3132: aload 15
      //   3134: astore 10
      //   3136: aload 16
      //   3138: astore 9
      //   3140: goto -3124 -> 16
      //   3143: astore 9
      //   3145: aload 9
      //   3147: invokevirtual 76	java/io/IOException:printStackTrace	()V
      //   3150: aload 8
      //   3152: astore 11
      //   3154: aload 15
      //   3156: astore 10
      //   3158: aload 16
      //   3160: astore 9
      //   3162: goto -3146 -> 16
      //   3165: aload 10
      //   3167: astore 11
      //   3169: aload 10
      //   3171: astore 12
      //   3173: aload 10
      //   3175: astore 13
      //   3177: aload 10
      //   3179: astore 14
      //   3181: aload 9
      //   3183: new 126	java/lang/String
      //   3186: dup
      //   3187: new 80	java/lang/StringBuilder
      //   3190: dup
      //   3191: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   3194: ldc_w 275
      //   3197: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3200: lload 4
      //   3202: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3205: ldc -7
      //   3207: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3210: aload 24
      //   3212: invokevirtual 183	java/io/File:length	()J
      //   3215: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3218: ldc -68
      //   3220: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3223: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3226: invokespecial 190	java/lang/String:<init>	(Ljava/lang/String;)V
      //   3229: invokevirtual 170	java/lang/String:getBytes	()[B
      //   3232: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   3235: goto -540 -> 2695
      //   3238: lload_2
      //   3239: iload_1
      //   3240: i2l
      //   3241: lcmp
      //   3242: iflt +31 -> 3273
      //   3245: aload 10
      //   3247: astore 11
      //   3249: aload 10
      //   3251: astore 12
      //   3253: aload 10
      //   3255: astore 13
      //   3257: aload 10
      //   3259: astore 14
      //   3261: aload 9
      //   3263: aload 23
      //   3265: iconst_0
      //   3266: iload_1
      //   3267: invokevirtual 284	java/io/OutputStream:write	([BII)V
      //   3270: goto +949 -> 4219
      //   3273: aload 10
      //   3275: astore 11
      //   3277: aload 10
      //   3279: astore 12
      //   3281: aload 10
      //   3283: astore 13
      //   3285: aload 10
      //   3287: astore 14
      //   3289: aload 9
      //   3291: aload 23
      //   3293: iconst_0
      //   3294: lload_2
      //   3295: l2i
      //   3296: invokevirtual 284	java/io/OutputStream:write	([BII)V
      //   3299: goto +920 -> 4219
      //   3302: astore 10
      //   3304: aload 11
      //   3306: astore 18
      //   3308: aload 8
      //   3310: astore 13
      //   3312: aload 18
      //   3314: astore 14
      //   3316: aload 9
      //   3318: astore 12
      //   3320: aload 10
      //   3322: invokevirtual 285	java/io/FileNotFoundException:printStackTrace	()V
      //   3325: ldc -60
      //   3327: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   3330: aload 8
      //   3332: ifnull +8 -> 3340
      //   3335: aload 8
      //   3337: invokevirtual 199	java/net/Socket:close	()V
      //   3340: aload 18
      //   3342: ifnull +8 -> 3350
      //   3345: aload 18
      //   3347: invokevirtual 202	java/io/FileInputStream:close	()V
      //   3350: aload 9
      //   3352: ifnull -1899 -> 1453
      //   3355: aload 9
      //   3357: invokevirtual 203	java/io/OutputStream:close	()V
      //   3360: goto -1907 -> 1453
      //   3363: astore 8
      //   3365: aload 8
      //   3367: invokevirtual 76	java/io/IOException:printStackTrace	()V
      //   3370: goto -1917 -> 1453
      //   3373: aload 8
      //   3375: astore 17
      //   3377: aload 10
      //   3379: astore 19
      //   3381: aload 9
      //   3383: astore 16
      //   3385: aload 8
      //   3387: astore 21
      //   3389: aload 10
      //   3391: astore 18
      //   3393: aload 9
      //   3395: astore 15
      //   3397: aload 8
      //   3399: astore 13
      //   3401: aload 10
      //   3403: astore 14
      //   3405: aload 9
      //   3407: astore 12
      //   3409: aload 8
      //   3411: astore 22
      //   3413: aload 10
      //   3415: astore 20
      //   3417: aload 9
      //   3419: astore 11
      //   3421: aload 9
      //   3423: ldc -90
      //   3425: invokevirtual 170	java/lang/String:getBytes	()[B
      //   3428: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   3431: aload 8
      //   3433: astore 17
      //   3435: aload 10
      //   3437: astore 19
      //   3439: aload 9
      //   3441: astore 16
      //   3443: aload 8
      //   3445: astore 21
      //   3447: aload 10
      //   3449: astore 18
      //   3451: aload 9
      //   3453: astore 15
      //   3455: aload 8
      //   3457: astore 13
      //   3459: aload 10
      //   3461: astore 14
      //   3463: aload 9
      //   3465: astore 12
      //   3467: aload 8
      //   3469: astore 22
      //   3471: aload 10
      //   3473: astore 20
      //   3475: aload 9
      //   3477: astore 11
      //   3479: aload 9
      //   3481: ldc -79
      //   3483: invokevirtual 170	java/lang/String:getBytes	()[B
      //   3486: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   3489: aload 8
      //   3491: astore 17
      //   3493: aload 10
      //   3495: astore 19
      //   3497: aload 9
      //   3499: astore 16
      //   3501: aload 8
      //   3503: astore 21
      //   3505: aload 10
      //   3507: astore 18
      //   3509: aload 9
      //   3511: astore 15
      //   3513: aload 8
      //   3515: astore 13
      //   3517: aload 10
      //   3519: astore 14
      //   3521: aload 9
      //   3523: astore 12
      //   3525: aload 8
      //   3527: astore 22
      //   3529: aload 10
      //   3531: astore 20
      //   3533: aload 9
      //   3535: astore 11
      //   3537: aload 9
      //   3539: new 126	java/lang/String
      //   3542: dup
      //   3543: new 80	java/lang/StringBuilder
      //   3546: dup
      //   3547: invokespecial 81	java/lang/StringBuilder:<init>	()V
      //   3550: ldc -77
      //   3552: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3555: aload 24
      //   3557: invokevirtual 183	java/io/File:length	()J
      //   3560: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3563: ldc -68
      //   3565: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3568: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3571: invokespecial 190	java/lang/String:<init>	(Ljava/lang/String;)V
      //   3574: invokevirtual 170	java/lang/String:getBytes	()[B
      //   3577: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   3580: aload 8
      //   3582: astore 17
      //   3584: aload 10
      //   3586: astore 19
      //   3588: aload 9
      //   3590: astore 16
      //   3592: aload 8
      //   3594: astore 21
      //   3596: aload 10
      //   3598: astore 18
      //   3600: aload 9
      //   3602: astore 15
      //   3604: aload 8
      //   3606: astore 13
      //   3608: aload 10
      //   3610: astore 14
      //   3612: aload 9
      //   3614: astore 12
      //   3616: aload 8
      //   3618: astore 22
      //   3620: aload 10
      //   3622: astore 20
      //   3624: aload 9
      //   3626: astore 11
      //   3628: aload 9
      //   3630: ldc -64
      //   3632: invokevirtual 170	java/lang/String:getBytes	()[B
      //   3635: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   3638: aload 8
      //   3640: astore 17
      //   3642: aload 10
      //   3644: astore 19
      //   3646: aload 9
      //   3648: astore 16
      //   3650: aload 8
      //   3652: astore 21
      //   3654: aload 10
      //   3656: astore 18
      //   3658: aload 9
      //   3660: astore 15
      //   3662: aload 8
      //   3664: astore 13
      //   3666: aload 10
      //   3668: astore 14
      //   3670: aload 9
      //   3672: astore 12
      //   3674: aload 8
      //   3676: astore 22
      //   3678: aload 10
      //   3680: astore 20
      //   3682: aload 9
      //   3684: astore 11
      //   3686: aload 9
      //   3688: ldc -62
      //   3690: invokevirtual 170	java/lang/String:getBytes	()[B
      //   3693: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   3696: aload 8
      //   3698: astore 17
      //   3700: aload 10
      //   3702: astore 19
      //   3704: aload 9
      //   3706: astore 16
      //   3708: aload 8
      //   3710: astore 21
      //   3712: aload 10
      //   3714: astore 18
      //   3716: aload 9
      //   3718: astore 15
      //   3720: aload 8
      //   3722: astore 13
      //   3724: aload 10
      //   3726: astore 14
      //   3728: aload 9
      //   3730: astore 12
      //   3732: aload 8
      //   3734: astore 22
      //   3736: aload 10
      //   3738: astore 20
      //   3740: aload 9
      //   3742: astore 11
      //   3744: new 201	java/io/FileInputStream
      //   3747: dup
      //   3748: aload 24
      //   3750: invokespecial 255	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   3753: astore 10
      //   3755: aload 10
      //   3757: astore 11
      //   3759: aload 10
      //   3761: astore 12
      //   3763: aload 10
      //   3765: astore 13
      //   3767: aload 10
      //   3769: astore 14
      //   3771: aload 10
      //   3773: aload 23
      //   3775: invokevirtual 276	java/io/FileInputStream:read	([B)I
      //   3778: istore_1
      //   3779: iload_1
      //   3780: ifgt +28 -> 3808
      //   3783: aload 10
      //   3785: astore 11
      //   3787: aload 10
      //   3789: astore 12
      //   3791: aload 10
      //   3793: astore 13
      //   3795: aload 10
      //   3797: astore 14
      //   3799: ldc_w 278
      //   3802: invokestatic 252	com/millennialmedia/android/MMAdViewSDK$Log:i	(Ljava/lang/String;)V
      //   3805: goto -949 -> 2856
      //   3808: aload 10
      //   3810: astore 11
      //   3812: aload 10
      //   3814: astore 12
      //   3816: aload 10
      //   3818: astore 13
      //   3820: aload 10
      //   3822: astore 14
      //   3824: aload 9
      //   3826: aload 23
      //   3828: iconst_0
      //   3829: iload_1
      //   3830: invokevirtual 284	java/io/OutputStream:write	([BII)V
      //   3833: goto -78 -> 3755
      //   3836: astore 10
      //   3838: aload 9
      //   3840: astore 16
      //   3842: aload 12
      //   3844: astore 15
      //   3846: aload 10
      //   3848: astore 9
      //   3850: aload 8
      //   3852: astore 13
      //   3854: aload 15
      //   3856: astore 14
      //   3858: aload 16
      //   3860: astore 12
      //   3862: aload 9
      //   3864: invokevirtual 76	java/io/IOException:printStackTrace	()V
      //   3867: ldc -60
      //   3869: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   3872: aload 8
      //   3874: ifnull +8 -> 3882
      //   3877: aload 8
      //   3879: invokevirtual 199	java/net/Socket:close	()V
      //   3882: aload 15
      //   3884: ifnull +8 -> 3892
      //   3887: aload 15
      //   3889: invokevirtual 202	java/io/FileInputStream:close	()V
      //   3892: aload 8
      //   3894: astore 11
      //   3896: aload 15
      //   3898: astore 10
      //   3900: aload 16
      //   3902: astore 9
      //   3904: aload 16
      //   3906: ifnull -3890 -> 16
      //   3909: aload 16
      //   3911: invokevirtual 203	java/io/OutputStream:close	()V
      //   3914: aload 8
      //   3916: astore 11
      //   3918: aload 15
      //   3920: astore 10
      //   3922: aload 16
      //   3924: astore 9
      //   3926: goto -3910 -> 16
      //   3929: astore 9
      //   3931: aload 9
      //   3933: invokevirtual 76	java/io/IOException:printStackTrace	()V
      //   3936: aload 8
      //   3938: astore 11
      //   3940: aload 15
      //   3942: astore 10
      //   3944: aload 16
      //   3946: astore 9
      //   3948: goto -3932 -> 16
      //   3951: aload 8
      //   3953: astore 17
      //   3955: aload 10
      //   3957: astore 19
      //   3959: aload 9
      //   3961: astore 16
      //   3963: aload 8
      //   3965: astore 21
      //   3967: aload 10
      //   3969: astore 18
      //   3971: aload 9
      //   3973: astore 15
      //   3975: aload 8
      //   3977: astore 13
      //   3979: aload 10
      //   3981: astore 14
      //   3983: aload 9
      //   3985: astore 12
      //   3987: aload 8
      //   3989: astore 22
      //   3991: aload 10
      //   3993: astore 20
      //   3995: aload 9
      //   3997: astore 11
      //   3999: aload 9
      //   4001: ldc_w 287
      //   4004: invokevirtual 170	java/lang/String:getBytes	()[B
      //   4007: invokevirtual 175	java/io/OutputStream:write	([B)V
      //   4010: aload 8
      //   4012: astore 17
      //   4014: aload 10
      //   4016: astore 19
      //   4018: aload 9
      //   4020: astore 16
      //   4022: aload 8
      //   4024: astore 21
      //   4026: aload 10
      //   4028: astore 18
      //   4030: aload 9
      //   4032: astore 15
      //   4034: aload 8
      //   4036: astore 13
      //   4038: aload 10
      //   4040: astore 14
      //   4042: aload 9
      //   4044: astore 12
      //   4046: aload 8
      //   4048: astore 22
      //   4050: aload 10
      //   4052: astore 20
      //   4054: aload 9
      //   4056: astore 11
      //   4058: ldc_w 289
      //   4061: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   4064: aload 10
      //   4066: astore 13
      //   4068: aload 9
      //   4070: astore 12
      //   4072: goto -2909 -> 1163
      //   4075: astore 10
      //   4077: aload 21
      //   4079: astore 8
      //   4081: aload 15
      //   4083: astore 9
      //   4085: goto -777 -> 3308
      //   4088: astore 9
      //   4090: aload 8
      //   4092: astore 13
      //   4094: aload 15
      //   4096: astore 14
      //   4098: aload 16
      //   4100: astore 12
      //   4102: aload 9
      //   4104: invokevirtual 76	java/io/IOException:printStackTrace	()V
      //   4107: goto -1026 -> 3081
      //   4110: astore 8
      //   4112: aload 12
      //   4114: astore 9
      //   4116: ldc -60
      //   4118: invokestatic 97	com/millennialmedia/android/MMAdViewSDK$Log:v	(Ljava/lang/String;)V
      //   4121: aload 13
      //   4123: ifnull +8 -> 4131
      //   4126: aload 13
      //   4128: invokevirtual 199	java/net/Socket:close	()V
      //   4131: aload 14
      //   4133: ifnull +8 -> 4141
      //   4136: aload 14
      //   4138: invokevirtual 202	java/io/FileInputStream:close	()V
      //   4141: aload 9
      //   4143: ifnull +8 -> 4151
      //   4146: aload 9
      //   4148: invokevirtual 203	java/io/OutputStream:close	()V
      //   4151: aload 8
      //   4153: athrow
      //   4154: astore 9
      //   4156: aload 9
      //   4158: invokevirtual 76	java/io/IOException:printStackTrace	()V
      //   4161: goto -10 -> 4151
      //   4164: astore 8
      //   4166: aload 8
      //   4168: invokevirtual 76	java/io/IOException:printStackTrace	()V
      //   4171: return
      //   4172: astore 10
      //   4174: aload 13
      //   4176: astore 14
      //   4178: aload 8
      //   4180: astore 13
      //   4182: aload 10
      //   4184: astore 8
      //   4186: goto -70 -> 4116
      //   4189: astore 9
      //   4191: aload 22
      //   4193: astore 8
      //   4195: aload 20
      //   4197: astore 15
      //   4199: aload 11
      //   4201: astore 16
      //   4203: goto -353 -> 3850
      //   4206: astore 10
      //   4208: aload 14
      //   4210: astore 15
      //   4212: aload 9
      //   4214: astore 16
      //   4216: goto -1174 -> 3042
      //   4219: lload_2
      //   4220: iload_1
      //   4221: i2l
      //   4222: lsub
      //   4223: lstore 4
      //   4225: lload 4
      //   4227: lstore_2
      //   4228: lload 4
      //   4230: lconst_0
      //   4231: lcmp
      //   4232: ifgt -1426 -> 2806
      //   4235: goto -1379 -> 2856
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	4238	0	this	VideoServer
      //   2829	1392	1	i	int
      //   1735	2493	2	l1	long
      //   1732	2497	4	l2	long
      //   2498	306	6	l3	long
      //   78	1351	8	localSocket	java.net.Socket
      //   1495	1510	8	localIOException1	IOException
      //   3040	296	8	localObject1	Object
      //   3363	684	8	localIOException2	IOException
      //   4079	12	8	localObject2	Object
      //   4110	42	8	localObject3	Object
      //   4164	15	8	localIOException3	IOException
      //   4184	10	8	localObject4	Object
      //   4	1217	9	localObject5	Object
      //   1225	3	9	localIOException4	IOException
      //   1242	1897	9	localObject6	Object
      //   3143	3	9	localIOException5	IOException
      //   3160	765	9	localObject7	Object
      //   3929	3	9	localIOException6	IOException
      //   3946	138	9	localObject8	Object
      //   4088	15	9	localIOException7	IOException
      //   4114	33	9	localObject9	Object
      //   4154	3	9	localIOException8	IOException
      //   4189	24	9	localIOException9	IOException
      //   7	3015	10	localObject10	Object
      //   3032	23	10	localSocketTimeoutException1	java.net.SocketTimeoutException
      //   3112	174	10	localObject11	Object
      //   3302	435	10	localFileNotFoundException1	java.io.FileNotFoundException
      //   3753	68	10	localFileInputStream	java.io.FileInputStream
      //   3836	11	10	localIOException10	IOException
      //   3898	167	10	localObject12	Object
      //   4075	1	10	localFileNotFoundException2	java.io.FileNotFoundException
      //   4172	11	10	localObject13	Object
      //   4206	1	10	localSocketTimeoutException2	java.net.SocketTimeoutException
      //   1	4199	11	localObject14	Object
      //   57	4056	12	localObject15	Object
      //   49	4132	13	localObject16	Object
      //   53	4156	14	localObject17	Object
      //   45	4166	15	localObject18	Object
      //   33	4182	16	localObject19	Object
      //   25	3988	17	localObject20	Object
      //   41	3988	18	localObject21	Object
      //   29	3988	19	localObject22	Object
      //   65	4131	20	localObject23	Object
      //   37	4041	21	localObject24	Object
      //   61	4131	22	localObject25	Object
      //   14	3813	23	arrayOfByte	byte[]
      //   186	3563	24	localObject26	Object
      //   472	1665	25	localObject27	Object
      //   298	1899	26	localObject28	Object
      //   2142	123	27	str	String
      // Exception table:
      //   from	to	target	type
      //   1173	1178	1225	java/io/IOException
      //   1183	1188	1225	java/io/IOException
      //   1205	1210	1225	java/io/IOException
      //   1428	1433	1495	java/io/IOException
      //   1438	1443	1495	java/io/IOException
      //   1448	1453	1495	java/io/IOException
      //   71	80	3032	java/net/SocketTimeoutException
      //   128	133	3032	java/net/SocketTimeoutException
      //   181	188	3032	java/net/SocketTimeoutException
      //   236	243	3032	java/net/SocketTimeoutException
      //   291	300	3032	java/net/SocketTimeoutException
      //   348	356	3032	java/net/SocketTimeoutException
      //   404	419	3032	java/net/SocketTimeoutException
      //   467	474	3032	java/net/SocketTimeoutException
      //   522	532	3032	java/net/SocketTimeoutException
      //   580	594	3032	java/net/SocketTimeoutException
      //   642	647	3032	java/net/SocketTimeoutException
      //   695	730	3032	java/net/SocketTimeoutException
      //   778	832	3032	java/net/SocketTimeoutException
      //   880	890	3032	java/net/SocketTimeoutException
      //   938	948	3032	java/net/SocketTimeoutException
      //   996	1039	3032	java/net/SocketTimeoutException
      //   1087	1097	3032	java/net/SocketTimeoutException
      //   1145	1155	3032	java/net/SocketTimeoutException
      //   1295	1330	3032	java/net/SocketTimeoutException
      //   1378	1413	3032	java/net/SocketTimeoutException
      //   1553	1560	3032	java/net/SocketTimeoutException
      //   1608	1618	3032	java/net/SocketTimeoutException
      //   1666	1671	3032	java/net/SocketTimeoutException
      //   1719	1731	3032	java/net/SocketTimeoutException
      //   1784	1792	3032	java/net/SocketTimeoutException
      //   1840	1859	3032	java/net/SocketTimeoutException
      //   1907	1913	3032	java/net/SocketTimeoutException
      //   1964	1976	3032	java/net/SocketTimeoutException
      //   2024	2032	3032	java/net/SocketTimeoutException
      //   2080	2088	3032	java/net/SocketTimeoutException
      //   2136	2144	3032	java/net/SocketTimeoutException
      //   2192	2207	3032	java/net/SocketTimeoutException
      //   2260	2274	3032	java/net/SocketTimeoutException
      //   2325	2333	3032	java/net/SocketTimeoutException
      //   2384	2416	3032	java/net/SocketTimeoutException
      //   2464	2475	3032	java/net/SocketTimeoutException
      //   2904	2914	3032	java/net/SocketTimeoutException
      //   2962	2968	3032	java/net/SocketTimeoutException
      //   3016	3021	3032	java/net/SocketTimeoutException
      //   3421	3431	3032	java/net/SocketTimeoutException
      //   3479	3489	3032	java/net/SocketTimeoutException
      //   3537	3580	3032	java/net/SocketTimeoutException
      //   3628	3638	3032	java/net/SocketTimeoutException
      //   3686	3696	3032	java/net/SocketTimeoutException
      //   3744	3755	3032	java/net/SocketTimeoutException
      //   3999	4010	3032	java/net/SocketTimeoutException
      //   4058	4064	3032	java/net/SocketTimeoutException
      //   3091	3096	3143	java/io/IOException
      //   3101	3106	3143	java/io/IOException
      //   3123	3128	3143	java/io/IOException
      //   2491	2500	3302	java/io/FileNotFoundException
      //   2516	2534	3302	java/io/FileNotFoundException
      //   2558	2569	3302	java/io/FileNotFoundException
      //   2585	2596	3302	java/io/FileNotFoundException
      //   2612	2623	3302	java/io/FileNotFoundException
      //   2645	2695	3302	java/io/FileNotFoundException
      //   2711	2721	3302	java/io/FileNotFoundException
      //   2737	2777	3302	java/io/FileNotFoundException
      //   2793	2803	3302	java/io/FileNotFoundException
      //   2822	2830	3302	java/io/FileNotFoundException
      //   2850	2856	3302	java/io/FileNotFoundException
      //   3181	3235	3302	java/io/FileNotFoundException
      //   3261	3270	3302	java/io/FileNotFoundException
      //   3289	3299	3302	java/io/FileNotFoundException
      //   3771	3779	3302	java/io/FileNotFoundException
      //   3799	3805	3302	java/io/FileNotFoundException
      //   3824	3833	3302	java/io/FileNotFoundException
      //   3335	3340	3363	java/io/IOException
      //   3345	3350	3363	java/io/IOException
      //   3355	3360	3363	java/io/IOException
      //   2491	2500	3836	java/io/IOException
      //   2516	2534	3836	java/io/IOException
      //   2558	2569	3836	java/io/IOException
      //   2585	2596	3836	java/io/IOException
      //   2612	2623	3836	java/io/IOException
      //   2645	2695	3836	java/io/IOException
      //   2711	2721	3836	java/io/IOException
      //   2737	2777	3836	java/io/IOException
      //   2793	2803	3836	java/io/IOException
      //   2822	2830	3836	java/io/IOException
      //   2850	2856	3836	java/io/IOException
      //   3181	3235	3836	java/io/IOException
      //   3261	3270	3836	java/io/IOException
      //   3289	3299	3836	java/io/IOException
      //   3771	3779	3836	java/io/IOException
      //   3799	3805	3836	java/io/IOException
      //   3824	3833	3836	java/io/IOException
      //   3877	3882	3929	java/io/IOException
      //   3887	3892	3929	java/io/IOException
      //   3909	3914	3929	java/io/IOException
      //   71	80	4075	java/io/FileNotFoundException
      //   128	133	4075	java/io/FileNotFoundException
      //   181	188	4075	java/io/FileNotFoundException
      //   236	243	4075	java/io/FileNotFoundException
      //   291	300	4075	java/io/FileNotFoundException
      //   348	356	4075	java/io/FileNotFoundException
      //   404	419	4075	java/io/FileNotFoundException
      //   467	474	4075	java/io/FileNotFoundException
      //   522	532	4075	java/io/FileNotFoundException
      //   580	594	4075	java/io/FileNotFoundException
      //   642	647	4075	java/io/FileNotFoundException
      //   695	730	4075	java/io/FileNotFoundException
      //   778	832	4075	java/io/FileNotFoundException
      //   880	890	4075	java/io/FileNotFoundException
      //   938	948	4075	java/io/FileNotFoundException
      //   996	1039	4075	java/io/FileNotFoundException
      //   1087	1097	4075	java/io/FileNotFoundException
      //   1145	1155	4075	java/io/FileNotFoundException
      //   1295	1330	4075	java/io/FileNotFoundException
      //   1378	1413	4075	java/io/FileNotFoundException
      //   1553	1560	4075	java/io/FileNotFoundException
      //   1608	1618	4075	java/io/FileNotFoundException
      //   1666	1671	4075	java/io/FileNotFoundException
      //   1719	1731	4075	java/io/FileNotFoundException
      //   1784	1792	4075	java/io/FileNotFoundException
      //   1840	1859	4075	java/io/FileNotFoundException
      //   1907	1913	4075	java/io/FileNotFoundException
      //   1964	1976	4075	java/io/FileNotFoundException
      //   2024	2032	4075	java/io/FileNotFoundException
      //   2080	2088	4075	java/io/FileNotFoundException
      //   2136	2144	4075	java/io/FileNotFoundException
      //   2192	2207	4075	java/io/FileNotFoundException
      //   2260	2274	4075	java/io/FileNotFoundException
      //   2325	2333	4075	java/io/FileNotFoundException
      //   2384	2416	4075	java/io/FileNotFoundException
      //   2464	2475	4075	java/io/FileNotFoundException
      //   2904	2914	4075	java/io/FileNotFoundException
      //   2962	2968	4075	java/io/FileNotFoundException
      //   3016	3021	4075	java/io/FileNotFoundException
      //   3421	3431	4075	java/io/FileNotFoundException
      //   3479	3489	4075	java/io/FileNotFoundException
      //   3537	3580	4075	java/io/FileNotFoundException
      //   3628	3638	4075	java/io/FileNotFoundException
      //   3686	3696	4075	java/io/FileNotFoundException
      //   3744	3755	4075	java/io/FileNotFoundException
      //   3999	4010	4075	java/io/FileNotFoundException
      //   4058	4064	4075	java/io/FileNotFoundException
      //   3076	3081	4088	java/io/IOException
      //   71	80	4110	finally
      //   128	133	4110	finally
      //   181	188	4110	finally
      //   236	243	4110	finally
      //   291	300	4110	finally
      //   348	356	4110	finally
      //   404	419	4110	finally
      //   467	474	4110	finally
      //   522	532	4110	finally
      //   580	594	4110	finally
      //   642	647	4110	finally
      //   695	730	4110	finally
      //   778	832	4110	finally
      //   880	890	4110	finally
      //   938	948	4110	finally
      //   996	1039	4110	finally
      //   1087	1097	4110	finally
      //   1145	1155	4110	finally
      //   1295	1330	4110	finally
      //   1378	1413	4110	finally
      //   1553	1560	4110	finally
      //   1608	1618	4110	finally
      //   1666	1671	4110	finally
      //   1719	1731	4110	finally
      //   1784	1792	4110	finally
      //   1840	1859	4110	finally
      //   1907	1913	4110	finally
      //   1964	1976	4110	finally
      //   2024	2032	4110	finally
      //   2080	2088	4110	finally
      //   2136	2144	4110	finally
      //   2192	2207	4110	finally
      //   2260	2274	4110	finally
      //   2325	2333	4110	finally
      //   2384	2416	4110	finally
      //   2464	2475	4110	finally
      //   2904	2914	4110	finally
      //   2962	2968	4110	finally
      //   3016	3021	4110	finally
      //   3054	3059	4110	finally
      //   3076	3081	4110	finally
      //   3320	3325	4110	finally
      //   3421	3431	4110	finally
      //   3479	3489	4110	finally
      //   3537	3580	4110	finally
      //   3628	3638	4110	finally
      //   3686	3696	4110	finally
      //   3744	3755	4110	finally
      //   3862	3867	4110	finally
      //   3999	4010	4110	finally
      //   4058	4064	4110	finally
      //   4102	4107	4110	finally
      //   4126	4131	4154	java/io/IOException
      //   4136	4141	4154	java/io/IOException
      //   4146	4151	4154	java/io/IOException
      //   1465	1494	4164	java/io/IOException
      //   2491	2500	4172	finally
      //   2516	2534	4172	finally
      //   2558	2569	4172	finally
      //   2585	2596	4172	finally
      //   2612	2623	4172	finally
      //   2645	2695	4172	finally
      //   2711	2721	4172	finally
      //   2737	2777	4172	finally
      //   2793	2803	4172	finally
      //   2822	2830	4172	finally
      //   2850	2856	4172	finally
      //   3181	3235	4172	finally
      //   3261	3270	4172	finally
      //   3289	3299	4172	finally
      //   3771	3779	4172	finally
      //   3799	3805	4172	finally
      //   3824	3833	4172	finally
      //   71	80	4189	java/io/IOException
      //   128	133	4189	java/io/IOException
      //   181	188	4189	java/io/IOException
      //   236	243	4189	java/io/IOException
      //   291	300	4189	java/io/IOException
      //   348	356	4189	java/io/IOException
      //   404	419	4189	java/io/IOException
      //   467	474	4189	java/io/IOException
      //   522	532	4189	java/io/IOException
      //   580	594	4189	java/io/IOException
      //   642	647	4189	java/io/IOException
      //   695	730	4189	java/io/IOException
      //   778	832	4189	java/io/IOException
      //   880	890	4189	java/io/IOException
      //   938	948	4189	java/io/IOException
      //   996	1039	4189	java/io/IOException
      //   1087	1097	4189	java/io/IOException
      //   1145	1155	4189	java/io/IOException
      //   1295	1330	4189	java/io/IOException
      //   1378	1413	4189	java/io/IOException
      //   1553	1560	4189	java/io/IOException
      //   1608	1618	4189	java/io/IOException
      //   1666	1671	4189	java/io/IOException
      //   1719	1731	4189	java/io/IOException
      //   1784	1792	4189	java/io/IOException
      //   1840	1859	4189	java/io/IOException
      //   1907	1913	4189	java/io/IOException
      //   1964	1976	4189	java/io/IOException
      //   2024	2032	4189	java/io/IOException
      //   2080	2088	4189	java/io/IOException
      //   2136	2144	4189	java/io/IOException
      //   2192	2207	4189	java/io/IOException
      //   2260	2274	4189	java/io/IOException
      //   2325	2333	4189	java/io/IOException
      //   2384	2416	4189	java/io/IOException
      //   2464	2475	4189	java/io/IOException
      //   2904	2914	4189	java/io/IOException
      //   2962	2968	4189	java/io/IOException
      //   3016	3021	4189	java/io/IOException
      //   3421	3431	4189	java/io/IOException
      //   3479	3489	4189	java/io/IOException
      //   3537	3580	4189	java/io/IOException
      //   3628	3638	4189	java/io/IOException
      //   3686	3696	4189	java/io/IOException
      //   3744	3755	4189	java/io/IOException
      //   3999	4010	4189	java/io/IOException
      //   4058	4064	4189	java/io/IOException
      //   2491	2500	4206	java/net/SocketTimeoutException
      //   2516	2534	4206	java/net/SocketTimeoutException
      //   2558	2569	4206	java/net/SocketTimeoutException
      //   2585	2596	4206	java/net/SocketTimeoutException
      //   2612	2623	4206	java/net/SocketTimeoutException
      //   2645	2695	4206	java/net/SocketTimeoutException
      //   2711	2721	4206	java/net/SocketTimeoutException
      //   2737	2777	4206	java/net/SocketTimeoutException
      //   2793	2803	4206	java/net/SocketTimeoutException
      //   2822	2830	4206	java/net/SocketTimeoutException
      //   2850	2856	4206	java/net/SocketTimeoutException
      //   3181	3235	4206	java/net/SocketTimeoutException
      //   3261	3270	4206	java/net/SocketTimeoutException
      //   3289	3299	4206	java/net/SocketTimeoutException
      //   3771	3779	4206	java/net/SocketTimeoutException
      //   3799	3805	4206	java/net/SocketTimeoutException
      //   3824	3833	4206	java/net/SocketTimeoutException
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/millennialmedia/android/VideoPlayerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */