package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;

final class t
  extends a
{
  private final a.d<Status> b;
  
  public t(a.d<Status> paramd)
  {
    a.d locald;
    this.b = locald;
  }
  
  public void h(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
    {
      paramBundle = new Status(paramInt, null, paramBundle);
      this.a.a(new u(this.a, this.b, paramBundle));
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/internal/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */