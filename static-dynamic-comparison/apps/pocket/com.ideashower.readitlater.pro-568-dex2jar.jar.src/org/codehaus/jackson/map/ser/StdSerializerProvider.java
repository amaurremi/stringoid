package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.ContextualSerializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerFactory;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.impl.FailingSerializer;
import org.codehaus.jackson.map.ser.impl.ReadOnlyClassToSerializerMap;
import org.codehaus.jackson.map.ser.impl.SerializerCache;
import org.codehaus.jackson.map.ser.impl.UnknownSerializer;
import org.codehaus.jackson.map.ser.std.NullSerializer;
import org.codehaus.jackson.map.ser.std.StdKeySerializer;
import org.codehaus.jackson.map.ser.std.StdKeySerializers;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.map.util.RootNameLookup;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.schema.SchemaAware;
import org.codehaus.jackson.type.JavaType;

public class StdSerializerProvider
  extends SerializerProvider
{
  static final boolean CACHE_UNKNOWN_MAPPINGS = false;
  @Deprecated
  public static final JsonSerializer DEFAULT_KEY_SERIALIZER = new StdKeySerializer();
  public static final JsonSerializer DEFAULT_NULL_KEY_SERIALIZER = new FailingSerializer("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
  public static final JsonSerializer DEFAULT_UNKNOWN_SERIALIZER = new UnknownSerializer();
  protected DateFormat _dateFormat;
  protected JsonSerializer _keySerializer;
  protected final ReadOnlyClassToSerializerMap _knownSerializers;
  protected JsonSerializer _nullKeySerializer = DEFAULT_NULL_KEY_SERIALIZER;
  protected JsonSerializer _nullValueSerializer = NullSerializer.instance;
  protected final RootNameLookup _rootNames;
  protected final SerializerCache _serializerCache;
  protected final SerializerFactory _serializerFactory;
  protected JsonSerializer _unknownTypeSerializer = DEFAULT_UNKNOWN_SERIALIZER;
  
  public StdSerializerProvider()
  {
    super(null);
    this._serializerFactory = null;
    this._serializerCache = new SerializerCache();
    this._knownSerializers = null;
    this._rootNames = new RootNameLookup();
  }
  
  protected StdSerializerProvider(SerializationConfig paramSerializationConfig, StdSerializerProvider paramStdSerializerProvider, SerializerFactory paramSerializerFactory)
  {
    super(paramSerializationConfig);
    if (paramSerializationConfig == null) {
      throw new NullPointerException();
    }
    this._serializerFactory = paramSerializerFactory;
    this._serializerCache = paramStdSerializerProvider._serializerCache;
    this._unknownTypeSerializer = paramStdSerializerProvider._unknownTypeSerializer;
    this._keySerializer = paramStdSerializerProvider._keySerializer;
    this._nullValueSerializer = paramStdSerializerProvider._nullValueSerializer;
    this._nullKeySerializer = paramStdSerializerProvider._nullKeySerializer;
    this._rootNames = paramStdSerializerProvider._rootNames;
    this._knownSerializers = this._serializerCache.getReadOnlyLookupMap();
  }
  
  protected JsonSerializer _createAndCacheUntypedSerializer(Class paramClass, BeanProperty paramBeanProperty)
  {
    try
    {
      paramBeanProperty = _createUntypedSerializer(this._config.constructType(paramClass), paramBeanProperty);
      if (paramBeanProperty != null) {
        this._serializerCache.addAndResolveNonTypedSerializer(paramClass, paramBeanProperty, this);
      }
      return paramBeanProperty;
    }
    catch (IllegalArgumentException paramClass)
    {
      throw new JsonMappingException(paramClass.getMessage(), null, paramClass);
    }
  }
  
  protected JsonSerializer _createAndCacheUntypedSerializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    try
    {
      paramBeanProperty = _createUntypedSerializer(paramJavaType, paramBeanProperty);
      if (paramBeanProperty != null) {
        this._serializerCache.addAndResolveNonTypedSerializer(paramJavaType, paramBeanProperty, this);
      }
      return paramBeanProperty;
    }
    catch (IllegalArgumentException paramJavaType)
    {
      throw new JsonMappingException(paramJavaType.getMessage(), null, paramJavaType);
    }
  }
  
  protected JsonSerializer _createUntypedSerializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    return this._serializerFactory.createSerializer(this._config, paramJavaType, paramBeanProperty);
  }
  
  protected JsonSerializer _findExplicitUntypedSerializer(Class paramClass, BeanProperty paramBeanProperty)
  {
    Object localObject = this._knownSerializers.untypedValueSerializer(paramClass);
    if (localObject != null) {}
    JsonSerializer localJsonSerializer;
    do
    {
      return (JsonSerializer)localObject;
      localJsonSerializer = this._serializerCache.untypedValueSerializer(paramClass);
      localObject = localJsonSerializer;
    } while (localJsonSerializer != null);
    try
    {
      paramClass = _createAndCacheUntypedSerializer(paramClass, paramBeanProperty);
      return paramClass;
    }
    catch (Exception paramClass) {}
    return null;
  }
  
  protected JsonSerializer _handleContextualResolvable(JsonSerializer paramJsonSerializer, BeanProperty paramBeanProperty)
  {
    if (!(paramJsonSerializer instanceof ContextualSerializer)) {
      return paramJsonSerializer;
    }
    paramBeanProperty = ((ContextualSerializer)paramJsonSerializer).createContextual(this._config, paramBeanProperty);
    if (paramBeanProperty != paramJsonSerializer)
    {
      paramJsonSerializer = paramBeanProperty;
      if ((paramBeanProperty instanceof ResolvableSerializer))
      {
        ((ResolvableSerializer)paramBeanProperty).resolve(this);
        paramJsonSerializer = paramBeanProperty;
      }
    }
    for (;;)
    {
      return paramJsonSerializer;
    }
  }
  
  protected void _reportIncompatibleRootType(Object paramObject, JavaType paramJavaType)
  {
    if ((paramJavaType.isPrimitive()) && (ClassUtil.wrapperType(paramJavaType.getRawClass()).isAssignableFrom(paramObject.getClass()))) {
      return;
    }
    throw new JsonMappingException("Incompatible types: declared root type (" + paramJavaType + ") vs " + paramObject.getClass().getName());
  }
  
  protected void _serializeValue(JsonGenerator paramJsonGenerator, Object paramObject)
  {
    Object localObject;
    int i;
    if (paramObject == null)
    {
      localObject = getNullValueSerializer();
      i = 0;
    }
    for (;;)
    {
      try
      {
        ((JsonSerializer)localObject).serialize(paramObject, paramJsonGenerator, this);
        if (i != 0) {
          paramJsonGenerator.writeEndObject();
        }
        return;
      }
      catch (IOException paramJsonGenerator)
      {
        JsonSerializer localJsonSerializer;
        boolean bool;
        throw paramJsonGenerator;
      }
      catch (Exception localException)
      {
        paramObject = localException.getMessage();
        paramJsonGenerator = (JsonGenerator)paramObject;
        if (paramObject != null) {
          continue;
        }
        paramJsonGenerator = "[no message for " + localException.getClass().getName() + "]";
        throw new JsonMappingException(paramJsonGenerator, localException);
      }
      localJsonSerializer = findTypedValueSerializer(paramObject.getClass(), true, null);
      bool = this._config.isEnabled(SerializationConfig.Feature.WRAP_ROOT_VALUE);
      i = bool;
      localObject = localJsonSerializer;
      if (bool)
      {
        paramJsonGenerator.writeStartObject();
        paramJsonGenerator.writeFieldName(this._rootNames.findRootName(paramObject.getClass(), this._config));
        i = bool;
        localObject = localJsonSerializer;
      }
    }
  }
  
  protected void _serializeValue(JsonGenerator paramJsonGenerator, Object paramObject, JavaType paramJavaType)
  {
    Object localObject;
    int i;
    if (paramObject == null)
    {
      localObject = getNullValueSerializer();
      i = 0;
    }
    for (;;)
    {
      try
      {
        ((JsonSerializer)localObject).serialize(paramObject, paramJsonGenerator, this);
        if (i != 0) {
          paramJsonGenerator.writeEndObject();
        }
        return;
      }
      catch (IOException paramJsonGenerator)
      {
        JsonSerializer localJsonSerializer;
        boolean bool;
        throw paramJsonGenerator;
      }
      catch (Exception paramJavaType)
      {
        paramObject = paramJavaType.getMessage();
        paramJsonGenerator = (JsonGenerator)paramObject;
        if (paramObject != null) {
          continue;
        }
        paramJsonGenerator = "[no message for " + paramJavaType.getClass().getName() + "]";
        throw new JsonMappingException(paramJsonGenerator, paramJavaType);
      }
      if (!paramJavaType.getRawClass().isAssignableFrom(paramObject.getClass())) {
        _reportIncompatibleRootType(paramObject, paramJavaType);
      }
      localJsonSerializer = findTypedValueSerializer(paramJavaType, true, null);
      bool = this._config.isEnabled(SerializationConfig.Feature.WRAP_ROOT_VALUE);
      localObject = localJsonSerializer;
      i = bool;
      if (bool)
      {
        paramJsonGenerator.writeStartObject();
        paramJsonGenerator.writeFieldName(this._rootNames.findRootName(paramJavaType, this._config));
        localObject = localJsonSerializer;
        i = bool;
      }
    }
  }
  
  public int cachedSerializersCount()
  {
    return this._serializerCache.size();
  }
  
  protected StdSerializerProvider createInstance(SerializationConfig paramSerializationConfig, SerializerFactory paramSerializerFactory)
  {
    return new StdSerializerProvider(paramSerializationConfig, this, paramSerializerFactory);
  }
  
  public void defaultSerializeDateKey(long paramLong, JsonGenerator paramJsonGenerator)
  {
    if (isEnabled(SerializationConfig.Feature.WRITE_DATE_KEYS_AS_TIMESTAMPS))
    {
      paramJsonGenerator.writeFieldName(String.valueOf(paramLong));
      return;
    }
    if (this._dateFormat == null) {
      this._dateFormat = ((DateFormat)this._config.getDateFormat().clone());
    }
    paramJsonGenerator.writeFieldName(this._dateFormat.format(new Date(paramLong)));
  }
  
  public void defaultSerializeDateKey(Date paramDate, JsonGenerator paramJsonGenerator)
  {
    if (isEnabled(SerializationConfig.Feature.WRITE_DATE_KEYS_AS_TIMESTAMPS))
    {
      paramJsonGenerator.writeFieldName(String.valueOf(paramDate.getTime()));
      return;
    }
    if (this._dateFormat == null) {
      this._dateFormat = ((DateFormat)this._config.getDateFormat().clone());
    }
    paramJsonGenerator.writeFieldName(this._dateFormat.format(paramDate));
  }
  
  public final void defaultSerializeDateValue(long paramLong, JsonGenerator paramJsonGenerator)
  {
    if (isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS))
    {
      paramJsonGenerator.writeNumber(paramLong);
      return;
    }
    if (this._dateFormat == null) {
      this._dateFormat = ((DateFormat)this._config.getDateFormat().clone());
    }
    paramJsonGenerator.writeString(this._dateFormat.format(new Date(paramLong)));
  }
  
  public final void defaultSerializeDateValue(Date paramDate, JsonGenerator paramJsonGenerator)
  {
    if (isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS))
    {
      paramJsonGenerator.writeNumber(paramDate.getTime());
      return;
    }
    if (this._dateFormat == null) {
      this._dateFormat = ((DateFormat)this._config.getDateFormat().clone());
    }
    paramJsonGenerator.writeString(this._dateFormat.format(paramDate));
  }
  
  public JsonSerializer findKeySerializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    JsonSerializer localJsonSerializer2 = this._serializerFactory.createKeySerializer(this._config, paramJavaType, paramBeanProperty);
    JsonSerializer localJsonSerializer1 = localJsonSerializer2;
    if (localJsonSerializer2 == null) {
      if (this._keySerializer != null) {
        break label61;
      }
    }
    label61:
    for (localJsonSerializer1 = StdKeySerializers.getStdKeySerializer(paramJavaType);; localJsonSerializer1 = this._keySerializer)
    {
      paramJavaType = localJsonSerializer1;
      if ((localJsonSerializer1 instanceof ContextualSerializer)) {
        paramJavaType = ((ContextualSerializer)localJsonSerializer1).createContextual(this._config, paramBeanProperty);
      }
      return paramJavaType;
    }
  }
  
  public JsonSerializer findTypedValueSerializer(Class paramClass, boolean paramBoolean, BeanProperty paramBeanProperty)
  {
    Object localObject = this._knownSerializers.typedValueSerializer(paramClass);
    if (localObject != null) {}
    JsonSerializer localJsonSerializer;
    do
    {
      return (JsonSerializer)localObject;
      localJsonSerializer = this._serializerCache.typedValueSerializer(paramClass);
      localObject = localJsonSerializer;
    } while (localJsonSerializer != null);
    localObject = findValueSerializer(paramClass, paramBeanProperty);
    paramBeanProperty = this._serializerFactory.createTypeSerializer(this._config, this._config.constructType(paramClass), paramBeanProperty);
    if (paramBeanProperty != null) {}
    for (paramBeanProperty = new StdSerializerProvider.WrappedSerializer(paramBeanProperty, (JsonSerializer)localObject);; paramBeanProperty = (BeanProperty)localObject)
    {
      localObject = paramBeanProperty;
      if (!paramBoolean) {
        break;
      }
      this._serializerCache.addTypedSerializer(paramClass, paramBeanProperty);
      return paramBeanProperty;
    }
  }
  
  public JsonSerializer findTypedValueSerializer(JavaType paramJavaType, boolean paramBoolean, BeanProperty paramBeanProperty)
  {
    Object localObject = this._knownSerializers.typedValueSerializer(paramJavaType);
    if (localObject != null) {}
    JsonSerializer localJsonSerializer;
    do
    {
      return (JsonSerializer)localObject;
      localJsonSerializer = this._serializerCache.typedValueSerializer(paramJavaType);
      localObject = localJsonSerializer;
    } while (localJsonSerializer != null);
    localObject = findValueSerializer(paramJavaType, paramBeanProperty);
    paramBeanProperty = this._serializerFactory.createTypeSerializer(this._config, paramJavaType, paramBeanProperty);
    if (paramBeanProperty != null) {}
    for (paramBeanProperty = new StdSerializerProvider.WrappedSerializer(paramBeanProperty, (JsonSerializer)localObject);; paramBeanProperty = (BeanProperty)localObject)
    {
      localObject = paramBeanProperty;
      if (!paramBoolean) {
        break;
      }
      this._serializerCache.addTypedSerializer(paramJavaType, paramBeanProperty);
      return paramBeanProperty;
    }
  }
  
  public JsonSerializer findValueSerializer(Class paramClass, BeanProperty paramBeanProperty)
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
          localJsonSerializer2 = _createAndCacheUntypedSerializer(paramClass, paramBeanProperty);
          localJsonSerializer1 = localJsonSerializer2;
          if (localJsonSerializer2 == null) {
            return getUnknownTypeSerializer(paramClass);
          }
        }
      }
    }
    return _handleContextualResolvable(localJsonSerializer1, paramBeanProperty);
  }
  
  public JsonSerializer findValueSerializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    JsonSerializer localJsonSerializer2 = this._knownSerializers.untypedValueSerializer(paramJavaType);
    JsonSerializer localJsonSerializer1 = localJsonSerializer2;
    if (localJsonSerializer2 == null)
    {
      localJsonSerializer2 = this._serializerCache.untypedValueSerializer(paramJavaType);
      localJsonSerializer1 = localJsonSerializer2;
      if (localJsonSerializer2 == null)
      {
        localJsonSerializer2 = _createAndCacheUntypedSerializer(paramJavaType, paramBeanProperty);
        localJsonSerializer1 = localJsonSerializer2;
        if (localJsonSerializer2 == null) {
          return getUnknownTypeSerializer(paramJavaType.getRawClass());
        }
      }
    }
    return _handleContextualResolvable(localJsonSerializer1, paramBeanProperty);
  }
  
  public void flushCachedSerializers()
  {
    this._serializerCache.flush();
  }
  
  public JsonSchema generateJsonSchema(Class paramClass, SerializationConfig paramSerializationConfig, SerializerFactory paramSerializerFactory)
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("A class must be provided");
    }
    paramSerializationConfig = createInstance(paramSerializationConfig, paramSerializerFactory);
    if (paramSerializationConfig.getClass() != getClass()) {
      throw new IllegalStateException("Broken serializer provider: createInstance returned instance of type " + paramSerializationConfig.getClass() + "; blueprint of type " + getClass());
    }
    paramSerializerFactory = paramSerializationConfig.findValueSerializer(paramClass, null);
    if ((paramSerializerFactory instanceof SchemaAware)) {}
    for (paramSerializationConfig = ((SchemaAware)paramSerializerFactory).getSchema(paramSerializationConfig, null); !(paramSerializationConfig instanceof ObjectNode); paramSerializationConfig = JsonSchema.getDefaultSchemaNode()) {
      throw new IllegalArgumentException("Class " + paramClass.getName() + " would not be serialized as a JSON object and therefore has no schema");
    }
    return new JsonSchema((ObjectNode)paramSerializationConfig);
  }
  
  public JsonSerializer getNullKeySerializer()
  {
    return this._nullKeySerializer;
  }
  
  public JsonSerializer getNullValueSerializer()
  {
    return this._nullValueSerializer;
  }
  
  public JsonSerializer getUnknownTypeSerializer(Class paramClass)
  {
    return this._unknownTypeSerializer;
  }
  
  public boolean hasSerializerFor(SerializationConfig paramSerializationConfig, Class paramClass, SerializerFactory paramSerializerFactory)
  {
    return createInstance(paramSerializationConfig, paramSerializerFactory)._findExplicitUntypedSerializer(paramClass, null) != null;
  }
  
  public final void serializeValue(SerializationConfig paramSerializationConfig, JsonGenerator paramJsonGenerator, Object paramObject, SerializerFactory paramSerializerFactory)
  {
    if (paramSerializerFactory == null) {
      throw new IllegalArgumentException("Can not pass null serializerFactory");
    }
    paramSerializationConfig = createInstance(paramSerializationConfig, paramSerializerFactory);
    if (paramSerializationConfig.getClass() != getClass()) {
      throw new IllegalStateException("Broken serializer provider: createInstance returned instance of type " + paramSerializationConfig.getClass() + "; blueprint of type " + getClass());
    }
    paramSerializationConfig._serializeValue(paramJsonGenerator, paramObject);
  }
  
  public final void serializeValue(SerializationConfig paramSerializationConfig, JsonGenerator paramJsonGenerator, Object paramObject, JavaType paramJavaType, SerializerFactory paramSerializerFactory)
  {
    if (paramSerializerFactory == null) {
      throw new IllegalArgumentException("Can not pass null serializerFactory");
    }
    paramSerializationConfig = createInstance(paramSerializationConfig, paramSerializerFactory);
    if (paramSerializationConfig.getClass() != getClass()) {
      throw new IllegalStateException("Broken serializer provider: createInstance returned instance of type " + paramSerializationConfig.getClass() + "; blueprint of type " + getClass());
    }
    paramSerializationConfig._serializeValue(paramJsonGenerator, paramObject, paramJavaType);
  }
  
  public void setDefaultKeySerializer(JsonSerializer paramJsonSerializer)
  {
    if (paramJsonSerializer == null) {
      throw new IllegalArgumentException("Can not pass null JsonSerializer");
    }
    this._keySerializer = paramJsonSerializer;
  }
  
  public void setNullKeySerializer(JsonSerializer paramJsonSerializer)
  {
    if (paramJsonSerializer == null) {
      throw new IllegalArgumentException("Can not pass null JsonSerializer");
    }
    this._nullKeySerializer = paramJsonSerializer;
  }
  
  public void setNullValueSerializer(JsonSerializer paramJsonSerializer)
  {
    if (paramJsonSerializer == null) {
      throw new IllegalArgumentException("Can not pass null JsonSerializer");
    }
    this._nullValueSerializer = paramJsonSerializer;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/StdSerializerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */