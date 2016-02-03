package org.codehaus.jackson.map.ser.impl;

import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.type.JavaType;

public abstract class PropertySerializerMap
{
  public static PropertySerializerMap emptyMap()
  {
    return PropertySerializerMap.Empty.instance;
  }
  
  public final PropertySerializerMap.SerializerAndMapResult findAndAddSerializer(Class paramClass, SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
  {
    paramSerializerProvider = paramSerializerProvider.findValueSerializer(paramClass, paramBeanProperty);
    return new PropertySerializerMap.SerializerAndMapResult(paramSerializerProvider, newWith(paramClass, paramSerializerProvider));
  }
  
  public final PropertySerializerMap.SerializerAndMapResult findAndAddSerializer(JavaType paramJavaType, SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
  {
    paramSerializerProvider = paramSerializerProvider.findValueSerializer(paramJavaType, paramBeanProperty);
    return new PropertySerializerMap.SerializerAndMapResult(paramSerializerProvider, newWith(paramJavaType.getRawClass(), paramSerializerProvider));
  }
  
  public abstract PropertySerializerMap newWith(Class paramClass, JsonSerializer paramJsonSerializer);
  
  public abstract JsonSerializer serializerFor(Class paramClass);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/impl/PropertySerializerMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */