package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.LongBuilder;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$LongDeser
  extends PrimitiveArrayDeserializers.Base<long[]>
{
  public PrimitiveArrayDeserializers$LongDeser()
  {
    super(long[].class);
  }
  
  private final long[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
      return null;
    }
    if (!paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    return new long[] { _parseLongPrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public long[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ArrayBuilders.LongBuilder localLongBuilder = paramDeserializationContext.getArrayBuilders().getLongBuilder();
    long[] arrayOfLong = (long[])localLongBuilder.resetAndStart();
    int i = 0;
    long l;
    if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
    {
      l = _parseLongPrimitive(paramJsonParser, paramDeserializationContext);
      if (i < arrayOfLong.length) {
        break label104;
      }
      arrayOfLong = (long[])localLongBuilder.appendCompletedChunk(arrayOfLong, i);
      i = 0;
    }
    label104:
    for (;;)
    {
      int j = i + 1;
      arrayOfLong[i] = l;
      i = j;
      break;
      return (long[])localLongBuilder.completeAndClearBuffer(arrayOfLong, i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/PrimitiveArrayDeserializers$LongDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */