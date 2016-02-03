package com.parse;

import org.json.JSONException;

abstract interface ParseFieldOperation
{
  public abstract Object apply(Object paramObject, ParseObject paramParseObject, String paramString);
  
  public abstract Object encode()
    throws JSONException;
  
  public abstract ParseFieldOperation mergeWithPrevious(ParseFieldOperation paramParseFieldOperation);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseFieldOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */