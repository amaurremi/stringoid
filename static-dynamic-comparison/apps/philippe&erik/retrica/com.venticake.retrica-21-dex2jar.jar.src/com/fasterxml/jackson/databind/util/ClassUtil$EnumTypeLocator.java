package com.fasterxml.jackson.databind.util;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;

class ClassUtil$EnumTypeLocator
{
  static final EnumTypeLocator instance = new EnumTypeLocator();
  private final Field enumMapTypeField = locateField(EnumMap.class, "elementType", Class.class);
  private final Field enumSetTypeField = locateField(EnumSet.class, "elementType", Class.class);
  
  private Object get(Object paramObject, Field paramField)
  {
    try
    {
      paramObject = paramField.get(paramObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      throw new IllegalArgumentException((Throwable)paramObject);
    }
  }
  
  private static Field locateField(Class<?> paramClass1, String paramString, Class<?> paramClass2)
  {
    Field[] arrayOfField = paramClass1.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      paramClass1 = arrayOfField[i];
      if ((!paramString.equals(paramClass1.getName())) || (paramClass1.getType() != paramClass2)) {}
    }
    for (;;)
    {
      paramString = paramClass1;
      if (paramClass1 == null)
      {
        j = arrayOfField.length;
        i = 0;
        label56:
        if (i < j)
        {
          paramString = arrayOfField[i];
          if (paramString.getType() == paramClass2)
          {
            if (paramClass1 == null) {
              break label92;
            }
            paramClass1 = null;
          }
        }
      }
      label92:
      do
      {
        return paramClass1;
        i += 1;
        break;
        paramString = paramClass1;
        i += 1;
        paramClass1 = paramString;
        break label56;
        paramString = paramClass1;
        paramClass1 = paramString;
      } while (paramString == null);
      try
      {
        paramString.setAccessible(true);
        return paramString;
      }
      catch (Throwable paramClass1)
      {
        return paramString;
      }
      paramClass1 = null;
    }
  }
  
  public Class<? extends Enum<?>> enumTypeFor(EnumMap<?, ?> paramEnumMap)
  {
    if (this.enumMapTypeField != null) {
      return (Class)get(paramEnumMap, this.enumMapTypeField);
    }
    throw new IllegalStateException("Can not figure out type for EnumMap (odd JDK platform?)");
  }
  
  public Class<? extends Enum<?>> enumTypeFor(EnumSet<?> paramEnumSet)
  {
    if (this.enumSetTypeField != null) {
      return (Class)get(paramEnumSet, this.enumSetTypeField);
    }
    throw new IllegalStateException("Can not figure out type for EnumSet (odd JDK platform?)");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/util/ClassUtil$EnumTypeLocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */