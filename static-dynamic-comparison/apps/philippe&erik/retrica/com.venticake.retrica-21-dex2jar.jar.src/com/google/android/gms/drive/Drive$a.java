package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.internal.gy;
import java.util.List;

public abstract class Drive$a<O extends Api.ApiOptions>
  implements Api.b<r, O>
{
  protected abstract Bundle a(O paramO);
  
  public r a(Context paramContext, Looper paramLooper, gy paramgy, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    List localList = paramgy.fl();
    return new r(paramContext, paramLooper, paramgy, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])localList.toArray(new String[localList.size()]), a(paramO));
  }
  
  public int getPriority()
  {
    return Integer.MAX_VALUE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/Drive$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */