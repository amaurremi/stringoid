package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class DeserializerCache
  implements Serializable
{
  protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _cachedDeserializers = new ConcurrentHashMap(64, 0.75F, 2);
  protected final HashMap<JavaType, JsonDeserializer<Object>> _incompleteDeserializers = new HashMap(8);
  
  private Class<?> _verifyAsClass(Object paramObject, String paramString, Class<?> paramClass)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    do
    {
      return (Class<?>)paramObject;
      if (!(paramObject instanceof Class)) {
        throw new IllegalStateException("AnnotationIntrospector." + paramString + "() returned value of type " + paramObject.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
      }
      paramString = (Class)paramObject;
      if (paramString == paramClass) {
        break;
      }
      paramObject = paramString;
    } while (paramString != NoClass.class);
    return null;
  }
  
  private JavaType modifyTypeByAnnotation(DeserializationContext paramDeserializationContext, Annotated paramAnnotated, JavaType paramJavaType)
  {
    Object localObject2 = paramDeserializationContext.getAnnotationIntrospector();
    Object localObject3 = ((AnnotationIntrospector)localObject2).findDeserializationType(paramAnnotated, paramJavaType);
    if (localObject3 != null) {}
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = paramJavaType.narrowBy((Class)localObject3);
        paramJavaType = (JavaType)localObject1;
        localObject1 = paramJavaType;
        if (paramJavaType.isContainerType())
        {
          localObject3 = ((AnnotationIntrospector)localObject2).findDeserializationKeyType(paramAnnotated, paramJavaType.getKeyType());
          if (localObject3 == null) {
            break label486;
          }
          if (!(paramJavaType instanceof MapLikeType)) {
            throw new JsonMappingException("Illegal key-type annotation: type " + paramJavaType + " is not a Map(-like) type");
          }
        }
      }
      catch (IllegalArgumentException paramDeserializationContext)
      {
        throw new JsonMappingException("Failed to narrow type " + paramJavaType + " with concrete-type annotation (value " + ((Class)localObject3).getName() + "), method '" + paramAnnotated.getName() + "': " + paramDeserializationContext.getMessage(), null, paramDeserializationContext);
      }
      for (;;)
      {
        try
        {
          localObject1 = ((MapLikeType)paramJavaType).narrowKey((Class)localObject3);
          localObject3 = ((JavaType)localObject1).getKeyType();
          paramJavaType = (JavaType)localObject1;
          if (localObject3 != null)
          {
            paramJavaType = (JavaType)localObject1;
            if (((JavaType)localObject3).getValueHandler() == null)
            {
              localObject3 = ((AnnotationIntrospector)localObject2).findKeyDeserializer(paramAnnotated);
              paramJavaType = (JavaType)localObject1;
              if (localObject3 != null)
              {
                localObject3 = paramDeserializationContext.keyDeserializerInstance(paramAnnotated, localObject3);
                paramJavaType = (JavaType)localObject1;
                if (localObject3 != null)
                {
                  paramJavaType = ((MapLikeType)localObject1).withKeyValueHandler(localObject3);
                  paramJavaType.getKeyType();
                }
              }
            }
          }
          localObject3 = ((AnnotationIntrospector)localObject2).findDeserializationContentType(paramAnnotated, paramJavaType.getContentType());
          if (localObject3 == null) {
            break label483;
          }
          localObject1 = _verifyAsClass(localObject2, "findContentDeserializer", JsonDeserializer.None.class);
        }
        catch (IllegalArgumentException paramDeserializationContext)
        {
          try
          {
            localObject1 = paramJavaType.narrowContentsBy((Class)localObject3);
            paramJavaType = (JavaType)localObject1;
            localObject1 = paramJavaType;
            if (paramJavaType.getContentType().getValueHandler() == null)
            {
              localObject2 = ((AnnotationIntrospector)localObject2).findContentDeserializer(paramAnnotated);
              localObject1 = paramJavaType;
              if (localObject2 != null)
              {
                if (!(localObject2 instanceof JsonDeserializer)) {
                  break label450;
                }
                paramDeserializationContext = (JsonDeserializer)localObject2;
                paramDeserializationContext = null;
                localObject1 = paramJavaType;
                if (paramDeserializationContext != null) {
                  localObject1 = paramJavaType.withContentValueHandler(paramDeserializationContext);
                }
              }
            }
            return (JavaType)localObject1;
          }
          catch (IllegalArgumentException paramDeserializationContext)
          {
            throw new JsonMappingException("Failed to narrow content type " + paramJavaType + " with content-type annotation (" + ((Class)localObject3).getName() + "): " + paramDeserializationContext.getMessage(), null, paramDeserializationContext);
          }
          paramDeserializationContext = paramDeserializationContext;
          throw new JsonMappingException("Failed to narrow key type " + paramJavaType + " with key-type annotation (" + ((Class)localObject3).getName() + "): " + paramDeserializationContext.getMessage(), null, paramDeserializationContext);
        }
        label450:
        if (localObject1 != null)
        {
          paramDeserializationContext = paramDeserializationContext.deserializerInstance(paramAnnotated, localObject1);
        }
        else
        {
          paramDeserializationContext = null;
          continue;
          label483:
          continue;
          label486:
          localObject1 = paramJavaType;
        }
      }
    }
  }
  
  protected JsonDeserializer<Object> _createAndCache2(DeserializationContext paramDeserializationContext, DeserializerFactory paramDeserializerFactory, JavaType paramJavaType)
  {
    boolean bool2;
    do
    {
      try
      {
        paramDeserializerFactory = _createDeserializer(paramDeserializationContext, paramDeserializerFactory, paramJavaType);
        if (paramDeserializerFactory == null)
        {
          paramDeserializationContext = null;
          return paramDeserializationContext;
        }
      }
      catch (IllegalArgumentException paramDeserializationContext)
      {
        throw new JsonMappingException(paramDeserializationContext.getMessage(), null, paramDeserializationContext);
      }
      boolean bool1 = paramDeserializerFactory instanceof ResolvableDeserializer;
      bool2 = paramDeserializerFactory.isCachable();
      if (bool1)
      {
        this._incompleteDeserializers.put(paramJavaType, paramDeserializerFactory);
        ((ResolvableDeserializer)paramDeserializerFactory).resolve(paramDeserializationContext);
        this._incompleteDeserializers.remove(paramJavaType);
      }
      paramDeserializationContext = paramDeserializerFactory;
    } while (!bool2);
    this._cachedDeserializers.put(paramJavaType, paramDeserializerFactory);
    return paramDeserializerFactory;
  }
  
  protected JsonDeserializer<Object> _createAndCacheValueDeserializer(DeserializationContext paramDeserializationContext, DeserializerFactory paramDeserializerFactory, JavaType paramJavaType)
  {
    int i;
    synchronized (this._incompleteDeserializers)
    {
      JsonDeserializer localJsonDeserializer = _findCachedDeserializer(paramJavaType);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
      i = this._incompleteDeserializers.size();
      if (i > 0)
      {
        localJsonDeserializer = (JsonDeserializer)this._incompleteDeserializers.get(paramJavaType);
        if (localJsonDeserializer != null) {
          return localJsonDeserializer;
        }
      }
    }
    try
    {
      paramDeserializationContext = _createAndCache2(paramDeserializationContext, paramDeserializerFactory, paramJavaType);
      if ((i == 0) && (this._incompleteDeserializers.size() > 0)) {
        this._incompleteDeserializers.clear();
      }
      return paramDeserializationContext;
    }
    finally
    {
      paramDeserializationContext = finally;
      if ((i == 0) && (this._incompleteDeserializers.size() > 0)) {
        this._incompleteDeserializers.clear();
      }
      throw paramDeserializationContext;
    }
  }
  
  protected JsonDeserializer<Object> _createDeserializer(DeserializationContext paramDeserializationContext, DeserializerFactory paramDeserializerFactory, JavaType paramJavaType)
  {
    DeserializationConfig localDeserializationConfig = paramDeserializationContext.getConfig();
    Object localObject1;
    if ((!paramJavaType.isAbstract()) && (!paramJavaType.isMapLikeType()))
    {
      localObject1 = paramJavaType;
      if (!paramJavaType.isCollectionLikeType()) {}
    }
    else
    {
      localObject1 = paramDeserializerFactory.mapAbstractType(localDeserializationConfig, paramJavaType);
    }
    paramJavaType = localDeserializationConfig.introspect((JavaType)localObject1);
    Object localObject2 = findDeserializerFromAnnotation(paramDeserializationContext, paramJavaType.getClassInfo());
    if (localObject2 != null) {
      return (JsonDeserializer<Object>)localObject2;
    }
    localObject2 = modifyTypeByAnnotation(paramDeserializationContext, paramJavaType.getClassInfo(), (JavaType)localObject1);
    if (localObject2 != localObject1)
    {
      paramJavaType = localDeserializationConfig.introspect((JavaType)localObject2);
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = paramJavaType.findPOJOBuilder();
      if (localObject2 != null) {
        return paramDeserializerFactory.createBuilderBasedDeserializer(paramDeserializationContext, (JavaType)localObject1, paramJavaType, (Class)localObject2);
      }
      if (((JavaType)localObject1).isEnumType()) {
        return paramDeserializerFactory.createEnumDeserializer(paramDeserializationContext, (JavaType)localObject1, paramJavaType);
      }
      if (((JavaType)localObject1).isContainerType())
      {
        if (((JavaType)localObject1).isArrayType()) {
          return paramDeserializerFactory.createArrayDeserializer(paramDeserializationContext, (ArrayType)localObject1, paramJavaType);
        }
        if (((JavaType)localObject1).isMapLikeType())
        {
          localObject1 = (MapLikeType)localObject1;
          if (((MapLikeType)localObject1).isTrueMapType()) {
            return paramDeserializerFactory.createMapDeserializer(paramDeserializationContext, (MapType)localObject1, paramJavaType);
          }
          return paramDeserializerFactory.createMapLikeDeserializer(paramDeserializationContext, (MapLikeType)localObject1, paramJavaType);
        }
        if (((JavaType)localObject1).isCollectionLikeType())
        {
          localObject2 = paramJavaType.findExpectedFormat(null);
          if ((localObject2 == null) || (((JsonFormat.Value)localObject2).getShape() != JsonFormat.Shape.OBJECT))
          {
            localObject1 = (CollectionLikeType)localObject1;
            if (((CollectionLikeType)localObject1).isTrueCollectionType()) {
              return paramDeserializerFactory.createCollectionDeserializer(paramDeserializationContext, (CollectionType)localObject1, paramJavaType);
            }
            return paramDeserializerFactory.createCollectionLikeDeserializer(paramDeserializationContext, (CollectionLikeType)localObject1, paramJavaType);
          }
        }
      }
      if (JsonNode.class.isAssignableFrom(((JavaType)localObject1).getRawClass())) {
        return paramDeserializerFactory.createTreeDeserializer(localDeserializationConfig, (JavaType)localObject1, paramJavaType);
      }
      return paramDeserializerFactory.createBeanDeserializer(paramDeserializationContext, (JavaType)localObject1, paramJavaType);
    }
  }
  
  protected JsonDeserializer<Object> _findCachedDeserializer(JavaType paramJavaType)
  {
    if (paramJavaType == null) {
      throw new IllegalArgumentException("Null JavaType passed");
    }
    return (JsonDeserializer)this._cachedDeserializers.get(paramJavaType);
  }
  
  protected KeyDeserializer _handleUnknownKeyDeserializer(JavaType paramJavaType)
  {
    throw new JsonMappingException("Can not find a (Map) Key deserializer for type " + paramJavaType);
  }
  
  protected JsonDeserializer<Object> _handleUnknownValueDeserializer(JavaType paramJavaType)
  {
    if (!ClassUtil.isConcrete(paramJavaType.getRawClass())) {
      throw new JsonMappingException("Can not find a Value deserializer for abstract type " + paramJavaType);
    }
    throw new JsonMappingException("Can not find a Value deserializer for type " + paramJavaType);
  }
  
  protected JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext paramDeserializationContext, Annotated paramAnnotated)
  {
    Object localObject = paramDeserializationContext.getAnnotationIntrospector().findDeserializer(paramAnnotated);
    if (localObject == null) {
      return null;
    }
    return paramDeserializationContext.deserializerInstance(paramAnnotated, localObject);
  }
  
  public KeyDeserializer findKeyDeserializer(DeserializationContext paramDeserializationContext, DeserializerFactory paramDeserializerFactory, JavaType paramJavaType)
  {
    KeyDeserializer localKeyDeserializer = paramDeserializerFactory.createKeyDeserializer(paramDeserializationContext, paramJavaType);
    if (localKeyDeserializer == null) {
      paramDeserializerFactory = _handleUnknownKeyDeserializer(paramJavaType);
    }
    do
    {
      return paramDeserializerFactory;
      paramDeserializerFactory = localKeyDeserializer;
    } while (!(localKeyDeserializer instanceof ResolvableDeserializer));
    ((ResolvableDeserializer)localKeyDeserializer).resolve(paramDeserializationContext);
    return localKeyDeserializer;
  }
  
  public JsonDeserializer<Object> findValueDeserializer(DeserializationContext paramDeserializationContext, DeserializerFactory paramDeserializerFactory, JavaType paramJavaType)
  {
    JsonDeserializer localJsonDeserializer = _findCachedDeserializer(paramJavaType);
    if (localJsonDeserializer != null) {
      paramDeserializationContext = localJsonDeserializer;
    }
    do
    {
      return paramDeserializationContext;
      paramDeserializerFactory = _createAndCacheValueDeserializer(paramDeserializationContext, paramDeserializerFactory, paramJavaType);
      paramDeserializationContext = paramDeserializerFactory;
    } while (paramDeserializerFactory != null);
    return _handleUnknownValueDeserializer(paramJavaType);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/DeserializerCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */