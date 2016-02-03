package com.google.android.gms.plus.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.b;

final class u
  extends hb<d>.b<a.d<Status>>
{
  private final Status b;
  
  public u(a.d<Status> paramd, Status paramStatus)
  {
    super(paramd, paramStatus);
    Status localStatus;
    this.b = localStatus;
  }
  
  protected void a(a.d<Status> paramd)
  {
    this.a.disconnect();
    if (paramd != null) {
      paramd.a(this.b);
    }
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/internal/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */