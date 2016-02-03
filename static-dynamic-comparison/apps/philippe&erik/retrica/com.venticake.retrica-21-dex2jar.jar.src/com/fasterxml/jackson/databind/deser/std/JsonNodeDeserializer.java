package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonNodeDeserializer
  extends BaseNodeDeserializer<JsonNode>
{
  private static final JsonNodeDeserializer instance = new JsonNodeDeserializer();
  
  protected JsonNodeDeserializer()
  {
    super(JsonNode.class);
  }
  
  public static JsonDeserializer<? extends JsonNode> getDeserializer(Class<?> paramClass)
  {
    if (paramClass == ObjectNode.class) {
      return JsonNodeDeserializer.ObjectDeserializer.getInstance();
    }
    if (paramClass == ArrayNode.class) {
      return JsonNodeDeserializer.ArrayDeserializer.getInstance();
    }
    return instance;
  }
  
  public JsonNode deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
    {
    default: 
      return deserializeAny(paramJsonParser, paramDeserializationContext, paramDeserializationContext.getNodeFactory());
    case 1: 
      return deserializeObject(paramJsonParser, paramDeserializationContext, paramDeserializationContext.getNodeFactory());
    }
    return deserializeArray(paramJsonParser, paramDeserializationContext, paramDeserializationContext.getNodeFactory());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JsonNodeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */