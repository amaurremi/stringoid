package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.support.v4.app.l;
import android.support.v4.app.p;
import android.view.View;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GoogleApiClient$Builder
{
  private Looper DF;
  private final Set<String> DH = new HashSet();
  private int DI;
  private View DJ;
  private String DK;
  private final Map<Api<?>, Api.ApiOptions> DL = new HashMap();
  private h DM;
  private GoogleApiClient.OnConnectionFailedListener DN;
  private final Set<GoogleApiClient.ConnectionCallbacks> DO = new HashSet();
  private final Set<GoogleApiClient.OnConnectionFailedListener> DP = new HashSet();
  private final Context mContext;
  private String yQ;
  
  public GoogleApiClient$Builder(Context paramContext)
  {
    this.mContext = paramContext;
    this.DF = paramContext.getMainLooper();
    this.DK = paramContext.getPackageName();
  }
  
  public GoogleApiClient$Builder(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext);
    hm.b(paramConnectionCallbacks, "Must provide a connected listener");
    this.DO.add(paramConnectionCallbacks);
    hm.b(paramOnConnectionFailedListener, "Must provide a connection failed listener");
    this.DP.add(paramOnConnectionFailedListener);
  }
  
  private d eJ()
  {
    l locall = this.DM.e();
    if (locall.c() != null)
    {
      localObject = locall.c().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        if (((localFragment instanceof d)) && (localFragment.isAdded()) && (!((d)localFragment).isInitialized())) {
          return (d)localFragment;
        }
      }
    }
    Object localObject = new d();
    locall.a().a((Fragment)localObject, null).a();
    return (d)localObject;
  }
  
  public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
  {
    this.DL.put(paramApi, null);
    paramApi = paramApi.eA();
    int j = paramApi.size();
    int i = 0;
    while (i < j)
    {
      this.DH.add(((Scope)paramApi.get(i)).eP());
      i += 1;
    }
    return this;
  }
  
  public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO)
  {
    hm.b(paramO, "Null options are not permitted for this Api");
    this.DL.put(paramApi, paramO);
    paramApi = paramApi.eA();
    int j = paramApi.size();
    int i = 0;
    while (i < j)
    {
      this.DH.add(((Scope)paramApi.get(i)).eP());
      i += 1;
    }
    return this;
  }
  
  public Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.DO.add(paramConnectionCallbacks);
    return this;
  }
  
  public Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.DP.add(paramOnConnectionFailedListener);
    return this;
  }
  
  public Builder addScope(Scope paramScope)
  {
    this.DH.add(paramScope.eP());
    return this;
  }
  
  public GoogleApiClient build()
  {
    if (!this.DL.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      hm.b(bool, "must call addApi() to add at least one API");
      d locald = null;
      if (this.DM != null) {
        locald = eJ();
      }
      c localc = new c(this.mContext, this.DF, eI(), this.DL, locald, this.DO, this.DP);
      if (locald != null) {
        locald.a(localc, this.DN);
      }
      return localc;
    }
  }
  
  public gy eI()
  {
    return new gy(this.yQ, this.DH, this.DI, this.DJ, this.DK);
  }
  
  public Builder enableAutoManage(h paramh, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.DM = ((h)hm.b(paramh, "Null activity is not permitted."));
    this.DN = paramOnConnectionFailedListener;
    return this;
  }
  
  public Builder setAccountName(String paramString)
  {
    this.yQ = paramString;
    return this;
  }
  
  public Builder setGravityForPopups(int paramInt)
  {
    this.DI = paramInt;
    return this;
  }
  
  public Builder setHandler(Handler paramHandler)
  {
    hm.b(paramHandler, "Handler must not be null");
    this.DF = paramHandler.getLooper();
    return this;
  }
  
  public Builder setViewForPopups(View paramView)
  {
    this.DJ = paramView;
    return this;
  }
  
  public Builder useDefaultAccount()
  {
    return setAccountName("<<default account>>");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/api/GoogleApiClient$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */