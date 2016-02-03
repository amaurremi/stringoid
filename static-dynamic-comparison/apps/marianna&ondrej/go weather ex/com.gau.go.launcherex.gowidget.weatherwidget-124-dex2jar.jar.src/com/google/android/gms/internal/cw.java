package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

public class cw
  extends ff<db>
{
  final int pe;
  
  public cw(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.pe = paramInt;
  }
  
  protected void a(fm paramfm, ff.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paramfm.g(parame, this.pe, getContext().getPackageName(), localBundle);
  }
  
  protected String bg()
  {
    return "com.google.android.gms.ads.service.START";
  }
  
  protected String bh()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }
  
  public db bi()
  {
    return (db)super.eM();
  }
  
  protected db q(IBinder paramIBinder)
  {
    return db.a.s(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */