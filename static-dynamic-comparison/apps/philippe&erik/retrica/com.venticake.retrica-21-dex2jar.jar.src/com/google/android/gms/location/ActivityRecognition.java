package com.google.android.gms.location;

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
import com.google.android.gms.internal.ja;
import com.google.android.gms.internal.jg;

public class ActivityRecognition
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api(yI, yH, new Scope[0]);
  public static ActivityRecognitionApi ActivityRecognitionApi = new ja();
  public static final String CLIENT_NAME = "activity_recognition";
  private static final Api.c<jg> yH = new Api.c();
  private static final Api.b<jg, Api.ApiOptions.NoOptions> yI = new Api.b()
  {
    public jg a(Context paramAnonymousContext, Looper paramAnonymousLooper, gy paramAnonymousgy, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new jg(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, "activity_recognition");
    }
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
  };
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/location/ActivityRecognition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */