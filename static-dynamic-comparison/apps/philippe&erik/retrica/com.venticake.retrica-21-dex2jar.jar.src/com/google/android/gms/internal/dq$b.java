package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

public final class dq$b
  extends dq
  implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener
{
  private final Object ls = new Object();
  private final dp.a pT;
  private final dr pU;
  
  public dq$b(Context paramContext, ds paramds, dp.a parama)
  {
    super(paramds, parama);
    this.pT = parama;
    this.pU = new dr(paramContext, this, this, paramds.kQ.sy);
    this.pU.connect();
  }
  
  public void bs()
  {
    synchronized (this.ls)
    {
      if ((this.pU.isConnected()) || (this.pU.isConnecting())) {
        this.pU.disconnect();
      }
      return;
    }
  }
  
  public dw bt()
  {
    synchronized (this.ls)
    {
      try
      {
        dw localdw = this.pU.bw();
        return localdw;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        return null;
      }
    }
  }
  
  public void onConnected(Bundle paramBundle)
  {
    start();
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.pT.a(new du(0));
  }
  
  public void onDisconnected()
  {
    eu.z("Disconnected from remote ad request service.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dq$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */