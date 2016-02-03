package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.type.JavaType;

public final class SettableBeanProperty$NullProvider
{
  private final boolean _isPrimitive;
  private final Object _nullValue;
  private final Class _rawType;
  
  protected SettableBeanProperty$NullProvider(JavaType paramJavaType, Object paramObject)
  {
    this._nullValue = paramObject;
    this._isPrimitive = paramJavaType.isPrimitive();
    this._rawType = paramJavaType.getRawClass();
  }
  
  public Object nullValue(DeserializationContext paramDeserializationContext)
  {
    if ((this._isPrimitive) && (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES))) {
      throw paramDeserializationContext.mappingException("Can not map JSON null into type " + this._rawType.getName() + " (set DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)");
    }
    return this._nullValue;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/SettableBeanProperty$NullProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */