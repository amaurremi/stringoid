package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;

public final class NullProvider
  implements Serializable
{
  private final boolean _isPrimitive;
  private final Object _nullValue;
  private final Class<?> _rawType;
  
  public NullProvider(JavaType paramJavaType, Object paramObject)
  {
    this._nullValue = paramObject;
    this._isPrimitive = paramJavaType.isPrimitive();
    this._rawType = paramJavaType.getRawClass();
  }
  
  public Object nullValue(DeserializationContext paramDeserializationContext)
  {
    if ((this._isPrimitive) && (paramDeserializationContext.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES))) {
      throw paramDeserializationContext.mappingException("Can not map JSON null into type " + this._rawType.getName() + " (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)");
    }
    return this._nullValue;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/NullProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */