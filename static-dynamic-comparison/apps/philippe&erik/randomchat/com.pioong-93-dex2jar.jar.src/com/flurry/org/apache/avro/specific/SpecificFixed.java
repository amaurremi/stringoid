package com.flurry.org.apache.avro.specific;

import com.flurry.org.apache.avro.generic.GenericData.Fixed;

public abstract class SpecificFixed
  extends GenericData.Fixed
{
  public SpecificFixed()
  {
    setSchema(SpecificData.get().getSchema(getClass()));
  }
  
  public SpecificFixed(byte[] paramArrayOfByte)
  {
    this();
    bytes(paramArrayOfByte);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/apache/avro/specific/SpecificFixed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */