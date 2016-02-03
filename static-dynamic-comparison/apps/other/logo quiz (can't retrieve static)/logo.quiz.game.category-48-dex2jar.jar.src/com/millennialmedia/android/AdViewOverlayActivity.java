package com.millennialmedia.android;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class AdViewOverlayActivity
  extends MMBaseActivity
{
  private AdViewOverlayView adViewOverlayView;
  boolean hasFocus;
  boolean isPaused;
  private OverlaySettings settings;
  
  private void lockOrientation()
  {
    if (this.activity.getRequestedOrientation() == 0)
    {
      setRequestedOrientation(0);
      return;
    }
    if (this.activity.getRequestedOrientation() == 8)
    {
      setRequestedOrientation(8);
      return;
    }
    if (this.activity.getRequestedOrientation() == 9)
    {
      setRequestedOrientation(9);
      return;
    }
    setRequestedOrientation(1);
  }
  
  private void setRequestedOrientation(String paramString)
  {
    if ("landscape".equalsIgnoreCase(paramString)) {
      setRequestedOrientation(0);
    }
    while (!"portrait".equalsIgnoreCase(paramString)) {
      return;
    }
    setRequestedOrientation(1);
  }
  
  public void finish()
  {
    if (this.adViewOverlayView != null)
    {
      if (!this.adViewOverlayView.attachWebViewToLink()) {
        this.adViewOverlayView.killWebView();
      }
      this.adViewOverlayView.removeSelfAndAll();
    }
    this.adViewOverlayView = null;
    super.finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.adViewOverlayView != null) {
      this.adViewOverlayView.inlineConfigChange();
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setTheme(16973840);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getWindow().clearFlags(1024);
    getWindow().addFlags(2048);
    getWindow().addFlags(16777216);
    paramBundle = getIntent();
    this.settings = ((OverlaySettings)paramBundle.getParcelableExtra("settings"));
    if (this.settings == null) {
      this.settings = new OverlaySettings();
    }
    this.settings.log();
    if (this.settings.orientation != null) {
      setRequestedOrientation(this.settings.orientation);
    }
    if (this.settings.allowOrientationChange)
    {
      unlockScreenOrientation();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getData();
        if (paramBundle != null) {
          MMSDK.Log.v("Path: %s", new Object[] { paramBundle.getLastPathSegment() });
        }
      }
      paramBundle = new RelativeLayout(this.activity);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      paramBundle.setId(885394873);
      paramBundle.setLayoutParams(localLayoutParams);
      this.adViewOverlayView = new AdViewOverlayView(this, this.settings);
      paramBundle.addView(this.adViewOverlayView);
      setContentView(paramBundle);
      if (getLastNonConfigurationInstance() == null)
      {
        if (!this.settings.isExpanded()) {
          break label350;
        }
        if ((this.adViewOverlayView.adImpl != null) && (this.adViewOverlayView.adImpl.controller != null) && (this.adViewOverlayView.adImpl.controller.webView != null)) {
          this.adViewOverlayView.adImpl.controller.webView.setMraidExpanded();
        }
        if (this.settings.hasExpandUrl()) {
          this.adViewOverlayView.getWebContent(this.settings.urlToLoad);
        }
      }
    }
    for (;;)
    {
      this.settings.orientation = null;
      return;
      lockOrientation();
      break;
      label350:
      if (!this.settings.isExpanded()) {
        this.adViewOverlayView.loadWebContent(this.settings.content, this.settings.adUrl);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    MMSDK.Log.d("Overlay onDestroy");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      this.adViewOverlayView.finishOverlayWithAnimation();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    this.isPaused = true;
    MMSDK.Log.d("Overlay onPause");
    BridgeMMMedia.Audio localAudio = BridgeMMMedia.Audio.sharedAudio(this.activity);
    if (localAudio != null) {}
    try
    {
      localAudio.stop();
      BridgeMMMicrophone.Recorder.getInstance().stopRecording();
      if (this.adViewOverlayView != null)
      {
        this.adViewOverlayView.pauseVideo();
        if ((this.adViewOverlayView.adImpl != null) && (this.adViewOverlayView.adImpl.controller != null) && (this.adViewOverlayView.adImpl.controller.webView != null)) {
          this.adViewOverlayView.adImpl.controller.webView.onPauseWebView();
        }
      }
      setResult(0);
      super.onPause();
      return;
    }
    finally {}
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onResume()
  {
    this.isPaused = false;
    MMSDK.Log.d("Overlay onResume");
    if (this.adViewOverlayView != null)
    {
      if (this.hasFocus) {
        this.adViewOverlayView.resumeVideo();
      }
      this.adViewOverlayView.addBlackView();
      if ((this.adViewOverlayView.adImpl != null) && (this.adViewOverlayView.adImpl.controller != null) && (this.adViewOverlayView.adImpl.controller.webView != null)) {
        this.adViewOverlayView.adImpl.controller.webView.onResumeWebView();
      }
    }
    super.onResume();
  }
  
  public Object onRetainNonConfigurationInstance()
  {
    return this.adViewOverlayView.getNonConfigurationInstance();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("adViewId", this.adViewOverlayView.getId());
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.hasFocus = paramBoolean;
    if ((!this.isPaused) && (paramBoolean)) {
      this.adViewOverlayView.resumeVideo();
    }
  }
  
  void setAllowOrientationChange(boolean paramBoolean)
  {
    this.settings.allowOrientationChange = paramBoolean;
    if (paramBoolean)
    {
      unlockScreenOrientation();
      return;
    }
    lockOrientation();
  }
  
  void setRequestedOrientationLandscape()
  {
    this.settings.orientation = "landscape";
    this.settings.allowOrientationChange = false;
    setRequestedOrientation(0);
  }
  
  void setRequestedOrientationPortrait()
  {
    this.settings.orientation = "portrait";
    this.settings.allowOrientationChange = false;
    setRequestedOrientation(1);
  }
  
  void unlockScreenOrientation()
  {
    setRequestedOrientation(-1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */