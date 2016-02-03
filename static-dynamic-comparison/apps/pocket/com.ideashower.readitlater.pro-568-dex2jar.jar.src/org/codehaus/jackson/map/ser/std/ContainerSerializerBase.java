package org.codehaus.jackson.map.ser.std;

import org.codehaus.jackson.map.TypeSerializer;

public abstract class ContainerSerializerBase
  extends SerializerBase
{
  protected ContainerSerializerBase(Class paramClass)
  {
    super(paramClass);
  }
  
  protected ContainerSerializerBase(Class paramClass, boolean paramBoolean)
  {
    super(paramClass, paramBoolean);
  }
  
  public abstract ContainerSerializerBase _withValueTypeSerializer(TypeSerializer paramTypeSerializer);
  
  public ContainerSerializerBase withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    if (paramTypeSerializer == null) {
      return this;
    }
    return _withValueTypeSerializer(paramTypeSerializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/ContainerSerializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */