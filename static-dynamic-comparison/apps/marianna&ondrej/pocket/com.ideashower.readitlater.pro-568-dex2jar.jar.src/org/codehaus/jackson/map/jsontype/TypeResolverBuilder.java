package org.codehaus.jackson.map.jsontype;

import java.util.Collection;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.type.JavaType;

public abstract interface TypeResolverBuilder
{
  public abstract TypeDeserializer buildTypeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, Collection paramCollection, BeanProperty paramBeanProperty);
  
  public abstract TypeSerializer buildTypeSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, Collection paramCollection, BeanProperty paramBeanProperty);
  
  public abstract TypeResolverBuilder defaultImpl(Class paramClass);
  
  public abstract Class getDefaultImpl();
  
  public abstract TypeResolverBuilder inclusion(JsonTypeInfo.As paramAs);
  
  public abstract TypeResolverBuilder init(JsonTypeInfo.Id paramId, TypeIdResolver paramTypeIdResolver);
  
  public abstract TypeResolverBuilder typeProperty(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/jsontype/TypeResolverBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */