package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@JacksonStdImpl
public class UntypedObjectDeserializer
  extends StdDeserializer<Object>
{
  private static final Object[] NO_OBJECTS = new Object[0];
  
  public UntypedObjectDeserializer()
  {
    super(Object.class);
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
    {
    case 2: 
    case 4: 
    default: 
      throw paramDeserializationContext.mappingException(Object.class);
    case 1: 
      return mapObject(paramJsonParser, paramDeserializationContext);
    case 3: 
      return mapArray(paramJsonParser, paramDeserializationContext);
    case 5: 
      return mapObject(paramJsonParser, paramDeserializationContext);
    case 6: 
      return paramJsonParser.getEmbeddedObject();
    case 7: 
      return paramJsonParser.getText();
    case 8: 
      if (paramDeserializationContext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
        return paramJsonParser.getBigIntegerValue();
      }
      return paramJsonParser.getNumberValue();
    case 9: 
      if (paramDeserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
        return paramJsonParser.getDecimalValue();
      }
      return Double.valueOf(paramJsonParser.getDoubleValue());
    case 10: 
      return Boolean.TRUE;
    case 11: 
      return Boolean.FALSE;
    }
    return null;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[localJsonToken.ordinal()])
    {
    case 2: 
    case 4: 
    default: 
      throw paramDeserializationContext.mappingException(Object.class);
    case 1: 
    case 3: 
    case 5: 
      return paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
    case 7: 
      return paramJsonParser.getText();
    case 8: 
      if (paramDeserializationContext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
        return paramJsonParser.getBigIntegerValue();
      }
      return paramJsonParser.getNumberValue();
    case 9: 
      if (paramDeserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
        return paramJsonParser.getDecimalValue();
      }
      return Double.valueOf(paramJsonParser.getDoubleValue());
    case 10: 
      return Boolean.TRUE;
    case 11: 
      return Boolean.FALSE;
    case 6: 
      return paramJsonParser.getEmbeddedObject();
    }
    return null;
  }
  
  protected Object mapArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (paramDeserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
      return mapArrayToArray(paramJsonParser, paramDeserializationContext);
    }
    if (paramJsonParser.nextToken() == JsonToken.END_ARRAY) {
      return new ArrayList(4);
    }
    ObjectBuffer localObjectBuffer = paramDeserializationContext.leaseObjectBuffer();
    Object localObject2 = localObjectBuffer.resetAndStart();
    int i = 0;
    int j = 0;
    Object localObject3 = deserialize(paramJsonParser, paramDeserializationContext);
    int k = j + 1;
    Object localObject1;
    if (i >= localObject2.length)
    {
      localObject1 = localObjectBuffer.appendCompletedChunk((Object[])localObject2);
      i = 0;
    }
    for (;;)
    {
      int m = i + 1;
      localObject1[i] = localObject3;
      j = k;
      i = m;
      localObject2 = localObject1;
      if (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
        break;
      }
      paramJsonParser = new ArrayList(k + (k >> 3) + 1);
      localObjectBuffer.completeAndClearBuffer((Object[])localObject1, m, paramJsonParser);
      return paramJsonParser;
      localObject1 = localObject2;
    }
  }
  
  protected Object[] mapArrayToArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (paramJsonParser.nextToken() == JsonToken.END_ARRAY) {
      return NO_OBJECTS;
    }
    ObjectBuffer localObjectBuffer = paramDeserializationContext.leaseObjectBuffer();
    Object localObject1 = localObjectBuffer.resetAndStart();
    int i = 0;
    Object localObject3 = deserialize(paramJsonParser, paramDeserializationContext);
    Object localObject2;
    if (i >= localObject1.length)
    {
      localObject2 = localObjectBuffer.appendCompletedChunk((Object[])localObject1);
      i = 0;
    }
    for (;;)
    {
      int j = i + 1;
      localObject2[i] = localObject3;
      i = j;
      localObject1 = localObject2;
      if (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
        break;
      }
      return localObjectBuffer.completeAndClearBuffer((Object[])localObject2, j);
      localObject2 = localObject1;
    }
  }
  
  protected Object mapObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {
      localObject1 = paramJsonParser.nextToken();
    }
    if (localObject1 != JsonToken.FIELD_NAME) {
      return new LinkedHashMap(4);
    }
    localObject1 = paramJsonParser.getText();
    paramJsonParser.nextToken();
    localObject2 = deserialize(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser.nextToken() != JsonToken.FIELD_NAME)
    {
      paramJsonParser = new LinkedHashMap(4);
      paramJsonParser.put(localObject1, localObject2);
      return paramJsonParser;
    }
    String str = paramJsonParser.getText();
    paramJsonParser.nextToken();
    Object localObject3 = deserialize(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser.nextToken() != JsonToken.FIELD_NAME)
    {
      paramJsonParser = new LinkedHashMap(4);
      paramJsonParser.put(localObject1, localObject2);
      paramJsonParser.put(str, localObject3);
      return paramJsonParser;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(localObject1, localObject2);
    localLinkedHashMap.put(str, localObject3);
    do
    {
      localObject1 = paramJsonParser.getText();
      paramJsonParser.nextToken();
      localLinkedHashMap.put(localObject1, deserialize(paramJsonParser, paramDeserializationContext));
    } while (paramJsonParser.nextToken() != JsonToken.END_OBJECT);
    return localLinkedHashMap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/UntypedObjectDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */