package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.d.e;
import com.google.android.gms.common.internal.k;

public class hy
  extends d<hv>
{
  public hy(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
  }
  
  protected hv H(IBinder paramIBinder)
  {
    return hv.a.F(paramIBinder);
  }
  
  protected void a(k paramk, d.e parame)
    throws RemoteException
  {
    paramk.b(parame, 6111000, getContext().getPackageName());
  }
  
  public hv fo()
  {
    return (hv)gS();
  }
  
  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
  }
  
  protected String getStartServiceAction()
  {
    return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/hy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */