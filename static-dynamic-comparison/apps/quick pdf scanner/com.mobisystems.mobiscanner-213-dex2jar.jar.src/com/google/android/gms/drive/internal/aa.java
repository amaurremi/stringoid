package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.api.c.d;
import com.google.android.gms.common.api.d;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.a;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.cs.d;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.dc;
import com.google.android.gms.internal.ee;
import java.util.HashMap;
import java.util.Map;

public class aa
  extends cs<ah>
{
  private final String qS;
  private DriveId tA;
  private DriveId tB;
  final c.c tC;
  Map<DriveId, Map<DriveEvent.a<?>, af<?>>> tD = new HashMap();
  
  public aa(Context paramContext, Looper paramLooper, ee paramee, c.c paramc, c.d paramd, String[] paramArrayOfString)
  {
    super(paramContext, paramLooper, paramc, paramd, paramArrayOfString);
    this.qS = ((String)dc.e(paramee.qi(), "Must call Api.ClientBuilder.setAccountName()"));
    this.tC = paramc;
  }
  
  <C extends DriveEvent> d<Status> a(com.google.android.gms.common.api.c paramc, final DriveId paramDriveId, final int paramInt, DriveEvent.a<C> parama)
  {
    dc.b(com.google.android.gms.drive.events.c.a(paramInt, paramDriveId), "id");
    dc.e(parama, "listener");
    dc.a(isConnected(), "Client must be connected");
    synchronized (this.tD)
    {
      final Object localObject2 = (Map)this.tD.get(paramDriveId);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashMap();
        this.tD.put(paramDriveId, localObject1);
      }
      if (((Map)localObject1).containsKey(parama))
      {
        paramc = new y.h(Status.rc);
        return paramc;
      }
      localObject2 = new af(getLooper(), paramInt, parama);
      ((Map)localObject1).put(parama, localObject2);
      paramc = paramc.b(new y.g()
      {
        protected void a(aa paramAnonymousaa)
        {
          paramAnonymousaa.nn().a(new AddEventListenerRequest(paramDriveId, paramInt), localObject2, null, new l(this));
        }
      });
      return paramc;
    }
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.tA = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.root_id"));
      this.tB = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.appdata_id"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  protected void a(cx paramcx, cs.d paramd)
  {
    String str = getContext().getPackageName();
    dc.N(paramd);
    dc.N(str);
    dc.N(qq());
    paramcx.a(paramd, 4323000, str, qq(), this.qS, new Bundle());
  }
  
  protected ah c(IBinder paramIBinder)
  {
    return ah.a.e(paramIBinder);
  }
  
  public void disconnect()
  {
    ah localah = (ah)qr();
    if (localah != null) {}
    try
    {
      localah.a(new DisconnectRequest());
      super.disconnect();
      this.tD.clear();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  protected String nl()
  {
    return "com.google.android.gms.drive.internal.IDriveService";
  }
  
  protected String nm()
  {
    return "com.google.android.gms.drive.ApiService.START";
  }
  
  public ah nn()
  {
    return (ah)qr();
  }
  
  public DriveId no()
  {
    return this.tA;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */