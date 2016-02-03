package org.codehaus.jackson.map.util;

import java.util.HashMap;
import org.codehaus.jackson.map.AnnotationIntrospector;

public class EnumResolver
{
  protected final Class _enumClass;
  protected final Enum[] _enums;
  protected final HashMap _enumsById;
  
  protected EnumResolver(Class paramClass, Enum[] paramArrayOfEnum, HashMap paramHashMap)
  {
    this._enumClass = paramClass;
    this._enums = paramArrayOfEnum;
    this._enumsById = paramHashMap;
  }
  
  public static EnumResolver constructFor(Class paramClass, AnnotationIntrospector paramAnnotationIntrospector)
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
  
  public static EnumResolver constructUnsafe(Class paramClass, AnnotationIntrospector paramAnnotationIntrospector)
  {
    return constructFor(paramClass, paramAnnotationIntrospector);
  }
  
  public static EnumResolver constructUnsafeUsingToString(Class paramClass)
  {
    return constructUsingToString(paramClass);
  }
  
  public static EnumResolver constructUsingToString(Class paramClass)
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
  
  public Enum findEnum(String paramString)
  {
    return (Enum)this._enumsById.get(paramString);
  }
  
  public Enum getEnum(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this._enums.length)) {
      return null;
    }
    return this._enums[paramInt];
  }
  
  public Class getEnumClass()
  {
    return this._enumClass;
  }
  
  public int lastValidIndex()
  {
    return this._enums.length - 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/util/EnumResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */