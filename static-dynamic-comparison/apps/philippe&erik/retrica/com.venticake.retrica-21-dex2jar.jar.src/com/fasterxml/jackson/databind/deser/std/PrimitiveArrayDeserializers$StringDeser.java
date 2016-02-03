package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.ObjectBuffer;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$StringDeser
  extends PrimitiveArrayDeserializers.Base<String[]>
{
  public PrimitiveArrayDeserializers$StringDeser()
  {
    super(String[].class);
  }
  
  private final String[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    Object localObject = null;
    if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
        return null;
      }
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {}
    for (paramJsonParser = (JsonParser)localObject;; paramJsonParser = _parseString(paramJsonParser, paramDeserializationContext)) {
      return new String[] { paramJsonParser };
    }
  }
  
  public String[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ObjectBuffer localObjectBuffer = paramDeserializationContext.leaseObjectBuffer();
    Object[] arrayOfObject = localObjectBuffer.resetAndStart();
    int i = 0;
    Object localObject = paramJsonParser.nextToken();
    if (localObject != JsonToken.END_ARRAY) {
      if (localObject == JsonToken.VALUE_NULL)
      {
        localObject = null;
        label54:
        if (i < arrayOfObject.length) {
          break label122;
        }
        arrayOfObject = localObjectBuffer.appendCompletedChunk(arrayOfObject);
        i = 0;
      }
    }
    label122:
    for (;;)
    {
      int j = i + 1;
      arrayOfObject[i] = localObject;
      i = j;
      break;
      localObject = _parseString(paramJsonParser, paramDeserializationContext);
      break label54;
      paramJsonParser = (String[])localObjectBuffer.completeAndClearBuffer(arrayOfObject, i, String.class);
      paramDeserializationContext.returnObjectBuffer(localObjectBuffer);
      return paramJsonParser;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$StringDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */