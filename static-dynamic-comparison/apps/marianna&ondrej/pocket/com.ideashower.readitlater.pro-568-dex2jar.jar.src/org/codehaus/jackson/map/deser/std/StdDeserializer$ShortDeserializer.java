package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public final class StdDeserializer$ShortDeserializer
  extends StdDeserializer.PrimitiveOrWrapperDeserializer
{
  public StdDeserializer$ShortDeserializer(Class paramClass, Short paramShort)
  {
    super(paramClass, paramShort);
  }
  
  public Short deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    return _parseShort(paramJsonParser, paramDeserializationContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdDeserializer$ShortDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */