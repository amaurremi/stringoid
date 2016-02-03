package com.flurry.org.apache.avro.specific;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Protocol;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Type;
import com.flurry.org.apache.avro.generic.GenericData;
import com.flurry.org.apache.avro.io.DatumReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class SpecificData
  extends GenericData
{
  private static final Map<Class, Constructor> CTOR_CACHE = new ConcurrentHashMap();
  private static final SpecificData INSTANCE = new SpecificData();
  private static final Class<?>[] NO_ARG = new Class[0];
  private static final Class NO_CLASS = new Object() {}.getClass();
  private static final Schema NULL_SCHEMA = Schema.create(Schema.Type.NULL);
  private static final Class<?>[] SCHEMA_ARG = { Schema.class };
  private Map<String, Class> classCache = new ConcurrentHashMap();
  private final ClassLoader classLoader;
  private final WeakHashMap<Type, Schema> schemaCache = new WeakHashMap();
  
  protected SpecificData()
  {
    this(SpecificData.class.getClassLoader());
  }
  
  public SpecificData(ClassLoader paramClassLoader)
  {
    this.classLoader = paramClassLoader;
  }
  
  public static SpecificData get()
  {
    return INSTANCE;
  }
  
  public static String getClassName(Schema paramSchema)
  {
    String str1 = paramSchema.getNamespace();
    String str2 = paramSchema.getName();
    if ((str1 == null) || ("".equals(str1))) {
      return str2;
    }
    if (str1.endsWith("$")) {}
    for (paramSchema = "";; paramSchema = ".") {
      return str1 + paramSchema + str2;
    }
  }
  
  /* Error */
  public static Object newInstance(Class paramClass, Schema paramSchema)
  {
    // Byte code:
    //   0: ldc 10
    //   2: aload_0
    //   3: invokevirtual 135	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   6: istore_2
    //   7: getstatic 51	com/flurry/org/apache/avro/specific/SpecificData:CTOR_CACHE	Ljava/util/Map;
    //   10: aload_0
    //   11: invokeinterface 140 2 0
    //   16: checkcast 142	java/lang/reflect/Constructor
    //   19: astore 4
    //   21: aload 4
    //   23: astore_3
    //   24: aload 4
    //   26: ifnonnull +33 -> 59
    //   29: iload_2
    //   30: ifeq +48 -> 78
    //   33: getstatic 46	com/flurry/org/apache/avro/specific/SpecificData:SCHEMA_ARG	[Ljava/lang/Class;
    //   36: astore_3
    //   37: aload_0
    //   38: aload_3
    //   39: invokevirtual 146	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   42: astore_3
    //   43: aload_3
    //   44: iconst_1
    //   45: invokevirtual 150	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   48: getstatic 51	com/flurry/org/apache/avro/specific/SpecificData:CTOR_CACHE	Ljava/util/Map;
    //   51: aload_0
    //   52: aload_3
    //   53: invokeinterface 154 3 0
    //   58: pop
    //   59: iload_2
    //   60: ifeq +25 -> 85
    //   63: iconst_1
    //   64: anewarray 54	java/lang/Object
    //   67: astore_0
    //   68: aload_0
    //   69: iconst_0
    //   70: aload_1
    //   71: aastore
    //   72: aload_3
    //   73: aload_0
    //   74: invokevirtual 157	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   77: areturn
    //   78: getstatic 42	com/flurry/org/apache/avro/specific/SpecificData:NO_ARG	[Ljava/lang/Class;
    //   81: astore_3
    //   82: goto -45 -> 37
    //   85: aconst_null
    //   86: checkcast 159	[Ljava/lang/Object;
    //   89: astore_0
    //   90: goto -18 -> 72
    //   93: astore_0
    //   94: new 161	java/lang/RuntimeException
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 164	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramClass	Class
    //   0	103	1	paramSchema	Schema
    //   6	54	2	bool	boolean
    //   23	59	3	localObject	Object
    //   19	6	4	localConstructor	Constructor
    // Exception table:
    //   from	to	target	type
    //   7	21	93	java/lang/Exception
    //   33	37	93	java/lang/Exception
    //   37	59	93	java/lang/Exception
    //   63	68	93	java/lang/Exception
    //   72	78	93	java/lang/Exception
    //   78	82	93	java/lang/Exception
    //   85	90	93	java/lang/Exception
  }
  
  protected int compare(Object paramObject1, Object paramObject2, Schema paramSchema, boolean paramBoolean)
  {
    switch (paramSchema.getType())
    {
    }
    do
    {
      return super.compare(paramObject1, paramObject2, paramSchema, paramBoolean);
    } while (!(paramObject1 instanceof Enum));
    return ((Enum)paramObject1).ordinal() - ((Enum)paramObject2).ordinal();
  }
  
  public DatumReader createDatumReader(Schema paramSchema)
  {
    return new SpecificDatumReader(paramSchema, paramSchema, this);
  }
  
  public Object createFixed(Object paramObject, Schema paramSchema)
  {
    Class localClass = get().getClass(paramSchema);
    Object localObject;
    if (localClass == null) {
      localObject = super.createFixed(paramObject, paramSchema);
    }
    do
    {
      return localObject;
      localObject = paramObject;
    } while (localClass.isInstance(paramObject));
    return newInstance(localClass, paramSchema);
  }
  
  protected Schema createSchema(Type paramType, Map<String, Schema> paramMap)
  {
    if (((paramType instanceof Class)) && (CharSequence.class.isAssignableFrom((Class)paramType))) {
      return Schema.create(Schema.Type.STRING);
    }
    if (paramType == ByteBuffer.class) {
      return Schema.create(Schema.Type.BYTES);
    }
    if ((paramType == Integer.class) || (paramType == Integer.TYPE)) {
      return Schema.create(Schema.Type.INT);
    }
    if ((paramType == Long.class) || (paramType == Long.TYPE)) {
      return Schema.create(Schema.Type.LONG);
    }
    if ((paramType == Float.class) || (paramType == Float.TYPE)) {
      return Schema.create(Schema.Type.FLOAT);
    }
    if ((paramType == Double.class) || (paramType == Double.TYPE)) {
      return Schema.create(Schema.Type.DOUBLE);
    }
    if ((paramType == Boolean.class) || (paramType == Boolean.TYPE)) {
      return Schema.create(Schema.Type.BOOLEAN);
    }
    if ((paramType == Void.class) || (paramType == Void.TYPE)) {
      return Schema.create(Schema.Type.NULL);
    }
    Object localObject2;
    Object localObject1;
    if ((paramType instanceof ParameterizedType))
    {
      localObject2 = (ParameterizedType)paramType;
      localObject1 = (Class)((ParameterizedType)localObject2).getRawType();
      localObject2 = ((ParameterizedType)localObject2).getActualTypeArguments();
      if (Collection.class.isAssignableFrom((Class)localObject1))
      {
        if (localObject2.length != 1) {
          throw new AvroTypeException("No array type specified.");
        }
        return Schema.createArray(createSchema(localObject2[0], paramMap));
      }
      if (Map.class.isAssignableFrom((Class)localObject1))
      {
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        if ((!(paramType instanceof Class)) || (!CharSequence.class.isAssignableFrom((Class)paramType))) {
          throw new AvroTypeException("Map key class not CharSequence: " + localObject1);
        }
        return Schema.createMap(createSchema((Type)localObject2, paramMap));
      }
      return createSchema((Type)localObject1, paramMap);
    }
    if ((paramType instanceof Class))
    {
      localObject2 = (Class)paramType;
      String str = ((Class)localObject2).getName();
      localObject1 = (Schema)paramMap.get(str);
      paramType = (Type)localObject1;
      if (localObject1 == null) {}
      try
      {
        localObject1 = (Schema)((Class)localObject2).getDeclaredField("SCHEMA$").get(null);
        paramType = (Type)localObject1;
        if (!str.equals(getClassName((Schema)localObject1))) {
          paramType = Schema.parse(((Schema)localObject1).toString().replace(((Schema)localObject1).getNamespace(), ((Class)localObject2).getPackage().getName()));
        }
        paramMap.put(str, paramType);
        return paramType;
      }
      catch (NoSuchFieldException paramType)
      {
        throw new AvroRuntimeException("Not a Specific class: " + localObject2);
      }
      catch (IllegalAccessException paramType)
      {
        throw new AvroRuntimeException(paramType);
      }
    }
    throw new AvroTypeException("Unknown type: " + paramType);
  }
  
  public Class getClass(Schema paramSchema)
  {
    switch (paramSchema.getType())
    {
    default: 
      throw new AvroRuntimeException("Unknown type: " + paramSchema);
    case ???: 
    case ???: 
    case ???: 
      String str = paramSchema.getFullName();
      if (str == null) {
        return null;
      }
      Class localClass2 = (Class)this.classCache.get(str);
      Class localClass1 = localClass2;
      if (localClass2 == null) {}
      try
      {
        localClass1 = this.classLoader.loadClass(getClassName(paramSchema));
        this.classCache.put(str, localClass1);
        paramSchema = localClass1;
        if (localClass1 == NO_CLASS) {
          paramSchema = null;
        }
        return paramSchema;
      }
      catch (ClassNotFoundException paramSchema)
      {
        for (;;)
        {
          localClass1 = NO_CLASS;
        }
      }
    case ???: 
      return List.class;
    case ???: 
      return Map.class;
    case ???: 
      paramSchema = paramSchema.getTypes();
      if ((paramSchema.size() == 2) && (paramSchema.contains(NULL_SCHEMA)))
      {
        if (((Schema)paramSchema.get(0)).equals(NULL_SCHEMA)) {}
        for (int i = 1;; i = 0) {
          return getClass((Schema)paramSchema.get(i));
        }
      }
      return Object.class;
    case ???: 
      if ("String".equals(paramSchema.getProp("avro.java.string"))) {
        return String.class;
      }
      return CharSequence.class;
    case ???: 
      return ByteBuffer.class;
    case ???: 
      return Integer.TYPE;
    case ???: 
      return Long.TYPE;
    case ???: 
      return Float.TYPE;
    case ???: 
      return Double.TYPE;
    case ???: 
      return Boolean.TYPE;
    }
    return Void.TYPE;
  }
  
  protected Schema getEnumSchema(Object paramObject)
  {
    if ((paramObject instanceof Enum)) {
      return getSchema(paramObject.getClass());
    }
    return super.getEnumSchema(paramObject);
  }
  
  public Protocol getProtocol(Class paramClass)
  {
    try
    {
      Protocol localProtocol2 = (Protocol)paramClass.getDeclaredField("PROTOCOL").get(null);
      Protocol localProtocol1 = localProtocol2;
      if (!localProtocol2.getNamespace().equals(paramClass.getPackage().getName())) {
        localProtocol1 = Protocol.parse(localProtocol2.toString().replace(localProtocol2.getNamespace(), paramClass.getPackage().getName()));
      }
      return localProtocol1;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new AvroRuntimeException("Not a Specific protocol: " + paramClass);
    }
    catch (IllegalAccessException paramClass)
    {
      throw new AvroRuntimeException(paramClass);
    }
  }
  
  public Schema getSchema(Type paramType)
  {
    Schema localSchema2 = (Schema)this.schemaCache.get(paramType);
    Schema localSchema1 = localSchema2;
    if (localSchema2 == null)
    {
      localSchema1 = createSchema(paramType, new LinkedHashMap());
      this.schemaCache.put(paramType, localSchema1);
    }
    return localSchema1;
  }
  
  protected boolean isEnum(Object paramObject)
  {
    return ((paramObject instanceof Enum)) || (super.isEnum(paramObject));
  }
  
  public Object newRecord(Object paramObject, Schema paramSchema)
  {
    Class localClass = get().getClass(paramSchema);
    Object localObject;
    if (localClass == null) {
      localObject = super.newRecord(paramObject, paramSchema);
    }
    do
    {
      return localObject;
      localObject = paramObject;
    } while (localClass.isInstance(paramObject));
    return newInstance(localClass, paramSchema);
  }
  
  public static abstract interface SchemaConstructable {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/specific/SpecificData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */