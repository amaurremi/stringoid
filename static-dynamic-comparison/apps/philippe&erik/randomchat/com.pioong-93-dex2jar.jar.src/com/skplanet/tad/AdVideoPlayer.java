package com.skplanet.tad;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.skplanet.tad.videoplayer.activity.a;

public class AdVideoPlayer
  extends Activity
{
  private static String b = null;
  private a a = null;
  
  private a a(String paramString)
  {
    return com.skplanet.tad.videoplayer.activity.b.a(paramString, this);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4) {
      finish();
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    com.skplanet.tad.videoplayer.util.b.a("onConfigurationChanged mIsApkUsed FALSE ");
    this.a.a(paramConfiguration);
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b = getIntent().getStringExtra("multimedia");
    this.a = a(b);
    if (this.a != null) {
      this.a.a(paramBundle);
    }
  }
  
  protected void onDestroy()
  {
    this.a.d();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = false;
    com.skplanet.tad.videoplayer.util.b.a("onKeyDown mIsApkUsed FALSE ");
    if (this.a != null) {
      bool1 = this.a.a(paramInt, paramKeyEvent);
    }
    com.skplanet.tad.videoplayer.util.b.a("PlayerActivity onKeyDown= " + bool1);
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = super.onKeyDown(paramInt, paramKeyEvent);
    }
    return bool2;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    com.skplanet.tad.videoplayer.util.b.a("onTouchEvent mIsApkUsed FALSE ");
    return this.a.b(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    this.a.b();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.a.a();
  }
  
  protected void onStop()
  {
    this.a.c();
    super.onStop();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    com.skplanet.tad.videoplayer.util.b.a("onTouchEvent mIsApkUsed FALSE ");
    boolean bool2 = this.a.a(paramMotionEvent);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    return bool1;
  }
  
  public void onUserInteraction()
  {
    com.skplanet.tad.videoplayer.util.b.a("onUserInteraction mIsApkUsed FALSE ");
    this.a.e();
    super.onUserInteraction();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/AdVideoPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */