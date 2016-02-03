package com.google.android.gms.appstate;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.internal.dc;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.eg;

@Deprecated
public final class AppStateClient
  implements GooglePlayServicesClient
{
  public static final int STATUS_CLIENT_RECONNECT_REQUIRED = 2;
  public static final int STATUS_DEVELOPER_ERROR = 7;
  public static final int STATUS_INTERNAL_ERROR = 1;
  public static final int STATUS_NETWORK_ERROR_NO_DATA = 4;
  public static final int STATUS_NETWORK_ERROR_OPERATION_DEFERRED = 5;
  public static final int STATUS_NETWORK_ERROR_OPERATION_FAILED = 6;
  public static final int STATUS_NETWORK_ERROR_STALE_DATA = 3;
  public static final int STATUS_OK = 0;
  public static final int STATUS_STATE_KEY_LIMIT_EXCEEDED = 2003;
  public static final int STATUS_STATE_KEY_NOT_FOUND = 2002;
  public static final int STATUS_WRITE_OUT_OF_DATE_VERSION = 2000;
  public static final int STATUS_WRITE_SIZE_EXCEEDED = 2001;
  private final dc jx;
  
  private AppStateClient(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, String[] paramArrayOfString)
  {
    this.jx = new dc(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, paramArrayOfString);
  }
  
  @Deprecated
  public void connect()
  {
    this.jx.connect();
  }
  
  @Deprecated
  public void deleteState(final OnStateDeletedListener paramOnStateDeletedListener, int paramInt)
  {
    this.jx.a(new a.c()
    {
      public void a(AppStateManager.StateDeletedResult paramAnonymousStateDeletedResult)
      {
        paramOnStateDeletedListener.onStateDeleted(paramAnonymousStateDeletedResult.getStatus().getStatusCode(), paramAnonymousStateDeletedResult.getStateKey());
      }
    }, paramInt);
  }
  
  @Deprecated
  public void disconnect()
  {
    this.jx.disconnect();
  }
  
  @Deprecated
  public int getMaxNumKeys()
  {
    return this.jx.getMaxNumKeys();
  }
  
  @Deprecated
  public int getMaxStateSize()
  {
    return this.jx.getMaxStateSize();
  }
  
  @Deprecated
  public boolean isConnected()
  {
    return this.jx.isConnected();
  }
  
  @Deprecated
  public boolean isConnecting()
  {
    return this.jx.isConnecting();
  }
  
  @Deprecated
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.jx.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  @Deprecated
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.jx.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void listStates(final OnStateListLoadedListener paramOnStateListLoadedListener)
  {
    this.jx.a(new a.c()
    {
      public void a(AppStateManager.StateListResult paramAnonymousStateListResult)
      {
        paramOnStateListLoadedListener.onStateListLoaded(paramAnonymousStateListResult.getStatus().getStatusCode(), paramAnonymousStateListResult.getStateBuffer());
      }
    });
  }
  
  @Deprecated
  public void loadState(OnStateLoadedListener paramOnStateLoadedListener, int paramInt)
  {
    this.jx.b(new a(paramOnStateLoadedListener), paramInt);
  }
  
  @Deprecated
  public void reconnect()
  {
    this.jx.disconnect();
    this.jx.connect();
  }
  
  @Deprecated
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.jx.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.jx.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void resolveState(OnStateLoadedListener paramOnStateLoadedListener, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.jx.a(new a(paramOnStateLoadedListener), paramInt, paramString, paramArrayOfByte);
  }
  
  @Deprecated
  public void signOut()
  {
    this.jx.b(new a.c()
    {
      public void a(Status paramAnonymousStatus) {}
    });
  }
  
  @Deprecated
  public void signOut(final OnSignOutCompleteListener paramOnSignOutCompleteListener)
  {
    eg.b(paramOnSignOutCompleteListener, "Must provide a valid listener");
    this.jx.b(new a.c()
    {
      public void a(Status paramAnonymousStatus)
      {
        paramOnSignOutCompleteListener.onSignOutComplete();
      }
    });
  }
  
  @Deprecated
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.jx.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.jx.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void updateState(int paramInt, byte[] paramArrayOfByte)
  {
    this.jx.a(new a(null), paramInt, paramArrayOfByte);
  }
  
  @Deprecated
  public void updateStateImmediate(OnStateLoadedListener paramOnStateLoadedListener, int paramInt, byte[] paramArrayOfByte)
  {
    eg.b(paramOnStateLoadedListener, "Must provide a valid listener");
    this.jx.a(new a(paramOnStateLoadedListener), paramInt, paramArrayOfByte);
  }
  
  @Deprecated
  public static final class Builder
  {
    private static final String[] jC = { "https://www.googleapis.com/auth/appstate" };
    private GooglePlayServicesClient.ConnectionCallbacks jD;
    private GooglePlayServicesClient.OnConnectionFailedListener jE;
    private String[] jF;
    private String jG;
    private Context mContext;
    
    public Builder(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.mContext = paramContext;
      this.jD = paramConnectionCallbacks;
      this.jE = paramOnConnectionFailedListener;
      this.jF = jC;
      this.jG = "<<default account>>";
    }
    
    public AppStateClient create()
    {
      return new AppStateClient(this.mContext, this.jD, this.jE, this.jG, this.jF, null);
    }
    
    public Builder setAccountName(String paramString)
    {
      this.jG = ((String)eg.f(paramString));
      return this;
    }
    
    public Builder setScopes(String... paramVarArgs)
    {
      this.jF = paramVarArgs;
      return this;
    }
  }
  
  private static final class a
    implements a.c<AppStateManager.StateResult>
  {
    private final OnStateLoadedListener jH;
    
    a(OnStateLoadedListener paramOnStateLoadedListener)
    {
      this.jH = paramOnStateLoadedListener;
    }
    
    public void a(AppStateManager.StateResult paramStateResult)
    {
      if (this.jH == null) {
        return;
      }
      if (paramStateResult.getStatus().getStatusCode() == 2000)
      {
        paramStateResult = paramStateResult.getConflictResult();
        ds.d(paramStateResult);
        this.jH.onStateConflict(paramStateResult.getStateKey(), paramStateResult.getResolvedVersion(), paramStateResult.getLocalData(), paramStateResult.getServerData());
        return;
      }
      paramStateResult = paramStateResult.getLoadedResult();
      ds.d(paramStateResult);
      this.jH.onStateLoaded(paramStateResult.getStatus().getStatusCode(), paramStateResult.getStateKey(), paramStateResult.getLocalData());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/appstate/AppStateClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */