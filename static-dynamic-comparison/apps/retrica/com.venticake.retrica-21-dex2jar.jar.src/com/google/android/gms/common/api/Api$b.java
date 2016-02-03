package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.internal.gy;

public abstract interface Api$b<T extends Api.a, O>
{
  public abstract T a(Context paramContext, Looper paramLooper, gy paramgy, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  
  public abstract int getPriority();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/api/Api$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */