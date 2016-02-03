package com.google.android.gms.cast;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.go;

final class h
  implements ResultCallback<Status>
{
  private final long b;
  
  h(g paramg, long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(Status paramStatus)
  {
    if (!paramStatus.isSuccess()) {
      RemoteMediaPlayer.e(this.a.a).a(this.b, paramStatus.getStatusCode());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */