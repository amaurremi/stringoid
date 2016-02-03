package com.flurry.org.apache.avro.generic;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Field;
import com.flurry.org.apache.avro.Schema.Field.Order;
import com.flurry.org.apache.avro.Schema.Type;
import com.flurry.org.apache.avro.UnresolvedUnionException;
import com.flurry.org.apache.avro.io.BinaryData;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.util.Utf8;
import java.nio.ByteBuffer;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GenericData
{
  private static final GenericData INSTANCE = new GenericData();
  private static final Schema STRINGS = Schema.create(Schema.Type.STRING);
  protected static final String STRING_PROP = "avro.java.string";
  protected static final String STRING_TYPE_STRING = "String";
  
  public static GenericData get()
  {
    return INSTANCE;
  }
  
  public static void setStringType(Schema paramSchema, StringType paramStringType)
  {
    if (paramStringType == StringType.String) {
      paramSchema.addProp("avro.java.string", "String");
    }
  }
  
  private void writeEscapedString(String paramString, StringBuilder paramStringBuilder)
  {
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      int j;
      switch (c)
      {
      default: 
        if (((c >= 0) && (c <= '\037')) || ((c >= '') && (c <= '')) || ((c >= ' ') && (c <= '⃿')))
        {
          Integer.toHexString(c);
          paramStringBuilder.append("\\u");
          j = 0;
        }
        break;
      case '"': 
        while (j < 4 - paramStringBuilder.length())
        {
          paramStringBuilder.append('0');
          j += 1;
          continue;
          paramStringBuilder.append("\\\"");
        }
      }
      for (;;)
      {
        i += 1;
        break;
        paramStringBuilder.append("\\\\");
        continue;
        paramStringBuilder.append("\\b");
        continue;
        paramStringBuilder.append("\\f");
        continue;
        paramStringBuilder.append("\\n");
        continue;
        paramStringBuilder.append("\\r");
        continue;
        paramStringBuilder.append("\\t");
        continue;
        paramStringBuilder.append("\\/");
        continue;
        paramStringBuilder.append(paramString.toUpperCase());
        continue;
        paramStringBuilder.append(c);
      }
    }
  }
  
  public int compare(Object paramObject1, Object paramObject2, Schema paramSchema)
  {
    return compare(paramObject1, paramObject2, paramSchema, false);
  }
  
  protected int compare(Object paramObject1, Object paramObject2, Schema paramSchema, boolean paramBoolean)
  {
    if (paramObject1 == paramObject2) {
      return 0;
    }
    int i;
    int j;
    switch (paramSchema.getType())
    {
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    default: 
      return ((Comparable)paramObject1).compareTo(paramObject2);
    case ???: 
      paramSchema = paramSchema.getFields().iterator();
      while (paramSchema.hasNext())
      {
        Schema.Field localField = (Schema.Field)paramSchema.next();
        if (localField.order() != Schema.Field.Order.IGNORE)
        {
          i = localField.pos();
          String str = localField.name();
          j = compare(getField(paramObject1, str, i), getField(paramObject2, str, i), localField.schema(), paramBoolean);
          if (j != 0)
          {
            i = j;
            if (localField.order() == Schema.Field.Order.DESCENDING) {
              i = -j;
            }
            return i;
          }
        }
      }
      return 0;
    case ???: 
      return paramSchema.getEnumOrdinal(paramObject1.toString()) - paramSchema.getEnumOrdinal(paramObject2.toString());
    case ???: 
      paramObject1 = (Collection)paramObject1;
      paramObject2 = (Collection)paramObject2;
      paramObject1 = ((Collection)paramObject1).iterator();
      paramObject2 = ((Collection)paramObject2).iterator();
      paramSchema = paramSchema.getElementType();
      while ((((Iterator)paramObject1).hasNext()) && (((Iterator)paramObject2).hasNext()))
      {
        i = compare(((Iterator)paramObject1).next(), ((Iterator)paramObject2).next(), paramSchema, paramBoolean);
        if (i != 0) {
          return i;
        }
      }
      if (((Iterator)paramObject1).hasNext()) {
        return 1;
      }
      if (((Iterator)paramObject2).hasNext()) {
        return -1;
      }
      return 0;
    case ???: 
      if (paramBoolean)
      {
        if (((Map)paramObject1).equals(paramObject2)) {
          return 0;
        }
        return 1;
      }
      throw new AvroRuntimeException("Can't compare maps!");
    case ???: 
      i = resolveUnion(paramSchema, paramObject1);
      j = resolveUnion(paramSchema, paramObject2);
      if (i == j) {
        return compare(paramObject1, paramObject2, (Schema)paramSchema.getTypes().get(i), paramBoolean);
      }
      return i - j;
    case ???: 
      return 0;
    }
    if ((paramObject1 instanceof Utf8))
    {
      paramObject1 = (Utf8)paramObject1;
      if (!(paramObject2 instanceof Utf8)) {
        break label464;
      }
    }
    label464:
    for (paramObject2 = (Utf8)paramObject2;; paramObject2 = new Utf8(paramObject2.toString()))
    {
      return ((Utf8)paramObject1).compareTo((Utf8)paramObject2);
      paramObject1 = new Utf8(paramObject1.toString());
      break;
    }
  }
  
  public DatumReader createDatumReader(Schema paramSchema)
  {
    return new GenericDatumReader(paramSchema, paramSchema, this);
  }
  
  public Object createFixed(Object paramObject, Schema paramSchema)
  {
    if (((paramObject instanceof GenericFixed)) && (((GenericFixed)paramObject).bytes().length == paramSchema.getFixedSize())) {
      return paramObject;
    }
    return new Fixed(paramSchema);
  }
  
  public Object createFixed(Object paramObject, byte[] paramArrayOfByte, Schema paramSchema)
  {
    paramObject = (GenericFixed)createFixed(paramObject, paramSchema);
    System.arraycopy(paramArrayOfByte, 0, ((GenericFixed)paramObject).bytes(), 0, paramSchema.getFixedSize());
    return paramObject;
  }
  
  public Object deepCopy(Schema paramSchema, Object paramObject)
  {
    Object localObject1;
    if (paramObject == null) {
      localObject1 = null;
    }
    do
    {
      return localObject1;
      localObject1 = paramObject;
      Object localObject2;
      switch (paramSchema.getType())
      {
      case ???: 
      default: 
        throw new AvroRuntimeException("Deep copy failed for schema \"" + paramSchema + "\" and value \"" + paramObject + "\"");
      case ???: 
        localObject1 = (List)paramObject;
        paramObject = new Array(((List)localObject1).size(), paramSchema);
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          ((List)paramObject).add(deepCopy(paramSchema.getElementType(), localObject2));
        }
        return paramObject;
      case ???: 
        return new Boolean(((Boolean)paramObject).booleanValue());
      case ???: 
        paramSchema = (ByteBuffer)paramObject;
        paramObject = new byte[paramSchema.capacity()];
        paramSchema.rewind();
        paramSchema.get((byte[])paramObject);
        paramSchema.rewind();
        return ByteBuffer.wrap((byte[])paramObject);
      case ???: 
        return new Double(((Double)paramObject).doubleValue());
      case ???: 
        return createFixed(null, ((GenericFixed)paramObject).bytes(), paramSchema);
      case ???: 
        return new Float(((Float)paramObject).floatValue());
      case ???: 
        return new Integer(((Integer)paramObject).intValue());
      case ???: 
        return new Long(((Long)paramObject).longValue());
      case ???: 
        localObject1 = (Map)paramObject;
        paramObject = new HashMap(((Map)localObject1).size());
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          ((Map)paramObject).put((CharSequence)deepCopy(STRINGS, ((Map.Entry)localObject2).getKey()), deepCopy(paramSchema.getValueType(), ((Map.Entry)localObject2).getValue()));
        }
        return paramObject;
      case ???: 
        return null;
      case ???: 
        paramObject = (IndexedRecord)paramObject;
        localObject1 = (IndexedRecord)newRecord(null, paramSchema);
        paramSchema = paramSchema.getFields().iterator();
        while (paramSchema.hasNext())
        {
          localObject2 = (Schema.Field)paramSchema.next();
          ((IndexedRecord)localObject1).put(((Schema.Field)localObject2).pos(), deepCopy(((Schema.Field)localObject2).schema(), ((IndexedRecord)paramObject).get(((Schema.Field)localObject2).pos())));
        }
        return localObject1;
      case ???: 
        localObject1 = paramObject;
      }
    } while ((paramObject instanceof String));
    if ((paramObject instanceof Utf8)) {
      return new Utf8((Utf8)paramObject);
    }
    return new Utf8(paramObject.toString());
    return deepCopy((Schema)paramSchema.getTypes().get(resolveUnion(paramSchema, paramObject)), paramObject);
  }
  
  protected Schema getEnumSchema(Object paramObject)
  {
    return ((GenericContainer)paramObject).getSchema();
  }
  
  public Object getField(Object paramObject, String paramString, int paramInt)
  {
    return ((IndexedRecord)paramObject).get(paramInt);
  }
  
  protected Object getField(Object paramObject1, String paramString, int paramInt, Object paramObject2)
  {
    return getField(paramObject1, paramString, paramInt);
  }
  
  protected Schema getFixedSchema(Object paramObject)
  {
    return ((GenericContainer)paramObject).getSchema();
  }
  
  protected Schema getRecordSchema(Object paramObject)
  {
    return ((GenericContainer)paramObject).getSchema();
  }
  
  protected Object getRecordState(Object paramObject, Schema paramSchema)
  {
    return null;
  }
  
  protected String getSchemaName(Object paramObject)
  {
    if (paramObject == null) {
      return Schema.Type.NULL.getName();
    }
    if (isRecord(paramObject)) {
      return getRecordSchema(paramObject).getFullName();
    }
    if (isEnum(paramObject)) {
      return getEnumSchema(paramObject).getFullName();
    }
    if (isArray(paramObject)) {
      return Schema.Type.ARRAY.getName();
    }
    if (isMap(paramObject)) {
      return Schema.Type.MAP.getName();
    }
    if (isFixed(paramObject)) {
      return getFixedSchema(paramObject).getFullName();
    }
    if (isString(paramObject)) {
      return Schema.Type.STRING.getName();
    }
    if (isBytes(paramObject)) {
      return Schema.Type.BYTES.getName();
    }
    if ((paramObject instanceof Integer)) {
      return Schema.Type.INT.getName();
    }
    if ((paramObject instanceof Long)) {
      return Schema.Type.LONG.getName();
    }
    if ((paramObject instanceof Float)) {
      return Schema.Type.FLOAT.getName();
    }
    if ((paramObject instanceof Double)) {
      return Schema.Type.DOUBLE.getName();
    }
    if ((paramObject instanceof Boolean)) {
      return Schema.Type.BOOLEAN.getName();
    }
    throw new AvroRuntimeException("Unknown datum type: " + paramObject);
  }
  
  public int hashCode(Object paramObject, Schema paramSchema)
  {
    if (paramObject == null)
    {
      i = 0;
      return i;
    }
    int i = 1;
    int j = 1;
    switch (paramSchema.getType())
    {
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
    default: 
      return paramObject.hashCode();
    case ???: 
      paramSchema = paramSchema.getFields().iterator();
      for (;;)
      {
        i = j;
        if (!paramSchema.hasNext()) {
          break;
        }
        Schema.Field localField = (Schema.Field)paramSchema.next();
        if (localField.order() != Schema.Field.Order.IGNORE) {
          j = hashCodeAdd(j, getField(paramObject, localField.name(), localField.pos()), localField.schema());
        }
      }
    case ???: 
      paramObject = (Collection)paramObject;
      paramSchema = paramSchema.getElementType();
      paramObject = ((Collection)paramObject).iterator();
      for (j = i;; j = hashCodeAdd(j, ((Iterator)paramObject).next(), paramSchema))
      {
        i = j;
        if (!((Iterator)paramObject).hasNext()) {
          break;
        }
      }
    case ???: 
      return hashCode(paramObject, (Schema)paramSchema.getTypes().get(resolveUnion(paramSchema, paramObject)));
    case ???: 
      return paramSchema.getEnumOrdinal(paramObject.toString());
    case ???: 
      return 0;
    }
    if ((paramObject instanceof Utf8)) {}
    for (;;)
    {
      return paramObject.hashCode();
      paramObject = new Utf8(paramObject.toString());
    }
  }
  
  protected int hashCodeAdd(int paramInt, Object paramObject, Schema paramSchema)
  {
    return paramInt * 31 + hashCode(paramObject, paramSchema);
  }
  
  public Schema induce(Object paramObject)
  {
    if (isRecord(paramObject)) {
      return getRecordSchema(paramObject);
    }
    Schema localSchema;
    Object localObject1;
    Object localObject2;
    if ((paramObject instanceof Collection))
    {
      localSchema = null;
      localObject1 = ((Collection)paramObject).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (localSchema == null) {
          localSchema = induce(localObject2);
        } else if (!localSchema.equals(induce(localObject2))) {
          throw new AvroTypeException("No mixed type arrays.");
        }
      }
      if (localSchema == null) {
        throw new AvroTypeException("Empty array: " + paramObject);
      }
      return Schema.createArray(localSchema);
    }
    if ((paramObject instanceof Map))
    {
      localObject1 = (Map)paramObject;
      localSchema = null;
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (localSchema == null) {
          localSchema = induce(((Map.Entry)localObject2).getValue());
        } else if (!localSchema.equals(induce(((Map.Entry)localObject2).getValue()))) {
          throw new AvroTypeException("No mixed type map values.");
        }
      }
      if (localSchema == null) {
        throw new AvroTypeException("Empty map: " + paramObject);
      }
      return Schema.createMap(localSchema);
    }
    if ((paramObject instanceof GenericFixed)) {
      return Schema.createFixed(null, null, null, ((GenericFixed)paramObject).bytes().length);
    }
    if ((paramObject instanceof CharSequence)) {
      return Schema.create(Schema.Type.STRING);
    }
    if ((paramObject instanceof ByteBuffer)) {
      return Schema.create(Schema.Type.BYTES);
    }
    if ((paramObject instanceof Integer)) {
      return Schema.create(Schema.Type.INT);
    }
    if ((paramObject instanceof Long)) {
      return Schema.create(Schema.Type.LONG);
    }
    if ((paramObject instanceof Float)) {
      return Schema.create(Schema.Type.FLOAT);
    }
    if ((paramObject instanceof Double)) {
      return Schema.create(Schema.Type.DOUBLE);
    }
    if ((paramObject instanceof Boolean)) {
      return Schema.create(Schema.Type.BOOLEAN);
    }
    if (paramObject == null) {
      return Schema.create(Schema.Type.NULL);
    }
    throw new AvroTypeException("Can't create schema for: " + paramObject);
  }
  
  protected boolean instanceOf(Schema paramSchema, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramSchema.getType())
    {
    case ???: 
    default: 
      throw new AvroRuntimeException("Unexpected type: " + paramSchema);
    case ???: 
      if (isRecord(paramObject)) {
        break;
      }
    case ???: 
    case ???: 
    case ???: 
    case ???: 
      do
      {
        do
        {
          return false;
          if (paramSchema.getFullName() == null) {
            if (getRecordSchema(paramObject).getFullName() != null) {}
          }
          for (;;)
          {
            return bool1;
            bool1 = false;
            continue;
            bool1 = paramSchema.getFullName().equals(getRecordSchema(paramObject).getFullName());
          }
        } while (!isEnum(paramObject));
        return paramSchema.getFullName().equals(getEnumSchema(paramObject).getFullName());
        return isArray(paramObject);
        return isMap(paramObject);
      } while (!isFixed(paramObject));
      return paramSchema.getFullName().equals(getFixedSchema(paramObject).getFullName());
    case ???: 
      return isString(paramObject);
    case ???: 
      return isBytes(paramObject);
    case ???: 
      return paramObject instanceof Integer;
    case ???: 
      return paramObject instanceof Long;
    case ???: 
      return paramObject instanceof Float;
    case ???: 
      return paramObject instanceof Double;
    case ???: 
      return paramObject instanceof Boolean;
    }
    if (paramObject == null) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  protected boolean isArray(Object paramObject)
  {
    return paramObject instanceof Collection;
  }
  
  protected boolean isBytes(Object paramObject)
  {
    return paramObject instanceof ByteBuffer;
  }
  
  protected boolean isEnum(Object paramObject)
  {
    return paramObject instanceof GenericEnumSymbol;
  }
  
  protected boolean isFixed(Object paramObject)
  {
    return paramObject instanceof GenericFixed;
  }
  
  protected boolean isMap(Object paramObject)
  {
    return paramObject instanceof Map;
  }
  
  protected boolean isRecord(Object paramObject)
  {
    return paramObject instanceof IndexedRecord;
  }
  
  protected boolean isString(Object paramObject)
  {
    return paramObject instanceof CharSequence;
  }
  
  public Object newRecord(Object paramObject, Schema paramSchema)
  {
    if ((paramObject instanceof IndexedRecord))
    {
      paramObject = (IndexedRecord)paramObject;
      if (((IndexedRecord)paramObject).getSchema() == paramSchema) {
        return paramObject;
      }
    }
    return new Record(paramSchema);
  }
  
  public int resolveUnion(Schema paramSchema, Object paramObject)
  {
    Integer localInteger = paramSchema.getIndexNamed(getSchemaName(paramObject));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new UnresolvedUnionException(paramSchema, paramObject);
  }
  
  public void setField(Object paramObject1, String paramString, int paramInt, Object paramObject2)
  {
    ((IndexedRecord)paramObject1).put(paramInt, paramObject2);
  }
  
  protected void setField(Object paramObject1, String paramString, int paramInt, Object paramObject2, Object paramObject3)
  {
    setField(paramObject1, paramString, paramInt, paramObject2);
  }
  
  public String toString(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    toString(paramObject, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  protected void toString(Object paramObject, StringBuilder paramStringBuilder)
  {
    int i;
    Object localObject1;
    Object localObject2;
    int j;
    if (isRecord(paramObject))
    {
      paramStringBuilder.append("{");
      i = 0;
      localObject1 = getRecordSchema(paramObject);
      localObject2 = ((Schema)localObject1).getFields().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Schema.Field localField = (Schema.Field)((Iterator)localObject2).next();
        toString(localField.name(), paramStringBuilder);
        paramStringBuilder.append(": ");
        toString(getField(paramObject, localField.name(), localField.pos()), paramStringBuilder);
        j = i + 1;
        i = j;
        if (j < ((Schema)localObject1).getFields().size())
        {
          paramStringBuilder.append(", ");
          i = j;
        }
      }
      paramStringBuilder.append("}");
      return;
    }
    if ((paramObject instanceof Collection))
    {
      paramObject = (Collection)paramObject;
      paramStringBuilder.append("[");
      long l = ((Collection)paramObject).size() - 1;
      i = 0;
      paramObject = ((Collection)paramObject).iterator();
      while (((Iterator)paramObject).hasNext())
      {
        toString(((Iterator)paramObject).next(), paramStringBuilder);
        if (i < l) {
          paramStringBuilder.append(", ");
        }
        i += 1;
      }
      paramStringBuilder.append("]");
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramStringBuilder.append("{");
      i = 0;
      paramObject = (Map)paramObject;
      localObject1 = ((Map)paramObject).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        toString(((Map.Entry)localObject2).getKey(), paramStringBuilder);
        paramStringBuilder.append(": ");
        toString(((Map.Entry)localObject2).getValue(), paramStringBuilder);
        j = i + 1;
        i = j;
        if (j < ((Map)paramObject).size())
        {
          paramStringBuilder.append(", ");
          i = j;
        }
      }
      paramStringBuilder.append("}");
      return;
    }
    if (((paramObject instanceof CharSequence)) || ((paramObject instanceof GenericEnumSymbol)))
    {
      paramStringBuilder.append("\"");
      writeEscapedString(paramObject.toString(), paramStringBuilder);
      paramStringBuilder.append("\"");
      return;
    }
    if ((paramObject instanceof ByteBuffer))
    {
      paramStringBuilder.append("{\"bytes\": \"");
      paramObject = (ByteBuffer)paramObject;
      i = ((ByteBuffer)paramObject).position();
      while (i < ((ByteBuffer)paramObject).limit())
      {
        paramStringBuilder.append((char)((ByteBuffer)paramObject).get(i));
        i += 1;
      }
      paramStringBuilder.append("\"}");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  public boolean validate(Schema paramSchema, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramSchema.getType())
    {
    default: 
    case ???: 
    case ???: 
    case ???: 
    case ???: 
      Object localObject;
      do
      {
        do
        {
          do
          {
            return false;
          } while (!isRecord(paramObject));
          paramSchema = paramSchema.getFields().iterator();
          while (paramSchema.hasNext())
          {
            localObject = (Schema.Field)paramSchema.next();
            if (!validate(((Schema.Field)localObject).schema(), getField(paramObject, ((Schema.Field)localObject).name(), ((Schema.Field)localObject).pos()))) {
              return false;
            }
          }
          return true;
          return paramSchema.getEnumSymbols().contains(paramObject.toString());
        } while (!(paramObject instanceof Collection));
        paramObject = ((Collection)paramObject).iterator();
        while (((Iterator)paramObject).hasNext())
        {
          localObject = ((Iterator)paramObject).next();
          if (!validate(paramSchema.getElementType(), localObject)) {
            return false;
          }
        }
        return true;
      } while (!(paramObject instanceof Map));
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (((Iterator)paramObject).hasNext())
      {
        localObject = (Map.Entry)((Iterator)paramObject).next();
        if (!validate(paramSchema.getValueType(), ((Map.Entry)localObject).getValue())) {
          return false;
        }
      }
      return true;
    case ???: 
      paramSchema = paramSchema.getTypes().iterator();
      do
      {
        if (!paramSchema.hasNext()) {
          break;
        }
      } while (!validate((Schema)paramSchema.next(), paramObject));
      return true;
    case ???: 
      if (((paramObject instanceof GenericFixed)) && (((GenericFixed)paramObject).bytes().length == paramSchema.getFixedSize())) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
    case ???: 
      return isString(paramObject);
    case ???: 
      return isBytes(paramObject);
    case ???: 
      return paramObject instanceof Integer;
    case ???: 
      return paramObject instanceof Long;
    case ???: 
      return paramObject instanceof Float;
    case ???: 
      return paramObject instanceof Double;
    case ???: 
      return paramObject instanceof Boolean;
    }
    if (paramObject == null) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static class Array<T>
    extends AbstractList<T>
    implements GenericArray<T>, Comparable<GenericArray<T>>
  {
    private static final Object[] EMPTY = new Object[0];
    private Object[] elements = EMPTY;
    private final Schema schema;
    private int size;
    
    public Array(int paramInt, Schema paramSchema)
    {
      if ((paramSchema == null) || (!Schema.Type.ARRAY.equals(paramSchema.getType()))) {
        throw new AvroRuntimeException("Not an array schema: " + paramSchema);
      }
      this.schema = paramSchema;
      if (paramInt != 0) {
        this.elements = new Object[paramInt];
      }
    }
    
    public Array(Schema paramSchema, Collection<T> paramCollection)
    {
      if ((paramSchema == null) || (!Schema.Type.ARRAY.equals(paramSchema.getType()))) {
        throw new AvroRuntimeException("Not an array schema: " + paramSchema);
      }
      this.schema = paramSchema;
      if (paramCollection != null)
      {
        this.elements = new Object[paramCollection.size()];
        addAll(paramCollection);
      }
    }
    
    public void add(int paramInt, T paramT)
    {
      if ((paramInt > this.size) || (paramInt < 0)) {
        throw new IndexOutOfBoundsException("Index " + paramInt + " out of bounds.");
      }
      if (this.size == this.elements.length)
      {
        Object[] arrayOfObject = new Object[this.size * 3 / 2 + 1];
        System.arraycopy(this.elements, 0, arrayOfObject, 0, this.size);
        this.elements = arrayOfObject;
      }
      System.arraycopy(this.elements, paramInt, this.elements, paramInt + 1, this.size - paramInt);
      this.elements[paramInt] = paramT;
      this.size += 1;
    }
    
    public boolean add(T paramT)
    {
      if (this.size == this.elements.length)
      {
        arrayOfObject = new Object[this.size * 3 / 2 + 1];
        System.arraycopy(this.elements, 0, arrayOfObject, 0, this.size);
        this.elements = arrayOfObject;
      }
      Object[] arrayOfObject = this.elements;
      int i = this.size;
      this.size = (i + 1);
      arrayOfObject[i] = paramT;
      return true;
    }
    
    public void clear()
    {
      this.size = 0;
    }
    
    public int compareTo(GenericArray<T> paramGenericArray)
    {
      return GenericData.get().compare(this, paramGenericArray, getSchema());
    }
    
    public T get(int paramInt)
    {
      if (paramInt >= this.size) {
        throw new IndexOutOfBoundsException("Index " + paramInt + " out of bounds.");
      }
      return (T)this.elements[paramInt];
    }
    
    public Schema getSchema()
    {
      return this.schema;
    }
    
    public Iterator<T> iterator()
    {
      new Iterator()
      {
        private int position = 0;
        
        public boolean hasNext()
        {
          return this.position < GenericData.Array.this.size;
        }
        
        public T next()
        {
          Object[] arrayOfObject = GenericData.Array.this.elements;
          int i = this.position;
          this.position = (i + 1);
          return (T)arrayOfObject[i];
        }
        
        public void remove()
        {
          throw new UnsupportedOperationException();
        }
      };
    }
    
    public T peek()
    {
      if (this.size < this.elements.length) {
        return (T)this.elements[this.size];
      }
      return null;
    }
    
    public T remove(int paramInt)
    {
      if (paramInt >= this.size) {
        throw new IndexOutOfBoundsException("Index " + paramInt + " out of bounds.");
      }
      Object localObject = this.elements[paramInt];
      this.size -= 1;
      System.arraycopy(this.elements, paramInt + 1, this.elements, paramInt, this.size - paramInt);
      this.elements[this.size] = null;
      return (T)localObject;
    }
    
    public void reverse()
    {
      int j = 0;
      int i = this.elements.length - 1;
      while (j < i)
      {
        Object localObject = this.elements[j];
        this.elements[j] = this.elements[i];
        this.elements[i] = localObject;
        j += 1;
        i -= 1;
      }
    }
    
    public T set(int paramInt, T paramT)
    {
      if (paramInt >= this.size) {
        throw new IndexOutOfBoundsException("Index " + paramInt + " out of bounds.");
      }
      Object localObject = this.elements[paramInt];
      this.elements[paramInt] = paramT;
      return (T)localObject;
    }
    
    public int size()
    {
      return this.size;
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("[");
      int i = 0;
      Iterator localIterator = iterator();
      if (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (localObject == null) {}
        for (localObject = "null";; localObject = localObject.toString())
        {
          localStringBuffer.append((String)localObject);
          int j = i + 1;
          i = j;
          if (j >= size()) {
            break;
          }
          localStringBuffer.append(", ");
          i = j;
          break;
        }
      }
      localStringBuffer.append("]");
      return localStringBuffer.toString();
    }
  }
  
  public static class EnumSymbol
    implements GenericEnumSymbol
  {
    private Schema schema;
    private String symbol;
    
    public EnumSymbol(Schema paramSchema, String paramString)
    {
      this.schema = paramSchema;
      this.symbol = paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      while (((paramObject instanceof GenericEnumSymbol)) && (this.symbol.equals(paramObject.toString()))) {
        return true;
      }
      return false;
    }
    
    public Schema getSchema()
    {
      return this.schema;
    }
    
    public int hashCode()
    {
      return this.symbol.hashCode();
    }
    
    public String toString()
    {
      return this.symbol;
    }
  }
  
  public static class Fixed
    implements GenericFixed, Comparable<Fixed>
  {
    private byte[] bytes;
    private Schema schema;
    
    protected Fixed() {}
    
    public Fixed(Schema paramSchema)
    {
      setSchema(paramSchema);
    }
    
    public Fixed(Schema paramSchema, byte[] paramArrayOfByte)
    {
      this.schema = paramSchema;
      this.bytes = paramArrayOfByte;
    }
    
    public void bytes(byte[] paramArrayOfByte)
    {
      this.bytes = paramArrayOfByte;
    }
    
    public byte[] bytes()
    {
      return this.bytes;
    }
    
    public int compareTo(Fixed paramFixed)
    {
      return BinaryData.compareBytes(this.bytes, 0, this.bytes.length, paramFixed.bytes, 0, paramFixed.bytes.length);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      while (((paramObject instanceof GenericFixed)) && (Arrays.equals(this.bytes, ((GenericFixed)paramObject).bytes()))) {
        return true;
      }
      return false;
    }
    
    public Schema getSchema()
    {
      return this.schema;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(this.bytes);
    }
    
    protected void setSchema(Schema paramSchema)
    {
      this.schema = paramSchema;
      this.bytes = new byte[paramSchema.getFixedSize()];
    }
    
    public String toString()
    {
      return Arrays.toString(this.bytes);
    }
  }
  
  public static class Record
    implements GenericRecord, Comparable<Record>
  {
    private final Schema schema;
    private final Object[] values;
    
    public Record(Schema paramSchema)
    {
      if ((paramSchema == null) || (!Schema.Type.RECORD.equals(paramSchema.getType()))) {
        throw new AvroRuntimeException("Not a record schema: " + paramSchema);
      }
      this.schema = paramSchema;
      this.values = new Object[paramSchema.getFields().size()];
    }
    
    public Record(Record paramRecord, boolean paramBoolean)
    {
      this.schema = paramRecord.schema;
      this.values = new Object[this.schema.getFields().size()];
      if (paramBoolean)
      {
        int i = 0;
        while (i < this.values.length)
        {
          this.values[i] = GenericData.INSTANCE.deepCopy(((Schema.Field)this.schema.getFields().get(i)).schema(), paramRecord.values[i]);
          i += 1;
        }
      }
      System.arraycopy(paramRecord.values, 0, this.values, 0, paramRecord.values.length);
    }
    
    public int compareTo(Record paramRecord)
    {
      return GenericData.get().compare(this, paramRecord, this.schema);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof Record)) {
          return false;
        }
        paramObject = (Record)paramObject;
        if (!this.schema.getFullName().equals(((Record)paramObject).schema.getFullName())) {
          return false;
        }
      } while (GenericData.get().compare(this, paramObject, this.schema, true) == 0);
      return false;
    }
    
    public Object get(int paramInt)
    {
      return this.values[paramInt];
    }
    
    public Object get(String paramString)
    {
      paramString = this.schema.getField(paramString);
      if (paramString == null) {
        return null;
      }
      return this.values[paramString.pos()];
    }
    
    public Schema getSchema()
    {
      return this.schema;
    }
    
    public int hashCode()
    {
      return GenericData.get().hashCode(this, this.schema);
    }
    
    public void put(int paramInt, Object paramObject)
    {
      this.values[paramInt] = paramObject;
    }
    
    public void put(String paramString, Object paramObject)
    {
      Schema.Field localField = this.schema.getField(paramString);
      if (localField == null) {
        throw new AvroRuntimeException("Not a valid schema field: " + paramString);
      }
      this.values[localField.pos()] = paramObject;
    }
    
    public String toString()
    {
      return GenericData.get().toString(this);
    }
  }
  
  public static enum StringType
  {
    CharSequence,  String,  Utf8;
    
    private StringType() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/generic/GenericData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */