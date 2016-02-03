package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.millennialmedia.google.gson.Gson;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class InlineVideoView
  extends VideoView
  implements Serializable
{
  private static final String ANCHOR_IN_PNG = "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABOpJREFUeNrUmmtIY0cUgCfJ3VBXUXxR0dp2Ya0aBSFi6yOtFPGF1d1WavrAXy1YwVcLLaQpttsH+lcbirYq0a3Ptd0WpKi1P1SMaAitJNptalcQIwV/iI+o2ST39kx6I9cY3STcuSYHhjuTzD33fJk5M+fciWh9fR0tLCwgrhwfH6OcnBwkl8ur9vb2DIODg5aIiAjkq1itViQWi1FYWBgiKYmJiQhptdpzX6SlpSGz2fwRwzDHR0dH83V1dYn+KK6oqLjR19enQISluLgYof7+/jMfZmRkIIvFcoc5K783NTU95YvSsrKyFLvd/s/a2pqRNEBJSclZAJlMhra2tjyNP4Vobm5OukxhaWlpysnJyQPceXl5WS8SicgDDAwMuBrp6enY+M+Zy2UFIJ72pqy8vDwFfOcvd0ebzWYoLCwkD9DR0YFSU1Ox8W2Mb7IKEM+4lWBnHRoaSnM6nX97jhhAkQfQ6/XXNjY27jD+iamhoeFZiqLQyMhIOrQfeuljhCklJg4AD7rFBCA0Tf+h0+luQ9V80UgBAEUaQAzrvB7qk/7eDA6alZeXdx+qKRd0wb++hPRKJIZNaru+vv4NqP/Gs25sPEUcIDw8HHV1de2BY1bzDCFmC1kA91rd2dmJIV6D6nRIjQC3ARD7LMQvPOmWCArAQlhbWlqUPEBIrgQAC2xuh42NjUoI5O5BkwmpEXCLRqM5XFlZ+Qaq9qB2Yq9jL5HgHRaW+bzvoSkNZic+9wA2tnmxpqbmB2jGB7sPUB67KzZeAcb/CM24kHBi9z6Ar8PDwy8plcr7PBgvnBND9uSa82D8y2D8TzwZLxgAhRN4yF+zwfhfeX7gdSjXiANgp11cXDyCjOxr1ick7MojYQ2g2Cu3fvpZcnKyOCEhQcL5xd1XK+QLu8QB2GDuTyjvB6IgKSkJZWZmejouLrTBYLAJvoz6KxaLxVVYcbLljOTm5oqioqLwlHJw+jB4+s7NzQX8bIfDQX6jwdLb2/upTCZ7kzWcZouTHSUnZHd2tv2IvdrZ4vC4uuv09va2eXx8XCMIgNVqxXPsOW/fZWdnB6TTZrNp8egJAgByyKey/f19LeTD7+IFSCwQgINH47+rrKx8Z2lpyRkZGSkYwCM+lBwcHHwLxtfB1ME+hN+ohM4IsMa/B8YzPuUDwQSwu7urAePrZ2dnGd73AdJTCGK1n2traxvBeP8ysmAZAQhHXlCpVK/Ex8dfKUCgaSkO8xMKCgpGJycnb3uDCBUnvi6Xy4cA4lZcXFxIAmAJA4iRqamp12NjY0+TsJDaB0CeAIjB6enpmujo6P8PE0NtJ8Y5CEDcnZiYUOJQngpBACzS/Pz8u1lZWfSVr0I7OzufrK6uqgMZCUjG3qauEgDCgy+qqqq+woftsFGJIGf40g+dD+fn51XnzolJCCQtb3meP21ubn7GPcXE89lkMql9POFab21tTYVMDwkCMDMzo+Q+fXR0VI1DYW/5tdFoVD3G+AdtbW2uY62ioiJhAKqrq1/lGo9PNy8S/P8HgPjwEuNvuvueO6knDTA2NvbxZcY/BmKtvb39JrefC6Cnp4c4AMQyT3Z3d5f6cw9+3aPT6T7AlkNEalKr1Tc8+ygUCiSC7B7BMkYUgKZpnIQjqVTqeo3pYxjtGglY65+H+ib40b949Lj/v4iJiUH/CTAAFI2ZNCJ5irUAAAAASUVORK5CYII=";
  private static final String ANCHOR_OUT_PNG = "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABEZJREFUeNrUml9IU1Ecx8+2uwnCrBlaGD2YEKiVla2ypAj8X+l8KYpkLxUFoT0VBT1YUYYP6ktQCGUQgQr+w0o3sgdDEv+AaBH9odicEq4XY25u7vY9dhe3m9N5d+8Z/uDHvRzPn+/nnN/5d6eG5/mNhJCjcAPcD18QngHhPSDxBVE+cfo/aXa7/afL5eKJipaSkkI4QfwzuBZOGwwKQoKS90jTqOvm5uZqrFbrYzUB8vPzFwEMgnhqGtq44LLN4/F8bmxsfEdUNo1GswjgF3peo0SlED9hsVhKbTbbV8LAtELMBhUSP1ZeXn6clXgxwEK0FSHmqfgTvb293whD45QAEMQfh3gHYWxa0eohy2ZmZt4i5o/19PQwFx8CmI9mBLq6umrQ804SI4t6BCoqKh5UVVWZYwVAsBMfhrv56GwKEPtYay8oKFgEyIH/4KO36crKyoOxADDTxnll7AcgDrEG2A2f5JUzCpHLEmAn3MEraxTiCCuAdPj3ZcR4ZEK4MbH3qw2w7FFidna2t6mpiU7M1zLqT8QSu43FMroV/vm/bvd47Dhvm2ge9OQGJL1ZTfc7nc77WVlZOhYhtAX+USLeVlhYaBJnXg0ExN/LyMhgNolT4B9CjeNg9hLiE5YqAAgTsthWEp+ens50Gd0If08b93q9r8KJF0GsR1Z7GPG3WfS8FCCBzgGfz/e6qKgoIZKCWCLXS0dicnKyOjMzk/1Roq+vj+AsfyA7OzthNYUBYYTuF/BALMT/BcDlW3YFubm58Qi5vampqTE5iFIATq/Xy66gv7/fg8eQ3PJ5eXmbdTrduqGhofdut1vOHZwQbFQx6b2GhoZMhN8n+K/h4eHypKSkiMvGxcXRsN9XXV29KSYA9fX1GRD+RbQGeAFxMhIIKr6zs/M0yvjh55gDQPx2ifiQ+QBxKjk5eSXxZwTx1C4xBYB4evL9tsw+6B0ZGVkSwmAwkI6ODip+XpT/MjOAurq6HSucev+OBCAqxBCCeKtEPLUrqgPQxtHzeyIUH7L50dHRs4mJiYt1tLe3W0VhI7arqgMUFxfHSw+LEZpvcHDwZHd39+kw4qnd4NQOnfHxcf/ExMQAdurV3g0MZrP5ufDROdyHZ71WbQCHw+HHjnkRIE9lfrda7qs5p2UxgV0ulxeXo3OAeKJw1TotqyV0enqajsR5hSEMzACoTU1NBXD4oxCNClXJMQUQwolCXMDEfqRAdXrmAAIETyf22NjYQ/Ln5621MwJiCIvFcjEQCAysuREI7dC1tbVVuA/simYEuFiJb2lpuVZaWlqz5iYxvQE2NzcrIZ59CHEYcPT89bKyshql+oMZAGKdtLa23oT4u0r2CRMAk8mkb2truwPxt5SeTpzf71cdIC0tzVhSUpKP1++hARFcu8RzqbSwBzoN1mOCXVFVgGAwSHJycuKMRmM8+fcfSqQg0jQuzN90Qj3O3wIMAN8Np0JgnxtnAAAAAElFTkSuQmCC";
  static final int TIME_TO_UPDATE_SEEK_JS = 500;
  private int duration;
  InlineParams inlineParams;
  MediaController mediaController;
  WeakReference<MMLayout> mmLayoutRef;
  TransparentFix transFix;
  TransparentHandler transparentHandler = new TransparentHandler(this);
  Handler videoHandler;
  
  public InlineVideoView(MMLayout paramMMLayout)
  {
    super(paramMMLayout.getContext());
    setId(8832429);
    setFocusable(true);
    MMAdImplController.destroyOtherInlineVideo(paramMMLayout.getContext());
    this.mmLayoutRef = new WeakReference(paramMMLayout);
  }
  
  private MediaPlayer.OnCompletionListener createOnCompletionListener()
  {
    return new VideoCompletionListener(this);
  }
  
  private MediaPlayer.OnErrorListener createOnErrorListener()
  {
    return new VideoErrorListener(this);
  }
  
  private MediaPlayer.OnPreparedListener createOnPreparedListener()
  {
    return new VideoPreparedListener(this);
  }
  
  private View.OnTouchListener createOnTouchListener()
  {
    return new VideoTouchListener(this);
  }
  
  private Handler createVideoHandler()
  {
    return new VideoHandler(this);
  }
  
  private void downloadCacheVideo()
  {
    Utils.ThreadUtils.execute(new DownloadRunnable(this));
  }
  
  private Uri getVideoUri()
  {
    if ((hasCachedVideo()) && (!this.inlineParams.isPlayingStreaming))
    {
      this.inlineParams.isPlayingStreaming = false;
      return VideoAd.getVideoUri(getContext(), this.inlineParams.cachedVideoID);
    }
    if (!TextUtils.isEmpty(this.inlineParams.streamVideoURI))
    {
      this.inlineParams.isPlayingStreaming = true;
      return Uri.parse(this.inlineParams.streamVideoURI);
    }
    return null;
  }
  
  private boolean hasCachedVideo()
  {
    return (!TextUtils.isEmpty(this.inlineParams.cachedVideoID)) && (VideoAd.hasVideoFile(getContext(), this.inlineParams.cachedVideoID));
  }
  
  private void initInternalInlineVideo()
  {
    this.videoHandler = createVideoHandler();
    setVideoURI(getVideoUri());
    setBackgroundColor(-16777216);
    setClickable(true);
    setOnErrorListener(createOnErrorListener());
    setOnCompletionListener(createOnCompletionListener());
    setOnPreparedListener(createOnPreparedListener());
    setOnTouchListener(createOnTouchListener());
    if (this.inlineParams.autoPlay)
    {
      seekTo(this.inlineParams.currentPosition);
      startInternal();
      if ((this.videoHandler != null) && (!this.videoHandler.hasMessages(2))) {
        this.videoHandler.sendMessageDelayed(Message.obtain(this.videoHandler, 2), 500L);
      }
    }
    if (this.inlineParams.showControls)
    {
      this.mediaController = new MediaController(this);
      setMediaController(this.mediaController);
      this.mediaController.show();
    }
    MMSDK.Log.e("Finished inserting inlineVideo player");
  }
  
  private void makeTransparent()
  {
    if (!this.transparentHandler.hasMessages(4)) {
      this.transparentHandler.sendEmptyMessage(4);
    }
  }
  
  private void removeFromParent()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this);
    }
  }
  
  private void removeKeyboardFocusViewJira1642()
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    requestFocus();
  }
  
  private void resumeInternal(boolean paramBoolean)
  {
    if (!this.inlineParams.isCompleted)
    {
      seekTo(this.inlineParams.currentPosition);
      if ((paramBoolean) || (this.inlineParams.autoPlay))
      {
        startInternal();
        if ((this.videoHandler != null) && (!this.videoHandler.hasMessages(2))) {
          this.videoHandler.sendMessageDelayed(Message.obtain(this.videoHandler, 2), 500L);
        }
      }
    }
  }
  
  private void setInlineVideoParams(InlineParams paramInlineParams)
  {
    this.inlineParams = paramInlineParams;
  }
  
  boolean adjustVideo(InlineParams paramInlineParams)
  {
    try
    {
      setAdjustVideoParams(paramInlineParams);
      MMSDK.Log.e("Called initInlineVideo inside reposition section code");
      boolean bool = isPlaying();
      stopPlayback();
      paramInlineParams = (MMLayout)this.mmLayoutRef.get();
      if (paramInlineParams != null) {
        paramInlineParams.addInlineVideo();
      }
      resumeInternal(bool);
      return true;
    }
    finally {}
  }
  
  void downloadVideo()
  {
    VideoAd.downloadVideoFile(getContext(), this.inlineParams.cachedVideoURI, this.inlineParams.cachedVideoID);
  }
  
  public RelativeLayout.LayoutParams getCustomLayoutParams()
  {
    if (this.inlineParams.goingFullScreen) {
      return new RelativeLayout.LayoutParams(-1, -1);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.inlineParams.scaleFactor * this.inlineParams.width), (int)(this.inlineParams.scaleFactor * this.inlineParams.height));
    localLayoutParams.topMargin = ((int)(this.inlineParams.scaleFactor * this.inlineParams.y));
    localLayoutParams.leftMargin = ((int)(this.inlineParams.scaleFactor * this.inlineParams.x));
    MMSDK.Log.d("lp height = " + localLayoutParams.height);
    return localLayoutParams;
  }
  
  String getGsonState()
  {
    return new Gson().toJson(this.inlineParams);
  }
  
  void handleTransparentMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        if ((isPlaying()) && (getCurrentPosition() > 0))
        {
          this.transparentHandler.sendEmptyMessageDelayed(5, 100L);
          return;
        }
        this.transparentHandler.sendEmptyMessageDelayed(4, 50L);
        return;
      } while ((!isPlaying()) || (getCurrentPosition() <= 0));
      setBackgroundColor(0);
    } while ((this.mmLayoutRef == null) || (this.mmLayoutRef.get() == null));
    ((MMLayout)this.mmLayoutRef.get()).removeBlackView();
  }
  
  /* Error */
  void initInlineVideo(InlineParams paramInlineParams)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 416	com/millennialmedia/android/InlineVideoView:setInlineVideoParams	(Lcom/millennialmedia/android/InlineVideoView$InlineParams;)V
    //   7: aload_0
    //   8: getfield 133	com/millennialmedia/android/InlineVideoView:inlineParams	Lcom/millennialmedia/android/InlineVideoView$InlineParams;
    //   11: getfield 328	com/millennialmedia/android/InlineVideoView$InlineParams:cachedVideoURI	Ljava/lang/String;
    //   14: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +7 -> 24
    //   20: aload_0
    //   21: invokespecial 418	com/millennialmedia/android/InlineVideoView:downloadCacheVideo	()V
    //   24: aload_0
    //   25: invokevirtual 421	com/millennialmedia/android/InlineVideoView:isValid	()Z
    //   28: ifeq +10 -> 38
    //   31: aload_0
    //   32: invokespecial 423	com/millennialmedia/android/InlineVideoView:initInternalInlineVideo	()V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: ldc_w 425
    //   41: invokestatic 258	com/millennialmedia/android/MMSDK$Log:e	(Ljava/lang/String;)V
    //   44: goto -9 -> 35
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	InlineVideoView
    //   0	52	1	paramInlineParams	InlineParams
    // Exception table:
    //   from	to	target	type
    //   2	24	47	finally
    //   24	35	47	finally
    //   38	44	47	finally
  }
  
  boolean isPlayingStreaming()
  {
    return (this.inlineParams != null) && (this.inlineParams.isPlayingStreaming);
  }
  
  boolean isValid()
  {
    return (!TextUtils.isEmpty(this.inlineParams.streamVideoURI)) || (hasCachedVideo());
  }
  
  void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if ((this.videoHandler != null) && (this.videoHandler.hasMessages(2))) {
      this.videoHandler.removeMessages(2);
    }
    this.inlineParams.isCompleted = true;
    this.inlineParams.currentPosition = this.duration;
    if (this.inlineParams.currentPosition == -1) {
      this.inlineParams.currentPosition = 0;
    }
    updateVideoSeekTimeFinal();
  }
  
  boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((this.videoHandler != null) && (this.videoHandler.hasMessages(2))) {
      this.videoHandler.removeMessages(2);
    }
    paramMediaPlayer = (MMLayout)this.mmLayoutRef.get();
    if (paramMediaPlayer == null)
    {
      MMSDK.Log.w("MMLayout weak reference broken");
      return false;
    }
    paramMediaPlayer.loadUrl("javascript:MMJS.setError(" + String.format("Error while playing, %d - %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) + ");");
    return true;
  }
  
  void onMediaControllerClick(View paramView)
  {
    paramView = (MMLayout)this.mmLayoutRef.get();
    if (paramView != null)
    {
      setBackgroundColor(-16777216);
      if (isPlaying()) {
        this.inlineParams.currentPosition = getCurrentPosition();
      }
      if (!this.inlineParams.goingFullScreen) {
        break label105;
      }
      this.inlineParams.goingFullScreen = false;
      if (this.inlineParams.originalOrientation != 1) {
        break label86;
      }
      paramView = (Activity)getContext();
      if (paramView != null) {
        paramView.setRequestedOrientation(1);
      }
    }
    label86:
    label105:
    do
    {
      return;
      bool = isPlaying();
      stopPlayback();
      paramView.repositionVideoLayout();
      resumeInternal(bool);
      return;
      this.inlineParams.originalOrientation = getContext().getResources().getConfiguration().orientation;
      this.inlineParams.goingFullScreen = true;
      if (this.inlineParams.originalOrientation == 2) {
        break;
      }
      paramView = (Activity)getContext();
    } while (paramView == null);
    paramView.setRequestedOrientation(0);
    return;
    boolean bool = isPlaying();
    stopPlayback();
    paramView.fullScreenVideoLayout();
    resumeInternal(bool);
  }
  
  void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.inlineParams.autoPlay) {
      makeTransparent();
    }
    seekTo(this.inlineParams.currentPosition);
    if ((this.inlineParams.autoPlay) || (!this.inlineParams.isInitialPlayBack)) {
      getHeight();
    }
    for (;;)
    {
      this.duration = getDuration();
      return;
      this.inlineParams.isInitialPlayBack = false;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof AdViewOverlayView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (AdViewOverlayView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.inlineParams.inflateFromGson(paramParcelable.gson);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AdViewOverlayView.SavedState localSavedState = new AdViewOverlayView.SavedState(super.onSaveInstanceState());
    if (isPlaying()) {
      this.inlineParams.currentPosition = getCurrentPosition();
    }
    localSavedState.gson = getGsonState();
    return localSavedState;
  }
  
  boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramView = (MMLayout)this.mmLayoutRef.get();
      if (paramView == null)
      {
        MMSDK.Log.w("MMLayout weak reference broken");
        return false;
      }
      if (!TextUtils.isEmpty(this.inlineParams.touchCallBack)) {
        paramView.loadUrl(String.format("javascript:" + this.inlineParams.touchCallBack + "(%f,%f)", new Object[] { Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()) }));
      }
      if ((this.inlineParams.showControls) && (this.mediaController != null) && (!this.mediaController.isShowing()))
      {
        this.mediaController.show();
        return true;
      }
    }
    return true;
  }
  
  void pauseVideo()
  {
    if ((this.videoHandler != null) && (this.videoHandler.hasMessages(2))) {
      this.videoHandler.removeMessages(2);
    }
    if (isPlaying())
    {
      this.inlineParams.currentPosition = getCurrentPosition();
      pause();
    }
  }
  
  void playVideo()
  {
    if (!isPlaying())
    {
      if ((!this.inlineParams.isStopped) || (getVideoUri() == null)) {
        break label95;
      }
      this.inlineParams.isStopped = false;
      setVideoURI(getVideoUri());
      seekTo(0);
    }
    for (;;)
    {
      this.inlineParams.isCompleted = false;
      startInternal();
      if ((this.videoHandler != null) && (!this.videoHandler.hasMessages(2))) {
        this.videoHandler.sendMessageDelayed(Message.obtain(this.videoHandler, 2), 500L);
      }
      return;
      label95:
      if (this.inlineParams.isCompleted) {
        seekTo(0);
      }
    }
  }
  
  void removeVideo()
  {
    if ((this.videoHandler != null) && (this.videoHandler.hasMessages(2))) {
      this.videoHandler.removeMessages(2);
    }
    if (isPlaying()) {
      stopPlayback();
    }
    setOnCompletionListener(null);
    setOnErrorListener(null);
    setOnPreparedListener(null);
    setOnTouchListener(null);
    removeFromParent();
  }
  
  void resumeVideo()
  {
    if ((!isPlaying()) && (!this.inlineParams.isCompleted))
    {
      startInternal();
      if ((this.videoHandler != null) && (!this.videoHandler.hasMessages(2))) {
        this.videoHandler.sendMessageDelayed(Message.obtain(this.videoHandler, 2), 500L);
      }
    }
  }
  
  void setAdjustVideoParams(InlineParams paramInlineParams)
  {
    this.inlineParams.x = paramInlineParams.x;
    this.inlineParams.y = paramInlineParams.y;
    this.inlineParams.width = paramInlineParams.width;
    this.inlineParams.height = paramInlineParams.height;
  }
  
  void setVideoSource(String paramString)
  {
    if (isPlaying()) {
      stopPlayback();
    }
    this.inlineParams.currentPosition = 0;
    setBackgroundColor(-16777216);
    setVideoURI(Uri.parse(paramString));
    startInternal();
  }
  
  public void start()
  {
    makeTransparent();
    removeKeyboardFocusViewJira1642();
    super.start();
  }
  
  public void startInternal()
  {
    if (((PowerManager)getContext().getSystemService("power")).isScreenOn()) {
      start();
    }
  }
  
  public void stopPlayback()
  {
    if ((this.videoHandler != null) && (this.videoHandler.hasMessages(2))) {
      this.videoHandler.removeMessages(2);
    }
    if (isPlaying()) {
      this.inlineParams.currentPosition = 0;
    }
    super.stopPlayback();
  }
  
  void stopVideo()
  {
    if ((this.videoHandler != null) && (this.videoHandler.hasMessages(2))) {
      this.videoHandler.removeMessages(2);
    }
    if (isPlaying())
    {
      this.inlineParams.isStopped = true;
      this.inlineParams.currentPosition = 0;
      if ((this.mmLayoutRef != null) && (this.mmLayoutRef.get() != null)) {
        ((MMLayout)this.mmLayoutRef.get()).addBlackView();
      }
      stopPlayback();
    }
  }
  
  public String toString()
  {
    return this.inlineParams.toString();
  }
  
  void updateVideoSeekTime()
  {
    int i = getCurrentPosition();
    if (i >= 0)
    {
      MMSDK.Log.d("Time is " + i);
      updateVideoSeekTime(Math.floor(i / 1000.0F));
    }
  }
  
  void updateVideoSeekTime(double paramDouble)
  {
    MMLayout localMMLayout = (MMLayout)this.mmLayoutRef.get();
    if (localMMLayout == null) {
      MMSDK.Log.w("MMLayout weak reference broken");
    }
    localMMLayout.loadUrl("javascript:MMJS.inlineVideo.updateVideoSeekTime(" + paramDouble + ");");
  }
  
  void updateVideoSeekTimeFinal()
  {
    if (this.duration > 0)
    {
      MMSDK.Log.d("Time is " + this.duration);
      updateVideoSeekTime(Math.ceil(this.duration / 1000.0F));
    }
  }
  
  private static class DownloadRunnable
    implements Runnable
  {
    private WeakReference<InlineVideoView> inlineVideoRef;
    
    public DownloadRunnable(InlineVideoView paramInlineVideoView)
    {
      this.inlineVideoRef = new WeakReference(paramInlineVideoView);
    }
    
    public void run()
    {
      InlineVideoView localInlineVideoView = (InlineVideoView)this.inlineVideoRef.get();
      if (localInlineVideoView != null) {
        localInlineVideoView.downloadVideo();
      }
    }
  }
  
  static class InlineParams
  {
    boolean autoPlay;
    int bodyHeight;
    int bodyWidth;
    String cachedVideoID;
    String cachedVideoURI;
    int currentPosition;
    boolean goingFullScreen;
    int height;
    boolean isCompleted;
    boolean isInitialPlayBack = true;
    boolean isPlayingStreaming;
    boolean isStopped;
    int originalOrientation;
    float scaleFactor;
    boolean showControls;
    String streamVideoURI;
    String touchCallBack;
    int width;
    int x;
    int y;
    
    InlineParams(HashMap<String, String> paramHashMap, Context paramContext)
    {
      if (paramHashMap.get("x") != null) {
        this.x = ((int)Float.parseFloat((String)paramHashMap.get("x")));
      }
      if (paramHashMap.get("y") != null) {
        this.y = ((int)Float.parseFloat((String)paramHashMap.get("y")));
      }
      if (paramHashMap.get("width") != null) {
        this.width = ((int)Float.parseFloat((String)paramHashMap.get("width")));
      }
      if (paramHashMap.get("height") != null) {
        this.height = ((int)Float.parseFloat((String)paramHashMap.get("height")));
      }
      this.streamVideoURI = ((String)paramHashMap.get("streamVideoURI"));
      this.cachedVideoURI = ((String)paramHashMap.get("cachedVideoURI"));
      this.cachedVideoID = ((String)paramHashMap.get("cachedVideoID"));
      if (paramHashMap.get("autoPlay") != null) {
        this.autoPlay = Boolean.parseBoolean((String)paramHashMap.get("autoPlay"));
      }
      if (paramHashMap.get("showControls") != null) {
        this.showControls = Boolean.parseBoolean((String)paramHashMap.get("showControls"));
      }
      if (paramHashMap.get("bodyWidth") != null) {
        this.bodyWidth = ((int)Float.parseFloat((String)paramHashMap.get("bodyWidth")));
      }
      if (paramHashMap.get("bodyHeight") != null) {
        this.bodyHeight = ((int)Float.parseFloat((String)paramHashMap.get("bodyHeight")));
      }
      this.touchCallBack = ((String)paramHashMap.get("touchCallback"));
      this.scaleFactor = paramContext.getResources().getDisplayMetrics().density;
    }
    
    static InlineParams getInlineParams(String paramString)
    {
      return (InlineParams)new Gson().fromJson(paramString, InlineParams.class);
    }
    
    void inflateFromGson(String paramString)
    {
      InlineParams localInlineParams = (InlineParams)new Gson().fromJson(paramString, InlineParams.class);
      this.x = localInlineParams.x;
      this.y = localInlineParams.y;
      this.bodyWidth = localInlineParams.bodyWidth;
      this.bodyHeight = localInlineParams.bodyHeight;
      this.width = localInlineParams.width;
      this.height = localInlineParams.height;
      this.currentPosition = localInlineParams.currentPosition;
      this.streamVideoURI = localInlineParams.streamVideoURI;
      this.cachedVideoURI = localInlineParams.cachedVideoURI;
      this.cachedVideoID = localInlineParams.cachedVideoID;
      this.touchCallBack = localInlineParams.touchCallBack;
      this.autoPlay = localInlineParams.autoPlay;
      this.showControls = localInlineParams.showControls;
      this.isInitialPlayBack = localInlineParams.isInitialPlayBack;
      this.scaleFactor = localInlineParams.scaleFactor;
      this.goingFullScreen = localInlineParams.goingFullScreen;
      this.originalOrientation = localInlineParams.originalOrientation;
      this.isCompleted = localInlineParams.isCompleted;
      MMSDK.Log.d("gson*****" + paramString);
      MMSDK.Log.d("PARAMS*****" + localInlineParams);
    }
    
    public String toString()
    {
      return String.format("%s id, %d x, %d y, %d bWidth, %d bHeight, %d pos, %b autoPlay", new Object[] { this.cachedVideoID, Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.bodyWidth), Integer.valueOf(this.bodyHeight), Integer.valueOf(this.currentPosition), Boolean.valueOf(this.autoPlay) });
    }
  }
  
  private static class MediaController
    extends MediaController
  {
    BitmapDrawable inDrawable;
    private WeakReference<InlineVideoView> inlineVideoRef;
    BitmapDrawable outDrawable;
    
    public MediaController(InlineVideoView paramInlineVideoView)
    {
      super();
      this.inlineVideoRef = new WeakReference(paramInlineVideoView);
    }
    
    public void setAnchorView(View paramView)
    {
      super.setAnchorView(paramView);
      paramView = new Button(getContext());
      if (this.inDrawable == null) {}
      try
      {
        this.inDrawable = new BitmapDrawable(new ByteArrayInputStream(Base64.decode("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABOpJREFUeNrUmmtIY0cUgCfJ3VBXUXxR0dp2Ya0aBSFi6yOtFPGF1d1WavrAXy1YwVcLLaQpttsH+lcbirYq0a3Ptd0WpKi1P1SMaAitJNptalcQIwV/iI+o2ST39kx6I9cY3STcuSYHhjuTzD33fJk5M+fciWh9fR0tLCwgrhwfH6OcnBwkl8ur9vb2DIODg5aIiAjkq1itViQWi1FYWBgiKYmJiQhptdpzX6SlpSGz2fwRwzDHR0dH83V1dYn+KK6oqLjR19enQISluLgYof7+/jMfZmRkIIvFcoc5K783NTU95YvSsrKyFLvd/s/a2pqRNEBJSclZAJlMhra2tjyNP4Vobm5OukxhaWlpysnJyQPceXl5WS8SicgDDAwMuBrp6enY+M+Zy2UFIJ72pqy8vDwFfOcvd0ebzWYoLCwkD9DR0YFSU1Ox8W2Mb7IKEM+4lWBnHRoaSnM6nX97jhhAkQfQ6/XXNjY27jD+iamhoeFZiqLQyMhIOrQfeuljhCklJg4AD7rFBCA0Tf+h0+luQ9V80UgBAEUaQAzrvB7qk/7eDA6alZeXdx+qKRd0wb++hPRKJIZNaru+vv4NqP/Gs25sPEUcIDw8HHV1de2BY1bzDCFmC1kA91rd2dmJIV6D6nRIjQC3ARD7LMQvPOmWCArAQlhbWlqUPEBIrgQAC2xuh42NjUoI5O5BkwmpEXCLRqM5XFlZ+Qaq9qB2Yq9jL5HgHRaW+bzvoSkNZic+9wA2tnmxpqbmB2jGB7sPUB67KzZeAcb/CM24kHBi9z6Ar8PDwy8plcr7PBgvnBND9uSa82D8y2D8TzwZLxgAhRN4yF+zwfhfeX7gdSjXiANgp11cXDyCjOxr1ick7MojYQ2g2Cu3fvpZcnKyOCEhQcL5xd1XK+QLu8QB2GDuTyjvB6IgKSkJZWZmejouLrTBYLAJvoz6KxaLxVVYcbLljOTm5oqioqLwlHJw+jB4+s7NzQX8bIfDQX6jwdLb2/upTCZ7kzWcZouTHSUnZHd2tv2IvdrZ4vC4uuv09va2eXx8XCMIgNVqxXPsOW/fZWdnB6TTZrNp8egJAgByyKey/f19LeTD7+IFSCwQgINH47+rrKx8Z2lpyRkZGSkYwCM+lBwcHHwLxtfB1ME+hN+ohM4IsMa/B8YzPuUDwQSwu7urAePrZ2dnGd73AdJTCGK1n2traxvBeP8ysmAZAQhHXlCpVK/Ex8dfKUCgaSkO8xMKCgpGJycnb3uDCBUnvi6Xy4cA4lZcXFxIAmAJA4iRqamp12NjY0+TsJDaB0CeAIjB6enpmujo6P8PE0NtJ8Y5CEDcnZiYUOJQngpBACzS/Pz8u1lZWfSVr0I7OzufrK6uqgMZCUjG3qauEgDCgy+qqqq+woftsFGJIGf40g+dD+fn51XnzolJCCQtb3meP21ubn7GPcXE89lkMql9POFab21tTYVMDwkCMDMzo+Q+fXR0VI1DYW/5tdFoVD3G+AdtbW2uY62ioiJhAKqrq1/lGo9PNy8S/P8HgPjwEuNvuvueO6knDTA2NvbxZcY/BmKtvb39JrefC6Cnp4c4AMQyT3Z3d5f6cw9+3aPT6T7AlkNEalKr1Tc8+ygUCiSC7B7BMkYUgKZpnIQjqVTqeo3pYxjtGglY65+H+ib40b949Lj/v4iJiUH/CTAAFI2ZNCJ5irUAAAAASUVORK5CYII=")));
        if (this.outDrawable != null) {}
      }
      catch (Exception localException1)
      {
        try
        {
          this.outDrawable = new BitmapDrawable(new ByteArrayInputStream(Base64.decode("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABEZJREFUeNrUml9IU1Ecx8+2uwnCrBlaGD2YEKiVla2ypAj8X+l8KYpkLxUFoT0VBT1YUYYP6ktQCGUQgQr+w0o3sgdDEv+AaBH9odicEq4XY25u7vY9dhe3m9N5d+8Z/uDHvRzPn+/nnN/5d6eG5/mNhJCjcAPcD18QngHhPSDxBVE+cfo/aXa7/afL5eKJipaSkkI4QfwzuBZOGwwKQoKS90jTqOvm5uZqrFbrYzUB8vPzFwEMgnhqGtq44LLN4/F8bmxsfEdUNo1GswjgF3peo0SlED9hsVhKbTbbV8LAtELMBhUSP1ZeXn6clXgxwEK0FSHmqfgTvb293whD45QAEMQfh3gHYWxa0eohy2ZmZt4i5o/19PQwFx8CmI9mBLq6umrQ804SI4t6BCoqKh5UVVWZYwVAsBMfhrv56GwKEPtYay8oKFgEyIH/4KO36crKyoOxADDTxnll7AcgDrEG2A2f5JUzCpHLEmAn3MEraxTiCCuAdPj3ZcR4ZEK4MbH3qw2w7FFidna2t6mpiU7M1zLqT8QSu43FMroV/vm/bvd47Dhvm2ge9OQGJL1ZTfc7nc77WVlZOhYhtAX+USLeVlhYaBJnXg0ExN/LyMhgNolT4B9CjeNg9hLiE5YqAAgTsthWEp+ens50Gd0If08b93q9r8KJF0GsR1Z7GPG3WfS8FCCBzgGfz/e6qKgoIZKCWCLXS0dicnKyOjMzk/1Roq+vj+AsfyA7OzthNYUBYYTuF/BALMT/BcDlW3YFubm58Qi5vampqTE5iFIATq/Xy66gv7/fg8eQ3PJ5eXmbdTrduqGhofdut1vOHZwQbFQx6b2GhoZMhN8n+K/h4eHypKSkiMvGxcXRsN9XXV29KSYA9fX1GRD+RbQGeAFxMhIIKr6zs/M0yvjh55gDQPx2ifiQ+QBxKjk5eSXxZwTx1C4xBYB4evL9tsw+6B0ZGVkSwmAwkI6ODip+XpT/MjOAurq6HSucev+OBCAqxBCCeKtEPLUrqgPQxtHzeyIUH7L50dHRs4mJiYt1tLe3W0VhI7arqgMUFxfHSw+LEZpvcHDwZHd39+kw4qnd4NQOnfHxcf/ExMQAdurV3g0MZrP5ufDROdyHZ71WbQCHw+HHjnkRIE9lfrda7qs5p2UxgV0ulxeXo3OAeKJw1TotqyV0enqajsR5hSEMzACoTU1NBXD4oxCNClXJMQUQwolCXMDEfqRAdXrmAAIETyf22NjYQ/Ln5621MwJiCIvFcjEQCAysuREI7dC1tbVVuA/simYEuFiJb2lpuVZaWlqz5iYxvQE2NzcrIZ59CHEYcPT89bKyshql+oMZAGKdtLa23oT4u0r2CRMAk8mkb2truwPxt5SeTpzf71cdIC0tzVhSUpKP1++hARFcu8RzqbSwBzoN1mOCXVFVgGAwSHJycuKMRmM8+fcfSqQg0jQuzN90Qj3O3wIMAN8Np0JgnxtnAAAAAElFTkSuQmCC")));
          Object localObject = (InlineVideoView)this.inlineVideoRef.get();
          if (localObject != null)
          {
            if (((InlineVideoView)localObject).inlineParams.goingFullScreen)
            {
              paramView.setBackgroundDrawable(this.inDrawable);
              paramView.setOnClickListener(new MediaClickListener((InlineVideoView)localObject));
            }
          }
          else
          {
            localObject = new FrameLayout.LayoutParams(-2, -2, 5);
            ((FrameLayout.LayoutParams)localObject).setMargins(0, 20, 10, 0);
            addView(paramView, (ViewGroup.LayoutParams)localObject);
            return;
            localException1 = localException1;
            MMSDK.Log.e("Exception image:" + localException1.getMessage());
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            MMSDK.Log.e("Exception image:" + localException2.getMessage());
            continue;
            paramView.setBackgroundDrawable(this.outDrawable);
          }
        }
      }
    }
    
    static final class MediaClickListener
      implements View.OnClickListener
    {
      private WeakReference<InlineVideoView> inlineVideoRef;
      
      public MediaClickListener(InlineVideoView paramInlineVideoView)
      {
        this.inlineVideoRef = new WeakReference(paramInlineVideoView);
      }
      
      public void onClick(View paramView)
      {
        InlineVideoView localInlineVideoView = (InlineVideoView)this.inlineVideoRef.get();
        if (localInlineVideoView != null) {
          localInlineVideoView.onMediaControllerClick(paramView);
        }
      }
    }
  }
  
  static abstract interface TransparentFix
  {
    public abstract void removeBlackView();
  }
  
  private static class TransparentHandler
    extends Handler
  {
    private WeakReference<InlineVideoView> inlineVideoRef;
    
    public TransparentHandler(InlineVideoView paramInlineVideoView)
    {
      this.inlineVideoRef = new WeakReference(paramInlineVideoView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      InlineVideoView localInlineVideoView = (InlineVideoView)this.inlineVideoRef.get();
      if (localInlineVideoView != null) {
        localInlineVideoView.handleTransparentMessage(paramMessage);
      }
    }
  }
  
  private static class VideoCompletionListener
    implements MediaPlayer.OnCompletionListener
  {
    private WeakReference<InlineVideoView> inlineVideoRef;
    
    public VideoCompletionListener(InlineVideoView paramInlineVideoView)
    {
      this.inlineVideoRef = new WeakReference(paramInlineVideoView);
    }
    
    public void onCompletion(MediaPlayer paramMediaPlayer)
    {
      InlineVideoView localInlineVideoView = (InlineVideoView)this.inlineVideoRef.get();
      if (localInlineVideoView != null) {
        localInlineVideoView.onCompletion(paramMediaPlayer);
      }
    }
  }
  
  private static class VideoErrorListener
    implements MediaPlayer.OnErrorListener
  {
    private WeakReference<InlineVideoView> inlineVideoRef;
    
    public VideoErrorListener(InlineVideoView paramInlineVideoView)
    {
      this.inlineVideoRef = new WeakReference(paramInlineVideoView);
    }
    
    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
    {
      InlineVideoView localInlineVideoView = (InlineVideoView)this.inlineVideoRef.get();
      if (localInlineVideoView != null) {
        localInlineVideoView.onError(paramMediaPlayer, paramInt1, paramInt2);
      }
      return true;
    }
  }
  
  private static class VideoHandler
    extends Handler
  {
    private WeakReference<InlineVideoView> inlineVideoRef;
    
    public VideoHandler(InlineVideoView paramInlineVideoView)
    {
      this.inlineVideoRef = new WeakReference(paramInlineVideoView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        paramMessage = (InlineVideoView)this.inlineVideoRef.get();
      } while (paramMessage == null);
      if (paramMessage.isPlaying()) {
        paramMessage.updateVideoSeekTime();
      }
      paramMessage.videoHandler.sendMessageDelayed(Message.obtain(paramMessage.videoHandler, 2), 500L);
    }
  }
  
  private static class VideoPreparedListener
    implements MediaPlayer.OnPreparedListener
  {
    private WeakReference<InlineVideoView> inlineVideoRef;
    
    public VideoPreparedListener(InlineVideoView paramInlineVideoView)
    {
      this.inlineVideoRef = new WeakReference(paramInlineVideoView);
    }
    
    public void onPrepared(MediaPlayer paramMediaPlayer)
    {
      InlineVideoView localInlineVideoView = (InlineVideoView)this.inlineVideoRef.get();
      if (localInlineVideoView != null) {
        localInlineVideoView.onPrepared(paramMediaPlayer);
      }
    }
  }
  
  private static class VideoTouchListener
    implements View.OnTouchListener
  {
    private WeakReference<InlineVideoView> inlineVideoRef;
    
    public VideoTouchListener(InlineVideoView paramInlineVideoView)
    {
      this.inlineVideoRef = new WeakReference(paramInlineVideoView);
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      InlineVideoView localInlineVideoView = (InlineVideoView)this.inlineVideoRef.get();
      if (localInlineVideoView != null) {
        return localInlineVideoView.onTouch(paramView, paramMotionEvent);
      }
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/InlineVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */