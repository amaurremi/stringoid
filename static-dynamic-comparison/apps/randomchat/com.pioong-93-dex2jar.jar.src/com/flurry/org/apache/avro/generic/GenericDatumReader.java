package com.flurry.org.apache.avro.generic;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Field;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.io.Decoder;
import com.flurry.org.apache.avro.io.DecoderFactory;
import com.flurry.org.apache.avro.io.ResolvingDecoder;
import com.flurry.org.apache.avro.util.Utf8;
import com.flurry.org.apache.avro.util.WeakIdentityHashMap;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GenericDatumReader<D>
  implements DatumReader<D>
{
  private static final ThreadLocal<Map<Schema, Map<Schema, ResolvingDecoder>>> RESOLVER_CACHE = new ThreadLocal()
  {
    protected Map<Schema, Map<Schema, ResolvingDecoder>> initialValue()
    {
      return new WeakIdentityHashMap();
    }
  };
  private Schema actual;
  private final Thread creator;
  private ResolvingDecoder creatorResolver = null;
  private final GenericData data;
  private Schema expected;
  
  public GenericDatumReader()
  {
    this(null, null, GenericData.get());
  }
  
  public GenericDatumReader(Schema paramSchema)
  {
    this(paramSchema, paramSchema, GenericData.get());
  }
  
  public GenericDatumReader(Schema paramSchema1, Schema paramSchema2)
  {
    this(paramSchema1, paramSchema2, GenericData.get());
  }
  
  protected GenericDatumReader(Schema paramSchema1, Schema paramSchema2, GenericData paramGenericData)
  {
    this.actual = paramSchema1;
    this.expected = paramSchema2;
    this.data = paramGenericData;
    this.creator = Thread.currentThread();
  }
  
  public static void skip(Schema paramSchema, Decoder paramDecoder)
    throws IOException
  {
    long l1;
    long l2;
    switch (paramSchema.getType())
    {
    default: 
      throw new RuntimeException("Unknown type: " + paramSchema);
    case ???: 
      paramSchema = paramSchema.getFields().iterator();
    case ???: 
      while (paramSchema.hasNext())
      {
        skip(((Schema.Field)paramSchema.next()).schema(), paramDecoder);
        continue;
        paramDecoder.readInt();
      }
    case ???: 
      return;
    case ???: 
      paramSchema = paramSchema.getElementType();
      for (l1 = paramDecoder.skipArray(); l1 > 0L; l1 = paramDecoder.skipArray()) {
        for (l2 = 0L; l2 < l1; l2 += 1L) {
          skip(paramSchema, paramDecoder);
        }
      }
    case ???: 
      paramSchema = paramSchema.getValueType();
      for (l1 = paramDecoder.skipMap(); l1 > 0L; l1 = paramDecoder.skipMap()) {
        for (l2 = 0L; l2 < l1; l2 += 1L)
        {
          paramDecoder.skipString();
          skip(paramSchema, paramDecoder);
        }
      }
    case ???: 
      skip((Schema)paramSchema.getTypes().get(paramDecoder.readIndex()), paramDecoder);
      return;
    case ???: 
      paramDecoder.skipFixed(paramSchema.getFixedSize());
      return;
    case ???: 
      paramDecoder.skipString();
      return;
    case ???: 
      paramDecoder.skipBytes();
      return;
    case ???: 
      paramDecoder.readInt();
      return;
    case ???: 
      paramDecoder.readLong();
      return;
    case ???: 
      paramDecoder.readFloat();
      return;
    case ???: 
      paramDecoder.readDouble();
      return;
    }
    paramDecoder.readBoolean();
  }
  
  protected void addToArray(Object paramObject1, long paramLong, Object paramObject2)
  {
    ((Collection)paramObject1).add(paramObject2);
  }
  
  protected void addToMap(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    ((Map)paramObject1).put(paramObject2, paramObject3);
  }
  
  protected Object createBytes(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte);
  }
  
  protected Object createEnum(String paramString, Schema paramSchema)
  {
    return new GenericData.EnumSymbol(paramSchema, paramString);
  }
  
  @Deprecated
  protected Object createFixed(Object paramObject, Schema paramSchema)
  {
    return this.data.createFixed(paramObject, paramSchema);
  }
  
  @Deprecated
  protected Object createFixed(Object paramObject, byte[] paramArrayOfByte, Schema paramSchema)
  {
    return this.data.createFixed(paramObject, paramArrayOfByte, paramSchema);
  }
  
  protected Object createString(String paramString)
  {
    return new Utf8(paramString);
  }
  
  public GenericData getData()
  {
    return this.data;
  }
  
  public Schema getExpected()
  {
    return this.expected;
  }
  
  protected final ResolvingDecoder getResolver(Schema paramSchema1, Schema paramSchema2)
    throws IOException
  {
    Thread localThread = Thread.currentThread();
    if ((localThread == this.creator) && (this.creatorResolver != null)) {
      paramSchema1 = this.creatorResolver;
    }
    Object localObject1;
    do
    {
      return paramSchema1;
      localObject1 = (Map)((Map)RESOLVER_CACHE.get()).get(paramSchema1);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new WeakIdentityHashMap();
        ((Map)RESOLVER_CACHE.get()).put(paramSchema1, localObject2);
      }
      ResolvingDecoder localResolvingDecoder = (ResolvingDecoder)((Map)localObject2).get(paramSchema2);
      localObject1 = localResolvingDecoder;
      if (localResolvingDecoder == null)
      {
        localObject1 = DecoderFactory.get().resolvingDecoder(Schema.applyAliases(paramSchema1, paramSchema2), paramSchema2, null);
        ((Map)localObject2).put(paramSchema2, localObject1);
      }
      paramSchema1 = (Schema)localObject1;
    } while (localThread != this.creator);
    this.creatorResolver = ((ResolvingDecoder)localObject1);
    return (ResolvingDecoder)localObject1;
  }
  
  public Schema getSchema()
  {
    return this.actual;
  }
  
  protected Object newArray(Object paramObject, int paramInt, Schema paramSchema)
  {
    if ((paramObject instanceof Collection))
    {
      ((Collection)paramObject).clear();
      return paramObject;
    }
    return new GenericData.Array(paramInt, paramSchema);
  }
  
  protected Object newMap(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Map))
    {
      ((Map)paramObject).clear();
      return paramObject;
    }
    return new HashMap(paramInt);
  }
  
  @Deprecated
  protected Object newRecord(Object paramObject, Schema paramSchema)
  {
    return this.data.newRecord(paramObject, paramSchema);
  }
  
  protected Object peekArray(Object paramObject)
  {
    if ((paramObject instanceof GenericArray)) {
      return ((GenericArray)paramObject).peek();
    }
    return null;
  }
  
  protected Object read(Object paramObject, Schema paramSchema, ResolvingDecoder paramResolvingDecoder)
    throws IOException
  {
    switch (paramSchema.getType())
    {
    default: 
      throw new AvroRuntimeException("Unknown type: " + paramSchema);
    case ???: 
      return readRecord(paramObject, paramSchema, paramResolvingDecoder);
    case ???: 
      return readEnum(paramSchema, paramResolvingDecoder);
    case ???: 
      return readArray(paramObject, paramSchema, paramResolvingDecoder);
    case ???: 
      return readMap(paramObject, paramSchema, paramResolvingDecoder);
    case ???: 
      return read(paramObject, (Schema)paramSchema.getTypes().get(paramResolvingDecoder.readIndex()), paramResolvingDecoder);
    case ???: 
      return readFixed(paramObject, paramSchema, paramResolvingDecoder);
    case ???: 
      return readString(paramObject, paramSchema, paramResolvingDecoder);
    case ???: 
      return readBytes(paramObject, paramResolvingDecoder);
    case ???: 
      return readInt(paramObject, paramSchema, paramResolvingDecoder);
    case ???: 
      return Long.valueOf(paramResolvingDecoder.readLong());
    case ???: 
      return Float.valueOf(paramResolvingDecoder.readFloat());
    case ???: 
      return Double.valueOf(paramResolvingDecoder.readDouble());
    case ???: 
      return Boolean.valueOf(paramResolvingDecoder.readBoolean());
    }
    paramResolvingDecoder.readNull();
    return null;
  }
  
  public D read(D paramD, Decoder paramDecoder)
    throws IOException
  {
    ResolvingDecoder localResolvingDecoder = getResolver(this.actual, this.expected);
    localResolvingDecoder.configure(paramDecoder);
    paramD = read(paramD, this.expected, localResolvingDecoder);
    localResolvingDecoder.drain();
    return paramD;
  }
  
  protected Object readArray(Object paramObject, Schema paramSchema, ResolvingDecoder paramResolvingDecoder)
    throws IOException
  {
    Schema localSchema = paramSchema.getElementType();
    long l1 = paramResolvingDecoder.readArrayStart();
    long l2 = 0L;
    if (l1 > 0L)
    {
      paramObject = newArray(paramObject, (int)l1, paramSchema);
      long l3;
      do
      {
        for (l3 = 0L; l3 < l1; l3 += 1L) {
          addToArray(paramObject, l2 + l3, read(peekArray(paramObject), localSchema, paramResolvingDecoder));
        }
        l2 += l1;
        l3 = paramResolvingDecoder.arrayNext();
        l1 = l3;
      } while (l3 > 0L);
      return paramObject;
    }
    return newArray(paramObject, 0, paramSchema);
  }
  
  protected Object readBytes(Object paramObject, Decoder paramDecoder)
    throws IOException
  {
    if ((paramObject instanceof ByteBuffer)) {}
    for (paramObject = (ByteBuffer)paramObject;; paramObject = null) {
      return paramDecoder.readBytes((ByteBuffer)paramObject);
    }
  }
  
  protected Object readEnum(Schema paramSchema, Decoder paramDecoder)
    throws IOException
  {
    return createEnum((String)paramSchema.getEnumSymbols().get(paramDecoder.readEnum()), paramSchema);
  }
  
  protected Object readFixed(Object paramObject, Schema paramSchema, Decoder paramDecoder)
    throws IOException
  {
    paramObject = (GenericFixed)this.data.createFixed(paramObject, paramSchema);
    paramDecoder.readFixed(((GenericFixed)paramObject).bytes(), 0, paramSchema.getFixedSize());
    return paramObject;
  }
  
  protected Object readInt(Object paramObject, Schema paramSchema, Decoder paramDecoder)
    throws IOException
  {
    return Integer.valueOf(paramDecoder.readInt());
  }
  
  protected Object readMap(Object paramObject, Schema paramSchema, ResolvingDecoder paramResolvingDecoder)
    throws IOException
  {
    Schema localSchema = paramSchema.getValueType();
    long l1 = paramResolvingDecoder.readMapStart();
    paramObject = newMap(paramObject, (int)l1);
    if (l1 > 0L)
    {
      long l2;
      do
      {
        int i = 0;
        while (i < l1)
        {
          addToMap(paramObject, readString(null, paramSchema, paramResolvingDecoder), read(null, localSchema, paramResolvingDecoder));
          i += 1;
        }
        l2 = paramResolvingDecoder.mapNext();
        l1 = l2;
      } while (l2 > 0L);
    }
    return paramObject;
  }
  
  protected Object readRecord(Object paramObject, Schema paramSchema, ResolvingDecoder paramResolvingDecoder)
    throws IOException
  {
    Object localObject1 = this.data.newRecord(paramObject, paramSchema);
    Object localObject2 = this.data.getRecordState(localObject1, paramSchema);
    Schema.Field[] arrayOfField = paramResolvingDecoder.readFieldOrder();
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      Schema.Field localField = arrayOfField[i];
      int k = localField.pos();
      String str = localField.name();
      if (paramObject != null) {}
      for (paramSchema = this.data.getField(localObject1, str, k, localObject2);; paramSchema = null)
      {
        this.data.setField(localObject1, str, k, read(paramSchema, localField.schema(), paramResolvingDecoder), localObject2);
        i += 1;
        break;
      }
    }
    return localObject1;
  }
  
  protected Object readString(Object paramObject, Schema paramSchema, Decoder paramDecoder)
    throws IOException
  {
    GenericData localGenericData = this.data;
    localGenericData = this.data;
    if ("String".equals(paramSchema.getProp("avro.java.string"))) {
      return paramDecoder.readString();
    }
    return readString(paramObject, paramDecoder);
  }
  
  protected Object readString(Object paramObject, Decoder paramDecoder)
    throws IOException
  {
    if ((paramObject instanceof Utf8)) {}
    for (paramObject = (Utf8)paramObject;; paramObject = null) {
      return paramDecoder.readString((Utf8)paramObject);
    }
  }
  
  public void setExpected(Schema paramSchema)
  {
    this.expected = paramSchema;
    this.creatorResolver = null;
  }
  
  public void setSchema(Schema paramSchema)
  {
    this.actual = paramSchema;
    if (this.expected == null) {
      this.expected = this.actual;
    }
    this.creatorResolver = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/generic/GenericDatumReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */