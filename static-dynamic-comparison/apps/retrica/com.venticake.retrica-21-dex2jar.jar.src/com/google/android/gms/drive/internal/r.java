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
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.e;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.Map;

public class r
  extends hb<aa>
{
  private final String IQ;
  private final Bundle IR;
  private DriveId IS;
  private DriveId IT;
  final GoogleApiClient.ConnectionCallbacks IU;
  Map<DriveId, Map<DriveEvent.Listener<?>, x<?>>> IV = new HashMap();
  private final String yQ;
  
  public r(Context paramContext, Looper paramLooper, gy paramgy, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString, Bundle paramBundle)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.yQ = ((String)hm.b(paramgy.fj(), "Must call Api.ClientBuilder.setAccountName()"));
    this.IQ = paramgy.fn();
    this.IU = paramConnectionCallbacks;
    this.IR = paramBundle;
  }
  
  protected aa O(IBinder paramIBinder)
  {
    return aa.a.P(paramIBinder);
  }
  
  <C extends DriveEvent> PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt, DriveEvent.Listener<C> paramListener)
  {
    hm.b(b.a(paramInt, paramDriveId), "id");
    hm.b(paramListener, "listener");
    hm.a(isConnected(), "Client must be connected");
    synchronized (this.IV)
    {
      final Object localObject2 = (Map)this.IV.get(paramDriveId);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashMap();
        this.IV.put(paramDriveId, localObject1);
      }
      if (((Map)localObject1).containsKey(paramListener))
      {
        paramGoogleApiClient = new bk(paramGoogleApiClient, Status.En);
        return paramGoogleApiClient;
      }
      localObject2 = new x(getLooper(), paramInt, paramListener);
      ((Map)localObject1).put(paramListener, localObject2);
      paramGoogleApiClient = paramGoogleApiClient.b(new bj()
      {
        protected void a(r paramAnonymousr)
        {
          paramAnonymousr.gp().a(new AddEventListenerRequest(paramDriveId, paramInt, null), localObject2, null, new aw(this));
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
      this.IS = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.root_id"));
      this.IT = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.appdata_id"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  protected void a(hi paramhi, hb.e parame)
  {
    String str = getContext().getPackageName();
    hm.f(parame);
    hm.f(str);
    hm.f(fs());
    Bundle localBundle = new Bundle();
    localBundle.putString("proxy_package_name", this.IQ);
    localBundle.putAll(this.IR);
    paramhi.a(parame, 5089000, str, fs(), this.yQ, localBundle);
  }
  
  PendingResult<Status> b(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt, final DriveEvent.Listener<?> paramListener)
  {
    hm.b(b.a(paramInt, paramDriveId), "id");
    hm.a(isConnected(), "Client must be connected");
    hm.b(paramListener, "listener");
    Map localMap2;
    synchronized (this.IV)
    {
      localMap2 = (Map)this.IV.get(paramDriveId);
      if (localMap2 == null)
      {
        paramGoogleApiClient = new bk(paramGoogleApiClient, Status.En);
        return paramGoogleApiClient;
      }
      paramListener = (x)localMap2.remove(paramListener);
      if (paramListener == null)
      {
        paramGoogleApiClient = new bk(paramGoogleApiClient, Status.En);
        return paramGoogleApiClient;
      }
    }
    if (localMap2.isEmpty()) {
      this.IV.remove(paramDriveId);
    }
    paramGoogleApiClient = paramGoogleApiClient.b(new bj()
    {
      protected void a(r paramAnonymousr)
      {
        paramAnonymousr.gp().a(new RemoveEventListenerRequest(paramDriveId, paramInt), paramListener, null, new aw(this));
      }
    });
    return paramGoogleApiClient;
  }
  
  protected String bu()
  {
    return "com.google.android.gms.drive.ApiService.START";
  }
  
  protected String bv()
  {
    return "com.google.android.gms.drive.internal.IDriveService";
  }
  
  public void disconnect()
  {
    aa localaa = (aa)ft();
    if (localaa != null) {}
    try
    {
      localaa.a(new DisconnectRequest());
      super.disconnect();
      this.IV.clear();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public aa gp()
  {
    return (aa)ft();
  }
  
  public DriveId gq()
  {
    return this.IS;
  }
  
  public DriveId gr()
  {
    return this.IT;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */