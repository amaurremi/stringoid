package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.type.TypeFactory;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;

public class JavaTypeDeserializer
  extends StdScalarDeserializer<JavaType>
{
  public JavaTypeDeserializer()
  {
    super(JavaType.class);
  }
  
  public JavaType deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/std/JavaTypeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */