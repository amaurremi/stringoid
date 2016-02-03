package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

@JacksonStdImpl
public final class NumberSerializers$IntLikeSerializer
  extends StdScalarSerializer<Number>
{
  static final IntLikeSerializer instance = new IntLikeSerializer();
  
  public NumberSerializers$IntLikeSerializer()
  {
    super(Number.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/NumberSerializers$IntLikeSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */