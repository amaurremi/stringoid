package com.google.android.gms.appstate;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface AppStateManager$StateLoadedResult
  extends Releasable, Result
{
  public abstract byte[] getLocalData();
  
  public abstract int getStateKey();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/appstate/AppStateManager$StateLoadedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */