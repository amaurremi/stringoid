package org.codehaus.jackson.map.deser.std;

import java.net.URL;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$URLDeserializer
  extends FromStringDeserializer
{
  public FromStringDeserializer$URLDeserializer()
  {
    super(URL.class);
  }
  
  protected URL _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return new URL(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/FromStringDeserializer$URLDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */