package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public final class StdDeserializer$CharacterDeserializer
  extends StdDeserializer.PrimitiveOrWrapperDeserializer
{
  public StdDeserializer$CharacterDeserializer(Class paramClass, Character paramCharacter)
  {
    super(paramClass, paramCharacter);
  }
  
  public Character deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_NUMBER_INT)
    {
      int i = paramJsonParser.getIntValue();
      if ((i >= 0) && (i <= 65535)) {
        return Character.valueOf((char)i);
      }
    }
    else if (localJsonToken == JsonToken.VALUE_STRING)
    {
      paramJsonParser = paramJsonParser.getText();
      if (paramJsonParser.length() == 1) {
        return Character.valueOf(paramJsonParser.charAt(0));
      }
      if (paramJsonParser.length() == 0) {
        return (Character)getEmptyValue();
      }
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdDeserializer$CharacterDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */