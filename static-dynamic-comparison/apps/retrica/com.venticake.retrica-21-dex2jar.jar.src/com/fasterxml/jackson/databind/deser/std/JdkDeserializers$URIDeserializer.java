package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.net.URI;

public class JdkDeserializers$URIDeserializer
  extends FromStringDeserializer<URI>
{
  public JdkDeserializers$URIDeserializer()
  {
    super(URI.class);
  }
  
  protected URI _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return URI.create(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JdkDeserializers$URIDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */