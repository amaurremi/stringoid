package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import java.io.Serializable;

final class StdKeyDeserializer$DelegatingKD
  extends KeyDeserializer
  implements Serializable
{
  protected final JsonDeserializer<?> _delegate;
  protected final Class<?> _keyClass;
  
  protected StdKeyDeserializer$DelegatingKD(Class<?> paramClass, JsonDeserializer<?> paramJsonDeserializer)
  {
    this._keyClass = paramClass;
    this._delegate = paramJsonDeserializer;
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
        Object localObject2 = this._delegate.deserialize(paramDeserializationContext.getParser(), paramDeserializationContext);
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdKeyDeserializer$DelegatingKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */