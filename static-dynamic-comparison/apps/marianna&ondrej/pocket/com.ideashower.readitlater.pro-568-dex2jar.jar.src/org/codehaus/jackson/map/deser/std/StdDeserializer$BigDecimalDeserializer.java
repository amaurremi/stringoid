package org.codehaus.jackson.map.deser.std;

import java.math.BigDecimal;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public class StdDeserializer$BigDecimalDeserializer
  extends StdScalarDeserializer
{
  public StdDeserializer$BigDecimalDeserializer()
  {
    super(BigDecimal.class);
  }
  
  public BigDecimal deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      return paramJsonParser.getDecimalValue();
    }
    if (localJsonToken == JsonToken.VALUE_STRING)
    {
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() == 0) {
        return null;
      }
      try
      {
        paramJsonParser = new BigDecimal(paramJsonParser);
        return paramJsonParser;
      }
      catch (IllegalArgumentException paramJsonParser)
      {
        throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid representation");
      }
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdDeserializer$BigDecimalDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */