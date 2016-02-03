package com.flurry.android.monolithic.sdk.impl;

public abstract class nu
  implements nt, Comparable<nt>
{
  public int a(nt paramnt)
  {
    return nn.b().a(this, paramnt, a());
  }
  
  public abstract ji a();
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof nt)) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
    } while (a((nt)paramObject) == 0);
    return false;
  }
  
  public int hashCode()
  {
    return nn.b().b(this, a());
  }
  
  public String toString()
  {
    return nn.b().a(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/nu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */