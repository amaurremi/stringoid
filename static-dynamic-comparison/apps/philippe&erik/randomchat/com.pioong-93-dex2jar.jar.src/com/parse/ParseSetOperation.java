package com.parse;

class ParseSetOperation
  implements ParseFieldOperation
{
  private Object value;
  
  public ParseSetOperation(Object paramObject)
  {
    this.value = paramObject;
  }
  
  public Object apply(Object paramObject, ParseObject paramParseObject, String paramString)
  {
    return this.value;
  }
  
  public Object encode()
  {
    return Parse.maybeEncodeJSONObject(this.value, true);
  }
  
  public Object getValue()
  {
    return this.value;
  }
  
  public ParseFieldOperation mergeWithPrevious(ParseFieldOperation paramParseFieldOperation)
  {
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseSetOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */