package org.codehaus.jackson.map;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.text.DateFormat;
import org.codehaus.jackson.FormatSchema;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.Versioned;
import org.codehaus.jackson.io.SegmentedStringWriter;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.codehaus.jackson.util.VersionUtil;

public class ObjectWriter
  implements Versioned
{
  protected static final PrettyPrinter NULL_PRETTY_PRINTER = new MinimalPrettyPrinter();
  protected final SerializationConfig _config;
  protected final JsonFactory _jsonFactory;
  protected final PrettyPrinter _prettyPrinter;
  protected final SerializerProvider _provider;
  protected final JavaType _rootType;
  protected final FormatSchema _schema;
  protected final SerializerFactory _serializerFactory;
  
  protected ObjectWriter(ObjectMapper paramObjectMapper, SerializationConfig paramSerializationConfig)
  {
    this._config = paramSerializationConfig;
    this._provider = paramObjectMapper._serializerProvider;
    this._serializerFactory = paramObjectMapper._serializerFactory;
    this._jsonFactory = paramObjectMapper._jsonFactory;
    this._rootType = null;
    this._prettyPrinter = null;
    this._schema = null;
  }
  
  protected ObjectWriter(ObjectMapper paramObjectMapper, SerializationConfig paramSerializationConfig, FormatSchema paramFormatSchema)
  {
    this._config = paramSerializationConfig;
    this._provider = paramObjectMapper._serializerProvider;
    this._serializerFactory = paramObjectMapper._serializerFactory;
    this._jsonFactory = paramObjectMapper._jsonFactory;
    this._rootType = null;
    this._prettyPrinter = null;
    this._schema = paramFormatSchema;
  }
  
  protected ObjectWriter(ObjectMapper paramObjectMapper, SerializationConfig paramSerializationConfig, JavaType paramJavaType, PrettyPrinter paramPrettyPrinter)
  {
    this._config = paramSerializationConfig;
    this._provider = paramObjectMapper._serializerProvider;
    this._serializerFactory = paramObjectMapper._serializerFactory;
    this._jsonFactory = paramObjectMapper._jsonFactory;
    this._rootType = paramJavaType;
    this._prettyPrinter = paramPrettyPrinter;
    this._schema = null;
  }
  
  protected ObjectWriter(ObjectWriter paramObjectWriter, SerializationConfig paramSerializationConfig)
  {
    this._config = paramSerializationConfig;
    this._provider = paramObjectWriter._provider;
    this._serializerFactory = paramObjectWriter._serializerFactory;
    this._jsonFactory = paramObjectWriter._jsonFactory;
    this._schema = paramObjectWriter._schema;
    this._rootType = paramObjectWriter._rootType;
    this._prettyPrinter = paramObjectWriter._prettyPrinter;
  }
  
  protected ObjectWriter(ObjectWriter paramObjectWriter, SerializationConfig paramSerializationConfig, JavaType paramJavaType, PrettyPrinter paramPrettyPrinter, FormatSchema paramFormatSchema)
  {
    this._config = paramSerializationConfig;
    this._provider = paramObjectWriter._provider;
    this._serializerFactory = paramObjectWriter._serializerFactory;
    this._jsonFactory = paramObjectWriter._jsonFactory;
    this._rootType = paramJavaType;
    this._prettyPrinter = paramPrettyPrinter;
    this._schema = paramFormatSchema;
  }
  
  /* Error */
  private final void _configAndWriteCloseable(JsonGenerator paramJsonGenerator, Object paramObject, SerializationConfig paramSerializationConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: checkcast 64	java/io/Closeable
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 50	org/codehaus/jackson/map/ObjectWriter:_rootType	Lorg/codehaus/jackson/type/JavaType;
    //   10: ifnonnull +68 -> 78
    //   13: aload_0
    //   14: getfield 42	org/codehaus/jackson/map/ObjectWriter:_provider	Lorg/codehaus/jackson/map/SerializerProvider;
    //   17: aload_3
    //   18: aload_1
    //   19: aload_2
    //   20: aload_0
    //   21: getfield 45	org/codehaus/jackson/map/ObjectWriter:_serializerFactory	Lorg/codehaus/jackson/map/SerializerFactory;
    //   24: invokevirtual 70	org/codehaus/jackson/map/SerializerProvider:serializeValue	(Lorg/codehaus/jackson/map/SerializationConfig;Lorg/codehaus/jackson/JsonGenerator;Ljava/lang/Object;Lorg/codehaus/jackson/map/SerializerFactory;)V
    //   27: aload_0
    //   28: getfield 54	org/codehaus/jackson/map/ObjectWriter:_schema	Lorg/codehaus/jackson/FormatSchema;
    //   31: ifnull +11 -> 42
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 54	org/codehaus/jackson/map/ObjectWriter:_schema	Lorg/codehaus/jackson/FormatSchema;
    //   39: invokevirtual 76	org/codehaus/jackson/JsonGenerator:setSchema	(Lorg/codehaus/jackson/FormatSchema;)V
    //   42: aload_1
    //   43: invokevirtual 79	org/codehaus/jackson/JsonGenerator:close	()V
    //   46: aload 4
    //   48: invokeinterface 80 1 0
    //   53: iconst_0
    //   54: ifeq +11 -> 65
    //   57: new 82	java/lang/NullPointerException
    //   60: dup
    //   61: invokespecial 83	java/lang/NullPointerException:<init>	()V
    //   64: athrow
    //   65: iconst_0
    //   66: ifeq +11 -> 77
    //   69: new 82	java/lang/NullPointerException
    //   72: dup
    //   73: invokespecial 83	java/lang/NullPointerException:<init>	()V
    //   76: athrow
    //   77: return
    //   78: aload_0
    //   79: getfield 42	org/codehaus/jackson/map/ObjectWriter:_provider	Lorg/codehaus/jackson/map/SerializerProvider;
    //   82: aload_3
    //   83: aload_1
    //   84: aload_2
    //   85: aload_0
    //   86: getfield 50	org/codehaus/jackson/map/ObjectWriter:_rootType	Lorg/codehaus/jackson/type/JavaType;
    //   89: aload_0
    //   90: getfield 45	org/codehaus/jackson/map/ObjectWriter:_serializerFactory	Lorg/codehaus/jackson/map/SerializerFactory;
    //   93: invokevirtual 86	org/codehaus/jackson/map/SerializerProvider:serializeValue	(Lorg/codehaus/jackson/map/SerializationConfig;Lorg/codehaus/jackson/JsonGenerator;Ljava/lang/Object;Lorg/codehaus/jackson/type/JavaType;Lorg/codehaus/jackson/map/SerializerFactory;)V
    //   96: goto -69 -> 27
    //   99: astore 5
    //   101: aload_1
    //   102: astore_2
    //   103: aload 4
    //   105: astore_3
    //   106: aload 5
    //   108: astore_1
    //   109: aload_2
    //   110: ifnull +7 -> 117
    //   113: aload_2
    //   114: invokevirtual 79	org/codehaus/jackson/JsonGenerator:close	()V
    //   117: aload_3
    //   118: ifnull +9 -> 127
    //   121: aload_3
    //   122: invokeinterface 80 1 0
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: goto -65 -> 65
    //   133: astore_1
    //   134: return
    //   135: astore_2
    //   136: goto -19 -> 117
    //   139: astore_2
    //   140: goto -13 -> 127
    //   143: astore_1
    //   144: aconst_null
    //   145: astore_2
    //   146: aload 4
    //   148: astore_3
    //   149: goto -40 -> 109
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_2
    //   157: goto -48 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	ObjectWriter
    //   0	160	1	paramJsonGenerator	JsonGenerator
    //   0	160	2	paramObject	Object
    //   0	160	3	paramSerializationConfig	SerializationConfig
    //   4	143	4	localCloseable	Closeable
    //   99	8	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	27	99	finally
    //   27	42	99	finally
    //   78	96	99	finally
    //   57	65	129	java/io/IOException
    //   69	77	133	java/io/IOException
    //   113	117	135	java/io/IOException
    //   121	127	139	java/io/IOException
    //   42	46	143	finally
    //   46	53	152	finally
  }
  
  /* Error */
  private final void _writeCloseableValue(JsonGenerator paramJsonGenerator, Object paramObject, SerializationConfig paramSerializationConfig)
  {
    // Byte code:
    //   0: aload_2
    //   1: checkcast 64	java/io/Closeable
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 50	org/codehaus/jackson/map/ObjectWriter:_rootType	Lorg/codehaus/jackson/type/JavaType;
    //   10: ifnonnull +54 -> 64
    //   13: aload_0
    //   14: getfield 42	org/codehaus/jackson/map/ObjectWriter:_provider	Lorg/codehaus/jackson/map/SerializerProvider;
    //   17: aload_3
    //   18: aload_1
    //   19: aload_2
    //   20: aload_0
    //   21: getfield 45	org/codehaus/jackson/map/ObjectWriter:_serializerFactory	Lorg/codehaus/jackson/map/SerializerFactory;
    //   24: invokevirtual 70	org/codehaus/jackson/map/SerializerProvider:serializeValue	(Lorg/codehaus/jackson/map/SerializationConfig;Lorg/codehaus/jackson/JsonGenerator;Ljava/lang/Object;Lorg/codehaus/jackson/map/SerializerFactory;)V
    //   27: aload_0
    //   28: getfield 35	org/codehaus/jackson/map/ObjectWriter:_config	Lorg/codehaus/jackson/map/SerializationConfig;
    //   31: getstatic 93	org/codehaus/jackson/map/SerializationConfig$Feature:FLUSH_AFTER_WRITE_VALUE	Lorg/codehaus/jackson/map/SerializationConfig$Feature;
    //   34: invokevirtual 99	org/codehaus/jackson/map/SerializationConfig:isEnabled	(Lorg/codehaus/jackson/map/SerializationConfig$Feature;)Z
    //   37: ifeq +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 102	org/codehaus/jackson/JsonGenerator:flush	()V
    //   44: aload 4
    //   46: invokeinterface 80 1 0
    //   51: iconst_0
    //   52: ifeq +11 -> 63
    //   55: new 82	java/lang/NullPointerException
    //   58: dup
    //   59: invokespecial 83	java/lang/NullPointerException:<init>	()V
    //   62: athrow
    //   63: return
    //   64: aload_0
    //   65: getfield 42	org/codehaus/jackson/map/ObjectWriter:_provider	Lorg/codehaus/jackson/map/SerializerProvider;
    //   68: aload_3
    //   69: aload_1
    //   70: aload_2
    //   71: aload_0
    //   72: getfield 50	org/codehaus/jackson/map/ObjectWriter:_rootType	Lorg/codehaus/jackson/type/JavaType;
    //   75: aload_0
    //   76: getfield 45	org/codehaus/jackson/map/ObjectWriter:_serializerFactory	Lorg/codehaus/jackson/map/SerializerFactory;
    //   79: invokevirtual 86	org/codehaus/jackson/map/SerializerProvider:serializeValue	(Lorg/codehaus/jackson/map/SerializationConfig;Lorg/codehaus/jackson/JsonGenerator;Ljava/lang/Object;Lorg/codehaus/jackson/type/JavaType;Lorg/codehaus/jackson/map/SerializerFactory;)V
    //   82: goto -55 -> 27
    //   85: astore_1
    //   86: aload 4
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +9 -> 99
    //   93: aload_2
    //   94: invokeinterface 80 1 0
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: return
    //   103: astore_2
    //   104: goto -5 -> 99
    //   107: astore_1
    //   108: aconst_null
    //   109: astore_2
    //   110: goto -21 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	ObjectWriter
    //   0	113	1	paramJsonGenerator	JsonGenerator
    //   0	113	2	paramObject	Object
    //   0	113	3	paramSerializationConfig	SerializationConfig
    //   4	83	4	localCloseable	Closeable
    // Exception table:
    //   from	to	target	type
    //   6	27	85	finally
    //   27	44	85	finally
    //   64	82	85	finally
    //   55	63	101	java/io/IOException
    //   93	99	103	java/io/IOException
    //   44	51	107	finally
  }
  
  protected final void _configAndWriteValue(JsonGenerator paramJsonGenerator, Object paramObject)
  {
    if (this._prettyPrinter != null)
    {
      PrettyPrinter localPrettyPrinter2 = this._prettyPrinter;
      PrettyPrinter localPrettyPrinter1 = localPrettyPrinter2;
      if (localPrettyPrinter2 == NULL_PRETTY_PRINTER) {
        localPrettyPrinter1 = null;
      }
      paramJsonGenerator.setPrettyPrinter(localPrettyPrinter1);
    }
    for (;;)
    {
      if (this._schema != null) {
        paramJsonGenerator.setSchema(this._schema);
      }
      if ((!this._config.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE)) || (!(paramObject instanceof Closeable))) {
        break;
      }
      _configAndWriteCloseable(paramJsonGenerator, paramObject, this._config);
      return;
      if (this._config.isEnabled(SerializationConfig.Feature.INDENT_OUTPUT)) {
        paramJsonGenerator.useDefaultPrettyPrinter();
      }
    }
    try
    {
      if (this._rootType == null)
      {
        this._provider.serializeValue(this._config, paramJsonGenerator, paramObject, this._serializerFactory);
        i = 1;
        try
        {
          paramJsonGenerator.close();
          return;
        }
        finally {}
        if (i != 0) {}
      }
    }
    finally
    {
      try
      {
        for (;;)
        {
          paramJsonGenerator.close();
          throw ((Throwable)paramObject);
          this._provider.serializeValue(this._config, paramJsonGenerator, paramObject, this._rootType, this._serializerFactory);
        }
        paramObject = finally;
        int i = 0;
      }
      catch (IOException paramJsonGenerator)
      {
        for (;;) {}
      }
    }
  }
  
  public boolean canSerialize(Class paramClass)
  {
    return this._provider.hasSerializerFor(this._config, paramClass, this._serializerFactory);
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
  
  public ObjectWriter withDateFormat(DateFormat paramDateFormat)
  {
    paramDateFormat = this._config.withDateFormat(paramDateFormat);
    if (paramDateFormat == this._config) {
      return this;
    }
    return new ObjectWriter(this, paramDateFormat);
  }
  
  public ObjectWriter withDefaultPrettyPrinter()
  {
    return withPrettyPrinter(new DefaultPrettyPrinter());
  }
  
  public ObjectWriter withFilters(FilterProvider paramFilterProvider)
  {
    if (paramFilterProvider == this._config.getFilterProvider()) {
      return this;
    }
    return new ObjectWriter(this, this._config.withFilters(paramFilterProvider));
  }
  
  public ObjectWriter withPrettyPrinter(PrettyPrinter paramPrettyPrinter)
  {
    if (paramPrettyPrinter == this._prettyPrinter) {
      return this;
    }
    if (paramPrettyPrinter == null) {
      paramPrettyPrinter = NULL_PRETTY_PRINTER;
    }
    for (;;)
    {
      return new ObjectWriter(this, this._config, this._rootType, paramPrettyPrinter, this._schema);
    }
  }
  
  public ObjectWriter withSchema(FormatSchema paramFormatSchema)
  {
    if (this._schema == paramFormatSchema) {
      return this;
    }
    return new ObjectWriter(this, this._config, this._rootType, this._prettyPrinter, paramFormatSchema);
  }
  
  public ObjectWriter withType(Class paramClass)
  {
    return withType(this._config.constructType(paramClass));
  }
  
  public ObjectWriter withType(JavaType paramJavaType)
  {
    if (paramJavaType == this._rootType) {
      return this;
    }
    return new ObjectWriter(this, this._config, paramJavaType, this._prettyPrinter, this._schema);
  }
  
  public ObjectWriter withType(TypeReference paramTypeReference)
  {
    return withType(this._config.getTypeFactory().constructType(paramTypeReference.getType()));
  }
  
  public ObjectWriter withView(Class paramClass)
  {
    if (paramClass == this._config.getSerializationView()) {
      return this;
    }
    return new ObjectWriter(this, this._config.withView(paramClass));
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
    if ((this._config.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE)) && ((paramObject instanceof Closeable))) {
      _writeCloseableValue(paramJsonGenerator, paramObject, this._config);
    }
    for (;;)
    {
      return;
      if (this._rootType == null) {
        this._provider.serializeValue(this._config, paramJsonGenerator, paramObject, this._serializerFactory);
      }
      while (this._config.isEnabled(SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE))
      {
        paramJsonGenerator.flush();
        return;
        this._provider.serializeValue(this._config, paramJsonGenerator, paramObject, this._rootType, this._serializerFactory);
      }
    }
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ObjectWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */