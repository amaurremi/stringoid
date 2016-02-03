package com.google.android.gms.appstate;

import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;

public final class a
  implements AppState
{
  private final int wr;
  private final String ws;
  private final byte[] wt;
  private final boolean wu;
  private final String wv;
  private final byte[] ww;
  
  public a(AppState paramAppState)
  {
    this.wr = paramAppState.getKey();
    this.ws = paramAppState.getLocalVersion();
    this.wt = paramAppState.getLocalData();
    this.wu = paramAppState.hasConflict();
    this.wv = paramAppState.getConflictVersion();
    this.ww = paramAppState.getConflictData();
  }
  
  static int a(AppState paramAppState)
  {
    return fo.hashCode(new Object[] { Integer.valueOf(paramAppState.getKey()), paramAppState.getLocalVersion(), paramAppState.getLocalData(), Boolean.valueOf(paramAppState.hasConflict()), paramAppState.getConflictVersion(), paramAppState.getConflictData() });
  }
  
  static boolean a(AppState paramAppState, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof AppState)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramAppState == paramObject);
      paramObject = (AppState)paramObject;
      if ((!fo.equal(Integer.valueOf(((AppState)paramObject).getKey()), Integer.valueOf(paramAppState.getKey()))) || (!fo.equal(((AppState)paramObject).getLocalVersion(), paramAppState.getLocalVersion())) || (!fo.equal(((AppState)paramObject).getLocalData(), paramAppState.getLocalData())) || (!fo.equal(Boolean.valueOf(((AppState)paramObject).hasConflict()), Boolean.valueOf(paramAppState.hasConflict()))) || (!fo.equal(((AppState)paramObject).getConflictVersion(), paramAppState.getConflictVersion()))) {
        break;
      }
      bool1 = bool2;
    } while (fo.equal(((AppState)paramObject).getConflictData(), paramAppState.getConflictData()));
    return false;
  }
  
  static String b(AppState paramAppState)
  {
    return fo.e(paramAppState).a("Key", Integer.valueOf(paramAppState.getKey())).a("LocalVersion", paramAppState.getLocalVersion()).a("LocalData", paramAppState.getLocalData()).a("HasConflict", Boolean.valueOf(paramAppState.hasConflict())).a("ConflictVersion", paramAppState.getConflictVersion()).a("ConflictData", paramAppState.getConflictData()).toString();
  }
  
  public AppState dt()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public byte[] getConflictData()
  {
    return this.ww;
  }
  
  public String getConflictVersion()
  {
    return this.wv;
  }
  
  public int getKey()
  {
    return this.wr;
  }
  
  public byte[] getLocalData()
  {
    return this.wt;
  }
  
  public String getLocalVersion()
  {
    return this.ws;
  }
  
  public boolean hasConflict()
  {
    return this.wu;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/appstate/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */