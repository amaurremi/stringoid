package com.google.android.gms.internal;

import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;

final class oe
  extends b
  implements AppStateManager.StateConflictResult, AppStateManager.StateLoadedResult, AppStateManager.StateResult
{
  private final int a;
  private final AppStateBuffer b;
  
  public oe(int paramInt, DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.a = paramInt;
    this.b = new AppStateBuffer(paramDataHolder);
  }
  
  private boolean a()
  {
    return this.yz.getStatusCode() == 2000;
  }
  
  public AppStateManager.StateConflictResult getConflictResult()
  {
    if (a()) {
      return this;
    }
    return null;
  }
  
  public AppStateManager.StateLoadedResult getLoadedResult()
  {
    oe localoe = this;
    if (a()) {
      localoe = null;
    }
    return localoe;
  }
  
  public byte[] getLocalData()
  {
    if (this.b.getCount() == 0) {
      return null;
    }
    return this.b.get(0).getLocalData();
  }
  
  public String getResolvedVersion()
  {
    if (this.b.getCount() == 0) {
      return null;
    }
    return this.b.get(0).getConflictVersion();
  }
  
  public byte[] getServerData()
  {
    if (this.b.getCount() == 0) {
      return null;
    }
    return this.b.get(0).getConflictData();
  }
  
  public int getStateKey()
  {
    return this.a;
  }
  
  public void release()
  {
    this.b.close();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/oe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */