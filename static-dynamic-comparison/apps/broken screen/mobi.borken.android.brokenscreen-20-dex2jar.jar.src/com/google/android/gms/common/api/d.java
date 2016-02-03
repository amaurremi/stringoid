package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.List;

public class d
  extends Fragment
  implements DialogInterface.OnCancelListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private GoogleApiClient.OnConnectionFailedListener DK;
  private GoogleApiClient Eq;
  private ConnectionResult Er;
  private boolean Es;
  
  public void a(GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.Eq = paramGoogleApiClient;
    this.Eq.registerConnectionCallbacks(this);
    this.DK = paramOnConnectionFailedListener;
    this.Eq.registerConnectionCallbacks(this);
    this.Eq.registerConnectionFailedListener(this);
  }
  
  public boolean isInitialized()
  {
    return this.Eq != null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label76;
      }
      this.Eq.connect();
      this.Es = false;
      return;
      if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) != 0) {
        break;
      }
      paramInt1 = i;
      continue;
      if (paramInt2 != -1) {
        break;
      }
      paramInt1 = i;
    }
    label76:
    this.DK.onConnectionFailed(this.Er);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.Es = false;
    this.DK.onConnectionFailed(this.Er);
  }
  
  public void onConnected(Bundle paramBundle)
  {
    this.Es = false;
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.Er = paramConnectionResult;
    if (this.Es) {
      return;
    }
    int i = getActivity().getSupportFragmentManager().getFragments().indexOf(this);
    if (paramConnectionResult.hasResolution()) {
      try
      {
        paramConnectionResult.startResolutionForResult(getActivity(), (i + 1 << 16) + 1);
        return;
      }
      catch (IntentSender.SendIntentException paramConnectionResult)
      {
        this.Eq.connect();
        return;
      }
    }
    if (GooglePlayServicesUtil.isUserRecoverableError(paramConnectionResult.getErrorCode()))
    {
      GooglePlayServicesUtil.b(paramConnectionResult.getErrorCode(), getActivity(), this, 2, this);
      return;
    }
    this.DK.onConnectionFailed(this.Er);
  }
  
  public void onConnectionSuspended(int paramInt) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.Es = paramBundle.getBoolean("resolving_error", false);
      int i = paramBundle.getInt("connection_result_status");
      if (i != 0) {
        this.Er = new ConnectionResult(i, (PendingIntent)paramBundle.getParcelable("resolution_pending_intent"));
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.Es);
    if (this.Er != null)
    {
      paramBundle.putInt("connection_result_status", this.Er.getErrorCode());
      paramBundle.putParcelable("resolution_pending_intent", this.Er.getResolution());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((!this.Es) && (this.Eq != null)) {
      this.Eq.connect();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.Eq != null) {
      this.Eq.disconnect();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/api/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */