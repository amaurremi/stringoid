package com.flurry.org.apache.avro.specific;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.data.RecordBuilderBase;

public abstract class SpecificRecordBuilderBase<T extends SpecificRecord>
  extends RecordBuilderBase<T>
{
  protected SpecificRecordBuilderBase(Schema paramSchema)
  {
    super(paramSchema, SpecificData.get());
  }
  
  protected SpecificRecordBuilderBase(T paramT)
  {
    super(paramT.getSchema(), SpecificData.get());
  }
  
  protected SpecificRecordBuilderBase(SpecificRecordBuilderBase<T> paramSpecificRecordBuilderBase)
  {
    super(paramSpecificRecordBuilderBase, SpecificData.get());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/specific/SpecificRecordBuilderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */