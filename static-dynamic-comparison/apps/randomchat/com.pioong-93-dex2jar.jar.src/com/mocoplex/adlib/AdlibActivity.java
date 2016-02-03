package com.mocoplex.adlib;

import android.app.Activity;
import android.os.Bundle;

public class AdlibActivity
  extends Activity
{
  protected AdlibManager _amanager;
  
  public void bindAdsContainer(AdlibAdViewContainer paramAdlibAdViewContainer)
  {
    this._amanager.bindAdsContainer(paramAdlibAdViewContainer);
  }
  
  public void destroyAdsContainer()
  {
    this._amanager.destroyAdsContainer();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this._amanager = new AdlibManager();
    this._amanager.onCreate(this);
  }
  
  protected void onDestroy()
  {
    this._amanager.onDestroy(this);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    this._amanager.onPause();
    super.onPause();
  }
  
  protected void onResume()
  {
    this._amanager.onResume(this);
    super.onResume();
  }
  
  public void setAdsContainer(int paramInt)
  {
    this._amanager.setAdsContainer(paramInt);
  }
  
  public void setVersionCheckingListner(AdlibManager.AdlibVersionCheckingListener paramAdlibVersionCheckingListener)
  {
    this._amanager.setVersionCheckingListner(paramAdlibVersionCheckingListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/AdlibActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */