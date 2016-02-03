package org.codehaus.jackson.map;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.DateFormat;
import java.util.concurrent.ConcurrentHashMap;
import org.codehaus.jackson.FormatSchema;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonGenerator.Feature;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.Versioned;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import org.codehaus.jackson.io.SegmentedStringWriter;
import org.codehaus.jackson.io.SerializedString;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.deser.BeanDeserializerModifier;
import org.codehaus.jackson.map.deser.StdDeserializationContext;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;
import org.codehaus.jackson.map.deser.ValueInstantiators;
import org.codehaus.jackson.map.introspect.BasicClassIntrospector;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.introspect.VisibilityChecker.Std;
import org.codehaus.jackson.map.jsontype.NamedType;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.jsontype.impl.StdSubtypeResolver;
import org.codehaus.jackson.map.ser.BeanSerializerFactory;
import org.codehaus.jackson.map.ser.BeanSerializerModifier;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.type.TypeModifier;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.NullNode;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.node.TreeTraversingParser;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.codehaus.jackson.util.TokenBuffer;
import org.codehaus.jackson.util.VersionUtil;

public class ObjectMapper
  extends ObjectCodec
  implements Versioned
{
  protected static final AnnotationIntrospector DEFAULT_ANNOTATION_INTROSPECTOR = new JacksonAnnotationIntrospector();
  protected static final ClassIntrospector DEFAULT_INTROSPECTOR;
  private static final JavaType JSON_NODE_TYPE = SimpleType.constructUnsafe(JsonNode.class);
  protected static final VisibilityChecker STD_VISIBILITY_CHECKER = VisibilityChecker.Std.defaultInstance();
  protected DeserializationConfig _deserializationConfig;
  protected DeserializerProvider _deserializerProvider;
  protected InjectableValues _injectableValues;
  protected final JsonFactory _jsonFactory;
  protected final ConcurrentHashMap _rootDeserializers = new ConcurrentHashMap(64, 0.6F, 2);
  protected SerializationConfig _serializationConfig;
  protected SerializerFactory _serializerFactory;
  protected SerializerProvider _serializerProvider;
  protected SubtypeResolver _subtypeResolver;
  protected TypeFactory _typeFactory;
  
  static
  {
    DEFAULT_INTROSPECTOR = BasicClassIntrospector.instance;
  }
  
  public ObjectMapper()
  {
    this(null, null, null);
  }
  
  public ObjectMapper(JsonFactory paramJsonFactory)
  {
    this(paramJsonFactory, null, null);
  }
  
  public ObjectMapper(JsonFactory paramJsonFactory, SerializerProvider paramSerializerProvider, DeserializerProvider paramDeserializerProvider)
  {
    this(paramJsonFactory, paramSerializerProvider, paramDeserializerProvider, null, null);
  }
  
  public ObjectMapper(JsonFactory paramJsonFactory, SerializerProvider paramSerializerProvider, DeserializerProvider paramDeserializerProvider, SerializationConfig paramSerializationConfig, DeserializationConfig paramDeserializationConfig)
  {
    if (paramJsonFactory == null)
    {
      this._jsonFactory = new MappingJsonFactory(this);
      this._typeFactory = TypeFactory.defaultInstance();
      if (paramSerializationConfig == null) {
        break label135;
      }
      label48:
      this._serializationConfig = paramSerializationConfig;
      if (paramDeserializationConfig == null) {
        break label163;
      }
    }
    for (;;)
    {
      this._deserializationConfig = paramDeserializationConfig;
      paramJsonFactory = paramSerializerProvider;
      if (paramSerializerProvider == null) {
        paramJsonFactory = new StdSerializerProvider();
      }
      this._serializerProvider = paramJsonFactory;
      paramJsonFactory = paramDeserializerProvider;
      if (paramDeserializerProvider == null) {
        paramJsonFactory = new StdDeserializerProvider();
      }
      this._deserializerProvider = paramJsonFactory;
      this._serializerFactory = BeanSerializerFactory.instance;
      return;
      this._jsonFactory = paramJsonFactory;
      if (paramJsonFactory.getCodec() != null) {
        break;
      }
      this._jsonFactory.setCodec(this);
      break;
      label135:
      paramSerializationConfig = new SerializationConfig(DEFAULT_INTROSPECTOR, DEFAULT_ANNOTATION_INTROSPECTOR, STD_VISIBILITY_CHECKER, null, null, this._typeFactory, null);
      break label48;
      label163:
      paramDeserializationConfig = new DeserializationConfig(DEFAULT_INTROSPECTOR, DEFAULT_ANNOTATION_INTROSPECTOR, STD_VISIBILITY_CHECKER, null, null, this._typeFactory, null);
    }
  }
  
  @Deprecated
  public ObjectMapper(SerializerFactory paramSerializerFactory)
  {
    this(null, null, null);
    setSerializerFactory(paramSerializerFactory);
  }
  
  /* Error */
  private final void _configAndWriteCloseable(JsonGenerator paramJsonGenerator, Object paramObject, SerializationConfig paramSerializationConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: checkcast 156	java/io/Closeable
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 113	org/codehaus/jackson/map/ObjectMapper:_serializerProvider	Lorg/codehaus/jackson/map/SerializerProvider;
    //   10: aload_3
    //   11: aload_1
    //   12: aload_2
    //   13: aload_0
    //   14: getfield 125	org/codehaus/jackson/map/ObjectMapper:_serializerFactory	Lorg/codehaus/jackson/map/SerializerFactory;
    //   17: invokevirtual 162	org/codehaus/jackson/map/SerializerProvider:serializeValue	(Lorg/codehaus/jackson/map/SerializationConfig;Lorg/codehaus/jackson/JsonGenerator;Ljava/lang/Object;Lorg/codehaus/jackson/map/SerializerFactory;)V
    //   20: aload_1
    //   21: invokevirtual 167	org/codehaus/jackson/JsonGenerator:close	()V
    //   24: aload 4
    //   26: invokeinterface 168 1 0
    //   31: iconst_0
    //   32: ifeq +11 -> 43
    //   35: new 170	java/lang/NullPointerException
    //   38: dup
    //   39: invokespecial 171	java/lang/NullPointerException:<init>	()V
    //   42: athrow
    //   43: iconst_0
    //   44: ifeq +11 -> 55
    //   47: new 170	java/lang/NullPointerException
    //   50: dup
    //   51: invokespecial 171	java/lang/NullPointerException:<init>	()V
    //   54: athrow
    //   55: return
    //   56: astore_3
    //   57: aload 4
    //   59: astore_2
    //   60: aload_3
    //   61: astore 4
    //   63: aload_1
    //   64: astore_3
    //   65: aload 4
    //   67: astore_1
    //   68: aload_3
    //   69: ifnull +7 -> 76
    //   72: aload_3
    //   73: invokevirtual 167	org/codehaus/jackson/JsonGenerator:close	()V
    //   76: aload_2
    //   77: ifnull +9 -> 86
    //   80: aload_2
    //   81: invokeinterface 168 1 0
    //   86: aload_1
    //   87: athrow
    //   88: astore_1
    //   89: goto -46 -> 43
    //   92: astore_1
    //   93: return
    //   94: astore_3
    //   95: goto -19 -> 76
    //   98: astore_2
    //   99: goto -13 -> 86
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_3
    //   105: aload 4
    //   107: astore_2
    //   108: goto -40 -> 68
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_3
    //   116: goto -48 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	ObjectMapper
    //   0	119	1	paramJsonGenerator	JsonGenerator
    //   0	119	2	paramObject	Object
    //   0	119	3	paramSerializationConfig	SerializationConfig
    //   4	102	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	20	56	finally
    //   35	43	88	java/io/IOException
    //   47	55	92	java/io/IOException
    //   72	76	94	java/io/IOException
    //   80	86	98	java/io/IOException
    //   20	24	102	finally
    //   24	31	111	finally
  }
  
  /* Error */
  private final void _writeCloseableValue(JsonGenerator paramJsonGenerator, Object paramObject, SerializationConfig paramSerializationConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: checkcast 156	java/io/Closeable
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 113	org/codehaus/jackson/map/ObjectMapper:_serializerProvider	Lorg/codehaus/jackson/map/SerializerProvider;
    //   10: aload_3
    //   11: aload_1
    //   12: aload_2
    //   13: aload_0
    //   14: getfield 125	org/codehaus/jackson/map/ObjectMapper:_serializerFactory	Lorg/codehaus/jackson/map/SerializerFactory;
    //   17: invokevirtual 162	org/codehaus/jackson/map/SerializerProvider:serializeValue	(Lorg/codehaus/jackson/map/SerializationConfig;Lorg/codehaus/jackson/JsonGenerator;Ljava/lang/Object;Lorg/codehaus/jackson/map/SerializerFactory;)V
    //   20: aload_3
    //   21: getstatic 178	org/codehaus/jackson/map/SerializationConfig$Feature:FLUSH_AFTER_WRITE_VALUE	Lorg/codehaus/jackson/map/SerializationConfig$Feature;
    //   24: invokevirtual 182	org/codehaus/jackson/map/SerializationConfig:isEnabled	(Lorg/codehaus/jackson/map/SerializationConfig$Feature;)Z
    //   27: ifeq +7 -> 34
    //   30: aload_1
    //   31: invokevirtual 185	org/codehaus/jackson/JsonGenerator:flush	()V
    //   34: aconst_null
    //   35: astore_2
    //   36: aload 4
    //   38: invokeinterface 168 1 0
    //   43: iconst_0
    //   44: ifeq +11 -> 55
    //   47: new 170	java/lang/NullPointerException
    //   50: dup
    //   51: invokespecial 171	java/lang/NullPointerException:<init>	()V
    //   54: athrow
    //   55: return
    //   56: astore_1
    //   57: aload 4
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull +9 -> 70
    //   64: aload_2
    //   65: invokeinterface 168 1 0
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: return
    //   74: astore_2
    //   75: goto -5 -> 70
    //   78: astore_1
    //   79: goto -19 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ObjectMapper
    //   0	82	1	paramJsonGenerator	JsonGenerator
    //   0	82	2	paramObject	Object
    //   0	82	3	paramSerializationConfig	SerializationConfig
    //   4	54	4	localCloseable	Closeable
    // Exception table:
    //   from	to	target	type
    //   6	34	56	finally
    //   47	55	72	java/io/IOException
    //   64	70	74	java/io/IOException
    //   36	43	78	finally
  }
  
  protected final void _configAndWriteValue(JsonGenerator paramJsonGenerator, Object paramObject)
  {
    SerializationConfig localSerializationConfig = copySerializationConfig();
    if (localSerializationConfig.isEnabled(SerializationConfig.Feature.INDENT_OUTPUT)) {
      paramJsonGenerator.useDefaultPrettyPrinter();
    }
    if ((localSerializationConfig.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE)) && ((paramObject instanceof Closeable)))
    {
      _configAndWriteCloseable(paramJsonGenerator, paramObject, localSerializationConfig);
      return;
    }
    int i = 0;
    try
    {
      this._serializerProvider.serializeValue(localSerializationConfig, paramJsonGenerator, paramObject, this._serializerFactory);
      i = 1;
      paramJsonGenerator.close();
      return;
    }
    finally
    {
      if (i != 0) {}
    }
    try
    {
      paramJsonGenerator.close();
      throw ((Throwable)paramObject);
    }
    catch (IOException paramJsonGenerator)
    {
      for (;;) {}
    }
  }
  
  protected final void _configAndWriteValue(JsonGenerator paramJsonGenerator, Object paramObject, Class paramClass)
  {
    paramClass = copySerializationConfig().withView(paramClass);
    if (paramClass.isEnabled(SerializationConfig.Feature.INDENT_OUTPUT)) {
      paramJsonGenerator.useDefaultPrettyPrinter();
    }
    if ((paramClass.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE)) && ((paramObject instanceof Closeable)))
    {
      _configAndWriteCloseable(paramJsonGenerator, paramObject, paramClass);
      return;
    }
    int i = 0;
    try
    {
      this._serializerProvider.serializeValue(paramClass, paramJsonGenerator, paramObject, this._serializerFactory);
      i = 1;
      paramJsonGenerator.close();
      return;
    }
    finally
    {
      if (i != 0) {}
    }
    try
    {
      paramJsonGenerator.close();
      throw ((Throwable)paramObject);
    }
    catch (IOException paramJsonGenerator)
    {
      for (;;) {}
    }
  }
  
  protected Object _convert(Object paramObject, JavaType paramJavaType)
  {
    if (paramObject == null) {
      return null;
    }
    TokenBuffer localTokenBuffer = new TokenBuffer(this);
    try
    {
      writeValue(localTokenBuffer, paramObject);
      paramObject = localTokenBuffer.asParser();
      paramJavaType = readValue((JsonParser)paramObject, paramJavaType);
      ((JsonParser)paramObject).close();
      return paramJavaType;
    }
    catch (IOException paramObject)
    {
      throw new IllegalArgumentException(((IOException)paramObject).getMessage(), (Throwable)paramObject);
    }
  }
  
  protected DeserializationContext _createDeserializationContext(JsonParser paramJsonParser, DeserializationConfig paramDeserializationConfig)
  {
    return new StdDeserializationContext(paramDeserializationConfig, paramJsonParser, this._deserializerProvider, this._injectableValues);
  }
  
  protected PrettyPrinter _defaultPrettyPrinter()
  {
    return new DefaultPrettyPrinter();
  }
  
  protected JsonDeserializer _findRootDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    JsonDeserializer localJsonDeserializer = (JsonDeserializer)this._rootDeserializers.get(paramJavaType);
    if (localJsonDeserializer != null) {
      return localJsonDeserializer;
    }
    paramDeserializationConfig = this._deserializerProvider.findTypedValueDeserializer(paramDeserializationConfig, paramJavaType, null);
    if (paramDeserializationConfig == null) {
      throw new JsonMappingException("Can not find a deserializer for type " + paramJavaType);
    }
    this._rootDeserializers.put(paramJavaType, paramDeserializationConfig);
    return paramDeserializationConfig;
  }
  
  protected JsonToken _initForReading(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    Object localObject = localJsonToken;
    if (localJsonToken == null)
    {
      paramJsonParser = paramJsonParser.nextToken();
      localObject = paramJsonParser;
      if (paramJsonParser == null) {
        throw new EOFException("No content to map to Object due to end of input");
      }
    }
    return (JsonToken)localObject;
  }
  
  /* Error */
  protected Object _readMapAndClose(JsonParser paramJsonParser, JavaType paramJavaType)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 307	org/codehaus/jackson/map/ObjectMapper:_initForReading	(Lorg/codehaus/jackson/JsonParser;)Lorg/codehaus/jackson/JsonToken;
    //   5: astore_3
    //   6: aload_3
    //   7: getstatic 313	org/codehaus/jackson/JsonToken:VALUE_NULL	Lorg/codehaus/jackson/JsonToken;
    //   10: if_acmpne +26 -> 36
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 108	org/codehaus/jackson/map/ObjectMapper:_deserializationConfig	Lorg/codehaus/jackson/map/DeserializationConfig;
    //   18: aload_2
    //   19: invokevirtual 315	org/codehaus/jackson/map/ObjectMapper:_findRootDeserializer	(Lorg/codehaus/jackson/map/DeserializationConfig;Lorg/codehaus/jackson/type/JavaType;)Lorg/codehaus/jackson/map/JsonDeserializer;
    //   22: invokevirtual 319	org/codehaus/jackson/map/JsonDeserializer:getNullValue	()Ljava/lang/Object;
    //   25: astore_2
    //   26: aload_1
    //   27: invokevirtual 322	org/codehaus/jackson/JsonParser:clearCurrentToken	()V
    //   30: aload_1
    //   31: invokevirtual 229	org/codehaus/jackson/JsonParser:close	()V
    //   34: aload_2
    //   35: areturn
    //   36: aload_3
    //   37: getstatic 325	org/codehaus/jackson/JsonToken:END_ARRAY	Lorg/codehaus/jackson/JsonToken;
    //   40: if_acmpeq +84 -> 124
    //   43: aload_3
    //   44: getstatic 328	org/codehaus/jackson/JsonToken:END_OBJECT	Lorg/codehaus/jackson/JsonToken;
    //   47: if_acmpne +6 -> 53
    //   50: goto +74 -> 124
    //   53: aload_0
    //   54: invokevirtual 332	org/codehaus/jackson/map/ObjectMapper:copyDeserializationConfig	()Lorg/codehaus/jackson/map/DeserializationConfig;
    //   57: astore_3
    //   58: aload_0
    //   59: aload_1
    //   60: aload_3
    //   61: invokevirtual 334	org/codehaus/jackson/map/ObjectMapper:_createDeserializationContext	(Lorg/codehaus/jackson/JsonParser;Lorg/codehaus/jackson/map/DeserializationConfig;)Lorg/codehaus/jackson/map/DeserializationContext;
    //   64: astore 4
    //   66: aload_0
    //   67: aload_3
    //   68: aload_2
    //   69: invokevirtual 315	org/codehaus/jackson/map/ObjectMapper:_findRootDeserializer	(Lorg/codehaus/jackson/map/DeserializationConfig;Lorg/codehaus/jackson/type/JavaType;)Lorg/codehaus/jackson/map/JsonDeserializer;
    //   72: astore 5
    //   74: aload_3
    //   75: getstatic 340	org/codehaus/jackson/map/DeserializationConfig$Feature:UNWRAP_ROOT_VALUE	Lorg/codehaus/jackson/map/DeserializationConfig$Feature;
    //   78: invokevirtual 343	org/codehaus/jackson/map/DeserializationConfig:isEnabled	(Lorg/codehaus/jackson/map/DeserializationConfig$Feature;)Z
    //   81: ifeq +17 -> 98
    //   84: aload_0
    //   85: aload_1
    //   86: aload_2
    //   87: aload 4
    //   89: aload 5
    //   91: invokevirtual 347	org/codehaus/jackson/map/ObjectMapper:_unwrapAndDeserialize	(Lorg/codehaus/jackson/JsonParser;Lorg/codehaus/jackson/type/JavaType;Lorg/codehaus/jackson/map/DeserializationContext;Lorg/codehaus/jackson/map/JsonDeserializer;)Ljava/lang/Object;
    //   94: astore_2
    //   95: goto -69 -> 26
    //   98: aload 5
    //   100: aload_1
    //   101: aload 4
    //   103: invokevirtual 351	org/codehaus/jackson/map/JsonDeserializer:deserialize	(Lorg/codehaus/jackson/JsonParser;Lorg/codehaus/jackson/map/DeserializationContext;)Ljava/lang/Object;
    //   106: astore_2
    //   107: goto -81 -> 26
    //   110: astore_2
    //   111: aload_1
    //   112: invokevirtual 229	org/codehaus/jackson/JsonParser:close	()V
    //   115: aload_2
    //   116: athrow
    //   117: astore_1
    //   118: aload_2
    //   119: areturn
    //   120: astore_1
    //   121: goto -6 -> 115
    //   124: aconst_null
    //   125: astore_2
    //   126: goto -100 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	ObjectMapper
    //   0	129	1	paramJsonParser	JsonParser
    //   0	129	2	paramJavaType	JavaType
    //   5	70	3	localObject	Object
    //   64	38	4	localDeserializationContext	DeserializationContext
    //   72	27	5	localJsonDeserializer	JsonDeserializer
    // Exception table:
    //   from	to	target	type
    //   0	26	110	finally
    //   26	30	110	finally
    //   36	50	110	finally
    //   53	95	110	finally
    //   98	107	110	finally
    //   30	34	117	java/io/IOException
    //   111	115	120	java/io/IOException
  }
  
  protected Object _readValue(DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, JavaType paramJavaType)
  {
    Object localObject = _initForReading(paramJsonParser);
    if (localObject == JsonToken.VALUE_NULL) {
      paramDeserializationConfig = _findRootDeserializer(paramDeserializationConfig, paramJavaType).getNullValue();
    }
    for (;;)
    {
      paramJsonParser.clearCurrentToken();
      return paramDeserializationConfig;
      if ((localObject == JsonToken.END_ARRAY) || (localObject == JsonToken.END_OBJECT))
      {
        paramDeserializationConfig = null;
      }
      else
      {
        localObject = _createDeserializationContext(paramJsonParser, paramDeserializationConfig);
        JsonDeserializer localJsonDeserializer = _findRootDeserializer(paramDeserializationConfig, paramJavaType);
        if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE)) {
          paramDeserializationConfig = _unwrapAndDeserialize(paramJsonParser, paramJavaType, (DeserializationContext)localObject, localJsonDeserializer);
        } else {
          paramDeserializationConfig = localJsonDeserializer.deserialize(paramJsonParser, (DeserializationContext)localObject);
        }
      }
    }
  }
  
  protected Object _unwrapAndDeserialize(JsonParser paramJsonParser, JavaType paramJavaType, DeserializationContext paramDeserializationContext, JsonDeserializer paramJsonDeserializer)
  {
    SerializedString localSerializedString = this._deserializerProvider.findExpectedRootName(paramDeserializationContext.getConfig(), paramJavaType);
    if (paramJsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
      throw JsonMappingException.from(paramJsonParser, "Current token not START_OBJECT (needed to unwrap root name '" + localSerializedString + "'), but " + paramJsonParser.getCurrentToken());
    }
    if (paramJsonParser.nextToken() != JsonToken.FIELD_NAME) {
      throw JsonMappingException.from(paramJsonParser, "Current token not FIELD_NAME (to contain expected root name '" + localSerializedString + "'), but " + paramJsonParser.getCurrentToken());
    }
    String str = paramJsonParser.getCurrentName();
    if (!localSerializedString.getValue().equals(str)) {
      throw JsonMappingException.from(paramJsonParser, "Root name '" + str + "' does not match expected ('" + localSerializedString + "') for type " + paramJavaType);
    }
    paramJsonParser.nextToken();
    paramJavaType = paramJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser.nextToken() != JsonToken.END_OBJECT) {
      throw JsonMappingException.from(paramJsonParser, "Current token not END_OBJECT (to match wrapper object with root name '" + localSerializedString + "'), but " + paramJsonParser.getCurrentToken());
    }
    return paramJavaType;
  }
  
  public boolean canDeserialize(JavaType paramJavaType)
  {
    return this._deserializerProvider.hasValueDeserializerFor(copyDeserializationConfig(), paramJavaType);
  }
  
  public boolean canSerialize(Class paramClass)
  {
    return this._serializerProvider.hasSerializerFor(copySerializationConfig(), paramClass, this._serializerFactory);
  }
  
  public ObjectMapper configure(JsonGenerator.Feature paramFeature, boolean paramBoolean)
  {
    this._jsonFactory.configure(paramFeature, paramBoolean);
    return this;
  }
  
  public ObjectMapper configure(JsonParser.Feature paramFeature, boolean paramBoolean)
  {
    this._jsonFactory.configure(paramFeature, paramBoolean);
    return this;
  }
  
  public ObjectMapper configure(DeserializationConfig.Feature paramFeature, boolean paramBoolean)
  {
    this._deserializationConfig.set(paramFeature, paramBoolean);
    return this;
  }
  
  public ObjectMapper configure(SerializationConfig.Feature paramFeature, boolean paramBoolean)
  {
    this._serializationConfig.set(paramFeature, paramBoolean);
    return this;
  }
  
  public JavaType constructType(Type paramType)
  {
    return this._typeFactory.constructType(paramType);
  }
  
  public Object convertValue(Object paramObject, Class paramClass)
  {
    return _convert(paramObject, this._typeFactory.constructType(paramClass));
  }
  
  public Object convertValue(Object paramObject, JavaType paramJavaType)
  {
    return _convert(paramObject, paramJavaType);
  }
  
  public Object convertValue(Object paramObject, TypeReference paramTypeReference)
  {
    return _convert(paramObject, this._typeFactory.constructType(paramTypeReference));
  }
  
  public DeserializationConfig copyDeserializationConfig()
  {
    return this._deserializationConfig.createUnshared(this._subtypeResolver).passSerializationFeatures(this._serializationConfig._featureFlags);
  }
  
  public SerializationConfig copySerializationConfig()
  {
    return this._serializationConfig.createUnshared(this._subtypeResolver);
  }
  
  public ArrayNode createArrayNode()
  {
    return this._deserializationConfig.getNodeFactory().arrayNode();
  }
  
  public ObjectNode createObjectNode()
  {
    return this._deserializationConfig.getNodeFactory().objectNode();
  }
  
  @Deprecated
  public ObjectWriter defaultPrettyPrintingWriter()
  {
    return writerWithDefaultPrettyPrinter();
  }
  
  public ObjectMapper disable(DeserializationConfig.Feature... paramVarArgs)
  {
    this._deserializationConfig = this._deserializationConfig.without(paramVarArgs);
    return this;
  }
  
  public ObjectMapper disable(SerializationConfig.Feature... paramVarArgs)
  {
    this._serializationConfig = this._serializationConfig.without(paramVarArgs);
    return this;
  }
  
  public ObjectMapper disableDefaultTyping()
  {
    return setDefaultTyping(null);
  }
  
  public ObjectMapper enable(DeserializationConfig.Feature... paramVarArgs)
  {
    this._deserializationConfig = this._deserializationConfig.with(paramVarArgs);
    return this;
  }
  
  public ObjectMapper enable(SerializationConfig.Feature... paramVarArgs)
  {
    this._serializationConfig = this._serializationConfig.with(paramVarArgs);
    return this;
  }
  
  public ObjectMapper enableDefaultTyping()
  {
    return enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
  }
  
  public ObjectMapper enableDefaultTyping(ObjectMapper.DefaultTyping paramDefaultTyping)
  {
    return enableDefaultTyping(paramDefaultTyping, JsonTypeInfo.As.WRAPPER_ARRAY);
  }
  
  public ObjectMapper enableDefaultTyping(ObjectMapper.DefaultTyping paramDefaultTyping, JsonTypeInfo.As paramAs)
  {
    return setDefaultTyping(new ObjectMapper.DefaultTypeResolverBuilder(paramDefaultTyping).init(JsonTypeInfo.Id.CLASS, null).inclusion(paramAs));
  }
  
  public ObjectMapper enableDefaultTypingAsProperty(ObjectMapper.DefaultTyping paramDefaultTyping, String paramString)
  {
    return setDefaultTyping(new ObjectMapper.DefaultTypeResolverBuilder(paramDefaultTyping).init(JsonTypeInfo.Id.CLASS, null).inclusion(JsonTypeInfo.As.PROPERTY).typeProperty(paramString));
  }
  
  @Deprecated
  public ObjectWriter filteredWriter(FilterProvider paramFilterProvider)
  {
    return writer(paramFilterProvider);
  }
  
  public JsonSchema generateJsonSchema(Class paramClass)
  {
    return generateJsonSchema(paramClass, copySerializationConfig());
  }
  
  public JsonSchema generateJsonSchema(Class paramClass, SerializationConfig paramSerializationConfig)
  {
    return this._serializerProvider.generateJsonSchema(paramClass, paramSerializationConfig, this._serializerFactory);
  }
  
  public DeserializationConfig getDeserializationConfig()
  {
    return this._deserializationConfig;
  }
  
  public DeserializerProvider getDeserializerProvider()
  {
    return this._deserializerProvider;
  }
  
  public JsonFactory getJsonFactory()
  {
    return this._jsonFactory;
  }
  
  public JsonNodeFactory getNodeFactory()
  {
    return this._deserializationConfig.getNodeFactory();
  }
  
  public SerializationConfig getSerializationConfig()
  {
    return this._serializationConfig;
  }
  
  public SerializerProvider getSerializerProvider()
  {
    return this._serializerProvider;
  }
  
  public SubtypeResolver getSubtypeResolver()
  {
    if (this._subtypeResolver == null) {
      this._subtypeResolver = new StdSubtypeResolver();
    }
    return this._subtypeResolver;
  }
  
  public TypeFactory getTypeFactory()
  {
    return this._typeFactory;
  }
  
  public VisibilityChecker getVisibilityChecker()
  {
    return this._serializationConfig.getDefaultVisibilityChecker();
  }
  
  public boolean isEnabled(JsonGenerator.Feature paramFeature)
  {
    return this._jsonFactory.isEnabled(paramFeature);
  }
  
  public boolean isEnabled(JsonParser.Feature paramFeature)
  {
    return this._jsonFactory.isEnabled(paramFeature);
  }
  
  public boolean isEnabled(DeserializationConfig.Feature paramFeature)
  {
    return this._deserializationConfig.isEnabled(paramFeature);
  }
  
  public boolean isEnabled(SerializationConfig.Feature paramFeature)
  {
    return this._serializationConfig.isEnabled(paramFeature);
  }
  
  @Deprecated
  public ObjectWriter prettyPrintingWriter(PrettyPrinter paramPrettyPrinter)
  {
    return writer(paramPrettyPrinter);
  }
  
  public JsonNode readTree(File paramFile)
  {
    JsonNode localJsonNode = (JsonNode)_readMapAndClose(this._jsonFactory.createJsonParser(paramFile), JSON_NODE_TYPE);
    paramFile = localJsonNode;
    if (localJsonNode == null) {
      paramFile = NullNode.instance;
    }
    return paramFile;
  }
  
  public JsonNode readTree(InputStream paramInputStream)
  {
    JsonNode localJsonNode = (JsonNode)_readMapAndClose(this._jsonFactory.createJsonParser(paramInputStream), JSON_NODE_TYPE);
    paramInputStream = localJsonNode;
    if (localJsonNode == null) {
      paramInputStream = NullNode.instance;
    }
    return paramInputStream;
  }
  
  public JsonNode readTree(Reader paramReader)
  {
    JsonNode localJsonNode = (JsonNode)_readMapAndClose(this._jsonFactory.createJsonParser(paramReader), JSON_NODE_TYPE);
    paramReader = localJsonNode;
    if (localJsonNode == null) {
      paramReader = NullNode.instance;
    }
    return paramReader;
  }
  
  public JsonNode readTree(String paramString)
  {
    JsonNode localJsonNode = (JsonNode)_readMapAndClose(this._jsonFactory.createJsonParser(paramString), JSON_NODE_TYPE);
    paramString = localJsonNode;
    if (localJsonNode == null) {
      paramString = NullNode.instance;
    }
    return paramString;
  }
  
  public JsonNode readTree(URL paramURL)
  {
    JsonNode localJsonNode = (JsonNode)_readMapAndClose(this._jsonFactory.createJsonParser(paramURL), JSON_NODE_TYPE);
    paramURL = localJsonNode;
    if (localJsonNode == null) {
      paramURL = NullNode.instance;
    }
    return paramURL;
  }
  
  public JsonNode readTree(JsonParser paramJsonParser)
  {
    Object localObject = copyDeserializationConfig();
    if ((paramJsonParser.getCurrentToken() == null) && (paramJsonParser.nextToken() == null)) {
      paramJsonParser = null;
    }
    do
    {
      return paramJsonParser;
      localObject = (JsonNode)_readValue((DeserializationConfig)localObject, paramJsonParser, JSON_NODE_TYPE);
      paramJsonParser = (JsonParser)localObject;
    } while (localObject != null);
    return getNodeFactory().nullNode();
  }
  
  public JsonNode readTree(JsonParser paramJsonParser, DeserializationConfig paramDeserializationConfig)
  {
    paramDeserializationConfig = (JsonNode)_readValue(paramDeserializationConfig, paramJsonParser, JSON_NODE_TYPE);
    paramJsonParser = paramDeserializationConfig;
    if (paramDeserializationConfig == null) {
      paramJsonParser = NullNode.instance;
    }
    return paramJsonParser;
  }
  
  public JsonNode readTree(byte[] paramArrayOfByte)
  {
    JsonNode localJsonNode = (JsonNode)_readMapAndClose(this._jsonFactory.createJsonParser(paramArrayOfByte), JSON_NODE_TYPE);
    paramArrayOfByte = localJsonNode;
    if (localJsonNode == null) {
      paramArrayOfByte = NullNode.instance;
    }
    return paramArrayOfByte;
  }
  
  public Object readValue(File paramFile, Class paramClass)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramFile), this._typeFactory.constructType(paramClass));
  }
  
  public Object readValue(File paramFile, JavaType paramJavaType)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramFile), paramJavaType);
  }
  
  public Object readValue(File paramFile, TypeReference paramTypeReference)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramFile), this._typeFactory.constructType(paramTypeReference));
  }
  
  public Object readValue(InputStream paramInputStream, Class paramClass)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramInputStream), this._typeFactory.constructType(paramClass));
  }
  
  public Object readValue(InputStream paramInputStream, JavaType paramJavaType)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramInputStream), paramJavaType);
  }
  
  public Object readValue(InputStream paramInputStream, TypeReference paramTypeReference)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramInputStream), this._typeFactory.constructType(paramTypeReference));
  }
  
  public Object readValue(Reader paramReader, Class paramClass)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramReader), this._typeFactory.constructType(paramClass));
  }
  
  public Object readValue(Reader paramReader, JavaType paramJavaType)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramReader), paramJavaType);
  }
  
  public Object readValue(Reader paramReader, TypeReference paramTypeReference)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramReader), this._typeFactory.constructType(paramTypeReference));
  }
  
  public Object readValue(String paramString, Class paramClass)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramString), this._typeFactory.constructType(paramClass));
  }
  
  public Object readValue(String paramString, JavaType paramJavaType)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramString), paramJavaType);
  }
  
  public Object readValue(String paramString, TypeReference paramTypeReference)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramString), this._typeFactory.constructType(paramTypeReference));
  }
  
  public Object readValue(URL paramURL, Class paramClass)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramURL), this._typeFactory.constructType(paramClass));
  }
  
  public Object readValue(URL paramURL, JavaType paramJavaType)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramURL), paramJavaType);
  }
  
  public Object readValue(URL paramURL, TypeReference paramTypeReference)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramURL), this._typeFactory.constructType(paramTypeReference));
  }
  
  public Object readValue(JsonNode paramJsonNode, Class paramClass)
  {
    return _readValue(copyDeserializationConfig(), treeAsTokens(paramJsonNode), this._typeFactory.constructType(paramClass));
  }
  
  public Object readValue(JsonNode paramJsonNode, JavaType paramJavaType)
  {
    return _readValue(copyDeserializationConfig(), treeAsTokens(paramJsonNode), paramJavaType);
  }
  
  public Object readValue(JsonNode paramJsonNode, TypeReference paramTypeReference)
  {
    return _readValue(copyDeserializationConfig(), treeAsTokens(paramJsonNode), this._typeFactory.constructType(paramTypeReference));
  }
  
  public Object readValue(JsonParser paramJsonParser, Class paramClass)
  {
    return _readValue(copyDeserializationConfig(), paramJsonParser, this._typeFactory.constructType(paramClass));
  }
  
  public Object readValue(JsonParser paramJsonParser, Class paramClass, DeserializationConfig paramDeserializationConfig)
  {
    return _readValue(paramDeserializationConfig, paramJsonParser, this._typeFactory.constructType(paramClass));
  }
  
  public Object readValue(JsonParser paramJsonParser, JavaType paramJavaType)
  {
    return _readValue(copyDeserializationConfig(), paramJsonParser, paramJavaType);
  }
  
  public Object readValue(JsonParser paramJsonParser, JavaType paramJavaType, DeserializationConfig paramDeserializationConfig)
  {
    return _readValue(paramDeserializationConfig, paramJsonParser, paramJavaType);
  }
  
  public Object readValue(JsonParser paramJsonParser, TypeReference paramTypeReference)
  {
    return _readValue(copyDeserializationConfig(), paramJsonParser, this._typeFactory.constructType(paramTypeReference));
  }
  
  public Object readValue(JsonParser paramJsonParser, TypeReference paramTypeReference, DeserializationConfig paramDeserializationConfig)
  {
    return _readValue(paramDeserializationConfig, paramJsonParser, this._typeFactory.constructType(paramTypeReference));
  }
  
  public Object readValue(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Class paramClass)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramArrayOfByte, paramInt1, paramInt2), this._typeFactory.constructType(paramClass));
  }
  
  public Object readValue(byte[] paramArrayOfByte, int paramInt1, int paramInt2, JavaType paramJavaType)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramArrayOfByte, paramInt1, paramInt2), paramJavaType);
  }
  
  public Object readValue(byte[] paramArrayOfByte, int paramInt1, int paramInt2, TypeReference paramTypeReference)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramArrayOfByte, paramInt1, paramInt2), this._typeFactory.constructType(paramTypeReference));
  }
  
  public Object readValue(byte[] paramArrayOfByte, Class paramClass)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramArrayOfByte), this._typeFactory.constructType(paramClass));
  }
  
  public Object readValue(byte[] paramArrayOfByte, JavaType paramJavaType)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramArrayOfByte), paramJavaType);
  }
  
  public Object readValue(byte[] paramArrayOfByte, TypeReference paramTypeReference)
  {
    return _readMapAndClose(this._jsonFactory.createJsonParser(paramArrayOfByte), this._typeFactory.constructType(paramTypeReference));
  }
  
  public MappingIterator readValues(JsonParser paramJsonParser, Class paramClass)
  {
    return readValues(paramJsonParser, this._typeFactory.constructType(paramClass));
  }
  
  public MappingIterator readValues(JsonParser paramJsonParser, JavaType paramJavaType)
  {
    DeserializationConfig localDeserializationConfig = copyDeserializationConfig();
    return new MappingIterator(paramJavaType, paramJsonParser, _createDeserializationContext(paramJsonParser, localDeserializationConfig), _findRootDeserializer(localDeserializationConfig, paramJavaType), false, null);
  }
  
  public MappingIterator readValues(JsonParser paramJsonParser, TypeReference paramTypeReference)
  {
    return readValues(paramJsonParser, this._typeFactory.constructType(paramTypeReference));
  }
  
  public ObjectReader reader()
  {
    return new ObjectReader(this, copyDeserializationConfig()).withInjectableValues(this._injectableValues);
  }
  
  public ObjectReader reader(Class paramClass)
  {
    return reader(this._typeFactory.constructType(paramClass));
  }
  
  public ObjectReader reader(FormatSchema paramFormatSchema)
  {
    return new ObjectReader(this, copyDeserializationConfig(), null, null, paramFormatSchema, this._injectableValues);
  }
  
  public ObjectReader reader(InjectableValues paramInjectableValues)
  {
    return new ObjectReader(this, copyDeserializationConfig(), null, null, null, paramInjectableValues);
  }
  
  public ObjectReader reader(JsonNodeFactory paramJsonNodeFactory)
  {
    return new ObjectReader(this, copyDeserializationConfig()).withNodeFactory(paramJsonNodeFactory);
  }
  
  public ObjectReader reader(JavaType paramJavaType)
  {
    return new ObjectReader(this, copyDeserializationConfig(), paramJavaType, null, null, this._injectableValues);
  }
  
  public ObjectReader reader(TypeReference paramTypeReference)
  {
    return reader(this._typeFactory.constructType(paramTypeReference));
  }
  
  public ObjectReader readerForUpdating(Object paramObject)
  {
    JavaType localJavaType = this._typeFactory.constructType(paramObject.getClass());
    return new ObjectReader(this, copyDeserializationConfig(), localJavaType, paramObject, null, this._injectableValues);
  }
  
  public void registerModule(Module paramModule)
  {
    if (paramModule.getModuleName() == null) {
      throw new IllegalArgumentException("Module without defined name");
    }
    if (paramModule.version() == null) {
      throw new IllegalArgumentException("Module without defined version");
    }
    paramModule.setupModule(new Module.SetupContext()
    {
      public void addAbstractTypeResolver(AbstractTypeResolver paramAnonymousAbstractTypeResolver)
      {
        jdField_this._deserializerProvider = jdField_this._deserializerProvider.withAbstractTypeResolver(paramAnonymousAbstractTypeResolver);
      }
      
      public void addBeanDeserializerModifier(BeanDeserializerModifier paramAnonymousBeanDeserializerModifier)
      {
        jdField_this._deserializerProvider = jdField_this._deserializerProvider.withDeserializerModifier(paramAnonymousBeanDeserializerModifier);
      }
      
      public void addBeanSerializerModifier(BeanSerializerModifier paramAnonymousBeanSerializerModifier)
      {
        jdField_this._serializerFactory = jdField_this._serializerFactory.withSerializerModifier(paramAnonymousBeanSerializerModifier);
      }
      
      public void addDeserializers(Deserializers paramAnonymousDeserializers)
      {
        jdField_this._deserializerProvider = jdField_this._deserializerProvider.withAdditionalDeserializers(paramAnonymousDeserializers);
      }
      
      public void addKeyDeserializers(KeyDeserializers paramAnonymousKeyDeserializers)
      {
        jdField_this._deserializerProvider = jdField_this._deserializerProvider.withAdditionalKeyDeserializers(paramAnonymousKeyDeserializers);
      }
      
      public void addKeySerializers(Serializers paramAnonymousSerializers)
      {
        jdField_this._serializerFactory = jdField_this._serializerFactory.withAdditionalKeySerializers(paramAnonymousSerializers);
      }
      
      public void addSerializers(Serializers paramAnonymousSerializers)
      {
        jdField_this._serializerFactory = jdField_this._serializerFactory.withAdditionalSerializers(paramAnonymousSerializers);
      }
      
      public void addTypeModifier(TypeModifier paramAnonymousTypeModifier)
      {
        paramAnonymousTypeModifier = jdField_this._typeFactory.withModifier(paramAnonymousTypeModifier);
        jdField_this.setTypeFactory(paramAnonymousTypeModifier);
      }
      
      public void addValueInstantiators(ValueInstantiators paramAnonymousValueInstantiators)
      {
        jdField_this._deserializerProvider = jdField_this._deserializerProvider.withValueInstantiators(paramAnonymousValueInstantiators);
      }
      
      public void appendAnnotationIntrospector(AnnotationIntrospector paramAnonymousAnnotationIntrospector)
      {
        jdField_this._deserializationConfig = jdField_this._deserializationConfig.withAppendedAnnotationIntrospector(paramAnonymousAnnotationIntrospector);
        jdField_this._serializationConfig = jdField_this._serializationConfig.withAppendedAnnotationIntrospector(paramAnonymousAnnotationIntrospector);
      }
      
      public DeserializationConfig getDeserializationConfig()
      {
        return jdField_this.getDeserializationConfig();
      }
      
      public Version getMapperVersion()
      {
        return ObjectMapper.this.version();
      }
      
      public SerializationConfig getSerializationConfig()
      {
        return jdField_this.getSerializationConfig();
      }
      
      public void insertAnnotationIntrospector(AnnotationIntrospector paramAnonymousAnnotationIntrospector)
      {
        jdField_this._deserializationConfig = jdField_this._deserializationConfig.withInsertedAnnotationIntrospector(paramAnonymousAnnotationIntrospector);
        jdField_this._serializationConfig = jdField_this._serializationConfig.withInsertedAnnotationIntrospector(paramAnonymousAnnotationIntrospector);
      }
      
      public boolean isEnabled(JsonGenerator.Feature paramAnonymousFeature)
      {
        return jdField_this.isEnabled(paramAnonymousFeature);
      }
      
      public boolean isEnabled(JsonParser.Feature paramAnonymousFeature)
      {
        return jdField_this.isEnabled(paramAnonymousFeature);
      }
      
      public boolean isEnabled(DeserializationConfig.Feature paramAnonymousFeature)
      {
        return jdField_this.isEnabled(paramAnonymousFeature);
      }
      
      public boolean isEnabled(SerializationConfig.Feature paramAnonymousFeature)
      {
        return jdField_this.isEnabled(paramAnonymousFeature);
      }
      
      public void setMixInAnnotations(Class paramAnonymousClass1, Class paramAnonymousClass2)
      {
        jdField_this._deserializationConfig.addMixInAnnotations(paramAnonymousClass1, paramAnonymousClass2);
        jdField_this._serializationConfig.addMixInAnnotations(paramAnonymousClass1, paramAnonymousClass2);
      }
    });
  }
  
  public void registerSubtypes(Class... paramVarArgs)
  {
    getSubtypeResolver().registerSubtypes(paramVarArgs);
  }
  
  public void registerSubtypes(NamedType... paramVarArgs)
  {
    getSubtypeResolver().registerSubtypes(paramVarArgs);
  }
  
  @Deprecated
  public ObjectReader schemaBasedReader(FormatSchema paramFormatSchema)
  {
    return reader(paramFormatSchema);
  }
  
  @Deprecated
  public ObjectWriter schemaBasedWriter(FormatSchema paramFormatSchema)
  {
    return writer(paramFormatSchema);
  }
  
  public ObjectMapper setAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    this._serializationConfig = this._serializationConfig.withAnnotationIntrospector(paramAnnotationIntrospector);
    this._deserializationConfig = this._deserializationConfig.withAnnotationIntrospector(paramAnnotationIntrospector);
    return this;
  }
  
  public void setDateFormat(DateFormat paramDateFormat)
  {
    this._deserializationConfig = this._deserializationConfig.withDateFormat(paramDateFormat);
    this._serializationConfig = this._serializationConfig.withDateFormat(paramDateFormat);
  }
  
  public ObjectMapper setDefaultTyping(TypeResolverBuilder paramTypeResolverBuilder)
  {
    this._deserializationConfig = this._deserializationConfig.withTypeResolverBuilder(paramTypeResolverBuilder);
    this._serializationConfig = this._serializationConfig.withTypeResolverBuilder(paramTypeResolverBuilder);
    return this;
  }
  
  public ObjectMapper setDeserializationConfig(DeserializationConfig paramDeserializationConfig)
  {
    this._deserializationConfig = paramDeserializationConfig;
    return this;
  }
  
  public ObjectMapper setDeserializerProvider(DeserializerProvider paramDeserializerProvider)
  {
    this._deserializerProvider = paramDeserializerProvider;
    return this;
  }
  
  public void setFilters(FilterProvider paramFilterProvider)
  {
    this._serializationConfig = this._serializationConfig.withFilters(paramFilterProvider);
  }
  
  public void setHandlerInstantiator(HandlerInstantiator paramHandlerInstantiator)
  {
    this._deserializationConfig = this._deserializationConfig.withHandlerInstantiator(paramHandlerInstantiator);
    this._serializationConfig = this._serializationConfig.withHandlerInstantiator(paramHandlerInstantiator);
  }
  
  public ObjectMapper setInjectableValues(InjectableValues paramInjectableValues)
  {
    this._injectableValues = paramInjectableValues;
    return this;
  }
  
  public ObjectMapper setNodeFactory(JsonNodeFactory paramJsonNodeFactory)
  {
    this._deserializationConfig = this._deserializationConfig.withNodeFactory(paramJsonNodeFactory);
    return this;
  }
  
  public ObjectMapper setPropertyNamingStrategy(PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    this._serializationConfig = this._serializationConfig.withPropertyNamingStrategy(paramPropertyNamingStrategy);
    this._deserializationConfig = this._deserializationConfig.withPropertyNamingStrategy(paramPropertyNamingStrategy);
    return this;
  }
  
  public ObjectMapper setSerializationConfig(SerializationConfig paramSerializationConfig)
  {
    this._serializationConfig = paramSerializationConfig;
    return this;
  }
  
  public ObjectMapper setSerializationInclusion(JsonSerialize.Inclusion paramInclusion)
  {
    this._serializationConfig = this._serializationConfig.withSerializationInclusion(paramInclusion);
    return this;
  }
  
  public ObjectMapper setSerializerFactory(SerializerFactory paramSerializerFactory)
  {
    this._serializerFactory = paramSerializerFactory;
    return this;
  }
  
  public ObjectMapper setSerializerProvider(SerializerProvider paramSerializerProvider)
  {
    this._serializerProvider = paramSerializerProvider;
    return this;
  }
  
  public void setSubtypeResolver(SubtypeResolver paramSubtypeResolver)
  {
    this._subtypeResolver = paramSubtypeResolver;
  }
  
  public ObjectMapper setTypeFactory(TypeFactory paramTypeFactory)
  {
    this._typeFactory = paramTypeFactory;
    this._deserializationConfig = this._deserializationConfig.withTypeFactory(paramTypeFactory);
    this._serializationConfig = this._serializationConfig.withTypeFactory(paramTypeFactory);
    return this;
  }
  
  public ObjectMapper setVisibility(JsonMethod paramJsonMethod, JsonAutoDetect.Visibility paramVisibility)
  {
    this._deserializationConfig = this._deserializationConfig.withVisibility(paramJsonMethod, paramVisibility);
    this._serializationConfig = this._serializationConfig.withVisibility(paramJsonMethod, paramVisibility);
    return this;
  }
  
  public void setVisibilityChecker(VisibilityChecker paramVisibilityChecker)
  {
    this._deserializationConfig = this._deserializationConfig.withVisibilityChecker(paramVisibilityChecker);
    this._serializationConfig = this._serializationConfig.withVisibilityChecker(paramVisibilityChecker);
  }
  
  public JsonParser treeAsTokens(JsonNode paramJsonNode)
  {
    return new TreeTraversingParser(paramJsonNode, this);
  }
  
  public Object treeToValue(JsonNode paramJsonNode, Class paramClass)
  {
    return readValue(treeAsTokens(paramJsonNode), paramClass);
  }
  
  @Deprecated
  public ObjectWriter typedWriter(Class paramClass)
  {
    return writerWithType(paramClass);
  }
  
  @Deprecated
  public ObjectWriter typedWriter(JavaType paramJavaType)
  {
    return writerWithType(paramJavaType);
  }
  
  @Deprecated
  public ObjectWriter typedWriter(TypeReference paramTypeReference)
  {
    return writerWithType(paramTypeReference);
  }
  
  @Deprecated
  public ObjectReader updatingReader(Object paramObject)
  {
    return readerForUpdating(paramObject);
  }
  
  public JsonNode valueToTree(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    Object localObject = new TokenBuffer(this);
    try
    {
      writeValue((JsonGenerator)localObject, paramObject);
      paramObject = ((TokenBuffer)localObject).asParser();
      localObject = readTree((JsonParser)paramObject);
      ((JsonParser)paramObject).close();
      return (JsonNode)localObject;
    }
    catch (IOException paramObject)
    {
      throw new IllegalArgumentException(((IOException)paramObject).getMessage(), (Throwable)paramObject);
    }
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
  
  @Deprecated
  public ObjectWriter viewWriter(Class paramClass)
  {
    return writerWithView(paramClass);
  }
  
  public ObjectMapper withModule(Module paramModule)
  {
    registerModule(paramModule);
    return this;
  }
  
  public void writeTree(JsonGenerator paramJsonGenerator, JsonNode paramJsonNode)
  {
    SerializationConfig localSerializationConfig = copySerializationConfig();
    this._serializerProvider.serializeValue(localSerializationConfig, paramJsonGenerator, paramJsonNode, this._serializerFactory);
    if (localSerializationConfig.isEnabled(SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE)) {
      paramJsonGenerator.flush();
    }
  }
  
  public void writeTree(JsonGenerator paramJsonGenerator, JsonNode paramJsonNode, SerializationConfig paramSerializationConfig)
  {
    this._serializerProvider.serializeValue(paramSerializationConfig, paramJsonGenerator, paramJsonNode, this._serializerFactory);
    if (paramSerializationConfig.isEnabled(SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE)) {
      paramJsonGenerator.flush();
    }
  }
  
  public void writeValue(File paramFile, Object paramObject)
  {
    _configAndWriteValue(this._jsonFactory.createJsonGenerator(paramFile, JsonEncoding.UTF8), paramObject);
  }
  
  public void writeValue(OutputStream paramOutputStream, Object paramObject)
  {
    _configAndWriteValue(this._jsonFactory.createJsonGenerator(paramOutputStream, JsonEncoding.UTF8), paramObject);
  }
  
  public void writeValue(Writer paramWriter, Object paramObject)
  {
    _configAndWriteValue(this._jsonFactory.createJsonGenerator(paramWriter), paramObject);
  }
  
  public void writeValue(JsonGenerator paramJsonGenerator, Object paramObject)
  {
    SerializationConfig localSerializationConfig = copySerializationConfig();
    if ((localSerializationConfig.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE)) && ((paramObject instanceof Closeable))) {
      _writeCloseableValue(paramJsonGenerator, paramObject, localSerializationConfig);
    }
    do
    {
      return;
      this._serializerProvider.serializeValue(localSerializationConfig, paramJsonGenerator, paramObject, this._serializerFactory);
    } while (!localSerializationConfig.isEnabled(SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE));
    paramJsonGenerator.flush();
  }
  
  public void writeValue(JsonGenerator paramJsonGenerator, Object paramObject, SerializationConfig paramSerializationConfig)
  {
    if ((paramSerializationConfig.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE)) && ((paramObject instanceof Closeable))) {
      _writeCloseableValue(paramJsonGenerator, paramObject, paramSerializationConfig);
    }
    do
    {
      return;
      this._serializerProvider.serializeValue(paramSerializationConfig, paramJsonGenerator, paramObject, this._serializerFactory);
    } while (!paramSerializationConfig.isEnabled(SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE));
    paramJsonGenerator.flush();
  }
  
  public byte[] writeValueAsBytes(Object paramObject)
  {
    ByteArrayBuilder localByteArrayBuilder = new ByteArrayBuilder(this._jsonFactory._getBufferRecycler());
    _configAndWriteValue(this._jsonFactory.createJsonGenerator(localByteArrayBuilder, JsonEncoding.UTF8), paramObject);
    paramObject = localByteArrayBuilder.toByteArray();
    localByteArrayBuilder.release();
    return (byte[])paramObject;
  }
  
  public String writeValueAsString(Object paramObject)
  {
    SegmentedStringWriter localSegmentedStringWriter = new SegmentedStringWriter(this._jsonFactory._getBufferRecycler());
    _configAndWriteValue(this._jsonFactory.createJsonGenerator(localSegmentedStringWriter), paramObject);
    return localSegmentedStringWriter.getAndClear();
  }
  
  public ObjectWriter writer()
  {
    return new ObjectWriter(this, copySerializationConfig());
  }
  
  public ObjectWriter writer(DateFormat paramDateFormat)
  {
    return new ObjectWriter(this, copySerializationConfig().withDateFormat(paramDateFormat));
  }
  
  public ObjectWriter writer(FormatSchema paramFormatSchema)
  {
    return new ObjectWriter(this, copySerializationConfig(), paramFormatSchema);
  }
  
  public ObjectWriter writer(PrettyPrinter paramPrettyPrinter)
  {
    PrettyPrinter localPrettyPrinter = paramPrettyPrinter;
    if (paramPrettyPrinter == null) {
      localPrettyPrinter = ObjectWriter.NULL_PRETTY_PRINTER;
    }
    return new ObjectWriter(this, copySerializationConfig(), null, localPrettyPrinter);
  }
  
  public ObjectWriter writer(FilterProvider paramFilterProvider)
  {
    return new ObjectWriter(this, copySerializationConfig().withFilters(paramFilterProvider));
  }
  
  public ObjectWriter writerWithDefaultPrettyPrinter()
  {
    return new ObjectWriter(this, copySerializationConfig(), null, _defaultPrettyPrinter());
  }
  
  public ObjectWriter writerWithType(Class paramClass)
  {
    if (paramClass == null) {}
    for (paramClass = null;; paramClass = this._typeFactory.constructType(paramClass)) {
      return new ObjectWriter(this, copySerializationConfig(), paramClass, null);
    }
  }
  
  public ObjectWriter writerWithType(JavaType paramJavaType)
  {
    return new ObjectWriter(this, copySerializationConfig(), paramJavaType, null);
  }
  
  public ObjectWriter writerWithType(TypeReference paramTypeReference)
  {
    if (paramTypeReference == null) {}
    for (paramTypeReference = null;; paramTypeReference = this._typeFactory.constructType(paramTypeReference)) {
      return new ObjectWriter(this, copySerializationConfig(), paramTypeReference, null);
    }
  }
  
  public ObjectWriter writerWithView(Class paramClass)
  {
    return new ObjectWriter(this, copySerializationConfig().withView(paramClass));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ObjectMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */