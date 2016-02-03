package com.google.android.gms.internal;

import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationStatusCodes;

final class ph
  extends hb<je>.b<LocationClient.OnAddGeofencesResultListener>
{
  private final int b;
  private final String[] c;
  
  public ph(jg paramjg, LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener, int paramInt, String[] paramArrayOfString)
  {
    super(paramjg, paramOnAddGeofencesResultListener);
    this.b = LocationStatusCodes.cJ(paramInt);
    this.c = paramArrayOfString;
  }
  
  protected void a(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
  {
    if (paramOnAddGeofencesResultListener != null) {
      paramOnAddGeofencesResultListener.onAddGeofencesResult(this.b, this.c);
    }
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */