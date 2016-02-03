package com.millennialmedia.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

class CachedVideoPlayerActivity
  extends VideoPlayerActivity
  implements Handler.Callback
{
  private static final int STATIC_HUD_ID = 402;
  private static final int STATIC_HUD_SECONDS_ID = 401;
  private RelativeLayout buttonsLayout;
  private boolean hasCountdownHud = true;
  boolean hasLoadedCompletionUrl;
  boolean hasWebOverlay;
  private TextView hudSeconds;
  private TextView hudStaticText;
  private int lastVideoPosition;
  private Handler logTimeAndEventhandler;
  private MMWebView mWebView;
  private VideoAd videoAd;
  
  private String calculateHudSecondsText()
  {
    if (this.currentVideoPosition != 0) {
      return String.valueOf(this.currentVideoPosition / 1000);
    }
    if (this.videoAd != null) {
      return String.valueOf(this.videoAd.duration / 1000L);
    }
    return "";
  }
  
  private void dismissAfter(long paramLong)
  {
    this.logTimeAndEventhandler.postDelayed(new Runnable()
    {
      public void run()
      {
        CachedVideoPlayerActivity.this.dismiss();
      }
    }, paramLong);
  }
  
  private void fadeButton(VideoImage paramVideoImage)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramVideoImage.fromAlpha, paramVideoImage.toAlpha);
    localAlphaAnimation.setDuration(paramVideoImage.fadeDuration);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setFillBefore(true);
    localAlphaAnimation.setFillAfter(true);
    paramVideoImage.button.startAnimation(localAlphaAnimation);
  }
  
  private void fadeButtons()
  {
    if ((this.videoAd != null) && (this.videoAd.buttons != null))
    {
      int i = 0;
      while (i < this.videoAd.buttons.size())
      {
        VideoImage localVideoImage = (VideoImage)this.videoAd.buttons.get(i);
        if (!localVideoImage.isLeaveBehind) {
          setButtonAlpha(localVideoImage.button, localVideoImage.fromAlpha);
        }
        if (localVideoImage.button.getParent() == null) {
          this.buttonsLayout.addView(localVideoImage.button, localVideoImage.layoutParams);
        }
        int j = 0;
        while (j < this.videoAd.buttons.size())
        {
          this.buttonsLayout.bringChildToFront(((VideoImage)this.videoAd.buttons.get(j)).button);
          j += 1;
        }
        MMSDK.Log.v("Button: %d alpha: %f", new Object[] { Integer.valueOf(i), Float.valueOf(localVideoImage.fromAlpha) });
        i += 1;
      }
    }
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
  
  private void initHudSeconds(ViewGroup paramViewGroup)
  {
    this.hudSeconds = new TextView(this.activity);
    this.hudSeconds.setText(calculateHudSecondsText());
    this.hudSeconds.setTextColor(-1);
    this.hudSeconds.setId(401);
    this.hudSeconds.setShadowLayer(1.0F, 0.0F, 0.0F, -16777216);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(0, 402);
    paramViewGroup.addView(this.hudSeconds, localLayoutParams);
  }
  
  private void initHudStaticText(ViewGroup paramViewGroup)
  {
    this.hudStaticText = new TextView(this.activity);
    this.hudStaticText.setText(" seconds remaining ...");
    this.hudStaticText.setTextColor(-1);
    this.hudStaticText.setPadding(0, 0, 5, 0);
    this.hudStaticText.setId(402);
    this.hudStaticText.setShadowLayer(1.0F, 0.0F, 0.0F, -16777216);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(11);
    paramViewGroup.addView(this.hudStaticText, localLayoutParams);
  }
  
  private void initWebOverlay()
  {
    this.mWebView = new MMWebView(this.activity, this.activity.creatorAdImplInternalId);
    this.mWebView.setId(413);
    Object localObject = new CachedVideoWebViewClientListener(this);
    this.mWebView.setWebViewClient(new InterstitialWebViewClient((MMWebViewClient.MMWebViewClientListener)localObject, this.redirectListenerImpl));
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.mWebView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mWebView.setBackgroundColor(0);
    loadUrlForMraidInjection(this.videoAd.webOverlayURL);
  }
  
  private void onPageFinished(String paramString)
  {
    if ((this.mVideoView != null) && (this.videoAd != null) && (!this.mVideoView.isPlaying()) && (this.videoAd.webOverlayURL != null) && (paramString.equalsIgnoreCase(this.videoAd.webOverlayURL))) {
      playVideo(0);
    }
  }
  
  private void showHud()
  {
    if (this.videoAd != null) {
      this.hudSeconds.setText(String.valueOf(this.videoAd.duration / 1000L));
    }
    this.hudStaticText.setVisibility(0);
    this.hudSeconds.setVisibility(0);
  }
  
  protected boolean canFadeButtons()
  {
    return (!this.videoAd.stayInPlayer) || (!super.canFadeButtons());
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.videoAd != null)
    {
      if (this.logTimeAndEventhandler != null) {
        this.logTimeAndEventhandler.removeMessages(1);
      }
      if (!this.hasWebOverlay)
      {
        int i = 0;
        if (i < this.videoAd.buttons.size())
        {
          VideoImage localVideoImage = (VideoImage)this.videoAd.buttons.get(i);
          setButtonAlpha(localVideoImage.button, localVideoImage.fromAlpha);
          Object localObject;
          if (localVideoImage.inactivityTimeout > 0L)
          {
            localObject = Message.obtain(this.logTimeAndEventhandler, 1, localVideoImage);
            this.logTimeAndEventhandler.sendMessageDelayed((Message)localObject, localVideoImage.inactivityTimeout);
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
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void enableButtons()
  {
    super.enableButtons();
    if ((this.hasWebOverlay) || (this.videoAd == null) || (this.videoAd.buttons == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.videoAd.buttons.iterator();
      while (localIterator.hasNext())
      {
        VideoImage localVideoImage = (VideoImage)localIterator.next();
        if (localVideoImage.button != null) {
          localVideoImage.button.setEnabled(true);
        }
      }
    }
  }
  
  protected void errorPlayVideo(String paramString)
  {
    if (this.videoAd != null) {
      HttpGetRequest.log(this.videoAd.videoError);
    }
    if (this.mWebView != null) {
      this.mWebView.loadUrl("javascript:MMJS.cachedVideo.setError(" + paramString + ");");
    }
    super.errorPlayVideo(paramString);
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
          fadeButton((VideoImage)paramMessage.obj);
          continue;
          paramMessage = (VideoImage)paramMessage.obj;
          try
          {
            if (this.buttonsLayout.indexOfChild(paramMessage.button) == -1) {
              this.buttonsLayout.addView(paramMessage.button, paramMessage.layoutParams);
            }
            if (canFadeButtons())
            {
              fadeButton(paramMessage);
              MMSDK.Log.v("Beginning animation to visibility. Fade duration: %d Button: %d Time: %d", new Object[] { Long.valueOf(paramMessage.fadeDuration), Integer.valueOf(paramMessage.button.getId()), Long.valueOf(System.currentTimeMillis()) });
            }
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
      try
      {
        if ((this.mVideoView != null) && (this.mVideoView.isPlaying()))
        {
          int k = this.mVideoView.getCurrentPosition();
          if (k > this.lastVideoPosition)
          {
            if (this.videoAd != null)
            {
              if (this.lastVideoPosition != 0) {
                break label454;
              }
              this.videoAd.logBeginEvent();
              break label454;
              if (i < this.videoAd.activities.size())
              {
                paramMessage = (VideoLogEvent)this.videoAd.activities.get(i);
                if ((paramMessage == null) || (paramMessage.position < this.lastVideoPosition) || (paramMessage.position >= k)) {
                  break label459;
                }
                int j = 0;
                if (j >= paramMessage.activities.length) {
                  break label459;
                }
                MMSDK.Event.logEvent(paramMessage.activities[j]);
                j += 1;
                continue;
              }
            }
            this.lastVideoPosition = k;
          }
          if ((this.hasWebOverlay) && (this.mWebView != null)) {
            this.mWebView.loadUrl("javascript:MMJS.cachedVideo.updateVideoSeekTime(" + (float)Math.floor(k / 1000.0F) + ");");
          }
          if (this.hasCountdownHud)
          {
            long l = (this.videoAd.duration - k) / 1000L;
            if (l <= 0L) {
              break label447;
            }
            if (this.hudSeconds != null) {
              this.hudSeconds.setText(String.valueOf(l));
            }
          }
        }
        this.logTimeAndEventhandler.sendMessageDelayed(Message.obtain(this.logTimeAndEventhandler, 2), 500L);
      }
      catch (IllegalStateException paramMessage)
      {
        paramMessage.printStackTrace();
      }
      break;
      label447:
      hideHud();
      continue;
      label454:
      int i = 0;
      continue;
      label459:
      i += 1;
    }
  }
  
  protected RelativeLayout initLayout()
  {
    RelativeLayout localRelativeLayout = super.initLayout();
    this.logTimeAndEventhandler = new Handler(this);
    setRequestedOrientation(0);
    if (this.hasCountdownHud)
    {
      initHudStaticText(localRelativeLayout);
      initHudSeconds(localRelativeLayout);
      showHud();
    }
    if ((this.videoAd != null) && (this.videoAd.webOverlayURL != null))
    {
      initWebOverlay();
      if (this.mWebView != null)
      {
        localRelativeLayout.addView(this.mWebView);
        this.hasWebOverlay = true;
      }
    }
    do
    {
      return localRelativeLayout;
      this.hasWebOverlay = false;
      this.buttonsLayout = new RelativeLayout(this.activity);
      this.buttonsLayout.setId(1000);
      ArrayList localArrayList = null;
      if (this.videoAd != null) {
        localArrayList = this.videoAd.buttons;
      }
      if (localArrayList != null)
      {
        File localFile = AdCache.getCacheDirectory(this.activity);
        int i = 0;
        final VideoImage localVideoImage;
        final ImageButton localImageButton;
        if (i < localArrayList.size())
        {
          localVideoImage = (VideoImage)localArrayList.get(i);
          localImageButton = new ImageButton(this.activity);
          localVideoImage.button = localImageButton;
          for (;;)
          {
            try
            {
              localObject = BitmapFactory.decodeFile(localFile.getAbsolutePath() + File.separator + this.videoAd.getId() + Uri.parse(localVideoImage.imageUrl).getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat"));
              if (localObject == null) {
                continue;
              }
              localImageButton.setImageBitmap((Bitmap)localObject);
            }
            catch (Exception localException)
            {
              Object localObject;
              MMSDK.Log.e(localException);
              continue;
              localImageButton.setBackgroundColor(0);
              RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
              MMSDK.Log.v("Button: %d Anchor: %d Position: %d Anchor2: %d Position2: %d", new Object[] { Integer.valueOf(localImageButton.getId()), Integer.valueOf(localVideoImage.anchor), Integer.valueOf(localVideoImage.position), Integer.valueOf(localVideoImage.anchor2), Integer.valueOf(localVideoImage.position2) });
              localLayoutParams.addRule(localVideoImage.position, localVideoImage.anchor);
              localLayoutParams.addRule(localVideoImage.position2, localVideoImage.anchor2);
              localLayoutParams.setMargins(localVideoImage.paddingLeft, localVideoImage.paddingTop, localVideoImage.paddingRight, localVideoImage.paddingBottom);
              continue;
              this.buttonsLayout.addView(localImageButton, localLayoutParams);
              continue;
            }
            setButtonAlpha(localImageButton, localVideoImage.fromAlpha);
            localImageButton.setId(i + 1);
            localImageButton.setPadding(0, 0, 0, 0);
            if (!localVideoImage.isLeaveBehind) {
              continue;
            }
            localImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
            localImageButton.setBackgroundColor(-16777216);
            localObject = new RelativeLayout.LayoutParams(-1, -1);
            if (!TextUtils.isEmpty(localVideoImage.linkUrl)) {
              localImageButton.setOnClickListener(new View.OnClickListener()
              {
                public void onClick(View paramAnonymousView)
                {
                  if (localImageButton != null) {
                    localImageButton.setEnabled(false);
                  }
                  CachedVideoPlayerActivity.this.redirectListenerImpl.orientation = localVideoImage.overlayOrientation;
                  CachedVideoPlayerActivity.this.dispatchButtonClick(localVideoImage.linkUrl);
                  CachedVideoPlayerActivity.this.logButtonEvent(localVideoImage);
                }
              });
            }
            if (localVideoImage.appearanceDelay <= 0L) {
              continue;
            }
            localVideoImage.layoutParams = ((RelativeLayout.LayoutParams)localObject);
            localObject = Message.obtain(this.logTimeAndEventhandler, 3, localVideoImage);
            this.logTimeAndEventhandler.sendMessageDelayed((Message)localObject, localVideoImage.appearanceDelay);
            if (localVideoImage.inactivityTimeout > 0L)
            {
              localObject = Message.obtain(this.logTimeAndEventhandler, 1, localVideoImage);
              this.logTimeAndEventhandler.sendMessageDelayed((Message)localObject, localVideoImage.inactivityTimeout + localVideoImage.appearanceDelay + localVideoImage.fadeDuration);
            }
            i += 1;
            break;
            localImageButton.setImageURI(Uri.parse(localFile.getAbsolutePath() + File.separator + this.videoAd.getId() + Uri.parse(localVideoImage.imageUrl).getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat")));
          }
        }
        localRelativeLayout.addView(this.buttonsLayout, new RelativeLayout.LayoutParams(-1, -1));
      }
      if (this.buttonsLayout != null) {
        localRelativeLayout.bringChildToFront(this.buttonsLayout);
      }
    } while (this.mWebView == null);
    localRelativeLayout.bringChildToFront(this.mWebView);
    return localRelativeLayout;
  }
  
  protected void initSavedInstance(Bundle paramBundle)
  {
    super.initSavedInstance(paramBundle);
    if (paramBundle == null)
    {
      paramBundle = getIntent().getStringExtra("videoId");
      this.videoAd = ((VideoAd)AdCache.load(this.activity, paramBundle));
      if (this.videoAd != null)
      {
        this.hasBottomBar = this.videoAd.showControls;
        this.hasCountdownHud = this.videoAd.showCountdown;
      }
      return;
    }
    this.videoAd = ((VideoAd)paramBundle.getParcelable("videoAd"));
    this.hasBottomBar = paramBundle.getBoolean("shouldShowBottomBar");
    this.lastVideoPosition = paramBundle.getInt("lastVideoPosition");
    this.currentVideoPosition = paramBundle.getInt("currentVideoPosition");
    this.hasCountdownHud = this.videoAd.showCountdown;
  }
  
  void loadUrlForMraidInjection(String paramString)
  {
    new FetchWebViewContentTask(paramString).execute(new Void[0]);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    super.onCompletion(paramMediaPlayer);
    if (this.hasCountdownHud) {
      hideHud();
    }
    if (this.videoAd != null) {
      videoPlayerOnCompletion(this.videoAd.onCompletionUrl);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.adProperties = new AdProperties(this.activity);
    MMSDK.Log.v("Is Cached Ad");
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    errorPlayVideo(String.format("Error while playing, %d - %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    return super.onError(paramMediaPlayer, paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    this.videoAd = ((VideoAd)paramBundle.getParcelable("videoAd"));
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.mWebView != null) {
      this.mWebView.bringToFront();
    }
    if (this.buttonsLayout != null) {
      this.buttonsLayout.bringToFront();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("videoAd", this.videoAd);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    if ((!this.hasWebOverlay) && (this.videoAd != null) && (this.videoAd.stayInPlayer == true) && (this.isVideoCompleted == true)) {
      fadeButtons();
    }
  }
  
  protected void pauseVideo()
  {
    super.pauseVideo();
    this.logTimeAndEventhandler.removeMessages(1);
    this.logTimeAndEventhandler.removeMessages(2);
    this.logTimeAndEventhandler.removeMessages(3);
  }
  
  protected void playVideo(int paramInt)
  {
    if (this.videoAd == null)
    {
      Toast.makeText(this.activity, "Sorry. There was a problem playing the video", 1).show();
      return;
    }
    if ((!this.logTimeAndEventhandler.hasMessages(2)) && (this.videoAd != null)) {
      this.logTimeAndEventhandler.sendMessageDelayed(Message.obtain(this.logTimeAndEventhandler, 2), 1000L);
    }
    super.playVideo(paramInt);
  }
  
  protected void restartVideo()
  {
    if (this.videoAd != null)
    {
      if (((this.hasLoadedCompletionUrl) || (this.videoAd.reloadNonEndOverlayOnRestart)) && (this.videoAd.webOverlayURL != null) && (this.mWebView != null))
      {
        loadUrlForMraidInjection(this.videoAd.webOverlayURL);
        this.hasLoadedCompletionUrl = false;
      }
      ArrayList localArrayList = this.videoAd.buttons;
      this.logTimeAndEventhandler.removeMessages(1);
      this.logTimeAndEventhandler.removeMessages(2);
      this.logTimeAndEventhandler.removeMessages(3);
      this.lastVideoPosition = 0;
      if ((!this.hasWebOverlay) && (this.buttonsLayout != null) && (localArrayList != null))
      {
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
              this.buttonsLayout.removeView((View)localObject);
              localObject = Message.obtain(this.logTimeAndEventhandler, 3, localVideoImage);
              this.logTimeAndEventhandler.sendMessageDelayed((Message)localObject, localVideoImage.appearanceDelay);
            }
            if (localVideoImage.inactivityTimeout > 0L)
            {
              localObject = Message.obtain(this.logTimeAndEventhandler, 1, localVideoImage);
              this.logTimeAndEventhandler.sendMessageDelayed((Message)localObject, localVideoImage.inactivityTimeout + localVideoImage.appearanceDelay + localVideoImage.fadeDuration);
            }
          }
          i += 1;
        }
      }
      if (this.logTimeAndEventhandler != null) {
        this.logTimeAndEventhandler.sendMessageDelayed(Message.obtain(this.logTimeAndEventhandler, 2), 1000L);
      }
      if (this.hasCountdownHud) {
        showHud();
      }
    }
    super.restartVideo();
  }
  
  protected void resumeVideo()
  {
    if (this.videoAd != null)
    {
      if (!this.logTimeAndEventhandler.hasMessages(2)) {
        this.logTimeAndEventhandler.sendMessageDelayed(Message.obtain(this.logTimeAndEventhandler, 2), 1000L);
      }
      if (!this.hasWebOverlay)
      {
        long l1;
        if (this.hasCountdownHud)
        {
          l1 = (this.videoAd.duration - this.currentVideoPosition) / 1000L;
          if (l1 <= 0L) {
            break label272;
          }
          if (this.hudSeconds != null) {
            this.hudSeconds.setText(String.valueOf(l1));
          }
        }
        while (this.videoAd.buttons != null)
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
                localMessage = Message.obtain(this.logTimeAndEventhandler, 3, localVideoImage);
                l2 = localVideoImage.appearanceDelay - this.currentVideoPosition;
                l1 = l2;
                if (l2 < 0L) {
                  l1 = 500L;
                }
                this.logTimeAndEventhandler.sendMessageDelayed(localMessage, l1);
              }
            }
            if (localVideoImage.inactivityTimeout > 0L)
            {
              localMessage = Message.obtain(this.logTimeAndEventhandler, 1, localVideoImage);
              this.logTimeAndEventhandler.sendMessageDelayed(localMessage, localVideoImage.inactivityTimeout + l1 + localVideoImage.fadeDuration);
            }
            i += 1;
          }
          label272:
          hideHud();
        }
      }
    }
    super.resumeVideo();
  }
  
  protected void videoPlayerOnCompletion(String paramString)
  {
    if (paramString != null) {
      dispatchButtonClick(paramString);
    }
    if (this.videoAd != null)
    {
      this.videoAd.logEndEvent();
      if (!this.videoAd.stayInPlayer) {
        dismiss();
      }
    }
    else
    {
      return;
    }
    if ((!this.hasWebOverlay) && (this.videoAd.buttons != null))
    {
      fadeButtons();
      if (!this.videoAd.hasEndCard()) {
        dismiss();
      }
    }
    if ((this.mWebView != null) && (!TextUtils.isEmpty(this.videoAd.endOverlayURL)))
    {
      loadUrlForMraidInjection(this.videoAd.endOverlayURL);
      this.mWebView.bringToFront();
    }
    for (;;)
    {
      if (this.videoAd.closeDelayMillis != 0L) {
        dismissAfter(this.videoAd.closeDelayMillis);
      }
      this.logTimeAndEventhandler.removeMessages(1);
      this.logTimeAndEventhandler.removeMessages(2);
      this.logTimeAndEventhandler.removeMessages(3);
      return;
      if (this.hasWebOverlay) {
        dismiss();
      }
    }
  }
  
  private static class CachedVideoWebViewClientListener
    extends MMWebViewClient.MMWebViewClientListener
  {
    WeakReference<CachedVideoPlayerActivity> activityRef;
    
    CachedVideoWebViewClientListener(CachedVideoPlayerActivity paramCachedVideoPlayerActivity)
    {
      this.activityRef = new WeakReference(paramCachedVideoPlayerActivity);
    }
    
    public void onPageFinished(String paramString)
    {
      MMSDK.Log.d("@@ ON PAGE FINISHED" + paramString);
      CachedVideoPlayerActivity localCachedVideoPlayerActivity = (CachedVideoPlayerActivity)this.activityRef.get();
      if (localCachedVideoPlayerActivity != null) {
        localCachedVideoPlayerActivity.onPageFinished(paramString);
      }
    }
  }
  
  class FetchWebViewContentTask
    extends AsyncTask<Void, Void, String>
  {
    private String baseUrl;
    private boolean cancelVideo;
    
    public FetchWebViewContentTask(String paramString)
    {
      this.baseUrl = paramString;
    }
    
    protected String doInBackground(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = new HttpGetRequest().get(this.baseUrl);
        StatusLine localStatusLine = paramVarArgs.getStatusLine();
        if ((paramVarArgs != null) && (localStatusLine != null) && (localStatusLine.getStatusCode() != 404))
        {
          paramVarArgs = paramVarArgs.getEntity();
          if (paramVarArgs != null) {
            return HttpGetRequest.convertStreamToString(paramVarArgs.getContent());
          }
        }
        else
        {
          this.cancelVideo = true;
        }
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          paramVarArgs.printStackTrace();
        }
      }
      return null;
    }
    
    protected void onPostExecute(String paramString)
    {
      if (this.cancelVideo) {
        CachedVideoPlayerActivity.this.dismiss();
      }
      if ((paramString != null) && (CachedVideoPlayerActivity.this.mWebView != null))
      {
        CachedVideoPlayerActivity.this.mWebView.setWebViewContent(paramString, this.baseUrl, CachedVideoPlayerActivity.this.activity);
        CachedVideoPlayerActivity.this.hasLoadedCompletionUrl = true;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/CachedVideoPlayerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */