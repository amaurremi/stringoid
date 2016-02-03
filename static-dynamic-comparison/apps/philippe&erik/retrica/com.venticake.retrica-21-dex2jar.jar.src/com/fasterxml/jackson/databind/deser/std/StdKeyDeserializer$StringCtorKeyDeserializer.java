package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.lang.reflect.Constructor;

final class StdKeyDeserializer$StringCtorKeyDeserializer
  extends StdKeyDeserializer
{
  protected final Constructor<?> _ctor;
  
  public StdKeyDeserializer$StringCtorKeyDeserializer(Constructor<?> paramConstructor)
  {
    super(paramConstructor.getDeclaringClass());
    this._ctor = paramConstructor;
  }
  
  public Object _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return this._ctor.newInstance(new Object[] { paramString });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$StringCtorKeyDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */