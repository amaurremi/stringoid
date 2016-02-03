package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.dx;
import com.google.android.gms.internal.dx.b;
import com.google.android.gms.internal.eg;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class GoogleApiClient
{
  private final Object mV = new Object();
  private final a nc = new a()
  {
    public void b(GoogleApiClient.b paramAnonymousb)
    {
      synchronized (GoogleApiClient.c(GoogleApiClient.this))
      {
        GoogleApiClient.this.nn.remove(paramAnonymousb);
        return;
      }
    }
  };
  private final dx ne = new dx(paramContext, this.np);
  final Queue<b<?>> nf = new LinkedList();
  private ConnectionResult ng;
  private int nh;
  private int ni = 4;
  private int nj;
  private final Bundle nk = new Bundle();
  private final Map<Api.b<?>, Api.a> nl = new HashMap();
  private boolean nm;
  final Set<b> nn = new HashSet();
  final ConnectionCallbacks no = new ConnectionCallbacks()
  {
    public void onConnected(Bundle paramAnonymousBundle)
    {
      synchronized (GoogleApiClient.c(GoogleApiClient.this))
      {
        if (GoogleApiClient.d(GoogleApiClient.this) == 1)
        {
          if (paramAnonymousBundle != null) {
            GoogleApiClient.e(GoogleApiClient.this).putAll(paramAnonymousBundle);
          }
          GoogleApiClient.f(GoogleApiClient.this);
        }
        return;
      }
    }
    
    public void onConnectionSuspended(int paramAnonymousInt)
    {
      synchronized (GoogleApiClient.c(GoogleApiClient.this))
      {
        GoogleApiClient.a(GoogleApiClient.this, paramAnonymousInt);
        if (paramAnonymousInt == 2) {
          GoogleApiClient.this.connect();
        }
        return;
      }
    }
  };
  private final dx.b np = new dx.b()
  {
    public Bundle aU()
    {
      return null;
    }
    
    public boolean bp()
    {
      return GoogleApiClient.g(GoogleApiClient.this);
    }
    
    public boolean isConnected()
    {
      return GoogleApiClient.this.isConnected();
    }
  };
  
  private GoogleApiClient(Context paramContext, dt paramdt, Map<Api, ApiOptions> paramMap, Set<ConnectionCallbacks> paramSet, final Set<OnConnectionFailedListener> paramSet1)
  {
    paramSet = paramSet.iterator();
    Object localObject;
    while (paramSet.hasNext())
    {
      localObject = (ConnectionCallbacks)paramSet.next();
      this.ne.registerConnectionCallbacks((ConnectionCallbacks)localObject);
    }
    paramSet = paramSet1.iterator();
    while (paramSet.hasNext())
    {
      paramSet1 = (OnConnectionFailedListener)paramSet.next();
      this.ne.registerConnectionFailedListener(paramSet1);
    }
    paramSet = paramMap.keySet().iterator();
    while (paramSet.hasNext())
    {
      localObject = (Api)paramSet.next();
      paramSet1 = ((Api)localObject).bj();
      localObject = (ApiOptions)paramMap.get(localObject);
      this.nl.put(paramSet1, paramSet1.b(paramContext, paramdt, (ApiOptions)localObject, this.no, new OnConnectionFailedListener()
      {
        public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
        {
          synchronized (GoogleApiClient.c(GoogleApiClient.this))
          {
            if ((GoogleApiClient.h(GoogleApiClient.this) == null) || (paramSet1.getPriority() < GoogleApiClient.i(GoogleApiClient.this)))
            {
              GoogleApiClient.a(GoogleApiClient.this, paramAnonymousConnectionResult);
              GoogleApiClient.b(GoogleApiClient.this, paramSet1.getPriority());
            }
            GoogleApiClient.f(GoogleApiClient.this);
            return;
          }
        }
      }));
    }
  }
  
  private void A(int paramInt)
  {
    boolean bool1;
    Object localObject3;
    synchronized (this.mV)
    {
      if (this.ni == 3) {
        break label242;
      }
      bool1 = isConnected();
      this.ni = 3;
      if (paramInt == -1) {
        this.nf.clear();
      }
      Iterator localIterator1 = this.nn.iterator();
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localObject3 = (b)localIterator1.next();
          boolean bool2 = localObject3 instanceof Releasable;
          if (!bool2) {
            continue;
          }
          try
          {
            ((Releasable)localObject3).release();
          }
          catch (Exception localException)
          {
            Log.w("GoogleApiClient", "Unable to release " + localObject3, localException);
          }
        }
      }
    }
    this.nn.clear();
    this.nm = false;
    Iterator localIterator2 = this.nl.values().iterator();
    while (localIterator2.hasNext())
    {
      localObject3 = (Api.a)localIterator2.next();
      if (((Api.a)localObject3).isConnected()) {
        ((Api.a)localObject3).disconnect();
      }
    }
    this.nm = true;
    this.ni = 4;
    if (bool1)
    {
      if (paramInt != -1) {
        this.ne.J(paramInt);
      }
      this.nm = false;
    }
    label242:
  }
  
  private <A extends Api.a> void a(b<A> paramb)
  {
    for (;;)
    {
      synchronized (this.mV)
      {
        eg.a(isConnected(), "GoogleApiClient is not connected yet.");
        if (paramb.bj() != null)
        {
          bool = true;
          eg.a(bool, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
          if ((paramb instanceof Releasable))
          {
            this.nn.add(paramb);
            paramb.a(this.nc);
          }
          paramb.b(a(paramb.bj()));
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  private void bn()
  {
    for (;;)
    {
      synchronized (this.mV)
      {
        this.nj -= 1;
        if (this.nj == 0)
        {
          if (this.ng != null)
          {
            A(3);
            this.ne.a(this.ng);
            this.nm = false;
          }
        }
        else {
          return;
        }
        this.ni = 2;
        bo();
        if (this.nk.isEmpty())
        {
          Bundle localBundle1 = null;
          this.ne.b(localBundle1);
        }
      }
      Bundle localBundle2 = this.nk;
    }
  }
  
  private void bo()
  {
    eg.a(isConnected(), "GoogleApiClient is not connected yet.");
    synchronized (this.mV)
    {
      if (!this.nf.isEmpty()) {
        a((b)this.nf.remove());
      }
    }
  }
  
  public <C extends Api.a> C a(Api.b<C> paramb)
  {
    paramb = (Api.a)this.nl.get(paramb);
    eg.b(paramb, "Appropriate Api was not requested.");
    return paramb;
  }
  
  public <A extends Api.a, T extends a.a<? extends Result, A>> T a(T paramT)
  {
    synchronized (this.mV)
    {
      if (isConnected())
      {
        b(paramT);
        return paramT;
      }
      this.nf.add(paramT);
    }
  }
  
  public <A extends Api.a, T extends a.a<? extends Result, A>> T b(T paramT)
  {
    eg.a(isConnected(), "GoogleApiClient is not connected yet.");
    bo();
    a(paramT);
    return paramT;
  }
  
  public void connect()
  {
    synchronized (this.mV)
    {
      if ((isConnected()) || (isConnecting())) {
        return;
      }
      this.nm = true;
      this.ng = null;
      this.ni = 1;
      this.nk.clear();
      this.nj = this.nl.size();
      Iterator localIterator = this.nl.values().iterator();
      if (localIterator.hasNext()) {
        ((Api.a)localIterator.next()).connect();
      }
    }
  }
  
  public void disconnect()
  {
    A(-1);
  }
  
  public boolean isConnected()
  {
    for (;;)
    {
      synchronized (this.mV)
      {
        if (this.ni == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isConnecting()
  {
    for (boolean bool = true;; bool = false) {
      synchronized (this.mV)
      {
        if (this.ni == 1) {
          return bool;
        }
      }
    }
  }
  
  public boolean isConnectionCallbacksRegistered(ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.ne.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.ne.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void reconnect()
  {
    disconnect();
    connect();
  }
  
  public void registerConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks)
  {
    this.ne.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.ne.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void unregisterConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks)
  {
    this.ne.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.ne.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public static abstract interface ApiOptions {}
  
  public static final class Builder
  {
    private String jG;
    private final Context mContext;
    private final Set<String> ns = new HashSet();
    private int nt;
    private View nu;
    private String nv;
    private final Map<Api, GoogleApiClient.ApiOptions> nw = new HashMap();
    private final Set<GoogleApiClient.ConnectionCallbacks> nx = new HashSet();
    private final Set<GoogleApiClient.OnConnectionFailedListener> ny = new HashSet();
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
      this.nv = paramContext.getPackageName();
    }
    
    public Builder(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this(paramContext);
      eg.b(paramConnectionCallbacks, "Must provide a connected listener");
      this.nx.add(paramConnectionCallbacks);
      eg.b(paramOnConnectionFailedListener, "Must provide a connection failed listener");
      this.ny.add(paramOnConnectionFailedListener);
    }
    
    public Builder addApi(Api paramApi)
    {
      return addApi(paramApi, null);
    }
    
    public Builder addApi(Api paramApi, GoogleApiClient.ApiOptions paramApiOptions)
    {
      this.nw.put(paramApi, paramApiOptions);
      paramApi = paramApi.bk();
      int j = paramApi.size();
      int i = 0;
      while (i < j)
      {
        this.ns.add(((Scope)paramApi.get(i)).br());
        i += 1;
      }
      return this;
    }
    
    public Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      this.nx.add(paramConnectionCallbacks);
      return this;
    }
    
    public Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.ny.add(paramOnConnectionFailedListener);
      return this;
    }
    
    public Builder addScope(Scope paramScope)
    {
      this.ns.add(paramScope.br());
      return this;
    }
    
    public dt bq()
    {
      return new dt(this.jG, this.ns, this.nt, this.nu, this.nv);
    }
    
    public GoogleApiClient build()
    {
      return new GoogleApiClient(this.mContext, bq(), this.nw, this.nx, this.ny, null);
    }
    
    public Builder setAccountName(String paramString)
    {
      this.jG = paramString;
      return this;
    }
    
    public Builder setGravityForPopups(int paramInt)
    {
      this.nt = paramInt;
      return this;
    }
    
    public Builder setViewForPopups(View paramView)
    {
      this.nu = paramView;
      return this;
    }
    
    public Builder useDefaultAccount()
    {
      return setAccountName("<<default account>>");
    }
  }
  
  public static abstract interface ConnectionCallbacks
  {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    
    public abstract void onConnected(Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface OnConnectionFailedListener
    extends GooglePlayServicesClient.OnConnectionFailedListener
  {}
  
  public static abstract interface a
  {
    public abstract void b(GoogleApiClient.b paramb);
  }
  
  public static abstract interface b<A extends Api.a>
  {
    public abstract void a(GoogleApiClient.a parama);
    
    public abstract void b(A paramA);
    
    public abstract Api.b<A> bj();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/common/api/GoogleApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */