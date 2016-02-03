package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class t
{
  private final Set<String> a;
  private final String b;
  
  public t(String paramString, String... paramVarArgs)
  {
    this.b = paramString;
    this.a = new HashSet(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramVarArgs[i];
      this.a.add(paramString);
      i += 1;
    }
  }
  
  public abstract d.a a(Map<String, d.a> paramMap);
  
  public abstract boolean a();
  
  boolean a(Set<String> paramSet)
  {
    return paramSet.containsAll(this.a);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public Set<String> c()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */