package com.google.android.gms.common.api;

import android.content.Context;
import com.google.android.gms.internal.dt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api
{
  private final b<?> mS;
  private final ArrayList<Scope> mT;
  
  public Api(b<?> paramb, Scope... paramVarArgs)
  {
    this.mS = paramb;
    this.mT = new ArrayList(Arrays.asList(paramVarArgs));
  }
  
  public b<?> bj()
  {
    return this.mS;
  }
  
  public List<Scope> bk()
  {
    return this.mT;
  }
  
  public static abstract interface a
  {
    public abstract void connect();
    
    public abstract void disconnect();
    
    public abstract boolean isConnected();
  }
  
  public static abstract interface b<T extends Api.a>
  {
    public abstract T b(Context paramContext, dt paramdt, GoogleApiClient.ApiOptions paramApiOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
    
    public abstract int getPriority();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/common/api/Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */