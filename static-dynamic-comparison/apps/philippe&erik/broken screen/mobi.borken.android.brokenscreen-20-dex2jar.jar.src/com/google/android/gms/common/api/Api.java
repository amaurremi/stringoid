package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.internal.gz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends ApiOptions>
{
  private final b<?, O> Dj;
  private final c<?> Dk;
  private final ArrayList<Scope> Dl;
  
  public <C extends a> Api(b<C, O> paramb, c<C> paramc, Scope... paramVarArgs)
  {
    this.Dj = paramb;
    this.Dk = paramc;
    this.Dl = new ArrayList(Arrays.asList(paramVarArgs));
  }
  
  public b<?, O> eu()
  {
    return this.Dj;
  }
  
  public List<Scope> ev()
  {
    return this.Dl;
  }
  
  public c<?> ew()
  {
    return this.Dk;
  }
  
  public static abstract interface ApiOptions
  {
    public static abstract interface HasOptions
      extends Api.ApiOptions
    {}
    
    public static final class NoOptions
      implements Api.ApiOptions.NotRequiredOptions
    {}
    
    public static abstract interface NotRequiredOptions
      extends Api.ApiOptions
    {}
    
    public static abstract interface Optional
      extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {}
  }
  
  public static abstract interface a
  {
    public abstract void connect();
    
    public abstract void disconnect();
    
    public abstract Looper getLooper();
    
    public abstract boolean isConnected();
  }
  
  public static abstract interface b<T extends Api.a, O>
  {
    public abstract T a(Context paramContext, Looper paramLooper, gz paramgz, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
    
    public abstract int getPriority();
  }
  
  public static final class c<C extends Api.a> {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/api/Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */