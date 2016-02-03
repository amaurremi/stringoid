package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.support.v4.app.l;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.List;

public class d
  extends Fragment
  implements DialogInterface.OnCancelListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private GoogleApiClient.OnConnectionFailedListener DN;
  private GoogleApiClient Et;
  private ConnectionResult Eu;
  private boolean Ev;
  
  public void a(GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.Et = paramGoogleApiClient;
    this.Et.registerConnectionCallbacks(this);
    this.DN = paramOnConnectionFailedListener;
    this.Et.registerConnectionCallbacks(this);
    this.Et.registerConnectionFailedListener(this);
  }
  
  public boolean isInitialized()
  {
    return this.Et != null;
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
      this.Et.connect();
      this.Ev = false;
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
    this.DN.onConnectionFailed(this.Eu);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.Ev = false;
    this.DN.onConnectionFailed(this.Eu);
  }
  
  public void onConnected(Bundle paramBundle)
  {
    this.Ev = false;
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.Eu = paramConnectionResult;
    if (this.Ev) {
      return;
    }
    int i = getActivity().e().c().indexOf(this);
    if (paramConnectionResult.hasResolution()) {
      try
      {
        paramConnectionResult.startResolutionForResult(getActivity(), (i + 1 << 16) + 1);
        return;
      }
      catch (IntentSender.SendIntentException paramConnectionResult)
      {
        this.Et.connect();
        return;
      }
    }
    if (GooglePlayServicesUtil.isUserRecoverableError(paramConnectionResult.getErrorCode()))
    {
      GooglePlayServicesUtil.b(paramConnectionResult.getErrorCode(), getActivity(), this, 2, this);
      return;
    }
    this.DN.onConnectionFailed(this.Eu);
  }
  
  public void onConnectionSuspended(int paramInt) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.Ev = paramBundle.getBoolean("resolving_error", false);
      int i = paramBundle.getInt("connection_result_status");
      if (i != 0) {
        this.Eu = new ConnectionResult(i, (PendingIntent)paramBundle.getParcelable("resolution_pending_intent"));
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.Ev);
    if (this.Eu != null)
    {
      paramBundle.putInt("connection_result_status", this.Eu.getErrorCode());
      paramBundle.putParcelable("resolution_pending_intent", this.Eu.getResolution());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((!this.Ev) && (this.Et != null)) {
      this.Et.connect();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.Et != null) {
      this.Et.disconnect();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/api/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */