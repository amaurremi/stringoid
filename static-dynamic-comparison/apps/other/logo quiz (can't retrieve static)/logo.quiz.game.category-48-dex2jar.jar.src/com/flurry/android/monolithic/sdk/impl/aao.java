package com.flurry.android.monolithic.sdk.impl;

final class aao
  extends aal
{
  private final aar[] a;
  
  public aao(aar[] paramArrayOfaar)
  {
    this.a = paramArrayOfaar;
  }
  
  public aal a(Class<?> paramClass, ra<Object> paramra)
  {
    int i = this.a.length;
    if (i == 8) {
      return this;
    }
    aar[] arrayOfaar = new aar[i + 1];
    System.arraycopy(this.a, 0, arrayOfaar, 0, i);
    arrayOfaar[i] = new aar(paramClass, paramra);
    return new aao(arrayOfaar);
  }
  
  public ra<Object> a(Class<?> paramClass)
  {
    int i = 0;
    int j = this.a.length;
    while (i < j)
    {
      aar localaar = this.a[i];
      if (localaar.a == paramClass) {
        return localaar.b;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */