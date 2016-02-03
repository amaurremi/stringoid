package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.type.JavaType;

@Deprecated
public abstract class StdDeserializer
  extends org.codehaus.jackson.map.deser.std.StdDeserializer
{
  protected StdDeserializer(Class paramClass)
  {
    super(paramClass);
  }
  
  protected StdDeserializer(JavaType paramJavaType)
  {
    super(paramJavaType);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/StdDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */