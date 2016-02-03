package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.charset.Charset;

public class JdkDeserializers$CharsetDeserializer
  extends FromStringDeserializer<Charset>
{
  public JdkDeserializers$CharsetDeserializer()
  {
    super(Charset.class);
  }
  
  protected Charset _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return Charset.forName(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JdkDeserializers$CharsetDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */