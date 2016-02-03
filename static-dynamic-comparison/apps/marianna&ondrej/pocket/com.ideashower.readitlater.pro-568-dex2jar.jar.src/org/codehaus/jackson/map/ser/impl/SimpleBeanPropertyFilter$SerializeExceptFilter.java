package org.codehaus.jackson.map.ser.impl;

import java.util.Set;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.BeanPropertyWriter;

public class SimpleBeanPropertyFilter$SerializeExceptFilter
  extends SimpleBeanPropertyFilter
{
  protected final Set _propertiesToExclude;
  
  public SimpleBeanPropertyFilter$SerializeExceptFilter(Set paramSet)
  {
    this._propertiesToExclude = paramSet;
  }
  
  public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, BeanPropertyWriter paramBeanPropertyWriter)
  {
    if (!this._propertiesToExclude.contains(paramBeanPropertyWriter.getName())) {
      paramBeanPropertyWriter.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/impl/SimpleBeanPropertyFilter$SerializeExceptFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */