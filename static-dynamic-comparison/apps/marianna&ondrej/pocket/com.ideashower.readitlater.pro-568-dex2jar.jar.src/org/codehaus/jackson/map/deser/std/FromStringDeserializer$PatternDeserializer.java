package org.codehaus.jackson.map.deser.std;

import java.util.regex.Pattern;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$PatternDeserializer
  extends FromStringDeserializer
{
  public FromStringDeserializer$PatternDeserializer()
  {
    super(Pattern.class);
  }
  
  protected Pattern _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return Pattern.compile(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/FromStringDeserializer$PatternDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */