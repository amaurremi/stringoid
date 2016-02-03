package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.b.c;
import com.google.android.gms.common.a;

final class br
  extends bg
{
  private final c b;
  
  public br(bo parambo, c paramc)
  {
    this.b = paramc;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    PendingIntent localPendingIntent = null;
    if (paramBundle != null) {
      localPendingIntent = (PendingIntent)paramBundle.getParcelable("pendingIntent");
    }
    paramBundle = new a(paramInt, localPendingIntent);
    this.a.a(new bs(this.a, this.b, paramBundle));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */