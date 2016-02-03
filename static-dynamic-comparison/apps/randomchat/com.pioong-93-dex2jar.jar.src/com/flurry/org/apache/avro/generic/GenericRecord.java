package com.flurry.org.apache.avro.generic;

public abstract interface GenericRecord
  extends IndexedRecord
{
  public abstract Object get(String paramString);
  
  public abstract void put(String paramString, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/generic/GenericRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */