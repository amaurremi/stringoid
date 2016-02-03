package org.codehaus.jackson.map;

import org.codehaus.jackson.map.ser.BeanSerializerModifier;
import org.codehaus.jackson.type.JavaType;

public abstract class SerializerFactory
{
  public abstract JsonSerializer createKeySerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty);
  
  public abstract JsonSerializer createSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty);
  
  @Deprecated
  public final JsonSerializer createSerializer(JavaType paramJavaType, SerializationConfig paramSerializationConfig)
  {
    try
    {
      paramJavaType = createSerializer(paramSerializationConfig, paramJavaType, null);
      return paramJavaType;
    }
    catch (JsonMappingException paramJavaType)
    {
      throw new RuntimeJsonMappingException(paramJavaType);
    }
  }
  
  public abstract TypeSerializer createTypeSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty);
  
  @Deprecated
  public final TypeSerializer createTypeSerializer(JavaType paramJavaType, SerializationConfig paramSerializationConfig)
  {
    try
    {
      paramJavaType = createTypeSerializer(paramSerializationConfig, paramJavaType, null);
      return paramJavaType;
    }
    catch (JsonMappingException paramJavaType)
    {
      throw new RuntimeException(paramJavaType);
    }
  }
  
  public abstract SerializerFactory.Config getConfig();
  
  public final SerializerFactory withAdditionalKeySerializers(Serializers paramSerializers)
  {
    return withConfig(getConfig().withAdditionalKeySerializers(paramSerializers));
  }
  
  public final SerializerFactory withAdditionalSerializers(Serializers paramSerializers)
  {
    return withConfig(getConfig().withAdditionalSerializers(paramSerializers));
  }
  
  public abstract SerializerFactory withConfig(SerializerFactory.Config paramConfig);
  
  public final SerializerFactory withSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier)
  {
    return withConfig(getConfig().withSerializerModifier(paramBeanSerializerModifier));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/SerializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */