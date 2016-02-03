package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JacksonDeserializers$JavaTypeDeserializer
  extends StdScalarDeserializer<JavaType>
{
  public JacksonDeserializers$JavaTypeDeserializer()
  {
    super(JavaType.class);
  }
  
  public JavaType deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_STRING)
    {
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() == 0) {
        return (JavaType)getEmptyValue();
      }
      return paramDeserializationContext.getTypeFactory().constructFromCanonical(paramJsonParser);
    }
    if (localJsonToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
      return (JavaType)paramJsonParser.getEmbeddedObject();
    }
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JacksonDeserializers$JavaTypeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */