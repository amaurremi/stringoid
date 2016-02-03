package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.util.regex.Pattern;

public class JdkDeserializers$PatternDeserializer
  extends FromStringDeserializer<Pattern>
{
  public JdkDeserializers$PatternDeserializer()
  {
    super(Pattern.class);
  }
  
  protected Pattern _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return Pattern.compile(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JdkDeserializers$PatternDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */