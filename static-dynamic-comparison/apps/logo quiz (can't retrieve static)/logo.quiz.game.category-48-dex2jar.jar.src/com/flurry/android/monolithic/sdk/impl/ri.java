package com.flurry.android.monolithic.sdk.impl;

abstract class ri<CFG extends rh, T extends ri<CFG, T>>
  extends rf<T>
{
  protected int i;
  
  protected ri(qf<? extends qb> paramqf, py parampy, ye<?> paramye, yh paramyh, rl paramrl, adk paramadk, qs paramqs, int paramInt)
  {
    super(paramqf, parampy, paramye, paramyh, paramrl, paramadk, paramqs);
    this.i = paramInt;
  }
  
  protected ri(ri<CFG, T> paramri, rg paramrg, yh paramyh)
  {
    super(paramri, paramrg, paramyh);
    this.i = paramri.i;
  }
  
  static <F extends Enum<F>,  extends rh> int d(Class<F> paramClass)
  {
    paramClass = (Enum[])paramClass.getEnumConstants();
    int m = paramClass.length;
    int k = 0;
    int j = 0;
    if (k < m)
    {
      Object localObject = paramClass[k];
      if (!((rh)localObject).a()) {
        break label60;
      }
      j = ((rh)localObject).b() | j;
    }
    label60:
    for (;;)
    {
      k += 1;
      break;
      return j;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */