package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

abstract class MMLayout
  extends RelativeLayout
  implements MMAd, InlineVideoView.TransparentFix
{
  static final String BOTTOM_CENTER = "bottom-center";
  static final String BOTTOM_LEFT = "bottom-left";
  static final String BOTTOM_RIGHT = "bottom-right";
  static final String CENTER = "center";
  private static final int CLOSE_AREA_SIZE = 50;
  public static final String KEY_HEIGHT = "height";
  public static final String KEY_WIDTH = "width";
  static final String TOP_CENTER = "top-center";
  static final String TOP_LEFT = "top-left";
  static final String TOP_RIGHT = "top-right";
  private static boolean appInit;
  MMAdImpl adImpl;
  View blackView;
  View closeAreaView;
  private GestureDetector diagnosticDetector;
  String goalId;
  RelativeLayout inlineVideoLayout;
  InlineVideoView inlineVideoView;
  boolean isResizing;
  
  protected MMLayout(Context paramContext)
  {
    super(paramContext);
    initLayout(paramContext);
  }
  
  @Deprecated
  protected MMLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initLayout(paramContext);
  }
  
  private void initInlineVideoTransparentFix()
  {
    if (this.blackView != null)
    {
      localObject = this.blackView.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup)))
      {
        ((ViewGroup)localObject).removeView(this.blackView);
        this.blackView = null;
      }
    }
    this.blackView = new View(getContext());
    this.blackView.setBackgroundColor(-16777216);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.blackView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if ((this.inlineVideoLayout != null) && (this.blackView.getParent() == null)) {
      this.inlineVideoLayout.addView(this.blackView);
    }
  }
  
  private void internalSetCloseArea(String paramString)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.closeAreaView == null)
    {
      this.closeAreaView = new View(getContext());
      float f = getContext().getResources().getDisplayMetrics().density;
      localLayoutParams = new RelativeLayout.LayoutParams((int)(50.0F * f), (int)(50.0F * f));
      if (!"top-right".equals(paramString)) {
        break label94;
      }
      localLayoutParams.addRule(11);
    }
    for (;;)
    {
      this.closeAreaView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          MMLayout.this.closeAreaTouched();
        }
      });
      addView(this.closeAreaView, localLayoutParams);
      return;
      label94:
      if ("top-center".equals(paramString))
      {
        localLayoutParams.addRule(14);
      }
      else if ("bottom-left".equals(paramString))
      {
        localLayoutParams.addRule(12);
      }
      else if ("bottom-center".equals(paramString))
      {
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(14);
      }
      else if ("bottom-right".equals(paramString))
      {
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(11);
      }
      else if ("center".equals(paramString))
      {
        localLayoutParams.addRule(13);
      }
    }
  }
  
  public void addBlackView()
  {
    initInlineVideoTransparentFix();
    if (this.blackView != null) {
      this.blackView.setVisibility(0);
    }
  }
  
  void addInlineVideo()
  {
    if ((this.inlineVideoLayout != null) && (this.inlineVideoLayout.getParent() != null)) {
      ((ViewGroup)this.inlineVideoLayout.getParent()).removeView(this.inlineVideoLayout);
    }
    this.inlineVideoLayout = new RelativeLayout(getContext());
    this.inlineVideoLayout.setId(892934232);
    if (this.inlineVideoView.getParent() != null) {
      ((ViewGroup)this.inlineVideoView.getParent()).removeView(this.inlineVideoView);
    }
    this.inlineVideoLayout.addView(this.inlineVideoView);
    if (this.blackView != null)
    {
      if (this.blackView.getParent() == null) {
        this.inlineVideoLayout.addView(this.blackView);
      }
      this.blackView.bringToFront();
    }
    addView(this.inlineVideoLayout, this.inlineVideoView.getCustomLayoutParams());
  }
  
  boolean adjustVideo(final InlineVideoView.InlineParams paramInlineParams)
  {
    MMSDK.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (MMLayout.this.inlineVideoView != null) {
          MMLayout.this.inlineVideoView.adjustVideo(paramInlineParams);
        }
      }
    });
    return false;
  }
  
  void closeAreaTouched() {}
  
  protected void finalize()
    throws Throwable
  {
    if (getId() == -1)
    {
      this.adImpl.isFinishing = true;
      MMSDK.Log.d("finalize() for " + this.adImpl);
      MMAdImplController.removeAdViewController(this.adImpl);
    }
  }
  
  void fullScreenVideoLayout() {}
  
  public String getApid()
  {
    return this.adImpl.getApid();
  }
  
  public boolean getIgnoresDensityScaling()
  {
    return this.adImpl.getIgnoresDensityScaling();
  }
  
  public RequestListener getListener()
  {
    return this.adImpl.getListener();
  }
  
  public MMRequest getMMRequest()
  {
    return this.adImpl.getMMRequest();
  }
  
  void initInlineVideo(InlineVideoView.InlineParams paramInlineParams)
  {
    if (this.inlineVideoView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.inlineVideoView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.inlineVideoView);
      }
      if (this.inlineVideoView.isPlaying()) {
        this.inlineVideoView.stopPlayback();
      }
      this.inlineVideoView = null;
    }
    this.inlineVideoView = new InlineVideoView(this);
    this.inlineVideoView.initInlineVideo(paramInlineParams);
    paramInlineParams = new RelativeLayout.LayoutParams(-2, -2);
    paramInlineParams.addRule(13, -1);
    this.inlineVideoView.setLayoutParams(paramInlineParams);
    addInlineVideo();
  }
  
  protected final void initLayout(Context paramContext)
  {
    try
    {
      MMSDK.Log.i("Initializing MMLayout.");
      MMSDK.checkPermissions(paramContext);
      MMSDK.checkActivity(paramContext);
      this.diagnosticDetector = new GestureDetector(paramContext.getApplicationContext(), new LayoutGestureListener(this));
      if (!appInit)
      {
        MMSDK.Log.d("********** Millennial Device Id *****************");
        MMSDK.Log.d(MMSDK.getMMdid(paramContext));
        MMSDK.Log.d("Use the above identifier to register this device and receive test ads. Test devices can be registered and administered through your account at http://mmedia.com.");
        MMSDK.Log.d("*************************************************");
        AdCache.cleanCache(paramContext);
        appInit = true;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        MMSDK.Log.e("There was an exception initializing the MMAdView. %s", new Object[] { localException.getMessage() });
        localException.printStackTrace();
      }
    }
  }
  
  boolean isVideoPlayingStreaming()
  {
    return (this.inlineVideoView != null) && (this.inlineVideoView.isPlayingStreaming());
  }
  
  void loadUrl(String paramString)
  {
    if (MMSDK.isConnected(getContext()))
    {
      if (this.adImpl.controller != null) {
        this.adImpl.controller.loadUrl(paramString);
      }
      return;
    }
    MMSDK.Log.e("No network available, can't load overlay.");
  }
  
  void loadWebContent(String paramString1, String paramString2)
  {
    if (MMSDK.isConnected(getContext()))
    {
      if (this.adImpl.controller != null) {
        this.adImpl.controller.loadWebContent(paramString1, paramString2);
      }
      return;
    }
    MMSDK.Log.e("No network available, can't load overlay.");
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode())
    {
      MMSDK.Log.d("onAttachedToWindow for " + this.adImpl);
      if (getId() == -1) {
        MMSDK.Log.w("MMAd missing id from getId(). Performance will be affected for configuration changes.");
      }
      if (!this.isResizing) {
        MMAdImplController.assignAdViewController(this.adImpl);
      }
      if (this.inlineVideoLayout != null) {
        this.inlineVideoLayout.bringToFront();
      }
      if ((this.adImpl != null) && (this.adImpl.controller != null) && (this.adImpl.controller.webView != null)) {
        this.adImpl.controller.webView.enableSendingSize();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    MMSDK.Log.d("onDetachedFromWindow for" + this.adImpl);
    if (!this.isResizing) {
      MMAdImplController.removeAdViewController(this.adImpl);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (Bundle)paramParcelable;
    long l = this.adImpl.internalId;
    this.adImpl.internalId = paramParcelable.getLong("MMAdImplId");
    this.adImpl.linkForExpansionId = paramParcelable.getLong("MMAdImplLinkedId");
    MMSDK.Log.d("onRestoreInstanceState replacing adImpl-" + l + " with " + this.adImpl + " id=" + getId());
    String str = paramParcelable.getString("inlineVideoViewGson");
    if (str != null) {
      initInlineVideo(InlineVideoView.InlineParams.getInlineParams(str));
    }
    super.onRestoreInstanceState(paramParcelable.getParcelable("super"));
  }
  
  protected Parcelable onSaveInstanceState()
  {
    super.onSaveInstanceState();
    MMSDK.Log.d("onSaveInstanceState saving - " + this.adImpl + " id=" + getId());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("super", super.onSaveInstanceState());
    localBundle.putLong("MMAdImplId", this.adImpl.internalId);
    localBundle.putLong("MMAdImplLinkedId", this.adImpl.linkForExpansionId);
    if (this.inlineVideoView != null)
    {
      if (this.inlineVideoView.isPlaying()) {
        this.inlineVideoView.inlineParams.currentPosition = this.inlineVideoView.getCurrentPosition();
      }
      localBundle.putString("inlineVideoViewGson", this.inlineVideoView.getGsonState());
    }
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.diagnosticDetector.onTouchEvent(paramMotionEvent)) || (!isClickable()) || (super.onTouchEvent(paramMotionEvent));
  }
  
  @Deprecated
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      if (this.inlineVideoView != null) {
        this.inlineVideoView.resumeVideo();
      }
      MMSDK.Log.d("Window Focus Changed. For %s, Window in focus?: %b Controllers: %s", new Object[] { this.adImpl, Boolean.valueOf(paramBoolean), MMAdImplController.controllersToString() });
      if ((this.adImpl != null) && (this.adImpl.controller != null) && (this.adImpl.controller.webView != null))
      {
        if (!paramBoolean) {
          break label275;
        }
        this.adImpl.controller.webView.onResumeWebView();
        this.adImpl.controller.webView.setMraidViewableVisible();
      }
    }
    for (;;)
    {
      if ((!paramBoolean) && ((getContext() instanceof Activity)))
      {
        localObject1 = (Activity)getContext();
        if ((localObject1 == null) || ((((Activity)localObject1).isFinishing()) && (this.adImpl != null)))
        {
          this.adImpl.isFinishing = true;
          MMSDK.Log.d("Window Focus Changed.removing " + this.adImpl);
          if ((this.adImpl.controller != null) && (this.adImpl.controller.webView != null)) {
            this.adImpl.controller.webView.setMraidHidden();
          }
          MMAdImplController.removeAdViewController(this.adImpl);
        }
      }
      Object localObject1 = BridgeMMMedia.Audio.sharedAudio(getContext());
      if (localObject1 != null) {}
      try
      {
        ((BridgeMMMedia.Audio)localObject1).stop();
        BridgeMMMicrophone.Recorder.getInstance().stopRecording();
        return;
      }
      finally {}
      if (this.inlineVideoView == null) {
        break;
      }
      this.inlineVideoView.pauseVideo();
      break;
      label275:
      BridgeMMSpeechkit.releaseSpeechKit();
      this.adImpl.controller.webView.setMraidViewableHidden();
      this.adImpl.controller.webView.onPauseWebView();
    }
  }
  
  void pauseVideo()
  {
    if (this.inlineVideoView != null) {
      this.inlineVideoView.pauseVideo();
    }
  }
  
  void playVideo()
  {
    if (this.inlineVideoView != null) {
      this.inlineVideoView.playVideo();
    }
  }
  
  public void removeBlackView()
  {
    if (this.blackView != null) {
      this.blackView.setVisibility(4);
    }
  }
  
  void removeCloseTouchDelegate()
  {
    if ((this.closeAreaView != null) && (this.closeAreaView.getParent() != null) && ((this.closeAreaView.getParent() instanceof ViewGroup)))
    {
      ((ViewGroup)this.closeAreaView.getParent()).removeView(this.closeAreaView);
      this.closeAreaView = null;
    }
  }
  
  void removeVideo()
  {
    if (this.inlineVideoView != null)
    {
      this.inlineVideoView.removeVideo();
      this.inlineVideoView = null;
    }
  }
  
  void repositionVideoLayout() {}
  
  void resumeVideo()
  {
    if (this.inlineVideoView != null) {
      this.inlineVideoView.resumeVideo();
    }
  }
  
  public void setApid(String paramString)
  {
    this.adImpl.setApid(paramString);
  }
  
  void setCloseArea(final String paramString)
  {
    post(new Runnable()
    {
      public void run()
      {
        MMLayout.this.internalSetCloseArea(paramString);
      }
    });
  }
  
  public void setIgnoresDensityScaling(boolean paramBoolean)
  {
    this.adImpl.setIgnoresDensityScaling(paramBoolean);
  }
  
  public void setListener(RequestListener paramRequestListener)
  {
    this.adImpl.setListener(paramRequestListener);
  }
  
  public void setMMRequest(MMRequest paramMMRequest)
  {
    this.adImpl.setMMRequest(paramMMRequest);
  }
  
  void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    try
    {
      WebView.class.getMethod("setMediaPlaybackRequiresUserGesture", new Class[] { Boolean.TYPE }).invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException) {}
  }
  
  void setVideoSource(String paramString)
  {
    if (this.inlineVideoView != null) {
      this.inlineVideoView.setVideoSource(paramString);
    }
  }
  
  void stopVideo()
  {
    if (this.inlineVideoView != null) {
      this.inlineVideoView.stopVideo();
    }
  }
  
  class LayoutAdProperties
    extends AdProperties
  {
    LayoutAdProperties(Context paramContext)
    {
      super();
    }
    
    String getAdDpiIndependentHeight()
    {
      float f = MMSDK.getDensity(getContext());
      return String.valueOf((int)(MMLayout.this.getHeight() / f));
    }
    
    String getAdDpiIndependentWidth()
    {
      float f = MMSDK.getDensity(getContext());
      return String.valueOf((int)(MMLayout.this.getWidth() / f));
    }
  }
  
  private static class LayoutGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    WeakReference<MMLayout> layoutRef;
    
    public LayoutGestureListener(MMLayout paramMMLayout)
    {
      this.layoutRef = new WeakReference(paramMMLayout);
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
      while ((Math.abs((int)(paramMotionEvent2.getX() - paramMotionEvent1.getX())) <= 200) || (Math.abs(paramFloat1) <= Math.abs(paramFloat2))) {
        return false;
      }
      if (paramFloat1 > 0.0F) {
        if (MMSDK.logLevel == 0)
        {
          MMSDK.Log.i("Enabling debug and verbose logging.");
          MMSDK.logLevel = 3;
        }
      }
      for (;;)
      {
        return true;
        MMSDK.Log.i("Disabling debug and verbose logging.");
        MMSDK.logLevel = 0;
        continue;
        paramMotionEvent1 = (MMLayout)this.layoutRef.get();
        if (paramMotionEvent1 != null) {
          MMSDK.printDiagnostics(paramMotionEvent1.adImpl);
        }
      }
    }
  }
  
  class MMLayoutMMAdImpl
    extends MMAdImpl
  {
    public MMLayoutMMAdImpl(Context paramContext)
    {
      super();
      this.adProperties = new MMLayout.LayoutAdProperties(MMLayout.this, getContext());
    }
    
    public void addView(MMWebView paramMMWebView, RelativeLayout.LayoutParams paramLayoutParams)
    {
      MMSDK.Log.w("MMLayout adding view (" + paramMMWebView + ") to " + this);
      MMLayout.this.addView(paramMMWebView, paramLayoutParams);
    }
    
    MMLayout getCallingAd()
    {
      return MMLayout.this;
    }
    
    int getId()
    {
      return MMLayout.this.getId();
    }
    
    public void removeView(MMWebView paramMMWebView)
    {
      MMLayout.this.removeView(paramMMWebView);
    }
    
    public void setClickable(boolean paramBoolean)
    {
      MMLayout.this.setClickable(paramBoolean);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/MMLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */