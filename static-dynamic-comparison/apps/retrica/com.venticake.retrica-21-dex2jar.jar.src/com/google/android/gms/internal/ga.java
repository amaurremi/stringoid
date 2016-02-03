package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;

public final class ga
  extends hb<gc>
{
  private final String yQ;
  
  public ga(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, String[] paramArrayOfString)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.yQ = ((String)hm.f(paramString));
  }
  
  protected gc D(IBinder paramIBinder)
  {
    return gc.a.F(paramIBinder);
  }
  
  public void a(a.d<AppStateManager.StateListResult> paramd)
  {
    try
    {
      ((gc)ft()).a(new ob(paramd));
      return;
    }
    catch (RemoteException paramd)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  public void a(a.d<AppStateManager.StateDeletedResult> paramd, int paramInt)
  {
    try
    {
      ((gc)ft()).b(new nz(paramd), paramInt);
      return;
    }
    catch (RemoteException paramd)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  public void a(a.d<AppStateManager.StateResult> paramd, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      ((gc)ft()).a(new od(paramd), paramInt, paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramd)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  public void a(a.d<AppStateManager.StateResult> paramd, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramd == null) {}
    for (paramd = null;; paramd = new od(paramd)) {
      try
      {
        ((gc)ft()).a(paramd, paramInt, paramArrayOfByte);
        return;
      }
      catch (RemoteException paramd)
      {
        Log.w("AppStateClient", "service died");
      }
    }
  }
  
  protected void a(hi paramhi, hb.e parame)
  {
    paramhi.a(parame, 5089000, getContext().getPackageName(), this.yQ, fs());
  }
  
  public void b(a.d<Status> paramd)
  {
    try
    {
      ((gc)ft()).b(new of(paramd));
      return;
    }
    catch (RemoteException paramd)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  public void b(a.d<AppStateManager.StateResult> paramd, int paramInt)
  {
    try
    {
      ((gc)ft()).a(new od(paramd), paramInt);
      return;
    }
    catch (RemoteException paramd)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  protected void b(String... paramVarArgs)
  {
    int i = 0;
    boolean bool = false;
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i].equals("https://www.googleapis.com/auth/appstate")) {
        bool = true;
      }
      i += 1;
    }
    hm.a(bool, String.format("App State APIs requires %s to function.", new Object[] { "https://www.googleapis.com/auth/appstate" }));
  }
  
  protected String bu()
  {
    return "com.google.android.gms.appstate.service.START";
  }
  
  protected String bv()
  {
    return "com.google.android.gms.appstate.internal.IAppStateService";
  }
  
  public int dU()
  {
    try
    {
      int i = ((gc)ft()).dU();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AppStateClient", "service died");
    }
    return 2;
  }
  
  public int dV()
  {
    try
    {
      int i = ((gc)ft()).dV();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AppStateClient", "service died");
    }
    return 2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */