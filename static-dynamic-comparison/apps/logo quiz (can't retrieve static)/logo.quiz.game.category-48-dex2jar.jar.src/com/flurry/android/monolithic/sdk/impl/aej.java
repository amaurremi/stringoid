package com.flurry.android.monolithic.sdk.impl;

public abstract class aej<T>
{
  T a;
  aek<T> b;
  aek<T> c;
  int d;
  
  public T a()
  {
    b();
    if (this.a == null) {
      return (T)b(12);
    }
    return (T)this.a;
  }
  
  public final T a(T paramT, int paramInt)
  {
    paramT = new aek(paramT, paramInt);
    if (this.b == null)
    {
      this.c = paramT;
      this.b = paramT;
      this.d += paramInt;
      if (paramInt >= 16384) {
        break label70;
      }
      paramInt += paramInt;
    }
    for (;;)
    {
      return (T)b(paramInt);
      this.c.a(paramT);
      this.c = paramT;
      break;
      label70:
      paramInt = (paramInt >> 2) + paramInt;
    }
  }
  
  protected abstract T b(int paramInt);
  
  public T b(T paramT, int paramInt)
  {
    int j = paramInt + this.d;
    Object localObject = b(j);
    aek localaek = this.b;
    int i = 0;
    while (localaek != null)
    {
      i = localaek.a(localObject, i);
      localaek = localaek.b();
    }
    System.arraycopy(paramT, 0, localObject, i, paramInt);
    paramInt = i + paramInt;
    if (paramInt != j) {
      throw new IllegalStateException("Should have gotten " + j + " entries, got " + paramInt);
    }
    return (T)localObject;
  }
  
  protected void b()
  {
    if (this.c != null) {
      this.a = this.c.a();
    }
    this.c = null;
    this.b = null;
    this.d = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */