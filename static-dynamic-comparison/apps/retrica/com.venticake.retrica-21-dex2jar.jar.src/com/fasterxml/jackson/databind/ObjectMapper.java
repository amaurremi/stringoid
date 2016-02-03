package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectMapper
  extends ObjectCodec
  implements Serializable
{
  protected static final AnnotationIntrospector DEFAULT_ANNOTATION_INTROSPECTOR;
  protected static final BaseSettings DEFAULT_BASE = new BaseSettings(DEFAULT_INTROSPECTOR, DEFAULT_ANNOTATION_INTROSPECTOR, STD_VISIBILITY_CHECKER, null, TypeFactory.defaultInstance(), null, StdDateFormat.instance, null, Locale.getDefault(), TimeZone.getTimeZone("GMT"), Base64Variants.getDefaultVariant());
  protected static final ClassIntrospector DEFAULT_INTROSPECTOR;
  private static final JavaType JSON_NODE_TYPE = SimpleType.constructUnsafe(JsonNode.class);
  protected static final VisibilityChecker<?> STD_VISIBILITY_CHECKER;
  protected static final PrettyPrinter _defaultPrettyPrinter;
  protected DeserializationConfig _deserializationConfig;
  protected DefaultDeserializationContext _deserializationContext;
  protected InjectableValues _injectableValues;
  protected final JsonFactory _jsonFactory;
  protected final HashMap<ClassKey, Class<?>> _mixInAnnotations = new HashMap();
  protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _rootDeserializers = new ConcurrentHashMap(64, 0.6F, 2);
  protected final RootNameLookup _rootNames;
  protected SerializationConfig _serializationConfig;
  protected SerializerFactory _serializerFactory;
  protected DefaultSerializerProvider _serializerProvider;
  protected SubtypeResolver _subtypeResolver;
  protected TypeFactory _typeFactory;
  
  static
  {
    DEFAULT_INTROSPECTOR = BasicClassIntrospector.instance;
    DEFAULT_ANNOTATION_INTROSPECTOR = new JacksonAnnotationIntrospector();
    STD_VISIBILITY_CHECKER = VisibilityChecker.Std.defaultInstance();
    _defaultPrettyPrinter = new DefaultPrettyPrinter();
  }
  
  public ObjectMapper()
  {
    this(null, null, null);
  }
  
  public ObjectMapper(JsonFactory paramJsonFactory)
  {
    this(paramJsonFactory, null, null);
  }
  
  public ObjectMapper(JsonFactory paramJsonFactory, DefaultSerializerProvider paramDefaultSerializerProvider, DefaultDeserializationContext paramDefaultDeserializationContext)
  {
    if (paramJsonFactory == null) {
      this._jsonFactory = new MappingJsonFactory(this);
    }
    for (;;)
    {
      this._subtypeResolver = new StdSubtypeResolver();
      this._rootNames = new RootNameLookup();
      this._typeFactory = TypeFactory.defaultInstance();
      this._serializationConfig = new SerializationConfig(DEFAULT_BASE, this._subtypeResolver, this._mixInAnnotations);
      this._deserializationConfig = new DeserializationConfig(DEFAULT_BASE, this._subtypeResolver, this._mixInAnnotations);
      paramJsonFactory = paramDefaultSerializerProvider;
      if (paramDefaultSerializerProvider == null) {
        paramJsonFactory = new DefaultSerializerProvider.Impl();
      }
      this._serializerProvider = paramJsonFactory;
      paramJsonFactory = paramDefaultDeserializationContext;
      if (paramDefaultDeserializationContext == null) {
        paramJsonFactory = new DefaultDeserializationContext.Impl(BeanDeserializerFactory.instance);
      }
      this._deserializationContext = paramJsonFactory;
      this._serializerFactory = BeanSerializerFactory.instance;
      return;
      this._jsonFactory = paramJsonFactory;
      if (paramJsonFactory.getCodec() == null) {
        this._jsonFactory.setCodec(this);
      }
    }
  }
  
  protected PrettyPrinter _defaultPrettyPrinter()
  {
    return _defaultPrettyPrinter;
  }
  
  protected JsonDeserializer<Object> _findRootDeserializer(DeserializationContext paramDeserializationContext, JavaType paramJavaType)
  {
    JsonDeserializer localJsonDeserializer = (JsonDeserializer)this._rootDeserializers.get(paramJavaType);
    if (localJsonDeserializer != null) {
      return localJsonDeserializer;
    }
    paramDeserializationContext = paramDeserializationContext.findRootValueDeserializer(paramJavaType);
    if (paramDeserializationContext == null) {
      throw new JsonMappingException("Can not find a deserializer for type " + paramJavaType);
    }
    this._rootDeserializers.put(paramJavaType, paramDeserializationContext);
    return paramDeserializationContext;
  }
  
  protected JsonToken _initForReading(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken2 = paramJsonParser.getCurrentToken();
    JsonToken localJsonToken1 = localJsonToken2;
    if (localJsonToken2 == null)
    {
      localJsonToken2 = paramJsonParser.nextToken();
      localJsonToken1 = localJsonToken2;
      if (localJsonToken2 == null) {
        throw JsonMappingException.from(paramJsonParser, "No content to map due to end-of-input");
      }
    }
    return localJsonToken1;
  }
  
  /* Error */
  protected Object _readMapAndClose(JsonParser paramJsonParser, JavaType paramJavaType)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 271	com/fasterxml/jackson/databind/ObjectMapper:_initForReading	(Lcom/fasterxml/jackson/core/JsonParser;)Lcom/fasterxml/jackson/core/JsonToken;
    //   5: astore_3
    //   6: aload_3
    //   7: getstatic 277	com/fasterxml/jackson/core/JsonToken:VALUE_NULL	Lcom/fasterxml/jackson/core/JsonToken;
    //   10: if_acmpne +31 -> 41
    //   13: aload_0
    //   14: aload_0
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 281	com/fasterxml/jackson/databind/ObjectMapper:getDeserializationConfig	()Lcom/fasterxml/jackson/databind/DeserializationConfig;
    //   20: invokevirtual 285	com/fasterxml/jackson/databind/ObjectMapper:createDeserializationContext	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationConfig;)Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;
    //   23: aload_2
    //   24: invokevirtual 287	com/fasterxml/jackson/databind/ObjectMapper:_findRootDeserializer	(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    //   27: invokevirtual 291	com/fasterxml/jackson/databind/JsonDeserializer:getNullValue	()Ljava/lang/Object;
    //   30: astore_2
    //   31: aload_1
    //   32: invokevirtual 294	com/fasterxml/jackson/core/JsonParser:clearCurrentToken	()V
    //   35: aload_1
    //   36: invokevirtual 297	com/fasterxml/jackson/core/JsonParser:close	()V
    //   39: aload_2
    //   40: areturn
    //   41: aload_3
    //   42: getstatic 300	com/fasterxml/jackson/core/JsonToken:END_ARRAY	Lcom/fasterxml/jackson/core/JsonToken;
    //   45: if_acmpeq +83 -> 128
    //   48: aload_3
    //   49: getstatic 303	com/fasterxml/jackson/core/JsonToken:END_OBJECT	Lcom/fasterxml/jackson/core/JsonToken;
    //   52: if_acmpne +6 -> 58
    //   55: goto +73 -> 128
    //   58: aload_0
    //   59: invokevirtual 281	com/fasterxml/jackson/databind/ObjectMapper:getDeserializationConfig	()Lcom/fasterxml/jackson/databind/DeserializationConfig;
    //   62: astore_3
    //   63: aload_0
    //   64: aload_1
    //   65: aload_3
    //   66: invokevirtual 285	com/fasterxml/jackson/databind/ObjectMapper:createDeserializationContext	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationConfig;)Lcom/fasterxml/jackson/databind/deser/DefaultDeserializationContext;
    //   69: astore 4
    //   71: aload_0
    //   72: aload 4
    //   74: aload_2
    //   75: invokevirtual 287	com/fasterxml/jackson/databind/ObjectMapper:_findRootDeserializer	(Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JsonDeserializer;
    //   78: astore 5
    //   80: aload_3
    //   81: invokevirtual 307	com/fasterxml/jackson/databind/DeserializationConfig:useRootWrapping	()Z
    //   84: ifeq +18 -> 102
    //   87: aload_0
    //   88: aload_1
    //   89: aload 4
    //   91: aload_3
    //   92: aload_2
    //   93: aload 5
    //   95: invokevirtual 311	com/fasterxml/jackson/databind/ObjectMapper:_unwrapAndDeserialize	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Lcom/fasterxml/jackson/databind/DeserializationConfig;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonDeserializer;)Ljava/lang/Object;
    //   98: astore_2
    //   99: goto -68 -> 31
    //   102: aload 5
    //   104: aload_1
    //   105: aload 4
    //   107: invokevirtual 315	com/fasterxml/jackson/databind/JsonDeserializer:deserialize	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;
    //   110: astore_2
    //   111: goto -80 -> 31
    //   114: astore_2
    //   115: aload_1
    //   116: invokevirtual 297	com/fasterxml/jackson/core/JsonParser:close	()V
    //   119: aload_2
    //   120: athrow
    //   121: astore_1
    //   122: aload_2
    //   123: areturn
    //   124: astore_1
    //   125: goto -6 -> 119
    //   128: aconst_null
    //   129: astore_2
    //   130: goto -99 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	ObjectMapper
    //   0	133	1	paramJsonParser	JsonParser
    //   0	133	2	paramJavaType	JavaType
    //   5	87	3	localObject	Object
    //   69	37	4	localDefaultDeserializationContext	DefaultDeserializationContext
    //   78	25	5	localJsonDeserializer	JsonDeserializer
    // Exception table:
    //   from	to	target	type
    //   0	31	114	finally
    //   31	35	114	finally
    //   41	55	114	finally
    //   58	99	114	finally
    //   102	111	114	finally
    //   35	39	121	java/io/IOException
    //   115	119	124	java/io/IOException
  }
  
  protected Object _unwrapAndDeserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, JsonDeserializer<Object> paramJsonDeserializer)
  {
    String str2 = paramDeserializationConfig.getRootName();
    String str1 = str2;
    if (str2 == null) {
      str1 = this._rootNames.findRootName(paramJavaType, paramDeserializationConfig).getValue();
    }
    if (paramJsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
      throw JsonMappingException.from(paramJsonParser, "Current token not START_OBJECT (needed to unwrap root name '" + str1 + "'), but " + paramJsonParser.getCurrentToken());
    }
    if (paramJsonParser.nextToken() != JsonToken.FIELD_NAME) {
      throw JsonMappingException.from(paramJsonParser, "Current token not FIELD_NAME (to contain expected root name '" + str1 + "'), but " + paramJsonParser.getCurrentToken());
    }
    paramDeserializationConfig = paramJsonParser.getCurrentName();
    if (!str1.equals(paramDeserializationConfig)) {
      throw JsonMappingException.from(paramJsonParser, "Root name '" + paramDeserializationConfig + "' does not match expected ('" + str1 + "') for type " + paramJavaType);
    }
    paramJsonParser.nextToken();
    paramDeserializationContext = paramJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser.nextToken() != JsonToken.END_OBJECT) {
      throw JsonMappingException.from(paramJsonParser, "Current token not END_OBJECT (to match wrapper object with root name '" + str1 + "'), but " + paramJsonParser.getCurrentToken());
    }
    return paramDeserializationContext;
  }
  
  public ObjectMapper configure(JsonParser.Feature paramFeature, boolean paramBoolean)
  {
    this._jsonFactory.configure(paramFeature, paramBoolean);
    return this;
  }
  
  public ObjectMapper configure(DeserializationFeature paramDeserializationFeature, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramDeserializationFeature = this._deserializationConfig.with(paramDeserializationFeature);; paramDeserializationFeature = this._deserializationConfig.without(paramDeserializationFeature))
    {
      this._deserializationConfig = paramDeserializationFeature;
      return this;
    }
  }
  
  protected final DefaultDeserializationContext createDeserializationContext(JsonParser paramJsonParser, DeserializationConfig paramDeserializationConfig)
  {
    return this._deserializationContext.createInstance(paramDeserializationConfig, paramJsonParser, this._injectableValues);
  }
  
  public DeserializationConfig getDeserializationConfig()
  {
    return this._deserializationConfig;
  }
  
  public SerializationConfig getSerializationConfig()
  {
    return this._serializationConfig;
  }
  
  public <T> T readValue(URL paramURL, Class<T> paramClass)
  {
    return (T)_readMapAndClose(this._jsonFactory.createJsonParser(paramURL), this._typeFactory.constructType(paramClass));
  }
  
  public ObjectWriter writer()
  {
    return new ObjectWriter(this, getSerializationConfig());
  }
  
  public ObjectWriter writerWithDefaultPrettyPrinter()
  {
    return new ObjectWriter(this, getSerializationConfig(), null, _defaultPrettyPrinter());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ObjectMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */