package com.amazonaws.transform;

import com.fasterxml.jackson.core.JsonToken;

class JsonUnmarshallerContext$JsonFieldTokenPair
{
  private final String field;
  private final JsonToken jsonToken;
  
  public JsonUnmarshallerContext$JsonFieldTokenPair(String paramString, JsonToken paramJsonToken)
  {
    this.field = paramString;
    this.jsonToken = paramJsonToken;
  }
  
  public String getField()
  {
    return this.field;
  }
  
  public JsonToken getToken()
  {
    return this.jsonToken;
  }
  
  public String toString()
  {
    return this.field + ": " + this.jsonToken.asString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/transform/JsonUnmarshallerContext$JsonFieldTokenPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */