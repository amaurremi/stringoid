package org.codehaus.jackson.map.ext;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;

public class JodaDeserializers$DateMidnightDeserializer
  extends JodaDeserializers.JodaDeserializer
{
  public JodaDeserializers$DateMidnightDeserializer()
  {
    super(DateMidnight.class);
  }
  
  public DateMidnight deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (paramJsonParser.isExpectedStartArrayToken())
    {
      paramJsonParser.nextToken();
      int i = paramJsonParser.getIntValue();
      paramJsonParser.nextToken();
      int j = paramJsonParser.getIntValue();
      paramJsonParser.nextToken();
      int k = paramJsonParser.getIntValue();
      if (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
        throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "after DateMidnight ints");
      }
      return new DateMidnight(i, j, k);
    }
    switch (JodaDeserializers.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
    {
    default: 
      throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.START_ARRAY, "expected JSON Array, Number or String");
    case 1: 
      return new DateMidnight(paramJsonParser.getLongValue());
    }
    paramJsonParser = parseLocal(paramJsonParser);
    if (paramJsonParser == null) {
      return null;
    }
    return paramJsonParser.toDateMidnight();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/JodaDeserializers$DateMidnightDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */