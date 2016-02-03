package com.flurry.org.codehaus.jackson.map.ser;

import com.flurry.org.codehaus.jackson.map.AnnotationIntrospector;
import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.ContextualSerializer;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.JsonSerializable;
import com.flurry.org.codehaus.jackson.map.JsonSerializableWithType;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.JsonSerializer.None;
import com.flurry.org.codehaus.jackson.map.SerializationConfig;
import com.flurry.org.codehaus.jackson.map.SerializationConfig.Feature;
import com.flurry.org.codehaus.jackson.map.SerializerFactory;
import com.flurry.org.codehaus.jackson.map.Serializers;
import com.flurry.org.codehaus.jackson.map.TypeSerializer;
import com.flurry.org.codehaus.jackson.map.annotate.JsonSerialize.Typing;
import com.flurry.org.codehaus.jackson.map.ext.OptionalHandlerFactory;
import com.flurry.org.codehaus.jackson.map.introspect.Annotated;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedClass;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMethod;
import com.flurry.org.codehaus.jackson.map.introspect.BasicBeanDescription;
import com.flurry.org.codehaus.jackson.map.jsontype.SubtypeResolver;
import com.flurry.org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import com.flurry.org.codehaus.jackson.map.ser.std.CalendarSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.DateSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.EnumMapSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.EnumSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.IndexedStringListSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.InetAddressSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.JsonValueSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.MapSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.NullSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.ObjectArraySerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.SerializableSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.SerializableWithTypeSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.StdArraySerializers.BooleanArraySerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.StdArraySerializers.ByteArraySerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.StdArraySerializers.CharArraySerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.StdArraySerializers.DoubleArraySerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.StdArraySerializers.FloatArraySerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.StdArraySerializers.IntArraySerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.StdArraySerializers.LongArraySerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.StdArraySerializers.ShortArraySerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.StdArraySerializers.StringArraySerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.StdContainerSerializers;
import com.flurry.org.codehaus.jackson.map.ser.std.StdJdkSerializers;
import com.flurry.org.codehaus.jackson.map.ser.std.StringCollectionSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.StringSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.TimeZoneSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.ToStringSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.TokenBufferSerializer;
import com.flurry.org.codehaus.jackson.map.type.ArrayType;
import com.flurry.org.codehaus.jackson.map.type.CollectionLikeType;
import com.flurry.org.codehaus.jackson.map.type.CollectionType;
import com.flurry.org.codehaus.jackson.map.type.MapLikeType;
import com.flurry.org.codehaus.jackson.map.type.MapType;
import com.flurry.org.codehaus.jackson.map.type.TypeFactory;
import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import com.flurry.org.codehaus.jackson.map.util.EnumValues;
import com.flurry.org.codehaus.jackson.type.JavaType;
import com.flurry.org.codehaus.jackson.util.TokenBuffer;
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
{
  protected static final HashMap<String, JsonSerializer<?>> _arraySerializers;
  protected static final HashMap<String, JsonSerializer<?>> _concrete = new HashMap();
  protected static final HashMap<String, Class<? extends JsonSerializer<?>>> _concreteLazy = new HashMap();
  protected OptionalHandlerFactory optionalHandlers = OptionalHandlerFactory.instance;
  
  static
  {
    _concrete.put(String.class.getName(), new StringSerializer());
    Object localObject1 = ToStringSerializer.instance;
    _concrete.put(StringBuffer.class.getName(), localObject1);
    _concrete.put(StringBuilder.class.getName(), localObject1);
    _concrete.put(Character.class.getName(), localObject1);
    _concrete.put(Character.TYPE.getName(), localObject1);
    _concrete.put(Boolean.TYPE.getName(), new StdSerializers.BooleanSerializer(true));
    _concrete.put(Boolean.class.getName(), new StdSerializers.BooleanSerializer(false));
    localObject1 = new StdSerializers.IntegerSerializer();
    _concrete.put(Integer.class.getName(), localObject1);
    _concrete.put(Integer.TYPE.getName(), localObject1);
    _concrete.put(Long.class.getName(), StdSerializers.LongSerializer.instance);
    _concrete.put(Long.TYPE.getName(), StdSerializers.LongSerializer.instance);
    _concrete.put(Byte.class.getName(), StdSerializers.IntLikeSerializer.instance);
    _concrete.put(Byte.TYPE.getName(), StdSerializers.IntLikeSerializer.instance);
    _concrete.put(Short.class.getName(), StdSerializers.IntLikeSerializer.instance);
    _concrete.put(Short.TYPE.getName(), StdSerializers.IntLikeSerializer.instance);
    _concrete.put(Float.class.getName(), StdSerializers.FloatSerializer.instance);
    _concrete.put(Float.TYPE.getName(), StdSerializers.FloatSerializer.instance);
    _concrete.put(Double.class.getName(), StdSerializers.DoubleSerializer.instance);
    _concrete.put(Double.TYPE.getName(), StdSerializers.DoubleSerializer.instance);
    localObject1 = new StdSerializers.NumberSerializer();
    _concrete.put(BigInteger.class.getName(), localObject1);
    _concrete.put(BigDecimal.class.getName(), localObject1);
    _concrete.put(Calendar.class.getName(), CalendarSerializer.instance);
    localObject1 = DateSerializer.instance;
    _concrete.put(java.util.Date.class.getName(), localObject1);
    _concrete.put(Timestamp.class.getName(), localObject1);
    _concrete.put(java.sql.Date.class.getName(), new StdSerializers.SqlDateSerializer());
    _concrete.put(Time.class.getName(), new StdSerializers.SqlTimeSerializer());
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
    _arraySerializers = new HashMap();
    _arraySerializers.put(boolean[].class.getName(), new StdArraySerializers.BooleanArraySerializer());
    _arraySerializers.put(byte[].class.getName(), new StdArraySerializers.ByteArraySerializer());
    _arraySerializers.put(char[].class.getName(), new StdArraySerializers.CharArraySerializer());
    _arraySerializers.put(short[].class.getName(), new StdArraySerializers.ShortArraySerializer());
    _arraySerializers.put(int[].class.getName(), new StdArraySerializers.IntArraySerializer());
    _arraySerializers.put(long[].class.getName(), new StdArraySerializers.LongArraySerializer());
    _arraySerializers.put(float[].class.getName(), new StdArraySerializers.FloatArraySerializer());
    _arraySerializers.put(double[].class.getName(), new StdArraySerializers.DoubleArraySerializer());
  }
  
  protected static JsonSerializer<Object> findContentSerializer(SerializationConfig paramSerializationConfig, Annotated paramAnnotated, BeanProperty paramBeanProperty)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    Class localClass2 = localAnnotationIntrospector.findContentSerializer(paramAnnotated);
    Class localClass1;
    if (localClass2 != null)
    {
      localClass1 = localClass2;
      if (localClass2 != JsonSerializer.None.class) {}
    }
    else
    {
      localClass1 = localClass2;
      if (paramBeanProperty != null) {
        localClass1 = localAnnotationIntrospector.findContentSerializer(paramBeanProperty.getMember());
      }
    }
    if ((localClass1 != null) && (localClass1 != JsonSerializer.None.class)) {
      return paramSerializationConfig.serializerInstance(paramAnnotated, localClass1);
    }
    return null;
  }
  
  protected static JsonSerializer<Object> findKeySerializer(SerializationConfig paramSerializationConfig, Annotated paramAnnotated, BeanProperty paramBeanProperty)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    Class localClass2 = localAnnotationIntrospector.findKeySerializer(paramAnnotated);
    Class localClass1;
    if (localClass2 != null)
    {
      localClass1 = localClass2;
      if (localClass2 != JsonSerializer.None.class) {}
    }
    else
    {
      localClass1 = localClass2;
      if (paramBeanProperty != null) {
        localClass1 = localAnnotationIntrospector.findKeySerializer(paramBeanProperty.getMember());
      }
    }
    if ((localClass1 != null) && (localClass1 != JsonSerializer.None.class)) {
      return paramSerializationConfig.serializerInstance(paramAnnotated, localClass1);
    }
    return null;
  }
  
  /* Error */
  protected static <T extends JavaType> T modifySecondaryTypesByAnnotation(SerializationConfig paramSerializationConfig, Annotated paramAnnotated, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 252	com/flurry/org/codehaus/jackson/map/SerializationConfig:getAnnotationIntrospector	()Lcom/flurry/org/codehaus/jackson/map/AnnotationIntrospector;
    //   4: astore 4
    //   6: aload_2
    //   7: astore_3
    //   8: aload_2
    //   9: invokevirtual 283	com/flurry/org/codehaus/jackson/type/JavaType:isContainerType	()Z
    //   12: ifeq +93 -> 105
    //   15: aload 4
    //   17: aload_1
    //   18: aload_2
    //   19: invokevirtual 287	com/flurry/org/codehaus/jackson/type/JavaType:getKeyType	()Lcom/flurry/org/codehaus/jackson/type/JavaType;
    //   22: invokevirtual 291	com/flurry/org/codehaus/jackson/map/AnnotationIntrospector:findSerializationKeyType	(Lcom/flurry/org/codehaus/jackson/map/introspect/Annotated;Lcom/flurry/org/codehaus/jackson/type/JavaType;)Ljava/lang/Class;
    //   25: astore_3
    //   26: aload_2
    //   27: astore_0
    //   28: aload_3
    //   29: ifnull +53 -> 82
    //   32: aload_2
    //   33: instanceof 293
    //   36: ifne +37 -> 73
    //   39: new 278	java/lang/IllegalArgumentException
    //   42: dup
    //   43: new 48	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 295
    //   53: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_2
    //   57: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   60: ldc_w 300
    //   63: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokespecial 301	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   72: athrow
    //   73: aload_2
    //   74: checkcast 293	com/flurry/org/codehaus/jackson/map/type/MapType
    //   77: aload_3
    //   78: invokevirtual 305	com/flurry/org/codehaus/jackson/map/type/MapType:widenKey	(Ljava/lang/Class;)Lcom/flurry/org/codehaus/jackson/type/JavaType;
    //   81: astore_0
    //   82: aload 4
    //   84: aload_1
    //   85: aload_0
    //   86: invokevirtual 308	com/flurry/org/codehaus/jackson/type/JavaType:getContentType	()Lcom/flurry/org/codehaus/jackson/type/JavaType;
    //   89: invokevirtual 311	com/flurry/org/codehaus/jackson/map/AnnotationIntrospector:findSerializationContentType	(Lcom/flurry/org/codehaus/jackson/map/introspect/Annotated;Lcom/flurry/org/codehaus/jackson/type/JavaType;)Ljava/lang/Class;
    //   92: astore_1
    //   93: aload_0
    //   94: astore_3
    //   95: aload_1
    //   96: ifnull +9 -> 105
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 314	com/flurry/org/codehaus/jackson/type/JavaType:widenContentsBy	(Ljava/lang/Class;)Lcom/flurry/org/codehaus/jackson/type/JavaType;
    //   104: astore_3
    //   105: aload_3
    //   106: areturn
    //   107: astore_0
    //   108: new 278	java/lang/IllegalArgumentException
    //   111: dup
    //   112: new 48	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 316
    //   122: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_2
    //   126: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   129: ldc_w 318
    //   132: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 31	java/lang/Class:getName	()Ljava/lang/String;
    //   139: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 320
    //   145: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_0
    //   149: invokevirtual 323	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   152: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokespecial 301	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   161: athrow
    //   162: astore_2
    //   163: new 278	java/lang/IllegalArgumentException
    //   166: dup
    //   167: new 48	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 325
    //   177: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: ldc_w 327
    //   187: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_1
    //   191: invokevirtual 31	java/lang/Class:getName	()Ljava/lang/String;
    //   194: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 320
    //   200: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_2
    //   204: invokevirtual 323	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   207: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokespecial 301	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramSerializationConfig	SerializationConfig
    //   0	217	1	paramAnnotated	Annotated
    //   0	217	2	paramT	T
    //   7	129	3	localObject	Object
    //   4	79	4	localAnnotationIntrospector	AnnotationIntrospector
    // Exception table:
    //   from	to	target	type
    //   73	82	107	java/lang/IllegalArgumentException
    //   99	105	162	java/lang/IllegalArgumentException
  }
  
  protected JsonSerializer<?> buildArraySerializer(SerializationConfig paramSerializationConfig, ArrayType paramArrayType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    paramSerializationConfig = paramArrayType.getRawClass();
    if (String[].class == paramSerializationConfig) {
      paramSerializationConfig = new StdArraySerializers.StringArraySerializer(paramBeanProperty);
    }
    do
    {
      return paramSerializationConfig;
      paramBasicBeanDescription = (JsonSerializer)_arraySerializers.get(paramSerializationConfig.getName());
      paramSerializationConfig = paramBasicBeanDescription;
    } while (paramBasicBeanDescription != null);
    return new ObjectArraySerializer(paramArrayType.getContentType(), paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
  }
  
  protected JsonSerializer<?> buildCollectionLikeSerializer(SerializationConfig paramSerializationConfig, CollectionLikeType paramCollectionLikeType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    Iterator localIterator = customSerializers().iterator();
    while (localIterator.hasNext())
    {
      JsonSerializer localJsonSerializer = ((Serializers)localIterator.next()).findCollectionLikeSerializer(paramSerializationConfig, paramCollectionLikeType, paramBasicBeanDescription, paramBeanProperty, paramTypeSerializer, paramJsonSerializer);
      if (localJsonSerializer != null) {
        return localJsonSerializer;
      }
    }
    return null;
  }
  
  protected JsonSerializer<?> buildCollectionSerializer(SerializationConfig paramSerializationConfig, CollectionType paramCollectionType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    Object localObject = customSerializers().iterator();
    while (((Iterator)localObject).hasNext())
    {
      JsonSerializer localJsonSerializer = ((Serializers)((Iterator)localObject).next()).findCollectionSerializer(paramSerializationConfig, paramCollectionType, paramBasicBeanDescription, paramBeanProperty, paramTypeSerializer, paramJsonSerializer);
      if (localJsonSerializer != null) {
        return localJsonSerializer;
      }
    }
    localObject = paramCollectionType.getRawClass();
    if (EnumSet.class.isAssignableFrom((Class)localObject)) {
      return buildEnumSetSerializer(paramSerializationConfig, paramCollectionType, paramBasicBeanDescription, paramBeanProperty, paramBoolean, paramTypeSerializer, paramJsonSerializer);
    }
    paramSerializationConfig = paramCollectionType.getContentType().getRawClass();
    if (isIndexedList((Class)localObject))
    {
      if (paramSerializationConfig == String.class) {
        return new IndexedStringListSerializer(paramBeanProperty);
      }
      return StdContainerSerializers.indexedListSerializer(paramCollectionType.getContentType(), paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
    }
    if (paramSerializationConfig == String.class) {
      return new StringCollectionSerializer(paramBeanProperty);
    }
    return StdContainerSerializers.collectionSerializer(paramCollectionType.getContentType(), paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
  }
  
  public JsonSerializer<?> buildContainerSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, boolean paramBoolean)
  {
    TypeSerializer localTypeSerializer = createTypeSerializer(paramSerializationConfig, paramJavaType.getContentType(), paramBeanProperty);
    boolean bool;
    if (localTypeSerializer != null) {
      bool = false;
    }
    JsonSerializer localJsonSerializer1;
    JsonSerializer localJsonSerializer2;
    for (;;)
    {
      localJsonSerializer1 = findContentSerializer(paramSerializationConfig, paramBasicBeanDescription.getClassInfo(), paramBeanProperty);
      if (!paramJavaType.isMapLikeType()) {
        break label127;
      }
      paramJavaType = (MapLikeType)paramJavaType;
      localJsonSerializer2 = findKeySerializer(paramSerializationConfig, paramBasicBeanDescription.getClassInfo(), paramBeanProperty);
      if (!paramJavaType.isTrueMapType()) {
        break;
      }
      return buildMapSerializer(paramSerializationConfig, (MapType)paramJavaType, paramBasicBeanDescription, paramBeanProperty, bool, localJsonSerializer2, localTypeSerializer, localJsonSerializer1);
      bool = paramBoolean;
      if (!paramBoolean) {
        bool = usesStaticTyping(paramSerializationConfig, paramBasicBeanDescription, localTypeSerializer, paramBeanProperty);
      }
    }
    return buildMapLikeSerializer(paramSerializationConfig, paramJavaType, paramBasicBeanDescription, paramBeanProperty, bool, localJsonSerializer2, localTypeSerializer, localJsonSerializer1);
    label127:
    if (paramJavaType.isCollectionLikeType())
    {
      paramJavaType = (CollectionLikeType)paramJavaType;
      if (paramJavaType.isTrueCollectionType()) {
        return buildCollectionSerializer(paramSerializationConfig, (CollectionType)paramJavaType, paramBasicBeanDescription, paramBeanProperty, bool, localTypeSerializer, localJsonSerializer1);
      }
      return buildCollectionLikeSerializer(paramSerializationConfig, paramJavaType, paramBasicBeanDescription, paramBeanProperty, bool, localTypeSerializer, localJsonSerializer1);
    }
    if (paramJavaType.isArrayType()) {
      return buildArraySerializer(paramSerializationConfig, (ArrayType)paramJavaType, paramBasicBeanDescription, paramBeanProperty, bool, localTypeSerializer, localJsonSerializer1);
    }
    return null;
  }
  
  protected JsonSerializer<?> buildEnumMapSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    JavaType localJavaType = paramJavaType.getKeyType();
    paramBasicBeanDescription = null;
    if (localJavaType.isEnumType()) {
      paramBasicBeanDescription = EnumValues.construct(localJavaType.getRawClass(), paramSerializationConfig.getAnnotationIntrospector());
    }
    return new EnumMapSerializer(paramJavaType.getContentType(), paramBoolean, paramBasicBeanDescription, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
  }
  
  protected JsonSerializer<?> buildEnumSetSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    paramJavaType = paramJavaType.getContentType();
    paramSerializationConfig = paramJavaType;
    if (!paramJavaType.isEnumType()) {
      paramSerializationConfig = null;
    }
    return StdContainerSerializers.enumSetSerializer(paramSerializationConfig, paramBeanProperty);
  }
  
  protected JsonSerializer<?> buildIterableSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, boolean paramBoolean)
  {
    Object localObject = paramJavaType.containedType(0);
    paramJavaType = (JavaType)localObject;
    if (localObject == null) {
      paramJavaType = TypeFactory.unknownType();
    }
    localObject = createTypeSerializer(paramSerializationConfig, paramJavaType, paramBeanProperty);
    return StdContainerSerializers.iterableSerializer(paramJavaType, usesStaticTyping(paramSerializationConfig, paramBasicBeanDescription, (TypeSerializer)localObject, paramBeanProperty), (TypeSerializer)localObject, paramBeanProperty);
  }
  
  protected JsonSerializer<?> buildIteratorSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, boolean paramBoolean)
  {
    Object localObject = paramJavaType.containedType(0);
    paramJavaType = (JavaType)localObject;
    if (localObject == null) {
      paramJavaType = TypeFactory.unknownType();
    }
    localObject = createTypeSerializer(paramSerializationConfig, paramJavaType, paramBeanProperty);
    return StdContainerSerializers.iteratorSerializer(paramJavaType, usesStaticTyping(paramSerializationConfig, paramBasicBeanDescription, (TypeSerializer)localObject, paramBeanProperty), (TypeSerializer)localObject, paramBeanProperty);
  }
  
  protected JsonSerializer<?> buildMapLikeSerializer(SerializationConfig paramSerializationConfig, MapLikeType paramMapLikeType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, boolean paramBoolean, JsonSerializer<Object> paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer2)
  {
    Iterator localIterator = customSerializers().iterator();
    while (localIterator.hasNext())
    {
      JsonSerializer localJsonSerializer = ((Serializers)localIterator.next()).findMapLikeSerializer(paramSerializationConfig, paramMapLikeType, paramBasicBeanDescription, paramBeanProperty, paramJsonSerializer1, paramTypeSerializer, paramJsonSerializer2);
      if (localJsonSerializer != null) {
        return localJsonSerializer;
      }
    }
    return null;
  }
  
  protected JsonSerializer<?> buildMapSerializer(SerializationConfig paramSerializationConfig, MapType paramMapType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, boolean paramBoolean, JsonSerializer<Object> paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer2)
  {
    Iterator localIterator = customSerializers().iterator();
    while (localIterator.hasNext())
    {
      JsonSerializer localJsonSerializer = ((Serializers)localIterator.next()).findMapSerializer(paramSerializationConfig, paramMapType, paramBasicBeanDescription, paramBeanProperty, paramJsonSerializer1, paramTypeSerializer, paramJsonSerializer2);
      if (localJsonSerializer != null) {
        return localJsonSerializer;
      }
    }
    if (EnumMap.class.isAssignableFrom(paramMapType.getRawClass())) {
      return buildEnumMapSerializer(paramSerializationConfig, paramMapType, paramBasicBeanDescription, paramBeanProperty, paramBoolean, paramTypeSerializer, paramJsonSerializer2);
    }
    return MapSerializer.construct(paramSerializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(paramBasicBeanDescription.getClassInfo()), paramMapType, paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer1, paramJsonSerializer2);
  }
  
  public abstract JsonSerializer<Object> createSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public TypeSerializer createTypeSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    AnnotatedClass localAnnotatedClass = ((BasicBeanDescription)paramSerializationConfig.introspectClassAnnotations(paramJavaType.getRawClass())).getClassInfo();
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    TypeResolverBuilder localTypeResolverBuilder = localAnnotationIntrospector.findTypeResolver(paramSerializationConfig, localAnnotatedClass, paramJavaType);
    Collection localCollection = null;
    if (localTypeResolverBuilder == null) {
      localTypeResolverBuilder = paramSerializationConfig.getDefaultTyper(paramJavaType);
    }
    while (localTypeResolverBuilder == null)
    {
      return null;
      localCollection = paramSerializationConfig.getSubtypeResolver().collectAndResolveSubtypes(localAnnotatedClass, paramSerializationConfig, localAnnotationIntrospector);
    }
    return localTypeResolverBuilder.buildTypeSerializer(paramSerializationConfig, paramJavaType, localCollection, paramBeanProperty);
  }
  
  protected abstract Iterable<Serializers> customSerializers();
  
  public final JsonSerializer<?> findSerializerByAddonType(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, boolean paramBoolean)
    throws JsonMappingException
  {
    Class localClass = paramJavaType.getRawClass();
    if (Iterator.class.isAssignableFrom(localClass)) {
      return buildIteratorSerializer(paramSerializationConfig, paramJavaType, paramBasicBeanDescription, paramBeanProperty, paramBoolean);
    }
    if (Iterable.class.isAssignableFrom(localClass)) {
      return buildIterableSerializer(paramSerializationConfig, paramJavaType, paramBasicBeanDescription, paramBeanProperty, paramBoolean);
    }
    if (CharSequence.class.isAssignableFrom(localClass)) {
      return ToStringSerializer.instance;
    }
    return null;
  }
  
  public final JsonSerializer<?> findSerializerByLookup(JavaType paramJavaType, SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, boolean paramBoolean)
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
  
  public final JsonSerializer<?> findSerializerByPrimaryType(JavaType paramJavaType, SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, boolean paramBoolean)
    throws JsonMappingException
  {
    Class localClass = paramJavaType.getRawClass();
    if (JsonSerializable.class.isAssignableFrom(localClass)) {
      if (JsonSerializableWithType.class.isAssignableFrom(localClass)) {
        paramJavaType = SerializableWithTypeSerializer.instance;
      }
    }
    do
    {
      return paramJavaType;
      return SerializableSerializer.instance;
      AnnotatedMethod localAnnotatedMethod = paramBasicBeanDescription.findJsonValueMethod();
      if (localAnnotatedMethod != null)
      {
        paramJavaType = localAnnotatedMethod.getAnnotated();
        if (paramSerializationConfig.isEnabled(SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
          ClassUtil.checkAndFixAccess(paramJavaType);
        }
        return new JsonValueSerializer(paramJavaType, findSerializerFromAnnotation(paramSerializationConfig, localAnnotatedMethod, paramBeanProperty), paramBeanProperty);
      }
      if (InetAddress.class.isAssignableFrom(localClass)) {
        return InetAddressSerializer.instance;
      }
      if (TimeZone.class.isAssignableFrom(localClass)) {
        return TimeZoneSerializer.instance;
      }
      if (Charset.class.isAssignableFrom(localClass)) {
        return ToStringSerializer.instance;
      }
      paramBeanProperty = this.optionalHandlers.findSerializer(paramSerializationConfig, paramJavaType);
      paramJavaType = paramBeanProperty;
    } while (paramBeanProperty != null);
    if (Number.class.isAssignableFrom(localClass)) {
      return StdSerializers.NumberSerializer.instance;
    }
    if (Enum.class.isAssignableFrom(localClass)) {
      return EnumSerializer.construct(localClass, paramSerializationConfig, paramBasicBeanDescription);
    }
    if (Calendar.class.isAssignableFrom(localClass)) {
      return CalendarSerializer.instance;
    }
    if (java.util.Date.class.isAssignableFrom(localClass)) {
      return DateSerializer.instance;
    }
    return null;
  }
  
  protected JsonSerializer<Object> findSerializerFromAnnotation(SerializationConfig paramSerializationConfig, Annotated paramAnnotated, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject = paramSerializationConfig.getAnnotationIntrospector().findSerializer(paramAnnotated);
    if (localObject == null) {
      paramAnnotated = null;
    }
    do
    {
      do
      {
        return paramAnnotated;
        if (!(localObject instanceof JsonSerializer)) {
          break;
        }
        localObject = (JsonSerializer)localObject;
        paramAnnotated = (Annotated)localObject;
      } while (!(localObject instanceof ContextualSerializer));
      return ((ContextualSerializer)localObject).createContextual(paramSerializationConfig, paramBeanProperty);
      if (!(localObject instanceof Class)) {
        throw new IllegalStateException("AnnotationIntrospector returned value of type " + localObject.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
      }
      localObject = (Class)localObject;
      if (!JsonSerializer.class.isAssignableFrom((Class)localObject)) {
        throw new IllegalStateException("AnnotationIntrospector returned Class " + ((Class)localObject).getName() + "; expected Class<JsonSerializer>");
      }
      localObject = paramSerializationConfig.serializerInstance(paramAnnotated, (Class)localObject);
      paramAnnotated = (Annotated)localObject;
    } while (!(localObject instanceof ContextualSerializer));
    return ((ContextualSerializer)localObject).createContextual(paramSerializationConfig, paramBeanProperty);
  }
  
  public final JsonSerializer<?> getNullSerializer()
  {
    return NullSerializer.instance;
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
  
  protected boolean usesStaticTyping(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
  {
    if (paramTypeSerializer != null) {}
    do
    {
      do
      {
        do
        {
          return false;
          paramTypeSerializer = paramSerializationConfig.getAnnotationIntrospector();
          paramBasicBeanDescription = paramTypeSerializer.findSerializationTyping(paramBasicBeanDescription.getClassInfo());
          if (paramBasicBeanDescription != null)
          {
            if (paramBasicBeanDescription == JsonSerialize.Typing.STATIC) {
              return true;
            }
          }
          else if (paramSerializationConfig.isEnabled(SerializationConfig.Feature.USE_STATIC_TYPING)) {
            return true;
          }
        } while (paramBeanProperty == null);
        paramSerializationConfig = paramBeanProperty.getType();
      } while (!paramSerializationConfig.isContainerType());
      if (paramTypeSerializer.findSerializationContentType(paramBeanProperty.getMember(), paramBeanProperty.getType()) != null) {
        return true;
      }
    } while ((!(paramSerializationConfig instanceof MapType)) || (paramTypeSerializer.findSerializationKeyType(paramBeanProperty.getMember(), paramBeanProperty.getType()) == null));
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ser/BasicSerializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */