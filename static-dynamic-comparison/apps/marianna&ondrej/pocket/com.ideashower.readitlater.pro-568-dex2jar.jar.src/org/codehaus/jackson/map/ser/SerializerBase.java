package org.codehaus.jackson.map.ser;

import org.codehaus.jackson.type.JavaType;

@Deprecated
public abstract class SerializerBase
  extends org.codehaus.jackson.map.ser.std.SerializerBase
{
  protected SerializerBase(Class paramClass)
  {
    super(paramClass);
  }
  
  protected SerializerBase(Class paramClass, boolean paramBoolean)
  {
    super(paramClass, paramBoolean);
  }
  
  protected SerializerBase(JavaType paramJavaType)
  {
    super(paramJavaType);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/SerializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */