package com.flurry.org.codehaus.jackson.map;

import com.flurry.org.codehaus.jackson.map.ser.BeanSerializerModifier;
import com.flurry.org.codehaus.jackson.type.JavaType;

public abstract class SerializerFactory
{
  public abstract JsonSerializer<Object> createKeySerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public abstract JsonSerializer<Object> createSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  @Deprecated
  public final JsonSerializer<Object> createSerializer(JavaType paramJavaType, SerializationConfig paramSerializationConfig)
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
  
  public abstract TypeSerializer createTypeSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
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
  
  public abstract Config getConfig();
  
  public final SerializerFactory withAdditionalKeySerializers(Serializers paramSerializers)
  {
    return withConfig(getConfig().withAdditionalKeySerializers(paramSerializers));
  }
  
  public final SerializerFactory withAdditionalSerializers(Serializers paramSerializers)
  {
    return withConfig(getConfig().withAdditionalSerializers(paramSerializers));
  }
  
  public abstract SerializerFactory withConfig(Config paramConfig);
  
  public final SerializerFactory withSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier)
  {
    return withConfig(getConfig().withSerializerModifier(paramBeanSerializerModifier));
  }
  
  public static abstract class Config
  {
    public abstract boolean hasKeySerializers();
    
    public abstract boolean hasSerializerModifiers();
    
    public abstract boolean hasSerializers();
    
    public abstract Iterable<Serializers> keySerializers();
    
    public abstract Iterable<BeanSerializerModifier> serializerModifiers();
    
    public abstract Iterable<Serializers> serializers();
    
    public abstract Config withAdditionalKeySerializers(Serializers paramSerializers);
    
    public abstract Config withAdditionalSerializers(Serializers paramSerializers);
    
    public abstract Config withSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/SerializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */