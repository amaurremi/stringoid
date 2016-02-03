package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import java.io.Serializable;

public class ObjectWriter
  implements Serializable
{
  protected static final PrettyPrinter NULL_PRETTY_PRINTER = new MinimalPrettyPrinter();
  protected final SerializationConfig _config;
  protected final JsonFactory _jsonFactory;
  protected final PrettyPrinter _prettyPrinter;
  protected final JsonSerializer<Object> _rootSerializer;
  protected final JavaType _rootType;
  protected final FormatSchema _schema;
  protected final SerializerFactory _serializerFactory;
  protected final DefaultSerializerProvider _serializerProvider;
  
  protected ObjectWriter(ObjectMapper paramObjectMapper, SerializationConfig paramSerializationConfig)
  {
    this._config = paramSerializationConfig;
    this._serializerProvider = paramObjectMapper._serializerProvider;
    this._serializerFactory = paramObjectMapper._serializerFactory;
    this._jsonFactory = paramObjectMapper._jsonFactory;
    this._rootType = null;
    this._rootSerializer = null;
    this._prettyPrinter = null;
    this._schema = null;
  }
  
  protected ObjectWriter(ObjectMapper paramObjectMapper, SerializationConfig paramSerializationConfig, JavaType paramJavaType, PrettyPrinter paramPrettyPrinter)
  {
    this._config = paramSerializationConfig;
    this._serializerProvider = paramObjectMapper._serializerProvider;
    this._serializerFactory = paramObjectMapper._serializerFactory;
    this._jsonFactory = paramObjectMapper._jsonFactory;
    this._rootType = paramJavaType;
    this._prettyPrinter = paramPrettyPrinter;
    this._schema = null;
    this._rootSerializer = _prefetchRootSerializer(paramSerializationConfig, paramJavaType);
  }
  
  protected final JsonSerializer<Object> _prefetchRootSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType)
  {
    if ((paramJavaType == null) || (!this._config.isEnabled(SerializationFeature.EAGER_SERIALIZER_FETCH))) {
      return null;
    }
    try
    {
      paramSerializationConfig = _serializerProvider(paramSerializationConfig).findTypedValueSerializer(paramJavaType, true, null);
      return paramSerializationConfig;
    }
    catch (JsonProcessingException paramSerializationConfig) {}
    return null;
  }
  
  protected DefaultSerializerProvider _serializerProvider(SerializationConfig paramSerializationConfig)
  {
    return this._serializerProvider.createInstance(paramSerializationConfig, this._serializerFactory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ObjectWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */