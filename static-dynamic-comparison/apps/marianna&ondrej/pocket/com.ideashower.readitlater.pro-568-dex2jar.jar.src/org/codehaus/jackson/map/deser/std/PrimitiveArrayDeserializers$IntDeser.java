package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ArrayBuilders.IntBuilder;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$IntDeser
  extends PrimitiveArrayDeserializers.Base
{
  public PrimitiveArrayDeserializers$IntDeser()
  {
    super(int[].class);
  }
  
  private final int[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
      return null;
    }
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    return new int[] { _parseIntPrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public int[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ArrayBuilders.IntBuilder localIntBuilder = paramDeserializationContext.getArrayBuilders().getIntBuilder();
    int[] arrayOfInt = (int[])localIntBuilder.resetAndStart();
    int i = 0;
    int k;
    if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
    {
      k = _parseIntPrimitive(paramJsonParser, paramDeserializationContext);
      if (i < arrayOfInt.length) {
        break label104;
      }
      arrayOfInt = (int[])localIntBuilder.appendCompletedChunk(arrayOfInt, i);
      i = 0;
    }
    label104:
    for (;;)
    {
      int j = i + 1;
      arrayOfInt[i] = k;
      i = j;
      break;
      return (int[])localIntBuilder.completeAndClearBuffer(arrayOfInt, i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/PrimitiveArrayDeserializers$IntDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */