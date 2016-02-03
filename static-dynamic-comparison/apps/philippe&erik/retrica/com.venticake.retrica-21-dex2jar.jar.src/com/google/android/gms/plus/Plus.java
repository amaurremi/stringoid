package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.ki;
import com.google.android.gms.internal.kj;
import com.google.android.gms.internal.kk;
import com.google.android.gms.internal.kl;
import com.google.android.gms.internal.km;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.internal.h;
import java.util.Set;

public final class Plus
{
  public static final Api<Plus.PlusOptions> API;
  public static final Account AccountApi = new ki();
  public static final Moments MomentsApi;
  public static final People PeopleApi;
  public static final Scope SCOPE_PLUS_LOGIN;
  public static final Scope SCOPE_PLUS_PROFILE;
  public static final b abp = new kk();
  public static final a abq = new kj();
  public static final Api.c<e> yH = new Api.c();
  static final Api.b<e, Plus.PlusOptions> yI = new Api.b()
  {
    public e a(Context paramAnonymousContext, Looper paramAnonymousLooper, gy paramAnonymousgy, Plus.PlusOptions paramAnonymousPlusOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      Object localObject = paramAnonymousPlusOptions;
      if (paramAnonymousPlusOptions == null) {
        localObject = new Plus.PlusOptions(null);
      }
      paramAnonymousPlusOptions = paramAnonymousgy.fj();
      paramAnonymousgy = paramAnonymousgy.fm();
      localObject = (String[])((Plus.PlusOptions)localObject).abs.toArray(new String[0]);
      String str1 = paramAnonymousContext.getPackageName();
      String str2 = paramAnonymousContext.getPackageName();
      PlusCommonExtras localPlusCommonExtras = new PlusCommonExtras();
      return new e(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, new h(paramAnonymousPlusOptions, paramAnonymousgy, (String[])localObject, new String[0], str1, str2, null, localPlusCommonExtras));
    }
    
    public int getPriority()
    {
      return 2;
    }
  };
  
  static
  {
    API = new Api(yI, yH, new Scope[0]);
    SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
    SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
    MomentsApi = new kl();
    PeopleApi = new km();
  }
  
  public static e a(GoogleApiClient paramGoogleApiClient, Api.c<e> paramc)
  {
    boolean bool2 = true;
    if (paramGoogleApiClient != null)
    {
      bool1 = true;
      hm.b(bool1, "GoogleApiClient parameter is required.");
      hm.a(paramGoogleApiClient.isConnected(), "GoogleApiClient must be connected.");
      paramGoogleApiClient = (e)paramGoogleApiClient.a(paramc);
      if (paramGoogleApiClient == null) {
        break label55;
      }
    }
    label55:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      hm.a(bool1, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
      return paramGoogleApiClient;
      bool1 = false;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/Plus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */