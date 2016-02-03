package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.cc.a;
import java.util.Map;
import java.util.Set;

abstract class g
{
  private final Set<String> WO;
  
  public abstract cc.a L(Map<String, cc.a> paramMap);
  
  boolean a(Set<String> paramSet)
  {
    return paramSet.containsAll(this.WO);
  }
  
  public abstract boolean vK();
  
  public Set<String> vL()
  {
    return this.WO;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */