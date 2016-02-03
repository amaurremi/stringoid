package com.fasterxml.jackson.databind.ser.std;

public abstract class StdScalarSerializer<T>
  extends StdSerializer<T>
{
  protected StdScalarSerializer(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  protected StdScalarSerializer(Class<?> paramClass, boolean paramBoolean)
  {
    super(paramClass);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/StdScalarSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */