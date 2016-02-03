package org.codehaus.jackson.map.ser.impl;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.std.BeanSerializerBase;

public class UnwrappingBeanSerializer
  extends BeanSerializerBase
{
  public UnwrappingBeanSerializer(BeanSerializerBase paramBeanSerializerBase)
  {
    super(paramBeanSerializerBase);
  }
  
  public boolean isUnwrappingSerializer()
  {
    return true;
  }
  
  public final void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    if (this._propertyFilterId != null)
    {
      serializeFieldsFiltered(paramObject, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    serializeFields(paramObject, paramJsonGenerator, paramSerializerProvider);
  }
  
  public String toString()
  {
    return "UnwrappingBeanSerializer for " + handledType().getName();
  }
  
  public JsonSerializer unwrappingSerializer()
  {
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/impl/UnwrappingBeanSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */