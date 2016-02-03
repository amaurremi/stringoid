package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.type.JavaType;

public abstract class ContainerDeserializerBase
  extends StdDeserializer
{
  protected ContainerDeserializerBase(Class paramClass)
  {
    super(paramClass);
  }
  
  public abstract JsonDeserializer getContentDeserializer();
  
  public abstract JavaType getContentType();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/ContainerDeserializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */