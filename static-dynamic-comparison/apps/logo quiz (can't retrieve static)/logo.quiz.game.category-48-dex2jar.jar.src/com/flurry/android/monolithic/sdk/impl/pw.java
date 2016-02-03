package com.flurry.android.monolithic.sdk.impl;

public class pw
  implements pe
{
  protected final String a;
  protected char[] b;
  
  public pw(String paramString)
  {
    this.a = paramString;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final char[] b()
  {
    char[] arrayOfChar2 = this.b;
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2 == null)
    {
      arrayOfChar1 = ps.a().a(this.a);
      this.b = arrayOfChar1;
    }
    return arrayOfChar1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      return false;
    }
    paramObject = (pw)paramObject;
    return this.a.equals(((pw)paramObject).a);
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
  
  public final String toString()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/pw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */