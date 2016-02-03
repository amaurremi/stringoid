package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;

public class StdDeserializer$StackTraceElementDeserializer
  extends StdScalarDeserializer
{
  public StdDeserializer$StackTraceElementDeserializer()
  {
    super(StackTraceElement.class);
  }
  
  public StackTraceElement deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    Object localObject = paramJsonParser.getCurrentToken();
    if (localObject == JsonToken.START_OBJECT)
    {
      localObject = "";
      String str1 = "";
      String str2 = "";
      int i = -1;
      for (;;)
      {
        JsonToken localJsonToken = paramJsonParser.nextValue();
        if (localJsonToken == JsonToken.END_OBJECT) {
          break;
        }
        String str3 = paramJsonParser.getCurrentName();
        if ("className".equals(str3)) {
          localObject = paramJsonParser.getText();
        } else if ("fileName".equals(str3)) {
          str2 = paramJsonParser.getText();
        } else if ("lineNumber".equals(str3))
        {
          if (localJsonToken.isNumeric()) {
            i = paramJsonParser.getIntValue();
          } else {
            throw JsonMappingException.from(paramJsonParser, "Non-numeric token (" + localJsonToken + ") for property 'lineNumber'");
          }
        }
        else if ("methodName".equals(str3)) {
          str1 = paramJsonParser.getText();
        } else if (!"nativeMethod".equals(str3)) {
          handleUnknownProperty(paramJsonParser, paramDeserializationContext, this._valueClass, str3);
        }
      }
      return new StackTraceElement((String)localObject, str1, str2, i);
    }
    throw paramDeserializationContext.mappingException(this._valueClass, (JsonToken)localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdDeserializer$StackTraceElementDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */