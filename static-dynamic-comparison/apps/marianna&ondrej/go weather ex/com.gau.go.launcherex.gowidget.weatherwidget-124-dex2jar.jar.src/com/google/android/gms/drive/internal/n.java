package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.events.c;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.ff.e;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fq;
import java.util.HashMap;
import java.util.Map;

public class n
  extends ff<u>
{
  private DriveId Fh;
  private DriveId Fi;
  final GoogleApiClient.ConnectionCallbacks Fj;
  Map<DriveId, Map<DriveEvent.Listener<?>, s<?>>> Fk = new HashMap();
  private final String wG;
  
  public n(Context paramContext, Looper paramLooper, fc paramfc, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.wG = ((String)fq.b(paramfc.eC(), "Must call Api.ClientBuilder.setAccountName()"));
    this.Fj = paramConnectionCallbacks;
  }
  
  protected u F(IBinder paramIBinder)
  {
    return u.a.G(paramIBinder);
  }
  
  <C extends DriveEvent> PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt, DriveEvent.Listener<C> paramListener)
  {
    fq.b(c.a(paramInt, paramDriveId), "id");
    fq.b(paramListener, "listener");
    fq.a(isConnected(), "Client must be connected");
    synchronized (this.Fk)
    {
      final Object localObject2 = (Map)this.Fk.get(paramDriveId);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashMap();
        this.Fk.put(paramDriveId, localObject1);
      }
      if (((Map)localObject1).containsKey(paramListener))
      {
        paramGoogleApiClient = new l.k(paramGoogleApiClient, Status.Bv);
        return paramGoogleApiClient;
      }
      localObject2 = new s(getLooper(), paramInt, paramListener);
      ((Map)localObject1).put(paramListener, localObject2);
      paramGoogleApiClient = paramGoogleApiClient.b(new l.j()
      {
        protected void a(n paramAnonymousn)
          throws RemoteException
        {
          paramAnonymousn.fE().a(new AddEventListenerRequest(paramDriveId, paramInt, null), localObject2, null, new al(this));
        }
      });
      return paramGoogleApiClient;
    }
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.Fh = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.root_id"));
      this.Fi = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.appdata_id"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  protected void a(fm paramfm, ff.e parame)
    throws RemoteException
  {
    String str = getContext().getPackageName();
    fq.f(parame);
    fq.f(str);
    fq.f(eL());
    paramfm.a(parame, 4452000, str, eL(), this.wG, new Bundle());
  }
  
  PendingResult<Status> b(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt, final DriveEvent.Listener<?> paramListener)
  {
    fq.b(c.a(paramInt, paramDriveId), "id");
    fq.b(paramListener, "listener");
    fq.a(isConnected(), "Client must be connected");
    Map localMap2;
    synchronized (this.Fk)
    {
      localMap2 = (Map)this.Fk.get(paramDriveId);
      if (localMap2 == null)
      {
        paramGoogleApiClient = new l.k(paramGoogleApiClient, Status.Bv);
        return paramGoogleApiClient;
      }
      paramListener = (s)localMap2.remove(paramListener);
      if (paramListener == null)
      {
        paramGoogleApiClient = new l.k(paramGoogleApiClient, Status.Bv);
        return paramGoogleApiClient;
      }
    }
    if (localMap2.isEmpty()) {
      this.Fk.remove(paramDriveId);
    }
    paramGoogleApiClient = paramGoogleApiClient.b(new l.j()
    {
      protected void a(n paramAnonymousn)
        throws RemoteException
      {
        paramAnonymousn.fE().a(new RemoveEventListenerRequest(paramDriveId, paramInt), paramListener, null, new al(this));
      }
    });
    return paramGoogleApiClient;
  }
  
  protected String bg()
  {
    return "com.google.android.gms.drive.ApiService.START";
  }
  
  protected String bh()
  {
    return "com.google.android.gms.drive.internal.IDriveService";
  }
  
  public void disconnect()
  {
    u localu = (u)eM();
    if (localu != null) {}
    try
    {
      localu.a(new DisconnectRequest());
      super.disconnect();
      this.Fk.clear();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public u fE()
  {
    return (u)eM();
  }
  
  public DriveId fF()
  {
    return this.Fh;
  }
  
  public DriveId fG()
  {
    return this.Fi;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/internal/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */