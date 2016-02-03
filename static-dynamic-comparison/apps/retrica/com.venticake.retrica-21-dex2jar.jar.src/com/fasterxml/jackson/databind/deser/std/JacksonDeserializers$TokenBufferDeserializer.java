package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.TokenBuffer;

@JacksonStdImpl
public class JacksonDeserializers$TokenBufferDeserializer
  extends StdScalarDeserializer<TokenBuffer>
{
  public JacksonDeserializers$TokenBufferDeserializer()
  {
    super(TokenBuffer.class);
  }
  
  public TokenBuffer deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    paramDeserializationContext = new TokenBuffer(paramJsonParser.getCodec());
    paramDeserializationContext.copyCurrentStructure(paramJsonParser);
    return paramDeserializationContext;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JacksonDeserializers$TokenBufferDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */