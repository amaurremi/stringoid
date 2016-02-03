package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.node.ObjectNode;

final class JsonNodeDeserializer$ObjectDeserializer
  extends BaseNodeDeserializer<ObjectNode>
{
  protected static final ObjectDeserializer _instance = new ObjectDeserializer();
  
  protected JsonNodeDeserializer$ObjectDeserializer()
  {
    super(ObjectNode.class);
  }
  
  public static ObjectDeserializer getInstance()
  {
    return _instance;
  }
  
  public ObjectNode deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.START_OBJECT)
    {
      paramJsonParser.nextToken();
      return deserializeObject(paramJsonParser, paramDeserializationContext, paramDeserializationContext.getNodeFactory());
    }
    if (paramJsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
      return deserializeObject(paramJsonParser, paramDeserializationContext, paramDeserializationContext.getNodeFactory());
    }
    throw paramDeserializationContext.mappingException(ObjectNode.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JsonNodeDeserializer$ObjectDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */