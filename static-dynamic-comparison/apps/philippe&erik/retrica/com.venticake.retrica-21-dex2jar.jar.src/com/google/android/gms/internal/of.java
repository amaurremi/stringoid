package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;

final class of
  extends fz
{
  private final a.d<Status> a;
  
  public of(a.d<Status> paramd)
  {
    this.a = ((a.d)hm.b(paramd, "Holder must not be null"));
  }
  
  public void dT()
  {
    Status localStatus = new Status(0);
    this.a.a(localStatus);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/of.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */