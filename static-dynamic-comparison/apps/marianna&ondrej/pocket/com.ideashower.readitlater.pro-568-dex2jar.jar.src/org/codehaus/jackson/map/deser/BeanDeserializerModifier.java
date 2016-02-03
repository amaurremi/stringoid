package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;

public abstract class BeanDeserializerModifier
{
  public JsonDeserializer modifyDeserializer(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, JsonDeserializer paramJsonDeserializer)
  {
    return paramJsonDeserializer;
  }
  
  public BeanDeserializerBuilder updateBuilder(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanDeserializerBuilder paramBeanDeserializerBuilder)
  {
    return paramBeanDeserializerBuilder;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/BeanDeserializerModifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */