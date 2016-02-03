package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;

public abstract class ClassIntrospector
{
  public abstract BeanDescription forClassAnnotations(MapperConfig<?> paramMapperConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver);
  
  public abstract BeanDescription forCreation(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver);
  
  public abstract BeanDescription forDeserialization(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver);
  
  public abstract BeanDescription forDeserializationWithBuilder(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver);
  
  public abstract BeanDescription forSerialization(SerializationConfig paramSerializationConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/introspect/ClassIntrospector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */