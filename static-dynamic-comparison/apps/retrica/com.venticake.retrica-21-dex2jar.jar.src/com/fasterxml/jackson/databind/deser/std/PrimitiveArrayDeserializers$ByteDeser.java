package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.ByteBuilder;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$ByteDeser
  extends PrimitiveArrayDeserializers.Base<byte[]>
{
  public PrimitiveArrayDeserializers$ByteDeser()
  {
    super(byte[].class);
  }
  
  private final byte[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
      return null;
    }
    if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {}
    for (int i = paramJsonParser.getByteValue();; i = 0)
    {
      return new byte[] { i };
      if (localJsonToken != JsonToken.VALUE_NULL) {
        throw paramDeserializationContext.mappingException(this._valueClass.getComponentType());
      }
    }
  }
  
  public byte[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    Object localObject = paramJsonParser.getCurrentToken();
    if (localObject == JsonToken.VALUE_STRING) {
      return paramJsonParser.getBinaryValue(paramDeserializationContext.getBase64Variant());
    }
    if (localObject == JsonToken.VALUE_EMBEDDED_OBJECT)
    {
      localObject = paramJsonParser.getEmbeddedObject();
      if (localObject == null) {
        return null;
      }
      if ((localObject instanceof byte[])) {
        return (byte[])localObject;
      }
    }
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ArrayBuilders.ByteBuilder localByteBuilder = paramDeserializationContext.getArrayBuilders().getByteBuilder();
    localObject = (byte[])localByteBuilder.resetAndStart();
    int j = 0;
    JsonToken localJsonToken = paramJsonParser.nextToken();
    int i;
    if (localJsonToken != JsonToken.END_ARRAY) {
      if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT))
      {
        i = paramJsonParser.getByteValue();
        label132:
        if (j < localObject.length) {
          break label214;
        }
        localObject = (byte[])localByteBuilder.appendCompletedChunk(localObject, j);
        j = 0;
      }
    }
    label214:
    for (;;)
    {
      int k = j + 1;
      localObject[j] = i;
      j = k;
      break;
      if (localJsonToken != JsonToken.VALUE_NULL) {
        throw paramDeserializationContext.mappingException(this._valueClass.getComponentType());
      }
      i = 0;
      break label132;
      return (byte[])localByteBuilder.completeAndClearBuffer(localObject, j);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$ByteDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */