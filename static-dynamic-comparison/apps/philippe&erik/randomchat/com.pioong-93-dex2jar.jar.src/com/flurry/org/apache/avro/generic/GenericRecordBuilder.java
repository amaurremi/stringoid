package com.flurry.org.apache.avro.generic;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Field;
import com.flurry.org.apache.avro.data.RecordBuilderBase;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class GenericRecordBuilder
  extends RecordBuilderBase<GenericData.Record>
{
  private final GenericData.Record record;
  
  public GenericRecordBuilder(Schema paramSchema)
  {
    super(paramSchema, GenericData.get());
    this.record = new GenericData.Record(paramSchema);
  }
  
  public GenericRecordBuilder(GenericData.Record paramRecord)
  {
    super(paramRecord.getSchema(), GenericData.get());
    this.record = new GenericData.Record(paramRecord, true);
    Iterator localIterator = schema().getFields().iterator();
    while (localIterator.hasNext())
    {
      Schema.Field localField = (Schema.Field)localIterator.next();
      Object localObject = paramRecord.get(localField.pos());
      if (isValidValue(localField, localObject)) {
        set(localField, data().deepCopy(localField.schema(), localObject));
      }
    }
  }
  
  public GenericRecordBuilder(GenericRecordBuilder paramGenericRecordBuilder)
  {
    super(paramGenericRecordBuilder, GenericData.get());
    this.record = new GenericData.Record(paramGenericRecordBuilder.record, true);
  }
  
  private Object getWithDefault(Schema.Field paramField)
    throws IOException
  {
    if (fieldSetFlags()[paramField.pos()] != 0) {
      return this.record.get(paramField.pos());
    }
    return defaultValue(paramField);
  }
  
  private GenericRecordBuilder set(Schema.Field paramField, int paramInt, Object paramObject)
  {
    validate(paramField, paramObject);
    this.record.put(paramInt, paramObject);
    fieldSetFlags()[paramInt] = 1;
    return this;
  }
  
  public GenericData.Record build()
  {
    try
    {
      localRecord = new GenericData.Record(schema());
      arrayOfField = fields();
      j = arrayOfField.length;
      i = 0;
    }
    catch (Exception localException)
    {
      try
      {
        GenericData.Record localRecord;
        Schema.Field[] arrayOfField;
        int j;
        int i;
        Schema.Field localField;
        Object localObject = getWithDefault(localField);
        if (localObject != null) {
          localRecord.put(localField.pos(), localObject);
        }
        i += 1;
      }
      catch (IOException localIOException)
      {
        throw new AvroRuntimeException(localIOException);
      }
      localException = localException;
      throw new AvroRuntimeException(localException);
    }
    if (i < j) {
      localField = arrayOfField[i];
    }
    return localIOException;
  }
  
  protected GenericRecordBuilder clear(int paramInt)
  {
    this.record.put(paramInt, null);
    fieldSetFlags()[paramInt] = 0;
    return this;
  }
  
  public GenericRecordBuilder clear(Schema.Field paramField)
  {
    return clear(paramField.pos());
  }
  
  public GenericRecordBuilder clear(String paramString)
  {
    return clear(schema().getField(paramString));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (!super.equals(paramObject)) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (GenericRecordBuilder)paramObject;
        if (this.record != null) {
          break;
        }
      } while (((GenericRecordBuilder)paramObject).record == null);
      return false;
    } while (this.record.equals(((GenericRecordBuilder)paramObject).record));
    return false;
  }
  
  protected Object get(int paramInt)
  {
    return this.record.get(paramInt);
  }
  
  public Object get(Schema.Field paramField)
  {
    return get(paramField.pos());
  }
  
  public Object get(String paramString)
  {
    return get(schema().getField(paramString));
  }
  
  protected boolean has(int paramInt)
  {
    return fieldSetFlags()[paramInt];
  }
  
  public boolean has(Schema.Field paramField)
  {
    return has(paramField.pos());
  }
  
  public boolean has(String paramString)
  {
    return has(schema().getField(paramString));
  }
  
  public int hashCode()
  {
    int j = super.hashCode();
    if (this.record == null) {}
    for (int i = 0;; i = this.record.hashCode()) {
      return j * 31 + i;
    }
  }
  
  protected GenericRecordBuilder set(int paramInt, Object paramObject)
  {
    return set(fields()[paramInt], paramInt, paramObject);
  }
  
  public GenericRecordBuilder set(Schema.Field paramField, Object paramObject)
  {
    return set(paramField, paramField.pos(), paramObject);
  }
  
  public GenericRecordBuilder set(String paramString, Object paramObject)
  {
    return set(schema().getField(paramString), paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/generic/GenericRecordBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */