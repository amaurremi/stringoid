package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.wearable.internal.ae;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.au;
import com.google.android.gms.wearable.internal.e;
import com.google.android.gms.wearable.internal.f;

public class Wearable
{
  public static final Api<Wearable.WearableOptions> API = new Api(yI, yH, new Scope[0]);
  public static final DataApi DataApi = new f();
  public static final MessageApi MessageApi = new ae();
  public static final NodeApi NodeApi = new ah();
  public static final b alp = new e();
  public static final Api.c<au> yH = new Api.c();
  private static final Api.b<au, Wearable.WearableOptions> yI = new Api.b()
  {
    public au a(Context paramAnonymousContext, Looper paramAnonymousLooper, gy paramAnonymousgy, Wearable.WearableOptions paramAnonymousWearableOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      if (paramAnonymousWearableOptions != null) {}
      for (;;)
      {
        return new au(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
        new Wearable.WearableOptions(new Wearable.WearableOptions.Builder(), null);
      }
    }
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
  };
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/Wearable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */