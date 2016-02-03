package com.flurry.org.codehaus.jackson;

import com.flurry.org.codehaus.jackson.type.JavaType;
import com.flurry.org.codehaus.jackson.type.TypeReference;
import java.io.IOException;
import java.util.Iterator;

public abstract class ObjectCodec
{
  public abstract JsonNode createArrayNode();
  
  public abstract JsonNode createObjectNode();
  
  public abstract JsonNode readTree(JsonParser paramJsonParser)
    throws IOException, JsonProcessingException;
  
  public abstract <T> T readValue(JsonParser paramJsonParser, JavaType paramJavaType)
    throws IOException, JsonProcessingException;
  
  public abstract <T> T readValue(JsonParser paramJsonParser, TypeReference<?> paramTypeReference)
    throws IOException, JsonProcessingException;
  
  public abstract <T> T readValue(JsonParser paramJsonParser, Class<T> paramClass)
    throws IOException, JsonProcessingException;
  
  public abstract <T> Iterator<T> readValues(JsonParser paramJsonParser, JavaType paramJavaType)
    throws IOException, JsonProcessingException;
  
  public abstract <T> Iterator<T> readValues(JsonParser paramJsonParser, TypeReference<?> paramTypeReference)
    throws IOException, JsonProcessingException;
  
  public abstract <T> Iterator<T> readValues(JsonParser paramJsonParser, Class<T> paramClass)
    throws IOException, JsonProcessingException;
  
  public abstract JsonParser treeAsTokens(JsonNode paramJsonNode);
  
  public abstract <T> T treeToValue(JsonNode paramJsonNode, Class<T> paramClass)
    throws IOException, JsonProcessingException;
  
  public abstract void writeTree(JsonGenerator paramJsonGenerator, JsonNode paramJsonNode)
    throws IOException, JsonProcessingException;
  
  public abstract void writeValue(JsonGenerator paramJsonGenerator, Object paramObject)
    throws IOException, JsonProcessingException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/ObjectCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */