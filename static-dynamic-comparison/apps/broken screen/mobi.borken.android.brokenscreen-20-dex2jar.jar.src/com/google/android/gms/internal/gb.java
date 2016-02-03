package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;

public final class gb
  extends hc<gd>
{
  private final String yN;
  
  public gb(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, String[] paramArrayOfString)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.yN = ((String)hn.f(paramString));
  }
  
  protected gd D(IBinder paramIBinder)
  {
    return gd.a.F(paramIBinder);
  }
  
  public void a(a.d<AppStateManager.StateListResult> paramd)
  {
    try
    {
      ((gd)fo()).a(new c(paramd));
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
      ((gd)fo()).b(new a(paramd), paramInt);
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
      ((gd)fo()).a(new e(paramd), paramInt, paramString, paramArrayOfByte);
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
    for (paramd = null;; paramd = new e(paramd)) {
      try
      {
        ((gd)fo()).a(paramd, paramInt, paramArrayOfByte);
        return;
      }
      catch (RemoteException paramd)
      {
        Log.w("AppStateClient", "service died");
      }
    }
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    paramhj.a(parame, 5077000, getContext().getPackageName(), this.yN, fn());
  }
  
  public void b(a.d<Status> paramd)
  {
    try
    {
      ((gd)fo()).b(new g(paramd));
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
      ((gd)fo()).a(new e(paramd), paramInt);
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
    hn.a(bool, String.format("App State APIs requires %s to function.", new Object[] { "https://www.googleapis.com/auth/appstate" }));
  }
  
  protected String bp()
  {
    return "com.google.android.gms.appstate.service.START";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.appstate.internal.IAppStateService";
  }
  
  public int dP()
  {
    try
    {
      int i = ((gd)fo()).dP();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AppStateClient", "service died");
    }
    return 2;
  }
  
  public int dQ()
  {
    try
    {
      int i = ((gd)fo()).dQ();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("AppStateClient", "service died");
    }
    return 2;
  }
  
  private static final class a
    extends ga
  {
    private final a.d<AppStateManager.StateDeletedResult> yO;
    
    public a(a.d<AppStateManager.StateDeletedResult> paramd)
    {
      this.yO = ((a.d)hn.b(paramd, "Result holder must not be null"));
    }
    
    public void b(int paramInt1, int paramInt2)
    {
      Status localStatus = new Status(paramInt1);
      this.yO.a(new gb.b(localStatus, paramInt2));
    }
  }
  
  private static final class b
    implements AppStateManager.StateDeletedResult
  {
    private final int yP;
    private final Status yw;
    
    public b(Status paramStatus, int paramInt)
    {
      this.yw = paramStatus;
      this.yP = paramInt;
    }
    
    public int getStateKey()
    {
      return this.yP;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
  
  private static final class c
    extends ga
  {
    private final a.d<AppStateManager.StateListResult> yO;
    
    public c(a.d<AppStateManager.StateListResult> paramd)
    {
      this.yO = ((a.d)hn.b(paramd, "Result holder must not be null"));
    }
    
    public void a(DataHolder paramDataHolder)
    {
      this.yO.a(new gb.d(paramDataHolder));
    }
  }
  
  private static final class d
    extends b
    implements AppStateManager.StateListResult
  {
    private final AppStateBuffer yQ;
    
    public d(DataHolder paramDataHolder)
    {
      super();
      this.yQ = new AppStateBuffer(paramDataHolder);
    }
    
    public AppStateBuffer getStateBuffer()
    {
      return this.yQ;
    }
  }
  
  private static final class e
    extends ga
  {
    private final a.d<AppStateManager.StateResult> yO;
    
    public e(a.d<AppStateManager.StateResult> paramd)
    {
      this.yO = ((a.d)hn.b(paramd, "Result holder must not be null"));
    }
    
    public void a(int paramInt, DataHolder paramDataHolder)
    {
      this.yO.a(new gb.f(paramInt, paramDataHolder));
    }
  }
  
  private static final class f
    extends b
    implements AppStateManager.StateConflictResult, AppStateManager.StateLoadedResult, AppStateManager.StateResult
  {
    private final int yP;
    private final AppStateBuffer yQ;
    
    public f(int paramInt, DataHolder paramDataHolder)
    {
      super();
      this.yP = paramInt;
      this.yQ = new AppStateBuffer(paramDataHolder);
    }
    
    private boolean dR()
    {
      return this.yw.getStatusCode() == 2000;
    }
    
    public AppStateManager.StateConflictResult getConflictResult()
    {
      if (dR()) {
        return this;
      }
      return null;
    }
    
    public AppStateManager.StateLoadedResult getLoadedResult()
    {
      f localf = this;
      if (dR()) {
        localf = null;
      }
      return localf;
    }
    
    public byte[] getLocalData()
    {
      if (this.yQ.getCount() == 0) {
        return null;
      }
      return this.yQ.get(0).getLocalData();
    }
    
    public String getResolvedVersion()
    {
      if (this.yQ.getCount() == 0) {
        return null;
      }
      return this.yQ.get(0).getConflictVersion();
    }
    
    public byte[] getServerData()
    {
      if (this.yQ.getCount() == 0) {
        return null;
      }
      return this.yQ.get(0).getConflictData();
    }
    
    public int getStateKey()
    {
      return this.yP;
    }
    
    public void release()
    {
      this.yQ.close();
    }
  }
  
  private static final class g
    extends ga
  {
    private final a.d<Status> yO;
    
    public g(a.d<Status> paramd)
    {
      this.yO = ((a.d)hn.b(paramd, "Holder must not be null"));
    }
    
    public void dO()
    {
      Status localStatus = new Status(0);
      this.yO.a(localStatus);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/gb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */