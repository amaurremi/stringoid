package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.FloatBuilder;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$FloatDeser
  extends PrimitiveArrayDeserializers.Base<float[]>
{
  public PrimitiveArrayDeserializers$FloatDeser()
  {
    super(float[].class);
  }
  
  private final float[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
      return null;
    }
    if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    return new float[] { _parseFloatPrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public float[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ArrayBuilders.FloatBuilder localFloatBuilder = paramDeserializationContext.getArrayBuilders().getFloatBuilder();
    float[] arrayOfFloat = (float[])localFloatBuilder.resetAndStart();
    int i = 0;
    float f;
    if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
    {
      f = _parseFloatPrimitive(paramJsonParser, paramDeserializationContext);
      if (i < arrayOfFloat.length) {
        break label110;
      }
      arrayOfFloat = (float[])localFloatBuilder.appendCompletedChunk(arrayOfFloat, i);
      i = 0;
    }
    label110:
    for (;;)
    {
      int j = i + 1;
      arrayOfFloat[i] = f;
      i = j;
      break;
      return (float[])localFloatBuilder.completeAndClearBuffer(arrayOfFloat, i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$FloatDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */