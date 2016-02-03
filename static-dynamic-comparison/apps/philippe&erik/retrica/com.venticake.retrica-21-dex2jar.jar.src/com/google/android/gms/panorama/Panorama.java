package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.kf;
import com.google.android.gms.internal.kg;

public final class Panorama
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api(yI, yH, new Scope[0]);
  public static final PanoramaApi PanoramaApi = new kf();
  public static final Api.c<kg> yH = new Api.c();
  static final Api.b<kg, Api.ApiOptions.NoOptions> yI = new Api.b()
  {
    public kg a(Context paramAnonymousContext, Looper paramAnonymousLooper, gy paramAnonymousgy, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new kg(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
  };
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/panorama/Panorama.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */