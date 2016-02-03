package org.codehaus.jackson.map;

import org.codehaus.jackson.map.deser.ValueInstantiator;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;

public abstract class HandlerInstantiator
{
  public abstract JsonDeserializer deserializerInstance(DeserializationConfig paramDeserializationConfig, Annotated paramAnnotated, Class paramClass);
  
  public abstract KeyDeserializer keyDeserializerInstance(DeserializationConfig paramDeserializationConfig, Annotated paramAnnotated, Class paramClass);
  
  public abstract JsonSerializer serializerInstance(SerializationConfig paramSerializationConfig, Annotated paramAnnotated, Class paramClass);
  
  public abstract TypeIdResolver typeIdResolverInstance(MapperConfig paramMapperConfig, Annotated paramAnnotated, Class paramClass);
  
  public abstract TypeResolverBuilder typeResolverBuilderInstance(MapperConfig paramMapperConfig, Annotated paramAnnotated, Class paramClass);
  
  public ValueInstantiator valueInstantiatorInstance(MapperConfig paramMapperConfig, Annotated paramAnnotated, Class paramClass)
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/HandlerInstantiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */