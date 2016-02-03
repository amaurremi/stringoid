package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

public class dr
  extends hb<dw>
{
  final int pV;
  
  public dr(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.pV = paramInt;
  }
  
  protected void a(hi paramhi, hb.e parame)
  {
    Bundle localBundle = new Bundle();
    paramhi.g(parame, this.pV, getContext().getPackageName(), localBundle);
  }
  
  protected String bu()
  {
    return "com.google.android.gms.ads.service.START";
  }
  
  protected String bv()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }
  
  public dw bw()
  {
    return (dw)super.ft();
  }
  
  protected dw w(IBinder paramIBinder)
  {
    return dw.a.y(paramIBinder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */