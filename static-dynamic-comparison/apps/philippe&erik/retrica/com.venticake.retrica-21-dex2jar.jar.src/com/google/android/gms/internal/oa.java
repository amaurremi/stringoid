package com.google.android.gms.internal;

import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.common.api.Status;

final class oa
  implements AppStateManager.StateDeletedResult
{
  private final Status a;
  private final int b;
  
  public oa(Status paramStatus, int paramInt)
  {
    this.a = paramStatus;
    this.b = paramInt;
  }
  
  public int getStateKey()
  {
    return this.b;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/oa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */