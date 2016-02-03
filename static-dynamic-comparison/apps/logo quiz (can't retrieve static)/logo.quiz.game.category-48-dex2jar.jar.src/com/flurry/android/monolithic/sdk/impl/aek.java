package com.flurry.android.monolithic.sdk.impl;

final class aek<T>
{
  final T a;
  final int b;
  aek<T> c;
  
  public aek(T paramT, int paramInt)
  {
    this.a = paramT;
    this.b = paramInt;
  }
  
  public int a(T paramT, int paramInt)
  {
    System.arraycopy(this.a, 0, paramT, paramInt, this.b);
    return this.b + paramInt;
  }
  
  public T a()
  {
    return (T)this.a;
  }
  
  public void a(aek<T> paramaek)
  {
    if (this.c != null) {
      throw new IllegalStateException();
    }
    this.c = paramaek;
  }
  
  public aek<T> b()
  {
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */