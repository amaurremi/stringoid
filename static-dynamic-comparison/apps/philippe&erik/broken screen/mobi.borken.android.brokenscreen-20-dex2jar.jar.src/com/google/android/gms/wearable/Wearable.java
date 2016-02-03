package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gz;
import com.google.android.gms.wearable.internal.ae;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.au;
import com.google.android.gms.wearable.internal.e;
import com.google.android.gms.wearable.internal.f;

public class Wearable
{
  public static final Api<WearableOptions> API = new Api(yF, yE, new Scope[0]);
  public static final DataApi DataApi = new f();
  public static final MessageApi MessageApi = new ae();
  public static final NodeApi NodeApi = new ah();
  public static final b alm = new e();
  public static final Api.c<au> yE = new Api.c();
  private static final Api.b<au, WearableOptions> yF = new Api.b()
  {
    public au a(Context paramAnonymousContext, Looper paramAnonymousLooper, gz paramAnonymousgz, Wearable.WearableOptions paramAnonymousWearableOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
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
  
  public static final class WearableOptions
    implements Api.ApiOptions.Optional
  {
    private WearableOptions(Builder paramBuilder) {}
    
    public static class Builder
    {
      public Wearable.WearableOptions build()
      {
        return new Wearable.WearableOptions(this, null);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wearable/Wearable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */