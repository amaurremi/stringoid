package com.google.android.gms.internal;

import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;

final class nz
  extends fz
{
  private final a.d<AppStateManager.StateDeletedResult> a;
  
  public nz(a.d<AppStateManager.StateDeletedResult> paramd)
  {
    this.a = ((a.d)hm.b(paramd, "Result holder must not be null"));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Status localStatus = new Status(paramInt1);
    this.a.a(new oa(localStatus, paramInt2));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/nz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */