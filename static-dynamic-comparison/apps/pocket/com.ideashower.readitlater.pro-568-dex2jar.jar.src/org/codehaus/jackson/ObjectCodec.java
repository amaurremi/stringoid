package org.codehaus.jackson;

import java.util.Iterator;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

public abstract class ObjectCodec
{
  public abstract JsonNode createArrayNode();
  
  public abstract JsonNode createObjectNode();
  
  public abstract JsonNode readTree(JsonParser paramJsonParser);
  
  public abstract Object readValue(JsonParser paramJsonParser, Class paramClass);
  
  public abstract Object readValue(JsonParser paramJsonParser, JavaType paramJavaType);
  
  public abstract Object readValue(JsonParser paramJsonParser, TypeReference paramTypeReference);
  
  public abstract Iterator readValues(JsonParser paramJsonParser, Class paramClass);
  
  public abstract Iterator readValues(JsonParser paramJsonParser, JavaType paramJavaType);
  
  public abstract Iterator readValues(JsonParser paramJsonParser, TypeReference paramTypeReference);
  
  public abstract JsonParser treeAsTokens(JsonNode paramJsonNode);
  
  public abstract Object treeToValue(JsonNode paramJsonNode, Class paramClass);
  
  public abstract void writeTree(JsonGenerator paramJsonGenerator, JsonNode paramJsonNode);
  
  public abstract void writeValue(JsonGenerator paramJsonGenerator, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/ObjectCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */