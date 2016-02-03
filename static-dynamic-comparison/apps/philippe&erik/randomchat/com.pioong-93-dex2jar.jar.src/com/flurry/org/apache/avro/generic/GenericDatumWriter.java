package com.flurry.org.apache.avro.generic;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Field;
import com.flurry.org.apache.avro.io.DatumWriter;
import com.flurry.org.apache.avro.io.Encoder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GenericDatumWriter<D>
  implements DatumWriter<D>
{
  private final GenericData data;
  private Schema root;
  
  public GenericDatumWriter()
  {
    this(GenericData.get());
  }
  
  public GenericDatumWriter(Schema paramSchema)
  {
    this();
    setSchema(paramSchema);
  }
  
  protected GenericDatumWriter(Schema paramSchema, GenericData paramGenericData)
  {
    this(paramGenericData);
    setSchema(paramSchema);
  }
  
  protected GenericDatumWriter(GenericData paramGenericData)
  {
    this.data = paramGenericData;
  }
  
  private void error(Schema paramSchema, Object paramObject)
  {
    throw new AvroTypeException("Not a " + paramSchema + ": " + paramObject);
  }
  
  protected Iterator<? extends Object> getArrayElements(Object paramObject)
  {
    return ((Collection)paramObject).iterator();
  }
  
  protected long getArraySize(Object paramObject)
  {
    return ((Collection)paramObject).size();
  }
  
  public GenericData getData()
  {
    return this.data;
  }
  
  protected Iterable<Map.Entry<Object, Object>> getMapEntries(Object paramObject)
  {
    return ((Map)paramObject).entrySet();
  }
  
  protected int getMapSize(Object paramObject)
  {
    return ((Map)paramObject).size();
  }
  
  protected NullPointerException npe(NullPointerException paramNullPointerException, String paramString)
  {
    paramString = new NullPointerException(paramNullPointerException.getMessage() + paramString);
    if (paramNullPointerException.getCause() == null) {}
    for (;;)
    {
      paramString.initCause(paramNullPointerException);
      return paramString;
      paramNullPointerException = paramNullPointerException.getCause();
    }
  }
  
  protected int resolveUnion(Schema paramSchema, Object paramObject)
  {
    return this.data.resolveUnion(paramSchema, paramObject);
  }
  
  public void setSchema(Schema paramSchema)
  {
    this.root = paramSchema;
  }
  
  protected void write(Schema paramSchema, Object paramObject, Encoder paramEncoder)
    throws IOException
  {
    for (;;)
    {
      try
      {
        switch (paramSchema.getType())
        {
        case ???: 
          error(paramSchema, paramObject);
          return;
        }
      }
      catch (NullPointerException paramObject)
      {
        throw npe((NullPointerException)paramObject, " of " + paramSchema.getFullName());
      }
      writeRecord(paramSchema, paramObject, paramEncoder);
      return;
      writeEnum(paramSchema, paramObject, paramEncoder);
      return;
      writeArray(paramSchema, paramObject, paramEncoder);
      return;
      writeMap(paramSchema, paramObject, paramEncoder);
      return;
      int i = resolveUnion(paramSchema, paramObject);
      paramEncoder.writeIndex(i);
      write((Schema)paramSchema.getTypes().get(i), paramObject, paramEncoder);
      return;
      writeFixed(paramSchema, paramObject, paramEncoder);
      return;
      writeString(paramSchema, paramObject, paramEncoder);
      return;
      writeBytes(paramObject, paramEncoder);
      return;
      paramEncoder.writeInt(((Number)paramObject).intValue());
      return;
      paramEncoder.writeLong(((Long)paramObject).longValue());
      return;
      paramEncoder.writeFloat(((Float)paramObject).floatValue());
      return;
      paramEncoder.writeDouble(((Double)paramObject).doubleValue());
      return;
      paramEncoder.writeBoolean(((Boolean)paramObject).booleanValue());
      return;
      paramEncoder.writeNull();
      return;
    }
  }
  
  public void write(D paramD, Encoder paramEncoder)
    throws IOException
  {
    write(this.root, paramD, paramEncoder);
  }
  
  protected void writeArray(Schema paramSchema, Object paramObject, Encoder paramEncoder)
    throws IOException
  {
    paramSchema = paramSchema.getElementType();
    long l = getArraySize(paramObject);
    paramEncoder.writeArrayStart();
    paramEncoder.setItemCount(l);
    paramObject = getArrayElements(paramObject);
    while (((Iterator)paramObject).hasNext())
    {
      paramEncoder.startItem();
      write(paramSchema, ((Iterator)paramObject).next(), paramEncoder);
    }
    paramEncoder.writeArrayEnd();
  }
  
  protected void writeBytes(Object paramObject, Encoder paramEncoder)
    throws IOException
  {
    paramEncoder.writeBytes((ByteBuffer)paramObject);
  }
  
  protected void writeEnum(Schema paramSchema, Object paramObject, Encoder paramEncoder)
    throws IOException
  {
    paramEncoder.writeEnum(paramSchema.getEnumOrdinal(paramObject.toString()));
  }
  
  protected void writeFixed(Schema paramSchema, Object paramObject, Encoder paramEncoder)
    throws IOException
  {
    paramEncoder.writeFixed(((GenericFixed)paramObject).bytes(), 0, paramSchema.getFixedSize());
  }
  
  protected void writeMap(Schema paramSchema, Object paramObject, Encoder paramEncoder)
    throws IOException
  {
    paramSchema = paramSchema.getValueType();
    int i = getMapSize(paramObject);
    paramEncoder.writeMapStart();
    paramEncoder.setItemCount(i);
    paramObject = getMapEntries(paramObject).iterator();
    while (((Iterator)paramObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)paramObject).next();
      paramEncoder.startItem();
      writeString(localEntry.getKey(), paramEncoder);
      write(paramSchema, localEntry.getValue(), paramEncoder);
    }
    paramEncoder.writeMapEnd();
  }
  
  protected void writeRecord(Schema paramSchema, Object paramObject, Encoder paramEncoder)
    throws IOException
  {
    Object localObject1 = this.data.getRecordState(paramObject, paramSchema);
    Iterator localIterator = paramSchema.getFields().iterator();
    while (localIterator.hasNext())
    {
      paramSchema = (Schema.Field)localIterator.next();
      Object localObject2 = this.data.getField(paramObject, paramSchema.name(), paramSchema.pos(), localObject1);
      try
      {
        write(paramSchema.schema(), localObject2, paramEncoder);
      }
      catch (NullPointerException paramObject)
      {
        throw npe((NullPointerException)paramObject, " in field " + paramSchema.name());
      }
    }
  }
  
  protected void writeString(Schema paramSchema, Object paramObject, Encoder paramEncoder)
    throws IOException
  {
    writeString(paramObject, paramEncoder);
  }
  
  protected void writeString(Object paramObject, Encoder paramEncoder)
    throws IOException
  {
    paramEncoder.writeString((CharSequence)paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/generic/GenericDatumWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */