package com.flurry.android.monolithic.sdk.impl;

import java.util.LinkedHashMap;

class hv
{
  public static LinkedHashMap<Integer, Long> a(int paramInt, long paramLong)
  {
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramInt = 0;
    if (paramInt < i)
    {
      if (paramInt == 0) {}
      for (paramLong = 0L;; paramLong = l)
      {
        localLinkedHashMap.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
        paramInt += 1;
        break;
      }
    }
    return localLinkedHashMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */