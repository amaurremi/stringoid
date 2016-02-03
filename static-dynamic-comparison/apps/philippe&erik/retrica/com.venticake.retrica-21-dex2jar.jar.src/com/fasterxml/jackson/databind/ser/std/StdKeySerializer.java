package com.fasterxml.jackson.databind.ser.std;

public class StdKeySerializer
  extends StdSerializer<Object>
{
  static final StdKeySerializer instace = new StdKeySerializer();
  
  public StdKeySerializer()
  {
    super(Object.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/StdKeySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */