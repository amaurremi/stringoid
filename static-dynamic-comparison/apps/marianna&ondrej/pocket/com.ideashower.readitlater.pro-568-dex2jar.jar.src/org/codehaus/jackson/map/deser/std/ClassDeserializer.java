package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public class ClassDeserializer
  extends StdScalarDeserializer
{
  public ClassDeserializer()
  {
    super(Class.class);
  }
  
  public Class deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    Object localObject = paramJsonParser.getCurrentToken();
    if (localObject == JsonToken.VALUE_STRING)
    {
      localObject = paramJsonParser.getText();
      if (((String)localObject).indexOf('.') < 0)
      {
        if ("int".equals(localObject)) {
          return Integer.TYPE;
        }
        if ("long".equals(localObject)) {
          return Long.TYPE;
        }
        if ("float".equals(localObject)) {
          return Float.TYPE;
        }
        if ("double".equals(localObject)) {
          return Double.TYPE;
        }
        if ("boolean".equals(localObject)) {
          return Boolean.TYPE;
        }
        if ("byte".equals(localObject)) {
          return Byte.TYPE;
        }
        if ("char".equals(localObject)) {
          return Character.TYPE;
        }
        if ("short".equals(localObject)) {
          return Short.TYPE;
        }
        if ("void".equals(localObject)) {
          return Void.TYPE;
        }
      }
      try
      {
        paramJsonParser = Class.forName(paramJsonParser.getText());
        return paramJsonParser;
      }
      catch (ClassNotFoundException paramJsonParser)
      {
        throw paramDeserializationContext.instantiationException(this._valueClass, paramJsonParser);
      }
    }
    throw paramDeserializationContext.mappingException(this._valueClass, (JsonToken)localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/ClassDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */