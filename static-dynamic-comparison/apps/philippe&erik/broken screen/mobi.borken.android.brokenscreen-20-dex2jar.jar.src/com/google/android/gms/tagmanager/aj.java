package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj
{
  private final String afA;
  private final Set<String> afz;
  
  public aj(String paramString, String... paramVarArgs)
  {
    this.afA = paramString;
    this.afz = new HashSet(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramVarArgs[i];
      this.afz.add(paramString);
      i += 1;
    }
  }
  
  boolean a(Set<String> paramSet)
  {
    return paramSet.containsAll(this.afz);
  }
  
  public String lG()
  {
    return this.afA;
  }
  
  public Set<String> lH()
  {
    return this.afz;
  }
  
  public abstract boolean lc();
  
  public abstract d.a w(Map<String, d.a> paramMap);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */