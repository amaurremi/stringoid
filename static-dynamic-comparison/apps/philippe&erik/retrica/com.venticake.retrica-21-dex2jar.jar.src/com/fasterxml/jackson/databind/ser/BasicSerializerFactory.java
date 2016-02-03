package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedStringListSerializer;
import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.StringCollectionSerializer;
import com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumMapSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import com.fasterxml.jackson.databind.ser.std.InetAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.NumberSerializer;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.fasterxml.jackson.databind.ser.std.SqlDateSerializer;
import com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.fasterxml.jackson.databind.ser.std.StdContainerSerializers;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumValues;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.TimeZone;

public abstract class BasicSerializerFactory
  extends SerializerFactory
  implements Serializable
{
  protected static final HashMap<String, JsonSerializer<?>> _concrete = new HashMap();
  protected static final HashMap<String, Class<? extends JsonSerializer<?>>> _concreteLazy = new HashMap();
  protected final SerializerFactoryConfig _factoryConfig;
  protected OptionalHandlerFactory optionalHandlers = OptionalHandlerFactory.instance;
  
  static
  {
    _concrete.put(String.class.getName(), new StringSerializer());
    Object localObject1 = ToStringSerializer.instance;
    _concrete.put(StringBuffer.class.getName(), localObject1);
    _concrete.put(StringBuilder.class.getName(), localObject1);
    _concrete.put(Character.class.getName(), localObject1);
    _concrete.put(Character.TYPE.getName(), localObject1);
    NumberSerializers.addAll(_concrete);
    _concrete.put(Boolean.TYPE.getName(), new BooleanSerializer(true));
    _concrete.put(Boolean.class.getName(), new BooleanSerializer(false));
    localObject1 = new NumberSerializers.NumberSerializer();
    _concrete.put(BigInteger.class.getName(), localObject1);
    _concrete.put(BigDecimal.class.getName(), localObject1);
    _concrete.put(Calendar.class.getName(), CalendarSerializer.instance);
    localObject1 = DateSerializer.instance;
    _concrete.put(java.util.Date.class.getName(), localObject1);
    _concrete.put(Timestamp.class.getName(), localObject1);
    _concrete.put(java.sql.Date.class.getName(), new SqlDateSerializer());
    _concrete.put(Time.class.getName(), new SqlTimeSerializer());
    localObject1 = new StdJdkSerializers().provide().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = localEntry.getValue();
      if ((localObject2 instanceof JsonSerializer))
      {
        _concrete.put(((Class)localEntry.getKey()).getName(), (JsonSerializer)localObject2);
      }
      else if ((localObject2 instanceof Class))
      {
        localObject2 = (Class)localObject2;
        _concreteLazy.put(((Class)localEntry.getKey()).getName(), localObject2);
      }
      else
      {
        throw new IllegalStateException("Internal error: unrecognized value of type " + localEntry.getClass().getName());
      }
    }
    _concreteLazy.put(TokenBuffer.class.getName(), TokenBufferSerializer.class);
  }
  
  protected BasicSerializerFactory(SerializerFactoryConfig paramSerializerFactoryConfig)
  {
    SerializerFactoryConfig localSerializerFactoryConfig = paramSerializerFactoryConfig;
    if (paramSerializerFactoryConfig == null) {
      localSerializerFactoryConfig = new SerializerFactoryConfig();
    }
    this._factoryConfig = localSerializerFactoryConfig;
  }
  
  /* Error */
  protected static <T extends JavaType> T modifySecondaryTypesByAnnotation(SerializationConfig paramSerializationConfig, Annotated paramAnnotated, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 186	com/fasterxml/jackson/databind/SerializationConfig:getAnnotationIntrospector	()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    //   4: astore 4
    //   6: aload_2
    //   7: astore_3
    //   8: aload_2
    //   9: invokevirtual 191	com/fasterxml/jackson/databind/JavaType:isContainerType	()Z
    //   12: ifeq +91 -> 103
    //   15: aload 4
    //   17: aload_1
    //   18: aload_2
    //   19: invokevirtual 195	com/fasterxml/jackson/databind/JavaType:getKeyType	()Lcom/fasterxml/jackson/databind/JavaType;
    //   22: invokevirtual 201	com/fasterxml/jackson/databind/AnnotationIntrospector:findSerializationKeyType	(Lcom/fasterxml/jackson/databind/introspect/Annotated;Lcom/fasterxml/jackson/databind/JavaType;)Ljava/lang/Class;
    //   25: astore_3
    //   26: aload_2
    //   27: astore_0
    //   28: aload_3
    //   29: ifnull +51 -> 80
    //   32: aload_2
    //   33: instanceof 203
    //   36: ifne +35 -> 71
    //   39: new 180	java/lang/IllegalArgumentException
    //   42: dup
    //   43: new 51	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   50: ldc -51
    //   52: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_2
    //   56: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: ldc -46
    //   61: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokespecial 211	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    //   71: aload_2
    //   72: checkcast 203	com/fasterxml/jackson/databind/type/MapType
    //   75: aload_3
    //   76: invokevirtual 215	com/fasterxml/jackson/databind/type/MapType:widenKey	(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    //   79: astore_0
    //   80: aload 4
    //   82: aload_1
    //   83: aload_0
    //   84: invokevirtual 218	com/fasterxml/jackson/databind/JavaType:getContentType	()Lcom/fasterxml/jackson/databind/JavaType;
    //   87: invokevirtual 221	com/fasterxml/jackson/databind/AnnotationIntrospector:findSerializationContentType	(Lcom/fasterxml/jackson/databind/introspect/Annotated;Lcom/fasterxml/jackson/databind/JavaType;)Ljava/lang/Class;
    //   90: astore_1
    //   91: aload_0
    //   92: astore_3
    //   93: aload_1
    //   94: ifnull +9 -> 103
    //   97: aload_0
    //   98: aload_1
    //   99: invokevirtual 224	com/fasterxml/jackson/databind/JavaType:widenContentsBy	(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    //   102: astore_3
    //   103: aload_3
    //   104: areturn
    //   105: astore_0
    //   106: new 180	java/lang/IllegalArgumentException
    //   109: dup
    //   110: new 51	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   117: ldc -30
    //   119: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_2
    //   123: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: ldc -28
    //   128: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_3
    //   132: invokevirtual 34	java/lang/Class:getName	()Ljava/lang/String;
    //   135: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc -26
    //   140: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: invokevirtual 233	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokespecial 211	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   156: athrow
    //   157: astore_2
    //   158: new 180	java/lang/IllegalArgumentException
    //   161: dup
    //   162: new 51	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   169: ldc -21
    //   171: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   178: ldc -19
    //   180: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_1
    //   184: invokevirtual 34	java/lang/Class:getName	()Ljava/lang/String;
    //   187: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc -26
    //   192: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: invokevirtual 233	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   199: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokespecial 211	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramSerializationConfig	SerializationConfig
    //   0	209	1	paramAnnotated	Annotated
    //   0	209	2	paramT	T
    //   7	125	3	localObject	Object
    //   4	77	4	localAnnotationIntrospector	AnnotationIntrospector
    // Exception table:
    //   from	to	target	type
    //   71	80	105	java/lang/IllegalArgumentException
    //   97	103	157	java/lang/IllegalArgumentException
  }
  
  protected JsonSerializer<Object> _findContentSerializer(SerializerProvider paramSerializerProvider, Annotated paramAnnotated)
  {
    Object localObject = paramSerializerProvider.getAnnotationIntrospector().findContentSerializer(paramAnnotated);
    if (localObject != null) {
      return paramSerializerProvider.serializerInstance(paramAnnotated, localObject);
    }
    return null;
  }
  
  protected JsonSerializer<Object> _findKeySerializer(SerializerProvider paramSerializerProvider, Annotated paramAnnotated)
  {
    Object localObject = paramSerializerProvider.getAnnotationIntrospector().findKeySerializer(paramAnnotated);
    if (localObject != null) {
      return paramSerializerProvider.serializerInstance(paramAnnotated, localObject);
    }
    return null;
  }
  
  protected JsonSerializer<?> buildArraySerializer(SerializationConfig paramSerializationConfig, ArrayType paramArrayType, BeanDescription paramBeanDescription, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    Iterator localIterator = customSerializers().iterator();
    while (localIterator.hasNext())
    {
      JsonSerializer localJsonSerializer = ((Serializers)localIterator.next()).findArraySerializer(paramSerializationConfig, paramArrayType, paramBeanDescription, paramTypeSerializer, paramJsonSerializer);
      if (localJsonSerializer != null) {
        paramSerializationConfig = localJsonSerializer;
      }
    }
    do
    {
      return paramSerializationConfig;
      paramSerializationConfig = paramArrayType.getRawClass();
      if ((paramJsonSerializer != null) && (!ClassUtil.isJacksonStdImpl(paramJsonSerializer))) {
        break;
      }
      if (String[].class == paramSerializationConfig) {
        return StringArraySerializer.instance;
      }
      paramBeanDescription = StdArraySerializers.findStandardImpl(paramSerializationConfig);
      paramSerializationConfig = paramBeanDescription;
    } while (paramBeanDescription != null);
    return new ObjectArraySerializer(paramArrayType.getContentType(), paramBoolean, paramTypeSerializer, paramJsonSerializer);
  }
  
  protected JsonSerializer<?> buildCollectionSerializer(SerializationConfig paramSerializationConfig, CollectionType paramCollectionType, BeanDescription paramBeanDescription, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    paramSerializationConfig = paramCollectionType.getRawClass();
    if (EnumSet.class.isAssignableFrom(paramSerializationConfig))
    {
      paramCollectionType = paramCollectionType.getContentType();
      paramSerializationConfig = paramCollectionType;
      if (!paramCollectionType.isEnumType()) {
        paramSerializationConfig = null;
      }
      return StdContainerSerializers.enumSetSerializer(paramSerializationConfig);
    }
    paramBeanDescription = paramCollectionType.getContentType().getRawClass();
    if (isIndexedList(paramSerializationConfig))
    {
      if ((paramBeanDescription == String.class) && ((paramJsonSerializer == null) || (ClassUtil.isJacksonStdImpl(paramJsonSerializer)))) {
        return IndexedStringListSerializer.instance;
      }
      return StdContainerSerializers.indexedListSerializer(paramCollectionType.getContentType(), paramBoolean, paramTypeSerializer, paramJsonSerializer);
    }
    if ((paramBeanDescription == String.class) && ((paramJsonSerializer == null) || (ClassUtil.isJacksonStdImpl(paramJsonSerializer)))) {
      return StringCollectionSerializer.instance;
    }
    return StdContainerSerializers.collectionSerializer(paramCollectionType.getContentType(), paramBoolean, paramTypeSerializer, paramJsonSerializer);
  }
  
  protected JsonSerializer<?> buildContainerSerializer(SerializerProvider paramSerializerProvider, JavaType paramJavaType, BeanDescription paramBeanDescription, boolean paramBoolean)
  {
    SerializationConfig localSerializationConfig = paramSerializerProvider.getConfig();
    TypeSerializer localTypeSerializer = createTypeSerializer(localSerializationConfig, paramJavaType.getContentType());
    if (localTypeSerializer != null) {
      paramBoolean = false;
    }
    for (;;)
    {
      JsonSerializer localJsonSerializer1 = _findContentSerializer(paramSerializerProvider, paramBeanDescription.getClassInfo());
      Object localObject;
      JsonSerializer localJsonSerializer2;
      if (paramJavaType.isMapLikeType())
      {
        localObject = (MapLikeType)paramJavaType;
        paramSerializerProvider = _findKeySerializer(paramSerializerProvider, paramBeanDescription.getClassInfo());
        if (((MapLikeType)localObject).isTrueMapType()) {
          return buildMapSerializer(localSerializationConfig, (MapType)localObject, paramBeanDescription, paramBoolean, paramSerializerProvider, localTypeSerializer, localJsonSerializer1);
        }
        localObject = customSerializers().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localJsonSerializer2 = ((Serializers)((Iterator)localObject).next()).findMapLikeSerializer(localSerializationConfig, (MapLikeType)paramJavaType, paramBeanDescription, paramSerializerProvider, localTypeSerializer, localJsonSerializer1);
          if (localJsonSerializer2 != null) {
            return localJsonSerializer2;
          }
        }
        return null;
      }
      if (paramJavaType.isCollectionLikeType())
      {
        paramSerializerProvider = (CollectionLikeType)paramJavaType;
        if (paramSerializerProvider.isTrueCollectionType())
        {
          paramSerializerProvider = (CollectionType)paramSerializerProvider;
          localObject = customSerializers().iterator();
          while (((Iterator)localObject).hasNext())
          {
            localJsonSerializer2 = ((Serializers)((Iterator)localObject).next()).findCollectionSerializer(localSerializationConfig, paramSerializerProvider, paramBeanDescription, localTypeSerializer, localJsonSerializer1);
            if (localJsonSerializer2 != null) {
              return localJsonSerializer2;
            }
          }
          localObject = paramBeanDescription.findExpectedFormat(null);
          if ((localObject == null) || (((JsonFormat.Value)localObject).getShape() != JsonFormat.Shape.OBJECT)) {
            return buildCollectionSerializer(localSerializationConfig, paramSerializerProvider, paramBeanDescription, paramBoolean, localTypeSerializer, localJsonSerializer1);
          }
        }
        else
        {
          paramSerializerProvider = customSerializers().iterator();
          while (paramSerializerProvider.hasNext())
          {
            localObject = ((Serializers)paramSerializerProvider.next()).findCollectionLikeSerializer(localSerializationConfig, (CollectionLikeType)paramJavaType, paramBeanDescription, localTypeSerializer, localJsonSerializer1);
            if (localObject != null) {
              return (JsonSerializer<?>)localObject;
            }
          }
          return null;
        }
      }
      if (paramJavaType.isArrayType()) {
        return buildArraySerializer(localSerializationConfig, (ArrayType)paramJavaType, paramBeanDescription, paramBoolean, localTypeSerializer, localJsonSerializer1);
      }
      return null;
    }
  }
  
  protected JsonSerializer<?> buildIterableSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription, boolean paramBoolean)
  {
    Object localObject = paramJavaType.containedType(0);
    paramJavaType = (JavaType)localObject;
    if (localObject == null) {
      paramJavaType = TypeFactory.unknownType();
    }
    localObject = createTypeSerializer(paramSerializationConfig, paramJavaType);
    return StdContainerSerializers.iterableSerializer(paramJavaType, usesStaticTyping(paramSerializationConfig, paramBeanDescription, (TypeSerializer)localObject), (TypeSerializer)localObject);
  }
  
  protected JsonSerializer<?> buildIteratorSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription, boolean paramBoolean)
  {
    Object localObject = paramJavaType.containedType(0);
    paramJavaType = (JavaType)localObject;
    if (localObject == null) {
      paramJavaType = TypeFactory.unknownType();
    }
    localObject = createTypeSerializer(paramSerializationConfig, paramJavaType);
    return StdContainerSerializers.iteratorSerializer(paramJavaType, usesStaticTyping(paramSerializationConfig, paramBeanDescription, (TypeSerializer)localObject), (TypeSerializer)localObject);
  }
  
  protected JsonSerializer<?> buildMapSerializer(SerializationConfig paramSerializationConfig, MapType paramMapType, BeanDescription paramBeanDescription, boolean paramBoolean, JsonSerializer<Object> paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer2)
  {
    Iterator localIterator = customSerializers().iterator();
    while (localIterator.hasNext())
    {
      JsonSerializer localJsonSerializer = ((Serializers)localIterator.next()).findMapSerializer(paramSerializationConfig, paramMapType, paramBeanDescription, paramJsonSerializer1, paramTypeSerializer, paramJsonSerializer2);
      if (localJsonSerializer != null) {
        return localJsonSerializer;
      }
    }
    if (EnumMap.class.isAssignableFrom(paramMapType.getRawClass()))
    {
      paramJsonSerializer1 = paramMapType.getKeyType();
      paramBeanDescription = null;
      if (paramJsonSerializer1.isEnumType()) {
        paramBeanDescription = EnumValues.construct(paramJsonSerializer1.getRawClass(), paramSerializationConfig.getAnnotationIntrospector());
      }
      return new EnumMapSerializer(paramMapType.getContentType(), paramBoolean, paramBeanDescription, paramTypeSerializer, paramJsonSerializer2);
    }
    return MapSerializer.construct(paramSerializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(paramBeanDescription.getClassInfo()), paramMapType, paramBoolean, paramTypeSerializer, paramJsonSerializer1, paramJsonSerializer2);
  }
  
  public JsonSerializer<Object> createKeySerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType)
  {
    Object localObject = null;
    JsonSerializer localJsonSerializer = null;
    if (!this._factoryConfig.hasKeySerializers()) {}
    do
    {
      localObject = localJsonSerializer;
      BeanDescription localBeanDescription;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return (JsonSerializer<Object>)localObject;
        localBeanDescription = paramSerializationConfig.introspectClassAnnotations(paramJavaType.getRawClass());
        localIterator = this._factoryConfig.keySerializers().iterator();
      }
      localJsonSerializer = ((Serializers)localIterator.next()).findSerializer(paramSerializationConfig, paramJavaType, localBeanDescription);
      localObject = localJsonSerializer;
    } while (localJsonSerializer == null);
    return localJsonSerializer;
  }
  
  public TypeSerializer createTypeSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType)
  {
    Object localObject = paramSerializationConfig.introspectClassAnnotations(paramJavaType.getRawClass()).getClassInfo();
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    TypeResolverBuilder localTypeResolverBuilder = localAnnotationIntrospector.findTypeResolver(paramSerializationConfig, (AnnotatedClass)localObject, paramJavaType);
    if (localTypeResolverBuilder == null) {
      localTypeResolverBuilder = paramSerializationConfig.getDefaultTyper(paramJavaType);
    }
    for (localObject = null; localTypeResolverBuilder == null; localObject = paramSerializationConfig.getSubtypeResolver().collectAndResolveSubtypes((AnnotatedClass)localObject, paramSerializationConfig, localAnnotationIntrospector)) {
      return null;
    }
    return localTypeResolverBuilder.buildTypeSerializer(paramSerializationConfig, paramJavaType, (Collection)localObject);
  }
  
  protected abstract Iterable<Serializers> customSerializers();
  
  protected final JsonSerializer<?> findSerializerByAddonType(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription, boolean paramBoolean)
  {
    Class localClass = paramJavaType.getRawClass();
    if (Iterator.class.isAssignableFrom(localClass)) {
      return buildIteratorSerializer(paramSerializationConfig, paramJavaType, paramBeanDescription, paramBoolean);
    }
    if (Iterable.class.isAssignableFrom(localClass)) {
      return buildIterableSerializer(paramSerializationConfig, paramJavaType, paramBeanDescription, paramBoolean);
    }
    if (CharSequence.class.isAssignableFrom(localClass)) {
      return ToStringSerializer.instance;
    }
    return null;
  }
  
  protected final JsonSerializer<?> findSerializerByAnnotations(SerializerProvider paramSerializerProvider, JavaType paramJavaType, BeanDescription paramBeanDescription)
  {
    if (JsonSerializable.class.isAssignableFrom(paramJavaType.getRawClass())) {
      return SerializableSerializer.instance;
    }
    paramJavaType = paramBeanDescription.findJsonValueMethod();
    if (paramJavaType != null)
    {
      paramBeanDescription = paramJavaType.getAnnotated();
      if (paramSerializerProvider.canOverrideAccessModifiers()) {
        ClassUtil.checkAndFixAccess(paramBeanDescription);
      }
      return new JsonValueSerializer(paramBeanDescription, findSerializerFromAnnotation(paramSerializerProvider, paramJavaType));
    }
    return null;
  }
  
  protected final JsonSerializer<?> findSerializerByLookup(JavaType paramJavaType, SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, boolean paramBoolean)
  {
    paramJavaType = paramJavaType.getRawClass().getName();
    paramSerializationConfig = (JsonSerializer)_concrete.get(paramJavaType);
    if (paramSerializationConfig != null) {
      return paramSerializationConfig;
    }
    paramJavaType = (Class)_concreteLazy.get(paramJavaType);
    if (paramJavaType != null) {
      try
      {
        paramSerializationConfig = (JsonSerializer)paramJavaType.newInstance();
        return paramSerializationConfig;
      }
      catch (Exception paramSerializationConfig)
      {
        throw new IllegalStateException("Failed to instantiate standard serializer (of type " + paramJavaType.getName() + "): " + paramSerializationConfig.getMessage(), paramSerializationConfig);
      }
    }
    return null;
  }
  
  protected final JsonSerializer<?> findSerializerByPrimaryType(SerializerProvider paramSerializerProvider, JavaType paramJavaType, BeanDescription paramBeanDescription, boolean paramBoolean)
  {
    Class localClass = paramJavaType.getRawClass();
    if (InetAddress.class.isAssignableFrom(localClass)) {
      paramJavaType = InetAddressSerializer.instance;
    }
    JsonSerializer localJsonSerializer;
    do
    {
      return paramJavaType;
      if (TimeZone.class.isAssignableFrom(localClass)) {
        return TimeZoneSerializer.instance;
      }
      if (Charset.class.isAssignableFrom(localClass)) {
        return ToStringSerializer.instance;
      }
      localJsonSerializer = this.optionalHandlers.findSerializer(paramSerializerProvider.getConfig(), paramJavaType);
      paramJavaType = localJsonSerializer;
    } while (localJsonSerializer != null);
    if (Number.class.isAssignableFrom(localClass)) {
      return NumberSerializers.NumberSerializer.instance;
    }
    if (Enum.class.isAssignableFrom(localClass))
    {
      paramJavaType = paramBeanDescription.findExpectedFormat(null);
      if ((paramJavaType != null) && (paramJavaType.getShape() == JsonFormat.Shape.OBJECT)) {
        ((BasicBeanDescription)paramBeanDescription).removeProperty("declaringClass");
      }
    }
    else
    {
      if (!Calendar.class.isAssignableFrom(localClass)) {
        break label158;
      }
      return CalendarSerializer.instance;
    }
    return EnumSerializer.construct(localClass, paramSerializerProvider.getConfig(), paramBeanDescription, paramJavaType);
    label158:
    if (java.util.Date.class.isAssignableFrom(localClass)) {
      return DateSerializer.instance;
    }
    return null;
  }
  
  protected JsonSerializer<Object> findSerializerFromAnnotation(SerializerProvider paramSerializerProvider, Annotated paramAnnotated)
  {
    Object localObject = paramSerializerProvider.getAnnotationIntrospector().findSerializer(paramAnnotated);
    if (localObject == null) {
      return null;
    }
    return paramSerializerProvider.serializerInstance(paramAnnotated, localObject);
  }
  
  protected boolean isIndexedList(Class<?> paramClass)
  {
    return RandomAccess.class.isAssignableFrom(paramClass);
  }
  
  protected <T extends JavaType> T modifyTypeByAnnotation(SerializationConfig paramSerializationConfig, Annotated paramAnnotated, T paramT)
  {
    Class localClass = paramSerializationConfig.getAnnotationIntrospector().findSerializationType(paramAnnotated);
    Object localObject = paramT;
    if (localClass != null) {}
    try
    {
      localObject = paramT.widenBy(localClass);
      return modifySecondaryTypesByAnnotation(paramSerializationConfig, paramAnnotated, (JavaType)localObject);
    }
    catch (IllegalArgumentException paramSerializationConfig)
    {
      throw new IllegalArgumentException("Failed to widen type " + paramT + " with concrete-type annotation (value " + localClass.getName() + "), method '" + paramAnnotated.getName() + "': " + paramSerializationConfig.getMessage());
    }
  }
  
  protected boolean usesStaticTyping(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, TypeSerializer paramTypeSerializer)
  {
    if (paramTypeSerializer != null) {}
    do
    {
      do
      {
        return false;
        paramBeanDescription = paramSerializationConfig.getAnnotationIntrospector().findSerializationTyping(paramBeanDescription.getClassInfo());
        if (paramBeanDescription == null) {
          break;
        }
      } while (paramBeanDescription != JsonSerialize.Typing.STATIC);
      return true;
    } while (!paramSerializationConfig.isEnabled(MapperFeature.USE_STATIC_TYPING));
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/BasicSerializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */