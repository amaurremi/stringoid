package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ArrayBuilders.BooleanBuilder;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$BooleanDeser
  extends PrimitiveArrayDeserializers.Base
{
  public PrimitiveArrayDeserializers$BooleanDeser()
  {
    super(boolean[].class);
  }
  
  private final boolean[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
      return null;
    }
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    return new boolean[] { _parseBooleanPrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public boolean[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ArrayBuilders.BooleanBuilder localBooleanBuilder = paramDeserializationContext.getArrayBuilders().getBooleanBuilder();
    boolean[] arrayOfBoolean = (boolean[])localBooleanBuilder.resetAndStart();
    int i = 0;
    boolean bool;
    if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
    {
      bool = _parseBooleanPrimitive(paramJsonParser, paramDeserializationContext);
      if (i < arrayOfBoolean.length) {
        break label104;
      }
      arrayOfBoolean = (boolean[])localBooleanBuilder.appendCompletedChunk(arrayOfBoolean, i);
      i = 0;
    }
    label104:
    for (;;)
    {
      int j = i + 1;
      arrayOfBoolean[i] = bool;
      i = j;
      break;
      return (boolean[])localBooleanBuilder.completeAndClearBuffer(arrayOfBoolean, i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/PrimitiveArrayDeserializers$BooleanDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */