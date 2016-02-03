package org.codehaus.jackson.map.deser.std;

import java.util.EnumMap;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.util.EnumResolver;

public class EnumMapDeserializer
  extends StdDeserializer
{
  protected final Class _enumClass;
  protected final JsonDeserializer _keyDeserializer;
  protected final JsonDeserializer _valueDeserializer;
  
  public EnumMapDeserializer(Class paramClass, JsonDeserializer paramJsonDeserializer1, JsonDeserializer paramJsonDeserializer2)
  {
    super(EnumMap.class);
    this._enumClass = paramClass;
    this._keyDeserializer = paramJsonDeserializer1;
    this._valueDeserializer = paramJsonDeserializer2;
  }
  
  @Deprecated
  public EnumMapDeserializer(EnumResolver paramEnumResolver, JsonDeserializer paramJsonDeserializer)
  {
    this(paramEnumResolver.getEnumClass(), new EnumDeserializer(paramEnumResolver), paramJsonDeserializer);
  }
  
  private EnumMap constructMap()
  {
    return new EnumMap(this._enumClass);
  }
  
  public EnumMap deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (paramJsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
      throw paramDeserializationContext.mappingException(EnumMap.class);
    }
    EnumMap localEnumMap = constructMap();
    if (paramJsonParser.nextToken() != JsonToken.END_OBJECT)
    {
      Enum localEnum = (Enum)this._keyDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
      if (localEnum == null) {
        throw paramDeserializationContext.weirdStringException(this._enumClass, "value not one of declared Enum instance names");
      }
      if (paramJsonParser.nextToken() == JsonToken.VALUE_NULL) {}
      for (Object localObject = null;; localObject = this._valueDeserializer.deserialize(paramJsonParser, paramDeserializationContext))
      {
        localEnumMap.put(localEnum, localObject);
        break;
      }
    }
    return localEnumMap;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/EnumMapDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */