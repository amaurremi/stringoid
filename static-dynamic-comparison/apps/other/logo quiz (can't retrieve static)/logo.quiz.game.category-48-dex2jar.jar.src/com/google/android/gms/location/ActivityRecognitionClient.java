package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.ly;

@Deprecated
public class ActivityRecognitionClient
  implements GooglePlayServicesClient
{
  private final ly adP;
  
  public ActivityRecognitionClient(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.adP = new ly(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, "activity_recognition");
  }
  
  public void connect()
  {
    this.adP.connect();
  }
  
  public void disconnect()
  {
    this.adP.disconnect();
  }
  
  public boolean isConnected()
  {
    return this.adP.isConnected();
  }
  
  public boolean isConnecting()
  {
    return this.adP.isConnecting();
  }
  
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.adP.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.adP.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.adP.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.adP.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void removeActivityUpdates(PendingIntent paramPendingIntent)
  {
    try
    {
      this.adP.removeActivityUpdates(paramPendingIntent);
      return;
    }
    catch (RemoteException paramPendingIntent)
    {
      throw new IllegalStateException(paramPendingIntent);
    }
  }
  
  public void requestActivityUpdates(long paramLong, PendingIntent paramPendingIntent)
  {
    try
    {
      this.adP.requestActivityUpdates(paramLong, paramPendingIntent);
      return;
    }
    catch (RemoteException paramPendingIntent)
    {
      throw new IllegalStateException(paramPendingIntent);
    }
  }
  
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.adP.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.adP.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/location/ActivityRecognitionClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */