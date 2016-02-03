package com.backflipstudios.android.googleanalytics;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import com.backflipstudios.android.engine.app.BFSActivityAddon;
import com.backflipstudios.android.engine.app.BFSActivityAddon.AddonType;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;

public class BFSGoogleAnalyticsActivityAddon
  extends BFSActivityAddon
{
  public static final String NAME = "BFSMoPubConversionTrackerAddon";
  private String m_account = "";
  private GoogleAnalyticsTracker m_tracker = null;
  
  public BFSGoogleAnalyticsActivityAddon(Activity paramActivity, String paramString)
  {
    super(paramActivity);
    this.m_account = paramString;
  }
  
  public String getName()
  {
    return "BFSMoPubConversionTrackerAddon";
  }
  
  public BFSActivityAddon.AddonType getType()
  {
    return BFSActivityAddon.AddonType.Other;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart()
  {
    this.m_tracker = GoogleAnalyticsTracker.getInstance();
    this.m_tracker.startNewSession(this.m_account, this.m_activity);
    this.m_tracker.trackPageView("/mainactivity");
    this.m_tracker.dispatch();
  }
  
  public void onStop()
  {
    this.m_tracker.stopSession();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/backflipstudios/android/googleanalytics/BFSGoogleAnalyticsActivityAddon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */