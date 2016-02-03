package com.flurry.org.codehaus.jackson.map;

public class RuntimeJsonMappingException
  extends RuntimeException
{
  public RuntimeJsonMappingException(JsonMappingException paramJsonMappingException)
  {
    super(paramJsonMappingException);
  }
  
  public RuntimeJsonMappingException(String paramString)
  {
    super(paramString);
  }
  
  public RuntimeJsonMappingException(String paramString, JsonMappingException paramJsonMappingException)
  {
    super(paramString, paramJsonMappingException);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/RuntimeJsonMappingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */