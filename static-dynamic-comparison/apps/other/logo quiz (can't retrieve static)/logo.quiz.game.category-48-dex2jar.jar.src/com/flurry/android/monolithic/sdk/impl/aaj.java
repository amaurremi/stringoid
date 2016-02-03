package com.flurry.android.monolithic.sdk.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aaj
{
  private final aak[] a;
  private final int b;
  
  public aaj(Map<aau, ra<Object>> paramMap)
  {
    int i = a(paramMap.size());
    this.b = i;
    aak[] arrayOfaak = new aak[i];
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      aau localaau = (aau)localEntry.getKey();
      int j = localaau.hashCode() & i - 1;
      arrayOfaak[j] = new aak(arrayOfaak[j], localaau, (ra)localEntry.getValue());
    }
    this.a = arrayOfaak;
  }
  
  private static final int a(int paramInt)
  {
    if (paramInt <= 64) {
      paramInt += paramInt;
    }
    int i;
    for (;;)
    {
      i = 8;
      while (i < paramInt) {
        i += i;
      }
      paramInt = (paramInt >> 2) + paramInt;
    }
    return i;
  }
  
  public ra<Object> a(aau paramaau)
  {
    int i = paramaau.hashCode();
    int j = this.a.length;
    aak localaak2 = this.a[(i & j - 1)];
    if (localaak2 == null) {
      return null;
    }
    aak localaak1 = localaak2;
    if (paramaau.equals(localaak2.a)) {
      return localaak2.b;
    }
    do
    {
      localaak2 = localaak1.c;
      if (localaak2 == null) {
        break;
      }
      localaak1 = localaak2;
    } while (!paramaau.equals(localaak2.a));
    return localaak2.b;
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */