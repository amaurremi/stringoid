package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.Moments.LoadMomentsResult;

final class o
  extends a
{
  private final a.d<Moments.LoadMomentsResult> b;
  
  public o(a.d<Moments.LoadMomentsResult> paramd)
  {
    a.d locald;
    this.b = locald;
  }
  
  public void a(DataHolder paramDataHolder, String paramString1, String paramString2)
  {
    if (paramDataHolder.eU() != null) {}
    for (Object localObject = (PendingIntent)paramDataHolder.eU().getParcelable("pendingIntent");; localObject = null)
    {
      localObject = new Status(paramDataHolder.getStatusCode(), null, (PendingIntent)localObject);
      if ((!((Status)localObject).isSuccess()) && (paramDataHolder != null))
      {
        if (!paramDataHolder.isClosed()) {
          paramDataHolder.close();
        }
        paramDataHolder = null;
      }
      for (;;)
      {
        this.a.a(new p(this.a, this.b, (Status)localObject, paramDataHolder, paramString1, paramString2));
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/internal/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */