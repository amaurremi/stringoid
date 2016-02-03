package org.codehaus.jackson.map.ser.std;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.ser.impl.PropertySerializerMap;
import org.codehaus.jackson.map.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public class MapSerializer
  extends ContainerSerializerBase
  implements ResolvableSerializer
{
  protected static final JavaType UNSPECIFIED_TYPE = ;
  protected PropertySerializerMap _dynamicValueSerializers;
  protected final HashSet _ignoredEntries;
  protected JsonSerializer _keySerializer;
  protected final JavaType _keyType;
  protected final BeanProperty _property;
  protected JsonSerializer _valueSerializer;
  protected final JavaType _valueType;
  protected final boolean _valueTypeIsStatic;
  protected final TypeSerializer _valueTypeSerializer;
  
  protected MapSerializer()
  {
    this((HashSet)null, null, null, false, null, null, null, null);
  }
  
  protected MapSerializer(HashSet paramHashSet, JavaType paramJavaType1, JavaType paramJavaType2, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer paramJsonSerializer1, JsonSerializer paramJsonSerializer2, BeanProperty paramBeanProperty)
  {
    super(Map.class, false);
    this._property = paramBeanProperty;
    this._ignoredEntries = paramHashSet;
    this._keyType = paramJavaType1;
    this._valueType = paramJavaType2;
    this._valueTypeIsStatic = paramBoolean;
    this._valueTypeSerializer = paramTypeSerializer;
    this._keySerializer = paramJsonSerializer1;
    this._valueSerializer = paramJsonSerializer2;
    this._dynamicValueSerializers = PropertySerializerMap.emptyMap();
  }
  
  @Deprecated
  public static MapSerializer construct(String[] paramArrayOfString, JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
  {
    return construct(paramArrayOfString, paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, null, null);
  }
  
  public static MapSerializer construct(String[] paramArrayOfString, JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer paramJsonSerializer1, JsonSerializer paramJsonSerializer2)
  {
    HashSet localHashSet = toSet(paramArrayOfString);
    if (paramJavaType == null)
    {
      paramJavaType = UNSPECIFIED_TYPE;
      paramArrayOfString = paramJavaType;
      if (paramBoolean) {
        break label71;
      }
      if ((paramJavaType == null) || (!paramJavaType.isFinal())) {
        break label66;
      }
      paramBoolean = true;
    }
    label66:
    label71:
    for (;;)
    {
      return new MapSerializer(localHashSet, paramArrayOfString, paramJavaType, paramBoolean, paramTypeSerializer, paramJsonSerializer1, paramJsonSerializer2, paramBeanProperty);
      paramArrayOfString = paramJavaType.getKeyType();
      paramJavaType = paramJavaType.getContentType();
      break;
      paramBoolean = false;
    }
  }
  
  private static HashSet toSet(String[] paramArrayOfString)
  {
    Object localObject;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      localObject = null;
      return (HashSet)localObject;
    }
    HashSet localHashSet = new HashSet(paramArrayOfString.length);
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      localObject = localHashSet;
      if (i >= j) {
        break;
      }
      localHashSet.add(paramArrayOfString[i]);
      i += 1;
    }
  }
  
  protected final JsonSerializer _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, Class paramClass, SerializerProvider paramSerializerProvider)
  {
    paramClass = paramPropertySerializerMap.findAndAddSerializer(paramClass, paramSerializerProvider, this._property);
    if (paramPropertySerializerMap != paramClass.map) {
      this._dynamicValueSerializers = paramClass.map;
    }
    return paramClass.serializer;
  }
  
  protected final JsonSerializer _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, JavaType paramJavaType, SerializerProvider paramSerializerProvider)
  {
    paramJavaType = paramPropertySerializerMap.findAndAddSerializer(paramJavaType, paramSerializerProvider, this._property);
    if (paramPropertySerializerMap != paramJavaType.map) {
      this._dynamicValueSerializers = paramJavaType.map;
    }
    return paramJavaType.serializer;
  }
  
  public ContainerSerializerBase _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    paramTypeSerializer = new MapSerializer(this._ignoredEntries, this._keyType, this._valueType, this._valueTypeIsStatic, paramTypeSerializer, this._keySerializer, this._valueSerializer, this._property);
    if (this._valueSerializer != null) {
      paramTypeSerializer._valueSerializer = this._valueSerializer;
    }
    return paramTypeSerializer;
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    return createSchemaNode("object", true);
  }
  
  public void resolve(SerializerProvider paramSerializerProvider)
  {
    if ((this._valueTypeIsStatic) && (this._valueSerializer == null)) {
      this._valueSerializer = paramSerializerProvider.findValueSerializer(this._valueType, this._property);
    }
    if (this._keySerializer == null) {
      this._keySerializer = paramSerializerProvider.findKeySerializer(this._keyType, this._property);
    }
  }
  
  public void serialize(Map paramMap, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramJsonGenerator.writeStartObject();
    if (!paramMap.isEmpty())
    {
      if (this._valueSerializer == null) {
        break label36;
      }
      serializeFieldsUsing(paramMap, paramJsonGenerator, paramSerializerProvider, this._valueSerializer);
    }
    for (;;)
    {
      paramJsonGenerator.writeEndObject();
      return;
      label36:
      serializeFields(paramMap, paramJsonGenerator, paramSerializerProvider);
    }
  }
  
  /* Error */
  public void serializeFields(Map paramMap, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	org/codehaus/jackson/map/ser/std/MapSerializer:_valueTypeSerializer	Lorg/codehaus/jackson/map/TypeSerializer;
    //   4: ifnull +11 -> 15
    //   7: aload_0
    //   8: aload_1
    //   9: aload_2
    //   10: aload_3
    //   11: invokevirtual 167	org/codehaus/jackson/map/ser/std/MapSerializer:serializeTypedFields	(Ljava/util/Map;Lorg/codehaus/jackson/JsonGenerator;Lorg/codehaus/jackson/map/SerializerProvider;)V
    //   14: return
    //   15: aload_0
    //   16: getfield 60	org/codehaus/jackson/map/ser/std/MapSerializer:_keySerializer	Lorg/codehaus/jackson/map/JsonSerializer;
    //   19: astore 8
    //   21: aload_0
    //   22: getfield 50	org/codehaus/jackson/map/ser/std/MapSerializer:_ignoredEntries	Ljava/util/HashSet;
    //   25: astore 9
    //   27: aload_3
    //   28: getstatic 173	org/codehaus/jackson/map/SerializationConfig$Feature:WRITE_NULL_MAP_VALUES	Lorg/codehaus/jackson/map/SerializationConfig$Feature;
    //   31: invokevirtual 177	org/codehaus/jackson/map/SerializerProvider:isEnabled	(Lorg/codehaus/jackson/map/SerializationConfig$Feature;)Z
    //   34: ifne +93 -> 127
    //   37: iconst_1
    //   38: istore 4
    //   40: aload_0
    //   41: getfield 70	org/codehaus/jackson/map/ser/std/MapSerializer:_dynamicValueSerializers	Lorg/codehaus/jackson/map/ser/impl/PropertySerializerMap;
    //   44: astore 5
    //   46: aload_1
    //   47: invokeinterface 181 1 0
    //   52: invokeinterface 187 1 0
    //   57: astore 10
    //   59: aload 10
    //   61: invokeinterface 192 1 0
    //   66: ifeq -52 -> 14
    //   69: aload 10
    //   71: invokeinterface 196 1 0
    //   76: checkcast 198	java/util/Map$Entry
    //   79: astore 6
    //   81: aload 6
    //   83: invokeinterface 201 1 0
    //   88: astore 11
    //   90: aload 6
    //   92: invokeinterface 204 1 0
    //   97: astore 12
    //   99: aload 12
    //   101: ifnonnull +32 -> 133
    //   104: aload_3
    //   105: invokevirtual 208	org/codehaus/jackson/map/SerializerProvider:getNullKeySerializer	()Lorg/codehaus/jackson/map/JsonSerializer;
    //   108: aconst_null
    //   109: aload_2
    //   110: aload_3
    //   111: invokevirtual 212	org/codehaus/jackson/map/JsonSerializer:serialize	(Ljava/lang/Object;Lorg/codehaus/jackson/JsonGenerator;Lorg/codehaus/jackson/map/SerializerProvider;)V
    //   114: aload 11
    //   116: ifnonnull +54 -> 170
    //   119: aload_3
    //   120: aload_2
    //   121: invokevirtual 216	org/codehaus/jackson/map/SerializerProvider:defaultSerializeNull	(Lorg/codehaus/jackson/JsonGenerator;)V
    //   124: goto -65 -> 59
    //   127: iconst_0
    //   128: istore 4
    //   130: goto -90 -> 40
    //   133: iload 4
    //   135: ifeq +8 -> 143
    //   138: aload 11
    //   140: ifnull -81 -> 59
    //   143: aload 9
    //   145: ifnull +13 -> 158
    //   148: aload 9
    //   150: aload 12
    //   152: invokevirtual 219	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   155: ifne -96 -> 59
    //   158: aload 8
    //   160: aload 12
    //   162: aload_2
    //   163: aload_3
    //   164: invokevirtual 212	org/codehaus/jackson/map/JsonSerializer:serialize	(Ljava/lang/Object;Lorg/codehaus/jackson/JsonGenerator;Lorg/codehaus/jackson/map/SerializerProvider;)V
    //   167: goto -53 -> 114
    //   170: aload 11
    //   172: invokevirtual 225	java/lang/Object:getClass	()Ljava/lang/Class;
    //   175: astore 7
    //   177: aload 5
    //   179: aload 7
    //   181: invokevirtual 229	org/codehaus/jackson/map/ser/impl/PropertySerializerMap:serializerFor	(Ljava/lang/Class;)Lorg/codehaus/jackson/map/JsonSerializer;
    //   184: astore 6
    //   186: aload 6
    //   188: ifnonnull +105 -> 293
    //   191: aload_0
    //   192: getfield 54	org/codehaus/jackson/map/ser/std/MapSerializer:_valueType	Lorg/codehaus/jackson/type/JavaType;
    //   195: invokevirtual 232	org/codehaus/jackson/type/JavaType:hasGenericTypes	()Z
    //   198: ifeq +81 -> 279
    //   201: aload_0
    //   202: aload 5
    //   204: aload_3
    //   205: aload_0
    //   206: getfield 54	org/codehaus/jackson/map/ser/std/MapSerializer:_valueType	Lorg/codehaus/jackson/type/JavaType;
    //   209: aload 7
    //   211: invokevirtual 236	org/codehaus/jackson/map/SerializerProvider:constructSpecializedType	(Lorg/codehaus/jackson/type/JavaType;Ljava/lang/Class;)Lorg/codehaus/jackson/type/JavaType;
    //   214: aload_3
    //   215: invokevirtual 238	org/codehaus/jackson/map/ser/std/MapSerializer:_findAndAddDynamic	(Lorg/codehaus/jackson/map/ser/impl/PropertySerializerMap;Lorg/codehaus/jackson/type/JavaType;Lorg/codehaus/jackson/map/SerializerProvider;)Lorg/codehaus/jackson/map/JsonSerializer;
    //   218: astore 5
    //   220: aload_0
    //   221: getfield 70	org/codehaus/jackson/map/ser/std/MapSerializer:_dynamicValueSerializers	Lorg/codehaus/jackson/map/ser/impl/PropertySerializerMap;
    //   224: astore 7
    //   226: aload 5
    //   228: astore 6
    //   230: aload 7
    //   232: astore 5
    //   234: aload 6
    //   236: aload 11
    //   238: aload_2
    //   239: aload_3
    //   240: invokevirtual 212	org/codehaus/jackson/map/JsonSerializer:serialize	(Ljava/lang/Object;Lorg/codehaus/jackson/JsonGenerator;Lorg/codehaus/jackson/map/SerializerProvider;)V
    //   243: goto -119 -> 124
    //   246: astore 6
    //   248: aload_0
    //   249: aload_3
    //   250: aload 6
    //   252: aload_1
    //   253: new 240	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   260: ldc -12
    //   262: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 12
    //   267: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokevirtual 259	org/codehaus/jackson/map/ser/std/MapSerializer:wrapAndThrow	(Lorg/codehaus/jackson/map/SerializerProvider;Ljava/lang/Throwable;Ljava/lang/Object;Ljava/lang/String;)V
    //   276: goto -152 -> 124
    //   279: aload_0
    //   280: aload 5
    //   282: aload 7
    //   284: aload_3
    //   285: invokevirtual 261	org/codehaus/jackson/map/ser/std/MapSerializer:_findAndAddDynamic	(Lorg/codehaus/jackson/map/ser/impl/PropertySerializerMap;Ljava/lang/Class;Lorg/codehaus/jackson/map/SerializerProvider;)Lorg/codehaus/jackson/map/JsonSerializer;
    //   288: astore 5
    //   290: goto -70 -> 220
    //   293: goto -59 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	MapSerializer
    //   0	296	1	paramMap	Map
    //   0	296	2	paramJsonGenerator	JsonGenerator
    //   0	296	3	paramSerializerProvider	SerializerProvider
    //   38	96	4	i	int
    //   44	245	5	localObject1	Object
    //   79	156	6	localObject2	Object
    //   246	5	6	localException	Exception
    //   175	108	7	localObject3	Object
    //   19	140	8	localJsonSerializer	JsonSerializer
    //   25	124	9	localHashSet	HashSet
    //   57	13	10	localIterator	Iterator
    //   88	149	11	localObject4	Object
    //   97	169	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   234	243	246	java/lang/Exception
  }
  
  protected void serializeFieldsUsing(Map paramMap, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, JsonSerializer paramJsonSerializer)
  {
    JsonSerializer localJsonSerializer = this._keySerializer;
    HashSet localHashSet = this._ignoredEntries;
    TypeSerializer localTypeSerializer = this._valueTypeSerializer;
    int i;
    Iterator localIterator;
    if (!paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES))
    {
      i = 1;
      localIterator = paramMap.entrySet().iterator();
    }
    for (;;)
    {
      label44:
      if (!localIterator.hasNext()) {
        return;
      }
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getValue();
      localObject2 = ((Map.Entry)localObject2).getKey();
      if (localObject2 == null) {
        paramSerializerProvider.getNullKeySerializer().serialize(null, paramJsonGenerator, paramSerializerProvider);
      }
      for (;;)
      {
        if (localObject1 != null) {
          break label155;
        }
        paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
        break label44;
        i = 0;
        break;
        if (((i != 0) && (localObject1 == null)) || ((localHashSet != null) && (localHashSet.contains(localObject2)))) {
          break label44;
        }
        localJsonSerializer.serialize(localObject2, paramJsonGenerator, paramSerializerProvider);
      }
      label155:
      if (localTypeSerializer == null) {
        try
        {
          paramJsonSerializer.serialize(localObject1, paramJsonGenerator, paramSerializerProvider);
        }
        catch (Exception localException)
        {
          wrapAndThrow(paramSerializerProvider, localException, paramMap, "" + localObject2);
        }
      } else {
        paramJsonSerializer.serializeWithType(localException, paramJsonGenerator, paramSerializerProvider, localTypeSerializer);
      }
    }
  }
  
  protected void serializeTypedFields(Map paramMap, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    JsonSerializer localJsonSerializer2 = this._keySerializer;
    HashSet localHashSet = this._ignoredEntries;
    int i;
    Object localObject2;
    Object localObject1;
    label44:
    Object localObject3;
    Object localObject5;
    Object localObject6;
    if (!paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES))
    {
      i = 1;
      Iterator localIterator = paramMap.entrySet().iterator();
      localObject2 = null;
      localObject1 = null;
      if (!localIterator.hasNext()) {
        return;
      }
      localObject3 = (Map.Entry)localIterator.next();
      localObject5 = ((Map.Entry)localObject3).getValue();
      localObject6 = ((Map.Entry)localObject3).getKey();
      if (localObject6 != null) {
        break label118;
      }
      paramSerializerProvider.getNullKeySerializer().serialize(null, paramJsonGenerator, paramSerializerProvider);
    }
    for (;;)
    {
      if (localObject5 != null) {
        break label155;
      }
      paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
      break label44;
      i = 0;
      break;
      label118:
      if (((i != 0) && (localObject5 == null)) || ((localHashSet != null) && (localHashSet.contains(localObject6)))) {
        break label44;
      }
      localJsonSerializer2.serialize(localObject6, paramJsonGenerator, paramSerializerProvider);
    }
    label155:
    Object localObject4 = localObject5.getClass();
    if (localObject4 == localObject2)
    {
      localObject4 = localObject1;
      localObject3 = localObject1;
      localObject1 = localObject4;
    }
    for (;;)
    {
      try
      {
        ((JsonSerializer)localObject3).serializeWithType(localObject5, paramJsonGenerator, paramSerializerProvider, this._valueTypeSerializer);
      }
      catch (Exception localException)
      {
        wrapAndThrow(paramSerializerProvider, localException, paramMap, "" + localObject6);
      }
      break;
      JsonSerializer localJsonSerializer1 = paramSerializerProvider.findValueSerializer((Class)localObject4, this._property);
      localObject1 = localJsonSerializer1;
      localObject2 = localObject4;
    }
  }
  
  public void serializeWithType(Map paramMap, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
  {
    paramTypeSerializer.writeTypePrefixForObject(paramMap, paramJsonGenerator);
    if (!paramMap.isEmpty())
    {
      if (this._valueSerializer == null) {
        break label42;
      }
      serializeFieldsUsing(paramMap, paramJsonGenerator, paramSerializerProvider, this._valueSerializer);
    }
    for (;;)
    {
      paramTypeSerializer.writeTypeSuffixForObject(paramMap, paramJsonGenerator);
      return;
      label42:
      serializeFields(paramMap, paramJsonGenerator, paramSerializerProvider);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/MapSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */