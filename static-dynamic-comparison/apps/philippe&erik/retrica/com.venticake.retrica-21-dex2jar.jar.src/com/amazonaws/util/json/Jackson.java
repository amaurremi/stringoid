package com.amazonaws.util.json;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public enum Jackson
{
  private static final ObjectMapper objectMapper = new ObjectMapper();
  private static final ObjectWriter prettyWriter = objectMapper.writerWithDefaultPrettyPrinter();
  private static final ObjectWriter writer;
  
  static
  {
    objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    writer = objectMapper.writer();
  }
  
  public static ObjectMapper getObjectMapper()
  {
    return objectMapper;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/json/Jackson.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */