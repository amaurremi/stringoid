package com.flurry.org.codehaus.jackson.map.ser;

import com.flurry.org.codehaus.jackson.map.ser.std.SerializerBase;

@Deprecated
public abstract class ScalarSerializerBase<T>
  extends SerializerBase<T>
{
  protected ScalarSerializerBase(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  protected ScalarSerializerBase(Class<?> paramClass, boolean paramBoolean)
  {
    super(paramClass);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ser/ScalarSerializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */