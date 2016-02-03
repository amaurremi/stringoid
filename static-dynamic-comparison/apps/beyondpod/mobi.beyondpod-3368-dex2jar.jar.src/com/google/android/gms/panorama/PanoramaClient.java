package com.google.android.gms.panorama;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.internal.hm;

public class PanoramaClient
  implements GooglePlayServicesClient
{
  private final hm Di;
  
  public PanoramaClient(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.Di = new hm(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public void connect()
  {
    this.Di.connect();
  }
  
  public void disconnect()
  {
    this.Di.disconnect();
  }
  
  public boolean isConnected()
  {
    return this.Di.isConnected();
  }
  
  public boolean isConnecting()
  {
    return this.Di.isConnecting();
  }
  
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.Di.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.Di.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void loadPanoramaInfo(final OnPanoramaInfoLoadedListener paramOnPanoramaInfoLoadedListener, Uri paramUri)
  {
    this.Di.a(new a.c()
    {
      public void a(Panorama.PanoramaResult paramAnonymousPanoramaResult)
      {
        paramOnPanoramaInfoLoadedListener.onPanoramaInfoLoaded(paramAnonymousPanoramaResult.getStatus().bu(), paramAnonymousPanoramaResult.getViewerIntent());
      }
    }, paramUri, false);
  }
  
  public void loadPanoramaInfoAndGrantAccess(final OnPanoramaInfoLoadedListener paramOnPanoramaInfoLoadedListener, Uri paramUri)
  {
    this.Di.a(new a.c()
    {
      public void a(Panorama.PanoramaResult paramAnonymousPanoramaResult)
      {
        paramOnPanoramaInfoLoadedListener.onPanoramaInfoLoaded(paramAnonymousPanoramaResult.getStatus().bu(), paramAnonymousPanoramaResult.getViewerIntent());
      }
    }, paramUri, true);
  }
  
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.Di.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.Di.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.Di.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.Di.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public static abstract interface OnPanoramaInfoLoadedListener
  {
    public abstract void onPanoramaInfoLoaded(ConnectionResult paramConnectionResult, Intent paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/panorama/PanoramaClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */