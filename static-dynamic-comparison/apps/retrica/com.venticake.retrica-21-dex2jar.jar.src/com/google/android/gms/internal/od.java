package com.google.android.gms.internal;

import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;

final class od
  extends fz
{
  private final a.d<AppStateManager.StateResult> a;
  
  public od(a.d<AppStateManager.StateResult> paramd)
  {
    this.a = ((a.d)hm.b(paramd, "Result holder must not be null"));
  }
  
  public void a(int paramInt, DataHolder paramDataHolder)
  {
    this.a.a(new oe(paramInt, paramDataHolder));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/od.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */