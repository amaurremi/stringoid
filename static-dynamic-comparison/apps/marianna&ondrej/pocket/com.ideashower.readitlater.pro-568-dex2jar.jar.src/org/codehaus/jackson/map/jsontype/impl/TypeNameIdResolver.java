package org.codehaus.jackson.map.jsontype.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.jsontype.NamedType;
import org.codehaus.jackson.type.JavaType;

public class TypeNameIdResolver
  extends TypeIdResolverBase
{
  protected final MapperConfig _config;
  protected final HashMap _idToType;
  protected final HashMap _typeToId;
  
  protected TypeNameIdResolver(MapperConfig paramMapperConfig, JavaType paramJavaType, HashMap paramHashMap1, HashMap paramHashMap2)
  {
    super(paramJavaType, paramMapperConfig.getTypeFactory());
    this._config = paramMapperConfig;
    this._typeToId = paramHashMap1;
    this._idToType = paramHashMap2;
  }
  
  protected static String _defaultTypeId(Class paramClass)
  {
    paramClass = paramClass.getName();
    int i = paramClass.lastIndexOf('.');
    if (i < 0) {
      return paramClass;
    }
    return paramClass.substring(i + 1);
  }
  
  public static TypeNameIdResolver construct(MapperConfig paramMapperConfig, JavaType paramJavaType, Collection paramCollection, boolean paramBoolean1, boolean paramBoolean2)
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
  
  public JsonTypeInfo.Id getMechanism()
  {
    return JsonTypeInfo.Id.NAME;
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
          paramObject = (BasicBeanDescription)this._config.introspectClassAnnotations(localClass);
          paramObject = this._config.getAnnotationIntrospector().findTypeName(((BasicBeanDescription)paramObject).getClassInfo());
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
  
  public String idFromValueAndType(Object paramObject, Class paramClass)
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/jsontype/impl/TypeNameIdResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */