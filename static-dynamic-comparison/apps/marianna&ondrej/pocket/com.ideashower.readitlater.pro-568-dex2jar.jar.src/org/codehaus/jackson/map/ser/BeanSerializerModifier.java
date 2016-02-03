package org.codehaus.jackson.map.ser;

import java.util.List;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;

public abstract class BeanSerializerModifier
{
  public List changeProperties(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, List paramList)
  {
    return paramList;
  }
  
  public JsonSerializer modifySerializer(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, JsonSerializer paramJsonSerializer)
  {
    return paramJsonSerializer;
  }
  
  public List orderProperties(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, List paramList)
  {
    return paramList;
  }
  
  public BeanSerializerBuilder updateBuilder(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanSerializerBuilder paramBeanSerializerBuilder)
  {
    return paramBeanSerializerBuilder;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/BeanSerializerModifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */