package com.flurry.org.apache.avro.data;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.Schema.Field;
import com.flurry.org.apache.avro.Schema.Type;
import com.flurry.org.apache.avro.generic.GenericData;
import com.flurry.org.apache.avro.generic.IndexedRecord;
import com.flurry.org.apache.avro.io.BinaryDecoder;
import com.flurry.org.apache.avro.io.BinaryEncoder;
import com.flurry.org.apache.avro.io.DatumReader;
import com.flurry.org.apache.avro.io.DecoderFactory;
import com.flurry.org.apache.avro.io.EncoderFactory;
import com.flurry.org.apache.avro.io.parsing.ResolvingGrammarGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class RecordBuilderBase<T extends IndexedRecord>
  implements RecordBuilder<T>
{
  private static final ConcurrentMap<String, ConcurrentMap<Integer, Object>> DEFAULT_VALUE_CACHE = new ConcurrentHashMap();
  private static final Schema.Field[] EMPTY_FIELDS = new Schema.Field[0];
  private final GenericData data;
  private BinaryDecoder decoder = null;
  private BinaryEncoder encoder = null;
  private final boolean[] fieldSetFlags;
  private final Schema.Field[] fields;
  private final Schema schema;
  
  protected RecordBuilderBase(Schema paramSchema, GenericData paramGenericData)
  {
    this.schema = paramSchema;
    this.data = paramGenericData;
    this.fields = ((Schema.Field[])paramSchema.getFields().toArray(EMPTY_FIELDS));
    this.fieldSetFlags = new boolean[this.fields.length];
  }
  
  protected RecordBuilderBase(RecordBuilderBase<T> paramRecordBuilderBase, GenericData paramGenericData)
  {
    this.schema = paramRecordBuilderBase.schema;
    this.data = paramGenericData;
    this.fields = ((Schema.Field[])this.schema.getFields().toArray(EMPTY_FIELDS));
    this.fieldSetFlags = new boolean[paramRecordBuilderBase.fieldSetFlags.length];
    System.arraycopy(paramRecordBuilderBase.fieldSetFlags, 0, this.fieldSetFlags, 0, this.fieldSetFlags.length);
  }
  
  protected static boolean isValidValue(Schema.Field paramField, Object paramObject)
  {
    if (paramObject != null) {}
    do
    {
      return true;
      paramField = paramField.schema();
      paramObject = paramField.getType();
    } while (paramObject == Schema.Type.NULL);
    if (paramObject == Schema.Type.UNION)
    {
      paramField = paramField.getTypes().iterator();
      while (paramField.hasNext()) {
        if (((Schema)paramField.next()).getType() == Schema.Type.NULL) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected final GenericData data()
  {
    return this.data;
  }
  
  protected Object defaultValue(Schema.Field paramField)
    throws IOException
  {
    JsonNode localJsonNode = paramField.defaultValue();
    if (localJsonNode == null) {
      throw new AvroRuntimeException("Field " + paramField + " not set and has no default value");
    }
    if ((localJsonNode.isNull()) && ((paramField.schema().getType() == Schema.Type.NULL) || ((paramField.schema().getType() == Schema.Type.UNION) && (((Schema)paramField.schema().getTypes().get(0)).getType() == Schema.Type.NULL)))) {
      return null;
    }
    Object localObject2 = (ConcurrentMap)DEFAULT_VALUE_CACHE.get(this.schema.getFullName());
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      DEFAULT_VALUE_CACHE.putIfAbsent(this.schema.getFullName(), new ConcurrentHashMap(this.fields.length));
      localObject1 = (ConcurrentMap)DEFAULT_VALUE_CACHE.get(this.schema.getFullName());
    }
    Object localObject3 = ((ConcurrentMap)localObject1).get(Integer.valueOf(paramField.pos()));
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new ByteArrayOutputStream();
      this.encoder = EncoderFactory.get().binaryEncoder((OutputStream)localObject2, this.encoder);
      ResolvingGrammarGenerator.encode(this.encoder, paramField.schema(), localJsonNode);
      this.encoder.flush();
      this.decoder = DecoderFactory.get().binaryDecoder(((ByteArrayOutputStream)localObject2).toByteArray(), this.decoder);
      localObject2 = this.data.createDatumReader(paramField.schema()).read(null, this.decoder);
      ((ConcurrentMap)localObject1).putIfAbsent(Integer.valueOf(paramField.pos()), localObject2);
    }
    return this.data.deepCopy(paramField.schema(), localObject2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (RecordBuilderBase)paramObject;
        if (!Arrays.equals(this.fieldSetFlags, ((RecordBuilderBase)paramObject).fieldSetFlags)) {
          return false;
        }
        if (this.schema != null) {
          break;
        }
      } while (((RecordBuilderBase)paramObject).schema == null);
      return false;
    } while (this.schema.equals(((RecordBuilderBase)paramObject).schema));
    return false;
  }
  
  protected final boolean[] fieldSetFlags()
  {
    return this.fieldSetFlags;
  }
  
  protected final Schema.Field[] fields()
  {
    return this.fields;
  }
  
  public int hashCode()
  {
    int j = Arrays.hashCode(this.fieldSetFlags);
    if (this.schema == null) {}
    for (int i = 0;; i = this.schema.hashCode()) {
      return (j + 31) * 31 + i;
    }
  }
  
  protected final Schema schema()
  {
    return this.schema;
  }
  
  protected void validate(Schema.Field paramField, Object paramObject)
  {
    if (isValidValue(paramField, paramObject)) {}
    while (paramField.defaultValue() != null) {
      return;
    }
    throw new AvroRuntimeException("Field " + paramField + " does not accept null values");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/data/RecordBuilderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */