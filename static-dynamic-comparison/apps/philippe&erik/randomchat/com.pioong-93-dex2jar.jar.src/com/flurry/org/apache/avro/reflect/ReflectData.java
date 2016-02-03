package com.flurry.org.apache.avro.reflect;

import com.flurry.org.apache.avro.AvroRemoteException;
import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Protocol;
import com.flurry.org.apache.avro.Protocol.Message;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Field;
import com.flurry.org.apache.avro.Schema.Type;
import com.flurry.org.apache.avro.generic.GenericContainer;
import com.flurry.org.apache.avro.generic.GenericFixed;
import com.flurry.org.apache.avro.generic.IndexedRecord;
import com.flurry.org.apache.avro.io.BinaryData;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.specific.FixedSize;
import com.flurry.org.apache.avro.specific.SpecificData;
import com.flurry.org.codehaus.jackson.node.NullNode;
import com.thoughtworks.paranamer.CachingParanamer;
import com.thoughtworks.paranamer.Paranamer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectData
  extends SpecificData
{
  private static final Class BYTES_CLASS = new byte[0].getClass();
  static final String CLASS_PROP = "java-class";
  static final String ELEMENT_PROP = "java-element-class";
  private static final Map<Class, Map<String, Field>> FIELD_CACHE;
  private static final ReflectData INSTANCE = new ReflectData();
  private static final Schema THROWABLE_MESSAGE = makeNullable(Schema.create(Schema.Type.STRING));
  private final Paranamer paranamer = new CachingParanamer();
  
  static
  {
    FIELD_CACHE = new ConcurrentHashMap();
  }
  
  private static Field findField(Class paramClass, String paramString)
  {
    Object localObject = paramClass;
    Class localClass;
    do
    {
      try
      {
        Field localField = ((Class)localObject).getDeclaredField(paramString);
        localField.setAccessible(true);
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = ((Class)localObject).getSuperclass();
        localObject = localClass;
      }
    } while (localClass != null);
    throw new AvroRuntimeException("No field named " + paramString + " in: " + paramClass);
  }
  
  public static ReflectData get()
  {
    return INSTANCE;
  }
  
  private Schema getAnnotatedUnion(Union paramUnion, Map<String, Schema> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramUnion = paramUnion.value();
    int j = paramUnion.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(createSchema(paramUnion[i], paramMap));
      i += 1;
    }
    return Schema.createUnion(localArrayList);
  }
  
  static Class getClassProp(Schema paramSchema, String paramString)
  {
    paramSchema = paramSchema.getProp(paramString);
    if (paramSchema == null) {
      return null;
    }
    try
    {
      paramSchema = Class.forName(paramSchema);
      return paramSchema;
    }
    catch (ClassNotFoundException paramSchema)
    {
      throw new AvroRuntimeException(paramSchema);
    }
  }
  
  private static Field getField(Class paramClass, String paramString)
  {
    Object localObject2 = (Map)FIELD_CACHE.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ConcurrentHashMap();
      FIELD_CACHE.put(paramClass, localObject1);
    }
    Field localField = (Field)((Map)localObject1).get(paramString);
    localObject2 = localField;
    if (localField == null)
    {
      localObject2 = findField(paramClass, paramString);
      ((Map)localObject1).put(paramString, localObject2);
    }
    return (Field)localObject2;
  }
  
  private Collection<Field> getFields(Class paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if ((paramClass.getPackage() != null) && (paramClass.getPackage().getName().startsWith("java."))) {}
    for (;;)
    {
      return localLinkedHashMap.values();
      Object localObject1 = paramClass.getDeclaredFields();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (((((Field)localObject2).getModifiers() & 0x88) == 0) && (localLinkedHashMap.put(((Field)localObject2).getName(), localObject2) != null)) {
          throw new AvroTypeException(paramClass + " contains two fields named: " + localObject2);
        }
        i += 1;
      }
      localObject1 = paramClass.getSuperclass();
      paramClass = (Class)localObject1;
      if (localObject1 != null) {
        break;
      }
    }
  }
  
  private Protocol.Message getMessage(Method paramMethod, Protocol paramProtocol, Map<String, Schema> paramMap)
  {
    Object localObject3 = new ArrayList();
    Object localObject4 = this.paranamer.lookupParameterNames(paramMethod);
    Type[] arrayOfType = paramMethod.getGenericParameterTypes();
    Annotation[][] arrayOfAnnotation = paramMethod.getParameterAnnotations();
    int i = 0;
    Object localObject2;
    int j;
    if (i < arrayOfType.length)
    {
      localObject2 = getSchema(arrayOfType[i], paramMap);
      j = 0;
      if (j < arrayOfAnnotation[i].length)
      {
        if ((arrayOfAnnotation[i][j] instanceof Union)) {
          localObject1 = getAnnotatedUnion((Union)arrayOfAnnotation[i][j], paramMap);
        }
        for (;;)
        {
          j += 1;
          localObject2 = localObject1;
          break;
          localObject1 = localObject2;
          if ((arrayOfAnnotation[i][j] instanceof Nullable)) {
            localObject1 = makeNullable((Schema)localObject2);
          }
        }
      }
      if (localObject4.length == arrayOfType.length) {}
      for (localObject1 = localObject4[i];; localObject1 = ((Schema)localObject2).getName() + i)
      {
        ((List)localObject3).add(new Schema.Field((String)localObject1, (Schema)localObject2, null, null));
        i += 1;
        break;
      }
    }
    localObject3 = Schema.createRecord((List)localObject3);
    Object localObject1 = (Union)paramMethod.getAnnotation(Union.class);
    if (localObject1 == null) {}
    for (localObject1 = getSchema(paramMethod.getGenericReturnType(), paramMap);; localObject1 = getAnnotatedUnion((Union)localObject1, paramMap))
    {
      localObject2 = localObject1;
      if (paramMethod.isAnnotationPresent(Nullable.class)) {
        localObject2 = makeNullable((Schema)localObject1);
      }
      localObject1 = new ArrayList();
      ((List)localObject1).add(Protocol.SYSTEM_ERROR);
      localObject4 = paramMethod.getGenericExceptionTypes();
      j = localObject4.length;
      i = 0;
      while (i < j)
      {
        arrayOfType = localObject4[i];
        if (arrayOfType != AvroRemoteException.class) {
          ((List)localObject1).add(getSchema(arrayOfType, paramMap));
        }
        i += 1;
      }
    }
    paramMap = Schema.createUnion((List)localObject1);
    return paramProtocol.createMessage(paramMethod.getName(), null, (Schema)localObject3, (Schema)localObject2, paramMap);
  }
  
  private Schema getSchema(Type paramType, Map<String, Schema> paramMap)
  {
    try
    {
      paramMap = createSchema(paramType, paramMap);
      return paramMap;
    }
    catch (AvroTypeException paramMap)
    {
      throw new AvroTypeException("Error getting schema for " + paramType + ": " + paramMap.getMessage(), paramMap);
    }
  }
  
  public static Schema makeNullable(Schema paramSchema)
  {
    return Schema.createUnion(Arrays.asList(new Schema[] { Schema.create(Schema.Type.NULL), paramSchema }));
  }
  
  private void setElement(Schema paramSchema, Type paramType)
  {
    if (!(paramType instanceof Class)) {}
    do
    {
      return;
      paramType = (Class)paramType;
    } while ((Union)paramType.getAnnotation(Union.class) == null);
    paramSchema.addProp("java-element-class", paramType.getName());
  }
  
  protected int compare(Object paramObject1, Object paramObject2, Schema paramSchema, boolean paramBoolean)
  {
    switch (paramSchema.getType())
    {
    }
    label135:
    do
    {
      int i;
      do
      {
        i = super.compare(paramObject1, paramObject2, paramSchema, paramBoolean);
        return i;
      } while (!paramObject1.getClass().isArray());
      paramSchema = paramSchema.getElementType();
      int m = Array.getLength(paramObject1);
      int n = Array.getLength(paramObject2);
      int i1 = Math.min(m, n);
      int j = 0;
      for (;;)
      {
        if (j >= i1) {
          break label135;
        }
        int k = compare(Array.get(paramObject1, j), Array.get(paramObject2, j), paramSchema, paramBoolean);
        i = k;
        if (k != 0) {
          break;
        }
        j += 1;
      }
      return m - n;
    } while (!paramObject1.getClass().isArray());
    paramObject1 = (byte[])paramObject1;
    paramObject2 = (byte[])paramObject2;
    return BinaryData.compareBytes((byte[])paramObject1, 0, paramObject1.length, (byte[])paramObject2, 0, paramObject2.length);
  }
  
  public DatumReader createDatumReader(Schema paramSchema)
  {
    return new ReflectDatumReader(paramSchema, paramSchema, this);
  }
  
  protected Schema createFieldSchema(Field paramField, Map<String, Schema> paramMap)
  {
    Schema localSchema = createSchema(paramField.getGenericType(), paramMap);
    paramMap = localSchema;
    if (paramField.isAnnotationPresent(Nullable.class)) {
      paramMap = makeNullable(localSchema);
    }
    return paramMap;
  }
  
  protected Schema createSchema(Type paramType, Map<String, Schema> paramMap)
  {
    if ((paramType instanceof GenericArrayType))
    {
      paramType = ((GenericArrayType)paramType).getGenericComponentType();
      if (paramType == Byte.TYPE) {
        return Schema.create(Schema.Type.BYTES);
      }
      paramMap = Schema.createArray(createSchema(paramType, paramMap));
      setElement(paramMap, paramType);
      return paramMap;
    }
    Object localObject2;
    Object localObject1;
    if ((paramType instanceof ParameterizedType))
    {
      localObject2 = (ParameterizedType)paramType;
      localObject1 = (Class)((ParameterizedType)localObject2).getRawType();
      localObject2 = ((ParameterizedType)localObject2).getActualTypeArguments();
      if (Map.class.isAssignableFrom((Class)localObject1))
      {
        paramType = localObject2[0];
        localObject1 = localObject2[1];
        if (paramType != String.class) {
          throw new AvroTypeException("Map key class not String: " + paramType);
        }
        return Schema.createMap(createSchema((Type)localObject1, paramMap));
      }
      if (Collection.class.isAssignableFrom((Class)localObject1))
      {
        if (localObject2.length != 1) {
          throw new AvroTypeException("No array type specified.");
        }
        paramType = Schema.createArray(createSchema(localObject2[0], paramMap));
        paramType.addProp("java-class", ((Class)localObject1).getName());
        return paramType;
      }
    }
    else
    {
      if ((paramType == Byte.class) || (paramType == Byte.TYPE))
      {
        paramType = Schema.create(Schema.Type.INT);
        paramType.addProp("java-class", Byte.class.getName());
        return paramType;
      }
      if ((paramType == Short.class) || (paramType == Short.TYPE))
      {
        paramType = Schema.create(Schema.Type.INT);
        paramType.addProp("java-class", Short.class.getName());
        return paramType;
      }
      if ((paramType instanceof Class))
      {
        Object localObject3 = (Class)paramType;
        if ((((Class)localObject3).isPrimitive()) || (Number.class.isAssignableFrom((Class)localObject3)) || (localObject3 == Void.class) || (localObject3 == Boolean.class)) {
          return super.createSchema(paramType, paramMap);
        }
        if (((Class)localObject3).isArray())
        {
          paramType = ((Class)localObject3).getComponentType();
          if (paramType == Byte.TYPE) {
            return Schema.create(Schema.Type.BYTES);
          }
          paramMap = Schema.createArray(createSchema(paramType, paramMap));
          setElement(paramMap, paramType);
          return paramMap;
        }
        if (CharSequence.class.isAssignableFrom((Class)localObject3)) {
          return Schema.create(Schema.Type.STRING);
        }
        if (ByteBuffer.class.isAssignableFrom((Class)localObject3)) {
          return Schema.create(Schema.Type.BYTES);
        }
        if (Collection.class.isAssignableFrom((Class)localObject3)) {
          throw new AvroRuntimeException("Can't find element type of Collection");
        }
        String str = ((Class)localObject3).getName();
        localObject2 = (Schema)paramMap.get(str);
        localObject1 = localObject2;
        Object localObject4;
        if (localObject2 == null)
        {
          localObject2 = ((Class)localObject3).getSimpleName();
          if (((Class)localObject3).getPackage() == null) {}
          for (localObject1 = "";; localObject1 = ((Class)localObject3).getPackage().getName())
          {
            if (((Class)localObject3).getEnclosingClass() != null) {
              localObject1 = ((Class)localObject3).getEnclosingClass().getName() + "$";
            }
            localObject4 = (Union)((Class)localObject3).getAnnotation(Union.class);
            if (localObject4 == null) {
              break;
            }
            return getAnnotatedUnion((Union)localObject4, paramMap);
          }
          if (((Class)localObject3).isAnnotationPresent(Stringable.class))
          {
            paramType = Schema.create(Schema.Type.STRING);
            paramType.addProp("java-class", ((Class)localObject3).getName());
            return paramType;
          }
          if (!((Class)localObject3).isEnum()) {
            break label673;
          }
          paramType = new ArrayList();
          localObject3 = (Enum[])((Class)localObject3).getEnumConstants();
          int i = 0;
          while (i < localObject3.length)
          {
            paramType.add(localObject3[i].name());
            i += 1;
          }
          paramType = Schema.createEnum((String)localObject2, null, (String)localObject1, paramType);
        }
        for (;;)
        {
          paramMap.put(str, paramType);
          localObject1 = paramType;
          return (Schema)localObject1;
          label673:
          if (GenericFixed.class.isAssignableFrom((Class)localObject3))
          {
            paramType = Schema.createFixed((String)localObject2, null, (String)localObject1, ((FixedSize)((Class)localObject3).getAnnotation(FixedSize.class)).value());
          }
          else
          {
            if (IndexedRecord.class.isAssignableFrom((Class)localObject3)) {
              return super.createSchema(paramType, paramMap);
            }
            localObject4 = new ArrayList();
            boolean bool = Throwable.class.isAssignableFrom((Class)localObject3);
            localObject1 = Schema.createRecord((String)localObject2, null, (String)localObject1, bool);
            paramMap.put(((Class)localObject3).getName(), localObject1);
            localObject3 = getFields((Class)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              Field localField = (Field)((Iterator)localObject3).next();
              if ((localField.getModifiers() & 0x88) == 0)
              {
                Schema localSchema = createFieldSchema(localField, paramMap);
                localObject2 = null;
                paramType = (Type)localObject2;
                if (localSchema.getType() == Schema.Type.UNION)
                {
                  paramType = (Type)localObject2;
                  if (((Schema)localSchema.getTypes().get(0)).getType() == Schema.Type.NULL) {
                    paramType = NullNode.getInstance();
                  }
                }
                ((List)localObject4).add(new Schema.Field(localField.getName(), localSchema, null, paramType));
              }
            }
            if (bool) {
              ((List)localObject4).add(new Schema.Field("detailMessage", THROWABLE_MESSAGE, null, null));
            }
            ((Schema)localObject1).setFields((List)localObject4);
            paramType = (Type)localObject1;
          }
        }
      }
    }
    return super.createSchema(paramType, paramMap);
  }
  
  public Class getClass(Schema paramSchema)
  {
    switch (paramSchema.getType())
    {
    }
    Object localObject;
    do
    {
      localObject = super.getClass(paramSchema);
      Class localClass;
      do
      {
        return (Class)localObject;
        localClass = getClassProp(paramSchema, "java-class");
        localObject = localClass;
      } while (localClass != null);
      return Array.newInstance(getClass(paramSchema.getElementType()), 0).getClass();
      return String.class;
      return BYTES_CLASS;
      localObject = paramSchema.getProp("java-class");
      if (Byte.class.getName().equals(localObject)) {
        return Byte.TYPE;
      }
    } while (!Short.class.getName().equals(localObject));
    return Short.TYPE;
  }
  
  public Object getField(Object paramObject, String paramString, int paramInt)
  {
    if ((paramObject instanceof IndexedRecord)) {
      return super.getField(paramObject, paramString, paramInt);
    }
    try
    {
      paramObject = getField(paramObject.getClass(), paramString).get(paramObject);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new AvroRuntimeException((Throwable)paramObject);
    }
  }
  
  public Protocol getProtocol(Class paramClass)
  {
    Object localObject2 = paramClass.getSimpleName();
    Object localObject1;
    Map localMap;
    int j;
    int i;
    if (paramClass.getPackage() == null)
    {
      localObject1 = "";
      localObject1 = new Protocol((String)localObject2, (String)localObject1);
      localObject2 = new LinkedHashMap();
      localMap = ((Protocol)localObject1).getMessages();
      paramClass = paramClass.getMethods();
      j = paramClass.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label165;
      }
      Method localMethod = paramClass[i];
      if ((localMethod.getModifiers() & 0x8) == 0)
      {
        String str = localMethod.getName();
        if (localMap.containsKey(str))
        {
          throw new AvroTypeException("Two methods with same name: " + str);
          localObject1 = paramClass.getPackage().getName();
          break;
        }
        localMap.put(str, getMessage(localMethod, (Protocol)localObject1, (Map)localObject2));
      }
      i += 1;
    }
    label165:
    paramClass = new ArrayList();
    paramClass.addAll(((Map)localObject2).values());
    Collections.reverse(paramClass);
    ((Protocol)localObject1).setTypes(paramClass);
    return (Protocol)localObject1;
  }
  
  protected Schema getRecordSchema(Object paramObject)
  {
    if ((paramObject instanceof GenericContainer)) {
      return super.getRecordSchema(paramObject);
    }
    return getSchema(paramObject.getClass());
  }
  
  protected boolean isArray(Object paramObject)
  {
    if (paramObject == null) {}
    while ((!(paramObject instanceof Collection)) && (!paramObject.getClass().isArray())) {
      return false;
    }
    return true;
  }
  
  protected boolean isBytes(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramObject == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (super.isBytes(paramObject));
      paramObject = paramObject.getClass();
      if (!((Class)paramObject).isArray()) {
        break;
      }
      bool1 = bool2;
    } while (((Class)paramObject).getComponentType() == Byte.TYPE);
    return false;
  }
  
  protected boolean isRecord(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (super.isRecord(paramObject)) {
        return true;
      }
    } while ((paramObject instanceof Collection));
    if (getSchema(paramObject.getClass()).getType() == Schema.Type.RECORD) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void setField(Object paramObject1, String paramString, int paramInt, Object paramObject2)
  {
    if ((paramObject1 instanceof IndexedRecord))
    {
      super.setField(paramObject1, paramString, paramInt, paramObject2);
      return;
    }
    try
    {
      getField(paramObject1.getClass(), paramString).set(paramObject1, paramObject2);
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      throw new AvroRuntimeException((Throwable)paramObject1);
    }
  }
  
  public boolean validate(Schema paramSchema, Object paramObject)
  {
    switch (paramSchema.getType())
    {
    default: 
      return super.validate(paramSchema, paramObject);
    }
    if (!paramObject.getClass().isArray()) {
      return super.validate(paramSchema, paramObject);
    }
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      if (!validate(paramSchema.getElementType(), Array.get(paramObject, i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static class AllowNull
    extends ReflectData
  {
    private static final AllowNull INSTANCE = new AllowNull();
    
    public static AllowNull get()
    {
      return INSTANCE;
    }
    
    protected Schema createFieldSchema(Field paramField, Map<String, Schema> paramMap)
    {
      return makeNullable(super.createFieldSchema(paramField, paramMap));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/reflect/ReflectData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */