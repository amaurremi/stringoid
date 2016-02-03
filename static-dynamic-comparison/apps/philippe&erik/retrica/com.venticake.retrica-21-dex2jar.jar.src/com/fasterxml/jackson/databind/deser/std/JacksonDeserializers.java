package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;

public class JacksonDeserializers
{
  public static StdDeserializer<?>[] all()
  {
    return new StdDeserializer[] { new JacksonDeserializers.JavaTypeDeserializer(), new JacksonDeserializers.TokenBufferDeserializer() };
  }
  
  public static ValueInstantiator findValueInstantiator(DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription)
  {
    if (paramBeanDescription.getBeanClass() == JsonLocation.class) {
      return new JacksonDeserializers.JsonLocationInstantiator();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JacksonDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */