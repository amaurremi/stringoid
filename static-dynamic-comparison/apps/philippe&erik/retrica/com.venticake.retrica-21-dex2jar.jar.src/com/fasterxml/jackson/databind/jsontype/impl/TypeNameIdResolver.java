package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class TypeNameIdResolver
  extends TypeIdResolverBase
{
  protected final MapperConfig<?> _config;
  protected final HashMap<String, JavaType> _idToType;
  protected final HashMap<String, String> _typeToId;
  
  protected TypeNameIdResolver(MapperConfig<?> paramMapperConfig, JavaType paramJavaType, HashMap<String, String> paramHashMap, HashMap<String, JavaType> paramHashMap1)
  {
    super(paramJavaType, paramMapperConfig.getTypeFactory());
    this._config = paramMapperConfig;
    this._typeToId = paramHashMap;
    this._idToType = paramHashMap1;
  }
  
  protected static String _defaultTypeId(Class<?> paramClass)
  {
    paramClass = paramClass.getName();
    int i = paramClass.lastIndexOf('.');
    if (i < 0) {
      return paramClass;
    }
    return paramClass.substring(i + 1);
  }
  
  public static TypeNameIdResolver construct(MapperConfig<?> paramMapperConfig, JavaType paramJavaType, Collection<NamedType> paramCollection, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == paramBoolean2) {
      throw new IllegalArgumentException();
    }
    if (paramBoolean1) {}
    for (HashMap localHashMap1 = new HashMap();; localHashMap1 = null)
    {
      if (paramBoolean2) {}
      for (HashMap localHashMap2 = new HashMap();; localHashMap2 = null)
      {
        if (paramCollection != null)
        {
          Iterator localIterator = paramCollection.iterator();
          if (localIterator.hasNext())
          {
            paramCollection = (NamedType)localIterator.next();
            Class localClass = paramCollection.getType();
            if (paramCollection.hasName()) {}
            for (paramCollection = paramCollection.getName();; paramCollection = _defaultTypeId(localClass))
            {
              if (paramBoolean1) {
                localHashMap1.put(localClass.getName(), paramCollection);
              }
              if (!paramBoolean2) {
                break;
              }
              JavaType localJavaType = (JavaType)localHashMap2.get(paramCollection);
              if ((localJavaType != null) && (localClass.isAssignableFrom(localJavaType.getRawClass()))) {
                break;
              }
              localHashMap2.put(paramCollection, paramMapperConfig.constructType(localClass));
              break;
            }
          }
        }
        return new TypeNameIdResolver(paramMapperConfig, paramJavaType, localHashMap1, localHashMap2);
      }
    }
  }
  
  public String idFromValue(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    String str = localClass.getName();
    synchronized (this._typeToId)
    {
      paramObject = (String)this._typeToId.get(str);
      Object localObject = paramObject;
      if (paramObject == null)
      {
        if (this._config.isAnnotationProcessingEnabled())
        {
          paramObject = this._config.introspectClassAnnotations(localClass);
          paramObject = this._config.getAnnotationIntrospector().findTypeName(((BeanDescription)paramObject).getClassInfo());
        }
        localObject = paramObject;
        if (paramObject == null) {
          localObject = _defaultTypeId(localClass);
        }
        this._typeToId.put(str, localObject);
      }
      return (String)localObject;
    }
  }
  
  public String idFromValueAndType(Object paramObject, Class<?> paramClass)
  {
    return idFromValue(paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[').append(getClass().getName());
    localStringBuilder.append("; id-to-type=").append(this._idToType);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public JavaType typeFromId(String paramString)
  {
    return (JavaType)this._idToType.get(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/jsontype/impl/TypeNameIdResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */