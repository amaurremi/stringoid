package com.amazonaws.transform;

import com.amazonaws.http.HttpResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class JsonUnmarshallerContext
{
  private String currentField;
  public JsonToken currentToken;
  private final HttpResponse httpResponse;
  private final JsonParser jsonParser;
  private String lastParsedParentElement;
  private Map<String, String> metadata = new HashMap();
  private List<JsonUnmarshallerContext.MetadataExpression> metadataExpressions = new ArrayList();
  private JsonToken nextToken;
  private final Stack<JsonUnmarshallerContext.JsonFieldTokenPair> stack = new Stack();
  
  public JsonUnmarshallerContext(JsonParser paramJsonParser, HttpResponse paramHttpResponse)
  {
    this.jsonParser = paramJsonParser;
    this.httpResponse = paramHttpResponse;
  }
  
  private void updateContext()
  {
    int j = 1;
    this.lastParsedParentElement = null;
    if (this.currentToken == null) {}
    label192:
    label197:
    do
    {
      do
      {
        return;
        if ((this.currentToken != JsonToken.START_OBJECT) && (this.currentToken != JsonToken.START_ARRAY)) {
          break;
        }
      } while (this.currentField == null);
      this.stack.push(new JsonUnmarshallerContext.JsonFieldTokenPair(this.currentField, this.currentToken));
      this.currentField = null;
      return;
      if ((this.currentToken == JsonToken.END_OBJECT) || (this.currentToken == JsonToken.END_ARRAY))
      {
        int i;
        if (!this.stack.isEmpty())
        {
          if ((this.currentToken != JsonToken.END_ARRAY) || (((JsonUnmarshallerContext.JsonFieldTokenPair)this.stack.peek()).getToken() != JsonToken.START_ARRAY)) {
            break label192;
          }
          i = 1;
          if ((this.currentToken != JsonToken.END_OBJECT) || (((JsonUnmarshallerContext.JsonFieldTokenPair)this.stack.peek()).getToken() != JsonToken.START_OBJECT)) {
            break label197;
          }
        }
        for (;;)
        {
          if ((i != 0) || (j != 0)) {
            this.lastParsedParentElement = ((JsonUnmarshallerContext.JsonFieldTokenPair)this.stack.pop()).getField();
          }
          this.currentField = null;
          return;
          i = 0;
          break;
          j = 0;
        }
      }
    } while (this.currentToken != JsonToken.FIELD_NAME);
    this.currentField = this.jsonParser.getText();
  }
  
  public int getCurrentDepth()
  {
    int j = this.stack.size();
    int i = j;
    if (this.currentField != null) {
      i = j + 1;
    }
    return i;
  }
  
  public String getCurrentParentElement()
  {
    if (this.currentField != null) {
      return this.currentField;
    }
    if (!this.stack.isEmpty()) {
      return ((JsonUnmarshallerContext.JsonFieldTokenPair)this.stack.peek()).getField();
    }
    return "";
  }
  
  public String getLastParsedParentElement()
  {
    return this.lastParsedParentElement;
  }
  
  public Map<String, String> getMetadata()
  {
    return this.metadata;
  }
  
  public JsonToken nextToken()
  {
    if (this.nextToken != null) {}
    for (JsonToken localJsonToken = this.nextToken;; localJsonToken = this.jsonParser.nextToken())
    {
      this.currentToken = localJsonToken;
      this.nextToken = null;
      updateContext();
      return localJsonToken;
    }
  }
  
  public String readText()
  {
    switch (1.$SwitchMap$com$fasterxml$jackson$core$JsonToken[this.currentToken.ordinal()])
    {
    default: 
      throw new RuntimeException("We expected a VALUE token but got: " + this.currentToken);
    case 1: 
      return this.jsonParser.getText();
    case 2: 
      return "false";
    case 3: 
      return "true";
    case 4: 
      return null;
    case 5: 
    case 6: 
      return this.jsonParser.getNumberValue().toString();
    }
    return this.jsonParser.getText();
  }
  
  public boolean testExpression(String paramString)
  {
    if (paramString.equals(".")) {
      return true;
    }
    if (this.currentField != null) {
      return this.currentField.equals(paramString);
    }
    if ((!this.stack.isEmpty()) && (((JsonUnmarshallerContext.JsonFieldTokenPair)this.stack.peek()).getField().equals(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean testExpression(String paramString, int paramInt)
  {
    if (paramString.equals(".")) {}
    while ((testExpression(paramString)) && (paramInt == getCurrentDepth())) {
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.stack.iterator();
    while (localIterator.hasNext())
    {
      JsonUnmarshallerContext.JsonFieldTokenPair localJsonFieldTokenPair = (JsonUnmarshallerContext.JsonFieldTokenPair)localIterator.next();
      localStringBuilder.append("/").append(localJsonFieldTokenPair.getField());
    }
    if (this.currentField != null) {
      localStringBuilder.append("/").append(this.currentField);
    }
    if (localStringBuilder.length() == 0) {
      return "/";
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/transform/JsonUnmarshallerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */