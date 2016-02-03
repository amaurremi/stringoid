package com.google.android.gms.internal;

import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;

final class oc
  extends b
  implements AppStateManager.StateListResult
{
  private final AppStateBuffer a;
  
  public oc(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.a = new AppStateBuffer(paramDataHolder);
  }
  
  public AppStateBuffer getStateBuffer()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/oc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */