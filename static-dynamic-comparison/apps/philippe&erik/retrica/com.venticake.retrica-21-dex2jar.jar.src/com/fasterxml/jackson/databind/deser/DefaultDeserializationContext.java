package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer.None;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.LinkedHashMap;

public abstract class DefaultDeserializationContext
  extends DeserializationContext
  implements Serializable
{
  protected transient LinkedHashMap<ObjectIdGenerator.IdKey, ReadableObjectId> _objectIds;
  
  protected DefaultDeserializationContext(DefaultDeserializationContext paramDefaultDeserializationContext, DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, InjectableValues paramInjectableValues)
  {
    super(paramDefaultDeserializationContext, paramDeserializationConfig, paramJsonParser, paramInjectableValues);
  }
  
  protected DefaultDeserializationContext(DeserializerFactory paramDeserializerFactory, DeserializerCache paramDeserializerCache)
  {
    super(paramDeserializerFactory, paramDeserializerCache);
  }
  
  public abstract DefaultDeserializationContext createInstance(DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, InjectableValues paramInjectableValues);
  
  public JsonDeserializer<Object> deserializerInstance(Annotated paramAnnotated, Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null)
    {
      paramObject = localObject;
      return (JsonDeserializer<Object>)paramObject;
    }
    if ((paramObject instanceof JsonDeserializer)) {
      paramAnnotated = (JsonDeserializer)paramObject;
    }
    for (;;)
    {
      paramObject = paramAnnotated;
      if (!(paramAnnotated instanceof ResolvableDeserializer)) {
        break;
      }
      ((ResolvableDeserializer)paramAnnotated).resolve(this);
      return paramAnnotated;
      if (!(paramObject instanceof Class)) {
        throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + paramObject.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
      }
      Class localClass = (Class)paramObject;
      paramObject = localObject;
      if (localClass == JsonDeserializer.None.class) {
        break;
      }
      paramObject = localObject;
      if (localClass == NoClass.class) {
        break;
      }
      if (!JsonDeserializer.class.isAssignableFrom(localClass)) {
        throw new IllegalStateException("AnnotationIntrospector returned Class " + localClass.getName() + "; expected Class<JsonDeserializer>");
      }
      paramObject = this._config.getHandlerInstantiator();
      if (paramObject != null) {
        paramAnnotated = ((HandlerInstantiator)paramObject).deserializerInstance(this._config, paramAnnotated, localClass);
      } else {
        paramAnnotated = (JsonDeserializer)ClassUtil.createInstance(localClass, this._config.canOverrideAccessModifiers());
      }
    }
  }
  
  public ReadableObjectId findObjectId(Object paramObject, ObjectIdGenerator<?> paramObjectIdGenerator)
  {
    paramObjectIdGenerator = paramObjectIdGenerator.key(paramObject);
    if (this._objectIds == null) {
      this._objectIds = new LinkedHashMap();
    }
    ReadableObjectId localReadableObjectId;
    do
    {
      paramObject = new ReadableObjectId(paramObject);
      this._objectIds.put(paramObjectIdGenerator, paramObject);
      return (ReadableObjectId)paramObject;
      localReadableObjectId = (ReadableObjectId)this._objectIds.get(paramObjectIdGenerator);
    } while (localReadableObjectId == null);
    return localReadableObjectId;
  }
  
  public final KeyDeserializer keyDeserializerInstance(Annotated paramAnnotated, Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null)
    {
      paramObject = localObject;
      return (KeyDeserializer)paramObject;
    }
    if ((paramObject instanceof KeyDeserializer)) {
      paramAnnotated = (KeyDeserializer)paramObject;
    }
    for (;;)
    {
      paramObject = paramAnnotated;
      if (!(paramAnnotated instanceof ResolvableDeserializer)) {
        break;
      }
      ((ResolvableDeserializer)paramAnnotated).resolve(this);
      return paramAnnotated;
      if (!(paramObject instanceof Class)) {
        throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + paramObject.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
      }
      Class localClass = (Class)paramObject;
      paramObject = localObject;
      if (localClass == KeyDeserializer.None.class) {
        break;
      }
      paramObject = localObject;
      if (localClass == NoClass.class) {
        break;
      }
      if (!KeyDeserializer.class.isAssignableFrom(localClass)) {
        throw new IllegalStateException("AnnotationIntrospector returned Class " + localClass.getName() + "; expected Class<KeyDeserializer>");
      }
      paramObject = this._config.getHandlerInstantiator();
      if (paramObject != null) {
        paramAnnotated = ((HandlerInstantiator)paramObject).keyDeserializerInstance(this._config, paramAnnotated, localClass);
      } else {
        paramAnnotated = (KeyDeserializer)ClassUtil.createInstance(localClass, this._config.canOverrideAccessModifiers());
      }
    }
  }
  
  public ObjectIdGenerator<?> objectIdGeneratorInstance(Annotated paramAnnotated, ObjectIdInfo paramObjectIdInfo)
  {
    Class localClass = paramObjectIdInfo.getGeneratorType();
    HandlerInstantiator localHandlerInstantiator = this._config.getHandlerInstantiator();
    if (localHandlerInstantiator != null) {}
    for (paramAnnotated = localHandlerInstantiator.objectIdGeneratorInstance(this._config, paramAnnotated, localClass);; paramAnnotated = (ObjectIdGenerator)ClassUtil.createInstance(localClass, this._config.canOverrideAccessModifiers())) {
      return paramAnnotated.forScope(paramObjectIdInfo.getScope());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/DefaultDeserializationContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */