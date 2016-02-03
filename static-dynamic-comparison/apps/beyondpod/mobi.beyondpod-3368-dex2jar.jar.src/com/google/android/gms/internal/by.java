package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

public class by
  extends dw<cd>
{
  private final int hp;
  
  public by(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.hp = paramInt;
  }
  
  protected void a(ec paramec, dw.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paramec.g(parame, this.hp, getContext().getPackageName(), localBundle);
  }
  
  protected String am()
  {
    return "com.google.android.gms.ads.service.START";
  }
  
  protected String an()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }
  
  public cd ao()
  {
    return (cd)super.bQ();
  }
  
  protected cd o(IBinder paramIBinder)
  {
    return cd.a.q(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */