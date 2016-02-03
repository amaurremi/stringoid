package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.gz;
import com.google.android.gms.internal.hn;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract interface GoogleApiClient
{
  public abstract <C extends Api.a> C a(Api.c<C> paramc);
  
  public abstract <A extends Api.a, T extends a.b<? extends Result, A>> T a(T paramT);
  
  public abstract <A extends Api.a, T extends a.b<? extends Result, A>> T b(T paramT);
  
  public abstract ConnectionResult blockingConnect();
  
  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract Looper getLooper();
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void reconnect();
  
  public abstract void registerConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void registerConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract void stopAutoManage();
  
  public abstract void unregisterConnectionCallbacks(ConnectionCallbacks paramConnectionCallbacks);
  
  public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public static final class Builder
  {
    private Looper DC;
    private final Set<String> DE = new HashSet();
    private int DF;
    private View DG;
    private String DH;
    private final Map<Api<?>, Api.ApiOptions> DI = new HashMap();
    private FragmentActivity DJ;
    private GoogleApiClient.OnConnectionFailedListener DK;
    private final Set<GoogleApiClient.ConnectionCallbacks> DL = new HashSet();
    private final Set<GoogleApiClient.OnConnectionFailedListener> DM = new HashSet();
    private final Context mContext;
    private String yN;
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
      this.DC = paramContext.getMainLooper();
      this.DH = paramContext.getPackageName();
    }
    
    public Builder(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this(paramContext);
      hn.b(paramConnectionCallbacks, "Must provide a connected listener");
      this.DL.add(paramConnectionCallbacks);
      hn.b(paramOnConnectionFailedListener, "Must provide a connection failed listener");
      this.DM.add(paramOnConnectionFailedListener);
    }
    
    private d eE()
    {
      FragmentManager localFragmentManager = this.DJ.getSupportFragmentManager();
      if (localFragmentManager.getFragments() != null)
      {
        localObject = localFragmentManager.getFragments().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Fragment localFragment = (Fragment)((Iterator)localObject).next();
          if (((localFragment instanceof d)) && (localFragment.isAdded()) && (!((d)localFragment).isInitialized())) {
            return (d)localFragment;
          }
        }
      }
      Object localObject = new d();
      localFragmentManager.beginTransaction().add((Fragment)localObject, null).commit();
      return (d)localObject;
    }
    
    public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
    {
      this.DI.put(paramApi, null);
      paramApi = paramApi.ev();
      int j = paramApi.size();
      int i = 0;
      while (i < j)
      {
        this.DE.add(((Scope)paramApi.get(i)).eK());
        i += 1;
      }
      return this;
    }
    
    public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO)
    {
      hn.b(paramO, "Null options are not permitted for this Api");
      this.DI.put(paramApi, paramO);
      paramApi = paramApi.ev();
      int j = paramApi.size();
      int i = 0;
      while (i < j)
      {
        this.DE.add(((Scope)paramApi.get(i)).eK());
        i += 1;
      }
      return this;
    }
    
    public Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      this.DL.add(paramConnectionCallbacks);
      return this;
    }
    
    public Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.DM.add(paramOnConnectionFailedListener);
      return this;
    }
    
    public Builder addScope(Scope paramScope)
    {
      this.DE.add(paramScope.eK());
      return this;
    }
    
    public GoogleApiClient build()
    {
      if (!this.DI.isEmpty()) {}
      for (boolean bool = true;; bool = false)
      {
        hn.b(bool, "must call addApi() to add at least one API");
        d locald = null;
        if (this.DJ != null) {
          locald = eE();
        }
        c localc = new c(this.mContext, this.DC, eD(), this.DI, locald, this.DL, this.DM);
        if (locald != null) {
          locald.a(localc, this.DK);
        }
        return localc;
      }
    }
    
    public gz eD()
    {
      return new gz(this.yN, this.DE, this.DF, this.DG, this.DH);
    }
    
    public Builder enableAutoManage(FragmentActivity paramFragmentActivity, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.DJ = ((FragmentActivity)hn.b(paramFragmentActivity, "Null activity is not permitted."));
      this.DK = paramOnConnectionFailedListener;
      return this;
    }
    
    public Builder setAccountName(String paramString)
    {
      this.yN = paramString;
      return this;
    }
    
    public Builder setGravityForPopups(int paramInt)
    {
      this.DF = paramInt;
      return this;
    }
    
    public Builder setHandler(Handler paramHandler)
    {
      hn.b(paramHandler, "Handler must not be null");
      this.DC = paramHandler.getLooper();
      return this;
    }
    
    public Builder setViewForPopups(View paramView)
    {
      this.DG = paramView;
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
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/api/GoogleApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */