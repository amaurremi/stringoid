package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.net.URL;

public class JdkDeserializers$URLDeserializer
  extends FromStringDeserializer<URL>
{
  public JdkDeserializers$URLDeserializer()
  {
    super(URL.class);
  }
  
  protected URL _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return new URL(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JdkDeserializers$URLDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */