package com.google.android.gms.appstate;

import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ee.a;

public final class a
  implements AppState
{
  private final int jI;
  private final String jJ;
  private final byte[] jK;
  private final boolean jL;
  private final String jM;
  private final byte[] jN;
  
  public a(AppState paramAppState)
  {
    this.jI = paramAppState.getKey();
    this.jJ = paramAppState.getLocalVersion();
    this.jK = paramAppState.getLocalData();
    this.jL = paramAppState.hasConflict();
    this.jM = paramAppState.getConflictVersion();
    this.jN = paramAppState.getConflictData();
  }
  
  static int a(AppState paramAppState)
  {
    return ee.hashCode(new Object[] { Integer.valueOf(paramAppState.getKey()), paramAppState.getLocalVersion(), paramAppState.getLocalData(), Boolean.valueOf(paramAppState.hasConflict()), paramAppState.getConflictVersion(), paramAppState.getConflictData() });
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
      if ((!ee.equal(Integer.valueOf(((AppState)paramObject).getKey()), Integer.valueOf(paramAppState.getKey()))) || (!ee.equal(((AppState)paramObject).getLocalVersion(), paramAppState.getLocalVersion())) || (!ee.equal(((AppState)paramObject).getLocalData(), paramAppState.getLocalData())) || (!ee.equal(Boolean.valueOf(((AppState)paramObject).hasConflict()), Boolean.valueOf(paramAppState.hasConflict()))) || (!ee.equal(((AppState)paramObject).getConflictVersion(), paramAppState.getConflictVersion()))) {
        break;
      }
      bool1 = bool2;
    } while (ee.equal(((AppState)paramObject).getConflictData(), paramAppState.getConflictData()));
    return false;
  }
  
  static String b(AppState paramAppState)
  {
    return ee.e(paramAppState).a("Key", Integer.valueOf(paramAppState.getKey())).a("LocalVersion", paramAppState.getLocalVersion()).a("LocalData", paramAppState.getLocalData()).a("HasConflict", Boolean.valueOf(paramAppState.hasConflict())).a("ConflictVersion", paramAppState.getConflictVersion()).a("ConflictData", paramAppState.getConflictData()).toString();
  }
  
  public AppState aK()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public byte[] getConflictData()
  {
    return this.jN;
  }
  
  public String getConflictVersion()
  {
    return this.jM;
  }
  
  public int getKey()
  {
    return this.jI;
  }
  
  public byte[] getLocalData()
  {
    return this.jK;
  }
  
  public String getLocalVersion()
  {
    return this.jJ;
  }
  
  public boolean hasConflict()
  {
    return this.jL;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/appstate/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */