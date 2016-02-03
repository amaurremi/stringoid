package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.gn;

public class ActivityRecognitionClient
  implements GooglePlayServicesClient
{
  private final gn xl;
  
  public ActivityRecognitionClient(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.xl = new gn(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, "activity_recognition");
  }
  
  public void connect()
  {
    this.xl.connect();
  }
  
  public void disconnect()
  {
    this.xl.disconnect();
  }
  
  public boolean isConnected()
  {
    return this.xl.isConnected();
  }
  
  public boolean isConnecting()
  {
    return this.xl.isConnecting();
  }
  
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.xl.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.xl.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.xl.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.xl.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void removeActivityUpdates(PendingIntent paramPendingIntent)
  {
    this.xl.removeActivityUpdates(paramPendingIntent);
  }
  
  public void requestActivityUpdates(long paramLong, PendingIntent paramPendingIntent)
  {
    this.xl.requestActivityUpdates(paramLong, paramPendingIntent);
  }
  
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.xl.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.xl.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/location/ActivityRecognitionClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */