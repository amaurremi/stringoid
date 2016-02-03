package com.google.android.gms.appstate;

import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;

public final class a
  implements AppState
{
  private final int yB;
  private final String yC;
  private final byte[] yD;
  private final boolean yE;
  private final String yF;
  private final byte[] yG;
  
  public a(AppState paramAppState)
  {
    this.yB = paramAppState.getKey();
    this.yC = paramAppState.getLocalVersion();
    this.yD = paramAppState.getLocalData();
    this.yE = paramAppState.hasConflict();
    this.yF = paramAppState.getConflictVersion();
    this.yG = paramAppState.getConflictData();
  }
  
  static int a(AppState paramAppState)
  {
    return hk.hashCode(new Object[] { Integer.valueOf(paramAppState.getKey()), paramAppState.getLocalVersion(), paramAppState.getLocalData(), Boolean.valueOf(paramAppState.hasConflict()), paramAppState.getConflictVersion(), paramAppState.getConflictData() });
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
      if ((!hk.equal(Integer.valueOf(((AppState)paramObject).getKey()), Integer.valueOf(paramAppState.getKey()))) || (!hk.equal(((AppState)paramObject).getLocalVersion(), paramAppState.getLocalVersion())) || (!hk.equal(((AppState)paramObject).getLocalData(), paramAppState.getLocalData())) || (!hk.equal(Boolean.valueOf(((AppState)paramObject).hasConflict()), Boolean.valueOf(paramAppState.hasConflict()))) || (!hk.equal(((AppState)paramObject).getConflictVersion(), paramAppState.getConflictVersion()))) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(((AppState)paramObject).getConflictData(), paramAppState.getConflictData()));
    return false;
  }
  
  static String b(AppState paramAppState)
  {
    return hk.e(paramAppState).a("Key", Integer.valueOf(paramAppState.getKey())).a("LocalVersion", paramAppState.getLocalVersion()).a("LocalData", paramAppState.getLocalData()).a("HasConflict", Boolean.valueOf(paramAppState.hasConflict())).a("ConflictVersion", paramAppState.getConflictVersion()).a("ConflictData", paramAppState.getConflictData()).toString();
  }
  
  public AppState dS()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public byte[] getConflictData()
  {
    return this.yG;
  }
  
  public String getConflictVersion()
  {
    return this.yF;
  }
  
  public int getKey()
  {
    return this.yB;
  }
  
  public byte[] getLocalData()
  {
    return this.yD;
  }
  
  public String getLocalVersion()
  {
    return this.yC;
  }
  
  public boolean hasConflict()
  {
    return this.yE;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/appstate/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */