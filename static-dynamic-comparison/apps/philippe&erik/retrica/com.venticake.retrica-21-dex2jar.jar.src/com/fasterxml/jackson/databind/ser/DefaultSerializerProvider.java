package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.JsonSerializer.None;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;

public abstract class DefaultSerializerProvider
  extends SerializerProvider
  implements Serializable
{
  protected DefaultSerializerProvider() {}
  
  protected DefaultSerializerProvider(SerializerProvider paramSerializerProvider, SerializationConfig paramSerializationConfig, SerializerFactory paramSerializerFactory)
  {
    super(paramSerializerProvider, paramSerializationConfig, paramSerializerFactory);
  }
  
  public abstract DefaultSerializerProvider createInstance(SerializationConfig paramSerializationConfig, SerializerFactory paramSerializerFactory);
  
  public ObjectIdGenerator<?> objectIdGeneratorInstance(Annotated paramAnnotated, ObjectIdInfo paramObjectIdInfo)
  {
    Class localClass = paramObjectIdInfo.getGeneratorType();
    HandlerInstantiator localHandlerInstantiator = this._config.getHandlerInstantiator();
    if (localHandlerInstantiator != null) {}
    for (paramAnnotated = localHandlerInstantiator.objectIdGeneratorInstance(this._config, paramAnnotated, localClass);; paramAnnotated = (ObjectIdGenerator)ClassUtil.createInstance(localClass, this._config.canOverrideAccessModifiers())) {
      return paramAnnotated.forScope(paramObjectIdInfo.getScope());
    }
  }
  
  public JsonSerializer<Object> serializerInstance(Annotated paramAnnotated, Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof JsonSerializer)) {
      paramAnnotated = (JsonSerializer)paramObject;
    }
    for (;;)
    {
      return _handleResolvable(paramAnnotated);
      if (!(paramObject instanceof Class)) {
        throw new IllegalStateException("AnnotationIntrospector returned serializer definition of type " + paramObject.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
      }
      paramObject = (Class)paramObject;
      if ((paramObject == JsonSerializer.None.class) || (paramObject == NoClass.class)) {
        break;
      }
      if (!JsonSerializer.class.isAssignableFrom((Class)paramObject)) {
        throw new IllegalStateException("AnnotationIntrospector returned Class " + ((Class)paramObject).getName() + "; expected Class<JsonSerializer>");
      }
      HandlerInstantiator localHandlerInstantiator = this._config.getHandlerInstantiator();
      if (localHandlerInstantiator != null) {
        paramAnnotated = localHandlerInstantiator.serializerInstance(this._config, paramAnnotated, (Class)paramObject);
      } else {
        paramAnnotated = (JsonSerializer)ClassUtil.createInstance((Class)paramObject, this._config.canOverrideAccessModifiers());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/DefaultSerializerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */