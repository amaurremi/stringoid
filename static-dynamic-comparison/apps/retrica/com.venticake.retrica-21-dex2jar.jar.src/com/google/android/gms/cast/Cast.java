package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gh;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;

public final class Cast
{
  public static final Api<Cast.CastOptions> API = new Api(yI, yH, new Scope[0]);
  public static final Cast.CastApi CastApi = new Cast.CastApi.a();
  public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
  public static final int MAX_MESSAGE_LENGTH = 65536;
  public static final int MAX_NAMESPACE_LENGTH = 128;
  static final Api.c<gh> yH = new Api.c();
  private static final Api.b<gh, Cast.CastOptions> yI = new Api.b()
  {
    public gh a(Context paramAnonymousContext, Looper paramAnonymousLooper, gy paramAnonymousgy, Cast.CastOptions paramAnonymousCastOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      hm.b(paramAnonymousCastOptions, "Setting the API options is required.");
      return new gh(paramAnonymousContext, paramAnonymousLooper, paramAnonymousCastOptions.Aa, Cast.CastOptions.a(paramAnonymousCastOptions), paramAnonymousCastOptions.Ab, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
  };
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/Cast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */