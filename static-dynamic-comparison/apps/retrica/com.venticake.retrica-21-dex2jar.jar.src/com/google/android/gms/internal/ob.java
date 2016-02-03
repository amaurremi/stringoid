package com.google.android.gms.internal;

import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;

final class ob
  extends fz
{
  private final a.d<AppStateManager.StateListResult> a;
  
  public ob(a.d<AppStateManager.StateListResult> paramd)
  {
    this.a = ((a.d)hm.b(paramd, "Result holder must not be null"));
  }
  
  public void a(DataHolder paramDataHolder)
  {
    this.a.a(new oc(paramDataHolder));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */