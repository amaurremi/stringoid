package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.d.e;
import com.google.android.gms.common.internal.k;

public class nc
  extends d<na>
{
  public nc(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])null);
  }
  
  protected void a(k paramk, d.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paramk.a(parame, 6111000, getContext().getPackageName(), localBundle);
  }
  
  public na bB(IBinder paramIBinder)
  {
    return na.a.bA(paramIBinder);
  }
  
  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.panorama.internal.IPanoramaService";
  }
  
  protected String getStartServiceAction()
  {
    return "com.google.android.gms.panorama.service.START";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/nc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */