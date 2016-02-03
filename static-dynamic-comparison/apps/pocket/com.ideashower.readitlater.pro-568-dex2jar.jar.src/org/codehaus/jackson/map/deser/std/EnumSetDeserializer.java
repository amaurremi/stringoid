package org.codehaus.jackson.map.deser.std;

import java.util.EnumSet;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.util.EnumResolver;

public class EnumSetDeserializer
  extends StdDeserializer
{
  protected final Class _enumClass;
  protected final JsonDeserializer _enumDeserializer;
  
  public EnumSetDeserializer(Class paramClass, JsonDeserializer paramJsonDeserializer)
  {
    super(EnumSet.class);
    this._enumClass = paramClass;
    this._enumDeserializer = paramJsonDeserializer;
  }
  
  public EnumSetDeserializer(EnumResolver paramEnumResolver)
  {
    this(paramEnumResolver.getEnumClass(), new EnumDeserializer(paramEnumResolver));
  }
  
  private EnumSet constructSet()
  {
    return EnumSet.noneOf(this._enumClass);
  }
  
  public EnumSet deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      throw paramDeserializationContext.mappingException(EnumSet.class);
    }
    EnumSet localEnumSet = constructSet();
    for (;;)
    {
      JsonToken localJsonToken = paramJsonParser.nextToken();
      if (localJsonToken == JsonToken.END_ARRAY) {
        break;
      }
      if (localJsonToken == JsonToken.VALUE_NULL) {
        throw paramDeserializationContext.mappingException(this._enumClass);
      }
      localEnumSet.add((Enum)this._enumDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
    }
    return localEnumSet;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/EnumSetDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */