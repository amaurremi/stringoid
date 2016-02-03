package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj
{
  private final Set<String> aoY;
  private final String aoZ;
  
  public aj(String paramString, String... paramVarArgs)
  {
    this.aoZ = paramString;
    this.aoY = new HashSet(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramVarArgs[i];
      this.aoY.add(paramString);
      i += 1;
    }
  }
  
  public abstract d.a C(Map<String, d.a> paramMap);
  
  boolean a(Set<String> paramSet)
  {
    return paramSet.containsAll(this.aoY);
  }
  
  public abstract boolean nL();
  
  public String op()
  {
    return this.aoZ;
  }
  
  public Set<String> oq()
  {
    return this.aoY;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */