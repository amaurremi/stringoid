package com.google.android.gms.plus;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.hs;
import com.google.android.gms.internal.hu;
import com.google.android.gms.internal.hx;
import com.google.android.gms.internal.hy;
import com.google.android.gms.internal.hz;
import com.google.android.gms.internal.ia;
import java.util.HashSet;
import java.util.Set;

public final class Plus
{
  public static final Api API;
  public static final Account AccountApi = new hx(jO);
  public static final a Dr = new hy(jO);
  public static final Moments MomentsApi;
  public static final People PeopleApi;
  public static final Scope SCOPE_PLUS_LOGIN;
  public static final Scope SCOPE_PLUS_PROFILE;
  static final Api.b<hs> jO = new Api.b()
  {
    public hs g(Context paramAnonymousContext, dt paramAnonymousdt, GoogleApiClient.ApiOptions paramAnonymousApiOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      Object localObject = new Plus.PlusOptions(null);
      if (paramAnonymousApiOptions != null) {
        eg.b(paramAnonymousApiOptions instanceof Plus.PlusOptions, "Must provide valid PlusOptions!");
      }
      for (paramAnonymousApiOptions = (Plus.PlusOptions)paramAnonymousApiOptions;; paramAnonymousApiOptions = (GoogleApiClient.ApiOptions)localObject)
      {
        localObject = paramAnonymousdt.bF();
        paramAnonymousdt = paramAnonymousdt.bI();
        paramAnonymousApiOptions = (String[])paramAnonymousApiOptions.Dt.toArray(new String[0]);
        String str1 = paramAnonymousContext.getPackageName();
        String str2 = paramAnonymousContext.getPackageName();
        return new hs(paramAnonymousContext, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, new hu((String)localObject, paramAnonymousdt, paramAnonymousApiOptions, new String[0], str1, str2, null));
      }
    }
    
    public int getPriority()
    {
      return 2;
    }
  };
  
  static
  {
    API = new Api(jO, new Scope[0]);
    SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
    SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
    MomentsApi = new hz(jO);
    PeopleApi = new ia(jO);
  }
  
  public static hs a(GoogleApiClient paramGoogleApiClient, Api.b<hs> paramb)
  {
    boolean bool2 = true;
    if (paramGoogleApiClient != null)
    {
      bool1 = true;
      eg.b(bool1, "GoogleApiClient parameter is required.");
      eg.a(paramGoogleApiClient.isConnected(), "GoogleApiClient must be connected.");
      paramGoogleApiClient = (hs)paramGoogleApiClient.a(paramb);
      if (paramGoogleApiClient == null) {
        break label51;
      }
    }
    label51:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      eg.a(bool1, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
      return paramGoogleApiClient;
      bool1 = false;
      break;
    }
  }
  
  public static final class PlusOptions
    implements GoogleApiClient.ApiOptions
  {
    final String Ds;
    final Set<String> Dt;
    
    private PlusOptions()
    {
      this.Ds = null;
      this.Dt = new HashSet();
    }
    
    private PlusOptions(Builder paramBuilder)
    {
      this.Ds = paramBuilder.Ds;
      this.Dt = paramBuilder.Dt;
    }
    
    public static Builder builder()
    {
      return new Builder();
    }
    
    public static final class Builder
    {
      String Ds;
      final Set<String> Dt = new HashSet();
      
      public Builder addActivityTypes(String... paramVarArgs)
      {
        eg.b(paramVarArgs, "activityTypes may not be null.");
        int i = 0;
        while (i < paramVarArgs.length)
        {
          this.Dt.add(paramVarArgs[i]);
          i += 1;
        }
        return this;
      }
      
      public Plus.PlusOptions build()
      {
        return new Plus.PlusOptions(this, null);
      }
      
      public Builder setServerClientId(String paramString)
      {
        this.Ds = paramString;
        return this;
      }
    }
  }
  
  public static abstract class a<R extends Result>
    extends a.a<R, hs>
  {
    public a(Api.b<hs> paramb)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/plus/Plus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */