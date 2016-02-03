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
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class kk
  extends d<ko>
  implements kj
{
  private static final Set<String> Tm = Collections.unmodifiableSet(new HashSet() {});
  private final String Dd;
  
  public kk(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, String[] paramArrayOfString)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.Dd = paramString;
  }
  
  protected void a(k paramk, d.e parame)
    throws RemoteException
  {
    paramk.a(parame, 6111000, getContext().getPackageName(), this.Dd, gR(), new Bundle());
  }
  
  protected ko ao(IBinder paramIBinder)
  {
    return ko.a.as(paramIBinder);
  }
  
  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.fitness.internal.IGoogleFitnessService";
  }
  
  protected String getStartServiceAction()
  {
    return "com.google.android.gms.fitness.GoogleFitnessService.START";
  }
  
  public ko iT()
  {
    return (ko)gS();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/kk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */