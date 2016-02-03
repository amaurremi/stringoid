package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.co;
import com.google.android.gms.internal.ev;

public final class AdActivity
  extends Activity
{
  public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
  public static final String SIMPLE_CLASS_NAME = "AdActivity";
  private co kp;
  
  private void N()
  {
    if (this.kp != null) {}
    try
    {
      this.kp.N();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not forward setContentViewSet to ad overlay:", localRemoteException);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.kp = cn.a(this);
    if (this.kp == null)
    {
      ev.D("Could not create ad overlay.");
      finish();
      return;
    }
    try
    {
      this.kp.onCreate(paramBundle);
      return;
    }
    catch (RemoteException paramBundle)
    {
      ev.c("Could not forward onCreate to ad overlay:", paramBundle);
      finish();
    }
  }
  
  protected void onDestroy()
  {
    try
    {
      if (this.kp != null) {
        this.kp.onDestroy();
      }
      super.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not forward onDestroy to ad overlay:", localRemoteException);
      }
    }
  }
  
  protected void onPause()
  {
    try
    {
      if (this.kp != null) {
        this.kp.onPause();
      }
      super.onPause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not forward onPause to ad overlay:", localRemoteException);
        finish();
      }
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    try
    {
      if (this.kp != null) {
        this.kp.onRestart();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not forward onRestart to ad overlay:", localRemoteException);
      finish();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    try
    {
      if (this.kp != null) {
        this.kp.onResume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not forward onResume to ad overlay:", localRemoteException);
      finish();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      if (this.kp != null) {
        this.kp.onSaveInstanceState(paramBundle);
      }
      super.onSaveInstanceState(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not forward onSaveInstanceState to ad overlay:", localRemoteException);
        finish();
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    try
    {
      if (this.kp != null) {
        this.kp.onStart();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not forward onStart to ad overlay:", localRemoteException);
      finish();
    }
  }
  
  protected void onStop()
  {
    try
    {
      if (this.kp != null) {
        this.kp.onStop();
      }
      super.onStop();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not forward onStop to ad overlay:", localRemoteException);
        finish();
      }
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    N();
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
    N();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
    N();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/ads/AdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */