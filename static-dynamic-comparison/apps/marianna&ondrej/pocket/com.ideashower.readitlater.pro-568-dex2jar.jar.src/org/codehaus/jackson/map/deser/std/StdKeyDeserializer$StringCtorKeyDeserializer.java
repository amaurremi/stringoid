package org.codehaus.jackson.map.deser.std;

import java.lang.reflect.Constructor;
import org.codehaus.jackson.map.DeserializationContext;

final class StdKeyDeserializer$StringCtorKeyDeserializer
  extends StdKeyDeserializer
{
  protected final Constructor _ctor;
  
  public StdKeyDeserializer$StringCtorKeyDeserializer(Constructor paramConstructor)
  {
    super(paramConstructor.getDeclaringClass());
    this._ctor = paramConstructor;
  }
  
  public Object _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return this._ctor.newInstance(new Object[] { paramString });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer$StringCtorKeyDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */