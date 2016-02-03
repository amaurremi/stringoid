package org.codehaus.jackson.map.deser.std;

import java.util.UUID;
import org.codehaus.jackson.map.DeserializationContext;

final class StdKeyDeserializer$UuidKD
  extends StdKeyDeserializer
{
  protected StdKeyDeserializer$UuidKD()
  {
    super(UUID.class);
  }
  
  public UUID _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return UUID.fromString(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer$UuidKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */