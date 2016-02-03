package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.panorama.PanoramaApi.a;

final class po
  extends kd.a
{
  private final a.d<PanoramaApi.a> a;
  
  public po(a.d<PanoramaApi.a> paramd)
  {
    this.a = paramd;
  }
  
  public void a(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (paramBundle != null) {}
    for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
    {
      paramBundle = new Status(paramInt1, null, paramBundle);
      this.a.a(new kc(paramBundle, paramIntent, paramInt2));
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/po.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */