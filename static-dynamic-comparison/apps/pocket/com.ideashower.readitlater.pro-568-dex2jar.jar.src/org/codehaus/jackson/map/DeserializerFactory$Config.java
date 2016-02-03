package org.codehaus.jackson.map;

import org.codehaus.jackson.map.deser.BeanDeserializerModifier;
import org.codehaus.jackson.map.deser.ValueInstantiators;

public abstract class DeserializerFactory$Config
{
  public abstract Iterable abstractTypeResolvers();
  
  public abstract Iterable deserializerModifiers();
  
  public abstract Iterable deserializers();
  
  public abstract boolean hasAbstractTypeResolvers();
  
  public abstract boolean hasDeserializerModifiers();
  
  public abstract boolean hasDeserializers();
  
  public abstract boolean hasKeyDeserializers();
  
  public abstract boolean hasValueInstantiators();
  
  public abstract Iterable keyDeserializers();
  
  public abstract Iterable valueInstantiators();
  
  public abstract Config withAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver);
  
  public abstract Config withAdditionalDeserializers(Deserializers paramDeserializers);
  
  public abstract Config withAdditionalKeyDeserializers(KeyDeserializers paramKeyDeserializers);
  
  public abstract Config withDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier);
  
  public abstract Config withValueInstantiators(ValueInstantiators paramValueInstantiators);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/DeserializerFactory$Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */