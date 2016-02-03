package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.io.NumberInput;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.KeyDeserializer;

public abstract class StdKeyDeserializer
  extends KeyDeserializer
{
  protected final Class _keyClass;
  
  protected StdKeyDeserializer(Class paramClass)
  {
    this._keyClass = paramClass;
  }
  
  protected abstract Object _parse(String paramString, DeserializationContext paramDeserializationContext);
  
  protected double _parseDouble(String paramString)
  {
    return NumberInput.parseDouble(paramString);
  }
  
  protected int _parseInt(String paramString)
  {
    return Integer.parseInt(paramString);
  }
  
  protected long _parseLong(String paramString)
  {
    return Long.parseLong(paramString);
  }
  
  public final Object deserializeKey(String paramString, DeserializationContext paramDeserializationContext)
  {
    Object localObject1;
    if (paramString == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        Object localObject2 = _parse(paramString, paramDeserializationContext);
        localObject1 = localObject2;
        if (localObject2 != null) {
          continue;
        }
        throw paramDeserializationContext.weirdKeyException(this._keyClass, paramString, "not a valid representation");
      }
      catch (Exception localException)
      {
        throw paramDeserializationContext.weirdKeyException(this._keyClass, paramString, "not a valid representation: " + localException.getMessage());
      }
    }
  }
  
  public Class getKeyClass()
  {
    return this._keyClass;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */