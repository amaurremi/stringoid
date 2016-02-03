package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.SerializerCache;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap;
import com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer;
import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.TimeZone;

public abstract class SerializerProvider
{
  public static final JsonSerializer<Object> DEFAULT_NULL_KEY_SERIALIZER = new FailingSerializer("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
  public static final JsonSerializer<Object> DEFAULT_UNKNOWN_SERIALIZER = new UnknownSerializer();
  protected static final JavaType TYPE_OBJECT = TypeFactory.defaultInstance().uncheckedSimpleType(Object.class);
  protected final SerializationConfig _config;
  protected JsonSerializer<Object> _keySerializer;
  protected final ReadOnlyClassToSerializerMap _knownSerializers;
  protected JsonSerializer<Object> _nullKeySerializer = DEFAULT_NULL_KEY_SERIALIZER;
  protected JsonSerializer<Object> _nullValueSerializer = NullSerializer.instance;
  protected final RootNameLookup _rootNames;
  protected final Class<?> _serializationView;
  protected final SerializerCache _serializerCache;
  protected final SerializerFactory _serializerFactory;
  protected JsonSerializer<Object> _unknownTypeSerializer = DEFAULT_UNKNOWN_SERIALIZER;
  
  public SerializerProvider()
  {
    this._config = null;
    this._serializerFactory = null;
    this._serializerCache = new SerializerCache();
    this._knownSerializers = null;
    this._rootNames = new RootNameLookup();
    this._serializationView = null;
  }
  
  protected SerializerProvider(SerializerProvider paramSerializerProvider, SerializationConfig paramSerializationConfig, SerializerFactory paramSerializerFactory)
  {
    if (paramSerializationConfig == null) {
      throw new NullPointerException();
    }
    this._serializerFactory = paramSerializerFactory;
    this._config = paramSerializationConfig;
    this._serializerCache = paramSerializerProvider._serializerCache;
    this._unknownTypeSerializer = paramSerializerProvider._unknownTypeSerializer;
    this._keySerializer = paramSerializerProvider._keySerializer;
    this._nullValueSerializer = paramSerializerProvider._nullValueSerializer;
    this._nullKeySerializer = paramSerializerProvider._nullKeySerializer;
    this._rootNames = paramSerializerProvider._rootNames;
    this._knownSerializers = this._serializerCache.getReadOnlyLookupMap();
    this._serializationView = paramSerializationConfig.getActiveView();
  }
  
  protected JsonSerializer<Object> _createAndCacheUntypedSerializer(JavaType paramJavaType)
  {
    try
    {
      JsonSerializer localJsonSerializer = _createUntypedSerializer(paramJavaType);
      if (localJsonSerializer != null) {
        this._serializerCache.addAndResolveNonTypedSerializer(paramJavaType, localJsonSerializer, this);
      }
      return localJsonSerializer;
    }
    catch (IllegalArgumentException paramJavaType)
    {
      throw new JsonMappingException(paramJavaType.getMessage(), null, paramJavaType);
    }
  }
  
  protected JsonSerializer<Object> _createAndCacheUntypedSerializer(Class<?> paramClass)
  {
    try
    {
      JsonSerializer localJsonSerializer = _createUntypedSerializer(this._config.constructType(paramClass));
      if (localJsonSerializer != null) {
        this._serializerCache.addAndResolveNonTypedSerializer(paramClass, localJsonSerializer, this);
      }
      return localJsonSerializer;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw new JsonMappingException(paramClass.getMessage(), null, paramClass);
    }
  }
  
  protected JsonSerializer<Object> _createUntypedSerializer(JavaType paramJavaType)
  {
    return this._serializerFactory.createSerializer(this, paramJavaType, null);
  }
  
  protected JsonSerializer<Object> _handleContextual(JsonSerializer<?> paramJsonSerializer, BeanProperty paramBeanProperty)
  {
    Object localObject = paramJsonSerializer;
    if ((paramJsonSerializer instanceof ContextualSerializer)) {
      localObject = ((ContextualSerializer)paramJsonSerializer).createContextual(this, paramBeanProperty);
    }
    return (JsonSerializer<Object>)localObject;
  }
  
  protected JsonSerializer<Object> _handleContextualResolvable(JsonSerializer<?> paramJsonSerializer, BeanProperty paramBeanProperty)
  {
    if ((paramJsonSerializer instanceof ResolvableSerializer)) {
      ((ResolvableSerializer)paramJsonSerializer).resolve(this);
    }
    return _handleContextual(paramJsonSerializer, paramBeanProperty);
  }
  
  protected JsonSerializer<Object> _handleResolvable(JsonSerializer<?> paramJsonSerializer)
  {
    if ((paramJsonSerializer instanceof ResolvableSerializer)) {
      ((ResolvableSerializer)paramJsonSerializer).resolve(this);
    }
    return paramJsonSerializer;
  }
  
  public final boolean canOverrideAccessModifiers()
  {
    return this._config.canOverrideAccessModifiers();
  }
  
  public JavaType constructType(Type paramType)
  {
    return this._config.getTypeFactory().constructType(paramType);
  }
  
  public JsonSerializer<Object> findKeySerializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    JsonSerializer localJsonSerializer2 = this._serializerFactory.createKeySerializer(this._config, paramJavaType);
    JsonSerializer localJsonSerializer1 = localJsonSerializer2;
    if (localJsonSerializer2 == null) {
      if (this._keySerializer != null) {
        break label41;
      }
    }
    label41:
    for (localJsonSerializer1 = StdKeySerializers.getStdKeySerializer(paramJavaType);; localJsonSerializer1 = this._keySerializer) {
      return _handleContextualResolvable(localJsonSerializer1, paramBeanProperty);
    }
  }
  
  public JsonSerializer<Object> findNullValueSerializer(BeanProperty paramBeanProperty)
  {
    return getDefaultNullValueSerializer();
  }
  
  public JsonSerializer<Object> findTypedValueSerializer(JavaType paramJavaType, boolean paramBoolean, BeanProperty paramBeanProperty)
  {
    Object localObject1 = this._knownSerializers.typedValueSerializer(paramJavaType);
    if (localObject1 != null) {}
    do
    {
      return (JsonSerializer<Object>)localObject1;
      localObject2 = this._serializerCache.typedValueSerializer(paramJavaType);
      localObject1 = localObject2;
    } while (localObject2 != null);
    localObject1 = findValueSerializer(paramJavaType, paramBeanProperty);
    Object localObject2 = this._serializerFactory.createTypeSerializer(this._config, paramJavaType);
    if (localObject2 != null) {}
    for (paramBeanProperty = new TypeWrappedSerializer(((TypeSerializer)localObject2).forProperty(paramBeanProperty), (JsonSerializer)localObject1);; paramBeanProperty = (BeanProperty)localObject1)
    {
      localObject1 = paramBeanProperty;
      if (!paramBoolean) {
        break;
      }
      this._serializerCache.addTypedSerializer(paramJavaType, paramBeanProperty);
      return paramBeanProperty;
    }
  }
  
  public JsonSerializer<Object> findValueSerializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    JsonSerializer localJsonSerializer2 = this._knownSerializers.untypedValueSerializer(paramJavaType);
    JsonSerializer localJsonSerializer1 = localJsonSerializer2;
    if (localJsonSerializer2 == null)
    {
      localJsonSerializer2 = this._serializerCache.untypedValueSerializer(paramJavaType);
      localJsonSerializer1 = localJsonSerializer2;
      if (localJsonSerializer2 == null)
      {
        localJsonSerializer2 = _createAndCacheUntypedSerializer(paramJavaType);
        localJsonSerializer1 = localJsonSerializer2;
        if (localJsonSerializer2 == null) {
          return getUnknownTypeSerializer(paramJavaType.getRawClass());
        }
      }
    }
    return _handleContextual(localJsonSerializer1, paramBeanProperty);
  }
  
  public JsonSerializer<Object> findValueSerializer(Class<?> paramClass, BeanProperty paramBeanProperty)
  {
    JsonSerializer localJsonSerializer2 = this._knownSerializers.untypedValueSerializer(paramClass);
    JsonSerializer localJsonSerializer1 = localJsonSerializer2;
    if (localJsonSerializer2 == null)
    {
      localJsonSerializer2 = this._serializerCache.untypedValueSerializer(paramClass);
      localJsonSerializer1 = localJsonSerializer2;
      if (localJsonSerializer2 == null)
      {
        localJsonSerializer2 = this._serializerCache.untypedValueSerializer(this._config.constructType(paramClass));
        localJsonSerializer1 = localJsonSerializer2;
        if (localJsonSerializer2 == null)
        {
          localJsonSerializer2 = _createAndCacheUntypedSerializer(paramClass);
          localJsonSerializer1 = localJsonSerializer2;
          if (localJsonSerializer2 == null) {
            return getUnknownTypeSerializer(paramClass);
          }
        }
      }
    }
    return _handleContextual(localJsonSerializer1, paramBeanProperty);
  }
  
  public final AnnotationIntrospector getAnnotationIntrospector()
  {
    return this._config.getAnnotationIntrospector();
  }
  
  public final SerializationConfig getConfig()
  {
    return this._config;
  }
  
  public JsonSerializer<Object> getDefaultNullValueSerializer()
  {
    return this._nullValueSerializer;
  }
  
  public Locale getLocale()
  {
    return this._config.getLocale();
  }
  
  public TimeZone getTimeZone()
  {
    return this._config.getTimeZone();
  }
  
  public TypeFactory getTypeFactory()
  {
    return this._config.getTypeFactory();
  }
  
  public JsonSerializer<Object> getUnknownTypeSerializer(Class<?> paramClass)
  {
    return this._unknownTypeSerializer;
  }
  
  public final boolean isEnabled(MapperFeature paramMapperFeature)
  {
    return this._config.isEnabled(paramMapperFeature);
  }
  
  public abstract ObjectIdGenerator<?> objectIdGeneratorInstance(Annotated paramAnnotated, ObjectIdInfo paramObjectIdInfo);
  
  public abstract JsonSerializer<Object> serializerInstance(Annotated paramAnnotated, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/SerializerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */