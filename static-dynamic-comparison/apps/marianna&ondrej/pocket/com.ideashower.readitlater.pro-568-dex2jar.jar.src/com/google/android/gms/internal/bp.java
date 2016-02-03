package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.a;

final class bp
  extends bg
{
  private final com.google.android.gms.b.d b;
  
  public bp(bo parambo, com.google.android.gms.b.d paramd)
  {
    this.b = paramd;
  }
  
  public void a(com.google.android.gms.common.data.d paramd, String paramString)
  {
    if (paramd.f() != null) {}
    for (Object localObject = (PendingIntent)paramd.f().getParcelable("pendingIntent");; localObject = null)
    {
      localObject = new a(paramd.e(), (PendingIntent)localObject);
      if ((!((a)localObject).b()) && (paramd != null))
      {
        if (!paramd.h()) {
          paramd.i();
        }
        paramd = null;
      }
      for (;;)
      {
        this.a.a(new bq(this.a, this.b, (a)localObject, paramd, paramString));
        return;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */