package com.flurry.android.monolithic.sdk.impl;

import java.lang.reflect.Array;

final class aec
{
  aec(Object paramObject, int paramInt) {}
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (paramObject.getClass() != this.a.getClass());
      bool1 = bool2;
    } while (Array.getLength(paramObject) != this.b);
    int i = 0;
    if (i < this.b)
    {
      Object localObject1 = Array.get(this.a, i);
      Object localObject2 = Array.get(paramObject, i);
      if (localObject1 == localObject2) {}
      while ((localObject1 == null) || (localObject1.equals(localObject2)))
      {
        i += 1;
        break;
      }
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */