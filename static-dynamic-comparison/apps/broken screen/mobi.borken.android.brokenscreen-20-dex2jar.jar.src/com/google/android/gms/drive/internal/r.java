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
import com.google.android.gms.drive.events.b;
import com.google.android.gms.internal.gz;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hc.e;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.hn;
import java.util.HashMap;
import java.util.Map;

public class r
  extends hc<aa>
{
  private final String IN;
  private final Bundle IO;
  private DriveId IP;
  private DriveId IQ;
  final GoogleApiClient.ConnectionCallbacks IR;
  Map<DriveId, Map<DriveEvent.Listener<?>, x<?>>> IS = new HashMap();
  private final String yN;
  
  public r(Context paramContext, Looper paramLooper, gz paramgz, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString, Bundle paramBundle)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.yN = ((String)hn.b(paramgz.fe(), "Must call Api.ClientBuilder.setAccountName()"));
    this.IN = paramgz.fi();
    this.IR = paramConnectionCallbacks;
    this.IO = paramBundle;
  }
  
  protected aa O(IBinder paramIBinder)
  {
    return aa.a.P(paramIBinder);
  }
  
  <C extends DriveEvent> PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt, DriveEvent.Listener<C> paramListener)
  {
    hn.b(b.a(paramInt, paramDriveId), "id");
    hn.b(paramListener, "listener");
    hn.a(isConnected(), "Client must be connected");
    synchronized (this.IS)
    {
      final Object localObject2 = (Map)this.IS.get(paramDriveId);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashMap();
        this.IS.put(paramDriveId, localObject1);
      }
      if (((Map)localObject1).containsKey(paramListener))
      {
        paramGoogleApiClient = new p.k(paramGoogleApiClient, Status.Ek);
        return paramGoogleApiClient;
      }
      localObject2 = new x(getLooper(), paramInt, paramListener);
      ((Map)localObject1).put(paramListener, localObject2);
      paramGoogleApiClient = paramGoogleApiClient.b(new p.j()
      {
        protected void a(r paramAnonymousr)
          throws RemoteException
        {
          paramAnonymousr.gk().a(new AddEventListenerRequest(paramDriveId, paramInt, null), localObject2, null, new aw(this));
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
      this.IP = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.root_id"));
      this.IQ = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.appdata_id"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    String str = getContext().getPackageName();
    hn.f(parame);
    hn.f(str);
    hn.f(fn());
    Bundle localBundle = new Bundle();
    localBundle.putString("proxy_package_name", this.IN);
    localBundle.putAll(this.IO);
    paramhj.a(parame, 5077000, str, fn(), this.yN, localBundle);
  }
  
  PendingResult<Status> b(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt, final DriveEvent.Listener<?> paramListener)
  {
    hn.b(b.a(paramInt, paramDriveId), "id");
    hn.a(isConnected(), "Client must be connected");
    hn.b(paramListener, "listener");
    Map localMap2;
    synchronized (this.IS)
    {
      localMap2 = (Map)this.IS.get(paramDriveId);
      if (localMap2 == null)
      {
        paramGoogleApiClient = new p.k(paramGoogleApiClient, Status.Ek);
        return paramGoogleApiClient;
      }
      paramListener = (x)localMap2.remove(paramListener);
      if (paramListener == null)
      {
        paramGoogleApiClient = new p.k(paramGoogleApiClient, Status.Ek);
        return paramGoogleApiClient;
      }
    }
    if (localMap2.isEmpty()) {
      this.IS.remove(paramDriveId);
    }
    paramGoogleApiClient = paramGoogleApiClient.b(new p.j()
    {
      protected void a(r paramAnonymousr)
        throws RemoteException
      {
        paramAnonymousr.gk().a(new RemoveEventListenerRequest(paramDriveId, paramInt), paramListener, null, new aw(this));
      }
    });
    return paramGoogleApiClient;
  }
  
  protected String bp()
  {
    return "com.google.android.gms.drive.ApiService.START";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.drive.internal.IDriveService";
  }
  
  public void disconnect()
  {
    aa localaa = (aa)fo();
    if (localaa != null) {}
    try
    {
      localaa.a(new DisconnectRequest());
      super.disconnect();
      this.IS.clear();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public aa gk()
  {
    return (aa)fo();
  }
  
  public DriveId gl()
  {
    return this.IP;
  }
  
  public DriveId gm()
  {
    return this.IQ;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */