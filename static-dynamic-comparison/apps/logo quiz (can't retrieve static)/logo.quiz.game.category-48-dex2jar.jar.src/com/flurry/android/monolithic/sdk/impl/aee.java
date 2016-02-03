package com.flurry.android.monolithic.sdk.impl;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class aee
{
  private final EnumMap<?, pw> a;
  
  private aee(Map<Enum<?>, pw> paramMap)
  {
    this.a = new EnumMap(paramMap);
  }
  
  public static aee a(Class<Enum<?>> paramClass, py parampy)
  {
    return b(paramClass, parampy);
  }
  
  public static aee b(Class<Enum<?>> paramClass, py parampy)
  {
    Enum[] arrayOfEnum = (Enum[])adz.g(paramClass).getEnumConstants();
    if (arrayOfEnum != null)
    {
      paramClass = new HashMap();
      int j = arrayOfEnum.length;
      int i = 0;
      while (i < j)
      {
        Enum localEnum = arrayOfEnum[i];
        paramClass.put(localEnum, new pw(parampy.a(localEnum)));
        i += 1;
      }
      return new aee(paramClass);
    }
    throw new IllegalArgumentException("Can not determine enum constants for Class " + paramClass.getName());
  }
  
  public static aee c(Class<Enum<?>> paramClass, py parampy)
  {
    parampy = (Enum[])adz.g(paramClass).getEnumConstants();
    if (parampy != null)
    {
      paramClass = new HashMap();
      int j = parampy.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = parampy[i];
        paramClass.put(localObject, new pw(((Enum)localObject).toString()));
        i += 1;
      }
      return new aee(paramClass);
    }
    throw new IllegalArgumentException("Can not determine enum constants for Class " + paramClass.getName());
  }
  
  public pw a(Enum<?> paramEnum)
  {
    return (pw)this.a.get(paramEnum);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */