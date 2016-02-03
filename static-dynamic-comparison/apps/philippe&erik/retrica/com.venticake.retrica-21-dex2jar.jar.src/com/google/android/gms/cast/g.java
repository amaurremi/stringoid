package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.internal.gp;
import java.io.IOException;

class g
  implements gp
{
  private GoogleApiClient b;
  private long c = 0L;
  
  public g(RemoteMediaPlayer paramRemoteMediaPlayer) {}
  
  public void a(GoogleApiClient paramGoogleApiClient)
  {
    this.b = paramGoogleApiClient;
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if (this.b == null) {
      throw new IOException("No GoogleApiClient available");
    }
    Cast.CastApi.sendMessage(this.b, paramString1, paramString2).setResultCallback(new h(this, paramLong));
  }
  
  public long eb()
  {
    long l = this.c + 1L;
    this.c = l;
    return l;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */