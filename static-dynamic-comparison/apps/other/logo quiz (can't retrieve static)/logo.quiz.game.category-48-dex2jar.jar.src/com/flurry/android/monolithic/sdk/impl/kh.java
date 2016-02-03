package com.flurry.android.monolithic.sdk.impl;

class kh
{
  private Object a;
  private Object b;
  
  private kh(Object paramObject1, Object paramObject2)
  {
    this.a = paramObject1;
    this.b = paramObject2;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this.a == ((kh)paramObject).a) && (this.b == ((kh)paramObject).b);
  }
  
  public int hashCode()
  {
    return System.identityHashCode(this.a) + System.identityHashCode(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/kh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */