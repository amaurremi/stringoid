package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;

public class StdDeserializer$SqlDateDeserializer
  extends StdScalarDeserializer
{
  public StdDeserializer$SqlDateDeserializer()
  {
    super(java.sql.Date.class);
  }
  
  public java.sql.Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    paramJsonParser = _parseDate(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser == null) {
      return null;
    }
    return new java.sql.Date(paramJsonParser.getTime());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdDeserializer$SqlDateDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */