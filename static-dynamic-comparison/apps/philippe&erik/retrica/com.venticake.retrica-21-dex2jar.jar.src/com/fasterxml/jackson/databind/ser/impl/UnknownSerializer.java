package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class UnknownSerializer
  extends StdSerializer<Object>
{
  public UnknownSerializer()
  {
    super(Object.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/impl/UnknownSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */