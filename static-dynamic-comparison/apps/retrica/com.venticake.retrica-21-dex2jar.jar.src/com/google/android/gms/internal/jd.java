package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IInterface;

public abstract interface jd
  extends IInterface
{
  public abstract void onAddGeofencesResult(int paramInt, String[] paramArrayOfString);
  
  public abstract void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent);
  
  public abstract void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */