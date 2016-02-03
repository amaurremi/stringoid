package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;

final class pi
  extends jd.a
{
  private LocationClient.OnAddGeofencesResultListener a;
  private LocationClient.OnRemoveGeofencesResultListener b;
  private jg c;
  
  public pi(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener, jg paramjg)
  {
    this.a = paramOnAddGeofencesResultListener;
    this.b = null;
    this.c = paramjg;
  }
  
  public pi(LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, jg paramjg)
  {
    this.b = paramOnRemoveGeofencesResultListener;
    this.a = null;
    this.c = paramjg;
  }
  
  public void onAddGeofencesResult(int paramInt, String[] paramArrayOfString)
  {
    if (this.c == null)
    {
      Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
      return;
    }
    jg localjg1 = this.c;
    jg localjg2 = this.c;
    localjg2.getClass();
    localjg1.a(new ph(localjg2, this.a, paramInt, paramArrayOfString));
    this.c = null;
    this.a = null;
    this.b = null;
  }
  
  public void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent)
  {
    if (this.c == null)
    {
      Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
      return;
    }
    jg localjg1 = this.c;
    jg localjg2 = this.c;
    localjg2.getClass();
    localjg1.a(new pk(localjg2, 1, this.b, paramInt, paramPendingIntent));
    this.c = null;
    this.a = null;
    this.b = null;
  }
  
  public void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString)
  {
    if (this.c == null)
    {
      Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
      return;
    }
    jg localjg1 = this.c;
    jg localjg2 = this.c;
    localjg2.getClass();
    localjg1.a(new pk(localjg2, 2, this.b, paramInt, paramArrayOfString));
    this.c = null;
    this.a = null;
    this.b = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/pi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */