package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.lang.reflect.Method;

final class StdKeyDeserializer$StringFactoryKeyDeserializer
  extends StdKeyDeserializer
{
  final Method _factoryMethod;
  
  public StdKeyDeserializer$StringFactoryKeyDeserializer(Method paramMethod)
  {
    super(paramMethod.getDeclaringClass());
    this._factoryMethod = paramMethod;
  }
  
  public Object _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return this._factoryMethod.invoke(null, new Object[] { paramString });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringFactoryKeyDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */