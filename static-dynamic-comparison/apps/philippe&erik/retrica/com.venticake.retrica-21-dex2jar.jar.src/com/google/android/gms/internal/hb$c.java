package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;

public final class hb$c
  implements GoogleApiClient.ConnectionCallbacks
{
  private final GooglePlayServicesClient.ConnectionCallbacks Gk;
  
  public hb$c(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.Gk = paramConnectionCallbacks;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof c)) {
      return this.Gk.equals(((c)paramObject).Gk);
    }
    return this.Gk.equals(paramObject);
  }
  
  public void onConnected(Bundle paramBundle)
  {
    this.Gk.onConnected(paramBundle);
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    this.Gk.onDisconnected();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hb$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */