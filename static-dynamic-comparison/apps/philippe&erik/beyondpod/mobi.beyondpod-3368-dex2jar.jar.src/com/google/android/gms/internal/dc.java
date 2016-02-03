package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.data.DataHolder;

public final class dc
  extends dw<de>
{
  private final String jG;
  
  @Deprecated
  public dc(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, String[] paramArrayOfString)
  {
    this(paramContext, new dw.c(paramConnectionCallbacks), new dw.g(paramOnConnectionFailedListener), paramString, paramArrayOfString);
  }
  
  public dc(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, String[] paramArrayOfString)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.jG = ((String)eg.f(paramString));
  }
  
  public void a(a.c<AppStateManager.StateListResult> paramc)
  {
    try
    {
      ((de)bQ()).a(new c(paramc));
      return;
    }
    catch (RemoteException paramc)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  public void a(a.c<AppStateManager.StateDeletedResult> paramc, int paramInt)
  {
    try
    {
      ((de)bQ()).b(new a(paramc), paramInt);
      return;
    }
    catch (RemoteException paramc)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  public void a(a.c<AppStateManager.StateResult> paramc, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      ((de)bQ()).a(new e(paramc), paramInt, paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramc)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  public void a(a.c<AppStateManager.StateResult> paramc, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramc == null) {}
    for (paramc = null;; paramc = new e(paramc)) {
      try
      {
        ((de)bQ()).a(paramc, paramInt, paramArrayOfByte);
        return;
      }
      catch (RemoteException paramc)
      {
        Log.w("AppStateClient", "service died");
      }
    }
  }
  
  protected void a(ec paramec, dw.e parame)
    throws RemoteException
  {
    paramec.a(parame, 4242000, getContext().getPackageName(), this.jG, bO());
  }
  
  protected void a(String... paramVarArgs)
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
    eg.a(bool, String.format("App State APIs requires %s to function.", new Object[] { "https://www.googleapis.com/auth/appstate" }));
  }
  
  protected String am()
  {
    return "com.google.android.gms.appstate.service.START";
  }
  
  protected String an()
  {
    return "com.google.android.gms.appstate.internal.IAppStateService";
  }
  
  public void b(a.c<Status> paramc)
  {
    try
    {
      ((de)bQ()).b(new g(paramc));
      return;
    }
    catch (RemoteException paramc)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  public void b(a.c<AppStateManager.StateResult> paramc, int paramInt)
  {
    try
    {
      ((de)bQ()).a(new e(paramc), paramInt);
      return;
    }
    catch (RemoteException paramc)
    {
      Log.w("AppStateClient", "service died");
    }
  }
  
  public int getMaxNumKeys()
  {
    try
    {
      int i = ((de)bQ()).getMaxNumKeys();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AppStateClient", "service died");
    }
    return 2;
  }
  
  public int getMaxStateSize()
  {
    try
    {
      int i = ((de)bQ()).getMaxStateSize();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AppStateClient", "service died");
    }
    return 2;
  }
  
  protected de r(IBinder paramIBinder)
  {
    return de.a.t(paramIBinder);
  }
  
  final class a
    extends db
  {
    private final a.c<AppStateManager.StateDeletedResult> jW;
    
    public a()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Result holder must not be null"));
    }
    
    public void onStateDeleted(int paramInt1, int paramInt2)
    {
      Status localStatus = new Status(paramInt1);
      dc.this.a(new dc.b(dc.this, this.jW, localStatus, paramInt2));
    }
  }
  
  final class b
    extends dw<de>.b<a.c<AppStateManager.StateDeletedResult>>
    implements AppStateManager.StateDeletedResult
  {
    private final Status jY;
    private final int jZ;
    
    public b(Status paramStatus, int paramInt)
    {
      super(paramStatus);
      this.jY = paramInt;
      int i;
      this.jZ = i;
    }
    
    protected void aL() {}
    
    public void c(a.c<AppStateManager.StateDeletedResult> paramc)
    {
      paramc.a(this);
    }
    
    public int getStateKey()
    {
      return this.jZ;
    }
    
    public Status getStatus()
    {
      return this.jY;
    }
  }
  
  final class c
    extends db
  {
    private final a.c<AppStateManager.StateListResult> jW;
    
    public c()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Result holder must not be null"));
    }
    
    public void a(DataHolder paramDataHolder)
    {
      Status localStatus = new Status(paramDataHolder.getStatusCode());
      dc.this.a(new dc.d(dc.this, this.jW, localStatus, paramDataHolder));
    }
  }
  
  final class d
    extends dw<de>.d<a.c<AppStateManager.StateListResult>>
    implements AppStateManager.StateListResult
  {
    private final Status jY;
    private final AppStateBuffer ka;
    
    public d(Status paramStatus, DataHolder paramDataHolder)
    {
      super(paramStatus, localDataHolder);
      this.jY = paramDataHolder;
      this.ka = new AppStateBuffer(localDataHolder);
    }
    
    public void a(a.c<AppStateManager.StateListResult> paramc, DataHolder paramDataHolder)
    {
      paramc.a(this);
    }
    
    public AppStateBuffer getStateBuffer()
    {
      return this.ka;
    }
    
    public Status getStatus()
    {
      return this.jY;
    }
  }
  
  final class e
    extends db
  {
    private final a.c<AppStateManager.StateResult> jW;
    
    public e()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Result holder must not be null"));
    }
    
    public void a(int paramInt, DataHolder paramDataHolder)
    {
      dc.this.a(new dc.f(dc.this, this.jW, paramInt, paramDataHolder));
    }
  }
  
  final class f
    extends dw<de>.d<a.c<AppStateManager.StateResult>>
    implements AppStateManager.StateConflictResult, AppStateManager.StateLoadedResult, AppStateManager.StateResult
  {
    private final Status jY;
    private final int jZ;
    private final AppStateBuffer ka;
    
    public f(int paramInt, DataHolder paramDataHolder)
    {
      super(paramInt, localDataHolder);
      this.jZ = paramDataHolder;
      this.jY = new Status(localDataHolder.getStatusCode());
      this.ka = new AppStateBuffer(localDataHolder);
    }
    
    private boolean aM()
    {
      return this.jY.getStatusCode() == 2000;
    }
    
    public void a(a.c<AppStateManager.StateResult> paramc, DataHolder paramDataHolder)
    {
      paramc.a(this);
    }
    
    public AppStateManager.StateConflictResult getConflictResult()
    {
      if (aM()) {
        return this;
      }
      return null;
    }
    
    public AppStateManager.StateLoadedResult getLoadedResult()
    {
      f localf = this;
      if (aM()) {
        localf = null;
      }
      return localf;
    }
    
    public byte[] getLocalData()
    {
      if (this.ka.getCount() == 0) {
        return null;
      }
      return this.ka.get(0).getLocalData();
    }
    
    public String getResolvedVersion()
    {
      if (this.ka.getCount() == 0) {
        return null;
      }
      return this.ka.get(0).getConflictVersion();
    }
    
    public byte[] getServerData()
    {
      if (this.ka.getCount() == 0) {
        return null;
      }
      return this.ka.get(0).getConflictData();
    }
    
    public int getStateKey()
    {
      return this.jZ;
    }
    
    public Status getStatus()
    {
      return this.jY;
    }
  }
  
  final class g
    extends db
  {
    a.c<Status> jW;
    
    public g()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void onSignOutComplete()
    {
      Status localStatus = new Status(0);
      dc.this.a(new dc.h(dc.this, this.jW, localStatus));
    }
  }
  
  final class h
    extends dw<de>.b<a.c<Status>>
  {
    private final Status jY;
    
    public h(Status paramStatus)
    {
      super(paramStatus);
      Status localStatus;
      this.jY = localStatus;
    }
    
    protected void aL() {}
    
    public void c(a.c<Status> paramc)
    {
      paramc.a(this.jY);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */