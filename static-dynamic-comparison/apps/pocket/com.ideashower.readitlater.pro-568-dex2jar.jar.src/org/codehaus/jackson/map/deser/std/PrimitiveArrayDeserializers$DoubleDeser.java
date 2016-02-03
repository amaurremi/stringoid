package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ArrayBuilders.DoubleBuilder;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$DoubleDeser
  extends PrimitiveArrayDeserializers.Base
{
  public PrimitiveArrayDeserializers$DoubleDeser()
  {
    super(double[].class);
  }
  
  private final double[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
      return null;
    }
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    return new double[] { _parseDoublePrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public double[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ArrayBuilders.DoubleBuilder localDoubleBuilder = paramDeserializationContext.getArrayBuilders().getDoubleBuilder();
    double[] arrayOfDouble = (double[])localDoubleBuilder.resetAndStart();
    int i = 0;
    double d;
    if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
    {
      d = _parseDoublePrimitive(paramJsonParser, paramDeserializationContext);
      if (i < arrayOfDouble.length) {
        break label110;
      }
      arrayOfDouble = (double[])localDoubleBuilder.appendCompletedChunk(arrayOfDouble, i);
      i = 0;
    }
    label110:
    for (;;)
    {
      int j = i + 1;
      arrayOfDouble[i] = d;
      i = j;
      break;
      return (double[])localDoubleBuilder.completeAndClearBuffer(arrayOfDouble, i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/PrimitiveArrayDeserializers$DoubleDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */