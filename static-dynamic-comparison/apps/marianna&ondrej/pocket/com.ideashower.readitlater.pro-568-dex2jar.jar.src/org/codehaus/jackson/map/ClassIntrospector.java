package org.codehaus.jackson.map;

import org.codehaus.jackson.type.JavaType;

public abstract class ClassIntrospector
{
  @Deprecated
  public BeanDescription forClassAnnotations(MapperConfig paramMapperConfig, Class paramClass, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    return forClassAnnotations(paramMapperConfig, paramMapperConfig.constructType(paramClass), paramMixInResolver);
  }
  
  public abstract BeanDescription forClassAnnotations(MapperConfig paramMapperConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver);
  
  public abstract BeanDescription forCreation(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver);
  
  public abstract BeanDescription forDeserialization(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver);
  
  @Deprecated
  public BeanDescription forDirectClassAnnotations(MapperConfig paramMapperConfig, Class paramClass, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    return forDirectClassAnnotations(paramMapperConfig, paramMapperConfig.constructType(paramClass), paramMixInResolver);
  }
  
  public abstract BeanDescription forDirectClassAnnotations(MapperConfig paramMapperConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver);
  
  public abstract BeanDescription forSerialization(SerializationConfig paramSerializationConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ClassIntrospector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */