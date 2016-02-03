package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.d.e;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q
  extends com.google.android.gms.common.internal.d<ab>
{
  private final String Dd;
  private final String IH;
  private final Bundle Os;
  private final boolean Ot;
  private DriveId Ou;
  private DriveId Ov;
  final GoogleApiClient.ConnectionCallbacks Ow;
  final Map<DriveId, Map<c, y>> Ox = new HashMap();
  
  public q(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString, Bundle paramBundle)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.Dd = ((String)n.b(paramClientSettings.getAccountNameOrDefault(), "Must call Api.ClientBuilder.setAccountName()"));
    this.IH = paramClientSettings.getRealClientPackageName();
    this.Ow = paramConnectionCallbacks;
    this.Os = paramBundle;
    paramLooper = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
    paramLooper.setPackage(paramContext.getPackageName());
    paramContext = paramContext.getPackageManager().queryIntentServices(paramLooper, 0);
    switch (paramContext.size())
    {
    default: 
      throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + paramLooper.getAction() + " action");
    case 0: 
      this.Ot = false;
      return;
    }
    paramContext = ((ResolveInfo)paramContext.get(0)).serviceInfo;
    if (!paramContext.exported) {
      throw new IllegalStateException("Drive event service " + paramContext.name + " must be exported in AndroidManifest.xml");
    }
    this.Ot = true;
  }
  
  protected ab T(IBinder paramIBinder)
  {
    return ab.a.U(paramIBinder);
  }
  
  PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt)
  {
    n.b(com.google.android.gms.drive.events.d.a(paramInt, paramDriveId), "id");
    n.i("eventService");
    n.a(isConnected(), "Client must be connected");
    if (!this.Ot) {
      throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }
    paramGoogleApiClient.b(new p.a()
    {
      protected void a(q paramAnonymousq)
        throws RemoteException
      {
        paramAnonymousq.hY().a(new AddEventListenerRequest(paramDriveId, paramInt), null, null, new bb(this));
      }
    });
  }
  
  PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt, final c paramc)
  {
    n.b(com.google.android.gms.drive.events.d.a(paramInt, paramDriveId), "id");
    n.b(paramc, "listener");
    n.a(isConnected(), "Client must be connected");
    for (;;)
    {
      synchronized (this.Ox)
      {
        Object localObject = (Map)this.Ox.get(paramDriveId);
        if (localObject == null)
        {
          localObject = new HashMap();
          this.Ox.put(paramDriveId, localObject);
          y localy = (y)((Map)localObject).get(paramc);
          if (localy == null)
          {
            localy = new y(getLooper(), getContext(), paramInt, paramc);
            ((Map)localObject).put(paramc, localy);
            paramc = localy;
            paramc.bq(paramInt);
            paramGoogleApiClient = paramGoogleApiClient.b(new p.a()
            {
              protected void a(q paramAnonymousq)
                throws RemoteException
              {
                paramAnonymousq.hY().a(new AddEventListenerRequest(paramDriveId, paramInt), paramc, null, new bb(this));
              }
            });
            return paramGoogleApiClient;
          }
          paramc = localy;
          if (localy.br(paramInt))
          {
            paramGoogleApiClient = new o.m(paramGoogleApiClient, Status.Jo);
            return paramGoogleApiClient;
          }
        }
      }
    }
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.Ou = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.root_id"));
      this.Ov = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.appdata_id"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  protected void a(k paramk, d.e parame)
    throws RemoteException
  {
    String str = getContext().getPackageName();
    n.i(parame);
    n.i(str);
    n.i(gR());
    Bundle localBundle = new Bundle();
    if (!str.equals(this.IH)) {
      localBundle.putString("proxy_package_name", this.IH);
    }
    localBundle.putAll(this.Os);
    paramk.a(parame, 6111000, str, gR(), this.Dd, localBundle);
  }
  
  PendingResult<Status> b(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt)
  {
    n.b(com.google.android.gms.drive.events.d.a(paramInt, paramDriveId), "id");
    n.i("eventService");
    n.a(isConnected(), "Client must be connected");
    paramGoogleApiClient.b(new p.a()
    {
      protected void a(q paramAnonymousq)
        throws RemoteException
      {
        paramAnonymousq.hY().a(new RemoveEventListenerRequest(paramDriveId, paramInt), null, null, new bb(this));
      }
    });
  }
  
  PendingResult<Status> b(GoogleApiClient paramGoogleApiClient, final DriveId paramDriveId, final int paramInt, final c paramc)
  {
    n.b(com.google.android.gms.drive.events.d.a(paramInt, paramDriveId), "id");
    n.a(isConnected(), "Client must be connected");
    n.b(paramc, "listener");
    Map localMap2;
    synchronized (this.Ox)
    {
      localMap2 = (Map)this.Ox.get(paramDriveId);
      if (localMap2 == null)
      {
        paramGoogleApiClient = new o.m(paramGoogleApiClient, Status.Jo);
        return paramGoogleApiClient;
      }
      paramc = (y)localMap2.remove(paramc);
      if (paramc == null)
      {
        paramGoogleApiClient = new o.m(paramGoogleApiClient, Status.Jo);
        return paramGoogleApiClient;
      }
    }
    if (localMap2.isEmpty()) {
      this.Ox.remove(paramDriveId);
    }
    paramGoogleApiClient = paramGoogleApiClient.b(new p.a()
    {
      protected void a(q paramAnonymousq)
        throws RemoteException
      {
        paramAnonymousq.hY().a(new RemoveEventListenerRequest(paramDriveId, paramInt), paramc, null, new bb(this));
      }
    });
    return paramGoogleApiClient;
  }
  
  public void disconnect()
  {
    ab localab = (ab)gS();
    if (localab != null) {}
    try
    {
      localab.a(new DisconnectRequest());
      super.disconnect();
      this.Ox.clear();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.drive.internal.IDriveService";
  }
  
  protected String getStartServiceAction()
  {
    return "com.google.android.gms.drive.ApiService.START";
  }
  
  public ab hY()
  {
    return (ab)gS();
  }
  
  public DriveId hZ()
  {
    return this.Ou;
  }
  
  public DriveId ia()
  {
    return this.Ov;
  }
  
  public boolean ib()
  {
    return this.Ot;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/internal/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */