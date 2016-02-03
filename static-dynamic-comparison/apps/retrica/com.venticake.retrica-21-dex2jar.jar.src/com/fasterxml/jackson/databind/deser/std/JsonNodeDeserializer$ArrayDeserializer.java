package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.node.ArrayNode;

final class JsonNodeDeserializer$ArrayDeserializer
  extends BaseNodeDeserializer<ArrayNode>
{
  protected static final ArrayDeserializer _instance = new ArrayDeserializer();
  
  protected JsonNodeDeserializer$ArrayDeserializer()
  {
    super(ArrayNode.class);
  }
  
  public static ArrayDeserializer getInstance()
  {
    return _instance;
  }
  
  public ArrayNode deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (paramJsonParser.isExpectedStartArrayToken()) {
      return deserializeArray(paramJsonParser, paramDeserializationContext, paramDeserializationContext.getNodeFactory());
    }
    throw paramDeserializationContext.mappingException(ArrayNode.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JsonNodeDeserializer$ArrayDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */