package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LocationClient
  implements GooglePlayServicesClient
{
  public static final String KEY_LOCATION_CHANGED = "com.google.android.location.LOCATION";
  public static final String KEY_MOCK_LOCATION = "mockLocation";
  private final hc NO;
  
  public LocationClient(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.NO = new hc(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, "location");
  }
  
  public static int getErrorCode(Intent paramIntent)
  {
    return paramIntent.getIntExtra("gms_error_code", -1);
  }
  
  public static int getGeofenceTransition(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
    if (i == -1) {}
    while ((i != 1) && (i != 2) && (i != 4)) {
      return -1;
    }
    return i;
  }
  
  public static List<Geofence> getTriggeringGeofences(Intent paramIntent)
  {
    Object localObject = (ArrayList)paramIntent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
    if (localObject == null) {
      return null;
    }
    paramIntent = new ArrayList(((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramIntent.add(hd.h((byte[])((Iterator)localObject).next()));
    }
    return paramIntent;
  }
  
  public static boolean hasError(Intent paramIntent)
  {
    return paramIntent.hasExtra("gms_error_code");
  }
  
  public void addGeofences(List<Geofence> paramList, PendingIntent paramPendingIntent, OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
  {
    ArrayList localArrayList = null;
    if (paramList != null)
    {
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Geofence localGeofence = (Geofence)paramList.next();
        fq.b(localGeofence instanceof hd, "Geofence must be created using Geofence.Builder.");
        localArrayList.add((hd)localGeofence);
      }
    }
    this.NO.addGeofences(localArrayList, paramPendingIntent, paramOnAddGeofencesResultListener);
  }
  
  public void connect()
  {
    this.NO.connect();
  }
  
  public void disconnect()
  {
    this.NO.disconnect();
  }
  
  public Location getLastLocation()
  {
    return this.NO.getLastLocation();
  }
  
  public boolean isConnected()
  {
    return this.NO.isConnected();
  }
  
  public boolean isConnecting()
  {
    return this.NO.isConnecting();
  }
  
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.NO.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.NO.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.NO.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.NO.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void removeGeofences(PendingIntent paramPendingIntent, OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
  {
    this.NO.removeGeofences(paramPendingIntent, paramOnRemoveGeofencesResultListener);
  }
  
  public void removeGeofences(List<String> paramList, OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
  {
    this.NO.removeGeofences(paramList, paramOnRemoveGeofencesResultListener);
  }
  
  public void removeLocationUpdates(PendingIntent paramPendingIntent)
  {
    this.NO.removeLocationUpdates(paramPendingIntent);
  }
  
  public void removeLocationUpdates(LocationListener paramLocationListener)
  {
    this.NO.removeLocationUpdates(paramLocationListener);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
  {
    this.NO.requestLocationUpdates(paramLocationRequest, paramPendingIntent);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener)
  {
    this.NO.requestLocationUpdates(paramLocationRequest, paramLocationListener);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
  {
    this.NO.requestLocationUpdates(paramLocationRequest, paramLocationListener, paramLooper);
  }
  
  public void setMockLocation(Location paramLocation)
  {
    this.NO.setMockLocation(paramLocation);
  }
  
  public void setMockMode(boolean paramBoolean)
  {
    this.NO.setMockMode(paramBoolean);
  }
  
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.NO.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.NO.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public static abstract interface OnAddGeofencesResultListener
  {
    public abstract void onAddGeofencesResult(int paramInt, String[] paramArrayOfString);
  }
  
  public static abstract interface OnRemoveGeofencesResultListener
  {
    public abstract void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent);
    
    public abstract void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/location/LocationClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */