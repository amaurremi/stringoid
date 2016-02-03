package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;

abstract class BaseNodeDeserializer
  extends StdDeserializer
{
  public BaseNodeDeserializer(Class paramClass)
  {
    super(paramClass);
  }
  
  protected void _handleDuplicateField(String paramString, ObjectNode paramObjectNode, JsonNode paramJsonNode1, JsonNode paramJsonNode2) {}
  
  protected void _reportProblem(JsonParser paramJsonParser, String paramString)
  {
    throw new JsonMappingException(paramString, paramJsonParser.getTokenLocation());
  }
  
  protected final JsonNode deserializeAny(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonNodeFactory paramJsonNodeFactory)
  {
    switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
    {
    case 4: 
    default: 
      throw paramDeserializationContext.mappingException(getValueClass());
    case 1: 
      return deserializeObject(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
    case 2: 
      return deserializeArray(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
    case 5: 
      return deserializeObject(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
    case 6: 
      return paramJsonNodeFactory.POJONode(paramJsonParser.getEmbeddedObject());
    case 3: 
      return paramJsonNodeFactory.textNode(paramJsonParser.getText());
    case 7: 
      JsonParser.NumberType localNumberType = paramJsonParser.getNumberType();
      if ((localNumberType == JsonParser.NumberType.BIG_INTEGER) || (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS))) {
        return paramJsonNodeFactory.numberNode(paramJsonParser.getBigIntegerValue());
      }
      if (localNumberType == JsonParser.NumberType.INT) {
        return paramJsonNodeFactory.numberNode(paramJsonParser.getIntValue());
      }
      return paramJsonNodeFactory.numberNode(paramJsonParser.getLongValue());
    case 8: 
      if ((paramJsonParser.getNumberType() == JsonParser.NumberType.BIG_DECIMAL) || (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS))) {
        return paramJsonNodeFactory.numberNode(paramJsonParser.getDecimalValue());
      }
      return paramJsonNodeFactory.numberNode(paramJsonParser.getDoubleValue());
    case 9: 
      return paramJsonNodeFactory.booleanNode(true);
    case 10: 
      return paramJsonNodeFactory.booleanNode(false);
    }
    return paramJsonNodeFactory.nullNode();
  }
  
  protected final ArrayNode deserializeArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonNodeFactory paramJsonNodeFactory)
  {
    ArrayNode localArrayNode = paramJsonNodeFactory.arrayNode();
    for (;;)
    {
      switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.nextToken().ordinal()])
      {
      default: 
        localArrayNode.add(deserializeAny(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory));
        break;
      case 1: 
        localArrayNode.add(deserializeObject(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory));
        break;
      case 2: 
        localArrayNode.add(deserializeArray(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory));
        break;
      case 3: 
        localArrayNode.add(paramJsonNodeFactory.textNode(paramJsonParser.getText()));
      }
    }
    return localArrayNode;
  }
  
  protected final ObjectNode deserializeObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonNodeFactory paramJsonNodeFactory)
  {
    ObjectNode localObjectNode = paramJsonNodeFactory.objectNode();
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {
      localObject1 = paramJsonParser.nextToken();
    }
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      localObject2 = paramJsonParser.getCurrentName();
      switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.nextToken().ordinal()])
      {
      default: 
        localObject1 = deserializeAny(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
      }
      for (;;)
      {
        JsonNode localJsonNode = localObjectNode.put((String)localObject2, (JsonNode)localObject1);
        if (localJsonNode != null) {
          _handleDuplicateField((String)localObject2, localObjectNode, localJsonNode, (JsonNode)localObject1);
        }
        localObject1 = paramJsonParser.nextToken();
        break;
        localObject1 = deserializeObject(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
        continue;
        localObject1 = deserializeArray(paramJsonParser, paramDeserializationContext, paramJsonNodeFactory);
        continue;
        localObject1 = paramJsonNodeFactory.textNode(paramJsonParser.getText());
      }
    }
    return localObjectNode;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/BaseNodeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */