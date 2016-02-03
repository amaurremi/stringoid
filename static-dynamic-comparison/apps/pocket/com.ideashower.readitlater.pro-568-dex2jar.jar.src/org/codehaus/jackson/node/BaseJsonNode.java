package org.codehaus.jackson.node;

import java.util.List;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonSerializableWithType;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;

public abstract class BaseJsonNode
  extends JsonNode
  implements JsonSerializableWithType
{
  public abstract JsonToken asToken();
  
  public ObjectNode findParent(String paramString)
  {
    return null;
  }
  
  public List findParents(String paramString, List paramList)
  {
    return paramList;
  }
  
  public final JsonNode findPath(String paramString)
  {
    JsonNode localJsonNode = findValue(paramString);
    paramString = localJsonNode;
    if (localJsonNode == null) {
      paramString = MissingNode.getInstance();
    }
    return paramString;
  }
  
  public JsonNode findValue(String paramString)
  {
    return null;
  }
  
  public List findValues(String paramString, List paramList)
  {
    return paramList;
  }
  
  public List findValuesAsText(String paramString, List paramList)
  {
    return paramList;
  }
  
  public JsonParser.NumberType getNumberType()
  {
    return null;
  }
  
  public abstract void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider);
  
  public abstract void serializeWithType(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer);
  
  public JsonParser traverse()
  {
    return new TreeTraversingParser(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/node/BaseJsonNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */