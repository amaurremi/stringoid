package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig.Feature;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.map.annotate.JacksonStdImpl;
import com.flurry.org.codehaus.jackson.map.util.ObjectBuffer;
import java.io.IOException;
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
    throws IOException, JsonProcessingException
  {
    switch (paramJsonParser.getCurrentToken())
    {
    case ???: 
    case ???: 
    default: 
      throw paramDeserializationContext.mappingException(Object.class);
    case ???: 
      return mapObject(paramJsonParser, paramDeserializationContext);
    case ???: 
      return mapArray(paramJsonParser, paramDeserializationContext);
    case ???: 
      return mapObject(paramJsonParser, paramDeserializationContext);
    case ???: 
      return paramJsonParser.getEmbeddedObject();
    case ???: 
      return paramJsonParser.getText();
    case ???: 
      if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS)) {
        return paramJsonParser.getBigIntegerValue();
      }
      return paramJsonParser.getNumberValue();
    case ???: 
      if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS)) {
        return paramJsonParser.getDecimalValue();
      }
      return Double.valueOf(paramJsonParser.getDoubleValue());
    case ???: 
      return Boolean.TRUE;
    case ???: 
      return Boolean.FALSE;
    }
    return null;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    switch (localJsonToken)
    {
    case ???: 
    case ???: 
    default: 
      throw paramDeserializationContext.mappingException(Object.class);
    case ???: 
    case ???: 
    case ???: 
      return paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
    case ???: 
      return paramJsonParser.getText();
    case ???: 
      if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS)) {
        return paramJsonParser.getBigIntegerValue();
      }
      return Integer.valueOf(paramJsonParser.getIntValue());
    case ???: 
      if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS)) {
        return paramJsonParser.getDecimalValue();
      }
      return Double.valueOf(paramJsonParser.getDoubleValue());
    case ???: 
      return Boolean.TRUE;
    case ???: 
      return Boolean.FALSE;
    case ???: 
      return paramJsonParser.getEmbeddedObject();
    }
    return null;
  }
  
  protected Object mapArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
      return mapArrayToArray(paramJsonParser, paramDeserializationContext);
    }
    if (paramJsonParser.nextToken() == JsonToken.END_ARRAY) {
      return new ArrayList(4);
    }
    ObjectBuffer localObjectBuffer = paramDeserializationContext.leaseObjectBuffer();
    Object localObject2 = localObjectBuffer.resetAndStart();
    int i = 0;
    int j = 0;
    for (;;)
    {
      Object localObject3 = deserialize(paramJsonParser, paramDeserializationContext);
      int k = j + 1;
      j = i;
      Object localObject1 = localObject2;
      if (i >= localObject2.length)
      {
        localObject1 = localObjectBuffer.appendCompletedChunk((Object[])localObject2);
        j = 0;
      }
      i = j + 1;
      localObject1[j] = localObject3;
      if (paramJsonParser.nextToken() == JsonToken.END_ARRAY)
      {
        paramJsonParser = new ArrayList((k >> 3) + k + 1);
        localObjectBuffer.completeAndClearBuffer((Object[])localObject1, i, paramJsonParser);
        return paramJsonParser;
      }
      j = k;
      localObject2 = localObject1;
    }
  }
  
  protected Object[] mapArrayToArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (paramJsonParser.nextToken() == JsonToken.END_ARRAY) {
      return NO_OBJECTS;
    }
    ObjectBuffer localObjectBuffer = paramDeserializationContext.leaseObjectBuffer();
    Object localObject1 = localObjectBuffer.resetAndStart();
    int i = 0;
    for (;;)
    {
      Object localObject3 = deserialize(paramJsonParser, paramDeserializationContext);
      int j = i;
      Object localObject2 = localObject1;
      if (i >= localObject1.length)
      {
        localObject2 = localObjectBuffer.appendCompletedChunk((Object[])localObject1);
        j = 0;
      }
      i = j + 1;
      localObject2[j] = localObject3;
      if (paramJsonParser.nextToken() == JsonToken.END_ARRAY) {
        return localObjectBuffer.completeAndClearBuffer((Object[])localObject2, i);
      }
      localObject1 = localObject2;
    }
  }
  
  protected Object mapObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/std/UntypedObjectDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */