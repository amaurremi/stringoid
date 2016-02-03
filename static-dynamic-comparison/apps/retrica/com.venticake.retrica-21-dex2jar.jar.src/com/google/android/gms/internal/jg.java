package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class jg
  extends hb<je>
{
  private final jj<je> VJ = new pj(this, null);
  private final jf VP = new jf(paramContext, this.VJ);
  private final jz VQ;
  private final iz VR;
  private final String VS;
  
  public jg(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    this(paramContext, paramLooper, paramContext.getPackageName(), paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, null);
  }
  
  public jg(Context paramContext, Looper paramLooper, String paramString1, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString2, String paramString3)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.VS = paramString2;
    this.VQ = new jz(paramString1, this.VJ);
    this.VR = iz.a(paramContext, paramString3, this.VJ);
  }
  
  public jg(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.VS = paramString;
    this.VQ = new jz(paramContext.getPackageName(), this.VJ);
    this.VR = iz.a(paramContext, null, this.VJ);
  }
  
  protected void a(hi paramhi, hb.e parame)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", this.VS);
    paramhi.e(parame, 5089000, getContext().getPackageName(), localBundle);
  }
  
  public void addGeofences(List<jh> paramList, PendingIntent paramPendingIntent, LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
  {
    cn();
    boolean bool;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool = true;
      hm.b(bool, "At least one geofence must be specified.");
      hm.b(paramPendingIntent, "PendingIntent must be specified.");
      hm.b(paramOnAddGeofencesResultListener, "OnAddGeofencesResultListener not provided.");
      if (paramOnAddGeofencesResultListener != null) {
        break label76;
      }
    }
    label76:
    for (paramOnAddGeofencesResultListener = null;; paramOnAddGeofencesResultListener = new pi(paramOnAddGeofencesResultListener, this))
    {
      ((je)ft()).a(paramList, paramPendingIntent, paramOnAddGeofencesResultListener, getContext().getPackageName());
      return;
      bool = false;
      break;
    }
  }
  
  protected je at(IBinder paramIBinder)
  {
    return je.a.as(paramIBinder);
  }
  
  protected String bu()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  protected String bv()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  public void disconnect()
  {
    synchronized (this.VP)
    {
      if (isConnected())
      {
        this.VP.removeAllListeners();
        this.VP.iY();
      }
      super.disconnect();
      return;
    }
  }
  
  public Location getLastLocation()
  {
    return this.VP.getLastLocation();
  }
  
  public void removeActivityUpdates(PendingIntent paramPendingIntent)
  {
    cn();
    hm.f(paramPendingIntent);
    ((je)ft()).removeActivityUpdates(paramPendingIntent);
  }
  
  public void removeGeofences(PendingIntent paramPendingIntent, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
  {
    cn();
    hm.b(paramPendingIntent, "PendingIntent must be specified.");
    hm.b(paramOnRemoveGeofencesResultListener, "OnRemoveGeofencesResultListener not provided.");
    if (paramOnRemoveGeofencesResultListener == null) {}
    for (paramOnRemoveGeofencesResultListener = null;; paramOnRemoveGeofencesResultListener = new pi(paramOnRemoveGeofencesResultListener, this))
    {
      ((je)ft()).a(paramPendingIntent, paramOnRemoveGeofencesResultListener, getContext().getPackageName());
      return;
    }
  }
  
  public void removeGeofences(List<String> paramList, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
  {
    cn();
    boolean bool;
    String[] arrayOfString;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool = true;
      hm.b(bool, "geofenceRequestIds can't be null nor empty.");
      hm.b(paramOnRemoveGeofencesResultListener, "OnRemoveGeofencesResultListener not provided.");
      arrayOfString = (String[])paramList.toArray(new String[0]);
      if (paramOnRemoveGeofencesResultListener != null) {
        break label81;
      }
    }
    label81:
    for (paramList = null;; paramList = new pi(paramOnRemoveGeofencesResultListener, this))
    {
      ((je)ft()).a(arrayOfString, paramList, getContext().getPackageName());
      return;
      bool = false;
      break;
    }
  }
  
  public void removeLocationUpdates(PendingIntent paramPendingIntent)
  {
    this.VP.removeLocationUpdates(paramPendingIntent);
  }
  
  public void removeLocationUpdates(LocationListener paramLocationListener)
  {
    this.VP.removeLocationUpdates(paramLocationListener);
  }
  
  public void requestActivityUpdates(long paramLong, PendingIntent paramPendingIntent)
  {
    cn();
    hm.f(paramPendingIntent);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      hm.b(bool, "detectionIntervalMillis must be >= 0");
      ((je)ft()).a(paramLong, true, paramPendingIntent);
      return;
    }
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
  {
    this.VP.requestLocationUpdates(paramLocationRequest, paramPendingIntent);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener)
  {
    requestLocationUpdates(paramLocationRequest, paramLocationListener, null);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
  {
    synchronized (this.VP)
    {
      this.VP.requestLocationUpdates(paramLocationRequest, paramLocationListener, paramLooper);
      return;
    }
  }
  
  public void setMockLocation(Location paramLocation)
  {
    this.VP.setMockLocation(paramLocation);
  }
  
  public void setMockMode(boolean paramBoolean)
  {
    this.VP.setMockMode(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */