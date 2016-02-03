package org.codehaus.jackson.map;

import java.util.Collection;
import org.codehaus.jackson.map.jsontype.impl.StdTypeResolverBuilder;
import org.codehaus.jackson.type.JavaType;

public class ObjectMapper$DefaultTypeResolverBuilder
  extends StdTypeResolverBuilder
{
  protected final ObjectMapper.DefaultTyping _appliesFor;
  
  public ObjectMapper$DefaultTypeResolverBuilder(ObjectMapper.DefaultTyping paramDefaultTyping)
  {
    this._appliesFor = paramDefaultTyping;
  }
  
  public TypeDeserializer buildTypeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, Collection paramCollection, BeanProperty paramBeanProperty)
  {
    if (useForType(paramJavaType)) {
      return super.buildTypeDeserializer(paramDeserializationConfig, paramJavaType, paramCollection, paramBeanProperty);
    }
    return null;
  }
  
  public TypeSerializer buildTypeSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, Collection paramCollection, BeanProperty paramBeanProperty)
  {
    if (useForType(paramJavaType)) {
      return super.buildTypeSerializer(paramSerializationConfig, paramJavaType, paramCollection, paramBeanProperty);
    }
    return null;
  }
  
  public boolean useForType(JavaType paramJavaType)
  {
    boolean bool = false;
    JavaType localJavaType = paramJavaType;
    switch (ObjectMapper.2.$SwitchMap$org$codehaus$jackson$map$ObjectMapper$DefaultTyping[this._appliesFor.ordinal()])
    {
    default: 
      if (paramJavaType.getRawClass() != Object.class) {
        break;
      }
    case 1: 
    case 2: 
    case 3: 
      do
      {
        return true;
        localJavaType = paramJavaType;
        if (paramJavaType.isArrayType()) {
          localJavaType = paramJavaType.getContentType();
        }
        if ((localJavaType.getRawClass() == Object.class) || (!localJavaType.isConcrete())) {
          bool = true;
        }
        return bool;
        localJavaType = paramJavaType;
        if (paramJavaType.isArrayType()) {
          localJavaType = paramJavaType.getContentType();
        }
      } while (!localJavaType.isFinal());
      return false;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ObjectMapper$DefaultTypeResolverBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */