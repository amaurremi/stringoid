package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.d.e;
import com.google.android.gms.common.internal.k;

@ez
public class fh
  extends d<fm>
{
  final int pP;
  
  public fh(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.pP = paramInt;
  }
  
  protected fm C(IBinder paramIBinder)
  {
    return fm.a.D(paramIBinder);
  }
  
  protected void a(k paramk, d.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paramk.g(parame, this.pP, getContext().getPackageName(), localBundle);
  }
  
  public fm cF()
  {
    return (fm)super.gS();
  }
  
  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }
  
  protected String getStartServiceAction()
  {
    return "com.google.android.gms.ads.service.START";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */