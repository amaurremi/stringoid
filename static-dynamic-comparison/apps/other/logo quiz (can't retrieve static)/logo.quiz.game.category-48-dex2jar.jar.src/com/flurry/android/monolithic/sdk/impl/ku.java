package com.flurry.android.monolithic.sdk.impl;

public class ku
  implements lc
{
  private ji a;
  private String b;
  
  public ku(ji paramji, String paramString)
  {
    this.a = paramji;
    this.b = paramString;
  }
  
  public ji a()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    while (((paramObject instanceof lc)) && (this.b.equals(paramObject.toString()))) {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public String toString()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */