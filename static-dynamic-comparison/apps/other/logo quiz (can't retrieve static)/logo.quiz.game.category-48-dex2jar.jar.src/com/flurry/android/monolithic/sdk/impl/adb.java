package com.flurry.android.monolithic.sdk.impl;

public final class adb
  implements Comparable<adb>
{
  private String a;
  private Class<?> b;
  private int c;
  
  public adb()
  {
    this.b = null;
    this.a = null;
    this.c = 0;
  }
  
  public adb(Class<?> paramClass)
  {
    this.b = paramClass;
    this.a = paramClass.getName();
    this.c = this.a.hashCode();
  }
  
  public int a(adb paramadb)
  {
    return this.a.compareTo(paramadb.a);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (paramObject.getClass() != getClass()) {
        return false;
      }
    } while (((adb)paramObject).b == this.b);
    return false;
  }
  
  public int hashCode()
  {
    return this.c;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/adb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */