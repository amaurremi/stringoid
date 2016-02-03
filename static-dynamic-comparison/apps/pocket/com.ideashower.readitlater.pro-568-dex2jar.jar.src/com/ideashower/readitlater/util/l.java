package com.ideashower.readitlater.util;

import java.io.IOException;
import org.apache.a.c.k;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public class l
{
  private static ObjectMapper a;
  private static JsonFactory b;
  
  public static int a(JsonNode paramJsonNode, String paramString, int paramInt)
  {
    paramJsonNode = paramJsonNode.get(paramString);
    if ((paramJsonNode == null) || (paramJsonNode.isNull())) {
      return paramInt;
    }
    return paramJsonNode.asInt(paramInt);
  }
  
  public static long a(JsonNode paramJsonNode, String paramString, long paramLong)
  {
    paramJsonNode = paramJsonNode.get(paramString);
    if ((paramJsonNode == null) || (paramJsonNode.isNull())) {
      return paramLong;
    }
    return paramJsonNode.asLong(paramLong);
  }
  
  private static String a(JsonNode paramJsonNode)
  {
    if (paramJsonNode.isValueNode()) {
      return paramJsonNode.asText();
    }
    return paramJsonNode.toString();
  }
  
  public static String a(JsonNode paramJsonNode, String paramString1, String paramString2)
  {
    paramJsonNode = paramJsonNode.get(paramString1);
    if ((paramJsonNode == null) || (paramJsonNode.isNull())) {
      return paramString2;
    }
    return a(paramJsonNode);
  }
  
  public static String a(JsonParser paramJsonParser)
  {
    if (paramJsonParser.getCurrentToken() != JsonToken.VALUE_NULL) {
      return paramJsonParser.getText();
    }
    return null;
  }
  
  public static ObjectMapper a()
  {
    if (a == null) {
      a = new ObjectMapper();
    }
    return a;
  }
  
  public static ObjectNode a(String paramString)
  {
    if (k.c(paramString)) {
      return null;
    }
    ObjectMapper localObjectMapper = a();
    try
    {
      paramString = (ObjectNode)localObjectMapper.readTree(paramString);
      return paramString;
    }
    catch (JsonProcessingException paramString)
    {
      for (;;)
      {
        e.a(paramString);
        paramString = null;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        e.a(paramString);
        paramString = null;
      }
    }
  }
  
  public static ObjectNode a(ObjectNode paramObjectNode, String paramString)
  {
    return b(paramObjectNode.get(paramString));
  }
  
  public static boolean a(JsonNode paramJsonNode, String paramString, boolean paramBoolean)
  {
    paramJsonNode = paramJsonNode.get(paramString);
    if ((paramJsonNode == null) || (paramJsonNode.isNull())) {
      return paramBoolean;
    }
    return paramJsonNode.asBoolean(paramBoolean);
  }
  
  public static ArrayNode b(String paramString)
  {
    if (k.c(paramString)) {
      return null;
    }
    ObjectMapper localObjectMapper = a();
    try
    {
      paramString = (ArrayNode)localObjectMapper.readTree(paramString);
      return paramString;
    }
    catch (JsonProcessingException paramString)
    {
      for (;;)
      {
        e.a(paramString);
        paramString = null;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        e.a(paramString);
        paramString = null;
      }
    }
  }
  
  public static ArrayNode b(ObjectNode paramObjectNode, String paramString)
  {
    return c(paramObjectNode.get(paramString));
  }
  
  public static ObjectNode b()
  {
    return a().createObjectNode();
  }
  
  private static ObjectNode b(JsonNode paramJsonNode)
  {
    if ((paramJsonNode == null) || (!paramJsonNode.isObject())) {
      return null;
    }
    return (ObjectNode)paramJsonNode;
  }
  
  public static ObjectNode b(JsonParser paramJsonParser)
  {
    try
    {
      paramJsonParser = (ObjectNode)a().readTree(paramJsonParser);
      return paramJsonParser;
    }
    catch (Exception paramJsonParser)
    {
      e.a(paramJsonParser);
    }
    return null;
  }
  
  public static ArrayNode c()
  {
    return a().createArrayNode();
  }
  
  private static ArrayNode c(JsonNode paramJsonNode)
  {
    if ((paramJsonNode == null) || (!paramJsonNode.isArray())) {
      return null;
    }
    return (ArrayNode)paramJsonNode;
  }
  
  public static JsonFactory d()
  {
    if (b == null) {
      b = new JsonFactory();
    }
    return b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */