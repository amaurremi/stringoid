package com.backflipstudios.android.mopub;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import com.backflipstudios.android.engine.app.BFSActivityAddon;
import com.backflipstudios.android.engine.app.BFSActivityAddon.AddonType;
import com.mopub.mobileads.MoPubConversionTracker;

public class BFSMoPubConversionTrackerAddon
  extends BFSActivityAddon
{
  public static final String NAME = "BFSMoPubConversionTrackerAddon";
  
  public BFSMoPubConversionTrackerAddon(Activity paramActivity)
  {
    super(paramActivity);
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
  
  public void onCreate()
  {
    new MoPubConversionTracker().reportAppOpen(this.m_activity);
  }
  
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
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/backflipstudios/android/mopub/BFSMoPubConversionTrackerAddon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */