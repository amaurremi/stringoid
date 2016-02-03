package com.google.android.gms.appstate;

import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class a
  implements AppState
{
  private final byte[] yA;
  private final boolean yB;
  private final String yC;
  private final byte[] yD;
  private final int yy;
  private final String yz;
  
  public a(AppState paramAppState)
  {
    this.yy = paramAppState.getKey();
    this.yz = paramAppState.getLocalVersion();
    this.yA = paramAppState.getLocalData();
    this.yB = paramAppState.hasConflict();
    this.yC = paramAppState.getConflictVersion();
    this.yD = paramAppState.getConflictData();
  }
  
  static int a(AppState paramAppState)
  {
    return hl.hashCode(new Object[] { Integer.valueOf(paramAppState.getKey()), paramAppState.getLocalVersion(), paramAppState.getLocalData(), Boolean.valueOf(paramAppState.hasConflict()), paramAppState.getConflictVersion(), paramAppState.getConflictData() });
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
      if ((!hl.equal(Integer.valueOf(((AppState)paramObject).getKey()), Integer.valueOf(paramAppState.getKey()))) || (!hl.equal(((AppState)paramObject).getLocalVersion(), paramAppState.getLocalVersion())) || (!hl.equal(((AppState)paramObject).getLocalData(), paramAppState.getLocalData())) || (!hl.equal(Boolean.valueOf(((AppState)paramObject).hasConflict()), Boolean.valueOf(paramAppState.hasConflict()))) || (!hl.equal(((AppState)paramObject).getConflictVersion(), paramAppState.getConflictVersion()))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(((AppState)paramObject).getConflictData(), paramAppState.getConflictData()));
    return false;
  }
  
  static String b(AppState paramAppState)
  {
    return hl.e(paramAppState).a("Key", Integer.valueOf(paramAppState.getKey())).a("LocalVersion", paramAppState.getLocalVersion()).a("LocalData", paramAppState.getLocalData()).a("HasConflict", Boolean.valueOf(paramAppState.hasConflict())).a("ConflictVersion", paramAppState.getConflictVersion()).a("ConflictData", paramAppState.getConflictData()).toString();
  }
  
  public AppState dN()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public byte[] getConflictData()
  {
    return this.yD;
  }
  
  public String getConflictVersion()
  {
    return this.yC;
  }
  
  public int getKey()
  {
    return this.yy;
  }
  
  public byte[] getLocalData()
  {
    return this.yA;
  }
  
  public String getLocalVersion()
  {
    return this.yz;
  }
  
  public boolean hasConflict()
  {
    return this.yB;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/appstate/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */