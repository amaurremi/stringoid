package com.amazonaws.transform;

public class SimpleTypeJsonUnmarshallers$StringJsonUnmarshaller
  implements Unmarshaller<String, JsonUnmarshallerContext>
{
  private static StringJsonUnmarshaller instance;
  
  public static StringJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new StringJsonUnmarshaller();
    }
    return instance;
  }
  
  public String unmarshall(JsonUnmarshallerContext paramJsonUnmarshallerContext)
  {
    return paramJsonUnmarshallerContext.readText();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/transform/SimpleTypeJsonUnmarshallers$StringJsonUnmarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */