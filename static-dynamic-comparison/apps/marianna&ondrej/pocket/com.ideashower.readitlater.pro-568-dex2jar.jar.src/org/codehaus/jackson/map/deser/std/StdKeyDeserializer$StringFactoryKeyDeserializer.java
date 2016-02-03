package org.codehaus.jackson.map.deser.std;

import java.lang.reflect.Method;
import org.codehaus.jackson.map.DeserializationContext;

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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer$StringFactoryKeyDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */