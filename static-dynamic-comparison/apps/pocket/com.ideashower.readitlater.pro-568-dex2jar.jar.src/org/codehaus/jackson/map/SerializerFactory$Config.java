package org.codehaus.jackson.map;

import org.codehaus.jackson.map.ser.BeanSerializerModifier;

public abstract class SerializerFactory$Config
{
  public abstract boolean hasKeySerializers();
  
  public abstract boolean hasSerializerModifiers();
  
  public abstract boolean hasSerializers();
  
  public abstract Iterable keySerializers();
  
  public abstract Iterable serializerModifiers();
  
  public abstract Iterable serializers();
  
  public abstract Config withAdditionalKeySerializers(Serializers paramSerializers);
  
  public abstract Config withAdditionalSerializers(Serializers paramSerializers);
  
  public abstract Config withSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/SerializerFactory$Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */