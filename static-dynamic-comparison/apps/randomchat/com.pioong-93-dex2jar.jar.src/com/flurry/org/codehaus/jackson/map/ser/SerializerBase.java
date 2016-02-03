package com.flurry.org.codehaus.jackson.map.ser;

import com.flurry.org.codehaus.jackson.type.JavaType;

@Deprecated
public abstract class SerializerBase<T>
  extends com.flurry.org.codehaus.jackson.map.ser.std.SerializerBase<T>
{
  protected SerializerBase(JavaType paramJavaType)
  {
    super(paramJavaType);
  }
  
  protected SerializerBase(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  protected SerializerBase(Class<?> paramClass, boolean paramBoolean)
  {
    super(paramClass, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ser/SerializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */