package org.codehaus.jackson.map.ser;

import org.codehaus.jackson.map.ser.std.SerializerBase;

@Deprecated
public abstract class ScalarSerializerBase
  extends SerializerBase
{
  protected ScalarSerializerBase(Class paramClass)
  {
    super(paramClass);
  }
  
  protected ScalarSerializerBase(Class paramClass, boolean paramBoolean)
  {
    super(paramClass);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/ScalarSerializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */