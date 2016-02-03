package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.util.EnumMap;
import java.util.EnumSet;

public class ClassNameIdResolver
  extends TypeIdResolverBase
{
  public ClassNameIdResolver(JavaType paramJavaType, TypeFactory paramTypeFactory)
  {
    super(paramJavaType, paramTypeFactory);
  }
  
  protected final String _idFrom(Object paramObject, Class<?> paramClass)
  {
    Object localObject = paramClass;
    if (Enum.class.isAssignableFrom(paramClass))
    {
      localObject = paramClass;
      if (!paramClass.isEnum()) {
        localObject = paramClass.getSuperclass();
      }
    }
    paramClass = ((Class)localObject).getName();
    if (paramClass.startsWith("java.util")) {
      if ((paramObject instanceof EnumSet))
      {
        paramObject = ClassUtil.findEnumType((EnumSet)paramObject);
        paramObject = TypeFactory.defaultInstance().constructCollectionType(EnumSet.class, (Class)paramObject).toCanonical();
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return (String)paramObject;
              if ((paramObject instanceof EnumMap))
              {
                paramObject = ClassUtil.findEnumType((EnumMap)paramObject);
                return TypeFactory.defaultInstance().constructMapType(EnumMap.class, (Class)paramObject, Object.class).toCanonical();
              }
              localObject = paramClass.substring(9);
              if (((String)localObject).startsWith(".Arrays$")) {
                break;
              }
              paramObject = paramClass;
            } while (!((String)localObject).startsWith(".Collections$"));
            paramObject = paramClass;
          } while (paramClass.indexOf("List") < 0);
          return "java.util.ArrayList";
          paramObject = paramClass;
        } while (paramClass.indexOf('$') < 0);
        paramObject = paramClass;
      } while (ClassUtil.getOuterClass((Class)localObject) == null);
      paramObject = paramClass;
    } while (ClassUtil.getOuterClass(this._baseType.getRawClass()) != null);
    return this._baseType.getRawClass().getName();
  }
  
  public String idFromValueAndType(Object paramObject, Class<?> paramClass)
  {
    return _idFrom(paramObject, paramClass);
  }
  
  public JavaType typeFromId(String paramString)
  {
    if (paramString.indexOf('<') > 0) {
      return this._typeFactory.constructFromCanonical(paramString);
    }
    try
    {
      Object localObject = ClassUtil.findClass(paramString);
      localObject = this._typeFactory.constructSpecializedType(this._baseType, (Class)localObject);
      return (JavaType)localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new IllegalArgumentException("Invalid type id '" + paramString + "' (for id type 'Id.class'): no such class found");
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException("Invalid type id '" + paramString + "' (for id type 'Id.class'): " + localException.getMessage(), localException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/jsontype/impl/ClassNameIdResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */