package org.codehaus.jackson.map;

import java.io.EOFException;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.codehaus.jackson.FormatSchema;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.Versioned;
import org.codehaus.jackson.io.SerializedString;
import org.codehaus.jackson.map.deser.StdDeserializationContext;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.NullNode;
import org.codehaus.jackson.node.TreeTraversingParser;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.util.VersionUtil;

public class ObjectReader
  extends ObjectCodec
  implements Versioned
{
  private static final JavaType JSON_NODE_TYPE = SimpleType.constructUnsafe(JsonNode.class);
  protected final DeserializationConfig _config;
  protected final InjectableValues _injectableValues;
  protected final JsonFactory _jsonFactory;
  protected final DeserializerProvider _provider;
  protected final ConcurrentHashMap _rootDeserializers;
  protected final FormatSchema _schema;
  protected final boolean _unwrapRoot;
  protected final Object _valueToUpdate;
  protected final JavaType _valueType;
  
  protected ObjectReader(ObjectMapper paramObjectMapper, DeserializationConfig paramDeserializationConfig)
  {
    this(paramObjectMapper, paramDeserializationConfig, null, null, null, null);
  }
  
  protected ObjectReader(ObjectMapper paramObjectMapper, DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, Object paramObject, FormatSchema paramFormatSchema, InjectableValues paramInjectableValues)
  {
    this._config = paramDeserializationConfig;
    this._rootDeserializers = paramObjectMapper._rootDeserializers;
    this._provider = paramObjectMapper._deserializerProvider;
    this._jsonFactory = paramObjectMapper._jsonFactory;
    this._valueType = paramJavaType;
    this._valueToUpdate = paramObject;
    if ((paramObject != null) && (paramJavaType.isArrayType())) {
      throw new IllegalArgumentException("Can not update an array value");
    }
    this._schema = paramFormatSchema;
    this._injectableValues = paramInjectableValues;
    this._unwrapRoot = paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE);
  }
  
  protected ObjectReader(ObjectReader paramObjectReader, DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, Object paramObject, FormatSchema paramFormatSchema, InjectableValues paramInjectableValues)
  {
    this._config = paramDeserializationConfig;
    this._rootDeserializers = paramObjectReader._rootDeserializers;
    this._provider = paramObjectReader._provider;
    this._jsonFactory = paramObjectReader._jsonFactory;
    this._valueType = paramJavaType;
    this._valueToUpdate = paramObject;
    if ((paramObject != null) && (paramJavaType.isArrayType())) {
      throw new IllegalArgumentException("Can not update an array value");
    }
    this._schema = paramFormatSchema;
    this._injectableValues = paramInjectableValues;
    this._unwrapRoot = paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE);
  }
  
  protected static JsonToken _initForReading(JsonParser paramJsonParser)
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
  
  protected Object _bind(JsonParser paramJsonParser)
  {
    Object localObject = _initForReading(paramJsonParser);
    if (localObject == JsonToken.VALUE_NULL) {
      if (this._valueToUpdate == null) {
        localObject = _findRootDeserializer(this._config, this._valueType).getNullValue();
      }
    }
    for (;;)
    {
      paramJsonParser.clearCurrentToken();
      return localObject;
      localObject = this._valueToUpdate;
      continue;
      if ((localObject == JsonToken.END_ARRAY) || (localObject == JsonToken.END_OBJECT))
      {
        localObject = this._valueToUpdate;
      }
      else
      {
        localObject = _createDeserializationContext(paramJsonParser, this._config);
        JsonDeserializer localJsonDeserializer = _findRootDeserializer(this._config, this._valueType);
        if (this._unwrapRoot)
        {
          localObject = _unwrapAndDeserialize(paramJsonParser, (DeserializationContext)localObject, this._valueType, localJsonDeserializer);
        }
        else if (this._valueToUpdate == null)
        {
          localObject = localJsonDeserializer.deserialize(paramJsonParser, (DeserializationContext)localObject);
        }
        else
        {
          localJsonDeserializer.deserialize(paramJsonParser, (DeserializationContext)localObject, this._valueToUpdate);
          localObject = this._valueToUpdate;
        }
      }
    }
  }
  
  /* Error */
  protected Object _bindAndClose(JsonParser paramJsonParser)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 79	org/codehaus/jackson/map/ObjectReader:_schema	Lorg/codehaus/jackson/FormatSchema;
    //   4: ifnull +11 -> 15
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 79	org/codehaus/jackson/map/ObjectReader:_schema	Lorg/codehaus/jackson/FormatSchema;
    //   12: invokevirtual 163	org/codehaus/jackson/JsonParser:setSchema	(Lorg/codehaus/jackson/FormatSchema;)V
    //   15: aload_1
    //   16: invokestatic 116	org/codehaus/jackson/map/ObjectReader:_initForReading	(Lorg/codehaus/jackson/JsonParser;)Lorg/codehaus/jackson/JsonToken;
    //   19: astore_2
    //   20: aload_2
    //   21: getstatic 122	org/codehaus/jackson/JsonToken:VALUE_NULL	Lorg/codehaus/jackson/JsonToken;
    //   24: if_acmpne +40 -> 64
    //   27: aload_0
    //   28: getfield 64	org/codehaus/jackson/map/ObjectReader:_valueToUpdate	Ljava/lang/Object;
    //   31: ifnonnull +25 -> 56
    //   34: aload_0
    //   35: aload_0
    //   36: getfield 47	org/codehaus/jackson/map/ObjectReader:_config	Lorg/codehaus/jackson/map/DeserializationConfig;
    //   39: aload_0
    //   40: getfield 62	org/codehaus/jackson/map/ObjectReader:_valueType	Lorg/codehaus/jackson/type/JavaType;
    //   43: invokevirtual 126	org/codehaus/jackson/map/ObjectReader:_findRootDeserializer	(Lorg/codehaus/jackson/map/DeserializationConfig;Lorg/codehaus/jackson/type/JavaType;)Lorg/codehaus/jackson/map/JsonDeserializer;
    //   46: invokevirtual 132	org/codehaus/jackson/map/JsonDeserializer:getNullValue	()Ljava/lang/Object;
    //   49: astore_2
    //   50: aload_1
    //   51: invokevirtual 166	org/codehaus/jackson/JsonParser:close	()V
    //   54: aload_2
    //   55: areturn
    //   56: aload_0
    //   57: getfield 64	org/codehaus/jackson/map/ObjectReader:_valueToUpdate	Ljava/lang/Object;
    //   60: astore_2
    //   61: goto -11 -> 50
    //   64: aload_2
    //   65: getstatic 138	org/codehaus/jackson/JsonToken:END_ARRAY	Lorg/codehaus/jackson/JsonToken;
    //   68: if_acmpeq +10 -> 78
    //   71: aload_2
    //   72: getstatic 141	org/codehaus/jackson/JsonToken:END_OBJECT	Lorg/codehaus/jackson/JsonToken;
    //   75: if_acmpne +11 -> 86
    //   78: aload_0
    //   79: getfield 64	org/codehaus/jackson/map/ObjectReader:_valueToUpdate	Ljava/lang/Object;
    //   82: astore_2
    //   83: goto -33 -> 50
    //   86: aload_0
    //   87: aload_1
    //   88: aload_0
    //   89: getfield 47	org/codehaus/jackson/map/ObjectReader:_config	Lorg/codehaus/jackson/map/DeserializationConfig;
    //   92: invokevirtual 145	org/codehaus/jackson/map/ObjectReader:_createDeserializationContext	(Lorg/codehaus/jackson/JsonParser;Lorg/codehaus/jackson/map/DeserializationConfig;)Lorg/codehaus/jackson/map/DeserializationContext;
    //   95: astore_2
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 47	org/codehaus/jackson/map/ObjectReader:_config	Lorg/codehaus/jackson/map/DeserializationConfig;
    //   101: aload_0
    //   102: getfield 62	org/codehaus/jackson/map/ObjectReader:_valueType	Lorg/codehaus/jackson/type/JavaType;
    //   105: invokevirtual 126	org/codehaus/jackson/map/ObjectReader:_findRootDeserializer	(Lorg/codehaus/jackson/map/DeserializationConfig;Lorg/codehaus/jackson/type/JavaType;)Lorg/codehaus/jackson/map/JsonDeserializer;
    //   108: astore_3
    //   109: aload_0
    //   110: getfield 95	org/codehaus/jackson/map/ObjectReader:_unwrapRoot	Z
    //   113: ifeq +18 -> 131
    //   116: aload_0
    //   117: aload_1
    //   118: aload_2
    //   119: aload_0
    //   120: getfield 62	org/codehaus/jackson/map/ObjectReader:_valueType	Lorg/codehaus/jackson/type/JavaType;
    //   123: aload_3
    //   124: invokevirtual 149	org/codehaus/jackson/map/ObjectReader:_unwrapAndDeserialize	(Lorg/codehaus/jackson/JsonParser;Lorg/codehaus/jackson/map/DeserializationContext;Lorg/codehaus/jackson/type/JavaType;Lorg/codehaus/jackson/map/JsonDeserializer;)Ljava/lang/Object;
    //   127: astore_2
    //   128: goto -78 -> 50
    //   131: aload_0
    //   132: getfield 64	org/codehaus/jackson/map/ObjectReader:_valueToUpdate	Ljava/lang/Object;
    //   135: ifnonnull +13 -> 148
    //   138: aload_3
    //   139: aload_1
    //   140: aload_2
    //   141: invokevirtual 153	org/codehaus/jackson/map/JsonDeserializer:deserialize	(Lorg/codehaus/jackson/JsonParser;Lorg/codehaus/jackson/map/DeserializationContext;)Ljava/lang/Object;
    //   144: astore_2
    //   145: goto -95 -> 50
    //   148: aload_3
    //   149: aload_1
    //   150: aload_2
    //   151: aload_0
    //   152: getfield 64	org/codehaus/jackson/map/ObjectReader:_valueToUpdate	Ljava/lang/Object;
    //   155: invokevirtual 156	org/codehaus/jackson/map/JsonDeserializer:deserialize	(Lorg/codehaus/jackson/JsonParser;Lorg/codehaus/jackson/map/DeserializationContext;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: aload_0
    //   160: getfield 64	org/codehaus/jackson/map/ObjectReader:_valueToUpdate	Ljava/lang/Object;
    //   163: astore_2
    //   164: goto -114 -> 50
    //   167: astore_2
    //   168: aload_1
    //   169: invokevirtual 166	org/codehaus/jackson/JsonParser:close	()V
    //   172: aload_2
    //   173: athrow
    //   174: astore_1
    //   175: aload_2
    //   176: areturn
    //   177: astore_1
    //   178: goto -6 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	ObjectReader
    //   0	181	1	paramJsonParser	JsonParser
    //   19	145	2	localObject1	Object
    //   167	9	2	localObject2	Object
    //   108	41	3	localJsonDeserializer	JsonDeserializer
    // Exception table:
    //   from	to	target	type
    //   15	50	167	finally
    //   56	61	167	finally
    //   64	78	167	finally
    //   78	83	167	finally
    //   86	128	167	finally
    //   131	145	167	finally
    //   148	164	167	finally
    //   50	54	174	java/io/IOException
    //   168	172	177	java/io/IOException
  }
  
  /* Error */
  protected JsonNode _bindAndCloseAsTree(JsonParser paramJsonParser)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 79	org/codehaus/jackson/map/ObjectReader:_schema	Lorg/codehaus/jackson/FormatSchema;
    //   4: ifnull +11 -> 15
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 79	org/codehaus/jackson/map/ObjectReader:_schema	Lorg/codehaus/jackson/FormatSchema;
    //   12: invokevirtual 163	org/codehaus/jackson/JsonParser:setSchema	(Lorg/codehaus/jackson/FormatSchema;)V
    //   15: aload_0
    //   16: aload_1
    //   17: invokevirtual 171	org/codehaus/jackson/map/ObjectReader:_bindAsTree	(Lorg/codehaus/jackson/JsonParser;)Lorg/codehaus/jackson/JsonNode;
    //   20: astore_2
    //   21: aload_1
    //   22: invokevirtual 166	org/codehaus/jackson/JsonParser:close	()V
    //   25: aload_2
    //   26: areturn
    //   27: astore_2
    //   28: aload_1
    //   29: invokevirtual 166	org/codehaus/jackson/JsonParser:close	()V
    //   32: aload_2
    //   33: athrow
    //   34: astore_1
    //   35: aload_2
    //   36: areturn
    //   37: astore_1
    //   38: goto -6 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	ObjectReader
    //   0	41	1	paramJsonParser	JsonParser
    //   20	6	2	localJsonNode1	JsonNode
    //   27	9	2	localJsonNode2	JsonNode
    // Exception table:
    //   from	to	target	type
    //   15	21	27	finally
    //   21	25	34	java/io/IOException
    //   28	32	37	java/io/IOException
  }
  
  protected JsonNode _bindAsTree(JsonParser paramJsonParser)
  {
    Object localObject = _initForReading(paramJsonParser);
    if ((localObject == JsonToken.VALUE_NULL) || (localObject == JsonToken.END_ARRAY) || (localObject == JsonToken.END_OBJECT)) {
      localObject = NullNode.instance;
    }
    for (;;)
    {
      paramJsonParser.clearCurrentToken();
      return (JsonNode)localObject;
      localObject = _createDeserializationContext(paramJsonParser, this._config);
      JsonDeserializer localJsonDeserializer = _findRootDeserializer(this._config, JSON_NODE_TYPE);
      if (this._unwrapRoot) {
        localObject = (JsonNode)_unwrapAndDeserialize(paramJsonParser, (DeserializationContext)localObject, JSON_NODE_TYPE, localJsonDeserializer);
      } else {
        localObject = (JsonNode)localJsonDeserializer.deserialize(paramJsonParser, (DeserializationContext)localObject);
      }
    }
  }
  
  protected DeserializationContext _createDeserializationContext(JsonParser paramJsonParser, DeserializationConfig paramDeserializationConfig)
  {
    return new StdDeserializationContext(paramDeserializationConfig, paramJsonParser, this._provider, this._injectableValues);
  }
  
  protected JsonDeserializer _findRootDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    if (paramJavaType == null) {
      throw new JsonMappingException("No value type configured for ObjectReader");
    }
    JsonDeserializer localJsonDeserializer = (JsonDeserializer)this._rootDeserializers.get(paramJavaType);
    if (localJsonDeserializer != null) {
      return localJsonDeserializer;
    }
    paramDeserializationConfig = this._provider.findTypedValueDeserializer(paramDeserializationConfig, paramJavaType, null);
    if (paramDeserializationConfig == null) {
      throw new JsonMappingException("Can not find a deserializer for type " + paramJavaType);
    }
    this._rootDeserializers.put(paramJavaType, paramDeserializationConfig);
    return paramDeserializationConfig;
  }
  
  protected Object _unwrapAndDeserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JavaType paramJavaType, JsonDeserializer paramJsonDeserializer)
  {
    SerializedString localSerializedString = this._provider.findExpectedRootName(paramDeserializationContext.getConfig(), paramJavaType);
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
    if (this._valueToUpdate == null) {}
    for (paramDeserializationContext = paramJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext); paramJsonParser.nextToken() != JsonToken.END_OBJECT; paramDeserializationContext = this._valueToUpdate)
    {
      throw JsonMappingException.from(paramJsonParser, "Current token not END_OBJECT (to match wrapper object with root name '" + localSerializedString + "'), but " + paramJsonParser.getCurrentToken());
      paramJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext, this._valueToUpdate);
    }
    return paramDeserializationContext;
  }
  
  public JsonNode createArrayNode()
  {
    return this._config.getNodeFactory().arrayNode();
  }
  
  public JsonNode createObjectNode()
  {
    return this._config.getNodeFactory().objectNode();
  }
  
  public JsonNode readTree(InputStream paramInputStream)
  {
    return _bindAndCloseAsTree(this._jsonFactory.createJsonParser(paramInputStream));
  }
  
  public JsonNode readTree(Reader paramReader)
  {
    return _bindAndCloseAsTree(this._jsonFactory.createJsonParser(paramReader));
  }
  
  public JsonNode readTree(String paramString)
  {
    return _bindAndCloseAsTree(this._jsonFactory.createJsonParser(paramString));
  }
  
  public JsonNode readTree(JsonParser paramJsonParser)
  {
    return _bindAsTree(paramJsonParser);
  }
  
  public Object readValue(File paramFile)
  {
    return _bindAndClose(this._jsonFactory.createJsonParser(paramFile));
  }
  
  public Object readValue(InputStream paramInputStream)
  {
    return _bindAndClose(this._jsonFactory.createJsonParser(paramInputStream));
  }
  
  public Object readValue(Reader paramReader)
  {
    return _bindAndClose(this._jsonFactory.createJsonParser(paramReader));
  }
  
  public Object readValue(String paramString)
  {
    return _bindAndClose(this._jsonFactory.createJsonParser(paramString));
  }
  
  public Object readValue(URL paramURL)
  {
    return _bindAndClose(this._jsonFactory.createJsonParser(paramURL));
  }
  
  public Object readValue(JsonNode paramJsonNode)
  {
    return _bindAndClose(treeAsTokens(paramJsonNode));
  }
  
  public Object readValue(JsonParser paramJsonParser)
  {
    return _bind(paramJsonParser);
  }
  
  public Object readValue(JsonParser paramJsonParser, Class paramClass)
  {
    return withType(paramClass).readValue(paramJsonParser);
  }
  
  public Object readValue(JsonParser paramJsonParser, JavaType paramJavaType)
  {
    return withType(paramJavaType).readValue(paramJsonParser);
  }
  
  public Object readValue(JsonParser paramJsonParser, TypeReference paramTypeReference)
  {
    return withType(paramTypeReference).readValue(paramJsonParser);
  }
  
  public Object readValue(byte[] paramArrayOfByte)
  {
    return _bindAndClose(this._jsonFactory.createJsonParser(paramArrayOfByte));
  }
  
  public Object readValue(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return _bindAndClose(this._jsonFactory.createJsonParser(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public Iterator readValues(JsonParser paramJsonParser, Class paramClass)
  {
    return withType(paramClass).readValues(paramJsonParser);
  }
  
  public Iterator readValues(JsonParser paramJsonParser, JavaType paramJavaType)
  {
    return withType(paramJavaType).readValues(paramJsonParser);
  }
  
  public Iterator readValues(JsonParser paramJsonParser, TypeReference paramTypeReference)
  {
    return withType(paramTypeReference).readValues(paramJsonParser);
  }
  
  public MappingIterator readValues(File paramFile)
  {
    paramFile = this._jsonFactory.createJsonParser(paramFile);
    if (this._schema != null) {
      paramFile.setSchema(this._schema);
    }
    DeserializationContext localDeserializationContext = _createDeserializationContext(paramFile, this._config);
    return new MappingIterator(this._valueType, paramFile, localDeserializationContext, _findRootDeserializer(this._config, this._valueType), true, this._valueToUpdate);
  }
  
  public MappingIterator readValues(InputStream paramInputStream)
  {
    paramInputStream = this._jsonFactory.createJsonParser(paramInputStream);
    if (this._schema != null) {
      paramInputStream.setSchema(this._schema);
    }
    DeserializationContext localDeserializationContext = _createDeserializationContext(paramInputStream, this._config);
    return new MappingIterator(this._valueType, paramInputStream, localDeserializationContext, _findRootDeserializer(this._config, this._valueType), true, this._valueToUpdate);
  }
  
  public MappingIterator readValues(Reader paramReader)
  {
    paramReader = this._jsonFactory.createJsonParser(paramReader);
    if (this._schema != null) {
      paramReader.setSchema(this._schema);
    }
    DeserializationContext localDeserializationContext = _createDeserializationContext(paramReader, this._config);
    return new MappingIterator(this._valueType, paramReader, localDeserializationContext, _findRootDeserializer(this._config, this._valueType), true, this._valueToUpdate);
  }
  
  public MappingIterator readValues(String paramString)
  {
    paramString = this._jsonFactory.createJsonParser(paramString);
    if (this._schema != null) {
      paramString.setSchema(this._schema);
    }
    DeserializationContext localDeserializationContext = _createDeserializationContext(paramString, this._config);
    return new MappingIterator(this._valueType, paramString, localDeserializationContext, _findRootDeserializer(this._config, this._valueType), true, this._valueToUpdate);
  }
  
  public MappingIterator readValues(URL paramURL)
  {
    paramURL = this._jsonFactory.createJsonParser(paramURL);
    if (this._schema != null) {
      paramURL.setSchema(this._schema);
    }
    DeserializationContext localDeserializationContext = _createDeserializationContext(paramURL, this._config);
    return new MappingIterator(this._valueType, paramURL, localDeserializationContext, _findRootDeserializer(this._config, this._valueType), true, this._valueToUpdate);
  }
  
  public MappingIterator readValues(JsonParser paramJsonParser)
  {
    DeserializationContext localDeserializationContext = _createDeserializationContext(paramJsonParser, this._config);
    return new MappingIterator(this._valueType, paramJsonParser, localDeserializationContext, _findRootDeserializer(this._config, this._valueType), false, this._valueToUpdate);
  }
  
  public final MappingIterator readValues(byte[] paramArrayOfByte)
  {
    return readValues(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public MappingIterator readValues(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = this._jsonFactory.createJsonParser(paramArrayOfByte, paramInt1, paramInt2);
    if (this._schema != null) {
      paramArrayOfByte.setSchema(this._schema);
    }
    DeserializationContext localDeserializationContext = _createDeserializationContext(paramArrayOfByte, this._config);
    return new MappingIterator(this._valueType, paramArrayOfByte, localDeserializationContext, _findRootDeserializer(this._config, this._valueType), true, this._valueToUpdate);
  }
  
  public JsonParser treeAsTokens(JsonNode paramJsonNode)
  {
    return new TreeTraversingParser(paramJsonNode, this);
  }
  
  public Object treeToValue(JsonNode paramJsonNode, Class paramClass)
  {
    return readValue(treeAsTokens(paramJsonNode), paramClass);
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
  
  public ObjectReader withInjectableValues(InjectableValues paramInjectableValues)
  {
    if (this._injectableValues == paramInjectableValues) {
      return this;
    }
    return new ObjectReader(this, this._config, this._valueType, this._valueToUpdate, this._schema, paramInjectableValues);
  }
  
  public ObjectReader withNodeFactory(JsonNodeFactory paramJsonNodeFactory)
  {
    if (paramJsonNodeFactory == this._config.getNodeFactory()) {
      return this;
    }
    return new ObjectReader(this, this._config.withNodeFactory(paramJsonNodeFactory), this._valueType, this._valueToUpdate, this._schema, this._injectableValues);
  }
  
  public ObjectReader withSchema(FormatSchema paramFormatSchema)
  {
    if (this._schema == paramFormatSchema) {
      return this;
    }
    return new ObjectReader(this, this._config, this._valueType, this._valueToUpdate, paramFormatSchema, this._injectableValues);
  }
  
  public ObjectReader withType(Class paramClass)
  {
    return withType(this._config.constructType(paramClass));
  }
  
  public ObjectReader withType(Type paramType)
  {
    return withType(this._config.getTypeFactory().constructType(paramType));
  }
  
  public ObjectReader withType(JavaType paramJavaType)
  {
    if (paramJavaType == this._valueType) {
      return this;
    }
    return new ObjectReader(this, this._config, paramJavaType, this._valueToUpdate, this._schema, this._injectableValues);
  }
  
  public ObjectReader withType(TypeReference paramTypeReference)
  {
    return withType(this._config.getTypeFactory().constructType(paramTypeReference.getType()));
  }
  
  public ObjectReader withValueToUpdate(Object paramObject)
  {
    if (paramObject == this._valueToUpdate) {
      return this;
    }
    if (paramObject == null) {
      throw new IllegalArgumentException("cat not update null value");
    }
    if (this._valueType == null) {}
    for (JavaType localJavaType = this._config.constructType(paramObject.getClass());; localJavaType = this._valueType) {
      return new ObjectReader(this, this._config, localJavaType, paramObject, this._schema, this._injectableValues);
    }
  }
  
  public void writeTree(JsonGenerator paramJsonGenerator, JsonNode paramJsonNode)
  {
    throw new UnsupportedOperationException("Not implemented for ObjectReader");
  }
  
  public void writeValue(JsonGenerator paramJsonGenerator, Object paramObject)
  {
    throw new UnsupportedOperationException("Not implemented for ObjectReader");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ObjectReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */