package com.google.android.gms.fitness;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.kj;
import com.google.android.gms.internal.kk;
import com.google.android.gms.internal.ku;
import com.google.android.gms.internal.kw;
import com.google.android.gms.internal.kx;
import com.google.android.gms.internal.ky;
import com.google.android.gms.internal.kz;
import com.google.android.gms.internal.la;
import com.google.android.gms.internal.lb;
import com.google.android.gms.internal.lc;
import com.google.android.gms.internal.ld;

public class Fitness
{
  public static final Api<Api.ApiOptions.NoOptions> API;
  public static final BleApi BleApi = iy();
  public static final Api.c<kj> CU = new Api.c();
  private static final Api.b<kj, Api.ApiOptions.NoOptions> CV = new Api.b()
  {
    public kj c(Context paramAnonymousContext, Looper paramAnonymousLooper, ClientSettings paramAnonymousClientSettings, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      paramAnonymousNoOptions = FitnessScopes.d(paramAnonymousClientSettings.getScopes());
      return new kk(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymousClientSettings.getAccountNameOrDefault(), paramAnonymousNoOptions);
    }
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
  };
  public static final ConfigApi ConfigApi;
  public static final HistoryApi HistoryApi;
  public static final RecordingApi RecordingApi;
  public static final SensorsApi SensorsApi;
  public static final SessionsApi SessionsApi;
  public static final ku Sf = new kz();
  
  static
  {
    API = new Api(CV, CU, new Scope[0]);
    SensorsApi = new lb();
    RecordingApi = new la();
    SessionsApi = new lc();
    HistoryApi = new ky();
    ConfigApi = new kx();
  }
  
  private static BleApi iy()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new kw();
    }
    return new ld();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/Fitness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */