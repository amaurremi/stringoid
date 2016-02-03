package org.codehaus.jackson.map;

public class RuntimeJsonMappingException
  extends RuntimeException
{
  public RuntimeJsonMappingException(String paramString)
  {
    super(paramString);
  }
  
  public RuntimeJsonMappingException(String paramString, JsonMappingException paramJsonMappingException)
  {
    super(paramString, paramJsonMappingException);
  }
  
  public RuntimeJsonMappingException(JsonMappingException paramJsonMappingException)
  {
    super(paramJsonMappingException);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/RuntimeJsonMappingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */