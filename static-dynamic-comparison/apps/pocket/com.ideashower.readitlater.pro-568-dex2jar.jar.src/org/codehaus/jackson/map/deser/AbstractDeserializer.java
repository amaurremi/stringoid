package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.type.JavaType;

public class AbstractDeserializer
  extends JsonDeserializer
{
  protected final boolean _acceptBoolean;
  protected final boolean _acceptDouble;
  protected final boolean _acceptInt;
  protected final boolean _acceptString;
  protected final JavaType _baseType;
  
  public AbstractDeserializer(JavaType paramJavaType)
  {
    this._baseType = paramJavaType;
    paramJavaType = paramJavaType.getRawClass();
    this._acceptString = paramJavaType.isAssignableFrom(String.class);
    if ((paramJavaType == Boolean.TYPE) || (paramJavaType.isAssignableFrom(Boolean.class)))
    {
      bool1 = true;
      this._acceptBoolean = bool1;
      if ((paramJavaType != Integer.TYPE) && (!paramJavaType.isAssignableFrom(Integer.class))) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = true;; bool1 = false)
    {
      this._acceptInt = bool1;
      if (paramJavaType != Double.TYPE)
      {
        bool1 = bool2;
        if (!paramJavaType.isAssignableFrom(Double.class)) {}
      }
      else
      {
        bool1 = true;
      }
      this._acceptDouble = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  protected Object _deserializeIfNatural(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
            } while (!this._acceptString);
            return paramJsonParser.getText();
          } while (!this._acceptInt);
          return Integer.valueOf(paramJsonParser.getIntValue());
        } while (!this._acceptDouble);
        return Double.valueOf(paramJsonParser.getDoubleValue());
      } while (!this._acceptBoolean);
      return Boolean.TRUE;
    } while (!this._acceptBoolean);
    return Boolean.FALSE;
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    throw paramDeserializationContext.instantiationException(this._baseType.getRawClass(), "abstract types can only be instantiated with additional type information");
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    Object localObject = _deserializeIfNatural(paramJsonParser, paramDeserializationContext);
    if (localObject != null) {
      return localObject;
    }
    return paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/AbstractDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */