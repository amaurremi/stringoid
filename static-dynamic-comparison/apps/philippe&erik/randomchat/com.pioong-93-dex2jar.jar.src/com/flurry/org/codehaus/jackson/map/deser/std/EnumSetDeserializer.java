package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.map.util.EnumResolver;
import java.io.IOException;
import java.util.EnumSet;

public class EnumSetDeserializer
  extends StdDeserializer<EnumSet<?>>
{
  protected final Class<Enum> _enumClass;
  protected final JsonDeserializer<Enum<?>> _enumDeserializer;
  
  public EnumSetDeserializer(EnumResolver paramEnumResolver)
  {
    this(paramEnumResolver.getEnumClass(), new EnumDeserializer(paramEnumResolver));
  }
  
  public EnumSetDeserializer(Class<?> paramClass, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(EnumSet.class);
    this._enumClass = paramClass;
    this._enumDeserializer = paramJsonDeserializer;
  }
  
  private EnumSet constructSet()
  {
    return EnumSet.noneOf(this._enumClass);
  }
  
  public EnumSet<?> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
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
    throws IOException, JsonProcessingException
  {
    return paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/std/EnumSetDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */