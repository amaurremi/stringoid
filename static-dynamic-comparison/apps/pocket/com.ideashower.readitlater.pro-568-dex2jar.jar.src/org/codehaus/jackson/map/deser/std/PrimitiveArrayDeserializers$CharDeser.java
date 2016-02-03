package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$CharDeser
  extends PrimitiveArrayDeserializers.Base
{
  public PrimitiveArrayDeserializers$CharDeser()
  {
    super(char[].class);
  }
  
  public char[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    Object localObject1 = paramJsonParser.getCurrentToken();
    if (localObject1 == JsonToken.VALUE_STRING)
    {
      paramDeserializationContext = paramJsonParser.getTextCharacters();
      int i = paramJsonParser.getTextOffset();
      int j = paramJsonParser.getTextLength();
      paramJsonParser = new char[j];
      System.arraycopy(paramDeserializationContext, i, paramJsonParser, 0, j);
      return paramJsonParser;
    }
    if (paramJsonParser.isExpectedStartArrayToken())
    {
      localObject1 = new StringBuilder(64);
      for (;;)
      {
        Object localObject2 = paramJsonParser.nextToken();
        if (localObject2 == JsonToken.END_ARRAY) {
          break;
        }
        if (localObject2 != JsonToken.VALUE_STRING) {
          throw paramDeserializationContext.mappingException(Character.TYPE);
        }
        localObject2 = paramJsonParser.getText();
        if (((String)localObject2).length() != 1) {
          throw JsonMappingException.from(paramJsonParser, "Can not convert a JSON String of length " + ((String)localObject2).length() + " into a char element of char array");
        }
        ((StringBuilder)localObject1).append(((String)localObject2).charAt(0));
      }
      return ((StringBuilder)localObject1).toString().toCharArray();
    }
    if (localObject1 == JsonToken.VALUE_EMBEDDED_OBJECT)
    {
      paramJsonParser = paramJsonParser.getEmbeddedObject();
      if (paramJsonParser == null) {
        return null;
      }
      if ((paramJsonParser instanceof char[])) {
        return (char[])paramJsonParser;
      }
      if ((paramJsonParser instanceof String)) {
        return ((String)paramJsonParser).toCharArray();
      }
      if ((paramJsonParser instanceof byte[])) {
        return Base64Variants.getDefaultVariant().encode((byte[])paramJsonParser, false).toCharArray();
      }
    }
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/PrimitiveArrayDeserializers$CharDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */