package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;

public class EnumResolver<T extends Enum<T>>
  implements Serializable
{
  protected final Class<T> _enumClass;
  protected final T[] _enums;
  protected final HashMap<String, T> _enumsById;
  
  protected EnumResolver(Class<T> paramClass, T[] paramArrayOfT, HashMap<String, T> paramHashMap)
  {
    this._enumClass = paramClass;
    this._enums = paramArrayOfT;
    this._enumsById = paramHashMap;
  }
  
  public static <ET extends Enum<ET>> EnumResolver<ET> constructFor(Class<ET> paramClass, AnnotationIntrospector paramAnnotationIntrospector)
  {
    Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
    if (arrayOfEnum == null) {
      throw new IllegalArgumentException("No enum constants for class " + paramClass.getName());
    }
    HashMap localHashMap = new HashMap();
    int j = arrayOfEnum.length;
    int i = 0;
    while (i < j)
    {
      Enum localEnum = arrayOfEnum[i];
      localHashMap.put(paramAnnotationIntrospector.findEnumValue(localEnum), localEnum);
      i += 1;
    }
    return new EnumResolver(paramClass, arrayOfEnum, localHashMap);
  }
  
  public static EnumResolver<?> constructUnsafe(Class<?> paramClass, AnnotationIntrospector paramAnnotationIntrospector)
  {
    return constructFor(paramClass, paramAnnotationIntrospector);
  }
  
  public static EnumResolver<?> constructUnsafeUsingMethod(Class<?> paramClass, Method paramMethod)
  {
    return constructUsingMethod(paramClass, paramMethod);
  }
  
  public static EnumResolver<?> constructUnsafeUsingToString(Class<?> paramClass)
  {
    return constructUsingToString(paramClass);
  }
  
  public static <ET extends Enum<ET>> EnumResolver<ET> constructUsingMethod(Class<ET> paramClass, Method paramMethod)
  {
    Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
    HashMap localHashMap = new HashMap();
    int i = arrayOfEnum.length;
    for (;;)
    {
      int j = i - 1;
      if (j >= 0)
      {
        Enum localEnum = arrayOfEnum[j];
        try
        {
          Object localObject = paramMethod.invoke(localEnum, new Object[0]);
          i = j;
          if (localObject != null)
          {
            localHashMap.put(localObject.toString(), localEnum);
            i = j;
          }
        }
        catch (Exception paramClass)
        {
          throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + localEnum + ": " + paramClass.getMessage());
        }
      }
    }
    return new EnumResolver(paramClass, arrayOfEnum, localHashMap);
  }
  
  public static <ET extends Enum<ET>> EnumResolver<ET> constructUsingToString(Class<ET> paramClass)
  {
    Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
    HashMap localHashMap = new HashMap();
    int i = arrayOfEnum.length;
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      Enum localEnum = arrayOfEnum[i];
      localHashMap.put(localEnum.toString(), localEnum);
    }
    return new EnumResolver(paramClass, arrayOfEnum, localHashMap);
  }
  
  public T findEnum(String paramString)
  {
    return (Enum)this._enumsById.get(paramString);
  }
  
  public T getEnum(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this._enums.length)) {
      return null;
    }
    return this._enums[paramInt];
  }
  
  public Class<T> getEnumClass()
  {
    return this._enumClass;
  }
  
  public int lastValidIndex()
  {
    return this._enums.length - 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/EnumResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */