package org.codehaus.jackson.map.deser.std;

import java.net.URI;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$URIDeserializer
  extends FromStringDeserializer
{
  public FromStringDeserializer$URIDeserializer()
  {
    super(URI.class);
  }
  
  protected URI _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return URI.create(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/FromStringDeserializer$URIDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */