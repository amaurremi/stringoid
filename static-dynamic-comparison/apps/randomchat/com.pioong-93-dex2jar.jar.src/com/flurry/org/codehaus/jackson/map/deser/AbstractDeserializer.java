package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;

public class AbstractDeserializer
  extends JsonDeserializer<Object>
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
    throws IOException, JsonProcessingException
  {
    switch (paramJsonParser.getCurrentToken())
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
    throws IOException, JsonProcessingException
  {
    throw paramDeserializationContext.instantiationException(this._baseType.getRawClass(), "abstract types can only be instantiated with additional type information");
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    Object localObject = _deserializeIfNatural(paramJsonParser, paramDeserializationContext);
    if (localObject != null) {
      return localObject;
    }
    return paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/AbstractDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */