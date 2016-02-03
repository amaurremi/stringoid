package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public final class hb$g
  implements GoogleApiClient.OnConnectionFailedListener
{
  private final GooglePlayServicesClient.OnConnectionFailedListener Gm;
  
  public hb$g(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.Gm = paramOnConnectionFailedListener;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof g)) {
      return this.Gm.equals(((g)paramObject).Gm);
    }
    return this.Gm.equals(paramObject);
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.Gm.onConnectionFailed(paramConnectionResult);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hb$g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */