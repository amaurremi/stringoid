package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
public final class NumberSerializers$LongSerializer
  extends StdScalarSerializer<Long>
{
  static final LongSerializer instance = new LongSerializer();
  
  public NumberSerializers$LongSerializer()
  {
    super(Long.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/NumberSerializers$LongSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */