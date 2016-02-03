package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;

public class JavaTypeDeserializer
  extends StdScalarDeserializer
{
  public JavaTypeDeserializer()
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/JavaTypeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */