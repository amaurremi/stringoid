package com.flurry.org.apache.avro.specific;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.generic.GenericDatumWriter;
import com.flurry.org.apache.avro.io.Encoder;
import java.io.IOException;

public class SpecificDatumWriter<T>
  extends GenericDatumWriter<T>
{
  public SpecificDatumWriter()
  {
    super(SpecificData.get());
  }
  
  public SpecificDatumWriter(Schema paramSchema)
  {
    super(paramSchema, SpecificData.get());
  }
  
  protected SpecificDatumWriter(Schema paramSchema, SpecificData paramSpecificData)
  {
    super(paramSchema, paramSpecificData);
  }
  
  protected SpecificDatumWriter(SpecificData paramSpecificData)
  {
    super(paramSpecificData);
  }
  
  public SpecificDatumWriter(Class<T> paramClass)
  {
    super(SpecificData.get().getSchema(paramClass), SpecificData.get());
  }
  
  protected void writeEnum(Schema paramSchema, Object paramObject, Encoder paramEncoder)
    throws IOException
  {
    if (!(paramObject instanceof Enum))
    {
      super.writeEnum(paramSchema, paramObject, paramEncoder);
      return;
    }
    paramEncoder.writeEnum(((Enum)paramObject).ordinal());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/specific/SpecificDatumWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */