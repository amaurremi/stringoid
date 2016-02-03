package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationStatusCodes;

final class pk
  extends hb<je>.b<LocationClient.OnRemoveGeofencesResultListener>
{
  private final int b;
  private final String[] c;
  private final PendingIntent d;
  private final int e;
  
  public pk(jg paramjg, int paramInt1, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, int paramInt2, PendingIntent paramPendingIntent)
  {
    super(paramjg, paramOnRemoveGeofencesResultListener);
    if (paramInt1 == 1) {}
    for (;;)
    {
      gx.A(bool);
      this.e = paramInt1;
      this.b = LocationStatusCodes.cJ(paramInt2);
      this.d = paramPendingIntent;
      this.c = null;
      return;
      bool = false;
    }
  }
  
  public pk(jg paramjg, int paramInt1, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, int paramInt2, String[] paramArrayOfString)
  {
    super(paramjg, paramOnRemoveGeofencesResultListener);
    if (paramInt1 == 2) {}
    for (boolean bool = true;; bool = false)
    {
      gx.A(bool);
      this.e = paramInt1;
      this.b = LocationStatusCodes.cJ(paramInt2);
      this.c = paramArrayOfString;
      this.d = null;
      return;
    }
  }
  
  protected void a(LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
  {
    if (paramOnRemoveGeofencesResultListener != null) {}
    switch (this.e)
    {
    default: 
      Log.wtf("LocationClientImpl", "Unsupported action: " + this.e);
      return;
    case 1: 
      paramOnRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.b, this.d);
      return;
    }
    paramOnRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.b, this.c);
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/pk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */